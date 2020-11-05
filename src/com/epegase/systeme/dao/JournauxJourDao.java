package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxComptables;
import com.epegase.systeme.classe.JournauxJour;
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

public class JournauxJourDao implements Serializable {
   private JournauxJour journauxJour;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;
   private List lesjoursItems = new ArrayList();

   public JournauxJourDao(String var1, UtilInitHibernate var2) {
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

   public String ajoutPeriode(JournauxComptables var1, String var2, ExercicesComptable var3) throws HibernateException, NamingException, ParseException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
      Transaction var5 = var4.beginTransaction();
      Query var6 = var4.createQuery("from JournauxJour where exercicesComptable=:exo and joujrCode=:code and joujrPeriode=:per").setLong("exo", var3.getExecpt_id()).setString("code", var1.getPljCode()).setString("per", var2);
      int var7 = var6.list().size();
      if (var7 == 0) {
         this.calculLesJourDunMois(var2);

         for(int var8 = 0; var8 < this.lesjoursItems.size(); ++var8) {
            Date var9 = (Date)this.lesjoursItems.get(var8);
            JournauxJour var10 = new JournauxJour();
            var10.setJoujrDate(var9);
            var10.setJoujrPeriode(var2);
            var10.setExercicesComptable(var3);
            var10.setJoujrCle1(var1.getPljCode() + ":" + var2);
            var10.setJoujrCode(var1.getPljCode());
            var10.setJoujrEtat(0);
            var4.save(var10);
         }
      }

      var5.commit();
      this.utilInitHibernate.closeSession();
      return "ok";
   }

   public JournauxJour majJournal(JournauxJour var1) throws HibernateException, NamingException {
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

   public JournauxJour majJournal(JournauxJour var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public List mesjournauxjour(String var1, String var2, ExercicesComptable var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var5 = true;
      }

      Query var6 = null;
      if (var3 != null) {
         var6 = var4.createQuery(" from JournauxJour where joujrCode=:code and exercicesComptable=:exo and joujrPeriode=:per").setString("code", var1).setLong("exo", var3.getExecpt_id()).setString("per", var2);
      } else {
         var6 = var4.createQuery(" from JournauxJour where joujrCode=:code and joujrPeriode=:per").setString("code", var1).setString("per", var2);
      }

      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List mesjournauxjour(String var1, Date var2, Date var3, ExercicesComptable var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var6 = true;
      }

      Query var7 = null;
      if (var4 != null) {
         var7 = var5.createQuery(" from JournauxJour where joujrCode=:code and exercicesComptable=:exo and joujrDate>=:d1 and joujrDate<=:d2").setString("code", var1).setLong("exo", var4.getExecpt_id()).setDate("d1", var2).setDate("d2", var3);
      } else {
         var7 = var5.createQuery(" from JournauxJour where joujrCode=:code and joujrDate>=:d1 and joujrDate<=:d2").setString("code", var1).setDate("d1", var2).setDate("d2", var3);
      }

      List var8 = var7.list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List mesjournauxmois(String var1, ExercicesComptable var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null) {
         var5 = var3.createQuery(" from JournauxJour where joujrCode=:code and exercicesComptable=:exo").setString("code", var1).setLong("exo", var2.getExecpt_id());
      } else {
         var5 = var3.createQuery(" from JournauxJour where joujrCode=:code").setString("code", var1);
      }

      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public JournauxJour recupererJournauxJour(String var1, ExercicesComptable var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var4 = true;
      }

      Query var5 = var3.createQuery(" from JournauxJour where joujrCle1=:cle1 and exercicesComptable=:exo").setString("cle1", var1).setLong("exo", var2.getExecpt_id()).setMaxResults(1);
      List var6 = var5.list();
      new JournauxJour();
      JournauxJour var7;
      if (var6.size() > 0) {
         var7 = (JournauxJour)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public JournauxJour recupererJournauxJour(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from JournauxJour where joujrCle1=:cle1").setString("cle1", var1).setMaxResults(1);
      List var5 = var4.list();
      new JournauxJour();
      JournauxJour var6;
      if (var5.size() > 0) {
         var6 = (JournauxJour)var5.get(0);
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
      Query var8 = var3.createQuery(" from JournauxJour where exercicesComptable=:exo and joujrEtat=0").setLong("exo", var2.getExecpt_id());
      List var9 = var8.list();
      ArrayList var10 = new ArrayList();
      if (var9.size() != 0) {
         for(int var11 = 0; var11 < var9.size(); ++var11) {
            this.journauxJour = (JournauxJour)var9.get(var11);
            String[] var12 = this.journauxJour.getJoujrPeriode().split(":");
            int var13 = Integer.parseInt(var12[0]);
            int var14 = Integer.parseInt(var12[1]);
            if (var13 <= var6 && var14 <= var7) {
               var10.add(this.journauxJour);
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
      Query var11 = var3.createQuery(" from JournauxJour where joujrEtat=1");
      List var12 = var11.list();
      ArrayList var13 = new ArrayList();
      if (var12.size() != 0) {
         for(int var14 = 0; var14 < var12.size(); ++var14) {
            this.journauxJour = (JournauxJour)var12.get(var14);
            String[] var15 = this.journauxJour.getJoujrPeriode().split(":");
            int var16 = Integer.parseInt(var15[0]);
            int var17 = Integer.parseInt(var15[1]);
            if (var16 >= var6 && var17 >= var7 && var16 <= var9 && var17 <= var10) {
               var13.add(this.journauxJour);
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var13;
   }

   public List listeJouJrAnnee(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var3 = true;
      }

      Query var4 = var2.createQuery(" from JournauxJour where joujrPeriode like '%:" + var1 + "' and joujrEtat=0");
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List listeJouJrAnnee(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "JournauxComptables");
         var2 = true;
      }

      Query var3 = var1.createQuery(" from JournauxJour");
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

      Query var4 = var2.createQuery(" from JournauxJour where exercicesComptable=:exo order by joujrCode, joujrPeriode").setLong("exo", var1.getExecpt_id());
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

      Query var4 = var2.createQuery(" from JournauxJour where exercicesComptable=:exo group by joujrCode order by joujrCode").setLong("exo", var1.getExecpt_id());
      List var5 = var4.list();
      ArrayList var6 = new ArrayList();
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(((JournauxJour)var5.get(var7)).getJoujrCode());
         }
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
