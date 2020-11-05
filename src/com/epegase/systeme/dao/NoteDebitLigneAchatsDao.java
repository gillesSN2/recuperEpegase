package com.epegase.systeme.dao;

import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitLigneAchats;
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

public class NoteDebitLigneAchatsDao implements Serializable {
   private NoteDebitLigneAchats noteDebitLigneAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public NoteDebitLigneAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public NoteDebitLigneAchats insertLigne(NoteDebitLigneAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public NoteDebitLigneAchats modifLigne(NoteDebitLigneAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(NoteDebitLigneAchats var1, Session var2) {
      Query var3 = var2.createQuery("delete from NoteDebitLigneAchats where ndfligId =" + var1.getNdfligId());
      var3.executeUpdate();
      return null;
   }

   public String deleteAllLigne(NoteDebitEnteteAchats var1, Session var2) {
      var2.createQuery("delete from NoteDebitLigneAchats where noteDebitEnteteAchats=:id").setLong("id", var1.getNdfId()).executeUpdate();
      return "";
   }

   public List chargerLesLignesByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from NoteDebitLigneAchats where noteDebitEnteteAchats.ndfAnal4=:dos").setString("dos", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(NoteDebitEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from NoteDebitLigneAchats where noteDebitEnteteAchats=:idfk order by ndfligId").setLong("idfk", var1.getNdfId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesNoteDebits(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from NoteDebitLigneAchats where noteDebitEnteteAchats.ndfNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, String var6, Session var7) throws HibernateException, NamingException {
      List var8 = null;
      String var9 = "";
      if (var1 != null && !var1.isEmpty()) {
         var9 = var9 + " noteDebitEnteteAchats.ndfSerie='" + var1 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var9 = var9 + " noteDebitEnteteAchats.ndfActivite='" + var3 + "' and ";
      }

      if (var4 != null && !var4.isEmpty()) {
         var9 = var9 + " noteDebitEnteteAchats.ndfService='" + var4 + "' and ";
      }

      var8 = var7.createQuery("select noteDebitEnteteAchats.ndfEtat,noteDebitEnteteAchats.ndfNum,noteDebitEnteteAchats.ndfSerie,noteDebitEnteteAchats.ndfDiversNom,noteDebitEnteteAchats.ndfNomTiers,noteDebitEnteteAchats.ndfDate,noteDebitEnteteAchats.ndfDevise,ndfligId,ndfligDescription,ndfligCode,ndfligFamille,ndfligLibelle,ndfligQte,ndfligQteUtil,ndfligPu,ndfligPt,ndfligPr,ndfligPump,ndfligPoidsBrut from NoteDebitLigneAchats where " + var9 + " ndfligCode='" + var2 + "' and noteDebitEnteteAchats.ndfDate>='" + var5 + "' and noteDebitEnteteAchats.ndfDate<='" + var6 + "'").list();
      return var8;
   }

   public List chargerLesMvts(String var1, Session var2) throws HibernateException, NamingException {
      List var3 = null;
      var3 = var2.createQuery("from NoteDebitLigneAchats where ndfligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 != null && !var4.isEmpty()) {
         var7 = var5.createQuery("from NoteDebitLigneAchats where noteDebitEnteteAchats.tiers.tieid=" + var1.getTieid() + " and noteDebitEnteteAchats.ndfDate between '" + var2 + "' and '" + var3 + "' and noteDebitEnteteAchats.ndfSerie in (" + var4 + ")").list();
      } else {
         var7 = var5.createQuery("from NoteDebitLigneAchats where noteDebitEnteteAchats.tiers.tieid=" + var1.getTieid() + " and noteDebitEnteteAchats.ndfDate between '" + var2 + "' and '" + var3 + "'").list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from NoteDebitLigneAchats where noteDebitEnteteAchats.ndfIdResponsable=" + var1.getUsrid() + " and noteDebitEnteteAchats.ndfDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheNoteDebitRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from NoteDebitLigneAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public NoteDebitLigneAchats rechercheNoteDebit(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.noteDebitLigneAchats = new NoteDebitLigneAchats();
      var6 = var3.createQuery("from NoteDebitLigneAchats where ndfligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.noteDebitLigneAchats = (NoteDebitLigneAchats)var6.get(0);
      } else {
         this.noteDebitLigneAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.noteDebitLigneAchats;
   }
}
