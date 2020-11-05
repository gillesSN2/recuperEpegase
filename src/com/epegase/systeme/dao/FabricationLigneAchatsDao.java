package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class FabricationLigneAchatsDao implements Serializable {
   private FabricationLigneAchats fabricationLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FabricationLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FabricationLigneAchats insertLigne(FabricationLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FabricationLigneAchats modifLigne(FabricationLigneAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(FabricationLigneAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from FabricationLigneAchats where fabligId =" + var1.getFabligId());
      var3.executeUpdate();
      return null;
   }

   public String deleteAllLigne(FabricationEnteteAchats var1, Session var2) {
      var2.createQuery("delete from FabricationLigneAchats where fabricationEnteteAchats=:id").setLong("id", var1.getFabId()).executeUpdate();
      return "";
   }

   public List chargerLesLignes(FabricationEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProcessAchats");
         var3 = true;
      }

      List var4 = var2.createQuery("from FabricationLigneAchats where fabricationEnteteAchats=:idfk").setLong("idfk", var1.getFabId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from FabricationLigneAchats where fabricationEnteteAchats.fabligCode='" + var1 + "' and fabricationEnteteAchats.fabligDepot='" + var2 + "' and fabricationEnteteAchats.fabDate >'" + var3 + "' order desc by fabricationEnteteAchats.fabDate").list();
      return var5;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = " (fabligType=1 or fabligType=2 or fabligType = 3) and ";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " fabricationEnteteAchats.fabSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " fabricationEnteteAchats.fabActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " fabricationEnteteAchats.fabService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " fabligDepot='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " fabricationEnteteAchats.fabIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("from FabricationLigneAchats where " + var12 + " fabligCode in " + var2 + " and fabricationEnteteAchats.fabDate between '" + var8 + "' and '" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("from FabricationLigneAchats where " + var12 + " fabligCode='" + var2 + "' and fabricationEnteteAchats.fabDate between '" + var8 + "' and '" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("from FabricationLigneAchats where " + var12 + " fabricationEnteteAchats.fabDate between '" + var8 + "' and '" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, String var2, long var3, Session var5) {
      List var6 = null;
      if (var3 != 0L) {
         var6 = var5.createQuery("from FabricationLigneAchats where (fabligType=1 or fabligType=2 or fabligType = 3) and fabligCode='" + var1 + "' and fabricationEnteteAchats.fabDepot='" + var2 + "' and fabricationEnteteAchats.fabIdEquipe=" + var3 + " order by fabricationEnteteAchats.fabDate DESC").list();
      } else {
         var6 = var5.createQuery("from FabricationLigneAchats where (fabligType=1 or fabligType=2 or fabligType = 3) and fabligCode='" + var1 + "' and fabricationEnteteAchats.fabDepot='" + var2 + "' order by fabricationEnteteAchats.fabDate DESC").list();
      }

      return var6;
   }

   public List rechercheFabricationRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProcessAchats");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FabricationLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FabricationLigneAchats rechercheFabrication(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ProcessAchats");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.fabricationLigneAchats = new FabricationLigneAchats();
      var6 = var3.createQuery("from FabricationLigneAchats where fabligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.fabricationLigneAchats = (FabricationLigneAchats)var6.get(0);
      } else {
         this.fabricationLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.fabricationLigneAchats;
   }

   public List chargerLesLignesFabricationValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var3 != null && var4 != null) {
         if (var2 != null && !var2.isEmpty()) {
            if (var4 == null) {
               var6 = var5.createQuery("from FabricationLigneAchats where fabligCode='" + var1 + "' and fabligDepot='" + var2 + "' and fabricationEnteteAchats.fabDate >=:d1").setDate("d1", var3).list();
            } else {
               var6 = var5.createQuery("from FabricationLigneAchats where fabligCode='" + var1 + "' and fabligDepot='" + var2 + "' and fabricationEnteteAchats.fabDate >=:d1 and fabricationEnteteAchats.fabDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
            }
         } else if (var4 == null) {
            var6 = var5.createQuery("from FabricationLigneAchats where fabligCode='" + var1 + "' and fabricationEnteteAchats.fabDate >=:d1").setDate("d1", var3).list();
         } else {
            var6 = var5.createQuery("from FabricationLigneAchats where fabligCode='" + var1 + "' and fabricationEnteteAchats.fabDate >=:d1 and fabricationEnteteAchats.fabDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
         }
      } else if (var2 != null && !var2.isEmpty()) {
         var6 = var5.createQuery("from FabricationLigneAchats where fabligCode='" + var1 + "' and fabligDepot='" + var2 + "'").list();
      } else {
         var6 = var5.createQuery("from FabricationLigneAchats where fabligCode='" + var1 + "'").list();
      }

      return var6;
   }

   public List chargerLesLignesFab(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ProcessAchats");
         var3 = true;
      }

      List var4 = var2.createQuery("from FabricationLigneAchats where fabricationEnteteAchats.fabNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
