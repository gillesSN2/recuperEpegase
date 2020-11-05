package com.epegase.systeme.dao;

import com.epegase.systeme.classe.HospitalisationEntete;
import com.epegase.systeme.classe.HospitalisationSejour;
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
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class HospitalisationSejourDao implements Serializable {
   private HospitalisationSejour hospitalisationSejour;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public HospitalisationSejourDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public HospitalisationSejour insert(HospitalisationSejour var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
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

   public HospitalisationSejour modif(HospitalisationSejour var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
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

   public HospitalisationSejour modif(HospitalisationSejour var1, Session var2) throws HibernateException, NamingException {
      var2.update(var1);
      return var1;
   }

   public void delete(HospitalisationSejour var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
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

   public void delete(HospitalisationSejour var1, Session var2) throws HibernateException, NamingException {
      var2.delete(var1);
   }

   public void deleteAllLigne(HospitalisationEntete var1, Session var2) {
      var2.createQuery("delete from HospitalisationSejour where HospitalisationEntete=:id").setParameter("id", var1).executeUpdate();
   }

   public List selectSejourByEnt(HospitalisationEntete var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("From HospitalisationSejour where HospitalisationEntete=:param").setParameter("param", var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List selectSejourByEnt(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From HospitalisationSejour where HospitalisationEntete.hosId=:param").setLong("param", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public HospitalisationSejour selectSejour(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = var3.createQuery("From HospitalisationSejour where hossejId=:param").setLong("param", var1).setMaxResults(1).list();
      this.hospitalisationSejour = new HospitalisationSejour();
      if (var5.size() != 0) {
         this.hospitalisationSejour = (HospitalisationSejour)var5.get(0);
      } else {
         this.hospitalisationSejour = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return this.hospitalisationSejour;
   }

   public List chargerLesMvtsPatients(Patients var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var5 = true;
      }

      List var6 = null;
      var6 = var4.createQuery("from HospitalisationSejour where HospitalisationEntete.Patients.patId=" + var1.getPatId() + " and HospitalisationEntete.hosDateEntree between '" + var2 + "' and '" + var3 + "'").list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List chargerLesMvtsPeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = null;
      var5 = var3.createQuery("from HospitalisationSejour where HospitalisationEntete.hosDateEntree between '" + var1 + "' and '" + var2 + "'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerLesMvtsJour(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from HospitalisationSejour where hossejDateSortie = '" + var1 + "'").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesMvtsHospit(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var4 = true;
      }

      List var5 = null;
      var5 = var3.createQuery("from HospitalisationSejour where HospitalisationEntete.hosId=" + var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerSejourByRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = null;
      var4 = var2.createQuery("from HospitalisationSejour where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List chargerLesLignesSejour(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var3 = true;
      }

      List var4 = var2.createQuery("from HospitalisationSejour where HospitalisationEntete.hosNum in (" + var1 + ") order by hossejService").list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheHospitalisation(Session var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, int var12, String var13, String var14, String var15, String var16, long var17, int var19, String var20, String var21, String var22, String var23, String var24) throws HibernateException, NamingException, ParseException {
      boolean var25 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "HospitalisationEntete");
         var25 = true;
      }

      UtilDate var26 = new UtilDate();
      new ArrayList();
      Criteria var28 = var1.createCriteria(HospitalisationSejour.class);
      var28 = var28.createAlias("HospitalisationEntete", "hos", 1);
      var28 = var28.createAlias("Patients", "pat", 1);
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
      if (var15.equalsIgnoreCase("100")) {
         if (var23 != null && var24 != null) {
            var30 = var26.stringToDateSQLLight(var23);
            var31 = var26.stringToDateSQLLight(var24);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else {
            var36 = "1980-01-01";
            var26.stringToDateSQLLight(var36);
            var28 = var28.add(Restrictions.isNotNull("hos.hosDateEntree"));
         }
      } else if (var15.equalsIgnoreCase("0")) {
         var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
      } else if (var15.equalsIgnoreCase("1")) {
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
         var30 = var26.stringToDateSQLLight(var34);
         var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
      } else {
         int var40;
         if (var15.equalsIgnoreCase("2")) {
            var40 = var29.get(2) + 1;
            var37 = var35 + "-" + var40 + "-01";
            var30 = var26.stringToDateSQLLight(var37);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("3")) {
            var40 = var29.get(2);
            var29.add(5, -var40);
            if (var40 <= 3) {
               var37 = var35 + "-01-01";
               var30 = var26.stringToDateSQLLight(var37);
            } else if (var40 >= 4 && var40 <= 6) {
               var37 = var35 + "-04-01";
               var30 = var26.stringToDateSQLLight(var37);
            } else if (var40 >= 7 && var40 <= 9) {
               var37 = var35 + "-07-01";
               var30 = var26.stringToDateSQLLight(var37);
            } else if (var40 >= 10) {
               var37 = var35 + "-10-01";
               var30 = var26.stringToDateSQLLight(var37);
            }

            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("4")) {
            var40 = var29.get(2);
            var29.add(5, -var40);
            if (var40 <= 6) {
               var37 = var35 + "-01-01";
               var30 = var26.stringToDateSQLLight(var37);
            } else {
               var37 = var35 + "-07-01";
               var30 = var26.stringToDateSQLLight(var37);
            }

            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("5")) {
            var36 = var35 + "-01-01";
            var30 = var26.stringToDateSQLLight(var36);
            var37 = var35 + "-03-31";
            var31 = var26.stringToDateSQLLight(var37);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("6")) {
            var36 = var35 + "-04-01";
            var30 = var26.stringToDateSQLLight(var36);
            var37 = var35 + "-06-30";
            var31 = var26.stringToDateSQLLight(var37);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("7")) {
            var36 = var35 + "-07-01";
            var30 = var26.stringToDateSQLLight(var36);
            var37 = var35 + "-09-30";
            var31 = var26.stringToDateSQLLight(var37);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("8")) {
            var36 = var35 + "-10-01";
            var30 = var26.stringToDateSQLLight(var36);
            var37 = var35 + "-12-31";
            var31 = var26.stringToDateSQLLight(var37);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("9")) {
            var36 = var35 + "-01-01";
            var30 = var26.stringToDateSQLLight(var36);
            var37 = var35 + "-06-30";
            var31 = var26.stringToDateSQLLight(var37);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("10")) {
            var36 = var35 + "-07-01";
            var30 = var26.stringToDateSQLLight(var36);
            var37 = var35 + "-12-31";
            var31 = var26.stringToDateSQLLight(var37);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("11")) {
            var36 = var35 + "-01-01";
            var30 = var26.stringToDateSQLLight(var36);
            var37 = var35 + "-12-31";
            var31 = var26.stringToDateSQLLight(var37);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("12")) {
            var36 = "1980-01-01";
            var30 = var26.stringToDateSQL(var36);
            var37 = var35 - 1 + "-12-31";
            var31 = var26.stringToDateSQLLight(var37);
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("13")) {
            var36 = var35 - 1 + "-01-01";
            var30 = var26.stringToDateSQL(var36 + " 00:00:00");
            var37 = var35 + "-12-31";
            var31 = var26.stringToDateSQL(var37 + " 23:59:59");
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("14")) {
            var36 = var35 - 1 + "-01-01";
            var30 = var26.stringToDateSQL(var36 + " 00:00:00");
            var37 = var35 - 1 + "-12-31";
            var31 = var26.stringToDateSQL(var37 + " 23:59:59");
            var28 = var28.add(Restrictions.between("hos.hosDateEntree", var30, var31));
         } else if (var15.equalsIgnoreCase("20")) {
            var28.setMaxResults(20);
            var28 = var28.addOrder(Order.desc("hos.hosId"));
         }
      }

      if (var2 != null && !var2.isEmpty()) {
         var36 = "%" + var2 + "%";
         var28 = var28.add(Restrictions.like("hos.hosNum", var36));
      }

      if (var3 != null && !var3.isEmpty()) {
         var36 = "%" + var3 + "%";
         var28 = var28.add(Restrictions.like("pat.patNom", var36));
      }

      if (var4 != null && !var4.isEmpty()) {
         var36 = "%" + var4 + "%";
         var28 = var28.add(Restrictions.like("pat.patPrenom", var36));
      }

      if (var5 != null && !var5.isEmpty()) {
         var36 = "%" + var5 + "%";
         var28 = var28.add(Restrictions.or(Restrictions.like("pat.patTelDom", var36), Restrictions.like("pat.patCel1", var36)));
      }

      if (var6 != null && !var6.isEmpty()) {
         var36 = "%" + var6 + "%";
         var28 = var28.add(Restrictions.like("pat.patCi", var36));
      }

      if (var7 != null && !var7.isEmpty()) {
         var36 = "%" + var7 + "%";
         var28 = var28.add(Restrictions.like("pat.patDossier", var36));
      }

      if (var8 != null && !var8.isEmpty()) {
         var36 = "%" + var8 + "%";
         var28 = var28.add(Restrictions.like("hos.hosNomSociete", var36));
      }

      if (var9 != null && !var9.isEmpty()) {
         var36 = "%" + var9 + "%";
         var28 = var28.add(Restrictions.like("hos.hosNomAssurance", var36));
      }

      if (var10 != null && !var10.isEmpty()) {
         var36 = "%" + var10 + "%";
         var28 = var28.add(Restrictions.like("hos.hosNomComplementaire", var36));
      }

      if (var11 != null && !var11.isEmpty()) {
         var36 = "%" + var11 + "%";
         var28 = var28.add(Restrictions.like("hos.hosContratAssurance", var36));
      }

      if (var20 != null && !var20.isEmpty()) {
         var28 = var28.add(Restrictions.eq("hos.hosProtocole", var20));
      }

      if (var21 != null && !var21.isEmpty()) {
         var28 = var28.add(Restrictions.eq("hos.hosMedecin", var21));
      }

      if (var19 == 1) {
         var28 = var28.add(Restrictions.eq("hos.hosIdCreateur", var17));
      }

      String[] var42;
      if (!var13.equalsIgnoreCase("100")) {
         if (var13.contains(",")) {
            var42 = var13.split(",");
            int var41 = var42.length;
            String[] var38 = new String[var41];

            for(int var39 = 0; var39 < var41; ++var39) {
               var38[var39] = new String(var42[var39]);
            }

            var28 = var28.add(Restrictions.in("hos.hosSerie", var38));
         } else {
            var28 = var28.add(Restrictions.eq("hos.hosSerie", var13));
         }
      }

      if (!var14.equalsIgnoreCase("100")) {
         if (var14.equals("0")) {
            var28 = var28.add(Restrictions.eq("hos.hosFam", 0L));
         } else if (var14.equals("-1")) {
            var28 = var28.add(Restrictions.eq("hos.hosFam", -1L));
         } else {
            var28 = var28.add(Restrictions.ne("hos.hosFam", 0L));
            var28 = var28.add(Restrictions.ne("hos.hosFam", -1L));
         }
      }

      if (var12 <= 10) {
         var28 = var28.add(Restrictions.eq("hos.hosEtat", var12));
      } else if (var12 == 13) {
         var28 = var28.add(Restrictions.eq("hos.hosSoldePatient", 0));
         var28 = var28.add(Restrictions.ne("hos.hosTotPatient", 0.0D));
      } else if (var12 == 14) {
         var28 = var28.add(Restrictions.eq("hos.hosSoldePatient", 1));
      } else if (var12 == 15) {
         var28 = var28.add(Restrictions.eq("hos.hosSoldeTiers", 0));
      } else if (var12 == 16) {
         var28 = var28.add(Restrictions.eq("hos.hosSoldeTiers", 1));
      } else if (var12 == 17) {
         var28 = var28.add(Restrictions.isNotNull("hos.hosDateTransfert"));
      } else if (var12 == 18) {
         var28 = var28.add(Restrictions.isNull("hos.hosDateTransfert"));
      } else if (var12 == 19) {
         var28 = var28.add(Restrictions.or(Restrictions.eq("hos.hosEtat", 1), Restrictions.eq("hos.hosEtat", 5)));
      } else if (var12 == 20) {
         var28 = var28.add(Restrictions.or(Restrictions.or(Restrictions.eq("hos.hosEtat", 1), Restrictions.eq("hos.hosEtat", 5)), Restrictions.or(Restrictions.eq("hos.hosEtat", 6), Restrictions.eq("hos.hosEtat", 7))));
      }

      if (var16 != null && !var16.isEmpty() && !var16.equalsIgnoreCase("100") && var16.contains(":")) {
         var28 = var28.add(Restrictions.eq("hossejService", var16));
      }

      if (!var22.equalsIgnoreCase("100")) {
         var42 = var22.split(":");
         var37 = var42[0];
         var28 = var28.add(Restrictions.eq("hos.hosActivite", var37));
      }

      var28 = var28.addOrder(Order.desc("hos.hosDateEntree"));
      var28 = var28.addOrder(Order.desc("hos.hosNum"));
      List var43 = var28.list();
      if (var25) {
         this.utilInitHibernate.closeSession();
      }

      return var43;
   }
}
