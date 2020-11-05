package com.epegase.systeme.dao;

import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
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
import org.hibernate.Transaction;

public class LivraisonLigneVentesDao implements Serializable {
   private LivraisonLigneVentes livraisonLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public LivraisonLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public void saveLigne(List var1, LivraisonEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         LivraisonLigneVentes var5 = (LivraisonLigneVentes)var1.get(var4);
         var5.setLivraisonEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public void duppliquerLigne(List var1, LivraisonEnteteVentes var2, Session var3) {
      new LivraisonLigneVentes();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         LivraisonLigneVentes var4 = (LivraisonLigneVentes)var1.get(var5);
         LivraisonLigneVentes var6 = new LivraisonLigneVentes();
         var6.setLivraisonEnteteVentes(var2);
         var6.setBlvligOrdre(var4.getBlvligOrdre());
         var6.setBlvligCode(var4.getBlvligCode());
         var6.setBlvligGroupe(var4.getBlvligGroupe());
         var6.setBlvligModeGroupe(var4.getBlvligModeGroupe());
         var6.setBlvligFamille(var4.getBlvligFamille());
         var6.setBlvligGenerique(var4.getBlvligGenerique());
         var6.setBlvligLibelle(var4.getBlvligLibelle());
         var6.setBlvligComplement(var4.getBlvligComplement());
         var6.setBlvligDescription(var4.getBlvligDescription());
         var6.setBlvligReference(var4.getBlvligReference());
         var6.setBlvligTaxe(var4.getBlvligTaxe());
         var6.setBlvligTauxTaxe(var4.getBlvligTauxTaxe());
         var6.setBlvligUnite(var4.getBlvligUnite());
         var6.setBlvligQte(var4.getBlvligQte());
         var6.setBlvligQteUtil(var4.getBlvligQteUtil());
         var6.setBlvligQteUtilStock(var4.getBlvligQteUtilStock());
         var6.setBlvligQteStock(var4.getBlvligQteStock());
         var6.setBlvligDevise(var4.getBlvligDevise());
         var6.setBlvligPu(var4.getBlvligPu());
         var6.setBlvligPuTtc(var4.getBlvligPuTtc());
         var6.setBlvligTauxRemise(var4.getBlvligTauxRemise());
         var6.setBlvligRabais(var4.getBlvligRabais());
         var6.setBlvligPuRem(var4.getBlvligPuRem());
         var6.setBlvligPuRemTtc(var4.getBlvligPuRemTtc());
         var6.setBlvligPt(var4.getBlvligPt());
         var6.setBlvligTva(var4.getBlvligTva());
         var6.setBlvligTc(var4.getBlvligTc());
         var6.setBlvligTtc(var4.getBlvligTtc());
         var6.setBlvligPump(var4.getBlvligPump());
         var6.setBlvligDepot(var4.getBlvligDepot());
         var6.setBlvligDepotCmd(var4.getBlvligDepotCmd());
         var6.setBlvligLot(var4.getBlvligLot());
         var6.setBlvligNumSerie(var4.getBlvligNumSerie());
         var6.setBlvligStock(var4.getBlvligStock());
         var6.setBlvligEntStock(var4.getBlvligEntStock());
         var6.setBlvligLarg(var4.getBlvligLarg());
         var6.setBlvligLong(var4.getBlvligLong());
         var6.setBlvligHaut(var4.getBlvligHaut());
         var6.setBlvligPoidsBrut(var4.getBlvligPoidsBrut());
         var6.setBlvligPoidsNet(var4.getBlvligPoidsNet());
         var6.setBlvligDiam(var4.getBlvligDiam());
         var6.setBlvligNb(var4.getBlvligNb());
         var6.setBlvligProcess(var4.getBlvligProcess());
         var6.setBlvligVolume(var4.getBlvligVolume());
         var6.setBlvligEchelle(var4.getBlvligEchelle());
         var6.setBlvligCondition(var4.getBlvligCondition());
         var3.save(var6);
      }

   }

   public String deleteAllLigne(LivraisonEnteteVentes var1, Session var2) {
      var2.createQuery("delete from LivraisonLigneVentes where livraisonEnteteVentes=:id").setLong("id", var1.getBlvId()).executeUpdate();
      return "";
   }

   public LivraisonLigneVentes insert(LivraisonLigneVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.save(var1);
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

   public LivraisonLigneVentes insert(LivraisonLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public LivraisonLigneVentes modif(LivraisonLigneVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
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

   public LivraisonLigneVentes modif(LivraisonLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void deleteOneLigne(LivraisonLigneVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.delete(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void deleteOneLigne(LivraisonLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from LivraisonLigneVentes where blvligId =" + var1.getBlvligId());
      var3.executeUpdate();
   }

   public List chargerLesLignes(LivraisonEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from LivraisonLigneVentes where livraisonEnteteVentes=:idfk order by blvligOrdre,blvligId").setLong("idfk", var1.getBlvId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesLivraisons(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from LivraisonLigneVentes where livraisonEnteteVentes.blvNum in (" + var1 + ") order by blvligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, String var10, Session var11) {
      List var12 = null;
      String var13 = "";
      if (var1 != null && !var1.isEmpty()) {
         var13 = var13 + " livraisonEnteteVentes.blvSerie='" + var1 + "' and ";
      }

      if (var10 != null && !var10.isEmpty()) {
         var13 = var13 + " livraisonEnteteVentes.tiers.tiecompte0='" + var10 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var13 = var13 + " livraisonEnteteVentes.blvActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var13 = var13 + " livraisonEnteteVentes.blvService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var13 = var13 + " blvligDepot='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var13 = var13 + " livraisonEnteteVentes.blvIdEquipe=" + var4 + " and ";
      }

      var12 = var11.createQuery("select livraisonEnteteVentes.blvEtat,livraisonEnteteVentes.blvNum,livraisonEnteteVentes.blvSerie,livraisonEnteteVentes.blvIdEquipe,livraisonEnteteVentes.blvDiversNom,livraisonEnteteVentes.blvNomTiers,livraisonEnteteVentes.blvDate,livraisonEnteteVentes.blvDevise,blvligId,blvligDepot,blvligCode,blvligFamille,blvligLibelle,blvligQteStock,blvligQteUtilStock,blvligPu,blvligPt,blvligPump,blvligPoidsBrut from LivraisonLigneVentes where " + var13 + " blvligCode='" + var2 + "' and livraisonEnteteVentes.blvDate>='" + var8 + "' and livraisonEnteteVentes.blvDate<='" + var9 + "'").list();
      return var12;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from LivraisonLigneVentes where blvligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesLivraisonsDirectes(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, String var10, Session var11) {
      List var12 = null;
      String var13 = "blvligId<>0 and ";
      if (var1 != null && !var1.isEmpty()) {
         var13 = var13 + " livraisonEnteteVentes.blvSerie='" + var1 + "' and ";
      }

      if (var10 != null && !var10.isEmpty()) {
         var13 = var13 + " livraisonEnteteVentes.tiers.tiecompte0='" + var10 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var13 = var13 + " livraisonEnteteVentes.blvActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var13 = var13 + " livraisonEnteteVentes.blvService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var13 = var13 + " blvligDepot='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var13 = var13 + " livraisonEnteteVentes.blvIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var12 = var11.createQuery("select livraisonEnteteVentes.blvEtat,livraisonEnteteVentes.blvNum,livraisonEnteteVentes.blvSerie,livraisonEnteteVentes.blvIdEquipe,livraisonEnteteVentes.blvDiversNom,livraisonEnteteVentes.blvNomTiers,livraisonEnteteVentes.blvDate,livraisonEnteteVentes.blvDevise,blvligId,blvligDepot,blvligCode,blvligFamille,blvligLibelle,blvligQteStock,blvligQteUtilStock,blvligPu,blvligPt,blvligPump,blvligPoidsBrut from LivraisonLigneVentes where " + var13 + " livraisonEnteteVentes.blvStock=0 and blvligCode in " + var2 + " and livraisonEnteteVentes.blvDate>='" + var8 + "' and livraisonEnteteVentes.blvDate<='" + var9 + "'").list();
         } else {
            var12 = var11.createQuery("select livraisonEnteteVentes.blvEtat,livraisonEnteteVentes.blvNum,livraisonEnteteVentes.blvSerie,livraisonEnteteVentes.blvIdEquipe,livraisonEnteteVentes.blvDiversNom,livraisonEnteteVentes.blvNomTiers,livraisonEnteteVentes.blvDate,livraisonEnteteVentes.blvDevise,blvligId,blvligDepot,blvligCode,blvligFamille,blvligLibelle,blvligQteStock,blvligQteUtilStock,blvligPu,blvligPt,blvligPump,blvligPoidsBrut from LivraisonLigneVentes where " + var13 + " livraisonEnteteVentes.blvStock=0 and blvligCode='" + var2 + "' and livraisonEnteteVentes.blvDate>='" + var8 + "' and livraisonEnteteVentes.blvDate<='" + var9 + "'").list();
         }
      } else {
         var12 = var11.createQuery("select livraisonEnteteVentes.blvEtat,livraisonEnteteVentes.blvNum,livraisonEnteteVentes.blvSerie,livraisonEnteteVentes.blvIdEquipe,livraisonEnteteVentes.blvDiversNom,livraisonEnteteVentes.blvNomTiers,livraisonEnteteVentes.blvDate,livraisonEnteteVentes.blvDevise,blvligId,blvligDepot,blvligCode,blvligFamille,blvligLibelle,blvligQteStock,blvligQteUtilStock,blvligPu,blvligPt,blvligPump,blvligPoidsBrut from LivraisonLigneVentes where " + var13 + " livraisonEnteteVentes.blvStock=0 and livraisonEnteteVentes.blvDate>='" + var8 + "' and livraisonEnteteVentes.blvDate<='" + var9 + "'").list();
      }

      return var12;
   }

   public float chargerLesReliquatsDevisVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from LivraisonLigneVentes where blvligIdDvs=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((LivraisonLigneVentes)var6.get(var8)).getBlvligQte();
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
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from LivraisonLigneVentes where livraisonEnteteVentes.tiers.tieid=" + var1.getTieid() + " and livraisonEnteteVentes.blvDate between '" + var2 + "' and '" + var3 + "' and livraisonEnteteVentes.blvSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from LivraisonLigneVentes where livraisonEnteteVentes.tiers.tieid=" + var1.getTieid() + " and livraisonEnteteVentes.blvDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsTiersNonFacture(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from LivraisonLigneVentes where livraisonEnteteVentes.tiers.tieid=" + var1.getTieid() + " and livraisonEnteteVentes.blvDate between '" + var2 + "' and '" + var3 + "' and livraisonEnteteVentes.blvSerie in (" + var4 + ") and (livraisonEnteteVentes.blvNumFacture is null or livraisonEnteteVentes.blvNumFacture='') ").list();
      } else {
         var7 = var5.createQuery("from LivraisonLigneVentes where livraisonEnteteVentes.tiers.tieid=" + var1.getTieid() + " and livraisonEnteteVentes.blvDate between '" + var2 + "' and '" + var3 + "' and (livraisonEnteteVentes.blvNumFacture is null or livraisonEnteteVentes.blvNumFacture='')").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from LivraisonLigneVentes where livraisonEnteteVentes.blvNomContact='" + var1 + "' and livraisonEnteteVentes.blvDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from LivraisonLigneVentes where (livraisonEnteteVentes.blvIdCommercial=:usr or livraisonEnteteVentes.blvIdResponsable=:usr) and livraisonEnteteVentes.blvDate>=:dDeb and livraisonEnteteVentes.blvDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public float chargerLesReliquatsCommandeVtes(long var1, Session var3) throws HibernateException, NamingException {
      List var4 = var3.createQuery("from LivraisonLigneVentes where blvligIdBcm=" + var1).list();
      List var5 = var4;
      float var6 = 0.0F;
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6 += ((LivraisonLigneVentes)var5.get(var7)).getBlvligQte();
         }
      }

      return var6;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = var5.createQuery("from LivraisonLigneVentes where blvligCode='" + var1 + "' and blvligDepot='" + var2 + "' and livraisonEnteteVentes.blvDate >'" + var3 + "'").list();
      return var6;
   }

   public List chargerLesLignes(String var1, String var2, Session var3) {
      List var4 = var3.createQuery("from LivraisonLigneVentes where livraisonEnteteVentes.blvDate >='" + var1 + "' and livraisonEnteteVentes.blvDate <='" + var2 + "'").list();
      return var4;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var4 == null) {
            var6 = var5.createQuery("from LivraisonLigneVentes where blvligCode='" + var1 + "' and blvligDepot='" + var2 + "' and livraisonEnteteVentes.blvDate >=:d1").setDate("d1", var3).list();
         } else {
            var6 = var5.createQuery("from LivraisonLigneVentes where blvligCode='" + var1 + "' and blvligDepot='" + var2 + "' and livraisonEnteteVentes.blvDate >=:d1 and livraisonEnteteVentes.blvDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
         }
      } else if (var4 == null) {
         var6 = var5.createQuery("from LivraisonLigneVentes where blvligCode='" + var1 + "' and livraisonEnteteVentes.blvDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from LivraisonLigneVentes where blvligCode='" + var1 + "' and livraisonEnteteVentes.blvDate >=:d1 and livraisonEnteteVentes.blvDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public List rechercheLivraisonRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from LivraisonLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public LivraisonLigneVentes rechercheLivraison(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.livraisonLigneVentes = new LivraisonLigneVentes();
      var6 = var3.createQuery("from LivraisonLigneVentes where blvligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.livraisonLigneVentes = (LivraisonLigneVentes)var6.get(0);
      } else {
         this.livraisonLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.livraisonLigneVentes;
   }
}
