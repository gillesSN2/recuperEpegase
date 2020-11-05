package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesGrh;
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

public class SalariesGrhDao implements Serializable {
   private SalariesGrh salariesGrh;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesGrhDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesGrh insert(SalariesGrh var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public SalariesGrh insert(SalariesGrh var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SalariesGrh modif(SalariesGrh var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public SalariesGrh modif(SalariesGrh var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesGrh var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
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

   public void delete(SalariesGrh var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List chargerlesElementRh(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesGrh where Salaries=:salarie order by salgrhType asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesElementRhFamille(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesGrh where Salaries=:salarie and (salgrhType=15 or salgrhType=16) order by salgrhType asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesElementRh(int var1, int var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, Session var14) throws HibernateException, NamingException {
      boolean var15 = false;
      if (var14 == null) {
         var14 = this.utilInitHibernate.getOpenSession(this.maBase, "SuiviRH");
         var15 = true;
      }

      new ArrayList();
      String var17 = "";
      if (var2 != 100) {
         if (var2 == 90) {
            var17 = var17 + " and (Salaries.salEtat=0 or Salaries.salEtat=1)";
         } else {
            var17 = var17 + " and Salaries.salEtat=" + var2;
         }
      }

      if (!var3.equals("100")) {
         var17 = var17 + " and Salaries.salFeuille='" + var3 + "'";
      }

      if (!var4.equals("100")) {
         var17 = var17 + " and Salaries.salNature='" + var4 + "'";
      }

      String[] var18;
      String var19;
      if (var5.contains(":")) {
         var18 = var5.split(":");
         var19 = var18[0];
         var17 = var17 + " and Salaries.salSite='" + var19 + "'";
      }

      if (var6.contains(":")) {
         var18 = var6.split(":");
         var19 = var18[0];
         var17 = var17 + " and Salaries.salDepartement='" + var19 + "'";
      }

      if (var7.contains(":")) {
         var18 = var7.split(":");
         var19 = var18[0];
         var17 = var17 + " and Salaries.salService='" + var19 + "'";
      }

      if (var8.contains(":")) {
         var18 = var8.split(":");
         var19 = var18[0];
         var17 = var17 + " and Salaries.salActivite='" + var19 + "'";
      }

      if (var9.contains(":")) {
         var18 = var9.split(":");
         var19 = var18[0];
         var17 = var17 + " and Salaries.salConvention='" + var19 + "'";
      }

      if (var10.contains(":")) {
         var18 = var10.split(":");
         var19 = var18[0];
         var17 = var17 + " and Salaries.salNivEmploi='" + var19 + "'";
      }

      if (var11.contains(":")) {
         var18 = var11.split(":");
         var19 = var18[0];
         var17 = var17 + " and Salaries.salClassement='" + var19 + "'";
      }

      if (var12.contains(":")) {
         var18 = var12.split(":");
         var19 = var18[0];
         var17 = var17 + " and Salaries.salGrille='" + var19 + "'";
      }

      if (var13.contains(":")) {
         var18 = var13.split(":");
         var19 = var18[0];
         var17 = var17 + " and Salaries.salCentresImpots='" + var19 + "'";
      }

      Query var20 = var14.createQuery("from SalariesGrh where salgrhType=" + var1 + var17);
      List var16 = var20.list();
      if (var15) {
         this.utilInitHibernate.closeSession();
      }

      return var16;
   }

   public SalariesGrh pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesGrh where salgrhId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      SalariesGrh var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesGrh)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerlesElementRhAlerte(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from SalariesGrh where salgrhDateAlerte>=:deb and salgrhDateAlerte<=:fin order by salgrhType asc").setDate("deb", var1).setDate("fin", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
