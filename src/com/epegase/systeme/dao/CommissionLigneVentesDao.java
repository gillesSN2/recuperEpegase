package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CommissionEnteteVentes;
import com.epegase.systeme.classe.CommissionLigneVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CommissionLigneVentesDao implements Serializable {
   private CommissionLigneVentes commissionLigneVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CommissionLigneVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CommissionLigneVentes insertLigne(CommissionLigneVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CommissionLigneVentes modifLigne(CommissionLigneVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void deleteAllLigne(CommissionEnteteVentes var1, Session var2) {
      var2.createQuery("delete from CommissionLigneVentes where commissionEnteteVentes=:id").setLong("id", var1.getComId()).executeUpdate();
   }

   public void deleteOneLigne(CommissionLigneVentes var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerLesLignes(CommissionEnteteVentes var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CommissionLigneVentes where commissionEnteteVentes=:idfk").setLong("idfk", var1.getComId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, String var4, String var5, Session var6) {
      List var7 = null;
      String var8 = "";
      if (var2 != null && !var2.isEmpty()) {
         var8 = " commissionEnteteVentes.facActivite='" + var2 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var8 = " commissionEnteteVentes.facService='" + var3 + "' and ";
      }

      var7 = var6.createQuery("from CommissionLigneVentes where " + var8 + " comligCode='" + var1 + "' and commissionEnteteVentes.comDateDebut>='" + var4 + "' and commissionEnteteVentes.comDateDebut<='" + var5 + "'").list();
      return var7;
   }

   public List chargerLesCommissionsDirectes(String var1, String var2, String var3, String var4, String var5, Session var6) {
      List var7 = null;
      String var8 = "";
      if (var2 != null && !var2.isEmpty()) {
         var8 = " commissionEnteteVentes.facActivite='" + var2 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var8 = " commissionEnteteVentes.facService='" + var3 + "' and ";
      }

      var7 = var6.createQuery("from CommissionLigneVentes where " + var8 + " comligEntStock=1 and comligCode='" + var1 + "' and commissionEnteteVentes.comDateDebut>='" + var4 + "' and commissionEnteteVentes.comDateDebut<='" + var5 + "'").list();
      return var7;
   }

   public List chargerLesMvtsTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from CommissionLigneVentes where commissionEnteteVentes.tiers.tieid=" + var1.getTieid() + " and commissionEnteteVentes.comDateDebut between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsUsers(Users var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from CommissionLigneVentes where (commissionEnteteVentes.facIdCommercial=" + var1.getUsrid() + " or commissionEnteteVentes.facIdResponsable=" + var1.getUsrid() + ") and commissionEnteteVentes.comDateDebut between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheCommissionRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CommissionLigneVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
