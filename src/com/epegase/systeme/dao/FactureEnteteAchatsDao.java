package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.Tiers;
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

public class FactureEnteteAchatsDao implements Serializable {
   private FactureEnteteAchats factureEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FactureEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FactureEnteteAchats insert(FactureEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FactureEnteteAchats modif(FactureEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
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

   public FactureEnteteAchats modif(FactureEnteteAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from FactureEnteteAchats where fcfId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public FactureEnteteAchats duppliquer(FactureEnteteAchats var1, Session var2) {
      FactureEnteteAchats var3 = new FactureEnteteAchats();
      var3.setExercicesAchats(var1.getExercicesAchats());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from FactureEnteteAchats order by fcfId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            FactureEnteteAchats var7 = (FactureEnteteAchats)var6.get(0);
            var4 = 1L + var7.getFcfId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public FactureEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from FactureEnteteAchats where exercicesAchats.exeachId=:id and fcfSerie =:ser and year(fcfDate)=" + var7 + " order by fcfDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      FactureEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (FactureEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public FactureEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from FactureEnteteAchats where exercicesAchats.exeachId=:id and fcfSerie =:ser and year(fcfDate)=" + var7 + " and month(fcfDate)=" + var8 + " order by fcfDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      FactureEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (FactureEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, double var6, long var8, String var10, int var11, String var12, String var13, String var14, String var15, long var16, int var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25) throws HibernateException, NamingException, ParseException {
      boolean var26 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var26 = true;
      }

      UtilDate var27 = new UtilDate();
      new ArrayList();
      Criteria var29 = var1.createCriteria(FactureEnteteAchats.class);
      Calendar var30 = Calendar.getInstance();
      Date var31 = null;
      Date var32 = null;
      Date var33 = new Date();
      String var34 = var27.dateToStringFr(var33);
      String var35 = var34.substring(6, 10) + "-" + var34.substring(3, 5) + "-" + var34.substring(0, 2);
      var31 = var27.stringToDateSQL(var35 + " 00:00:00");
      var32 = var27.stringToDateSQL(var35 + " 23:59:59");
      int var36 = var33.getYear() + 1900;
      String var37;
      String var38;
      if (var14.equalsIgnoreCase("100")) {
         if (var22 != null && var23 != null) {
            var31 = var27.stringToDateSQL(var22 + " 00:00:00");
            var32 = var27.stringToDateSQL(var23 + " 23:59:59");
            var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
         } else {
            var37 = "1980-01-01";
            var27.stringToDateSQL(var37 + " 00:00:00");
            var29 = var29.add(Restrictions.isNotNull("fcfDate"));
         }
      } else {
         if (!var14.equalsIgnoreCase("12") && !var14.equalsIgnoreCase("13") && !var14.equalsIgnoreCase("14")) {
            var29 = var29.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var14.equalsIgnoreCase("0")) {
            var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
         } else if (var14.equalsIgnoreCase("1")) {
            var37 = "" + var30.getTime();
            if (var37.contains("Mon")) {
               var31 = var30.getTime();
            } else if (var37.contains("Tue")) {
               var30.add(7, -1);
               var31 = var30.getTime();
            } else if (var37.contains("Wed")) {
               var30.add(7, -2);
               var31 = var30.getTime();
            } else if (var37.contains("Thu")) {
               var30.add(7, -3);
               var31 = var30.getTime();
            } else if (var37.contains("Fri")) {
               var30.add(7, -4);
               var31 = var30.getTime();
            } else if (var37.contains("Sat")) {
               var30.add(7, -5);
               var31 = var30.getTime();
            } else if (var37.contains("Sun")) {
               var30.add(7, -6);
               var31 = var30.getTime();
            }

            var34 = var27.dateToStringFr(var31);
            var35 = var34.substring(6, 10) + "-" + var34.substring(3, 5) + "-" + var34.substring(0, 2);
            var31 = var27.stringToDateSQL(var35 + " 00:00:00");
            var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
         } else {
            int var41;
            if (var14.equalsIgnoreCase("2")) {
               var41 = var30.get(2) + 1;
               var38 = var36 + "-" + var41 + "-01";
               var31 = var27.stringToDateSQL(var38 + " 00:00:00");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("3")) {
               var41 = var30.get(2);
               var30.add(5, -var41);
               if (var41 <= 3) {
                  var38 = var36 + "-01-01";
                  var31 = var27.stringToDateSQL(var38 + " 00:00:00");
               } else if (var41 >= 4 && var41 <= 6) {
                  var38 = var36 + "-04-01";
                  var31 = var27.stringToDateSQL(var38 + " 00:00:00");
               } else if (var41 >= 7 && var41 <= 9) {
                  var38 = var36 + "-07-01";
                  var31 = var27.stringToDateSQL(var38 + " 00:00:00");
               } else if (var41 >= 10) {
                  var38 = var36 + "-10-01";
                  var31 = var27.stringToDateSQL(var38 + " 00:00:00");
               }

               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("4")) {
               var41 = var30.get(2);
               var30.add(5, -var41);
               if (var41 <= 6) {
                  var38 = var36 + "-01-01";
                  var31 = var27.stringToDateSQL(var38 + " 00:00:00");
               } else {
                  var38 = var36 + "-07-01";
                  var31 = var27.stringToDateSQL(var38 + " 00:00:00");
               }

               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("5")) {
               var37 = var36 + "-01-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 + "-03-31";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("6")) {
               var37 = var36 + "-04-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 + "-06-30";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("7")) {
               var37 = var36 + "-07-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 + "-09-30";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("8")) {
               var37 = var36 + "-10-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 + "-12-31";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("9")) {
               var37 = var36 + "-01-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 + "-06-30";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("10")) {
               var37 = var36 + "-07-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 + "-12-31";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("11")) {
               var37 = var36 + "-01-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 + "-12-31";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("12")) {
               var37 = "1980-01-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 - 1 + "-12-31";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("13")) {
               var37 = var36 - 1 + "-01-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 + "-12-31";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("14")) {
               var37 = var36 - 1 + "-01-01";
               var31 = var27.stringToDateSQL(var37 + " 00:00:00");
               var38 = var36 - 1 + "-12-31";
               var32 = var27.stringToDateSQL(var38 + " 23:59:59");
               var29 = var29.add(Restrictions.between("fcfDate", var31, var32));
            } else if (var14.equalsIgnoreCase("20")) {
               var29.setMaxResults(20);
               var29 = var29.addOrder(Order.desc("fcfId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var37 = "%" + var4 + "%";
         var29 = var29.add(Restrictions.like("fcfNum", var37));
      }

      if (var5 != null && !var5.isEmpty()) {
         var37 = "%" + var5 + "%";
         var29 = var29.add(Restrictions.like("fcfNumFour", var37));
      }

      if (var6 != 0.0D) {
         double var43 = var6 - 1.0D;
         double var39 = var6 + 0.99D;
         var29 = var29.add(Restrictions.between("fcfTotTtc", var43, var39));
      }

      String[] var46;
      if (var8 != 0L) {
         var29 = var29.add(Restrictions.eq("tiers.tieid", var8));
      } else {
         if (var10 != null && !var10.isEmpty() && !var10.contains(":")) {
            var37 = "";
            if (var10.startsWith("*")) {
               var37 = "%" + var10.substring(1) + "%";
            } else {
               var37 = var10 + "%";
            }

            var29 = var29.add(Restrictions.or(Restrictions.like("fcfNomTiers", var37), Restrictions.like("fcfDiversNom", var37)));
         }

         if (var10 != null && !var10.isEmpty() && var10.contains(":")) {
            var46 = var10.split(":");
            long var44 = Long.parseLong(var46[0]);
            var29 = var29.add(Restrictions.eq("tiers.tieid", var44));
         }
      }

      if (var20 != null && !var20.isEmpty()) {
         var29 = var29.add(Restrictions.eq("fcfNomResponsable", var20));
      }

      if (var18 == 1) {
         var29 = var29.add(Restrictions.eq("fcfIdCreateur", var16));
      }

      if (!var12.equalsIgnoreCase("100")) {
         if (var12.contains(",")) {
            var46 = var12.split(",");
            int var45 = var46.length;
            String[] var42 = new String[var45];

            for(int var40 = 0; var40 < var45; ++var40) {
               var42[var40] = new String(var46[var40]);
            }

            var29 = var29.add(Restrictions.in("fcfSerie", var42));
         } else {
            var29 = var29.add(Restrictions.eq("fcfSerie", var12));
         }
      }

      if (!var13.equalsIgnoreCase("100")) {
         var29 = var29.add(Restrictions.eq("fcfCat", var13));
      }

      if (var11 <= 10) {
         var29 = var29.add(Restrictions.eq("fcfEtat", var11));
      } else if (var11 == 11) {
         var29 = var29.add(Restrictions.isNotNull("fcfDateRelance"));
      } else if (var11 == 12) {
         var29 = var29.add(Restrictions.eq("fcfTotHt", 0.0D));
      } else if (var11 == 13) {
         var29 = var29.add(Restrictions.eq("fcfSolde", 0));
      } else if (var11 == 14) {
         var29 = var29.add(Restrictions.eq("fcfSolde", 1));
      } else if (var11 == 15) {
         var29 = var29.add(Restrictions.eq("fcfExoTva", 1));
      } else if (var11 == 17) {
         var29 = var29.add(Restrictions.isNotNull("fcfDateTransfert"));
      } else if (var11 == 18) {
         var29 = var29.add(Restrictions.isNull("fcfDateTransfert"));
      }

      if (var15 != null && !var15.isEmpty() && !var15.equalsIgnoreCase("100") && var15.contains(":")) {
         var29 = var29.add(Restrictions.eq("fcfService", var15));
      }

      if (!var21.equalsIgnoreCase("100")) {
         var46 = var21.split(":");
         var38 = var46[0];
         var29 = var29.add(Restrictions.eq("fcfActivite", var38));
      }

      if (!var19.equalsIgnoreCase("100")) {
         var46 = var19.split(":");
         var38 = var46[0];
         var29 = var29.add(Restrictions.eq("fcfBudget", var38));
      }

      if (var24 != null && !var24.isEmpty() && !var24.equalsIgnoreCase("100")) {
         var37 = "%" + var24 + "%";
         var29 = var29.add(Restrictions.or(Restrictions.eq("fcfAffaire", var37), Restrictions.eq("fcfAnal4", var37)));
      }

      if (var25 != null && !var25.isEmpty() && !var25.equalsIgnoreCase("100")) {
         var37 = "%" + var25 + "%";
         var29 = var29.add(Restrictions.eq("fcfAnal4", var37));
      }

      var29 = var29.addOrder(Order.desc("fcfDate"));
      var29 = var29.addOrder(Order.desc("fcfNum"));
      List var47 = var29.list();
      if (var26) {
         this.utilInitHibernate.closeSession();
      }

      return var47;
   }

   public List rechercheFactureAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from FactureEnteteAchats where fcfService='" + var1 + "' and (fcfDateEcheReg='" + var5 + "' or fcfTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from FactureEnteteAchats where fcfDateEcheReg='" + var5 + "' or fcfTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public FactureEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FactureEnteteAchats where fcfId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new FactureEnteteAchats();
      FactureEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (FactureEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FactureEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FactureEnteteAchats where fcfNum=:num and fcfSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new FactureEnteteAchats();
      FactureEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (FactureEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FactureEnteteAchats rechercheAnal4(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureEnteteAchats where fcfAnal4=:num and fcfSerie=:ser").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new FactureEnteteAchats();
      FactureEnteteAchats var6;
      if (var5.size() != 0) {
         var6 = (FactureEnteteAchats)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureAValoriser(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      if (var1 != null && !var1.isEmpty()) {
         var5 = var2.createQuery("from FactureEnteteAchats where fcfService='" + var1 + "' and fcfDateValo='null' or fcfCoefValo=0").list();
      } else {
         var5 = var2.createQuery("from FactureEnteteAchats where fcfDateValo='null' or fcfCoefValo=0").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheFactureATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from FactureEnteteAchats where (fcfEtat=0 or fcfEtat=1 or fcfEtat=4) and fcfDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from FactureEnteteAchats where (fcfEtat=0 or fcfEtat=1 or fcfEtat=4) and fcfDateTransfert is NULL and fcfDate>=:dte1 and fcfDate<=:dte2 and fcfNum>=:p1 and fcfNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from FactureEnteteAchats where (fcfEtat=0 or fcfEtat=1 or fcfEtat=4) and fcfDateTransfert is NULL and fcfDate>=:dte1 and fcfDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from FactureEnteteAchats where (fcfEtat=1 or fcfEtat=4) and fcfDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from FactureEnteteAchats where (fcfEtat=1 or fcfEtat=4) and fcfDateTransfert is NULL and fcfDate>=:dte1 and fcfDate<=:dte2 and fcfNum>=:p1 and fcfNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from FactureEnteteAchats where (fcfEtat=1 or fcfEtat=4) and fcfDateTransfert is NULL and fcfDate>=:dte1 and fcfDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheFactureDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from FactureEnteteAchats where (fcfEtat=0 or fcfEtat=1 or fcfEtat=4) and (fcfDateTransfert<> '' and fcfDateTransfert is not NULL) and (fcfDate>=:dte1 and fcfDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
      Query var4 = var3.createQuery("from FactureEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public boolean verifTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureEnteteAchats where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FactureEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureEnteteAchats where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheFactureByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from FactureEnteteAchats where fcfDate>=:deb and fcfDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureCampagne(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FactureEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureEnteteAchats where fcfSource like '" + var1 + "%'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
