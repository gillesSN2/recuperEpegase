package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.RetourEnteteVentes;
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

public class RetourEnteteVentesDao implements Serializable {
   private RetourEnteteVentes retourEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public RetourEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public RetourEnteteVentes insert(RetourEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public RetourEnteteVentes modif(RetourEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
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

   public RetourEnteteVentes modif(RetourEnteteVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from RetourEnteteVentes where brtId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public RetourEnteteVentes duppliquer(RetourEnteteVentes var1, Session var2) {
      RetourEnteteVentes var3 = new RetourEnteteVentes();
      var3.setBrtSerie(var1.getBrtSerie());
      var3.setBrtIdCreateur(var1.getBrtIdCreateur());
      var3.setBrtNomCreateur(var1.getBrtNomCreateur());
      var3.setBrtDate(var1.getBrtDate());
      var3.setBrtDateCreat(var1.getBrtDateCreat());
      var3.setBrtDateModif(var1.getBrtDateModif());
      var3.setBrtIdModif(var1.getBrtIdModif());
      var3.setBrtNomModif(var1.getBrtNomModif());
      var3.setBrtNum(var1.getBrtNum());
      var3.setBrtDateRelance(var1.getBrtDateRelance());
      var3.setBrtDateValidite(var1.getBrtDateValidite());
      var3.setBrtService(var1.getBrtService());
      var3.setBrtSource(var1.getBrtSource());
      var3.setBrtNomResponsable(var1.getBrtNomResponsable());
      var3.setBrtIdResponsable(var1.getBrtIdResponsable());
      var3.setBrtNomCommercial(var1.getBrtNomCommercial());
      var3.setBrtIdCommercial(var1.getBrtIdCommercial());
      var3.setBrtNomTiers(var1.getBrtNomTiers());
      var3.setBrtCivilTiers(var1.getBrtCivilTiers());
      var3.setBrtTiersRegroupe(var1.getBrtTiersRegroupe());
      var3.setBrtIdContact(var1.getBrtIdContact());
      var3.setBrtNomContact(var1.getBrtNomContact());
      var3.setBrtCivilContact(var1.getBrtCivilContact());
      var3.setBrtDiversAdresse(var1.getBrtDiversAdresse());
      var3.setBrtDiversMail(var1.getBrtDiversMail());
      var3.setBrtDiversNom(var1.getBrtDiversNom());
      var3.setBrtDiversTel(var1.getBrtDiversTel());
      var3.setBrtDiversTiers(var1.getBrtDiversTiers());
      var3.setBrtDiversVille(var1.getBrtDiversVille());
      var3.setBrtExoTva(var1.getBrtExoTva());
      var3.setBrtExoDouane(var1.getBrtExoDouane());
      var3.setBrtJournalReg(var1.getBrtJournalReg());
      var3.setBrtCat(var1.getBrtCat());
      var3.setBrtDevise(var1.getBrtDevise());
      var3.setBrtObject(var1.getBrtObject());
      var3.setBrtObservation(var1.getBrtObservation());
      var3.setBrtTauxRemise(var1.getBrtTauxRemise());
      var3.setBrtTotHt(var1.getBrtTotHt());
      var3.setBrtTotRemise(var1.getBrtTotRemise());
      var3.setBrtTotRabais(var1.getBrtTotRabais());
      var3.setBrtTotTva(var1.getBrtTotTva());
      var3.setBrtTotTc(var1.getBrtTotTc());
      var3.setBrtTotTtc(var1.getBrtTotTtc());
      var3.setBrtTotReglement(var1.getBrtTotReglement());
      var3.setBrtSolde(var1.getBrtSolde());
      var3.setBrtBanque(var1.getBrtBanque());
      var3.setBrtTypeReg(var1.getBrtTypeReg());
      var3.setBrtModeReg(var1.getBrtModeReg());
      var3.setBrtNbJourReg(var1.getBrtNbJourReg());
      var3.setBrtArrondiReg(var1.getBrtArrondiReg());
      var3.setBrtConditionReg(var1.getBrtConditionReg());
      var3.setBrtDateEcheReg(var1.getBrtDateEcheReg());
      var3.setBrtContener(var1.getBrtContener());
      var3.setBrtActivite(var1.getBrtActivite());
      var3.setBrtSite(var1.getBrtSite());
      var3.setBrtDepartement(var1.getBrtDepartement());
      var3.setBrtRegion(var1.getBrtRegion());
      var3.setBrtSecteur(var1.getBrtSecteur());
      var3.setBrtPdv(var1.getBrtPdv());
      var3.setBrtAnal2(var1.getBrtAnal2());
      var3.setBrtAnal4(var1.getBrtAnal4());
      var3.setBrtAffaire(var1.getBrtAffaire());
      var3.setBrtInfo1(var1.getBrtInfo1());
      var3.setBrtInfo2(var1.getBrtInfo2());
      var3.setBrtInfo3(var1.getBrtInfo3());
      var3.setBrtInfo4(var1.getBrtInfo4());
      var3.setBrtInfo5(var1.getBrtInfo5());
      var3.setBrtInfo6(var1.getBrtInfo6());
      var3.setBrtInfo7(var1.getBrtInfo7());
      var3.setBrtInfo8(var1.getBrtInfo8());
      var3.setBrtInfo9(var1.getBrtInfo9());
      var3.setBrtInfo10(var1.getBrtInfo10());
      var3.setBrtFormule1(var1.getBrtFormule1());
      var3.setBrtFormule2(var1.getBrtFormule2());
      var3.setBrtAnnexe1(var1.getBrtAnnexe1());
      var3.setBrtAnnexe2(var1.getBrtAnnexe2());
      var3.setBrtContrat(var1.getBrtContrat());
      var3.setBrtIncoterm(var1.getBrtIncoterm());
      var3.setBrtLieuLivraison(var1.getBrtLieuLivraison());
      var3.setBrtDateLivraison(var1.getBrtDateLivraison());
      var3.setBrtInfoLivraison(var1.getBrtInfoLivraison());
      var3.setBrtDateImp(var1.getBrtDateImp());
      var3.setBrtModeleImp(var1.getBrtModeleImp());
      var3.setBrtGarde(var1.getBrtGarde());
      var3.setBrtGele(var1.getBrtGele());
      var3.setBrtEtat(var1.getBrtEtat());
      var3.setBrtDateTransforme(var1.getBrtDateTransforme());
      var3.setBrtDateAnnule(var1.getBrtDateAnnule());
      var3.setBrtMotifAnnule(var1.getBrtMotifAnnule());
      var3.setBrtFactorNom(var1.getBrtFactorNom());
      var3.setBrtFactorId(var1.getBrtFactorId());
      var3.setBrtFactorEtat(var1.getBrtFactorEtat());
      var3.setExerciceventes(var1.getExerciceventes());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from RetourEnteteVentes order by brtId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            RetourEnteteVentes var7 = (RetourEnteteVentes)var6.get(0);
            var4 = 1L + var7.getBrtId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public RetourEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from RetourEnteteVentes where exerciceventes.exevteId=:id and brtSerie =:ser and year(brtDate)=" + var7 + " order by brtDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      RetourEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (RetourEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public RetourEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from RetourEnteteVentes where exerciceventes.exevteId=:id and brtSerie =:ser and year(brtDate)=" + var7 + " and month(brtDate)=" + var8 + " order by brtDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      RetourEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (RetourEnteteVentes)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, String var6, long var7, String var9, int var10, String var11, String var12, String var13, long var14, int var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29) throws HibernateException, NamingException, ParseException {
      boolean var30 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var30 = true;
      }

      UtilDate var31 = new UtilDate();
      new ArrayList();
      Criteria var33 = var1.createCriteria(RetourEnteteVentes.class);
      Calendar var34 = Calendar.getInstance();
      Date var35 = null;
      Date var36 = null;
      Date var37 = new Date();
      String var38 = var31.dateToStringFr(var37);
      String var39 = var38.substring(6, 10) + "-" + var38.substring(3, 5) + "-" + var38.substring(0, 2);
      var35 = var31.stringToDateSQL(var39 + " 00:00:00");
      var36 = var31.stringToDateSQL(var39 + " 23:59:59");
      int var40 = var37.getYear() + 1900;
      String var41;
      String var42;
      if (var13.equalsIgnoreCase("100")) {
         if (var22 != null && var23 != null) {
            var35 = var31.stringToDateSQL(var22 + " 00:00:00");
            var36 = var31.stringToDateSQL(var23 + " 23:59:59");
            var33 = var33.add(Restrictions.between("brtDate", var35, var36));
         } else {
            var41 = "1980-01-01";
            var31.stringToDateSQL(var41 + " 00:00:00");
            var33 = var33.add(Restrictions.isNotNull("brtDate"));
         }
      } else {
         if (!var13.equalsIgnoreCase("12") && !var13.equalsIgnoreCase("13") && !var13.equalsIgnoreCase("14")) {
            var33 = var33.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var13.equalsIgnoreCase("0")) {
            var33 = var33.add(Restrictions.between("brtDate", var35, var36));
         } else if (var13.equalsIgnoreCase("1")) {
            var41 = "" + var34.getTime();
            if (var41.contains("Mon")) {
               var35 = var34.getTime();
            } else if (var41.contains("Tue")) {
               var34.add(7, -1);
               var35 = var34.getTime();
            } else if (var41.contains("Wed")) {
               var34.add(7, -2);
               var35 = var34.getTime();
            } else if (var41.contains("Thu")) {
               var34.add(7, -3);
               var35 = var34.getTime();
            } else if (var41.contains("Fri")) {
               var34.add(7, -4);
               var35 = var34.getTime();
            } else if (var41.contains("Sat")) {
               var34.add(7, -5);
               var35 = var34.getTime();
            } else if (var41.contains("Sun")) {
               var34.add(7, -6);
               var35 = var34.getTime();
            }

            var38 = var31.dateToStringFr(var35);
            var39 = var38.substring(6, 10) + "-" + var38.substring(3, 5) + "-" + var38.substring(0, 2);
            var35 = var31.stringToDateSQL(var39 + " 00:00:00");
            var33 = var33.add(Restrictions.between("brtDate", var35, var36));
         } else {
            int var45;
            if (var13.equalsIgnoreCase("2")) {
               var45 = var34.get(2) + 1;
               var42 = var40 + "-" + var45 + "-01";
               var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("3")) {
               var45 = var34.get(2);
               var34.add(5, -var45);
               if (var45 <= 3) {
                  var42 = var40 + "-01-01";
                  var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               } else if (var45 >= 4 && var45 <= 6) {
                  var42 = var40 + "-04-01";
                  var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               } else if (var45 >= 7 && var45 <= 9) {
                  var42 = var40 + "-07-01";
                  var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               } else if (var45 >= 10) {
                  var42 = var40 + "-10-01";
                  var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               }

               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("4")) {
               var45 = var34.get(2);
               var34.add(5, -var45);
               if (var45 <= 6) {
                  var42 = var40 + "-01-01";
                  var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               } else {
                  var42 = var40 + "-07-01";
                  var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               }

               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("5")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-03-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("6")) {
               var41 = var40 + "-04-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-06-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("7")) {
               var41 = var40 + "-07-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-09-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("8")) {
               var41 = var40 + "-10-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("9")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-06-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("10")) {
               var41 = var40 + "-07-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("11")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("12")) {
               var41 = "1980-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 - 1 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("13")) {
               var41 = var40 - 1 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("14")) {
               var41 = var40 - 1 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 - 1 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("brtDate", var35, var36));
            } else if (var13.equalsIgnoreCase("20")) {
               var33.setMaxResults(20);
               var33 = var33.addOrder(Order.desc("brtId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var41 = "%" + var4 + "%";
         var33 = var33.add(Restrictions.like("brtNum", var41));
      }

      if (var5 != null && !var5.isEmpty()) {
         var41 = "%" + var5 + "%";
         var33 = var33.add(Restrictions.like("brtNumClient", var41));
      }

      if (var6 != null && !var6.isEmpty()) {
         var41 = "%" + var6 + "%";
         var33 = var33.add(Restrictions.like("brtAnal4", var41));
      }

      if (var7 != 0L) {
         var33 = var33.add(Restrictions.eq("tiers.tieid", var7));
      } else if (var9 != null && !var9.isEmpty()) {
         var41 = "";
         if (var9.startsWith("*")) {
            var41 = "%" + var9.substring(1) + "%";
         } else {
            var41 = var9 + "%";
         }

         var33 = var33.add(Restrictions.or(Restrictions.like("brtNomTiers", var41), Restrictions.like("brtDiversNom", var41)));
      }

      if (var17 != null && !var17.isEmpty()) {
         var33 = var33.add(Restrictions.eq("brtNomContact", var17));
      }

      if (var18 != null && !var18.isEmpty()) {
         var33 = var33.add(Restrictions.eq("brtNomResponsable", var18));
      }

      if (var19 != null && !var19.isEmpty()) {
         var33 = var33.add(Restrictions.eq("brtNomCommercial", var19));
      }

      if (var16 == 1 || var16 == 2) {
         var33 = var33.add(Restrictions.eq("brtIdCreateur", var14));
      }

      String[] var47;
      if (!var11.equalsIgnoreCase("100")) {
         if (var11.contains(",")) {
            var47 = var11.split(",");
            int var46 = var47.length;
            String[] var43 = new String[var46];

            for(int var44 = 0; var44 < var46; ++var44) {
               var43[var44] = new String(var47[var44]);
            }

            var33 = var33.add(Restrictions.in("brtSerie", var43));
         } else {
            var33 = var33.add(Restrictions.eq("brtSerie", var11));
         }
      }

      if (!var12.equalsIgnoreCase("100")) {
         var33 = var33.add(Restrictions.eq("brtCat", var12));
      }

      if (var10 <= 10) {
         var33 = var33.add(Restrictions.eq("brtEtat", var10));
      }

      if (!var20.equalsIgnoreCase("100")) {
         var47 = var20.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("brtActivite", var42));
      }

      if (var24 != null && !var24.isEmpty() && var24.contains(":")) {
         var47 = var24.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("brtRegion", var42));
      }

      if (var25 != null && !var25.isEmpty() && var25.contains(":")) {
         var47 = var25.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("brtSecteur", var42));
      }

      if (var26 != null && !var26.isEmpty() && var26.contains(":")) {
         var47 = var26.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("brtPdv", var42));
      }

      if (var27 != null && !var27.isEmpty()) {
         var33 = var33.add(Restrictions.eq("brtSite", var27));
      }

      if (var28 != null && !var28.isEmpty()) {
         var33 = var33.add(Restrictions.eq("brtDepartement", var28));
      }

      if (var29 != null && !var29.isEmpty()) {
         var33 = var33.add(Restrictions.eq("brtService", var29));
      }

      if (var21 != null && !var21.isEmpty()) {
         var41 = "%" + var21 + "%";
         var33 = var33.add(Restrictions.like("brtContener", var41));
      }

      var33 = var33.addOrder(Order.desc("brtDate"));
      var33 = var33.addOrder(Order.desc("brtNum"));
      List var48 = var33.list();
      if (var30) {
         this.utilInitHibernate.closeSession();
      }

      return var48;
   }

   public RetourEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from RetourEnteteVentes where brtId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new RetourEnteteVentes();
      RetourEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (RetourEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public RetourEnteteVentes pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from RetourEnteteVentes where brtNum=:num and brtSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new RetourEnteteVentes();
      RetourEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (RetourEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
      Query var4 = var3.createQuery("from RetourEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from RetourEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public List rechercheRetourRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from RetourEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheRetourByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from RetourEnteteVentes where brtDate>=:deb and brtDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BretourEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from RetourEnteteVentes where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
