package com.epegase.systeme.dao;

import com.epegase.systeme.classe.AvoirEnteteVentes;
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

public class AvoirEnteteVentesDao implements Serializable {
   private AvoirEnteteVentes avoirEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public AvoirEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public AvoirEnteteVentes insert(AvoirEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public AvoirEnteteVentes modif(AvoirEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
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

   public AvoirEnteteVentes modif(AvoirEnteteVentes var1, Session var2) {
      var2.saveOrUpdate(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from AvoirEnteteVentes where avrId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public AvoirEnteteVentes duppliquer(AvoirEnteteVentes var1, Session var2) {
      AvoirEnteteVentes var3 = new AvoirEnteteVentes();
      var3.setAvrSerie(var1.getAvrSerie());
      var3.setAvrIdCreateur(var1.getAvrIdCreateur());
      var3.setAvrNomCreateur(var1.getAvrNomCreateur());
      var3.setAvrDate(var1.getAvrDate());
      var3.setAvrDateCreat(var1.getAvrDateCreat());
      var3.setAvrDateModif(var1.getAvrDateModif());
      var3.setAvrIdModif(var1.getAvrIdModif());
      var3.setAvrNomModif(var1.getAvrNomModif());
      var3.setAvrDateRelance(var1.getAvrDateRelance());
      var3.setAvrDateValidite(var1.getAvrDateValidite());
      var3.setAvrService(var1.getAvrService());
      var3.setAvrNum(var1.getAvrNum());
      var3.setAvrSource(var1.getAvrSource());
      var3.setAvrNomResponsable(var1.getAvrNomResponsable());
      var3.setAvrIdResponsable(var1.getAvrIdResponsable());
      var3.setAvrNomCommercial(var1.getAvrNomCommercial());
      var3.setAvrIdCommercial(var1.getAvrIdCommercial());
      var3.setAvrNomTiers(var1.getAvrNomTiers());
      var3.setAvrCivilTiers(var1.getAvrCivilTiers());
      var3.setAvrTiersRegroupe(var1.getAvrTiersRegroupe());
      var3.setAvrIdContact(var1.getAvrIdContact());
      var3.setAvrNomContact(var1.getAvrNomContact());
      var3.setAvrCivilContact(var1.getAvrCivilContact());
      var3.setAvrDiversAdresse(var1.getAvrDiversAdresse());
      var3.setAvrDiversMail(var1.getAvrDiversMail());
      var3.setAvrDiversNom(var1.getAvrDiversNom());
      var3.setAvrDiversTel(var1.getAvrDiversTel());
      var3.setAvrDiversTiers(var1.getAvrDiversTiers());
      var3.setAvrDiversVille(var1.getAvrDiversVille());
      var3.setAvrExoTva(var1.getAvrExoTva());
      var3.setAvrExoDouane(var1.getAvrExoDouane());
      var3.setAvrJournalReg(var1.getAvrJournalReg());
      var3.setAvrCat(var1.getAvrCat());
      var3.setAvrDevise(var1.getAvrDevise());
      var3.setAvrObject(var1.getAvrObject());
      var3.setAvrObservation(var1.getAvrObservation());
      var3.setAvrTauxRemise(var1.getAvrTauxRemise());
      var3.setAvrTotHt(var1.getAvrTotHt());
      var3.setAvrTotRemise(var1.getAvrTotRemise());
      var3.setAvrTotRabais(var1.getAvrTotRabais());
      var3.setAvrTotTva(var1.getAvrTotTva());
      var3.setAvrTotTc(var1.getAvrTotTc());
      var3.setAvrTotTtc(var1.getAvrTotTtc());
      var3.setAvrTotReglement(var1.getAvrTotReglement());
      var3.setAvrSolde(var1.getAvrSolde());
      var3.setAvrBanque(var1.getAvrBanque());
      var3.setAvrTypeReg(var1.getAvrTypeReg());
      var3.setAvrModeReg(var1.getAvrModeReg());
      var3.setAvrNbJourReg(var1.getAvrNbJourReg());
      var3.setAvrArrondiReg(var1.getAvrArrondiReg());
      var3.setAvrConditionReg(var1.getAvrConditionReg());
      var3.setAvrDateEcheReg(var1.getAvrDateEcheReg());
      var3.setAvrContener(var1.getAvrContener());
      var3.setAvrActivite(var1.getAvrActivite());
      var3.setAvrSite(var1.getAvrSite());
      var3.setAvrDepartement(var1.getAvrDepartement());
      var3.setAvrRegion(var1.getAvrRegion());
      var3.setAvrSecteur(var1.getAvrSecteur());
      var3.setAvrPdv(var1.getAvrPdv());
      var3.setAvrAnal2(var1.getAvrAnal2());
      var3.setAvrAnal4(var1.getAvrAnal4());
      var3.setAvrAffaire(var1.getAvrAffaire());
      var3.setAvrInfo1(var1.getAvrInfo1());
      var3.setAvrInfo2(var1.getAvrInfo2());
      var3.setAvrInfo3(var1.getAvrInfo3());
      var3.setAvrInfo4(var1.getAvrInfo4());
      var3.setAvrInfo5(var1.getAvrInfo5());
      var3.setAvrInfo6(var1.getAvrInfo6());
      var3.setAvrInfo7(var1.getAvrInfo7());
      var3.setAvrInfo8(var1.getAvrInfo8());
      var3.setAvrInfo9(var1.getAvrInfo9());
      var3.setAvrInfo10(var1.getAvrInfo10());
      var3.setAvrFormule1(var1.getAvrFormule1());
      var3.setAvrFormule2(var1.getAvrFormule2());
      var3.setAvrAnnexe1(var1.getAvrAnnexe1());
      var3.setAvrAnnexe2(var1.getAvrAnnexe2());
      var3.setAvrContrat(var1.getAvrContrat());
      var3.setAvrIncoterm(var1.getAvrIncoterm());
      var3.setAvrLieuLivraison(var1.getAvrLieuLivraison());
      var3.setAvrDateLivraison(var1.getAvrDateLivraison());
      var3.setAvrInfoLivraison(var1.getAvrInfoLivraison());
      var3.setAvrDateImp(var1.getAvrDateImp());
      var3.setAvrModeleImp(var1.getAvrModeleImp());
      var3.setAvrGarde(var1.getAvrGarde());
      var3.setAvrGele(var1.getAvrGele());
      var3.setAvrEtat(var1.getAvrEtat());
      var3.setAvrDateTransforme(var1.getAvrDateTransforme());
      var3.setAvrTypeTransforme(var1.getAvrTypeTransforme());
      var3.setAvrDateAnnule(var1.getAvrDateAnnule());
      var3.setAvrMotifAnnule(var1.getAvrMotifAnnule());
      var3.setAvrNumFacture(var1.getAvrNum());
      var3.setAvrFactorNom(var1.getAvrFactorNom());
      var3.setAvrFactorId(var1.getAvrFactorId());
      var3.setAvrFactorEtat(var1.getAvrFactorEtat());
      var3.setExerciceventes(var1.getExerciceventes());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from AvoirEnteteVentes order by avrId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            AvoirEnteteVentes var7 = (AvoirEnteteVentes)var6.get(0);
            var4 = 1L + var7.getAvrId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public AvoirEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from AvoirEnteteVentes where exerciceventes.exevteId=:id and avrSerie =:ser and year(avrDate)=" + var7 + " order by avrDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      AvoirEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (AvoirEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public AvoirEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from AvoirEnteteVentes where exerciceventes.exevteId=:id and avrSerie =:ser and year(avrDate)=" + var7 + " and month(avrDate)=" + var8 + " order by avrDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      AvoirEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (AvoirEnteteVentes)var11.get(0);
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
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var30 = true;
      }

      UtilDate var31 = new UtilDate();
      new ArrayList();
      Criteria var33 = var1.createCriteria(AvoirEnteteVentes.class);
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
            var33 = var33.add(Restrictions.between("avrDate", var35, var36));
         } else {
            var41 = "1980-01-01";
            var31.stringToDateSQL(var41 + " 00:00:00");
            var33 = var33.add(Restrictions.isNotNull("avrDate"));
         }
      } else {
         if (!var13.equalsIgnoreCase("12") && !var13.equalsIgnoreCase("13") && !var13.equalsIgnoreCase("14")) {
            var33 = var33.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var13.equalsIgnoreCase("0")) {
            var33 = var33.add(Restrictions.between("avrDate", var35, var36));
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
            var33 = var33.add(Restrictions.between("avrDate", var35, var36));
         } else {
            int var45;
            if (var13.equalsIgnoreCase("2")) {
               var45 = var34.get(2) + 1;
               var42 = var40 + "-" + var45 + "-01";
               var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
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

               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
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

               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("5")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-03-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("6")) {
               var41 = var40 + "-04-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-06-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("7")) {
               var41 = var40 + "-07-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-09-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("8")) {
               var41 = var40 + "-10-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("9")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-06-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("10")) {
               var41 = var40 + "-07-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("11")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("12")) {
               var41 = "1980-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 - 1 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("13")) {
               var41 = var40 - 1 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("14")) {
               var41 = var40 - 1 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 - 1 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("avrDate", var35, var36));
            } else if (var13.equalsIgnoreCase("20")) {
               var33.setMaxResults(20);
               var33 = var33.addOrder(Order.desc("avrId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var41 = "%" + var4 + "%";
         var33 = var33.add(Restrictions.like("avrNum", var41));
      }

      if (var5 != null && !var5.isEmpty()) {
         var41 = "%" + var5 + "%";
         var33 = var33.add(Restrictions.like("avrNumClient", var41));
      }

      if (var6 != null && !var6.isEmpty()) {
         var41 = "%" + var6 + "%";
         var33 = var33.add(Restrictions.like("avrAnal4", var41));
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

         var33 = var33.add(Restrictions.or(Restrictions.like("avrNomTiers", var41), Restrictions.like("avrDiversNom", var41)));
      }

      if (var17 != null && !var17.isEmpty()) {
         var33 = var33.add(Restrictions.eq("avrNomContact", var17));
      }

      if (var18 != null && !var18.isEmpty()) {
         var33 = var33.add(Restrictions.eq("avrNomResponsable", var18));
      }

      if (var19 != null && !var19.isEmpty()) {
         var33 = var33.add(Restrictions.eq("avrNomCommercial", var19));
      }

      if (var16 == 1 || var16 == 2) {
         var33 = var33.add(Restrictions.eq("avrIdCreateur", var14));
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

            var33 = var33.add(Restrictions.in("avrSerie", var43));
         } else {
            var33 = var33.add(Restrictions.eq("avrSerie", var11));
         }
      }

      if (!var12.equalsIgnoreCase("100")) {
         var33 = var33.add(Restrictions.eq("avrCat", var12));
      }

      if (var10 <= 10) {
         var33 = var33.add(Restrictions.eq("avrEtat", var10));
      } else if (var10 == 11) {
         var33 = var33.add(Restrictions.isNotNull("avrDateRelance"));
      } else if (var10 == 12) {
         var33 = var33.add(Restrictions.eq("avrTotHt", 0.0D));
      } else if (var10 == 13) {
         var33 = var33.add(Restrictions.eq("avrSolde", 0));
      } else if (var10 == 14) {
         var33 = var33.add(Restrictions.eq("avrSolde", 1));
      } else if (var10 == 15) {
         var33 = var33.add(Restrictions.eq("avrExoTva", 1));
      } else if (var10 == 16) {
         var33 = var33.add(Restrictions.and(Restrictions.eq("avrExoTva", 1), Restrictions.isNull("avrDateVisa")));
      } else if (var10 == 17) {
         var33 = var33.add(Restrictions.isNotNull("avrDateTransfert"));
      } else if (var10 == 18) {
         var33 = var33.add(Restrictions.isNull("avrDateTransfert"));
      }

      if (!var20.equalsIgnoreCase("100")) {
         var47 = var20.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("avrActivite", var42));
      }

      if (var24 != null && !var24.isEmpty() && var24.contains(":")) {
         var47 = var24.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("avrRegion", var42));
      }

      if (var25 != null && !var25.isEmpty() && var25.contains(":")) {
         var47 = var25.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("avrSecteur", var42));
      }

      if (var26 != null && !var26.isEmpty() && var26.contains(":")) {
         var47 = var26.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("avrPdv", var42));
      }

      if (var27 != null && !var27.isEmpty()) {
         var33 = var33.add(Restrictions.eq("avrSite", var27));
      }

      if (var28 != null && !var28.isEmpty()) {
         var33 = var33.add(Restrictions.eq("avrDepartement", var28));
      }

      if (var29 != null && !var29.isEmpty()) {
         var33 = var33.add(Restrictions.eq("avrService", var29));
      }

      if (var21 != null && !var21.isEmpty()) {
         var41 = "%" + var21 + "%";
         var33 = var33.add(Restrictions.like("avrContener", var41));
      }

      var33 = var33.addOrder(Order.desc("avrDate"));
      var33 = var33.addOrder(Order.desc("avrNum"));
      List var48 = var33.list();
      if (var30) {
         this.utilInitHibernate.closeSession();
      }

      return var48;
   }

   public AvoirEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from AvoirEnteteVentes where avrId =:num").setParameter("num", var1).setMaxResults(1);
      new AvoirEnteteVentes();
      List var7 = var5.list();
      AvoirEnteteVentes var6;
      if (var7.size() != 0) {
         var6 = (AvoirEnteteVentes)var7.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public AvoirEnteteVentes pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from AvoirEnteteVentes where avrNum=:num and avrSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      new AvoirEnteteVentes();
      List var7 = var5.list();
      AvoirEnteteVentes var6;
      if (var7.size() != 0) {
         var6 = (AvoirEnteteVentes)var7.get(0);
      } else {
         var6 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheAvoirATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from AvoirEnteteVentes where (avrEtat=0 or avrEtat=1 or avrEtat=4 or avrEtat=5) and avrDateTransfert is NULL ").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from AvoirEnteteVentes where (avrEtat=0 or avrEtat=1 or avrEtat=4 or avrEtat=5) and avrDateTransfert is NULL and avrDate>=:dte1 and avrDate<=:dte2 and avrNum>=:p1 and avrNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from AvoirEnteteVentes where (avrEtat=0 or avrEtat=1 or avrEtat=4 or avrEtat=5) and avrDateTransfert is NULL and avrDate>=:dte1 and avrDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from AvoirEnteteVentes where (avrEtat=1 or avrEtat=4 or avrEtat=5) and avrDateTransfert is NULL ").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from AvoirEnteteVentes where (avrEtat=1 or avrEtat=4 or avrEtat=5) and avrDateTransfert is NULL and avrDate>=:dte1 and avrDate<=:dte2 and avrNum>=:p1 and avrNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from AvoirEnteteVentes where (avrEtat=1 or avrEtat=4 or avrEtat=5) and avrDateTransfert is NULL and avrDate>=:dte1 and avrDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheAvoirDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from AvoirEnteteVentes where (avrEtat=0 or avrEtat=1 or avrEtat=4 or avrEtat=5) and (avrDateTransfert<>'' and avrDateTransfert is not null) and avrDate>=:dte1 and avrDate<=:dte2").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
      Query var4 = var3.createQuery("from AvoirEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from AvoirEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public List rechercheAvoirRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from AvoirEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCommissions(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from AvoirEnteteVentes where avrSolde=1 and avrDate>=:d1 and avrDate<=:d2").setDate("d1", var1).setDate("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from AvoirEnteteVentes where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from AvoirEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheAvoirCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var6 = true;
      }

      List var7 = var4.createQuery("from AvoirEnteteVentes where avrDate>=:d1 and avrSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheAvoirByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BavoirEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from AvoirEnteteVentes where avrDate>=:deb and avrDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
