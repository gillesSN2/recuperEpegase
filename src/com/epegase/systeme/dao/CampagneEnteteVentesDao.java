package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CampagneEnteteVentes;
import com.epegase.systeme.classe.ExercicesVentes;
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

public class CampagneEnteteVentesDao implements Serializable {
   private CampagneEnteteVentes campagneEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CampagneEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CampagneEnteteVentes insert(CampagneEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CampagneEnteteVentes modif(CampagneEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
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

   public CampagneEnteteVentes modif(CampagneEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(CampagneEnteteVentes var1, Session var2) {
      var2.delete(var1);
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from CampagneEnteteVentes order by camId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            CampagneEnteteVentes var7 = (CampagneEnteteVentes)var6.get(0);
            var4 = 1L + var7.getCamId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public CampagneEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from CampagneEnteteVentes where exerciceventes.exevteId=:id and camSerie =:ser and year(camDate)=" + var7 + " order by camDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      CampagneEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (CampagneEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public CampagneEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from CampagneEnteteVentes where exerciceventes.exevteId=:id and camSerie =:ser and year(camDate)=" + var7 + " and month(camDate)=" + var8 + " order by camDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      CampagneEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (CampagneEnteteVentes)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, int var5, String var6, String var7, long var8, int var10, String var11, String var12, String var13, String var14, String var15) throws HibernateException, NamingException, ParseException {
      boolean var16 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
         var16 = true;
      }

      UtilDate var17 = new UtilDate();
      new ArrayList();
      Criteria var19 = var1.createCriteria(CampagneEnteteVentes.class);
      Calendar var20 = Calendar.getInstance();
      Date var21 = null;
      Date var22 = null;
      Date var23 = new Date();
      String var24 = var17.dateToStringFr(var23);
      String var25 = var24.substring(6, 10) + "-" + var24.substring(3, 5) + "-" + var24.substring(0, 2);
      var21 = var17.stringToDateSQL(var25 + " 00:00:00");
      var22 = var17.stringToDateSQL(var25 + " 23:59:59");
      int var26 = var23.getYear() + 1900;
      if (var6 == null || var6.isEmpty()) {
         var6 = "100";
      }

      String var27;
      String var28;
      if (var6.equalsIgnoreCase("100")) {
         if (var14 != null && var15 != null) {
            var21 = var17.stringToDateSQL(var14 + " 00:00:00");
            var22 = var17.stringToDateSQL(var15 + " 23:59:59");
            var19 = var19.add(Restrictions.between("camDate", var21, var22));
         } else {
            var27 = "1980-01-01";
            var17.stringToDateSQL(var27 + " 00:00:00");
            var19 = var19.add(Restrictions.isNotNull("camDate"));
         }
      } else {
         if (!var6.equalsIgnoreCase("12") && !var6.equalsIgnoreCase("13") && !var6.equalsIgnoreCase("14")) {
            var19 = var19.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var6.equalsIgnoreCase("0")) {
            var19 = var19.add(Restrictions.between("camDate", var21, var22));
         } else if (var6.equalsIgnoreCase("1")) {
            var27 = "" + var20.getTime();
            if (var27.contains("Mon")) {
               var21 = var20.getTime();
            } else if (var27.contains("Tue")) {
               var20.add(7, -1);
               var21 = var20.getTime();
            } else if (var27.contains("Wed")) {
               var20.add(7, -2);
               var21 = var20.getTime();
            } else if (var27.contains("Thu")) {
               var20.add(7, -3);
               var21 = var20.getTime();
            } else if (var27.contains("Fri")) {
               var20.add(7, -4);
               var21 = var20.getTime();
            } else if (var27.contains("Sat")) {
               var20.add(7, -5);
               var21 = var20.getTime();
            } else if (var27.contains("Sun")) {
               var20.add(7, -6);
               var21 = var20.getTime();
            }

            var24 = var17.dateToStringFr(var21);
            var25 = var24.substring(6, 10) + "-" + var24.substring(3, 5) + "-" + var24.substring(0, 2);
            var21 = var17.stringToDateSQL(var25 + " 00:00:00");
            var19 = var19.add(Restrictions.between("camDate", var21, var22));
         } else {
            int var29;
            if (var6.equalsIgnoreCase("2")) {
               var29 = var20.get(2) + 1;
               var28 = var26 + "-" + var29 + "-01";
               var21 = var17.stringToDateSQL(var28 + " 00:00:00");
               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("3")) {
               var29 = var20.get(2);
               var20.add(5, -var29);
               if (var29 <= 3) {
                  var28 = var26 + "-01-01";
                  var21 = var17.stringToDateSQL(var28 + " 00:00:00");
               } else if (var29 >= 4 && var29 <= 6) {
                  var28 = var26 + "-04-01";
                  var21 = var17.stringToDateSQL(var28 + " 00:00:00");
               } else if (var29 >= 7 && var29 <= 9) {
                  var28 = var26 + "-07-01";
                  var21 = var17.stringToDateSQL(var28 + " 00:00:00");
               } else if (var29 >= 10) {
                  var28 = var26 + "-10-01";
                  var21 = var17.stringToDateSQL(var28 + " 00:00:00");
               }

               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("4")) {
               var29 = var20.get(2);
               var20.add(5, -var29);
               if (var29 <= 6) {
                  var28 = var26 + "-01-01";
                  var21 = var17.stringToDateSQL(var28 + " 00:00:00");
               } else {
                  var28 = var26 + "-07-01";
                  var21 = var17.stringToDateSQL(var28 + " 00:00:00");
               }

               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("5")) {
               var27 = var26 + "-01-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 + "-03-31";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("6")) {
               var27 = var26 + "-04-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 + "-06-30";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("7")) {
               var27 = var26 + "-07-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 + "-09-30";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("8")) {
               var27 = var26 + "-10-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 + "-12-31";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("9")) {
               var27 = var26 + "-01-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 + "-06-30";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("10")) {
               var27 = var26 + "-07-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 + "-12-31";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("11")) {
               var27 = var26 + "-01-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 + "-12-31";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("12")) {
               var27 = "1980-01-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 - 1 + "-12-31";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("camDate", var21, var22));
            } else if (var6.equalsIgnoreCase("13")) {
               var27 = var26 - 1 + "-01-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 + "-12-31";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("canDate", var21, var22));
            } else if (var6.equalsIgnoreCase("14")) {
               var27 = var26 - 1 + "-01-01";
               var21 = var17.stringToDateSQL(var27 + " 00:00:00");
               var28 = var26 - 1 + "-12-31";
               var22 = var17.stringToDateSQL(var28 + " 23:59:59");
               var19 = var19.add(Restrictions.between("canDate", var21, var22));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var27 = "%" + var4 + "%";
         var19 = var19.add(Restrictions.like("camNum", var27));
      }

      if (var11 != null && !var11.isEmpty()) {
         var19 = var19.add(Restrictions.eq("camNomResponsable", var11));
      }

      if (var12 != null && !var12.isEmpty()) {
         var19 = var19.add(Restrictions.eq("camNomCommercial", var12));
      }

      if (var10 == 1 || var10 == 2) {
         var19 = var19.add(Restrictions.eq("camIdCreateur", var8));
      }

      if (var5 <= 10) {
         var19 = var19.add(Restrictions.eq("camEtat", var5));
      }

      if (var7 != null && !var7.isEmpty() && !var7.equalsIgnoreCase("100") && var7.contains(":")) {
         var19 = var19.add(Restrictions.eq("camService", var7));
      }

      if (!var13.equalsIgnoreCase("100")) {
         String[] var30 = var13.split(":");
         var28 = var30[0];
         var19 = var19.add(Restrictions.eq("camActivite", var28));
      }

      var19 = var19.addOrder(Order.desc("camNum"));
      List var31 = var19.list();
      if (var16) {
         this.utilInitHibernate.closeSession();
      }

      return var31;
   }

   public CampagneEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CampagneEnteteVentes where camId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new CampagneEnteteVentes();
      CampagneEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (CampagneEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CampagneEnteteVentes pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CampagneEnteteVentes where camNum=:num and camSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new CampagneEnteteVentes();
      CampagneEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (CampagneEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheCampagneRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CampagneEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCampagneActive(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
         var2 = true;
      }

      new ArrayList();
      List var4 = null;
      var4 = var1.createQuery("from CampagneEnteteVentes where camEtat=1").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
      Query var4 = var3.createQuery("from CampagneEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List rechercheCampagneByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CampagneEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from CampagneEnteteVentes where camDateDebut>=:deb and camDateDebut<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
