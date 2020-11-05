package com.epegase.systeme.dao;

import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class RetourLigneVentesDao implements Serializable {
   private RetourLigneVentes retourLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public RetourLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public RetourLigneVentes insertLigne(RetourLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public RetourLigneVentes modifLigne(RetourLigneVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String deleteAllLigne(RetourEnteteVentes var1, Session var2) {
      var2.createQuery("delete from RetourLigneVentes where retourEnteteVentes=:id").setLong("id", var1.getBrtId()).executeUpdate();
      return "";
   }

   public String deleteOneLigne(RetourLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from RetourLigneVentes where brtligId =" + var1.getBrtligId());
      var3.executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, RetourEnteteVentes var2, Session var3) {
      new RetourLigneVentes();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         RetourLigneVentes var4 = (RetourLigneVentes)var1.get(var5);
         RetourLigneVentes var6 = new RetourLigneVentes();
         var6.setRetourEnteteVentes(var2);
         var6.setBrtligOrdre(var4.getBrtligOrdre());
         var6.setBrtligCode(var4.getBrtligCode());
         var6.setBrtligGroupe(var4.getBrtligGroupe());
         var6.setBrtligModeGroupe(var4.getBrtligModeGroupe());
         var6.setBrtligFamille(var4.getBrtligFamille());
         var6.setBrtligLibelle(var4.getBrtligLibelle());
         var6.setBrtligComplement(var4.getBrtligComplement());
         var6.setBrtligDescription(var4.getBrtligDescription());
         var6.setBrtligReference(var4.getBrtligReference());
         var6.setBrtligTaxe(var4.getBrtligTaxe());
         var6.setBrtligTauxTaxe(var4.getBrtligTauxTaxe());
         var6.setBrtligUnite(var4.getBrtligUnite());
         var6.setBrtligQte(var4.getBrtligQte());
         var6.setBrtligQteStock(var4.getBrtligQteStock());
         var6.setBrtligQteUtil(var4.getBrtligQteUtil());
         var6.setBrtligDevise(var4.getBrtligDevise());
         var6.setBrtligPu(var4.getBrtligPu());
         var6.setBrtligPuTtc(var4.getBrtligPuTtc());
         var6.setBrtligTauxRemise(var4.getBrtligTauxRemise());
         var6.setBrtligRabais(var4.getBrtligRabais());
         var6.setBrtligPuRem(var4.getBrtligPuRem());
         var6.setBrtligPuRemTtc(var4.getBrtligPuRemTtc());
         var6.setBrtligPt(var4.getBrtligPt());
         var6.setBrtligTva(var4.getBrtligTva());
         var6.setBrtligTc(var4.getBrtligTc());
         var6.setBrtligTtc(var4.getBrtligTtc());
         var6.setBrtligPump(var4.getBrtligPump());
         var6.setBrtligDepot(var4.getBrtligDepot());
         var6.setBrtligLot(var4.getBrtligLot());
         var6.setBrtligNumSerie(var4.getBrtligNumSerie());
         var6.setBrtligStock(var4.getBrtligStock());
         var6.setBrtligLarg(var4.getBrtligLarg());
         var6.setBrtligLong(var4.getBrtligLong());
         var6.setBrtligHaut(var4.getBrtligHaut());
         var6.setBrtligPoidsBrut(var4.getBrtligPoidsBrut());
         var6.setBrtligPoidsNet(var4.getBrtligPoidsNet());
         var6.setBrtligDiam(var4.getBrtligDiam());
         var6.setBrtligNb(var4.getBrtligNb());
         var6.setBrtligVolume(var4.getBrtligVolume());
         var6.setBrtligEchelle(var4.getBrtligEchelle());
         var6.setBrtligCondition(var4.getBrtligCondition());
         var3.save(var6);
      }

   }

   public void saveLigne(List var1, RetourEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         RetourLigneVentes var5 = (RetourLigneVentes)var1.get(var4);
         var5.setRetourEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(RetourEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from RetourLigneVentes where retourEnteteVentes=:idfk order by brtligOrdre,brtligId").setLong("idfk", var1.getBrtId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesRetours(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from RetourLigneVentes where retourEnteteVentes.brtNum in (" + var1 + ") order by brtligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, String var10, Session var11) {
      List var12 = null;
      String var13 = "brtligId<>0 and ";
      if (var1 != null && !var1.isEmpty()) {
         var13 = var13 + " retourEnteteVentes.brtSerie='" + var1 + "' and ";
      }

      if (var10 != null && !var10.isEmpty()) {
         var13 = var13 + " retourEnteteVentes.tiers.tiecompte0='" + var10 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var13 = var13 + " retourEnteteVentes.brtActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var13 = var13 + " retourEnteteVentes.brtService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var13 = var13 + " brtligDepot='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var13 = var13 + " retourEnteteVentes.brtIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var12 = var11.createQuery("select retourEnteteVentes.brtEtat,retourEnteteVentes.brtNum,retourEnteteVentes.brtSerie,retourEnteteVentes.brtIdEquipe,retourEnteteVentes.brtDiversNom,retourEnteteVentes.brtNomTiers,retourEnteteVentes.brtDate,retourEnteteVentes.brtDevise,brtligId,brtligDepot,brtligCode,brtligFamille,brtligLibelle,brtligQte,brtligQteUtil,brtligPu,brtligPt,brtligPump,brtligPoidsBrut from RetourLigneVentes where " + var13 + " brtligCode in " + var2 + " and retourEnteteVentes.brtDate>='" + var8 + "' and retourEnteteVentes.brtDate<='" + var9 + "'").list();
         } else {
            var12 = var11.createQuery("select retourEnteteVentes.brtEtat,retourEnteteVentes.brtNum,retourEnteteVentes.brtSerie,retourEnteteVentes.brtIdEquipe,retourEnteteVentes.brtDiversNom,retourEnteteVentes.brtNomTiers,retourEnteteVentes.brtDate,retourEnteteVentes.brtDevise,brtligId,brtligDepot,brtligCode,brtligFamille,brtligLibelle,brtligQte,brtligQteUtil,brtligPu,brtligPt,brtligPump,brtligPoidsBrut from RetourLigneVentes where " + var13 + " brtligCode='" + var2 + "' and retourEnteteVentes.brtDate>='" + var8 + "' and retourEnteteVentes.brtDate<='" + var9 + "'").list();
         }
      } else {
         var12 = var11.createQuery("select retourEnteteVentes.brtEtat,retourEnteteVentes.brtNum,retourEnteteVentes.brtSerie,retourEnteteVentes.brtIdEquipe,retourEnteteVentes.brtDiversNom,retourEnteteVentes.brtNomTiers,retourEnteteVentes.brtDate,retourEnteteVentes.brtDevise,brtligId,brtligDepot,brtligCode,brtligFamille,brtligLibelle,brtligQte,brtligQteUtil,brtligPu,brtligPt,brtligPump,brtligPoidsBrut from RetourLigneVentes where " + var13 + " retourEnteteVentes.brtDate>='" + var8 + "' and retourEnteteVentes.brtDate<='" + var9 + "'").list();
      }

      return var12;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from RetourLigneVentes where brtligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from RetourLigneVentes where retourEnteteVentes.tiers.tieid=" + var1.getTieid() + " and retourEnteteVentes.brtDate between '" + var2 + "' and '" + var3 + "' and retourEnteteVentes.brtSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from RetourLigneVentes where retourEnteteVentes.tiers.tieid=" + var1.getTieid() + " and retourEnteteVentes.brtDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from RetourLigneVentes where retourEnteteVentes.brtNomContact='" + var1 + "' and retourEnteteVentes.brtDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from RetourLigneVentes where (retourEnteteVentes.brtIdCommercial=:usr or retourEnteteVentes.brtIdResponsable=:usr) and retourEnteteVentes.brtDate>=:dDeb and retourEnteteVentes.brtDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public float chargerLesReliquatsLivraisonVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from RetourLigneVentes where brtligIdBlv=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((RetourLigneVentes)var6.get(var8)).getBrtligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from RetourLigneVentes where brtligCode='" + var1 + "' and brtligDepot='" + var2 + "' and retourEnteteVentes.brtDate >'" + var3 + "'").list();
      return var5;
   }

   public List chargerLesLinesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var4 == null) {
            var6 = var5.createQuery("from RetourLigneVentes where brtligCode='" + var1 + "' and brtligDepot='" + var2 + "' and retourEnteteVentes.brtDate >=:d1").setDate("d1", var3).list();
         } else {
            var6 = var5.createQuery("from RetourLigneVentes where brtligCode='" + var1 + "' and brtligDepot='" + var2 + "' and retourEnteteVentes.brtDate >=:d1 and retourEnteteVentes.brtDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
         }
      } else if (var4 == null) {
         var6 = var5.createQuery("from RetourLigneVentes where brtligCode='" + var1 + "' and retourEnteteVentes.brtDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from RetourLigneVentes where brtligCode='" + var1 + "' and retourEnteteVentes.brtDate >=:d1 and retourEnteteVentes.brtDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public List rechercheRetourRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from RetourLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public RetourLigneVentes rechercheRetour(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.retourLigneVentes = new RetourLigneVentes();
      var6 = var3.createQuery("from RetourLigneVentes where brtligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.retourLigneVentes = (RetourLigneVentes)var6.get(0);
      } else {
         this.retourLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.retourLigneVentes;
   }
}
