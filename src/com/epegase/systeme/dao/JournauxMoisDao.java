package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.JournauxMois;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class JournauxMoisDao implements Serializable {
   private JournauxMois journauxMois;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public JournauxMoisDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public String ajoutPeriode(JournauxComptables var1, ExercicesComptable var2, List var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
      Transaction var5 = var4.beginTransaction();
      Query var6 = var4.createQuery("from JournauxMois j where  j.exercicesComptable=:exo and j.joumenCode=:code ");
      var6.setLong("exo", var2.getExecpt_id());
      var6.setParameter("code", var1.getPljCode());
      int var7 = var6.list().size();
      if (var7 == 0) {
         for(int var8 = 0; var8 < var3.size(); ++var8) {
            String var9 = (String)var3.get(var8);
            JournauxMois var10 = new JournauxMois();
            var10.setJoumenPeriode(var9);
            var10.setExercicesComptable(var2);
            var10.setJoumenCle1(var1.getPljCode() + ":" + var9);
            var10.setJoumenCode(var1.getPljCode());
            var10.setJoumenEtat(0);
            var10.setJoumenSaisie(0);
            var4.save(var10);
         }
      } else if (var7 != var3.size()) {
         for(int var13 = var7; var13 < var3.size(); ++var13) {
            String var12 = (String)var3.get(var13);
            JournauxMois var11 = new JournauxMois();
            var11.setJoumenPeriode(var12);
            var11.setExercicesComptable(var2);
            var11.setJoumenCle1(var1.getPljCode() + ":" + var12);
            var11.setJoumenCode(var1.getPljCode());
            var11.setJoumenEtat(0);
            var11.setJoumenSaisie(0);
            var4.save(var11);
         }
      }

      var5.commit();
      this.utilInitHibernate.closeSession();
      return "ok";
   }

   public JournauxMois majJournal(JournauxMois var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
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

   public JournauxMois majJournal(JournauxMois var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List mesjournauxmois(String var1, ExercicesComptable var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null) {
         var5 = var3.createQuery("from JournauxMois where joumenCode=:code and exercicesComptable=:exo").setString("code", var1).setLong("exo", var2.getExecpt_id());
      } else {
         var5 = var3.createQuery("from JournauxMois where joumenCode=:code").setString("code", var1);
      }

      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public JournauxMois recupererJournauxMois(String var1, ExercicesComptable var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var4 = true;
      }

      Query var5 = var3.createQuery(" from JournauxMois where joumenCle1=:cle1 and exercicesComptable=:exo").setString("cle1", var1).setLong("exo", var2.getExecpt_id()).setMaxResults(1);
      List var6 = var5.list();
      new JournauxMois();
      JournauxMois var7;
      if (var6.size() > 0) {
         var7 = (JournauxMois)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public JournauxMois recupererJournauxMois(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from JournauxMois where joumenCle1=:cle1").setString("cle1", var1).setMaxResults(1);
      List var5 = var4.list();
      new JournauxMois();
      JournauxMois var6;
      if (var5.size() > 0) {
         var6 = (JournauxMois)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List listeJouMemPourCloture(String var1, ExercicesComptable var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var4 = true;
      }

      String[] var5 = var1.split(":");
      int var6 = Integer.parseInt(var5[0]);
      int var7 = Integer.parseInt(var5[1]);
      Query var8 = var3.createQuery(" from JournauxMois where exercicesComptable=:exo and joumenEtat=0").setLong("exo", var2.getExecpt_id());
      List var9 = var8.list();
      ArrayList var10 = new ArrayList();
      if (var9.size() != 0) {
         for(int var11 = 0; var11 < var9.size(); ++var11) {
            this.journauxMois = (JournauxMois)var9.get(var11);
            String[] var12 = this.journauxMois.getJoumenPeriode().split(":");
            int var13 = Integer.parseInt(var12[0]);
            int var14 = Integer.parseInt(var12[1]);
            if (var13 <= var6 && var14 <= var7) {
               var10.add(this.journauxMois);
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List listeJouMemPourDecloture(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var4 = true;
      }

      String[] var5 = var1.split(":");
      int var6 = Integer.parseInt(var5[0]);
      int var7 = Integer.parseInt(var5[1]);
      String[] var8 = var2.split(":");
      int var9 = Integer.parseInt(var8[0]);
      int var10 = Integer.parseInt(var8[1]);
      Query var11 = var3.createQuery(" from JournauxMois where joumenEtat=1");
      List var12 = var11.list();
      ArrayList var13 = new ArrayList();
      if (var12.size() != 0) {
         for(int var14 = 0; var14 < var12.size(); ++var14) {
            this.journauxMois = (JournauxMois)var12.get(var14);
            String[] var15 = this.journauxMois.getJoumenPeriode().split(":");
            int var16 = Integer.parseInt(var15[0]);
            int var17 = Integer.parseInt(var15[1]);
            if (var16 >= var6 && var17 >= var7 && var16 <= var9 && var17 <= var10) {
               var13.add(this.journauxMois);
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var13;
   }

   public List listeJouMemAnnee(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from JournauxMois where joumenPeriode like '%:" + var1 + "' and joumenEtat=0");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeJouMemAnnee(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var2 = true;
      }

      Query var3 = var1.createQuery(" from JournauxMois");
      List var4 = var3.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List listeJouMemCloture(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from JournauxMois where exercicesComptable=:exo order by joumenCode, joumenPeriode").setLong("exo", var1.getExecpt_id());
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeJouMemClotureByJournal(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from JournauxMois where exercicesComptable=:exo group by joumenCode order by joumenCode").setLong("exo", var1.getExecpt_id());
      List var5 = var4.list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(((JournauxMois)var5.get(var7)).getJoumenCode());
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
