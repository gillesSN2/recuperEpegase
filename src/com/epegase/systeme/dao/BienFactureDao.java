package com.epegase.systeme.dao;

import com.epegase.systeme.classe.BienFacture;
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

public class BienFactureDao implements Serializable {
   private BienFacture bienFacture;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public BienFactureDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public BienFacture insert(BienFacture var1) throws HibernateException, NamingException {
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

   public BienFacture insert(BienFacture var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public BienFacture modif(BienFacture var1) throws HibernateException, NamingException {
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

   public BienFacture modif(BienFacture var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(BienFacture var1) throws HibernateException, NamingException {
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

   public void delete(BienFacture var1, Session var2) {
      var2.delete(var1);
   }

   public List chargerFactures(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienFacture where biefacDate>=:deb and biefacDate<=:fin order by biefacNum").setDate("deb", var1).setDate("fin", var2);
      new ArrayList();
      List var6 = var5.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var2 = true;
      }

      Query var3 = var1.createQuery("from BienFacture order by biefacId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            BienFacture var7 = (BienFacture)var6.get(0);
            var4 = 1L + var7.getBiefacId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public BienFacture enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from BienFacture where exerciceventes.exevteId=:id and biefacSerie =:ser and year(facDate)=" + var7 + " order by biefacDate desc").setParameter("id", var1).setParameter("ser", var3);
      BienFacture var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (BienFacture)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public BienFacture enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from BienFacture where exerciceventes.exevteId=:id and biefacSerie =:ser and year(facDate)=" + var7 + " and month(facDate)=" + var8 + " order by biefacDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      BienFacture var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (BienFacture)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, String var6, String var7, int var8, String var9, String var10, String var11, String var12, long var13, int var15, String var16, String var17, String var18, String var19, String var20, String var21) throws HibernateException, NamingException, ParseException {
      boolean var22 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var22 = true;
      }

      UtilDate var23 = new UtilDate();
      new ArrayList();
      Criteria var25 = var1.createCriteria(BienFacture.class);
      Calendar var26 = Calendar.getInstance();
      Date var27 = null;
      Date var28 = null;
      Date var29 = new Date();
      String var30 = var23.dateToStringFr(var29);
      String var31 = var30.substring(6, 10) + "-" + var30.substring(3, 5) + "-" + var30.substring(0, 2);
      var23.stringToDateSQL(var31 + " 00:00:00");
      var23.stringToDateSQL(var31 + " 23:59:59");
      int var32 = var29.getYear() + 1900;
      String var33;
      String var34;
      String[] var37;
      if (var11 != null && !var11.isEmpty() && var11.equalsIgnoreCase("100")) {
         if (var20 != null && var21 != null) {
            var27 = var23.stringToDateSQL(var20 + " 00:00:00");
            var28 = var23.stringToDateSQL(var21 + " 23:59:59");
            var25 = var25.add(Restrictions.between("biefacDate", var27, var28));
         } else {
            var33 = "1980-01-01";
            var23.stringToDateSQL(var33 + " 00:00:00");
            var25 = var25.add(Restrictions.isNotNull("biefacDate"));
         }
      } else {
         if (var11 != null && !var11.isEmpty() && !var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var25 = var25.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var11 != null && !var11.isEmpty() && var11.contains(":")) {
            var37 = var11.split(":");
            var34 = var37[0];
            String var35 = var37[1];
            var27 = var23.stringToDateSQL(var35 + "-" + var34 + "-" + "01 00:00:00");
            String var36 = var23.dateToStringSQLLight(var23.dateDernierJourMois(var27));
            var28 = var23.stringToDateSQL(var36 + " 23:59:59");
            var25 = var25.add(Restrictions.between("biefacDate", var27, var28));
         } else if (var11 != null && !var11.isEmpty() && var11.equalsIgnoreCase("11")) {
            var33 = var32 + "-01-01";
            var27 = var23.stringToDateSQL(var33 + " 00:00:00");
            var34 = var32 + "-12-31";
            var28 = var23.stringToDateSQL(var34 + " 23:59:59");
            var25 = var25.add(Restrictions.between("biefacDate", var27, var28));
         } else if (var11 != null && !var11.isEmpty() && var11.equalsIgnoreCase("12")) {
            var33 = "1980-01-01";
            var27 = var23.stringToDateSQL(var33 + " 00:00:00");
            var34 = var32 - 1 + "-12-31";
            var28 = var23.stringToDateSQL(var34 + " 23:59:59");
            var25 = var25.add(Restrictions.between("biefacDate", var27, var28));
         } else if (var11 != null && !var11.isEmpty() && var11.equalsIgnoreCase("13")) {
            var33 = var32 - 1 + "-01-01";
            var27 = var23.stringToDateSQL(var33 + " 00:00:00");
            var34 = var32 + "-12-31";
            var28 = var23.stringToDateSQL(var34 + " 23:59:59");
            var25 = var25.add(Restrictions.between("biefacDate", var27, var28));
         } else if (var11 != null && !var11.isEmpty() && var11.equalsIgnoreCase("14")) {
            var33 = var32 - 1 + "-01-01";
            var27 = var23.stringToDateSQL(var33 + " 00:00:00");
            var34 = var32 - 1 + "-12-31";
            var28 = var23.stringToDateSQL(var34 + " 23:59:59");
            var25 = var25.add(Restrictions.between("biefacDate", var27, var28));
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var33 = "%" + var4 + "%";
         var25 = var25.add(Restrictions.like("biefacNum", var33));
      }

      if (var5 != null && !var5.isEmpty() && !var5.contains(":")) {
         var33 = "";
         if (var5.startsWith("*")) {
            var33 = "%" + var5.substring(1) + "%";
         } else {
            var33 = var5 + "%";
         }

         var25 = var25.add(Restrictions.like("biefacNomTiers", var33));
      }

      if (var5 != null && !var5.isEmpty() && var5.contains(":")) {
         var37 = var5.split(":");
         long var39 = Long.parseLong(var37[0]);
         var25 = var25.add(Restrictions.eq("tiers.tieid", var39));
      }

      if (var6 != null && !var6.isEmpty()) {
         var33 = "";
         if (var6.startsWith("*")) {
            var33 = "%" + var6.substring(1) + "%";
         } else {
            var33 = var6 + "%";
         }

         var25 = var25.add(Restrictions.like("biefacNomProprietaire", var33));
      }

      if (var7 != null && !var7.isEmpty()) {
         var25 = var25.add(Restrictions.eq("biefacBail", var7));
      }

      if (var16 != null && !var16.isEmpty()) {
         var25 = var25.add(Restrictions.eq("biefacNomContact", var16));
      }

      if (var17 != null && !var17.isEmpty()) {
         var25 = var25.add(Restrictions.eq("biefacNomResponsable", var17));
      }

      if (var18 != null && !var18.isEmpty()) {
         var25 = var25.add(Restrictions.eq("biefacNomCommercial", var18));
      }

      if (var15 == 1) {
         var25 = var25.add(Restrictions.eq("biefacIdCreateur", var13));
      }

      if (!var9.equalsIgnoreCase("100")) {
         if (var9.contains(",")) {
            var37 = var9.split(",");
            int var40 = var37.length;
            String[] var38 = new String[var40];

            for(int var41 = 0; var41 < var40; ++var41) {
               var38[var41] = new String(var37[var41]);
            }

            var25 = var25.add(Restrictions.in("biefacSerie", var38));
         } else {
            var25 = var25.add(Restrictions.eq("biefacSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         var25 = var25.add(Restrictions.eq("biefacCat", var10));
      }

      if (var8 <= 10) {
         var25 = var25.add(Restrictions.eq("biefacEtat", var8));
      } else if (var8 == 11) {
         var25 = var25.add(Restrictions.isNotNull("biefacDateRelance"));
      } else if (var8 == 12) {
         var25 = var25.add(Restrictions.eq("biefacTotHt", 0.0D));
      } else if (var8 == 13) {
         var25 = var25.add(Restrictions.and(Restrictions.eq("biefacSolde", 0), Restrictions.ne("biefacEtat", 3)));
      } else if (var8 == 14) {
         var25 = var25.add(Restrictions.eq("biefacSolde", 1));
      } else if (var8 == 15) {
         var25 = var25.add(Restrictions.eq("biefacExoTva", 1));
      } else if (var8 == 16) {
         var25 = var25.add(Restrictions.and(Restrictions.eq("biefacExoTva", 1), Restrictions.isNull("biefacDateVisa")));
      } else if (var8 == 17) {
         var25 = var25.add(Restrictions.isNotNull("biefacDateTransfert"));
      } else if (var8 == 18) {
         var25 = var25.add(Restrictions.isNull("biefacDateTransfert"));
      }

      if (var12 != null && !var12.isEmpty() && !var12.equalsIgnoreCase("100") && var12.contains(":")) {
         var25 = var25.add(Restrictions.eq("biefacService", var12));
      }

      if (!var19.equalsIgnoreCase("100")) {
         var37 = var19.split(":");
         var34 = var37[0];
         var25 = var25.add(Restrictions.eq("biefacActivite", var34));
      }

      var25 = var25.addOrder(Order.desc("biefacDate"));
      var25 = var25.addOrder(Order.desc("biefacNum"));
      List var42 = var25.list();
      if (var22) {
         this.utilInitHibernate.closeSession();
      }

      return var42;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from BienFacture where biefacService='" + var1 + "' and (facDateEcheReg='" + var5 + "' or biefacTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from BienFacture where biefacDateEcheReg='" + var5 + "' or biefacTypeReg=4").list();
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheDejaPayer(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      List var6 = var3.createQuery("from BienFacture where biefacTotReglement<>0 and biefacDate>=:d1 and biefacDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from BienFacture where biefacDate>=:deb and biefacDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public BienFacture pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienFacture where biefacId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new BienFacture();
      BienFacture var7;
      if (var6.size() != 0) {
         var7 = (BienFacture)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BienFacture pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienFacture where biefacNum =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new BienFacture();
      BienFacture var6;
      if (var5.size() != 0) {
         var6 = (BienFacture)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public BienFacture pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      Query var5 = var3.createQuery("from BienFacture where biefacNum=:num and biefacSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new BienFacture();
      BienFacture var7;
      if (var6.size() != 0) {
         var7 = (BienFacture)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public BienFacture pourParapheurAutomatique(long var1, long var3, String var5, String var6, String var7, Session var8) throws HibernateException, NamingException {
      boolean var9 = false;
      if (var8 == null) {
         var8 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var9 = true;
      }

      Query var10 = var8.createQuery("from BienFacture where tiers=:tie and bien=:bien and biefacBail=:bail and biefacDateDebut=:deb and biefacDateFin=:fin and biefacType=0").setLong("tie", var1).setLong("bien", var3).setString("bail", var5).setString("deb", var6).setString("fin", var7).setMaxResults(1);
      List var11 = var10.list();
      new BienFacture();
      BienFacture var12;
      if (var11.size() != 0) {
         var12 = (BienFacture)var11.get(0);
      } else {
         var12 = null;
      }

      if (var9) {
         this.utilInitHibernate.closeSession();
      }

      return var12;
   }

   public List rechercheFactureATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from BienFacture where (biefacEtat=0 or biefacEtat=1 or biefacEtat=4) and biefacDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from BienFacture where (biefacEtat=0 or biefacEtat=1 or biefacEtat=4) and biefacDateTransfert is NULL and biefacDateDebut>=:dte1 and biefacDateDebut<=:dte2 and biefacNum>=:p1 and biefacNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from BienFacture where (biefacEtat=0 or biefacEtat=1 or biefacEtat=4) and biefacDateTransfert is NULL and biefacDateDebut>=:dte1 and biefacDateDebut<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from BienFacture where (biefacEtat=1 or biefacEtat=4) and biefacDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from BienFacture where (biefacEtat=1 or biefacEtat=4) and biefacDateTransfert is NULL and biefacDateDebut>=:dte1 and biefacDateDebut<=:dte2 and biefacNum>=:p1 and biefacNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from BienFacture where (biefacEtat=1 or biefacEtat=4) and biefacDateTransfert is NULL and biefacDateDebut>=:dte1 and biefacDateDebut<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheFactureDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from BienFacture where (facEtat=0 or biefacEtat=1 or biefacEtat=4) and (facDateTransfert<>'' and biefacDateTransfert is not null) and (facDate>=:dte1 and biefacDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from BienFacture where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
      Query var4 = var3.createQuery("from BienFacture where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var3 = true;
      }

      Query var4 = var2.createQuery("from BienFacture where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      List var6 = var3.createQuery("from BienFacture where tiers=:tie and biefacSolde=0 and biefacEtat>=1 and biefacSerie=:ser").setParameter("tie", var1).setString("ser", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheNonSoldeTiersMode(long var1, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      new ArrayList();
      boolean var8 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var8 = true;
      }

      List var9 = null;
      if (var4 != null && !var4.isEmpty()) {
         var9 = var6.createQuery("from BienFacture where tiers=:tie and biefacSolde=0 and biefacEtat>=1 and biefacSerie=:ser and biefacDate<=:d2 and biefacBail=:num order by biefacDate desc").setLong("tie", var1).setString("ser", var4).setString("d2", var5).setString("num", var3).list();
      } else {
         var9 = var6.createQuery("from BienFacture where tiers=:tie and biefacSolde=0 and biefacEtat>=1 and biefacDate<=:d2  and biefacBail=:num order by biefacDate desc").setLong("tie", var1).setString("d2", var5).setString("num", var3).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List rechercheByBail(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      List var5 = var2.createQuery("from BienFacture where biefacBail=:bail").setString("bail", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var4 = true;
      }

      List var5 = var2.createQuery("from BienFacture where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCommissions(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      List var6 = var3.createQuery("from BienFacture where biefacSolde=1 and biefacDate>=:d1 and biefacDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFacturePeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var5 = true;
      }

      List var6 = var3.createQuery("from BienFacture where biefacDate>=:d1 and biefacDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BiensImmobilier");
         var6 = true;
      }

      List var7 = var4.createQuery("from BienFacture where biefacDate>=:d1 and biefacSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
