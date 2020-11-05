package com.epegase.systeme.dao;

import com.epegase.systeme.classe.Bien;
import com.epegase.systeme.classe.BienTravauxEntete;
import com.epegase.systeme.classe.BienTravauxLigne;
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

public class BienTravauxLigneDao implements Serializable {
   private BienTravauxLigne bienTravauxLigne;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienTravauxLigneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BienTravauxLigne insert(BienTravauxLigne var1) throws HibernateException, NamingException {
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

   public BienTravauxLigne insert(BienTravauxLigne var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public BienTravauxLigne maj(BienTravauxLigne var1, Session var2) throws HibernateException, NamingException {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public BienTravauxLigne modif(BienTravauxLigne var1) throws HibernateException, NamingException {
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

   public BienTravauxLigne modif(BienTravauxLigne var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(BienTravauxLigne var1) throws HibernateException, NamingException {
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

   public void delete(BienTravauxLigne var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public String deleteAllLigne(BienTravauxEntete var1, Session var2) {
      var2.createQuery("delete from BienTravauxLigne where BienTravauxEntete=:id").setLong("id", var1.getBietraentId()).executeUpdate();
      return "";
   }

   public List recherche(Session var1, long var2, String var4, String var5, int var6, String var7, String var8, long var9, int var11, String var12, String var13, String var14) throws HibernateException, NamingException, ParseException {
      boolean var15 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var15 = true;
      }

      UtilDate var16 = new UtilDate();
      new ArrayList();
      Criteria var18 = var1.createCriteria(BienTravauxLigne.class);
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
            var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
         } else {
            var26 = "1980-01-01";
            var16.stringToDateSQLLight(var26);
            var18 = var18.add(Restrictions.isNotNull("bietraligDateFacture"));
         }
      } else {
         if (!var8.equalsIgnoreCase("12") && !var8.equalsIgnoreCase("13") && !var8.equalsIgnoreCase("14")) {
         }

         if (var8.equalsIgnoreCase("0")) {
            var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
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
            var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
         } else {
            String var27;
            int var28;
            if (var8.equalsIgnoreCase("2")) {
               var28 = var19.get(2) + 1;
               var27 = var25 + "-" + var28 + "-01";
               var20 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("3")) {
               var28 = var19.get(2);
               var19.add(5, -var28);
               if (var28 <= 3) {
                  var27 = var25 + "-01-01";
                  var20 = var16.stringToDateSQLLight(var27);
               } else if (var28 >= 4 && var28 <= 6) {
                  var27 = var25 + "-04-01";
                  var20 = var16.stringToDateSQLLight(var27);
               } else if (var28 >= 7 && var28 <= 9) {
                  var27 = var25 + "-07-01";
                  var20 = var16.stringToDateSQLLight(var27);
               } else if (var28 >= 10) {
                  var27 = var25 + "-10-01";
                  var20 = var16.stringToDateSQLLight(var27);
               }

               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("4")) {
               var28 = var19.get(2);
               var19.add(5, -var28);
               if (var28 <= 6) {
                  var27 = var25 + "-01-01";
                  var20 = var16.stringToDateSQLLight(var27);
               } else {
                  var27 = var25 + "-07-01";
                  var20 = var16.stringToDateSQLLight(var27);
               }

               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("5")) {
               var26 = var25 + "-01-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-03-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("6")) {
               var26 = var25 + "-04-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-06-30";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("7")) {
               var26 = var25 + "-07-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-09-30";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("8")) {
               var26 = var25 + "-10-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("9")) {
               var26 = var25 + "-01-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-06-30";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("10")) {
               var26 = var25 + "-07-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("11")) {
               var26 = var25 + "-01-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("12")) {
               var26 = "1980-01-01";
               var20 = var16.stringToDateSQLLight(var26);
               var27 = var25 - 1 + "-12-31";
               var21 = var16.stringToDateSQLLight(var27);
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("13")) {
               var26 = var25 - 1 + "-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("14")) {
               var26 = var25 - 1 + "-01-01";
               var20 = var16.stringToDateSQL(var26 + " 00:00:00");
               var27 = var25 - 1 + "-12-31";
               var21 = var16.stringToDateSQL(var27 + " 23:59:59");
               var18 = var18.add(Restrictions.between("bietraligDateFacture", var20, var21));
            } else if (var8.equalsIgnoreCase("20")) {
               var18.setMaxResults(20);
               var18 = var18.addOrder(Order.desc("bietraligId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var26 = "%" + var4 + "%";
         var18 = var18.add(Restrictions.like("bietraligNumFacture", var26));
      }

      if (var5 != null && !var5.isEmpty()) {
         var26 = "";
         if (var5.startsWith("*")) {
            var26 = "%" + var5.substring(1) + "%";
         } else {
            var26 = var5 + "%";
         }

         var18 = var18.add(Restrictions.like("bietraligCodeGroupe", var26));
      }

      if (var6 <= 10) {
         var18 = var18.add(Restrictions.eq("bietraligEtat", var6));
      }

      var18 = var18.addOrder(Order.desc("bietraligDateFacture"));
      var18 = var18.addOrder(Order.desc("bietraligNumFacture"));
      List var29 = var18.list();
      if (var15) {
         this.utilInitHibernate.closeSession();
      }

      return var29;
   }

   public List chargerDetail(BienTravauxEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      List var4 = var2.createQuery("from BienTravauxLigne where BienTravauxEntete=:idfk").setParameter("idfk", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerDetailByBien(Bien var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      List var6 = var4.createQuery("from BienTravauxLigne where Bien=:idBien and bietraligDateFacture>=:dteDeb and bietraligDateFacture<=:dteFin").setParameter("idBien", var1).setDate("dteDeb", var2).setDate("dteFin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerDetailByBien(Bien var1, String var2, Date var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      List var7 = var5.createQuery("from BienTravauxLigne where bietraligPoste=:pst and Bien=:idBien and bietraligDateFacture>=:dteDeb and bietraligDateFacture<=:dteFin").setString("pst", var2).setParameter("idBien", var1).setDate("dteDeb", var3).setDate("dteFin", var4).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BienTravauxLigne pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienTravauxLigne where bietraligId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new BienTravauxLigne();
      BienTravauxLigne var7;
      if (var6.size() != 0) {
         var7 = (BienTravauxLigne)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
