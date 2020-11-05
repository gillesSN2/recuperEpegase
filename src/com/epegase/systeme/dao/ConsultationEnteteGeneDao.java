package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ConsultationEnteteGene;
import com.epegase.systeme.classe.Patients;
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

public class ConsultationEnteteGeneDao implements Serializable {
   private ConsultationEnteteGene consultationEntete;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ConsultationEnteteGeneDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ConsultationEnteteGene insert(ConsultationEnteteGene var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public ConsultationEnteteGene insert(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      var2.save(var1);
      return var1;
   }

   public ConsultationEnteteGene modif(ConsultationEnteteGene var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public ConsultationEnteteGene modif(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(ConsultationEnteteGene var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
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

   public void delete(ConsultationEnteteGene var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ConsultationEnteteGene order by csgId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            ConsultationEnteteGene var7 = (ConsultationEnteteGene)var6.get(0);
            var4 = 1L + var7.getCsgId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ConsultationEnteteGene consultationEnteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from ConsultationEnteteGene where ExercicesVentes.exevteId=:id and csgSerie =:ser and year(csgDate)=" + var7 + " order by csgDate desc").setLong("id", var1).setString("ser", var3);
      ConsultationEnteteGene var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (ConsultationEnteteGene)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public ConsultationEnteteGene consultationEnteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from ConsultationEnteteGene where ExercicesVentes.exevteId=:id and csgSerie =:ser and year(csgDate)=" + var7 + " and month(csgDate)=" + var8 + " order by csgDate desc").setLong("id", var1).setString("ser", var3);
      ConsultationEnteteGene var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (ConsultationEnteteGene)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheConsultation(Session var1, long var2, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, String var12, String var13, String var14, int var15, String var16, String var17, String var18, String var19, long var20, int var22, String var23, String var24, String var25, String var26, String var27) throws HibernateException, NamingException, ParseException {
      boolean var28 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var28 = true;
      }

      UtilDate var29 = new UtilDate();
      new ArrayList();
      Criteria var31 = var1.createCriteria(ConsultationEnteteGene.class);
      var31 = var31.createAlias("Patients", "pat", 1);
      var31 = var31.add(Restrictions.eq("csgIdSejour", 0L));
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
      if (var18.equalsIgnoreCase("100")) {
         if (var26 != null && var27 != null) {
            var33 = var29.stringToDateSQL(var26 + " 00:00:00");
            var34 = var29.stringToDateSQL(var27 + " 23:59:59");
            var31 = var31.add(Restrictions.between("csgDate", var33, var34));
         } else {
            var39 = "1980-01-01";
            var29.stringToDateSQL(var39 + " 00:00:00");
            var31 = var31.add(Restrictions.isNotNull("csgDate"));
         }
      } else {
         if (!var18.equalsIgnoreCase("12") && !var18.equalsIgnoreCase("13") && !var18.equalsIgnoreCase("14")) {
            var31 = var31.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var18.equalsIgnoreCase("0")) {
            var31 = var31.add(Restrictions.between("csgDate", var33, var34));
         } else if (var18.equalsIgnoreCase("1")) {
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
            var31 = var31.add(Restrictions.between("csgDate", var33, var34));
         } else {
            int var43;
            if (var18.equalsIgnoreCase("2")) {
               var43 = var32.get(2) + 1;
               var40 = var38 + "-" + var43 + "-01";
               var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("3")) {
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

               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("4")) {
               var43 = var32.get(2);
               var32.add(5, -var43);
               if (var43 <= 6) {
                  var40 = var38 + "-01-01";
                  var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               } else {
                  var40 = var38 + "-07-01";
                  var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               }

               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("5")) {
               var39 = var38 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-03-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("6")) {
               var39 = var38 + "-04-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-06-30";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("7")) {
               var39 = var38 + "-07-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-09-30";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("8")) {
               var39 = var38 + "-10-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("9")) {
               var39 = var38 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-06-30";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("10")) {
               var39 = var38 + "-07-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("11")) {
               var39 = var38 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("12")) {
               var39 = "1980-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 - 1 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("13")) {
               var39 = var38 - 1 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("14")) {
               var39 = var38 - 1 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 - 1 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("csgDate", var33, var34));
            } else if (var18.equalsIgnoreCase("20")) {
               var31.setMaxResults(20);
               var31 = var31.addOrder(Order.desc("csgId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var31 = var31.add(Restrictions.eq("csgService", var4));
      }

      if (var5 != null && !var5.isEmpty()) {
         var39 = "%" + var5 + "%";
         var31 = var31.add(Restrictions.like("csgNum", var39));
      }

      if (var6 != null && !var6.isEmpty()) {
         var39 = "%" + var6 + "%";
         var31 = var31.add(Restrictions.like("pat.patNom", var39));
      }

      if (var7 != null && !var7.isEmpty()) {
         var39 = "%" + var7 + "%";
         var31 = var31.add(Restrictions.like("pat.patPrenom", var39));
      }

      if (var8 != null && !var8.isEmpty()) {
         var39 = "%" + var8 + "%";
         var31 = var31.add(Restrictions.or(Restrictions.like("pat.patTelDom", var39), Restrictions.like("pat.patCel1", var39)));
      }

      if (var9 != null && !var9.isEmpty()) {
         var39 = "%" + var9 + "%";
         var31 = var31.add(Restrictions.like("pat.patCi", var39));
      }

      if (var10 != null && !var10.isEmpty()) {
         var39 = "%" + var10 + "%";
         var31 = var31.add(Restrictions.like("pat.patDossier", var39));
      }

      if (var11 != null && !var11.isEmpty()) {
         var39 = "%" + var11 + "%";
         var31 = var31.add(Restrictions.like("csgNomSociete", var39));
      }

      if (var12 != null && !var12.isEmpty()) {
         var39 = "%" + var12 + "%";
         var31 = var31.add(Restrictions.like("csgNomAssurance", var39));
      }

      if (var13 != null && !var13.isEmpty()) {
         var39 = "%" + var13 + "%";
         var31 = var31.add(Restrictions.like("csgNomComplementaire", var39));
      }

      if (var14 != null && !var14.isEmpty()) {
         var39 = "%" + var14 + "%";
         var31 = var31.add(Restrictions.like("csgContratAssurance", var39));
      }

      if (var23 != null && !var23.isEmpty()) {
         var31 = var31.add(Restrictions.eq("csgProtocole", var23));
      }

      if (var24 != null && !var24.isEmpty()) {
         var31 = var31.add(Restrictions.eq("csgMedecin", var24));
      }

      if (var22 == 1) {
         var31 = var31.add(Restrictions.eq("csgIdCreateur", var20));
      }

      String[] var45;
      if (!var16.equalsIgnoreCase("100")) {
         if (var16.contains(",")) {
            var45 = var16.split(",");
            int var44 = var45.length;
            String[] var41 = new String[var44];

            for(int var42 = 0; var42 < var44; ++var42) {
               var41[var42] = new String(var45[var42]);
            }

            var31 = var31.add(Restrictions.in("csgSerie", var41));
         } else {
            var31 = var31.add(Restrictions.eq("csgSerie", var16));
         }
      }

      if (!var17.equalsIgnoreCase("100")) {
         if (var17.equals("0")) {
            var31 = var31.add(Restrictions.eq("csgIdSociete", 0L));
            var31 = var31.add(Restrictions.eq("csgIdAssurance", 0L));
            var31 = var31.add(Restrictions.eq("csgPecCnamgs", 0.0F));
            var31 = var31.add(Restrictions.eq("csgFam", 0L));
         } else if (var17.equals("-1")) {
            var31 = var31.add(Restrictions.eq("csgFam", -1L));
         } else if (var17.equals("-2")) {
            var31 = var31.add(Restrictions.ne("csgIdSociete", 0L));
         } else if (var17.equals("-4")) {
            var31 = var31.add(Restrictions.ne("csgPecCnamgs", 0.0F));
         } else {
            var31 = var31.add(Restrictions.ne("csgIdAssurance", 0L));
         }
      }

      if (var15 <= 10) {
         var31 = var31.add(Restrictions.eq("csgEtat", var15));
      } else if (var15 == 13) {
         var31 = var31.add(Restrictions.eq("csgSoldePatient", 0));
         var31 = var31.add(Restrictions.ne("csgTotPatient", 0.0D));
      } else if (var15 == 14) {
         var31 = var31.add(Restrictions.eq("csgSoldePatient", 1));
      } else if (var15 == 15) {
         var31 = var31.add(Restrictions.eq("csgSoldeTiers", 0));
      } else if (var15 == 16) {
         var31 = var31.add(Restrictions.eq("csgSoldeTiers", 1));
      } else if (var15 == 17) {
         var31 = var31.add(Restrictions.isNotNull("csgDateTransfert"));
      } else if (var15 == 18) {
         var31 = var31.add(Restrictions.isNull("csgDateTransfert"));
      } else if (var15 == 19) {
         var31 = var31.add(Restrictions.or(Restrictions.eq("csgEtat", 1), Restrictions.eq("csgEtat", 5)));
      } else if (var15 == 20) {
         var31 = var31.add(Restrictions.or(Restrictions.or(Restrictions.eq("csgEtat", 1), Restrictions.eq("csgEtat", 5)), Restrictions.or(Restrictions.eq("csgEtat", 6), Restrictions.eq("csgEtat", 7))));
      } else if (var15 == 21) {
         var31 = var31.add(Restrictions.or(Restrictions.eq("csgEtat", 0), Restrictions.eq("csgEtat", 1)));
      }

      if (var19 != null && !var19.isEmpty() && !var19.equalsIgnoreCase("100") && var19.contains(":")) {
         var31 = var31.add(Restrictions.eq("csgService", var19));
      }

      if (!var25.equalsIgnoreCase("100")) {
         var45 = var25.split(":");
         var40 = var45[0];
         var31 = var31.add(Restrictions.eq("csgActivite", var40));
      }

      var31 = var31.addOrder(Order.desc("csgDate"));
      var31 = var31.addOrder(Order.desc("csgNum"));
      List var46 = var31.list();
      if (var28) {
         this.utilInitHibernate.closeSession();
      }

      return var46;
   }

   public ConsultationEnteteGene selectById(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ConsultationEnteteGene where csgId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new ConsultationEnteteGene();
      ConsultationEnteteGene var7;
      if (var6.size() != 0) {
         var7 = (ConsultationEnteteGene)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ConsultationEnteteGene selectByFeuille(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ConsultationEnteteGene where csgFeuille=:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new ConsultationEnteteGene();
      ConsultationEnteteGene var6;
      if (var5.size() != 0) {
         var6 = (ConsultationEnteteGene)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ConsultationEnteteGene selectByPatient(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ConsultationEnteteGene where csgIdPatient=:id").setLong("id", var1);
      List var6 = var5.list();
      new ConsultationEnteteGene();
      ConsultationEnteteGene var7;
      if (var6.size() != 0) {
         var7 = (ConsultationEnteteGene)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ConsultationEnteteGene selectByGrace(long var1, long var3, int var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var7 = true;
      }

      Query var8 = var6.createQuery("from ConsultationEnteteGene where csgIdPatient=:idPat and csgIdMedecin=:idMed and (csgEtat<>2 and csgEtat<>3) order by csgDate desc").setLong("idPat", var1).setLong("idMed", var3).setMaxResults(1);
      List var9 = var8.list();
      new ConsultationEnteteGene();
      ConsultationEnteteGene var10;
      if (var9.size() != 0) {
         var10 = (ConsultationEnteteGene)var9.get(0);
         long var11 = (new Date()).getTime() - var10.getCsgDate().getTime();
         float var13 = (float)(var11 / 86400000L);
         if (var13 > (float)var5) {
            var10 = null;
         }
      } else {
         var10 = null;
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public ConsultationEnteteGene selectByNum(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from ConsultationEnteteGene where csgNum=:num and csgSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var5 = var3.createQuery("from ConsultationEnteteGene where csgNum=:num").setString("num", var1).setMaxResults(1);
      }

      List var6 = var5.list();
      new ConsultationEnteteGene();
      ConsultationEnteteGene var7;
      if (var6.size() != 0) {
         var7 = (ConsultationEnteteGene)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheConsultationATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var6) {
         var10 = var7.createQuery("from ConsultationEnteteGene where (csgEtat=1 or csgEtat=4 or csgEtat=5 or csgEtat=6 or csgEtat=7) and csgDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from ConsultationEnteteGene where (csgEtat=1 or csgEtat=4 or csgEtat=5 or csgEtat=6 or csgEtat=7) and csgDateTransfert is NULL and csgDate>=:dte1 and csgDate<=:dte2 and csgNum>=:p1 and csgNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from ConsultationEnteteGene where (csgEtat=1 or csgEtat=4 or csgEtat=5 or csgEtat=6 or csgEtat=7) and csgDateTransfert is NULL and csgDate>=:dte1 and csgDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheConsultationDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from ConsultationEnteteGene where (csgEtat=1 or csgEtat=4 or csgEtat=5 or csgEtat=6 or csgEtat=7) and (csgDateTransfert<>'' and csgDateTransfert is not null) and (csgDate>=:dte1 and csgDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheConsultationPeriode(String var1, String var2, long var3, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var7 = true;
      }

      new ArrayList();
      List var9 = null;
      if (var5 != null && !var5.isEmpty()) {
         if (var3 != 0L) {
            var9 = var6.createQuery("from ConsultationEnteteGene where (csgDate>=:dte1 and csgDate<=:dte2) and (csgIdSociete=:id or csgIdAssurance=:id or csgIdComplementaire=:id) and csgNumBc=:bc").setString("dte1", var1).setString("dte2", var2).setLong("id", var3).setString("bc", var5).list();
         } else {
            var9 = var6.createQuery("from ConsultationEnteteGene where (csgDate>=:dte1 and csgDate<=:dte2) and csgNumBc=:bc").setString("dte1", var1).setString("dte2", var2).setString("bc", var5).list();
         }
      } else if (var3 != 0L) {
         var9 = var6.createQuery("from ConsultationEnteteGene where (csgDate>=:dte1 and csgDate<=:dte2) and (csgIdSociete=:id or csgIdAssurance=:id or csgIdComplementaire=:id)").setString("dte1", var1).setString("dte2", var2).setLong("id", var3).list();
      } else {
         var9 = var6.createQuery("from ConsultationEnteteGene where (csgDate>=:dte1 and csgDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List rechercheConsultationCnamgsPeriode(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var5 = true;
      }

      new ArrayList();
      List var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         var7 = var4.createQuery("from ConsultationEnteteGene where (csgDate>=:dte1 and csgDate<=:dte2) and (csgFondCnamgs<>0 and csgPecCnamgs<>0) and csgNumBc=:bc").setString("dte1", var1).setString("dte2", var2).setString("bc", var3).list();
      } else {
         var7 = var4.createQuery("from ConsultationEnteteGene where (csgDate>=:dte1 and csgDate<=:dte2) and (csgFondCnamgs<>0 and csgPecCnamgs<>0)").setString("dte1", var1).setString("dte2", var2).list();
      }

      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheConsultationInfirmerie(String var1, String var2, String var3, long var4, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var7 = true;
      }

      new ArrayList();
      List var9 = null;
      if (var4 != 0L) {
         var9 = var6.createQuery("from ConsultationEnteteGene where (csgDate>=:dte1 and csgDate<=:dte2) and (csgIdSociete=:id or csgIdAssurance=:id or csgIdComplementaire=:id) and csgService=:srv").setString("dte1", var2).setString("dte2", var3).setLong("id", var4).setString("srv", var1).list();
      } else {
         var9 = var6.createQuery("from ConsultationEnteteGene where (csgDate>=:dte1 and csgDate<=:dte2) and csgService=:srv").setString("dte1", var2).setString("dte2", var3).setString("srv", var1).list();
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List chargerLesMvtsPatients(Patients var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ConsultationEnteteGene where Patients.patId=" + var1.getPatId() + " and csgDate>='" + var2 + "' and csgDate<='" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsPatients(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from ConsultationEnteteGene where Patients.patId=" + var1.getPatId()).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifConsultPatients(Patients var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from ConsultationEnteteGene where Patients.patId=" + var1.getPatId() + ")").list();
      boolean var5 = false;
      if (var4.size() != 0) {
         var5 = true;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerConsultationByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from ConsultationEnteteGene where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectConsultationByHospit(String var1, long var2, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ConsultationEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from ConsultationEnteteGene where  csgNumHospit='" + var1 + "' and Patients.patId=" + var2 + " and csgIdSejour<>0").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
