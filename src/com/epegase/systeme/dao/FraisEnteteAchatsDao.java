package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.FraisEnteteAchats;
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

public class FraisEnteteAchatsDao implements Serializable {
   private FraisEnteteAchats fraisEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FraisEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FraisEnteteAchats insert(FraisEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FraisEnteteAchats modif(FraisEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
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

   public FraisEnteteAchats modif(FraisEnteteAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public FraisEnteteAchats delete(FraisEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
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

      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from FraisEnteteAchats where fsfId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from FraisEnteteAchats order by fsfId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            FraisEnteteAchats var7 = (FraisEnteteAchats)var6.get(0);
            var4 = 1L + var7.getFsfId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public FraisEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from FraisEnteteAchats where exercicesAchats.exeachId=:id and fsfSerie =:ser and year(fsfDate)=" + var7 + " order by fsfDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      FraisEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (FraisEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public FraisEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from FraisEnteteAchats where exercicesAchats.exeachId=:id and fsfSerie =:ser and year(fsfDate)=" + var7 + " and month(fsfDate)=" + var8 + " order by fsfDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      FraisEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (FraisEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, double var6, long var8, String var10, int var11, String var12, String var13, String var14, String var15, long var16, int var18, String var19, String var20, String var21, String var22, String var23, String var24) throws HibernateException, NamingException, ParseException {
      boolean var25 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var25 = true;
      }

      UtilDate var26 = new UtilDate();
      new ArrayList();
      Criteria var28 = var1.createCriteria(FraisEnteteAchats.class);
      Calendar var29 = Calendar.getInstance();
      Date var30 = null;
      Date var31 = null;
      Date var32 = new Date();
      String var33 = var26.dateToStringFr(var32);
      String var34 = var33.substring(6, 10) + "-" + var33.substring(3, 5) + "-" + var33.substring(0, 2);
      var30 = var26.stringToDateSQL(var34 + " 00:00:00");
      var31 = var26.stringToDateSQL(var34 + " 23:59:59");
      int var35 = var32.getYear() + 1900;
      String var36;
      String var37;
      if (var14.equalsIgnoreCase("100")) {
         if (var23 != null && var24 != null) {
            var30 = var26.stringToDateSQL(var23 + " 00:00:00");
            var31 = var26.stringToDateSQL(var24 + " 23:59:59");
            var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
         } else {
            var36 = "1980-01-01";
            var26.stringToDateSQL(var36 + " 00:00:00");
            var28 = var28.add(Restrictions.isNotNull("fsfDate"));
         }
      } else {
         if (!var14.equalsIgnoreCase("12") && !var14.equalsIgnoreCase("13") && !var14.equalsIgnoreCase("14")) {
            var28 = var28.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var14.equalsIgnoreCase("0")) {
            var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
         } else if (var14.equalsIgnoreCase("1")) {
            var36 = "" + var29.getTime();
            if (var36.contains("Mon")) {
               var30 = var29.getTime();
            } else if (var36.contains("Tue")) {
               var29.add(7, -1);
               var30 = var29.getTime();
            } else if (var36.contains("Wed")) {
               var29.add(7, -2);
               var30 = var29.getTime();
            } else if (var36.contains("Thu")) {
               var29.add(7, -3);
               var30 = var29.getTime();
            } else if (var36.contains("Fri")) {
               var29.add(7, -4);
               var30 = var29.getTime();
            } else if (var36.contains("Sat")) {
               var29.add(7, -5);
               var30 = var29.getTime();
            } else if (var36.contains("Sun")) {
               var29.add(7, -6);
               var30 = var29.getTime();
            }

            var33 = var26.dateToStringFr(var30);
            var34 = var33.substring(6, 10) + "-" + var33.substring(3, 5) + "-" + var33.substring(0, 2);
            var30 = var26.stringToDateSQL(var34 + " 00:00:00");
            var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
         } else {
            int var40;
            if (var14.equalsIgnoreCase("2")) {
               var40 = var29.get(2) + 1;
               var37 = var35 + "-" + var40 + "-01";
               var30 = var26.stringToDateSQL(var37 + " 00:00:00");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("3")) {
               var40 = var29.get(2);
               var29.add(5, -var40);
               if (var40 <= 3) {
                  var37 = var35 + "-01-01";
                  var30 = var26.stringToDateSQL(var37 + " 00:00:00");
               } else if (var40 >= 4 && var40 <= 6) {
                  var37 = var35 + "-04-01";
                  var30 = var26.stringToDateSQL(var37 + " 00:00:00");
               } else if (var40 >= 7 && var40 <= 9) {
                  var37 = var35 + "-07-01";
                  var30 = var26.stringToDateSQL(var37 + " 00:00:00");
               } else if (var40 >= 10) {
                  var37 = var35 + "-10-01";
                  var30 = var26.stringToDateSQL(var37 + " 00:00:00");
               }

               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("4")) {
               var40 = var29.get(2);
               var29.add(5, -var40);
               if (var40 <= 6) {
                  var37 = var35 + "-01-01";
                  var30 = var26.stringToDateSQL(var37 + " 00:00:00");
               } else {
                  var37 = var35 + "-07-01";
                  var30 = var26.stringToDateSQL(var37 + " 00:00:00");
               }

               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("5")) {
               var36 = var35 + "-01-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 + "-03-31";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("6")) {
               var36 = var35 + "-04-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 + "-06-30";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("7")) {
               var36 = var35 + "-07-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 + "-09-30";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("8")) {
               var36 = var35 + "-10-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 + "-12-31";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("9")) {
               var36 = var35 + "-01-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 + "-06-30";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("10")) {
               var36 = var35 + "-07-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 + "-12-31";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("11")) {
               var36 = var35 + "-01-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 + "-12-31";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("12")) {
               var36 = "1980-01-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 - 1 + "-12-31";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("13")) {
               var36 = var35 - 1 + "-01-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 + "-12-31";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("14")) {
               var36 = var35 - 1 + "-01-01";
               var30 = var26.stringToDateSQL(var36 + " 00:00:00");
               var37 = var35 - 1 + "-12-31";
               var31 = var26.stringToDateSQL(var37 + " 23:59:59");
               var28 = var28.add(Restrictions.between("fsfDate", var30, var31));
            } else if (var14.equalsIgnoreCase("20")) {
               var28.setMaxResults(20);
               var28 = var28.addOrder(Order.desc("fsfId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var36 = "%" + var4 + "%";
         var28 = var28.add(Restrictions.like("fsfNum", var36));
      }

      if (var5 != null && !var5.isEmpty()) {
         var36 = "%" + var5 + "%";
         var28 = var28.add(Restrictions.like("fsfObject", var36));
      }

      if (var6 != 0.0D) {
         double var42 = var6 - 1.0D;
         double var38 = var6 + 0.99D;
         var28 = var28.add(Restrictions.between("fsfTotTtc", var42, var38));
      }

      if (var8 != 0L) {
         var28 = var28.add(Restrictions.eq("tiers.tieid", var8));
      } else if (var10 != null && !var10.isEmpty()) {
         var36 = "";
         if (var10.startsWith("*")) {
            var36 = "%" + var10.substring(1) + "%";
         } else {
            var36 = var10 + "%";
         }

         var28 = var28.add(Restrictions.or(Restrictions.like("fsfNomTiers", var36), Restrictions.like("fsfDiversNom", var36)));
      }

      if (var20 != null && !var20.isEmpty()) {
         var28 = var28.add(Restrictions.eq("fsfNomResponsable", var20));
      }

      if (var18 == 1) {
         var28 = var28.add(Restrictions.eq("fsfIdCreateur", var16));
      }

      String[] var44;
      if (!var12.equalsIgnoreCase("100")) {
         if (var12.contains(",")) {
            var44 = var12.split(",");
            int var43 = var44.length;
            String[] var41 = new String[var43];

            for(int var39 = 0; var39 < var43; ++var39) {
               var41[var39] = new String(var44[var39]);
            }

            var28 = var28.add(Restrictions.in("fsfSerie", var41));
         } else {
            var28 = var28.add(Restrictions.eq("fsfSerie", var12));
         }
      }

      if (!var13.equalsIgnoreCase("100")) {
         var28 = var28.add(Restrictions.eq("fsfCat", var13));
      }

      if (var11 <= 10) {
         var28 = var28.add(Restrictions.eq("fsfEtat", var11));
      } else if (var11 == 11) {
         var28 = var28.add(Restrictions.isNotNull("fsfDateRelance"));
      } else if (var11 == 12) {
         var28 = var28.add(Restrictions.eq("fsfTotHt", 0.0D));
      } else if (var11 == 13) {
         var28 = var28.add(Restrictions.eq("fsfSolde", 0));
      } else if (var11 == 14) {
         var28 = var28.add(Restrictions.eq("fsfSolde", 1));
      } else if (var11 == 15) {
         var28 = var28.add(Restrictions.eq("fsfExoTva", 1));
      } else if (var11 == 17) {
         var28 = var28.add(Restrictions.isNotNull("fsfDateTransfert"));
      } else if (var11 == 18) {
         var28 = var28.add(Restrictions.isNull("fsfDateTransfert"));
      }

      if (var15 != null && !var15.isEmpty() && !var15.equalsIgnoreCase("100") && var15.contains(":")) {
         var28 = var28.add(Restrictions.eq("fsfService", var15));
      }

      if (!var21.equalsIgnoreCase("100")) {
         var44 = var21.split(":");
         var37 = var44[0];
         var28 = var28.add(Restrictions.eq("fsfActivite", var37));
      }

      if (!var19.equalsIgnoreCase("100")) {
         var44 = var19.split(":");
         var37 = var44[0];
         var28 = var28.add(Restrictions.eq("fsfBudget", var37));
      }

      if (var22 != null && !var22.isEmpty()) {
         var28 = var28.add(Restrictions.eq("fsfAnal4", var22));
      }

      var28 = var28.addOrder(Order.desc("fsfDate"));
      var28 = var28.addOrder(Order.desc("fsfNum"));
      List var45 = var28.list();
      if (var25) {
         this.utilInitHibernate.closeSession();
      }

      return var45;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from FraisEnteteAchats where fsfService='" + var1 + "' and (fsfDateEcheReg='" + var5 + "' or fsfTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from FraisEnteteAchats where fsfDateEcheReg='" + var5 + "' or fsfTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public FraisEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FraisEnteteAchats where fsfId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new FraisEnteteAchats();
      FraisEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (FraisEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FraisEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from FraisEnteteAchats where fsfNum=:num and fsfSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var5 = var3.createQuery("from FraisEnteteAchats where fsfNum=:num").setString("num", var1).setMaxResults(1);
      }

      List var6 = var5.list();
      new FraisEnteteAchats();
      FraisEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (FraisEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheFraisFactureAchats(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = var2.createQuery("from FraisEnteteAchats where fdfDocument='" + var1 + "' and fdfDocumentId=15").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from FraisEnteteAchats where fsfAnal4 =:dos").setString("dos", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheByAffaire(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from FraisEnteteAchats where fsfAffaire =:dos and fsfAnal4 =:anal").setString("dos", var1).setString("anal", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByValo(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from FraisEnteteAchats where fsfValo =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheFraisATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from FraisEnteteAchats where (fsfEtat=0 or fsfEtat=1 or fsfEtat=4) and fsfDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from FraisEnteteAchats where (fsfEtat=0 or fsfEtat=1 or fsfEtat=4) and fsfDateTransfert is NULL and fsfDate>=:dte1 and fsfDate<=:dte2 and fsfNum>=:p1 and fsfNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from FraisEnteteAchats where (fsfEtat=0 or fsfEtat=1 or fsfEtat=4) and fsfDateTransfert is NULL and fsfDate>=:dte1 and fsfDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from FraisEnteteAchats where (fsfEtat=1 or fsfEtat=4) and fsfDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from FraisEnteteAchats where (fsfEtat=1 or fsfEtat=4) and fsfDateTransfert is NULL and fsfDate>=:dte1 and fsfDate<=:dte2 and fsfNum>=:p1 and fsfNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from FraisEnteteAchats where (fsfEtat=1 or fsfEtat=4) and fsfDateTransfert is NULL and fsfDate>=:dte1 and fsfDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheFraisDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from FraisEnteteAchats where (fsfEtat=0 or fsfEtat=1 or fsfEtat=4) and (fsfDateTransfert <> '' and fsfDateTransfert is not NULL) and (fsfDate>=:dte1 and fsfDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
      Query var4 = var3.createQuery("from FraisEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FraisEnteteAchats where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public List rechercheFraisRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FraisEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from FraisEnteteAchats where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheFraisByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "FraisEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from FraisEnteteAchats where fsfDate>=:deb and fsfDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
