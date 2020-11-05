package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CommandeEnteteVentes;
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

public class CommandeEnteteVentesDao implements Serializable {
   private CommandeEnteteVentes commandeEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CommandeEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CommandeEnteteVentes insert(CommandeEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CommandeEnteteVentes modif(CommandeEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
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

   public CommandeEnteteVentes modif(CommandeEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from CommandeEnteteVentes where bcmId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return null;
   }

   public CommandeEnteteVentes duppliquer(CommandeEnteteVentes var1, Session var2) {
      CommandeEnteteVentes var3 = new CommandeEnteteVentes();
      var3.setBcmSerie(var1.getBcmSerie());
      var3.setBcmIdCreateur(var1.getBcmIdCreateur());
      var3.setBcmNomCreateur(var1.getBcmNomCreateur());
      var3.setBcmDate(var1.getBcmDate());
      var3.setBcmDateCreat(var1.getBcmDateCreat());
      var3.setBcmDateModif(var1.getBcmDateModif());
      var3.setBcmIdModif(var1.getBcmIdModif());
      var3.setBcmNomModif(var1.getBcmNomModif());
      var3.setBcmNum(var1.getBcmNum());
      var3.setBcmDateRelance(var1.getBcmDateRelance());
      var3.setBcmDateValidite(var1.getBcmDateValidite());
      var3.setBcmService(var1.getBcmService());
      var3.setBcmNum(var1.getBcmNum());
      var3.setBcmSource(var1.getBcmSource());
      var3.setBcmNomResponsable(var1.getBcmNomResponsable());
      var3.setBcmIdResponsable(var1.getBcmIdResponsable());
      var3.setBcmNomCommercial(var1.getBcmNomCommercial());
      var3.setBcmIdCommercial(var1.getBcmIdCommercial());
      var3.setBcmNomTiers(var1.getBcmNomTiers());
      var3.setBcmCivilTiers(var1.getBcmCivilTiers());
      var3.setBcmTiersRegroupe(var1.getBcmTiersRegroupe());
      var3.setBcmIdContact(var1.getBcmIdContact());
      var3.setBcmNomContact(var1.getBcmNomContact());
      var3.setBcmCivilContact(var1.getBcmCivilContact());
      var3.setBcmDiversAdresse(var1.getBcmDiversAdresse());
      var3.setBcmDiversMail(var1.getBcmDiversMail());
      var3.setBcmDiversNom(var1.getBcmDiversNom());
      var3.setBcmDiversTel(var1.getBcmDiversTel());
      var3.setBcmDiversTiers(var1.getBcmDiversTiers());
      var3.setBcmDiversVille(var1.getBcmDiversVille());
      var3.setBcmExoTva(var1.getBcmExoTva());
      var3.setBcmExoDouane(var1.getBcmExoDouane());
      var3.setBcmJournalReg(var1.getBcmJournalReg());
      var3.setBcmCat(var1.getBcmCat());
      var3.setBcmDevise(var1.getBcmDevise());
      var3.setBcmObject(var1.getBcmObject());
      var3.setBcmObservation(var1.getBcmObservation());
      var3.setBcmTauxRemise(var1.getBcmTauxRemise());
      var3.setBcmTotHt(var1.getBcmTotHt());
      var3.setBcmTotRemise(var1.getBcmTotRemise());
      var3.setBcmTotRabais(var1.getBcmTotRabais());
      var3.setBcmTotTva(var1.getBcmTotTva());
      var3.setBcmTotTc((double)var1.getBcmTauxTc());
      var3.setBcmTotTtc(var1.getBcmTotTtc());
      var3.setBcmTotReglement(var1.getBcmTotReglement());
      var3.setBcmSolde(var1.getBcmSolde());
      var3.setBcmBanque(var1.getBcmBanque());
      var3.setBcmTypeReg(var1.getBcmTypeReg());
      var3.setBcmModeReg(var1.getBcmModeReg());
      var3.setBcmNbJourReg(var1.getBcmNbJourReg());
      var3.setBcmArrondiReg(var1.getBcmArrondiReg());
      var3.setBcmConditionReg(var1.getBcmConditionReg());
      var3.setBcmDateEcheReg(var1.getBcmDateEcheReg());
      var3.setBcmContener(var1.getBcmContener());
      var3.setBcmActivite(var1.getBcmActivite());
      var3.setBcmSite(var1.getBcmSite());
      var3.setBcmDepartement(var1.getBcmDepartement());
      var3.setBcmRegion(var1.getBcmRegion());
      var3.setBcmSecteur(var1.getBcmSecteur());
      var3.setBcmPdv(var1.getBcmPdv());
      var3.setBcmAnal2(var1.getBcmAnal2());
      var3.setBcmAnal4(var1.getBcmAnal4());
      var3.setBcmAffaire(var1.getBcmAffaire());
      var3.setBcmInfo1(var1.getBcmInfo1());
      var3.setBcmInfo2(var1.getBcmInfo2());
      var3.setBcmInfo3(var1.getBcmInfo3());
      var3.setBcmInfo4(var1.getBcmInfo4());
      var3.setBcmInfo5(var1.getBcmInfo5());
      var3.setBcmInfo6(var1.getBcmInfo6());
      var3.setBcmInfo7(var1.getBcmInfo7());
      var3.setBcmInfo8(var1.getBcmInfo8());
      var3.setBcmInfo9(var1.getBcmInfo9());
      var3.setBcmInfo10(var1.getBcmInfo10());
      var3.setBcmFormule1(var1.getBcmFormule1());
      var3.setBcmFormule2(var1.getBcmFormule2());
      var3.setBcmAnnexe1(var1.getBcmAnnexe1());
      var3.setBcmAnnexe2(var1.getBcmAnnexe2());
      var3.setBcmContrat(var1.getBcmContrat());
      var3.setBcmIncoterm(var1.getBcmIncoterm());
      var3.setBcmLieuLivraison(var1.getBcmLieuLivraison());
      var3.setBcmDateLivraison(var1.getBcmDateLivraison());
      var3.setBcmInfoLivraison(var1.getBcmInfoLivraison());
      var3.setBcmDateImp(var1.getBcmDateImp());
      var3.setBcmModeleImp(var1.getBcmModeleImp());
      var3.setBcmGarde(var1.getBcmGarde());
      var3.setBcmGele(var1.getBcmGele());
      var3.setBcmEtat(var1.getBcmEtat());
      var3.setBcmDateTransforme(var1.getBcmDateTransforme());
      var3.setBcmDateLastReg(var1.getBcmDateLastReg());
      var3.setBcmTypeTransforme(var1.getBcmTypeTransforme());
      var3.setBcmDateAnnule(var1.getBcmDateAnnule());
      var3.setBcmMotifAnnule(var1.getBcmMotifAnnule());
      var3.setBcmNiveau(var1.getBcmNiveau());
      var3.setBcmPreparateur(var1.getBcmPreparateur());
      var3.setBcmConseil(var1.getBcmConseil());
      var3.setBcmFactorNom(var1.getBcmFactorNom());
      var3.setBcmFactorId(var1.getBcmFactorId());
      var3.setBcmFactorEtat(var1.getBcmFactorEtat());
      var3.setBcmPhase(var1.getBcmPhase());
      var3.setBcmRistourneBloquee(false);
      var3.setBcmStock(var1.getBcmStock());
      var3.setExerciceventes(var1.getExerciceventes());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from CommandeEnteteVentes order by bcmId desc").setMaxResults(1);
      long var4 = 1L;
      if (var3.list() != null) {
         List var6 = var3.list();
         if (var6.size() > 0) {
            CommandeEnteteVentes var7 = (CommandeEnteteVentes)var6.get(0);
            var4 = 1L + var7.getBcmId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public CommandeEnteteVentes selectByNum(Session var1, String var2) {
      CommandeEnteteVentes var3 = new CommandeEnteteVentes();
      Query var4 = var1.createQuery("from CommandeEnteteVentes where bcmNum =:numero");
      var4.setParameter("numero", var2);
      var4.setMaxResults(1);
      List var5 = var4.list();
      if (var5.size() > 0) {
         var3 = (CommandeEnteteVentes)var5.get(0);
      }

      return var3;
   }

   public CommandeEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from CommandeEnteteVentes where exerciceventes.exevteId=:id and bcmSerie =:ser and year(bcmDate)=" + var7 + " order by bcmDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      CommandeEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (CommandeEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public CommandeEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from CommandeEnteteVentes where exerciceventes.exevteId=:id and bcmSerie =:ser and year(bcmDate)=" + var7 + " and month(bcmDate)=" + var8 + " order by bcmDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      CommandeEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (CommandeEnteteVentes)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, String var5, String var6, long var7, String var9, int var10, String var11, String var12, String var13, long var14, int var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, int var30) throws HibernateException, NamingException, ParseException {
      boolean var31 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var31 = true;
      }

      UtilDate var32 = new UtilDate();
      new ArrayList();
      Criteria var34 = var1.createCriteria(CommandeEnteteVentes.class);
      Calendar var35 = Calendar.getInstance();
      Date var36 = null;
      Date var37 = null;
      Date var38 = new Date();
      String var39 = var32.dateToStringFr(var38);
      String var40 = var39.substring(6, 10) + "-" + var39.substring(3, 5) + "-" + var39.substring(0, 2);
      var36 = var32.stringToDateSQL(var40 + " 00:00:00");
      var37 = var32.stringToDateSQL(var40 + " 23:59:59");
      int var41 = var38.getYear() + 1900;
      String var42;
      String var43;
      if (var13.equalsIgnoreCase("100")) {
         if (var22 != null && var23 != null) {
            var36 = var32.stringToDateSQL(var22 + " 00:00:00");
            var37 = var32.stringToDateSQL(var23 + " 23:59:59");
            var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
         } else {
            var42 = "1980-01-01";
            var32.stringToDateSQL(var42 + " 00:00:00");
            var34 = var34.add(Restrictions.isNotNull("bcmDate"));
         }
      } else {
         if (!var13.equalsIgnoreCase("12") && !var13.equalsIgnoreCase("13") && !var13.equalsIgnoreCase("14")) {
            var34 = var34.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var13.equalsIgnoreCase("0")) {
            var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
         } else if (var13.equalsIgnoreCase("1")) {
            var42 = "" + var35.getTime();
            if (var42.contains("Mon")) {
               var36 = var35.getTime();
            } else if (var42.contains("Tue")) {
               var35.add(7, -1);
               var36 = var35.getTime();
            } else if (var42.contains("Wed")) {
               var35.add(7, -2);
               var36 = var35.getTime();
            } else if (var42.contains("Thu")) {
               var35.add(7, -3);
               var36 = var35.getTime();
            } else if (var42.contains("Fri")) {
               var35.add(7, -4);
               var36 = var35.getTime();
            } else if (var42.contains("Sat")) {
               var35.add(7, -5);
               var36 = var35.getTime();
            } else if (var42.contains("Sun")) {
               var35.add(7, -6);
               var36 = var35.getTime();
            }

            var39 = var32.dateToStringFr(var36);
            var40 = var39.substring(6, 10) + "-" + var39.substring(3, 5) + "-" + var39.substring(0, 2);
            var36 = var32.stringToDateSQL(var40 + " 00:00:00");
            var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
         } else {
            int var46;
            if (var13.equalsIgnoreCase("2")) {
               var46 = var35.get(2) + 1;
               var43 = var41 + "-" + var46 + "-01";
               var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("3")) {
               var46 = var35.get(2);
               var35.add(5, -var46);
               if (var46 <= 3) {
                  var43 = var41 + "-01-01";
                  var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               } else if (var46 >= 4 && var46 <= 6) {
                  var43 = var41 + "-04-01";
                  var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               } else if (var46 >= 7 && var46 <= 9) {
                  var43 = var41 + "-07-01";
                  var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               } else if (var46 >= 10) {
                  var43 = var41 + "-10-01";
                  var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               }

               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("4")) {
               var46 = var35.get(2);
               var35.add(5, -var46);
               if (var46 <= 6) {
                  var43 = var41 + "-01-01";
                  var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               } else {
                  var43 = var41 + "-07-01";
                  var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               }

               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("5")) {
               var42 = var41 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-03-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("6")) {
               var42 = var41 + "-04-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-06-30";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("7")) {
               var42 = var41 + "-07-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-09-30";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("8")) {
               var42 = var41 + "-10-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("9")) {
               var42 = var41 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-06-30";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("10")) {
               var42 = var41 + "-07-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("11")) {
               var42 = var41 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("12")) {
               var42 = "1980-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 - 1 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("13")) {
               var42 = var41 - 1 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("14")) {
               var42 = var41 - 1 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 - 1 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("bcmDate", var36, var37));
            } else if (var13.equalsIgnoreCase("20")) {
               var34.setMaxResults(20);
               var34 = var34.addOrder(Order.desc("bcmId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var42 = "%" + var4 + "%";
         var34 = var34.add(Restrictions.like("bcmNum", var42));
      }

      if (var5 != null && !var5.isEmpty()) {
         var42 = "%" + var5 + "%";
         var34 = var34.add(Restrictions.like("bcmNumClient", var42));
      }

      if (var6 != null && !var6.isEmpty()) {
         var42 = "%" + var6 + "%";
         var34 = var34.add(Restrictions.like("bcmAnal4", var42));
      }

      String[] var49;
      if (var7 != 0L) {
         var34 = var34.add(Restrictions.eq("tiers.tieid", var7));
      } else {
         if (var9 != null && !var9.isEmpty() && !var9.contains(":")) {
            var42 = "";
            if (var9.startsWith("*")) {
               var42 = "%" + var9.substring(1) + "%";
            } else {
               var42 = var9 + "%";
            }

            var34 = var34.add(Restrictions.or(Restrictions.like("bcmNomTiers", var42), Restrictions.like("bcmDiversNom", var42)));
         }

         if (var9 != null && !var9.isEmpty() && var9.contains(":")) {
            var49 = var9.split(":");
            long var47 = Long.parseLong(var49[0]);
            var34 = var34.add(Restrictions.eq("tiers.tieid", var47));
         }
      }

      if (var17 != null && !var17.isEmpty()) {
         var34 = var34.add(Restrictions.eq("bcmNomContact", var17));
      }

      if (var18 != null && !var18.isEmpty()) {
         var34 = var34.add(Restrictions.eq("bcmNomResponsable", var18));
      }

      if (var19 != null && !var19.isEmpty()) {
         var34 = var34.add(Restrictions.eq("bcmNomCommercial", var19));
      }

      if (var16 == 1 || var16 == 2) {
         var34 = var34.add(Restrictions.eq("bcmIdCreateur", var14));
      }

      if (!var11.equalsIgnoreCase("100")) {
         if (var11.contains(",")) {
            var49 = var11.split(",");
            int var48 = var49.length;
            String[] var44 = new String[var48];

            for(int var45 = 0; var45 < var48; ++var45) {
               var44[var45] = new String(var49[var45]);
            }

            var34 = var34.add(Restrictions.in("bcmSerie", var44));
         } else {
            var34 = var34.add(Restrictions.eq("bcmSerie", var11));
         }
      }

      if (!var12.equalsIgnoreCase("100")) {
         if (var12.equalsIgnoreCase("101")) {
            var34 = var34.add(Restrictions.eq("bcmSuivi", 0));
         } else if (var12.equalsIgnoreCase("102")) {
            var34 = var34.add(Restrictions.eq("bcmSuivi", 1));
         } else {
            var34 = var34.add(Restrictions.eq("bcmCat", var12));
         }
      }

      if (var10 <= 10) {
         var34 = var34.add(Restrictions.eq("bcmEtat", var10));
      } else if (var10 == 11) {
         var34 = var34.add(Restrictions.isNotNull("bcmDateRelance"));
      } else if (var10 == 12) {
         var34 = var34.add(Restrictions.eq("bcmTotHt", 0.0D));
      } else if (var10 == 13) {
         var34 = var34.add(Restrictions.eq("bcmSolde", 0));
      } else if (var10 == 14) {
         var34 = var34.add(Restrictions.eq("bcmSolde", 1));
      } else if (var10 == 16) {
         var34 = var34.add(Restrictions.ne("bcmTotReglement", 0.0D)).add(Restrictions.eq("bcmSolde", 0));
      } else if (var10 == 21) {
         var34 = var34.add(Restrictions.eq("bcmPhase", 0)).add(Restrictions.eq("bcmEtat", 1));
      } else if (var10 == 22) {
         var34 = var34.add(Restrictions.eq("bcmPhase", 1)).add(Restrictions.eq("bcmEtat", 1));
      } else if (var10 == 23) {
         var34 = var34.add(Restrictions.eq("bcmPhase", 2)).add(Restrictions.eq("bcmEtat", 1));
      } else if (var10 == 24) {
         var34 = var34.add(Restrictions.eq("bcmNiveau", 0));
      } else if (var10 == 25) {
         var34 = var34.add(Restrictions.eq("bcmNiveau", 1));
      } else if (var10 == 26) {
         var34 = var34.add(Restrictions.eq("bcmNiveau", 2));
      } else if (var10 == 27) {
         var34 = var34.add(Restrictions.eq("bcmNiveau", 3));
      } else if (var10 == 28) {
         var34 = var34.add(Restrictions.or(Restrictions.between("bcmEtat", 0, 1), Restrictions.eq("bcmEtat", 4))).add(Restrictions.eq("bcmSolde", 0));
      } else if (var10 == 29) {
         var34 = var34.add(Restrictions.or(Restrictions.eq("bcmEtat", 1), Restrictions.eq("bcmEtat", 4)));
      } else if (var10 == 30) {
         var34 = var34.add(Restrictions.and(Restrictions.ne("bcmEtat", 2), Restrictions.ne("bcmEtat", 3)));
      }

      if (!var20.equalsIgnoreCase("100")) {
         var49 = var20.split(":");
         var43 = var49[0];
         var34 = var34.add(Restrictions.eq("bcmActivite", var43));
      }

      if (var24 != null && !var24.isEmpty() && var24.contains(":")) {
         var49 = var24.split(":");
         var43 = var49[0];
         var34 = var34.add(Restrictions.eq("bcmRegion", var43));
      }

      if (var25 != null && !var25.isEmpty() && var25.contains(":")) {
         var49 = var25.split(":");
         var43 = var49[0];
         var34 = var34.add(Restrictions.eq("bcmSecteur", var43));
      }

      if (var26 != null && !var26.isEmpty() && var26.contains(":")) {
         var49 = var26.split(":");
         var43 = var49[0];
         var34 = var34.add(Restrictions.eq("bcmPdv", var43));
      }

      if (var27 != null && !var27.isEmpty()) {
         var34 = var34.add(Restrictions.eq("bcmSite", var27));
      }

      if (var28 != null && !var28.isEmpty()) {
         var34 = var34.add(Restrictions.eq("bcmDepartement", var28));
      }

      if (var29 != null && !var29.isEmpty()) {
         var34 = var34.add(Restrictions.eq("bcmService", var29));
      }

      if (var21 != null && !var21.isEmpty()) {
         var42 = "%" + var21 + "%";
         var34 = var34.add(Restrictions.like("bcmContener", var42));
      }

      if (var30 != 99) {
         var34 = var34.add(Restrictions.eq("bcmModeLivraison", var30));
      }

      var34 = var34.addOrder(Order.desc("bcmDate"));
      var34 = var34.addOrder(Order.desc("bcmNum"));
      List var50 = var34.list();
      if (var31) {
         this.utilInitHibernate.closeSession();
      }

      return var50;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from CommandeEnteteVentes where bcmService='" + var1 + "' and (bcmDateEcheReg='" + var5 + "' or bcmTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from CommandeEnteteVentes where bcmDateEcheReg='" + var5 + "' or bcmTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheCommandeRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CommandeEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCommandeByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from CommandeEnteteVentes where bcmDate>=:deb and bcmDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public CommandeEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CommandeEnteteVentes where bcmId=:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new CommandeEnteteVentes();
      CommandeEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (CommandeEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CommandeEnteteVentes pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from CommandeEnteteVentes where bcmNum=:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new CommandeEnteteVentes();
      CommandeEnteteVentes var6;
      if (var5.size() != 0) {
         var6 = (CommandeEnteteVentes)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
      Query var4 = var3.createQuery("from CommandeEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from CommandeEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from CommandeEnteteVentes where tiers=:tie and bcmSolde=0 and bcmEtat>=1 and bcmSerie=:ser").setParameter("tie", var1).setString("ser", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from CommandeEnteteVentes where tiers=:tie order by bcmDate").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheNonPayeesByTiers(Tiers var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from CommandeEnteteVentes where tiers=:tie and bcmSolde=0 and bcmSerie in (" + var2 + ")order by bcmDate").setParameter("tie", var1).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from CommandeEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCommandeAPayerCriterion(String var1, Session var2) throws ParseException {
      new ArrayList();
      String var4 = "";
      Criteria var5 = var2.createCriteria(CommandeEnteteVentes.class);
      var5 = var5.add(Restrictions.eq("bcmConptant", 1));
      if (!var1.equalsIgnoreCase("100")) {
         System.out.println("recherche sans service ");
      } else {
         var5 = var5.add(Restrictions.eq("bcmService", var1));
      }

      List var3 = var5.list();
      return var3;
   }

   public CommandeEnteteVentes pourParapheurByNum(String var1, String var2, Session var3) {
      Query var4 = null;
      if (var2 != null && !var2.isEmpty()) {
         var4 = var3.createQuery("from CommandeEnteteVentes where bcmNum=:numero and bcmSerie=:ser").setString("numero", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var4 = var3.createQuery("from CommandeEnteteVentes where bcmNum=:numero").setString("numero", var1).setMaxResults(1);
      }

      List var5 = var4.list();
      new CommandeEnteteVentes();
      CommandeEnteteVentes var6;
      if (var5.size() != 0) {
         var6 = (CommandeEnteteVentes)var5.get(0);
      } else {
         var6 = null;
      }

      return var6;
   }

   public CommandeEnteteVentes rechercheCommandeByNumClient(String var1, Tiers var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var6 = true;
      }

      Query var7 = var5.createQuery("from CommandeEnteteVentes where bcmNumClient=:numero and tiers=:tie and bcmId<>" + var3).setParameter("tie", var2).setString("numero", var1).setMaxResults(1);
      List var8 = var7.list();
      new CommandeEnteteVentes();
      CommandeEnteteVentes var9;
      if (var8.size() != 0) {
         var9 = (CommandeEnteteVentes)var8.get(0);
      } else {
         var9 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public List rechercheCommandeCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var6 = true;
      }

      List var7 = var4.createQuery("from CommandeEnteteVentes where bcmDate>=:d1 and bcmSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List selectRdv(Date var1, Date var2, int var3, int var4, Session var5) throws HibernateException, NamingException, ParseException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var6 = true;
      }

      List var7 = null;
      if (var4 == 10) {
         if (var3 == 99) {
            var7 = var5.createQuery("from CommandeEnteteVentes where (bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and (bcmEtatLivraison=0 or bcmEtatLivraison=3 or bcmEtatLivraison=4 or bcmEtatLivraison=7) and (bcmModeLivraison=0 or bcmModeLivraison=1 or bcmModeLivraison=2) and bcmDateLivraison>=:deb and bcmDateLivraison<=:fin").setDate("deb", var1).setDate("fin", var2).list();
         } else {
            var7 = var5.createQuery("from CommandeEnteteVentes where (bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and (bcmEtatLivraison=0 or bcmEtatLivraison=3 or bcmEtatLivraison=4 or bcmEtatLivraison=7) and bcmModeLivraison=:mode and bcmDateLivraison>=:deb and bcmDateLivraison<=:fin").setDate("deb", var1).setDate("fin", var2).setInteger("mode", var3).list();
         }
      } else if (var3 == 99) {
         var7 = var5.createQuery("from CommandeEnteteVentes where (bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and bcmEtatLivraison=:stat and (bcmModeLivraison=0 or bcmModeLivraison=1 or bcmModeLivraison=2) and bcmDateLivraison>=:deb and bcmDateLivraison<=:fin").setDate("deb", var1).setDate("fin", var2).setInteger("stat", var4).list();
      } else {
         var7 = var5.createQuery("from CommandeEnteteVentes where (bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and bcmEtatLivraison=:stat and bcmModeLivraison=:mode and bcmDateLivraison>=:deb and bcmDateLivraison<=:fin").setDate("deb", var1).setDate("fin", var2).setInteger("mode", var3).setInteger("stat", var4).list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheDejaPayer(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from CommandeEnteteVentes where bcmTotReglement<>0 and bcmDate>=:d1 and bcmDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheCommandeATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from CommandeEnteteVentes where (bcmEtat=0 or bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and bcmDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from CommandeEnteteVentes where (bcmEtat=0 or bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and bcmDateTransfert is NULL and bcmDate>=:dte1 and bcmDate<=:dte2 and bcmNum>=:p1 and bcmNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from CommandeEnteteVentes where (bcmEtat=0 or bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and bcmDateTransfert is NULL and bcmDate>=:dte1 and bcmDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from CommandeEnteteVentes where (bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and bcmDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from CommandeEnteteVentes where (bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and bcmDateTransfert is NULL and bcmDate>=:dte1 and bcmDate<=:dte2 and bcmNum>=:p1 and bcmNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from CommandeEnteteVentes where (bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and bcmDateTransfert is NULL and bcmDate>=:dte1 and bcmDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheCommandeDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BcommandeEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from CommandeEnteteVentes where (bcmEtat=0 or bcmEtat=1 or bcmEtat=4 or bcmEtat=5) and (bcmDateTransfert<>'' and bcmDateTransfert is not null) and (bcmDate>=:dte1 and bcmDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
