package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FactureEnteteVentes;
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

public class FactureEnteteVentesDao implements Serializable {
   private FactureEnteteVentes factureEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FactureEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FactureEnteteVentes insert(FactureEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FactureEnteteVentes modif(FactureEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
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

   public FactureEnteteVentes modif(FactureEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public void delete(FactureEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
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

   public void delete(FactureEnteteVentes var1, Session var2) {
      var2.delete(var1);
   }

   public FactureEnteteVentes duppliquer(FactureEnteteVentes var1, FactureEnteteVentes var2, Session var3) {
      FactureEnteteVentes var4 = new FactureEnteteVentes();
      var4.setFacSerie(var1.getFacSerie());
      var4.setFacIdCreateur(var1.getFacIdCreateur());
      var4.setFacNomCreateur(var1.getFacNomCreateur());
      var4.setFacDate(var1.getFacDate());
      var4.setFacDateCreat(var1.getFacDateCreat());
      var4.setFacDateModif((Date)null);
      var4.setFacIdModif(0L);
      var4.setFacNomModif("");
      var4.setFacNum(var1.getFacNum());
      var4.setFacNumBl("");
      var4.setFacDateRelance(var1.getFacDateRelance());
      var4.setFacDateValidite(var1.getFacDateValidite());
      var4.setFacService(var2.getFacService());
      var4.setFacSource(var2.getFacSource());
      var4.setFacNomResponsable(var2.getFacNomResponsable());
      var4.setFacIdResponsable(var2.getFacIdResponsable());
      var4.setFacNomCommercial(var2.getFacNomCommercial());
      var4.setFacIdCommercial(var2.getFacIdCommercial());
      var4.setFacNomTiers(var2.getFacNomTiers());
      var4.setFacCivilTiers(var2.getFacCivilTiers());
      var4.setFacTiersRegroupe(var2.getFacTiersRegroupe());
      var4.setFacIdContact(var2.getFacIdContact());
      var4.setFacNomContact(var2.getFacNomContact());
      var4.setFacCivilContact(var2.getFacCivilContact());
      var4.setFacDiversAdresse(var2.getFacDiversAdresse());
      var4.setFacDiversMail(var2.getFacDiversMail());
      var4.setFacDiversNom(var2.getFacDiversNom());
      var4.setFacDiversTel(var2.getFacDiversTel());
      var4.setFacDiversTiers(var2.getFacDiversTiers());
      var4.setFacDiversVille(var2.getFacDiversVille());
      var4.setFacExoTva(var2.getFacExoTva());
      var4.setFacExoDouane(var2.getFacExoDouane());
      var4.setFacJournalReg(var2.getFacJournalReg());
      var4.setFacCat(var2.getFacCat());
      var4.setFacDevise(var2.getFacDevise());
      var4.setFacObject(var2.getFacObject());
      var4.setFacObservation(var2.getFacObservation());
      var4.setFacTauxRemise(var2.getFacTauxRemise());
      var4.setFacTotHt(var2.getFacTotHt());
      var4.setFacTotRemise(var2.getFacTotRemise());
      var4.setFacTotRabais(var2.getFacTotRabais());
      var4.setFacTotTva(var2.getFacTotTva());
      var4.setFacTotTc(var2.getFacTotTc());
      var4.setFacTotTtc(var2.getFacTotTtc());
      var4.setFacTotReglement(0.0D);
      var4.setFacSolde(0);
      var4.setFacBanque(var2.getFacBanque());
      var4.setFacTypeReg(var2.getFacTypeReg());
      var4.setFacModeReg(var2.getFacModeReg());
      var4.setFacNbJourReg(var2.getFacNbJourReg());
      var4.setFacArrondiReg(var2.getFacArrondiReg());
      var4.setFacConditionReg(var2.getFacConditionReg());
      var4.setFacDateEcheReg(var2.getFacDateEcheReg());
      var4.setFacContener("");
      var4.setFacActivite(var2.getFacActivite());
      var4.setFacSite(var2.getFacSite());
      var4.setFacDepartement(var2.getFacDepartement());
      var4.setFacRegion(var2.getFacRegion());
      var4.setFacSecteur(var2.getFacSecteur());
      var4.setFacPdv(var2.getFacPdv());
      var4.setFacAnal2(var2.getFacAnal2());
      var4.setFacAnal4(var2.getFacAnal4());
      var4.setFacAffaire(var2.getFacAffaire());
      var4.setFacInfo1(var2.getFacInfo1());
      var4.setFacInfo2(var2.getFacInfo2());
      var4.setFacInfo3(var2.getFacInfo3());
      var4.setFacInfo4(var2.getFacInfo4());
      var4.setFacInfo5(var2.getFacInfo5());
      var4.setFacInfo6(var2.getFacInfo6());
      var4.setFacInfo7(var2.getFacInfo7());
      var4.setFacInfo8(var2.getFacInfo8());
      var4.setFacInfo9(var2.getFacInfo9());
      var4.setFacInfo10(var2.getFacInfo10());
      var4.setFacFormule1(var2.getFacFormule1());
      var4.setFacFormule2(var2.getFacFormule2());
      var4.setFacAnnexe1(var2.getFacAnnexe1());
      var4.setFacAnnexe2(var2.getFacAnnexe2());
      var4.setFacContrat(var2.getFacContrat());
      var4.setFacIncoterm(var2.getFacIncoterm());
      var4.setFacLieuLivraison(var2.getFacLieuLivraison());
      var4.setFacDateLivraison(var2.getFacDateLivraison());
      var4.setFacInfoLivraison(var2.getFacInfoLivraison());
      var4.setFacDateImp((Date)null);
      var4.setFacModeleImp(var2.getFacModeleImp());
      var4.setFacGarde(var2.getFacGarde());
      var4.setFacGele(0);
      var4.setFacEtat(0);
      var4.setFacDateTransforme((Date)null);
      var4.setFacTypeTransforme(0);
      var4.setFacDateAnnule((Date)null);
      var4.setFacMotifAnnule("");
      var4.setFacFactorNom(var2.getFacFactorNom());
      var4.setFacFactorId(var2.getFacFactorId());
      var4.setFacFactorEtat(var2.getFacFactorEtat());
      var4.setFacTauxAcompte(var1.getFacTauxAcompte());
      var4.setFacNumAcompte(var1.getFacNumAcompte());
      var4.setExerciceventes(var2.getExerciceventes());
      var4.setTiers(var2.getTiers());
      var4.setUsers(var2.getUsers());
      var3.save(var4);
      return var4;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from FactureEnteteVentes order by facId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            FactureEnteteVentes var7 = (FactureEnteteVentes)var6.get(0);
            var4 = 1L + var7.getFacId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public FactureEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from FactureEnteteVentes where exerciceventes.exevteId=:id and facSerie =:ser and year(facDate)=" + var7 + " order by facDate desc").setParameter("id", var1).setParameter("ser", var3);
      FactureEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (FactureEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public FactureEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from FactureEnteteVentes where exerciceventes.exevteId=:id and facSerie =:ser and year(facDate)=" + var7 + " and month(facDate)=" + var8 + " order by facDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      FactureEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (FactureEnteteVentes)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, int var2, long var3, String var5, String var6, String var7, long var8, String var10, int var11, String var12, String var13, String var14, long var15, int var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26, String var27, String var28, String var29, String var30) throws HibernateException, NamingException, ParseException {
      boolean var31 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var31 = true;
      }

      UtilDate var32 = new UtilDate();
      new ArrayList();
      Criteria var34 = var1.createCriteria(FactureEnteteVentes.class);
      var34 = var34.createAlias("tiers", "tiers", 1);
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
      if (var14.equalsIgnoreCase("100")) {
         if (var23 != null && var24 != null) {
            var36 = var32.stringToDateSQL(var23 + " 00:00:00");
            var37 = var32.stringToDateSQL(var24 + " 23:59:59");
            var34 = var34.add(Restrictions.between("facDate", var36, var37));
         } else {
            var42 = "1980-01-01";
            var32.stringToDateSQL(var42 + " 00:00:00");
            var34 = var34.add(Restrictions.isNotNull("facDate"));
         }
      } else {
         if (!var14.equalsIgnoreCase("12") && !var14.equalsIgnoreCase("13") && !var14.equalsIgnoreCase("14")) {
            var34 = var34.add(Restrictions.eq("exerciceventes.exevteId", var3));
         }

         if (var14.equalsIgnoreCase("0")) {
            var34 = var34.add(Restrictions.between("facDate", var36, var37));
         } else if (var14.equalsIgnoreCase("1")) {
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
            var34 = var34.add(Restrictions.between("facDate", var36, var37));
         } else {
            int var46;
            if (var14.equalsIgnoreCase("2")) {
               var46 = var35.get(2) + 1;
               var43 = var41 + "-" + var46 + "-01";
               var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("3")) {
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

               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("4")) {
               var46 = var35.get(2);
               var35.add(5, -var46);
               if (var46 <= 6) {
                  var43 = var41 + "-01-01";
                  var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               } else {
                  var43 = var41 + "-07-01";
                  var36 = var32.stringToDateSQL(var43 + " 00:00:00");
               }

               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("5")) {
               var42 = var41 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-03-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("6")) {
               var42 = var41 + "-04-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-06-30";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("7")) {
               var42 = var41 + "-07-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-09-30";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("8")) {
               var42 = var41 + "-10-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("9")) {
               var42 = var41 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-06-30";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("10")) {
               var42 = var41 + "-07-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("11")) {
               var42 = var41 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("12")) {
               var42 = "1980-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 - 1 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("13")) {
               var42 = var41 - 1 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("14")) {
               var42 = var41 - 1 + "-01-01";
               var36 = var32.stringToDateSQL(var42 + " 00:00:00");
               var43 = var41 - 1 + "-12-31";
               var37 = var32.stringToDateSQL(var43 + " 23:59:59");
               var34 = var34.add(Restrictions.between("facDate", var36, var37));
            } else if (var14.equalsIgnoreCase("20")) {
               var34.setMaxResults(20);
               var34 = var34.addOrder(Order.desc("facId"));
            }
         }
      }

      if (var5 != null && !var5.isEmpty()) {
         var42 = "%" + var5 + "%";
         var34 = var34.add(Restrictions.like("facNum", var42));
      }

      if (var6 != null && !var6.isEmpty()) {
         var42 = "%" + var6 + "%";
         var34 = var34.add(Restrictions.like("facNumClient", var42));
      }

      if (var7 != null && !var7.isEmpty()) {
         var42 = "%" + var7 + "%";
         var34 = var34.add(Restrictions.like("facAnal4", var42));
      }

      String[] var49;
      if (var8 != 0L) {
         var34 = var34.add(Restrictions.eq("tiers.tieid", var8));
      } else {
         if (var10 != null && !var10.isEmpty() && !var10.contains(":")) {
            var42 = "";
            if (var10.startsWith("*")) {
               var42 = "%" + var10.substring(1) + "%";
            } else {
               var42 = var10 + "%";
            }

            if (var2 == 1) {
               var34 = var34.add(Restrictions.or(Restrictions.like("facNomTiers", var42), Restrictions.like("tiers.tiesigle", var42)));
            } else {
               var34 = var34.add(Restrictions.or(Restrictions.like("facNomTiers", var42), Restrictions.like("facDiversNom", var42)));
            }
         }

         if (var10 != null && !var10.isEmpty() && var10.contains(":")) {
            var49 = var10.split(":");
            long var47 = Long.parseLong(var49[0]);
            var34 = var34.add(Restrictions.eq("tiers.tieid", var47));
         }
      }

      if (var18 != null && !var18.isEmpty()) {
         var34 = var34.add(Restrictions.eq("facNomContact", var18));
      }

      if (var19 != null && !var19.isEmpty()) {
         var34 = var34.add(Restrictions.eq("facNomResponsable", var19));
      }

      if (var20 != null && !var20.isEmpty()) {
         var34 = var34.add(Restrictions.eq("facNomCommercial", var20));
      }

      if (var17 == 1 || var17 == 2) {
         var34 = var34.add(Restrictions.eq("facIdCreateur", var15));
      }

      if (!var12.equalsIgnoreCase("100")) {
         if (var12.contains(",")) {
            var49 = var12.split(",");
            int var48 = var49.length;
            String[] var44 = new String[var48];

            for(int var45 = 0; var45 < var48; ++var45) {
               var44[var45] = new String(var49[var45]);
            }

            var34 = var34.add(Restrictions.in("facSerie", var44));
         } else {
            var34 = var34.add(Restrictions.eq("facSerie", var12));
         }
      }

      if (!var13.equalsIgnoreCase("100")) {
         var34 = var34.add(Restrictions.eq("facCat", var13));
      }

      if (var11 <= 10) {
         var34 = var34.add(Restrictions.eq("facEtat", var11));
      } else if (var11 == 11) {
         var34 = var34.add(Restrictions.isNotNull("facDateRelance"));
      } else if (var11 == 12) {
         var34 = var34.add(Restrictions.eq("facTotHt", 0.0D));
      } else if (var11 == 13) {
         var34 = var34.add(Restrictions.and(Restrictions.eq("facSolde", 0), Restrictions.ne("facEtat", 3)));
      } else if (var11 == 14) {
         var34 = var34.add(Restrictions.eq("facSolde", 1));
      } else if (var11 == 15) {
         var34 = var34.add(Restrictions.eq("facExoTva", 1));
      } else if (var11 == 16) {
         var34 = var34.add(Restrictions.and(Restrictions.eq("facExoTva", 1), Restrictions.isNull("facDateVisa")));
      } else if (var11 == 17) {
         var34 = var34.add(Restrictions.isNotNull("facDateTransfert"));
      } else if (var11 == 18) {
         var34 = var34.add(Restrictions.isNull("facDateTransfert"));
      } else if (var11 == 20) {
         var34 = var34.add(Restrictions.ne("facNbAcompte", 0));
      }

      if (!var21.equalsIgnoreCase("100")) {
         var49 = var21.split(":");
         var43 = var49[0];
         var34 = var34.add(Restrictions.eq("facActivite", var43));
      }

      if (var25 != null && !var25.isEmpty() && var25.contains(":")) {
         var49 = var25.split(":");
         var43 = var49[0];
         var34 = var34.add(Restrictions.eq("facRegion", var43));
      }

      if (var26 != null && !var26.isEmpty() && var26.contains(":")) {
         var49 = var26.split(":");
         var43 = var49[0];
         var34 = var34.add(Restrictions.eq("facSecteur", var43));
      }

      if (var27 != null && !var27.isEmpty() && var27.contains(":")) {
         var49 = var27.split(":");
         var43 = var49[0];
         var34 = var34.add(Restrictions.eq("facPdv", var43));
      }

      if (var28 != null && !var28.isEmpty()) {
         var34 = var34.add(Restrictions.eq("facSite", var28));
      }

      if (var29 != null && !var29.isEmpty()) {
         var34 = var34.add(Restrictions.eq("facDepartement", var29));
      }

      if (var30 != null && !var30.isEmpty()) {
         var34 = var34.add(Restrictions.eq("facService", var30));
      }

      if (var22 != null && !var22.isEmpty()) {
         var42 = "%" + var22 + "%";
         var34 = var34.add(Restrictions.like("facContener", var42));
      }

      var34 = var34.addOrder(Order.desc("facDate"));
      var34 = var34.addOrder(Order.desc("facNum"));
      List var50 = var34.list();
      if (var31) {
         this.utilInitHibernate.closeSession();
      }

      return var50;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from FactureEnteteVentes where facService='" + var1 + "' and (facDateEcheReg='" + var5 + "' or facTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from FactureEnteteVentes where facDateEcheReg='" + var5 + "' or facTypeReg=4").list();
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
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureEnteteVentes where facTotReglement<>0 and facDate>=:d1 and facDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureByDate(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from FactureEnteteVentes where facDate>=:deb and facDate<=:fin").setString("deb", var1).setString("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureByDate(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var5 = true;
      }

      new ArrayList();
      List var7 = null;
      var7 = var4.createQuery("from FactureEnteteVentes where (facAnal2 is not null and facAnal2<>'' and facAnal2 like '" + var1 + "%') and facDate>=:deb and facDate<=:fin").setString("deb", var2).setString("fin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FactureEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FactureEnteteVentes where facId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new FactureEnteteVentes();
      FactureEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (FactureEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FactureEnteteVentes pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from FactureEnteteVentes where facNum=:num and facSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var5 = var3.createQuery("from FactureEnteteVentes where facNum=:num").setString("num", var1).setMaxResults(1);
      }

      List var6 = var5.list();
      new FactureEnteteVentes();
      FactureEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (FactureEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public FactureEnteteVentes pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureEnteteVentes where facNum=:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new FactureEnteteVentes();
      FactureEnteteVentes var6;
      if (var5.size() != 0) {
         var6 = (FactureEnteteVentes)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public FactureEnteteVentes pourContrat(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureEnteteVentes where facContrat=:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new FactureEnteteVentes();
      FactureEnteteVentes var6;
      if (var5.size() != 0) {
         var6 = (FactureEnteteVentes)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureATransfererCompta(String var1, String var2, String var3, String var4, String var5, boolean var6, Session var7) throws HibernateException, NamingException {
      boolean var8 = false;
      if (var7 == null) {
         var7 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var8 = true;
      }

      new ArrayList();
      List var10 = null;
      if (var1 != null && !var1.isEmpty() && var1.equals("1")) {
         if (var6) {
            var10 = var7.createQuery("from FactureEnteteVentes where (facEtat=0 or facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL").list();
         } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
            var10 = var7.createQuery("from FactureEnteteVentes where (facEtat=0 or facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL and facDate>=:dte1 and facDate<=:dte2 and facNum>=:p1 and facNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
         } else {
            var10 = var7.createQuery("from FactureEnteteVentes where (facEtat=0 or facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL and facDate>=:dte1 and facDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
         }
      } else if (var6) {
         var10 = var7.createQuery("from FactureEnteteVentes where (facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL").list();
      } else if (var2 != null && !var2.isEmpty() && var3 != null && !var3.isEmpty()) {
         var10 = var7.createQuery("from FactureEnteteVentes where (facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL and facDate>=:dte1 and facDate<=:dte2 and facNum>=:p1 and facNum<=:p2").setString("dte1", var4).setString("dte2", var5).setString("p1", var2).setString("p2", var3).list();
      } else {
         var10 = var7.createQuery("from FactureEnteteVentes where (facEtat=1 or facEtat=4 or facEtat=5) and facDateTransfert is NULL and facDate>=:dte1 and facDate<=:dte2").setString("dte1", var4).setString("dte2", var5).list();
      }

      if (var8) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List rechercheFactureDejaTransfererCompta(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = var3.createQuery("from FactureEnteteVentes where (facEtat=0 or facEtat=1 or facEtat=4 or facEtat=5) and (facDateTransfert<>'' and facDateTransfert is not null) and (facDate>=:dte1 and facDate<=:dte2)").setString("dte1", var1).setString("dte2", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from FactureEnteteVentes where " + var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
      Query var4 = var3.createQuery("from FactureEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FactureEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public boolean verifExistNum(long var1, String var3) throws HibernateException, NamingException {
      Session var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
      Query var5 = var4.createQuery("from FactureEnteteVentes where facId<>" + var1 + " and facNum='" + var3 + "'").setMaxResults(1);
      List var6 = var5.list();
      boolean var7 = false;
      if (var6.size() != 0) {
         var7 = true;
      }

      this.utilInitHibernate.closeSession();
      return var7;
   }

   public List rechercheNonSoldeTiers(Tiers var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureEnteteVentes where tiers=:tie and facSolde=0 and facEtat>=1 and facSerie=:ser").setParameter("tie", var1).setString("ser", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureEnteteVentes where tiers=:tie order by facDate").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheNonPayeesByTiers(Tiers var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureEnteteVentes where tiers=:tie and facSolde=0 and facSerie in (" + var2 + ") order by facDate desc").setParameter("tie", var1).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheNonPayeesByTiers(Tiers var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var6 = true;
      }

      List var7 = var4.createQuery("from FactureEnteteVentes where tiers=:tie and facSolde=0 and facSerie in (" + var2 + ") and facDate<='" + var3 + "' order by facDate desc").setParameter("tie", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCommissions(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureEnteteVentes where facSolde=1 and facDate>=:d1 and facDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFacturePeriode(String var1, String var2, Session var3) throws HibernateException, NamingException {
      new ArrayList();
      boolean var5 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var5 = true;
      }

      List var6 = var3.createQuery("from FactureEnteteVentes where facDate>=:d1 and facDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheFactureAbonnement(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var6 = true;
      }

      List var7 = null;
      if (var3 != null && !var3.isEmpty()) {
         String var8 = "";
         if (var3.contains(":")) {
            String[] var9 = var3.split(":");
            var8 = var9[0];
         } else {
            var8 = var3;
         }

         var7 = var4.createQuery("from FactureEnteteVentes where facDate>=:d1 and facDate<=:d2 and facRegion=:reg").setString("d1", var1).setString("d2", var2).setString("reg", var8).list();
      } else {
         var7 = var4.createQuery("from FactureEnteteVentes where facDate>=:d1 and facDate<=:d2").setString("d1", var1).setString("d2", var2).list();
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheFactureCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var6 = true;
      }

      List var7 = var4.createQuery("from FactureEnteteVentes where facDate>=:d1 and facSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheFactureAcompte(Tiers var1, String var2, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      boolean var7 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var7 = true;
      }

      List var8 = var5.createQuery("from FactureEnteteVentes where tiers=:tie and facNumAcompte=:ctt and facTauxAcompte>0 and (facDate<=:dte or facNum=:fac)").setParameter("tie", var1).setString("fac", var2).setString("ctt", var3).setDate("dte", var4).list();
      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheFactureContrat(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from FactureEnteteVentes where facContrat=:crt").setString("crt", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByAffaire(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from FactureEnteteVentes where facAffaire =:dos and facAnal4 =:anal").setString("dos", var1).setString("anal", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public FactureEnteteVentes pourParapheurAutomatique(long var1, String var3, String var4, String var5, Session var6) throws HibernateException, NamingException {
      boolean var7 = false;
      if (var6 == null) {
         var6 = this.utilInitHibernate.getOpenSession(this.mabase, "BfactureEntete");
         var7 = true;
      }

      Query var8 = var6.createQuery("from FactureEnteteVentes where tiers=:tie and facContrat=:crt and facDate>=:deb and facDate<=:fin").setLong("tie", var1).setString("crt", var3).setString("deb", var4).setString("fin", var5).setMaxResults(1);
      List var9 = var8.list();
      new FactureEnteteVentes();
      FactureEnteteVentes var10;
      if (var9.size() != 0) {
         var10 = (FactureEnteteVentes)var9.get(0);
      } else {
         var10 = null;
      }

      if (var7) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }
}
