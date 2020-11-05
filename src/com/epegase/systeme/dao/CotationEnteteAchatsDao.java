package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.ExercicesAchats;
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

public class CotationEnteteAchatsDao implements Serializable {
   private CotationEnteteAchats cotationEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CotationEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CotationEnteteAchats insert(CotationEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CotationEnteteAchats modif(CotationEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
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

   public CotationEnteteAchats modif(CotationEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from CotationEnteteAchats where cotId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public CotationEnteteAchats duppliquer(CotationEnteteAchats var1, Session var2) {
      CotationEnteteAchats var3 = new CotationEnteteAchats();
      var3.setCotActivite(var1.getCotActivite());
      var3.setCotAnal2(var1.getCotAnal2());
      var3.setCotAnal4(var1.getCotAnal4());
      var3.setCotAffaire(var1.getCotAffaire());
      var3.setCotAnnexe1(var1.getCotAnnexe1());
      var3.setCotAnnexe2(var1.getCotAnnexe2());
      var3.setCotArrondiReg(var1.getCotArrondiReg());
      var3.setCotBanque(var1.getCotBanque());
      var3.setCotBudget(var1.getCotBanque());
      var3.setCotBudgetDispo(var1.getCotBudgetDispo());
      var3.setCotBudgetDispoMois(var1.getCotBudgetDispoMois());
      var3.setCotBudgetTreso(var1.getCotBudgetTreso());
      var3.setCotBudgetTresoMois(var1.getCotBudgetTresoMois());
      var3.setCotCat(var1.getCotCat());
      var3.setCotCivilContact(var1.getCotCivilContact());
      var3.setCotCivilTiers(var1.getCotCivilTiers());
      var3.setCotCoefDevise(var1.getCotCoefDevise());
      var3.setCotConditionReg(var1.getCotConditionReg());
      var3.setCotContrat(var1.getCotContrat());
      var3.setCotDate(var1.getCotDate());
      var3.setCotDateLivraison(var1.getCotDateLivraison());
      var3.setCotDepartement(var1.getCotDepartement());
      var3.setCotDevise(var1.getCotDevise());
      var3.setCotDiversAdresse(var1.getCotDiversAdresse());
      var3.setCotDiversMail(var1.getCotDiversMail());
      var3.setCotDiversNom(var1.getCotDiversNom());
      var3.setCotDiversTel(var1.getCotDiversTel());
      var3.setCotDiversTiers(var1.getCotDiversTiers());
      var3.setCotDiversVille(var1.getCotDiversVille());
      var3.setCotEtat(var1.getCotEtat());
      var3.setCotEtatVal(var1.getCotEtatVal());
      var3.setCotExoDouane(var1.getCotExoDouane());
      var3.setCotExoTva(var1.getCotExoTva());
      var3.setCotFormule1(var1.getCotFormule1());
      var3.setCotFormule2(var1.getCotFormule2());
      var3.setCotGele(var1.getCotGele());
      var3.setCotIdContact(var1.getCotIdContact());
      var3.setCotIdResponsable(var1.getCotIdResponsable());
      var3.setCotIncoterm(var1.getCotIncoterm());
      var3.setCotInfo1(var1.getCotInfo1());
      var3.setCotInfo10(var1.getCotInfo10());
      var3.setCotInfo2(var1.getCotInfo2());
      var3.setCotInfo3(var1.getCotInfo3());
      var3.setCotInfo4(var1.getCotInfo4());
      var3.setCotInfo5(var1.getCotInfo5());
      var3.setCotInfo6(var1.getCotInfo6());
      var3.setCotInfo7(var1.getCotInfo7());
      var3.setCotInfo8(var1.getCotInfo8());
      var3.setCotInfo9(var1.getCotInfo9());
      var3.setCotInfoLivraison(var1.getCotInfoLivraison());
      var3.setCotLieuLivraison(var1.getCotLieuLivraison());
      var3.setCotModeReg(var1.getCotModeReg());
      var3.setCotModeleImp(var1.getCotModeleImp());
      var3.setCotModelePr(var1.getCotModelePr());
      var3.setCotMotifAnnule(var1.getCotMotifAnnule());
      var3.setCotNbJourReg(var1.getCotNbJourReg());
      var3.setCotNomContact(var1.getCotNomContact());
      var3.setCotNomResponsable(var1.getCotNomResponsable());
      var3.setCotNomTiers(var1.getCotNomTiers());
      var3.setCotNum(var1.getCotNum());
      var3.setCotObject(var1.getCotObject());
      var3.setCotObservation(var1.getCotObservation());
      var3.setCotPdv(var1.getCotPdv());
      var3.setCotRegion(var1.getCotRegion());
      var3.setCotSecteur(var1.getCotSecteur());
      var3.setCotSource(var1.getCotSource());
      var3.setCotSerie(var1.getCotSerie());
      var3.setCotService(var1.getCotService());
      var3.setCotSite(var1.getCotSite());
      var3.setCotTotHt(var1.getCotTotHt());
      var3.setCotTotPoidsBrut(var1.getCotTotPoidsBrut());
      var3.setCotTotQte(var1.getCotTotQte());
      var3.setCotTotRabais(var1.getCotTotRabais());
      var3.setCotTotRemise(var1.getCotTotRemise());
      var3.setCotTotTc(var1.getCotTotTc());
      var3.setCotTotTtc(var1.getCotTotTtc());
      var3.setCotTotTva(var1.getCotTotTva());
      var3.setCotTypeImp(var1.getCotTypeImp());
      var3.setCotTypeReg(var1.getCotTypeReg());
      var3.setCotTypeTransforme(var1.getCotTypeTransforme());
      var3.setExercicesAchats(var1.getExercicesAchats());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from CotationEnteteAchats order by cotId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            CotationEnteteAchats var7 = (CotationEnteteAchats)var6.get(0);
            var4 = 1L + var7.getCotId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public CotationEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from CotationEnteteAchats where exercicesAchats.exeachId=:id and cotSerie =:ser and year(cotDate)=" + var7 + " order by cotDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      CotationEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (CotationEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public CotationEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from CotationEnteteAchats where exercicesAchats.exeachId=:id and cotSerie =:ser and year(cotDate)=" + var7 + " and month(cotDate)=" + var8 + " order by cotDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      CotationEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (CotationEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, long var5, String var7, int var8, String var9, String var10, String var11, String var12, long var13, int var15, String var16, String var17, String var18, String var19, String var20, String var21) throws HibernateException, NamingException, ParseException {
      boolean var22 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var22 = true;
      }

      UtilDate var23 = new UtilDate();
      new ArrayList();
      Criteria var25 = var1.createCriteria(CotationEnteteAchats.class);
      Calendar var26 = Calendar.getInstance();
      Date var27 = null;
      Date var28 = null;
      Date var29 = new Date();
      String var30 = var23.dateToStringFr(var29);
      String var31 = var30.substring(6, 10) + "-" + var30.substring(3, 5) + "-" + var30.substring(0, 2);
      var27 = var23.stringToDateSQL(var31 + " 00:00:00");
      var28 = var23.stringToDateSQL(var31 + " 23:59:59");
      int var32 = var29.getYear() + 1900;
      String var33;
      String var34;
      if (var11.equalsIgnoreCase("100")) {
         if (var20 != null && var21 != null) {
            var27 = var23.stringToDateSQL(var20 + " 00:00:00");
            var28 = var23.stringToDateSQL(var21 + " 23:59:59");
            var25 = var25.add(Restrictions.between("cotDate", var27, var28));
         } else {
            var25 = var25.add(Restrictions.isNotNull("cotDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var25 = var25.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var25 = var25.add(Restrictions.between("cotDate", var27, var28));
         } else if (var11.equalsIgnoreCase("1")) {
            var33 = "" + var26.getTime();
            if (var33.contains("Mon")) {
               var27 = var26.getTime();
            } else if (var33.contains("Tue")) {
               var26.add(7, -1);
               var27 = var26.getTime();
            } else if (var33.contains("Wed")) {
               var26.add(7, -2);
               var27 = var26.getTime();
            } else if (var33.contains("Thu")) {
               var26.add(7, -3);
               var27 = var26.getTime();
            } else if (var33.contains("Fri")) {
               var26.add(7, -4);
               var27 = var26.getTime();
            } else if (var33.contains("Sat")) {
               var26.add(7, -5);
               var27 = var26.getTime();
            } else if (var33.contains("Sun")) {
               var26.add(7, -6);
               var27 = var26.getTime();
            }

            var30 = var23.dateToStringFr(var27);
            var31 = var30.substring(6, 10) + "-" + var30.substring(3, 5) + "-" + var30.substring(0, 2);
            var27 = var23.stringToDateSQL(var31 + " 00:00:00");
            var25 = var25.add(Restrictions.between("cotDate", var27, var28));
         } else {
            int var37;
            if (var11.equalsIgnoreCase("2")) {
               var37 = var26.get(2) + 1;
               var34 = var32 + "-" + var37 + "-01";
               var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("3")) {
               var37 = var26.get(2);
               var26.add(5, -var37);
               if (var37 <= 3) {
                  var34 = var32 + "-01-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               } else if (var37 >= 4 && var37 <= 6) {
                  var34 = var32 + "-04-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               } else if (var37 >= 7 && var37 <= 9) {
                  var34 = var32 + "-07-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               } else if (var37 >= 10) {
                  var34 = var32 + "-10-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               }

               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("4")) {
               var37 = var26.get(2);
               var26.add(5, -var37);
               if (var37 <= 6) {
                  var34 = var32 + "-01-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               } else {
                  var34 = var32 + "-07-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               }

               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("5")) {
               var33 = var32 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-03-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("6")) {
               var33 = var32 + "-04-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-06-30";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("7")) {
               var33 = var32 + "-07-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-09-30";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("8")) {
               var33 = var32 + "-10-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("9")) {
               var33 = var32 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-06-30";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("10")) {
               var33 = var32 + "-07-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("11")) {
               var33 = var32 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("12")) {
               var33 = "1980-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 - 1 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("13")) {
               var33 = var32 - 1 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("14")) {
               var33 = var32 - 1 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 - 1 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("cotDate", var27, var28));
            } else if (var11.equalsIgnoreCase("20")) {
               var25.setMaxResults(20);
               var25 = var25.addOrder(Order.desc("cotId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var33 = "%" + var4 + "%";
         var25 = var25.add(Restrictions.like("cotNum", var33));
      }

      if (var5 != 0L) {
         var25 = var25.add(Restrictions.eq("tiers.tieid", var5));
      } else if (var7 != null && !var7.isEmpty()) {
         var33 = "";
         if (var7.startsWith("*")) {
            var33 = "%" + var7.substring(1) + "%";
         } else {
            var33 = var7 + "%";
         }

         var25 = var25.add(Restrictions.or(Restrictions.like("cotNomTiers", var33), Restrictions.like("cotDiversNom", var33)));
      }

      if (var17 != null && !var17.isEmpty()) {
         var25 = var25.add(Restrictions.eq("cotNomResponsable", var17));
      }

      if (var15 == 1) {
         var25 = var25.add(Restrictions.eq("cotIdCreateur", var13));
      }

      String[] var38;
      if (!var9.equalsIgnoreCase("100")) {
         if (var9.contains(",")) {
            var38 = var9.split(",");
            int var39 = var38.length;
            String[] var35 = new String[var39];

            for(int var36 = 0; var36 < var39; ++var36) {
               var35[var36] = new String(var38[var36]);
            }

            var25 = var25.add(Restrictions.in("cotSerie", var35));
         } else {
            var25 = var25.add(Restrictions.eq("cotSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         var25 = var25.add(Restrictions.eq("cotCat", var10));
      }

      if (var8 <= 10) {
         var25 = var25.add(Restrictions.eq("cotEtat", var8));
      } else if (var8 == 11) {
         var25 = var25.add(Restrictions.isNotNull("cotDateRelance"));
      } else if (var8 == 12) {
         var25 = var25.add(Restrictions.eq("cotExoTva", 1));
      }

      if (var12 != null && !var12.isEmpty() && !var12.equalsIgnoreCase("100") && var12.contains(":")) {
         var25 = var25.add(Restrictions.eq("cotService", var12));
      }

      if (!var18.equalsIgnoreCase("100")) {
         var38 = var18.split(":");
         var34 = var38[0];
         var25 = var25.add(Restrictions.eq("cotActivite", var34));
      }

      if (!var16.equalsIgnoreCase("100")) {
         var38 = var16.split(":");
         var34 = var38[0];
         var25 = var25.add(Restrictions.eq("cotBudget", var34));
      }

      if (var19 != null && !var19.isEmpty()) {
         var33 = "%" + var19 + "%";
         var25 = var25.add(Restrictions.like("cotAnal4", var33));
      }

      var25 = var25.addOrder(Order.desc("cotDate"));
      var25 = var25.addOrder(Order.desc("cotNum"));
      List var40 = var25.list();
      if (var22) {
         this.utilInitHibernate.closeSession();
      }

      return var40;
   }

   public CotationEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CotationEnteteAchats where cotId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new CotationEnteteAchats();
      CotationEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (CotationEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CotationEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CotationEnteteAchats where cotNum=:num and cotSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new CotationEnteteAchats();
      CotationEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (CotationEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
      Query var4 = var3.createQuery("from CotationEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from CotationEnteteAchats where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from CotationEnteteAchats where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCotationRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CotationEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCotationByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from CotationEnteteAchats where cotDate>=:deb and cotDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheCotationCampagne(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CotationEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from CotationEnteteAchats where cotSource like '" + var1 + "%'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
