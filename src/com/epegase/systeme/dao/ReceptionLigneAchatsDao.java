package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
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
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReceptionLigneAchatsDao implements Serializable {
   private ReceptionLigneAchats receptionLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ReceptionLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ReceptionLigneAchats insertLigne(ReceptionLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReceptionLigneAchats modifLigne(ReceptionLigneAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
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

   public ReceptionLigneAchats modifLigne(ReceptionLigneAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteAllLigne(ReceptionEnteteAchats var1, Session var2) {
      var2.createQuery("delete from ReceptionLigneAchats where receptionEnteteAchats=:id").setLong("id", var1.getRecId()).executeUpdate();
   }

   public void deleteOneLigne(ReceptionLigneAchats var1, Session var2) {
      var2.delete(var1);
   }

   public void duppliquerLigne(List var1, ReceptionEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         ReceptionLigneAchats var5 = (ReceptionLigneAchats)var1.get(var4);
         LigneDocument var6 = new LigneDocument();
         var6.setLigCode(var5.getRecligCode());
         var6.setLigFamille(var5.getRecligFamille());
         var6.setLigLibelle(var5.getRecligLibelle());
         var6.setLigReference(var5.getRecligReference());
         var6.setLigTaxe(var5.getRecligTaxe());
         var6.setLigTauxTaxe(var5.getRecligTauxTaxe());
         var6.setLigUnite(var5.getRecligUnite());
         var6.setLigQte(var5.getRecligQte());
         var6.setLigDevise(var5.getRecligDevise());
         var6.setLigPu(var5.getRecligPu());
         var6.setLigTauxRemise(var5.getRecligTauxRemise());
         var6.setLigRabais(var5.getRecligRabais());
         var6.setLigPuRem(var5.getRecligPuRem());
         var6.setLigPt(var5.getRecligPt());
         var6.setLigTva(var5.getRecligTva());
         var6.setLigTc(var5.getRecligTc());
         var6.setLigTtc(var5.getRecligTtc());
         var6.setLigPr(var5.getRecligPr());
         var6.setLigPump(var5.getRecligPump());
         var6.setLigDepot(var5.getRecligDepot());
         var6.setLigLot("");
         var6.setLigNumSerie("");
         var6.setLigQteStock(var5.getRecligQteStock());
         ReceptionLigneAchats var7 = new ReceptionLigneAchats();
         var7.setReceptionEnteteAchats(var2);
         var7.setRecligCode(var6.getLigCode());
         var7.setRecligFamille(var6.getLigFamille());
         var7.setRecligLibelle(var6.getLigLibelle());
         var7.setRecligReference(var6.getLigReference());
         var7.setRecligTaxe(var6.getLigTaxe());
         var7.setRecligTauxTaxe(var6.getLigTauxTaxe());
         var7.setRecligUnite(var6.getLigUnite());
         var7.setRecligQte(var6.getLigQte());
         var7.setRecligDevise(var6.getLigDevise());
         var7.setRecligPu(var6.getLigPu());
         var7.setRecligTauxRemise(var6.getLigTauxRemise());
         var7.setRecligRabais(var6.getLigRabais());
         var7.setRecligPuRem(var6.getLigPuRem());
         var7.setRecligPt(var6.getLigPt());
         var7.setRecligTva(var6.getLigTva());
         var7.setRecligTc(var6.getLigTc());
         var7.setRecligTtc(var6.getLigTtc());
         var7.setRecligPr(var6.getLigPr());
         var7.setRecligPump(var6.getLigPump());
         var7.setRecligDepot(var6.getLigDepot());
         var7.setRecligQteStock(var6.getLigQteStock());
         var3.save(var7);
      }

   }

   public void duppliquerNegatifLigne(List var1, ReceptionEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         ReceptionLigneAchats var5 = (ReceptionLigneAchats)var1.get(var4);
         LigneDocument var6 = new LigneDocument();
         var6.setLigCode(var5.getRecligCode());
         var6.setLigFamille(var5.getRecligFamille());
         var6.setLigLibelle(var5.getRecligLibelle());
         var6.setLigReference(var5.getRecligReference());
         var6.setLigTaxe(var5.getRecligTaxe());
         var6.setLigTauxTaxe(var5.getRecligTauxTaxe());
         var6.setLigUnite(var5.getRecligUnite());
         var6.setLigQte(var5.getRecligQte() * -1.0F);
         var6.setLigQteUtil(var5.getRecligQteUtil() * -1.0F);
         var6.setLigDevise(var5.getRecligDevise());
         var6.setLigPu(var5.getRecligPu());
         var6.setLigTauxRemise(var5.getRecligTauxRemise());
         var6.setLigRabais(var5.getRecligRabais());
         var6.setLigPuRem(var5.getRecligPuRem());
         var6.setLigPt(var5.getRecligPt() * -1.0D);
         var6.setLigTva(var5.getRecligTva() * -1.0D);
         var6.setLigTc(var5.getRecligTc());
         var6.setLigTtc(var5.getRecligTtc() * -1.0D);
         var6.setLigPr(var5.getRecligPr() * -1.0D);
         var6.setLigPump(var5.getRecligPump() * -1.0D);
         var6.setLigDepot(var5.getRecligDepot());
         var6.setLigLot("");
         var6.setLigNumSerie("");
         var6.setLigQteStock(var5.getRecligQteStock());
         ReceptionLigneAchats var7 = new ReceptionLigneAchats();
         var7.setReceptionEnteteAchats(var2);
         var7.setRecligCode(var6.getLigCode());
         var7.setRecligFamille(var6.getLigFamille());
         var7.setRecligLibelle(var6.getLigLibelle());
         var7.setRecligReference(var6.getLigReference());
         var7.setRecligTaxe(var6.getLigTaxe());
         var7.setRecligTauxTaxe(var6.getLigTauxTaxe());
         var7.setRecligUnite(var6.getLigUnite());
         var7.setRecligQte(var6.getLigQte());
         var7.setRecligQteUtil(var6.getLigQteUtil());
         var7.setRecligDevise(var6.getLigDevise());
         var7.setRecligPu(var6.getLigPu());
         var7.setRecligTauxRemise(var6.getLigTauxRemise());
         var7.setRecligRabais(var6.getLigRabais());
         var7.setRecligPuRem(var6.getLigPuRem());
         var7.setRecligPt(var6.getLigPt());
         var7.setRecligTva(var6.getLigTva());
         var7.setRecligTc(var6.getLigTc());
         var7.setRecligTtc(var6.getLigTtc());
         var7.setRecligPr(var6.getLigPr());
         var7.setRecligPump(var6.getLigPump());
         var7.setRecligDepot(var6.getLigDepot());
         var7.setRecligQteStock(var6.getLigQteStock());
         var3.save(var7);
      }

   }

   public void saveLigne(List var1, ReceptionEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         ReceptionLigneAchats var5 = (ReceptionLigneAchats)var1.get(var4);
         var5.setReceptionEnteteAchats(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(ReceptionEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReceptionLigneAchats where receptionEnteteAchats=:idfk order by recligId").setLong("idfk", var1.getRecId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from ReceptionLigneAchats where recligCode='" + var1 + "' and recligDepot='" + var2 + "' and receptionEnteteAchats.recDate >'" + var3 + "' order by receptionEnteteAchats.recDate").list();
      return var5;
   }

   public List chargerLesLignes(String var1, String var2, String var3, Session var4) {
      List var5 = var4.createQuery("from ReceptionLigneAchats where recligCode='" + var1 + "' and receptionEnteteAchats.recDate>='" + var2 + "' and receptionEnteteAchats.recDate<='" + var3 + "' and (receptionEnteteAchats.recEtat=1 or receptionEnteteAchats.recEtat=4 or receptionEnteteAchats.recEtat=5) order by receptionEnteteAchats.recDate").list();
      return var5;
   }

   public List chargerLesMvts(String var1, String var2, long var3, Session var5) {
      List var6 = null;
      String var7 = "";
      if (var2 != null && !var2.isEmpty()) {
         var7 = var7 + " recligDepot='" + var2 + "' and ";
      }

      if (var3 != 0L) {
         var7 = var7 + " receptionEnteteAchats.recIdEquipe=" + var3 + " and ";
      }

      var6 = var5.createQuery("from ReceptionLigneAchats where " + var7 + " recligCode='" + var1 + "' order by receptionEnteteAchats.recDate desc").list();
      return var6;
   }

   public List chargerLesMvts(String var1, String var2, Session var3) {
      List var4 = null;
      String var5 = "";
      if (var2 != null && !var2.isEmpty()) {
         var5 = var5 + " recligDepot='" + var2 + "' and ";
      }

      var4 = var3.createQuery("from ReceptionLigneAchats where " + var5 + " recligCode='" + var1 + "' order by receptionEnteteAchats.recDate desc").list();
      return var4;
   }

   public List chargerLesLignesReceptions(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReceptionLigneAchats where receptionEnteteAchats.recNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, String var7, Session var8) {
      List var9 = null;
      String var10 = "";
      if (var1 != null && !var1.isEmpty()) {
         var10 = var10 + " receptionEnteteAchats.recSerie='" + var1 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var10 = var10 + " receptionEnteteAchats.recActivite='" + var4 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var10 = var10 + " receptionEnteteAchats.recService='" + var5 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var10 = var10 + " recligDepot='" + var3 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var9 = var8.createQuery("select receptionEnteteAchats.recEtat,receptionEnteteAchats.recNum,receptionEnteteAchats.recSerie,receptionEnteteAchats.recDiversNom,receptionEnteteAchats.recNomTiers,receptionEnteteAchats.recDate,receptionEnteteAchats.recDevise,recligId,recligDepot,recligCode,recligFamille,recligLibelle,recligQte,recligQteUtil,recligPu,recligPt,recligPrU,recligPump,recligPoidsBrut,receptionEnteteAchats.recObject,receptionEnteteAchats.recAnal4,receptionEnteteAchats.recCoefDevise,recligCoefPr,recligPrKg from ReceptionLigneAchats where " + var10 + " recligCode in " + var2 + " and receptionEnteteAchats.recDate between '" + var6 + "' and '" + var7 + "'").list();
         } else {
            var9 = var8.createQuery("select receptionEnteteAchats.recEtat,receptionEnteteAchats.recNum,receptionEnteteAchats.recSerie,receptionEnteteAchats.recDiversNom,receptionEnteteAchats.recNomTiers,receptionEnteteAchats.recDate,receptionEnteteAchats.recDevise,recligId,recligDepot,recligCode,recligFamille,recligLibelle,recligQte,recligQteUtil,recligPu,recligPt,recligPrU,recligPump,recligPoidsBrut,receptionEnteteAchats.recObject,receptionEnteteAchats.recAnal4,receptionEnteteAchats.recCoefDevise,recligCoefPr,recligPrKg from ReceptionLigneAchats where " + var10 + " recligCode='" + var2 + "' and receptionEnteteAchats.recDate between '" + var6 + "' and '" + var7 + "'").list();
         }
      } else {
         var9 = var8.createQuery("select receptionEnteteAchats.recEtat,receptionEnteteAchats.recNum,receptionEnteteAchats.recSerie,receptionEnteteAchats.recDiversNom,receptionEnteteAchats.recNomTiers,receptionEnteteAchats.recDate,receptionEnteteAchats.recDevise,recligId,recligDepot,recligCode,recligFamille,recligLibelle,recligQte,recligQteUtil,recligPu,recligPt,recligPrU,recligPump,recligPoidsBrut,receptionEnteteAchats.recObject,receptionEnteteAchats.recAnal4,receptionEnteteAchats.recCoefDevise,recligCoefPr,recligPrKg from ReceptionLigneAchats where " + var10 + " receptionEnteteAchats.recDate between '" + var6 + "' and '" + var7 + "'").list();
      }

      return var9;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from ReceptionLigneAchats where recligCode='" + var1 + "' order by receptionEnteteAchats.recDate desc").list();
      return var3;
   }

   public float chargerLesReliquatsCommandeAchs(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from ReceptionLigneAchats where recligIdCmd=:idCmd").setLong("idCmd", var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((ReceptionLigneAchats)var6.get(var8)).getRecligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheReceptionRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ReceptionLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from ReceptionLigneAchats where receptionEnteteAchats.tiers.tieid=" + var1.getTieid() + " and receptionEnteteAchats.recDate between '" + var2 + "' and '" + var3 + "' and receptionEnteteAchats.recSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from ReceptionLigneAchats where receptionEnteteAchats.tiers.tieid=" + var1.getTieid() + " and receptionEnteteAchats.recDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ReceptionLigneAchats where receptionEnteteAchats.recIdResponsable=" + var1.getUsrid() + " and receptionEnteteAchats.recDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesLignes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReceptionLigneAchats where recligSommier=:som").setString("som", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ReceptionLigneAchats rechercheBefore(Date var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var5 = true;
      }

      new ArrayList();
      List var7 = var4.createQuery("from ReceptionLigneAchats where recligCode =:prd and recligDepot =:dep and receptionEnteteAchats.recDate <'" + var1 + "' order by receptionEnteteAchats.recDate desc").setString("prd", var2).setString("dep", var3).setMaxResults(1).list();
      if (var7.size() != 0) {
         this.receptionLigneAchats = (ReceptionLigneAchats)var7.get(0);
      } else {
         this.receptionLigneAchats = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.receptionLigneAchats;
   }

   public ReceptionLigneAchats rechercheNext(Date var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var5 = true;
      }

      new ArrayList();
      List var7 = var4.createQuery("from ReceptionLigneAchats where recligCode =:prd and recligDepot =:dep and receptionEnteteAchats.recDate >'" + var1 + "' order by receptionEnteteAchats.recDate").setString("prd", var2).setString("dep", var3).setMaxResults(1).list();
      if (var7.size() != 0) {
         this.receptionLigneAchats = (ReceptionLigneAchats)var7.get(0);
      } else {
         this.receptionLigneAchats = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return this.receptionLigneAchats;
   }

   public ReceptionLigneAchats rechercheReception(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.receptionLigneAchats = new ReceptionLigneAchats();
      var6 = var3.createQuery("from ReceptionLigneAchats where recligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.receptionLigneAchats = (ReceptionLigneAchats)var6.get(0);
      } else {
         this.receptionLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.receptionLigneAchats;
   }

   public ReceptionLigneAchats rechercheReception(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      this.receptionLigneAchats = new ReceptionLigneAchats();
      var5 = var2.createQuery("from ReceptionLigneAchats where recligCode='" + var1 + "'").setMaxResults(1).list();
      if (var5.size() != 0) {
         this.receptionLigneAchats = (ReceptionLigneAchats)var5.get(0);
      } else {
         this.receptionLigneAchats = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.receptionLigneAchats;
   }
}
