package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteMedical;
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

public class FactureEnteteMedicalDao implements Serializable {
   private FactureEnteteMedical factureEnteteMedical;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FactureEnteteMedicalDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FactureEnteteMedical insert(FactureEnteteMedical var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FactureEnteteMedical modif(FactureEnteteMedical var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
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

   public FactureEnteteMedical modif(FactureEnteteMedical var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from FactureEnteteMedical where facId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from FactureEnteteMedical order by facId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            FactureEnteteMedical var7 = (FactureEnteteMedical)var6.get(0);
            var4 = 1L + var7.getFacId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public FactureEnteteMedical enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from FactureEnteteMedical where exerciceventes.exevteId=:id and facSerie =:ser and year(facDate)=" + var7 + " order by facDate desc").setParameter("id", var1).setParameter("ser", var3);
      FactureEnteteMedical var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (FactureEnteteMedical)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public FactureEnteteMedical enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from FactureEnteteMedical where exerciceventes.exevteId=:id and facSerie =:ser and year(facDate)=" + var7 + " and month(facDate)=" + var8 + " order by facDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      FactureEnteteMedical var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (FactureEnteteMedical)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, int var5, String var6, int var7, String var8, String var9, String var10, long var11, int var13, String var14, String var15, String var16) throws HibernateException, NamingException, ParseException {
      boolean var17 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var17 = true;
      }

      UtilDate var18 = new UtilDate();
      new ArrayList();
      Criteria var20 = var1.createCriteria(FactureEnteteMedical.class);
      Calendar var21 = Calendar.getInstance();
      Date var22 = null;
      Date var23 = null;
      Date var24 = new Date();
      String var25 = var18.dateToStringFr(var24);
      String var26 = var25.substring(6, 10) + "-" + var25.substring(3, 5) + "-" + var25.substring(0, 2);
      var22 = var18.stringToDateSQL(var26 + " 00:00:00");
      var23 = var18.stringToDateSQL(var26 + " 23:59:59");
      int var27 = var24.getYear() + 1900;
      String var28;
      if (var9.equalsIgnoreCase("100")) {
         if (var15 != null && var16 != null) {
            var22 = var18.stringToDateSQL(var15 + " 00:00:00");
            var23 = var18.stringToDateSQL(var16 + " 23:59:59");
            var20 = var20.add(Restrictions.between("facDate", var22, var23));
         } else {
            var28 = "1980-01-01";
            var18.stringToDateSQL(var28 + " 00:00:00");
            var20 = var20.add(Restrictions.isNotNull("facDate"));
         }
      } else {
         if (!var9.equalsIgnoreCase("12") && !var9.equalsIgnoreCase("13") && !var9.equalsIgnoreCase("14")) {
            var20 = var20.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var9.equalsIgnoreCase("0")) {
            var20 = var20.add(Restrictions.between("facDate", var22, var23));
         } else if (var9.equalsIgnoreCase("1")) {
            var28 = "" + var21.getTime();
            if (var28.contains("Mon")) {
               var22 = var21.getTime();
            } else if (var28.contains("Tue")) {
               var21.add(7, -1);
               var22 = var21.getTime();
            } else if (var28.contains("Wed")) {
               var21.add(7, -2);
               var22 = var21.getTime();
            } else if (var28.contains("Thu")) {
               var21.add(7, -3);
               var22 = var21.getTime();
            } else if (var28.contains("Fri")) {
               var21.add(7, -4);
               var22 = var21.getTime();
            } else if (var28.contains("Sat")) {
               var21.add(7, -5);
               var22 = var21.getTime();
            } else if (var28.contains("Sun")) {
               var21.add(7, -6);
               var22 = var21.getTime();
            }

            var25 = var18.dateToStringFr(var22);
            var26 = var25.substring(6, 10) + "-" + var25.substring(3, 5) + "-" + var25.substring(0, 2);
            var22 = var18.stringToDateSQL(var26 + " 00:00:00");
            var20 = var20.add(Restrictions.between("facDate", var22, var23));
         } else {
            String var29;
            int var32;
            if (var9.equalsIgnoreCase("2")) {
               var32 = var21.get(2) + 1;
               var29 = var27 + "-" + var32 + "-01";
               var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("3")) {
               var32 = var21.get(2);
               var21.add(5, -var32);
               if (var32 <= 3) {
                  var29 = var27 + "-01-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               } else if (var32 >= 4 && var32 <= 6) {
                  var29 = var27 + "-04-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               } else if (var32 >= 7 && var32 <= 9) {
                  var29 = var27 + "-07-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               } else if (var32 >= 10) {
                  var29 = var27 + "-10-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               }

               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("4")) {
               var32 = var21.get(2);
               var21.add(5, -var32);
               if (var32 <= 6) {
                  var29 = var27 + "-01-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               } else {
                  var29 = var27 + "-07-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               }

               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("5")) {
               var28 = var27 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-03-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("6")) {
               var28 = var27 + "-04-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-06-30";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("7")) {
               var28 = var27 + "-07-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-09-30";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("8")) {
               var28 = var27 + "-10-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("9")) {
               var28 = var27 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-06-30";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("10")) {
               var28 = var27 + "-07-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("11")) {
               var28 = var27 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("12")) {
               var28 = "1980-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 - 1 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("13")) {
               var28 = var27 - 1 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("14")) {
               var28 = var27 - 1 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 - 1 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("facDate", var22, var23));
            } else if (var9.equalsIgnoreCase("20")) {
               var20.setMaxResults(20);
               var20 = var20.addOrder(Order.desc("facId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var28 = "%" + var4 + "%";
         var20 = var20.add(Restrictions.like("facNum", var28));
      }

      if (var5 != 0) {
         var20 = var20.add(Restrictions.eq("facNumRecap", var5));
      }

      if (var6 != null && !var6.isEmpty()) {
         var20 = var20.add(Restrictions.eq("facNomTiers", var6));
      }

      String[] var33;
      if (var6 != null && !var6.isEmpty() && var6.contains(":")) {
         var33 = var6.split(":");
         long var35 = Long.parseLong(var33[0]);
         var20 = var20.add(Restrictions.eq("tiers.tieid", var35));
      }

      if (var14 != null && !var14.isEmpty()) {
         var20 = var20.add(Restrictions.eq("facNomCommercial", var14));
      }

      if (var13 == 1 || var13 == 2) {
         var20 = var20.add(Restrictions.eq("facIdCreateur", var11));
      }

      if (!var8.equalsIgnoreCase("100")) {
         if (var8.contains(",")) {
            var33 = var8.split(",");
            int var36 = var33.length;
            String[] var30 = new String[var36];

            for(int var31 = 0; var31 < var36; ++var31) {
               var30[var31] = new String(var33[var31]);
            }

            var20 = var20.add(Restrictions.in("facSerie", var30));
         } else {
            var20 = var20.add(Restrictions.eq("facSerie", var8));
         }
      }

      if (var7 <= 10 && var7 != 1) {
         var20 = var20.add(Restrictions.eq("facEtat", var7));
      } else if (var7 == 1) {
         var20 = var20.add(Restrictions.and(Restrictions.eq("facEtat", 1), Restrictions.eq("facNumRecap", 0)));
      } else if (var7 == 11) {
         var20 = var20.add(Restrictions.isNotNull("facDateRelance"));
      } else if (var7 == 12) {
         var20 = var20.add(Restrictions.eq("facTotHt", 0.0D));
      } else if (var7 == 13) {
         var20 = var20.add(Restrictions.eq("facSolde", 0));
      } else if (var7 == 14) {
         var20 = var20.add(Restrictions.eq("facSolde", 1));
      } else if (var7 == 15) {
         var20 = var20.add(Restrictions.eq("facExoTva", 1));
      } else if (var7 == 16) {
         var20 = var20.add(Restrictions.and(Restrictions.eq("facExoTva", 1), Restrictions.isNull("facDateVisa")));
      } else if (var7 == 17) {
         var20 = var20.add(Restrictions.isNotNull("facDateTransfert"));
      } else if (var7 == 18) {
         var20 = var20.add(Restrictions.isNull("facDateTransfert"));
      } else if (var7 == 19) {
         var20 = var20.add(Restrictions.and(Restrictions.eq("facEtat", 1), Restrictions.ne("facNumRecap", 0)));
      }

      if (var10 != null && !var10.isEmpty() && !var10.equalsIgnoreCase("100") && var10.contains(":")) {
         var20 = var20.add(Restrictions.eq("facService", var10));
      }

      var20 = var20.addOrder(Order.desc("facDate"));
      var20 = var20.addOrder(Order.desc("facNum"));
      List var34 = var20.list();
      if (var17) {
         this.utilInitHibernate.closeSession();
      }

      return var34;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from FactureEnteteMedical where facService='" + var1 + "' and (facDateEcheReg='" + var5 + "' or facTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from FactureEnteteMedical where facDateEcheReg='" + var5 + "' or facTypeReg=4").list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheByRecap(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureEnteteMedical where facNumRecap='" + var1 + "' and facEtat=1 order by facNum").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheDejaPayer(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureEnteteMedical where facTotReglement<>0 and facDate>=:d1 and facDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      UtilDate var7 = new UtilDate();
      String var8 = var7.dateToStringSQLLight(var1) + " 00:00:00";
      String var9 = var7.dateToStringSQLLight(var2) + " 23:59:59";
      var6 = var3.createQuery("from FactureEnteteMedical where facDate>=:deb and facDate<=:fin").setString("deb", var8).setString("fin", var9).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureByDateOrder(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      UtilDate var7 = new UtilDate();
      String var8 = var7.dateToStringSQLLight(var1) + " 00:00:00";
      String var9 = var7.dateToStringSQLLight(var2) + " 23:59:59";
      var6 = var3.createQuery("from FactureEnteteMedical where facDate>=:deb and facDate<=:fin order by facNomTiers").setString("deb", var8).setString("fin", var9).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FactureEnteteMedical pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FactureEnteteMedical where facId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new FactureEnteteMedical();
      FactureEnteteMedical var7;
      if (var6.size() != 0) {
         var7 = (FactureEnteteMedical)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FactureEnteteMedical pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FactureEnteteMedical where facNum=:num and facSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new FactureEnteteMedical();
      FactureEnteteMedical var7;
      if (var6.size() != 0) {
         var7 = (FactureEnteteMedical)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FactureEnteteMedical pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureEnteteMedical where facNum=:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new FactureEnteteMedical();
      FactureEnteteMedical var6;
      if (var5.size() != 0) {
         var6 = (FactureEnteteMedical)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FactureEnteteMedical pourContrat(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureEnteteMedical where facContrat=:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new FactureEnteteMedical();
      FactureEnteteMedical var6;
      if (var5.size() != 0) {
         var6 = (FactureEnteteMedical)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FactureEnteteMedical pourContrat(String var1, Date var2, Date var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var5 = true;
      }

      Query var6 = var4.createQuery("from FactureEnteteMedical where facContrat=:num and facDateDebut=:d1 and facDateFin=:d2").setString("num", var1).setDate("d1", var2).setDate("d2", var3).setMaxResults(1);
      List var7 = var6.list();
      new FactureEnteteMedical();
      FactureEnteteMedical var8;
      if (var7.size() != 0) {
         var8 = (FactureEnteteMedical)var7.get(0);
      } else {
         var8 = null;
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheFactureATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from FactureEnteteMedical where (facEtat=0 or facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from FactureEnteteMedical where (facEtat=0 or facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL and facDate>=:dte1 and facDate<=:dte2 and facNum>=:p1 and facNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from FactureEnteteMedical where (facEtat=0 or facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL and facDate>=:dte1 and facDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from FactureEnteteMedical where (facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from FactureEnteteMedical where (facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL and facDate>=:dte1 and facDate<=:dte2 and facNum>=:p1 and facNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from FactureEnteteMedical where (facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL and facDate>=:dte1 and facDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheFactureDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from FactureEnteteMedical where (facEtat=0 or facEtat=1 or facEtat=4 or facEtat=5) and (facDateTransfert<>'' and facDateTransfert is not null) and (facDate>=:dte1 and facDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from FactureEnteteMedical where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
      Query var4 = var3.createQuery("from FactureEnteteMedical where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureEnteteMedical where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public List rechercheNonSoldeTiers(Tiers var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureEnteteMedical where tiers=:tie and facSolde=0 and facEtat>=1 and facSerie=:ser").setParameter("tie", var1).setString("ser", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureEnteteMedical where tiers=:tie order by facDate").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureEnteteMedical where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCommissions(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureEnteteMedical where facSolde=1 and facDate>=:d1 and facDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFacturePeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureEnteteMedical where facDate>=:d1 and facDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var6 = true;
      }

      List var7 = var4.createQuery("from FactureEnteteMedical where facDate>=:d1 and facSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheFactureAcompte(Tiers var1, long var2, Date var4, String var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      boolean var8 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "Refacturation");
         var8 = true;
      }

      List var9 = var6.createQuery("from FactureEnteteMedical where tiers=:tie and facIdContact=:ctt and facTauxAcompte>0 and facDate<:dte and facObject=:obj").setParameter("tie", var1).setLong("ctt", var2).setDate("dte", var4).setString("obj", var5).list();
      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }
}
