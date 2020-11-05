package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.ContratLigneVentes;
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

public class ContratLigneVentesDao implements Serializable {
   private ContratLigneVentes contratLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ContratLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ContratLigneVentes insertLigne(ContratLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ContratLigneVentes modifLigne(ContratLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteAllLigne(ContratEnteteVentes var1, Session var2) {
      var2.createQuery("delete from ContratLigneVentes where contratEnteteVentes=:id").setLong("id", var1.getCrtId()).executeUpdate();
      return "";
   }

   public String deleteOneLigne(ContratLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from ContratLigneVentes where crtligId =" + var1.getCrtligId());
      var3.executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, ContratEnteteVentes var2, Session var3) {
      new ContratLigneVentes();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         ContratLigneVentes var4 = (ContratLigneVentes)var1.get(var5);
         ContratLigneVentes var6 = new ContratLigneVentes();
         var6.setContratEnteteVentes(var2);
         var6.setCrtligOrdre(var4.getCrtligOrdre());
         var6.setCrtligCode(var4.getCrtligCode());
         var6.setCrtligGroupe(var4.getCrtligGroupe());
         var6.setCrtligModeGroupe(var4.getCrtligModeGroupe());
         var6.setCrtligFamille(var4.getCrtligFamille());
         var6.setCrtligLibelle(var4.getCrtligLibelle());
         var6.setCrtligComplement(var4.getCrtligComplement());
         var6.setCrtligReference(var4.getCrtligReference());
         var6.setCrtligTaxe(var4.getCrtligTaxe());
         var6.setCrtligTauxTaxe(var4.getCrtligTauxTaxe());
         var6.setCrtligUnite(var4.getCrtligUnite());
         var6.setCrtligQte(var4.getCrtligQte());
         var6.setCrtligDevise(var4.getCrtligDevise());
         var6.setCrtligPu(var4.getCrtligPu());
         var6.setCrtligPuTtc(var4.getCrtligPuTtc());
         var6.setCrtligTauxRemise(var4.getCrtligTauxRemise());
         var6.setCrtligRabais(var4.getCrtligRabais());
         var6.setCrtligPuRem(var4.getCrtligPuRem());
         var6.setCrtligPuRemTtc(var4.getCrtligPuRemTtc());
         var6.setCrtligPt(var4.getCrtligPt());
         var6.setCrtligTva(var4.getCrtligTva());
         var6.setCrtligTc(var4.getCrtligTc());
         var6.setCrtligTtc(var4.getCrtligTtc());
         var6.setCrtligPump(var4.getCrtligPump());
         var6.setCrtligDepot(var4.getCrtligDepot());
         var6.setCrtligLot(var4.getCrtligLot());
         var6.setCrtligNumSerie(var4.getCrtligNumSerie());
         var6.setCrtligStock(var4.getCrtligStock());
         var6.setCrtligEntStock(var4.getCrtligEntStock());
         var6.setCrtligLarg(var4.getCrtligLarg());
         var6.setCrtligLong(var4.getCrtligLong());
         var6.setCrtligHaut(var4.getCrtligHaut());
         var6.setCrtligPoidsBrut(var4.getCrtligPoidsBrut());
         var6.setCrtligPoidsNet(var4.getCrtligPoidsNet());
         var6.setCrtligDiam(var4.getCrtligDiam());
         var6.setCrtligNb(var4.getCrtligNb());
         var6.setCrtligVolume(var4.getCrtligVolume());
         var6.setCrtligEchelle(var4.getCrtligEchelle());
         var6.setCrtligCondition(var4.getCrtligCondition());
         var3.save(var6);
      }

   }

   public void saveLigne(List var1, ContratEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         ContratLigneVentes var5 = (ContratLigneVentes)var1.get(var4);
         var5.setContratEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(ContratEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      List var4 = var2.createQuery("from ContratLigneVentes where contratEnteteVentes=:idfk order by crtligOrdre,crtligId").setLong("idfk", var1.getCrtId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesContrats(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      List var4 = var2.createQuery("from ContratLigneVentes where contratEnteteVentes.crtNum in (" + var1 + ") order by crtligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var4 == null) {
         var6 = var5.createQuery("from ContratLigneVentes where crtligCode='" + var1 + "' and contratEnteteVentes.crtDate >='" + var3 + "'").list();
      } else {
         var6 = var5.createQuery("from ContratLigneVentes where crtligCode='" + var1 + "' and contratEnteteVentes.crtDate >='" + var3 + "' and contratEnteteVentes.crtDate <='" + var4 + "'").list();
      }

      return var6;
   }

   public ContratLigneVentes chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var4 = true;
      }

      this.contratLigneVentes = new ContratLigneVentes();
      List var5 = var3.createQuery("from ContratLigneVentes where crtligId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.contratLigneVentes = (ContratLigneVentes)var5.get(0);
      } else {
         this.contratLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.contratLigneVentes;
   }

   public List chargerLesMvts(String var1, long var2, String var4, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "";
      if (var8 != null && !var8.isEmpty()) {
         var11 = var11 + " contratEnteteVentes.tiers.tiecompte0='" + var8 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var11 = var11 + " contratEnteteVentes.crtActivite='" + var4 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " contratEnteteVentes.crtService='" + var5 + "' and ";
      }

      if (var2 != 0L) {
         var11 = var11 + " contratEnteteVentes.crtIdEquipe=" + var2 + " and ";
      }

      var10 = var9.createQuery("select contratEnteteVentes.crtEtat,contratEnteteVentes.crtNum,contratEnteteVentes.crtSerie,contratEnteteVentes.crtIdEquipe,contratEnteteVentes.crtDiversNom,contratEnteteVentes.crtNomTiers,contratEnteteVentes.crtDate,contratEnteteVentes.crtDevise,crtligId,crtligDepot,crtligCode,crtligFamille,crtligLibelle,crtligQte,crtligQteUtil,crtligPu,crtligPt,crtligPump,crtligPoidsBrut from ContratLigneVentes where " + var11 + " crtligCode='" + var1 + "' and contratEnteteVentes.crtDate>='" + var6 + "' and contratEnteteVentes.crtDate<='" + var7 + "'").list();
      return var10;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from ContratLigneVentes where crtligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesContratsDirectes(String var1, long var2, String var4, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "";
      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " contratEnteteVentes.crtActivite='" + var5 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var11 = var11 + " contratEnteteVentes.crtService='" + var6 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var11 = var11 + " crtligDepot='" + var4 + "' and ";
      }

      if (var2 != 0L) {
         var11 = var11 + " contratEnteteVentes.crtIdEquipe=" + var2 + " and ";
      }

      var10 = var9.createQuery("select contratEnteteVentes.crtEtat,contratEnteteVentes.crtNum,contratEnteteVentes.crtSerie,contratEnteteVentes.crtIdEquipe,contratEnteteVentes.crtDiversNom,contratEnteteVentes.crtNomTiers,contratEnteteVentes.crtDate,contratEnteteVentes.crtDevise,crtligId,crtligDepot,crtligCode,crtligFamille,crtligLibelle,crtligQte,crtligQteUtil,crtligPu,crtligPt,crtligPump,crtligPoidsBrut from ContratLigneVentes where " + var11 + " contratEnteteVentes.crtStock=1 and crtligCode='" + var1 + "' and contratEnteteVentes.crtDate>='" + var7 + "' and contratEnteteVentes.crtDate<='" + var8 + "'").list();
      return var10;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ContratLigneVentes where contratEnteteVentes.tiers.tieid=" + var1.getTieid() + " and contratEnteteVentes.crtDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ContratLigneVentes where (contratEnteteVentes.crtIdCommercial=:usr or contratEnteteVentes.crtIdResponsable=:usr) and contratEnteteVentes.crtDate>=:dDeb and contratEnteteVentes.crtDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheContratRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ContratLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ContratLigneVentes rechercheContrat(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.contratLigneVentes = new ContratLigneVentes();
      var6 = var3.createQuery("from ContratLigneVentes where crtligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.contratLigneVentes = (ContratLigneVentes)var6.get(0);
      } else {
         this.contratLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.contratLigneVentes;
   }
}
