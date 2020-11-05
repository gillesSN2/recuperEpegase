package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class ValorisationEnteteAchatsDao implements Serializable {
   private ValorisationEnteteAchats retourEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ValorisationEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ValorisationEnteteAchats insert(ValorisationEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
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

   public ValorisationEnteteAchats insert(ValorisationEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ValorisationEnteteAchats modif(ValorisationEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from ValorisationEnteteAchats where valId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ValorisationEnteteAchats order by valId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            ValorisationEnteteAchats var7 = (ValorisationEnteteAchats)var6.get(0);
            var4 = 1L + var7.getValId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ValorisationEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from ValorisationEnteteAchats where exercicesAchats.exeachId=:id and year(valDate)=" + var7 + " order by valDate desc");
      var8.setParameter("id", var1);
      ValorisationEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (ValorisationEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public ValorisationEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from ValorisationEnteteAchats where exercicesAchats.exeachId=:id and year(valDate)=" + var7 + " and month(valDate)=" + var8 + " order by valDate desc");
      var9.setParameter("id", var1);
      ValorisationEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (ValorisationEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheValoATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from ValorisationEnteteAchats where (valEtat=0 or valEtat=1 or valEtat=4) and valDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from ValorisationEnteteAchats where (valEtat=0 or valEtat=1 or valEtat=4) and valDateTransfert is NULL and valDate>=:dte1 and valDate<=:dte2 and valNum>=:p1 and valNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from ValorisationEnteteAchats where (valEtat=0 or valEtat=1 or valEtat=4) and valDateTransfert is NULL and valDate>=:dte1 and valDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from ValorisationEnteteAchats where (valEtat=1 or valEtat=4) and fsfDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from ValorisationEnteteAchats where (valEtat=1 or valEtat=4) and valDateTransfert is NULL and valDate>=:dte1 and valDate<=:dte2 and valNum>=:p1 and valNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from ValorisationEnteteAchats where (valEtat=1 or valEtat=4) and valDateTransfert is NULL and valDate>=:dte1 and valDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheValoDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from ValorisationEnteteAchats where (valEtat=0 or valEtat=1 or valEtat=4) and (valDateTransfert <> '' and valDateTransfert is not NULL) and (valDate>=:dte1 and valDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List recherche(Session var1, long var2, String var4, int var5, String var6, long var7, int var9, String var10, String var11, String var12) throws HibernateException, NamingException, ParseException {
      boolean var13 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var13 = true;
      }

      UtilDate var14 = new UtilDate();
      new ArrayList();
      Criteria var16 = var1.createCriteria(ValorisationEnteteAchats.class);
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
      if (var6.equalsIgnoreCase("100")) {
         if (var11 != null && var12 != null) {
            var18 = var14.stringToDateSQL(var11 + " 00:00:00");
            var19 = var14.stringToDateSQL(var12 + " 23:59:59");
            var16 = var16.add(Restrictions.between("valDate", var18, var19));
         } else {
            var24 = "1980-01-01";
            var14.stringToDateSQL(var24 + " 00:00:00");
            var16 = var16.add(Restrictions.isNotNull("valDate"));
         }
      } else {
         if (!var6.equalsIgnoreCase("12") && !var6.equalsIgnoreCase("13") && !var6.equalsIgnoreCase("14")) {
            var16 = var16.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var6.equalsIgnoreCase("0")) {
            var16 = var16.add(Restrictions.between("valDate", var18, var19));
         } else if (var6.equalsIgnoreCase("1")) {
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
            var16 = var16.add(Restrictions.between("valDate", var18, var19));
         } else {
            String var25;
            int var26;
            if (var6.equalsIgnoreCase("2")) {
               var26 = var17.get(2) + 1;
               var25 = var23 + "-" + var26 + "-01";
               var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("3")) {
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

               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("4")) {
               var26 = var17.get(2);
               var17.add(5, -var26);
               if (var26 <= 6) {
                  var25 = var23 + "-01-01";
                  var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               } else {
                  var25 = var23 + "-07-01";
                  var18 = var14.stringToDateSQL(var25 + " 00:00:00");
               }

               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("5")) {
               var24 = var23 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-03-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("6")) {
               var24 = var23 + "-04-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-06-30";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("7")) {
               var24 = var23 + "-07-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-09-30";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("8")) {
               var24 = var23 + "-10-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("9")) {
               var24 = var23 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-06-30";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("10")) {
               var24 = var23 + "-07-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("11")) {
               var24 = var23 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("12")) {
               var24 = "1980-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 - 1 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("13")) {
               var24 = var23 - 1 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("14")) {
               var24 = var23 - 1 + "-01-01";
               var18 = var14.stringToDateSQL(var24 + " 00:00:00");
               var25 = var23 - 1 + "-12-31";
               var19 = var14.stringToDateSQL(var25 + " 23:59:59");
               var16 = var16.add(Restrictions.between("valDate", var18, var19));
            } else if (var6.equalsIgnoreCase("20")) {
               var16.setMaxResults(20);
               var16 = var16.addOrder(Order.desc("valId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var24 = "%" + var4 + "%";
         var16 = var16.add(Restrictions.like("valNum", var24));
      }

      if (var10 != null && !var10.isEmpty()) {
         var16 = var16.add(Restrictions.eq("valDossierTransit", var10));
      }

      if (var9 == 1) {
         var16 = var16.add(Restrictions.eq("valIdCreateur", var7));
      }

      if (var5 <= 10) {
         var16 = var16.add(Restrictions.eq("valEtat", var5));
      }

      var16 = var16.addOrder(Order.desc("valDate"));
      var16 = var16.addOrder(Order.desc("valNum"));
      List var27 = var16.list();
      if (var13) {
         this.utilInitHibernate.closeSession();
      }

      return var27;
   }

   public List recherche(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var2 = true;
      }

      new ArrayList();
      List var4 = var1.createQuery("from ValorisationEnteteAchats order by valNum").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ValorisationEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ValorisationEnteteAchats where valNum=:num and valSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      ValorisationEnteteAchats var7 = null;
      if (var6.size() != 0) {
         var7 = (ValorisationEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ValorisationEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ValorisationEnteteAchats where valId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      ValorisationEnteteAchats var7 = null;
      if (var6.size() != 0) {
         var7 = (ValorisationEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ValorisationEnteteAchats rechercheByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ValorisationEnteteAchats where valDossierTransit =:dos").setString("dos", var1).setMaxResults(1);
      List var5 = var4.list();
      ValorisationEnteteAchats var6 = null;
      if (var5.size() != 0) {
         var6 = (ValorisationEnteteAchats)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByDossier(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ValorisationEnteteAchats");
      ArrayList var4 = new ArrayList();
      new ArrayList();
      List var5 = var3.list();
      if (var5.size() != 0) {
         for(int var6 = 0; var6 < var5.size(); ++var6) {
            new ValorisationEnteteAchats();
            ValorisationEnteteAchats var7 = (ValorisationEnteteAchats)var5.get(var6);
            var4.add(new SelectItem(var7.getValNum(), var7.getValDossierTransit() + ":" + var7.getValObjet()));
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheValorisationRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ValorisationEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheValorisationByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ValorisationEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from ValorisationEnteteAchats where valDate>=:deb and valDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
