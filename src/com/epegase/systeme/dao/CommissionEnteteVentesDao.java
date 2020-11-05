package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CommissionEnteteVentes;
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

public class CommissionEnteteVentesDao implements Serializable {
   private CommissionEnteteVentes commissionEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CommissionEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CommissionEnteteVentes insert(CommissionEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CommissionEnteteVentes modif(CommissionEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
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

   public CommissionEnteteVentes modif(CommissionEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(CommissionEnteteVentes var1, Session var2) {
      var2.delete(var1);
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from CommissionEnteteVentes order by comId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            CommissionEnteteVentes var7 = (CommissionEnteteVentes)var6.get(0);
            var4 = 1L + var7.getComId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public CommissionEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from CommissionEnteteVentes where exerciceventes.exevteId=:id and comSerie =:ser and year(comDate)=" + var7 + " order by comDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      CommissionEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (CommissionEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public CommissionEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from CommissionEnteteVentes where exerciceventes.exevteId=:id and comSerie =:ser and year(comDate)=" + var7 + " and month(comDate)=" + var8 + " order by comDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      CommissionEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (CommissionEnteteVentes)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, int var5, String var6, String var7, long var8, int var10, long var11, long var13, String var15, String var16, String var17) throws HibernateException, NamingException, ParseException {
      boolean var18 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var18 = true;
      }

      UtilDate var19 = new UtilDate();
      new ArrayList();
      Criteria var21 = var1.createCriteria(CommissionEnteteVentes.class);
      Calendar var22 = Calendar.getInstance();
      Date var23 = null;
      Date var24 = null;
      Date var25 = new Date();
      String var26 = var19.dateToStringFr(var25);
      String var27 = var26.substring(6, 10) + "-" + var26.substring(3, 5) + "-" + var26.substring(0, 2);
      var23 = var19.stringToDateSQL(var27 + " 00:00:00");
      var24 = var19.stringToDateSQL(var27 + " 23:59:59");
      int var28 = var25.getYear() + 1900;
      String var29;
      String var30;
      if (var6.equalsIgnoreCase("100")) {
         if (var16 != null && var17 != null) {
            var23 = var19.stringToDateSQL(var16 + " 00:00:00");
            var24 = var19.stringToDateSQL(var17 + " 23:59:59");
            var21 = var21.add(Restrictions.between("comDate", var23, var24));
         } else {
            var29 = "1980-01-01";
            var19.stringToDateSQL(var29 + " 00:00:00");
            var21 = var21.add(Restrictions.isNotNull("comDate"));
         }
      } else {
         if (!var6.equalsIgnoreCase("12") && !var6.equalsIgnoreCase("13") && !var6.equalsIgnoreCase("14")) {
            var21 = var21.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var6.equalsIgnoreCase("0")) {
            var21 = var21.add(Restrictions.between("comDate", var23, var24));
         } else if (var6.equalsIgnoreCase("1")) {
            var29 = "" + var22.getTime();
            if (var29.contains("Mon")) {
               var23 = var22.getTime();
            } else if (var29.contains("Tue")) {
               var22.add(7, -1);
               var23 = var22.getTime();
            } else if (var29.contains("Wed")) {
               var22.add(7, -2);
               var23 = var22.getTime();
            } else if (var29.contains("Thu")) {
               var22.add(7, -3);
               var23 = var22.getTime();
            } else if (var29.contains("Fri")) {
               var22.add(7, -4);
               var23 = var22.getTime();
            } else if (var29.contains("Sat")) {
               var22.add(7, -5);
               var23 = var22.getTime();
            } else if (var29.contains("Sun")) {
               var22.add(7, -6);
               var23 = var22.getTime();
            }

            var26 = var19.dateToStringFr(var23);
            var27 = var26.substring(6, 10) + "-" + var26.substring(3, 5) + "-" + var26.substring(0, 2);
            var23 = var19.stringToDateSQL(var27 + " 00:00:00");
            var21 = var21.add(Restrictions.between("comDate", var23, var24));
         } else {
            int var31;
            if (var6.equalsIgnoreCase("2")) {
               var31 = var22.get(2) + 1;
               var30 = var28 + "-" + var31 + "-01";
               var23 = var19.stringToDateSQL(var30 + " 00:00:00");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("3")) {
               var31 = var22.get(2);
               var22.add(5, -var31);
               if (var31 <= 3) {
                  var30 = var28 + "-01-01";
                  var23 = var19.stringToDateSQL(var30 + " 00:00:00");
               } else if (var31 >= 4 && var31 <= 6) {
                  var30 = var28 + "-04-01";
                  var23 = var19.stringToDateSQL(var30 + " 00:00:00");
               } else if (var31 >= 7 && var31 <= 9) {
                  var30 = var28 + "-07-01";
                  var23 = var19.stringToDateSQL(var30 + " 00:00:00");
               } else if (var31 >= 10) {
                  var30 = var28 + "-10-01";
                  var23 = var19.stringToDateSQL(var30 + " 00:00:00");
               }

               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("4")) {
               var31 = var22.get(2);
               var22.add(5, -var31);
               if (var31 <= 6) {
                  var30 = var28 + "-01-01";
                  var23 = var19.stringToDateSQL(var30 + " 00:00:00");
               } else {
                  var30 = var28 + "-07-01";
                  var23 = var19.stringToDateSQL(var30 + " 00:00:00");
               }

               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("5")) {
               var29 = var28 + "-01-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 + "-03-31";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("6")) {
               var29 = var28 + "-04-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 + "-06-30";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("7")) {
               var29 = var28 + "-07-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 + "-09-30";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("8")) {
               var29 = var28 + "-10-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 + "-12-31";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("9")) {
               var29 = var28 + "-01-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 + "-06-30";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("10")) {
               var29 = var28 + "-07-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 + "-12-31";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("11")) {
               var29 = var28 + "-01-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 + "-12-31";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("12")) {
               var29 = "1980-01-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 - 1 + "-12-31";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("13")) {
               var29 = var28 - 1 + "-01-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 + "-12-31";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            } else if (var6.equalsIgnoreCase("14")) {
               var29 = var28 - 1 + "-01-01";
               var23 = var19.stringToDateSQL(var29 + " 00:00:00");
               var30 = var28 - 1 + "-12-31";
               var24 = var19.stringToDateSQL(var30 + " 23:59:59");
               var21 = var21.add(Restrictions.between("comDate", var23, var24));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var29 = "%" + var4 + "%";
         var21 = var21.add(Restrictions.like("comNum", var29));
      }

      if (var11 != 0L) {
         var21 = var21.add(Restrictions.eq("comIdResponsable", var11));
      }

      if (var13 != 0L) {
         var21 = var21.add(Restrictions.eq("comIdCommercial", var13));
      }

      if (var10 == 1 || var10 == 2) {
         var21 = var21.add(Restrictions.eq("comIdCreateur", var8));
      }

      if (var5 <= 10) {
         var21 = var21.add(Restrictions.eq("comEtat", var5));
      } else if (var5 == 12) {
         var21 = var21.add(Restrictions.eq("comTottCommissions", 0));
      } else if (var5 == 13) {
         var21 = var21.add(Restrictions.eq("comSolde", 0));
      } else if (var5 == 14) {
         var21 = var21.add(Restrictions.eq("comSolde", 1));
      } else if (var5 == 17) {
         var21 = var21.add(Restrictions.isNotNull("comDateTransfert"));
      } else if (var5 == 18) {
         var21 = var21.add(Restrictions.isNull("comDateTransfert"));
      }

      if (var7 != null && !var7.isEmpty() && !var7.equalsIgnoreCase("100") && var7.contains(":")) {
         var21 = var21.add(Restrictions.eq("comService", var7));
      }

      if (!var15.equalsIgnoreCase("100")) {
         String[] var32 = var15.split(":");
         var30 = var32[0];
         var21 = var21.add(Restrictions.eq("comActivite", var30));
      }

      var21 = var21.addOrder(Order.desc("comNum"));
      List var33 = var21.list();
      if (var18) {
         this.utilInitHibernate.closeSession();
      }

      return var33;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var4 = true;
      }

      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from CommissionEnteteVentes where comService='" + var1 + "' and (comDateEcheReg='" + var5 + "' or comTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from CommissionEnteteVentes where comDateEcheReg='" + var5 + "' or comTypeReg=4").list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheDejaPayer(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from CommissionEnteteVentes where comTotReglement<>0 and comDate>=:d1 and comDate<=:d2").setDate("d1", var1).setDate("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public CommissionEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CommissionEnteteVentes where comId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new CommissionEnteteVentes();
      CommissionEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (CommissionEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CommissionEnteteVentes pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from CommissionEnteteVentes where comNum =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new CommissionEnteteVentes();
      CommissionEnteteVentes var6;
      if (var5.size() != 0) {
         var6 = (CommissionEnteteVentes)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public CommissionEnteteVentes rechercheUniciteCommercial(long var1, Date var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var6 = true;
      }

      Query var7 = var5.createQuery("from CommissionEnteteVentes where comIdCommercial=:num and comDateDebut>=:d1 and comDateFin<=:d2").setLong("num", var1).setDate("d1", var3).setDate("d2", var4).setMaxResults(1);
      List var8 = var7.list();
      new CommissionEnteteVentes();
      CommissionEnteteVentes var9;
      if (var8.size() != 0) {
         var9 = (CommissionEnteteVentes)var8.get(0);
      } else {
         var9 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List rechercheComtureATransfererCompta(String var1, String var2, String var3, String var4, boolean var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var7 = true;
      }

      new ArrayList();
      List var9 = null;
      if (var5) {
         var9 = var6.createQuery("from CommissionEnteteVentes where (comEtat=0 or comEtat=1 or comEtat=4) and comDateTransfert is NULL").list();
      } else if (var1 != null && !var1.isEmpty() && var2 != null && !var2.isEmpty()) {
         var9 = var6.createQuery("from CommissionEnteteVentes where (comEtat=0 or comEtat=1 or comEtat=4) and comDateTransfert is NULL and comDate>=:dte1 and comDate<=:dte2 and comNum>=:p1 and comNum<=:p2").setString("dte1", var3).setString("dte2", var4).setString("p1", var1).setString("p2", var2).list();
      } else {
         var9 = var6.createQuery("from CommissionEnteteVentes where (comEtat=0 or comEtat=1 or comEtat=4) and comDateTransfert is NULL and comDate>=:dte1 and comDate<=:dte2").setString("dte1", var3).setString("dte2", var4).list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List rechercheComtureDejaTransfererCompta(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from CommissionEnteteVentes where (comEtat=0 or comEtat=1 or comEtat=4) and comDateTransfert is not NULL and comDate>=:dte1 and comDate<=:dte2").setDate("dte1", var1).setDate("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheComtureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CommissionEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
      Query var4 = var3.createQuery("from CommissionEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List rechercheCommissionByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommissionEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from CommissionEnteteVentes where comDate>=:deb and comDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
