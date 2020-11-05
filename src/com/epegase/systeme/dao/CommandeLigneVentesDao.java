package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class CommandeLigneVentesDao implements Serializable {
   private CommandeLigneVentes commandeLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CommandeLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CommandeLigneVentes insertLigne(CommandeLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CommandeLigneVentes modifLigne(CommandeLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(CommandeLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from CommandeLigneVentes where bcmligId =" + var1.getBcmligId());
      var3.executeUpdate();
      return null;
   }

   public String deleteAllLigne(CommandeEnteteVentes var1, Session var2) {
      var2.createQuery("delete from CommandeLigneVentes where commandeEnteteVentes=:id").setLong("id", var1.getBcmId()).executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, CommandeEnteteVentes var2, Session var3) {
      new CommandeLigneVentes();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         CommandeLigneVentes var4 = (CommandeLigneVentes)var1.get(var5);
         CommandeLigneVentes var6 = new CommandeLigneVentes();
         var6.setCommandeEnteteVentes(var2);
         var6.setBcmligOrdre(var4.getBcmligOrdre());
         var6.setBcmligCode(var4.getBcmligCode());
         var6.setBcmligGroupe(var4.getBcmligGroupe());
         var6.setBcmligModeGroupe(var4.getBcmligModeGroupe());
         var6.setBcmligFamille(var4.getBcmligFamille());
         var6.setBcmligLibelle(var4.getBcmligLibelle());
         var6.setBcmligComplement(var4.getBcmligComplement());
         var6.setBcmligDescription(var4.getBcmligDescription());
         var6.setBcmligReference(var4.getBcmligReference());
         var6.setBcmligTaxe(var4.getBcmligTaxe());
         var6.setBcmligTauxTaxe(var4.getBcmligTauxTaxe());
         var6.setBcmligUnite(var4.getBcmligUnite());
         var6.setBcmligQte(var4.getBcmligQte());
         var6.setBcmligQteUtil(var4.getBcmligQteUtil());
         var6.setBcmligQteLivree(var4.getBcmligQteLivree());
         var6.setBcmligQteStock(var4.getBcmligQteStock());
         var6.setBcmligDevise(var4.getBcmligDevise());
         var6.setBcmligPu(var4.getBcmligPu());
         var6.setBcmligPuTtc(var4.getBcmligPuTtc());
         var6.setBcmligTauxRemise(var4.getBcmligTauxRemise());
         var6.setBcmligRabais(var4.getBcmligRabais());
         var6.setBcmligPuRem(var4.getBcmligPuRem());
         var6.setBcmligPuRemTtc(var4.getBcmligPuRemTtc());
         var6.setBcmligPt(var4.getBcmligPt());
         var6.setBcmligTva(var4.getBcmligTva());
         var6.setBcmligTc(var4.getBcmligTc());
         var6.setBcmligTtc(var4.getBcmligTtc());
         var6.setBcmligPump(var4.getBcmligPump());
         var6.setBcmligDepot(var4.getBcmligDepot());
         var6.setBcmligStock(var4.getBcmligStock());
         var6.setBcmligEntStock(var4.getBcmligEntStock());
         var6.setBcmligLarg(var4.getBcmligLarg());
         var6.setBcmligLong(var4.getBcmligLong());
         var6.setBcmligHaut(var4.getBcmligHaut());
         var6.setBcmligPoidsBrut(var4.getBcmligPoidsBrut());
         var6.setBcmligPoidsNet(var4.getBcmligPoidsNet());
         var6.setBcmligDiam(var4.getBcmligDiam());
         var6.setBcmligNb(var4.getBcmligNb());
         var6.setBcmligProcess(var4.getBcmligProcess());
         var6.setBcmligVolume(var4.getBcmligVolume());
         var6.setBcmligEchelle(var4.getBcmligEchelle());
         var6.setBcmligCondition(var4.getBcmligCondition());
         var3.save(var6);
      }

   }

   public void saveLigne(List var1, CommandeEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         CommandeLigneVentes var5 = (CommandeLigneVentes)var1.get(var4);
         var5.setCommandeEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(CommandeEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CommandeLigneVentes where commandeEnteteVentes=:idfk order by bcmligOrdre,bcmligId").setLong("idfk", var1.getBcmId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesCommandes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CommandeLigneVentes where commandeEnteteVentes.bcmNum in (" + var1 + ") order by bcmligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "bcmligId<>0 and ";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " commandeEnteteVentes.bcmSerie='" + var1 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " bcmligDepot='" + var3 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " commandeEnteteVentes.bcmActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " commandeEnteteVentes.bcmService='" + var7 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " commandeEnteteVentes.bcmIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select commandeEnteteVentes.bcmEtat,commandeEnteteVentes.bcmNum,commandeEnteteVentes.bcmSerie,commandeEnteteVentes.bcmIdEquipe,commandeEnteteVentes.bcmDiversNom,commandeEnteteVentes.bcmNomTiers,commandeEnteteVentes.bcmDate,commandeEnteteVentes.bcmDevise,bcmligId,bcmligDepot,bcmligCode,bcmligFamille,bcmligLibelle,bcmligQte,bcmligQteUtil,bcmligPu,bcmligPt,bcmligPump,bcmligPoidsBrut,commandeEnteteVentes.bcmStock from CommandeLigneVentes where " + var12 + " bcmligCode in " + var2 + " and commandeEnteteVentes.bcmDate>='" + var8 + "' and commandeEnteteVentes.bcmDate<='" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select commandeEnteteVentes.bcmEtat,commandeEnteteVentes.bcmNum,commandeEnteteVentes.bcmSerie,commandeEnteteVentes.bcmIdEquipe,commandeEnteteVentes.bcmDiversNom,commandeEnteteVentes.bcmNomTiers,commandeEnteteVentes.bcmDate,commandeEnteteVentes.bcmDevise,bcmligId,bcmligDepot,bcmligCode,bcmligFamille,bcmligLibelle,bcmligQte,bcmligQteUtil,bcmligPu,bcmligPt,bcmligPump,bcmligPoidsBrut,commandeEnteteVentes.bcmStock from CommandeLigneVentes where " + var12 + " bcmligCode='" + var2 + "' and commandeEnteteVentes.bcmDate>='" + var8 + "' and commandeEnteteVentes.bcmDate<='" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select commandeEnteteVentes.bcmEtat,commandeEnteteVentes.bcmNum,commandeEnteteVentes.bcmSerie,commandeEnteteVentes.bcmIdEquipe,commandeEnteteVentes.bcmDiversNom,commandeEnteteVentes.bcmNomTiers,commandeEnteteVentes.bcmDate,commandeEnteteVentes.bcmDevise,bcmligId,bcmligDepot,bcmligCode,bcmligFamille,bcmligLibelle,bcmligQte,bcmligQteUtil,bcmligPu,bcmligPt,bcmligPump,bcmligPoidsBrut,commandeEnteteVentes.bcmStock from CommandeLigneVentes where " + var12 + " commandeEnteteVentes.bcmDate>='" + var8 + "' and commandeEnteteVentes.bcmDate<='" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from CommandeLigneVentes where bcmligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesCommandesDirectes(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " commandeEnteteVentes.bcmSerie='" + var1 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " bcmligDepot='" + var3 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " commandeEnteteVentes.bcmActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " commandeEnteteVentes.bcmService='" + var7 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " commandeEnteteVentes.bcmIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select commandeEnteteVentes.bcmEtat,commandeEnteteVentes.bcmNum,commandeEnteteVentes.bcmSerie,commandeEnteteVentes.bcmIdEquipe,commandeEnteteVentes.bcmDiversNom,commandeEnteteVentes.bcmNomTiers,commandeEnteteVentes.bcmDate,commandeEnteteVentes.bcmDevise,bcmligId,bcmligDepot,bcmligCode,bcmligFamille,bcmligLibelle,bcmligQte,bcmligQteUtil,bcmligPu,bcmligPt,bcmligPump,bcmligPoidsBrut,commandeEnteteVentes.bcmStock from CommandeLigneVentes where " + var12 + " commandeEnteteVentes.bcmStock=1 and bcmligCode in " + var2 + " and commandeEnteteVentes.bcmDate>='" + var8 + "' and commandeEnteteVentes.bcmDate<='" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select commandeEnteteVentes.bcmEtat,commandeEnteteVentes.bcmNum,commandeEnteteVentes.bcmSerie,commandeEnteteVentes.bcmIdEquipe,commandeEnteteVentes.bcmDiversNom,commandeEnteteVentes.bcmNomTiers,commandeEnteteVentes.bcmDate,commandeEnteteVentes.bcmDevise,bcmligId,bcmligDepot,bcmligCode,bcmligFamille,bcmligLibelle,bcmligQte,bcmligQteUtil,bcmligPu,bcmligPt,bcmligPump,bcmligPoidsBrut,commandeEnteteVentes.bcmStock from CommandeLigneVentes where " + var12 + " commandeEnteteVentes.bcmStock=1 and bcmligCode='" + var2 + "' and commandeEnteteVentes.bcmDate>='" + var8 + "' and commandeEnteteVentes.bcmDate<='" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select commandeEnteteVentes.bcmEtat,commandeEnteteVentes.bcmNum,commandeEnteteVentes.bcmSerie,commandeEnteteVentes.bcmIdEquipe,commandeEnteteVentes.bcmDiversNom,commandeEnteteVentes.bcmNomTiers,commandeEnteteVentes.bcmDate,commandeEnteteVentes.bcmDevise,bcmligId,bcmligDepot,bcmligCode,bcmligFamille,bcmligLibelle,bcmligQte,bcmligQteUtil,bcmligPu,bcmligPt,bcmligPump,bcmligPoidsBrut,commandeEnteteVentes.bcmStock from CommandeLigneVentes where " + var12 + " commandeEnteteVentes.bcmDate>='" + var8 + "' and commandeEnteteVentes.bcmDate<='" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from CommandeLigneVentes where commandeEnteteVentes.tiers.tieid=" + var1.getTieid() + " and commandeEnteteVentes.bcmDate between '" + var2 + "' and '" + var3 + "' and commandeEnteteVentes.bcmSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from CommandeLigneVentes where commandeEnteteVentes.tiers.tieid=" + var1.getTieid() + " and commandeEnteteVentes.bcmDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from CommandeLigneVentes where commandeEnteteVentes.bcmNomContact='" + var1 + "' and commandeEnteteVentes.bcmDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from CommandeLigneVentes where (commandeEnteteVentes.bcmIdCommercial=:usr or commandeEnteteVentes.bcmIdResponsable=:usr) and commandeEnteteVentes.bcmDate>=:dDeb and commandeEnteteVentes.bcmDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public float chargerLesReliquatsDevisVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from CommandeLigneVentes where bcmligIdDvs=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((CommandeLigneVentes)var6.get(var8)).getBcmligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheCommandeRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CommandeLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public CommandeLigneVentes rechercheCommande(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.commandeLigneVentes = new CommandeLigneVentes();
      var6 = var3.createQuery("from CommandeLigneVentes where bcmligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.commandeLigneVentes = (CommandeLigneVentes)var6.get(0);
      } else {
         this.commandeLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.commandeLigneVentes;
   }
}
