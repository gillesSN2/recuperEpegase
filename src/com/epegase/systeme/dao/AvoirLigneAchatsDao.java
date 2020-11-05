package com.epegase.systeme.dao;

import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirLigneAchats;
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

public class AvoirLigneAchatsDao implements Serializable {
   private AvoirLigneAchats avoirLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public AvoirLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public AvoirLigneAchats insertLigne(AvoirLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public AvoirLigneAchats modifLigne(AvoirLigneAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(AvoirLigneAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from AvoirLigneAchats where avfligId =" + var1.getAvfligId());
      var3.executeUpdate();
      return "";
   }

   public String deleteAllLigne(AvoirEnteteAchats var1, Session var2) {
      var2.createQuery("delete from AvoirLigneAchats where avoirEnteteAchats=:id").setLong("id", var1.getAvfId()).executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, AvoirEnteteAchats var2, Session var3) {
      LigneDocument var4 = new LigneDocument();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         AvoirLigneAchats var6 = (AvoirLigneAchats)var1.get(var5);
         var4.setLigCode(var6.getAvfligCode());
         var4.setLigFamille(var6.getAvfligFamille());
         var4.setLigLibelle(var6.getAvfligLibelle());
         var4.setLigReference(var6.getAvfligReference());
         var4.setLigTaxe(var6.getAvfligTaxe());
         var4.setLigTauxTaxe(var6.getAvfligTauxTaxe());
         var4.setLigUnite(var6.getAvfligUnite());
         var4.setLigQte(var6.getAvfligQte());
         var4.setLigDevise(var6.getAvfligDevise());
         var4.setLigPu(var6.getAvfligPu());
         var4.setLigTauxRemise(var6.getAvfligTauxRemise());
         var4.setLigRabais(var6.getAvfligRabais());
         var4.setLigPuRem(var6.getAvfligPuRem());
         var4.setLigPt(var6.getAvfligPt());
         var4.setLigTva(var6.getAvfligTva());
         var4.setLigTc(var6.getAvfligTc());
         var4.setLigTtc(var6.getAvfligTtc());
         var4.setLigPr(var6.getAvfligPr());
         var4.setLigPump(var6.getAvfligPump());
         var4.setLigDepot("");
         var4.setLigLot("");
         var4.setLigNumSerie("");
         var4.setLigQteStock(0.0F);
         AvoirLigneAchats var7 = new AvoirLigneAchats();
         var7.setAvoirEnteteAchats(var2);
         var7.setAvfligCode(var4.getLigCode());
         var7.setAvfligFamille(var4.getLigFamille());
         var7.setAvfligLibelle(var4.getLigLibelle());
         var7.setAvfligReference(var4.getLigReference());
         var7.setAvfligTaxe(var4.getLigTaxe());
         var7.setAvfligTauxTaxe(var4.getLigTauxTaxe());
         var7.setAvfligUnite(var4.getLigUnite());
         var7.setAvfligQte(var4.getLigQte());
         var7.setAvfligDevise(var4.getLigDevise());
         var7.setAvfligPu(var4.getLigPu());
         var7.setAvfligTauxRemise(var4.getLigTauxRemise());
         var7.setAvfligRabais(var4.getLigRabais());
         var7.setAvfligPuRem(var4.getLigPuRem());
         var7.setAvfligPt(var4.getLigPt());
         var7.setAvfligTva(var4.getLigTva());
         var7.setAvfligTc(var4.getLigTc());
         var7.setAvfligTtc(var4.getLigTtc());
         var7.setAvfligPr(var4.getLigPr());
         var7.setAvfligPump(var4.getLigPump());
         var3.save(var7);
      }

   }

   public void saveLigne(List var1, AvoirEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         AvoirLigneAchats var5 = (AvoirLigneAchats)var1.get(var4);
         var5.setAvoirEnteteAchats(var2);
         var3.save(var5);
      }

   }

   public float chargerLesReliquatsFacturesAchs(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from AvoirLigneAchats where avfligIdFcf=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((AvoirLigneAchats)var6.get(var8)).getAvfligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsNoteDebitAchs(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from AvoirLigneAchats where avfligIdNdf=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((AvoirLigneAchats)var6.get(var8)).getAvfligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesLignes(AvoirEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from AvoirLigneAchats where avoirEnteteAchats=:idfk order by avfligOrdre,avfligId").setLong("idfk", var1.getAvfId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesAvoirs(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from AvoirLigneAchats where avoirEnteteAchats.avfNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, Session var7) throws HibernateException, NamingException {
      List var8 = null;
      String var9 = "";
      if (var1 != null && !var1.isEmpty()) {
         var9 = var9 + " avoirEnteteAchats.avfSerie='" + var1 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var9 = var9 + " avoirEnteteAchats.avfActivite='" + var3 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var9 = var9 + " avoirEnteteAchats.avfService='" + var4 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var8 = var7.createQuery("select avoirEnteteAchats.avfEtat,avoirEnteteAchats.avfNum,avoirEnteteAchats.avfSerie,avoirEnteteAchats.avfDiversNom,avoirEnteteAchats.avfNomTiers,avoirEnteteAchats.avfDate,avoirEnteteAchats.avfDevise,avfligId,avfligDescription,avfligCode,avfligFamille,avfligLibelle,avfligQte,avfligQteUtil,avfligPu,avfligPt,avfligPr,avfligPump,avfligPoidsBrut from AvoirLigneAchats where " + var9 + " avfligCode in " + var2 + " and avoirEnteteAchats.avfDate>='" + var5 + "' and avoirEnteteAchats.avfDate<='" + var6 + "'").list();
         } else {
            var8 = var7.createQuery("select avoirEnteteAchats.avfEtat,avoirEnteteAchats.avfNum,avoirEnteteAchats.avfSerie,avoirEnteteAchats.avfDiversNom,avoirEnteteAchats.avfNomTiers,avoirEnteteAchats.avfDate,avoirEnteteAchats.avfDevise,avfligId,avfligDescription,avfligCode,avfligFamille,avfligLibelle,avfligQte,avfligQteUtil,avfligPu,avfligPt,avfligPr,avfligPump,avfligPoidsBrut from AvoirLigneAchats where " + var9 + " avfligCode='" + var2 + "' and avoirEnteteAchats.avfDate>='" + var5 + "' and avoirEnteteAchats.avfDate<='" + var6 + "'").list();
         }
      } else {
         var8 = var7.createQuery("select avoirEnteteAchats.avfEtat,avoirEnteteAchats.avfNum,avoirEnteteAchats.avfSerie,avoirEnteteAchats.avfDiversNom,avoirEnteteAchats.avfNomTiers,avoirEnteteAchats.avfDate,avoirEnteteAchats.avfDevise,avfligId,avfligDescription,avfligCode,avfligFamille,avfligLibelle,avfligQte,avfligQteUtil,avfligPu,avfligPt,avfligPr,avfligPump,avfligPoidsBrut from AvoirLigneAchats where " + var9 + " avoirEnteteAchats.avfDate>='" + var5 + "' and avoirEnteteAchats.avfDate<='" + var6 + "'").list();
      }

      return var8;
   }

   public List chargerLesMvts(String var1, Session var2) throws HibernateException, NamingException {
      List var3 = null;
      var3 = var2.createQuery("from AvoirLigneAchats where avfligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from AvoirLigneAchats where avoirEnteteAchats.tiers.tieid=" + var1.getTieid() + " and avoirEnteteAchats.avfDate between '" + var2 + "' and '" + var3 + "' and avoirEnteteAchats.avfSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from AvoirLigneAchats where avoirEnteteAchats.tiers.tieid=" + var1.getTieid() + " and avoirEnteteAchats.avfDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from AvoirLigneAchats where avoirEnteteAchats.avfIdResponsable=" + var1.getUsrid() + " and avoirEnteteAchats.avfDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheAvoirRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from AvoirLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public AvoirLigneAchats rechercheAvoir(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "AvoirEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.avoirLigneAchats = new AvoirLigneAchats();
      var6 = var3.createQuery("from AvoirLigneAchats where avfligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.avoirLigneAchats = (AvoirLigneAchats)var6.get(0);
      } else {
         this.avoirLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.avoirLigneAchats;
   }
}
