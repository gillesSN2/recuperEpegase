package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
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

public class NoteDebitEnteteAchatsDao implements Serializable {
   private NoteDebitEnteteAchats noteDebitEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public NoteDebitEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public NoteDebitEnteteAchats insert(NoteDebitEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public NoteDebitEnteteAchats modif(NoteDebitEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
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

   public NoteDebitEnteteAchats modif(NoteDebitEnteteAchats var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from NoteDebitEnteteAchats where ndfId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from NoteDebitEnteteAchats order by ndfId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            NoteDebitEnteteAchats var7 = (NoteDebitEnteteAchats)var6.get(0);
            var4 = 1L + var7.getNdfId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public NoteDebitEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from NoteDebitEnteteAchats where exercicesAchats.exeachId=:id and ndfSerie =:ser and year(ndfDate)=" + var7 + " order by ndfDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      NoteDebitEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (NoteDebitEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public NoteDebitEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from NoteDebitEnteteAchats where exercicesAchats.exeachId=:id and ndfSerie =:ser and year(ndfDate)=" + var7 + " and month(ndfDate)=" + var8 + " order by ndfDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      NoteDebitEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (NoteDebitEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, long var5, String var7, int var8, String var9, String var10, String var11, String var12, long var13, int var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22) throws HibernateException, NamingException, ParseException {
      boolean var23 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var23 = true;
      }

      UtilDate var24 = new UtilDate();
      new ArrayList();
      Criteria var26 = var1.createCriteria(NoteDebitEnteteAchats.class);
      Calendar var27 = Calendar.getInstance();
      Date var28 = null;
      Date var29 = null;
      Date var30 = new Date();
      String var31 = var24.dateToStringFr(var30);
      String var32 = var31.substring(6, 10) + "-" + var31.substring(3, 5) + "-" + var31.substring(0, 2);
      var28 = var24.stringToDateSQL(var32 + " 00:00:00");
      var29 = var24.stringToDateSQL(var32 + " 23:59:59");
      int var33 = var30.getYear() + 1900;
      String var34;
      String var35;
      if (var11.equalsIgnoreCase("100")) {
         if (var21 != null && var22 != null) {
            var28 = var24.stringToDateSQL(var21 + " 00:00:00");
            var29 = var24.stringToDateSQL(var22 + " 23:59:59");
            var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
         } else {
            var34 = "1980-01-01";
            var24.stringToDateSQL(var34 + " 00:00:00");
            var26 = var26.add(Restrictions.isNotNull("ndfDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var26 = var26.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
         } else if (var11.equalsIgnoreCase("1")) {
            var34 = "" + var27.getTime();
            if (var34.contains("Mon")) {
               var28 = var27.getTime();
            } else if (var34.contains("Tue")) {
               var27.add(7, -1);
               var28 = var27.getTime();
            } else if (var34.contains("Wed")) {
               var27.add(7, -2);
               var28 = var27.getTime();
            } else if (var34.contains("Thu")) {
               var27.add(7, -3);
               var28 = var27.getTime();
            } else if (var34.contains("Fri")) {
               var27.add(7, -4);
               var28 = var27.getTime();
            } else if (var34.contains("Sat")) {
               var27.add(7, -5);
               var28 = var27.getTime();
            } else if (var34.contains("Sun")) {
               var27.add(7, -6);
               var28 = var27.getTime();
            }

            var31 = var24.dateToStringFr(var28);
            var32 = var31.substring(6, 10) + "-" + var31.substring(3, 5) + "-" + var31.substring(0, 2);
            var28 = var24.stringToDateSQL(var32 + " 00:00:00");
            var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
         } else {
            int var38;
            if (var11.equalsIgnoreCase("2")) {
               var38 = var27.get(2) + 1;
               var35 = var33 + "-" + var38 + "-01";
               var28 = var24.stringToDateSQL(var35 + " 00:00:00");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("3")) {
               var38 = var27.get(2);
               var27.add(5, -var38);
               if (var38 <= 3) {
                  var35 = var33 + "-01-01";
                  var28 = var24.stringToDateSQL(var35 + " 00:00:00");
               } else if (var38 >= 4 && var38 <= 6) {
                  var35 = var33 + "-04-01";
                  var28 = var24.stringToDateSQL(var35 + " 00:00:00");
               } else if (var38 >= 7 && var38 <= 9) {
                  var35 = var33 + "-07-01";
                  var28 = var24.stringToDateSQL(var35 + " 00:00:00");
               } else if (var38 >= 10) {
                  var35 = var33 + "-10-01";
                  var28 = var24.stringToDateSQL(var35 + " 00:00:00");
               }

               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("4")) {
               var38 = var27.get(2);
               var27.add(5, -var38);
               if (var38 <= 6) {
                  var35 = var33 + "-01-01";
                  var28 = var24.stringToDateSQL(var35 + " 00:00:00");
               } else {
                  var35 = var33 + "-07-01";
                  var28 = var24.stringToDateSQL(var35 + " 00:00:00");
               }

               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("5")) {
               var34 = var33 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-03-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("6")) {
               var34 = var33 + "-04-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-06-30";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("7")) {
               var34 = var33 + "-07-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-09-30";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("8")) {
               var34 = var33 + "-10-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("9")) {
               var34 = var33 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-06-30";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("10")) {
               var34 = var33 + "-07-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("11")) {
               var34 = var33 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("12")) {
               var34 = "1980-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 - 1 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("13")) {
               var34 = var33 - 1 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("14")) {
               var34 = var33 - 1 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 - 1 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("ndfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("20")) {
               var26.setMaxResults(20);
               var26 = var26.addOrder(Order.desc("ndfId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var34 = "%" + var4 + "%";
         var26 = var26.add(Restrictions.like("ndfNum", var34));
      }

      if (var5 != 0L) {
         var26 = var26.add(Restrictions.eq("tiers.tieid", var5));
      } else if (var7 != null && !var7.isEmpty()) {
         var34 = "";
         if (var7.startsWith("*")) {
            var34 = "%" + var7.substring(1) + "%";
         } else {
            var34 = var7 + "%";
         }

         var26 = var26.add(Restrictions.or(Restrictions.like("ndfNomTiers", var34), Restrictions.like("ndfDiversNom", var34)));
      }

      if (var17 != null && !var17.isEmpty()) {
         var26 = var26.add(Restrictions.eq("ndfNomResponsable", var17));
      }

      if (var15 == 1) {
         var26 = var26.add(Restrictions.eq("ndfIdCreateur", var13));
      }

      String[] var39;
      if (!var9.equalsIgnoreCase("100")) {
         if (var9.contains(",")) {
            var39 = var9.split(",");
            int var40 = var39.length;
            String[] var36 = new String[var40];

            for(int var37 = 0; var37 < var40; ++var37) {
               var36[var37] = new String(var39[var37]);
            }

            var26 = var26.add(Restrictions.in("ndfSerie", var36));
         } else {
            var26 = var26.add(Restrictions.eq("ndfSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         var26 = var26.add(Restrictions.eq("ndfCat", var10));
      }

      if (var8 <= 10) {
         var26 = var26.add(Restrictions.eq("ndfEtat", var8));
      } else if (var8 == 11) {
         var26 = var26.add(Restrictions.isNotNull("ndfDateRelance"));
      } else if (var8 == 12) {
         var26 = var26.add(Restrictions.eq("ndfTotHt", 0.0D));
      } else if (var8 == 13) {
         var26 = var26.add(Restrictions.eq("ndfSolde", 0));
      } else if (var8 == 14) {
         var26 = var26.add(Restrictions.eq("ndfSolde", 1));
      } else if (var8 == 15) {
         var26 = var26.add(Restrictions.eq("ndfExoTva", 1));
      } else if (var8 == 17) {
         var26 = var26.add(Restrictions.isNotNull("ndfDateTransfert"));
      } else if (var8 == 18) {
         var26 = var26.add(Restrictions.isNull("ndfDateTransfert"));
      }

      if (var12 != null && !var12.isEmpty() && !var12.equalsIgnoreCase("100") && var12.contains(":")) {
         var26 = var26.add(Restrictions.eq("ndfService", var12));
      }

      if (!var18.equalsIgnoreCase("100")) {
         var39 = var18.split(":");
         var35 = var39[0];
         var26 = var26.add(Restrictions.eq("ndfActivite", var35));
      }

      if (!var16.equalsIgnoreCase("100")) {
         var39 = var16.split(":");
         var35 = var39[0];
         var26 = var26.add(Restrictions.eq("ndfBudget", var35));
      }

      if (var19 != null && !var19.isEmpty()) {
         var34 = "%" + var19 + "%";
         var26 = var26.add(Restrictions.or(Restrictions.like("ndfAffaire", var34), Restrictions.like("ndfAnal4", var34)));
      }

      if (var20 != null && !var20.isEmpty()) {
         var34 = "%" + var20 + "%";
         var26 = var26.add(Restrictions.like("ndfAnal4", var34));
      }

      var26 = var26.addOrder(Order.desc("ndfDate"));
      var26 = var26.addOrder(Order.desc("ndfNum"));
      List var41 = var26.list();
      if (var23) {
         this.utilInitHibernate.closeSession();
      }

      return var41;
   }

   public List rechercheNoteDebitAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from NoteDebitEnteteAchats where ndfService='" + var1 + "' and (ndfDateEcheReg='" + var5 + "' or ndfTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from NoteDebitEnteteAchats where ndfDateEcheReg='" + var5 + "' or ndfTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public NoteDebitEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from NoteDebitEnteteAchats where ndfId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new NoteDebitEnteteAchats();
      NoteDebitEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (NoteDebitEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public NoteDebitEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from NoteDebitEnteteAchats where ndfNum=:num and ndfSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new NoteDebitEnteteAchats();
      NoteDebitEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (NoteDebitEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from NoteDebitEnteteAchats where ndfAnal4 =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheByAffaire(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from NoteDebitEnteteAchats where ndfAffaire =:num and ndfAnal4 =:anal").setString("num", var1).setString("anal", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByValo(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from NoteDebitEnteteAchats where ndfValo =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheNonValoriser(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from NoteDebitEnteteAchats where (ndfValo='' or ndfValo is NULL or ndfValo=:val) and (ndfEtat=1 or ndfEtat=4 or ndfEtat=5)").setString("val", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheNoteDebitATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from NoteDebitEnteteAchats where (ndfEtat=0 or ndfEtat=1 or ndfEtat=4) and ndfDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from NoteDebitEnteteAchats where (ndfEtat=0 or ndfEtat=1 or ndfEtat=4) and ndfDateTransfert is NULL and ndfDate>=:dte1 and ndfDate<=:dte2 and ndfNum>=:p1 and ndfNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from NoteDebitEnteteAchats where (ndfEtat=0 or ndfEtat=1 or ndfEtat=4) and ndfDateTransfert is NULL and ndfDate>=:dte1 and ndfDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from NoteDebitEnteteAchats where (ndfEtat=1 or ndfEtat=4) and ndfDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from NoteDebitEnteteAchats where (ndfEtat=1 or ndfEtat=4) and ndfDateTransfert is NULL and ndfDate>=:dte1 and ndfDate<=:dte2 and ndfNum>=:p1 and ndfNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from NoteDebitEnteteAchats where (ndfEtat=1 or ndfEtat=4) and ndfDateTransfert is NULL and ndfDate>=:dte1 and ndfDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheNoteDebitDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from NoteDebitEnteteAchats where (ndfEtat=0 or ndfEtat=1 or ndfEtat=4) and (ndfDateTransfert <> '' and ndfDateTransfert is not NULL) and (ndfDate>=:dte1 and ndfDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
      Query var4 = var3.createQuery("from NoteDebitEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from NoteDebitEnteteAchats where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public List rechercheNoteDebitRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from NoteDebitEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from NoteDebitEnteteAchats where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheNoteDebitByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from NoteDebitEnteteAchats where ndfDate>=:deb and ndfDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheNoteDebitCampagne(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from NoteDebitEnteteAchats where ndfSource like '" + var1 + "%'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
