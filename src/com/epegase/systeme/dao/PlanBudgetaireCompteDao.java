package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlanBudgetaireCompte;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansBudgetaires;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanBudgetaireCompteDao implements Serializable {
   private PlanBudgetaireCompte planBudgetaireCompte;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public PlanBudgetaireCompteDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public PlanBudgetaireCompte insert(PlanBudgetaireCompte var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
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

   public PlanBudgetaireCompte insert(PlanBudgetaireCompte var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public void insertlesPlanBudgetComptes(List var1, PlansBudgetaires var2, int var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            new PlanComptable();
            PlanComptable var7 = (PlanComptable)var1.get(var6);
            if (var7.isVar_select()) {
               PlanBudgetaireCompte var8 = new PlanBudgetaireCompte();
               var8.setPlanbudgetaire(var2);
               var8.setPlbcptCode(var2.getPlbCode());
               var8.setPlbcptNature(var2.getPlbNature());
               var8.setPlbcptChoixBudget(var3);
               var8.setPlbcptType(0);
               var8.setPlbcptCompte(var7.getPlcCompte());
               var8.setPlbcptLibelleFr(var7.getPlcLibelleCpteFR());
               var8.setPlbcptLibelleSp(var7.getPlcLibelleCpteSP());
               var8.setPlbcptLibelleUk(var7.getPlcLibelleCpteUK());
               var4.save(var8);
            }
         }

         var5.commit();
      } catch (HibernateException var12) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var12;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void insertlesPlanBudgetComptes(List var1, PlansBudgetaires var2, int var3, Session var4) {
      for(int var5 = 0; var5 < var1.size(); ++var5) {
         new PlanComptable();
         PlanComptable var6 = (PlanComptable)var1.get(var5);
         if (var6.isVar_select()) {
            PlanBudgetaireCompte var7 = new PlanBudgetaireCompte();
            var7.setPlanbudgetaire(var2);
            var7.setPlbcptCode(var2.getPlbCode());
            var7.setPlbcptNature(var2.getPlbNature());
            var7.setPlbcptChoixBudget(var3);
            var7.setPlbcptType(0);
            var7.setPlbcptCompte(var6.getPlcCompte());
            var7.setPlbcptLibelleFr(var6.getPlcLibelleCpteFR());
            var7.setPlbcptLibelleSp(var6.getPlcLibelleCpteSP());
            var7.setPlbcptLibelleUk(var6.getPlcLibelleCpteUK());
            var4.save(var7);
         }
      }

   }

   public void insertlesPlanBudgetProduits(List var1, PlansBudgetaires var2, int var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
      Transaction var5 = null;

      try {
         var5 = var4.beginTransaction();

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            new Produits();
            Produits var7 = (Produits)var1.get(var6);
            if (var7.isVar_select()) {
               PlanBudgetaireCompte var8 = new PlanBudgetaireCompte();
               var8.setPlanbudgetaire(var2);
               var8.setPlbcptCode(var2.getPlbCode());
               var8.setPlbcptNature(var2.getPlbNature());
               var8.setPlbcptChoixBudget(var3);
               var8.setPlbcptType(1);
               var8.setPlbcptCompte(var7.getProCode());
               var8.setPlbcptLibelleFr(var7.getProLibClient());
               var8.setPlbcptLibelleSp(var7.getProLibClient());
               var8.setPlbcptLibelleUk(var7.getProLibClient());
               var4.save(var8);
            }
         }

         var5.commit();
      } catch (HibernateException var12) {
         if (var5 != null) {
            var5.rollback();
         }

         throw var12;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void insertlesPlanBudgetProduits(List var1, PlansBudgetaires var2, int var3, Session var4) {
      for(int var5 = 0; var5 < var1.size(); ++var5) {
         new Produits();
         Produits var6 = (Produits)var1.get(var5);
         if (var6.isVar_select()) {
            PlanBudgetaireCompte var7 = new PlanBudgetaireCompte();
            var7.setPlanbudgetaire(var2);
            var7.setPlbcptCode(var2.getPlbCode());
            var7.setPlbcptNature(var2.getPlbNature());
            var7.setPlbcptChoixBudget(var3);
            var7.setPlbcptType(1);
            var7.setPlbcptCompte(var6.getProCode());
            var7.setPlbcptLibelleFr(var6.getProLibClient());
            var7.setPlbcptLibelleSp(var6.getProLibClient());
            var7.setPlbcptLibelleUk(var6.getProLibClient());
            var4.save(var7);
         }
      }

   }

   public void deletelesPlanBudgetComptes(List var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            new PlanBudgetaireCompte();
            PlanBudgetaireCompte var5 = (PlanBudgetaireCompte)var1.get(var4);
            var2.delete(var5);
         }

         var3.commit();
      } catch (HibernateException var9) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var9;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public void delete(PlanBudgetaireCompte var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
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

   public void delete(PlanBudgetaireCompte var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerLesPlansBudgetaireCompte(long var1, int var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var6 = true;
      }

      Query var7 = var5.createQuery("FROM PlanBudgetaireCompte WHERE plb_id=" + var1 + " and plbcptType=" + var3 + " and plbcptChoixBudget=" + var4);
      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesComptesAnnee(String var1, int var2, int var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var6 = true;
      }

      Query var7 = var5.createQuery("FROM PlanBudgetaireCompte WHERE planbudgetaire.plbAnnee='" + var1 + "' and planbudgetaire.plbNature=" + var3 + " and plbcptType=" + var2 + " and plbcptChoixBudget=" + var4);
      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesComptesAnnee(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var4 = true;
      }

      Query var5 = var3.createQuery("FROM PlanBudgetaireCompte WHERE planbudgetaire.plbAnnee='" + var1 + "' and plbcptChoixBudget=" + var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesComptesCode(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var4 = true;
      }

      Query var5 = var3.createQuery("FROM PlanBudgetaireCompte WHERE plbcptCode='" + var1 + "' and plbcptChoixBudget=" + var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesComptesCode(String var1, String var2, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var5 = true;
      }

      Query var6 = var4.createQuery("FROM PlanBudgetaireCompte WHERE plbcptCode='" + var2 + "' and planbudgetaire.plbAnnee='" + var1 + "' and plbcptChoixBudget=" + var3);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesComptesAnnee(ExercicesComptable var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var4 = true;
      }

      Query var5 = var3.createQuery("FROM PlanBudgetaireCompte WHERE planbudgetaire.exercicesComptable=:exo and plbcptChoixBudget=:choix").setParameter("exo", var1).setInteger("choix", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
