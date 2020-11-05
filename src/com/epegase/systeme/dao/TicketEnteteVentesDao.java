package com.epegase.systeme.dao;

import com.epegase.systeme.classe.TicketEnteteVentes;
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

public class TicketEnteteVentesDao implements Serializable {
   private TicketEnteteVentes ticketEnteteVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public TicketEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public TicketEnteteVentes insert(TicketEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public TicketEnteteVentes modif(TicketEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteOneLigne(TicketEnteteVentes var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerLesTickets(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var4 = true;
      }

      List var5 = var3.createQuery("from TicketEnteteVentes where ticDate between '" + var1 + "' and '" + var2 + "' order by ticNum").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesTicketsByComResEqu(long var1, long var3, long var5, String var7, String var8, Session var9) throws HibernateException, NamingException {
      boolean var10 = false;
      if (var9 == null) {
         var9 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var10 = true;
      }

      String var11 = "";
      if (var1 != 0L) {
         var11 = var11 + " and ticIdCommercial=" + var1;
      }

      if (var3 != 0L) {
         var11 = var11 + " and ticIdResponsable=" + var3;
      }

      if (var5 != 0L) {
         var11 = var11 + " and ticIdEquipe=" + var5;
      }

      List var12 = var9.createQuery("from TicketEnteteVentes where ticDate between '" + var7 + "' and '" + var8 + "'" + var11 + "order by ticNum").list();
      if (var10) {
         this.utilInitHibernate.closeSession();
      }

      return var12;
   }

   public List chargerLesTicketsEnAttente(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var5 = true;
      }

      List var6 = var4.createQuery("from TicketEnteteVentes where ticDate>=:dte1 and ticDate<=:dte2 and ticCaisse=:cas and ticEtat=1 order by ticNum").setString("dte1", var1).setString("dte2", var2).setString("cas", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesTicketsLivre(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var5 = true;
      }

      List var6 = var4.createQuery("from TicketEnteteVentes where ticDate>=:dte1 and ticDate<=:dte2 and ticCaisse=:cas and ticEtat=2 order by ticNum").setString("dte1", var1).setString("dte2", var2).setString("cas", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerTousTickets(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var5 = true;
      }

      List var6 = var4.createQuery("from TicketEnteteVentes where ticDate>=:dte1 and ticDate<=:dte2 and ticCaisse=:cas order by ticNum").setString("dte1", var1).setString("dte2", var2).setString("cas", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public TicketEnteteVentes chargerLaLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var4 = true;
      }

      this.ticketEnteteVentes = new TicketEnteteVentes();
      List var5 = var3.createQuery("from TicketEnteteVentes where ticId=:idfk").setLong("idfk", var1).list();
      if (var5.size() != 0) {
         this.ticketEnteteVentes = (TicketEnteteVentes)var5.get(0);
      } else {
         this.ticketEnteteVentes = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.ticketEnteteVentes;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, Session var6) {
      List var7 = null;
      String var8 = "";
      if (var2 != null && !var2.isEmpty()) {
         var8 = " factureEnteteVentes.facActivite='" + var2 + "' and ";
      }

      var7 = var6.createQuery("from TicketEnteteVentes where " + var8 + " ticligCode='" + var1 + "' and ticligDate>='" + var4 + "' and ticligDate<='" + var5 + "'").list();
      return var7;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from TicketEnteteVentes where tiers.tieid=" + var1.getTieid() + " and ticDate between '" + var2 + "' and '" + var3 + "'").list();
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
      var6 = var4.createQuery("from TicketEnteteVentes where ticIdCommercial=" + var1.getUsrid() + " and ticDate between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheTicketATransfererCompta(String var1, String var2, String var3, String var4, boolean var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var7 = true;
      }

      new ArrayList();
      List var9 = null;
      if (var5) {
         var9 = var6.createQuery("from TicketEnteteVentes where ticDateTransfert is NULL").list();
      } else if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
         var9 = var6.createQuery("from TicketEnteteVentes where ticDateTransfert is NULL and ticDate>=:dte1 and ticDate<=:dte2 and ticNum>=:p1 and ticNum<=:p2").setString("dte1", var3).setString("dte2", var4).setString("p1", var1).setString("p2", var2).list();
      } else {
         var9 = var6.createQuery("from TicketEnteteVentes where ticDateTransfert is NULL and ticDate>=:dte1 and ticDate<=:dte2").setString("dte1", var3).setString("dte2", var4).list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List rechercheTicketATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var6) {
         var10 = var7.createQuery("from TicketEnteteVentes where (ticEtat=3 and ticDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from TicketEnteteVentes where ticEtat=3 and ticDateTransfert is NULL and ticDate>=:dte1 and ticDate<=:dte2 and ticNum>=:p1 and ticNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from TicketEnteteVentes where ticEtat=3 and ticDateTransfert is NULL and ticDate>=:dte1 and ticDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public TicketEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var4 = true;
      }

      Query var5 = var3.createQuery("from TicketEnteteVentes where ticId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new TicketEnteteVentes();
      TicketEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (TicketEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheTicketRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from TicketEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
      Query var4 = var3.createQuery("from TicketEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public boolean verifTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var3 = true;
      }

      Query var4 = var2.createQuery("from TicketEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var4 = true;
      }

      List var5 = var2.createQuery("from TicketEnteteVentes where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheTicketByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BticketLigne");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from TicketEnteteVentes where ticDate>=:deb and ticDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
