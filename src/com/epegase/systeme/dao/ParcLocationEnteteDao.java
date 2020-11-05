package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ParcLocationEntete;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ParcLocationEnteteDao implements Serializable {
   private ParcLocationEntete parcLocationEntete;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ParcLocationEnteteDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ParcLocationEntete insert(ParcLocationEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc_or");
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

   public ParcLocationEntete insert(ParcLocationEntete var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ParcLocationEntete modif(ParcLocationEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc_or");
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

   public ParcLocationEntete modif(ParcLocationEntete var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public String delete(ParcLocationEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc_or");
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

      return null;
   }

   public List rechercheParcLocationEntete(long var1, long var3, String var5, int var6, long var7, String var9, String var10, int var11, String var12, String var13, String var14, String var15, String var16, String var17, String var18, String var19, Session var20) throws HibernateException, NamingException, ParseException {
      boolean var21 = false;
      if (var20 == null) {
         var20 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc_location");
         var21 = true;
      }

      UtilDate var22 = new UtilDate();
      new ArrayList();
      Criteria var24 = var20.createCriteria(ParcLocationEntete.class);
      Calendar var25 = Calendar.getInstance();
      Date var26 = null;
      Date var27 = null;
      Date var28 = new Date();
      String var29 = var22.dateToStringFr(var28);
      String var30 = var29.substring(6, 10) + "-" + var29.substring(3, 5) + "-" + var29.substring(0, 2);
      var26 = var22.stringToDateSQL(var30 + " 00:00:00");
      var27 = var22.stringToDateSQL(var30 + " 23:59:59");
      int var31 = var28.getYear() + 1900;
      String var32;
      String var33;
      if (var12.equalsIgnoreCase("100")) {
         if (var17 != null && var18 != null) {
            var26 = var22.stringToDateSQL(var17 + " 00:00:00");
            var27 = var22.stringToDateSQL(var18 + " 23:59:59");
            var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
         } else {
            var32 = "1980-01-01";
            var22.stringToDateSQL(var32 + " 00:00:00");
            var24 = var24.add(Restrictions.isNotNull("prclocDate"));
         }
      } else {
         if (!var12.equalsIgnoreCase("12") && !var12.equalsIgnoreCase("13") && !var12.equalsIgnoreCase("14")) {
            var24 = var24.add(Restrictions.eq("exerciceventes.exeprcId", var1));
         }

         if (var12.equalsIgnoreCase("0")) {
            var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
         } else if (var12.equalsIgnoreCase("1")) {
            var32 = "" + var25.getTime();
            if (var32.contains("Mon")) {
               var26 = var25.getTime();
            } else if (var32.contains("Tue")) {
               var25.add(7, -1);
               var26 = var25.getTime();
            } else if (var32.contains("Wed")) {
               var25.add(7, -2);
               var26 = var25.getTime();
            } else if (var32.contains("Thu")) {
               var25.add(7, -3);
               var26 = var25.getTime();
            } else if (var32.contains("Fri")) {
               var25.add(7, -4);
               var26 = var25.getTime();
            } else if (var32.contains("Sat")) {
               var25.add(7, -5);
               var26 = var25.getTime();
            } else if (var32.contains("Sun")) {
               var25.add(7, -6);
               var26 = var25.getTime();
            }

            var29 = var22.dateToStringFr(var26);
            var30 = var29.substring(6, 10) + "-" + var29.substring(3, 5) + "-" + var29.substring(0, 2);
            var26 = var22.stringToDateSQL(var30 + " 00:00:00");
            var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
         } else {
            int var36;
            if (var12.equalsIgnoreCase("2")) {
               var36 = var25.get(2) + 1;
               var33 = var31 + "-" + var36 + "-01";
               var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("3")) {
               var36 = var25.get(2);
               var25.add(5, -var36);
               if (var36 <= 3) {
                  var33 = var31 + "-01-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               } else if (var36 >= 4 && var36 <= 6) {
                  var33 = var31 + "-04-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               } else if (var36 >= 7 && var36 <= 9) {
                  var33 = var31 + "-07-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               } else if (var36 >= 10) {
                  var33 = var31 + "-10-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               }

               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("4")) {
               var36 = var25.get(2);
               var25.add(5, -var36);
               if (var36 <= 6) {
                  var33 = var31 + "-01-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               } else {
                  var33 = var31 + "-07-01";
                  var26 = var22.stringToDateSQL(var33 + " 00:00:00");
               }

               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("5")) {
               var32 = var31 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-03-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("6")) {
               var32 = var31 + "-04-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-06-30";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("7")) {
               var32 = var31 + "-07-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-09-30";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("8")) {
               var32 = var31 + "-10-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("9")) {
               var32 = var31 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-06-30";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("10")) {
               var32 = var31 + "-07-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("11")) {
               var32 = var31 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("12")) {
               var32 = "1980-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 - 1 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("13")) {
               var32 = var31 - 1 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("14")) {
               var32 = var31 - 1 + "-01-01";
               var26 = var22.stringToDateSQL(var32 + " 00:00:00");
               var33 = var31 - 1 + "-12-31";
               var27 = var22.stringToDateSQL(var33 + " 23:59:59");
               var24 = var24.add(Restrictions.between("prclocDate", var26, var27));
            } else if (var12.equalsIgnoreCase("20")) {
               var24.setMaxResults(20);
               var24 = var24.addOrder(Order.desc("prclocId"));
            }
         }
      }

      if (var9 != null && !var9.isEmpty()) {
         var32 = "%" + var9 + "%";
         var24 = var24.add(Restrictions.like("prclocNum", var32));
      }

      if (var3 != 0L) {
         var24 = var24.add(Restrictions.eq("tiers.tieid", var3));
      } else if (var5 != null && !var5.isEmpty()) {
         var32 = "";
         if (var5.startsWith("*")) {
            var32 = "%" + var5.substring(1) + "%";
         } else {
            var32 = var5 + "%";
         }

         var24 = var24.add(Restrictions.like("prclocNomClient", var32));
      }

      if (var14 != null && !var14.isEmpty()) {
         var24 = var24.add(Restrictions.eq("prclocNomCommercial", var14));
      }

      if (var15 != null && !var15.isEmpty()) {
         var24 = var24.add(Restrictions.eq("prclocNomChauffeur", var15));
      }

      if (var6 == 1 || var6 == 2) {
         var24 = var24.add(Restrictions.eq("prclocIdCreateur", var7));
      }

      String[] var37;
      if (!var10.equalsIgnoreCase("100")) {
         if (var10.contains(",")) {
            var37 = var10.split(",");
            int var38 = var37.length;
            String[] var34 = new String[var38];

            for(int var35 = 0; var35 < var38; ++var35) {
               var34[var35] = new String(var37[var35]);
            }

            var24 = var24.add(Restrictions.in("prclocSerie", var34));
         } else {
            var24 = var24.add(Restrictions.eq("prclocSerie", var10));
         }
      }

      if (var11 <= 10) {
         var24 = var24.add(Restrictions.eq("prclocEtat", var11));
      }

      if (var13 != null && !var13.isEmpty() && !var13.equalsIgnoreCase("100")) {
         var37 = var13.split(":");
         var33 = var37[0];
         var24 = var24.add(Restrictions.eq("prclocActivite", var33));
      }

      if (var19 != null && !var19.isEmpty()) {
         var24 = var24.add(Restrictions.eq("prclocService", var19));
      }

      var24 = var24.addOrder(Order.desc("prclocDate"));
      var24 = var24.addOrder(Order.desc("prclocNum"));
      List var23 = var24.list();
      if (var21) {
         this.utilInitHibernate.closeSession();
      }

      return var23;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " prclocSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " prclocActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " prclocService='" + var7 + "' and ";
      }

      var11 = var10.createQuery("select prclocEtat,prclocNum,prclocDate,prclocIdReceptionnaire,prclocId from ParcLocationEntete where " + var12 + " prclocCode='" + var2 + "' and prclocDate>='" + var8 + "' and prclocDate<='" + var9 + "'").list();
      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from ParcLocationEntete where prclocCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvts(String var1, String var2, Session var3) {
      List var4 = null;
      String var5 = "";
      if (var2 != null && !var2.isEmpty()) {
         var5 = var5 + " prclocDepot='" + var2 + "' and ";
      }

      var4 = var3.createQuery("from ParcLocationEntete where " + var5 + " prclocCode='" + var1 + "'").list();
      return var4;
   }

   public ParcLocationEntete rechercheConsommation(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc_or");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.parcLocationEntete = new ParcLocationEntete();
      var6 = var3.createQuery("from ParcLocationEntete where prclocId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.parcLocationEntete = (ParcLocationEntete)var6.get(0);
      } else {
         this.parcLocationEntete = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.parcLocationEntete;
   }

   public ParcLocationEntete rechercheConsommation(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc_or");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      this.parcLocationEntete = new ParcLocationEntete();
      var5 = var2.createQuery("from ParcLocationEntete where prclocNum=" + var1).setMaxResults(1).list();
      if (var5.size() != 0) {
         this.parcLocationEntete = (ParcLocationEntete)var5.get(0);
      } else {
         this.parcLocationEntete = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.parcLocationEntete;
   }

   public List rechercheFactureByDate(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc_or");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from ParcLocationEntete where prclocDate>=:deb and prclocDate<=:fin").setString("deb", var1).setString("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc_or");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from ParcLocationEntete where prclocDate>=:deb and prclocDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureByDate(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "Parc_or");
         var5 = true;
      }

      new ArrayList();
      List var7 = null;
      var7 = var4.createQuery("from ParcLocationEntete where parc.prcImmatriculation like '" + var1 + "%' and prclocDate>=:deb and prclocDate<=:fin").setString("deb", var2).setString("fin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
