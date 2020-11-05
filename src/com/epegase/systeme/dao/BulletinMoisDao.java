package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BulletinMois;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BulletinMoisDao implements Serializable {
   private BulletinMois bulletinMois;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public BulletinMoisDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void ajoutPeriode(FeuilleCalcul var1, int var2, ExercicesPaye var3, List var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      Query var7 = var5.createQuery("from BulletinMois where ExercicesPaye=:exo and bulmenFeuille=:code and bulmenModeTravail=:mode").setLong("exo", var3.getExepayId()).setString("code", var1.getFeuCode()).setInteger("mode", var2);
      int var8 = var7.list().size();
      if (var8 == 0) {
         for(int var9 = 0; var9 < var4.size(); ++var9) {
            String var10 = (String)var4.get(var9);
            this.bulletinMois = new BulletinMois();
            this.bulletinMois.setBulmenPeriode(var10);
            this.bulletinMois.setBulmenJour((Date)null);
            this.bulletinMois.setExercicesPaye(var3);
            this.bulletinMois.setBulmenCle1(var1.getFeuCode() + ":" + var10);
            this.bulletinMois.setBulmenFeuille(var1.getFeuCode());
            this.bulletinMois.setBulmenEtat(0);
            this.bulletinMois.setBulmenModeTravail(var2);
            var5.save(this.bulletinMois);
         }
      } else if (var8 != var4.size()) {
         for(int var12 = var8; var12 < var4.size(); ++var12) {
            String var11 = (String)var4.get(var12);
            this.bulletinMois = new BulletinMois();
            this.bulletinMois.setBulmenPeriode(var11);
            this.bulletinMois.setBulmenJour((Date)null);
            this.bulletinMois.setExercicesPaye(var3);
            this.bulletinMois.setBulmenCle1(var1.getFeuCode() + ":" + var11);
            this.bulletinMois.setBulmenFeuille(var1.getFeuCode());
            this.bulletinMois.setBulmenEtat(0);
            this.bulletinMois.setBulmenModeTravail(var2);
            var5.save(this.bulletinMois);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

   }

   public void ajoutPeriodeJour(FeuilleCalcul var1, int var2, ExercicesPaye var3, List var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var6 = true;
      }

      Query var7 = var5.createQuery("from BulletinMois  where  ExercicesPaye=:exo and bulmenFeuille=:code ").setLong("exo", var3.getExepayId()).setString("code", var1.getFeuCode());
      int var8 = var7.list().size();
      String var12;
      String var13;
      if (var8 == 0) {
         for(int var9 = 0; var9 < var4.size(); ++var9) {
            Date var10 = (Date)var4.get(var9);
            this.bulletinMois = new BulletinMois();
            this.bulletinMois.setBulmenJour(var10);
            this.bulletinMois.setBulmenPeriode((String)null);
            this.bulletinMois.setExercicesPaye(var3);
            String var11 = "";
            if (var10.getDate() <= 9) {
               var11 = "0" + var10.getDate();
            } else {
               var11 = "" + var10.getDate();
            }

            var12 = "";
            if (var10.getMonth() + 1 <= 9) {
               var12 = "0" + (var10.getMonth() + 1);
            } else {
               var12 = "" + (var10.getMonth() + 1);
            }

            var13 = "" + (var10.getYear() + 1900);
            this.bulletinMois.setBulmenCle1(var1.getFeuCode() + ":" + var11 + ":" + var12 + ":" + var13);
            this.bulletinMois.setBulmenFeuille(var1.getFeuCode());
            this.bulletinMois.setBulmenEtat(0);
            this.bulletinMois.setBulmenModeTravail(var2);
            var5.save(this.bulletinMois);
         }
      } else if (var8 != var4.size()) {
         for(int var15 = var8; var15 < var4.size(); ++var15) {
            Date var16 = (Date)var4.get(var15);
            this.bulletinMois = new BulletinMois();
            this.bulletinMois.setBulmenJour(var16);
            this.bulletinMois.setBulmenPeriode((String)null);
            this.bulletinMois.setExercicesPaye(var3);
            var12 = "";
            if (var16.getDate() <= 9) {
               var12 = "0" + var16.getDate();
            } else {
               var12 = "" + var16.getDate();
            }

            var13 = "";
            if (var16.getMonth() + 1 <= 9) {
               var13 = "0" + (var16.getMonth() + 1);
            } else {
               var13 = "" + (var16.getMonth() + 1);
            }

            String var14 = "" + (var16.getYear() + 1900);
            this.bulletinMois.setBulmenCle1(var1.getFeuCode() + ":" + var12 + ":" + var13 + ":" + var14);
            this.bulletinMois.setBulmenFeuille(var1.getFeuCode());
            this.bulletinMois.setBulmenEtat(0);
            this.bulletinMois.setBulmenModeTravail(var2);
            var5.save(this.bulletinMois);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

   }

   public BulletinMois majJournal(BulletinMois var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public BulletinMois majJournal(BulletinMois var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List mesFeuillesmois(String var1, int var2, ExercicesPaye var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "SelectionFeuille");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var2 != 9) {
         var7 = var4.createQuery(" from BulletinMois where bulmenFeuille=:code and bulmenModeTravail=:mode and ExercicesPaye=:exo").setString("code", var1).setInteger("mode", var2).setLong("exo", var3.getExepayId());
      } else {
         var7 = var4.createQuery(" from BulletinMois where bulmenFeuille=:code and ExercicesPaye=:exo").setString("code", var1).setLong("exo", var3.getExepayId());
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List mesFeuillesmois(int var1, ExercicesPaye var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery(" from BulletinMois where bulmenModeTravail=:mode and ExercicesPaye=:exo").setInteger("mode", var1).setLong("exo", var2.getExepayId());
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public BulletinMois recupererBulletinMois(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from BulletinMois where bulmenPeriode=:per").setString("per", var1).setMaxResults(1);
      List var5 = var4.list();
      new BulletinMois();
      BulletinMois var6;
      if (var5.size() > 0) {
         var6 = (BulletinMois)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public BulletinMois recupererBulletinMoisFeuille(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery(" from BulletinMois where bulmenPeriode=:per and bulmenFeuille=:code").setString("per", var1).setString("code", var2).setMaxResults(1);
      List var6 = var5.list();
      new BulletinMois();
      BulletinMois var7;
      if (var6.size() > 0) {
         var7 = (BulletinMois)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List listeJouMemCloture(ExercicesPaye var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from BulletinMois where ExercicesPaye=:exo order by bulmenFeuille, bulmenPeriode").setLong("exo", var1.getExepayId());
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List mesFeuillesJours(String var1, int var2, ExercicesPaye var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "SelectionFeuille");
         var5 = true;
      }

      new ArrayList();
      Query var7 = var4.createQuery(" from BulletinMois where bulmenFeuille=:code and bulmenModeTravail=:mode and ExercicesPaye=:exo").setString("code", var1).setInteger("mode", var2).setLong("exo", var3.getExepayId());
      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
