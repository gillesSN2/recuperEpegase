package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.FeuilleCalcul;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jdom.JDOMException;

public class FeuilleCalculDao implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String mabase;

   public FeuilleCalculDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public String ajoutParDefaut(String var1) throws JDOMException, IOException, HibernateException, NamingException {
      return null;
   }

   public FeuilleCalcul insert(FeuilleCalcul var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
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

   public FeuilleCalcul insert(FeuilleCalcul var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FeuilleCalcul modif(FeuilleCalcul var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
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

   public FeuilleCalcul modif(FeuilleCalcul var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(FeuilleCalcul var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
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

   public void delete(FeuilleCalcul var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void copiertoutesLesFeuilles(List var1, ExercicesPaye var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
      Transaction var4 = null;

      try {
         var4 = var3.beginTransaction();

         for(int var5 = 0; var5 < var1.size(); ++var5) {
            FeuilleCalcul var6 = (FeuilleCalcul)var1.get(var5);
            var6.setExercicesPaye(var2);
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

   public List chargerFeuilles(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var4 = true;
      }

      Object var5 = new ArrayList();
      Query var6 = var3.createQuery(" from FeuilleCalcul where exercicesPaye=:exo and feuInactif = 0 group by feuCode order by feuCode").setLong("exo", var1);
      if (var6.list().size() > 0) {
         var5 = var6.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List chargerFeuillesByJournal(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var4 = true;
      }

      Object var5 = new ArrayList();
      Query var6 = var3.createQuery(" from FeuilleCalcul where exercicesPaye=:exo and feuInactif = 0 group by feuJournal order by feuJournal").setLong("exo", var1);
      if (var6.list().size() > 0) {
         var5 = var6.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List chargerFeuilles(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      ArrayList var6 = new ArrayList();
      new ArrayList();
      Query var8 = null;
      if (var1 != 0L) {
         var8 = var4.createQuery(" from FeuilleCalcul where exercicesPaye=:exo and feuInactif = 0 group by feuCode order by feuCode").setLong("exo", var1);
      } else {
         var8 = var4.createQuery(" from FeuilleCalcul where feuInactif = 0 group by feuCode order by feuCode");
      }

      if (var8.list().size() > 0) {
         List var7 = var8.list();
         if (var7.size() != 0) {
            for(int var9 = 0; var9 < var7.size(); ++var9) {
               var6.add(new SelectItem(((FeuilleCalcul)var7.get(var9)).getFeuCode() + ":" + ((FeuilleCalcul)var7.get(var9)).getFeuLibelleFr()));
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerFeuilleNature(long var1, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      Object var6 = new ArrayList();
      Query var7 = null;
      if (var3.equals("100")) {
         var7 = var4.createQuery(" from FeuilleCalcul where exercicesPaye=:exo group by feuCode order by feuCode").setLong("exo", var1);
      } else {
         String var8 = "";
         if (!var3.equals("01") && !var3.equals("01I") && !var3.equals("01D") && !var3.equals("02I") && !var3.equals("02D")) {
            if (!var3.equals("03") && !var3.equals("03D") && !var3.equals("03I")) {
               if (!var3.equals("05") && !var3.equals("11")) {
                  var8 = "feuNature like '" + var3 + "%'";
               } else {
                  var8 = "feuNature like '05%' or feuNature like '11%'";
               }
            } else {
               var8 = "feuNature like '03%'";
            }
         } else {
            var8 = "feuNature like '01%' or feuNature like '02%'";
         }

         var7 = var4.createQuery(" from FeuilleCalcul where " + var8 + " and exercicesPaye=:exo group by feuCode order by feuCode").setLong("exo", var1);
      }

      if (var7 != null) {
         var6 = var7.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public List chargerFeuillesUser(String var1, long var2, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var6 = true;
      }

      new ArrayList();
      Query var8 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var4 != null && !var4.isEmpty()) {
            var8 = var5.createQuery(" from FeuilleCalcul where exercicesPaye=:exo and feuInactif = 0 group by feuCode order by feuLibelleFr").setLong("exo", var2);
         } else {
            var8 = var5.createQuery(" from FeuilleCalcul where exercicesPaye=:exo and feuInactif = 0 group by feuCode order by feuLibelleFr").setLong("exo", var2);
         }
      } else if (var4 != null && !var4.isEmpty()) {
         var8 = var5.createQuery(" from FeuilleCalcul where exercicesPaye=:exo and feuInactif = 0 group by feuCode order by feuCode").setLong("exo", var2);
      } else {
         var8 = var5.createQuery(" from FeuilleCalcul where exercicesPaye=:exo and feuInactif = 0 group by feuCode order by feuCode").setLong("exo", var2);
      }

      List var7 = var8.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean existeCode(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      boolean var6 = false;
      Query var7 = var4.createQuery("from FeuilleCalcul where feuCode=:cpt and exercicesPaye=:exo").setString("cpt", var1).setLong("exo", var2).setMaxResults(1);
      new ArrayList();
      List var8 = var7.list();
      if (var8.size() > 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FeuilleCalcul chercherCode(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlanPaye");
         var5 = true;
      }

      new FeuilleCalcul();
      Query var7 = null;
      if (var2 != 0L) {
         var7 = var4.createQuery("from FeuilleCalcul where feuCode=:cpt and exercicesPaye=:exo").setString("cpt", var1).setLong("exo", var2).setMaxResults(1);
      } else {
         var7 = var4.createQuery("from FeuilleCalcul where feuCode=:cpt").setString("cpt", var1).setMaxResults(1);
      }

      new ArrayList();
      List var8 = var7.list();
      FeuilleCalcul var6;
      if (var8.size() > 0) {
         var6 = (FeuilleCalcul)var8.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
