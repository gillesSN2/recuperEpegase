package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DemandeEnteteAchats;
import com.epegase.systeme.classe.ExercicesAchats;
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

public class DemandeEnteteAchatsDao implements Serializable {
   private DemandeEnteteAchats demandeEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public DemandeEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public DemandeEnteteAchats insert(DemandeEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public DemandeEnteteAchats modif(DemandeEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
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

   public DemandeEnteteAchats modif(DemandeEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from DemandeEnteteAchats where demId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public DemandeEnteteAchats duppliquer(DemandeEnteteAchats var1, Session var2) {
      DemandeEnteteAchats var3 = new DemandeEnteteAchats();
      var3.setDemActivite(var1.getDemActivite());
      var3.setDemAnal2(var1.getDemAnal2());
      var3.setDemAnal4(var1.getDemAnal4());
      var3.setDemAnnexe1(var1.getDemAnnexe1());
      var3.setDemAnnexe2(var1.getDemAnnexe2());
      var3.setDemBudget(var1.getDemBudget());
      var3.setDemBudgetDispo(var1.getDemBudgetDispo());
      var3.setDemBudgetDispoMois(var1.getDemBudgetDispoMois());
      var3.setDemBudgetTreso(var1.getDemBudgetTreso());
      var3.setDemBudgetTresoMois(var1.getDemBudgetTresoMois());
      var3.setDemDate(var1.getDemDate());
      var3.setDemDateAnnule((Date)null);
      var3.setDemDateCreat(var1.getDemDateCreat());
      var3.setDemDateImp((Date)null);
      var3.setDemDateModif((Date)null);
      var3.setDemDateRelance((Date)null);
      var3.setDemDateTransforme((Date)null);
      var3.setDemDateValide(var1.getDemDateValide());
      var3.setDemDateValidite(var1.getDemDateValidite());
      var3.setDemEtat(0);
      var3.setDemEtatVal(var1.getDemEtatVal());
      var3.setDemFormule1(var1.getDemFormule1());
      var3.setDemFormule2(var1.getDemFormule2());
      var3.setDemGele(0);
      var3.setDemIdCreateur(var1.getDemIdCreateur());
      var3.setDemIdModif(0L);
      var3.setDemIdResponsable(var1.getDemIdResponsable());
      var3.setDemInfo1(var1.getDemInfo1());
      var3.setDemInfo2(var1.getDemInfo2());
      var3.setDemInfo3(var1.getDemInfo3());
      var3.setDemInfo4(var1.getDemInfo4());
      var3.setDemInfo5(var1.getDemInfo5());
      var3.setDemInfo6(var1.getDemInfo6());
      var3.setDemInfo7(var1.getDemInfo7());
      var3.setDemInfo8(var1.getDemInfo8());
      var3.setDemInfo9(var1.getDemInfo9());
      var3.setDemInfo10(var1.getDemInfo10());
      var3.setDemModeleImp(var1.getDemModeleImp());
      var3.setDemMotifAnnule((String)null);
      var3.setDemNomCreateur(var1.getDemNomCreateur());
      var3.setDemNomModif((String)null);
      var3.setDemNomResponsable(var1.getDemNomResponsable());
      var3.setDemNum(var1.getDemNum());
      var3.setDemObject(var1.getDemObject());
      var3.setDemObservation(var1.getDemObservation());
      var3.setDemPdv(var1.getDemPdv());
      var3.setDemRegion(var1.getDemRegion());
      var3.setDemSecteur(var1.getDemSecteur());
      var3.setDemSource(var1.getDemSource());
      var3.setDemSerie(var1.getDemSerie());
      var3.setDemService(var1.getDemService());
      var3.setDemSite(var1.getDemSite());
      var3.setDemTotHt(var1.getDemTotHt());
      var3.setDemTotTc(var1.getDemTotTc());
      var3.setDemTotTtc(var1.getDemTotTtc());
      var3.setDemTotTva(var1.getDemTotTva());
      var3.setDemTypeTransforme(0);
      var3.setExercicesAchats(var1.getExercicesAchats());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from DemandeEnteteAchats order by demId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            DemandeEnteteAchats var7 = (DemandeEnteteAchats)var6.get(0);
            var4 = 1L + var7.getDemId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public DemandeEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from DemandeEnteteAchats where exercicesAchats.exeachId=:id and demSerie =:ser and year(demDate)=" + var7 + " order by demDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      DemandeEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (DemandeEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public DemandeEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from DemandeEnteteAchats where exercicesAchats.exeachId=:id and demSerie =:ser and year(demDate)=" + var7 + " and month(demDate)=" + var8 + " order by demDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      DemandeEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (DemandeEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, int var5, String var6, String var7, String var8, long var9, int var11, String var12, String var13, String var14, String var15, String var16) throws HibernateException, NamingException, ParseException {
      boolean var17 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var17 = true;
      }

      UtilDate var18 = new UtilDate();
      new ArrayList();
      Criteria var20 = var1.createCriteria(DemandeEnteteAchats.class);
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
      String var29;
      if (var7.equalsIgnoreCase("100")) {
         if (var15 != null && var16 != null) {
            var22 = var18.stringToDateSQL(var15 + " 00:00:00");
            var23 = var18.stringToDateSQL(var16 + " 23:59:59");
            var20 = var20.add(Restrictions.between("demDate", var22, var23));
         } else {
            var28 = "1980-01-01";
            var18.stringToDateSQL(var28 + " 00:00:00");
            var20 = var20.add(Restrictions.isNotNull("demDate"));
         }
      } else {
         if (!var7.equalsIgnoreCase("12") && !var7.equalsIgnoreCase("13") && !var7.equalsIgnoreCase("14")) {
            var20 = var20.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var7.equalsIgnoreCase("0")) {
            var20 = var20.add(Restrictions.between("demDate", var22, var23));
         } else if (var7.equalsIgnoreCase("1")) {
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
            var20 = var20.add(Restrictions.between("demDate", var22, var23));
         } else {
            int var32;
            if (var7.equalsIgnoreCase("2")) {
               var32 = var21.get(2) + 1;
               var29 = var27 + "-" + var32 + "-01";
               var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("3")) {
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

               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("4")) {
               var32 = var21.get(2);
               var21.add(5, -var32);
               if (var32 <= 6) {
                  var29 = var27 + "-01-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               } else {
                  var29 = var27 + "-07-01";
                  var22 = var18.stringToDateSQL(var29 + " 00:00:00");
               }

               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("5")) {
               var28 = var27 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-03-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("6")) {
               var28 = var27 + "-04-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-06-30";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("7")) {
               var28 = var27 + "-07-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-09-30";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("8")) {
               var28 = var27 + "-10-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("9")) {
               var28 = var27 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-06-30";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("10")) {
               var28 = var27 + "-07-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("11")) {
               var28 = var27 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("12")) {
               var28 = "1980-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 - 1 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("13")) {
               var28 = var27 - 1 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("14")) {
               var28 = var27 - 1 + "-01-01";
               var22 = var18.stringToDateSQL(var28 + " 00:00:00");
               var29 = var27 - 1 + "-12-31";
               var23 = var18.stringToDateSQL(var29 + " 23:59:59");
               var20 = var20.add(Restrictions.between("demDate", var22, var23));
            } else if (var7.equalsIgnoreCase("20")) {
               var20.setMaxResults(20);
               var20 = var20.addOrder(Order.desc("demId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var28 = "%" + var4 + "%";
         var20 = var20.add(Restrictions.like("demNum", var28));
      }

      if (var13 != null && !var13.isEmpty()) {
         var20 = var20.add(Restrictions.eq("demNomResponsable", var13));
      }

      if (var11 == 1) {
         var20 = var20.add(Restrictions.eq("demIdCreateur", var9));
      }

      String[] var33;
      if (!var6.equalsIgnoreCase("100")) {
         if (var6.contains(",")) {
            var33 = var6.split(",");
            int var35 = var33.length;
            String[] var30 = new String[var35];

            for(int var31 = 0; var31 < var35; ++var31) {
               var30[var31] = new String(var33[var31]);
            }

            var20 = var20.add(Restrictions.in("demSerie", var30));
         } else {
            var20 = var20.add(Restrictions.eq("demSerie", var6));
         }
      }

      if (var5 <= 10) {
         var20 = var20.add(Restrictions.eq("demEtat", var5));
      } else if (var5 == 12) {
         var20 = var20.add(Restrictions.eq("demTotHt", 0.0D));
      }

      if (var8 != null && !var8.isEmpty() && !var8.equalsIgnoreCase("100") && var8.contains(":")) {
         var20 = var20.add(Restrictions.eq("demService", var8));
      }

      if (!var14.equalsIgnoreCase("100")) {
         var33 = var14.split(":");
         var29 = var33[0];
         var20 = var20.add(Restrictions.eq("demActivite", var29));
      }

      var20 = var20.addOrder(Order.desc("demNum"));
      List var34 = var20.list();
      if (var17) {
         this.utilInitHibernate.closeSession();
      }

      return var34;
   }

   public DemandeEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from DemandeEnteteAchats where demId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new DemandeEnteteAchats();
      DemandeEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (DemandeEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public DemandeEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from DemandeEnteteAchats where demNum=:num and demSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new DemandeEnteteAchats();
      DemandeEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (DemandeEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
      Query var4 = var3.createQuery("from DemandeEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
      List var5 = var4.list();
      boolean var6 = false;
      if (var5.size() != 0) {
         var6 = true;
      }

      this.utilInitHibernate.closeSession();
      return var6;
   }

   public List rechercheDemandeByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DemandeEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from DemandeEnteteAchats where demDate>=:deb and demDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
