package com.epegase.systeme.dao;

import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
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

public class NoteDebitLigneVentesDao implements Serializable {
   private NoteDebitLigneVentes noteDebitLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public NoteDebitLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public NoteDebitLigneVentes insertLigne(NoteDebitLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public NoteDebitLigneVentes modifLigne(NoteDebitLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(NoteDebitLigneVentes var1, Session var2) {
      Query var3 = var2.createQuery("delete from NoteDebitLigneVentes where ndbligId =" + var1.getNdbligId());
      var3.executeUpdate();
      return "";
   }

   public String deleteAllLigne(NoteDebitEnteteVentes var1, Session var2) {
      var2.createQuery("delete from NoteDebitLigneVentes where noteDebitEnteteVentes=:id").setLong("id", var1.getNdbId()).executeUpdate();
      return "";
   }

   public void duppliquerLigne(List var1, NoteDebitEnteteVentes var2, Session var3) {
      new NoteDebitLigneVentes();

      for(int var5 = 0; var5 < var1.size(); ++var5) {
         NoteDebitLigneVentes var4 = (NoteDebitLigneVentes)var1.get(var5);
         NoteDebitLigneVentes var6 = new NoteDebitLigneVentes();
         var6.setNoteDebitEnteteVentes(var2);
         var6.setNdbligOrdre(var4.getNdbligOrdre());
         var6.setNdbligCode(var4.getNdbligCode());
         var6.setNdbligGroupe(var4.getNdbligGroupe());
         var6.setNdbligModeGroupe(var4.getNdbligModeGroupe());
         var6.setNdbligFamille(var4.getNdbligFamille());
         var6.setNdbligLibelle(var4.getNdbligLibelle());
         var6.setNdbligComplement(var4.getNdbligComplement());
         var6.setNdbligDescription(var4.getNdbligDescription());
         var6.setNdbligReference(var4.getNdbligReference());
         var6.setNdbligTaxe(var4.getNdbligTaxe());
         var6.setNdbligTauxTaxe(var4.getNdbligTauxTaxe());
         var6.setNdbligUnite(var4.getNdbligUnite());
         var6.setNdbligQte(var4.getNdbligQte());
         var6.setNdbligQteStock(var4.getNdbligQteStock());
         var6.setNdbligQteUtil(var4.getNdbligQteUtil());
         var6.setNdbligDevise(var4.getNdbligDevise());
         var6.setNdbligPu(var4.getNdbligPu());
         var6.setNdbligPuTtc(var4.getNdbligPuTtc());
         var6.setNdbligTauxRemise(var4.getNdbligTauxRemise());
         var6.setNdbligRabais(var4.getNdbligRabais());
         var6.setNdbligPuRem(var4.getNdbligPuRem());
         var6.setNdbligPuRemTtc(var4.getNdbligPuRemTtc());
         var6.setNdbligPt(var4.getNdbligPt());
         var6.setNdbligTva(var4.getNdbligTva());
         var6.setNdbligTc(var4.getNdbligTc());
         var6.setNdbligTtc(var4.getNdbligTtc());
         var6.setNdbligPump(var4.getNdbligPump());
         var6.setNdbligDepot(var4.getNdbligDepot());
         var6.setNdbligLot(var4.getNdbligLot());
         var6.setNdbligNumSerie(var4.getNdbligNumSerie());
         var6.setNdbligStock(var4.getNdbligStock());
         var6.setNdbligLarg(var4.getNdbligLarg());
         var6.setNdbligLong(var4.getNdbligLong());
         var6.setNdbligHaut(var4.getNdbligHaut());
         var6.setNdbligPoidsBrut(var4.getNdbligPoidsBrut());
         var6.setNdbligPoidsNet(var4.getNdbligPoidsNet());
         var6.setNdbligDiam(var4.getNdbligDiam());
         var6.setNdbligNb(var4.getNdbligNb());
         var6.setNdbligVolume(var4.getNdbligVolume());
         var6.setNdbligEchelle(var4.getNdbligEchelle());
         var6.setNdbligCondition(var4.getNdbligCondition());
         var3.save(var6);
      }

   }

   public void saveLigne(List var1, NoteDebitEnteteVentes var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         NoteDebitLigneVentes var5 = (NoteDebitLigneVentes)var1.get(var4);
         var5.setNoteDebitEnteteVentes(var2);
         var3.save(var5);
      }

   }

   public List chargerLesLignes(NoteDebitEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from NoteDebitLigneVentes where noteDebitEnteteVentes=:idfk order by ndbligOrdre,ndbligId").setLong("idfk", var1.getNdbId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesNoteDebits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from NoteDebitLigneVentes where noteDebitEnteteVentes.ndbNum in (" + var1 + ") order by ndbligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var4 == null) {
         var6 = var5.createQuery("from NoteDebitLigneVentes where ndbligCode='" + var1 + "' and noteDebitEnteteVentes.ndbDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from NoteDebitLigneVentes where ndbligCode='" + var1 + "' and noteDebitEnteteVentes.ndbDate >=:d1 and noteDebitEnteteVentes.ndbDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public NoteDebitLigneVentes chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var4 = true;
      }

      this.noteDebitLigneVentes = new NoteDebitLigneVentes();
      List var5 = var3.createQuery("from NoteDebitLigneVentes where ndbligId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.noteDebitLigneVentes = (NoteDebitLigneVentes)var5.get(0);
      } else {
         this.noteDebitLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.noteDebitLigneVentes;
   }

   public List chargerLesMvts(String var1, String var2, long var3, String var5, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "ndbligId<>0 and ";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " noteDebitEnteteVentes.ndbSerie='" + var1 + "' and ";
      }

      if (var9 != null && !var9.isEmpty()) {
         var12 = var12 + " noteDebitEnteteVentes.tiers.tiecompte0='" + var9 + "' and ";
      }

      if (var5 != null && !var5.isEmpty()) {
         var12 = var12 + " noteDebitEnteteVentes.ndbActivite='" + var5 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " noteDebitEnteteVentes.ndbService='" + var6 + "' and ";
      }

      if (var3 != 0L) {
         var12 = var12 + " noteDebitEnteteVentes.ndbIdEquipe=" + var3 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select noteDebitEnteteVentes.ndbEtat,noteDebitEnteteVentes.ndbNum,noteDebitEnteteVentes.ndbSerie,noteDebitEnteteVentes.ndbIdEquipe,noteDebitEnteteVentes.ndbDiversNom,noteDebitEnteteVentes.ndbNomTiers,noteDebitEnteteVentes.ndbDate,noteDebitEnteteVentes.ndbDevise,ndbligId,ndbligDepot,ndbligCode,ndbligFamille,ndbligLibelle,ndbligQte,ndbligQteUtil,ndbligPu,ndbligPt,ndbligPump,ndbligPoidsBrut from NoteDebitLigneVentes where " + var12 + " ndbligCode in " + var2 + " and noteDebitEnteteVentes.ndbDate>='" + var7 + "' and noteDebitEnteteVentes.ndbDate<='" + var8 + "'").list();
         } else {
            var11 = var10.createQuery("select noteDebitEnteteVentes.ndbEtat,noteDebitEnteteVentes.ndbNum,noteDebitEnteteVentes.ndbSerie,noteDebitEnteteVentes.ndbIdEquipe,noteDebitEnteteVentes.ndbDiversNom,noteDebitEnteteVentes.ndbNomTiers,noteDebitEnteteVentes.ndbDate,noteDebitEnteteVentes.ndbDevise,ndbligId,ndbligDepot,ndbligCode,ndbligFamille,ndbligLibelle,ndbligQte,ndbligQteUtil,ndbligPu,ndbligPt,ndbligPump,ndbligPoidsBrut from NoteDebitLigneVentes where " + var12 + " ndbligCode='" + var2 + "' and noteDebitEnteteVentes.ndbDate>='" + var7 + "' and noteDebitEnteteVentes.ndbDate<='" + var8 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select noteDebitEnteteVentes.ndbEtat,noteDebitEnteteVentes.ndbNum,noteDebitEnteteVentes.ndbSerie,noteDebitEnteteVentes.ndbIdEquipe,noteDebitEnteteVentes.ndbDiversNom,noteDebitEnteteVentes.ndbNomTiers,noteDebitEnteteVentes.ndbDate,noteDebitEnteteVentes.ndbDevise,ndbligId,ndbligDepot,ndbligCode,ndbligFamille,ndbligLibelle,ndbligQte,ndbligQteUtil,ndbligPu,ndbligPt,ndbligPump,ndbligPoidsBrut from NoteDebitLigneVentes where " + var12 + " noteDebitEnteteVentes.ndbDate>='" + var7 + "' and noteDebitEnteteVentes.ndbDate<='" + var8 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from NoteDebitLigneVentes where ndbligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from NoteDebitLigneVentes where noteDebitEnteteVentes.tiers.tieid=" + var1.getTieid() + " and noteDebitEnteteVentes.ndbDate between '" + var2 + "' and '" + var3 + "' and noteDebitEnteteVentes.ndbSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from NoteDebitLigneVentes where noteDebitEnteteVentes.tiers.tieid=" + var1.getTieid() + " and noteDebitEnteteVentes.ndbDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsDestinataires(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from NoteDebitLigneVentes where noteDebitEnteteVentes.ndbNomContact='" + var1 + "' and noteDebitEnteteVentes.ndbDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from NoteDebitLigneVentes where (noteDebitEnteteVentes.ndbIdCommercial=:usr or noteDebitEnteteVentes.ndbIdResponsable=:usr) and noteDebitEnteteVentes.ndbDate>=:dDeb and noteDebitEnteteVentes.ndbDate<=:dFin").setLong("usr", var1.getUsrid()).setString("dDeb", var2).setString("dFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public float chargerLesReliquatsDevisVtes(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("from NoteDebitLigneVentes where ndbligIdDvs=" + var1).list();
      List var6 = var5;
      float var7 = 0.0F;
      if (var5.size() != 0) {
         for(int var8 = 0; var8 < var6.size(); ++var8) {
            var7 += ((NoteDebitLigneVentes)var6.get(var8)).getNdbligQte();
         }
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public float chargerLesReliquatsFacturesVtes(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
      List var4 = var3.createQuery("from NoteDebitLigneVentes where ndbligIdBcm=" + var1).list();
      List var5 = var4;
      float var6 = 0.0F;
      if (var4.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            var6 += ((NoteDebitLigneVentes)var5.get(var7)).getNdbligQte();
         }
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List rechercheNoteDebitRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from NoteDebitLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public NoteDebitLigneVentes rechercheNoteDebit(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.noteDebitLigneVentes = new NoteDebitLigneVentes();
      var6 = var3.createQuery("from NoteDebitLigneVentes where ndbligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.noteDebitLigneVentes = (NoteDebitLigneVentes)var6.get(0);
      } else {
         this.noteDebitLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.noteDebitLigneVentes;
   }
}
