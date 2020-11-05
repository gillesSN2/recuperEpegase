package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Budget;
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

public class BudgetDao implements Serializable {
   private Budget budget;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BudgetDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Budget insert(Budget var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
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

   public Budget insert(Budget var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Budget modif(Budget var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
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

   public Budget modif(Budget var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(Budget var1, Session var2) {
      var2.delete(var1);
   }

   public List selectAllBudget(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var4 = true;
      }

      Query var5 = var3.createQuery("FROM Budget where exercicescomptable=:exo").setLong("exo", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((Budget)var6.get(var8)).getBudCode() + ":" + ((Budget)var6.get(var8)).getBudLibelleFr()));
         }
      }

      return var7;
   }

   public List chargerLesBudgets(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var5 = true;
      }

      String var6 = "";
      if (var2 != null && !var2.isEmpty()) {
         if (var3 != null && !var3.isEmpty()) {
            var6 = "FROM Budget where budNature='" + var1 + "' and budAnnee='" + var2 + "' and budActivite='" + var3 + "' order by budEntite,budCode";
         } else {
            var6 = "FROM Budget where budNature='" + var1 + "' and budAnnee='" + var2 + "' order by budEntite,budCode";
         }
      } else if (var3 != null && !var3.isEmpty()) {
         var6 = "FROM Budget where budNature='" + var1 + "' and budActivite='" + var3 + "' order by budEntite,budCode";
      } else {
         var6 = "FROM Budget where budNature='" + var1 + "' order by budEntite,budCode";
      }

      Query var7 = var4.createQuery(var6);
      List var8 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesBudgetsEntite(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var5 = true;
      }

      String var6 = "";
      if (var2 != null && !var2.isEmpty()) {
         var6 = "FROM Budget where budNature='" + var1 + "' and budAnnee='" + var2 + "' and budEntite='" + var3 + "' order by budEntite,budCode";
      } else {
         var6 = "FROM Budget where budNature='" + var1 + "' and budEntite='" + var3 + "' order by budEntite,budCode";
      }

      Query var7 = var4.createQuery(var6);
      List var8 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesBudgetsEntitesTitre(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var5 = true;
      }

      String var6 = "";
      if (var2 != null && !var2.isEmpty()) {
         if (var3 != null && !var3.isEmpty()) {
            var6 = "FROM Budget where budType=15 and budNature='" + var1 + "' and budAnnee='" + var2 + "' and budActivite='" + var3 + "' order by budEntite,budCode";
         } else {
            var6 = "FROM Budget where  budType=15 and budNature='" + var1 + "' and budAnnee='" + var2 + "' order by budEntite,budCode";
         }
      } else if (var3 != null && !var3.isEmpty()) {
         var6 = "FROM Budget where  budType=15 and budNature='" + var1 + "' and budActivite='" + var3 + "' order by budEntite,budCode";
      } else {
         var6 = "FROM Budget where  budType=15 and budNature='" + var1 + "' order by budEntite,budCode";
      }

      Query var7 = var4.createQuery(var6);
      List var8 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesBudgetsEntitesDetail(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var5 = true;
      }

      String var6 = "";
      if (var2 != null && !var2.isEmpty()) {
         if (var3 != null && !var3.isEmpty()) {
            var6 = "FROM Budget where budType=1 and budEntite='" + var1 + "' and budAnnee='" + var2 + "' and budActivite='" + var3 + "' order by budEntite,budCode";
         } else {
            var6 = "FROM Budget where budType=1 and budEntite='" + var1 + "' and budAnnee='" + var2 + "' order by budEntite,budCode";
         }
      } else if (var3 != null && !var3.isEmpty()) {
         var6 = "FROM Budget where budType=1 and budEntite='" + var1 + "' and budActivite='" + var3 + "' order by budEntite,budCode";
      } else {
         var6 = "FROM Budget where budType=1 and budEntite='" + var1 + "' order by budEntite,budCode";
      }

      Query var7 = var4.createQuery(var6);
      List var8 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesBudgets(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var6 = true;
      }

      String var7 = "";
      if (var3 != null && !var3.isEmpty()) {
         if (var1 != null && !var1.isEmpty()) {
            var7 = "FROM Budget where budNature='" + var1 + "' and budAnnee='" + var2 + "' and budActivite='" + var3 + "' and budCode='" + var4 + "'  order by budEntite,budCode";
         } else {
            var7 = "FROM Budget where budAnnee='" + var2 + "' and budActivite='" + var3 + "' and budCode='" + var4 + "'  order by budEntite,budCode";
         }
      } else if (var1 != null && !var1.isEmpty()) {
         var7 = "FROM Budget where budNature='" + var1 + "' and budAnnee='" + var2 + "' and budCode='" + var4 + "'  order by budEntite,budCode";
      } else {
         var7 = "FROM Budget where budAnnee='" + var2 + "' and budCode='" + var4 + "'  order by budEntite,budCode";
      }

      Query var8 = var5.createQuery(var7);
      List var9 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargerLesBudgets(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("FROM Budget where budCode like '" + var1 + "%' order by budEntite,budCode");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesBudgetsProjet(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("FROM Budget where budNature like '" + var1 + "%'  order by budEntite,budCode");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesBudgetsProjetItems(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("FROM Budget where budNature like '" + var1 + "%'");
      List var5 = var4.list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((Budget)var5.get(var7)).getBudCode() + ":" + ((Budget)var5.get(var7)).getBudLibelleFr()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Budget rechercheBudget(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Budget ja where ja.budCode=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new Budget();
      Budget var6;
      if (var5.size() > 0) {
         var6 = (Budget)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Budget rechercheBudget(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Budget ja where ja.budCode=:cod and ja.budAnnee=:an").setString("cod", var1).setString("an", var2).setMaxResults(1);
      List var6 = var5.list();
      new Budget();
      Budget var7;
      if (var6.size() > 0) {
         var7 = (Budget)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Budget rechercheEntite(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Budget ja where ja.budEntite=:cod").setString("cod", var1).setMaxResults(1);
      List var5 = var4.list();
      new Budget();
      Budget var6;
      if (var5.size() > 0) {
         var6 = (Budget)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Budget recupererSelectedECById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Budget where bud_id=:id").setLong("id", var1).setMaxResults(1);
      List var6 = var5.list();
      new Budget();
      Budget var7;
      if (var6.size() > 0) {
         var7 = (Budget)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Budget rechercheBudgetByNature(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var4 = true;
      }

      Query var5 = var3.createQuery("from Budget where budNature=:cod and budAnnee=:an").setString("cod", var1).setString("an", var2).setMaxResults(1);
      List var6 = var5.list();
      new Budget();
      Budget var7;
      if (var6.size() > 0) {
         var7 = (Budget)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Budget rechercheBudgetByNature(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var5 = true;
      }

      Query var6 = var4.createQuery("from Budget where budNature=:nat and budCode=:cod and budAnnee=:an").setString("nat", var1).setString("cod", var2).setString("an", var3).setMaxResults(1);
      List var7 = var6.list();
      new Budget();
      Budget var8;
      if (var7.size() > 0) {
         var8 = (Budget)var7.get(0);
      } else {
         var8 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }
}
