package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ElevesInscription;
import com.epegase.systeme.classe.ElevesViolences;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FilieresEducation;
import com.epegase.systeme.classe.FilieresMatieres;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ElevesViolencesDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ElevesViolencesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ElevesViolences insert(ElevesViolences var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public ElevesViolences insert(ElevesViolences var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ElevesViolences modif(ElevesViolences var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public ElevesViolences modif(ElevesViolences var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ElevesViolences var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public void delete(ElevesViolences var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerLesElevesViolences(Date var1, FilieresEducation var2, FilieresMatieres var3, ExercicesVentes var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var6 = true;
      }

      List var7 = var5.createQuery("From ElevesViolences where elevioDate=:dte and filieresEducation=:fil and filieresMatieres=:mat and exercicesVentes=:exo").setDate("dte", var1).setParameter("fil", var2).setParameter("mat", var3).setParameter("exo", var4).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesElevesViolences(Date var1, Date var2, long var3, long var5, ExercicesVentes var7, int var8, String var9, String var10, Session var11) throws HibernateException, NamingException {
      boolean var12 = false;
      if (var11 == null) {
         var11 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var12 = true;
      }

      String var13 = "";
      if (var1 != null && var2 != null) {
         UtilDate var14 = new UtilDate();
         String var15 = var14.dateToStringSQLLight(var1);
         String var16 = var14.dateToStringSQLLight(var2);
         var13 = var13 + "elevioDate>='" + var15 + "' and elevioDate<='" + var16 + "'";
      } else {
         var13 = "exercicesVentes.exevteId=" + var7.getExevteId();
      }

      if (var3 != 0L) {
         var13 = var13 + " and filieresEducation.filId=" + var3;
      }

      if (var5 != 0L) {
         var13 = var13 + " and filieresMatieres.filmatId=" + var5;
      }

      if (var8 != 100) {
         var13 = var13 + " and elevioEtat=" + var8;
      }

      if (var9 != null && !var9.isEmpty()) {
         var13 = var13 + " and eleves.eleNom like '" + var9 + "%'";
      }

      if (var10 != null && !var10.isEmpty()) {
         var13 = var13 + " and eleves.eleDossier='" + var10 + "'";
      }

      List var17 = var11.createQuery("From ElevesViolences where " + var13).list();
      if (var12) {
         this.utilInitHibernate.closeSession();
      }

      return var17;
   }

   public List chargerLesElevesViolences(String var1, ExercicesVentes var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var4 = true;
      }

      List var5 = var3.createQuery("From ElevesViolences where elevioNum=:num and exercicesVentes=:exo").setString("num", var1).setParameter("exo", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesElevesViolences(Eleves var1, ElevesInscription var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var4 = true;
      }

      List var5 = var3.createQuery("From ElevesViolences where eleves=:param and elevioAnnee=:annee").setParameter("param", var1).setString("annee", var2.getEleinsAnnee()).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesElevesViolences(Eleves var1, ElevesInscription var2, FilieresMatieres var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var5 = true;
      }

      List var6 = var4.createQuery("From ElevesViolences where eleves=:param and elevioAnnee=:annee and elevioMatiere=:matiere").setParameter("param", var1).setString("annee", var2.getEleinsAnnee()).setString("matiere", var3.getFilmatCode()).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
