package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ForetGrume;
import com.epegase.systeme.classe.ForetInventaire;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ForetGrumeDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ForetGrumeDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ForetGrume insert(ForetGrume var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
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

   public ForetGrume insert(ForetGrume var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ForetGrume modif(ForetGrume var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
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

   public ForetGrume modif(ForetGrume var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(ForetGrume var1, Session var2) {
      var2.delete(var1);
   }

   public void delete(ForetGrume var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
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

   public ForetGrume pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ForetGrume where gruId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new ForetGrume();
      ForetGrume var7;
      if (var6.size() != 0) {
         var7 = (ForetGrume)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ForetGrume rechercheGrum(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ForetGrume where gruNumInv =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new ForetGrume();
      ForetGrume var6;
      if (var5.size() != 0) {
         var6 = (ForetGrume)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ForetGrume rechercheArbre(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var5 = true;
      }

      Query var6 = var4.createQuery("from ForetGrume where gruArbre=:num and gruChantier=:cha and gruEssence=:ess").setString("num", var1).setString("cha", var2).setString("ess", var3).setMaxResults(1);
      List var7 = var6.list();
      new ForetGrume();
      ForetGrume var8;
      if (var7.size() != 0) {
         var8 = (ForetGrume)var7.get(0);
      } else {
         var8 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesLignesInventaires(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ForetGrume where foretInventaire.forinvNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheGRumeRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ForetGrume where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByInventaire(ForetInventaire var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ForetEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ForetGrume where foretInventaire=:entete").setParameter("entete", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
