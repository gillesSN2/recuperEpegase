package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeLigneAchats;
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
import org.hibernate.Transaction;

public class CommandeLigneAchatsDao implements Serializable {
   private CommandeLigneAchats commandeLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CommandeLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CommandeLigneAchats insertLigne(CommandeLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CommandeLigneAchats modifLigne(CommandeLigneAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
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

   public CommandeLigneAchats modifLigne(CommandeLigneAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(CommandeLigneAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from CommandeLigneAchats where cmdligId =" + var1.getCmdligId());
      var3.executeUpdate();
      return null;
   }

   public String deleteAllLigne(CommandeEnteteAchats var1, Session var2) {
      var2.createQuery("delete from CommandeLigneAchats where commandeEnteteAchats=:id").setLong("id", var1.getCmdId()).executeUpdate();
      return "";
   }

   public void saveLigne(List var1, CommandeEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         CommandeLigneAchats var5 = (CommandeLigneAchats)var1.get(var4);
         var5.setCommandeEnteteAchats(var2);
         var3.save(var5);
      }

   }

   public void duppliquerLigne(List var1, CommandeEnteteAchats var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         CommandeLigneAchats var5 = (CommandeLigneAchats)var1.get(var4);
         LigneDocument var6 = new LigneDocument();
         var5 = (CommandeLigneAchats)var1.get(var4);
         var6.setLigCode(var5.getCmdligCode());
         var6.setLigFamille(var5.getCmdligFamille());
         var6.setLigLibelle(var5.getCmdligLibelle());
         var6.setLigReference(var5.getCmdligReference());
         var6.setLigTaxe(var5.getCmdligTaxe());
         var6.setLigTauxTaxe(var5.getCmdligTauxTaxe());
         var6.setLigUnite(var5.getCmdligUnite());
         var6.setLigQte(var5.getCmdligQte());
         var6.setLigDevise(var5.getCmdligDevise());
         var6.setLigPu(var5.getCmdligPu());
         var6.setLigTauxRemise(var5.getCmdligTauxRemise());
         var6.setLigRabais(var5.getCmdligRabais());
         var6.setLigPuRem(var5.getCmdligPuRem());
         var6.setLigPt(var5.getCmdligPt());
         var6.setLigTva(var5.getCmdligTva());
         var6.setLigTc(var5.getCmdligTc());
         var6.setLigTtc(var5.getCmdligTtc());
         var6.setLigPr(var5.getCmdligPr());
         var6.setLigPump(var5.getCmdligPump());
         var6.setLigDepot("");
         var6.setLigLot("");
         var6.setLigNumSerie("");
         var6.setLigQteStock(0.0F);
         CommandeLigneAchats var7 = new CommandeLigneAchats();
         var7.setCommandeEnteteAchats(var2);
         var7.setCmdligCode(var6.getLigCode());
         var7.setCmdligFamille(var6.getLigFamille());
         var7.setCmdligLibelle(var6.getLigLibelle());
         var7.setCmdligReference(var6.getLigReference());
         var7.setCmdligTaxe(var6.getLigTaxe());
         var7.setCmdligTauxTaxe(var6.getLigTauxTaxe());
         var7.setCmdligUnite(var6.getLigUnite());
         var7.setCmdligQte(var6.getLigQte());
         var7.setCmdligDevise(var6.getLigDevise());
         var7.setCmdligPu(var6.getLigPu());
         var7.setCmdligTauxRemise(var6.getLigTauxRemise());
         var7.setCmdligRabais(var6.getLigRabais());
         var7.setCmdligPuRem(var6.getLigPuRem());
         var7.setCmdligPt(var6.getLigPt());
         var7.setCmdligTva(var6.getLigTva());
         var7.setCmdligTc(var6.getLigTc());
         var7.setCmdligTtc(var6.getLigTtc());
         var7.setCmdligPr(var6.getLigPr());
         var7.setCmdligPump(var6.getLigPump());
         var3.save(var7);
      }

   }

   public List chargerLesLignes(CommandeEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CommandeLigneAchats where commandeEnteteAchats=:idfk order by cmdligOrdre,cmdligId").setLong("idfk", var1.getCmdId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesCommandes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CommandeLigneAchats where commandeEnteteAchats.cmdNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, String var7, Session var8) {
      List var9 = null;
      String var10 = "";
      if (var1 != null && !var1.isEmpty()) {
         var10 = var10 + " commandeEnteteAchats.cmdSerie='" + var1 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var10 = var10 + " commandeEnteteAchats.cmdActivite='" + var3 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var10 = var10 + " commandeEnteteAchats.cmdService='" + var4 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var10 = var10 + " cmdligDepot='" + var5 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var9 = var8.createQuery("select commandeEnteteAchats.cmdEtat,commandeEnteteAchats.cmdNum,commandeEnteteAchats.cmdSerie,commandeEnteteAchats.cmdDiversNom,commandeEnteteAchats.cmdNomTiers,commandeEnteteAchats.cmdDate,commandeEnteteAchats.cmdDevise,cmdligId,cmdligDepot,cmdligCode,cmdligFamille,cmdligLibelle,cmdligQte,cmdligQteUtil,cmdligPu,cmdligPt,cmdligPr,cmdligPump,cmdligPoidsBrut,commandeEnteteAchats.cmdObject from CommandeLigneAchats where " + var10 + " cmdligCode in " + var2 + " and commandeEnteteAchats.cmdDate between '" + var6 + "' and '" + var7 + "'").list();
         } else {
            var9 = var8.createQuery("select commandeEnteteAchats.cmdEtat,commandeEnteteAchats.cmdNum,commandeEnteteAchats.cmdSerie,commandeEnteteAchats.cmdDiversNom,commandeEnteteAchats.cmdNomTiers,commandeEnteteAchats.cmdDate,commandeEnteteAchats.cmdDevise,cmdligId,cmdligDepot,cmdligCode,cmdligFamille,cmdligLibelle,cmdligQte,cmdligQteUtil,cmdligPu,cmdligPt,cmdligPr,cmdligPump,cmdligPoidsBrut,commandeEnteteAchats.cmdObject from CommandeLigneAchats where " + var10 + " cmdligCode='" + var2 + "' and commandeEnteteAchats.cmdDate between '" + var6 + "' and '" + var7 + "'").list();
         }
      } else {
         var9 = var8.createQuery("select commandeEnteteAchats.cmdEtat,commandeEnteteAchats.cmdNum,commandeEnteteAchats.cmdSerie,commandeEnteteAchats.cmdDiversNom,commandeEnteteAchats.cmdNomTiers,commandeEnteteAchats.cmdDate,commandeEnteteAchats.cmdDevise,cmdligId,cmdligDepot,cmdligCode,cmdligFamille,cmdligLibelle,cmdligQte,cmdligQteUtil,cmdligPu,cmdligPt,cmdligPr,cmdligPump,cmdligPoidsBrut,commandeEnteteAchats.cmdObject from CommandeLigneAchats where " + var10 + " commandeEnteteAchats.cmdDate between '" + var6 + "' and '" + var7 + "'").list();
      }

      return var9;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from CommandeLigneAchats where cmdligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvts(long var1, String var3, Date var4, Date var5, Session var6) {
      List var7 = null;
      if (var4 != null && var5 != null) {
         if (var1 != 0L) {
            var7 = var6.createQuery("from CommandeLigneAchats where cmdligCode='" + var3 + "' and commandeEnteteAchats.cmdId<>" + var1 + " and commandeEnteteAchats.cmdDate>=:d1 and commandeEnteteAchats.cmdDate<=:d2").setDate("d1", var4).setDate("d2", var5).list();
         } else {
            var7 = var6.createQuery("from CommandeLigneAchats where cmdligCode='" + var3 + "' and commandeEnteteAchats.cmdDate>=:d1 and commandeEnteteAchats.cmdDate<=:d2").setDate("d1", var4).setDate("d2", var5).list();
         }
      } else if (var1 != 0L) {
         var7 = var6.createQuery("from CommandeLigneAchats where cmdligCode='" + var3 + "' and commandeEnteteAchats.cmdId<>" + var1).list();
      } else {
         var7 = var6.createQuery("from CommandeLigneAchats where cmdligCode='" + var3 + "'").list();
      }

      return var7;
   }

   public float chargerLesReliquatsCotationAchs(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from CommandeLigneAchats where cmdligIdCot=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((CommandeLigneAchats)var6.get(var8)).getCmdligQte();
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
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from CommandeLigneAchats where commandeEnteteAchats.tiers.tieid=" + var1.getTieid() + " and commandeEnteteAchats.cmdDate between '" + var2 + "' and '" + var3 + "' and commandeEnteteAchats.cmdSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from CommandeLigneAchats where commandeEnteteAchats.tiers.tieid=" + var1.getTieid() + " and commandeEnteteAchats.cmdDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from CommandeLigneAchats where commandeEnteteAchats.cmdIdResponsable=" + var1.getUsrid() + " and commandeEnteteAchats.cmdDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheCommandeRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CommandeLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public CommandeLigneAchats rechercheCommande(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.commandeLigneAchats = new CommandeLigneAchats();
      var6 = var3.createQuery("from CommandeLigneAchats where cmdligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.commandeLigneAchats = (CommandeLigneAchats)var6.get(0);
      } else {
         this.commandeLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.commandeLigneAchats;
   }

   public List chargerEcrituresBudget(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from CommandeLigneAchats where commandeEnteteAchats.cmdBudgetProjet=:bud and commandeEnteteAchats.cmdDate>=:debut and commandeEnteteAchats.cmdDate<=:final and (commandeEnteteAchats.cmdEtat=1 or commandeEnteteAchats.cmdEtat=4 or commandeEnteteAchats.cmdEtat=5) order by commandeEnteteAchats.cmdNum").setString("bud", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcrituresBudget(Date var1, Date var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      Query var7 = var5.createQuery("from CommandeLigneAchats where commandeEnteteAchats.cmdBudgetProjet=:bud and cmdligBudgetPoste=:pos and commandeEnteteAchats.cmdDate>=:debut and commandeEnteteAchats.cmdDate<=:final and (commandeEnteteAchats.cmdEtat=1 or commandeEnteteAchats.cmdEtat=4 or commandeEnteteAchats.cmdEtat=5) order by commandeEnteteAchats.cmdNum").setString("bud", var3).setString("pos", var4).setDate("debut", var1).setDate("final", var2);
      List var6 = var7.list();
      return var6;
   }

   public List chargerEcrituresByCompte(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from CommandeLigneAchats where cmdligBudgetPoste=:cpte and commandeEnteteAchats.cmdDate>=:debut and commandeEnteteAchats.cmdDate<=:final and (commandeEnteteAchats.cmdEtat=1 or commandeEnteteAchats.cmdEtat=4 or commandeEnteteAchats.cmdEtat=5) order by commandeEnteteAchats.cmdNum").setString("cpte", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }
}
