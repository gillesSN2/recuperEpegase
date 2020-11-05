package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DevisLigneVentes;
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

public class DevisLigneVentesDao implements Serializable {
   private DevisLigneVentes devisLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public DevisLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public DevisLigneVentes insertLigne(DevisLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public DevisLigneVentes modifLigne(DevisLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteAllLigne(DevisEnteteVentes var1, Session var2) {
      var2.createQuery("delete from DevisLigneVentes where devisEnteteVentes=:id").setLong("id", var1.getDvsId()).executeUpdate();
      return "";
   }

   public String deleteOneLigne(DevisLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from DevisLigneVentes where dvsligId =" + var1.getDvsligId());
      var3.executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, DevisEnteteVentes var2, Session var3) {
      new DevisLigneVentes();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         DevisLigneVentes var4 = (DevisLigneVentes)var1.get(var5);
         DevisLigneVentes var6 = new DevisLigneVentes();
         var6.setDevisEnteteVentes(var2);
         var6.setDvsligOrdre(var4.getDvsligOrdre());
         var6.setDvsligCode(var4.getDvsligCode());
         var6.setDvsligGroupe(var4.getDvsligGroupe());
         var6.setDvsligModeGroupe(var4.getDvsligModeGroupe());
         var6.setDvsligFamille(var4.getDvsligFamille());
         var6.setDvsligLibelle(var4.getDvsligLibelle());
         var6.setDvsligComplement(var4.getDvsligComplement());
         var6.setDvsligDescription(var4.getDvsligDescription());
         var6.setDvsligReference(var4.getDvsligReference());
         var6.setDvsligTaxe(var4.getDvsligTaxe());
         var6.setDvsligTauxTaxe(var4.getDvsligTauxTaxe());
         var6.setDvsligUnite(var4.getDvsligUnite());
         var6.setDvsligQte(var4.getDvsligQte());
         var6.setDvsligQteUtil(var4.getDvsligQteUtil());
         var6.setDvsligDevise(var4.getDvsligDevise());
         var6.setDvsligPu(var4.getDvsligPu());
         var6.setDvsligPuTtc(var4.getDvsligPuTtc());
         var6.setDvsligTauxRemise(var4.getDvsligTauxRemise());
         var6.setDvsligRabais(var4.getDvsligRabais());
         var6.setDvsligPuRem(var4.getDvsligPuRem());
         var6.setDvsligPuRemTtc(var4.getDvsligPuRemTtc());
         var6.setDvsligPt(var4.getDvsligPt());
         var6.setDvsligTva(var4.getDvsligTva());
         var6.setDvsligTc(var4.getDvsligTc());
         var6.setDvsligTtc(var4.getDvsligTtc());
         var6.setDvsligPump(var4.getDvsligPump());
         var6.setDvsligDepot(var4.getDvsligDepot());
         var6.setDvsligLarg(var4.getDvsligLarg());
         var6.setDvsligLong(var4.getDvsligLong());
         var6.setDvsligHaut(var4.getDvsligHaut());
         var6.setDvsligPoidsBrut(var4.getDvsligPoidsBrut());
         var6.setDvsligPoidsNet(var4.getDvsligPoidsNet());
         var6.setDvsligPrixKg(var4.getDvsligPrixKg());
         var6.setDvsligDiam(var4.getDvsligDiam());
         var6.setDvsligNb(var4.getDvsligNb());
         var6.setDvsligPrintTexte(var4.getDvsligPrintTexte());
         var6.setDvsligProcess(var4.getDvsligProcess());
         var6.setDvsligVolume(var4.getDvsligVolume());
         var6.setDvsligEchelle(var4.getDvsligEchelle());
         var6.setDvsligCondition(var4.getDvsligCondition());
         var6.setDvsligExcluCalcul(var4.getDvsligExcluCalcul());
         var3.save(var6);
      }

   }

   public void saveLigne(List var1, DevisEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         DevisLigneVentes var5 = (DevisLigneVentes)var1.get(var4);
         var5.setDevisEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(DevisEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from DevisLigneVentes where devisEnteteVentes=:idfk order by dvsligOrdre,dvsligId").setParameter("idfk", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesDevis(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from DevisLigneVentes where devisEnteteVentes.dvsNum in (" + var1 + ") order by dvsligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, long var3, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "dvsligId<>0 and ";
      if (var1 != null && !var1.isEmpty()) {
         var11 = var11 + " devisEnteteVentes.dvsSerie='" + var1 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " devisEnteteVentes.dvsActivite='" + var5 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var11 = var11 + " devisEnteteVentes.dvsService='" + var6 + "' and ";
      }

      if (var3 != 0L) {
         var11 = var11 + " devisEnteteVentes.dvsIdEquipe=" + var3 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var10 = var9.createQuery("select devisEnteteVentes.dvsEtat,devisEnteteVentes.dvsNum,devisEnteteVentes.dvsSerie,devisEnteteVentes.dvsIdEquipe,devisEnteteVentes.dvsDiversNom,devisEnteteVentes.dvsNomTiers,devisEnteteVentes.dvsDate,devisEnteteVentes.dvsDevise,dvsligId,dvsligDepot,dvsligCode,dvsligFamille,dvsligLibelle,dvsligQte,dvsligQteUtil,dvsligPu,dvsligPt,dvsligPump,dvsligPoidsBrut,dvsligEchelle from DevisLigneVentes where " + var11 + " dvsligCode in " + var2 + " and devisEnteteVentes.dvsDate>='" + var7 + "' and devisEnteteVentes.dvsDate<='" + var8 + "'").list();
         } else {
            var10 = var9.createQuery("select devisEnteteVentes.dvsEtat,devisEnteteVentes.dvsNum,devisEnteteVentes.dvsSerie,devisEnteteVentes.dvsIdEquipe,devisEnteteVentes.dvsDiversNom,devisEnteteVentes.dvsNomTiers,devisEnteteVentes.dvsDate,devisEnteteVentes.dvsDevise,dvsligId,dvsligDepot,dvsligCode,dvsligFamille,dvsligLibelle,dvsligQte,dvsligQteUtil,dvsligPu,dvsligPt,dvsligPump,dvsligPoidsBrut,dvsligEchelle from DevisLigneVentes where " + var11 + " dvsligCode='" + var2 + "' and devisEnteteVentes.dvsDate>='" + var7 + "' and devisEnteteVentes.dvsDate<='" + var8 + "'").list();
         }
      } else {
         var10 = var9.createQuery("select devisEnteteVentes.dvsEtat,devisEnteteVentes.dvsNum,devisEnteteVentes.dvsSerie,devisEnteteVentes.dvsIdEquipe,devisEnteteVentes.dvsDiversNom,devisEnteteVentes.dvsNomTiers,devisEnteteVentes.dvsDate,devisEnteteVentes.dvsDevise,dvsligId,dvsligDepot,dvsligCode,dvsligFamille,dvsligLibelle,dvsligQte,dvsligQteUtil,dvsligPu,dvsligPt,dvsligPump,dvsligPoidsBrut,dvsligEchelle from DevisLigneVentes where " + var11 + " devisEnteteVentes.dvsDate>='" + var7 + "' and devisEnteteVentes.dvsDate<='" + var8 + "'").list();
      }

      return var10;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from DevisLigneVentes where dvsligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from DevisLigneVentes where devisEnteteVentes.tiers.tieid=" + var1.getTieid() + " and devisEnteteVentes.dvsDate between '" + var2 + "' and '" + var3 + "' and devisEnteteVentes.dvsSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from DevisLigneVentes where devisEnteteVentes.tiers.tieid=" + var1.getTieid() + " and devisEnteteVentes.dvsDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from DevisLigneVentes where devisEnteteVentes.dvsNomContact='" + var1 + "' and devisEnteteVentes.dvsDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from DevisLigneVentes where (devisEnteteVentes.dvsIdCommercial=:usr or devisEnteteVentes.dvsIdResponsable=:usr) and devisEnteteVentes.dvsDate>=:dDeb and devisEnteteVentes.dvsDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheDevisRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from DevisLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public DevisLigneVentes rechercheDevis(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.devisLigneVentes = new DevisLigneVentes();
      var6 = var3.createQuery("from DevisLigneVentes where dvsligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.devisLigneVentes = (DevisLigneVentes)var6.get(0);
      } else {
         this.devisLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.devisLigneVentes;
   }
}
