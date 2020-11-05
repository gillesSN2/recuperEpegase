package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ParcConsommation;
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

public class ParcConsommationDao implements Serializable {
   private ParcConsommation parcConsommation;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public ParcConsommationDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public ParcConsommation insert(ParcConsommation var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ConsommationParc");
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

   public ParcConsommation insert(ParcConsommation var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ParcConsommation modif(ParcConsommation var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ConsommationParc");
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

   public ParcConsommation modif(ParcConsommation var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public String delete(ParcConsommation var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ConsommationParc");
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

   public List rechercheParcConsommation(long var1, String var3, String var4, String var5, String var6, int var7, String var8, String var9, String var10, String var11, Session var12) throws HibernateException, NamingException, ParseException {
      boolean var13 = false;
      if (var12 == null) {
         var12 = this.utilInitHibernate.getOpenSession(this.maBase, "ConsommationParc");
         var13 = true;
      }

      UtilDate var14 = new UtilDate();
      new ArrayList();
      Criteria var16 = var12.createCriteria(ParcConsommation.class);
      var16 = var16.createAlias("parc", "parc", 1);
      var16 = var16.add(Restrictions.eq("prcconType", var7));
      Calendar var17 = Calendar.getInstance();
      Date var18 = null;
      Date var19 = null;
      Date var20 = new Date();
      String var21 = var14.dateToStringFr(var20);
      String var22 = var21.substring(6, 10) + "-" + var21.substring(3, 5) + "-" + var21.substring(0, 2);
      var18 = var14.stringToDateSQL(var22 + " 00:00:00");
      var19 = var14.stringToDateSQL(var22 + " 23:59:59");
      int var23 = var20.getYear() + 1900;
      String var24;
      int var26;
      if (var11.equalsIgnoreCase("100")) {
         if (var9 != null && var10 != null) {
            var18 = var14.stringToDateSQL(var9 + " 00:00:00");
            var19 = var14.stringToDateSQL(var10 + " 23:59:59");
            var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
         } else {
            var24 = "1980-01-01";
            var14.stringToDateSQL(var24 + " 00:00:00");
            var16 = var16.add(Restrictions.isNotNull("prcconDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
         }

         if (var11.equalsIgnoreCase("0")) {
            var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
         } else if (var11.equalsIgnoreCase("1")) {
            var24 = "" + var17.getTime();
            if (var24.contains("Mon")) {
               var18 = var17.getTime();
            } else if (var24.contains("Tue")) {
               var17.add(7, -1);
               var18 = var17.getTime();
            } else if (var24.contains("Wed")) {
               var17.add(7, -2);
               var18 = var17.getTime();
            } else if (var24.contains("Thu")) {
               var17.add(7, -3);
               var18 = var17.getTime();
            } else if (var24.contains("Fri")) {
               var17.add(7, -4);
               var18 = var17.getTime();
            } else if (var24.contains("Sat")) {
               var17.add(7, -5);
               var18 = var17.getTime();
            } else if (var24.contains("Sun")) {
               var17.add(7, -6);
               var18 = var17.getTime();
            }

            var21 = var14.dateToStringFr(var18);
            var22 = var21.substring(6, 10) + "-" + var21.substring(3, 5) + "-" + var21.substring(0, 2);
            var18 = var14.stringToDateSQL(var22 + " 00:00:00");
            var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
         } else {
            String var25;
            if (var11.equalsIgnoreCase("2")) {
               var26 = var17.get(2) + 1;
               var25 = var23 + "-" + var26 + "-01";
               var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("3")) {
               var26 = var17.get(2);
               var17.add(5, -var26);
               if (var26 <= 3) {
                  var25 = var23 + "-01-01";
                  var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               } else if (var26 >= 4 && var26 <= 6) {
                  var25 = var23 + "-04-01";
                  var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               } else if (var26 >= 7 && var26 <= 9) {
                  var25 = var23 + "-07-01";
                  var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               } else if (var26 >= 10) {
                  var25 = var23 + "-10-01";
                  var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               }

               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("4")) {
               var26 = var17.get(2);
               var17.add(5, -var26);
               if (var26 <= 6) {
                  var25 = var23 + "-01-01";
                  var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               } else {
                  var25 = var23 + "-07-01";
                  var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               }

               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("5")) {
               var24 = var23 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-03-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("6")) {
               var24 = var23 + "-04-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-06-30";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("7")) {
               var24 = var23 + "-07-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-09-30";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("8")) {
               var24 = var23 + "-10-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("9")) {
               var24 = var23 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-06-30";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("10")) {
               var24 = var23 + "-07-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("11")) {
               var24 = var23 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("12")) {
               var24 = "1980-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 - 1 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("13")) {
               var24 = var23 - 1 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("14")) {
               var24 = var23 - 1 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 - 1 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("prcconDate", var18, var19));
            } else if (var11.equalsIgnoreCase("20")) {
               var16.setMaxResults(20);
               var16 = var16.addOrder(Order.desc("prcconId"));
            }
         }
      }

      if (var3 != null && !var3.isEmpty()) {
         var24 = "%" + var3 + "%";
         var16 = var16.add(Restrictions.like("parc.prcImmatriculation", var24));
      }

      String[] var27;
      if (var4 != null && !var4.isEmpty() && var4.contains(":")) {
         var27 = var4.split(":");
         int var28 = Integer.parseInt(var27[0]);
         var16 = var16.add(Restrictions.like("parc.prcNature", var28));
      }

      if (var5 != null && !var5.isEmpty() && var5.contains(":")) {
         var27 = var5.split(":");
         var16 = var16.add(Restrictions.like("parc.prcFamille", var27[0]));
      }

      if (var6 != null && !var6.isEmpty() && !var6.equals("100")) {
         var26 = Integer.parseInt(var6);
         var16 = var16.add(Restrictions.like("parc.prcOrigine", var26));
      }

      if (var8 != null && !var8.isEmpty() && var8.contains(":")) {
         var27 = var8.split(":");
         var16 = var16.add(Restrictions.like("prcconService", var27[0]));
      }

      List var15 = var16.list();
      if (var13) {
         this.utilInitHibernate.closeSession();
      }

      return var15;
   }

   public List chargerLesMvts(String var1, String var2, String var3, long var4, String var6, String var7, String var8, String var9, Session var10) {
      List var11 = null;
      String var12 = "";
      if (var1 != null && !var1.isEmpty()) {
         var12 = var12 + " prcconSerie='" + var1 + "' and ";
      }

      if (var6 != null && !var6.isEmpty()) {
         var12 = var12 + " prcconActivite='" + var6 + "' and ";
      }

      if (var7 != null && !var7.isEmpty()) {
         var12 = var12 + " prcconService='" + var7 + "' and ";
      }

      if (var3 != null && !var3.isEmpty()) {
         var12 = var12 + " prcconDepot='" + var3 + "' and ";
      }

      if (var2 != null && !var2.isEmpty()) {
         if (var2.startsWith("(")) {
            var11 = var10.createQuery("select prcconEtat,prcconNum,prcconDate,prcconIdDemandeur,prcconId,prcconDepot,prcconCode,prcconCode,prcconLibelle,prcconQte,prcconQte,prcconPu,prcconTotal,prcconPoidsBrut,prcconNomPompiste,prcconNomDemandeur,prcconType from ParcConsommation where " + var12 + " prcconCode in " + var2 + " and prcconDate>='" + var8 + "' and prcconDate<='" + var9 + "'").list();
         } else {
            var11 = var10.createQuery("select prcconEtat,prcconNum,prcconDate,prcconIdDemandeur,prcconId,prcconDepot,prcconCode,prcconCode,prcconLibelle,prcconQte,prcconQte,prcconPu,prcconTotal,prcconPoidsBrut,prcconNomPompiste,prcconNomDemandeur,prcconType from ParcConsommation where " + var12 + " prcconCode='" + var2 + "' and prcconDate>='" + var8 + "' and prcconDate<='" + var9 + "'").list();
         }
      } else {
         var11 = var10.createQuery("select prcconEtat,prcconNum,prcconDate,prcconIdDemandeur,prcconId,prcconDepot,prcconCode,prcconCode,prcconLibelle,prcconQte,prcconQte,prcconPu,prcconTotal,prcconPoidsBrut,prcconNomPompiste,prcconNomDemandeur,prcconType from ParcConsommation where " + var12 + " prcconDate>='" + var8 + "' and prcconDate<='" + var9 + "'").list();
      }

      return var11;
   }

   public List chargerLesMvts(String var1, Session var2) {
      List var3 = null;
      var3 = var2.createQuery("from ParcConsommation where prcconCode='" + var1 + "'").list();
      return var3;
   }

   public List chargerLesMvts(String var1, String var2, Session var3) {
      List var4 = null;
      String var5 = "";
      if (var2 != null && !var2.isEmpty()) {
         var5 = var5 + " prcconDepot='" + var2 + "' and ";
      }

      var4 = var3.createQuery("from ParcConsommation where " + var5 + " prcconCode='" + var1 + "'").list();
      return var4;
   }

   public ParcConsommation rechercheConsommation(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ConsommationParc");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      this.parcConsommation = new ParcConsommation();
      var6 = var3.createQuery("from ParcConsommation where prcconId=" + var1).setMaxResults(1).list();
      if (var6.size() != 0) {
         this.parcConsommation = (ParcConsommation)var6.get(0);
      } else {
         this.parcConsommation = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.parcConsommation;
   }

   public ParcConsommation rechercheConsommation(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "ConsommationParc");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      this.parcConsommation = new ParcConsommation();
      var5 = var2.createQuery("from ParcConsommation where prcconNum='" + var1 + "'").setMaxResults(1).list();
      if (var5.size() != 0) {
         this.parcConsommation = (ParcConsommation)var5.get(0);
      } else {
         this.parcConsommation = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.parcConsommation;
   }

   public List rechercheConsommationByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "ConsommationParc");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from ParcConsommation where prcconDate>=:deb and prcconDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
