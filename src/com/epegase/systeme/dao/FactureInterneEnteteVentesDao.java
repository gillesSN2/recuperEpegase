package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
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

public class FactureInterneEnteteVentesDao implements Serializable {
   private FactureInterneEnteteVentes factureInterneEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FactureInterneEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FactureInterneEnteteVentes insert(FactureInterneEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FactureInterneEnteteVentes modif(FactureInterneEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
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

   public FactureInterneEnteteVentes modif(FactureInterneEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from FactureInterneEnteteVentes where fitId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public FactureInterneEnteteVentes duppliquer(FactureInterneEnteteVentes var1, Session var2) {
      FactureInterneEnteteVentes var3 = new FactureInterneEnteteVentes();
      var3.setFitSerie(var1.getFitSerie());
      var3.setFitIdCreateur(var1.getFitIdCreateur());
      var3.setFitNomCreateur(var1.getFitNomCreateur());
      var3.setFitDate(var1.getFitDate());
      var3.setFitDateCreat(var1.getFitDateCreat());
      var3.setFitDateModif(var1.getFitDateModif());
      var3.setFitIdModif(var1.getFitIdModif());
      var3.setFitNomModif(var1.getFitNomModif());
      var3.setFitDateRelance(var1.getFitDateRelance());
      var3.setFitDateValidite(var1.getFitDateValidite());
      var3.setFitService(var1.getFitService());
      var3.setFitNum(var1.getFitNum());
      var3.setFitSource(var1.getFitSource());
      var3.setFitNomResponsable(var1.getFitNomResponsable());
      var3.setFitIdResponsable(var1.getFitIdResponsable());
      var3.setFitNomCommercial(var1.getFitNomCommercial());
      var3.setFitIdCommercial(var1.getFitIdCommercial());
      var3.setFitNomTiers(var1.getFitNomTiers());
      var3.setFitCivilTiers(var1.getFitCivilTiers());
      var3.setFitTiersRegroupe(var1.getFitTiersRegroupe());
      var3.setFitIdContact(var1.getFitIdContact());
      var3.setFitNomContact(var1.getFitNomContact());
      var3.setFitCivilContact(var1.getFitCivilContact());
      var3.setFitDiversAdresse(var1.getFitDiversAdresse());
      var3.setFitDiversMail(var1.getFitDiversMail());
      var3.setFitDiversNom(var1.getFitDiversNom());
      var3.setFitDiversTel(var1.getFitDiversTel());
      var3.setFitDiversTiers(var1.getFitDiversTiers());
      var3.setFitDiversVille(var1.getFitDiversVille());
      var3.setFitExoTva(var1.getFitExoTva());
      var3.setFitExoDouane(var1.getFitExoDouane());
      var3.setFitJournalReg(var1.getFitJournalReg());
      var3.setFitCat(var1.getFitCat());
      var3.setFitDevise(var1.getFitDevise());
      var3.setFitObject(var1.getFitObject());
      var3.setFitObservation(var1.getFitObservation());
      var3.setFitTauxRemise(var1.getFitTauxRemise());
      var3.setFitTotHt(var1.getFitTotHt());
      var3.setFitTotRemise(var1.getFitTotRemise());
      var3.setFitTotRabais(var1.getFitTotRabais());
      var3.setFitTotTva(var1.getFitTotTva());
      var3.setFitTotTc((double)var1.getFitTauxTc());
      var3.setFitTotTtc(var1.getFitTotTtc());
      var3.setFitTotReglement(var1.getFitTotReglement());
      var3.setFitSolde(var1.getFitSolde());
      var3.setFitBanque(var1.getFitBanque());
      var3.setFitTypeReg(var1.getFitTypeReg());
      var3.setFitModeReg(var1.getFitModeReg());
      var3.setFitNbJourReg(var1.getFitNbJourReg());
      var3.setFitArrondiReg(var1.getFitArrondiReg());
      var3.setFitConditionReg(var1.getFitConditionReg());
      var3.setFitDateEcheReg(var1.getFitDateEcheReg());
      var3.setFitContener(var1.getFitContener());
      var3.setFitActivite(var1.getFitActivite());
      var3.setFitSite(var1.getFitSite());
      var3.setFitDepartement(var1.getFitDepartement());
      var3.setFitRegion(var1.getFitRegion());
      var3.setFitSecteur(var1.getFitSecteur());
      var3.setFitPdv(var1.getFitPdv());
      var3.setFitAnal2(var1.getFitAnal2());
      var3.setFitAnal4(var1.getFitAnal4());
      var3.setFitInfo1(var1.getFitInfo1());
      var3.setFitInfo2(var1.getFitInfo2());
      var3.setFitInfo3(var1.getFitInfo3());
      var3.setFitInfo4(var1.getFitInfo4());
      var3.setFitInfo5(var1.getFitInfo5());
      var3.setFitInfo6(var1.getFitInfo6());
      var3.setFitInfo7(var1.getFitInfo7());
      var3.setFitInfo8(var1.getFitInfo8());
      var3.setFitInfo9(var1.getFitInfo9());
      var3.setFitInfo10(var1.getFitInfo10());
      var3.setFitFormule1(var1.getFitFormule1());
      var3.setFitFormule2(var1.getFitFormule2());
      var3.setFitAnnexe1(var1.getFitAnnexe1());
      var3.setFitAnnexe2(var1.getFitAnnexe2());
      var3.setFitContrat(var1.getFitContrat());
      var3.setFitIncoterm(var1.getFitIncoterm());
      var3.setFitLieuLivraison(var1.getFitLieuLivraison());
      var3.setFitDateLivraison(var1.getFitDateLivraison());
      var3.setFitInfoLivraison(var1.getFitInfoLivraison());
      var3.setFitDateImp(var1.getFitDateImp());
      var3.setFitModeleImp(var1.getFitModeleImp());
      var3.setFitGarde(var1.getFitGarde());
      var3.setFitGele(var1.getFitGele());
      var3.setFitEtat(var1.getFitEtat());
      var3.setFitDateTransforme(var1.getFitDateTransforme());
      var3.setFitDateAnnule(var1.getFitDateAnnule());
      var3.setFitMotifAnnule(var1.getFitMotifAnnule());
      var3.setFitFactorNom(var1.getFitFactorNom());
      var3.setFitFactorId(var1.getFitFactorId());
      var3.setFitFactorEtat(var1.getFitFactorEtat());
      var3.setExerciceventes(var1.getExerciceventes());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from FactureInterneEnteteVentes order by fitId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            FactureInterneEnteteVentes var7 = (FactureInterneEnteteVentes)var6.get(0);
            var4 = 1L + var7.getFitId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public FactureInterneEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from FactureInterneEnteteVentes where exerciceventes.exevteId=:id and fitSerie =:ser and year(fitDate)=" + var7 + " order by fitDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      FactureInterneEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (FactureInterneEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public FactureInterneEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from FactureInterneEnteteVentes where exerciceventes.exevteId=:id and fitSerie =:ser and year(fitDate)=" + var7 + " and month(fitDate)=" + var8 + " order by fitDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      FactureInterneEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (FactureInterneEnteteVentes)var11.get(0);
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
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var28 = true;
      }

      UtilDate var29 = new UtilDate();
      new ArrayList();
      Criteria var31 = var1.createCriteria(FactureInterneEnteteVentes.class);
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
            var31 = var31.add(Restrictions.between("fitDate", var33, var34));
         } else {
            var39 = "1980-01-01";
            var29.stringToDateSQL(var39 + " 00:00:00");
            var31 = var31.add(Restrictions.isNotNull("fitDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var31 = var31.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var31 = var31.add(Restrictions.between("fitDate", var33, var34));
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
            var31 = var31.add(Restrictions.between("fitDate", var33, var34));
         } else {
            int var43;
            if (var11.equalsIgnoreCase("2")) {
               var43 = var32.get(2) + 1;
               var40 = var38 + "-" + var43 + "-01";
               var33 = var29.stringToDateSQL(var40 + " 00:00:00");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
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

               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
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

               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("5")) {
               var39 = var38 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-03-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("6")) {
               var39 = var38 + "-04-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-06-30";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("7")) {
               var39 = var38 + "-07-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-09-30";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("8")) {
               var39 = var38 + "-10-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("9")) {
               var39 = var38 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-06-30";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("10")) {
               var39 = var38 + "-07-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("11")) {
               var39 = var38 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("12")) {
               var39 = "1980-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 - 1 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("13")) {
               var39 = var38 - 1 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("14")) {
               var39 = var38 - 1 + "-01-01";
               var33 = var29.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 - 1 + "-12-31";
               var34 = var29.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("fitDate", var33, var34));
            } else if (var11.equalsIgnoreCase("20")) {
               var31.setMaxResults(20);
               var31 = var31.addOrder(Order.desc("fitId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var39 = "%" + var4 + "%";
         var31 = var31.add(Restrictions.like("fitNum", var39));
      }

      if (var5 != 0L) {
         var31 = var31.add(Restrictions.eq("tiers.tieid", var5));
      } else if (var7 != null && !var7.isEmpty()) {
         var39 = "";
         if (var7.startsWith("*")) {
            var39 = "%" + var7.substring(1) + "%";
         } else {
            var39 = var7 + "%";
         }

         var31 = var31.add(Restrictions.or(Restrictions.like("fitNomTiers", var39), Restrictions.like("fitDiversNom", var39)));
      }

      if (var15 != null && !var15.isEmpty()) {
         var31 = var31.add(Restrictions.eq("fitNomContact", var15));
      }

      if (var16 != null && !var16.isEmpty()) {
         var31 = var31.add(Restrictions.eq("fitNomResponsable", var16));
      }

      if (var17 != null && !var17.isEmpty()) {
         var31 = var31.add(Restrictions.eq("fitNomCommercial", var17));
      }

      if (var14 == 1 || var14 == 2) {
         var31 = var31.add(Restrictions.eq("fitIdCreateur", var12));
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

            var31 = var31.add(Restrictions.in("fitSerie", var41));
         } else {
            var31 = var31.add(Restrictions.eq("fitSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         var31 = var31.add(Restrictions.eq("fitCat", var10));
      }

      if (var8 <= 10) {
         var31 = var31.add(Restrictions.eq("fitEtat", var8));
      } else if (var8 == 11) {
         var31 = var31.add(Restrictions.isNotNull("fitDateRelance"));
      } else if (var8 == 12) {
         var31 = var31.add(Restrictions.eq("fitTotHt", 0.0D));
      } else if (var8 == 13) {
         var31 = var31.add(Restrictions.eq("fitSolde", 0));
      } else if (var8 == 14) {
         var31 = var31.add(Restrictions.eq("fitSolde", 1));
      } else if (var8 == 15) {
         var31 = var31.add(Restrictions.eq("fitExoTva", 1));
      } else if (var8 == 16) {
         var31 = var31.add(Restrictions.and(Restrictions.eq("fitExoTva", 1), Restrictions.isNull("fitDateVisa")));
      } else if (var8 == 17) {
         var31 = var31.add(Restrictions.isNotNull("fitDateTransfert"));
      } else if (var8 == 18) {
         var31 = var31.add(Restrictions.isNull("fitDateTransfert"));
      }

      if (!var18.equalsIgnoreCase("100")) {
         var44 = var18.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("fitActivite", var40));
      }

      if (var22 != null && !var22.isEmpty() && var22.contains(":")) {
         var44 = var22.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("fitRegion", var40));
      }

      if (var23 != null && !var23.isEmpty() && var23.contains(":")) {
         var44 = var23.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("fitSecteur", var40));
      }

      if (var24 != null && !var24.isEmpty() && var24.contains(":")) {
         var44 = var24.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("fitPdv", var40));
      }

      if (var25 != null && !var25.isEmpty()) {
         var31 = var31.add(Restrictions.eq("fitSite", var25));
      }

      if (var26 != null && !var26.isEmpty()) {
         var31 = var31.add(Restrictions.eq("fitDepartement", var26));
      }

      if (var27 != null && !var27.isEmpty()) {
         var31 = var31.add(Restrictions.eq("fitService", var27));
      }

      if (var19 != null && !var19.isEmpty()) {
         var39 = "%" + var19 + "%";
         var31 = var31.add(Restrictions.like("fitContener", var39));
      }

      var31 = var31.addOrder(Order.desc("fitDate"));
      var31 = var31.addOrder(Order.desc("fitNum"));
      List var46 = var31.list();
      if (var28) {
         this.utilInitHibernate.closeSession();
      }

      return var46;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from FactureInterneEnteteVentes where fitService='" + var1 + "' and (fitDateEcheReg='" + var5 + "' or fitTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from FactureInterneEnteteVentes where fitDateEcheReg='" + var5 + "' or fitTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public FactureInterneEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FactureInterneEnteteVentes where fitId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      FactureInterneEnteteVentes var7 = new FactureInterneEnteteVentes();
      if (var6.size() != 0) {
         var7 = (FactureInterneEnteteVentes)var6.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FactureInterneEnteteVentes pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureInterneEnteteVentes where fitNum =:num").setParameter("num", var1).setMaxResults(1);
      List var5 = var4.list();
      FactureInterneEnteteVentes var6 = new FactureInterneEnteteVentes();
      if (var5.size() != 0) {
         var6 = (FactureInterneEnteteVentes)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureInterneATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from FactureInterneEnteteVentes where (fitEtat=0 or fitEtat=1 or fitEtat=4 or fitEtat=5) and fitDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from FactureInterneEnteteVentes where (fitEtat=0 or fitEtat=1 or fitEtat=4 or fitEtat=5) and fitDateTransfert is NULL and fitDate>=:dte1 and fitDate<=:dte2 and fitNum>=:p1 and fitNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from FactureInterneEnteteVentes where (fitEtat=0 or fitEtat=1 or fitEtat=4 or fitEtat=5) and fitDateTransfert is NULL and fitDate>=:dte1 and fitDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from FactureInterneEnteteVentes where (fitEtat=1 or fitEtat=4 or fitEtat=5) and fitDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from FactureInterneEnteteVentes where (fitEtat=1 or fitEtat=4 or fitEtat=5) and fitDateTransfert is NULL and fitDate>=:dte1 and fitDate<=:dte2 and fitNum>=:p1 and fitNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from FactureInterneEnteteVentes where (fitEtat=1 or fitEtat=4 or fitEtat=5) and fitDateTransfert is NULL and fitDate>=:dte1 and fitDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheFactureInterneDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from FactureInterneEnteteVentes where (fitEtat=0 or fitEtat=1 or fitEtat=4 or fitEtat=5) and (fitDateTransfert<>'' and fitDateTransfert is not null) and fitDate>=:dte1 and fitDate<=:dte2").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureInterneRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FactureInterneEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
      Query var4 = var3.createQuery("from FactureInterneEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureInterneEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public List rechercheFactureInterne(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureInterneEnteteVentes where fitSolde=1 and fitDate>=:d1 and fitDate<=:d2").setDate("d1", var1).setDate("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FactureInterneEnteteVentes pourParapheurByNum(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FactureInterneEnteteVentes where fitNum=:num and fitSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new FactureInterneEnteteVentes();
      FactureInterneEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (FactureInterneEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      return var7;
   }

   public List rechercheFactureInterneAPayerCriterion(String var1, Session var2) throws ParseException {
      new ArrayList();
      String var4 = "";
      Criteria var5 = var2.createCriteria(FactureInterneEnteteVentes.class);
      new ArrayList();
      var5 = var5.add(Restrictions.or(Restrictions.eq("fitTypeReg", 0), Restrictions.eq("fitTypeReg", 4)));
      if (!var1.equalsIgnoreCase("100")) {
         System.out.println("recherche sans service ");
      } else {
         var5 = var5.add(Restrictions.eq("fitService", var1));
      }

      List var3 = var5.list();
      System.out.println("nombre de resultat retourné  ds note de debit" + var3.size());
      return var3;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureInterneEnteteVentes where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureInterneEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheFatureInterneCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var6 = true;
      }

      List var7 = var4.createQuery("from FactureInterneEnteteVentes where fitDate>=:d1 and fitSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheFactureInterneByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureInterneEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from FactureInterneEnteteVentes where fitDate>=:deb and fitDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
