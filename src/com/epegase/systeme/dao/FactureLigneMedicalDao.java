package com.epegase.systeme.dao;

import com.epegase.systeme.classe.FactureEnteteMedical;
import com.epegase.systeme.classe.FactureLigneMedical;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.LigneDocument;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class FactureLigneMedicalDao implements Serializable {
   private FactureLigneMedical factureLigneMedical;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FactureLigneMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FactureLigneMedical insertLigne(FactureLigneMedical var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FactureLigneMedical modifLigne(FactureLigneMedical var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void deleteAllLigne(FactureEnteteMedical var1, Session var2) {
      var2.createQuery("delete from FactureLigneMedical where factureEnteteMedical=:id").setLong("id", var1.getFacId()).executeUpdate();
   }

   public String deleteOneLigne(FactureLigneMedical var1, Session var2) {
      Query var3 = var2.createQuery("delete from FactureLigneMedical where facligId =" + var1.getFacligId());
      var3.executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, FactureEnteteMedical var2, float var3, String var4, Session var5) {
      LigneDocument var6 = new LigneDocument();

      for(int var7 = 0; var7 < var1.size(); ++var7) {
         FactureLigneMedical var8 = (FactureLigneMedical)var1.get(var7);
         if (var3 != 0.0F) {
            UtilNombre var9 = new UtilNombre();
            var8.setFacligTauxRemise(var3);
            double var10 = var8.getFacligPu() * (double)var3 / 100.0D;
            var10 = var9.myRoundDevise(var10, var4);
            var8.setFacligPuRem(var10);
            double var12 = var8.getFacligPuTtc() * (double)var3 / 100.0D;
            var12 = var9.myRoundDevise(var12, var4);
            var8.setFacligPuRemTtc(var12);
            double var14 = var8.getFacligPuRem() * (double)var8.getFacligQte();
            var14 = var9.myRoundDevise(var14, var4);
            double var16 = 0.0D;
            double var18 = 0.0D;
            var8.setFacligPt(var14);
            if (var8.getFacligTauxTaxe() != 0.0F) {
               var16 = var14 * (double)var8.getFacligTauxTaxe() / 100.0D;
               var16 = var9.myRoundDevise(var16, var4);
            }

            var8.setFacligTva(var16);
            var18 = var14 + var16;
            var8.setFacligTtc(var18);
         }

         var6.setLigOrdre(var8.getFacligOrdre());
         var6.setLigCode(var8.getFacligCode());
         var6.setLigFamille(var8.getFacligFamille());
         var6.setLigLibelle(var8.getFacligLibelle());
         var6.setLigReference(var8.getFacligReference());
         var6.setLigTaxe(var8.getFacligTaxe());
         var6.setLigTauxTaxe(var8.getFacligTauxTaxe());
         var6.setLigQte(var8.getFacligQte());
         var6.setLigDevise(var8.getFacligDevise());
         var6.setLigPu(var8.getFacligPu());
         var6.setLigPuTtc(var8.getFacligPuTtc());
         var6.setLigTauxRemise(var8.getFacligTauxRemise());
         var6.setLigRabais(var8.getFacligRabais());
         var6.setLigPuRem(var8.getFacligPuRem());
         var6.setLigPuRemTtc(var8.getFacligPuRemTtc());
         var6.setLigPt(var8.getFacligPt());
         var6.setLigTva(var8.getFacligTva());
         var6.setLigTc(var8.getFacligTc());
         var6.setLigTtc(var8.getFacligTtc());
         var6.setLigDepot("");
         var6.setLigLot("");
         var6.setLigNumSerie("");
         var6.setLigQteStock(0.0F);
         FactureLigneMedical var20 = new FactureLigneMedical();
         var20.setFactureEnteteMedical(var2);
         var20.setFacligOrdre(var6.getLigOrdre());
         var20.setFacligCode(var6.getLigCode());
         var20.setFacligFamille(var6.getLigFamille());
         var20.setFacligLibelle(var6.getLigLibelle());
         var20.setFacligReference(var6.getLigReference());
         var20.setFacligTaxe(var6.getLigTaxe());
         var20.setFacligTauxTaxe(var6.getLigTauxTaxe());
         var20.setFacligQte(var6.getLigQte());
         var20.setFacligDevise(var6.getLigDevise());
         var20.setFacligPu(var6.getLigPu());
         var20.setFacligPuTtc(var6.getLigPuTtc());
         var20.setFacligTauxRemise(var6.getLigTauxRemise());
         var20.setFacligRabais(var6.getLigRabais());
         var20.setFacligPuRem(var6.getLigPuRem());
         var20.setFacligPuRemTtc(var6.getLigPuRemTtc());
         var20.setFacligPt(var6.getLigPt());
         var20.setFacligTva(var6.getLigTva());
         var20.setFacligTc(var6.getLigTc());
         var20.setFacligTtc(var6.getLigTtc());
         var5.save(var20);
      }

   }

   public void saveLigne(List var1, FactureEnteteMedical var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         FactureLigneMedical var5 = (FactureLigneMedical)var1.get(var4);
         var5.setFactureEnteteMedical(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(FactureEnteteMedical var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      List var4 = var2.createQuery("from FactureLigneMedical where factureEnteteMedical=:idfk order by facligOrdre, facligId").setLong("idfk", var1.getFacId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesFactures(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      List var4 = var2.createQuery("from FactureLigneMedical where factureEnteteMedical.facNum in (" + var1 + ") order by facligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesFacturesByNature(long var1, String var3, int var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var6 = true;
      }

      List var7 = null;
      if (var4 == 71) {
         var7 = var5.createQuery("from FactureLigneMedical where facligIdConsultation=:id").setLong("id", var1).list();
      } else if (var4 == 73) {
         var7 = var5.createQuery("from FactureLigneMedical where facligIdPharmacie=:id").setLong("id", var1).list();
      } else if (var4 == 74) {
         var7 = var5.createQuery("from FactureLigneMedical where facligIdLaboratoire=:id").setLong("id", var1).list();
      } else if (var4 == 77) {
         var7 = var5.createQuery("from FactureLigneMedical where facligNumHospitalisation=:num").setString("num", var3).list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesLignesFacturesByDocument(String var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      List var5 = null;
      if (var2 == 71) {
         var5 = var3.createQuery("from FactureLigneMedical where facligNumConsultation=:num").setString("num", var1).list();
      } else if (var2 == 73) {
         var5 = var3.createQuery("from FactureLigneMedical where facligNumPharmacie=:num").setString("num", var1).list();
      } else if (var2 == 74) {
         var5 = var3.createQuery("from FactureLigneMedical where facligNumLaboratoire=:num").setString("num", var1).list();
      } else if (var2 == 77) {
         var5 = var3.createQuery("from FactureLigneMedical where facligNumHospitalisation=:num").setString("num", var1).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var4 == null) {
         var6 = var5.createQuery("from FactureLigneMedical where facligCode='" + var1 + "' and factureEnteteMedical.facDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from FactureLigneMedical where facligCode='" + var1 + "' and factureEnteteMedical.facDate >=:d1 and factureEnteteMedical.facDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public FactureLigneMedical chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      this.factureLigneMedical = new FactureLigneMedical();
      List var5 = var3.createQuery("from FactureLigneMedical where facligId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.factureLigneMedical = (FactureLigneMedical)var5.get(0);
      } else {
         this.factureLigneMedical = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureLigneMedical;
   }

   public List chargerLesMvts(String var1, long var2, String var4, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "";
      if (var8 != null && !var8.isEmpty()) {
         var11 = var11 + " factureEnteteMedical.tiers.tiecompte0='" + var8 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var11 = var11 + " factureEnteteMedical.facActivite='" + var4 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " factureEnteteMedical.facService='" + var5 + "' and ";
      }

      if (var2 != 0L) {
         var11 = var11 + " factureEnteteMedical.facIdEquipe=" + var2 + " and ";
      }

      var10 = var9.createQuery("select factureEnteteMedical.facEtat,factureEnteteMedical.facNum,factureEnteteMedical.facIdEquipe,factureEnteteMedical.facDiversNom,factureEnteteMedical.facNomTiers,factureEnteteMedical.facDate,factureEnteteMedical.facDevise,facligId,facligDepot,facligCode,facligFamille,facligLibelle,facligQte,facligQteUtil,facligPu,facligPt,facligPump,facligPoidsBrut from FactureLigneMedical where " + var11 + " facligCode='" + var1 + "' and factureEnteteMedical.facDate>='" + var6 + "' and factureEnteteMedical.facDate<='" + var7 + "'").list();
      return var10;
   }

   public List chargerLesFacturesDirectes(String var1, long var2, String var4, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "";
      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " factureEnteteMedical.facActivite='" + var5 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var11 = var11 + " factureEnteteMedical.facService='" + var6 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var11 = var11 + " facligDepot='" + var4 + "' and ";
      }

      if (var2 != 0L) {
         var11 = var11 + " factureEnteteMedical.facIdEquipe=" + var2 + " and ";
      }

      var10 = var9.createQuery("select factureEnteteMedical.facEtat,factureEnteteMedical.facNum,factureEnteteMedical.facIdEquipe,factureEnteteMedical.facDiversNom,factureEnteteMedical.facNomTiers,factureEnteteMedical.facDate,factureEnteteMedical.facDevise,facligId,facligDepot,facligCode,facligFamille,facligLibelle,facligQte,facligQteUtil,facligPu,facligPt,facligPump,facligPoidsBrut from FactureLigneMedical where " + var11 + " factureEnteteMedical.facStock=1 and facligCode='" + var1 + "' and factureEnteteMedical.facDate>='" + var7 + "' and factureEnteteMedical.facDate<='" + var8 + "'").list();
      return var10;
   }

   public List chargerLesMvts(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from FactureLigneMedical where factureEnteteMedical.facDate>=:d1").setString("d1", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureLigneMedical where factureEnteteMedical.tiers.tieid=" + var1.getTieid() + " and factureEnteteMedical.facDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsPatients(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureLigneMedical where facligDossier='" + var1 + "' and factureEnteteMedical.facDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsPatients(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from FactureLigneMedical where facligDossier='" + var1 + "'").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvtsDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureLigneMedical where factureEnteteMedical.facNomContact='" + var1 + "' and factureEnteteMedical.facDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from FactureLigneMedical where (factureEnteteMedical.facIdCommercial=:usr or factureEnteteMedical.facIdResponsable=:usr) and factureEnteteMedical.facDate>=:dDeb and factureEnteteMedical.facDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public float chargerLesReliquatsDevisVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureLigneMedical where facligIdDvs=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((FactureLigneMedical)var6.get(var8)).getFacligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsCommandeVtes(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
      List var4 = var3.createQuery("from FactureLigneMedical where facligIdBcm=" + var1).list();
      List var5 = var4;
      float var6 = 0.0F;
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6 += ((FactureLigneMedical)var5.get(var7)).getFacligQte();
         }
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public float chargerLesReliquatsLivraisonVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      List var5 = var3.createQuery("from FactureLigneMedical where facligIdBlv=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((FactureLigneMedical)var6.get(var8)).getFacligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FactureLigneMedical where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FactureLigneMedical rechercheFacture(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.factureLigneMedical = new FactureLigneMedical();
      var6 = var3.createQuery("from FactureLigneMedical where facligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.factureLigneMedical = (FactureLigneMedical)var6.get(0);
      } else {
         this.factureLigneMedical = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureLigneMedical;
   }

   public FactureLigneMedical rechercheFactureByConsultation(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.factureLigneMedical = new FactureLigneMedical();
      var6 = var3.createQuery("from FactureLigneMedical where facligIdConsultation=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.factureLigneMedical = (FactureLigneMedical)var6.get(0);
      } else {
         this.factureLigneMedical = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureLigneMedical;
   }

   public FactureLigneMedical rechercheFactureByPharmacie(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.factureLigneMedical = new FactureLigneMedical();
      var6 = var3.createQuery("from FactureLigneMedical where facligIdPharmacie=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.factureLigneMedical = (FactureLigneMedical)var6.get(0);
      } else {
         this.factureLigneMedical = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureLigneMedical;
   }

   public FactureLigneMedical rechercheFactureByLaboratoire(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.factureLigneMedical = new FactureLigneMedical();
      var6 = var3.createQuery("from FactureLigneMedical where facligIdLaboratoire=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.factureLigneMedical = (FactureLigneMedical)var6.get(0);
      } else {
         this.factureLigneMedical = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureLigneMedical;
   }

   public FactureLigneMedical rechercheFactureByHospitalisation(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      this.factureLigneMedical = new FactureLigneMedical();
      var5 = var2.createQuery("from FactureLigneMedical where facligNumHospitalisation=" + var1).setMaxResults(1).list();
      if (var5.size() != 0) {
         this.factureLigneMedical = (FactureLigneMedical)var5.get(0);
      } else {
         this.factureLigneMedical = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.factureLigneMedical;
   }
}
