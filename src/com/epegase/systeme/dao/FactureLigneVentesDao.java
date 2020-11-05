package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FactureLigneVentesDao implements Serializable {
   private FactureLigneVentes factureLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FactureLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FactureLigneVentes insertLigne(FactureLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FactureLigneVentes modifLigne(FactureLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void deleteAllLigne(FactureEnteteVentes var1, Session var2) {
      var2.createQuery("delete from FactureLigneVentes where factureEnteteVentes=:id").setLong("id", var1.getFacId()).executeUpdate();
   }

   public void deleteOneLigne(FactureLigneVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.delete(var1);
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

   public String deleteOneLigne(FactureLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from FactureLigneVentes where facligId =" + var1.getFacligId());
      var3.executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, FactureEnteteVentes var2, float var3, String var4, Session var5) {
      new FactureLigneVentes();

      for(int var7 = 0; var7 < var1.size(); ++var7) {
         FactureLigneVentes var6 = (FactureLigneVentes)var1.get(var7);
         FactureLigneVentes var8 = new FactureLigneVentes();
         var8.setFactureEnteteVentes(var2);
         var8.setFacligOrdre(var6.getFacligOrdre());
         var8.setFacligCode(var6.getFacligCode());
         var8.setFacligGroupe(var6.getFacligGroupe());
         var8.setFacligModeGroupe(var6.getFacligModeGroupe());
         var8.setFacligFamille(var6.getFacligFamille());
         var8.setFacligLibelle(var6.getFacligLibelle());
         var8.setFacligComplement(var6.getFacligComplement());
         var8.setFacligDescription(var6.getFacligDescription());
         var8.setFacligReference(var6.getFacligReference());
         var8.setFacligTaxe(var6.getFacligTaxe());
         var8.setFacligTauxTaxe(var6.getFacligTauxTaxe());
         var8.setFacligUnite(var6.getFacligUnite());
         var8.setFacligQte(var6.getFacligQte());
         var8.setFacligQteStock(var6.getFacligQteStock());
         var8.setFacligQteUtil(var6.getFacligQteUtil());
         var8.setFacligDevise(var6.getFacligDevise());
         var8.setFacligPump(var6.getFacligPump());
         if (var3 != 0.0F) {
            UtilNombre var9 = new UtilNombre();
            var8.setFacligTauxRemise(var3);
            var8.setFacligPu(var6.getFacligPu());
            double var10 = var6.getFacligPu() * (double)var3 / 100.0D;
            var10 = var9.myRoundDevise(var10, var4);
            var8.setFacligPuRem(var10);
            double var12 = var6.getFacligPuTtc() * (double)var3 / 100.0D;
            var12 = var9.myRoundDevise(var12, var4);
            var8.setFacligPuRemTtc(var12);
            double var14 = var6.getFacligPuRem() * (double)var6.getFacligQte();
            var14 = var9.myRoundDevise(var14, var4);
            double var16 = 0.0D;
            double var18 = 0.0D;
            var8.setFacligPt(var14);
            if (var8.getFacligTauxTaxe() != 0.0F) {
               var16 = var14 * (double)var8.getFacligTauxTaxe() / 100.0D;
               var16 = var9.myRoundDevise(var16, var4);
            }

            var8.setFacligTva(var16);
            var18 = var14 + var16;
            var8.setFacligTtc(var18);
         } else {
            var8.setFacligPu(var6.getFacligPu());
            var8.setFacligPuTtc(var6.getFacligPuTtc());
            var8.setFacligTauxRemise(var6.getFacligTauxRemise());
            var8.setFacligRabais(var6.getFacligRabais());
            var8.setFacligPuRem(var6.getFacligPuRem());
            var8.setFacligPuRemTtc(var6.getFacligPuRemTtc());
            var8.setFacligPt(var6.getFacligPt());
            var8.setFacligTva(var6.getFacligTva());
            var8.setFacligTc(var6.getFacligTc());
            var8.setFacligTtc(var6.getFacligTtc());
         }

         var8.setFacligDepot(var6.getFacligDepot());
         var8.setFacligLot(var6.getFacligLot());
         var8.setFacligNumSerie(var6.getFacligNumSerie());
         var8.setFacligStock(var6.getFacligStock());
         var8.setFacligEntStock(var6.getFacligEntStock());
         var8.setFacligLarg(var6.getFacligLarg());
         var8.setFacligLong(var6.getFacligLong());
         var8.setFacligHaut(var6.getFacligHaut());
         var8.setFacligPoidsBrut(var6.getFacligPoidsBrut());
         var8.setFacligPoidsNet(var6.getFacligPoidsNet());
         var8.setFacligDiam(var6.getFacligDiam());
         var8.setFacligNb(var6.getFacligNb());
         var8.setFacligVolume(var6.getFacligVolume());
         var8.setFacligEchelle(var6.getFacligEchelle());
         var8.setFacligCondition(var6.getFacligCondition());
         var5.save(var8);
      }

   }

   public void saveLigne(List var1, FactureEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         FactureLigneVentes var5 = (FactureLigneVentes)var1.get(var4);
         var5.setFactureEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(FactureEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from FactureLigneVentes where factureEnteteVentes=:idfk order by facligOrdre,facligId").setLong("idfk", var1.getFacId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesFactures(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from FactureLigneVentes where factureEnteteVentes.facNum in (" + var1 + ") order by facligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesFactures(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureLigneVentes where facligIdBlv = " + var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var4 == null) {
         var6 = var5.createQuery("from FactureLigneVentes where facligCode='" + var1 + "' and factureEnteteVentes.facDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from FactureLigneVentes where facligCode='" + var1 + "' and factureEnteteVentes.facDate >=:d1 and factureEnteteVentes.facDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public FactureLigneVentes chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      this.factureLigneVentes = new FactureLigneVentes();
      List var5 = var3.createQuery("from FactureLigneVentes where facligId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.factureLigneVentes = (FactureLigneVentes)var5.get(0);
      } else {
         this.factureLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureLigneVentes;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, String var10, Session var11) {
      List var12 = null;
      String var13 = "facligId<>0 and ";
      if (var1 != null && !var1.isEmpty()) {
         var13 = var13 + " factureEnteteVentes.facSerie='" + var1 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var13 = var13 + " facligDepot='" + var3 + "' and ";
      }

      if (var10 != null && !var10.isEmpty()) {
         var13 = var13 + " factureEnteteVentes.tiers.tiecompte0='" + var10 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var13 = var13 + " factureEnteteVentes.facActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var13 = var13 + " factureEnteteVentes.facService='" + var7 + "' and ";
      }

      if (var4 != 0L) {
         var13 = var13 + " factureEnteteVentes.facIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var12 = var11.createQuery("select factureEnteteVentes.facEtat,factureEnteteVentes.facNum,factureEnteteVentes.facSerie,factureEnteteVentes.facIdEquipe,factureEnteteVentes.facDiversNom,factureEnteteVentes.facNomTiers,factureEnteteVentes.facDate,factureEnteteVentes.facDevise,facligId,facligDepot,facligCode,facligFamille,facligLibelle,facligQte,facligQteUtil,facligPu,facligPt,facligPump,facligPoidsBrut,factureEnteteVentes.facStock from FactureLigneVentes where " + var13 + " facligCode in " + var2 + " and factureEnteteVentes.facDate>='" + var8 + "' and factureEnteteVentes.facDate<='" + var9 + "'").list();
         } else {
            var12 = var11.createQuery("select factureEnteteVentes.facEtat,factureEnteteVentes.facNum,factureEnteteVentes.facSerie,factureEnteteVentes.facIdEquipe,factureEnteteVentes.facDiversNom,factureEnteteVentes.facNomTiers,factureEnteteVentes.facDate,factureEnteteVentes.facDevise,facligId,facligDepot,facligCode,facligFamille,facligLibelle,facligQte,facligQteUtil,facligPu,facligPt,facligPump,facligPoidsBrut,factureEnteteVentes.facStock from FactureLigneVentes where " + var13 + " facligCode='" + var2 + "' and factureEnteteVentes.facDate>='" + var8 + "' and factureEnteteVentes.facDate<='" + var9 + "'").list();
         }
      } else {
         var12 = var11.createQuery("select factureEnteteVentes.facEtat,factureEnteteVentes.facNum,factureEnteteVentes.facSerie,factureEnteteVentes.facIdEquipe,factureEnteteVentes.facDiversNom,factureEnteteVentes.facNomTiers,factureEnteteVentes.facDate,factureEnteteVentes.facDevise,facligId,facligDepot,facligCode,facligFamille,facligLibelle,facligQte,facligQteUtil,facligPu,facligPt,facligPump,facligPoidsBrut,factureEnteteVentes.facStock from FactureLigneVentes where " + var13 + " factureEnteteVentes.facDate>='" + var8 + "' and factureEnteteVentes.facDate<='" + var9 + "'").list();
      }

      return var12;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from FactureLigneVentes where facligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesFacturesDirectes(String var1, String var2, long var3, String var5, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " factureEnteteVentes.facSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " factureEnteteVentes.facActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " factureEnteteVentes.facService='" + var7 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var12 = var12 + " facligDepot='" + var5 + "' and ";
      }

      if (var3 != 0L) {
         var12 = var12 + " factureEnteteVentes.facIdEquipe=" + var3 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select factureEnteteVentes.facEtat,factureEnteteVentes.facNum,factureEnteteVentes.facSerie,factureEnteteVentes.facIdEquipe,factureEnteteVentes.facDiversNom,factureEnteteVentes.facNomTiers,factureEnteteVentes.facDate,factureEnteteVentes.facDevise,facligId,facligDepot,facligCode,facligFamille,facligLibelle,facligQte,facligQteUtil,facligPu,facligPt,facligPump,facligPoidsBrut,factureEnteteVentes.facStock from FactureLigneVentes where " + var12 + " factureEnteteVentes.facStock=1 and facligCode in " + var2 + " and factureEnteteVentes.facDate>='" + var8 + "' and factureEnteteVentes.facDate<='" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select factureEnteteVentes.facEtat,factureEnteteVentes.facNum,factureEnteteVentes.facSerie,factureEnteteVentes.facIdEquipe,factureEnteteVentes.facDiversNom,factureEnteteVentes.facNomTiers,factureEnteteVentes.facDate,factureEnteteVentes.facDevise,facligId,facligDepot,facligCode,facligFamille,facligLibelle,facligQte,facligQteUtil,facligPu,facligPt,facligPump,facligPoidsBrut,factureEnteteVentes.facStock from FactureLigneVentes where " + var12 + " factureEnteteVentes.facStock=1 and facligCode='" + var2 + "' and factureEnteteVentes.facDate>='" + var8 + "' and factureEnteteVentes.facDate<='" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select factureEnteteVentes.facEtat,factureEnteteVentes.facNum,factureEnteteVentes.facSerie,factureEnteteVentes.facIdEquipe,factureEnteteVentes.facDiversNom,factureEnteteVentes.facNomTiers,factureEnteteVentes.facDate,factureEnteteVentes.facDevise,facligId,facligDepot,facligCode,facligFamille,facligLibelle,facligQte,facligQteUtil,facligPu,facligPt,facligPump,facligPoidsBrut,factureEnteteVentes.facStock from FactureLigneVentes where " + var12 + " factureEnteteVentes.facStock=1 and factureEnteteVentes.facDate>='" + var8 + "' and factureEnteteVentes.facDate<='" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from FactureLigneVentes where factureEnteteVentes.tiers.tieid=" + var1.getTieid() + " and factureEnteteVentes.facDate between '" + var2 + "' and '" + var3 + "' and factureEnteteVentes.facSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from FactureLigneVentes where factureEnteteVentes.tiers.tieid=" + var1.getTieid() + " and factureEnteteVentes.facDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureLigneVentes where factureEnteteVentes.facNomContact='" + var1 + "' and factureEnteteVentes.facDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureLigneVentes where (factureEnteteVentes.facIdCommercial=:usr or factureEnteteVentes.facIdResponsable=:usr) and factureEnteteVentes.facDate>=:dDeb and factureEnteteVentes.facDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public float chargerLesReliquatsDevisVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureLigneVentes where facligIdDvs=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((FactureLigneVentes)var6.get(var8)).getFacligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsCommandeVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureLigneVentes where facligIdBcm=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((FactureLigneVentes)var6.get(var8)).getFacligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsLivraisonVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureLigneVentes where facligIdBlv=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((FactureLigneVentes)var6.get(var8)).getFacligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsFacturesNegativesVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureLigneVentes where facligIdFac=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((FactureLigneVentes)var6.get(var8)).getFacligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FactureLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FactureLigneVentes rechercheFacture(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.factureLigneVentes = new FactureLigneVentes();
      var6 = var3.createQuery("from FactureLigneVentes where facligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.factureLigneVentes = (FactureLigneVentes)var6.get(0);
      } else {
         this.factureLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureLigneVentes;
   }
}
