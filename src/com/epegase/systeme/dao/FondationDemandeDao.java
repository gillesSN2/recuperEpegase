package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.FondationDemande;
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

public class FondationDemandeDao implements Serializable {
   private FondationDemande fondationDemande;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public FondationDemandeDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public FondationDemande insert(FondationDemande var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public FondationDemande modif(FondationDemande var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
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

   public FondationDemande modif(FondationDemande var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from FondationDemande where fondemId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public FondationDemande duppliquer(FondationDemande var1, Session var2) {
      FondationDemande var3 = new FondationDemande();
      var3.setFondemActivite(var1.getFondemActivite());
      var3.setFondemAnal2(var1.getFondemAnal2());
      var3.setFondemAnal4(var1.getFondemAnal4());
      var3.setFondemAnnexe1(var1.getFondemAnnexe1());
      var3.setFondemAnnexe2(var1.getFondemAnnexe2());
      var3.setFondemArrondiReg(var1.getFondemArrondiReg());
      var3.setFondemBanque(var1.getFondemBanque());
      var3.setFondemCat(var1.getFondemCat());
      var3.setFondemCivilContact(var1.getFondemCivilContact());
      var3.setFondemCivilTiers(var1.getFondemCivilTiers());
      var3.setFondemConditionReg(var1.getFondemConditionReg());
      var3.setFondemContrat(var1.getFondemContrat());
      var3.setFondemDate(var1.getFondemDate());
      var3.setFondemDateAnnule(var1.getFondemDateAnnule());
      var3.setFondemDateCreat(var1.getFondemDateCreat());
      var3.setFondemDateEcheReg(var1.getFondemDateEcheReg());
      var3.setFondemDateImp(var1.getFondemDateImp());
      var3.setFondemDateModif(var1.getFondemDateModif());
      var3.setFondemDateRelance(var1.getFondemDateRelance());
      var3.setFondemDateTransforme(var1.getFondemDateTransforme());
      var3.setFondemDateValide(var1.getFondemDateValide());
      var3.setFondemDateValidite(var1.getFondemDateValidite());
      var3.setFondemDepartement(var1.getFondemDepartement());
      var3.setFondemDevise(var1.getFondemDevise());
      var3.setFondemDiversAdresse(var1.getFondemDiversAdresse());
      var3.setFondemDiversMail(var1.getFondemDiversMail());
      var3.setFondemDiversNom(var1.getFondemDiversNom());
      var3.setFondemDiversTel(var1.getFondemDiversTel());
      var3.setFondemDiversTiers(var1.getFondemDiversTiers());
      var3.setFondemDiversVille(var1.getFondemDiversVille());
      var3.setFondemEcheanceReliquat(var1.getFondemEcheanceReliquat());
      var3.setFondemEtat(var1.getFondemEtat());
      var3.setFondemEtatVal(var1.getFondemEtatVal());
      var3.setFondemExoDouane(var1.getFondemExoDouane());
      var3.setFondemExoTva(var1.getFondemExoTva());
      var3.setFondemFactorEtat(var1.getFondemFactorEtat());
      var3.setFondemFactorId((long)var1.getFondemFactorEtat());
      var3.setFondemFactorNom(var1.getFondemFactorNom());
      var3.setFondemFormule1(var1.getFondemFormule1());
      var3.setFondemFormule2(var1.getFondemFormule2());
      var3.setFondemGarde(var1.getFondemGarde());
      var3.setFondemGele(var1.getFondemGele());
      var3.setFondemIdCommercial(var1.getFondemIdCommercial());
      var3.setFondemIdContact(var1.getFondemIdContact());
      var3.setFondemIdCreateur(var1.getFondemIdCreateur());
      var3.setFondemIdEquipe(var1.getFondemIdEquipe());
      var3.setFondemIdModif(var1.getFondemIdModif());
      var3.setFondemIdResponsable(var1.getFondemIdResponsable());
      var3.setFondemInfo1(var1.getFondemInfo1());
      var3.setFondemInfo2(var1.getFondemInfo2());
      var3.setFondemInfo3(var1.getFondemInfo3());
      var3.setFondemInfo4(var1.getFondemInfo4());
      var3.setFondemInfo5(var1.getFondemInfo5());
      var3.setFondemInfo6(var1.getFondemInfo6());
      var3.setFondemInfo7(var1.getFondemInfo7());
      var3.setFondemInfo8(var1.getFondemInfo8());
      var3.setFondemInfo9(var1.getFondemInfo9());
      var3.setFondemInfo10(var1.getFondemInfo10());
      var3.setFondemJournalReg(var1.getFondemJournalReg());
      var3.setFondemModeReg(var1.getFondemModeReg());
      var3.setFondemModeleImp(var1.getFondemModeleImp());
      var3.setFondemMotifAnnule(var1.getFondemMotifAnnule());
      var3.setFondemMotifRejetCredit(var1.getFondemMotifRejetCredit());
      var3.setFondemNbJourReg(var1.getFondemNbJourReg());
      var3.setFondemNomCommercial(var1.getFondemNomCommercial());
      var3.setFondemNomContact(var1.getFondemNomContact());
      var3.setFondemNomCreateur(var1.getFondemNomCreateur());
      var3.setFondemNomEquipe(var1.getFondemNomEquipe());
      var3.setFondemNomModif(var1.getFondemNomModif());
      var3.setFondemNomResponsable(var1.getFondemNomResponsable());
      var3.setFondemNomTiers(var1.getFondemNomTiers());
      var3.setFondemNum(var1.getFondemNum());
      var3.setFondemObject(var1.getFondemObject());
      var3.setFondemObservation(var1.getFondemObservation());
      var3.setFondemPdv(var1.getFondemPdv());
      var3.setFondemRegion(var1.getFondemRegion());
      var3.setFondemSecteur(var1.getFondemSecteur());
      var3.setFondemSerie(var1.getFondemSerie());
      var3.setFondemService(var1.getFondemService());
      var3.setFondemSite(var1.getFondemSite());
      var3.setFondemSolde(var1.getFondemSolde());
      var3.setFondemSource(var1.getFondemSource());
      var3.setFondemTauxRemise(var1.getFondemTauxRemise());
      var3.setFondemTauxTc(var1.getFondemTauxTc());
      var3.setFondemTotDemande(var1.getFondemTotDemande());
      var3.setFondemTotRabais(var1.getFondemTotRabais());
      var3.setFondemTotReglement(var1.getFondemTotReglement());
      var3.setFondemTotRemise(var1.getFondemTotRemise());
      var3.setFondemTotTc(var1.getFondemTotTc());
      var3.setFondemTotDebloque(var1.getFondemTotDebloque());
      var3.setFondemTotAccorde(var1.getFondemTotAccorde());
      var3.setFondemTypeReg(var1.getFondemTypeReg());
      var3.setFondemTypeTransforme(var1.getFondemTypeTransforme());
      var3.setExerciceventes(var1.getExerciceventes());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var2 = true;
      }

      Query var3 = var1.createQuery("from FondationDemande order by fondemId desc").setMaxResults(1);
      long var4 = 1L;
      if (var3.list() != null) {
         List var6 = var3.list();
         if (var6.size() > 0) {
            FondationDemande var7 = (FondationDemande)var6.get(0);
            var4 = 1L + var7.getFondemId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public FondationDemande selectByNum(Session var1, String var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var3 = true;
      }

      FondationDemande var4 = new FondationDemande();
      Query var5 = var1.createQuery("from FondationDemande where fondemNum =:numero");
      var5.setParameter("numero", var2);
      var5.setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = (FondationDemande)var6.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public FondationDemande enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from FondationDemande where exerciceventes.exevteId=:id and fondemSerie =:ser and year(fondemDate)=" + var7 + " order by fondemDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      FondationDemande var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (FondationDemande)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public FondationDemande enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from FondationDemande where exerciceventes.exevteId=:id and fondemSerie =:ser and year(fondemDate)=" + var7 + " and month(fondemDate)=" + var8 + " order by fondemDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      FondationDemande var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (FondationDemande)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, long var5, String var7, int var8, String var9, String var10, String var11, long var12, int var14, String var15, String var16, String var17, String var18, String var19, String var20, String var21, String var22, String var23, String var24, String var25, String var26) throws HibernateException, NamingException, ParseException {
      boolean var27 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var27 = true;
      }

      new ArrayList();
      UtilDate var29 = new UtilDate();
      Criteria var30 = var1.createCriteria(FondationDemande.class);
      Calendar var31 = Calendar.getInstance();
      Date var32 = null;
      Date var33 = null;
      Date var34 = new Date();
      String var35 = var29.dateToStringFr(var34);
      String var36 = var35.substring(6, 10) + "-" + var35.substring(3, 5) + "-" + var35.substring(0, 2);
      var32 = var29.stringToDateSQL(var36 + " 00:00:00");
      var33 = var29.stringToDateSQL(var36 + " 23:59:59");
      int var37 = var34.getYear() + 1900;
      String var38;
      String var39;
      if (var11.equalsIgnoreCase("100")) {
         if (var19 != null && var20 != null) {
            var32 = var29.stringToDateSQL(var19 + " 00:00:00");
            var33 = var29.stringToDateSQL(var20 + " 23:59:59");
            var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
         } else {
            var38 = "1980-01-01";
            var29.stringToDateSQL(var38 + " 00:00:00");
            var30 = var30.add(Restrictions.isNotNull("fondemDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var30 = var30.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
         } else if (var11.equalsIgnoreCase("1")) {
            var38 = "" + var31.getTime();
            if (var38.contains("Mon")) {
               var32 = var31.getTime();
            } else if (var38.contains("Tue")) {
               var31.add(7, -1);
               var32 = var31.getTime();
            } else if (var38.contains("Wed")) {
               var31.add(7, -2);
               var32 = var31.getTime();
            } else if (var38.contains("Thu")) {
               var31.add(7, -3);
               var32 = var31.getTime();
            } else if (var38.contains("Fri")) {
               var31.add(7, -4);
               var32 = var31.getTime();
            } else if (var38.contains("Sat")) {
               var31.add(7, -5);
               var32 = var31.getTime();
            } else if (var38.contains("Sun")) {
               var31.add(7, -6);
               var32 = var31.getTime();
            }

            var35 = var29.dateToStringFr(var32);
            var36 = var35.substring(6, 10) + "-" + var35.substring(3, 5) + "-" + var35.substring(0, 2);
            var32 = var29.stringToDateSQL(var36 + " 00:00:00");
            var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
         } else {
            int var42;
            if (var11.equalsIgnoreCase("2")) {
               var42 = var31.get(2) + 1;
               var39 = var37 + "-" + var42 + "-01";
               var32 = var29.stringToDateSQL(var39 + " 00:00:00");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("3")) {
               var42 = var31.get(2);
               var31.add(5, -var42);
               if (var42 <= 3) {
                  var39 = var37 + "-01-01";
                  var32 = var29.stringToDateSQL(var39 + " 00:00:00");
               } else if (var42 >= 4 && var42 <= 6) {
                  var39 = var37 + "-04-01";
                  var32 = var29.stringToDateSQL(var39 + " 00:00:00");
               } else if (var42 >= 7 && var42 <= 9) {
                  var39 = var37 + "-07-01";
                  var32 = var29.stringToDateSQL(var39 + " 00:00:00");
               } else if (var42 >= 10) {
                  var39 = var37 + "-10-01";
                  var32 = var29.stringToDateSQL(var39 + " 00:00:00");
               }

               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("4")) {
               var42 = var31.get(2);
               var31.add(5, -var42);
               if (var42 <= 6) {
                  var39 = var37 + "-01-01";
                  var32 = var29.stringToDateSQL(var39 + " 00:00:00");
               } else {
                  var39 = var37 + "-07-01";
                  var32 = var29.stringToDateSQL(var39 + " 00:00:00");
               }

               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("5")) {
               var38 = var37 + "-01-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-03-31";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("6")) {
               var38 = var37 + "-04-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-06-30";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("7")) {
               var38 = var37 + "-07-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-09-30";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("8")) {
               var38 = var37 + "-10-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-12-31";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("9")) {
               var38 = var37 + "-01-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-06-30";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("10")) {
               var38 = var37 + "-07-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-12-31";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("11")) {
               var38 = var37 + "-01-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-12-31";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("12")) {
               var38 = "1980-01-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 - 1 + "-12-31";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("13")) {
               var38 = var37 - 1 + "-01-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 + "-12-31";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("14")) {
               var38 = var37 - 1 + "-01-01";
               var32 = var29.stringToDateSQL(var38 + " 00:00:00");
               var39 = var37 - 1 + "-12-31";
               var33 = var29.stringToDateSQL(var39 + " 23:59:59");
               var30 = var30.add(Restrictions.between("fondemDate", var32, var33));
            } else if (var11.equalsIgnoreCase("20")) {
               var30.setMaxResults(20);
               var30 = var30.addOrder(Order.desc("fondemId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var38 = "%" + var4 + "%";
         var30 = var30.add(Restrictions.like("fondemNum", var38));
      }

      if (var5 != 0L) {
         var30 = var30.add(Restrictions.eq("tiers.tieid", var5));
      } else if (var7 != null && !var7.isEmpty()) {
         var38 = "";
         if (var7.startsWith("*")) {
            var38 = "%" + var7.substring(1) + "%";
         } else {
            var38 = var7 + "%";
         }

         var30 = var30.add(Restrictions.or(Restrictions.like("fondemNomTiers", var38), Restrictions.like("fondemDiversNom", var38)));
      }

      if (var15 != null && !var15.isEmpty()) {
         var30 = var30.add(Restrictions.eq("fondemNomContact", var15));
      }

      if (var16 != null && !var16.isEmpty()) {
         var30 = var30.add(Restrictions.eq("fondemNomResponsable", var16));
      }

      if (var17 != null && !var17.isEmpty()) {
         var30 = var30.add(Restrictions.eq("fondemNomCommercial", var17));
      }

      if (var14 == 1) {
         var30 = var30.add(Restrictions.eq("fondemIdCreateur", var12));
      }

      String[] var43;
      if (!var9.equalsIgnoreCase("100")) {
         if (var9.contains(",")) {
            var43 = var9.split(",");
            int var44 = var43.length;
            String[] var40 = new String[var44];

            for(int var41 = 0; var41 < var44; ++var41) {
               var40[var41] = new String(var43[var41]);
            }

            var30 = var30.add(Restrictions.in("fondemSerie", var40));
         } else {
            var30 = var30.add(Restrictions.eq("fondemSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         if (var10.equalsIgnoreCase("101")) {
            var30 = var30.add(Restrictions.eq("fondemSuivi", 0));
         } else if (var10.equalsIgnoreCase("102")) {
            var30 = var30.add(Restrictions.eq("fondemSuivi", 1));
         } else {
            var30 = var30.add(Restrictions.eq("fondemCat", var10));
         }
      }

      if (var8 <= 10) {
         var30 = var30.add(Restrictions.eq("fondemEtat", var8));
      } else if (var8 == 11) {
         var30 = var30.add(Restrictions.isNotNull("fondemDateRelance"));
      } else if (var8 == 12) {
         var30 = var30.add(Restrictions.eq("fondemTotHt", 0));
      } else if (var8 == 13) {
         var30 = var30.add(Restrictions.eq("fondemSolde", 0));
      } else if (var8 == 14) {
         var30 = var30.add(Restrictions.eq("fondemSolde", 1));
      } else if (var8 == 15) {
         var30 = var30.add(Restrictions.eq("fondemExoTva", 1));
      }

      if (!var18.equalsIgnoreCase("100")) {
         var43 = var18.split(":");
         var39 = var43[0];
         var30 = var30.add(Restrictions.eq("fondemActivite", var39));
      }

      if (var21 != null && !var21.isEmpty() && var21.contains(":")) {
         var43 = var21.split(":");
         var39 = var43[0];
         var30 = var30.add(Restrictions.eq("fondemRegion", var39));
      }

      if (var22 != null && !var22.isEmpty() && var22.contains(":")) {
         var43 = var22.split(":");
         var39 = var43[0];
         var30 = var30.add(Restrictions.eq("fondemSecteur", var39));
      }

      if (var23 != null && !var23.isEmpty() && var23.contains(":")) {
         var43 = var23.split(":");
         var39 = var43[0];
         var30 = var30.add(Restrictions.eq("fondemPdv", var39));
      }

      if (var24 != null && !var24.isEmpty()) {
         var30 = var30.add(Restrictions.eq("fondemSite", var24));
      }

      if (var25 != null && !var25.isEmpty()) {
         var30 = var30.add(Restrictions.eq("fondemDepartement", var25));
      }

      if (var26 != null && !var26.isEmpty()) {
         var30 = var30.add(Restrictions.eq("fondemService", var26));
      }

      var30 = var30.addOrder(Order.desc("fondemDate"));
      var30 = var30.addOrder(Order.desc("fondemNum"));
      List var28 = var30.list();
      if (var27) {
         this.utilInitHibernate.closeSession();
      }

      return var28;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from FondationDemande where fondemService='" + var1 + "' and (fondemDateEcheReg='" + var5 + "' or fondemTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from FondationDemande where fondemDateEcheReg='" + var5 + "' or fondemTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public FondationDemande pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var4 = true;
      }

      Query var5 = var3.createQuery("from FondationDemande where fondemId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new FondationDemande();
      FondationDemande var7;
      if (var6.size() != 0) {
         var7 = (FondationDemande)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
      Query var4 = var3.createQuery("from FondationDemande where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var3 = true;
      }

      Query var4 = var2.createQuery("from FondationDemande where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public FondationDemande pourParapheurByNum(String var1, String var2, Session var3) {
      new FondationDemande();
      Query var5 = var3.createQuery("from FondationDemande where fondemNum=:num and fondemSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      FondationDemande var4;
      if (var6.size() != 0) {
         var4 = (FondationDemande)var6.get(0);
      } else {
         var4 = null;
      }

      return var4;
   }

   public List rechercheDevisAPayerCriterion(String var1, Session var2) throws ParseException {
      new ArrayList();
      String var4 = "";
      Criteria var5 = var2.createCriteria(FondationDemande.class);
      new ArrayList();
      var5 = var5.add(Restrictions.or(Restrictions.eq("fondemTypeReg", 0), Restrictions.eq("fondemTypeReg", 4)));
      if (!var1.equalsIgnoreCase("100")) {
         System.out.println("recherche sans service ");
      } else {
         var5 = var5.add(Restrictions.eq("fondemService", var1));
      }

      List var3 = var5.list();
      System.out.println("nombre de resultat retourné ds devis " + var3.size());
      return var3;
   }

   public List rechercheMaintenance(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var2 = true;
      }

      new ArrayList();
      String var4 = "";
      Date var5 = new Date();
      UtilDate var6 = new UtilDate();
      var6.dateToStringSQLLight(var5);
      List var7 = var1.createQuery("from FondationDemande").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheDevisRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from FondationDemande where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var4 = true;
      }

      List var5 = var2.createQuery("from FondationDemande where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheDevisByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from FondationDemande where fondemDate>=:deb and fondemDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var4 = true;
      }

      List var5 = var2.createQuery("from FondationDemande where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheDevisCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "Fondation");
         var6 = true;
      }

      List var7 = var4.createQuery("from FondationDemande where fondemDate>=:d1 and fondemSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
