package com.epegase.systeme.dao;

import com.epegase.systeme.classe.DevisEnteteVentes;
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

public class DevisEnteteVentesDao implements Serializable {
   private DevisEnteteVentes devisEnteteVentes;
   private ExercicesVentes exercicesVentes;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public DevisEnteteVentesDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public DevisEnteteVentes insert(DevisEnteteVentes var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public DevisEnteteVentes modif(DevisEnteteVentes var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
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

   public DevisEnteteVentes modif(DevisEnteteVentes var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from DevisEnteteVentes where dvsId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public DevisEnteteVentes duppliquer(DevisEnteteVentes var1, Session var2) {
      DevisEnteteVentes var3 = new DevisEnteteVentes();
      var3.setDvsAccord(var1.getDvsAccord());
      var3.setDvsActivite(var1.getDvsActivite());
      var3.setDvsAnal2(var1.getDvsAnal2());
      var3.setDvsAnal4(var1.getDvsAnal4());
      var3.setDvsAffaire(var1.getDvsAffaire());
      var3.setDvsAnnexe1(var1.getDvsAnnexe1());
      var3.setDvsAnnexe2(var1.getDvsAnnexe2());
      var3.setDvsArrondiReg(var1.getDvsArrondiReg());
      var3.setDvsBanque(var1.getDvsBanque());
      var3.setDvsBeneficiaire(var1.getDvsBeneficiaire());
      var3.setDvsBureau(var1.getDvsBureau());
      var3.setDvsCat(var1.getDvsCat());
      var3.setDvsCivilContact(var1.getDvsCivilContact());
      var3.setDvsCivilTiers(var1.getDvsCivilTiers());
      var3.setDvsConditionReg(var1.getDvsConditionReg());
      var3.setDvsContrat(var1.getDvsContrat());
      var3.setDvsDate(var1.getDvsDate());
      var3.setDvsDateAnnule(var1.getDvsDateAnnule());
      var3.setDvsDateCreat(var1.getDvsDateCreat());
      var3.setDvsDateEcheReg(var1.getDvsDateEcheReg());
      var3.setDvsDateImp(var1.getDvsDateImp());
      var3.setDvsDateLivraison(var1.getDvsDateLivraison());
      var3.setDvsDateModif(var1.getDvsDateModif());
      var3.setDvsDateRelance(var1.getDvsDateRelance());
      var3.setDvsDateTransforme(var1.getDvsDateTransforme());
      var3.setDvsDateValide(var1.getDvsDateValide());
      var3.setDvsDateValidite(var1.getDvsDateValidite());
      var3.setDvsDepartement(var1.getDvsDepartement());
      var3.setDvsDevise(var1.getDvsDevise());
      var3.setDvsDiversAdresse(var1.getDvsDiversAdresse());
      var3.setDvsDiversMail(var1.getDvsDiversMail());
      var3.setDvsDiversNom(var1.getDvsDiversNom());
      var3.setDvsDiversTel(var1.getDvsDiversTel());
      var3.setDvsDiversTiers(var1.getDvsDiversTiers());
      var3.setDvsDiversVille(var1.getDvsDiversVille());
      var3.setDvsEcheanceReliquat(var1.getDvsEcheanceReliquat());
      var3.setDvsEtat(var1.getDvsEtat());
      var3.setDvsEtatVal(var1.getDvsEtatVal());
      var3.setDvsExoDouane(var1.getDvsExoDouane());
      var3.setDvsExoTva(var1.getDvsExoTva());
      var3.setDvsFactorEtat(var1.getDvsFactorEtat());
      var3.setDvsFactorId((long)var1.getDvsFactorEtat());
      var3.setDvsFactorNom(var1.getDvsFactorNom());
      var3.setDvsFormule1(var1.getDvsFormule1());
      var3.setDvsFormule2(var1.getDvsFormule2());
      var3.setDvsFournisseur(var1.getDvsFournisseur());
      var3.setDvsGarde(var1.getDvsGarde());
      var3.setDvsGele(var1.getDvsGele());
      var3.setDvsIdCommercial(var1.getDvsIdCommercial());
      var3.setDvsIdContact(var1.getDvsIdContact());
      var3.setDvsIdCreateur(var1.getDvsIdCreateur());
      var3.setDvsIdEquipe(var1.getDvsIdEquipe());
      var3.setDvsIdModif(var1.getDvsIdModif());
      var3.setDvsIdResponsable(var1.getDvsIdResponsable());
      var3.setDvsIncoterm(var1.getDvsIncoterm());
      var3.setDvsInfo1(var1.getDvsInfo1());
      var3.setDvsInfo2(var1.getDvsInfo2());
      var3.setDvsInfo3(var1.getDvsInfo3());
      var3.setDvsInfo4(var1.getDvsInfo4());
      var3.setDvsInfo5(var1.getDvsInfo5());
      var3.setDvsInfo6(var1.getDvsInfo6());
      var3.setDvsInfo7(var1.getDvsInfo7());
      var3.setDvsInfo8(var1.getDvsInfo8());
      var3.setDvsInfo9(var1.getDvsInfo9());
      var3.setDvsInfo10(var1.getDvsInfo10());
      var3.setDvsInfoLivraison(var1.getDvsInfoLivraison());
      var3.setDvsJournalReg(var1.getDvsJournalReg());
      var3.setDvsLieuLivraison(var1.getDvsLieuLivraison());
      var3.setDvsModeReg(var1.getDvsModeReg());
      var3.setDvsModeleImp(var1.getDvsModeleImp());
      var3.setDvsMotifAnnule(var1.getDvsMotifAnnule());
      var3.setDvsMotifRejetCredit(var1.getDvsMotifRejetCredit());
      var3.setDvsNbJourReg(var1.getDvsNbJourReg());
      var3.setDvsNomCommercial(var1.getDvsNomCommercial());
      var3.setDvsNomContact(var1.getDvsNomContact());
      var3.setDvsNomCreateur(var1.getDvsNomCreateur());
      var3.setDvsNomEquipe(var1.getDvsNomEquipe());
      var3.setDvsNomModif(var1.getDvsNomModif());
      var3.setDvsNomResponsable(var1.getDvsNomResponsable());
      var3.setDvsNomTiers(var1.getDvsNomTiers());
      var3.setDvsNum(var1.getDvsNum());
      var3.setDvsObject(var1.getDvsObject());
      var3.setDvsObservation(var1.getDvsObservation());
      var3.setDvsPays(var1.getDvsPays());
      var3.setDvsPdv(var1.getDvsPdv());
      var3.setDvsRegime(var1.getDvsRegime());
      var3.setDvsRegion(var1.getDvsRegion());
      var3.setDvsSecteur(var1.getDvsSecteur());
      var3.setDvsSerie(var1.getDvsSerie());
      var3.setDvsService(var1.getDvsService());
      var3.setDvsSite(var1.getDvsSite());
      var3.setDvsSolde(var1.getDvsSolde());
      var3.setDvsSource(var1.getDvsSource());
      var3.setDvsTauxRemise(var1.getDvsTauxRemise());
      var3.setDvsTauxTc(var1.getDvsTauxTc());
      var3.setDvsTotHt(var1.getDvsTotHt());
      var3.setDvsTotRabais(var1.getDvsTotRabais());
      var3.setDvsTotReglement(var1.getDvsTotReglement());
      var3.setDvsTotRemise(var1.getDvsTotRemise());
      var3.setDvsTotTc(var1.getDvsTotTc());
      var3.setDvsTotTtc(var1.getDvsTotTtc());
      var3.setDvsTotTva(var1.getDvsTotTva());
      var3.setDvsTypeReg(var1.getDvsTypeReg());
      var3.setDvsTypeTransforme(var1.getDvsTypeTransforme());
      var3.setDvsUtilisation(var1.getDvsUtilisation());
      var3.setExerciceventes(var1.getExerciceventes());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from DevisEnteteVentes order by dvsId desc").setMaxResults(1);
      long var4 = 1L;
      if (var3.list() != null) {
         List var6 = var3.list();
         if (var6.size() > 0) {
            DevisEnteteVentes var7 = (DevisEnteteVentes)var6.get(0);
            var4 = 1L + var7.getDvsId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public DevisEnteteVentes selectByNum(Session var1, String var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var3 = true;
      }

      DevisEnteteVentes var4 = new DevisEnteteVentes();
      Query var5 = var1.createQuery("from DevisEnteteVentes where dvsNum =:numero").setString("numero", var2).setMaxResults(1);
      List var6 = var5.list();
      if (var6.size() > 0) {
         var4 = (DevisEnteteVentes)var6.get(0);
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public DevisEnteteVentes enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from DevisEnteteVentes where exerciceventes.exevteId=:id and dvsSerie =:ser and year(dvsDate)=" + var7 + " order by dvsDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      DevisEnteteVentes var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (DevisEnteteVentes)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public DevisEnteteVentes enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from DevisEnteteVentes where exerciceventes.exevteId=:id and dvsSerie =:ser and year(dvsDate)=" + var7 + " and month(dvsDate)=" + var8 + " order by dvsDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      DevisEnteteVentes var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (DevisEnteteVentes)var11.get(0);
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
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var28 = true;
      }

      new ArrayList();
      UtilDate var30 = new UtilDate();
      Criteria var31 = var1.createCriteria(DevisEnteteVentes.class);
      Calendar var32 = Calendar.getInstance();
      Date var33 = null;
      Date var34 = null;
      Date var35 = new Date();
      String var36 = var30.dateToStringFr(var35);
      String var37 = var36.substring(6, 10) + "-" + var36.substring(3, 5) + "-" + var36.substring(0, 2);
      var33 = var30.stringToDateSQL(var37 + " 00:00:00");
      var34 = var30.stringToDateSQL(var37 + " 23:59:59");
      int var38 = var35.getYear() + 1900;
      String var39;
      String var40;
      if (var11.equalsIgnoreCase("100")) {
         if (var20 != null && var21 != null) {
            var33 = var30.stringToDateSQL(var20 + " 00:00:00");
            var34 = var30.stringToDateSQL(var21 + " 23:59:59");
            var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
         } else {
            var39 = "1980-01-01";
            var30.stringToDateSQL(var39 + " 00:00:00");
            var31 = var31.add(Restrictions.isNotNull("dvsDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var31 = var31.add(Restrictions.eq("exerciceventes.exevteId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
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

            var36 = var30.dateToStringFr(var33);
            var37 = var36.substring(6, 10) + "-" + var36.substring(3, 5) + "-" + var36.substring(0, 2);
            var33 = var30.stringToDateSQL(var37 + " 00:00:00");
            var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
         } else {
            int var43;
            if (var11.equalsIgnoreCase("2")) {
               var43 = var32.get(2) + 1;
               var40 = var38 + "-" + var43 + "-01";
               var33 = var30.stringToDateSQL(var40 + " 00:00:00");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("3")) {
               var43 = var32.get(2);
               var32.add(5, -var43);
               if (var43 <= 3) {
                  var40 = var38 + "-01-01";
                  var33 = var30.stringToDateSQL(var40 + " 00:00:00");
               } else if (var43 >= 4 && var43 <= 6) {
                  var40 = var38 + "-04-01";
                  var33 = var30.stringToDateSQL(var40 + " 00:00:00");
               } else if (var43 >= 7 && var43 <= 9) {
                  var40 = var38 + "-07-01";
                  var33 = var30.stringToDateSQL(var40 + " 00:00:00");
               } else if (var43 >= 10) {
                  var40 = var38 + "-10-01";
                  var33 = var30.stringToDateSQL(var40 + " 00:00:00");
               }

               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("4")) {
               var43 = var32.get(2);
               var32.add(5, -var43);
               if (var43 <= 6) {
                  var40 = var38 + "-01-01";
                  var33 = var30.stringToDateSQL(var40 + " 00:00:00");
               } else {
                  var40 = var38 + "-07-01";
                  var33 = var30.stringToDateSQL(var40 + " 00:00:00");
               }

               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("5")) {
               var39 = var38 + "-01-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-03-31";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("6")) {
               var39 = var38 + "-04-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-06-30";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("7")) {
               var39 = var38 + "-07-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-09-30";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("8")) {
               var39 = var38 + "-10-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("9")) {
               var39 = var38 + "-01-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-06-30";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("10")) {
               var39 = var38 + "-07-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("11")) {
               var39 = var38 + "-01-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("12")) {
               var39 = "1980-01-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 - 1 + "-12-31";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("13")) {
               var39 = var38 - 1 + "-01-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 + "-12-31";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("14")) {
               var39 = var38 - 1 + "-01-01";
               var33 = var30.stringToDateSQL(var39 + " 00:00:00");
               var40 = var38 - 1 + "-12-31";
               var34 = var30.stringToDateSQL(var40 + " 23:59:59");
               var31 = var31.add(Restrictions.between("dvsDate", var33, var34));
            } else if (var11.equalsIgnoreCase("20")) {
               var31.setMaxResults(20);
               var31 = var31.addOrder(Order.desc("dvsId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var39 = "%" + var4 + "%";
         var31 = var31.add(Restrictions.like("dvsNum", var39));
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

         var31 = var31.add(Restrictions.or(Restrictions.like("dvsNomTiers", var39), Restrictions.like("dvsDiversNom", var39)));
      }

      if (var15 != null && !var15.isEmpty()) {
         var31 = var31.add(Restrictions.eq("dvsNomContact", var15));
      }

      if (var16 != null && !var16.isEmpty()) {
         var31 = var31.add(Restrictions.eq("dvsNomResponsable", var16));
      }

      if (var17 != null && !var17.isEmpty()) {
         var31 = var31.add(Restrictions.eq("dvsNomCommercial", var17));
      }

      if (var14 == 1) {
         var31 = var31.add(Restrictions.eq("dvsIdCreateur", var12));
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

            var31 = var31.add(Restrictions.in("dvsSerie", var41));
         } else {
            var31 = var31.add(Restrictions.eq("dvsSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         if (var10.equalsIgnoreCase("101")) {
            var31 = var31.add(Restrictions.eq("dvsSuivi", 0));
         } else if (var10.equalsIgnoreCase("102")) {
            var31 = var31.add(Restrictions.eq("dvsSuivi", 1));
         } else {
            var31 = var31.add(Restrictions.eq("dvsCat", var10));
         }
      }

      if (var8 <= 10) {
         var31 = var31.add(Restrictions.eq("dvsEtat", var8));
      } else if (var8 == 11) {
         var31 = var31.add(Restrictions.isNotNull("dvsDateRelance"));
      } else if (var8 == 12) {
         var31 = var31.add(Restrictions.eq("dvsTotHt", 0));
      } else if (var8 == 13) {
         var31 = var31.add(Restrictions.eq("dvsSolde", 0));
      } else if (var8 == 14) {
         var31 = var31.add(Restrictions.eq("dvsSolde", 1));
      } else if (var8 == 15) {
         var31 = var31.add(Restrictions.eq("dvsExoTva", 1));
      }

      if (!var18.equalsIgnoreCase("100")) {
         var44 = var18.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("dvsActivite", var40));
      }

      if (var22 != null && !var22.isEmpty() && var22.contains(":")) {
         var44 = var22.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("dvsRegion", var40));
      }

      if (var23 != null && !var23.isEmpty() && var23.contains(":")) {
         var44 = var23.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("dvsSecteur", var40));
      }

      if (var24 != null && !var24.isEmpty() && var24.contains(":")) {
         var44 = var24.split(":");
         var40 = var44[0];
         var31 = var31.add(Restrictions.eq("dvsPdv", var40));
      }

      if (var25 != null && !var25.isEmpty()) {
         var31 = var31.add(Restrictions.eq("dvsSite", var25));
      }

      if (var26 != null && !var26.isEmpty()) {
         var31 = var31.add(Restrictions.eq("dvsDepartement", var26));
      }

      if (var27 != null && !var27.isEmpty()) {
         var31 = var31.add(Restrictions.eq("dvsService", var27));
      }

      if (var19 != null && !var19.isEmpty()) {
         var39 = "%" + var19 + "%";
         var31 = var31.add(Restrictions.like("dvsContener", var39));
      }

      var31 = var31.addOrder(Order.desc("dvsDate"));
      var31 = var31.addOrder(Order.desc("dvsNum"));
      List var29 = var31.list();
      if (var28) {
         this.utilInitHibernate.closeSession();
      }

      return var29;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from DevisEnteteVentes where dvsService='" + var1 + "' and (dvsDateEcheReg='" + var5 + "' or dvsTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from DevisEnteteVentes where dvsDateEcheReg='" + var5 + "' or dvsTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public DevisEnteteVentes pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from DevisEnteteVentes where dvsId =:num").setLong("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new DevisEnteteVentes();
      DevisEnteteVentes var7;
      if (var6.size() != 0) {
         var7 = (DevisEnteteVentes)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public DevisEnteteVentes pourParapheur(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from DevisEnteteVentes where dvsNum =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new DevisEnteteVentes();
      DevisEnteteVentes var6;
      if (var5.size() != 0) {
         var6 = (DevisEnteteVentes)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
      Query var4 = var3.createQuery("from DevisEnteteVentes where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from DevisEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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

   public DevisEnteteVentes pourParapheurByNum(String var1, String var2, Session var3) {
      new DevisEnteteVentes();
      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from DevisEnteteVentes where dvsNum=:num and dvsSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var5 = var3.createQuery("from DevisEnteteVentes where dvsNum=:num").setString("num", var1).setMaxResults(1);
      }

      List var6 = var5.list();
      DevisEnteteVentes var4;
      if (var6.size() != 0) {
         var4 = (DevisEnteteVentes)var6.get(0);
      } else {
         var4 = null;
      }

      return var4;
   }

   public List rechercheDevisAPayerCriterion(String var1, Session var2) throws ParseException {
      new ArrayList();
      String var4 = "";
      Criteria var5 = var2.createCriteria(DevisEnteteVentes.class);
      new ArrayList();
      var5 = var5.add(Restrictions.or(Restrictions.eq("dvsTypeReg", 0), Restrictions.eq("dvsTypeReg", 4)));
      if (!var1.equalsIgnoreCase("100")) {
         System.out.println("recherche sans service ");
      } else {
         var5 = var5.add(Restrictions.eq("dvsService", var1));
      }

      List var3 = var5.list();
      System.out.println("nombre de resultat retourné ds devis " + var3.size());
      return var3;
   }

   public List rechercheMaintenance(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var2 = true;
      }

      new ArrayList();
      String var4 = "";
      Date var5 = new Date();
      UtilDate var6 = new UtilDate();
      var6.dateToStringSQLLight(var5);
      List var7 = var1.createQuery("from DevisEnteteVentes").list();
      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheDevisRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from DevisEnteteVentes where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from DevisEnteteVentes where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheDevisByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from DevisEnteteVentes where dvsDate>=:deb and dvsDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List verifByTiers(Tiers var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from DevisEnteteVentes where tiers=:tie").setParameter("tie", var1).setMaxResults(1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheDevisCampagne(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      boolean var6 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "DevisEntete");
         var6 = true;
      }

      List var7 = var4.createQuery("from DevisEnteteVentes where dvsDate>=:d1 and dvsSource like '" + var3 + "%'").setString("d1", var1).list();
      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }
}
