package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.ReceptionLotAchats;
import com.epegase.systeme.classe.RetourLigneAchats;
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

public class ReceptionLotAchatsDao implements Serializable {
   private ReceptionLotAchats receptionLotAchats;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ReceptionLotAchatsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public String getMaBase() {
      return this.maBase;
   }

   public void setMaBase(String var1) {
      this.maBase = var1;
   }

   public ReceptionLotAchats insert(ReceptionLotAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
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

   public ReceptionLotAchats insert(ReceptionLotAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReceptionLotAchats modif(ReceptionLotAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
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

   public ReceptionLotAchats modif(ReceptionLotAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delReceptionLot(ReceptionLotAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionEntete");
      Transaction var3 = var2.beginTransaction();
      var3.begin();
      Query var4 = var2.createQuery("delete from ReceptionLotAchats where reclotId =" + var1.getReclotId());
      var4.executeUpdate();
      var3.commit();
      this.utilInitHibernate.closeSession();
      return null;
   }

   public void deleteLotLigne(ReceptionLotAchats var1, Session var2) {
      var2.delete(var1);
   }

   public List selectReceptionLotByRecLig(ReceptionLigneAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ReceptionLotAchats where reclotIdLigne=:receptionLigne").setLong("receptionLigne", var1.getRecligId());
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ReceptionLotAchats selectRetourlotByRecLig(RetourLigneAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var3 = true;
      }

      ReceptionLotAchats var4 = new ReceptionLotAchats();
      Query var5 = var2.createQuery("from ReceptionLotAchats where receptionLigneAchats=:receptionLigne").setParameter("receptionLigne", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() != 0) {
         var4 = (ReceptionLotAchats)var6.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectLotDispo(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var5 = true;
      }

      new ArrayList();
      Query var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         var7 = var4.createQuery("from ReceptionLotAchats where reclotCode=:prod and reclotDepot=:dep and (reclotQteConso<reclotQte or reclotNumero=:lt)").setString("prod", var1).setString("dep", var2).setString("lt", var3);
      } else {
         var7 = var4.createQuery("from ReceptionLotAchats where reclotCode=:prod and reclotDepot=:dep and reclotQteConso<reclotQte").setString("prod", var1).setString("dep", var2);
      }

      List var6 = var7.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ReceptionLotAchats rechercheLot(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var5 = true;
      }

      new ReceptionLotAchats();
      Query var7 = var4.createQuery("from ReceptionLotAchats where reclotCode=:prod and reclotDepot=:dep and reclotNumero=:lt").setString("prod", var1).setString("dep", var2).setString("lt", var3).setMaxResults(1);
      List var8 = var7.list();
      ReceptionLotAchats var6;
      if (var8.size() != 0) {
         var6 = (ReceptionLotAchats)var8.get(0);
      } else {
         var6 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ReceptionLotAchats rechercheLot(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var4 = true;
      }

      new ReceptionLotAchats();
      Query var6 = var3.createQuery("from ReceptionLotAchats where reclotIdLigneFab=:idf").setLong("idf", var1).setMaxResults(1);
      List var7 = var6.list();
      ReceptionLotAchats var5;
      if (var7.size() != 0) {
         var5 = (ReceptionLotAchats)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectLotDispo(String var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ReceptionLotAchats where reclotCode=:prod and reclotQteUtilConso<reclotQteUtil").setString("prod", var1);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List selectLot(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ReceptionLotAchats where reclotCode=:prod and reclotNumero=:num").setString("prod", var1).setString("num", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ReceptionLotAchats rechercheLot(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ReceptionLigne");
         var4 = true;
      }

      new ReceptionLotAchats();
      Query var6 = var3.createQuery("from ReceptionLotAchats where reclotCode=:prod and reclotNumero=:lt").setString("prod", var1).setString("lt", var2).setMaxResults(1);
      List var7 = var6.list();
      ReceptionLotAchats var5;
      if (var7.size() != 0) {
         var5 = (ReceptionLotAchats)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
