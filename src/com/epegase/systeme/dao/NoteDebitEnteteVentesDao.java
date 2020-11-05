package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
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

public class NoteDebitEnteteVentesDao implements Serializable {
   private NoteDebitEnteteVentes noteDebitEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public NoteDebitEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public NoteDebitEnteteVentes insert(NoteDebitEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public NoteDebitEnteteVentes modif(NoteDebitEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
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

   public NoteDebitEnteteVentes modif(NoteDebitEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from NoteDebitEnteteVentes where ndbId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public NoteDebitEnteteVentes duppliquer(NoteDebitEnteteVentes var1, Session var2) {
      NoteDebitEnteteVentes var3 = new NoteDebitEnteteVentes();
      var3.setNdbSerie(var1.getNdbSerie());
      var3.setNdbIdCreateur(var1.getNdbIdCreateur());
      var3.setNdbNomCreateur(var1.getNdbNomCreateur());
      var3.setNdbDate(var1.getNdbDate());
      var3.setNdbDateCreat(var1.getNdbDateCreat());
      var3.setNdbDateModif(var1.getNdbDateModif());
      var3.setNdbIdModif(var1.getNdbIdModif());
      var3.setNdbNomModif(var1.getNdbNomModif());
      var3.setNdbDateRelance(var1.getNdbDateRelance());
      var3.setNdbDateValidite(var1.getNdbDateValidite());
      var3.setNdbService(var1.getNdbService());
      var3.setNdbNum(var1.getNdbNum());
      var3.setNdbSource(var1.getNdbSource());
      var3.setNdbNomResponsable(var1.getNdbNomResponsable());
      var3.setNdbIdResponsable(var1.getNdbIdResponsable());
      var3.setNdbNomCommercial(var1.getNdbNomCommercial());
      var3.setNdbIdCommercial(var1.getNdbIdCommercial());
      var3.setNdbNomTiers(var1.getNdbNomTiers());
      var3.setNdbCivilTiers(var1.getNdbCivilTiers());
      var3.setNdbTiersRegroupe(var1.getNdbTiersRegroupe());
      var3.setNdbIdContact(var1.getNdbIdContact());
      var3.setNdbNomContact(var1.getNdbNomContact());
      var3.setNdbCivilContact(var1.getNdbCivilContact());
      var3.setNdbDiversAdresse(var1.getNdbDiversAdresse());
      var3.setNdbDiversMail(var1.getNdbDiversMail());
      var3.setNdbDiversNom(var1.getNdbDiversNom());
      var3.setNdbDiversTel(var1.getNdbDiversTel());
      var3.setNdbDiversTiers(var1.getNdbDiversTiers());
      var3.setNdbDiversVille(var1.getNdbDiversVille());
      var3.setNdbExoTva(var1.getNdbExoTva());
      var3.setNdbExoDouane(var1.getNdbExoDouane());
      var3.setNdbJournalReg(var1.getNdbJournalReg());
      var3.setNdbCat(var1.getNdbCat());
      var3.setNdbDevise(var1.getNdbDevise());
      var3.setNdbObject(var1.getNdbObject());
      var3.setNdbObservation(var1.getNdbObservation());
      var3.setNdbTauxRemise(var1.getNdbTauxRemise());
      var3.setNdbTotHt(var1.getNdbTotHt());
      var3.setNdbTotRemise(var1.getNdbTotRemise());
      var3.setNdbTotRabais(var1.getNdbTotRabais());
      var3.setNdbTotTva(var1.getNdbTotTva());
      var3.setNdbTotTc((double)var1.getNdbTauxTc());
      var3.setNdbTotTtc(var1.getNdbTotTtc());
      var3.setNdbTotReglement(var1.getNdbTotReglement());
      var3.setNdbSolde(var1.getNdbSolde());
      var3.setNdbBanque(var1.getNdbBanque());
      var3.setNdbTypeReg(var1.getNdbTypeReg());
      var3.setNdbModeReg(var1.getNdbModeReg());
      var3.setNdbNbJourReg(var1.getNdbNbJourReg());
      var3.setNdbArrondiReg(var1.getNdbArrondiReg());
      var3.setNdbConditionReg(var1.getNdbConditionReg());
      var3.setNdbDateEcheReg(var1.getNdbDateEcheReg());
      var3.setNdbContener(var1.getNdbContener());
      var3.setNdbActivite(var1.getNdbActivite());
      var3.setNdbSite(var1.getNdbSite());
      var3.setNdbDepartement(var1.getNdbDepartement());
      var3.setNdbRegion(var1.getNdbRegion());
      var3.setNdbSecteur(var1.getNdbSecteur());
      var3.setNdbPdv(var1.getNdbPdv());
      var3.setNdbAnal2(var1.getNdbAnal2());
      var3.setNdbAnal4(var1.getNdbAnal4());
      var3.setNdbAffaire(var1.getNdbAffaire());
      var3.setNdbInfo1(var1.getNdbInfo1());
      var3.setNdbInfo2(var1.getNdbInfo2());
      var3.setNdbInfo3(var1.getNdbInfo3());
      var3.setNdbInfo4(var1.getNdbInfo4());
      var3.setNdbInfo5(var1.getNdbInfo5());
      var3.setNdbInfo6(var1.getNdbInfo6());
      var3.setNdbInfo7(var1.getNdbInfo7());
      var3.setNdbInfo8(var1.getNdbInfo8());
      var3.setNdbInfo9(var1.getNdbInfo9());
      var3.setNdbInfo10(var1.getNdbInfo10());
      var3.setNdbFormule1(var1.getNdbFormule1());
      var3.setNdbFormule2(var1.getNdbFormule2());
      var3.setNdbAnnexe1(var1.getNdbAnnexe1());
      var3.setNdbAnnexe2(var1.getNdbAnnexe2());
      var3.setNdbContrat(var1.getNdbContrat());
      var3.setNdbIncoterm(var1.getNdbIncoterm());
      var3.setNdbLieuLivraison(var1.getNdbLieuLivraison());
      var3.setNdbDateLivraison(var1.getNdbDateLivraison());
      var3.setNdbInfoLivraison(var1.getNdbInfoLivraison());
      var3.setNdbDateImp(var1.getNdbDateImp());
      var3.setNdbModeleImp(var1.getNdbModeleImp());
      var3.setNdbGarde(var1.getNdbGarde());
      var3.setNdbGele(var1.getNdbGele());
      var3.setNdbEtat(var1.getNdbEtat());
      var3.setNdbDateTransforme(var1.getNdbDateTransforme());
      var3.setNdbDateAnnule(var1.getNdbDateAnnule());
      var3.setNdbMotifAnnule(var1.getNdbMotifAnnule());
      var3.setNdbFactorNom(var1.getNdbFactorNom());
      var3.setNdbFactorId(var1.getNdbFactorId());
      var3.setNdbFactorEtat(var1.getNdbFactorEtat());
      var3.setExerciceventes(var1.getExerciceventes());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from NoteDebitEnteteVentes order by ndbId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            NoteDebitEnteteVentes var7 = (NoteDebitEnteteVentes)var6.get(0);
            var4 = 1L + var7.getNdbId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public NoteDebitEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from NoteDebitEnteteVentes where exerciceventes.exevteId=:id and ndbSerie =:ser and year(ndbDate)=" + var7 + " order by ndbDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      NoteDebitEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (NoteDebitEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public NoteDebitEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from NoteDebitEnteteVentes where exerciceventes.exevteId=:id and ndbSerie =:ser and year(ndbDate)=" + var7 + " and month(ndbDate)=" + var8 + " order by ndbDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      NoteDebitEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (NoteDebitEnteteVentes)var11.get(0);
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
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var30 = true;
      }

      UtilDate var31 = new UtilDate();
      new ArrayList();
      Criteria var33 = var1.createCriteria(NoteDebitEnteteVentes.class);
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
            var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
         } else {
            var41 = "1980-01-01";
            var31.stringToDateSQL(var41 + " 00:00:00");
            var33 = var33.add(Restrictions.isNotNull("ndbDate"));
         }
      } else {
         if (!var13.equalsIgnoreCase("12") && !var13.equalsIgnoreCase("13") && !var13.equalsIgnoreCase("14")) {
            var33 = var33.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var13.equalsIgnoreCase("0")) {
            var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
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
            var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
         } else {
            int var45;
            if (var13.equalsIgnoreCase("2")) {
               var45 = var34.get(2) + 1;
               var42 = var40 + "-" + var45 + "-01";
               var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
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

               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
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

               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("5")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-03-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("6")) {
               var41 = var40 + "-04-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-06-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("7")) {
               var41 = var40 + "-07-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-09-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("8")) {
               var41 = var40 + "-10-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("9")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-06-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("10")) {
               var41 = var40 + "-07-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("11")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("12")) {
               var41 = "1980-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 - 1 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("13")) {
               var41 = var40 - 1 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("14")) {
               var41 = var40 - 1 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 - 1 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("ndbDate", var35, var36));
            } else if (var13.equalsIgnoreCase("20")) {
               var33.setMaxResults(20);
               var33 = var33.addOrder(Order.desc("ndbId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var41 = "%" + var4 + "%";
         var33 = var33.add(Restrictions.like("ndbNum", var41));
      }

      if (var5 != null && !var5.isEmpty()) {
         var41 = "%" + var5 + "%";
         var33 = var33.add(Restrictions.like("ndbNumClient", var41));
      }

      if (var6 != null && !var6.isEmpty()) {
         var41 = "%" + var6 + "%";
         var33 = var33.add(Restrictions.like("ndbAnal4", var41));
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

         var33 = var33.add(Restrictions.or(Restrictions.like("ndbNomTiers", var41), Restrictions.like("ndbDiversNom", var41)));
      }

      if (var17 != null && !var17.isEmpty()) {
         var33 = var33.add(Restrictions.eq("ndbNomContact", var17));
      }

      if (var18 != null && !var18.isEmpty()) {
         var33 = var33.add(Restrictions.eq("ndbNomResponsable", var18));
      }

      if (var19 != null && !var19.isEmpty()) {
         var33 = var33.add(Restrictions.eq("ndbNomCommercial", var19));
      }

      if (var16 == 1 || var16 == 2) {
         var33 = var33.add(Restrictions.eq("ndbIdCreateur", var14));
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

            var33 = var33.add(Restrictions.in("ndbSerie", var43));
         } else {
            var33 = var33.add(Restrictions.eq("ndbSerie", var11));
         }
      }

      if (!var12.equalsIgnoreCase("100")) {
         var33 = var33.add(Restrictions.eq("ndbCat", var12));
      }

      if (var10 <= 10) {
         var33 = var33.add(Restrictions.eq("ndbEtat", var10));
      } else if (var10 == 11) {
         var33 = var33.add(Restrictions.isNotNull("ndbDateRelance"));
      } else if (var10 == 12) {
         var33 = var33.add(Restrictions.eq("ndbTotHt", 0.0D));
      } else if (var10 == 13) {
         var33 = var33.add(Restrictions.eq("ndbSolde", 0));
      } else if (var10 == 14) {
         var33 = var33.add(Restrictions.eq("ndbSolde", 1));
      } else if (var10 == 15) {
         var33 = var33.add(Restrictions.eq("ndbExoTva", 1));
      } else if (var10 == 16) {
         var33 = var33.add(Restrictions.and(Restrictions.eq("ndbExoTva", 1), Restrictions.isNull("ndbDateVisa")));
      } else if (var10 == 17) {
         var33 = var33.add(Restrictions.isNotNull("ndbDateTransfert"));
      } else if (var10 == 18) {
         var33 = var33.add(Restrictions.isNull("ndbDateTransfert"));
      }

      if (!var20.equalsIgnoreCase("100")) {
         var47 = var20.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("ndbActivite", var42));
      }

      if (var24 != null && !var24.isEmpty() && var24.contains(":")) {
         var47 = var24.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("ndbRegion", var42));
      }

      if (var25 != null && !var25.isEmpty() && var25.contains(":")) {
         var47 = var25.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("ndbSecteur", var42));
      }

      if (var26 != null && !var26.isEmpty() && var26.contains(":")) {
         var47 = var26.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("ndbPdv", var42));
      }

      if (var27 != null && !var27.isEmpty()) {
         var33 = var33.add(Restrictions.eq("ndbSite", var27));
      }

      if (var28 != null && !var28.isEmpty()) {
         var33 = var33.add(Restrictions.eq("fndbDepartement", var28));
      }

      if (var29 != null && !var29.isEmpty()) {
         var33 = var33.add(Restrictions.eq("ndbService", var29));
      }

      if (var21 != null && !var21.isEmpty()) {
         var41 = "%" + var21 + "%";
         var33 = var33.add(Restrictions.like("ndbContener", var41));
      }

      var33 = var33.addOrder(Order.desc("ndbDate"));
      var33 = var33.addOrder(Order.desc("ndbNum"));
      List var48 = var33.list();
      if (var30) {
         this.utilInitHibernate.closeSession();
      }

      return var48;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from NoteDebitEnteteVentes where ndbService='" + var1 + "' and (ndbDateEcheReg='" + var5 + "' or ndbTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from NoteDebitEnteteVentes where ndbDateEcheReg='" + var5 + "' or ndbTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public NoteDebitEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from NoteDebitEnteteVentes where ndbId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      NoteDebitEnteteVentes var7 = new NoteDebitEnteteVentes();
      if (var6.size() != 0) {
         var7 = (NoteDebitEnteteVentes)var6.get(0);
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public NoteDebitEnteteVentes pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from NoteDebitEnteteVentes where ndbNum =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      NoteDebitEnteteVentes var6 = new NoteDebitEnteteVentes();
      if (var5.size() != 0) {
         var6 = (NoteDebitEnteteVentes)var5.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheNoteDebitATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from NoteDebitEnteteVentes where (ndbEtat=0 or ndbEtat=1 or ndbEtat=4 or ndbEtat=5) and ndbDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from NoteDebitEnteteVentes where (ndbEtat=0 or ndbEtat=1 or ndbEtat=4 or ndbEtat=5) and ndbDateTransfert is NULL and ndbDate>=:dte1 and ndbDate<=:dte2 and ndbNum>=:p1 and ndbNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from NoteDebitEnteteVentes where (ndbEtat=0 or ndbEtat=1 or ndbEtat=4 or ndbEtat=5) and ndbDateTransfert is NULL and ndbDate>=:dte1 and ndbDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from NoteDebitEnteteVentes where (ndbEtat=1 or ndbEtat=4 or ndbEtat=5) and ndbDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from NoteDebitEnteteVentes where (ndbEtat=1 or ndbEtat=4 or ndbEtat=5) and ndbDateTransfert is NULL and ndbDate>=:dte1 and ndbDate<=:dte2 and ndbNum>=:p1 and ndbNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from NoteDebitEnteteVentes where (ndbEtat=1 or ndbEtat=4 or ndbEtat=5) and ndbDateTransfert is NULL and ndbDate>=:dte1 and ndbDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheNoteDebitDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from NoteDebitEnteteVentes where (ndbEtat=0 or ndbEtat=1 or ndbEtat=4 or ndbEtat=5) and (ndbDateTransfert<>'' and ndbDateTransfert is not null) and ndbDate>=:dte1 and ndbDate<=:dte2").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheNoteDebitRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from NoteDebitEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
      Query var4 = var3.createQuery("from NoteDebitEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from NoteDebitEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public List rechercheCommissions(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from NoteDebitEnteteVentes where ndbSolde=1 and ndbDate>=:d1 and ndbDate<=:d2").setDate("d1", var1).setDate("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public NoteDebitEnteteVentes pourParapheurByNum(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "NoteDebitEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from NoteDebitEnteteVentes where ndbNum=:num and ndbSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new NoteDebitEnteteVentes();
      NoteDebitEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (NoteDebitEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      return var7;
   }

   public List rechercheDevisAPayerCriterion(String var1, Session var2) throws ParseException {
      new ArrayList();
      String var4 = "";
      Criteria var5 = var2.createCriteria(NoteDebitEnteteVentes.class);
      new ArrayList();
      var5 = var5.add(Restrictions.or(Restrictions.eq("ndbTypeReg", 0), Restrictions.eq("ndbTypeReg", 4)));
      if (!var1.equalsIgnoreCase("100")) {
         System.out.println("recherche sans service ");
      } else {
         var5 = var5.add(Restrictions.eq("ndbService", var1));
      }

      List var3 = var5.list();
      System.out.println("nombre de resultat retourné  ds note de debit" + var3.size());
      return var3;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from NoteDebitEnteteVentes where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheNoteDebitByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from NoteDebitEnteteVentes where ndbDate>=:deb and ndbDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from NoteDebitEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheNoteDebitCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BnoteDebitEntete");
         var6 = true;
      }

      List var7 = var4.createQuery("from NoteDebitEnteteVentes where ndbDate>=:d1 and ndbSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
