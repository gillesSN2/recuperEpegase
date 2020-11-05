package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ReacheminementEnteteAchats;
import com.epegase.systeme.classe.ReacheminementLigneAchats;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReacheminementLigneAchatsDao implements Serializable {
   private ReacheminementLigneAchats reacheminementLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ReacheminementLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ReacheminementLigneAchats insertLigne(ReacheminementLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReacheminementLigneAchats modifLigne(ReacheminementLigneAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
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

   public ReacheminementLigneAchats modifLigne(ReacheminementLigneAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteAllLigne(ReacheminementEnteteAchats var1, Session var2) {
      var2.createQuery("delete from ReacheminementLigneAchats where reacheminementEnteteAchats=:id").setLong("id", var1.getReaId()).executeUpdate();
   }

   public void deleteOneLigne(ReacheminementLigneAchats var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerLesLignes(ReacheminementEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReacheminementLigneAchats where reacheminementEnteteAchats=:idfk").setLong("idfk", var1.getReaId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from ReacheminementLigneAchats where realigCode='" + var1 + "' and realigDepot='" + var2 + "' and reacheminementEnteteAchats.reaDate >'" + var3 + "' order desc by reacheminementEnteteAchats.reaDate").list();
      return var5;
   }

   public List chargerLesLignesReacheminement(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReacheminementLigneAchats where reacheminementEnteteAchats.reaNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, Session var6) {
      List var7 = null;
      String var8 = "";
      if (var1 != null && !var1.isEmpty()) {
         var8 = var8 + " reacheminementEnteteAchats.reaSerie='" + var1 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var8 = var8 + " recligDepot='" + var3 + "' and ";
      }

      var7 = var6.createQuery("select reacheminementEnteteAchats.reaEtat,reacheminementEnteteAchats.reaNum,reacheminementEnteteAchats.reaDiversNom,reacheminementEnteteAchats.reaNomTiers,reacheminementEnteteAchats.reaDate,reacheminementEnteteAchats.reaDevise,recligId,recligDepot,recligCode,recligFamille,recligLibelle,recligQte,recligQteUtil,recligPu,recligPt,recligPrU,recligPump,recligPoidsBrut,reacheminementEnteteAchats.reaObject,reacheminementEnteteAchats.reaAnal4,reacheminementEnteteAchats.reaCoefDevise,recligCoefPr,recligPrKg from ReacheminementLigneAchats where " + var8 + " recligCode='" + var2 + "' and reacheminementEnteteAchats.reaDate between '" + var4 + "' and '" + var5 + "'").list();
      return var7;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from ReacheminementLigneAchats where realigCode='" + var1 + "'").list();
      return var3;
   }

   public float chargerLesReliquatsCommandeAchs(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from ReacheminementLigneAchats where realigIdCmd=:idCmd").setLong("idCmd", var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((ReacheminementLigneAchats)var6.get(var8)).getRealigOrigQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsReceptionAchs(long var1, int var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var5 = true;
      }

      List var6 = var4.createQuery("from ReacheminementLigneAchats where realigIdRec=:idRec").setLong("idRec", var1).list();
      List var7 = var6;
      float var8 = 0.0F;
      if (var6.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            if (var3 == 0) {
               var8 += ((ReacheminementLigneAchats)var7.get(var9)).getRealigOrigPoidsBrut();
            } else if (var3 == 1) {
               var8 += (float)((ReacheminementLigneAchats)var7.get(var9)).getRealigOrigNbSac();
            } else if (var3 == 2) {
               var8 += ((ReacheminementLigneAchats)var7.get(var9)).getRealigOrigQte();
            }
         }
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheReacheminementRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ReacheminementLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ReacheminementLigneAchats where reacheminementEnteteAchats.tiers.tieid=" + var1.getTieid() + " and reacheminementEnteteAchats.reaDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ReacheminementLigneAchats where reacheminementEnteteAchats.reaIdResponsable=" + var1.getUsrid() + " and reacheminementEnteteAchats.reaDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesLignes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReacheminementLigneAchats where realigSommier=:som").setString("som", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ReacheminementLigneAchats rechercheBefore(Date var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var5 = true;
      }

      new ArrayList();
      List var7 = var4.createQuery("from ReacheminementLigneAchats where realigCode =:prd and realigDepot =:dep and reacheminementEnteteAchats.reaDate <'" + var1 + "' order by reacheminementEnteteAchats.reaDate").setString("prd", var2).setString("dep", var3).setMaxResults(1).list();
      if (var7.size() != 0) {
         this.reacheminementLigneAchats = (ReacheminementLigneAchats)var7.get(0);
      } else {
         this.reacheminementLigneAchats = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.reacheminementLigneAchats;
   }

   public ReacheminementLigneAchats rechercheNext(Date var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var5 = true;
      }

      new ArrayList();
      List var7 = var4.createQuery("from ReacheminementLigneAchats where recligCode =:prd and realigDepot =:dep and reacheminementEnteteAchats.reaDate >'" + var1 + "' order by reacheminementEnteteAchats.reaDate").setString("prd", var2).setString("dep", var3).setMaxResults(1).list();
      if (var7.size() != 0) {
         this.reacheminementLigneAchats = (ReacheminementLigneAchats)var7.get(0);
      } else {
         this.reacheminementLigneAchats = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.reacheminementLigneAchats;
   }

   public ReacheminementLigneAchats rechercheReacheminement(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReacheminementLightEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.reacheminementLigneAchats = new ReacheminementLigneAchats();
      var6 = var3.createQuery("from ReacheminementLigneAchats where realigId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.reacheminementLigneAchats = (ReacheminementLigneAchats)var6.get(0);
      } else {
         this.reacheminementLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.reacheminementLigneAchats;
   }
}
