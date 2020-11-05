package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FactureInterneLigneVentes;
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

public class FactureInterneLigneVentesDao implements Serializable {
   private FactureInterneLigneVentes factureInterneLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FactureInterneLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FactureInterneLigneVentes insertLigne(FactureInterneLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FactureInterneLigneVentes modifLigne(FactureInterneLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(FactureInterneLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from FactureInterneLigneVentes where fitligId =" + var1.getFitligId());
      var3.executeUpdate();
      return "";
   }

   public String deleteAllLigne(FactureInterneEnteteVentes var1, Session var2) {
      var2.createQuery("delete from FactureInterneLigneVentes where factureInterneEnteteVentes=:id").setLong("id", var1.getFitId()).executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, FactureInterneEnteteVentes var2, Session var3) {
      new FactureInterneLigneVentes();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         FactureInterneLigneVentes var4 = (FactureInterneLigneVentes)var1.get(var5);
         FactureInterneLigneVentes var6 = new FactureInterneLigneVentes();
         var6.setFactureInterneEnteteVentes(var2);
         var6.setFitligOrdre(var4.getFitligOrdre());
         var6.setFitligCode(var4.getFitligCode());
         var6.setFitligGroupe(var4.getFitligGroupe());
         var6.setFitligModeGroupe(var4.getFitligModeGroupe());
         var6.setFitligFamille(var4.getFitligFamille());
         var6.setFitligLibelle(var4.getFitligLibelle());
         var6.setFitligComplement(var4.getFitligComplement());
         var6.setFitligDescription(var4.getFitligDescription());
         var6.setFitligReference(var4.getFitligReference());
         var6.setFitligTaxe(var4.getFitligTaxe());
         var6.setFitligTauxTaxe(var4.getFitligTauxTaxe());
         var6.setFitligUnite(var4.getFitligUnite());
         var6.setFitligQte(var4.getFitligQte());
         var6.setFitligQteStock(var4.getFitligQteStock());
         var6.setFitligQteUtil(var4.getFitligQteUtil());
         var6.setFitligDevise(var4.getFitligDevise());
         var6.setFitligPu(var4.getFitligPu());
         var6.setFitligPuTtc(var4.getFitligPuTtc());
         var6.setFitligTauxRemise(var4.getFitligTauxRemise());
         var6.setFitligRabais(var4.getFitligRabais());
         var6.setFitligPuRem(var4.getFitligPuRem());
         var6.setFitligPuRemTtc(var4.getFitligPuRemTtc());
         var6.setFitligPt(var4.getFitligPt());
         var6.setFitligTva(var4.getFitligTva());
         var6.setFitligTc(var4.getFitligTc());
         var6.setFitligTtc(var4.getFitligTtc());
         var6.setFitligPump(var4.getFitligPump());
         var6.setFitligDepot(var4.getFitligDepot());
         var6.setFitligLot(var4.getFitligLot());
         var6.setFitligNumSerie(var4.getFitligNumSerie());
         var6.setFitligStock(var4.getFitligStock());
         var6.setFitligLarg(var4.getFitligLarg());
         var6.setFitligLong(var4.getFitligLong());
         var6.setFitligHaut(var4.getFitligHaut());
         var6.setFitligPoidsBrut(var4.getFitligPoidsBrut());
         var6.setFitligPoidsNet(var4.getFitligPoidsNet());
         var6.setFitligDiam(var4.getFitligDiam());
         var6.setFitligNb(var4.getFitligNb());
         var6.setFitligVolume(var4.getFitligVolume());
         var6.setFitligEchelle(var4.getFitligEchelle());
         var6.setFitligCondition(var4.getFitligCondition());
         var3.save(var6);
      }

   }

   public void saveLigne(List var1, FactureInterneEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         FactureInterneLigneVentes var5 = (FactureInterneLigneVentes)var1.get(var4);
         var5.setFactureInterneEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(FactureInterneEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from FactureInterneLigneVentes where factureInterneEnteteVentes=:idfk order by fitligOrdre,fitligId").setLong("idfk", var1.getFitId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesNoteDebits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from FactureInterneLigneVentes where factureInterneEnteteVentes.fitNum in (" + var1 + ") order by fitligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var4 == null) {
         var6 = var5.createQuery("from FactureInterneLigneVentes where fitligCode='" + var1 + "' and factureInterneEnteteVentes.fitDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from FactureInterneLigneVentes where fitligCode='" + var1 + "' and factureInterneEnteteVentes.fitDate >=:d1 and factureInterneEnteteVentes.fitDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public FactureInterneLigneVentes chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var4 = true;
      }

      this.factureInterneLigneVentes = new FactureInterneLigneVentes();
      List var5 = var3.createQuery("from FactureInterneLigneVentes where fitligId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.factureInterneLigneVentes = (FactureInterneLigneVentes)var5.get(0);
      } else {
         this.factureInterneLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureInterneLigneVentes;
   }

   public List chargerLesMvts(String var1, long var2, String var4, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "";
      if (var8 != null && !var8.isEmpty()) {
         var11 = var11 + " factureInterneEnteteVentes.tiers.tiecompte0='" + var8 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var11 = var11 + " factureInterneEnteteVentes.fitActivite='" + var4 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " factureInterneEnteteVentes.fitService='" + var5 + "' and ";
      }

      if (var2 != 0L) {
         var11 = var11 + " factureInterneEnteteVentes.fitIdEquipe=" + var2 + " and ";
      }

      var10 = var9.createQuery("select factureInterneEnteteVentes.fitEtat,factureInterneEnteteVentes.fitNum,factureInterneEnteteVentes.fitSerie,factureInterneEnteteVentes.fitIdEquipe,factureInterneEnteteVentes.fitDiversNom,factureInterneEnteteVentes.fitNomTiers,factureInterneEnteteVentes.fitDate,factureInterneEnteteVentes.fitDevise,fitligId,fitligDepot,fitligCode,fitligFamille,fitligLibelle,fitligQte,fitligQteUtil,fitligPu,fitligPt,fitligPump,fitligPoidsBrut from FactureInterneLigneVentes where " + var11 + " fitligCode='" + var1 + "' and factureInterneEnteteVentes.fitDate>='" + var6 + "' and factureInterneEnteteVentes.fitDate<='" + var7 + "'").list();
      return var10;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from FactureInterneLigneVentes where fitligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureInterneLigneVentes where factureInterneEnteteVentes.tiers.tieid=" + var1.getTieid() + " and factureInterneEnteteVentes.fitDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureInterneLigneVentes where factureInterneEnteteVentes.fitNomContact='" + var1 + "' and factureInterneEnteteVentes.fitDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureInterneLigneVentes where (factureInterneEnteteVentes.fitIdCommercial=:usr or factureInterneEnteteVentes.fitIdResponsable=:usr) and factureInterneEnteteVentes.fitDate>=:dDeb and factureInterneEnteteVentes.fitDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public float chargerLesReliquatsDevisVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureInterneLigneVentes where fitligIdDvs=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((FactureInterneLigneVentes)var6.get(var8)).getFitligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsFacturesVtes(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
      List var4 = var3.createQuery("from FactureInterneLigneVentes where fitligIdBcm=" + var1).list();
      List var5 = var4;
      float var6 = 0.0F;
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6 += ((FactureInterneLigneVentes)var5.get(var7)).getFitligQte();
         }
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List rechercheNoteDebitRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FactureInterneLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FactureInterneLigneVentes rechercheNoteDebit(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.factureInterneLigneVentes = new FactureInterneLigneVentes();
      var6 = var3.createQuery("from FactureInterneLigneVentes where fitligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.factureInterneLigneVentes = (FactureInterneLigneVentes)var6.get(0);
      } else {
         this.factureInterneLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureInterneLigneVentes;
   }
}
