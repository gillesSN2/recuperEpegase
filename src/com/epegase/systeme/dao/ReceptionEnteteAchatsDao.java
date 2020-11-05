package com.epegase.systeme.dao;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
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

public class ReceptionEnteteAchatsDao implements Serializable {
   private ReceptionEnteteAchats receptionEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public ReceptionEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public ReceptionEnteteAchats insert(ReceptionEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public ReceptionEnteteAchats modif(ReceptionEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
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

   public ReceptionEnteteAchats modif(ReceptionEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from ReceptionEnteteAchats where recId =:Id");
      var4.setParameter("Id", var1);
      var4.executeUpdate();
      return "";
   }

   public ReceptionEnteteAchats duppliquer(ReceptionEnteteAchats var1, Session var2) {
      ReceptionEnteteAchats var3 = new ReceptionEnteteAchats();
      var3.setRecIdCreateur(var1.getRecIdCreateur());
      var3.setRecNomCreateur(var1.getRecNomCreateur());
      var3.setRecDate(var1.getRecDate());
      var3.setRecDateModif(var1.getRecDateCreat());
      var3.setRecIdModif(var1.getRecIdModif());
      var3.setRecNomModif(var1.getRecNomModif());
      var3.setRecNum(var1.getRecNum());
      var3.setRecDateRelance(var1.getRecDateRelance());
      var3.setRecDateValidite(var1.getRecDateValidite());
      var3.setRecService(var1.getRecService());
      var3.setRecNum(var1.getRecNum());
      var3.setRecNomResponsable(var1.getRecNomResponsable());
      var3.setRecIdResponsable(var1.getRecIdResponsable());
      var3.setRecNomTiers(var1.getRecNomTiers());
      var3.setRecCivilTiers(var1.getRecCivilTiers());
      var3.setRecIdContact(var1.getRecIdContact());
      var3.setRecNomContact(var1.getRecNomContact());
      var3.setRecCivilContact(var1.getRecCivilContact());
      var3.setRecDiversAdresse(var1.getRecDiversAdresse());
      var3.setRecDiversMail(var1.getRecDiversMail());
      var3.setRecDiversNom(var1.getRecDiversNom());
      var3.setRecDiversTel(var1.getRecDiversTel());
      var3.setRecDiversTiers(var1.getRecDiversTiers());
      var3.setRecDiversVille(var1.getRecDiversVille());
      var3.setRecSerie(var1.getRecSerie());
      var3.setRecExoTva(var1.getRecExoTva());
      var3.setRecExoDouane(var1.getRecExoDouane());
      var3.setRecJournalReg(var1.getRecJournalReg());
      var3.setRecCat(var1.getRecCat());
      var3.setRecDevise(var1.getRecDevise());
      var3.setRecObject(var1.getRecObject());
      var3.setRecObservation(var1.getRecObservation());
      var3.setRecTotHt(var1.getRecTotHt());
      var3.setRecTotHtLocal(var1.getRecTotHtLocal());
      var3.setRecTotRemise(var1.getRecTotRemise());
      var3.setRecTotRabais(var1.getRecTotRabais());
      var3.setRecTotTva(var1.getRecTotTva());
      var3.setRecTotTvaLocal(var1.getRecTotTvaLocal());
      var3.setRecTotTc(var1.getRecTotTc());
      var3.setRecTotTtc(var1.getRecTotTtc());
      var3.setRecTotTtcLocal(var1.getRecTotTtcLocal());
      var3.setRecTotReglement(var1.getRecTotReglement());
      var3.setRecCoefDevise(var1.getRecCoefDevise());
      var3.setRecCoefValo(var1.getRecCoefValo());
      var3.setRecSolde(var1.getRecSolde());
      var3.setRecBanque(var1.getRecBanque());
      var3.setRecTypeReg(var1.getRecTypeReg());
      var3.setRecModeReg(var1.getRecModeReg());
      var3.setRecNbJourReg(var1.getRecNbJourReg());
      var3.setRecArrondiReg(var1.getRecArrondiReg());
      var3.setRecConditionReg(var1.getRecConditionReg());
      var3.setRecDateEcheReg(var1.getRecDateEcheReg());
      var3.setRecActivite(var1.getRecActivite());
      var3.setRecSource(var1.getRecSource());
      var3.setRecSite(var1.getRecSite());
      var3.setRecDepartement(var1.getRecDepartement());
      var3.setRecRegion(var1.getRecRegion());
      var3.setRecSecteur(var1.getRecSecteur());
      var3.setRecPdv(var1.getRecPdv());
      var3.setRecAnal2(var1.getRecAnal2());
      var3.setRecAnal4(var1.getRecAnal4());
      var3.setRecAffaire(var1.getRecAffaire());
      var3.setRecInfo1(var1.getRecInfo1());
      var3.setRecInfo2(var1.getRecInfo2());
      var3.setRecInfo3(var1.getRecInfo3());
      var3.setRecInfo4(var1.getRecInfo4());
      var3.setRecInfo5(var1.getRecInfo5());
      var3.setRecInfo6(var1.getRecInfo6());
      var3.setRecInfo7(var1.getRecInfo7());
      var3.setRecInfo8(var1.getRecInfo8());
      var3.setRecInfo9(var1.getRecInfo9());
      var3.setRecInfo10(var1.getRecInfo10());
      var3.setRecFormule1(var1.getRecFormule1());
      var3.setRecFormule2(var1.getRecFormule2());
      var3.setRecAnnexe1(var1.getRecAnnexe1());
      var3.setRecAnnexe2(var1.getRecAnnexe2());
      var3.setRecContrat(var1.getRecContrat());
      var3.setRecIncoterm(var1.getRecIncoterm());
      var3.setRecTotAssurance(var1.getRecTotAssurance());
      var3.setRecTotAssuranceLocal(var1.getRecTotAssuranceLocal());
      var3.setRecTotFret(var1.getRecTotFret());
      var3.setRecTotFret2(var1.getRecTotFret2());
      var3.setRecTotFret2Local(var1.getRecTotFret2Local());
      var3.setRecTotFretLocal(var1.getRecTotFretLocal());
      var3.setRecLieuLivraison(var1.getRecLieuLivraison());
      var3.setRecDateLivraison(var1.getRecDateLivraison());
      var3.setRecInfoLivraison(var1.getRecInfoLivraison());
      var3.setRecNumFature(var1.getRecNumFature());
      var3.setRecNomTransitaire(var1.getRecNomTransitaire());
      var3.setRecDateImp(var1.getRecDateImp());
      var3.setRecModeleImp(var1.getRecModeleImp());
      var3.setRecGele(var1.getRecGele());
      var3.setRecEtat(var1.getRecEtat());
      var3.setRecValorisation(var1.getRecValorisation());
      var3.setRecDateFacture(var1.getRecDateFacture());
      var3.setRecDateTransforme(var1.getRecDateTransforme());
      var3.setRecTypeTransforme(var1.getRecTypeTransforme());
      var3.setRecDateAnnule(var1.getRecDateAnnule());
      var3.setRecMotifAnnule(var1.getRecMotifAnnule());
      var3.setRecFactorNom(var1.getRecFactorNom());
      var3.setRecFactorId(var1.getRecFactorId());
      var3.setRecFactorEtat(var1.getRecFactorEtat());
      var3.setExercicesAchats(var1.getExercicesAchats());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public ReceptionEnteteAchats duppliquerNegatif(ReceptionEnteteAchats var1, Session var2) {
      ReceptionEnteteAchats var3 = new ReceptionEnteteAchats();
      var3.setRecIdCreateur(var1.getRecIdCreateur());
      var3.setRecNomCreateur(var1.getRecNomCreateur());
      var3.setRecDate(var1.getRecDate());
      var3.setRecDateModif(var1.getRecDateCreat());
      var3.setRecIdModif(var1.getRecIdModif());
      var3.setRecNomModif(var1.getRecNomModif());
      var3.setRecNum(var1.getRecNum());
      var3.setRecDateRelance(var1.getRecDateRelance());
      var3.setRecDateValidite(var1.getRecDateValidite());
      var3.setRecService(var1.getRecService());
      var3.setRecNum(var1.getRecNum());
      var3.setRecNomResponsable(var1.getRecNomResponsable());
      var3.setRecIdResponsable(var1.getRecIdResponsable());
      var3.setRecNomTiers(var1.getRecNomTiers());
      var3.setRecCivilTiers(var1.getRecCivilTiers());
      var3.setRecIdContact(var1.getRecIdContact());
      var3.setRecNomContact(var1.getRecNomContact());
      var3.setRecCivilContact(var1.getRecCivilContact());
      var3.setRecDiversAdresse(var1.getRecDiversAdresse());
      var3.setRecDiversMail(var1.getRecDiversMail());
      var3.setRecDiversNom(var1.getRecDiversNom());
      var3.setRecDiversTel(var1.getRecDiversTel());
      var3.setRecDiversTiers(var1.getRecDiversTiers());
      var3.setRecDiversVille(var1.getRecDiversVille());
      var3.setRecSerie(var1.getRecSerie());
      var3.setRecExoTva(var1.getRecExoTva());
      var3.setRecExoDouane(var1.getRecExoDouane());
      var3.setRecJournalReg(var1.getRecJournalReg());
      var3.setRecCat(var1.getRecCat());
      var3.setRecDevise(var1.getRecDevise());
      var3.setRecObject(var1.getRecObject());
      var3.setRecObservation(var1.getRecObservation());
      var3.setRecTotHt(var1.getRecTotHt() * -1.0D);
      var3.setRecTotHtLocal(var1.getRecTotHtLocal() * -1.0D);
      var3.setRecTotRemise(var1.getRecTotRemise() * -1.0D);
      var3.setRecTotRabais(var1.getRecTotRabais() * -1.0D);
      var3.setRecTotTva(var1.getRecTotTva() * -1.0D);
      var3.setRecTotTvaLocal(var1.getRecTotTvaLocal() * -1.0D);
      var3.setRecTotTc(var1.getRecTotTc() * -1.0D);
      var3.setRecTotTtc(var1.getRecTotTtc() * -1.0D);
      var3.setRecTotTtcLocal(var1.getRecTotTtcLocal() * -1.0D);
      var3.setRecTotReglement(0.0D);
      var3.setRecCoefDevise(var1.getRecCoefDevise());
      var3.setRecCoefValo(var1.getRecCoefValo());
      var3.setRecSolde(0);
      var3.setRecBanque(var1.getRecBanque());
      var3.setRecTypeReg(var1.getRecTypeReg());
      var3.setRecModeReg(var1.getRecModeReg());
      var3.setRecNbJourReg(var1.getRecNbJourReg());
      var3.setRecArrondiReg(var1.getRecArrondiReg());
      var3.setRecConditionReg(var1.getRecConditionReg());
      var3.setRecDateEcheReg(var1.getRecDateEcheReg());
      var3.setRecSource(var1.getRecSource());
      var3.setRecActivite(var1.getRecActivite());
      var3.setRecSite(var1.getRecSite());
      var3.setRecDepartement(var1.getRecDepartement());
      var3.setRecRegion(var1.getRecRegion());
      var3.setRecSecteur(var1.getRecSecteur());
      var3.setRecPdv(var1.getRecPdv());
      var3.setRecAnal2(var1.getRecAnal2());
      var3.setRecAnal4(var1.getRecAnal4());
      var3.setRecAffaire(var1.getRecAffaire());
      var3.setRecInfo1(var1.getRecInfo1());
      var3.setRecInfo2(var1.getRecInfo2());
      var3.setRecInfo3(var1.getRecInfo3());
      var3.setRecInfo4(var1.getRecInfo4());
      var3.setRecInfo5(var1.getRecInfo5());
      var3.setRecInfo6(var1.getRecInfo6());
      var3.setRecInfo7(var1.getRecInfo7());
      var3.setRecInfo8(var1.getRecInfo8());
      var3.setRecInfo9(var1.getRecInfo9());
      var3.setRecInfo10(var1.getRecInfo10());
      var3.setRecFormule1(var1.getRecFormule1());
      var3.setRecFormule2(var1.getRecFormule2());
      var3.setRecAnnexe1(var1.getRecAnnexe1());
      var3.setRecAnnexe2(var1.getRecAnnexe2());
      var3.setRecContrat(var1.getRecContrat());
      var3.setRecIncoterm(var1.getRecIncoterm());
      var3.setRecTotAssurance(var1.getRecTotAssurance() * -1.0D);
      var3.setRecTotAssuranceLocal(var1.getRecTotAssuranceLocal() * -1.0D);
      var3.setRecTotFret(var1.getRecTotFret() * -1.0D);
      var3.setRecTotFret2(var1.getRecTotFret2() * -1.0D);
      var3.setRecTotFret2Local(var1.getRecTotFret2Local() * -1.0D);
      var3.setRecTotFretLocal(var1.getRecTotFretLocal() * -1.0D);
      var3.setRecLieuLivraison(var1.getRecLieuLivraison());
      var3.setRecDateLivraison(var1.getRecDateLivraison());
      var3.setRecInfoLivraison(var1.getRecInfoLivraison());
      var3.setRecNumFature(var1.getRecNumFature());
      var3.setRecNomTransitaire(var1.getRecNomTransitaire());
      var3.setRecDateImp(var1.getRecDateImp());
      var3.setRecModeleImp(var1.getRecModeleImp());
      var3.setRecGele(var1.getRecGele());
      var3.setRecEtat(var1.getRecEtat());
      var3.setRecValorisation(var1.getRecValorisation());
      var3.setRecDateFacture(var1.getRecDateFacture());
      var3.setRecDateTransforme(var1.getRecDateTransforme());
      var3.setRecTypeTransforme(var1.getRecTypeTransforme());
      var3.setRecDateAnnule(var1.getRecDateAnnule());
      var3.setRecMotifAnnule(var1.getRecMotifAnnule());
      var3.setRecFactorNom(var1.getRecFactorNom());
      var3.setRecFactorId(var1.getRecFactorId());
      var3.setRecFactorEtat(var1.getRecFactorEtat());
      var3.setExercicesAchats(var1.getExercicesAchats());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var3.setRecExcluValo(true);
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from ReceptionEnteteAchats order by recId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            ReceptionEnteteAchats var7 = (ReceptionEnteteAchats)var6.get(0);
            var4 = 1L + var7.getRecId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public ReceptionEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from ReceptionEnteteAchats where exercicesAchats.exeachId=:id and recSerie =:ser and year(recDate)=" + var7 + " order by recDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      ReceptionEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (ReceptionEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public ReceptionEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from ReceptionEnteteAchats where exercicesAchats.exeachId=:id and recSerie =:ser and year(recDate)=" + var7 + " and month(recDate)=" + var8 + " order by recDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      ReceptionEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (ReceptionEnteteAchats)var11.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var10;
   }

   public List recherche(Session var1, long var2, String var4, long var5, String var7, int var8, String var9, String var10, String var11, String var12, long var13, int var15, String var16, String var17, String var18, String var19, String var20, String var21) throws HibernateException, NamingException, ParseException {
      boolean var22 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var22 = true;
      }

      UtilDate var23 = new UtilDate();
      new ArrayList();
      Criteria var25 = var1.createCriteria(ReceptionEnteteAchats.class);
      Calendar var26 = Calendar.getInstance();
      Date var27 = null;
      Date var28 = null;
      Date var29 = new Date();
      String var30 = var23.dateToStringFr(var29);
      String var31 = var30.substring(6, 10) + "-" + var30.substring(3, 5) + "-" + var30.substring(0, 2);
      var27 = var23.stringToDateSQL(var31 + " 00:00:00");
      var28 = var23.stringToDateSQL(var31 + " 23:59:59");
      int var32 = var29.getYear() + 1900;
      String var33;
      String var34;
      if (var11.equalsIgnoreCase("100")) {
         if (var20 != null && var21 != null) {
            var27 = var23.stringToDateSQL(var20 + " 00:00:00");
            var28 = var23.stringToDateSQL(var21 + " 23:59:59");
            var25 = var25.add(Restrictions.between("recDate", var27, var28));
         } else {
            var33 = "1980-01-01";
            var23.stringToDateSQL(var33 + " 00:00:00");
            var25 = var25.add(Restrictions.isNotNull("recDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var25 = var25.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var25 = var25.add(Restrictions.between("recDate", var27, var28));
         } else if (var11.equalsIgnoreCase("1")) {
            var33 = "" + var26.getTime();
            if (var33.contains("Mon")) {
               var27 = var26.getTime();
            } else if (var33.contains("Tue")) {
               var26.add(7, -1);
               var27 = var26.getTime();
            } else if (var33.contains("Wed")) {
               var26.add(7, -2);
               var27 = var26.getTime();
            } else if (var33.contains("Thu")) {
               var26.add(7, -3);
               var27 = var26.getTime();
            } else if (var33.contains("Fri")) {
               var26.add(7, -4);
               var27 = var26.getTime();
            } else if (var33.contains("Sat")) {
               var26.add(7, -5);
               var27 = var26.getTime();
            } else if (var33.contains("Sun")) {
               var26.add(7, -6);
               var27 = var26.getTime();
            }

            var30 = var23.dateToStringFr(var27);
            var31 = var30.substring(6, 10) + "-" + var30.substring(3, 5) + "-" + var30.substring(0, 2);
            var27 = var23.stringToDateSQL(var31 + " 00:00:00");
            var25 = var25.add(Restrictions.between("recDate", var27, var28));
         } else {
            int var37;
            if (var11.equalsIgnoreCase("2")) {
               var37 = var26.get(2) + 1;
               var34 = var32 + "-" + var37 + "-01";
               var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("3")) {
               var37 = var26.get(2);
               var26.add(5, -var37);
               if (var37 <= 3) {
                  var34 = var32 + "-01-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               } else if (var37 >= 4 && var37 <= 6) {
                  var34 = var32 + "-04-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               } else if (var37 >= 7 && var37 <= 9) {
                  var34 = var32 + "-07-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               } else if (var37 >= 10) {
                  var34 = var32 + "-10-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               }

               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("4")) {
               var37 = var26.get(2);
               var26.add(5, -var37);
               if (var37 <= 6) {
                  var34 = var32 + "-01-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               } else {
                  var34 = var32 + "-07-01";
                  var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               }

               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("5")) {
               var33 = var32 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-03-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("6")) {
               var33 = var32 + "-04-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-06-30";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("7")) {
               var33 = var32 + "-07-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-09-30";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("8")) {
               var33 = var32 + "-10-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("9")) {
               var33 = var32 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-06-30";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("10")) {
               var33 = var32 + "-07-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("11")) {
               var33 = var32 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("12")) {
               var33 = "1980-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 - 1 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("13")) {
               var33 = var32 - 1 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("14")) {
               var33 = var32 - 1 + "-01-01";
               var27 = var23.stringToDateSQL(var33 + " 00:00:00");
               var34 = var32 - 1 + "-12-31";
               var28 = var23.stringToDateSQL(var34 + " 23:59:59");
               var25 = var25.add(Restrictions.between("recDate", var27, var28));
            } else if (var11.equalsIgnoreCase("20")) {
               var25.setMaxResults(20);
               var25 = var25.addOrder(Order.desc("recId"));
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var33 = "%" + var4 + "%";
         var25 = var25.add(Restrictions.like("recNum", var33));
      }

      if (var5 != 0L) {
         var25 = var25.add(Restrictions.eq("tiers.tieid", var5));
      } else if (var7 != null && !var7.isEmpty()) {
         var33 = "%" + var7 + "%";
         var25 = var25.add(Restrictions.or(Restrictions.like("recNomTiers", var33), Restrictions.like("recDiversNom", var33)));
      }

      if (var16 != null && !var16.isEmpty()) {
         var25 = var25.add(Restrictions.eq("recNomResponsable", var16));
      }

      if (var15 == 1) {
         var25 = var25.add(Restrictions.eq("recIdCreateur", var13));
      }

      String[] var38;
      if (!var9.equalsIgnoreCase("100")) {
         if (var9.contains(",")) {
            var38 = var9.split(",");
            int var39 = var38.length;
            String[] var35 = new String[var39];

            for(int var36 = 0; var36 < var39; ++var36) {
               var35[var36] = new String(var38[var36]);
            }

            var25 = var25.add(Restrictions.in("recSerie", var35));
         } else {
            var25 = var25.add(Restrictions.eq("recSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         var25 = var25.add(Restrictions.eq("recCat", var10));
      }

      if (var8 <= 10) {
         var25 = var25.add(Restrictions.eq("recEtat", var8));
      } else if (var8 == 11) {
         var25 = var25.add(Restrictions.eq("recSolde", 0));
      } else if (var8 == 12) {
         var25 = var25.add(Restrictions.eq("recSolde", 1));
      }

      if (var12 != null && !var12.isEmpty() && !var12.equalsIgnoreCase("100") && var12.contains(":")) {
         var25 = var25.add(Restrictions.eq("recService", var12));
      }

      if (var17 != null && !var17.isEmpty() && !var17.equalsIgnoreCase("100")) {
         var38 = var17.split(":");
         var34 = var38[0];
         var25 = var25.add(Restrictions.eq("recActivite", var34));
      }

      if (var18 != null && !var18.isEmpty()) {
         var33 = "%" + var18 + "%";
         var25 = var25.add(Restrictions.or(Restrictions.like("recAffaire", var33), Restrictions.like("recAnal4", var33)));
      }

      if (var19 != null && !var19.isEmpty()) {
         var33 = "%" + var19 + "%";
         var25 = var25.add(Restrictions.like("recAnal4", var33));
      }

      var25 = var25.addOrder(Order.desc("recDate"));
      var25 = var25.addOrder(Order.desc("recNum"));
      List var40 = var25.list();
      if (var22) {
         this.utilInitHibernate.closeSession();
      }

      return var40;
   }

   public ReceptionEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ReceptionEnteteAchats where recId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new ReceptionEnteteAchats();
      ReceptionEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (ReceptionEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ReceptionEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var4 = true;
      }

      Query var5 = null;
      if (var2 != null && !var2.isEmpty()) {
         var5 = var3.createQuery("from ReceptionEnteteAchats where recNum=:num and recSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      } else {
         var5 = var3.createQuery("from ReceptionEnteteAchats where recNum=:num").setString("num", var1).setMaxResults(1);
      }

      List var6 = var5.list();
      new ReceptionEnteteAchats();
      ReceptionEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (ReceptionEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public ReceptionEnteteAchats rechercheAnal4(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ReceptionEnteteAchats where recAnal4=:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new ReceptionEnteteAchats();
      ReceptionEnteteAchats var6;
      if (var5.size() != 0) {
         var6 = (ReceptionEnteteAchats)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ReceptionEnteteAchats where recAnal4 =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheByAffaire(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from ReceptionEnteteAchats where recAffaire =:num and recAnal4 =:anal").setString("num", var1).setString("anal", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public ReceptionEnteteAchats pourParapheurByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ReceptionEnteteAchats where recAnal4 =:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new ReceptionEnteteAchats();
      ReceptionEnteteAchats var6;
      if (var5.size() != 0) {
         var6 = (ReceptionEnteteAchats)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public ReceptionEnteteAchats pourParapheurByDossier(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from ReceptionEnteteAchats where recAnal4 =:num and recAffaire =:aff").setString("num", var1).setString("aff", var2).setMaxResults(1);
      List var6 = var5.list();
      new ReceptionEnteteAchats();
      ReceptionEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (ReceptionEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheByValo(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ReceptionEnteteAchats where recValo =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheNonValoriser(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from ReceptionEnteteAchats where (recValo='' or recValo is NULL or recValo=:val ) and recValorisation>=1 and (recEtat=1 or recEtat=4 or recEtat=5)").setString("val", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
      Query var4 = var3.createQuery("from ReceptionEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from ReceptionEnteteAchats where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from ReceptionEnteteAchats where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheReceptionRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from ReceptionEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheReceptionByDate(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from ReceptionEnteteAchats where recDate>=:deb and recDate<=:fin").setString("deb", var1).setString("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheReceptionByDate(String var1, String var2, String var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = false;
      if (var4 == null) {
         var4 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var5 = true;
      }

      new ArrayList();
      List var7 = null;
      var7 = var4.createQuery("from ReceptionEnteteAchats where (recAnal2 is not null and recAnal2<>'' and recAnal2 like'" + var1 + "%') and recDate>=:deb and recDate<=:fin").setString("deb", var2).setString("fin", var3).list();
      if (var5) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public List rechercheReceptionCampagne(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "ReceptionEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from ReceptionEnteteAchats where recSource like '" + var1 + "%'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
