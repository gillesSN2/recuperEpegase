package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.ExercicesComptable;
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

public class BrouillardDao implements Serializable {
   private Brouillard brouillard;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BrouillardDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public Brouillard insert(Brouillard var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public Brouillard modif(Brouillard var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(Brouillard var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
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

   public void copiertousBrouillards(List var1, ExercicesComptable var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
      Transaction var4 = var3.beginTransaction();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         Brouillard var6 = (Brouillard)var1.get(var5);
         var6.setExercicescomptable(var2);
         var3.save(var6);
      }

      var4.commit();
      this.utilInitHibernate.closeSession();
   }

   public void removeSelected(List var1, Session var2) throws HibernateException, NamingException {
      new Ecritures();
      EcrituresDao var4 = new EcrituresDao(this.mabase, this.utilInitHibernate);
      if (var1.size() != 0) {
         new Brouillard();

         for(int var6 = 0; var6 < var1.size(); ++var6) {
            Brouillard var5 = (Brouillard)var1.get(var6);
            Ecritures var3 = var4.recupererSelectedECByIdBrouillard(var5.getBro_id(), var2);
            if (var3 == null) {
               var2.delete(var5);
            }
         }
      }

   }

   public void removeSelected(Brouillard var1, Session var2) throws HibernateException, NamingException {
      new Ecritures();
      EcrituresDao var4 = new EcrituresDao(this.mabase, this.utilInitHibernate);
      Ecritures var3 = var4.recupererSelectedECByIdBrouillard(var1.getBro_id(), var2);
      if (var3 == null) {
         var2.delete(var1);
      }

   }

   public List chargerLesBrouillards(String var1, Date var2, long var3, int var5, long var6) throws HibernateException, NamingException {
      Session var8 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
      List var9 = null;
      if (var5 == 100) {
         var9 = var8.createQuery("from Brouillard where broCode=:cod and broDateSaisie=:dteJ and exercicescomptable=:id and broUserCreat=:pro").setString("cod", var1).setDate("dteJ", var2).setLong("id", var6).setLong("pro", var3).list();
      } else {
         var9 = var8.createQuery("from Brouillard where broCode=:cod and broDateSaisie=:dteJ and exercicescomptable=:id and broUserCreat=:pro and broEtat=:et").setString("cod", var1).setDate("dteJ", var2).setLong("id", var6).setLong("pro", var3).setInteger("et", var5).list();
      }

      this.utilInitHibernate.closeSession();
      return var9;
   }

   public List chargerLesBrouillards(String var1, String var2, long var3, int var5, long var6) throws HibernateException, NamingException {
      Session var8 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
      List var9 = null;
      if (var5 == 100) {
         var9 = var8.createQuery("from Brouillard where broCode=:cod and broPeriode=:per and exercicescomptable=:id and broUserCreat=:pro").setString("cod", var1).setString("per", var2).setLong("id", var6).setLong("pro", var3).list();
      } else {
         var9 = var8.createQuery("from Brouillard where broCode=:cod and broPeriode=:per and exercicescomptable=:id and broUserCreat=:pro and broEtat=:et").setString("cod", var1).setString("per", var2).setLong("id", var6).setLong("pro", var3).setInteger("et", var5).list();
      }

      this.utilInitHibernate.closeSession();
      return var9;
   }

   public long chercherDernierBrouillard(String var1, String var2, long var3, long var5, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
         var8 = true;
      }

      Query var9 = var7.createQuery("from Brouillard where broCode=:cod and broPeriode=:per and exercicescomptable=:id and broUserCreat=:pro order by broNum desc").setString("cod", var1).setString("per", var2).setLong("id", var5).setLong("pro", var3).setMaxResults(1);
      long var10 = 0L;
      new ArrayList();
      List var12 = var9.list();
      if (var12.size() != 0) {
         var10 = ((Brouillard)var12.get(0)).getBroNum();
      }

      ++var10;
      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List chargerLesBrouillardsByCode(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
      List var5 = var4.createQuery("from Brouillard where broCode=:cod  and exercicescomptable=:id ").setString("cod", var1).setLong("id", var2).list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public List chargerLesBrouillardsByPeriode(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
      List var5 = var4.createQuery("from Brouillard where broPeriode=:per  and exercicescomptable=:id ").setString("per", var1).setLong("id", var2).list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public long lastBrouillard(String var1, String var2, long var3) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
      List var6 = var5.createQuery("from Brouillard where broCode=:cod and broPeriode=:per and exercicescomptable=:id order by bro_id desc ").setString("cod", var1).setString("per", var2).setLong("id", var3).list();
      long var7 = 0L;
      if (var6.size() > 0) {
         Brouillard var10 = (Brouillard)var6.get(0);
         var7 = var10.getBro_id();
      } else {
         var7 = 0L;
      }

      this.utilInitHibernate.closeSession();
      return var7;
   }

   public void changerExercice(String var1, ExercicesComptable var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Ecritures");
         var4 = true;
      }

      Query var5 = var3.createQuery("update Brouillard set exercicescomptable.execpt_id=" + var2.getExecpt_id() + " where broDateSaisie >=:debut").setString("debut", var1);
      var5.executeUpdate();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

   }

   public List chargerBrouillards(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from Brouillard where broCode=:jr and broDateSaisie>=:debut and broDateSaisie<=:final ").setString("jr", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List chargerBrouillardsTransfert(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from Brouillard where broCode=:jr and broDateSaisie>=:debut and broDateSaisie<=:final and broIdOrigine<>0").setString("jr", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcritures(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Brouillard where broDateSaisie >=:debut").setString("debut", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerEcritures(ExercicesComptable var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from Brouillard where exercicescomptable=:exo").setParameter("exo", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List ChargerLesBrouillardsRecherche(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Brouillard");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Brouillard where " + var1 + " order by broNum");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
