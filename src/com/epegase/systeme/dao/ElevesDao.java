package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ElevesInscription;
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

public class ElevesDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ElevesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Eleves insert(Eleves var1) throws HibernateException, NamingException {
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

   public Eleves insert(Eleves var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Eleves modif(Eleves var1) throws HibernateException, NamingException {
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

   public Eleves modif(Eleves var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(Eleves var1) throws HibernateException, NamingException {
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

   public Eleves getElevesById(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
      Eleves var4 = (Eleves)var3.get(Eleves.class, var1);
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public Eleves getElevesByCompte(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var3 = true;
      }

      new Eleves();
      new ArrayList();
      Query var6 = var2.createQuery("from Eleves where eleCompte=:cpt").setString("cpt", var1);
      List var5 = var6.list();
      Eleves var4;
      if (var5.size() != 0) {
         var4 = (Eleves)var5.get(0);
      } else {
         var4 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerListEleves(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var5 = true;
      }

      Object var6 = new ArrayList();
      new ArrayList();
      if (var2 != 0L) {
         List var7 = var4.createQuery(var1).list();
         if (var7.size() != 0) {
            for(int var8 = 0; var8 < var7.size(); ++var8) {
               ((List)var6).add(((ElevesInscription)var7.get(var8)).getEleves());
            }
         }
      } else {
         var6 = var4.createQuery(var1).list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerlesEleves(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      if (var1.equals("*")) {
         var5 = "from Eleves order by eleNom asc";
      } else if (var1.contains("*") && var1.length() >= 2) {
         String var6 = var1.substring(1);
         var5 = "from Eleves where (eleNom LIKE '%" + var6 + "%') or (elePrenom LIKE '%" + var6 + "%') order by eleNom asc";
      } else {
         var5 = "from Eleves where (eleNom LIKE '%" + var1 + "%') order by eleNom asc";
      }

      Query var7 = var2.createQuery(var5);
      List var4 = var7.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List findEleves(String var1, String var2, Date var3, String var4, int var5) throws HibernateException, NamingException {
      Session var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
      Criteria var7 = var6.createCriteria(Eleves.class);
      if (var5 != 0) {
         var7 = var7.add(Restrictions.like("eleId", var5));
      }

      if (!"".equals(var1)) {
         var7 = var7.add(Restrictions.like("eleNom", var1 + "%"));
      }

      if (!"".equals(var2)) {
         var7 = var7.add(Restrictions.like("elePrenom", var2 + "%"));
      }

      if (var3 != null) {
         var7 = var7.add(Restrictions.like("eleDateNaissance", var3));
      }

      if (!"".equals(var4)) {
         var7 = var7.add(Restrictions.like("eleCi", var4 + "%"));
      }

      List var8 = var7.list();
      var6.flush();
      this.utilInitHibernate.closeSession();
      return var8;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Eleves order by eleId desc");
      long var4 = 0L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            Eleves var7 = (Eleves)var6.get(0);
            var7.getEleId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public Eleves eleveBySerieAnneeDate(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var4 = true;
      }

      int var5 = 1900 + var2.getYear();
      Query var6 = var3.createQuery("from Eleves where and eleSerie =:ser and year(eleDateCreat)=" + var5 + " order by eleDateCreat desc");
      var6.setParameter("ser", var1);
      Eleves var7 = null;
      if (var6.list() != null) {
         var6.setMaxResults(1);
         List var8 = var6.list();
         if (var8.size() > 0) {
            var7 = (Eleves)var8.get(0);
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Eleves eleveBySerieMoisDate(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var4 = true;
      }

      int var5 = 1900 + var2.getYear();
      int var6 = var2.getMonth();
      Query var7 = var3.createQuery("from Eleves where eleSerie =:ser and year(eleDateCreat)=" + var5 + " and month(eleDateCreat)=" + var6 + " order by eleDateCreat desc");
      var7.setParameter("ser", var1);
      Eleves var8 = null;
      if (var7.list() != null) {
         var7.setMaxResults(1);
         List var9 = var7.list();
         if (var9.size() > 0) {
            var8 = (Eleves)var9.get(0);
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public Eleves selectElevesD(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
      List var4 = var3.createQuery("from Eleves where ele_id=" + var1).list();
      this.utilInitHibernate.closeSession();
      if (var4.size() > 0) {
         Eleves var5 = (Eleves)var4.get(0);
         return var5;
      } else {
         return null;
      }
   }

   public Eleves selectElevesD(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var4 = true;
      }

      List var5 = var3.createQuery("from Eleves where ele_id=" + var1).list();
      Eleves var6 = null;
      if (var5.size() > 0) {
         var6 = (Eleves)var5.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifUnicite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var3 = true;
      }

      boolean var4 = false;
      new ArrayList();
      Query var6 = var2.createQuery("from Eleves where eleDossier=:mat").setString("mat", var1).setMaxResults(1);
      List var5 = var6.list();
      if (var5.size() != 0) {
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
