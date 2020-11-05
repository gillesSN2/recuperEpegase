package com.epegase.systeme.dao;

import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.ExercicesAchats;
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

public class CommandeEnteteAchatsDao implements Serializable {
   private CommandeEnteteAchats commandeEnteteAchats;
   private ExercicesAchats exercicesAchats;
   private String mabase;
   private UtilInitHibernate utilInitHibernate;

   public CommandeEnteteAchatsDao(String var1, UtilInitHibernate var2) {
      this.mabase = var1;
      this.utilInitHibernate = var2;
   }

   public CommandeEnteteAchats insert(CommandeEnteteAchats var1, Session var2) {
      var2.save(var1);
      return var1;
   }

   public CommandeEnteteAchats modif(CommandeEnteteAchats var1) throws HibernateException, NamingException {
      Session var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
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

   public CommandeEnteteAchats modif(CommandeEnteteAchats var1, Session var2) {
      var2.update(var1);
      return var1;
   }

   public String delete(long var1, Session var3) {
      Query var4 = var3.createQuery("delete from CommandeEnteteAchats where cmdId =:Sid");
      var4.setParameter("Sid", var1);
      var4.executeUpdate();
      return "";
   }

   public CommandeEnteteAchats duppliquer(CommandeEnteteAchats var1, Session var2) {
      CommandeEnteteAchats var3 = new CommandeEnteteAchats();
      var3.setCmdIdCreateur(var1.getCmdIdCreateur());
      var3.setCmdNomCreateur(var1.getCmdNomCreateur());
      var3.setCmdDate(var1.getCmdDate());
      var3.setCmdDateCreat(var1.getCmdDateCreat());
      var3.setCmdDateModif(var1.getCmdDateModif());
      var3.setCmdIdModif(var1.getCmdIdModif());
      var3.setCmdNomModif(var1.getCmdNomModif());
      var3.setCmdNum(var1.getCmdNum());
      var3.setCmdDateRelance(var1.getCmdDateRelance());
      var3.setCmdDateValidite(var1.getCmdDateValidite());
      var3.setCmdService(var1.getCmdService());
      var3.setCmdNomResponsable(var1.getCmdNomResponsable());
      var3.setCmdIdResponsable(var1.getCmdIdResponsable());
      var3.setCmdNomTiers(var1.getCmdNomTiers());
      var3.setCmdCivilTiers(var1.getCmdCivilTiers());
      var3.setCmdIdContact(var1.getCmdIdContact());
      var3.setCmdNomContact(var1.getCmdNomContact());
      var3.setCmdCivilContact(var1.getCmdCivilContact());
      var3.setCmdDiversAdresse(var1.getCmdDiversAdresse());
      var3.setCmdDiversMail(var1.getCmdDiversMail());
      var3.setCmdDiversNom(var1.getCmdDiversNom());
      var3.setCmdDiversTel(var1.getCmdDiversTel());
      var3.setCmdDiversTiers(var1.getCmdDiversTiers());
      var3.setCmdDiversVille(var1.getCmdDiversVille());
      var3.setCmdSerie(var1.getCmdSerie());
      var3.setCmdExoTva(var1.getCmdExoTva());
      var3.setCmdExoDouane(var1.getCmdExoDouane());
      var3.setCmdJournalReg(var1.getCmdJournalReg());
      var3.setCmdCat(var1.getCmdCat());
      var3.setCmdDevise(var1.getCmdDevise());
      var3.setCmdObject(var1.getCmdObject());
      var3.setCmdObservation(var1.getCmdObservation());
      var3.setCmdTotHt(var1.getCmdTotHt());
      var3.setCmdTotRemise(var1.getCmdTotRemise());
      var3.setCmdTotRabais(var1.getCmdTotRabais());
      var3.setCmdTotTva(var1.getCmdTotTva());
      var3.setCmdTotTc(var1.getCmdTotTtc());
      var3.setCmdTotTtc(var1.getCmdTotTtc());
      var3.setCmdTotReglement(var1.getCmdTotReglement());
      var3.setCmdSolde(var1.getCmdSolde());
      var3.setCmdBanque(var1.getCmdBanque());
      var3.setCmdTypeReg(var1.getCmdTypeReg());
      var3.setCmdModeReg(var1.getCmdModeReg());
      var3.setCmdNbJourReg(var1.getCmdNbJourReg());
      var3.setCmdArrondiReg(var1.getCmdArrondiReg());
      var3.setCmdConditionReg(var1.getCmdConditionReg());
      var3.setCmdDateEcheReg(var1.getCmdDateEcheReg());
      var3.setCmdActivite(var1.getCmdActivite());
      var3.setCmdSource(var1.getCmdSource());
      var3.setCmdSite(var1.getCmdSite());
      var3.setCmdDepartement(var1.getCmdDepartement());
      var3.setCmdRegion(var1.getCmdRegion());
      var3.setCmdSecteur(var1.getCmdSecteur());
      var3.setCmdPdv(var1.getCmdPdv());
      var3.setCmdAnal2(var1.getCmdAnal2());
      var3.setCmdAnal4(var1.getCmdAnal4());
      var3.setCmdAffaire(var1.getCmdAffaire());
      var3.setCmdInfo1(var1.getCmdInfo1());
      var3.setCmdInfo2(var1.getCmdInfo2());
      var3.setCmdInfo3(var1.getCmdInfo3());
      var3.setCmdInfo4(var1.getCmdInfo4());
      var3.setCmdInfo5(var1.getCmdInfo5());
      var3.setCmdInfo6(var1.getCmdInfo6());
      var3.setCmdInfo7(var1.getCmdInfo7());
      var3.setCmdInfo8(var1.getCmdInfo8());
      var3.setCmdInfo9(var1.getCmdInfo9());
      var3.setCmdInfo10(var1.getCmdInfo10());
      var3.setCmdFormule1(var1.getCmdFormule1());
      var3.setCmdFormule2(var1.getCmdFormule2());
      var3.setCmdAnnexe1(var1.getCmdAnnexe1());
      var3.setCmdAnnexe2(var1.getCmdAnnexe2());
      var3.setCmdContrat(var1.getCmdContrat());
      var3.setCmdIncoterm(var1.getCmdIncoterm());
      var3.setCmdLieuLivraison(var1.getCmdLieuLivraison());
      var3.setCmdDateLivraison(var1.getCmdDateLivraison());
      var3.setCmdInfoLivraison(var1.getCmdInfoLivraison());
      var3.setCmdDateImp(var1.getCmdDateImp());
      var3.setCmdModeleImp(var1.getCmdModeleImp());
      var3.setCmdGele(var1.getCmdGele());
      var3.setCmdEtat(var1.getCmdEtat());
      var3.setCmdDateFacture(var1.getCmdDateFacture());
      var3.setCmdDateTransforme(var1.getCmdDateTransforme());
      var3.setCmdTypeTransforme(var1.getCmdTypeTransforme());
      var3.setCmdDateAnnule(var1.getCmdDateAnnule());
      var3.setCmdMotifAnnule(var1.getCmdMotifAnnule());
      var3.setCmdFactorNom(var1.getCmdFactorNom());
      var3.setCmdFactorId(var1.getCmdFactorId());
      var3.setCmdFactorEtat(var1.getCmdFactorEtat());
      var3.setExercicesAchats(var1.getExercicesAchats());
      var3.setTiers(var1.getTiers());
      var3.setUsers(var1.getUsers());
      var2.save(var3);
      return var3;
   }

   public long selectLastNum(Session var1) throws HibernateException, NamingException {
      boolean var2 = false;
      if (var1 == null) {
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var2 = true;
      }

      Query var3 = var1.createQuery("from CommandeEnteteAchats order by cmdId desc");
      long var4 = 1L;
      if (var3.list() != null) {
         var3.setMaxResults(1);
         List var6 = var3.list();
         if (var6.size() > 0) {
            CommandeEnteteAchats var7 = (CommandeEnteteAchats)var6.get(0);
            var4 = 1L + var7.getCmdId();
         }
      }

      if (var2) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public CommandeEnteteAchats enteteBySerieAnneeDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      Query var8 = var5.createQuery("from CommandeEnteteAchats where exercicesAchats.exeachId=:id and cmdSerie =:ser and year(cmdDate)=" + var7 + " order by cmdDate desc");
      var8.setParameter("id", var1);
      var8.setParameter("ser", var3);
      CommandeEnteteAchats var9 = null;
      if (var8.list() != null) {
         var8.setMaxResults(1);
         List var10 = var8.list();
         if (var10.size() > 0) {
            var9 = (CommandeEnteteAchats)var10.get(0);
         }
      }

      if (var6) {
         this.utilInitHibernate.closeSession();
      }

      return var9;
   }

   public CommandeEnteteAchats enteteBySerieMoisDate(long var1, String var3, Date var4, Session var5) throws HibernateException, NamingException {
      boolean var6 = false;
      if (var5 == null) {
         var5 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var6 = true;
      }

      int var7 = 1900 + var4.getYear();
      int var8 = var4.getMonth();
      Query var9 = var5.createQuery("from CommandeEnteteAchats where exercicesAchats.exeachId=:id and cmdSerie =:ser and year(cmdDate)=" + var7 + " and month(cmdDate)=" + var8 + " order by cmdDate desc");
      var9.setParameter("id", var1);
      var9.setParameter("ser", var3);
      CommandeEnteteAchats var10 = null;
      if (var9.list() != null) {
         var9.setMaxResults(1);
         List var11 = var9.list();
         if (var11.size() > 0) {
            var10 = (CommandeEnteteAchats)var11.get(0);
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
         var1 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var22 = true;
      }

      UtilDate var23 = new UtilDate();
      new ArrayList();
      Criteria var25 = var1.createCriteria(CommandeEnteteAchats.class);
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
            var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
         } else {
            var25 = var25.add(Restrictions.isNotNull("cmdDate"));
         }
      } else {
         if (!var11.equalsIgnoreCase("12") && !var11.equalsIgnoreCase("13") && !var11.equalsIgnoreCase("14")) {
            var25 = var25.add(Restrictions.eq("exercicesAchats.exeachId", var2));
         }

         if (var11.equalsIgnoreCase("0")) {
            var27 = var23.stringToDateSQL(var31 + " 00:00:00");
            var28 = var23.stringToDateSQL(var31 + " 23:59:59");
            var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
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
            var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
         } else {
            int var37;
            if (var11.equalsIgnoreCase("2")) {
               var37 = var26.get(2) + 1;
               var34 = var32 + "-" + var37 + "-01";
               var27 = var23.stringToDateSQL(var34 + " 00:00:00");
               var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
            } else {
               String var35;
               if (var11.equalsIgnoreCase("3")) {
                  var37 = var26.get(2);
                  var26.add(5, -var37);
                  if (var37 <= 3) {
                     var34 = var32 + "-01-01";
                     var27 = var23.stringToDateSQL(var34 + " 00:00:00");
                     var35 = var32 + "-03-31";
                     var28 = var23.stringToDateSQL(var35 + " 23:59:59");
                  } else if (var37 >= 4 && var37 <= 6) {
                     var34 = var32 + "-04-01";
                     var27 = var23.stringToDateSQL(var34 + " 00:00:00");
                     var35 = var32 + "-06-30";
                     var28 = var23.stringToDateSQL(var35 + " 23:59:59");
                  } else if (var37 >= 7 && var37 <= 9) {
                     var34 = var32 + "-07-01";
                     var27 = var23.stringToDateSQL(var34 + " 00:00:00");
                     var35 = var32 + "-09-30";
                     var28 = var23.stringToDateSQL(var35 + " 23:59:59");
                  } else if (var37 >= 10) {
                     var34 = var32 + "-10-01";
                     var27 = var23.stringToDateSQL(var34 + " 00:00:00");
                     var35 = var32 + "-12-31";
                     var28 = var23.stringToDateSQL(var35 + " 23:59:59");
                  }

                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("4")) {
                  var37 = var26.get(2);
                  var26.add(5, -var37);
                  if (var37 <= 6) {
                     var34 = var32 + "-01-01";
                     var27 = var23.stringToDateSQL(var34 + " 00:00:00");
                     var35 = var32 + "-06-30";
                     var28 = var23.stringToDateSQL(var35 + " 23:59:59");
                  } else {
                     var34 = var32 + "-07-01";
                     var27 = var23.stringToDateSQL(var34 + " 00:00:00");
                     var35 = var32 + "-12-31";
                     var28 = var23.stringToDateSQL(var35 + " 23:59:59");
                  }

                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("5")) {
                  var33 = var32 + "-01-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 + "-03-31";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("6")) {
                  var33 = var32 + "-04-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 + "-06-30";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("7")) {
                  var33 = var32 + "-07-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 + "-09-30";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("8")) {
                  var33 = var32 + "-10-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 + "-12-31";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("9")) {
                  var33 = var32 + "-01-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 + "-06-30";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("10")) {
                  var33 = var32 + "-07-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 + "-12-31";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("11")) {
                  var33 = var32 + "-01-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 + "-12-31";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("12")) {
                  var33 = "1980-01-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 - 1 + "-12-31";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("13")) {
                  var33 = var32 - 1 + "-01-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 + "-12-31";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("14")) {
                  var33 = var32 - 1 + "-01-01";
                  var27 = var23.stringToDateSQL(var33 + " 00:00:00");
                  var34 = var32 - 1 + "-12-31";
                  var28 = var23.stringToDateSQL(var34 + " 23:59:59");
                  var25 = var25.add(Restrictions.between("cmdDate", var27, var28));
               } else if (var11.equalsIgnoreCase("20")) {
                  var25.setMaxResults(20);
                  var25 = var25.addOrder(Order.desc("cmdId"));
               }
            }
         }
      }

      if (var4 != null && !var4.isEmpty()) {
         var33 = "%" + var4 + "%";
         var25 = var25.add(Restrictions.like("cmdNum", var33));
      }

      String[] var39;
      if (var5 != 0L) {
         var25 = var25.add(Restrictions.eq("tiers.tieid", var5));
      } else {
         if (var7 != null && !var7.isEmpty() && !var7.contains(":")) {
            var33 = "";
            if (var7.startsWith("*")) {
               var33 = "%" + var7.substring(1) + "%";
            } else {
               var33 = var7 + "%";
            }

            var25 = var25.add(Restrictions.or(Restrictions.like("cmdNomTiers", var33), Restrictions.like("cmdDiversNom", var33)));
         }

         if (var7 != null && !var7.isEmpty() && var7.contains(":")) {
            var39 = var7.split(":");
            long var40 = Long.parseLong(var39[0]);
            var25 = var25.add(Restrictions.eq("tiers.tieid", var40));
         }
      }

      if (var16 != null && !var16.isEmpty()) {
         var25 = var25.add(Restrictions.eq("cmdNomResponsable", var16));
      }

      if (var15 == 1) {
         var25 = var25.add(Restrictions.eq("cmdIdCreateur", var13));
      }

      if (!var9.equalsIgnoreCase("100")) {
         if (var9.contains(",")) {
            var39 = var9.split(",");
            int var41 = var39.length;
            String[] var38 = new String[var41];

            for(int var36 = 0; var36 < var41; ++var36) {
               var38[var36] = new String(var39[var36]);
            }

            var25 = var25.add(Restrictions.in("cmdSerie", var38));
         } else {
            var25 = var25.add(Restrictions.eq("cmdSerie", var9));
         }
      }

      if (!var10.equalsIgnoreCase("100")) {
         var25 = var25.add(Restrictions.eq("cmdCat", var10));
      }

      if (var8 <= 10) {
         var25 = var25.add(Restrictions.eq("cmdEtat", var8));
      } else if (var8 == 11) {
         var25 = var25.add(Restrictions.eq("cmdPriorite", 0));
      } else if (var8 == 12) {
         var25 = var25.add(Restrictions.eq("cmdPriorite", 1));
      } else if (var8 == 13) {
         var25 = var25.add(Restrictions.eq("cmdPriorite", 2));
      } else if (var8 == 14) {
         var25 = var25.add(Restrictions.eq("cmdPriorite", 3));
      } else if (var8 == 15) {
         var25 = var25.add(Restrictions.eq("cmdIntOut", 0));
      } else if (var8 == 16) {
         var25 = var25.add(Restrictions.eq("cmdIntOut", 1));
      } else if (var8 == 17) {
         var25 = var25.add(Restrictions.eq("cmdSolde", 0));
      } else if (var8 == 18) {
         var25 = var25.add(Restrictions.eq("cmdSolde", 1));
      }

      if (var12 != null && !var12.isEmpty() && !var12.equalsIgnoreCase("100") && var12.contains(":")) {
         var25 = var25.add(Restrictions.eq("cmdService", var12));
      }

      if (!var17.equalsIgnoreCase("100")) {
         var39 = var17.split(":");
         var34 = var39[0];
         var25 = var25.add(Restrictions.eq("cmdActivite", var34));
      }

      if (var18 != null && !var18.isEmpty()) {
         var33 = "%" + var18 + "%";
         var25 = var25.add(Restrictions.or(Restrictions.like("cmdAffaire", var33), Restrictions.like("cmdAnal4", var33)));
      }

      if (var19 != null && !var19.isEmpty()) {
         var33 = "%" + var19 + "%";
         var25 = var25.add(Restrictions.like("cmdAnal4", var33));
      }

      var25 = var25.addOrder(Order.desc("cmdDate"));
      var25 = var25.addOrder(Order.desc("cmdNum"));
      List var42 = var25.list();
      if (var22) {
         this.utilInitHibernate.closeSession();
      }

      return var42;
   }

   public CommandeEnteteAchats pourParapheur(long var1, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CommandeEnteteAchats where cmdId =:num").setParameter("num", var1).setMaxResults(1);
      List var6 = var5.list();
      new CommandeEnteteAchats();
      CommandeEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (CommandeEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CommandeEnteteAchats pourParapheur(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var4 = true;
      }

      Query var5 = var3.createQuery("from CommandeEnteteAchats where cmdNum=:num and cmdSerie=:ser").setString("num", var1).setString("ser", var2).setMaxResults(1);
      List var6 = var5.list();
      new CommandeEnteteAchats();
      CommandeEnteteAchats var7;
      if (var6.size() != 0) {
         var7 = (CommandeEnteteAchats)var6.get(0);
      } else {
         var7 = null;
      }

      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var7;
   }

   public CommandeEnteteAchats rechercheAnal4(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from CommandeEnteteAchats where cmdAnal4=:num").setString("num", var1).setMaxResults(1);
      List var5 = var4.list();
      new CommandeEnteteAchats();
      CommandeEnteteAchats var6;
      if (var5.size() != 0) {
         var6 = (CommandeEnteteAchats)var5.get(0);
      } else {
         var6 = null;
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheAPayer(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      new ArrayList();
      String var5 = "";
      Date var6 = new Date();
      UtilDate var7 = new UtilDate();
      var5 = var7.dateToStringSQLLight(var6);
      List var8 = null;
      if (!var1.equalsIgnoreCase("100")) {
         var8 = var2.createQuery("from CommandeEnteteAchats where cmdService='" + var1 + "' and (cmdDateEcheReg='" + var5 + "' or cmdTypeReg=4)").list();
      } else {
         var8 = var2.createQuery("from CommandeEnteteAchats where cmdDateEcheReg='" + var5 + "' or cmdTypeReg=4").list();
      }

      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var8;
   }

   public List rechercheByDossier(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from CommandeEnteteAchats where cmdAnal4 =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheByAffaire(String var1, String var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var4 = true;
      }

      new ArrayList();
      Query var6 = var3.createQuery("from CommandeEnteteAchats where cmdAffaire =:num and cmdAnal4 =:anal").setString("num", var1).setString("anal", var2);
      List var5 = var6.list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheByValo(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from CommandeEnteteAchats where cmdValo =:num").setString("num", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public List rechercheNonValoriser(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      new ArrayList();
      Query var5 = var2.createQuery("from CommandeEnteteAchats where  (cmdValo='' or cmdValo is NULL or cmdValo=:val)").setString("val", var1);
      List var4 = var5.list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var4;
   }

   public boolean verifUser(long var1) throws HibernateException, NamingException {
      Session var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
      Query var4 = var3.createQuery("from CommandeEnteteAchats where usr_id =:id").setLong("id", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      Query var4 = var2.createQuery("from CommandeEnteteAchats where tiers=:tie").setParameter("tie", var1).setMaxResults(1);
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
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from CommandeEnteteAchats where tiers=:tie").setParameter("tie", var1).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List rechercheCommandeRequete(String var1, Session var2) throws HibernateException, NamingException {
      boolean var3 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var3 = true;
      }

      new ArrayList();
      List var5 = null;
      var5 = var2.createQuery("from CommandeEnteteAchats where " + var1).list();
      if (var3) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }

   public List chargerEcrituresBudget(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from CommandeEnteteAchats where cmdBudgetProjet=:bud and cmdDate>=:debut and cmdDate<=:final and (cmdEtat=1 or cmdEtat=4 or cmdEtat=5) order by cmdNum").setString("bud", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List chargerEcrituresBudget(Date var1, Date var2, String var3, String var4, Session var5) throws HibernateException, NamingException {
      new ArrayList();
      Query var7 = var5.createQuery("from CommandeEnteteAchats where cmdBudgetProjet=:bud and cmdBudgetPoste=:pos and cmdDate>=:debut and cmdDate<=:final  and (cmdEtat=1 or cmdEtat=4 or cmdEtat=5) order by cmdNum").setString("bud", var3).setString("pos", var4).setDate("debut", var1).setDate("final", var2);
      List var6 = var7.list();
      return var6;
   }

   public List chargerEcrituresByCompte(Date var1, Date var2, String var3, Session var4) throws HibernateException, NamingException {
      new ArrayList();
      Query var6 = var4.createQuery("from CommandeEnteteAchats where cmdBudgetPoste=:cpte and cmdDate>=:debut and cmdDate<=:final and (cmdEtat=1 or cmdEtat=4 or cmdEtat=5) order by cmdNum").setString("cpte", var3).setDate("debut", var1).setDate("final", var2);
      List var5 = var6.list();
      return var5;
   }

   public List rechercheCommandeByDate(Date var1, Date var2, Session var3) throws HibernateException, NamingException {
      boolean var4 = false;
      if (var3 == null) {
         var3 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var4 = true;
      }

      new ArrayList();
      List var6 = null;
      var6 = var3.createQuery("from CommandeEnteteAchats where cmdDate>=:deb and cmdDate<=:fin").setDate("deb", var1).setDate("fin", var2).list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var6;
   }

   public List rechercheCommandeCampagne(String var1, Session var2) throws HibernateException, NamingException {
      new ArrayList();
      boolean var4 = false;
      if (var2 == null) {
         var2 = this.utilInitHibernate.getOpenSession(this.mabase, "CommandeEntete");
         var4 = true;
      }

      List var5 = var2.createQuery("from CommandeEnteteAchats where cmdSource like '" + var1 + "%'").list();
      if (var4) {
         this.utilInitHibernate.closeSession();
      }

      return var5;
   }
}
