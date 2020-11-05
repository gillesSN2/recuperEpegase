package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BonSortieEntete;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class BonSortieLigneDao implements Serializable {
   private BonSortieLigne bonSortieLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BonSortieLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BonSortieLigne insertLigne(BonSortieLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BonSortieLigne modifLigne(BonSortieLigne var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(BonSortieLigne var1, Session var2) {
      Query var3 = var2.createQuery("delete from BonSortieLigne where bouligId =" + var1.getBouligId());
      var3.executeUpdate();
      return null;
   }

   public String deleteAllLigne(BonSortieEntete var1, Session var2) {
      var2.createQuery("delete from BonSortieLigne where bonSortieEntete=:id").setLong("id", var1.getBouId()).executeUpdate();
      return "";
   }

   public List chargerLesLignes(BonSortieEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieLigne");
         var3 = true;
      }

      List var4 = var2.createQuery("from BonSortieLigne where bonSortieEntete=:idfk").setLong("idfk", var1.getBouId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from BonSortieLigne where bonSortieEntete.bouligCode='" + var1 + "' and bonSortieEntete.bouligDepot='" + var2 + "' and bonSortieEntete.bouDate >'" + var3 + "' order desc by bonSortieEntete.bouDate").list();
      return var5;
   }

   public List chargerLesLignes(String var1, Date var2, Session var3) {
      List var4 = var3.createQuery("from BonSortieLigne where bonSortieEntete.bouligCode='" + var1 + "' and bonSortieEntete.bouDate >='" + var2 + "' order desc by bonSortieEntete.bouDate").list();
      return var4;
   }

   public List chargerLesLignesBou(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieLigne");
         var3 = true;
      }

      List var4 = var2.createQuery("from BonSortieLigne where bonSortieEntete.bouNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var4 == null) {
            var6 = var5.createQuery("from BonSortieLigne where bouligCode='" + var1 + "' and bonSortieEntete.bouDepot='" + var2 + "' and bonSortieEntete.bouDate >=:d1").setDate("d1", var3).list();
         } else {
            var6 = var5.createQuery("from BonSortieLigne where bouligCode='" + var1 + "' and bonSortieEntete.bouDepot='" + var2 + "' and bonSortieEntete.bouDate >=:d1 and bonSortieEntete.bouDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
         }
      } else if (var4 == null) {
         var6 = var5.createQuery("from BonSortieLigne where bouligCode='" + var1 + "' and bonSortieEntete.bouDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from BonSortieLigne where bouligCode='" + var1 + "' and bonSortieEntete.bouDate >=:d1 and bonSortieEntete.bouDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " bonSortieEntete.bouSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " bonSortieEntete.bouActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " bonSortieEntete.bouService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " bouligDepot='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " bonSortieEntete.bouIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select bonSortieEntete.bouEtat,bonSortieEntete.bouNum,bonSortieEntete.bouSerie,bonSortieEntete.bouDate,bonSortieEntete.bouIdEquipe,bouligId,bouligDepot,bouligCode,bouligFamille,bouligLibelle,bouligQte,bouligQteUtil,bouligPump,bouligTotal,bouligPoidsBrut,bouligObs,bonSortieEntete.bouNomDemandeur from BonSortieLigne where " + var12 + " bouligCode in " + var2 + " and bonSortieEntete.bouDate>='" + var8 + "' and bonSortieEntete.bouDate<='" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select bonSortieEntete.bouEtat,bonSortieEntete.bouNum,bonSortieEntete.bouSerie,bonSortieEntete.bouDate,bonSortieEntete.bouIdEquipe,bouligId,bouligDepot,bouligCode,bouligFamille,bouligLibelle,bouligQte,bouligQteUtil,bouligPump,bouligTotal,bouligPoidsBrut,bouligObs,bonSortieEntete.bouNomDemandeur from BonSortieLigne where " + var12 + " bouligCode='" + var2 + "' and bonSortieEntete.bouDate>='" + var8 + "' and bonSortieEntete.bouDate<='" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select bonSortieEntete.bouEtat,bonSortieEntete.bouNum,bonSortieEntete.bouSerie,bonSortieEntete.bouDate,bonSortieEntete.bouIdEquipe,bouligId,bouligDepot,bouligCode,bouligFamille,bouligLibelle,bouligQte,bouligQteUtil,bouligPump,bouligTotal,bouligPoidsBrut,bouligObs,bonSortieEntete.bouNomDemandeur from BonSortieLigne where " + var12 + " bonSortieEntete.bouDate>='" + var8 + "' and bonSortieEntete.bouDate<='" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from BonSortieLigne where bouligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvts(String var1, String var2, long var3, Session var5) {
      List var6 = null;
      String var7 = "";
      if (var2 != null && !var2.isEmpty()) {
         var7 = var7 + " bouligDepot='" + var2 + "' and ";
      }

      if (var3 != 0L) {
         var7 = var7 + " bonSortieEntete.bouIdEquipe=" + var3 + " and ";
      }

      var6 = var5.createQuery("from BonSortieLigne where " + var7 + " bouligCode='" + var1 + "'").list();
      return var6;
   }

   public List rechercheBonSortieRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieLigne");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from BonSortieLigne where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheBSortieRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieLigne");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from BonSortieLigne where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public BonSortieLigne rechercheBonsortie(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BonSortieLigne");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.bonSortieLigne = new BonSortieLigne();
      var6 = var3.createQuery("from BonSortieLigne where bouligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.bonSortieLigne = (BonSortieLigne)var6.get(0);
      } else {
         this.bonSortieLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.bonSortieLigne;
   }
}
