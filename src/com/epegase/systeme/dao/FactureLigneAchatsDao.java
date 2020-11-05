package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.LigneDocument;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class FactureLigneAchatsDao implements Serializable {
   private FactureLigneAchats factureLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FactureLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FactureLigneAchats insertLigne(FactureLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FactureLigneAchats modifLigne(FactureLigneAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteAllLigne(FactureEnteteAchats var1, Session var2) {
      var2.createQuery("delete from FactureLigneAchats where factureEnteteAchats=:id").setLong("id", var1.getFcfId()).executeUpdate();
      return "";
   }

   public String deleteOneLigne(FactureLigneAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from FactureLigneAchats where fcfligId =" + var1.getFcfligId());
      var3.executeUpdate();
      return null;
   }

   public void duppliquerLigne(List var1, FactureEnteteAchats var2, Session var3) {
      LigneDocument var4 = new LigneDocument();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         FactureLigneAchats var6 = (FactureLigneAchats)var1.get(var5);
         var4.setLigCode(var6.getFcfligCode());
         var4.setLigFamille(var6.getFcfligFamille());
         var4.setLigLibelle(var6.getFcfligLibelle());
         var4.setLigReference(var6.getFcfligReference());
         var4.setLigTaxe(var6.getFcfligTaxe());
         var4.setLigTauxTaxe(var6.getFcfligTauxTaxe());
         var4.setLigUnite(var6.getFcfligUnite());
         var4.setLigQte(var6.getFcfligQte());
         var4.setLigDevise(var6.getFcfligDevise());
         var4.setLigPu(var6.getFcfligPu());
         var4.setLigTauxRemise(var6.getFcfligTauxRemise());
         var4.setLigRabais(var6.getFcfligRabais());
         var4.setLigPuRem(var6.getFcfligPuRem());
         var4.setLigPt(var6.getFcfligPt());
         var4.setLigTva(var6.getFcfligTva());
         var4.setLigTc(var6.getFcfligTc());
         var4.setLigTtc(var6.getFcfligTtc());
         var4.setLigPr(var6.getFcfligPr());
         var4.setLigPump(var6.getFcfligPump());
         var4.setLigDepot("");
         var4.setLigLot("");
         var4.setLigNumSerie("");
         var4.setLigQteStock(0.0F);
         FactureLigneAchats var7 = new FactureLigneAchats();
         var7.setFactureEnteteAchats(var2);
         var7.setFcfligCode(var4.getLigCode());
         var7.setFcfligFamille(var4.getLigFamille());
         var7.setFcfligLibelle(var4.getLigLibelle());
         var7.setFcfligReference(var4.getLigReference());
         var7.setFcfligTaxe(var4.getLigTaxe());
         var7.setFcfligTauxTaxe(var4.getLigTauxTaxe());
         var7.setFcfligUnite(var4.getLigUnite());
         var7.setFcfligQte(var4.getLigQte());
         var7.setFcfligDevise(var4.getLigDevise());
         var7.setFcfligPu(var4.getLigPu());
         var7.setFcfligTauxRemise(var4.getLigTauxRemise());
         var7.setFcfligRabais(var4.getLigRabais());
         var7.setFcfligPuRem(var4.getLigPuRem());
         var7.setFcfligPt(var4.getLigPt());
         var7.setFcfligTva(var4.getLigTva());
         var7.setFcfligTc(var4.getLigTc());
         var7.setFcfligTtc(var4.getLigTtc());
         var7.setFcfligPr(var4.getLigPr());
         var7.setFcfligPump(var4.getLigPump());
         var3.save(var7);
      }

   }

   public void saveLigne(List var1, FactureEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         FactureLigneAchats var5 = (FactureLigneAchats)var1.get(var4);
         var5.setFactureEnteteAchats(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(FactureEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from FactureLigneAchats where factureEnteteAchats=:idfk order by fcfligId").setLong("idfk", var1.getFcfId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesFactures(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from FactureLigneAchats where factureEnteteAchats.fcfNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, String var7, Session var8) {
      List var9 = null;
      String var10 = "";
      if (var1 != null && !var1.isEmpty()) {
         var10 = var10 + " factureEnteteAchats.fcfSerie='" + var1 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var10 = var10 + " factureEnteteAchats.tiers.tiecompte0='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var10 = var10 + " factureEnteteAchats.fcfActivite='" + var3 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var10 = var10 + " factureEnteteAchats.fcfService='" + var4 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var9 = var8.createQuery("select factureEnteteAchats.fcfEtat,factureEnteteAchats.fcfNum,factureEnteteAchats.fcfSerie,factureEnteteAchats.fcfDiversNom,factureEnteteAchats.fcfNomTiers,factureEnteteAchats.fcfDate,factureEnteteAchats.fcfDevise,fcfligId,fcfligDepot,fcfligCode,fcfligFamille,fcfligLibelle,fcfligQte,fcfligQteUtil,fcfligPu,fcfligPt,fcfligPr,fcfligPump,fcfligPoidsBrut from FactureLigneAchats where " + var10 + " fcfligCode in " + var2 + " and factureEnteteAchats.fcfDate>='" + var5 + "' and factureEnteteAchats.fcfDate<='" + var6 + "'").list();
         } else {
            var9 = var8.createQuery("select factureEnteteAchats.fcfEtat,factureEnteteAchats.fcfNum,factureEnteteAchats.fcfSerie,factureEnteteAchats.fcfDiversNom,factureEnteteAchats.fcfNomTiers,factureEnteteAchats.fcfDate,factureEnteteAchats.fcfDevise,fcfligId,fcfligDepot,fcfligCode,fcfligFamille,fcfligLibelle,fcfligQte,fcfligQteUtil,fcfligPu,fcfligPt,fcfligPr,fcfligPump,fcfligPoidsBrut from FactureLigneAchats where " + var10 + " fcfligCode='" + var2 + "' and factureEnteteAchats.fcfDate>='" + var5 + "' and factureEnteteAchats.fcfDate<='" + var6 + "'").list();
         }
      } else {
         var9 = var8.createQuery("select factureEnteteAchats.fcfEtat,factureEnteteAchats.fcfNum,factureEnteteAchats.fcfSerie,factureEnteteAchats.fcfDiversNom,factureEnteteAchats.fcfNomTiers,factureEnteteAchats.fcfDate,factureEnteteAchats.fcfDevise,fcfligId,fcfligDepot,fcfligCode,fcfligFamille,fcfligLibelle,fcfligQte,fcfligQteUtil,fcfligPu,fcfligPt,fcfligPr,fcfligPump,fcfligPoidsBrut from FactureLigneAchats where " + var10 + " factureEnteteAchats.fcfDate>='" + var5 + "' and factureEnteteAchats.fcfDate<='" + var6 + "'").list();
      }

      return var9;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from FactureLigneAchats where fcfligCode='" + var1 + "'").list();
      return var3;
   }

   public float chargerLesReliquatsCommandeAchats(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureLigneAchats where fcfligIdCmd=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((FactureLigneAchats)var6.get(var8)).getFcfligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsReceptionAchats(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureLigneAchats where fcfligIdRec=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((FactureLigneAchats)var6.get(var8)).getFcfligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from FactureLigneAchats where factureEnteteAchats.tiers.tieid=" + var1.getTieid() + " and factureEnteteAchats.fcfDate between '" + var2 + "' and '" + var3 + "' and factureEnteteAchats.fcfSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from FactureLigneAchats where factureEnteteAchats.tiers.tieid=" + var1.getTieid() + " and factureEnteteAchats.fcfDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureLigneAchats where factureEnteteAchats.fcfIdResponsable=" + var1.getUsrid() + " and factureEnteteAchats.fcfDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FactureLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FactureLigneAchats rechercheFacture(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.factureLigneAchats = new FactureLigneAchats();
      var6 = var3.createQuery("from FactureLigneAchats where fcfligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.factureLigneAchats = (FactureLigneAchats)var6.get(0);
      } else {
         this.factureLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureLigneAchats;
   }
}
