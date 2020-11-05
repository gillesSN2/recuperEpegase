package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FilieresEducation;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FilieresEducationDao implements Serializable {
   private FilieresEducation filieresEducation;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FilieresEducationDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FilieresEducation insert(FilieresEducation var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
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

   public FilieresEducation insert(FilieresEducation var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FilieresEducation modif(FilieresEducation var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
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

   public FilieresEducation modif(FilieresEducation var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(FilieresEducation var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
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

   public void delete(FilieresEducation var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectFilieres(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from FilieresEducation order by filCode");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectFilieresActives(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from FilieresEducation where filEtat=0 order by filCode");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public boolean existeCode(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FilieresEducation where filCode='" + var1 + "'");
      boolean var5 = false;
      if (var4.list() != null) {
         var5 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List mesFilieresItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from FilieresEducation order by filCode");
      new ArrayList();
      ArrayList var5 = new ArrayList();
      if (var3.list() != null) {
         List var4 = var3.list();
         if (var4.size() != 0) {
            for(int var6 = 0; var6 < var4.size(); ++var6) {
               var5.add(new SelectItem(((FilieresEducation)var4.get(var6)).getFilId(), ((FilieresEducation)var4.get(var6)).getFilCode() + ":" + ((FilieresEducation)var4.get(var6)).getFilLibelle()));
            }
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FilieresEducation pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from FilieresEducation where filId=" + var1).setMaxResults(1);
      if (var6.list() != null) {
         List var5 = var6.list();
         if (var5.size() != 0) {
            this.filieresEducation = (FilieresEducation)var5.get(0);
         } else {
            this.filieresEducation = null;
         }
      } else {
         this.filieresEducation = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.filieresEducation;
   }
}
