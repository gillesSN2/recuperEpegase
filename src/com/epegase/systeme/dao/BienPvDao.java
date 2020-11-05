package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.BienPv;
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

public class BienPvDao implements Serializable {
   private BienPv bienPv;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienPvDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BienPv insert(BienPv var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
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

   public BienPv insert(BienPv var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BienPv modif(BienPv var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
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

   public BienPv modif(BienPv var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(BienPv var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
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

   public void delete(BienPv var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List recherche(Session var1, long var2, String var4, String var5, int var6, String var7, String var8, String var9, String var10, long var11, int var13, String var14, String var15, String var16, String var17, String var18, String var19) throws HibernateException, NamingException, ParseException {
      boolean var20 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var20 = true;
      }

      UtilDate var21 = new UtilDate();
      new ArrayList();
      Criteria var23 = var1.createCriteria(BienFacture.class);
      Calendar var24 = Calendar.getInstance();
      Date var25 = null;
      Date var26 = null;
      Date var27 = new Date();
      String var28 = var21.dateToStringFr(var27);
      String var29 = var28.substring(6, 10) + "-" + var28.substring(3, 5) + "-" + var28.substring(0, 2);
      var25 = var21.stringToDateSQL(var29 + " 00:00:00");
      var26 = var21.stringToDateSQL(var29 + " 23:59:59");
      int var30 = var27.getYear() + 1900;
      String var31;
      String var32;
      if (var9.equalsIgnoreCase("100")) {
         if (var18 != null && var19 != null) {
            var25 = var21.stringToDateSQL(var18 + " 00:00:00");
            var26 = var21.stringToDateSQL(var19 + " 23:59:59");
            var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
         } else {
            var31 = "1980-01-01";
            var21.stringToDateSQL(var31 + " 00:00:00");
            var23 = var23.add(Restrictions.isNotNull("biefacDate"));
         }
      } else {
         if (!var9.equalsIgnoreCase("12") && !var9.equalsIgnoreCase("13") && !var9.equalsIgnoreCase("14")) {
            var23 = var23.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var9.equalsIgnoreCase("0")) {
            var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
         } else if (var9.equalsIgnoreCase("1")) {
            var31 = "" + var24.getTime();
            if (var31.contains("Mon")) {
               var25 = var24.getTime();
            } else if (var31.contains("Tue")) {
               var24.add(7, -1);
               var25 = var24.getTime();
            } else if (var31.contains("Wed")) {
               var24.add(7, -2);
               var25 = var24.getTime();
            } else if (var31.contains("Thu")) {
               var24.add(7, -3);
               var25 = var24.getTime();
            } else if (var31.contains("Fri")) {
               var24.add(7, -4);
               var25 = var24.getTime();
            } else if (var31.contains("Sat")) {
               var24.add(7, -5);
               var25 = var24.getTime();
            } else if (var31.contains("Sun")) {
               var24.add(7, -6);
               var25 = var24.getTime();
            }

            var28 = var21.dateToStringFr(var25);
            var29 = var28.substring(6, 10) + "-" + var28.substring(3, 5) + "-" + var28.substring(0, 2);
            var25 = var21.stringToDateSQL(var29 + " 00:00:00");
            var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
         } else {
            int var35;
            if (var9.equalsIgnoreCase("2")) {
               var35 = var24.get(2) + 1;
               var32 = var30 + "-" + var35 + "-01";
               var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("3")) {
               var35 = var24.get(2);
               var24.add(5, -var35);
               if (var35 <= 3) {
                  var32 = var30 + "-01-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               } else if (var35 >= 4 && var35 <= 6) {
                  var32 = var30 + "-04-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               } else if (var35 >= 7 && var35 <= 9) {
                  var32 = var30 + "-07-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               } else if (var35 >= 10) {
                  var32 = var30 + "-10-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               }

               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("4")) {
               var35 = var24.get(2);
               var24.add(5, -var35);
               if (var35 <= 6) {
                  var32 = var30 + "-01-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               } else {
                  var32 = var30 + "-07-01";
                  var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               }

               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("5")) {
               var31 = var30 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-03-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("6")) {
               var31 = var30 + "-04-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-06-30";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("7")) {
               var31 = var30 + "-07-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-09-30";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("8")) {
               var31 = var30 + "-10-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("9")) {
               var31 = var30 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-06-30";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("10")) {
               var31 = var30 + "-07-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("11")) {
               var31 = var30 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("12")) {
               var31 = "1980-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 - 1 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("13")) {
               var31 = var30 - 1 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("14")) {
               var31 = var30 - 1 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 - 1 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("biefacDate", var25, var26));
            } else if (var9.equalsIgnoreCase("20")) {
               var23.setMaxResults(20);
               var23 = var23.addOrder(Order.desc("biefacId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var31 = "%" + var4 + "%";
         var23 = var23.add(Restrictions.like("biefacNum", var31));
      }

      if (var5 != null && !var5.isEmpty() && !var5.contains(":")) {
         var31 = "";
         if (var5.startsWith("*")) {
            var31 = "%" + var5.substring(1) + "%";
         } else {
            var31 = var5 + "%";
         }

         var23 = var23.add(Restrictions.like("biefacNomTiers", var31));
      }

      String[] var36;
      if (var5 != null && !var5.isEmpty() && var5.contains(":")) {
         var36 = var5.split(":");
         long var37 = Long.parseLong(var36[0]);
         var23 = var23.add(Restrictions.eq("tiers.tieid", var37));
      }

      if (var14 != null && !var14.isEmpty()) {
         var23 = var23.add(Restrictions.eq("biefacNomContact", var14));
      }

      if (var15 != null && !var15.isEmpty()) {
         var23 = var23.add(Restrictions.eq("biefacNomResponsable", var15));
      }

      if (var16 != null && !var16.isEmpty()) {
         var23 = var23.add(Restrictions.eq("biefacNomCommercial", var16));
      }

      if (var13 == 1) {
         var23 = var23.add(Restrictions.eq("biefacIdCreateur", var11));
      }

      if (!var7.equalsIgnoreCase("100")) {
         if (var7.contains(",")) {
            var36 = var7.split(",");
            int var38 = var36.length;
            String[] var33 = new String[var38];

            for(int var34 = 0; var34 < var38; ++var34) {
               var33[var34] = new String(var36[var34]);
            }

            var23 = var23.add(Restrictions.in("biefacSerie", var33));
         } else {
            var23 = var23.add(Restrictions.eq("biefacSerie", var7));
         }
      }

      if (!var8.equalsIgnoreCase("100")) {
         var23 = var23.add(Restrictions.eq("biefacCat", var8));
      }

      if (var6 <= 10) {
         var23 = var23.add(Restrictions.eq("biefacEtat", var6));
      } else if (var6 == 11) {
         var23 = var23.add(Restrictions.isNotNull("biefacDateRelance"));
      } else if (var6 == 12) {
         var23 = var23.add(Restrictions.eq("biefacTotHt", 0.0D));
      } else if (var6 == 13) {
         var23 = var23.add(Restrictions.eq("biefacSolde", 0));
      } else if (var6 == 14) {
         var23 = var23.add(Restrictions.eq("biefacSolde", 1));
      } else if (var6 == 15) {
         var23 = var23.add(Restrictions.eq("biefacExoTva", 1));
      } else if (var6 == 16) {
         var23 = var23.add(Restrictions.and(Restrictions.eq("biefacExoTva", 1), Restrictions.isNull("biefacDateVisa")));
      } else if (var6 == 17) {
         var23 = var23.add(Restrictions.isNotNull("biefacDateTransfert"));
      } else if (var6 == 18) {
         var23 = var23.add(Restrictions.isNull("biefacDateTransfert"));
      }

      if (var10 != null && !var10.isEmpty() && !var10.equalsIgnoreCase("100") && var10.contains(":")) {
         var23 = var23.add(Restrictions.eq("biefacService", var10));
      }

      if (!var17.equalsIgnoreCase("100")) {
         var36 = var17.split(":");
         var32 = var36[0];
         var23 = var23.add(Restrictions.eq("biefacActivite", var32));
      }

      var23 = var23.addOrder(Order.desc("biefacDate"));
      var23 = var23.addOrder(Order.desc("biefacNum"));
      List var39 = var23.list();
      if (var20) {
         this.utilInitHibernate.closeSession();
      }

      return var39;
   }

   public List chargeBienPv(int var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var4 = true;
      }

      String var5 = "";
      if (var2 == 9) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=3 or bieCategorie=4 or bieCategorie=6)";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6)";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=4 or bieCategorie=6)";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6";
         }
      } else if (var2 == 0) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=3 or bieCategorie=4 or bieCategorie=6) and bieGestion=0 and bieOccupe=0";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6) and bieGestion=0 and bieOccupe=0";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=4 or bieCategorie=6) and bieGestion=0 and bieOccupe=0";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=0 and bieOccupe=0";
         }
      } else if (var2 == 1) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=3 or bieCategorie=4 or bieCategorie=6) and bieGestion=0 and bieOccupe=1";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6) and bieGestion=0 and bieOccupe=1";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=4 or bieCategorie=6) and bieGestion=0 and bieOccupe=1";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=0 and bieOccupe=1";
         }
      } else if (var2 == 2) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=3 or bieCategorie=4 or bieCategorie=6) and bieGestion=0";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6) and bieGestion=0";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=4 or bieCategorie=6) and bieGestion=0";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=0";
         }
      } else if (var2 == 8) {
         if (var1 == 0) {
            var5 = "(bieCategorie=0 or bieCategorie=3 or bieCategorie=4 or bieCategorie=6) and bieGestion=1";
         } else if (var1 == 1) {
            var5 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6) and bieGestion=1";
         } else if (var1 == 2) {
            var5 = "(bieCategorie=2 or bieCategorie=4 or bieCategorie=6) and bieGestion=1";
         } else {
            var5 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=1";
         }
      }

      List var6 = var3.createQuery("from BienPv where " + var5).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeBienPv(int var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var5 = true;
      }

      String var6 = "";
      if (var3 != null && !var3.isEmpty()) {
         if (var3.equals("*")) {
            var6 = "";
         } else if (var3.startsWith("*") && var3.length() >= 2) {
            var6 = " and (bieNum like '" + var3.substring(1) + "%' or bieNom like '%" + var3.substring(1) + "%')";
         } else {
            var6 = " and (bieNum like '" + var3 + "%' or bieNom like '%" + var3 + "%')";
         }
      }

      String var7 = "";
      if (var2 == 9) {
         if (var1 == 0) {
            var7 = "(bieCategorie=0 or bieCategorie=3 or bieCategorie=4 or bieCategorie=6)";
         } else if (var1 == 1) {
            var7 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6)";
         } else if (var1 == 2) {
            var7 = "(bieCategorie=2 or bieCategorie=4 or bieCategorie=6)";
         } else {
            var7 = "bieCategorie>=0 and bieCategorie<=6";
         }
      } else if (var1 == 0) {
         var7 = "(bieCategorie=0 or bieCategorie=3 or bieCategorie=4 or bieCategorie=6) and bieGestion=" + var2;
      } else if (var1 == 1) {
         var7 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6) and bieGestion=" + var2;
      } else if (var1 == 2) {
         var7 = "(bieCategorie=2 or bieCategorie=4 or bieCategorie=6) and bieGestion=" + var2;
      } else {
         var7 = "bieCategorie>=0 and bieCategorie<=6 and bieGestion=" + var2;
      }

      List var8 = var4.createQuery("from BienPv where " + var7 + var6).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List chargeBienPvSyndic(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var2 = true;
      }

      String var3 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6)";
      List var4 = var1.createQuery("from BienPv where " + var3).list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargeBienPvByType(int var1, int var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var4 = true;
      }

      String var5 = "";
      if (var1 == 0) {
         var5 = "(bieCategorie=0 or bieCategorie=3 or bieCategorie=4 or bieCategorie=6)";
      } else if (var1 == 1) {
         var5 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6)";
      } else if (var1 == 2) {
         var5 = "(bieCategorie=2 or bieCategorie=4 or bieCategorie=6)";
      } else {
         var5 = "bieCategorie>=0 and bieCategorie<=6";
      }

      List var6 = var3.createQuery("from BienPv where " + var5 + " and bieType=:typ").setInteger("typ", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeBienPvByTiers(int var1, Tiers var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var4 = true;
      }

      List var5 = null;
      if (var1 == 9) {
         var5 = var3.createQuery("from BienPv where Tiers=:tt").setParameter("tt", var2).list();
      } else {
         String var6 = "";
         if (var1 == 0) {
            var6 = "(bieCategorie=0 or bieCategorie=3 or bieCategorie=4 or bieCategorie=6)";
         } else if (var1 == 1) {
            var6 = "(bieCategorie=1 or bieCategorie=3 or bieCategorie=5 or bieCategorie=6)";
         } else if (var1 == 2) {
            var6 = "(bieCategorie=2 or bieCategorie=4 or bieCategorie=6)";
         } else {
            var6 = "bieCategorie>=0 and bieCategorie<=6";
         }

         var5 = var3.createQuery("from BienPv where " + var6 + " and Tiers=:tt").setParameter("tt", var2).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargeBienPvDetail(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var4 = true;
      }

      this.bienPv = new BienPv();
      Query var5 = var3.createQuery("from BienPv where bieIdGroupe=:numero and (bieType=1 or bieType=3 or bieType=4 or bieType=10)").setLong("numero", var1);
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public BienPv logBienPvId(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var4 = true;
      }

      this.bienPv = new BienPv();
      Query var5 = var3.createQuery("from BienPv where bieId=:bie").setLong("bie", var1).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() != 0) {
         this.bienPv = (BienPv)var6.get(0);
      } else {
         this.bienPv = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.bienPv;
   }

   public BienPv chargeGroupe(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var3 = true;
      }

      this.bienPv = new BienPv();
      Query var4 = var2.createQuery("from BienPv where bieNum=:numero and bieType=2").setString("numero", var1).setMaxResults(1);
      List var5 = var4.list();
      if (var5.size() != 0) {
         this.bienPv = (BienPv)var5.get(0);
      } else {
         this.bienPv = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.bienPv;
   }

   public BienPv logBienPvNum(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var3 = true;
      }

      this.bienPv = new BienPv();
      Query var4 = var2.createQuery("from BienPv where bieNum=:numero").setString("numero", var1).setMaxResults(1);
      List var5 = var4.list();
      if (var5.size() != 0) {
         this.bienPv = (BienPv)var5.get(0);
      } else {
         this.bienPv = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return this.bienPv;
   }

   public boolean logMailExiste(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienPv  where bieNum=:numero").setString("numero", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "SyndicPv");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienPv where Tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
}
