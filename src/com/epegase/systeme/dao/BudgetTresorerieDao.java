package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BudgetTresorerie;
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

public class BudgetTresorerieDao implements Serializable {
   private BudgetTresorerie budgetTresorerie;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BudgetTresorerieDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BudgetTresorerie insert(BudgetTresorerie var1) throws HibernateException, NamingException {
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

   public BudgetTresorerie insert(BudgetTresorerie var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BudgetTresorerie modif(BudgetTresorerie var1) throws HibernateException, NamingException {
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

   public BudgetTresorerie modif(BudgetTresorerie var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(BudgetTresorerie var1, Session var2) {
      var2.delete(var1);
   }

   public List selectAllBudgetTresorerie(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var4 = true;
      }

      Query var5 = var3.createQuery("FROM BudgetTresorerie where exercicescomptable=:exo").setLong("exo", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((BudgetTresorerie)var6.get(var8)).getBudCode() + ":" + ((BudgetTresorerie)var6.get(var8)).getBudLibelleFr()));
         }
      }

      return var7;
   }

   public List chargerLesBudgetTresoreries(String var1, String var2, String var3, boolean var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var6 = true;
      }

      String var7 = "";
      String var8 = "";
      if (!var4) {
         var8 = " and budSens<=2";
      }

      if (var3 != null && !var3.isEmpty()) {
         if (var1 != null && !var1.isEmpty()) {
            var7 = "FROM BudgetTresorerie where budProjet='" + var1 + "' and budAnnee='" + var2 + "' and budActivite='" + var3 + "'" + var8;
         } else {
            var7 = "FROM BudgetTresorerie where budAnnee='" + var2 + "' and budActivite='" + var3 + "'" + var8;
         }
      } else if (var2 != null && !var2.isEmpty()) {
         if (var1 != null && !var1.isEmpty()) {
            var7 = "FROM BudgetTresorerie where budProjet='" + var1 + "' and budAnnee='" + var2 + "'" + var8;
         } else {
            var7 = "FROM BudgetTresorerie where budAnnee='" + var2 + "'" + var8;
         }
      } else if (var1 != null && !var1.isEmpty()) {
         var7 = "FROM BudgetTresorerie where budProjet='" + var1 + "'" + var8;
      } else {
         var7 = "" + var8;
      }

      Query var9 = var5.createQuery(var7);
      List var10 = var9.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List chargerLesBudgetTresoreries(String var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var6 = true;
      }

      String var7 = "";
      if (var3 != null && !var3.isEmpty()) {
         var7 = "FROM BudgetTresorerie where budProjet='" + var1 + "' and budAnnee='" + var2 + "' and budActivite='" + var3 + "' and budCode='" + var4 + "'";
      } else {
         var7 = "FROM BudgetTresorerie where budProjet='" + var1 + "' and budAnnee='" + var2 + "' and budCode='" + var4 + "'";
      }

      Query var8 = var5.createQuery(var7);
      List var9 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargerLesBudgetTresoreries(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      String var4 = "FROM BudgetTresorerie where budProjet='" + var1 + "'";
      Query var5 = var2.createQuery(var4);
      List var6 = var5.list();
      ArrayList var7 = new ArrayList();
      if (var6.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((BudgetTresorerie)var6.get(var8)).getBudCode() + ":" + ((BudgetTresorerie)var6.get(var8)).getBudLibelleFr()));
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BudgetTresorerie rechercheBudgetTresorerie(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BudgetTresorerie ja where ja.budCode=:cod").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      new BudgetTresorerie();
      BudgetTresorerie var6;
      if (var5.size() > 0) {
         var6 = (BudgetTresorerie)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public BudgetTresorerie rechercheBudgetTresorerie(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Budget");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BudgetTresorerie where bud_id=:cod").setLong("cod", var1);
      var5.setMaxResults(1);
      List var6 = var5.list();
      new BudgetTresorerie();
      BudgetTresorerie var7;
      if (var6.size() > 0) {
         var7 = (BudgetTresorerie)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
