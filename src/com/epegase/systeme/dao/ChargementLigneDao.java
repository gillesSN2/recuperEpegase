package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ChargementEntete;
import com.epegase.systeme.classe.ChargementLigne;
import com.epegase.systeme.classe.Tiers;
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

public class ChargementLigneDao implements Serializable {
   private ChargementLigne chargementLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ChargementLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public List chargerLesLignes(ChargementEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ChargementLigne where ChargementEntete=:idfk order by chaligOrdre, chaligId").setLong("idfk", var1.getChamobId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " ChargementEntete.chamobSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " ChargementEntete.chamobActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " ChargementEntete.chamobService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " chaligDepotCharg='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " ChargementEntete.chamobIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select ChargementEntete.chamobEtat,ChargementEntete.chamobNum,ChargementEntete.chamobSerie,ChargementEntete.chamobIdEquipe,ChargementEntete.chamobDate,chaligId,chaligRechargement,chaligDepotCharg,chaligCode,chaligFamille,chaligLibelle,chaligQteCharg,chaligQteRetour,chaligPu,chaligPt,chaligPump,chaligPoidsBrut from ChargementLigne where " + var12 + " chaligCode in " + var2 + " and ChargementEntete.chamobDate>='" + var8 + "' and ChargementEntete.chamobDate<='" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select ChargementEntete.chamobEtat,ChargementEntete.chamobNum,ChargementEntete.chamobSerie,ChargementEntete.chamobIdEquipe,ChargementEntete.chamobDate,chaligId,chaligRechargement,chaligDepotCharg,chaligCode,chaligFamille,chaligLibelle,chaligQteCharg,chaligQteRetour,chaligPu,chaligPt,chaligPump,chaligPoidsBrut from ChargementLigne where " + var12 + " chaligCode='" + var2 + "' and ChargementEntete.chamobDate>='" + var8 + "' and ChargementEntete.chamobDate<='" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select ChargementEntete.chamobEtat,ChargementEntete.chamobNum,ChargementEntete.chamobSerie,ChargementEntete.chamobIdEquipe,ChargementEntete.chamobDate,chaligId,chaligRechargement,chaligDepotCharg,chaligCode,chaligFamille,chaligLibelle,chaligQteCharg,chaligQteRetour,chaligPu,chaligPt,chaligPump,chaligPoidsBrut from ChargementLigne where " + var12 + " ChargementEntete.chamobDate>='" + var8 + "' and ChargementEntete.chamobDate<='" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from ChargementLigne where chaligCode='" + var1 + "'").list();
      return var3;
   }

   public void saveLigne(List var1, ChargementEntete var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         ChargementLigne var5 = (ChargementLigne)var1.get(var4);
         var5.setChargementEntete(var2);
         var3.save(var5);
      }

   }

   public void duppliquerLigne(List var1, ChargementEntete var2, Session var3) {
   }

   public String deleteAllLigne(ChargementEntete var1, Session var2) {
      var2.createQuery("delete from ChargementLigne where ChargementEntete=:id").setLong("id", var1.getChamobId()).executeUpdate();
      return "";
   }

   public void deleteAllLigne(List var1, Session var2) {
      for(int var3 = 0; var3 < var1.size(); ++var3) {
         ChargementLigne var4 = (ChargementLigne)var1.get(var3);
         var2.delete(var4);
      }

   }

   public ChargementLigne insert(ChargementLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
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

   public ChargementLigne insert(ChargementLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ChargementLigne modif(ChargementLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
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

   public ChargementLigne modif(ChargementLigne var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public ChargementLigne delete(ChargementLigne var1, Session var2) {
      var2.delete(var1);
      return var1;
   }

   public String deleteOneLigne(ChargementLigne var1, Session var2) {
      Query var3 = var2.createQuery("delete from ChargementLigne where chaligId =" + var1.getChaligId());
      var3.executeUpdate();
      return null;
   }

   public float chargerLesReliquatsBesoinVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from ChargementLigne where chaligIdBes=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((ChargementLigne)var6.get(var8)).getChaligQteCharg();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ChargementLigne where chargementEntete.tiers.tieid=" + var1.getTieid() + " and chargementEntete.chamobDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public float chargerLesReliquatsCommandeVtes(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
      List var4 = var3.createQuery("from ChargementLigne where chaligIdBcm=" + var1).list();
      List var5 = var4;
      float var6 = 0.0F;
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6 += ((ChargementLigne)var5.get(var7)).getChaligQteCharg();
         }
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from ChargementLigne where chaligCode='" + var1 + "' and chaligDepot='" + var2 + "' and chargementEntete.chamobDate >'" + var3 + "'").list();
      return var5;
   }

   public List rechercheLivraisonRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ChargementLigne where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ChargementLigne rechercheChargement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.chargementLigne = new ChargementLigne();
      var6 = var3.createQuery("from ChargementLigne where chaligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.chargementLigne = (ChargementLigne)var6.get(0);
      } else {
         this.chargementLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.chargementLigne;
   }
}
