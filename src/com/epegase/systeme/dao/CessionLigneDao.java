package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CessionEntete;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class CessionLigneDao implements Serializable {
   private CessionLigne cessionLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CessionLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CessionLigne insertLigne(CessionLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CessionLigne modifLigne(CessionLigne var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String deleteOneLigne(CessionLigne var1, Session var2) {
      Query var3 = var2.createQuery("delete from CessionLigne where cesligId =" + var1.getCesligId());
      var3.executeUpdate();
      return null;
   }

   public String deleteAllLigne(CessionEntete var1, Session var2) {
      var2.createQuery("delete from CessionLigne where cessionEntete=:id").setLong("id", var1.getCesId()).executeUpdate();
      return "";
   }

   public List chargerLesLignes(CessionEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CessionLigne where cessionEntete=:idfk").setLong("idfk", var1.getCesId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CessionLigne where cessionEntete.cesSommier=:som").setString("som", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesCes(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from CessionLigne where cessionEntete.cesNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesOrigine(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from CessionLigne where cesligCode='" + var1 + "' and cessionEntete.cesDepotOrigine='" + var2 + "' and cessionEntete.cesDate >'" + var3 + "' order desc by cessionEntete.cesDate").list();
      return var5;
   }

   public List chargerLesLignesDestination(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from CessionLigne where cesligCode='" + var1 + "' and cessionEntete.cesDepotDestination='" + var2 + "' and cessionEntete.cesDate >'" + var3 + "' order desc by cessionEntete.cesDate").list();
      return var5;
   }

   public List chargerLesLignesDestinationValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var4 == null) {
            var6 = var5.createQuery("from CessionLigne where cesligCode='" + var1 + "' and cessionEntete.cesDepotDestination='" + var2 + "' and cessionEntete.cesDate >=:d1").setDate("d1", var3).list();
         } else {
            var6 = var5.createQuery("from CessionLigne where cesligCode='" + var1 + "' and cessionEntete.cesDepotDestination='" + var2 + "' and cessionEntete.cesDate >=:d1 and cessionEntete.cesDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
         }
      } else if (var4 == null) {
         var6 = var5.createQuery("from CessionLigne where cesligCode='" + var1 + "' and cessionEntete.cesDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from CessionLigne where cesligCode='" + var1 + "' and cessionEntete.cesDate >=:d1 and cessionEntete.cesDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public List chargerLesMvtsOrigine(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " cessionEntete.cesSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " cessionEntete.cesActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " cessionEntete.cesService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " cesligDepotOrigine='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " cessionEntete.cesIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select cessionEntete.cesEtat,cessionEntete.cesNum,cessionEntete.cesSerie,cessionEntete.cesDate,cessionEntete.cesIdEquipe,cesligId,cesligDepotOrigine,cesligCode,cesligFamille,cesligLibelle,cesligQte,cesligQteUtil,cesligPump,cesligTotal,cesligPoidsBrut,cesligObs from CessionLigne where " + var12 + " cesligCode in " + var2 + " and cessionEntete.cesDate between '" + var8 + "' and '" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select cessionEntete.cesEtat,cessionEntete.cesNum,cessionEntete.cesSerie,cessionEntete.cesDate,cessionEntete.cesIdEquipe,cesligId,cesligDepotOrigine,cesligCode,cesligFamille,cesligLibelle,cesligQte,cesligQteUtil,cesligPump,cesligTotal,cesligPoidsBrut,cesligObs from CessionLigne where " + var12 + " cesligCode='" + var2 + "' and cessionEntete.cesDate between '" + var8 + "' and '" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select cessionEntete.cesEtat,cessionEntete.cesNum,cessionEntete.cesSerie,cessionEntete.cesDate,cessionEntete.cesIdEquipe,cesligId,cesligDepotOrigine,cesligCode,cesligFamille,cesligLibelle,cesligQte,cesligQteUtil,cesligPump,cesligTotal,cesligPoidsBrut,cesligObs from CessionLigne where " + var12 + " cessionEntete.cesDate between '" + var8 + "' and '" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvtsDestination(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " cessionEntete.cesSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " cessionEntete.cesActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " cessionEntete.cesService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " cesligDepotDestination='" + var3 + "' and ";
      }

      if (var4 != 0L) {
         var12 = var12 + " cessionEntete.cesIdEquipe=" + var4 + " and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select cessionEntete.cesEtat,cessionEntete.cesNum,cessionEntete.cesSerie,cessionEntete.cesDate,cessionEntete.cesIdEquipe,cesligId,cesligDepotDestination,cesligCode,cesligFamille,cesligLibelle,cesligQte,cesligQteUtil,cesligPump,cesligTotal,cesligPoidsBrut from CessionLigne where " + var12 + " cesligCode in " + var2 + " and cessionEntete.cesDate between '" + var8 + "' and '" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select cessionEntete.cesEtat,cessionEntete.cesNum,cessionEntete.cesSerie,cessionEntete.cesDate,cessionEntete.cesIdEquipe,cesligId,cesligDepotDestination,cesligCode,cesligFamille,cesligLibelle,cesligQte,cesligQteUtil,cesligPump,cesligTotal,cesligPoidsBrut from CessionLigne where " + var12 + " cesligCode='" + var2 + "' and cessionEntete.cesDate between '" + var8 + "' and '" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select cessionEntete.cesEtat,cessionEntete.cesNum,cessionEntete.cesSerie,cessionEntete.cesDate,cessionEntete.cesIdEquipe,cesligId,cesligDepotDestination,cesligCode,cesligFamille,cesligLibelle,cesligQte,cesligQteUtil,cesligPump,cesligTotal,cesligPoidsBrut from CessionLigne where " + var12 + " cessionEntete.cesDate between '" + var8 + "' and '" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, String var2, long var3, String var5, String var6, String var7, String var8, Session var9) {
      List var10 = null;
      String var11 = "";
      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " cessionEntete.cesActivite='" + var5 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var11 = var11 + " cessionEntete.cesService='" + var6 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         var11 = var11 + " cesligDepotOrigine='" + var2 + "' and ";
      }

      if (var3 != 0L) {
         var11 = var11 + " cessionEntete.cesIdEquipe=" + var3 + " and ";
      }

      var10 = var9.createQuery("select cessionEntete.cesEtat,cessionEntete.cesNum,cessionEntete.cesSerie,cessionEntete.cesDate,cessionEntete.cesIdEquipe,cesligId,cesligDepotOrigine,cesligCode,cesligFamille,cesligLibelle,cesligQte,cesligQteUtil,cesligPump,cesligTotal,cesligPoidsBrut from CessionLigne where " + var11 + " cesligCode='" + var1 + "' and cessionEntete.cesDate between '" + var7 + "' and '" + var8 + "'").list();
      return var10;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from CessionLigne where cesligCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvts(String var1, String var2, long var3, Session var5) {
      List var6 = null;
      String var7 = "";
      if (var2 != null && !var2.isEmpty()) {
         var7 = var7 + " cesligDepotDestination='" + var2 + "' and ";
      }

      if (var3 != 0L) {
         var7 = var7 + " cessionEntete.cesIdEquipe=" + var3 + " and ";
      }

      var6 = var5.createQuery("from CessionLigne where " + var7 + " cesligCode='" + var1 + "'").list();
      return var6;
   }

   public List rechercheCessionRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CessionLigne where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public CessionLigne rechercheCession(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CessionEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.cessionLigne = new CessionLigne();
      var6 = var3.createQuery("from CessionLigne where cesligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.cessionLigne = (CessionLigne)var6.get(0);
      } else {
         this.cessionLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.cessionLigne;
   }
}
