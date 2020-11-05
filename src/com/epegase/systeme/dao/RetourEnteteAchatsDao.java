package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.RetourEnteteAchats;
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

public class RetourEnteteAchatsDao implements Serializable {
   private RetourEnteteAchats retourEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public RetourEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public RetourEnteteAchats insert(RetourEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public RetourEnteteAchats modif(RetourEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
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

   public RetourEnteteAchats modif(RetourEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from RetourEnteteAchats where brfId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public RetourEnteteAchats duppliquer(RetourEnteteAchats var1, Session var2) {
      RetourEnteteAchats var3 = new RetourEnteteAchats();
      var3.setBrfIdCreateur(var1.getBrfIdCreateur());
      var3.setBrfNomCreateur(var1.getBrfNomCreateur());
      var3.setBrfDate(var1.getBrfDate());
      var3.setBrfDateCreat(new Date());
      var3.setBrfDateModif((Date)null);
      var3.setBrfIdModif(0L);
      var3.setBrfNomModif("");
      var3.setBrfNum(var1.getBrfNum());
      var3.setBrfDateRelance((Date)null);
      var3.setBrfDateValidite((Date)null);
      var3.setBrfService(var1.getBrfService());
      var3.setBrfNomResponsable(var1.getBrfNomResponsable());
      var3.setBrfIdResponsable(var1.getBrfIdResponsable());
      var3.setBrfNomTiers(var1.getBrfNomTiers());
      var3.setBrfCivilTiers(var1.getBrfCivilTiers());
      var3.setBrfIdContact(var1.getBrfIdContact());
      var3.setBrfNomContact(var1.getBrfNomContact());
      var3.setBrfCivilContact(var1.getBrfCivilContact());
      var3.setBrfDiversAdresse(var1.getBrfDiversAdresse());
      var3.setBrfDiversMail(var1.getBrfDiversMail());
      var3.setBrfDiversNom(var1.getBrfDiversNom());
      var3.setBrfDiversTel(var1.getBrfDiversTel());
      var3.setBrfDiversTiers(var1.getBrfDiversTiers());
      var3.setBrfDiversVille(var1.getBrfDiversVille());
      var3.setBrfSource(var1.getBrfSource());
      var3.setBrfSerie(var1.getBrfSerie());
      var3.setBrfExoTva(var1.getBrfExoTva());
      var3.setBrfExoDouane(var1.getBrfExoDouane());
      var3.setBrfJournalReg(var1.getBrfJournalReg());
      var3.setBrfCat(var1.getBrfCat());
      var3.setBrfDevise(var1.getBrfDevise());
      var3.setBrfObject(var1.getBrfObject());
      var3.setBrfObservation(var1.getBrfObservation());
      var3.setBrfTotHt(var1.getBrfTotHt());
      var3.setBrfTotRemise(var1.getBrfTotRemise());
      var3.setBrfTotRabais(var1.getBrfTotRabais());
      var3.setBrfTotTva(var1.getBrfTotTva());
      var3.setBrfTotTc(var1.getBrfTotTc());
      var3.setBrfTotTtc(var1.getBrfTotTtc());
      var3.setBrfTotReglement(var1.getBrfTotReglement());
      var3.setBrfSolde(var1.getBrfSolde());
      var3.setBrfBanque(var1.getBrfBanque());
      var3.setBrfTypeReg(var1.getBrfTypeReg());
      var3.setBrfModeReg(var1.getBrfModeReg());
      var3.setBrfNbJourReg(var1.getBrfNbJourReg());
      var3.setBrfArrondiReg(var1.getBrfArrondiReg());
      var3.setBrfConditionReg(var1.getBrfConditionReg());
      var3.setBrfDateEcheReg(var1.getBrfDateEcheReg());
      var3.setBrfActivite(var1.getBrfActivite());
      var3.setBrfSite(var1.getBrfSite());
      var3.setBrfDepartement(var1.getBrfDepartement());
      var3.setBrfRegion(var1.getBrfRegion());
      var3.setBrfSecteur(var1.getBrfSecteur());
      var3.setBrfPdv(var1.getBrfPdv());
      var3.setBrfAnal2(var1.getBrfAnal2());
      var3.setBrfAnal4(var1.getBrfAnal4());
      var3.setBrfAffaire(var1.getBrfAffaire());
      var3.setBrfInfo1(var1.getBrfInfo1());
      var3.setBrfInfo2(var1.getBrfInfo2());
      var3.setBrfInfo3(var1.getBrfInfo3());
      var3.setBrfInfo4(var1.getBrfInfo4());
      var3.setBrfInfo5(var1.getBrfInfo5());
      var3.setBrfInfo6(var1.getBrfInfo6());
      var3.setBrfInfo7(var1.getBrfInfo7());
      var3.setBrfInfo8(var1.getBrfInfo8());
      var3.setBrfInfo9(var1.getBrfInfo9());
      var3.setBrfInfo10(var1.getBrfInfo10());
      var3.setBrfFormule1(var1.getBrfFormule1());
      var3.setBrfFormule2(var1.getBrfFormule2());
      var3.setBrfAnnexe1(var1.getBrfAnnexe1());
      var3.setBrfAnnexe2(var1.getBrfAnnexe2());
      var3.setBrfContrat(var1.getBrfContrat());
      var3.setBrfIncoterm(var1.getBrfIncoterm());
      var3.setBrfLieuLivraison(var1.getBrfLieuLivraison());
      var3.setBrfDateLivraison(var1.getBrfDateLivraison());
      var3.setBrfInfoLivraison(var1.getBrfInfoLivraison());
      var3.setBrfDateImp((Date)null);
      var3.setBrfModeleImp(var1.getBrfModeleImp());
      var3.setBrfGele(0);
      var3.setBrfEtat(0);
      var3.setBrfDateTransforme((Date)null);
      var3.setBrfTypeTransforme(0);
      var3.setBrfDateAnnule((Date)null);
      var3.setBrfMotifAnnule("");
      var3.setBrfFactorNom(var1.getBrfFactorNom());
      var3.setBrfFactorId(var1.getBrfFactorId());
      var3.setBrfFactorEtat(var1.getBrfFactorEtat());
      var3.setExercicesAchats(var1.getExercicesAchats());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var3.setExercicesAchats(var1.getExercicesAchats());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from RetourEnteteAchats order by brfId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            RetourEnteteAchats var7 = (RetourEnteteAchats)var6.get(0);
            var4 = 1L + var7.getBrfId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public RetourEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from RetourEnteteAchats where exercicesAchats.exeachId=:id and brfSerie =:ser and year(brfDate)=" + var7 + " order by brfDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      RetourEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (RetourEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public RetourEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from RetourEnteteAchats where exercicesAchats.exeachId=:id and brfSerie =:ser and year(brfDate)=" + var7 + " and month(brfDate)=" + var8 + " order by brfDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      RetourEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (RetourEnteteAchats)var11.get(0);
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
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var23 = true;
      }

      UtilDate var24 = new UtilDate();
      new ArrayList();
      Criteria var26 = var1.createCriteria(RetourEnteteAchats.class);
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
            var26 = var26.add(Restrictions.between("brfDate", var28, var29));
         } else {
            var26 = var26.add(Restrictions.isNotNull("brfDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var26 = var26.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var26 = var26.add(Restrictions.between("brfDate", var28, var29));
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
            var26 = var26.add(Restrictions.between("brfDate", var28, var29));
         } else {
            int var38;
            if (var11.equalsIgnoreCase("2")) {
               var38 = var27.get(2) + 1;
               var35 = var33 + "-" + var38 + "-01";
               var28 = var24.stringToDateSQL(var35 + " 00:00:00");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
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

               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
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

               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("5")) {
               var34 = var33 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-03-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("6")) {
               var34 = var33 + "-04-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-06-30";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("7")) {
               var34 = var33 + "-07-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-09-30";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("8")) {
               var34 = var33 + "-10-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("9")) {
               var34 = var33 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-06-30";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("10")) {
               var34 = var33 + "-07-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("11")) {
               var34 = var33 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("12")) {
               var34 = "1980-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 - 1 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("13")) {
               var34 = var33 - 1 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("14")) {
               var34 = var33 - 1 + "-01-01";
               var28 = var24.stringToDateSQL(var34 + " 00:00:00");
               var35 = var33 - 1 + "-12-31";
               var29 = var24.stringToDateSQL(var35 + " 23:59:59");
               var26 = var26.add(Restrictions.between("brfDate", var28, var29));
            } else if (var11.equalsIgnoreCase("20")) {
               var26.setMaxResults(20);
               var26 = var26.addOrder(Order.desc("brfId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var34 = "%" + var4 + "%";
         var26 = var26.add(Restrictions.like("brfNum", var34));
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

         var26 = var26.add(Restrictions.or(Restrictions.like("brfNomTiers", var34), Restrictions.like("brfDiversNom", var34)));
      }

      if (var17 != null && !var17.isEmpty()) {
         var26 = var26.add(Restrictions.eq("brfNomResponsable", var17));
      }

      if (var15 == 1) {
         var26 = var26.add(Restrictions.eq("brfIdCreateur", var13));
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

            var26 = var26.add(Restrictions.in("brfSerie", var36));
         } else {
            var26 = var26.add(Restrictions.eq("brfSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         var26 = var26.add(Restrictions.eq("brfCat", var10));
      }

      if (var8 <= 10) {
         var26 = var26.add(Restrictions.eq("brfEtat", var8));
      }

      if (var12 != null && !var12.isEmpty() && !var12.equalsIgnoreCase("100") && var12.contains(":")) {
         var26 = var26.add(Restrictions.eq("brfService", var12));
      }

      if (!var18.equalsIgnoreCase("100")) {
         var39 = var18.split(":");
         var35 = var39[0];
         var26 = var26.add(Restrictions.eq("brfActivite", var35));
      }

      if (!var16.equalsIgnoreCase("100")) {
         var39 = var16.split(":");
         var35 = var39[0];
         var26 = var26.add(Restrictions.eq("brfBudget", var35));
      }

      if (var19 != null && !var19.isEmpty()) {
         var34 = "%" + var19 + "%";
         var26 = var26.add(Restrictions.or(Restrictions.like("brfAffaire", var34), Restrictions.like("brfAnal4", var34)));
      }

      if (var20 != null && !var20.isEmpty()) {
         var34 = "%" + var20 + "%";
         var26 = var26.add(Restrictions.like("brfAnal4", var34));
      }

      var26 = var26.addOrder(Order.desc("brfDate"));
      var26 = var26.addOrder(Order.desc("brfNum"));
      List var41 = var26.list();
      if (var23) {
         this.utilInitHibernate.closeSession();
      }

      return var41;
   }

   public RetourEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from RetourEnteteAchats where brfId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new RetourEnteteAchats();
      RetourEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (RetourEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public RetourEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from RetourEnteteAchats where brfNum=:num and brfSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new RetourEnteteAchats();
      RetourEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (RetourEnteteAchats)var6.get(0);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from RetourEnteteAchats where brfAnal4 =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheByValo(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from RetourEnteteAchats where brfValo =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheNonValoriser(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var2 = true;
      }

      new ArrayList();
      Query var4 = var1.createQuery("from RetourEnteteAchats where  (brfValo='' or brfValo is NULL)");
      List var3 = var4.list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var3;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
      Query var4 = var3.createQuery("from RetourEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from RetourEnteteAchats where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from RetourEnteteAchats where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheRetourRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from RetourEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheRetourByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "RetourEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from RetourEnteteAchats where brfDate>=:deb and brfDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
