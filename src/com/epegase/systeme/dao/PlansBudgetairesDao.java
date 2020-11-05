package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.PlansBudgetaires;
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

public class PlansBudgetairesDao implements Serializable {
   private PlansBudgetaires plansBudgetaires;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public PlansBudgetairesDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public PlansBudgetaires insert(PlansBudgetaires var1) throws HibernateException, NamingException {
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

   public PlansBudgetaires insert(PlansBudgetaires var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PlansBudgetaires modif(PlansBudgetaires var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
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

   public PlansBudgetaires modif(PlansBudgetaires var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PlansBudgetaires var1) throws HibernateException, NamingException {
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

   public void delete(PlansBudgetaires var1, Session var2) {
      var2.delete(var1);
   }

   public void ordonnner(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         String var9 = "update PlansBudgetaires pb set pb.plbOrdre=:ordPrec where pb.plb_id=:idPlb";
         var7.createQuery(var9).setInteger("ordPrec", var1).setLong("idPlb", var3).executeUpdate();
         String var11 = "update PlansBudgetaires pb set pb.plbOrdre=:ord1 where pb.plb_id=:idPlb";
         var7.createQuery(var11).setInteger("ord1", var2).setLong("idPlb", var5).executeUpdate();
         var8.commit();
      } catch (HibernateException var16) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void ordonnnerDescendant(int var1, int var2, long var3, long var5) throws HibernateException, NamingException {
      Session var7 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
      Transaction var8 = null;

      try {
         var8 = var7.beginTransaction();
         String var9 = "update PlansBudgetaires pb set pb.plbOrdre=:ordSuiv where pb.plb_id=:idPlb";
         var7.createQuery(var9).setInteger("ordSuiv", var1).setLong("idPlb", var3).executeUpdate();
         String var11 = "update PlansBudgetaires pb set pb.plbOrdre=:ord1 where pb.plb_id=:idPlb";
         var7.createQuery(var11).setInteger("ord1", var2).setLong("idPlb", var5).executeUpdate();
         var8.commit();
      } catch (HibernateException var16) {
         if (var8 != null) {
            var8.rollback();
         }

         throw var16;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void copiertouslesPlansbudgetaires(List var1, ExercicesComptable var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            PlansBudgetaires var6 = (PlansBudgetaires)var1.get(var5);
            var6.setExercicesComptable(var2);
            var3.save(var6);
         }

         var4.commit();
      } catch (HibernateException var10) {
         if (var4 != null) {
            var4.rollback();
         }

         throw var10;
      } finally {
         this.utilInitHibernate.closeSession();
      }
   }

   public List chargerLesPlansBudgetaires(ExercicesComptable var1, int var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var6 = true;
      }

      Query var7 = var5.createQuery("from PlansBudgetaires where exercicesComptable=:exo and plbAnnee=:ann and plbNature=:nat and plbChoixBudget=:choix order by plbEntite,plbCode").setParameter("exo", var1).setString("ann", var4).setString("nat", var3).setInteger("choix", var2);
      new ArrayList();
      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesPlansBudgetaires(ExercicesComptable var1, int var2, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var7 = true;
      }

      Query var8 = var6.createQuery("from PlansBudgetaires where exercicesComptable=:exo and plbAnnee=:ann and plbNature=:nat and plbEntite=:ent and plbChoixBudget=:choix order by plbEntite,plbCode").setParameter("exo", var1).setString("ann", var4).setString("nat", var3).setString("ent", var5).setInteger("choix", var2);
      new ArrayList();
      List var9 = var8.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargerLesPlansBudgetaires(int var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var6 = true;
      }

      Query var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from PlansBudgetaires where plbActivite='" + var4 + "' and plbAnnee='" + var3 + "' and (plbNature<>'1' and plbNature<>'3' and plbNature<>'4' and plbNature<>'5' and plbNature<>'6' and plbNature<>'7' and plbNature<>'8') and plbType<=1 and plbChoixBudget=" + var1 + " order by plbCode");
      } else {
         var7 = var5.createQuery("from PlansBudgetaires where plbAnnee='" + var3 + "' and (plbNature<>'1' and plbNature<>'3' and plbNature<>'4' and plbNature<>'5' and plbNature<>'6' and plbNature<>'7' and plbNature<>'8')  and plbType<=1 and plbChoixBudget=" + var1 + " order by plbOrdre ");
      }

      new ArrayList();
      List var8 = var7.list();
      ArrayList var9 = new ArrayList();
      if (var8.size() != 0) {
         for(int var10 = 0; var10 < var8.size(); ++var10) {
            var9.add(new SelectItem(((PlansBudgetaires)var8.get(var10)).getPlbCode() + ":" + ((PlansBudgetaires)var8.get(var10)).getPlbLibelleFr()));
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargerLesPlansBudgetaires(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var5 = true;
      }

      String var6 = "";
      String[] var7;
      if (var2 != null) {
         if (var2.contains(":")) {
            var7 = var2.split(":");
            var6 = var7[0];
         } else {
            var6 = var2;
         }
      }

      var7 = null;
      Query var9;
      if (var3 != null && !var3.isEmpty()) {
         var9 = var4.createQuery("from PlansBudgetaires where plbActivite='" + var3 + "' and plbNature='" + var6 + "' and plbChoixBudget=" + var1 + " order by plbEntite,plbCode");
      } else {
         var9 = var4.createQuery("from PlansBudgetaires where plbNature='" + var6 + "' and plbChoixBudget=" + var1 + " order by plbEntite,plbCode");
      }

      new ArrayList();
      List var8 = var9.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesPlansBudgetairesItems(int var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var5 = true;
      }

      String var6 = "";
      String[] var7;
      if (var2 != null) {
         if (var2.contains(":")) {
            var7 = var2.split(":");
            var6 = var7[0];
         } else {
            var6 = var2;
         }
      }

      var7 = null;
      Query var11;
      if (var3 != null && !var3.isEmpty()) {
         var11 = var4.createQuery("from PlansBudgetaires where plbActivite='" + var3 + "' and plbNature='" + var6 + "' and plbChoixBudget=" + var1 + " order by plbCode");
      } else {
         var11 = var4.createQuery("from PlansBudgetaires where plbNature='" + var6 + "' and plbChoixBudget=" + var1 + " order by plbOrdre ");
      }

      new ArrayList();
      List var8 = var11.list();
      ArrayList var9 = new ArrayList();
      if (var8.size() != 0) {
         for(int var10 = 0; var10 < var8.size(); ++var10) {
            var9.add(new SelectItem(((PlansBudgetaires)var8.get(var10)).getPlbCode() + ":" + ((PlansBudgetaires)var8.get(var10)).getPlbLibelleFr()));
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public boolean existCode(int var1, String var2, String var3, long var4, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var7 = true;
      }

      boolean var8 = false;
      Query var9 = var6.createQuery("from PlansBudgetaires ja where ja.plbCode=:cod and ja.plbNature=:nat and ja.exercicesComptable=:exo and plbChoixBudget=:choix").setString("cod", var2).setString("nat", var3).setLong("exo", var4).setInteger("choix", var1);
      var9.setMaxResults(1);
      List var10 = var9.list();
      if (var10.size() > 0) {
         var8 = true;
      } else {
         var8 = false;
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public PlansBudgetaires rechercheCode(int var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var6 = true;
      }

      Query var7 = var5.createQuery("from PlansBudgetaires where plbCode=:cod and plbNature=:nat and plbAnnee=:an and plbChoixBudget=:choix").setString("cod", var2).setString("nat", var3).setString("an", var4).setInteger("choix", var1);
      var7.setMaxResults(1);
      this.plansBudgetaires = new PlansBudgetaires();
      List var8 = var7.list();
      if (var8.size() > 0) {
         this.plansBudgetaires = (PlansBudgetaires)var8.get(0);
      } else {
         this.plansBudgetaires = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return this.plansBudgetaires;
   }

   public PlansBudgetaires rechercheCode(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PlansBudgetaires where plbCode=:cod and plbChoixBudget=:choix").setString("cod", var2).setInteger("choix", var1);
      var5.setMaxResults(1);
      this.plansBudgetaires = new PlansBudgetaires();
      List var6 = var5.list();
      if (var6.size() > 0) {
         this.plansBudgetaires = (PlansBudgetaires)var6.get(0);
      } else {
         this.plansBudgetaires = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.plansBudgetaires;
   }

   public List chargerLesPlansBudgets(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var3 = true;
      }

      List var4 = var2.createQuery("from PlansBudgetaires where plbChoixBudget=:choix order by plbCode").setInteger("choix", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((PlansBudgetaires)var5.get(var7)).getPlbCode() + ":" + ((PlansBudgetaires)var5.get(var7)).getPlbLibelleFr()));
         }
      }

      return var6;
   }

   public List chargerLesPlansBudgetsProjets(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var4 = true;
      }

      List var5 = var3.createQuery("from PlansBudgetaires where plbNature=:nat and plbChoixBudget=:choix order by plbEntite,plbCode").setString("nat", var2).setInteger("choix", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesPlansBudgetairesAnnee(int var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PlansBudgetaires where plbAnnee='" + var2 + "' and plbChoixBudget=" + var1 + " order by plbEntite,plbCode");
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesPlansBudgetairesAnnee(ExercicesComptable var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PlansBudgetaires");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PlansBudgetaires where exercicesComptable=:exo and plbChoixBudget=:choix order by plbEntite,plbCode").setParameter("exo", var1).setInteger("choix", var2);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
