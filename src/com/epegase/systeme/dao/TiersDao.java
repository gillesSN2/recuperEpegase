package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TiersDao implements Serializable {
   private Tiers tiers;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public TiersDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public Tiers insert(Tiers var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
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

   public Tiers insert(Tiers var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public Tiers modif(Tiers var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
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

   public Tiers modif(Tiers var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delUsers(int var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         Query var4 = var2.createQuery("delete from Users where usr_id =" + var1);
         var4.executeUpdate();
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

   public void delete(Tiers var1, Session var2) {
      var2.delete(var1);
   }

   public String delSite(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      Transaction var4 = var3.beginTransaction();
      var4.begin();
      Query var5 = var3.createQuery("delete from Tiers where sit_id =" + var1);
      var5.executeUpdate();
      var4.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public List selectTiers(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var3 = var2.createQuery("from Tiers where tie_genre='" + var1 + "'").list();
      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List selectTiers() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var2 = var1.createQuery("from Tiers").list();
      new ArrayList();
      this.utilInitHibernate.closeSession();
      return var2;
   }

   public List selectFournisseur() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var2 = var1.createQuery("from Tiers where tietype='0'").list();
      ArrayList var3 = new ArrayList();
      if (var2.size() > 0) {
         for(int var4 = 0; var4 < var2.size(); ++var4) {
            Tiers var5 = (Tiers)var2.get(var4);
            var3.add(var5);
         }
      }

      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List selectTiers(String var1, String var2, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var5 = var4.createQuery("from Tiers where tietype=:param1 and tiegenre=:param2 and tiecategorie=:param3").setParameter("param1", var1).setParameter("param2", var2).setParameter("param3", var3).list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public List selectTiers(String var1, String var2) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      new ArrayList();
      List var4 = var3.createQuery("from Tiers where tietype=:param1 and tiegenre=:param2 ").setParameter("param1", var1).setParameter("param2", var2).list();
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List listeTiers(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var3 = true;
      }

      Object var4 = new ArrayList();
      if (var1 != null && !var1.isEmpty()) {
         var4 = var2.createQuery(var1).list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List selectTiersAnniv(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Date var3 = new Date();
      DateFormat var4 = DateFormat.getDateInstance(3);
      String var5 = var4.format(var3).substring(0, 5);
      List var6 = var1.createQuery("from Tiers where tieanniversaire=:dt or tieanniversairemariage=:dt or tieanniversairedeces=:dt").setString("dt", var5).list();
      ArrayList var7 = new ArrayList();
      if (var6.size() >= 1) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            new Tiers();
            Tiers var9 = (Tiers)var6.get(var8);
            var9.setTietype("");
            var7.add(var9);
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Tiers selectTierD(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var4 = var3.createQuery("from Tiers where tie_id=" + var1).setMaxResults(1).list();
      this.utilInitHibernate.closeSession();
      if (var4.size() > 0) {
         Tiers var5 = (Tiers)var4.get(0);
         return var5;
      } else {
         return null;
      }
   }

   public Tiers selectTierD(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      List var5 = var3.createQuery("from Tiers where tie_id=" + var1).setMaxResults(1).list();
      Tiers var6 = null;
      if (var5.size() > 0) {
         var6 = (Tiers)var5.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Tiers selectTierOlD(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      List var5 = var3.createQuery("from Tiers where tie_id_old=" + var1).setMaxResults(1).list();
      Tiers var6 = null;
      if (var5.size() > 0) {
         var6 = (Tiers)var5.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public Tiers selectTierSigle(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      List var4 = var2.createQuery("from Tiers where tie_sigle='" + var1 + "'").setMaxResults(1).list();
      Tiers var5 = null;
      if (var4.size() > 0) {
         var5 = (Tiers)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public String lastTierSigle(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      List var5 = var3.createQuery("from Tiers where tie_type='" + var1 + "' order by tie_sigle desc").setMaxResults(1).list();
      new ArrayList();
      String var7 = "";
      if (var5.size() != 0) {
         int var8 = ((Tiers)var5.get(0)).getTiesigle().length();
         var7 = ((Tiers)var5.get(0)).getTiesigle().substring(1, var8);
         int var9 = Integer.parseInt(var7);
         ++var9;
         var7 = "" + var9;
      } else {
         var7 = "1";
      }

      if (var7.length() == 1) {
         var7 = "000" + var7;
      } else if (var7.length() == 2) {
         var7 = "00" + var7;
      } else if (var7.length() == 3) {
         var7 = "0" + var7;
      } else if (var7.length() == 4) {
      }

      if (var1.equals("0")) {
         var7 = "P" + var7;
      } else if (var1.equals("3")) {
         var7 = "L" + var7;
      } else {
         var7 = "A" + var7;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public Tiers selectTierCompte(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      List var4 = var2.createQuery("from Tiers where tie_compte_0='" + var1 + "'").setMaxResults(1).list();
      Tiers var5 = null;
      if (var4.size() > 0) {
         var5 = (Tiers)var4.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Tiers selectTierEspaceClient(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      List var5 = var3.createQuery("from Tiers where tie_id_structure=" + var1).setMaxResults(1).list();
      Tiers var6 = null;
      if (var5.size() > 0) {
         var6 = (Tiers)var5.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List selectUserExiste(String var1, long var2) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      List var5 = var4.createQuery("from Users where " + var1 + "=" + var2).list();
      this.utilInitHibernate.closeSession();
      return var5;
   }

   public Tiers logUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      this.tiers = null;
      List var4 = var3.createQuery("from Users where usr_id =" + var1).list();
      if (var4.size() != 0) {
         this.tiers = (Tiers)var4.get(0);
      }

      this.utilInitHibernate.closeSession();
      return this.tiers;
   }

   public List recupererTier() throws HibernateException, NamingException {
      Session var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      Query var2 = var1.createQuery("from Tiers where tietype=:typ and tiecategorie=:four").setString("four", "Bailleur de fonds").setString("typ", "3");
      Object var3 = new ArrayList();
      if (var2.list() != null) {
         var3 = var2.list();
      }

      this.utilInitHibernate.closeSession();
      return (List)var3;
   }

   public List chargerLesTiersByCat(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var5 = true;
      }

      Query var6 = null;
      if (var3 != null && !var3.isEmpty()) {
         if (var3.startsWith("*")) {
            var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four").setString("four", var2).setString("typ", var1);
         } else {
            String var7;
            if (var3.startsWith("*")) {
               var7 = var3.substring(1);
               var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four and tieraisonsocialenom like '" + var7 + "%'").setString("four", var2).setString("typ", var1);
            } else if (var3.endsWith("*")) {
               var7 = var3.replace("*", "");
               var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four and tieraisonsocialenom like '%" + var7 + "%'").setString("four", var2).setString("typ", var1);
            } else {
               var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four and tieraisonsocialenom like '" + var3 + "%'").setString("four", var2).setString("typ", var1);
            }
         }
      } else {
         var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four").setString("four", var2).setString("typ", var1);
      }

      Object var8 = new ArrayList();
      if (var6.list() != null) {
         var8 = var6.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var8;
   }

   public List chargerLesTiersByCat(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("*")) {
            var5 = var3.createQuery("from Tiers where tietype=:typ").setString("typ", var1);
         } else {
            String var6;
            if (var2.startsWith("*")) {
               var6 = var2.substring(1);
               var5 = var3.createQuery("from Tiers where tietype=:typ and tieraisonsocialenom like '" + var6 + "%'").setString("typ", var1);
            } else if (var2.endsWith("*")) {
               var6 = var2.replace("*", "");
               var5 = var3.createQuery("from Tiers where tietype=:typ and tieraisonsocialenom like '%" + var6 + "%'").setString("typ", var1);
            } else {
               var5 = var3.createQuery("from Tiers where tietype=:typ and tieraisonsocialenom like '" + var2 + "%'").setString("typ", var1);
            }
         }
      } else {
         var5 = var3.createQuery("from Tiers where tietype=:typ").setString("typ", var1);
      }

      Object var7 = new ArrayList();
      if (var5.list() != null) {
         var7 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var7;
   }

   public List chargerLesTiersByCatMedical(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var5 = true;
      }

      Query var6 = null;
      String var7;
      if (var2 != null && !var2.isEmpty() && var2.equals("Client société")) {
         if (var3 != null && !var3.isEmpty()) {
            if (var3.startsWith("*")) {
               var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère') ").setString("typ", var1);
            } else if (var3.startsWith("*")) {
               var7 = var3.substring(1);
               var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère') and tieraisonsocialenom like '" + var7 + "%'").setString("typ", var1);
            } else if (var3.endsWith("*")) {
               var7 = var3.replace("*", "");
               var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère') and tieraisonsocialenom like '%" + var7 + "%'").setString("typ", var1);
            } else {
               var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère') and tieraisonsocialenom like '" + var3 + "%'").setString("typ", var1);
            }
         } else {
            var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère')").setString("typ", var1);
         }
      } else if (var2 != null && !var2.isEmpty() && var2.equals("Complémentaire")) {
         if (var3 != null && !var3.isEmpty()) {
            if (var3.startsWith("*")) {
               var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère' or tiecategorie='Assurance' or tiecategorie='IPM' or tiecategorie='Mutuelle/Assurance' or tiecategorie='Mutuelle' or tiecategorie='Complémentaire' or tiecategorie='Programme Médical') ").setString("typ", var1);
            } else if (var3.startsWith("*")) {
               var7 = var3.substring(1);
               var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère' or tiecategorie='Assurance' or tiecategorie='IPM' or tiecategorie='Mutuelle/Assurance' or tiecategorie='Mutuelle' or tiecategorie='Complémentaire' or tiecategorie='Programme Médical') and tieraisonsocialenom like '" + var7 + "%'").setString("typ", var1);
            } else if (var3.endsWith("*")) {
               var7 = var3.replace("*", "");
               var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère' or tiecategorie='Assurance' or tiecategorie='IPM' or tiecategorie='Mutuelle/Assurance' or tiecategorie='Mutuelle' or tiecategorie='Complémentaire' or tiecategorie='Programme Médical') and tieraisonsocialenom like '%" + var7 + "%'").setString("typ", var1);
            } else {
               var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère' or tiecategorie='Assurance' or tiecategorie='IPM' or tiecategorie='Mutuelle/Assurance' or tiecategorie='Mutuelle' or tiecategorie='Complémentaire' or tiecategorie='Programme Médical') and tieraisonsocialenom like '" + var3 + "%'").setString("typ", var1);
            }
         } else {
            var6 = var4.createQuery("from Tiers where tietype=:typ and (tiecategorie='Client société' or tiecategorie='Direction' or tiecategorie='Hôpital' or tiecategorie='Mairie' or tiecategorie='Ministère' or tiecategorie='Assurance' or tiecategorie='IPM' or tiecategorie='Mutuelle/Assurance' or tiecategorie='Mutuelle' or tiecategorie='Complémentaire' or tiecategorie='Programme Médical')").setString("typ", var1);
         }
      } else if (var3 != null && !var3.isEmpty()) {
         if (var3.startsWith("*")) {
            var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four").setString("four", var2).setString("typ", var1);
         } else if (var3.startsWith("*")) {
            var7 = var3.substring(1);
            var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four and tieraisonsocialenom like '" + var7 + "%'").setString("four", var2).setString("typ", var1);
         } else if (var3.endsWith("*")) {
            var7 = var3.replace("*", "");
            var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four and tieraisonsocialenom like '%" + var7 + "%'").setString("four", var2).setString("typ", var1);
         } else {
            var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four and tieraisonsocialenom like '" + var3 + "%'").setString("four", var2).setString("typ", var1);
         }
      } else {
         var6 = var4.createQuery("from Tiers where tietype=:typ and tiecategorie=:four").setString("four", var2).setString("typ", var1);
      }

      Object var8 = new ArrayList();
      if (var6.list() != null) {
         var8 = var6.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var8;
   }

   public List chargerLesTiersByLettre(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Tiers where tieraisonsocialenom like '" + var1 + "%' or tieyahoo like '%" + var1 + "%' or tiemsn like '%" + var1 + "%' or tieaol like '%" + var1 + "%' or tiemail1 like '%" + var1 + "%' or tiemail2 like '%" + var1 + "%' or tiemail3 like '%" + var1 + "%' or tiemail4 like '%" + var1 + "%' or tiemail5 like '%" + var1 + "%' order by tieraisonsocialenom");
      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var5;
   }

   public List chargerLesTiers(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      if (var1 == null || var1.isEmpty()) {
         var1 = "100";
      }

      List var4 = null;
      if (var1.equals("100")) {
         var4 = var2.createQuery("from Tiers where (tietype='0' or tietype='1' or tietype='2' or tietype='3') order by tieraisonsocialenom").list();
      } else if (var1.equals("101")) {
         var4 = var2.createQuery("from Tiers where tietype='0' order by tieraisonsocialenom").list();
      } else if (var1.equals("102")) {
         var4 = var2.createQuery("from Tiers where (tietype='1' or tietype='2' or tietype='3') order by tieraisonsocialenom").list();
      } else {
         var4 = var2.createQuery("from Tiers where tietype='" + var1 + "' order by tieraisonsocialenom").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesTiersPaye(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      if (var2 == null || var2.isEmpty()) {
         var2 = "100";
      }

      List var5 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var2.equals("100")) {
            var5 = var3.createQuery("from Tiers where (tietype='0' or tietype='1' or tietype='2' or tietype='3') order by tieraisonsocialenom").list();
         } else if (var2.equals("101")) {
            var5 = var3.createQuery("from Tiers where tietype='0' order by tieraisonsocialenom").list();
         } else if (var2.equals("102")) {
            var5 = var3.createQuery("from Tiers where (tietype='1' or tietype='2' or tietype='3') order by tieraisonsocialenom").list();
         } else {
            var5 = var3.createQuery("from Tiers where tietype='" + var2 + "' order by tieraisonsocialenom").list();
         }
      } else if (var2.equals("100")) {
         var5 = var3.createQuery("from Tiers where (tietype='0' or tietype='1' or tietype='2' or tietype='3') order by tieid").list();
      } else if (var2.equals("101")) {
         var5 = var3.createQuery("from Tiers where tietype='0' order by tieid").list();
      } else if (var2.equals("102")) {
         var5 = var3.createQuery("from Tiers where (tietype='1' or tietype='2' or tietype='3') order by tieid").list();
      } else {
         var5 = var3.createQuery("from Tiers where tietype='" + var2 + "' order by tieid").list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public Tiers chargerLesTiers(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      if (var1 == null || var1.isEmpty()) {
         var1 = "100";
      }

      List var5 = null;
      if (var1.equals("100")) {
         var5 = var3.createQuery("from Tiers where (tietype='0' or tietype='1' or tietype='2' or tietype='3') and (tieraisonsocialenom=:nom or tiesigle=:nom) and tieetat=0").setString("nom", var2).setMaxResults(1).list();
      } else if (var1.equals("101")) {
         var5 = var3.createQuery("from Tiers where tietype='0' and (tieraisonsocialenom=:nom or tiesigle=:nom) and tieetat=0").setString("nom", var2).setMaxResults(1).list();
      } else if (var1.equals("102")) {
         var5 = var3.createQuery("from Tiers where (tietype='1' or tietype='2' or tietype='3') and (tieraisonsocialenom=:nom or tiesigle=:nom) and tieetat=0").setString("nom", var2).setMaxResults(1).list();
      } else {
         var5 = var3.createQuery("from Tiers where tietype='" + var1 + "' and (tieraisonsocialenom=:nom or tiesigle=:nom) and tieetat=0").setString("nom", var2).setMaxResults(1).list();
      }

      this.tiers = new Tiers();
      if (var5.size() != 0) {
         this.tiers = (Tiers)var5.get(0);
      } else {
         this.tiers = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.tiers;
   }

   public Tiers chargerLesTiers(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var5 = true;
      }

      if (var1 == null || var1.isEmpty()) {
         var1 = "100";
      }

      List var6 = var4.createQuery("from Tiers where tietype='" + var1 + "' and tieidold=:id").setLong("id", var2).setMaxResults(1).list();
      this.tiers = new Tiers();
      if (var6.size() != 0) {
         this.tiers = (Tiers)var6.get(0);
      } else {
         this.tiers = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.tiers;
   }

   public Tiers rechercheLesTiers(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      if (var1 == null || var1.isEmpty()) {
         var1 = "010";
      }

      List var5 = var3.createQuery("from Tiers where tiegenre='" + var1 + "' and tieraisonsocialenom=:nom").setString("nom", var2).setMaxResults(1).list();
      this.tiers = new Tiers();
      if (var5.size() != 0) {
         this.tiers = (Tiers)var5.get(0);
      } else {
         this.tiers = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.tiers;
   }

   public Tiers rechercheLesTiers(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var5 = true;
      }

      if (var1 == null || var1.isEmpty()) {
         var1 = "010";
      }

      List var6 = var4.createQuery("from Tiers where tiegenre='" + var1 + "' and tieraisonsocialenom=:nom and tieprenom=:prenom").setString("nom", var2).setString("prenom", var3).setMaxResults(1).list();
      this.tiers = new Tiers();
      if (var6.size() != 0) {
         this.tiers = (Tiers)var6.get(0);
      } else {
         this.tiers = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.tiers;
   }

   public List chargerLesFactorsItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ and tiecategorie=:fact").setString("fact", "Factor").setString("typ", "0");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      var5.add(new SelectItem(""));
      if (((List)var4).size() != 0) {
         for(int var6 = 0; var6 < ((List)var4).size(); ++var6) {
            Tiers var7 = (Tiers)((List)var4).get(var6);
            if (var7.getTieraisonsocialenom() != null && !var7.getTieraisonsocialenom().isEmpty()) {
               var5.add(new SelectItem(var7.getTieraisonsocialenom()));
            }
         }
      }

      return var5;
   }

   public List chargerLesFactors(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ and tiecategorie=:fact").setString("fact", "Factor").setString("typ", "0");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var4;
   }

   public List chargerLesClientsItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ").setString("typ", "3");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      var5.add(new SelectItem(""));
      if (((List)var4).size() != 0) {
         for(int var6 = 0; var6 < ((List)var4).size(); ++var6) {
            Tiers var7 = (Tiers)((List)var4).get(var6);
            if (var7.getTieraisonsocialenom() != null && !var7.getTieraisonsocialenom().isEmpty()) {
               var5.add(new SelectItem(var7.getTieraisonsocialenom()));
            }
         }
      }

      return var5;
   }

   public List chargerLesProprietairesItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ and (tiegenre='080' or tiegenre='081') order by tieraisonsocialenom").setString("typ", "0");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (((List)var4).size() != 0) {
         for(int var6 = 0; var6 < ((List)var4).size(); ++var6) {
            Tiers var7 = (Tiers)((List)var4).get(var6);
            if (var7.getTieraisonsocialenom() != null && !var7.getTieraisonsocialenom().isEmpty()) {
               if (var7.getTiecivilite() != null && !var7.getTiecivilite().isEmpty()) {
                  if (var7.getTieprenom() != null && !var7.getTieprenom().isEmpty()) {
                     var5.add(new SelectItem(var7.getTieid(), var7.getTieraisonsocialenom() + " " + var7.getTieprenom() + " (" + var7.getTiecivilite() + ")"));
                  } else {
                     var5.add(new SelectItem(var7.getTieid(), var7.getTieraisonsocialenom() + " (" + var7.getTiecivilite() + ")"));
                  }
               } else if (var7.getTieprenom() != null && !var7.getTieprenom().isEmpty()) {
                  var5.add(new SelectItem(var7.getTieid(), var7.getTieraisonsocialenom() + " " + var7.getTieprenom()));
               } else {
                  var5.add(new SelectItem(var7.getTieid(), var7.getTieraisonsocialenom()));
               }
            }
         }
      }

      return var5;
   }

   public List chargerLesClientsByIdItems(int var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Tiers where tietype=:typ order by tieraisonsocialenom").setString("typ", "3");
      Object var5 = new ArrayList();
      if (var4.list() != null) {
         var5 = var4.list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var6 = new ArrayList();
      if (var1 == 0) {
         var6.add(new SelectItem(0, ""));
      }

      if (((List)var5).size() != 0) {
         for(int var7 = 0; var7 < ((List)var5).size(); ++var7) {
            Tiers var8 = (Tiers)((List)var5).get(var7);
            if (var8.getTieraisonsocialenom() != null && !var8.getTieraisonsocialenom().isEmpty()) {
               var6.add(new SelectItem(var8.getTieid(), var8.getTieraisonsocialenom()));
            }
         }
      }

      return var6;
   }

   public List chargerLesTransitaireTransporteurByIdItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ and (tiecategorie='Transitaire' or tiecategorie='Transporteur') order by tieraisonsocialenom").setString("typ", "0");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (((List)var4).size() != 0) {
         for(int var6 = 0; var6 < ((List)var4).size(); ++var6) {
            Tiers var7 = (Tiers)((List)var4).get(var6);
            if (var7.getTieraisonsocialenom() != null && !var7.getTieraisonsocialenom().isEmpty()) {
               var5.add(new SelectItem(var7.getTieid(), var7.getTieraisonsocialenom() + "  (" + var7.getTiecategorie() + ")"));
            }
         }
      }

      return var5;
   }

   public List chargerLesTransporteurByIdItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ and tiecategorie='Transporteur' order by tieraisonsocialenom").setString("typ", "0");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (((List)var4).size() != 0) {
         for(int var6 = 0; var6 < ((List)var4).size(); ++var6) {
            Tiers var7 = (Tiers)((List)var4).get(var6);
            if (var7.getTieraisonsocialenom() != null && !var7.getTieraisonsocialenom().isEmpty()) {
               var5.add(new SelectItem(var7.getTieid(), var7.getTieraisonsocialenom() + "  (" + var7.getTiecategorie() + ")"));
            }
         }
      }

      return var5;
   }

   public List chargerLesTransitaireByIdItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ and tiecategorie='Transitaire' order by tieraisonsocialenom").setString("typ", "0");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      if (((List)var4).size() != 0) {
         for(int var6 = 0; var6 < ((List)var4).size(); ++var6) {
            Tiers var7 = (Tiers)((List)var4).get(var6);
            if (var7.getTieraisonsocialenom() != null && !var7.getTieraisonsocialenom().isEmpty()) {
               var5.add(new SelectItem(var7.getTieid(), var7.getTieraisonsocialenom() + "  (" + var7.getTiecategorie() + ")"));
            }
         }
      }

      return var5;
   }

   public Tiers chargerLeFactorByNom(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      Query var3 = var2.createQuery("from Tiers where tieraisonsocialenom='" + var1 + "' and tietype=0 and tiecategorie='Factor'");
      var3.setMaxResults(1);
      List var4 = var3.list();
      if (var4.size() > 0) {
         Tiers var5 = (Tiers)var4.get(0);
         this.utilInitHibernate.closeSession();
         return var5;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public List chargerLesPrescripteurItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ and tiecategorie=:pres").setString("pres", "Prescripteur").setString("typ", "0");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      var5.add(new SelectItem(""));
      if (((List)var4).size() != 0) {
         for(int var6 = 0; var6 < ((List)var4).size(); ++var6) {
            Tiers var7 = (Tiers)((List)var4).get(var6);
            if (var7.getTieraisonsocialenom() != null && !var7.getTieraisonsocialenom().isEmpty()) {
               var5.add(new SelectItem(var7.getTieraisonsocialenom()));
            }
         }
      }

      return var5;
   }

   public List chargerLesOrganesMedicauxItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ and (tiecategorie= 'Organisme Médical' or  tiecategorie= 'Médecin')").setString("typ", "0");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      var5.add(new SelectItem(""));
      if (((List)var4).size() != 0) {
         for(int var6 = 0; var6 < ((List)var4).size(); ++var6) {
            Tiers var7 = (Tiers)((List)var4).get(var6);
            if (var7.getTieraisonsocialenom() != null && !var7.getTieraisonsocialenom().isEmpty()) {
               var5.add(new SelectItem(var7.getTieraisonsocialenom()));
            }
         }
      }

      return var5;
   }

   public List chargerLesCoproprietairesItems(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where tietype=:typ and tiecategorie=:pres").setString("pres", "Copropriété").setString("typ", "3");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      var5.add(new SelectItem(0, ""));
      if (((List)var4).size() != 0) {
         for(int var6 = 0; var6 < ((List)var4).size(); ++var6) {
            Tiers var7 = (Tiers)((List)var4).get(var6);
            if (var7.getTieraisonsocialenom() != null && !var7.getTieraisonsocialenom().isEmpty()) {
               var5.add(new SelectItem(var7.getTieid(), var7.getTieraisonsocialenom()));
            }
         }
      }

      return var5;
   }

   public List recupererTier(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      Query var3 = var2.createQuery("from Tiers where tieprenom=" + var1);
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      this.utilInitHibernate.closeSession();
      return (List)var4;
   }

   public Tiers lesTiers(String var1, long var2, String var4) throws HibernateException, NamingException {
      Session var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      Query var6 = var5.createQuery("from Tiers where tieid='" + var2 + "' and tietype='" + var1 + "' and tieprenom='" + var4 + "'");
      var6.setMaxResults(1);
      List var7 = var6.list();
      if (var7.size() > 0) {
         Tiers var8 = (Tiers)var7.get(0);
         this.utilInitHibernate.closeSession();
         return var8;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public Tiers tiersCalculDateEchéance(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      new Tiers();
      Query var4 = var2.createQuery("from Tiers where tiecompte0=:compte").setString("compte", var1).setMaxResults(1);
      List var5 = var4.list();
      Tiers var3;
      if (var5.size() > 0) {
         var3 = (Tiers)var5.get(0);
      } else {
         var3 = null;
      }

      this.utilInitHibernate.closeSession();
      return var3;
   }

   public List verifTiers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var5 = true;
      }

      if (var2.isEmpty() || var2.contains("()")) {
         var2 = "(0,1,2,3)";
      }

      String var6 = "";
      if (var3.equals("*")) {
         var6 = "from Tiers where tietype IN" + var2 + " and tieetat=0";
      } else if (var3.contains("*") && var3.length() >= 2) {
         String var7 = var3.substring(1);
         var6 = "from Tiers where tietype IN" + var2 + " and tieetat=0 and (tieraisonsocialenom LIKE '%" + var7 + "%' or tiesigle like '%" + var7 + "%')";
      } else {
         var6 = "from Tiers where tietype IN" + var2 + " and tieetat=0 and (tieraisonsocialenom LIKE '" + var3 + "%' or tiesigle like '" + var3 + "%')";
      }

      if (var1.getUsrTiers() == 1) {
         var6 = var6 + " and tieetat=0 and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var1.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var1.getUsrid() + "))";
      } else if (var1.getUsrTiers() == 2) {
         var6 = var6 + " and tieetat=0 and tieusercreat=" + var1.getUsrid() + " and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var1.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var1.getUsrid() + "))";
      } else if (var1.getUsrTiers() == 3) {
         var6 = var6 + " and tieetat=0 and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var1.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var1.getUsrid() + "))";
      }

      Query var11 = var4.createQuery(var6);
      List var8 = var11.list();
      if (var1.getUsrTiers() == 3 && var8.size() != 0) {
         String var9 = "";

         for(int var10 = 0; var10 < var8.size(); ++var10) {
            if (var9 != null && !var9.isEmpty()) {
               var9 = var9 + "," + ((Tiers)var8.get(var10)).getTieid();
            } else {
               var9 = "" + ((Tiers)var8.get(var10)).getTieid();
            }
         }

         var9 = "(" + var9 + ")";
         ResponsableDao var12 = new ResponsableDao(this.maBase, this.utilInitHibernate);
         var8 = var12.chargerLesResponsables(var1.getUsrid(), var9, var4);
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List verifTiers(long var1, Users var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var7 = true;
      }

      if (var4.isEmpty() || var4.contains("()")) {
         var4 = "(0,1,2,3)";
      }

      String var8 = "";
      if (var5.equals("*")) {
         var8 = "from Tiers where tietype IN" + var4;
      } else if (var5.contains("*") && var5.length() >= 2) {
         String var9 = var5.substring(1);
         var8 = "from Tiers where tietype IN" + var4 + " and (tieraisonsocialenom LIKE '%" + var9 + "%' or tiesigle like '%" + var9 + "%')";
      } else {
         var8 = "from Tiers where tietype IN" + var4 + " and (tieraisonsocialenom LIKE '" + var5 + "%' or tiesigle like '" + var5 + "%')";
      }

      if (var3.getUsrTiers() == 1) {
         var8 = var8 + " and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var3.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var3.getUsrid() + "))";
      } else if (var3.getUsrTiers() == 2) {
         var8 = var8 + " and tieusercreat=" + var3.getUsrid() + " and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var3.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var3.getUsrid() + "))";
      } else if (var3.getUsrTiers() == 3) {
         var8 = var8 + " and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var3.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var3.getUsrid() + "))";
      }

      if (var1 != 0L) {
         var8 = var8 + " and tieidgroupe=" + var1;
      }

      Query var13 = var6.createQuery(var8);
      List var10 = var13.list();
      if (var3.getUsrTiers() == 3 && var10.size() != 0) {
         String var11 = "";

         for(int var12 = 0; var12 < var10.size(); ++var12) {
            if (var11 != null && !var11.isEmpty()) {
               var11 = var11 + "," + ((Tiers)var10.get(var12)).getTieid();
            } else {
               var11 = "" + ((Tiers)var10.get(var12)).getTieid();
            }
         }

         var11 = "(" + var11 + ")";
         ResponsableDao var14 = new ResponsableDao(this.maBase, this.utilInitHibernate);
         var10 = var14.chargerLesResponsables(var3.getUsrid(), var11, var6);
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List chargeTierFournissseurCategorie(Users var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var6 = true;
      }

      if (var2.isEmpty() || var2.contains("()")) {
         var2 = "(0,1)";
      }

      String var7 = "";
      if (var3.equals("*")) {
         var7 = "from Tiers where tiecategorie ='" + var4 + "' and tieetat=0 and tietype IN" + var2;
      } else if (var3.contains("*") && var3.length() >= 2) {
         String var8 = var3.substring(1);
         var7 = "from Tiers where tiecategorie ='" + var4 + "' and tieetat=0 and tietype IN" + var2 + " and tieraisonsocialenom LIKE '%" + var8 + "%'";
      } else {
         var7 = "from Tiers where tiecategorie ='" + var4 + "' and tieetat=0 and tietype IN" + var2 + " and tieraisonsocialenom LIKE '" + var3 + "%'";
      }

      if (var1.getUsrTiers() == 1) {
         var7 = var7 + " and tieetat=0 and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var1.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var1.getUsrid() + "))";
      } else if (var1.getUsrTiers() == 2) {
         var7 = var7 + " and tieetat=0 and tieusercreat=" + var1.getUsrid() + " and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var1.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var1.getUsrid() + "))";
      } else if (var1.getUsrTiers() == 3) {
         var7 = var7 + " and tieetat=0 and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var1.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var1.getUsrid() + "))";
      }

      Query var12 = var5.createQuery(var7);
      List var9 = var12.list();
      if (var1.getUsrTiers() == 3 && var9.size() != 0) {
         String var10 = "";

         for(int var11 = 0; var11 < var9.size(); ++var11) {
            if (var10 != null && !var10.isEmpty()) {
               var10 = var10 + "," + ((Tiers)var9.get(var11)).getTieid();
            } else {
               var10 = "" + ((Tiers)var9.get(var11)).getTieid();
            }
         }

         var10 = "(" + var10 + ")";
         ResponsableDao var13 = new ResponsableDao(this.maBase, this.utilInitHibernate);
         var9 = var13.chargerLesResponsables(var1.getUsrid(), var10, var5);
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargeTierClientCategorie(Users var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var6 = true;
      }

      if (var2.isEmpty() || var2.contains("()")) {
         var2 = "(2,3)";
      }

      String var7 = "";
      if (var3.equals("*")) {
         var7 = "from Tiers where tiecategorie ='" + var4 + "' and tieetat=0 and tietype IN" + var2;
      } else if (var3.contains("*") && var3.length() >= 2) {
         String var8 = var3.substring(1);
         var7 = "from Tiers where tiecategorie ='" + var4 + "' and tieetat=0 and tietype IN" + var2 + " and tieraisonsocialenom LIKE '%" + var8 + "%'";
      } else {
         var7 = "from Tiers where tiecategorie ='" + var4 + "' and tieetat=0 and tietype IN" + var2 + " and tieraisonsocialenom LIKE '" + var3 + "%'";
      }

      if (var1.getUsrTiers() == 1) {
         var7 = var7 + " and tieetat=0 and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var1.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var1.getUsrid() + "))";
      } else if (var1.getUsrTiers() == 2) {
         var7 = var7 + " and tieetat=0 and tieusercreat=" + var1.getUsrid() + " and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var1.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var1.getUsrid() + "))";
      } else if (var1.getUsrTiers() == 3) {
         var7 = var7 + " and tieetat=0 and ((tievisibilite=0) or (tievisibilite=1 and tievisibiliteGrp='" + var1.getUsrCollaboration() + "') or (tievisibilite=2 and tievisibiliteUser=" + var1.getUsrid() + "))";
      }

      Query var12 = var5.createQuery(var7);
      List var9 = var12.list();
      if (var1.getUsrTiers() == 3 && var9.size() != 0) {
         String var10 = "";

         for(int var11 = 0; var11 < var9.size(); ++var11) {
            if (var10 != null && !var10.isEmpty()) {
               var10 = var10 + "," + ((Tiers)var9.get(var11)).getTieid();
            } else {
               var10 = "" + ((Tiers)var9.get(var11)).getTieid();
            }
         }

         var10 = "(" + var10 + ")";
         ResponsableDao var13 = new ResponsableDao(this.maBase, this.utilInitHibernate);
         var9 = var13.chargerLesResponsables(var1.getUsrid(), var10, var5);
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public Tiers chargerTiersByCompte(String var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
      Query var3 = var2.createQuery("from Tiers where tiecompte0='" + var1 + "' and tieetat=0 ").setMaxResults(1);
      List var4 = var3.list();
      if (var4.size() > 0) {
         Tiers var5 = (Tiers)var4.get(0);
         this.utilInitHibernate.closeSession();
         return var5;
      } else {
         this.utilInitHibernate.closeSession();
         return null;
      }
   }

   public Tiers chargerTiersByCompte(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Tiers where tiecompte0='" + var1 + "'").setMaxResults(1);
      List var5 = var4.list();
      if (var5.size() > 0) {
         Tiers var6 = (Tiers)var5.get(0);
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var6;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public Tiers chargerTiersByCompteSage(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var3 = true;
      }

      Query var4 = var2.createQuery("from Tiers where tiecompteSage='" + var1 + "'").setMaxResults(1);
      List var5 = var4.list();
      if (var5.size() > 0) {
         Tiers var6 = (Tiers)var5.get(0);
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return var6;
      } else {
         if (var3) {
            this.utilInitHibernate.closeSession();
         }

         return null;
      }
   }

   public List selectTiersEmail(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Tiers");
         var2 = true;
      }

      List var3 = var1.createQuery("from Tiers where (tiemail1 like '%@%' or tiemail2 like '%@%' or tiemail3 like '%@%' or tiemail4 like '%@%' or tiemail5 like '%@%') ").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesActivitesUtilisees(int var1, boolean var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      Query var5 = null;
      if (var1 == 7) {
         var5 = var3.createQuery("from Tiers where (tietype=1 or tietype=2 or tietype=3) and (tieactivite1 is not null and tieactivite1<>'') group by tieactivite1");
      } else if (var1 == 0) {
         if (!var2) {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='001' or tiegenre='081') and (tieactivite1 is not null and tieactivite1<>'') group by tieactivite1").setInteger("typ", var1);
         } else {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='000' or tiegenre='080') and (tieactivite1 is not null and tieactivite1<>'') group by tieactivite1").setInteger("typ", var1);
         }
      } else if (!var2) {
         var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='011' or tiegenre='021' or tiegenre='031') and (tieactivite1 is not null and tieactivite1<>'') group by tieactivite1").setInteger("typ", var1);
      } else {
         var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='010' or tiegenre='020' or tiegenre='030') and (tieactivite1 is not null and tieactivite1<>'') group by tieactivite1").setInteger("typ", var1);
      }

      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      ArrayList var7 = new ArrayList();
      var7.add(new SelectItem(""));
      int var8;
      Tiers var9;
      if (((List)var6).size() != 0) {
         for(var8 = 0; var8 < ((List)var6).size(); ++var8) {
            var9 = (Tiers)((List)var6).get(var8);
            var7.add(new SelectItem(var9.getTieactivite1()));
         }
      }

      if (var1 == 7) {
         var5 = var3.createQuery("from Tiers where (tietype=1 or tietype=2 or tietype=3) and (tieactivite2 is not null and tieactivite2<>'') group by tieactivite2");
      } else if (var1 == 0) {
         if (!var2) {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='001' or tiegenre='081') and (tieactivite2 is not null and tieactivite2<>'') group by tieactivite2").setInteger("typ", var1);
         } else {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='000' or tiegenre='080') and (tieactivite2 is not null and tieactivite2<>'') group by tieactivite2").setInteger("typ", var1);
         }
      } else if (!var2) {
         var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='011' or tiegenre='021' or tiegenre='031') and (tieactivite2 is not null and tieactivite2<>'') group by tieactivite2").setInteger("typ", var1);
      } else {
         var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='010' or tiegenre='020' or tiegenre='030') and (tieactivite2 is not null and tieactivite2<>'') group by tieactivite2").setInteger("typ", var1);
      }

      ((List)var6).clear();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      boolean var10;
      int var11;
      if (((List)var6).size() != 0) {
         for(var8 = 0; var8 < ((List)var6).size(); ++var8) {
            var9 = (Tiers)((List)var6).get(var8);
            var10 = false;
            if (var7.size() != 0) {
               for(var11 = 0; var11 < var7.size(); ++var11) {
                  if (((SelectItem)var7.get(var11)).getValue().toString().equals(var9.getTieactivite2())) {
                     var10 = true;
                     break;
                  }
               }
            }

            if (!var10) {
               var7.add(new SelectItem(var9.getTieactivite2()));
            }
         }
      }

      if (var1 == 1 || var1 == 2) {
         if (var1 == 7) {
            var5 = var3.createQuery("from Tiers where (tietype=1 or tietype=2 or tietype=3) and (tieprofession is not null and tieprofession<>'') group by tieprofession");
         } else if (var1 == 0) {
            if (!var2) {
               var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='001' or tiegenre='081') and (tieprofession is not null and tieprofession<>'') group by tieprofession").setInteger("typ", var1);
            } else {
               var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='000' or tiegenre='080') and (tieprofession is not null and tieprofession<>'') group by tieprofession").setInteger("typ", var1);
            }
         } else if (!var2) {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='011' or tiegenre='021' or tiegenre='031') and (tieprofession is not null and tieprofession<>'') group by tieprofession").setInteger("typ", var1);
         } else {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='010' or tiegenre='020' or tiegenre='030') and (tieprofession is not null and tieprofession<>'') group by tieprofession").setInteger("typ", var1);
         }

         ((List)var6).clear();
         if (var5.list() != null) {
            var6 = var5.list();
         }

         if (((List)var6).size() != 0) {
            for(var8 = 0; var8 < ((List)var6).size(); ++var8) {
               var9 = (Tiers)((List)var6).get(var8);
               var10 = false;
               if (var7.size() != 0) {
                  for(var11 = 0; var11 < var7.size(); ++var11) {
                     if (((SelectItem)var7.get(var11)).getValue().toString().equals(var9.getTieprofession())) {
                        var10 = true;
                        break;
                     }
                  }
               }

               if (!var10) {
                  var7.add(new SelectItem(var9.getTieprofession()));
               }
            }
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesObservationsUtilisees(int var1, boolean var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      Query var5 = null;
      if (var1 == 7) {
         var5 = var3.createQuery("from Tiers where (tietype=1 or tietype=2 or tietype=3) and (tieobservations is not null and tieobservations<>'') group by tieobservations");
      } else if (var1 == 0) {
         if (!var2) {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='001' or tiegenre='081') and (tieobservations is not null and tieobservations<>'') group by tieobservations").setInteger("typ", var1);
         } else {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='000' or tiegenre='080') and (tieobservations is not null and tieobservations<>'') group by tieobservations").setInteger("typ", var1);
         }
      } else if (!var2) {
         var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='011' or tiegenre='021' or tiegenre='031') and (tieobservations is not null and tieobservations<>'') group by tieobservations").setInteger("typ", var1);
      } else {
         var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='010' or tiegenre='020' or tiegenre='030') and (tieobservations is not null and tieobservations<>'') group by tieobservations").setInteger("typ", var1);
      }

      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      var7.add(new SelectItem(""));
      if (((List)var6).size() != 0) {
         for(int var8 = 0; var8 < ((List)var6).size(); ++var8) {
            Tiers var9 = (Tiers)((List)var6).get(var8);
            var7.add(new SelectItem(var9.getTieobservations()));
         }
      }

      return var7;
   }

   public List chargerLesPaysUtilisees(int var1, boolean var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var4 = true;
      }

      Query var5 = null;
      if (var1 == 99) {
         var5 = var3.createQuery("from Tiers where (tienompays is not null and tienompays<>'') group by tienompays");
      } else if (var1 == 7) {
         var5 = var3.createQuery("from Tiers where (tietype=1 or tietype=2 or tietype=3) and (tienompays is not null and tienompays<>'') group by tienompays");
      } else if (var1 == 0) {
         if (!var2) {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='001' or tiegenre='081') and (tienompays is not null and tienompays<>'') group by tienompays").setInteger("typ", var1);
         } else {
            var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='000' or tiegenre='080') and (tienompays is not null and tienompays<>'') group by tienompays").setInteger("typ", var1);
         }
      } else if (!var2) {
         var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='011' or tiegenre='021' or tiegenre='031') and (tienompays is not null and tienompays<>'') group by tienompays").setInteger("typ", var1);
      } else {
         var5 = var3.createQuery("from Tiers where tietype=:typ and (tiegenre='010' or tiegenre='020' or tiegenre='030') and (tienompays is not null and tienompays<>'') group by tienompays").setInteger("typ", var1);
      }

      Object var6 = new ArrayList();
      if (var5.list() != null) {
         var6 = var5.list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var7 = new ArrayList();
      var7.add(new SelectItem(""));
      if (((List)var6).size() != 0) {
         for(int var8 = 0; var8 < ((List)var6).size(); ++var8) {
            Tiers var9 = (Tiers)((List)var6).get(var8);
            var7.add(new SelectItem(var9.getTienompays()));
         }
      }

      return var7;
   }

   public List chargerLesTiersFC(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var2 = true;
      }

      Query var3 = var1.createQuery("from Tiers where (tietype=0 or tietype=3) order by tieraisonsocialenom");
      Object var4 = new ArrayList();
      if (var3.list() != null) {
         var4 = var3.list();
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      ArrayList var5 = new ArrayList();
      String var6 = "";
      if (((List)var4).size() != 0) {
         for(int var7 = 0; var7 < ((List)var4).size(); ++var7) {
            Tiers var8 = (Tiers)((List)var4).get(var7);
            if (var8.getTieprenom() != null && !var8.getTieprenom().isEmpty()) {
               var6 = var8.getTiecivilite() + " " + var8.getTieraisonsocialenom() + " " + var8.getTieprenom();
            } else {
               var6 = var8.getTieraisonsocialenom();
            }

            var5.add(new SelectItem(var8.getTieid(), var6));
         }
      }

      return var5;
   }

   public String lastTierAgenceMF(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "");
         var3 = true;
      }

      List var4 = var2.createQuery("from Tiers where tie_type='3' and tie_pdv='" + var1 + "'").list();
      new ArrayList();
      String var6 = "";
      if (var4.size() != 0) {
         int var7 = var4.size();
         ++var7;
         var6 = "" + var7;
      } else {
         var6 = "1";
      }

      if (var6.length() == 1) {
         var6 = "0000000000" + var6;
      } else if (var6.length() == 2) {
         var6 = "000000000" + var6;
      } else if (var6.length() == 3) {
         var6 = "00000000" + var6;
      } else if (var6.length() == 4) {
         var6 = "0000000" + var6;
      } else if (var6.length() == 5) {
         var6 = "000000" + var6;
      } else if (var6.length() == 6) {
         var6 = "00000" + var6;
      } else if (var6.length() == 7) {
         var6 = "0000" + var6;
      } else if (var6.length() == 8) {
         var6 = "000" + var6;
      } else if (var6.length() == 9) {
         var6 = "00" + var6;
      } else if (var6.length() == 10) {
         var6 = "0" + var6;
      } else if (var6.length() == 11) {
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
