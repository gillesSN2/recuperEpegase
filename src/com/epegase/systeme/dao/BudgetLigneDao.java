package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Budget;
import com.epegase.systeme.classe.BudgetLigne;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class BudgetLigneDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BudgetLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BudgetLigne insert(BudgetLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BudgetLigne modif(BudgetLigne var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(BudgetLigne var1, Session var2) {
      var2.delete(var1);
   }

   public void delete(List var1, Session var2) {
      if (var1.size() != 0) {
         new BudgetLigne();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            BudgetLigne var3 = (BudgetLigne)var1.get(var4);
            var2.delete(var3);
         }
      }

   }

   public List chargerLigneBudget(Budget var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BudgetLigne where budget=:bud order by budligActivite").setLong("bud", var1.getBud_id());
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLigneBudget(BudgetLigne var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BudgetLigne where budlig_id=:bud").setLong("bud", var1.getBudlig_id());
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public BudgetLigne recupererLigneBudget(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BudgetLigne where budlig_id=:bud").setLong("bud", var1);
      List var6 = var5.list();
      BudgetLigne var7 = null;
      if (var6.size() != 0) {
         var7 = (BudgetLigne)var6.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLigneBudget(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BudgetLigne where budget.exercicescomptable=:exo order by budligCode").setParameter("exo", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLigneBudget(ExercicesComptable var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BudgetLigne where budget.budAnnee=:an order by budligCode").setString("an", var2);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLigneBudget(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BudgetLigne where budligCode=:bud order by budligActivite").setString("bud", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLigneBudgetByIdBudget(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BudgetLigne where budget.bud_id in (" + var1 + ") order by budligAnal1,budligCode");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvts(List var1, String var2, Session var3) {
      String var4 = "";
      String var5;
      if (var1.size() != 0) {
         var5 = "";

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            if (var6 + 1 == var1.size()) {
               var5 = var5 + "'" + ((String)var1.get(var6)).toString() + "'";
            } else {
               var5 = var5 + "'" + ((String)var1.get(var6)).toString() + "',";
            }
         }

         var4 = "(" + var5 + ")";
      }

      var5 = null;
      List var7;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var3.createQuery("from BudgetLigne where budligCode IN " + var4 + " and budget.budAnnee=:an").setString("an", var2).list();
      } else {
         var7 = var3.createQuery("from BudgetLigne where budget.budAnnee=:an").setString("an", var2).list();
      }

      return var7;
   }

   public List chargerLesMvts(List var1, String var2, boolean var3, List var4, List var5, List var6, List var7, List var8, List var9, List var10, List var11, List var12, List var13, List var14, List var15, List var16, List var17, List var18, List var19, Session var20) throws HibernateException, NamingException {
      boolean var21 = false;
      if (var20 == null) {
         var20 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var21 = true;
      }

      new ArrayList();
      ArrayList var23 = new ArrayList();
      Criteria var24 = var20.createCriteria(BudgetLigne.class);
      if (var1.size() != 0) {
         var24 = var24.add(Restrictions.in("budligCode", var1));
      }

      if (!var3) {
         if (var4.size() != 0) {
            var24 = var24.add(Restrictions.in("budligActivite", var4));
         }
      } else {
         if (var5.size() != 0) {
            var24 = var24.add(Restrictions.in("budligActivite", var5));
         }

         if (var6.size() != 0) {
            var24 = var24.add(Restrictions.in("budligAnal1", var6));
         }

         if (var7.size() != 0) {
            var24 = var24.add(Restrictions.in("budligAnal3", var7));
         }
      }

      if (var8.size() != 0) {
         var24 = var24.add(Restrictions.in("budligSite", var8));
      }

      if (var9.size() != 0) {
         var24 = var24.add(Restrictions.in("budligDepartement", var9));
      }

      if (var10.size() != 0) {
         var24 = var24.add(Restrictions.in("budligService", var10));
      }

      if (var11.size() != 0) {
         var24 = var24.add(Restrictions.in("budligRegion", var11));
      }

      if (var12.size() != 0) {
         var24 = var24.add(Restrictions.in("budligSecteur", var12));
      }

      if (var13.size() != 0) {
         var24 = var24.add(Restrictions.in("budligPdv", var13));
      }

      List var25 = var24.list();
      List var22 = var25;
      if (var25.size() != 0) {
         for(int var26 = 0; var26 < var22.size(); ++var26) {
            if (((BudgetLigne)var22.get(var26)).getBudget().getBudAnnee().equals(var2)) {
               var23.add(var22.get(var26));
            }
         }
      }

      if (var21) {
         this.utilInitHibernate.closeSession();
      }

      return var23;
   }

   public void nettoyageAnalytiqueByEcriture(List var1, Session var2) {
      if (var1.size() != 0) {
         new BudgetLigne();

         for(int var4 = 0; var4 < var1.size(); ++var4) {
            BudgetLigne var3 = (BudgetLigne)var1.get(var4);
            var2.delete(var3);
         }
      }

   }
}
