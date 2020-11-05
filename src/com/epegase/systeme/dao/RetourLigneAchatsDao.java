package com.epegase.systeme.dao;

import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.LigneDocument;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class RetourLigneAchatsDao implements Serializable {
   private RetourLigneAchats retourLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public RetourLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public RetourLigneAchats insertLigne(RetourLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public RetourLigneAchats modifLigne(RetourLigneAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(RetourLigneAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from RetourLigneAchats where brfligId =" + var1.getBrfligId());
      var3.executeUpdate();
      return null;
   }

   public String deleteAllLigne(RetourEnteteAchats var1, Session var2) {
      var2.createQuery("delete from RetourLigneAchats where retourEnteteAchats=:id").setLong("id", var1.getBrfId()).executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, RetourEnteteAchats var2, Session var3) {
      LigneDocument var4 = new LigneDocument();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         RetourLigneAchats var6 = (RetourLigneAchats)var1.get(var5);
         var4.setLigCode(var6.getBrfligCode());
         var4.setLigFamille(var6.getBrfligFamille());
         var4.setLigLibelle(var6.getBrfligLibelle());
         var4.setLigReference(var6.getBrfligReference());
         var4.setLigTaxe(var6.getBrfligTaxe());
         var4.setLigTauxTaxe(var6.getBrfligTauxTaxe());
         var4.setLigUnite(var6.getBrfligUnite());
         var4.setLigQte(var6.getBrfligQte());
         var4.setLigDevise(var6.getBrfligDevise());
         var4.setLigPu(var6.getBrfligPu());
         var4.setLigTauxRemise(var6.getBrfligTauxRemise());
         var4.setLigRabais(var6.getBrfligRabais());
         var4.setLigPuRem(var6.getBrfligPuRem());
         var4.setLigPt(var6.getBrfligPt());
         var4.setLigTva(var6.getBrfligTva());
         var4.setLigTc(var6.getBrfligTc());
         var4.setLigTtc(var6.getBrfligTtc());
         var4.setLigPr(var6.getBrfligPr());
         var4.setLigPump(var6.getBrfligPump());
         var4.setLigDepot(var6.getBrfligDepot());
         var4.setLigLot("");
         var4.setLigNumSerie("");
         var4.setLigQteStock(var6.getBrfligQteStock());
         RetourLigneAchats var7 = new RetourLigneAchats();
         var7.setRetourEnteteAchats(var2);
         var7.setBrfligCode(var4.getLigCode());
         var7.setBrfligFamille(var4.getLigFamille());
         var7.setBrfligLibelle(var4.getLigLibelle());
         var7.setBrfligReference(var4.getLigReference());
         var7.setBrfligTaxe(var4.getLigTaxe());
         var7.setBrfligTauxTaxe(var4.getLigTauxTaxe());
         var7.setBrfligUnite(var4.getLigUnite());
         var7.setBrfligQte(var4.getLigQte());
         var7.setBrfligDevise(var4.getLigDevise());
         var7.setBrfligPu(var4.getLigPu());
         var7.setBrfligTauxRemise(var4.getLigTauxRemise());
         var7.setBrfligRabais(var4.getLigRabais());
         var7.setBrfligPuRem(var4.getLigPuRem());
         var7.setBrfligPt(var4.getLigPt());
         var7.setBrfligTva(var4.getLigTva());
         var7.setBrfligTc(var4.getLigTc());
         var7.setBrfligTtc(var4.getLigTtc());
         var7.setBrfligPr(var4.getLigPr());
         var7.setBrfligPump(var4.getLigPump());
         var7.setBrfligDepot(var4.getLigDepot());
         var7.setBrfligQteStock(var4.getLigQteStock());
         var3.save(var7);
      }

   }

   public void saveLigne(List var1, RetourEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         RetourLigneAchats var5 = (RetourLigneAchats)var1.get(var4);
         var5.setRetourEnteteAchats(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(RetourEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from RetourLigneAchats where retourEnteteAchats=:idfk order by brfligId").setLong("idfk", var1.getBrfId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from RetourLigneAchats where brfligCode='" + var1 + "' and brfligDepot='" + var2 + "' and retourEnteteAchats.brfDate >'" + var3 + "'").list();
      return var5;
   }

   public List chargerLesLignesRetours(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from RetourLigneAchats where retourEnteteAchats.brfNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, String var7, Session var8) {
      List var9 = null;
      String var10 = "";
      if (var1 != null && !var1.isEmpty()) {
         var10 = var10 + " retourEnteteAchats.brfSerie='" + var1 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var10 = var10 + " retourEnteteAchats.brfActivite='" + var4 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var10 = var10 + " retourEnteteAchats.brfService='" + var5 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var10 = var10 + " brfligDepot='" + var3 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var9 = var8.createQuery("select retourEnteteAchats.brfEtat,retourEnteteAchats.brfNum,retourEnteteAchats.brfSerie,retourEnteteAchats.brfDiversNom,retourEnteteAchats.brfNomTiers,retourEnteteAchats.brfDate,retourEnteteAchats.brfDevise,brfligId,brfligDepot,brfligCode,brfligFamille,brfligLibelle,brfligQte,brfligQteUtil,brfligPu,brfligPt,brfligPr,brfligPump,brfligPoidsBrut from RetourLigneAchats where " + var10 + " brfligCode in " + var2 + " and retourEnteteAchats.brfDate between '" + var6 + "' and '" + var7 + "'").list();
         } else {
            var9 = var8.createQuery("select retourEnteteAchats.brfEtat,retourEnteteAchats.brfNum,retourEnteteAchats.brfSerie,retourEnteteAchats.brfDiversNom,retourEnteteAchats.brfNomTiers,retourEnteteAchats.brfDate,retourEnteteAchats.brfDevise,brfligId,brfligDepot,brfligCode,brfligFamille,brfligLibelle,brfligQte,brfligQteUtil,brfligPu,brfligPt,brfligPr,brfligPump,brfligPoidsBrut from RetourLigneAchats where " + var10 + " brfligCode='" + var2 + "' and retourEnteteAchats.brfDate between '" + var6 + "' and '" + var7 + "'").list();
         }
      } else {
         var9 = var8.createQuery("select retourEnteteAchats.brfEtat,retourEnteteAchats.brfNum,retourEnteteAchats.brfSerie,retourEnteteAchats.brfDiversNom,retourEnteteAchats.brfNomTiers,retourEnteteAchats.brfDate,retourEnteteAchats.brfDevise,brfligId,brfligDepot,brfligCode,brfligFamille,brfligLibelle,brfligQte,brfligQteUtil,brfligPu,brfligPt,brfligPr,brfligPump,brfligPoidsBrut from RetourLigneAchats where " + var10 + " retourEnteteAchats.brfDate between '" + var6 + "' and '" + var7 + "'").list();
      }

      return var9;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from RetourLigneAchats where brfligCode='" + var1 + "'").list();
      return var3;
   }

   public float chargerLesReliquatsReceptionAchs(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from RetourLigneAchats where brfligIdRec=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((RetourLigneAchats)var6.get(var8)).getBrfligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheRetourRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from RetourLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from RetourLigneAchats where retourEnteteAchats.tiers.tieid=" + var1.getTieid() + " and retourEnteteAchats.brfDate between '" + var2 + "' and '" + var3 + "' and retourEnteteAchats.brfSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from RetourLigneAchats where retourEnteteAchats.tiers.tieid=" + var1.getTieid() + " and retourEnteteAchats.brfDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from RetourLigneAchats where retourEnteteAchats.brfIdResponsable=" + var1.getUsrid() + " and retourEnteteAchats.brfDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public RetourLigneAchats rechercheRetour(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.retourLigneAchats = new RetourLigneAchats();
      var6 = var3.createQuery("from retourEnteteAchats where brfligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.retourLigneAchats = (RetourLigneAchats)var6.get(0);
      } else {
         this.retourLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.retourLigneAchats;
   }
}
