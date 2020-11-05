package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BonEntreeEntete;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class BonEntreeLigneDao implements Serializable {
   private BonEntreeLigne bonEntreeLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BonEntreeLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BonEntreeLigne insertLigne(BonEntreeLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BonEntreeLigne modifLigne(BonEntreeLigne var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(BonEntreeLigne var1, Session var2) {
      Query var3 = var2.createQuery("delete from BonEntreeLigne where binligId =" + var1.getBinligId());
      var3.executeUpdate();
      return null;
   }

   public String deleteAllLigne(BonEntreeEntete var1, Session var2) {
      var2.createQuery("delete from BonEntreeLigne where bonEntreeEntete=:id").setLong("id", var1.getBinId()).executeUpdate();
      return "";
   }

   public List chargerLesLignes(BonEntreeEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from BonEntreeLigne where bonEntreeEntete=:idfk").setLong("idfk", var1.getBinId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from BonEntreeLigne where bonEntreeEntete.binligCode='" + var1 + "' and bonEntreeEntete.binligDepot='" + var2 + "' and bonEntreeEntete.binDate >'" + var3 + "' order desc by bonEntreeEntete.binDate").list();
      return var5;
   }

   public List chargerLesLignesBin(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from BonEntreeLigne where bonEntreeEntete.binNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var4 == null) {
            var6 = var5.createQuery("from BonEntreeLigne where binligCode='" + var1 + "' and bonEntreeEntete.binDepot='" + var2 + "' and bonEntreeEntete.binDate >=:d1").setDate("d1", var3).list();
         } else {
            var6 = var5.createQuery("from BonEntreeLigne where binligCode='" + var1 + "' and bonEntreeEntete.binDepot='" + var2 + "' and bonEntreeEntete.binDate >=:d1 and bonEntreeEntete.binDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
         }
      } else if (var4 == null) {
         var6 = var5.createQuery("from BonEntreeLigne where binligCode='" + var1 + "' and bonEntreeEntete.binDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from BonEntreeLigne where binligCode='" + var1 + "' and bonEntreeEntete.binDate >=:d1 and bonEntreeEntete.binDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " bonEntreeEntete.binSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " bonEntreeEntete.binActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " bonEntreeEntete.binService='" + var7 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " bonEntreeEntete.binIdEquipe=" + var4 + " and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " binligDepot='" + var3 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select bonEntreeEntete.binEtat,bonEntreeEntete.binNum,bonEntreeEntete.binSerie,bonEntreeEntete.binDate,bonEntreeEntete.binIdEquipe,binligId,binligDepot,binligCode,binligFamille,binligLibelle,binligQte,binligQteUtil,binligPump,binligTotal,binligPoidsBrut,binligObs,bonEntreeEntete.binNomRapporteur from BonEntreeLigne where " + var12 + " binligCode in " + var2 + " and bonEntreeEntete.binDate between '" + var8 + "' and '" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select bonEntreeEntete.binEtat,bonEntreeEntete.binNum,bonEntreeEntete.binSerie,bonEntreeEntete.binDate,bonEntreeEntete.binIdEquipe,binligId,binligDepot,binligCode,binligFamille,binligLibelle,binligQte,binligQteUtil,binligPump,binligTotal,binligPoidsBrut,binligObs,bonEntreeEntete.binNomRapporteur from BonEntreeLigne where " + var12 + " binligCode='" + var2 + "' and bonEntreeEntete.binDate between '" + var8 + "' and '" + var9 + "'").list();
         }
      } else if (var3 != null && !var3.isEmpty()) {
         var11 = var10.createQuery("select bonEntreeEntete.binEtat,bonEntreeEntete.binNum,bonEntreeEntete.binSerie,bonEntreeEntete.binDate,bonEntreeEntete.binIdEquipe,binligId,binligDepot,binligCode,binligFamille,binligLibelle,binligQte,binligQteUtil,binligPump,binligTotal,binligPoidsBrut,binligObs,bonEntreeEntete.binNomRapporteur from BonEntreeLigne where " + var12 + " bonEntreeEntete.binDate between '" + var8 + "' and '" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from BonEntreeLigne where binligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvts(String var1, String var2, long var3, Session var5) {
      List var6 = null;
      String var7 = "";
      if (var2 != null && !var2.isEmpty()) {
         var7 = var7 + " binligDepot='" + var2 + "' and ";
      }

      if (var3 != 0L) {
         var7 = var7 + " bonEntreeEntete.binIdEquipe=" + var3 + " and ";
      }

      var6 = var5.createQuery("from BonEntreeLigne where " + var7 + " binligCode='" + var1 + "'").list();
      return var6;
   }

   public List rechercheBEntreeRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from BonEntreeLigne where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public BonEntreeLigne rechercheBonentree(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonEntreeEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.bonEntreeLigne = new BonEntreeLigne();
      var6 = var3.createQuery("from BonEntreeLigne where binligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.bonEntreeLigne = (BonEntreeLigne)var6.get(0);
      } else {
         this.bonEntreeLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.bonEntreeLigne;
   }
}
