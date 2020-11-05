package com.epegase.systeme.dao;

import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class PlansAnalytiquesDao implements Serializable {
   private PlansAnalytiques plansAnalytiques;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PlansAnalytiquesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public PlansAnalytiques insert(PlansAnalytiques var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
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

   public PlansAnalytiques insert(PlansAnalytiques var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PlansAnalytiques modif(PlansAnalytiques var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
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

   public PlansAnalytiques modif(PlansAnalytiques var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(PlansAnalytiques var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
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

   public void delete(PlansAnalytiques var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List selectAnal(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery(" from PlansAnalytiques where anaNature=:nat order by anaCode").setString("nat", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheDestinataire(String var1, String var2, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var7 = true;
      }

      new ArrayList();
      String var9 = "";
      if (var1 != null && !var1.isEmpty() && !var1.contains("*")) {
         var9 = var9 + " anaNomFr like '" + var1 + "%' and ";
      }

      String var10;
      if (var1 != null && !var1.isEmpty() && var1.startsWith("*")) {
         var10 = var1.substring(1);
         var9 = var9 + " anaNomFr like '%" + var10 + "%' and ";
      }

      if (var2 != null && !var2.isEmpty() && !var2.contains("*")) {
         var9 = var9 + " anaTiersVille like '" + var2 + "%' and ";
      }

      if (var2 != null && !var2.isEmpty() && var2.startsWith("*")) {
         var10 = var2.substring(1);
         var9 = var9 + " anaTiersVille like '%" + var10 + "%' and ";
      }

      if (var3 != null && !var3.isEmpty() && !var3.endsWith("100")) {
         var9 = var9 + " anaTiersAppreciation = '" + var3 + "' and ";
      }

      if (var4 != null && !var4.isEmpty() && !var4.equals("100")) {
         var9 = var9 + " anaTierssource = '" + var4 + "' and ";
      }

      Query var11 = var6.createQuery(" from PlansAnalytiques where " + var9 + " anaNature=:nat order by anaNomFr").setString("nat", var5);
      List var8 = var11.list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargerLesAnalytiques(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      List var4 = var2.createQuery("from PlansAnalytiques where anaNature=:nat and anaInactif=0 order by anaCode asc").setString("nat", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((PlansAnalytiques)var5.get(var7)).getAnaCode() + ":" + ((PlansAnalytiques)var5.get(var7)).getAnaNomFr()));
         }
      }

      return var6;
   }

   public List chargerLesLotsEnCours(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var4 = true;
      }

      List var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from PlansAnalytiques where anaNature=:nat and (anaLotEtat=0 or anaCode=:code) order by anaCode asc").setString("nat", var1).setString("code", var2).list();
      } else {
         var5 = var3.createQuery("from PlansAnalytiques where anaNature=:nat and anaLotEtat=0 order by anaCode asc").setString("nat", var1).list();
      }

      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((PlansAnalytiques)var6.get(var8)).getAnaCode(), ((PlansAnalytiques)var6.get(var8)).getAnaCode() + ":" + ((PlansAnalytiques)var6.get(var8)).getAnaNomFr()));
         }
      }

      return var7;
   }

   public List chargerLesAnalytiques(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      List var4 = var2.createQuery("from PlansAnalytiques where anaNature='9' and anaNatureRepartition=:nat and anaInactif=0 order by anaCode asc").setInteger("nat", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((PlansAnalytiques)var5.get(var7)).getAnaCode() + ":" + ((PlansAnalytiques)var5.get(var7)).getAnaNomFr()));
         }
      }

      return var6;
   }

   public List chargerLesAnalytiquesStructure(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var2 = true;
      }

      List var3 = var1.createQuery("from PlansAnalytiques where ((anaNature='9' and anaNatureRepartition=200) or (anaNature='20' and anaNatureRepartition=201)) and anaInactif=0 order by anaCode asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((PlansAnalytiques)var4.get(var6)).getAnaCode() + ":" + ((PlansAnalytiques)var4.get(var6)).getAnaNomFr()));
         }
      }

      return var5;
   }

   public List chargerLesAnalytiquesStandard(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      List var4 = var2.createQuery("from PlansAnalytiques where anaNature='9' and anaNatureRepartition!=:nat and anaInactif=0 order by anaCode asc").setInteger("nat", var1).list();
      List var5 = var4;
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6.add(new SelectItem(((PlansAnalytiques)var5.get(var7)).getAnaCode() + ":" + ((PlansAnalytiques)var5.get(var7)).getAnaNomFr()));
         }
      }

      return var6;
   }

   public List chargerLesAnalytiques(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var4 = true;
      }

      List var5 = var3.createQuery("from PlansAnalytiques where anaNature=:nat and ((anaAnneeDebut=0 or anaAnneeFin=0) or (anaAnneeFin <='" + var2 + "' or anaAnneeDebut >='" + var2 + "')) and anaInactif=0 order by anaCode asc").setString("nat", var1).list();
      List var6 = var5;
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7.add(new SelectItem(((PlansAnalytiques)var6.get(var8)).getAnaCode() + ":" + ((PlansAnalytiques)var6.get(var8)).getAnaNomFr()));
         }
      }

      return var7;
   }

   public long chercherDernierAnal(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlansAnalytiques where anaNature=:nat and anaInactif=0 order by anaCode desc").setString("nat", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      long var6 = 0L;
      if (var5.size() > 0) {
         var6 = ((PlansAnalytiques)var5.get(0)).getAnaId() + 1L;
      } else {
         var6 = 1L;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public PlansAnalytiques rechercheAnal(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PlansAnalytiques where anaNature=:nat and anaCode=:cod and anaInactif=0").setString("nat", var1).setString("cod", var2);
      var5.setMaxResults(1);
      List var6 = var5.list();
      new PlansAnalytiques();
      PlansAnalytiques var7;
      if (var6.size() > 0) {
         var7 = (PlansAnalytiques)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public PlansAnalytiques rechercheAffaire(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlansAnalytiques where (anaNature='6' or anaNature='8' or anaNature='10') and (anaCodeComplet=:cod or anaCode=:cod)").setString("cod", var1);
      var4.setMaxResults(1);
      List var5 = var4.list();
      new PlansAnalytiques();
      PlansAnalytiques var6;
      if (var5.size() > 0) {
         var6 = (PlansAnalytiques)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public PlansAnalytiques devalideAnal(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PlansAnalytiques where anaNature=:nat and anaCode=:cod").setString("nat", var1).setString("cod", var2);
      var5.setMaxResults(1);
      List var6 = var5.list();
      new PlansAnalytiques();
      PlansAnalytiques var7;
      if (var6.size() > 0) {
         var7 = (PlansAnalytiques)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectAnal(String var1, String var2, String var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var6 = true;
      }

      Query var7 = null;
      List var8 = null;
      if (var2 != null) {
         String var9;
         if (var1 != null && !var1.isEmpty() && var1.equals("10")) {
            var9 = "";
            if (var4 != 10 && var4 != 11 && var4 != 12 && var4 != 13 && var4 != 14 && var4 != 15 && var4 != 18) {
               var9 = "(anaAffaireEtat=4)";
            } else {
               var9 = "((anaNature=10 and (anaAffaireEtat=1 or anaAffaireEtat=4 or anaAffaireEtat=5)))";
            }

            if (var2.equals("*")) {
               if (var3 != null && !var3.isEmpty()) {
                  var7 = var5.createQuery("from PlansAnalytiques where (anaNature=6 or anaNature=10) and (anaAnnee=:an or anaAnnee is null or anaAnnee='') and " + var9).setString("an", var3);
               } else {
                  var7 = var5.createQuery("from PlansAnalytiques where (anaNature=6 or anaNature=10) and " + var9);
               }
            } else if (var2.length() >= 2 && var2.contains("*")) {
               String var10 = var2.substring(1);
               if (var3 != null && !var3.isEmpty()) {
                  var7 = var5.createQuery("from PlansAnalytiques where (anaNature=6 or anaNature=10) and (anaAnnee=:an or anaAnnee is null or anaAnnee='') and (anaCode LIKE '%" + var10 + "%' or anaNomFr LIKE '%" + var10 + "% or anaCodeComplet LIKE '" + var10 + "%'') and " + var9).setString("an", var3);
               } else {
                  var7 = var5.createQuery("from PlansAnalytiques where (anaNature=6 or anaNature=10) and (anaCode LIKE '%" + var10 + "%' or anaNomFr LIKE '%" + var10 + "% or anaCodeComplet LIKE '" + var10 + "%'') and " + var9);
               }
            } else if (var3 != null && !var3.isEmpty()) {
               var7 = var5.createQuery("from PlansAnalytiques where (anaNature=6 or anaNature=10) and (anaAnnee=:an or anaAnnee is null or anaAnnee='') and (anaCode LIKE '" + var2 + "%' or anaNomFr LIKE '" + var2 + "%' or anaCodeComplet LIKE '" + var2 + "%') and " + var9).setString("an", var3);
            } else {
               var7 = var5.createQuery("from PlansAnalytiques where (anaNature=6 or anaNature=10) and (anaCode LIKE '" + var2 + "%' or anaNomFr LIKE '" + var2 + "%'  or anaCodeComplet LIKE '" + var2 + "%') and " + var9);
            }
         } else if (var2.equals("*")) {
            if (var3 != null && !var3.isEmpty()) {
               var7 = var5.createQuery("from PlansAnalytiques where anaNature=:nat and (anaAnnee=:an or anaAnnee is null or anaAnnee='') and anaInactif=0").setString("nat", var1).setString("an", var3);
            } else {
               var7 = var5.createQuery("from PlansAnalytiques where anaNature=:nat and anaInactif=0").setString("nat", var1);
            }
         } else if (var2.length() >= 2 && var2.contains("*")) {
            var9 = var2.substring(1);
            if (var3 != null && !var3.isEmpty()) {
               var7 = var5.createQuery("from PlansAnalytiques where anaNature=:nat and (anaAnnee=:an or anaAnnee is null or anaAnnee='') and (anaCode LIKE '%" + var9 + "%' or anaNomFr LIKE '%" + var9 + "%') and anaInactif=0").setString("nat", var1).setString("an", var3);
            } else {
               var7 = var5.createQuery("from PlansAnalytiques where anaNature=:nat and (anaCode LIKE '%" + var9 + "%' or anaNomFr LIKE '%" + var9 + "%') and anaInactif=0").setString("nat", var1);
            }
         } else if (var3 != null && !var3.isEmpty()) {
            var7 = var5.createQuery("from PlansAnalytiques where anaNature=:nat and (anaAnnee=:an or anaAnnee is null or anaAnnee='') and (anaCode LIKE '" + var2 + "%' or anaNomFr LIKE '" + var2 + "%') and anaInactif=0").setString("nat", var1).setString("an", var3);
         } else {
            var7 = var5.createQuery("from PlansAnalytiques where anaNature=:nat and (anaCode LIKE '" + var2 + "%' or anaNomFr LIKE '" + var2 + "%') and anaInactif=0").setString("nat", var1);
         }

         var8 = var7.list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List selectAnalStructure(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var5 = true;
      }

      Query var6 = null;
      List var7 = null;
      if (var2 != null) {
         if (var2.equals("*")) {
            if (var3 != null && !var3.isEmpty()) {
               var6 = var4.createQuery("from PlansAnalytiques where anaNature=9 and anaNatureRepartition=:nat and (anaAnnee=:an or anaAnnee is null or anaAnnee='') and anaInactif=0").setString("nat", var1).setString("an", var3);
            } else {
               var6 = var4.createQuery("from PlansAnalytiques where anaNature=9 and anaNatureRepartition=:nat and anaInactif=0").setString("nat", var1);
            }
         } else if (var2.length() >= 2 && var2.contains("*")) {
            String var8 = var2.substring(1);
            if (var3 != null && !var3.isEmpty()) {
               var6 = var4.createQuery("from PlansAnalytiques where anaNature=9 and anaNatureRepartition=:nat and (anaAnnee=:an or anaAnnee is null or anaAnnee='') and (anaCode LIKE '%" + var8 + "%' or anaNomFr LIKE '%" + var8 + "%') and anaInactif=0").setString("nat", var1).setString("an", var3);
            } else {
               var6 = var4.createQuery("from PlansAnalytiques where anaNature=9 and anaNatureRepartition=:nat and (anaCode LIKE '%" + var8 + "%' or anaNomFr LIKE '%" + var8 + "%') and anaInactif=0").setString("nat", var1);
            }
         } else if (var3 != null && !var3.isEmpty()) {
            var6 = var4.createQuery("from PlansAnalytiques where anaNature=9 and anaNatureRepartition=:nat and (anaAnnee=:an or anaAnnee is null or anaAnnee='') and (anaCode LIKE'" + var2 + "%' or anaNomFr LIKE'" + var2 + "%') and anaInactif=0").setString("nat", var1).setString("an", var3);
         } else {
            var6 = var4.createQuery("from PlansAnalytiques where anaNature=9 and anaNatureRepartition=:nat and (anaCode LIKE'" + var2 + "%' or anaNomFr LIKE'" + var2 + "%') and anaInactif=0").setString("nat", var1);
         }

         var7 = var6.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean existCode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var4 = true;
      }

      boolean var5 = false;
      Query var6 = var3.createQuery("from PlansAnalytiques where anaNature=:nat and anaCode=:cod").setString("nat", var1).setString("cod", var2).setMaxResults(1);
      List var7 = var6.list();
      if (var7.size() > 0) {
         var5 = true;
      } else {
         var5 = false;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesPlansAnalytiques(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var4 = true;
      }

      List var5 = var3.createQuery("from PlansAnalytiques where (anaNature=:nat or anaNatureRepartition=:nat) and (anaAnnee=:an or anaAnnee is null or anaAnnee='') order by anaCode asc").setString("nat", var1).setString("an", var2).list();
      new ArrayList();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesPlansAnalytiques(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      List var4 = var2.createQuery("from PlansAnalytiques where anaNature=:nat order by anaCode asc").setString("nat", var1).list();
      new ArrayList();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheAnalytiqueRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from PlansAnalytiques where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public PlansAnalytiques rechercheAnal(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlansAnalytiques where anaNomFr=:nom").setString("nom", var1).setMaxResults(1);
      List var5 = var4.list();
      new PlansAnalytiques();
      PlansAnalytiques var6;
      if (var5.size() > 0) {
         var6 = (PlansAnalytiques)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesAffaires(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var2 = true;
      }

      List var3 = var1.createQuery("from PlansAnalytiques where anaNature='10' and anaInactif=0 order by anaCode asc").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            var5.add(new SelectItem(((PlansAnalytiques)var4.get(var6)).getAnaCode(), ((PlansAnalytiques)var4.get(var6)).getAnaCode() + ":" + ((PlansAnalytiques)var4.get(var6)).getAnaNomFr()));
         }
      }

      return var5;
   }

   public List chargerLesAffaires(String var1, String var2, String var3, String var4, String var5, int var6, int var7, String var8, long var9, long var11, String var13, Session var14) throws HibernateException, NamingException, ParseException {
      boolean var15 = false;
      if (var14 == null) {
         var14 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var15 = true;
      }

      new ArrayList();
      UtilDate var17 = new UtilDate();
      Criteria var18 = var14.createCriteria(PlansAnalytiques.class);
      Calendar var19 = Calendar.getInstance();
      Date var20 = null;
      Date var21 = null;
      Date var22 = new Date();
      String var23 = var17.dateToStringFr(var22);
      String var24 = var23.substring(6, 10) + "-" + var23.substring(3, 5) + "-" + var23.substring(0, 2);
      var20 = var17.stringToDateSQL(var24 + " 00:00:00");
      var21 = var17.stringToDateSQL(var24 + " 23:59:59");
      int var25 = var22.getYear() + 1900;
      String var26;
      if (var1.equalsIgnoreCase("100")) {
         if (var3 != null && var4 != null) {
            var20 = var17.stringToDateSQL(var3 + " 00:00:00");
            var21 = var17.stringToDateSQL(var4 + " 23:59:59");
            var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
         } else {
            var26 = "1980-01-01";
            var17.stringToDateSQL(var26 + " 00:00:00");
            var18 = var18.add(Restrictions.isNotNull("anaAffaireDateDemande"));
         }
      } else {
         if (!var1.equalsIgnoreCase("12") && !var1.equalsIgnoreCase("13") && !var1.equalsIgnoreCase("14")) {
            var26 = "" + (var20.getYear() + 1900);
            var18 = var18.add(Restrictions.eq("anaAnnee", var26));
         }

         if (var1.equalsIgnoreCase("0")) {
            var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
         } else if (var1.equalsIgnoreCase("1")) {
            var26 = "" + var19.getTime();
            if (var26.contains("Mon")) {
               var20 = var19.getTime();
            } else if (var26.contains("Tue")) {
               var19.add(7, -1);
               var20 = var19.getTime();
            } else if (var26.contains("Wed")) {
               var19.add(7, -2);
               var20 = var19.getTime();
            } else if (var26.contains("Thu")) {
               var19.add(7, -3);
               var20 = var19.getTime();
            } else if (var26.contains("Fri")) {
               var19.add(7, -4);
               var20 = var19.getTime();
            } else if (var26.contains("Sat")) {
               var19.add(7, -5);
               var20 = var19.getTime();
            } else if (var26.contains("Sun")) {
               var19.add(7, -6);
               var20 = var19.getTime();
            }

            var23 = var17.dateToStringFr(var20);
            var24 = var23.substring(6, 10) + "-" + var23.substring(3, 5) + "-" + var23.substring(0, 2);
            var20 = var17.stringToDateSQL(var24 + " 00:00:00");
            var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
         } else {
            String var27;
            int var28;
            if (var1.equalsIgnoreCase("2")) {
               var28 = var19.get(2) + 1;
               var27 = var25 + "-" + var28 + "-01";
               var20 = var17.stringToDateSQL(var27 + " 00:00:00");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("3")) {
               var28 = var19.get(2);
               var19.add(5, -var28);
               if (var28 <= 3) {
                  var27 = var25 + "-01-01";
                  var20 = var17.stringToDateSQL(var27 + " 00:00:00");
               } else if (var28 >= 4 && var28 <= 6) {
                  var27 = var25 + "-04-01";
                  var20 = var17.stringToDateSQL(var27 + " 00:00:00");
               } else if (var28 >= 7 && var28 <= 9) {
                  var27 = var25 + "-07-01";
                  var20 = var17.stringToDateSQL(var27 + " 00:00:00");
               } else if (var28 >= 10) {
                  var27 = var25 + "-10-01";
                  var20 = var17.stringToDateSQL(var27 + " 00:00:00");
               }

               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("4")) {
               var28 = var19.get(2);
               var19.add(5, -var28);
               if (var28 <= 6) {
                  var27 = var25 + "-01-01";
                  var20 = var17.stringToDateSQL(var27 + " 00:00:00");
               } else {
                  var27 = var25 + "-07-01";
                  var20 = var17.stringToDateSQL(var27 + " 00:00:00");
               }

               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("5")) {
               var26 = var25 + "-01-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-03-31";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("6")) {
               var26 = var25 + "-04-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-06-30";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("7")) {
               var26 = var25 + "-07-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-09-30";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("8")) {
               var26 = var25 + "-10-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("9")) {
               var26 = var25 + "-01-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-06-30";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("10")) {
               var26 = var25 + "-07-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("11")) {
               var26 = var25 + "-01-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("12")) {
               var26 = "1980-01-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 - 1 + "-12-31";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("13")) {
               var26 = var25 - 1 + "-01-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("14")) {
               var26 = var25 - 1 + "-01-01";
               var20 = var17.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 - 1 + "-12-31";
               var21 = var17.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("anaAffaireDateDemande", var20, var21));
            } else if (var1.equalsIgnoreCase("20")) {
               var18.setMaxResults(20);
            }
         }
      }

      if (var13 != null && !var13.isEmpty()) {
         var26 = "";
         if (var13.startsWith("*")) {
            var26 = "%" + var13.substring(1) + "%";
         } else {
            var26 = var13 + "%";
         }

         var18 = var18.add(Restrictions.like("anaAffaireNomClient", var26));
      }

      if (var9 != 0L) {
         var18 = var18.add(Restrictions.eq("anaAffaireIdResponsable", var9));
      }

      if (var11 != 0L) {
         var18 = var18.add(Restrictions.eq("anaAffaireIdCommercial", var11));
      }

      if (var6 <= 10) {
         var18 = var18.add(Restrictions.eq("anaAffaireEtat", var6));
      }

      if (var2 != null && !var2.isEmpty()) {
         var26 = "%" + var2 + "%";
         var18 = var18.add(Restrictions.like("anaCodeComplet", var26));
      }

      if (var5 != null && !var5.isEmpty() && !var5.equals("100") && var5.contains(":")) {
         var18 = var18.add(Restrictions.eq("anaAffaireService", var5));
      }

      if (var7 != 99) {
         var18 = var18.add(Restrictions.eq("anaAffaireMode", var7));
      }

      if (var8 != null && !var8.isEmpty()) {
         var18 = var18.add(Restrictions.eq("anaTypeDossier", var8));
      }

      var18 = var18.addOrder(Order.desc("anaAffaireDateDemande"));
      var18 = var18.addOrder(Order.desc("anaCode"));
      List var16 = var18.list();
      if (var15) {
         this.utilInitHibernate.closeSession();
      }

      return var16;
   }

   public List chargerLesAffairesByTiers(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var5 = true;
      }

      String var6 = "";
      if (var3 >= 20 && var3 <= 27) {
         var6 = "(anaAffaireEtat=1 or anaAffaireEtat=4 or anaAffaireEtat=5)";
      } else {
         var6 = "(anaAffaireEtat=4 or anaAffaireEtat=5)";
      }

      List var7 = var4.createQuery("from PlansAnalytiques where anaNature='10' and " + var6 + " and (anaAffaireIdClient=:tie or anaIdTiers=:tie) order by anaCode asc").setLong("tie", var1).list();
      List var8 = var7;
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var9 = new ArrayList();
      if (var7.size() != 0) {
         for(int var10 = 0; var10 < var8.size(); ++var10) {
            if (((PlansAnalytiques)var8.get(var10)).getAnaCode() != null && !((PlansAnalytiques)var8.get(var10)).getAnaCode().isEmpty()) {
               if (((PlansAnalytiques)var8.get(var10)).getAnaTypeDossier() != null && !((PlansAnalytiques)var8.get(var10)).getAnaTypeDossier().isEmpty()) {
                  var9.add(new SelectItem(((PlansAnalytiques)var8.get(var10)).getAnaTypeDossier() + ((PlansAnalytiques)var8.get(var10)).getAnaCode(), ((PlansAnalytiques)var8.get(var10)).getAnaTypeDossier() + ((PlansAnalytiques)var8.get(var10)).getAnaCode()));
               } else {
                  var9.add(new SelectItem(((PlansAnalytiques)var8.get(var10)).getAnaCode(), ((PlansAnalytiques)var8.get(var10)).getAnaCode()));
               }
            }
         }
      } else {
         var9.add(new SelectItem("", "Sans affaire validée"));
      }

      return var9;
   }

   public List chargerLesGroupes(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var2 = true;
      }

      List var3 = var1.createQuery("from PlansAnalytiques where anaNature='7' and anaInactif=0 and anaTiersRegroupe is not null and anaTiersRegroupe<>'' group by anaTiersRegroupe").list();
      List var4 = var3;
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (var3.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (((PlansAnalytiques)var4.get(var6)).getAnaTiersRegroupe() != null && !((PlansAnalytiques)var4.get(var6)).getAnaTiersRegroupe().isEmpty()) {
               var5.add(new SelectItem(((PlansAnalytiques)var4.get(var6)).getAnaTiersRegroupe()));
            }
         }
      }

      return var5;
   }

   public PlansAnalytiques rechercheDestinataire(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "PlansAnalytiques");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PlansAnalytiques where anaNature='7' and anaNomFr=:destin and anaInactif=0").setString("destin", var1).setMaxResults(1);
      List var5 = var4.list();
      new PlansAnalytiques();
      PlansAnalytiques var6;
      if (var5.size() > 0) {
         var6 = (PlansAnalytiques)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
