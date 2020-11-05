package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.ExercicesVentes;
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

public class ContratEnteteVentesDao implements Serializable {
   private ContratEnteteVentes contratEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ContratEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ContratEnteteVentes insert(ContratEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
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

   public ContratEnteteVentes insert(ContratEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ContratEnteteVentes modif(ContratEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
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

   public ContratEnteteVentes modif(ContratEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from ContratEnteteVentes where crtId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ContratEnteteVentes order by crtId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            ContratEnteteVentes var7 = (ContratEnteteVentes)var6.get(0);
            var4 = 1L + var7.getCrtId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ContratEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from ContratEnteteVentes where exerciceventes.exevteId=:id and crtSerie =:ser and year(crtDate)=" + var7 + " order by crtDate desc").setParameter("id", var1).setParameter("ser", var3);
      ContratEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (ContratEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public ContratEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from ContratEnteteVentes where exerciceventes.exevteId=:id and crtSerie =:ser and year(crtDate)=" + var7 + " and month(crtDate)=" + var8 + " order by crtDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      ContratEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (ContratEnteteVentes)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, long var5, String var7, int var8, String var9, String var10, String var11, long var12, int var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27) throws HibernateException, NamingException, ParseException {
      boolean var28 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var28 = true;
      }

      UtilDate var29 = new UtilDate();
      new ArrayList();
      Criteria var31 = var1.createCriteria(ContratEnteteVentes.class);
      Calendar var32 = Calendar.getInstance();
      Date var33 = null;
      Date var34 = null;
      Date var35 = new Date();
      String var36 = var29.dateToStringFr(var35);
      String var37 = var36.substring(6, 10) + "-" + var36.substring(3, 5) + "-" + var36.substring(0, 2);
      var33 = var29.stringToDateSQL(var37 + " 00:00:00");
      var34 = var29.stringToDateSQL(var37 + " 23:59:59");
      int var38 = var35.getYear() + 1900;
      String var39;
      String var40;
      if (var11.equalsIgnoreCase("100")) {
         if (var20 != null && var21 != null) {
            var33 = var29.stringToDateSQL(var20 + " 00:00:00");
            var34 = var29.stringToDateSQL(var21 + " 23:59:59");
            var31 = var31.add(Restrictions.between("crtDate", var33, var34));
         } else {
            var39 = "1980-01-01";
            var29.stringToDateSQL(var39 + " 00:00:00");
            var31 = var31.add(Restrictions.isNotNull("crtDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var31 = var31.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var31 = var31.add(Restrictions.between("crtDate", var33, var34));
         } else if (var11.equalsIgnoreCase("1")) {
            var39 = "" + var32.getTime();
            if (var39.contains("Mon")) {
               var33 = var32.getTime();
            } else if (var39.contains("Tue")) {
               var32.add(7, -1);
               var33 = var32.getTime();
            } else if (var39.contains("Wed")) {
               var32.add(7, -2);
               var33 = var32.getTime();
            } else if (var39.contains("Thu")) {
               var32.add(7, -3);
               var33 = var32.getTime();
            } else if (var39.contains("Fri")) {
               var32.add(7, -4);
               var33 = var32.getTime();
            } else if (var39.contains("Sat")) {
               var32.add(7, -5);
               var33 = var32.getTime();
            } else if (var39.contains("Sun")) {
               var32.add(7, -6);
               var33 = var32.getTime();
            }

            var36 = var29.dateToStringFr(var33);
            var37 = var36.substring(6, 10) + "-" + var36.substring(3, 5) + "-" + var36.substring(0, 2);
            var33 = var29.stringToDateSQL(var37 + " 00:00:00");
            var31 = var31.add(Restrictions.between("crtDate", var33, var34));
         } else {
            int var43;
            if (var11.equalsIgnoreCase("2")) {
               var43 = var32.get(2) + 1;
               var40 = var38 + "-" + var43 + "-01";
               var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("3")) {
               var43 = var32.get(2);
               var32.add(5, -var43);
               if (var43 <= 3) {
                  var40 = var38 + "-01-01";
                  var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               } else if (var43 >= 4 && var43 <= 6) {
                  var40 = var38 + "-04-01";
                  var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               } else if (var43 >= 7 && var43 <= 9) {
                  var40 = var38 + "-07-01";
                  var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               } else if (var43 >= 10) {
                  var40 = var38 + "-10-01";
                  var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               }

               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("4")) {
               var43 = var32.get(2);
               var32.add(5, -var43);
               if (var43 <= 6) {
                  var40 = var38 + "-01-01";
                  var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               } else {
                  var40 = var38 + "-07-01";
                  var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               }

               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("5")) {
               var39 = var38 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-03-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("6")) {
               var39 = var38 + "-04-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-06-30";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("7")) {
               var39 = var38 + "-07-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-09-30";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("8")) {
               var39 = var38 + "-10-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("9")) {
               var39 = var38 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-06-30";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("10")) {
               var39 = var38 + "-07-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("11")) {
               var39 = var38 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("12")) {
               var39 = "1980-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 - 1 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("13")) {
               var39 = var38 - 1 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("14")) {
               var39 = var38 - 1 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 - 1 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("crtDate", var33, var34));
            } else if (var11.equalsIgnoreCase("20")) {
               var31.setMaxResults(20);
               var31 = var31.addOrder(Order.desc("crtId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var39 = "%" + var4 + "%";
         var31 = var31.add(Restrictions.like("crtNum", var39));
      }

      if (var5 != 0L) {
         var31 = var31.add(Restrictions.eq("tiers.tieid", var5));
      } else if (var7 != null && !var7.isEmpty()) {
         var39 = "%" + var7 + "%";
         var31 = var31.add(Restrictions.or(Restrictions.like("crtNomTiers", var39), Restrictions.like("crtDiversNom", var39)));
      }

      if (var15 != null && !var15.isEmpty()) {
         var31 = var31.add(Restrictions.eq("crtNomContact", var15));
      }

      if (var16 != null && !var16.isEmpty()) {
         var31 = var31.add(Restrictions.eq("crtNomResponsable", var16));
      }

      if (var17 != null && !var17.isEmpty()) {
         var31 = var31.add(Restrictions.eq("crtNomCommercial", var17));
      }

      if (var14 == 1 || var14 == 2) {
         var31 = var31.add(Restrictions.eq("crtIdCreateur", var12));
      }

      String[] var44;
      if (!var9.equalsIgnoreCase("100")) {
         if (var9.contains(",")) {
            var44 = var9.split(",");
            int var45 = var44.length;
            String[] var41 = new String[var45];

            for(int var42 = 0; var42 < var45; ++var42) {
               var41[var42] = new String(var44[var42]);
            }

            var31 = var31.add(Restrictions.in("crtSerie", var41));
         } else {
            var31 = var31.add(Restrictions.eq("crtSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         var31 = var31.add(Restrictions.eq("crtCat", var10));
      }

      if (var8 <= 10) {
         var31 = var31.add(Restrictions.eq("crtEtat", var8));
      }

      if (!var18.equalsIgnoreCase("100")) {
         var44 = var18.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("crtActivite", var40));
      }

      if (var22 != null && !var22.isEmpty() && var22.contains(":")) {
         var44 = var22.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("crtRegion", var40));
      }

      if (var23 != null && !var23.isEmpty() && var23.contains(":")) {
         var44 = var23.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("crtSecteur", var40));
      }

      if (var24 != null && !var24.isEmpty() && var24.contains(":")) {
         var44 = var24.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("crtPdv", var40));
      }

      if (var25 != null && !var25.isEmpty()) {
         var31 = var31.add(Restrictions.eq("crtSite", var25));
      }

      if (var26 != null && !var26.isEmpty()) {
         var31 = var31.add(Restrictions.eq("crtDepartement", var26));
      }

      if (var27 != null && !var27.isEmpty()) {
         var31 = var31.add(Restrictions.eq("crtService", var27));
      }

      var31 = var31.addOrder(Order.asc("crtDate"));
      var31 = var31.addOrder(Order.asc("crtNum"));
      List var46 = var31.list();
      if (var28) {
         this.utilInitHibernate.closeSession();
      }

      return var46;
   }

   public List rechercheFactureByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from ContratEnteteVentes where crtDate>=:deb and crtDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureByDate(Date var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         String var7 = "";
         if (var2.contains(":")) {
            String[] var8 = var2.split(":");
            var7 = var8[0];
         } else {
            var7 = var2;
         }

         var6 = var3.createQuery("from ContratEnteteVentes where tiers.tieregion=:reg and crtDateDebut is not null and crtDateDebut<=:deb and crtEtat=1").setString("reg", var7).setDate("deb", var1).list();
      } else {
         var6 = var3.createQuery("from ContratEnteteVentes where crtDateDebut is not null and crtDateDebut<=:deb and crtEtat=1").setDate("deb", var1).list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ContratEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ContratEnteteVentes where crtId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new ContratEnteteVentes();
      ContratEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (ContratEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ContratEnteteVentes pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ContratEnteteVentes where crtNum =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new ContratEnteteVentes();
      ContratEnteteVentes var6;
      if (var5.size() != 0) {
         var6 = (ContratEnteteVentes)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ContratEnteteVentes where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
      Query var4 = var3.createQuery("from ContratEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ContratEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var4 = true;
      }

      List var5 = var2.createQuery("from ContratEnteteVentes where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheContratPeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var5 = true;
      }

      List var6 = var3.createQuery("from ContratEnteteVentes where crtDate>=:d1 and crtDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheContratActif(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      List var4 = var1.createQuery("from ContratEnteteVentes where crtEtat=1").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheToutContrat(Session var1) throws HibernateException, NamingException {
      new ArrayList();
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BcontratEnteteLight");
         var3 = true;
      }

      List var4 = var1.createQuery("from ContratEnteteVentes").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }
}
