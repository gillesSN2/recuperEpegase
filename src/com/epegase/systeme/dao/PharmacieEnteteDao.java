package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Patients;
import com.epegase.systeme.classe.PharmacieEntete;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class PharmacieEnteteDao implements Serializable {
   private PharmacieEntete pharmacieEntete;
   private String maBase;
   private UtilInitHibernate utilInitHibernate;

   public PharmacieEnteteDao(String var1, UtilInitHibernate var2) {
      this.maBase = var1;
      this.utilInitHibernate = var2;
   }

   public PharmacieEntete insert(PharmacieEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
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

   public PharmacieEntete insert(PharmacieEntete var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public PharmacieEntete modif(PharmacieEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
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

   public PharmacieEntete modif(PharmacieEntete var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(PharmacieEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
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

   public void delete(PharmacieEntete var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from PharmacieEntete order by labId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            PharmacieEntete var7 = (PharmacieEntete)var6.get(0);
            var4 = 1L + var7.getPhaId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public PharmacieEntete pharmacieEnteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from PharmacieEntete where ExercicesVentes.exevteId=:id and phaSerie =:ser and year(phaDate)=" + var7 + " order by phaDate desc").setLong("id", var1).setString("ser", var3);
      PharmacieEntete var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (PharmacieEntete)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public PharmacieEntete pharmacieEnteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from PharmacieEntete where ExercicesVentes.exevteId=:id and phaSerie =:ser and year(phaDate)=" + var7 + " and month(phaDate)=" + var8 + " order by phaDate desc").setLong("id", var1).setString("ser", var3);
      PharmacieEntete var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (PharmacieEntete)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherchePharmacie(Session var1, long var2, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, int var14, String var15, String var16, String var17, String var18, long var19, int var21, String var22, String var23, String var24, String var25, String var26) throws HibernateException, NamingException, ParseException {
      boolean var27 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var27 = true;
      }

      UtilDate var28 = new UtilDate();
      new ArrayList();
      Criteria var30 = var1.createCriteria(PharmacieEntete.class);
      var30 = var30.createAlias("Patients", "pat", 1);
      Calendar var31 = Calendar.getInstance();
      Date var32 = null;
      Date var33 = null;
      Date var34 = new Date();
      String var35 = var28.dateToStringFr(var34);
      String var36 = var35.substring(6, 10) + "-" + var35.substring(3, 5) + "-" + var35.substring(0, 2);
      var32 = var28.stringToDateSQL(var36 + " 00:00:00");
      var33 = var28.stringToDateSQL(var36 + " 23:59:59");
      int var37 = var34.getYear() + 1900;
      String var38;
      String var39;
      if (var17.equalsIgnoreCase("100")) {
         if (var25 != null && var26 != null) {
            var32 = var28.stringToDateSQL(var25 + " 00:00:00");
            var33 = var28.stringToDateSQL(var26 + " 23:59:59");
            var30 = var30.add(Restrictions.between("phaDate", var32, var33));
         } else {
            var38 = "1980-01-01";
            var28.stringToDateSQL(var38 + " 00:00:00");
            var30 = var30.add(Restrictions.isNotNull("phaDate"));
         }
      } else {
         if (!var17.equalsIgnoreCase("12") && !var17.equalsIgnoreCase("13") && !var17.equalsIgnoreCase("14")) {
            var30 = var30.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var17.equalsIgnoreCase("0")) {
            var30 = var30.add(Restrictions.between("phaDate", var32, var33));
         } else if (var17.equalsIgnoreCase("1")) {
            var38 = "" + var31.getTime();
            if (var38.contains("Mon")) {
               var32 = var31.getTime();
            } else if (var38.contains("Tue")) {
               var31.add(7, -1);
               var32 = var31.getTime();
            } else if (var38.contains("Wed")) {
               var31.add(7, -2);
               var32 = var31.getTime();
            } else if (var38.contains("Thu")) {
               var31.add(7, -3);
               var32 = var31.getTime();
            } else if (var38.contains("Fri")) {
               var31.add(7, -4);
               var32 = var31.getTime();
            } else if (var38.contains("Sat")) {
               var31.add(7, -5);
               var32 = var31.getTime();
            } else if (var38.contains("Sun")) {
               var31.add(7, -6);
               var32 = var31.getTime();
            }

            var35 = var28.dateToStringFr(var32);
            var36 = var35.substring(6, 10) + "-" + var35.substring(3, 5) + "-" + var35.substring(0, 2);
            var32 = var28.stringToDateSQL(var36 + " 00:00:00");
            var30 = var30.add(Restrictions.between("phaDate", var32, var33));
         } else {
            int var42;
            if (var17.equalsIgnoreCase("2")) {
               var42 = var31.get(2) + 1;
               var39 = var37 + "-" + var42 + "-01";
               var32 = var28.stringToDateSQL(var39 + " 00:00:00");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("3")) {
               var42 = var31.get(2);
               var31.add(5, -var42);
               if (var42 <= 3) {
                  var39 = var37 + "-01-01";
                  var32 = var28.stringToDateSQL(var39 + " 00:00:00");
               } else if (var42 >= 4 && var42 <= 6) {
                  var39 = var37 + "-04-01";
                  var32 = var28.stringToDateSQL(var39 + " 00:00:00");
               } else if (var42 >= 7 && var42 <= 9) {
                  var39 = var37 + "-07-01";
                  var32 = var28.stringToDateSQL(var39 + " 00:00:00");
               } else if (var42 >= 10) {
                  var39 = var37 + "-10-01";
                  var32 = var28.stringToDateSQL(var39 + " 00:00:00");
               }

               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("4")) {
               var42 = var31.get(2);
               var31.add(5, -var42);
               if (var42 <= 6) {
                  var39 = var37 + "-01-01";
                  var32 = var28.stringToDateSQL(var39 + " 00:00:00");
               } else {
                  var39 = var37 + "-07-01";
                  var32 = var28.stringToDateSQL(var39 + " 00:00:00");
               }

               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("5")) {
               var38 = var37 + "-01-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-03-31";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("6")) {
               var38 = var37 + "-04-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-06-30";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("7")) {
               var38 = var37 + "-07-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-09-30";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("8")) {
               var38 = var37 + "-10-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-12-31";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("9")) {
               var38 = var37 + "-01-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-06-30";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("10")) {
               var38 = var37 + "-07-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-12-31";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("11")) {
               var38 = var37 + "-01-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-12-31";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("12")) {
               var38 = "1980-01-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 - 1 + "-12-31";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("13")) {
               var38 = var37 - 1 + "-01-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-12-31";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("14")) {
               var38 = var37 - 1 + "-01-01";
               var32 = var28.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 - 1 + "-12-31";
               var33 = var28.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("phaDate", var32, var33));
            } else if (var17.equalsIgnoreCase("20")) {
               var30.setMaxResults(20);
               var30 = var30.addOrder(Order.desc("phaId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var38 = "%" + var4 + "%";
         var30 = var30.add(Restrictions.like("phaNum", var38));
      }

      if (var5 != null && !var5.isEmpty()) {
         var38 = "%" + var5 + "%";
         var30 = var30.add(Restrictions.like("pat.patNom", var38));
      }

      if (var6 != null && !var6.isEmpty()) {
         var38 = "%" + var6 + "%";
         var30 = var30.add(Restrictions.like("pat.patPrenom", var38));
      }

      if (var7 != null && !var7.isEmpty()) {
         var38 = "%" + var7 + "%";
         var30 = var30.add(Restrictions.or(Restrictions.like("pat.patTelDom", var38), Restrictions.like("pat.patCel1", var38)));
      }

      if (var8 != null && !var8.isEmpty()) {
         var38 = "%" + var8 + "%";
         var30 = var30.add(Restrictions.like("pat.patCi", var38));
      }

      if (var9 != null && !var9.isEmpty()) {
         var38 = "%" + var9 + "%";
         var30 = var30.add(Restrictions.like("pat.patDossier", var38));
      }

      if (var10 != null && !var10.isEmpty()) {
         var38 = "%" + var10 + "%";
         var30 = var30.add(Restrictions.like("phaNomSociete", var38));
      }

      if (var11 != null && !var11.isEmpty()) {
         var38 = "%" + var11 + "%";
         var30 = var30.add(Restrictions.like("phaNomAssurance", var38));
      }

      if (var12 != null && !var12.isEmpty()) {
         var38 = "%" + var12 + "%";
         var30 = var30.add(Restrictions.like("phaNomComplementaire", var38));
      }

      if (var13 != null && !var13.isEmpty()) {
         var38 = "%" + var13 + "%";
         var30 = var30.add(Restrictions.like("phaContratAssurance", var38));
      }

      if (var22 != null && !var22.isEmpty()) {
         var30 = var30.add(Restrictions.eq("phaProtocole", var22));
      }

      if (var23 != null && !var23.isEmpty()) {
         var30 = var30.add(Restrictions.eq("phaMedecin", var23));
      }

      if (var21 == 1) {
         var30 = var30.add(Restrictions.eq("phaIdCreateur", var19));
      }

      String[] var44;
      if (!var15.equalsIgnoreCase("100")) {
         if (var15.contains(",")) {
            var44 = var15.split(",");
            int var43 = var44.length;
            String[] var40 = new String[var43];

            for(int var41 = 0; var41 < var43; ++var41) {
               var40[var41] = new String(var44[var41]);
            }

            var30 = var30.add(Restrictions.in("phaSerie", var40));
         } else {
            var30 = var30.add(Restrictions.eq("phaSerie", var15));
         }
      }

      if (!var16.equalsIgnoreCase("100")) {
         if (var16.equals("0")) {
            var30 = var30.add(Restrictions.eq("phaIdSociete", 0L));
            var30 = var30.add(Restrictions.eq("phaIdAssurance", 0L));
            var30 = var30.add(Restrictions.eq("phaPecCnamgs", 0.0F));
            var30 = var30.add(Restrictions.eq("phaFam", 0L));
         } else if (var16.equals("-1")) {
            var30 = var30.add(Restrictions.eq("phaFam", -1L));
         } else if (var16.equals("-2")) {
            var30 = var30.add(Restrictions.ne("phaIdSociete", 0L));
         } else if (var16.equals("-4")) {
            var30 = var30.add(Restrictions.ne("phaPecCnamgs", 0.0F));
         } else {
            var30 = var30.add(Restrictions.ne("phaIdAssurance", 0L));
         }
      }

      if (var14 <= 10) {
         var30 = var30.add(Restrictions.eq("phaEtat", var14));
      } else if (var14 == 13) {
         var30 = var30.add(Restrictions.eq("phaSoldePatient", 0));
         var30 = var30.add(Restrictions.ne("phaTotPatient", 0.0D));
      } else if (var14 == 14) {
         var30 = var30.add(Restrictions.eq("phaSoldePatient", 1));
      } else if (var14 == 15) {
         var30 = var30.add(Restrictions.eq("phaSoldeTiers", 0));
      } else if (var14 == 16) {
         var30 = var30.add(Restrictions.eq("phaSoldeTiers", 1));
      } else if (var14 == 17) {
         var30 = var30.add(Restrictions.isNotNull("phaDateTransfert"));
      } else if (var14 == 18) {
         var30 = var30.add(Restrictions.isNull("phaDateTransfert"));
      } else if (var14 == 19) {
         var30 = var30.add(Restrictions.or(Restrictions.eq("phaEtat", 1), Restrictions.eq("phaEtat", 5)));
      } else if (var14 == 20) {
         var30 = var30.add(Restrictions.or(Restrictions.or(Restrictions.eq("phaEtat", 1), Restrictions.eq("phaEtat", 5)), Restrictions.or(Restrictions.eq("phaEtat", 6), Restrictions.eq("phaEtat", 7))));
      }

      if (var18 != null && !var18.isEmpty() && !var18.equalsIgnoreCase("100") && var18.contains(":")) {
         var30 = var30.add(Restrictions.eq("phaService", var18));
      }

      if (!var24.equalsIgnoreCase("100")) {
         var44 = var24.split(":");
         var39 = var44[0];
         var30 = var30.add(Restrictions.eq("phaActivite", var39));
      }

      var30 = var30.addOrder(Order.desc("phaDate"));
      var30 = var30.addOrder(Order.desc("phaNum"));
      List var45 = var30.list();
      if (var27) {
         this.utilInitHibernate.closeSession();
      }

      return var45;
   }

   public PharmacieEntete selectById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PharmacieEntete where phaId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new PharmacieEntete();
      PharmacieEntete var7;
      if (var6.size() != 0) {
         var7 = (PharmacieEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public PharmacieEntete selectByFeuille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from PharmacieEntete where phaFeuille =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new PharmacieEntete();
      PharmacieEntete var6;
      if (var5.size() != 0) {
         var6 = (PharmacieEntete)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public PharmacieEntete selectByPatient(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from PharmacieEntete where phaIdPatient =:id").setLong("id", var1);
      List var6 = var5.list();
      new PharmacieEntete();
      PharmacieEntete var7;
      if (var6.size() != 0) {
         var7 = (PharmacieEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public PharmacieEntete selectByNum(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from PharmacieEntete where phaNum=:num and phaSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var5 = var3.createQuery("from PharmacieEntete where phaNum=:num").setString("num", var1).setMaxResults(1);
      }

      List var6 = var5.list();
      new PharmacieEntete();
      PharmacieEntete var7;
      if (var6.size() != 0) {
         var7 = (PharmacieEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List recherchePharmaciePeriode(String var1, String var2, long var3, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var7 = true;
      }

      new ArrayList();
      List var9 = null;
      if (var5 != null && !var5.isEmpty()) {
         if (var3 != 0L) {
            var9 = var6.createQuery("from PharmacieEntete where (phaDate>=:dte1 and phaDate<=:dte2) and (phaIdSociete=:id or phaIdAssurance=:id or phaIdComplementaire=:id) and phaNumBc=:bc").setString("dte1", var1).setString("dte2", var2).setLong("id", var3).setString("bc", var5).list();
         } else {
            var9 = var6.createQuery("from PharmacieEntete where (phaDate>=:dte1 and phaDate<=:dte2) and phaNumBc=:bc").setString("dte1", var1).setString("dte2", var2).setString("bc", var5).list();
         }
      } else if (var3 != 0L) {
         var9 = var6.createQuery("from PharmacieEntete where (phaDate>=:dte1 and phaDate<=:dte2) and (phaIdSociete=:id or phaIdAssurance=:id or phaIdComplementaire=:id)").setString("dte1", var1).setString("dte2", var2).setLong("id", var3).list();
      } else {
         var9 = var6.createQuery("from PharmacieEntete where (phaDate>=:dte1 and phaDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List recherchePharmacieCnamgsPeriode(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var5 = true;
      }

      new ArrayList();
      List var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         var7 = var4.createQuery("from PharmacieEntete where (phaDate>=:dte1 and phaDate<=:dte2) and (phaFondCnamgs<>0 and phaPecCnamgs<>0) and phaNumBc=:bc").setString("dte1", var1).setString("dte2", var2).setString("bc", var3).list();
      } else {
         var7 = var4.createQuery("from PharmacieEntete where (phaDate>=:dte1 and phaDate<=:dte2) and (phaFondCnamgs<>0 and phaPecCnamgs<>0)").setString("dte1", var1).setString("dte2", var2).list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List recherchePharmacieATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var6) {
         var10 = var7.createQuery("from PharmacieEntete where (phaEtat=1 or phaEtat=4 or phaEtat=5 or phaEtat=6) and phaDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from PharmacieEntete where (phaEtat=1  or phaEtat=4 or phaEtat=5 or phaEtat=6) and phaDateTransfert is NULL and phaDate>=:dte1 and phaDate<=:dte2 and phaNum>=:p1 and phaNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from PharmacieEntete where (phaEtat=1  or phaEtat=4 or phaEtat=5 or phaEtat=6) and phaDateTransfert is NULL and phaDate>=:dte1 and phaDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherchePharmacieDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from PharmacieEntete where (phaEtat=1 or phaEtat=4  or phaEtat=5 or phaEtat=6) and (phaDateTransfert<>'' and phaDateTransfert is not null) and (phaDate>=:dte1 and phaDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsPatients(Patients var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from PharmacieEntete where Patients.patId=" + var1.getPatId() + " and phaDate>='" + var2 + "' and phaDate<='" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsPatients(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from PharmacieEntete where Patients.patId=" + var1.getPatId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifPharmPatients(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from PharmacieEntete where Patients.patId=" + var1.getPatId() + ")").list();
      boolean var5 = false;
      if (var4.size() != 0) {
         var5 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerPharmacieByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.maBase, "PharmacieEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from PharmacieEntete where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
