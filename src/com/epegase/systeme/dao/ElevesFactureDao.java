package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Eleves;
import com.epegase.systeme.classe.ElevesFacture;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ElevesFactureDao implements Serializable {
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ElevesFactureDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ElevesFacture insert(ElevesFacture var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public ElevesFacture insert(ElevesFacture var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ElevesFacture modif(ElevesFacture var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public ElevesFacture modif(ElevesFacture var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ElevesFacture var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
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

   public void delete(ElevesFacture var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public ElevesFacture getElevesFactureById(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
      ElevesFacture var4 = (ElevesFacture)var3.get(ElevesFacture.class, var1);
      this.utilInitHibernate.closeSession();
      return var4;
   }

   public List chargerLesElevesFacture(Eleves var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var3 = true;
      }

      List var4 = var2.createQuery("From ElevesFacture where eleves=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesFacturesEcheances(Date var1, Date var2, String var3, String var4, String var5, String var6, String var7, String var8, Session var9) throws HibernateException, NamingException {
      boolean var10 = false;
      if (var9 == null) {
         var9 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var10 = true;
      }

      String var11 = "";
      if (var3 != null && !var3.isEmpty()) {
         var11 = var11 + " and elefacSite='" + var3 + "'";
      }

      if (var4 != null && !var4.isEmpty()) {
         var11 = var11 + " and elefacDepartement='" + var4 + "'";
      }

      if (var5 != null && !var5.isEmpty()) {
         var11 = var11 + " and elefacService='" + var5 + "'";
      }

      if (var6 != null && !var6.isEmpty()) {
         var11 = var11 + " and elefacRegion='" + var6 + "'";
      }

      if (var7 != null && !var7.isEmpty()) {
         var11 = var11 + " and elefacSecteur='" + var7 + "'";
      }

      if (var8 != null && !var8.isEmpty()) {
         var11 = var11 + " and elefacPdv='" + var8 + "'";
      }

      List var12 = var9.createQuery("From ElevesFacture where (elefacDateEche01>=:d1 and elefacDateEche01<=:d2) or (elefacDateEche02>=:d1 and elefacDateEche02<=:d2) or (elefacDateEche03>=:d1 and elefacDateEche03<=:d2) or (elefacDateEche04>=:d1 and elefacDateEche04<=:d2) or (elefacDateEche05>=:d1 and elefacDateEche05<=:d2) or (elefacDateEche06>=:d1 and elefacDateEche06<=:d2) or (elefacDateEche07>=:d1 and elefacDateEche07<=:d2) or (elefacDateEche08>=:d1 and elefacDateEche08<=:d2) or (elefacDateEche09>=:d1 and elefacDateEche09<=:d2) or (elefacDateEche10>=:d1 and elefacDateEche10<=:d2) or (elefacDateEche11>=:d1 and elefacDateEche11<=:d2) or (elefacDateEche12>=:d1 and elefacDateEche12<=:d2)" + var11).setDate("d1", var1).setDate("d2", var2).list();
      if (var10) {
         this.utilInitHibernate.closeSession();
      }

      return var12;
   }

   public ElevesFacture getElevesFactureMedByType(int var1, String var2, Eleves var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var5 = true;
      }

      List var6 = var4.createQuery("From ElevesFacture where eleves=:param and elefacType=:typ and elefacAnnee=:an").setParameter("param", var3).setInteger("typ", var1).setString("an", var2).list();
      new ElevesFacture();
      ElevesFacture var7;
      if (var6.size() != 0) {
         var7 = (ElevesFacture)var6.get(0);
      } else {
         var7 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ElevesFacture pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ElevesFacture where elefacId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new ElevesFacture();
      ElevesFacture var7;
      if (var6.size() != 0) {
         var7 = (ElevesFacture)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ElevesFacture pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Eleves");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ElevesFacture where elefacNum =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new ElevesFacture();
      ElevesFacture var6;
      if (var5.size() != 0) {
         var6 = (ElevesFacture)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
