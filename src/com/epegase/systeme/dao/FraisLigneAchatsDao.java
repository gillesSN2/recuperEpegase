package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.FraisLigneAchats;
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

public class FraisLigneAchatsDao implements Serializable {
   private FraisLigneAchats fraisLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FraisLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FraisLigneAchats insertLigne(FraisLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FraisLigneAchats modifLigne(FraisLigneAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(FraisLigneAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from FraisLigneAchats where fsfligId =" + var1.getFsfligId());
      var3.executeUpdate();
      return "";
   }

   public String deleteAllLigne(FraisEnteteAchats var1, Session var2) {
      var2.createQuery("delete from FraisLigneAchats where fraisEnteteAchats=:id").setLong("id", var1.getFsfId()).executeUpdate();
      return "";
   }

   public List chargerLesLignes(FraisEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from FraisLigneAchats where fraisEnteteAchats=:idfk").setLong("idfk", var1.getFsfId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesFrais(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from FraisLigneAchats where fraisEnteteAchats.fsfNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesByDossierReception(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FraisLigneAchats where fraisEnteteAchats.fsfNumDoc=:rec and fraisEnteteAchats.fsfAnal4=:dos").setString("rec", var1).setString("dos", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesLignesByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from FraisLigneAchats where fraisEnteteAchats.fsfAnal4=:dos").setString("dos", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesByDossier(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FraisLigneAchats where fraisEnteteAchats.fsfAffaire=:aff and fraisEnteteAchats.fsfAnal4=:anal").setString("aff", var1).setString("anal", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesLignesByAffaire(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FraisLigneAchats where fraisEnteteAchats.fsfAffaire=:dos and fraisEnteteAchats.fsfAnal4=:anal").setString("dos", var1).setString("anal", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesLignesByAffaireReception(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var5 = true;
      }

      List var6 = var4.createQuery("from FraisLigneAchats where fraisEnteteAchats.fsfNumDoc=:rec and fraisEnteteAchats.fsfAffaire=:dos and fraisEnteteAchats.fsfAnal4=:anal").setString("rec", var1).setString("dos", var2).setString("anal", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesLignesByIdReception(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from FraisLigneAchats where fsfligIdRec=:id").setLong("id", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, Session var7) throws HibernateException, NamingException {
      List var8 = null;
      String var9 = "";
      if (var1 != null && !var1.isEmpty()) {
         var9 = var9 + " fraisEnteteAchats.fsfSerie='" + var1 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var9 = var9 + " fraisEnteteAchats.fsfActivite='" + var3 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var9 = var9 + " fraisEnteteAchats.fsfService='" + var4 + "' and ";
      }

      var8 = var7.createQuery("select fraisEnteteAchats.fsfEtat,fraisEnteteAchats.fsfNum,fraisEnteteAchats.fsfDiversNom,fraisEnteteAchats.fsfNomTiers,fraisEnteteAchats.fsfDate,fraisEnteteAchats.fsfDevise,fsfligId,fsfligDescription,fsfligCode,fsfligFamille,fsfligLibelle,fsfligQte,fsfligQteUtil,fsfligPu,fsfligPt,fsfligPr,fsfligPump,fsfligPoidsBrut from FraisLigneAchats where " + var9 + " fsfligCode='" + var2 + "' and fraisEnteteAchats.fsfDate>='" + var5 + "' and fraisEnteteAchats.fsfDate<='" + var6 + "'").list();
      return var8;
   }

   public List chargerLesMvts(String var1, Session var2) throws HibernateException, NamingException {
      List var3 = null;
      var3 = var2.createQuery("from FraisLigneAchats where fsfligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerTvaDouane(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var2 = true;
      }

      List var3 = var1.createQuery("from FraisLigneAchats where fsfligMode=4").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from FraisLigneAchats where fraisEnteteAchats.tiers.tieid=" + var1.getTieid() + " and fraisEnteteAchats.fsfDate between '" + var2 + "' and '" + var3 + "' and fraisEnteteAchats.fsfSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from FraisLigneAchats where fraisEnteteAchats.tiers.tieid=" + var1.getTieid() + " and fraisEnteteAchats.fsfDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FraisLigneAchats where fraisEnteteAchats.fsfIdResponsable=" + var1.getUsrid() + " and fraisEnteteAchats.fsfDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FraisLigneAchats rechercheFrais(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.fraisLigneAchats = new FraisLigneAchats();
      var6 = var3.createQuery("from FraisLigneAchats where fsfligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.fraisLigneAchats = (FraisLigneAchats)var6.get(0);
      } else {
         this.fraisLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.fraisLigneAchats;
   }

   public List rechercheFraisRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FraisLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
