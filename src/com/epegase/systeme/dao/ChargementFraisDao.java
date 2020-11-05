package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ChargementEntete;
import com.epegase.systeme.classe.ChargementFrais;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChargementFraisDao implements Serializable {
   private ChargementFrais chargementFrais;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ChargementFraisDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public List chargerLesLignes(ChargementEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from ChargementFrais where ChargementEntete=:idfk").setLong("idfk", var1.getChamobId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvts(String var1, String var2, String var3, Session var4) {
      List var5 = null;
      var5 = var4.createQuery("from ChargementFrais where chafraCode='" + var1 + "' and ChargementEntete.chamobDate>='" + var2 + "' and ChargementEntete.chamobDate<='" + var3 + "'").list();
      return var5;
   }

   public void saveLigne(List var1, ChargementEntete var2, Session var3) {
      for(int var4 = 0; var4 < var1.size(); ++var4) {
         ChargementFrais var5 = (ChargementFrais)var1.get(var4);
         var5.setChargementEntete(var2);
         var3.save(var5);
      }

   }

   public void duppliquerLigne(List var1, ChargementEntete var2, Session var3) {
   }

   public String deleteAllLigne(ChargementEntete var1, Session var2) {
      var2.createQuery("delete from ChargementFrais where ChargementEntete=:id").setLong("id", var1.getChamobId()).executeUpdate();
      return "";
   }

   public void deleteAllLigne(List var1, Session var2) {
      for(int var3 = 0; var3 < var1.size(); ++var3) {
         ChargementFrais var4 = (ChargementFrais)var1.get(var3);
         var2.delete(var4);
      }

   }

   public ChargementFrais insert(ChargementFrais var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
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

   public ChargementFrais insert(ChargementFrais var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ChargementFrais modif(ChargementFrais var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
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

   public ChargementFrais modif(ChargementFrais var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public ChargementFrais delete(ChargementFrais var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
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

      return var1;
   }

   public List chargerLesLignes(String var1, Date var2, Session var3) {
      List var4 = var3.createQuery("from ChargementFrais where chafraCode='" + var1 + "' and chargementEntete.chamobDate >'" + var2 + "'").list();
      return var4;
   }

   public List rechercheFraisRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BchargementEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ChargementFrais where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
