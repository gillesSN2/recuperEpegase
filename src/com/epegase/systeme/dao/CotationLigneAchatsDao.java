package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.CotationLigneAchats;
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
import org.hibernate.Transaction;

public class CotationLigneAchatsDao implements Serializable {
   private CotationLigneAchats cotationLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CotationLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CotationLigneAchats insertLigne(CotationLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CotationLigneAchats modif(CotationLigneAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
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

   public CotationLigneAchats modifLigne(CotationLigneAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteAllLigne(CotationEnteteAchats var1, Session var2) {
      var2.createQuery("delete from CotationLigneAchats where cotationEnteteAchats=:id").setLong("id", var1.getCotId()).executeUpdate();
      return "";
   }

   public String deleteOneligne(CotationLigneAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from CotationLigneAchats where cotligId =" + var1.getCotligId());
      var3.executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, CotationEnteteAchats var2, Session var3) {
      LigneDocument var4 = new LigneDocument();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         CotationLigneAchats var6 = (CotationLigneAchats)var1.get(var5);
         var4.setLigCode(var6.getCotligCode());
         var4.setLigFamille(var6.getCotligFamille());
         var4.setLigLibelle(var6.getCotligLibelle());
         var4.setLigReference(var6.getCotligReference());
         var4.setLigTaxe(var6.getCotligTaxe());
         var4.setLigTauxTaxe(var6.getCotligTauxTaxe());
         var4.setLigUnite(var6.getCotligUnite());
         var4.setLigQte(var6.getCotligQte());
         var4.setLigDevise(var6.getCotligDevise());
         var4.setLigPu(var6.getCotligPu());
         var4.setLigTauxRemise(var6.getCotligTauxRemise());
         var4.setLigRabais(var6.getCotligRabais());
         var4.setLigPuRem(var6.getCotligPuRem());
         var4.setLigPt(var6.getCotligPt());
         var4.setLigTva(var6.getCotligTva());
         var4.setLigTc(var6.getCotligTc());
         var4.setLigTtc(var6.getCotligTtc());
         var4.setLigPr(var6.getCotligPr());
         var4.setLigPump(var6.getCotligPump());
         var4.setLigDepot("");
         var4.setLigLot("");
         var4.setLigNumSerie("");
         var4.setLigQteStock(0.0F);
         CotationLigneAchats var7 = new CotationLigneAchats();
         var7.setCotationEnteteAchats(var2);
         var7.setCotligCode(var4.getLigCode());
         var7.setCotligFamille(var4.getLigFamille());
         var7.setCotligLibelle(var4.getLigLibelle());
         var7.setCotligReference(var4.getLigReference());
         var7.setCotligTaxe(var4.getLigTaxe());
         var7.setCotligTauxTaxe(var4.getLigTauxTaxe());
         var7.setCotligUnite(var4.getLigUnite());
         var7.setCotligQte(var4.getLigQte());
         var7.setCotligDevise(var4.getLigDevise());
         var7.setCotligPu(var4.getLigPu());
         var7.setCotligTauxRemise(var4.getLigTauxRemise());
         var7.setCotligRabais(var4.getLigRabais());
         var7.setCotligPuRem(var4.getLigPuRem());
         var7.setCotligPt(var4.getLigPt());
         var7.setCotligTva(var4.getLigTva());
         var7.setCotligTc(var4.getLigTc());
         var7.setCotligTtc(var4.getLigTtc());
         var7.setCotligPr(var4.getLigPr());
         var7.setCotligPump(var4.getLigPump());
         var3.save(var7);
      }

   }

   public void saveLigne(List var1, CotationEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         CotationLigneAchats var5 = (CotationLigneAchats)var1.get(var4);
         var5.setCotationEnteteAchats(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(CotationEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CotationLigneAchats where cotationEnteteAchats=:idfk order by cotligOrdre,cotligId").setLong("idfk", var1.getCotId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesCotations(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CotationLigneAchats where cotationEnteteAchats.cotNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, Session var7) {
      List var8 = null;
      String var9 = "";
      if (var1 != null && !var1.isEmpty()) {
         var9 = var9 + " cotationEnteteAchats.cotSerie='" + var1 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var9 = var9 + " cotationEnteteAchats.cotActivite='" + var3 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var9 = var9 + " cotationEnteteAchats.cotService='" + var4 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var8 = var7.createQuery("select cotationEnteteAchats.cotEtat,cotationEnteteAchats.cotNum,cotationEnteteAchats.cotSerie,cotationEnteteAchats.cotDiversNom,cotationEnteteAchats.cotNomTiers,cotationEnteteAchats.cotDate,cotationEnteteAchats.cotDevise,cotligId,cotligDepot,cotligCode,cotligFamille,cotligLibelle,cotligQte,cotligQteUtil,cotligPu,cotligPt,cotligPr,cotligPump,cotligPoidsBrut,cotationEnteteAchats.cotObject from CotationLigneAchats where " + var9 + " cotligCode in " + var2 + " and cotationEnteteAchats.cotDate between '" + var5 + "' and '" + var6 + "'").list();
         } else {
            var8 = var7.createQuery("select cotationEnteteAchats.cotEtat,cotationEnteteAchats.cotNum,cotationEnteteAchats.cotSerie,cotationEnteteAchats.cotDiversNom,cotationEnteteAchats.cotNomTiers,cotationEnteteAchats.cotDate,cotationEnteteAchats.cotDevise,cotligId,cotligDepot,cotligCode,cotligFamille,cotligLibelle,cotligQte,cotligQteUtil,cotligPu,cotligPt,cotligPr,cotligPump,cotligPoidsBrut,cotationEnteteAchats.cotObject from CotationLigneAchats where " + var9 + " cotligCode='" + var2 + "' and cotationEnteteAchats.cotDate between '" + var5 + "' and '" + var6 + "'").list();
         }
      } else {
         var8 = var7.createQuery("select cotationEnteteAchats.cotEtat,cotationEnteteAchats.cotNum,cotationEnteteAchats.cotSerie,cotationEnteteAchats.cotDiversNom,cotationEnteteAchats.cotNomTiers,cotationEnteteAchats.cotDate,cotationEnteteAchats.cotDevise,cotligId,cotligDepot,cotligCode,cotligFamille,cotligLibelle,cotligQte,cotligQteUtil,cotligPu,cotligPt,cotligPr,cotligPump,cotligPoidsBrut,cotationEnteteAchats.cotObject from CotationLigneAchats where " + var9 + " cotationEnteteAchats.cotDate between '" + var5 + "' and '" + var6 + "'").list();
      }

      return var8;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from CotationLigneAchats where  cotligCode='" + var1 + "'").list();
      return var3;
   }

   public float chargerLesReliquatsDemandeAchs(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from CotationLigneAchats where cotligIdDa=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((CotationLigneAchats)var6.get(var8)).getCotligQte();
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
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from CotationLigneAchats where cotationEnteteAchats.tiers.tieid=" + var1.getTieid() + " and cotationEnteteAchats.cotDate between '" + var2 + "' and '" + var3 + "' and cotationEnteteAchats.cotSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from CotationLigneAchats where cotationEnteteAchats.tiers.tieid=" + var1.getTieid() + " and cotationEnteteAchats.cotDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from CotationLigneAchats where cotationEnteteAchats.cotIdResponsable=" + var1.getUsrid() + " and cotationEnteteAchats.cotDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheCotationRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CotationLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public CotationLigneAchats rechercheCotation(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.cotationLigneAchats = new CotationLigneAchats();
      var6 = var3.createQuery("from CotationLigneAchats where cotligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.cotationLigneAchats = (CotationLigneAchats)var6.get(0);
      } else {
         this.cotationLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.cotationLigneAchats;
   }
}
