package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ReceptionAvicultureAchats;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReceptionAvicultureAchatsDao implements Serializable {
   private ReceptionAvicultureAchats receptionAvicultureAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ReceptionAvicultureAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ReceptionAvicultureAchats insertLigne(ReceptionAvicultureAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReceptionAvicultureAchats modifLigne(ReceptionAvicultureAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEnteteLight");
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

   public ReceptionAvicultureAchats modifLigne(ReceptionAvicultureAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void deleteAllLigne(ReceptionEnteteAchats var1, Session var2) {
      var2.createQuery("delete from ReceptionAvicultureAchats where receptionEnteteAchats=:id").setLong("id", var1.getRecId()).executeUpdate();
   }

   public void deleteOneLigne(ReceptionAvicultureAchats var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerLesLignes(ReceptionEnteteAchats var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEnteteLight");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReceptionAvicultureAchats where receptionEnteteAchats=:idfk").setLong("idfk", var1.getRecId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignes(String var1, String var2, Date var3, Session var4) {
      List var5 = var4.createQuery("from ReceptionAvicultureAchats where recligCode='" + var1 + "' and recligDepot='" + var2 + "' and receptionEnteteAchats.recDate >'" + var3 + "' order desc by receptionEnteteAchats.recDate").list();
      return var5;
   }

   public List chargerLesLignesReceptions(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEnteteLight");
         var3 = true;
      }

      List var4 = var2.createQuery("from ReceptionAvicultureAchats where receptionEnteteAchats.recNum in (" + var1 + ")").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ReceptionAvicultureAchats rechercheReception(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEnteteLight");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.receptionAvicultureAchats = new ReceptionAvicultureAchats();
      var6 = var3.createQuery("from ReceptionAvicultureAchats where recligId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.receptionAvicultureAchats = (ReceptionAvicultureAchats)var6.get(0);
      } else {
         this.receptionAvicultureAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.receptionAvicultureAchats;
   }

   public ReceptionAvicultureAchats rechercheReception(Date var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEnteteLight");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.receptionAvicultureAchats = new ReceptionAvicultureAchats();
      var6 = var3.createQuery("from ReceptionAvicultureAchats where recaviDate=:dte and receptionEnteteAchats.recProduction=:lt").setDate("dte", var1).setString("lt", var2).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.receptionAvicultureAchats = (ReceptionAvicultureAchats)var6.get(0);
      } else {
         this.receptionAvicultureAchats = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.receptionAvicultureAchats;
   }
}
