package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ParcOrEntete;
import com.epegase.systeme.classe.ParcOrPiece;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ParcOrPieceDao implements Serializable {
   private ParcOrPiece parcOrPiece;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ParcOrPieceDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ParcOrPiece insertLigne(ParcOrPiece var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Parc_or");
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

   public ParcOrPiece insertLigne(ParcOrPiece var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ParcOrPiece modifLigne(ParcOrPiece var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Parc_or");
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

   public ParcOrPiece modifLigne(ParcOrPiece var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public void deleteOnLigne(ParcOrPiece var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Parc_or");
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

   public void deleteOnLigne(ParcOrPiece var1, Session var2) {
      var2.delete(var1);
   }

   public void deleteAllLigne(ParcOrEntete var1, Session var2) {
      var2.createQuery("delete from ParcOrPiece where parcOrEntete=:id").setLong("id", var1.getPrcoreId()).executeUpdate();
   }

   public List chargerLesLignes(ParcOrEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ParcOrPiece");
         var3 = true;
      }

      List var4 = var2.createQuery("from ParcOrPiece where parcOrEntete=:idfk").setLong("idfk", var1.getPrcoreId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from ParcOrPiece where prcorpCode='" + var1 + "' and prcorpDepot='" + var2 + "' and parcOrEntete.prcoreDate >'" + var3 + "' order desc by parcOrEntete.prcoreDate").list();
      return var5;
   }

   public List chargerLesLignesValorisation(String var1, String var2, Date var3, Date var4, Session var5) {
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         if (var4 == null) {
            var6 = var5.createQuery("from ParcOrPiece where prcorpCode='" + var1 + "' and prcorpDepot='" + var2 + "' and parcOrEntete.prcoreDate >=:d1").setDate("d1", var3).list();
         } else {
            var6 = var5.createQuery("from ParcOrPiece where prcorpCode='" + var1 + "' and prcorpDepot='" + var2 + "' and parcOrEntete.prcoreDate >=:d1 and parcOrEntete.prcoreDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
         }
      } else if (var4 == null) {
         var6 = var5.createQuery("from ParcOrPiece where prcorpCode='" + var1 + "' and parcOrEntete.prcoreDate >=:d1").setDate("d1", var3).list();
      } else {
         var6 = var5.createQuery("from ParcOrPiece where prcorpCode='" + var1 + "' and parcOrEntete.prcoreDate >=:d1 and parcOrEntete.prcoreDate <=:d2").setDate("d1", var3).setDate("d2", var4).list();
      }

      return var6;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " parcOrEntete.prcoreSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " parcOrEntete.prcoreActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " parcOrEntete.prcoreService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " prcorpDepot='" + var3 + "' and ";
      }

      var11 = var10.createQuery("select parcOrEntete.prcoreEtat,parcOrEntete.prcoreNum,parcOrEntete.prcoreDate,parcOrEntete.prcoreIdReceptionnaire,prcorpId,prcorpDepot,prcorpCode,prcorpFamille,prcorpLibelle,prcorpQte,prcorpQteUtil,prcorpPump,prcorpTotal,prcorpPoidsBrut,prcorpObs,parcOrEntete.prcoreNomReceptionnaire from ParcOrPiece where " + var12 + " prcorpCode='" + var2 + "' and parcOrEntete.prcoreDate>='" + var8 + "' and parcOrEntete.prcoreDate<='" + var9 + "'").list();
      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from ParcOrPiece where prcorpCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvts(String var1, String var2, long var3, Session var5) {
      List var6 = null;
      String var7 = "";
      if (var2 != null && !var2.isEmpty()) {
         var7 = var7 + " prcorpDepot='" + var2 + "' and ";
      }

      var6 = var5.createQuery("from ParcOrPiece where " + var7 + " prcorpCode='" + var1 + "'").list();
      return var6;
   }

   public List rechercheParcOrPieceRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ParcOrPiece");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ParcOrPiece where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ParcOrPiece rechercheParcOrPiece(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ParcOrPiece");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.parcOrPiece = new ParcOrPiece();
      var6 = var3.createQuery("from ParcOrPiece where prcorpId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.parcOrPiece = (ParcOrPiece)var6.get(0);
      } else {
         this.parcOrPiece = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.parcOrPiece;
   }
}
