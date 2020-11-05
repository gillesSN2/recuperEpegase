package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.CaissesJour;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CaissesJourDao implements Serializable {
   private CaissesJour caissesJour;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;
   private List lesjoursItems = new ArrayList();

   public CaissesJourDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public void calculLesJourDunMois(String var1) throws ParseException {
      if (var1 != null && !var1.isEmpty() && var1.contains(":")) {
         String var2 = "01:" + var1;
         SimpleDateFormat var3 = new SimpleDateFormat("dd:MM:yyyy");
         Date var4 = var3.parse(var2);
         this.lesjoursItems.clear();
         GregorianCalendar var5 = new GregorianCalendar();
         var5.setTime(var4);
         GregorianCalendar var6 = new GregorianCalendar();
         var6.setTime(var4);
         var5.add(5, -1);
         var6.add(2, 1);
         var6.add(5, -1);
         int var7 = 1;

         for(Date var8 = null; var5.compareTo(var6) < 0; ++var7) {
            var5.add(5, 1);
            var8 = var5.getTime();
            this.lesjoursItems.add(var8);
         }
      }

   }

   public String ajoutPeriode(CaissesCommerciales var1, String var2, ExercicesCaisse var3) throws HibernateException, NamingException, ParseException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
      Transaction var5 = var4.beginTransaction();
      Query var6 = var4.createQuery("from CaissesJour j where  j.exercicesCaisse=:exo and j.caijouCode=:code and caijouPeriode=:per").setLong("exo", var3.getExecaiId()).setString("code", var1.getCaiCode()).setString("per", var2);
      int var7 = var6.list().size();
      if (var7 == 0) {
         this.calculLesJourDunMois(var2);

         for(int var8 = 0; var8 < this.lesjoursItems.size(); ++var8) {
            Date var9 = (Date)this.lesjoursItems.get(var8);
            CaissesJour var10 = new CaissesJour();
            var10.setCaijouDate(var9);
            var10.setCaijouPeriode(var2);
            var10.setExercicesCaisse(var3);
            var10.setCaijouCle1(var1.getCaiCode() + ":" + var2);
            var10.setCaijouCode(var1.getCaiCode());
            var10.setCaijouEtat(0);
            var4.save(var10);
         }
      }

      var5.commit();
      this.utilInitHibernate.closeSession();
      return "ok";
   }

   public CaissesJour majJournal(CaissesJour var1) throws HibernateException, NamingException {
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

   public CaissesJour majJournal(CaissesJour var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List mesjournauxjour(String var1, String var2, ExercicesCaisse var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var5 = true;
      }

      Query var6 = null;
      if (var3 != null) {
         var6 = var4.createQuery(" from CaissesJour where caijouCode=:code and exercicesCaisse=:exo and caijouPeriode=:per").setString("code", var1).setLong("exo", var3.getExecaiId()).setString("per", var2);
      } else {
         var6 = var4.createQuery(" from CaissesJour where caijouCode=:code and caijouPeriode=:per").setString("code", var1).setString("per", var2);
      }

      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CaissesJour rechercheDernierJourCloture(String var1, String var2, ExercicesCaisse var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var5 = true;
      }

      Query var6 = var4.createQuery(" from CaissesJour where caijouCode=:code and exercicesCaisse=:exo and caijouEtat=1 and caijouDate<'" + var2 + "' order by caijouDate DESC").setString("code", var1).setLong("exo", var3.getExecaiId()).setMaxResults(1);
      this.caissesJour = new CaissesJour();
      List var7 = var6.list();
      if (var7.size() != 0) {
         this.caissesJour = (CaissesJour)var7.get(0);
      } else {
         this.caissesJour = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.caissesJour;
   }

   public CaissesJour recupererCaissesJour(Date var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var4 = true;
      }

      Query var5 = var3.createQuery(" from CaissesJour where caijouDate=:dte and caijouCode=:code").setDate("dte", var1).setString("code", var2).setMaxResults(1);
      List var6 = var5.list();
      new CaissesJour();
      CaissesJour var7;
      if (var6.size() > 0) {
         var7 = (CaissesJour)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CaissesJour recupererCaissesJour(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var4 = true;
      }

      Query var5 = var3.createQuery(" from CaissesJour where caijouId=:id").setLong("id", var1).setMaxResults(1);
      List var6 = var5.list();
      new CaissesJour();
      CaissesJour var7;
      if (var6.size() > 0) {
         var7 = (CaissesJour)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List listeJouMemPourCloture(String var1, ExercicesCaisse var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var4 = true;
      }

      Query var5 = var3.createQuery(" from CaissesJour where exercicesCaisse=:exo and caijouPeriode<=:per and caijouEtat=0").setLong("exo", var2.getExecaiId()).setString("per", var1);
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

      Query var4 = var2.createQuery(" from CaissesJour where caijouPeriode like '%:" + var1 + "' and caijouEtat=0");
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

      Query var3 = var1.createQuery(" from CaissesJour");
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

      Query var4 = var2.createQuery(" from CaissesJour where caijouPeriode like '%:" + var1 + "'");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeDateNonControle(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from CaissesJour where caijouCode=:cai and caijouControle is null and caijouEtat=1").setString("cai", var1);
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeDateDebut(String var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "CaisseCommerciale");
         var5 = true;
      }

      Query var6 = var4.createQuery(" from CaissesJour where caijouCode=:cai and caijouDate>=:dDeb and caijouDate<:dFin").setString("cai", var1).setDate("dDeb", var2).setDate("dFin", var3);
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
