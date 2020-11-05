package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesMois;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CaissesMoisDao implements Serializable {
   private CaissesMois caissesMois;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public CaissesMoisDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public String ajoutPeriode(CaissesCommerciales var1, ExercicesCaisse var2, List var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
      Transaction var5 = var4.beginTransaction();
      Query var6 = var4.createQuery("from CaissesMois j where  j.exercicesCaisse=:exo and j.caimenCode=:code ");
      var6.setLong("exo", var2.getExecaiId());
      var6.setParameter("code", var1.getCaiCode());
      int var7 = var6.list().size();
      if (var7 == 0) {
         for(int var8 = 0; var8 < var3.size(); ++var8) {
            String var9 = (String)var3.get(var8);
            CaissesMois var10 = new CaissesMois();
            var10.setCaimenPeriode(var9);
            var10.setExercicesCaisse(var2);
            var10.setCaimenCle1(var1.getCaiCode() + ":" + var9);
            var10.setCaimenCode(var1.getCaiCode());
            var10.setCaimenEtat(0);
            var4.save(var10);
         }
      } else if (var7 != var3.size()) {
         for(int var13 = var7; var13 < var3.size(); ++var13) {
            String var12 = (String)var3.get(var13);
            CaissesMois var11 = new CaissesMois();
            var11.setCaimenPeriode(var12);
            var11.setExercicesCaisse(var2);
            var11.setCaimenCle1(var1.getCaiCode() + ":" + var12);
            var11.setCaimenCode(var1.getCaiCode());
            var11.setCaimenEtat(0);
            var4.save(var11);
         }
      }

      var5.commit();
      this.utilInitHibernate.closeSession();
      return "ok";
   }

   public CaissesMois majJournal(CaissesMois var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
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

   public CaissesMois majJournal(CaissesMois var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List mesjournauxmois(String var1, ExercicesCaisse var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null) {
         var5 = var3.createQuery(" from CaissesMois where caimenCode=:code and exercicesCaisse=:exo").setString("code", var1).setLong("exo", var2.getExecaiId());
      } else {
         var5 = var3.createQuery(" from CaissesMois where caimenCode=:code").setString("code", var1);
      }

      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public CaissesMois recupererCaissesMois(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from CaissesMois where caimenCle1=:cle1").setString("cle1", var1).setMaxResults(1);
      List var5 = var4.list();
      new CaissesMois();
      CaissesMois var6;
      if (var5.size() > 0) {
         var6 = (CaissesMois)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List listeJouMemPourCloture(String var1, ExercicesCaisse var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var4 = true;
      }

      Query var5 = var3.createQuery(" from CaissesMois where exercicesCaisse=:exo and caimenPeriode<=:per and caimenEtat=0").setLong("exo", var2.getExecaiId()).setString("per", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List listeJouMemAnnee(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from CaissesMois where caimenPeriode like '%:" + var1 + "' and caimenEtat=0");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeJouMemAnnee(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var2 = true;
      }

      Query var3 = var1.createQuery(" from CaissesMois");
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List listeJouMemCloture(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from CaissesMois where caimenPeriode like '%:" + var1 + "'");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeDateDebut(String var1, String var2, ExercicesCaisse var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var5 = true;
      }

      Query var6 = var4.createQuery(" from CaissesMois where exercicesCaisse=:exo and caimenCode=:cai and caimenPeriode<:perFin").setLong("exo", var3.getExecaiId()).setString("cai", var1).setString("perFin", var2);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
