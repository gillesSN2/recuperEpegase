package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class PatientsDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PatientsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Patients insert(Patients var1) throws HibernateException, NamingException {
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

   public Patients insert(Patients var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Patients modif(Patients var1) throws HibernateException, NamingException {
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

   public Patients modif(Patients var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(Patients var1) throws HibernateException, NamingException {
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

   public Patients delete(Patients var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
      return var1;
   }

   public Patients getPatientsById(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      Patients var4 = (Patients)var3.get(Patients.class, var1);
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

   public List chargerListPatientsLight(String var1, Session var2) throws HibernateException, NamingException {
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

   public List chargerlesPatients(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      if (var1.equals("*")) {
         var5 = "from Patients order by patNom asc";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var5 = "from Patients where (patNom LIKE '%" + var6 + "%') or (patPrenom LIKE '%" + var6 + "%') order by patNom asc";
      } else {
         var5 = "from Patients where (patNom LIKE '%" + var1 + "%') order by patNom asc";
      }

      Query var7 = var2.createQuery(var5);
      List var4 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesPatients(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var5 = true;
      }

      new ArrayList();
      String var7 = "patId <> " + var2 + " and ";
      if (var1.equals("*")) {
         var7 = "from Patients order by patNom asc";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var8 = var1.substring(1);
         var7 = "from Patients where (patNom LIKE '%" + var8 + "%') or (patPrenom LIKE '%" + var8 + "%') order by patNom asc";
      } else {
         var7 = "from Patients where (patNom LIKE '%" + var1 + "%') order by patNom asc";
      }

      Query var9 = var4.createQuery(var7);
      List var6 = var9.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerlesPatients(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      new ArrayList();
      String var6 = "from Patients where patIdCouvertPar =" + var1 + " order by patNom asc";
      Query var7 = var3.createQuery(var6);
      List var5 = var7.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List findPatients(String var1, String var2, Date var3, String var4, int var5) throws HibernateException, NamingException {
      Session var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      Criteria var7 = var6.createCriteria(Patients.class);
      if (var5 != 0) {
         var7 = var7.add(Restrictions.like("patId", var5));
      }

      if (!"".equals(var1)) {
         var7 = var7.add(Restrictions.like("patNom", var1 + "%"));
      }

      if (!"".equals(var2)) {
         var7 = var7.add(Restrictions.like("patPrenom", var2 + "%"));
      }

      if (var3 != null) {
         var7 = var7.add(Restrictions.like("patDateNaissance", var3));
      }

      if (!"".equals(var4)) {
         var7 = var7.add(Restrictions.like("patCi", var4 + "%"));
      }

      List var8 = var7.list();
      var6.flush();
      this.utilInitHibernate.closeSession();
      return var8;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Patients order by patId desc");
      long var4 = 0L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            Patients var7 = (Patients)var6.get(0);
            var7.getPatId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public Patients patientBySerieAnneeDate(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      int var5 = 1900 + var2.getYear();
      Query var6 = var3.createQuery("from Patients where patSerie =:ser and year(patDateCreat)=" + var5 + " order by patDateCreat desc");
      var6.setParameter("ser", var1);
      Patients var7 = null;
      if (var6.list() != null) {
         var6.setMaxResults(1);
         List var8 = var6.list();
         if (var8.size() > 0) {
            var7 = (Patients)var8.get(0);
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Patients patientBySerieMoisDate(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      int var5 = 1900 + var2.getYear();
      int var6 = var2.getMonth();
      Query var7 = var3.createQuery("from Patients where patSerie =:ser and year(patDateCreat)=" + var5 + " and month(patDateCreat)=" + var6 + " order by patDateCreat desc");
      var7.setParameter("ser", var1);
      Patients var8 = null;
      if (var7.list() != null) {
         var7.setMaxResults(1);
         List var9 = var7.list();
         if (var9.size() > 0) {
            var8 = (Patients)var9.get(0);
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public Patients selectPatientsD(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
      List var4 = var3.createQuery("from Patients where pat_id=" + var1).list();
      this.utilInitHibernate.closeSession();
      if (var4.size() > 0) {
         Patients var5 = (Patients)var4.get(0);
         return var5;
      } else {
         return null;
      }
   }

   public Patients selectPatientsD(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var4 = true;
      }

      List var5 = var3.createQuery("from Patients where pat_id=" + var1).list();
      Patients var6 = null;
      if (var5.size() > 0) {
         var6 = (Patients)var5.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Patients selectPatientsM(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var3 = true;
      }

      List var4 = var2.createQuery("from Patients where pat_dossier='" + var1 + "'").list();
      Patients var5 = null;
      if (var4.size() > 0) {
         var5 = (Patients)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Patients selectPatientDivers(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Patients");
         var2 = true;
      }

      List var3 = var1.createQuery("from Patients where pat_nom='DIVERS' and pat_prenom='Divers'").setMaxResults(1).list();
      Patients var4 = null;
      if (var3.size() > 0) {
         var4 = (Patients)var3.get(0);
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
