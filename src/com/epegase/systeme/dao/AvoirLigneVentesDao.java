package com.epegase.systeme.dao;

import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.AvoirLigneVentes;
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

public class AvoirLigneVentesDao implements Serializable {
   private AvoirLigneVentes avoirLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public AvoirLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public AvoirLigneVentes insertLigne(AvoirLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public AvoirLigneVentes modifLigne(AvoirLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteAllLigne(AvoirEnteteVentes var1, Session var2) {
      var2.createQuery("delete from AvoirLigneVentes where avoirEnteteVentes=:id").setLong("id", var1.getAvrId()).executeUpdate();
      return "";
   }

   public String deleteOneLigne(AvoirLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from AvoirLigneVentes where avrligId =" + var1.getAvrligId());
      var3.executeUpdate();
      return null;
   }

   public void duppliquerLigne(List var1, AvoirEnteteVentes var2, Session var3) {
      new AvoirLigneVentes();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         AvoirLigneVentes var4 = (AvoirLigneVentes)var1.get(var5);
         AvoirLigneVentes var6 = new AvoirLigneVentes();
         var6.setAvoirEnteteVentes(var2);
         var6.setAvrligOrdre(var4.getAvrligOrdre());
         var6.setAvrligCode(var4.getAvrligCode());
         var6.setAvrligGroupe(var4.getAvrligGroupe());
         var6.setAvrligModeGroupe(var4.getAvrligModeGroupe());
         var6.setAvrligFamille(var4.getAvrligFamille());
         var6.setAvrligLibelle(var4.getAvrligLibelle());
         var6.setAvrligComplement(var4.getAvrligComplement());
         var6.setAvrligDescription(var4.getAvrligDescription());
         var6.setAvrligReference(var4.getAvrligReference());
         var6.setAvrligTaxe(var4.getAvrligTaxe());
         var6.setAvrligTauxTaxe(var4.getAvrligTauxTaxe());
         var6.setAvrligUnite(var4.getAvrligUnite());
         var6.setAvrligQte(var4.getAvrligQte());
         var6.setAvrligQteStock(var4.getAvrligQteStock());
         var6.setAvrligQteUtil(var4.getAvrligQteUtil());
         var6.setAvrligDevise(var4.getAvrligDevise());
         var6.setAvrligPu(var4.getAvrligPu());
         var6.setAvrligPuTtc(var4.getAvrligPuTtc());
         var6.setAvrligTauxRemise(var4.getAvrligTauxRemise());
         var6.setAvrligRabais(var4.getAvrligRabais());
         var6.setAvrligPuRem(var4.getAvrligPuRem());
         var6.setAvrligPuRemTtc(var4.getAvrligPuRemTtc());
         var6.setAvrligPt(var4.getAvrligPt());
         var6.setAvrligTva(var4.getAvrligTva());
         var6.setAvrligTc(var4.getAvrligTc());
         var6.setAvrligTtc(var4.getAvrligTtc());
         var6.setAvrligPump(var4.getAvrligPump());
         var6.setAvrligDepot(var4.getAvrligDepot());
         var6.setAvrligLot(var4.getAvrligLot());
         var6.setAvrligNumSerie(var4.getAvrligNumSerie());
         var6.setAvrligStock(var4.getAvrligStock());
         var6.setAvrligLarg(var4.getAvrligLarg());
         var6.setAvrligLong(var4.getAvrligLong());
         var6.setAvrligHaut(var4.getAvrligHaut());
         var6.setAvrligPoidsBrut(var4.getAvrligPoidsBrut());
         var6.setAvrligPoidsNet(var4.getAvrligPoidsNet());
         var6.setAvrligDiam(var4.getAvrligDiam());
         var6.setAvrligNb(var4.getAvrligNb());
         var6.setAvrligVolume(var4.getAvrligVolume());
         var6.setAvrligEchelle(var4.getAvrligEchelle());
         var6.setAvrligCondition(var4.getAvrligCondition());
         var3.save(var6);
      }

   }

   public void saveLigne(List var1, AvoirEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         AvoirLigneVentes var5 = (AvoirLigneVentes)var1.get(var4);
         var5.setAvoirEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(AvoirEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from AvoirLigneVentes where avoirEnteteVentes=:idfk order by avrligOrdre,avrligId").setLong("idfk", var1.getAvrId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesAvoirs(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from AvoirLigneVentes where avoirEnteteVentes.avrNum in (" + var1 + ") order by avrligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var4 == null) {
         var6 = var5.createQuery("from AvoirLigneVentes where avrligCode='" + var1 + "' and avoirEnteteVentes.avrDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from AvoirLigneVentes where avrligCode='" + var1 + "' and avoirEnteteVentes.avrDate >=:d1 and avoirEnteteVentes.avrDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public AvoirLigneVentes chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      this.avoirLigneVentes = new AvoirLigneVentes();
      List var5 = var3.createQuery("from AvoirLigneVentes where avrligId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.avoirLigneVentes = (AvoirLigneVentes)var5.get(0);
      } else {
         this.avoirLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.avoirLigneVentes;
   }

   public List chargerLesMvts(String var1, String var2, long var3, String var5, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "avrligId<>0 and ";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " avoirEnteteVentes.avrSerie='" + var1 + "' and ";
      }

      if (var9 != null && !var9.isEmpty()) {
         var12 = var12 + " avoirEnteteVentes.tiers.tiecompte0='" + var9 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var12 = var12 + " avoirEnteteVentes.avrActivite='" + var5 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " avoirEnteteVentes.avrService='" + var6 + "' and ";
      }

      if (var3 != 0L) {
         var12 = var12 + " avoirEnteteVentes.avrIdEquipe=" + var3 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select avoirEnteteVentes.avrEtat,avoirEnteteVentes.avrNum,avoirEnteteVentes.avrSerie,avoirEnteteVentes.avrIdEquipe,avoirEnteteVentes.avrDiversNom,avoirEnteteVentes.avrNomTiers,avoirEnteteVentes.avrDate,avoirEnteteVentes.avrDevise,avrligId,avrligDepot,avrligCode,avrligFamille,avrligLibelle,avrligQte,avrligQteUtil,avrligPu,avrligPt,avrligPump,avrligPoidsBrut from AvoirLigneVentes where " + var12 + " avrligCode in " + var2 + " and avoirEnteteVentes.avrDate>='" + var7 + "' and avoirEnteteVentes.avrDate<='" + var8 + "'").list();
         } else {
            var11 = var10.createQuery("select avoirEnteteVentes.avrEtat,avoirEnteteVentes.avrNum,avoirEnteteVentes.avrSerie,avoirEnteteVentes.avrIdEquipe,avoirEnteteVentes.avrDiversNom,avoirEnteteVentes.avrNomTiers,avoirEnteteVentes.avrDate,avoirEnteteVentes.avrDevise,avrligId,avrligDepot,avrligCode,avrligFamille,avrligLibelle,avrligQte,avrligQteUtil,avrligPu,avrligPt,avrligPump,avrligPoidsBrut from AvoirLigneVentes where " + var12 + " avrligCode='" + var2 + "' and avoirEnteteVentes.avrDate>='" + var7 + "' and avoirEnteteVentes.avrDate<='" + var8 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select avoirEnteteVentes.avrEtat,avoirEnteteVentes.avrNum,avoirEnteteVentes.avrSerie,avoirEnteteVentes.avrIdEquipe,avoirEnteteVentes.avrDiversNom,avoirEnteteVentes.avrNomTiers,avoirEnteteVentes.avrDate,avoirEnteteVentes.avrDevise,avrligId,avrligDepot,avrligCode,avrligFamille,avrligLibelle,avrligQte,avrligQteUtil,avrligPu,avrligPt,avrligPump,avrligPoidsBrut from AvoirLigneVentes where " + var12 + " avoirEnteteVentes.avrDate>='" + var7 + "' and avoirEnteteVentes.avrDate<='" + var8 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from AvoirLigneVentes where avrligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from AvoirLigneVentes where avoirEnteteVentes.tiers.tieid=" + var1.getTieid() + " and avoirEnteteVentes.avrDate between '" + var2 + "' and '" + var3 + "' and avoirEnteteVentes.avrSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from AvoirLigneVentes where avoirEnteteVentes.tiers.tieid=" + var1.getTieid() + " and avoirEnteteVentes.avrDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from AvoirLigneVentes where avoirEnteteVentes.avrNomContact='" + var1 + "' and avoirEnteteVentes.avrDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from AvoirLigneVentes where (avoirEnteteVentes.avrIdCommercial=:usr or avoirEnteteVentes.avrIdResponsable=:usr) and avoirEnteteVentes.avrDate>=:dDeb and avoirEnteteVentes.avrDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public float chargerLesReliquatsFactureVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from AvoirLigneVentes where avrligIdFac=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((AvoirLigneVentes)var6.get(var8)).getAvrligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsNoteDebitVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from AvoirLigneVentes where avrligIdNdb=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((AvoirLigneVentes)var6.get(var8)).getAvrligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheAvoirRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from AvoirLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public AvoirLigneVentes rechercheAvoir(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.avoirLigneVentes = new AvoirLigneVentes();
      var6 = var3.createQuery("from AvoirLigneVentes where avrligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.avoirLigneVentes = (AvoirLigneVentes)var6.get(0);
      } else {
         this.avoirLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.avoirLigneVentes;
   }
}
