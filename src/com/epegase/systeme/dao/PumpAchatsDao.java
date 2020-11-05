package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.PumpAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class PumpAchatsDao implements Serializable {
   private PumpAchats pumpAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public PumpAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public PumpAchats insert(PumpAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public PumpAchats modif(PumpAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(PumpAchats var1, Session var2) {
      var2.delete(var1);
   }

   public void deleteListe(List var1, Session var2) {
      if (var1.size() != 0) {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            this.pumpAchats = new PumpAchats();
            this.pumpAchats = (PumpAchats)var1.get(var3);
            var2.delete(this.pumpAchats);
         }
      }

   }

   public List chargePump(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PumpAchats");
         var4 = true;
      }

      List var5 = var3.createQuery("from PumpAchats where exercicesachats=:exo order by pumDate").setLong("exo", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public PumpAchats chargePumpByIdDoc(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PumpAchats");
         var5 = true;
      }

      PumpAchats var6 = null;
      new ArrayList();
      Query var8 = var4.createQuery("from PumpAchats where  pumIdDocOrigine=:id and pumNatureOrigine=:nat").setLong("id", var1).setInteger("nat", var3).setMaxResults(1);
      if (var8 != null) {
         List var7 = var8.list();
         if (var7.size() != 0) {
            var6 = (PumpAchats)var7.get(0);
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargePumpByIdDocList(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PumpAchats");
         var5 = true;
      }

      Object var6 = new ArrayList();
      Query var7 = var4.createQuery("from PumpAchats where  pumIdDocOrigine=:id and pumNatureOrigine=:nat").setLong("id", var1).setInteger("nat", var3);
      if (var7 != null) {
         var6 = var7.list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var6;
   }

   public PumpAchats chargePumpByIdDocLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PumpAchats");
         var4 = true;
      }

      new ArrayList();
      this.pumpAchats = new PumpAchats();
      Query var6 = var3.createQuery("from PumpAchats where pumIdLigneOrigine=:id").setLong("id", var1).setMaxResults(1);
      if (var6 != null) {
         List var5 = var6.list();
         if (var5.size() != 0) {
            this.pumpAchats = (PumpAchats)var5.get(0);
         } else {
            this.pumpAchats = null;
         }
      } else {
         this.pumpAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.pumpAchats;
   }

   public PumpAchats chargePumpByIdDocLigne(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "PumpAchats");
         var5 = true;
      }

      new ArrayList();
      this.pumpAchats = new PumpAchats();
      Query var7 = var4.createQuery("from PumpAchats where pumIdLigneOrigine=:id and pumNatureOrigine=:nat").setLong("id", var1).setInteger("nat", var3).setMaxResults(1);
      if (var7 != null) {
         List var6 = var7.list();
         if (var6.size() != 0) {
            this.pumpAchats = (PumpAchats)var6.get(0);
         } else {
            this.pumpAchats = null;
         }
      } else {
         this.pumpAchats = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.pumpAchats;
   }

   public PumpAchats chargePumpByIdDoc(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PumpAchats");
         var4 = true;
      }

      new ArrayList();
      this.pumpAchats = new PumpAchats();
      Query var6 = var3.createQuery("from PumpAchats where pumIdDocOrigine=:id").setLong("id", var1).setMaxResults(1);
      if (var6 != null) {
         List var5 = var6.list();
         if (var5.size() != 0) {
            this.pumpAchats = (PumpAchats)var5.get(0);
         } else {
            this.pumpAchats = null;
         }
      } else {
         this.pumpAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.pumpAchats;
   }

   public List chargePumpByProdDep(String var1, String var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "PumpAchats");
         var6 = true;
      }

      List var7 = var5.createQuery("from PumpAchats where exercicesachats=:exo and pumProduit=:prd and pumDepot=:dep order by pumDate").setString("prd", var1).setString("dep", var2).setLong("exo", var3).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, Session var5) {
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         var6 = var5.createQuery("from PumpAchats where pumProduit=:prd and pumDepot=:dep and pumDate between '" + var3 + "' and '" + var4 + "' order by pumDate").setString("dep", var2).setString("prd", var1).list();
      } else {
         var6 = var5.createQuery("from PumpAchats where pumProduit=:prd and pumDate between '" + var3 + "' and '" + var4 + "' order by pumDate").setString("prd", var1).list();
      }

      return var6;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = var2.createQuery("from PumpAchats where pumProduit=:prd order by pumDate").setString("prd", var1).list();
      return var3;
   }

   public List chargerLesMvtsReception(String var1, String var2, Session var3) {
      List var4 = null;
      if (var2 != null && !var2.isEmpty()) {
         String var5 = "";
         if (var2.contains(":")) {
            String[] var6 = var2.split(":");
            var5 = var6[0];
         } else {
            var5 = var2;
         }

         var4 = var3.createQuery("from PumpAchats where pumNatureOrigine=13 and pumProduit=:prd and pumDepot=:dep order by pumDate").setString("dep", var5).setString("prd", var1).list();
      } else {
         var4 = var3.createQuery("from PumpAchats where pumNatureOrigine=13 and pumProduit=:prd order by pumDate").setString("prd", var1).list();
      }

      return var4;
   }

   public PumpAchats chargeDernierPumpByProdDep(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "PumpAchats");
         var4 = true;
      }

      new PumpAchats();
      List var6 = var3.createQuery("from PumpAchats where pumProduit=:prd and pumDepot=:dep order by pumDate DESC").setString("prd", var1).setString("dep", var2).setMaxResults(1).list();
      PumpAchats var5;
      if (var6.size() != 0) {
         var5 = (PumpAchats)var6.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
