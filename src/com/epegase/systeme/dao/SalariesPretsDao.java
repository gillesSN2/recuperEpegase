package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesPrets;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SalariesPretsDao implements Serializable {
   private SalariesPrets salariesPrets;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public SalariesPretsDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public SalariesPrets insert(SalariesPrets var1) throws HibernateException, NamingException {
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

   public SalariesPrets insert(SalariesPrets var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public SalariesPrets modif(SalariesPrets var1) throws HibernateException, NamingException {
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

   public SalariesPrets modif(SalariesPrets var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(SalariesPrets var1) throws HibernateException, NamingException {
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

   public void delete(SalariesPrets var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerlesPretsInternes(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesPrets where Salaries=:salarie and salpreType=0 order by salpreNum asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesPretsExternes(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesPrets where Salaries=:salarie and salpreType=1 order by salpreNum asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesPretsManuels(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesPrets where Salaries=:salarie and salpreType=2 order by salpreNum asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerlesTousPrets(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesPrets where Salaries=:salarie order by salpreNum asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerTouslesPrets(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesPrets order by salpreNum asc");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public List chargerTouslesPrets(long var1, int var3, int var4, int var5, int var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, Session var19) throws HibernateException, NamingException {
      boolean var20 = false;
      if (var19 == null) {
         var19 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var20 = true;
      }

      Object var21 = new ArrayList();
      String var22 = "salpreId >=1 ";
      if (var1 != 0L) {
         if (var1 == -1L) {
            var22 = var22 + " and Salaries.salIdtiers=0";
         } else if (var1 >= 1L) {
            var22 = var22 + " and Salaries.salIdTiers=" + var1;
         }
      }

      if (var6 != 100) {
         if (var6 == 90) {
            var22 = var22 + " and (Salaries.salEtat=0 or Salaries.salEtat=1)";
         } else {
            var22 = var22 + " and Salaries.salEtat=" + var6;
         }
      }

      if (var5 != 100) {
         var22 = var22 + " and salpreEtat=" + var5;
      }

      if (var7 != null && !var7.isEmpty() && !var7.equals("100")) {
         var22 = var22 + " and Salaries.salFeuille='" + var7 + "'";
      }

      if (var8 != null && !var8.isEmpty() && !var8.equals("100")) {
         var22 = var22 + " and Salaries.salNature='" + var8 + "'";
      }

      String[] var23;
      String var24;
      if (var9 != null && !var9.isEmpty() && var9.contains(":")) {
         var23 = var9.split(":");
         var24 = var23[0];
         var22 = var22 + " and Salaries.salSite='" + var24 + "'";
      }

      if (var10 != null && !var10.isEmpty() && var10.contains(":")) {
         var23 = var10.split(":");
         var24 = var23[0];
         var22 = var22 + " and Salaries.salDepartement='" + var24 + "'";
      }

      if (var11 != null && !var11.isEmpty() && var11.contains(":")) {
         var23 = var11.split(":");
         var24 = var23[0];
         var22 = var22 + " and Salaries.salService='" + var24 + "'";
      }

      if (var12 != null && !var12.isEmpty() && var12.contains(":")) {
         var23 = var12.split(":");
         var24 = var23[0];
         var22 = var22 + " and Salaries.salActivite='" + var24 + "'";
      }

      if (var13 != null && !var13.isEmpty() && var13.contains(":")) {
         var23 = var13.split(":");
         var24 = var23[0];
         var22 = var22 + " and Salaries.salConvention='" + var24 + "'";
      }

      if (var14 != null && !var14.isEmpty() && var14.contains(":")) {
         var23 = var14.split(":");
         var24 = var23[0];
         var22 = var22 + " and Salaries.salNivEmploi='" + var24 + "'";
      }

      if (var15 != null && !var15.isEmpty() && var15.contains(":")) {
         var23 = var15.split(":");
         var24 = var23[0];
         var22 = var22 + " and Salaries.salClassement='" + var24 + "'";
      }

      if (var16 != null && !var16.isEmpty() && var16.contains(":")) {
         var23 = var16.split(":");
         var24 = var23[0];
         var22 = var22 + " and Salaries.salGrille='" + var24 + "'";
      }

      if (var17 != null && !var17.isEmpty() && var17.contains(":")) {
         var23 = var17.split(":");
         var24 = var23[0];
         var22 = var22 + " and Salaries.salCentresImpots='" + var24 + "'";
      }

      if (var18 != null && !var18.isEmpty()) {
         String var25 = "";
         if (var18.contains(":")) {
            String[] var26 = var18.split(":");
            var25 = var26[0];
         } else {
            var25 = var18;
         }

         var22 = var22 + " and Salaries.salMatricule like '%" + var25 + "'";
      }

      if (var4 != 100) {
         var22 = var22 + " and salpreNature=" + var4;
      }

      Query var27 = null;
      if (var3 == 1) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreType=0 and salpreMontant<>salpreRmb order by salpreNum asc");
      } else if (var3 == 2) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreType=1 and salpreMontant<>salpreRmb order by salpreNum asc");
      } else if (var3 == 3) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreType=2 and salpreMontant<>salpreRmb order by salpreNum asc");
      } else if (var3 == 9) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreMontant<>salpreRmb order by salpreNum asc");
      } else if (var3 == 11) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreType=0  and salpreMontant=salpreRmb order by salpreNum asc");
      } else if (var3 == 12) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreType=1 and salpreMontant=salpreRmb order by salpreNum asc");
      } else if (var3 == 13) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreType=2 and salpreMontant=salpreRmb order by salpreNum asc");
      } else if (var3 == 19) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreMontant=salpreRmb order by salpreNum asc");
      } else if (var3 == 21) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreType=0  order by salpreNum asc");
      } else if (var3 == 22) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreType=1 order by salpreNum asc");
      } else if (var3 == 23) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " and salpreType=2 order by salpreNum asc");
      } else if (var3 == 29) {
         var27 = var19.createQuery("from SalariesPrets where " + var22 + " order by salpreNum asc");
      }

      if (var27 != null) {
         var21 = var27.list();
      }

      if (var20) {
         this.utilInitHibernate.closeSession();
      }

      return (List)var21;
   }

   public List chargerlesPretsInternesValide(Salaries var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from SalariesPrets where Salaries=:salarie and salpreType=0 and salpreEtat=:et order by salpreNum asc").setParameter("salarie", var1).setInteger("et", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesPretsExternesValide(Salaries var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from SalariesPrets where Salaries=:salarie and salpreType=1 and salpreEtat=:et order by salpreNum asc").setParameter("salarie", var1).setInteger("et", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerlesPretsManuelsValide(Salaries var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from SalariesPrets where Salaries=:salarie and salpreType=2 and salpreEtat=1 order by salpreNum asc").setParameter("salarie", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerTouslesPretsValide(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from SalariesPrets where salpreEtat=1 order by salpreNum asc");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public SalariesPrets pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesPrets where salpreId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      SalariesPrets var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesPrets)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public SalariesPrets pourParapheur(String var1, Salaries var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Salarie");
         var4 = true;
      }

      Query var5 = var3.createQuery("from SalariesPrets where Salaries=:sal and salpreNum=:num").setString("num", var1).setParameter("sal", var2).setMaxResults(1);
      List var6 = var5.list();
      SalariesPrets var7 = null;
      if (var6.size() != 0) {
         var7 = (SalariesPrets)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
