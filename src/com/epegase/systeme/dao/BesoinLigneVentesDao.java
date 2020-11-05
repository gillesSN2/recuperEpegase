package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BesoinEnteteVentes;
import com.epegase.systeme.classe.BesoinLigneVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class BesoinLigneVentesDao implements Serializable {
   private BesoinLigneVentes besoinLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BesoinLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BesoinLigneVentes insertLigne(BesoinLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BesoinLigneVentes modifLigne(BesoinLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteAllLigne(BesoinEnteteVentes var1, Session var2) {
      var2.createQuery("delete from BesoinLigneVentes where besoinEnteteVentes=:id").setLong("id", var1.getBesId()).executeUpdate();
      return "";
   }

   public String deleteOneLigne(BesoinLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from BesoinLigneVentes where besligId =" + var1.getBesligId());
      var3.executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, BesoinEnteteVentes var2, Session var3) {
      new BesoinLigneVentes();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         BesoinLigneVentes var4 = (BesoinLigneVentes)var1.get(var5);
         BesoinLigneVentes var6 = new BesoinLigneVentes();
         var6.setBesoinEnteteVentes(var2);
         var6.setBesligCode(var4.getBesligCode());
         var6.setBesligGroupe(var4.getBesligGroupe());
         var6.setBesligModeGroupe(var4.getBesligModeGroupe());
         var6.setBesligFamille(var4.getBesligFamille());
         var6.setBesligLibelle(var4.getBesligLibelle());
         var6.setBesligDescription(var4.getBesligDescription());
         var6.setBesligReference(var4.getBesligReference());
         var6.setBesligTaxe(var4.getBesligTaxe());
         var6.setBesligTauxTaxe(var4.getBesligTauxTaxe());
         var6.setBesligUnite(var4.getBesligUnite());
         var6.setBesligQte(var4.getBesligQte());
         var6.setBesligQteUtil(var4.getBesligQteUtil());
         var6.setBesligPu(var4.getBesligPu());
         var6.setBesligPuTtc(var4.getBesligPuTtc());
         var6.setBesligTauxRemise(var4.getBesligTauxRemise());
         var6.setBesligRabais(var4.getBesligRabais());
         var6.setBesligPuRem(var4.getBesligPuRem());
         var6.setBesligPuRemTtc(var4.getBesligPuRemTtc());
         var6.setBesligPt(var4.getBesligPt());
         var6.setBesligTva(var4.getBesligTva());
         var6.setBesligTc(var4.getBesligTc());
         var6.setBesligTtc(var4.getBesligTtc());
         var6.setBesligPump(var4.getBesligPump());
         var6.setBesligDepot(var4.getBesligDepot());
         var6.setBesligStock(var4.getBesligStock());
         var6.setBesligLarg(var4.getBesligLarg());
         var6.setBesligLong(var4.getBesligLong());
         var6.setBesligHaut(var4.getBesligHaut());
         var6.setBesligPoidsBrut(var4.getBesligPoidsBrut());
         var6.setBesligPoidsNet(var4.getBesligPoidsNet());
         var6.setBesligDiam(var4.getBesligDiam());
         var6.setBesligNb(var4.getBesligNb());
         var6.setBesligVolume(var4.getBesligVolume());
         var6.setBesligEchelle(var4.getBesligEchelle());
         var6.setBesligCondition(var4.getBesligCondition());
         var3.save(var6);
      }

   }

   public void saveLigne(List var1, BesoinEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         BesoinLigneVentes var5 = (BesoinLigneVentes)var1.get(var4);
         var5.setBesoinEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(BesoinEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from BesoinLigneVentes where besoinEnteteVentes=:idfk").setLong("idfk", var1.getBesId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, Session var6) {
      List var7 = null;
      String var8 = "";
      if (var2 != null && !var2.isEmpty()) {
         var8 = " besoinEnteteVentes.besActivite='" + var2 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var8 = " besoinEnteteVentes.besService='" + var3 + "' and ";
      }

      var7 = var6.createQuery("from BesoinLigneVentes where " + var8 + " besligCode='" + var1 + "' and besoinEnteteVentes.besDate>='" + var4 + "' and besoinEnteteVentes.besDate<='" + var5 + "'").list();
      return var7;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from BesoinLigneVentes where  besligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from BesoinLigneVentes where besoinEnteteVentes.tiers.tieid=" + var1.getTieid() + " and besoinEnteteVentes.besDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheBesoinRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from BesoinLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public BesoinLigneVentes rechercheBesoin(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.besoinLigneVentes = new BesoinLigneVentes();
      var6 = var3.createQuery("from BesoinLigneVentes where besligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.besoinLigneVentes = (BesoinLigneVentes)var6.get(0);
      } else {
         this.besoinLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.besoinLigneVentes;
   }
}
