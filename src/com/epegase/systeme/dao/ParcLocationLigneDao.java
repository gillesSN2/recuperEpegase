package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ParcLocationEntete;
import com.epegase.systeme.classe.ParcLocationLigne;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParcLocationLigneDao implements Serializable {
   private ParcLocationLigne parcLocationLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ParcLocationLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ParcLocationLigne insertLigne(ParcLocationLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Parc_location");
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

   public ParcLocationLigne insertLigne(ParcLocationLigne var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ParcLocationLigne modifLigne(ParcLocationLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Parc_location");
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

   public ParcLocationLigne modifLigne(ParcLocationLigne var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void deleteOnLigne(ParcLocationLigne var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Parc_location");
      Transaction var3 = null;

      try {
         var3 = var2.beginTransaction();
         var2.delete(var1);
         var3.commit();
      } catch (HibernateException var8) {
         if (var3 != null) {
            var3.rollback();
         }

         throw var8;
      } finally {
         this.utilInitHibernate.closeSession();
      }

   }

   public void deleteOnLigne(ParcLocationLigne var1, Session var2) {
      var2.delete(var1);
   }

   public void deleteAllLigne(ParcLocationEntete var1, Session var2) {
      var2.createQuery("delete from ParcLocationLigne where ParcLocationEntete=:id").setLong("id", var1.getPrclocId()).executeUpdate();
   }

   public List chargerLesLignes(ParcLocationEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ParcLocationLigne");
         var3 = true;
      }

      List var4 = var2.createQuery("from ParcLocationLigne where ParcLocationEntete=:idfk").setLong("idfk", var1.getPrclocId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from ParcLocationLigne where prclocCode='" + var1 + "' and prclocDepot='" + var2 + "' and ParcLocationEntete.prcoreDate >'" + var3 + "' order desc by ParcLocationEntete.prcoreDate").list();
      return var5;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var4 == null) {
            var6 = var5.createQuery("from ParcLocationLigne where prclocCode='" + var1 + "' and prclocDepot='" + var2 + "' and ParcLocationEntete.prcoreDate >=:d1").setDate("d1", var3).list();
         } else {
            var6 = var5.createQuery("from ParcLocationLigne where prclocCode='" + var1 + "' and prclocDepot='" + var2 + "' and ParcLocationEntete.prcoreDate >=:d1 and ParcLocationEntete.prcoreDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
         }
      } else if (var4 == null) {
         var6 = var5.createQuery("from ParcLocationLigne where prclocCode='" + var1 + "' and ParcLocationEntete.prcoreDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from ParcLocationLigne where prclocCode='" + var1 + "' and ParcLocationEntete.prcoreDate >=:d1 and ParcLocationEntete.prcoreDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " ParcLocationEntete.prcoreSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " ParcLocationEntete.prcoreActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " ParcLocationEntete.prcoreService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " prclocDepot='" + var3 + "' and ";
      }

      var11 = var10.createQuery("select ParcLocationEntete.prcoreEtat,ParcLocationEntete.prcoreNum,ParcLocationEntete.prcoreDate,ParcLocationEntete.prcoreIdReceptionnaire,prclocId,prclocDepot,prclocCode,prclocFamille,prclocLibelle,prclocQte,prclocQteUtil,prclocPump,prclocTotal,prclocPoidsBrut,prclocObs,ParcLocationEntete.prcoreNomReceptionnaire from ParcLocationLigne where " + var12 + " prclocCode='" + var2 + "' and ParcLocationEntete.prcoreDate>='" + var8 + "' and ParcLocationEntete.prcoreDate<='" + var9 + "'").list();
      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from ParcLocationLigne where prclocCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvts(String var1, String var2, long var3, Session var5) {
      List var6 = null;
      String var7 = "";
      if (var2 != null && !var2.isEmpty()) {
         var7 = var7 + " prclocDepot='" + var2 + "' and ";
      }

      var6 = var5.createQuery("from ParcLocationLigne where " + var7 + " prclocCode='" + var1 + "'").list();
      return var6;
   }

   public List rechercheParcLocationLigneRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ParcLocationLigne");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ParcLocationLigne where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ParcLocationLigne rechercheParcLocationLigne(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ParcLocationLigne");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.parcLocationLigne = new ParcLocationLigne();
      var6 = var3.createQuery("from ParcLocationLigne where prclocId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.parcLocationLigne = (ParcLocationLigne)var6.get(0);
      } else {
         this.parcLocationLigne = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.parcLocationLigne;
   }
}
