package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DemandeEnteteAchats;
import com.epegase.systeme.classe.DemandeLigneAchats;
import com.epegase.systeme.control.LigneDocument;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class DemandeLigneAchatsDao implements Serializable {
   private DemandeLigneAchats demandeLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public DemandeLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public DemandeLigneAchats insertLigne(DemandeLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public DemandeLigneAchats modifLigne(DemandeLigneAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(DemandeLigneAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from DemandeLigneAchats where demligId =" + var1.getDemligId());
      var3.executeUpdate();
      return "";
   }

   public String deleteAllLigne(DemandeEnteteAchats var1, Session var2) {
      var2.createQuery("delete from DemandeLigneAchats where demandeEnteteAchats=:id").setLong("id", var1.getDemId()).executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, DemandeEnteteAchats var2, Session var3) {
      LigneDocument var4 = new LigneDocument();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         DemandeLigneAchats var6 = (DemandeLigneAchats)var1.get(var5);
         var4.setLigCode(var6.getDemligCode());
         var4.setLigFamille(var6.getDemligFamille());
         var4.setLigLibelle(var6.getDemligLibelle());
         var4.setLigReference(var6.getDemligReference());
         var4.setLigTaxe(var6.getDemligTaxe());
         var4.setLigTauxTaxe(var6.getDemligTauxTaxe());
         var4.setLigUnite(var6.getDemligUnite());
         var4.setLigQte(var6.getDemligQte());
         var4.setLigDevise(var6.getDemligDevise());
         var4.setLigPu(var6.getDemligPu());
         var4.setLigTauxRemise(0.0F);
         var4.setLigRabais(0.0D);
         var4.setLigPuRem(0.0D);
         var4.setLigPt(var6.getDemligPt());
         var4.setLigTva(var6.getDemligTva());
         var4.setLigTc(0.0D);
         var4.setLigTtc(var6.getDemligTtc());
         var4.setLigPr(var6.getDemligPr());
         var4.setLigPump(var6.getDemligPump());
         var4.setLigDepot("");
         var4.setLigLot("");
         var4.setLigNumSerie("");
         var4.setLigQteStock(0.0F);
         DemandeLigneAchats var7 = new DemandeLigneAchats();
         var7.setDemandeEnteteAchats(var2);
         var7.setDemligCode(var4.getLigCode());
         var7.setDemligFamille(var4.getLigFamille());
         var7.setDemligLibelle(var4.getLigLibelle());
         var7.setDemligReference(var4.getLigReference());
         var7.setDemligTaxe(var4.getLigTaxe());
         var7.setDemligTauxTaxe(var4.getLigTauxTaxe());
         var7.setDemligUnite(var4.getLigUnite());
         var7.setDemligQte(var4.getLigQte());
         var7.setDemligDevise(var4.getLigDevise());
         var7.setDemligPu(var4.getLigPu());
         var7.setDemligPt(var4.getLigPt());
         var7.setDemligTva(var4.getLigTva());
         var7.setDemligTtc(var4.getLigTtc());
         var7.setDemligPr(var4.getLigPr());
         var7.setDemligPump(var4.getLigPump());
         var3.save(var7);
      }

   }

   public void saveLigne(List var1, DemandeEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         DemandeLigneAchats var5 = (DemandeLigneAchats)var1.get(var4);
         var5.setDemandeEnteteAchats(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(DemandeEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from DemandeLigneAchats where demandeEnteteAchats=:idfk order by demligOrdre,demligId").setLong("idfk", var1.getDemId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesDemandes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from DemandeLigneAchats where demandeEnteteAchats.demNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var5 = true;
      }

      List var6 = var4.createQuery("from DemandeLigneAchats where demligCode='" + var1 + "' and demandeEnteteAchats.demDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvts(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from DemandeLigneAchats where demligCode='" + var1 + "'").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public DemandeLigneAchats rechercheDemande(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.demandeLigneAchats = new DemandeLigneAchats();
      var6 = var3.createQuery("from DemandeLigneAchats where demligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.demandeLigneAchats = (DemandeLigneAchats)var6.get(0);
      } else {
         this.demandeLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.demandeLigneAchats;
   }
}
