package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.ExercicesComptableDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import groovyjarjarcommonscli.ParseException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FormChiffrementCesar implements Serializable {
   private int typeVente;
   private String urlExplorateur;
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private String affichePage;
   private UserDao userDao;
   private Date var_date_deb;
   private Date var_date_fin;
   private FormUtilitaires formUtilitaires;

   public FormChiffrementCesar(UtilInitHibernate var1, String var2, Structure var3, Users var4) {
      this.utilInitHibernate = var1;
      this.baseLog = var2;
      this.structureLog = var3;
      this.usersLog = var4;
   }

   public void codageTexte() throws HibernateException, NamingException, ParseException, java.text.ParseException {
      this.formUtilitaires.setVar_info("Chargement des tiers....");
      this.formUtilitaires.setVar_currentValue(0);
      UtilNombre var1 = new UtilNombre();
      UtilDate var2 = new UtilDate();
      this.var_date_deb = var2.datePremierJourAnnee(new Date());
      this.var_date_fin = var2.dateDernierJourAnnee(new Date());
      new ArrayList();
      new Tiers();
      TiersDao var5 = new TiersDao(this.baseLog, this.utilInitHibernate);
      List var3 = var5.chargerLesTiers("100", (Session)null);
      if (var3.size() != 0) {
         Session var6 = this.utilInitHibernate.getOpenSession(this.baseLog, "tiers");
         Transaction var7 = null;

         try {
            var7 = var6.beginTransaction();

            for(int var8 = 0; var8 < var3.size(); ++var8) {
               Tiers var4 = (Tiers)var3.get(var8);
               String var9 = "Tiers " + var4.getTieraisonsocialenom() + " Numero " + var8 + ", pour un total de " + var3.size() + " total ";
               this.formUtilitaires.setVar_info(var9);
               if (var8 != 0) {
                  double var10 = (double)var3.size();
                  double var12 = var1.myRound(var10 / (double)var8, 4);
                  double var14 = var1.myRound(100.0D / var12, 2);
                  this.formUtilitaires.setVar_currentValue((int)var14);
               }

               var4.setTieraisonsocialenom(this.chiffrementCesar(var4.getTieraisonsocialenom()));
               var5.modif(var4, var6);
            }

            var7.commit();
         } catch (HibernateException var363) {
            if (var7 != null) {
               var7.rollback();
            }

            throw var363;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new Contacts();
      ContactDao var367 = new ContactDao(this.baseLog, this.utilInitHibernate);
      List var365 = var367.chargerLesContacts((Session)null);
      if (var365.size() != 0) {
         Session var368 = this.utilInitHibernate.getOpenSession(this.baseLog, "tiers");
         Transaction var370 = null;

         try {
            var370 = var368.beginTransaction();

            for(int var11 = 0; var11 < var365.size(); ++var11) {
               Contacts var366 = (Contacts)var365.get(var11);
               String var373 = "Contact " + var366.getConpatronyme() + " Numero " + var11 + ", pour un total de " + var365.size() + " total ";
               this.formUtilitaires.setVar_info(var373);
               if (var11 != 0) {
                  double var13 = (double)var365.size();
                  double var15 = var1.myRound(var13 / (double)var11, 4);
                  double var17 = var1.myRound(100.0D / var15, 2);
                  this.formUtilitaires.setVar_currentValue((int)var17);
               }

               var366.setConpatronyme(this.chiffrementCesar(var366.getConpatronyme()));
               var366.setConprenom(this.chiffrementCesar(var366.getConprenom()));
               var366.setConnom(this.chiffrementCesar(var366.getConnom()));
               var366.setConcel1("");
               var366.setConcel2("");
               var366.setConcel3("");
               var366.setContelbur("");
               var366.setConteldom("");
               var366.setConmail1("");
               var366.setConmail2("");
               var366.setConmail3("");
               var366.setConmail4("");
               var366.setConmail5("");
               var367.modif(var366, var368);
            }

            var370.commit();
         } catch (HibernateException var361) {
            if (var370 != null) {
               var370.rollback();
            }

            throw var361;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new PlansAnalytiques();
      PlansAnalytiquesDao var372 = new PlansAnalytiquesDao(this.baseLog, this.utilInitHibernate);
      List var369 = var372.chargerLesPlansAnalytiques("7", (Session)null);
      if (var369.size() != 0) {
         Session var374 = this.utilInitHibernate.getOpenSession(this.baseLog, "Analytique");
         Transaction var376 = null;

         try {
            var376 = var374.beginTransaction();

            for(int var378 = 0; var378 < var369.size(); ++var378) {
               PlansAnalytiques var371 = (PlansAnalytiques)var369.get(var378);
               String var380 = "Destinataire " + var371.getAnaNomFr() + " Numero " + var378 + ", pour un total de " + var369.size() + " total ";
               this.formUtilitaires.setVar_info(var380);
               if (var378 != 0) {
                  double var16 = (double)var369.size();
                  double var18 = var1.myRound(var16 / (double)var378, 4);
                  double var20 = var1.myRound(100.0D / var18, 2);
                  this.formUtilitaires.setVar_currentValue((int)var20);
               }

               var371.setAnaNomFr(this.chiffrementCesar(var371.getAnaNomFr()));
               var372.modif(var371, var374);
            }

            var376.commit();
         } catch (HibernateException var359) {
            if (var376 != null) {
               var376.rollback();
            }

            throw var359;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new Salaries();
      SalariesDao var379 = new SalariesDao(this.baseLog, this.utilInitHibernate);
      List var375 = var379.chargerlesSalariesActif("*", (Session)null);
      double var21;
      double var23;
      String var388;
      if (var375.size() != 0) {
         Session var381 = this.utilInitHibernate.getOpenSession(this.baseLog, "salarie");
         Transaction var383 = null;

         try {
            var383 = var381.beginTransaction();

            for(int var385 = 0; var385 < var375.size(); ++var385) {
               Salaries var377 = (Salaries)var375.get(var385);
               var388 = "Salaries " + var377.getPatronyme() + " Numero " + var385 + ", pour un total de " + var375.size() + " total ";
               this.formUtilitaires.setVar_info(var388);
               if (var385 != 0) {
                  double var19 = (double)var375.size();
                  var21 = var1.myRound(var19 / (double)var385, 4);
                  var23 = var1.myRound(100.0D / var21, 2);
                  this.formUtilitaires.setVar_currentValue((int)var23);
               }

               var377.setSalNom(this.chiffrementCesar(var377.getSalNom()));
               var377.setSalNomJf(this.chiffrementCesar(var377.getSalNomJf()));
               var377.setSalPrenom(this.chiffrementCesar(var377.getSalPrenom()));
               var377.setSalMail1("");
               var377.setSalCel1("");
               var377.setSalCel2("");
               var377.setSalCel3("");
               var377.setSalTelBur("");
               var377.setSalTelDom("");
               var379.modif(var377, var381);
            }

            var383.commit();
         } catch (HibernateException var357) {
            if (var383 != null) {
               var383.rollback();
            }

            throw var357;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new Users();
      this.userDao = new UserDao(this.baseLog, this.utilInitHibernate);
      List var382 = this.userDao.chargerLesUsers((Session)null);
      if (var382.size() != 0) {
         Session var386 = this.utilInitHibernate.getOpenSession(this.baseLog, "");
         var388 = null;

         try {
            Transaction var389 = var386.beginTransaction();

            for(int var390 = 0; var390 < var382.size(); ++var390) {
               Users var384 = (Users)var382.get(var390);
               String var393 = "Users " + var384.getUsrPatronyme() + " Numero " + var390 + ", pour un total de " + var382.size() + " total ";
               this.formUtilitaires.setVar_info(var393);
               if (var390 != 0) {
                  var21 = (double)var382.size();
                  var23 = var1.myRound(var21 / (double)var390, 4);
                  double var25 = var1.myRound(100.0D / var23, 2);
                  this.formUtilitaires.setVar_currentValue((int)var25);
               }

               var384.setUsrNom(this.chiffrementCesar(var384.getUsrNom()));
               var384.setUsrPrenom(this.chiffrementCesar(var384.getUsrPrenom()));
               var384.setUsrPatronyme(this.chiffrementCesar(var384.getUsrPatronyme()));
               var384.setUsrCel1("");
               var384.setUsrCel2("");
               var384.setUsrCel3("");
               var384.setUsrTelBureau("");
               var384.setUsrTelDomicile("");
               var384.setUsrYahoo("");
               var384.setUsrAol("");
               var384.setUsrMail("");
               var384.setUsrMsn("");
               this.userDao.modUser(var384, var386);
            }

            var389.commit();
         } catch (HibernateException var355) {
            if (var388 != null) {
               var388.rollback();
            }

            throw var355;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new PlanComptable();
      PlanComptableDao var392 = new PlanComptableDao(this.baseLog, this.utilInitHibernate);
      new ExercicesComptable();
      ExercicesComptableDao var395 = new ExercicesComptableDao(this.baseLog, this.utilInitHibernate);
      ExercicesComptable var394 = var395.recupererLastExo((Session)null);
      String var26;
      double var29;
      double var31;
      if (var394 != null) {
         String var22 = this.structureLog.getStrzonefiscale();
         List var387 = var392.chargerLesPlcComptables(var22, var394.getExecpt_id(), (String)null, (Session)null);
         if (var387.size() != 0) {
            Session var397 = this.utilInitHibernate.getOpenSession(this.baseLog, "PlanComptable");
            Transaction var24 = null;

            try {
               var24 = var397.beginTransaction();

               for(int var400 = 0; var400 < var387.size(); ++var400) {
                  PlanComptable var391 = (PlanComptable)var387.get(var400);
                  var26 = "Compte " + var391.getPlcLibelleCpteFR() + " Numero " + var400 + ", pour un total de " + var387.size() + " total ";
                  this.formUtilitaires.setVar_info(var26);
                  if (var400 != 0) {
                     double var27 = (double)var387.size();
                     var29 = var1.myRound(var27 / (double)var400, 4);
                     var31 = var1.myRound(100.0D / var29, 2);
                     this.formUtilitaires.setVar_currentValue((int)var31);
                  }

                  var391.setPlcLibelleCpteFR(this.chiffrementCesar(var391.getPlcLibelleCpteFR()));
                  var392.modif(var391, var397);
               }

               var24.commit();
            } catch (HibernateException var353) {
               if (var24 != null) {
                  var24.rollback();
               }

               throw var353;
            } finally {
               this.utilInitHibernate.closeSession();
            }
         }
      }

      new ArrayList();
      new DevisEnteteVentes();
      DevisEnteteVentesDao var399 = new DevisEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      List var396 = var399.rechercheDevisByDate(this.var_date_deb, this.var_date_fin, (Session)null);
      if (var396.size() != 0) {
         Session var401 = this.utilInitHibernate.getOpenSession(this.baseLog, "DevisEntete");
         var26 = null;

         try {
            Transaction var403 = var401.beginTransaction();

            for(int var405 = 0; var405 < var396.size(); ++var405) {
               DevisEnteteVentes var398 = (DevisEnteteVentes)var396.get(var405);
               String var28 = "Devis " + var398.getDvsNum() + " Numero " + var405 + ", pour un total de " + var396.size() + " total ";
               this.formUtilitaires.setVar_info(var28);
               if (var405 != 0) {
                  var29 = (double)var396.size();
                  var31 = var1.myRound(var29 / (double)var405, 4);
                  double var33 = var1.myRound(100.0D / var31, 2);
                  this.formUtilitaires.setVar_currentValue((int)var33);
               }

               var398.setDvsNomTiers(this.chiffrementCesar(var398.getDvsNomTiers()));
               var398.setDvsNomContact(this.chiffrementCesar(var398.getDvsNomContact()));
               var398.setDvsNomCommercial(this.chiffrementCesar(var398.getDvsNomCommercial()));
               var398.setDvsNomResponsable(this.chiffrementCesar(var398.getDvsNomResponsable()));
               var399.modif(var398, var401);
            }

            var403.commit();
         } catch (HibernateException var351) {
            if (var26 != null) {
               var26.rollback();
            }

            throw var351;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new CommandeEnteteVentes();
      CommandeEnteteVentesDao var406 = new CommandeEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      this.var_date_fin = var2.dateDernierJourAnnee(new Date());
      List var402 = var406.rechercheCommandeByDate(this.var_date_deb, this.var_date_fin, (Session)null);
      if (var402.size() != 0) {
         Session var407 = this.utilInitHibernate.getOpenSession(this.baseLog, "BcommandeEntete");
         Transaction var409 = null;

         try {
            var409 = var407.beginTransaction();

            for(int var30 = 0; var30 < var402.size(); ++var30) {
               CommandeEnteteVentes var404 = (CommandeEnteteVentes)var402.get(var30);
               String var412 = "Commande " + var404.getBcmNum() + " Numero " + var30 + ", pour un total de " + var402.size() + " total ";
               this.formUtilitaires.setVar_info(var412);
               if (var30 != 0) {
                  double var32 = (double)var402.size();
                  double var34 = var1.myRound(var32 / (double)var30, 4);
                  double var36 = var1.myRound(100.0D / var34, 2);
                  this.formUtilitaires.setVar_currentValue((int)var36);
               }

               var404.setBcmNomTiers(this.chiffrementCesar(var404.getBcmNomTiers()));
               var404.setBcmNomContact(this.chiffrementCesar(var404.getBcmNomContact()));
               var404.setBcmNomCommercial(this.chiffrementCesar(var404.getBcmNomCommercial()));
               var404.setBcmNomResponsable(this.chiffrementCesar(var404.getBcmNomResponsable()));
               var406.modif(var404, var407);
            }

            var409.commit();
         } catch (HibernateException var349) {
            if (var409 != null) {
               var409.rollback();
            }

            throw var349;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new LivraisonEnteteVentes();
      LivraisonEnteteVentesDao var411 = new LivraisonEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      List var408 = var411.rechercheLivraisonByDate(this.var_date_deb, this.var_date_fin, (Session)null);
      if (var408.size() != 0) {
         Session var413 = this.utilInitHibernate.getOpenSession(this.baseLog, "BlivraisonEntete");
         Transaction var414 = null;

         try {
            var414 = var413.beginTransaction();

            for(int var417 = 0; var417 < var408.size(); ++var417) {
               LivraisonEnteteVentes var410 = (LivraisonEnteteVentes)var408.get(var417);
               String var419 = "Livraison " + var410.getBlvNum() + " Numero " + var417 + ", pour un total de " + var408.size() + " total ";
               this.formUtilitaires.setVar_info(var419);
               if (var417 != 0) {
                  double var35 = (double)var408.size();
                  double var37 = var1.myRound(var35 / (double)var417, 4);
                  double var39 = var1.myRound(100.0D / var37, 2);
                  this.formUtilitaires.setVar_currentValue((int)var39);
               }

               var410.setBlvNomTiers(this.chiffrementCesar(var410.getBlvNomTiers()));
               var410.setBlvNomContact(this.chiffrementCesar(var410.getBlvNomContact()));
               var410.setBlvNomCommercial(this.chiffrementCesar(var410.getBlvNomCommercial()));
               var410.setBlvNomResponsable(this.chiffrementCesar(var410.getBlvNomResponsable()));
               var411.modif(var410, var413);
            }

            var414.commit();
         } catch (HibernateException var347) {
            if (var414 != null) {
               var414.rollback();
            }

            throw var347;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new RetourEnteteVentes();
      RetourEnteteVentesDao var418 = new RetourEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      List var415 = var418.rechercheRetourByDate(this.var_date_deb, this.var_date_fin, (Session)null);
      String var426;
      if (var415.size() != 0) {
         Session var420 = this.utilInitHibernate.getOpenSession(this.baseLog, "BretourEntete");
         Transaction var422 = null;

         try {
            var422 = var420.beginTransaction();

            for(int var424 = 0; var424 < var415.size(); ++var424) {
               RetourEnteteVentes var416 = (RetourEnteteVentes)var415.get(var424);
               var426 = "Retour " + var416.getBrtNum() + " Numero " + var424 + ", pour un total de " + var415.size() + " total ";
               this.formUtilitaires.setVar_info(var426);
               if (var424 != 0) {
                  double var38 = (double)var415.size();
                  double var40 = var1.myRound(var38 / (double)var424, 4);
                  double var42 = var1.myRound(100.0D / var40, 2);
                  this.formUtilitaires.setVar_currentValue((int)var42);
               }

               var416.setBrtNomTiers(this.chiffrementCesar(var416.getBrtNomTiers()));
               var416.setBrtNomContact(this.chiffrementCesar(var416.getBrtNomContact()));
               var416.setBrtNomCommercial(this.chiffrementCesar(var416.getBrtNomCommercial()));
               var416.setBrtNomResponsable(this.chiffrementCesar(var416.getBrtNomResponsable()));
               var418.modif(var416, var420);
            }

            var422.commit();
         } catch (HibernateException var345) {
            if (var422 != null) {
               var422.rollback();
            }

            throw var345;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new FactureEnteteVentes();
      FactureEnteteVentesDao var425 = new FactureEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      var426 = var2.dateToStringSQLLight(this.var_date_deb) + " 00:00:00";
      String var427 = var2.dateToStringSQLLight(this.var_date_fin) + " 23:59:59";
      List var421 = var425.rechercheFactureByDate(var426, var427, (Session)null);
      if (var421.size() != 0) {
         Session var428 = this.utilInitHibernate.getOpenSession(this.baseLog, "BfactureEntete");
         Transaction var430 = null;

         try {
            var430 = var428.beginTransaction();

            for(int var41 = 0; var41 < var421.size(); ++var41) {
               FactureEnteteVentes var423 = (FactureEnteteVentes)var421.get(var41);
               String var433 = "Facture " + var423.getFacNum() + " Numero " + var41 + ", pour un total de " + var421.size() + " total ";
               this.formUtilitaires.setVar_info(var433);
               if (var41 != 0) {
                  double var43 = (double)var421.size();
                  double var45 = var1.myRound(var43 / (double)var41, 4);
                  double var47 = var1.myRound(100.0D / var45, 2);
                  this.formUtilitaires.setVar_currentValue((int)var47);
               }

               var423.setFacNomTiers(this.chiffrementCesar(var423.getFacNomTiers()));
               var423.setFacNomContact(this.chiffrementCesar(var423.getFacNomContact()));
               var423.setFacNomCommercial(this.chiffrementCesar(var423.getFacNomCommercial()));
               var423.setFacNomResponsable(this.chiffrementCesar(var423.getFacNomResponsable()));
               var425.modif(var423, var428);
            }

            var430.commit();
         } catch (HibernateException var343) {
            if (var430 != null) {
               var430.rollback();
            }

            throw var343;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

      new ArrayList();
      new NoteDebitEnteteVentes();
      NoteDebitEnteteVentesDao var432 = new NoteDebitEnteteVentesDao(this.baseLog, this.utilInitHibernate);
      List var429 = var432.rechercheNoteDebitByDate(this.var_date_deb, this.var_date_fin, (Session)null);
      if (var429.size() != 0) {
         Session var434 = this.utilInitHibernate.getOpenSession(this.baseLog, "BnoteDebitEntete");
         Transaction var435 = null;

         try {
            var435 = var434.beginTransaction();

            for(int var44 = 0; var44 < var429.size(); ++var44) {
               NoteDebitEnteteVentes var431 = (NoteDebitEnteteVentes)var429.get(var44);
               String var436 = "Note debit " + var431.getNdbNum() + " Numero " + var44 + ", pour un total de " + var429.size() + " total ";
               this.formUtilitaires.setVar_info(var436);
               if (var44 != 0) {
                  double var46 = (double)var429.size();
                  double var48 = var1.myRound(var46 / (double)var44, 4);
                  double var50 = var1.myRound(100.0D / var48, 2);
                  this.formUtilitaires.setVar_currentValue((int)var50);
               }

               var431.setNdbNomTiers(this.chiffrementCesar(var431.getNdbNomTiers()));
               var431.setNdbNomContact(this.chiffrementCesar(var431.getNdbNomContact()));
               var431.setNdbNomCommercial(this.chiffrementCesar(var431.getNdbNomCommercial()));
               var431.setNdbNomResponsable(this.chiffrementCesar(var431.getNdbNomResponsable()));
               var432.modif(var431, var434);
            }

            var435.commit();
         } catch (HibernateException var341) {
            if (var435 != null) {
               var435.rollback();
            }

            throw var341;
         } finally {
            this.utilInitHibernate.closeSession();
         }
      }

   }

   public String chiffrementCesar(String var1) {
      String var2 = "";
      if (var1 != null && !var1.isEmpty()) {
         var1 = var1.toUpperCase();
         String var3 = "";

         for(int var4 = 0; var4 < var1.length(); ++var4) {
            var3 = (String)var1.subSequence(var4, var4 + 1);
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ ".contains(var3)) {
               if (var3.equals("A")) {
                  var3 = "D";
               } else if (var3.equals("B")) {
                  var3 = "E";
               } else if (var3.equals("C")) {
                  var3 = "F";
               } else if (var3.equals("D")) {
                  var3 = "G";
               } else if (var3.equals("E")) {
                  var3 = "H";
               } else if (var3.equals("F")) {
                  var3 = "I";
               } else if (var3.equals("G")) {
                  var3 = "J";
               } else if (var3.equals("H")) {
                  var3 = "K";
               } else if (var3.equals("I")) {
                  var3 = "L";
               } else if (var3.equals("J")) {
                  var3 = "M";
               } else if (var3.equals("K")) {
                  var3 = "N";
               } else if (var3.equals("L")) {
                  var3 = "O";
               } else if (var3.equals("M")) {
                  var3 = "P";
               } else if (var3.equals("N")) {
                  var3 = "Q";
               } else if (var3.equals("O")) {
                  var3 = "R";
               } else if (var3.equals("P")) {
                  var3 = "S";
               } else if (var3.equals("Q")) {
                  var3 = "T";
               } else if (var3.equals("R")) {
                  var3 = "U";
               } else if (var3.equals("S")) {
                  var3 = "V";
               } else if (var3.equals("T")) {
                  var3 = "W";
               } else if (var3.equals("U")) {
                  var3 = "X";
               } else if (var3.equals("V")) {
                  var3 = "Y";
               } else if (var3.equals("W")) {
                  var3 = "Z";
               } else if (var3.equals("X")) {
                  var3 = "A";
               } else if (var3.equals("Y")) {
                  var3 = "B";
               } else if (var3.equals("Z")) {
                  var3 = "C";
               } else if (var3.equals(" ")) {
                  var3 = " ";
               }

               var2 = var2 + var3;
            }
         }
      }

      return var2;
   }

   public FormUtilitaires getFormUtilitaires() {
      return this.formUtilitaires;
   }

   public void setFormUtilitaires(FormUtilitaires var1) {
      this.formUtilitaires = var1;
   }
}
