package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienTravauxEntete;
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

public class BienTravauxEnteteDao implements Serializable {
   private BienTravauxEntete bienTravauxEntete;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienTravauxEnteteDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BienTravauxEntete insert(BienTravauxEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public BienTravauxEntete insert(BienTravauxEntete var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BienTravauxEntete modif(BienTravauxEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public BienTravauxEntete modif(BienTravauxEntete var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(BienTravauxEntete var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
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

   public void delete(BienTravauxEntete var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public List recherche(Session var1, long var2, String var4, String var5, int var6, String var7, String var8, long var9, int var11, String var12, String var13, String var14) throws HibernateException, NamingException, ParseException {
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var15 = true;
      }

      UtilDate var16 = new UtilDate();
      new ArrayList();
      Criteria var18 = var1.createCriteria(BienTravauxEntete.class);
      Calendar var19 = Calendar.getInstance();
      Date var20 = null;
      Date var21 = null;
      Date var22 = new Date();
      String var23 = var16.dateToStringFr(var22);
      String var24 = var23.substring(6, 10) + "-" + var23.substring(3, 5) + "-" + var23.substring(0, 2);
      var20 = var16.stringToDateSQLLight(var24);
      var21 = var16.stringToDateSQLLight(var24);
      int var25 = var22.getYear() + 1900;
      String var26;
      if (var8.equalsIgnoreCase("100")) {
         if (var13 != null && var14 != null) {
            var20 = var16.stringToDateSQLLight(var13);
            var21 = var16.stringToDateSQLLight(var14);
            var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
         } else {
            var26 = "1980-01-01";
            var16.stringToDateSQLLight(var26);
            var18 = var18.add(Restrictions.isNotNull("bietraentDateDebut"));
         }
      } else {
         if (!var8.equalsIgnoreCase("12") && !var8.equalsIgnoreCase("13") && !var8.equalsIgnoreCase("14")) {
         }

         if (var8.equalsIgnoreCase("0")) {
            var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
         } else if (var8.equalsIgnoreCase("1")) {
            var26 = "" + var19.getTime();
            if (var26.contains("Mon")) {
               var20 = var19.getTime();
            } else if (var26.contains("Tue")) {
               var19.add(7, -1);
               var20 = var19.getTime();
            } else if (var26.contains("Wed")) {
               var19.add(7, -2);
               var20 = var19.getTime();
            } else if (var26.contains("Thu")) {
               var19.add(7, -3);
               var20 = var19.getTime();
            } else if (var26.contains("Fri")) {
               var19.add(7, -4);
               var20 = var19.getTime();
            } else if (var26.contains("Sat")) {
               var19.add(7, -5);
               var20 = var19.getTime();
            } else if (var26.contains("Sun")) {
               var19.add(7, -6);
               var20 = var19.getTime();
            }

            var23 = var16.dateToStringFr(var20);
            var24 = var23.substring(6, 10) + "-" + var23.substring(3, 5) + "-" + var23.substring(0, 2);
            var20 = var16.stringToDateSQLLight(var24);
            var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
         } else {
            String var27;
            int var30;
            if (var8.equalsIgnoreCase("2")) {
               var30 = var19.get(2) + 1;
               var27 = var25 + "-" + var30 + "-01";
               var20 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("3")) {
               var30 = var19.get(2);
               var19.add(5, -var30);
               if (var30 <= 3) {
                  var27 = var25 + "-01-01";
                  var20 = var16.stringToDateSQLLight(var27);
               } else if (var30 >= 4 && var30 <= 6) {
                  var27 = var25 + "-04-01";
                  var20 = var16.stringToDateSQLLight(var27);
               } else if (var30 >= 7 && var30 <= 9) {
                  var27 = var25 + "-07-01";
                  var20 = var16.stringToDateSQLLight(var27);
               } else if (var30 >= 10) {
                  var27 = var25 + "-10-01";
                  var20 = var16.stringToDateSQLLight(var27);
               }

               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("4")) {
               var30 = var19.get(2);
               var19.add(5, -var30);
               if (var30 <= 6) {
                  var27 = var25 + "-01-01";
                  var20 = var16.stringToDateSQLLight(var27);
               } else {
                  var27 = var25 + "-07-01";
                  var20 = var16.stringToDateSQLLight(var27);
               }

               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("5")) {
               var26 = var25 + "-01-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-03-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("6")) {
               var26 = var25 + "-04-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-06-30";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("7")) {
               var26 = var25 + "-07-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-09-30";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("8")) {
               var26 = var25 + "-10-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("9")) {
               var26 = var25 + "-01-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-06-30";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("10")) {
               var26 = var25 + "-07-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("11")) {
               var26 = var25 + "-01-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("12")) {
               var26 = "1980-01-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 - 1 + "-12-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("13")) {
               var26 = var25 - 1 + "-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("14")) {
               var26 = var25 - 1 + "-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 - 1 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("bietraentDateDebut", var20, var21));
            } else if (var8.equalsIgnoreCase("20")) {
               var18.setMaxResults(20);
               var18 = var18.addOrder(Order.desc("bietraentId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var26 = "%" + var4 + "%";
         var18 = var18.add(Restrictions.like("bietraentNum", var26));
      }

      if (var5 != null && !var5.isEmpty()) {
         var26 = "";
         if (var5.startsWith("*")) {
            var26 = "%" + var5.substring(1) + "%";
         } else {
            var26 = var5 + "%";
         }

         var18 = var18.add(Restrictions.like("bietraentCodeBien", var26));
      }

      if (var12 != null && !var12.isEmpty()) {
         var18 = var18.add(Restrictions.eq("bietraentNomResponsable", var12));
      }

      if (var11 == 1) {
         var18 = var18.add(Restrictions.eq("bietraentUserCreat", var9));
      }

      if (!var7.equalsIgnoreCase("100")) {
         if (var7.contains(",")) {
            String[] var31 = var7.split(",");
            int var32 = var31.length;
            String[] var28 = new String[var32];

            for(int var29 = 0; var29 < var32; ++var29) {
               var28[var29] = new String(var31[var29]);
            }

            var18 = var18.add(Restrictions.in("bietraentSerie", var28));
         } else {
            var18 = var18.add(Restrictions.eq("bietraentSerie", var7));
         }
      }

      if (var6 <= 10) {
         var18 = var18.add(Restrictions.eq("bietraentEtat", var6));
      }

      var18 = var18.addOrder(Order.desc("bietraentDateDebut"));
      var18 = var18.addOrder(Order.desc("bietraentNum"));
      List var33 = var18.list();
      if (var15) {
         this.utilInitHibernate.closeSession();
      }

      return var33;
   }

   public List chargerTravauxByBien(Bien var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienTravauxEntete where Bien=:bi").setParameter("bi", var1);
      new ArrayList();
      List var5 = var4.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerTravauxByBien(Bien var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      Query var6 = var4.createQuery("from BienTravauxEntete where Bien=:bi and bietraentDateDebut>=:dteDeb and bietraentDateDebut<=:dteFin").setParameter("bi", var1).setDate("dteDeb", var2).setDate("dteFin", var3);
      new ArrayList();
      List var7 = var6.list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List chargerTravauxByBien(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienTravauxEntete where bietraentDateDebut>=:dteDeb and bietraentDateDebut<=:dteFin").setDate("dteDeb", var1).setDate("dteFin", var2);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargeTravaux(int var1, int var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      String var6 = "";
      if (var3 != null && !var3.isEmpty()) {
         if (var3.equals("*")) {
            var6 = "";
         } else if (var3.startsWith("*") && var3.length() >= 2) {
            var6 = " and (bietraentNum like '" + var3.substring(1) + "%' or bietraentObjet like '%" + var3.substring(1) + "%')";
         } else {
            var6 = " and (bietraentNum like '" + var3 + "%' or bietraentObjet like '%" + var3 + "%')";
         }
      }

      String var7 = "";
      if (var2 == 9) {
         if (var1 == 0) {
            var7 = "(Bien.bieCategorie=0 or Bien.bieCategorie=3 or Bien.bieCategorie=4 or Bien.bieCategorie=6)";
         } else if (var1 == 1) {
            var7 = "(Bien.bieCategorie=1 or Bien.bieCategorie=3 or Bien.bieCategorie=5 or Bien.bieCategorie=6)";
         } else if (var1 == 2) {
            var7 = "(Bien.bieCategorie=2 or Bien.bieCategorie=4 or Bien.bieCategorie=6)";
         } else {
            var7 = "Bien.bieCategorie>=0 and Bien.bieCategorie<=6";
         }
      } else if (var1 == 0) {
         var7 = "(Bien.bieCategorie=0 or Bien.bieCategorie=3 or Bien.bieCategorie=4 or Bien.bieCategorie=6) and Bien.bieGestion=" + var2;
      } else if (var1 == 1) {
         var7 = "(Bien.bieCategorie=1 or Bien.bieCategorie=3 or Bien.bieCategorie=5 or Bien.bieCategorie=6) and Bien.bieGestion=" + var2;
      } else if (var1 == 2) {
         var7 = "(Bien.bieCategorie=2 or Bien.bieCategorie=4 or Bien.bieCategorie=6) and Bien.bieGestion=" + var2;
      } else {
         var7 = "Bien.bieCategorie>=0 and Bien.bieCategorie<=6 and Bien.bieGestion=" + var2;
      }

      List var8 = var4.createQuery("from BienTravauxEntete where " + var7 + var6).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public BienTravauxEntete pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienTravauxEntete where bietraentId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new BienTravauxEntete();
      BienTravauxEntete var7;
      if (var6.size() != 0) {
         var7 = (BienTravauxEntete)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectRdv(Date var1, Date var2, int var3, int var4, Session var5) throws HibernateException, NamingException, ParseException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      List var7 = null;
      if (var4 == 10) {
         if (var3 == 99) {
            var7 = var5.createQuery("from BienTravauxEntete where (bietraentEtat=1 or bietraentEtat=4 or bietraentEtat=5) and (bietraentEtatLivraison=0 or bietraentEtatLivraison=3 or bietraentEtatLivraison=4 or bietraentEtatLivraison=7) and (bietraentModeLivraison=0 or bietraentModeLivraison=1 or bietraentModeLivraison=2) and bietraentDateLivraison>=:deb and bietraentDateLivraison<=:fin").setDate("deb", var1).setDate("fin", var2).list();
         } else {
            var7 = var5.createQuery("from BienTravauxEntete where (bietraentEtat=1 or bietraentEtat=4 or bietraentEtat=5) and (bietraentEtatLivraison=0 or bietraentEtatLivraison=3 or bietraentEtatLivraison=4 or bietraentEtatLivraison=7) and bietraentModeLivraison=:mode and bietraentDateLivraison>=:deb and bietraentDateLivraison<=:fin").setDate("deb", var1).setDate("fin", var2).setInteger("mode", var3).list();
         }
      } else if (var3 == 99) {
         var7 = var5.createQuery("from BienTravauxEntete where (bietraentEtat=1 or bietraentEtat=4 or bietraentEtat=5) and bietraentEtatLivraison=:stat and (bietraentModeLivraison=0 or bietraentModeLivraison=1 or bietraentModeLivraison=2) and bietraentDateLivraison>=:deb and bietraentDateLivraison<=:fin").setDate("deb", var1).setDate("fin", var2).setInteger("stat", var4).list();
      } else {
         var7 = var5.createQuery("from BienTravauxEntete where (bietraentEtat=1 or bietraentEtat=4 or bietraentEtat=5) and bietraentEtatLivraison=:stat and bietraentModeLivraison=:mode and bietraentDateLivraison>=:deb and bietraentDateLivraison<=:fin").setDate("deb", var1).setDate("fin", var2).setInteger("mode", var3).setInteger("stat", var4).list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
