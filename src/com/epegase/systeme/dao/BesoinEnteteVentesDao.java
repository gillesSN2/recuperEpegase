package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BesoinEnteteVentes;
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

public class BesoinEnteteVentesDao implements Serializable {
   private BesoinEnteteVentes besoinEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BesoinEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BesoinEnteteVentes insert(BesoinEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BesoinEnteteVentes modif(BesoinEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEnteteLight");
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

   public BesoinEnteteVentes modif(BesoinEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from BesoinEnteteVentes where besId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from BesoinEnteteVentes order by besId desc").setMaxResults(1);
      long var4 = 1L;
      if (var3.list() != null) {
         List var6 = var3.list();
         if (var6.size() > 0) {
            BesoinEnteteVentes var7 = (BesoinEnteteVentes)var6.get(0);
            var4 = 1L + var7.getBesId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public BesoinEnteteVentes selectByNum(Session var1, String var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var3 = true;
      }

      BesoinEnteteVentes var4 = new BesoinEnteteVentes();
      Query var5 = var1.createQuery("from BesoinEnteteVentes where besNum =:numero");
      var5.setParameter("numero", var2);
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = (BesoinEnteteVentes)var6.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public BesoinEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from BesoinEnteteVentes where exerciceventes.exevteId=:id and besSerie =:ser and year(besDate)=" + var7 + " order by besDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      BesoinEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (BesoinEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public BesoinEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from BesoinEnteteVentes where exerciceventes.exevteId=:id and besSerie =:ser and year(besDate)=" + var7 + " and month(besDate)=" + var8 + " order by besDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      BesoinEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (BesoinEnteteVentes)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, int var6, String var7, String var8, String var9, String var10, long var11, int var13, String var14, String var15, String var16, String var17, String var18, String var19) throws HibernateException, NamingException, ParseException {
      boolean var20 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var20 = true;
      }

      UtilDate var21 = new UtilDate();
      new ArrayList();
      Criteria var23 = var1.createCriteria(BesoinEnteteVentes.class);
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
            System.out.println("d1 " + var25 + " d2 " + var26);
            var23 = var23.add(Restrictions.between("besDate", var25, var26));
         } else {
            var31 = "1980-01-01";
            var21.stringToDateSQL(var31 + " 00:00:00");
            var23 = var23.add(Restrictions.isNotNull("besDate"));
         }
      } else {
         if (!var9.equalsIgnoreCase("12") && !var9.equalsIgnoreCase("13") && !var9.equalsIgnoreCase("14")) {
            var23 = var23.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var9.equalsIgnoreCase("0")) {
            var23 = var23.add(Restrictions.between("besDate", var25, var26));
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
            var23 = var23.add(Restrictions.between("besDate", var25, var26));
         } else {
            int var35;
            if (var9.equalsIgnoreCase("2")) {
               var35 = var24.get(2) + 1;
               var32 = var30 + "-" + var35 + "-01";
               var25 = var21.stringToDateSQL(var32 + " 00:00:00");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
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

               var23 = var23.add(Restrictions.between("besDate", var25, var26));
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

               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("5")) {
               var31 = var30 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-03-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("6")) {
               var31 = var30 + "-04-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-06-30";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("7")) {
               var31 = var30 + "-07-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-09-30";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("8")) {
               var31 = var30 + "-10-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("9")) {
               var31 = var30 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-06-30";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("10")) {
               var31 = var30 + "-07-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("11")) {
               var31 = var30 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("12")) {
               var31 = "1980-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 - 1 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("13")) {
               var31 = var30 - 1 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            } else if (var9.equalsIgnoreCase("14")) {
               var31 = var30 - 1 + "-01-01";
               var25 = var21.stringToDateSQL(var31 + " 00:00:00");
               var32 = var30 - 1 + "-12-31";
               var26 = var21.stringToDateSQL(var32 + " 23:59:59");
               var23 = var23.add(Restrictions.between("besDate", var25, var26));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var31 = "%" + var4 + "%";
         var23 = var23.add(Restrictions.like("besNum", var31));
      }

      if (var5 != null && !var5.isEmpty()) {
         var31 = "%" + var5 + "%";
         var23 = var23.add(Restrictions.like("besNomTiers", var31));
      }

      if (var14 != null && !var14.isEmpty()) {
         var23 = var23.add(Restrictions.eq("besNomContact", var14));
      }

      if (var15 != null && !var15.isEmpty()) {
         var23 = var23.add(Restrictions.eq("besNomResponsable", var15));
      }

      if (var16 != null && !var16.isEmpty()) {
         var23 = var23.add(Restrictions.eq("besNomCommercial", var16));
      }

      if (var13 == 1 || var13 == 2) {
         var23 = var23.add(Restrictions.eq("besIdCreateur", var11));
      }

      String[] var36;
      if (!var7.equalsIgnoreCase("100")) {
         if (var7.contains(",")) {
            var36 = var7.split(",");
            int var38 = var36.length;
            String[] var33 = new String[var38];

            for(int var34 = 0; var34 < var38; ++var34) {
               var33[var34] = new String(var36[var34]);
            }

            var23 = var23.add(Restrictions.in("besSerie", var33));
         } else {
            var23 = var23.add(Restrictions.eq("besSerie", var7));
         }
      }

      if (!var8.equalsIgnoreCase("100")) {
         var23 = var23.add(Restrictions.eq("besCat", var8));
      }

      if (var6 <= 10) {
         var23 = var23.add(Restrictions.eq("besEtat", var6));
      } else if (var6 == 11) {
         var23 = var23.add(Restrictions.isNotNull("besDateRelance"));
      } else if (var6 == 12) {
         var23 = var23.add(Restrictions.eq("besTotHt", 0.0D));
      } else if (var6 == 13) {
         var23 = var23.add(Restrictions.eq("besSolde", 0));
      } else if (var6 == 14) {
         var23 = var23.add(Restrictions.eq("besSolde", 1));
      } else if (var6 == 15) {
         var23 = var23.add(Restrictions.eq("besExoTva", 1));
      }

      if (var10 != null && !var10.isEmpty() && !var10.equalsIgnoreCase("100") && var10.contains(":")) {
         var23 = var23.add(Restrictions.eq("besService", var10));
      }

      if (!var17.equalsIgnoreCase("100")) {
         var36 = var17.split(":");
         var32 = var36[0];
         var23 = var23.add(Restrictions.eq("besActivite", var32));
      }

      var23 = var23.addOrder(Order.desc("besNum"));
      List var37 = var23.list();
      if (var20) {
         this.utilInitHibernate.closeSession();
      }

      return var37;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from BesoinEnteteVentes where besService='" + var1 + "' and (besDateEcheReg='" + var5 + "' or besTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from BesoinEnteteVentes where besDateEcheReg='" + var5 + "' or besTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public BesoinEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BesoinEnteteVentes where besId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new BesoinEnteteVentes();
      BesoinEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (BesoinEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
      Query var4 = var3.createQuery("from BesoinEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public BesoinEnteteVentes pourParapheurByNum(String var1, String var2, Session var3) {
      new BesoinEnteteVentes();
      Query var5 = var3.createQuery("from BesoinEnteteVentes where besNum=:num and besSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      BesoinEnteteVentes var4;
      if (var6.size() != 0) {
         var4 = (BesoinEnteteVentes)var6.get(0);
      } else {
         var4 = null;
      }

      return var4;
   }

   public List rechercheBesoinAPayerCriterion(String var1, Session var2) throws ParseException {
      new ArrayList();
      String var4 = "";
      Criteria var5 = var2.createCriteria(BesoinEnteteVentes.class);
      new ArrayList();
      var5 = var5.add(Restrictions.or(Restrictions.eq("besTypeReg", 0), Restrictions.eq("besTypeReg", 4)));
      if (!var1.equalsIgnoreCase("100")) {
         System.out.println("recherche sans service ");
      } else {
         var5 = var5.add(Restrictions.eq("besService", var1));
      }

      List var3 = var5.list();
      System.out.println("nombre de resultat retourné ds besoin " + var3.size());
      return var3;
   }

   public List rechercheMaintenance(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var2 = true;
      }

      new ArrayList();
      String var4 = "";
      Date var5 = new Date();
      UtilDate var6 = new UtilDate();
      var6.dateToStringSQLLight(var5);
      List var7 = var1.createQuery("from BesoinEnteteVentes").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheBesoinRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from BesoinEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheBesoinByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BesoinEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from BesoinEnteteVentes where besDate>=:deb and besDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
