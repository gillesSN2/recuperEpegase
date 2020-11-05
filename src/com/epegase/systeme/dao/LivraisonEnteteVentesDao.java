package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
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

public class LivraisonEnteteVentesDao implements Serializable {
   private LivraisonEnteteVentes livraisonEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public LivraisonEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public LivraisonEnteteVentes insert(LivraisonEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public LivraisonEnteteVentes modif(LivraisonEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
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

   public LivraisonEnteteVentes modif(LivraisonEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void modifOneLigne(LivraisonEnteteVentes var1, Session var2) {
      Query var3 = var2.createQuery("update LivraisonEnteteVentes set blvTotHt=" + var1.getBlvTotHt() + ",blvTotRemise=" + var1.getBlvTotRemise() + ",blvTotRabais=" + var1.getBlvTotRabais() + ",blvTotTva=" + var1.getBlvTotTva() + ",blvTotTc=" + var1.getBlvTotTc() + ",blvTotTtc=" + var1.getBlvTotTtc() + "  where blvId=" + var1.getBlvId());
      var3.executeUpdate();
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from LivraisonEnteteVentes where blvId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public LivraisonEnteteVentes duppliquer(LivraisonEnteteVentes var1, Session var2) {
      LivraisonEnteteVentes var3 = new LivraisonEnteteVentes();
      var3.setBlvSerie(var1.getBlvSerie());
      var3.setBlvIdCreateur(var1.getBlvIdCreateur());
      var3.setBlvNomCreateur(var1.getBlvNomCreateur());
      var3.setBlvDate(var1.getBlvDate());
      var3.setBlvDateCreat(var1.getBlvDate());
      var3.setBlvDateModif(var1.getBlvDateModif());
      var3.setBlvIdModif(var1.getBlvIdModif());
      var3.setBlvNomModif(var1.getBlvNomModif());
      var3.setBlvNum(var1.getBlvNum());
      var3.setBlvDateRelance(var1.getBlvDateRelance());
      var3.setBlvDateValidite(var1.getBlvDateValidite());
      var3.setBlvService(var1.getBlvService());
      var3.setBlvSource(var1.getBlvSource());
      var3.setBlvNomResponsable(var1.getBlvNomResponsable());
      var3.setBlvIdResponsable(var1.getBlvIdResponsable());
      var3.setBlvNomCommercial(var1.getBlvNomCommercial());
      var3.setBlvIdCommercial(var1.getBlvIdCommercial());
      var3.setBlvNomTiers(var1.getBlvNomTiers());
      var3.setBlvCivilTiers(var1.getBlvCivilTiers());
      var3.setBlvTiersRegroupe(var1.getBlvTiersRegroupe());
      var3.setBlvIdContact(var1.getBlvIdContact());
      var3.setBlvNomContact(var1.getBlvNomContact());
      var3.setBlvCivilContact(var1.getBlvCivilContact());
      var3.setBlvDiversAdresse(var1.getBlvDiversAdresse());
      var3.setBlvDiversMail(var1.getBlvDiversMail());
      var3.setBlvDiversNom(var1.getBlvDiversNom());
      var3.setBlvDiversTel(var1.getBlvDiversTel());
      var3.setBlvDiversTiers(var1.getBlvDiversTiers());
      var3.setBlvDiversVille(var1.getBlvDiversVille());
      var3.setBlvExoTva(var1.getBlvExoTva());
      var3.setBlvExoDouane(var1.getBlvExoDouane());
      var3.setBlvJournalReg(var1.getBlvJournalReg());
      var3.setBlvCat(var1.getBlvCat());
      var3.setBlvDevise(var1.getBlvDevise());
      var3.setBlvObject(var1.getBlvObject());
      var3.setBlvObservation(var1.getBlvObservation());
      var3.setBlvTauxRemise(var1.getBlvTauxRemise());
      var3.setBlvTotHt(var1.getBlvTotHt());
      var3.setBlvTotRemise(var1.getBlvTotRemise());
      var3.setBlvTotRabais(var1.getBlvTotRabais());
      var3.setBlvTotTva(var1.getBlvTotTva());
      var3.setBlvTotTc(var1.getBlvTotTc());
      var3.setBlvTotTtc(var1.getBlvTotTtc());
      var3.setBlvTotReglement(var1.getBlvTotReglement());
      var3.setBlvSolde(var1.getBlvSolde());
      var3.setBlvStock(var1.getBlvStock());
      var3.setBlvBanque(var1.getBlvBanque());
      var3.setBlvTypeReg(var1.getBlvTypeReg());
      var3.setBlvModeReg(var1.getBlvModeReg());
      var3.setBlvNbJourReg(var1.getBlvNbJourReg());
      var3.setBlvArrondiReg(var1.getBlvArrondiReg());
      var3.setBlvConditionReg(var1.getBlvConditionReg());
      var3.setBlvDateEcheReg(var1.getBlvDateEcheReg());
      var3.setBlvContener(var1.getBlvContener());
      var3.setBlvActivite(var1.getBlvActivite());
      var3.setBlvSite(var1.getBlvSite());
      var3.setBlvDepartement(var1.getBlvDepartement());
      var3.setBlvRegion(var1.getBlvRegion());
      var3.setBlvSecteur(var1.getBlvSecteur());
      var3.setBlvPdv(var1.getBlvPdv());
      var3.setBlvAnal2(var1.getBlvAnal2());
      var3.setBlvAnal4(var1.getBlvAnal4());
      var3.setBlvAffaire(var1.getBlvAffaire());
      var3.setBlvInfo1(var1.getBlvInfo1());
      var3.setBlvInfo2(var1.getBlvInfo2());
      var3.setBlvInfo3(var1.getBlvInfo3());
      var3.setBlvInfo4(var1.getBlvInfo4());
      var3.setBlvInfo5(var1.getBlvInfo5());
      var3.setBlvInfo6(var1.getBlvInfo6());
      var3.setBlvInfo7(var1.getBlvInfo7());
      var3.setBlvInfo8(var1.getBlvInfo8());
      var3.setBlvInfo9(var1.getBlvInfo9());
      var3.setBlvInfo10(var1.getBlvInfo10());
      var3.setBlvFormule1(var1.getBlvFormule1());
      var3.setBlvFormule2(var1.getBlvFormule2());
      var3.setBlvAnnexe1(var1.getBlvAnnexe1());
      var3.setBlvAnnexe2(var1.getBlvAnnexe2());
      var3.setBlvContrat(var1.getBlvContrat());
      var3.setBlvIncoterm(var1.getBlvIncoterm());
      var3.setBlvLieuLivraison(var1.getBlvLieuLivraison());
      var3.setBlvDateLivraison(var1.getBlvDateLivraison());
      var3.setBlvInfoLivraison(var1.getBlvInfoLivraison());
      var3.setBlvDateImp(var1.getBlvDateImp());
      var3.setBlvModeleImp(var1.getBlvModeleImp());
      var3.setBlvGarde(var1.getBlvGarde());
      var3.setBlvGele(var1.getBlvGele());
      var3.setBlvEtatVal(var1.getBlvEtatVal());
      var3.setBlvEtat(var1.getBlvEtat());
      var3.setBlvDateValide(var1.getBlvDateValide());
      var3.setBlvDateTransforme(var1.getBlvDateTransforme());
      var3.setBlvTypeTransforme(var1.getBlvTypeTransforme());
      var3.setBlvDateAnnule(var1.getBlvDateAnnule());
      var3.setBlvMotifAnnule(var1.getBlvMotifAnnule());
      var3.setBlvFactorNom(var1.getBlvFactorNom());
      var3.setBlvFactorId(var1.getBlvFactorId());
      var3.setBlvFactorEtat(var1.getBlvFactorEtat());
      var3.setBlvRistourneBloquee(false);
      var3.setExerciceventes(var1.getExerciceventes());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from LivraisonEnteteVentes order by blvId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            LivraisonEnteteVentes var7 = (LivraisonEnteteVentes)var6.get(0);
            var4 = 1L + var7.getBlvId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public LivraisonEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from LivraisonEnteteVentes where exerciceventes.exevteId=:id and blvSerie =:ser and year(blvDate)=" + var7 + " order by blvDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      LivraisonEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (LivraisonEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public LivraisonEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from LivraisonEnteteVentes where exerciceventes.exevteId=:id and blvSerie =:ser and year(blvDate)=" + var7 + " and month(blvDate)=" + var8 + " order by blvDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      LivraisonEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (LivraisonEnteteVentes)var11.get(0);
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
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var30 = true;
      }

      UtilDate var31 = new UtilDate();
      new ArrayList();
      Criteria var33 = var1.createCriteria(LivraisonEnteteVentes.class);
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
            var33 = var33.add(Restrictions.between("blvDate", var35, var36));
         } else {
            var41 = "1980-01-01";
            var31.stringToDateSQL(var41 + " 00:00:00");
            var33 = var33.add(Restrictions.isNotNull("blvDate"));
         }
      } else {
         if (!var13.equalsIgnoreCase("12") && !var13.equalsIgnoreCase("13") && !var13.equalsIgnoreCase("14")) {
            var33 = var33.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var13.equalsIgnoreCase("0")) {
            var33 = var33.add(Restrictions.between("blvDate", var35, var36));
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
            var33 = var33.add(Restrictions.between("blvDate", var35, var36));
         } else {
            int var45;
            if (var13.equalsIgnoreCase("2")) {
               var45 = var34.get(2) + 1;
               var42 = var40 + "-" + var45 + "-01";
               var35 = var31.stringToDateSQL(var42 + " 00:00:00");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
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

               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
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

               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("5")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-03-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("6")) {
               var41 = var40 + "-04-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-06-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("7")) {
               var41 = var40 + "-07-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-09-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("8")) {
               var41 = var40 + "-10-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("9")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-06-30";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("10")) {
               var41 = var40 + "-07-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("11")) {
               var41 = var40 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("12")) {
               var41 = "1980-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 - 1 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("13")) {
               var41 = var40 - 1 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("14")) {
               var41 = var40 - 1 + "-01-01";
               var35 = var31.stringToDateSQL(var41 + " 00:00:00");
               var42 = var40 - 1 + "-12-31";
               var36 = var31.stringToDateSQL(var42 + " 23:59:59");
               var33 = var33.add(Restrictions.between("blvDate", var35, var36));
            } else if (var13.equalsIgnoreCase("20")) {
               var33.setMaxResults(20);
               var33 = var33.addOrder(Order.desc("blvId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var41 = "%" + var4 + "%";
         var33 = var33.add(Restrictions.like("blvNum", var41));
      }

      if (var5 != null && !var5.isEmpty()) {
         var41 = "%" + var5 + "%";
         var33 = var33.add(Restrictions.like("blvNumClient", var41));
      }

      if (var6 != null && !var6.isEmpty()) {
         var41 = "%" + var6 + "%";
         var33 = var33.add(Restrictions.like("blvAnal4", var41));
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

         var33 = var33.add(Restrictions.or(Restrictions.like("blvNomTiers", var41), Restrictions.like("blvDiversNom", var41)));
      }

      if (var17 != null && !var17.isEmpty()) {
         var33 = var33.add(Restrictions.eq("blvNomContact", var17));
      }

      if (var18 != null && !var18.isEmpty()) {
         var33 = var33.add(Restrictions.eq("blvNomResponsable", var18));
      }

      if (var19 != null && !var19.isEmpty()) {
         var33 = var33.add(Restrictions.eq("blvNomCommercial", var19));
      }

      if (var16 == 1 || var16 == 2) {
         var33 = var33.add(Restrictions.eq("blvIdCreateur", var14));
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

            var33 = var33.add(Restrictions.in("blvSerie", var43));
         } else {
            var33 = var33.add(Restrictions.eq("blvSerie", var11));
         }
      }

      if (!var12.equalsIgnoreCase("100")) {
         var33 = var33.add(Restrictions.eq("blvCat", var12));
      }

      if (var10 <= 10) {
         var33 = var33.add(Restrictions.eq("blvEtat", var10));
      } else if (var10 == 13) {
         var33 = var33.add(Restrictions.eq("blvSolde", 0));
      } else if (var10 == 14) {
         var33 = var33.add(Restrictions.eq("blvSolde", 1));
      } else if (var10 == 15) {
         var33 = var33.add(Restrictions.eq("blvExoTva", 1));
      } else if (var10 == 16) {
         var33 = var33.add(Restrictions.ne("blvTotReglement", 0.0D)).add(Restrictions.eq("blvSolde", 0));
      } else if (var10 == 30) {
         var33 = var33.add(Restrictions.eq("blvLivreeEtat", 0));
      } else if (var10 == 31) {
         var33 = var33.add(Restrictions.eq("blvLivreeEtat", 1));
      } else if (var10 == 32) {
         var33 = var33.add(Restrictions.eq("blvLivreeEtat", 2));
      } else if (var10 == 33) {
         var33 = var33.add(Restrictions.eq("blvEtat", 1));
      }

      if (!var20.equalsIgnoreCase("100")) {
         var47 = var20.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("blvActivite", var42));
      }

      if (var24 != null && !var24.isEmpty() && var24.contains(":")) {
         var47 = var24.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("blvRegion", var42));
      }

      if (var25 != null && !var25.isEmpty() && var25.contains(":")) {
         var47 = var25.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("blvSecteur", var42));
      }

      if (var26 != null && !var26.isEmpty() && var26.contains(":")) {
         var47 = var26.split(":");
         var42 = var47[0];
         var33 = var33.add(Restrictions.eq("blvPdv", var42));
      }

      if (var27 != null && !var27.isEmpty()) {
         var33 = var33.add(Restrictions.eq("blvSite", var27));
      }

      if (var28 != null && !var28.isEmpty()) {
         var33 = var33.add(Restrictions.eq("blvDepartement", var28));
      }

      if (var29 != null && !var29.isEmpty()) {
         var33 = var33.add(Restrictions.eq("blvService", var29));
      }

      if (var21 != null && !var21.isEmpty()) {
         var41 = "%" + var21 + "%";
         var33 = var33.add(Restrictions.like("blvContener", var41));
      }

      var33 = var33.addOrder(Order.desc("blvDate"));
      var33 = var33.addOrder(Order.desc("blvNum"));
      List var48 = var33.list();
      if (var30) {
         this.utilInitHibernate.closeSession();
      }

      return var48;
   }

   public List rechercheLivraisonByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from LivraisonEnteteVentes where blvDate>=:deb and blvDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public LivraisonEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var4 = true;
      }

      LivraisonEnteteVentes var5 = null;
      Query var6 = var3.createQuery("from LivraisonEnteteVentes where blvId =:num").setLong("num", var1).setMaxResults(1);
      List var7 = var6.list();
      if (var7.size() != 0) {
         var5 = (LivraisonEnteteVentes)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public LivraisonEnteteVentes pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var4 = true;
      }

      LivraisonEnteteVentes var5 = null;
      Query var6 = null;
      if (var2 != null && !var2.isEmpty()) {
         var6 = var3.createQuery("from LivraisonEnteteVentes where blvNum=:num and blvSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var6 = var3.createQuery("from LivraisonEnteteVentes where blvNum=:num").setString("num", var1).setMaxResults(1);
      }

      List var7 = var6.list();
      if (var7.size() != 0) {
         var5 = (LivraisonEnteteVentes)var7.get(0);
      } else {
         var5 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public LivraisonEnteteVentes pourParapheurByNum(String var1, String var2, Session var3) {
      Query var4 = null;
      if (var2 != null && !var2.isEmpty()) {
         var4 = var3.createQuery("from LivraisonEnteteVentes where blvNum=:numero and bcvSerie=:ser").setString("numero", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var4 = var3.createQuery("from LivraisonEnteteVentes where blvNum=:numero").setString("numero", var1).setMaxResults(1);
      }

      List var5 = var4.list();
      new LivraisonEnteteVentes();
      LivraisonEnteteVentes var6;
      if (var5.size() != 0) {
         var6 = (LivraisonEnteteVentes)var5.get(0);
      } else {
         var6 = null;
      }

      return var6;
   }

   public LivraisonEnteteVentes rechercheLivraisonByNumClient(String var1, Tiers var2, long var3, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var6 = true;
      }

      Query var7 = var5.createQuery("from LivraisonEnteteVentes where blvNumClient=:numero and tiers=:tie and blvId<>" + var3).setParameter("tie", var2).setString("numero", var1).setMaxResults(1);
      List var8 = var7.list();
      new LivraisonEnteteVentes();
      LivraisonEnteteVentes var9;
      if (var8.size() != 0) {
         var9 = (LivraisonEnteteVentes)var8.get(0);
      } else {
         var9 = null;
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
      Query var4 = var3.createQuery("from LivraisonEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from LivraisonEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from LivraisonEnteteVentes where tiers=:tie and blvSolde=0 and blvEtat>=1 and blvSerie=:ser").setParameter("tie", var1).setString("ser", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheLivraisonRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from LivraisonEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from LivraisonEnteteVentes where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheNonPayeesByTiers(Tiers var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from LivraisonEnteteVentes where tiers=:tie and blvSolde=0 and blvSerie in (" + var2 + ") order by blvDate").setParameter("tie", var1).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from LivraisonEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheLivraisonCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var6 = true;
      }

      List var7 = var4.createQuery("from LivraisonEnteteVentes where blvDate>=:d1 and blvSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheLivraisonATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from LivraisonEnteteVentes where (blvEtat=0 or blvEtat=1 or blvEtat=4 or blvEtat=5) and blvDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from LivraisonEnteteVentes where (blvEtat=0 or blvEtat=1 or blvEtat=4 or blvEtat=5) and blvDateTransfert is NULL and blvDate>=:dte1 and blvDate<=:dte2 and blvNum>=:p1 and blvNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from LivraisonEnteteVentes where (blvEtat=0 or blvEtat=1 or blvEtat=4 or blvEtat=5) and blvDateTransfert is NULL and blvDate>=:dte1 and blvDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from LivraisonEnteteVentes where (blvEtat=1 or blvEtat=4 or blvEtat=5) and blvDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from LivraisonEnteteVentes where (blvEtat=1 or blvEtat=4 or blvEtat=5) and blvDateTransfert is NULL and blvDate>=:dte1 and blvDate<=:dte2 and blvNum>=:p1 and blvNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from LivraisonEnteteVentes where (blvEtat=1 or blvEtat=4 or blvEtat=5) and blvDateTransfert is NULL and blvDate>=:dte1 and blvDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheLivraisonDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BlivraisonEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from LivraisonEnteteVentes where (blvEtat=0 or blvEtat=1 or blvEtat=4 or blvEtat=5) and (blvDateTransfert<>'' and blvDateTransfert is not null) and (blvDate>=:dte1 and blvDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }
}
