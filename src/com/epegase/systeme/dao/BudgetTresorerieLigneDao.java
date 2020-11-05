package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BudgetTresorerie;
import com.epegase.systeme.classe.BudgetTresorerieLigne;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class BudgetTresorerieLigneDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BudgetTresorerieLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BudgetTresorerieLigne insert(BudgetTresorerieLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BudgetTresorerieLigne modif(BudgetTresorerieLigne var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(BudgetTresorerieLigne var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerLigneBudgetTresorerie(BudgetTresorerie var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BudgetTresorerieLigne where budgetTresorerie=:bud order by budligCode").setParameter("bud", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLigneBudgetTresorerieItems(BudgetTresorerie var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BudgetTresorerieLigne where budgetTresorerie=:bud order by budligCode").setParameter("bud", var1);
      List var5 = var4.list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((BudgetTresorerieLigne)var5.get(var7)).getBudligCode()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
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
         var7 = var3.createQuery("from BudgetTresorerieLigne where budligCode IN " + var4 + " and budgetTresorerie.budAnnee=:an").setString("an", var2).list();
      } else {
         var7 = var3.createQuery("from BudgetTresorerieLigne where budgetTresorerie.budAnnee=:an").setString("an", var2).list();
      }

      return var7;
   }

   public List chargerLesMvts(List var1, String var2, List var3, List var4, List var5, List var6, List var7, List var8, List var9, List var10, List var11, List var12, List var13, List var14, List var15, Session var16) throws HibernateException, NamingException {
      boolean var17 = false;
      if (var16 == null) {
         var16 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var17 = true;
      }

      new ArrayList();
      ArrayList var19 = new ArrayList();
      Criteria var20 = var16.createCriteria(BudgetTresorerieLigne.class);
      if (var1.size() != 0) {
         var20 = var20.add(Restrictions.in("budligCode", var1));
      }

      if (var3.size() != 0) {
         var20 = var20.add(Restrictions.in("budligActivite", var3));
      }

      if (var4.size() != 0) {
         var20 = var20.add(Restrictions.in("budligSite", var4));
      }

      if (var5.size() != 0) {
         var20 = var20.add(Restrictions.in("budligDepartement", var5));
      }

      if (var6.size() != 0) {
         var20 = var20.add(Restrictions.in("budligService", var6));
      }

      if (var7.size() != 0) {
         var20 = var20.add(Restrictions.in("budligRegion", var7));
      }

      if (var8.size() != 0) {
         var20 = var20.add(Restrictions.in("budligSecteur", var8));
      }

      if (var9.size() != 0) {
         var20 = var20.add(Restrictions.in("budligPdv", var9));
      }

      List var21 = var20.list();
      List var18 = var21;
      if (var21.size() != 0) {
         for(int var22 = 0; var22 < var18.size(); ++var22) {
            if (((BudgetTresorerieLigne)var18.get(var22)).getBudgetTresorerie().getBudAnnee().equals(var2)) {
               var19.add(var18.get(var22));
            }
         }
      }

      if (var17) {
         this.utilInitHibernate.closeSession();
      }

      return var19;
   }
}
