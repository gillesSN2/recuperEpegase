package com.epegase.systeme.dao;

import com.epegase.systeme.classe.InventaireEntete;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class InventaireLigneDao implements Serializable {
   private InventaireLigne inventaireLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public InventaireLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public InventaireLigne insertLigne(InventaireLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public InventaireLigne modifLigne(InventaireLigne var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(InventaireLigne var1, Session var2) {
      Query var3 = var2.createQuery("delete from InventaireLigne where invligId =" + var1.getInvligId());
      var3.executeUpdate();
      return null;
   }

   public String deleteAllLigne(InventaireEntete var1, Session var2) {
      var2.createQuery("delete from InventaireLigne where inventaireEntete=:id").setLong("id", var1.getInvId()).executeUpdate();
      return "";
   }

   public void saveLigne(List var1, InventaireEntete var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         InventaireLigne var5 = (InventaireLigne)var1.get(var4);
         var5.setInventaireEntete(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(InventaireEntete var1, Session var2) {
      List var3 = var2.createQuery("from InventaireLigne where inventaireEntete=:idfk").setLong("idfk", var1.getInvId()).list();
      return var3;
   }

   public List chargerLesLignesInv(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from InventaireLigne where inventaireEntete.invNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var4 == null) {
            var6 = var5.createQuery("from InventaireLigne where invligCode='" + var1 + "' and inventaireEntete.invDepot='" + var2 + "' and inventaireEntete.invDate >=:d1").setDate("d1", var3).list();
         } else {
            var6 = var5.createQuery("from InventaireLigne where invligCode='" + var1 + "' and inventaireEntete.invDepot='" + var2 + "' and inventaireEntete.invDate >=:d1 and inventaireEntete.invDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
         }
      } else if (var4 == null) {
         var6 = var5.createQuery("from InventaireLigne where invligCode='" + var1 + "' and inventaireEntete.invDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from InventaireLigne where invligCode='" + var1 + "' and inventaireEntete.invDate >=:d1 and inventaireEntete.invDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " inventaireEntete.invSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " inventaireEntete.invActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " inventaireEntete.invService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " invligDepot='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " inventaireEntete.invIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select inventaireEntete.invEtat,inventaireEntete.invNum,inventaireEntete.invSerie,inventaireEntete.invDate,inventaireEntete.invIdEquipe,invligId,invligDepot,invligCode,invligFamille,invligLibelle,invligQte,invligQteUtil,invligPump,invligTotal,invligPoidsBrut,invligObs from InventaireLigne where " + var12 + " invligCode in " + var2 + " and inventaireEntete.invDate between '" + var8 + "' and '" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select inventaireEntete.invEtat,inventaireEntete.invNum,inventaireEntete.invSerie,inventaireEntete.invDate,inventaireEntete.invIdEquipe,invligId,invligDepot,invligCode,invligFamille,invligLibelle,invligQte,invligQteUtil,invligPump,invligTotal,invligPoidsBrut,invligObs from InventaireLigne where " + var12 + " invligCode='" + var2 + "' and inventaireEntete.invDate between '" + var8 + "' and '" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select inventaireEntete.invEtat,inventaireEntete.invNum,inventaireEntete.invSerie,inventaireEntete.invDate,inventaireEntete.invIdEquipe,invligId,invligDepot,invligCode,invligFamille,invligLibelle,invligQte,invligQteUtil,invligPump,invligTotal,invligPoidsBrut,invligObs from InventaireLigne where " + var12 + " and inventaireEntete.invDate between '" + var8 + "' and '" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from InventaireLigne where invligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvts(String var1, String var2, long var3, Session var5) {
      List var6 = null;
      String var7 = "";
      if (var2 != null && !var2.isEmpty()) {
         var7 = var7 + " invligDepot='" + var2 + "' and ";
      }

      if (var3 != 0L) {
         var7 = var7 + " inventaireEntete.invIdEquipe=" + var3 + " and ";
      }

      var6 = var5.createQuery("from InventaireLigne where " + var7 + " invligCode='" + var1 + "' order by inventaireEntete.invDate desc").list();
      return var6;
   }

   public List chargerLesMvts(String var1, String var2, Session var3) {
      List var4 = null;
      String var5 = "";
      if (var1 != null && !var1.isEmpty()) {
         if (var2 != null && !var2.isEmpty()) {
            var5 = var5 + " invligDepot='" + var2 + "' and ";
         }

         if (var1.startsWith("(")) {
            var4 = var3.createQuery("from InventaireLigne where " + var5 + " invligCode in " + var1 + " order by inventaireEntete.invDate desc").list();
         } else {
            var4 = var3.createQuery("from InventaireLigne where " + var5 + " invligCode='" + var1 + "' order by inventaireEntete.invDate desc").list();
         }
      } else {
         var4 = var3.createQuery("from InventaireLigne where invligDepot='" + var2 + "' order by inventaireEntete.invDate desc").list();
      }

      return var4;
   }

   public List localisationInv(String var1, String var2, String var3, String var4, String var5, long var6, Session var8) {
      new ArrayList();
      List var9;
      if (var1 != null && !var1.isEmpty()) {
         if (var6 != 0L) {
            var9 = var8.createQuery("from InventaireLigne where invligCode=:prd and invligDepot=:dep and inventaireEntete.invIdEquipe=:equ and inventaireEntete.invDate>=:dteD and inventaireEntete.invDate<=:dteF and inventaireEntete.invSerie=:ser order by inventaireEntete.invDate DESC").setString("prd", var4).setString("dep", var5).setString("dteD", var2).setString("dteF", var3).setLong("equ", var6).setString("ser", var1).list();
            if (var9.size() == 0) {
               var9 = var8.createQuery("from InventaireLigne where invligCode=:prd and invligDepot=:dep and inventaireEntete.invIdEquipe=:equ and inventaireEntete.invDate<:dteD and inventaireEntete.invSerie=:ser order by inventaireEntete.invDate DESC").setString("prd", var4).setString("dep", var5).setString("dteD", var2).setLong("equ", var6).setString("ser", var1).list();
            }
         } else {
            var9 = var8.createQuery("from InventaireLigne where invligCode=:prd and invligDepot=:dep and inventaireEntete.invDate>=:dteD and inventaireEntete.invDate<=:dteF and inventaireEntete.invSerie=:ser  order by inventaireEntete.invDate DESC").setString("prd", var4).setString("dep", var5).setString("dteD", var2).setString("dteF", var3).setString("ser", var1).list();
            if (var9.size() == 0) {
               var9 = var8.createQuery("from InventaireLigne where invligCode=:prd and invligDepot=:dep and inventaireEntete.invDate<:dteD and inventaireEntete.invSerie=:ser  order by inventaireEntete.invDate DESC").setString("prd", var4).setString("dep", var5).setString("dteD", var2).setString("ser", var1).list();
            }
         }
      } else if (var6 != 0L) {
         var9 = var8.createQuery("from InventaireLigne where invligCode=:prd and invligDepot=:dep and inventaireEntete.invIdEquipe=:equ and inventaireEntete.invDate>=:dteD and inventaireEntete.invDate<=:dteF order by inventaireEntete.invDate DESC").setString("prd", var4).setString("dep", var5).setString("dteD", var2).setString("dteF", var3).setLong("equ", var6).list();
         if (var9.size() == 0) {
            var9 = var8.createQuery("from InventaireLigne where invligCode=:prd and invligDepot=:dep and inventaireEntete.invIdEquipe=:equ and inventaireEntete.invDate<:dteD order by inventaireEntete.invDate DESC").setString("prd", var4).setString("dep", var5).setString("dteD", var2).setLong("equ", var6).list();
         }
      } else {
         var9 = var8.createQuery("from InventaireLigne where invligCode=:prd and invligDepot=:dep and inventaireEntete.invDate>=:dteD and inventaireEntete.invDate<=:dteF order by inventaireEntete.invDate DESC").setString("prd", var4).setString("dep", var5).setString("dteD", var2).setString("dteF", var3).list();
         if (var9.size() == 0) {
            var9 = var8.createQuery("from InventaireLigne where invligCode=:prd and invligDepot=:dep and inventaireEntete.invDate<:dteD order by inventaireEntete.invDate DESC").setString("prd", var4).setString("dep", var5).setString("dteD", var2).list();
         }
      }

      return var9;
   }

   public List rechercheInventaireRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from InventaireLigne where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public InventaireLigne rechercheInventaire(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.inventaireLigne = new InventaireLigne();
      var6 = var3.createQuery("from InventaireLigne where invligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.inventaireLigne = (InventaireLigne)var6.get(0);
      } else {
         this.inventaireLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.inventaireLigne;
   }

   public InventaireLigne rechercheBefore(Date var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "InventaireEntete");
         var5 = true;
      }

      new ArrayList();
      List var7 = var4.createQuery("from InventaireLigne where invligCode =:prd and invligDepot =:dep and inventaireEntete.invDate <'" + var1 + "' order by inventaireEntete.invDate desc").setString("prd", var2).setString("dep", var3).setMaxResults(1).list();
      if (var7.size() != 0) {
         this.inventaireLigne = (InventaireLigne)var7.get(0);
      } else {
         this.inventaireLigne = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.inventaireLigne;
   }
}
