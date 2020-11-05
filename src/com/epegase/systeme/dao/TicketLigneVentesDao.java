package com.epegase.systeme.dao;

import com.epegase.systeme.classe.TicketEnteteVentes;
import com.epegase.systeme.classe.TicketLigneVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class TicketLigneVentesDao implements Serializable {
   private TicketLigneVentes ticketLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public TicketLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public TicketLigneVentes insert(TicketLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public TicketLigneVentes modif(TicketLigneVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteOneLigne(TicketLigneVentes var1, Session var2) {
      var2.delete(var1);
   }

   public String deleteAllLigne(TicketEnteteVentes var1, Session var2) {
      var2.createQuery("delete from TicketLigneVentes where ticketEnteteVentes=:id").setLong("id", var1.getTicId()).executeUpdate();
      return "";
   }

   public void delete(List var1, Session var2) {
      for(int var3 = 0; var3 < var1.size(); ++var3) {
         new TicketLigneVentes();
         TicketLigneVentes var4 = (TicketLigneVentes)var1.get(var3);
         var2.delete(var4);
      }

   }

   public List chargerLesLignes(TicketEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var3 = true;
      }

      List var4 = var2.createQuery("from TicketLigneVentes where  ticketEnteteVentes=:tic").setParameter("tic", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var4 = true;
      }

      List var5 = var3.createQuery("from TicketLigneVentes where  ticketEnteteVentes.ticDate between '" + var1 + "' and '" + var2 + "' group by ticketEnteteVentes.ticNum order by ticketEnteteVentes.ticNum").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesLignesTickets(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var3 = true;
      }

      List var4 = var2.createQuery("from TicketLigneVentes where ticketEnteteVentes.ticNum in (" + var1 + ") order by ticligOrdre").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public TicketLigneVentes chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var4 = true;
      }

      this.ticketLigneVentes = new TicketLigneVentes();
      List var5 = var3.createQuery("from TicketLigneVentes where ticligId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.ticketLigneVentes = (TicketLigneVentes)var5.get(0);
      } else {
         this.ticketLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.ticketLigneVentes;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, Session var6) {
      List var7 = null;
      String var8 = "";
      if (var2 != null && !var2.isEmpty()) {
         var8 = " ticligActivite='" + var2 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var8 = " ticketEnteteVentes.ticService='" + var3 + "' and ";
      }

      var7 = var6.createQuery("from TicketLigneVentes where " + var8 + " ticligCode='" + var1 + "' and ticketEnteteVentes.ticDate>='" + var4 + "' and ticketEnteteVentes.ticDate<='" + var5 + "'").list();
      return var7;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from TicketLigneVentes where ticligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from TicketLigneVentes where tiers.tieid=" + var1.getTieid() + " and ticketEnteteVentes.ticDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from TicketLigneVentes where ticligIdCommercial=" + var1.getUsrid() + " and ticketEnteteVentes.ticDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from TicketLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesTickets(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " ticligActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " ticketEnteteVentes.ticService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " ticligDepot='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " ticketEnteteVentes.ticIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select ticketEnteteVentes.ticEtat,ticketEnteteVentes.ticNum,ticketEnteteVentes.ticIdEquipe,ticketEnteteVentes.ticNomTiers,ticketEnteteVentes.ticNomTiers,ticketEnteteVentes.ticDate,ticketEnteteVentes.ticDevise,ticligId,ticligDepot,ticligCode,ticligFamille,ticligLibelle,ticligQte,ticligQteUtil,ticligPu,ticligPt,ticligPump,ticligPoidsBrut from TicketLigneVentes where " + var12 + " ticligStock=1 and ticligCode in " + var2 + " and ticketEnteteVentes.ticDate>='" + var8 + "' and ticketEnteteVentes.ticDate<='" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select ticketEnteteVentes.ticEtat,ticketEnteteVentes.ticNum,ticketEnteteVentes.ticIdEquipe,ticketEnteteVentes.ticNomTiers,ticketEnteteVentes.ticNomTiers,ticketEnteteVentes.ticDate,ticketEnteteVentes.ticDevise,ticligId,ticligDepot,ticligCode,ticligFamille,ticligLibelle,ticligQte,ticligQteUtil,ticligPu,ticligPt,ticligPump,ticligPoidsBrut from TicketLigneVentes where " + var12 + " ticligStock=1 and ticligCode='" + var2 + "' and ticketEnteteVentes.ticDate>='" + var8 + "' and ticketEnteteVentes.ticDate<='" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select ticketEnteteVentes.ticEtat,ticketEnteteVentes.ticNum,ticketEnteteVentes.ticIdEquipe,ticketEnteteVentes.ticNomTiers,ticketEnteteVentes.ticNomTiers,ticketEnteteVentes.ticDate,ticketEnteteVentes.ticDevise,ticligId,ticligDepot,ticligCode,ticligFamille,ticligLibelle,ticligQte,ticligQteUtil,ticligPu,ticligPt,ticligPump,ticligPoidsBrut from TicketLigneVentes where " + var12 + " ticligStock=1 and ticketEnteteVentes.ticDate>='" + var8 + "' and ticketEnteteVentes.ticDate<='" + var9 + "'").list();
      }

      return var11;
   }

   public TicketLigneVentes rechercheTicket(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.ticketLigneVentes = new TicketLigneVentes();
      var6 = var3.createQuery("from TicketLigneVentes where ticligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.ticketLigneVentes = (TicketLigneVentes)var6.get(0);
      } else {
         this.ticketLigneVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.ticketLigneVentes;
   }
}
