package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FilieresEducation;
import com.epegase.systeme.classe.FilieresMatieres;
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

public class FilieresMatieresDao implements Serializable {
   private FilieresMatieres filieresMatieres;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FilieresMatieresDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FilieresMatieres insert(FilieresMatieres var1) throws HibernateException, NamingException {
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

   public FilieresMatieres insert(FilieresMatieres var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FilieresMatieres modif(FilieresMatieres var1) throws HibernateException, NamingException {
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

   public FilieresMatieres modif(FilieresMatieres var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(FilieresMatieres var1) throws HibernateException, NamingException {
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

   public void delete(FilieresMatieres var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerMatiereByFiliere(FilieresEducation var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FilieresMatieres where filieresEducation=:fil order by filmatCode").setParameter("fil", var1);
      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List mesMatieresByFiliereItems(FilieresEducation var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FilieresMatieres where filieresEducation=:fil order by filmatCode").setParameter("fil", var1);
      new ArrayList();
      ArrayList var6 = new ArrayList();
      if (var4.list() != null) {
         List var5 = var4.list();
         if (var5.size() != 0) {
            for(int var7 = 0; var7 < var5.size(); ++var7) {
               var6.add(new SelectItem(((FilieresMatieres)var5.get(var7)).getFilmatId(), ((FilieresMatieres)var5.get(var7)).getFilmatCode() + ":" + ((FilieresMatieres)var5.get(var7)).getFilmatLibelle()));
            }
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FilieresMatieres pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FilieresEducation");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from FilieresMatieres where filmatId=" + var1).setMaxResults(1);
      if (var6.list() != null) {
         List var5 = var6.list();
         if (var5.size() != 0) {
            this.filieresMatieres = (FilieresMatieres)var5.get(0);
         } else {
            this.filieresMatieres = null;
         }
      } else {
         this.filieresMatieres = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.filieresMatieres;
   }
}
