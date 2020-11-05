package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.Activites;
import com.epegase.systeme.classe.AmortissementTab;
import com.epegase.systeme.classe.Amortissements;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.ExercicesComptable;
import com.epegase.systeme.classe.JournauxJour;
import com.epegase.systeme.classe.JournauxMois;
import com.epegase.systeme.classe.PlanComptable;
import com.epegase.systeme.classe.Racines;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.AmortissementTabDao;
import com.epegase.systeme.dao.AmortissementsDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.JournauxJourDao;
import com.epegase.systeme.dao.JournauxMoisDao;
import com.epegase.systeme.dao.PlanComptableDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilMail;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.util.UtilTrie;
import com.epegase.systeme.xml.LectureNatureCompte;
import com.epegase.systeme.xml.LireLesoptionsCompta;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionComptabilite;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Utilitaires_Compta implements Serializable {
   FormUtilitaires formUtilitaires;

   public Utilitaires_Compta(FormUtilitaires var1) {
      this.formUtilitaires = var1;
   }

   public void effaceSemaphores(List var1, JournauxMois var2, JournauxMoisDao var3, List var4, JournauxJour var5, JournauxJourDao var6, String var7, Session var8) throws HibernateException, NamingException {
      var1 = var3.listeJouMemAnnee(var8);
      int var9;
      if (var1.size() != 0) {
         for(var9 = 0; var9 < var1.size(); ++var9) {
            new JournauxMois();
            var2 = (JournauxMois)var1.get(var9);
            if (var2.getJoumenOpenJournal() != 0 || var2.getJoumenUserIdJournal() != 0L) {
               var2.setJoumenOpenJournal(0);
               var2.setJoumenOpenUserJournal("");
               var2.setJoumenUserIdJournal(0L);
               var3.majJournal(var2, var8);
            }
         }
      }

      var4 = var6.listeJouJrAnnee(var8);
      if (var4.size() != 0) {
         for(var9 = 0; var9 < var4.size(); ++var9) {
            new JournauxJour();
            var5 = (JournauxJour)var4.get(var9);
            if (var5.getJoujrOpenJournal() != 0 || var5.getJoujrUserIdJournal() != 0L) {
               var5.setJoujrOpenJournal(0);
               var5.setJoujrOpenUserJournal("");
               var5.setJoujrUserIdJournal(0L);
               var6.majJournal(var5, var8);
            }
         }
      }

   }

   public void genePlanComptableTiers(List var1, List var2, Racines var3, PlanComptable var4, PlanComptableDao var5, Structure var6, Users var7, ExercicesComptable var8, TiersDao var9, Session var10) throws NamingException, HibernateException, IOException {
      new OptionComptabilite();
      LireLesoptionsCompta var12 = new LireLesoptionsCompta(var6);
      var12.setStrId(var6.getStrid());
      var12.lancer();
      OptionComptabilite var11 = var12.getOptionComptabilite();
      int var13 = Integer.parseInt(var11.getCalculCompte());
      int var14 = Integer.parseInt(var11.getNbcr());
      new ArrayList();
      LectureNatureCompte var16 = new LectureNatureCompte();
      List var15 = var16.getMesNatureCompte();
      String var17 = "";
      if (var6.getStrzonefiscale2() != null && !var6.getStrzonefiscale2().isEmpty()) {
         var17 = var6.getStrzonefiscale2();
      } else {
         var17 = var6.getStrzonefiscale();
      }

      new Tiers();

      for(int var19 = 0; var19 < var1.size(); ++var19) {
         Tiers var18 = (Tiers)var1.get(var19);
         String var20;
         if (var18.getTiecompte0() == null || var18.getTiecompte0().isEmpty()) {
            var20 = "";
            int var21 = 0;
            String var22 = "";
            if (var18.getTietype().equals("0")) {
               var22 = "4011";
            } else if (var18.getTietype().equals("3")) {
               var22 = "4111";
            } else {
               var22 = "";
            }

            if (var22 != null && !var22.isEmpty()) {
               if (var13 == 0) {
                  var21 = var5.calculeNbCompte(var17, var22, var8.getExecpt_id(), var10) + 1;
               } else if (var13 == 1) {
                  new ArrayList();
                  List var23 = var5.chargeNumCpte(var17, var22, var8.getExecpt_id(), 0, (String)null, var10);
                  if (var23.size() != 0) {
                     int var24 = var23.size() - 1;
                     String var25 = ((PlanComptable)var23.get(var24)).getPlcCompte();
                     var20 = var25.substring(var22.length(), var14);
                     if (this.estUnEntier(var20)) {
                        var21 = Integer.parseInt(var20) + 1;
                     } else {
                        var21 = var5.calculeNbCompte(var17, var22, var8.getExecpt_id(), var10) + 1;
                     }
                  }
               }

               if (var21 != 0) {
                  var20 = "" + var21;
                  String var27 = this.getComplementutil(var20, var22, var14);
                  var18.setTiecompte0(var27);
                  var18 = var9.modif(var18, var10);
                  var10.flush();
               }
            }
         }

         if (var18.getTiecompte0() != null && !var18.getTiecompte0().isEmpty()) {
            var4 = var5.chercherCompte((String)null, var18.getTiecompte0(), var8.getExecpt_id(), var10);
            if (var4 == null) {
               var3 = this.rechercheRacine(var18.getTiecompte0(), var2);
               if (var3 != null) {
                  var4 = new PlanComptable();
                  var4.setPlcCodeRacine(var3.getRacCode());
                  var4.setPlcCompte(var18.getTiecompte0());
                  var4.setPlcDateCreat(new Date());
                  var4.setPlcFiscalite(var3.getRacFiscalite());
                  var4.setPlcLibelleCpteFR(var18.getTieraisonsocialenom());
                  var4.setPlcLibelleCpteSP(var18.getTieraisonsocialenom());
                  var4.setPlcLibelleCpteUK(var18.getTieraisonsocialenom());
                  var4.setPlcLibelleNatureFR((String)null);
                  var4.setPlcLibelleNatureSP((String)null);
                  var4.setPlcLibelleNatureUK((String)null);

                  for(int var26 = 0; var26 < var15.size(); ++var26) {
                     if (((ObjetCompte)var15.get(var26)).getCode().equals(var3.getRacCodenature())) {
                        var4.setPlcLibelleNatureFR(((ObjetCompte)var15.get(var26)).getNom_FR());
                        var4.setPlcLibelleNatureSP(((ObjetCompte)var15.get(var26)).getNom_SP());
                        var4.setPlcLibelleNatureUK(((ObjetCompte)var15.get(var26)).getNom_UK());
                        break;
                     }
                  }

                  var4.setPlcLibelleRacineFR(var3.getRacLibelleFr());
                  var4.setPlcLibelleRacineSP(var3.getRacLibelleSp());
                  var4.setPlcLibelleRacineUK(var3.getRacLibelleUk());
                  var20 = var18.getTiecompte0().replace(var3.getRacCode(), "");
                  var4.setPlcLibre(var20);
                  var4.setPlcNature(Integer.parseInt(var3.getRacCodenature()));
                  var4.setPlcRanDetaille(true);
                  if (var4.getPlcNature() == 6) {
                     var4.setPlcSens(1);
                  } else if (var4.getPlcNature() == 7) {
                     var4.setPlcSens(0);
                  } else {
                     var4.setPlcSens(0);
                  }

                  var4.setPlcTauxTaxe(var3.getRactaux());
                  var4.setPlcUserCreat(var7.getUsrid());
                  var4.setExercicesComptable(var8);
                  var5.insert(var4, var10);
                  var10.flush();
               }
            }
         }
      }

   }

   public boolean estUnEntier(String var1) {
      try {
         Integer.parseInt(var1);
         return true;
      } catch (NumberFormatException var3) {
         return false;
      }
   }

   public String getComplementutil(String var1, String var2, int var3) {
      String var4 = var2.concat(var1);
      int var5 = var3 - var4.length();
      String var6 = "";
      String[] var7 = new String[var5];

      for(int var8 = 0; var8 < var5; ++var8) {
         var7[var8] = "0";
         var6 = var6 + var7[var8];
      }

      var6 = var2 + var6 + var1;
      return var6;
   }

   public Racines rechercheRacine(String var1, List var2) {
      new Racines();
      Racines var3 = null;

      for(int var4 = var2.size(); var4 != 0; --var4) {
         if (((Racines)var2.get(var4 - 1)).getRacCode() != null && !((Racines)var2.get(var4 - 1)).getRacCode().isEmpty() && var1.startsWith(((Racines)var2.get(var4 - 1)).getRacCode())) {
            var3 = (Racines)var2.get(var4 - 1);
            break;
         }
      }

      return var3;
   }

   public void calculTableauDotation(UtilNombre var1, AmortissementTabDao var2, Amortissements var3, List var4, UtilDate var5, AmortissementTab var6, OptionComptabilite var7, Structure var8, Session var9) throws HibernateException, NamingException, ParseException, groovyjarjarcommonscli.ParseException {
      if (var3 != null && var3.getAmoTauxComptable() != 0.0F && var3.getAmoNature() != 3 && var3.getAmoDateAchat() != null) {
         var4.clear();
         var4 = var2.chargeTableau(var3, var9);
         if (var3.getAmoNbAnneeCpte() == 0.0F) {
            float var10 = var3.getAmoTauxComptable();
            if (var10 > 0.0F && var10 <= 100.0F) {
               float var11 = 100.0F / var10;
               var3.setAmoNbAnneeCpte(var11);
            } else if (var10 == 0.0F) {
               var3.setAmoNbAnneeCpte(0.0F);
            }
         }

         if (var3.getAmoTauxComptable() > 100.0F) {
            var3.setAmoTauxComptable(100.0F);
         }

         if (var4.size() == 0) {
            AmortissementTab var26;
            if (var4.size() != 0) {
               new AmortissementTab();

               for(int var28 = 0; var28 < var4.size(); ++var28) {
                  var26 = (AmortissementTab)var4.get(var28);
                  if (var26.getAmotabDateTrf() == null) {
                     var2.delete(var26, var9);
                  }
               }

               var9.flush();
               var4 = var2.chargeTableau(var3, var9);
            }

            var26 = null;
            Date var27;
            if (var3.getAmoDateService() != null) {
               var27 = var3.getAmoDateService();
               if (var27.getYear() + 1900 < 1950) {
                  var27 = var3.getAmoDateAchat();
               }
            } else {
               var27 = var3.getAmoDateAchat();
            }

            if (var27.getYear() + 1900 < 1950) {
               var27 = null;
            }

            if (var27 != null) {
               double var29 = 0.0D;
               if (var7.getCalculImmobilisation().equals("1")) {
                  var29 = var3.getAmoValeurAchat() * (double)(var3.getAmoTauxComptable() / 100.0F) / 360.0D;
               } else {
                  var29 = var3.getAmoValeurAchat() * (double)(var3.getAmoTauxComptable() / 100.0F) / 365.0D;
               }

               Date var13 = var27;
               Date var14 = null;
               double var15 = var3.getAmoValeurAchat();
               double var17 = 0.0D;
               boolean var19 = false;
               boolean var20 = false;

               int var30;
               for(int var21 = 0; var15 > 0.0D; ++var21) {
                  if (var7.getCalculImmobilisation().equals("1")) {
                     if (!var20) {
                        var30 = 30;
                        if (var13.getDate() != 1) {
                           var30 = var30 - var13.getDate() - 1;
                        }
                     } else {
                        var30 = 30;
                     }
                  } else if (!var20) {
                     var30 = var5.dateNbJourMois(var13);
                     if (var13.getDate() != 1) {
                        var30 = var30 - var13.getDate() - 1;
                     }
                  } else {
                     var30 = var5.dateNbJourMois(var13);
                  }

                  if (var30 >= 1) {
                     var17 = var1.myRoundDevise(var29 * (double)var30, var8.getStrdevise());
                     if (var15 <= var17) {
                        double var22 = 0.0D;

                        for(int var24 = 0; var24 < var4.size(); ++var24) {
                           var22 += ((AmortissementTab)var4.get(var24)).getAmotabMontant();
                        }

                        var17 = var3.getAmoValeurAchat() - var22;
                        var15 = 0.0D;
                     } else {
                        var15 -= var17;
                     }

                     var6 = new AmortissementTab();
                     var6.setAmotabId(0L);
                     var6.setAmortissements(var3);
                     if (!var20) {
                        var6.setAmotabDateDeb(var27);
                     } else {
                        var6.setAmotabDateDeb(var5.datePremierJourMois(var13));
                     }

                     var6.setAmotabDateFin(var5.dateDernierJourMois(var13));
                     var6.setAmotabMontant(var17);
                     var6.setAmotabVnc(var15);
                     var20 = true;
                     boolean var32 = false;

                     for(int var23 = 0; var23 < var4.size(); ++var23) {
                        if (var6.getAmotabDateDeb().compareTo(((AmortissementTab)var4.get(var23)).getAmotabDateDeb()) == 0 && var6.getAmotabDateFin().compareTo(((AmortissementTab)var4.get(var23)).getAmotabDateFin()) == 0) {
                           var32 = true;
                           break;
                        }
                     }

                     if (!var32) {
                        var4.add(var6);
                     }
                  }

                  var13 = var5.dateMoisSuivant(var13);
               }

               UtilTrie var31 = new UtilTrie();
               var4 = var31.triListeAmortissementDate(var4);
               if (var3.getAmoDateAnterieur() != null && var3.getAmoAnterieur() != 0.0D) {
                  var14 = var3.getAmoDateAnterieur();
                  var15 = var3.getAmoValeurAchat() - var3.getAmoAnterieur();
                  int var33 = 0;

                  label157:
                  while(true) {
                     if (var33 >= var4.size()) {
                        var30 = 0;

                        for(var33 = 0; var33 < var4.size(); ++var33) {
                           var6 = (AmortissementTab)var4.get(var33);
                           if (var6.getAmotabDateFin().compareTo(var14) > 0) {
                              if (var7.getCalculImmobilisation().equals("1")) {
                                 var30 += 30;
                              } else {
                                 var30 += var5.dateNbJourMois(var6.getAmotabDateDeb());
                              }
                           }
                        }

                        var29 = (var3.getAmoValeurAchat() - var3.getAmoAnterieur()) / (double)var30;
                        var33 = 0;

                        while(true) {
                           if (var33 >= var4.size()) {
                              break label157;
                           }

                           var6 = (AmortissementTab)var4.get(var33);
                           if (var6.getAmotabDateFin().compareTo(var14) > 0) {
                              if (var7.getCalculImmobilisation().equals("1")) {
                                 var30 = 30;
                              } else {
                                 var30 = var5.dateNbJourMois(var6.getAmotabDateDeb());
                              }

                              var17 = var1.myRoundDevise(var29 * (double)var30, var8.getStrdevise());
                              if (var33 + 1 == var4.size()) {
                                 double var34 = 0.0D;

                                 for(int var25 = 0; var25 < var4.size(); ++var25) {
                                    var34 += ((AmortissementTab)var4.get(var25)).getAmotabMontant();
                                 }

                                 var17 = var3.getAmoValeurAchat() - var34;
                                 var6.setAmotabMontant(var17);
                                 var6.setAmotabVnc(0.0D);
                                 break label157;
                              }

                              var15 -= var17;
                              var6.setAmotabMontant(var17);
                              var6.setAmotabVnc(var15);
                           }

                           ++var33;
                        }
                     }

                     var6 = (AmortissementTab)var4.get(var33);
                     if (var6.getAmotabDateDeb().compareTo(var14) != 0 && var6.getAmotabDateFin().compareTo(var14) != 0) {
                        if (var6.getAmotabDateDeb().compareTo(var14) < 0) {
                           var6.setAmotabMontant(0.0D);
                           var6.setAmotabVnc(0.0D);
                        } else if (var6.getAmotabDateFin().compareTo(var14) > 0) {
                           var6.setAmotabMontant(0.0D);
                           var6.setAmotabVnc(0.0D);
                        }
                     } else {
                        var6.setAmotabMontant(var3.getAmoAnterieur());
                        var6.setAmotabVnc(var15);
                     }

                     ++var33;
                  }
               }

               if (var4.size() != 0) {
                  var2.maj(var4, var9);
               }
            }
         }
      }

   }

   public void recalculClesEcritures(Ecritures var1, List var2, EcrituresAnalytiquesDao var3, EcrituresDao var4, String var5, Session var6) throws HibernateException, NamingException, groovyjarjarcommonscli.ParseException {
      if (var1.getEcrDebitSaisie() == 0.0D && var1.getEcrCreditSaisie() == 0.0D) {
         var2.clear();
         var2 = var3.chargerLesEcrituresAnalytiques(var1, var6);
         if (var2.size() != 0) {
            var3.nettoyageAnalytiqueByEcriture(var2, var6);
         }

         var4.removeSelectedEC0(var1, 0, var6);
      } else {
         String var7 = "";
         if (var1.getEcrJour() == 0) {
            var1.setEcrJour(var1.getEcrDateSaisie().getDate());
         }

         if (var1.getEcrJour() == 0) {
            var1.setEcrJour(0);
         }

         if (var1.getEcrJour() <= 9) {
            var7 = "0" + var1.getEcrJour();
         } else {
            var7 = "" + var1.getEcrJour();
         }

         String var8 = "";
         if (var1.getEcrDateSaisie().getMonth() + 1 <= 9) {
            var8 = "0" + (var1.getEcrDateSaisie().getMonth() + 1);
         } else {
            var8 = "" + (var1.getEcrDateSaisie().getMonth() + 1);
         }

         String var9 = "" + (var1.getEcrDateSaisie().getYear() + 1900);
         if (var1.getEcrCode() == null || var1.getEcrCode().isEmpty()) {
            var1.setEcrCode("OD");
         }

         var1.setEcrPeriode(var8 + ":" + var9);
         var1.setEcrAnnee(var9);
         var1.setEcrCle1(var1.getEcrCode() + ":" + var1.getEcrPeriode());
         String var10 = var9 + ":" + var8 + ":" + var7;
         var1.setEcrCle2(var1.getEcrCode() + ":" + var10);
         if (var1.getEcrCompte() == null || var1.getEcrCompte().isEmpty()) {
            var1.setEcrCompte(var5);
            var1.setEcrClasse("4");
            var1.setEcrLibCompte("Compte d'attente");
            var1.setEcrNature(9);
         }

         var4.modif(var1, var6);
      }

   }

   public List recalculAnalytque(OptionComptabilite var1, Ecritures var2, EcrituresDao var3, EcrituresAnalytique var4, EcrituresAnalytiquesDao var5, List var6, List var7, Session var8) {
      if (this.testCompteAnalytique(var2, var1)) {
         var2.setEcrAnaActif(1);
         var2 = var3.modif(var2, var8);
         Math.abs(var2.getEcrDebitSaisie() + var2.getEcrCreditSaisie());
         boolean var11 = false;
         double var12 = 0.0D;

         for(int var14 = 0; var14 < var6.size(); ++var14) {
            var4 = (EcrituresAnalytique)var6.get(var14);
            if (var4.getEcritures().getEcr_id() == var2.getEcr_id()) {
               var11 = true;
               double var15 = 0.0D;
               if (var4.getEcritures().getEcrDebitSaisie() != 0.0D && var4.getEcritures().getEcrCreditSaisie() == 0.0D) {
                  var4.setEcranaSens(0);
                  if (var4.getEcritures().getEcrDebitSaisie() < 0.0D) {
                     var15 = Math.abs(var4.getEcranaMontantSaisie()) * -1.0D;
                  } else {
                     var15 = Math.abs(var4.getEcranaMontantSaisie());
                  }
               } else {
                  var4.setEcranaSens(1);
                  if (var4.getEcritures().getEcrCreditSaisie() < 0.0D) {
                     var15 = Math.abs(var4.getEcranaMontantSaisie()) * -1.0D;
                  } else {
                     var15 = Math.abs(var4.getEcranaMontantSaisie());
                  }
               }

               var12 += var15;
               var4.setEcranaMontantSaisie(var15);
               var4.setEcranaCompte(var2.getEcrCompte());
               var4.setEcranaClasse(var2.getEcrClasse());
               var4.setEcranaCle1(var2.getEcrCle1());
               var4.setEcranaCle2(var2.getEcrCle2());
               var4.setEcranaNature(var2.getEcrNature());
               var4.setEcranaPiece(var2.getEcrPiece());
               var4.setEcranaReference1(var2.getEcrReference1());
               var4.setEcranaReference2(var2.getEcrReference2());
               var5.modifEcritureAnalytiques(var8, var4);
            }
         }

         if (!var11) {
            var7.add(var2);
         }
      } else {
         var2.setEcrAnaActif(0);
         var2 = var3.modif(var2, var8);

         for(int var9 = 0; var9 < var6.size(); ++var9) {
            var4 = (EcrituresAnalytique)var6.get(var9);
            if (var4.getEcritures().getEcr_id() == var2.getEcr_id()) {
               var5.nettoyageAnalytique(var4, var8);
            }
         }
      }

      return var7;
   }

   public boolean testCompteAnalytique(Ecritures var1, OptionComptabilite var2) {
      boolean var3 = false;
      if (var1.getEcrNature() == 1) {
         var3 = Boolean.parseBoolean(var2.getAnal_c1());
      } else if (var1.getEcrNature() == 2) {
         var3 = Boolean.parseBoolean(var2.getAnal_c2());
      } else if (var1.getEcrNature() == 3) {
         var3 = Boolean.parseBoolean(var2.getAnal_c3());
      } else if (var1.getEcrNature() == 4) {
         var3 = Boolean.parseBoolean(var2.getAnal_c4());
      } else if (var1.getEcrNature() == 5) {
         var3 = Boolean.parseBoolean(var2.getAnal_c5());
      } else if (var1.getEcrNature() == 6) {
         var3 = Boolean.parseBoolean(var2.getAnal_c6());
      } else if (var1.getEcrNature() == 7) {
         var3 = Boolean.parseBoolean(var2.getAnal_c7());
      } else if (var1.getEcrNature() == 8) {
         var3 = Boolean.parseBoolean(var2.getAnal_c8());
      } else if (var1.getEcrNature() == 9) {
         var3 = Boolean.parseBoolean(var2.getAnal_c9());
      } else if (var1.getEcrNature() == 10) {
         var3 = Boolean.parseBoolean(var2.getAnal_c10());
      } else if (var1.getEcrNature() == 11) {
         var3 = Boolean.parseBoolean(var2.getAnal_c11());
      } else if (var1.getEcrNature() == 12) {
         var3 = Boolean.parseBoolean(var2.getAnal_c12());
      } else if (var1.getEcrNature() == 13) {
         var3 = Boolean.parseBoolean(var2.getAnal_c13());
      } else if (var1.getEcrNature() == 14) {
         var3 = Boolean.parseBoolean(var2.getAnal_c14());
      } else if (var1.getEcrNature() == 15) {
         var3 = Boolean.parseBoolean(var2.getAnal_c15());
      } else if (var1.getEcrNature() == 16) {
         var3 = Boolean.parseBoolean(var2.getAnal_c16());
      } else if (var1.getEcrNature() == 17) {
         var3 = Boolean.parseBoolean(var2.getAnal_c17());
      } else if (var1.getEcrNature() == 18) {
         var3 = Boolean.parseBoolean(var2.getAnal_c18());
      } else if (var1.getEcrNature() == 19) {
         var3 = Boolean.parseBoolean(var2.getAnal_c19());
      } else if (var1.getEcrNature() == 20) {
         var3 = Boolean.parseBoolean(var2.getAnal_c20());
      } else if (var1.getEcrNature() == 21) {
         var3 = Boolean.parseBoolean(var2.getAnal_c21());
      } else if (var1.getEcrNature() == 22) {
         var3 = Boolean.parseBoolean(var2.getAnal_c22());
      } else if (var1.getEcrNature() == 23) {
         var3 = Boolean.parseBoolean(var2.getAnal_c23());
      } else if (var1.getEcrNature() == 24) {
         var3 = Boolean.parseBoolean(var2.getAnal_c24());
      } else {
         var3 = false;
      }

      return var3;
   }

   public void delettrageExercices(Structure var1, ExercicesComptable var2, String var3, List var4, UtilNombre var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      String var8 = "Chargement des ecritures lettrees de l'exercice " + var2.getExecpt_id() + "...";
      this.formUtilitaires.setVar_info(var8);
      new ArrayList();
      PlanComptableDao var10 = new PlanComptableDao(var3, var6);
      String var11 = var1.getStrzonefiscale();
      if (var1.getStrzonefiscale2() != null && !var1.getStrzonefiscale2().isEmpty() && var1.getStrdatefiscale2() != null && var2.getExecptDateFin().compareTo(var1.getStrdatefiscale2()) > 0) {
         var11 = var1.getStrzonefiscale2();
      }

      List var9 = var10.chargerLesPlanComptables(var11, var2.getExecpt_id(), var7);
      if (var9.size() != 0) {
         EcrituresDao var12 = new EcrituresDao(var3, var6);
         var4 = var12.chargerLesEcrituresLettres(var2.getExecpt_id(), var7);
         if (var4.size() != 0) {
            for(int var13 = 0; var13 < var9.size(); ++var13) {
               new PlanComptable();
               PlanComptable var14 = (PlanComptable)var9.get(var13);
               var8 = "Analyse compte : " + var14.getPlcCompte();
               this.formUtilitaires.setVar_info(var8);
               double var19;
               if (var13 != 0) {
                  double var15 = (double)var9.size();
                  double var17 = var5.myRound(var15 / (double)var13, 4);
                  var19 = var5.myRound(100.0D / var17, 2);
                  int var21 = (int)var19;
                  this.formUtilitaires.setVar_currentValue(var21);
               }

               ArrayList var31 = new ArrayList();

               for(int var16 = 0; var16 < var4.size(); ++var16) {
                  if (((Ecritures)var4.get(var16)).getEcrCompte().equals(var14.getPlcCompte())) {
                     var31.add(var4.get(var16));
                  }
               }

               if (var31.size() != 0) {
                  ArrayList var32 = new ArrayList();
                  int var33;
                  if (var31.size() != 0) {
                     for(var33 = 0; var33 < var31.size(); ++var33) {
                        new Ecritures();
                        Ecritures var18 = (Ecritures)var31.get(var33);
                        if (var18.getEcrLettrage() != null && !var18.getEcrLettrage().isEmpty()) {
                           if (var32.size() == 0) {
                              var32.add(var18.getEcrLettrage());
                           } else {
                              boolean var35 = false;

                              for(int var20 = 0; var20 < var32.size(); ++var20) {
                                 if (((String)var32.get(var20)).equals(var18.getEcrLettrage())) {
                                    var35 = true;
                                 }
                              }

                              if (!var35) {
                                 var32.add(var18.getEcrLettrage());
                              }
                           }
                        }
                     }
                  }

                  if (var32.size() != 0) {
                     for(var33 = 0; var33 < var32.size(); ++var33) {
                        String var34 = ((String)var32.get(var33)).toString();
                        if (var34 != null && !var34.isEmpty()) {
                           var19 = 0.0D;
                           double var36 = 0.0D;

                           for(int var23 = 0; var23 < var31.size(); ++var23) {
                              if (((Ecritures)var31.get(var23)).getEcrLettrage().equals(var34)) {
                                 var19 += ((Ecritures)var31.get(var23)).getEcrDebitPays();
                                 var36 += ((Ecritures)var31.get(var23)).getEcrCreditPays();
                              }
                           }

                           double var37 = var5.myRoundDevise(var19, var1.getStrdevise());
                           double var25 = var5.myRoundDevise(var36, var1.getStrdevise());
                           int var27;
                           if (var37 != var25) {
                              for(var27 = 0; var27 < var31.size(); ++var27) {
                                 new Ecritures();
                                 Ecritures var28 = (Ecritures)var31.get(var27);
                                 if (var28.getEcrLettrage().equals(var34)) {
                                    var28.setEcrLettrage("");
                                    var12.modif(var28, var7);
                                 }
                              }
                           }

                           var27 = var2.getExecptDateDebut().getYear() + 1900;
                           boolean var38 = false;

                           int var29;
                           for(var29 = 0; var29 < var31.size(); ++var29) {
                              if (((Ecritures)var31.get(var29)).getEcrLettrage().equals(var34)) {
                                 int var30 = ((Ecritures)var31.get(var29)).getEcrDateSaisie().getYear() + 1900;
                                 if (var27 != var30) {
                                    var38 = true;
                                    break;
                                 }
                              }
                           }

                           if (var38) {
                              for(var29 = 0; var29 < var31.size(); ++var29) {
                                 new Ecritures();
                                 Ecritures var39 = (Ecritures)var31.get(var29);
                                 if (var39.getEcrLettrage().equals(var34)) {
                                    var39.setEcrLettrage("");
                                    var12.modif(var39, var7);
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   public void recalculCompteAmortissements(int var1, boolean var2, long var3, int var5, Amortissements var6, List var7, List var8, AmortissementsDao var9, Session var10) throws HibernateException, NamingException {
      if (var6.getAmoNum() == 0L) {
         var6.setAmoNum(var3);
         ++var3;
      }

      float var11;
      float var12;
      if (var6.getAmoNbAnneeCpte() == 0.0F && var6.getAmoTauxComptable() != 0.0F) {
         var11 = var6.getAmoTauxComptable();
         if (var11 > 0.0F && var11 <= 100.0F) {
            var12 = 100.0F / var11;
            var6.setAmoNbAnneeCpte(var12);
         }
      }

      if (var6.getAmoNbAnneeFiscal() == 0.0F && var6.getAmoTauxFiscal() != 0.0F) {
         var11 = var6.getAmoTauxFiscal();
         if (var11 > 0.0F && var11 <= 100.0F) {
            var12 = 100.0F / var11;
            var6.setAmoNbAnneeFiscal(var12);
         }
      }

      if (var6.getAmoLocalisation() != null && !var6.getAmoLocalisation().isEmpty()) {
         var6.setAmoLocalisation(var6.getAmoLocalisation().toUpperCase());
      }

      int var14;
      if (!var2 && var6.getAmoActivite() != null && !var6.getAmoActivite().isEmpty()) {
         for(var14 = 0; var14 < var8.size(); ++var14) {
            if (((Activites)var8.get(var14)).getActCode().equals(var6.getAmoActivite())) {
               var6.setAmoLibActivite(((Activites)var8.get(var14)).getActNomFr());
               break;
            }
         }
      }

      if (var6.getAmoCompteAmo() != null && !var6.getAmoCompteAmo().isEmpty()) {
         for(var14 = 0; var14 < var7.size(); ++var14) {
            if (((PlanComptable)var7.get(var14)).getPlcCompte() != null && !((PlanComptable)var7.get(var14)).getPlcCompte().isEmpty() && var6.getAmoCompteAmo().startsWith(((PlanComptable)var7.get(var14)).getPlcCompte())) {
               var6.setAmoCompteAmo(((PlanComptable)var7.get(var14)).getPlcCompte());
               var6.setAmoLibCompteAmo(((PlanComptable)var7.get(var14)).getPlcLibelleCpteFR());
               break;
            }
         }
      }

      if (var6.getAmoCompteCes() != null && !var6.getAmoCompteCes().isEmpty()) {
         for(var14 = 0; var14 < var7.size(); ++var14) {
            if (((PlanComptable)var7.get(var14)).getPlcCompte() != null && !((PlanComptable)var7.get(var14)).getPlcCompte().isEmpty() && var6.getAmoCompteCes().startsWith(((PlanComptable)var7.get(var14)).getPlcCompte())) {
               var6.setAmoCompteCes(((PlanComptable)var7.get(var14)).getPlcCompte());
               var6.setAmoLibCompteCes(((PlanComptable)var7.get(var14)).getPlcLibelleCpteFR());
               break;
            }
         }
      }

      if (var6.getAmoCompteDotation() != null && !var6.getAmoCompteDotation().isEmpty()) {
         for(var14 = 0; var14 < var7.size(); ++var14) {
            if (((PlanComptable)var7.get(var14)).getPlcCompte() != null && !((PlanComptable)var7.get(var14)).getPlcCompte().isEmpty() && var6.getAmoCompteDotation().startsWith(((PlanComptable)var7.get(var14)).getPlcCompte())) {
               var6.setAmoCompteDotation(((PlanComptable)var7.get(var14)).getPlcCompte());
               var6.setAmoLibCompteDot(((PlanComptable)var7.get(var14)).getPlcLibelleCpteFR());
               break;
            }
         }
      }

      if (var6.getAmoCompteImmo() != null && !var6.getAmoCompteImmo().isEmpty()) {
         for(var14 = 0; var14 < var7.size(); ++var14) {
            if (((PlanComptable)var7.get(var14)).getPlcCompte() != null && !((PlanComptable)var7.get(var14)).getPlcCompte().isEmpty() && var6.getAmoCompteImmo().startsWith(((PlanComptable)var7.get(var14)).getPlcCompte())) {
               var6.setAmoCompteImmo(((PlanComptable)var7.get(var14)).getPlcCompte());
               var6.setAmoLibCompteImo(((PlanComptable)var7.get(var14)).getPlcLibelleCpteFR());
               break;
            }
         }
      }

      if (var6.getAmoFournisseur() != null && !var6.getAmoFournisseur().isEmpty()) {
         for(var14 = 0; var14 < var7.size(); ++var14) {
            if (((PlanComptable)var7.get(var14)).getPlcCompte() != null && !((PlanComptable)var7.get(var14)).getPlcCompte().isEmpty() && var6.getAmoFournisseur().startsWith(((PlanComptable)var7.get(var14)).getPlcCompte())) {
               var6.setAmoFournisseur(((PlanComptable)var7.get(var14)).getPlcCompte());
               var6.setAmoLibFournisseur(((PlanComptable)var7.get(var14)).getPlcLibelleCpteFR());
               break;
            }
         }
      }

      var9.modif(var6, var10);
      if (var5 == 200) {
         var10.flush();
         boolean var13 = false;
      }

   }

   public void declotureRapprochement(Structure var1, Users var2, UtilDate var3, List var4, JournauxMois var5, String var6, JournauxMoisDao var7, List var8, JournauxJour var9, JournauxJourDao var10, Session var11) throws HibernateException, NamingException, Exception {
      new OptionComptabilite();
      LireLesoptionsCompta var13 = new LireLesoptionsCompta(var1);
      var13.setStrId(var1.getStrid());
      OptionComptabilite var12 = var13.lancer();

      int var14;
      UtilMail var15;
      String var16;
      for(var14 = 0; var14 < var4.size(); ++var14) {
         var5 = (JournauxMois)var4.get(var14);
         if (var5.getJoumenPeriode().equals(var6)) {
            var5.setJoumenEtat(0);
            var5 = var7.majJournal(var5, var11);
            if (var12 != null && var12.getMailClotureRappro() != null && !var12.getMailClotureRappro().isEmpty() && var12.getMailClotureRappro().contains("@")) {
               var15 = new UtilMail(var1);
               var16 = "Banque: " + var5.getJoumenCode() + " Période:" + var5.getJoumenPeriode();
               var15.envoieMailRappro(var1, var2, var16, 1, var12.getMailClotureRappro(), var3);
            }
         }
      }

      for(var14 = 0; var14 < var8.size(); ++var14) {
         var9 = (JournauxJour)var8.get(var14);
         var9.setJoujrEtat(0);
         var9 = var10.majJournal(var9, var11);
         if (var12 != null && var12.getMailClotureRappro() != null && !var12.getMailClotureRappro().isEmpty() && var12.getMailClotureRappro().contains("@")) {
            var15 = new UtilMail(var1);
            var16 = "Banque: " + var9.getJoujrCode() + " Date:" + var3.dateToStringFr(var9.getJoujrDate());
            var15.envoieMailRappro(var1, var2, var16, 1, var12.getMailClotureRappro(), var3);
         }
      }

   }

   public void declotureMensuelle(Structure var1, Users var2, UtilDate var3, List var4, JournauxMois var5, JournauxMoisDao var6, EcrituresDao var7, Date var8, Date var9, Session var10) throws HibernateException, NamingException, groovyjarjarcommonscli.ParseException, Exception {
      new OptionComptabilite();
      LireLesoptionsCompta var12 = new LireLesoptionsCompta(var1);
      var12.setStrId(var1.getStrid());
      OptionComptabilite var11 = var12.lancer();

      for(int var13 = 0; var13 < var4.size(); ++var13) {
         var5 = (JournauxMois)var4.get(var13);
         if (var5.getJoumenEtat() == 1) {
            var5.setJoumenEtat(0);
            var5 = var6.majJournal(var5, var10);
         }
      }

      var7.chargerEcrituresPourDecloture(var8, var9, var10);
      var10.flush();
      if (var11.getMailClotureJournal() != null && !var11.getMailClotureJournal().isEmpty() && var11.getMailClotureJournal().contains("@")) {
         UtilMail var15 = new UtilMail(var1);
         String var14 = "Banque: " + var5.getJoumenCode() + " Période:" + var5.getJoumenPeriode();
         var15.envoieMailJournal(var1, var2, var14, 1, var11.getMailClotureJournal(), var3);
      }

   }

   public void recalculCompteEcritures(int var1, int var2, Ecritures var3, List var4, EcrituresDao var5, Session var6) throws HibernateException, NamingException {
      if (var3.getEcrCompte() != null && !var3.getEcrCompte().isEmpty()) {
         for(int var7 = 0; var7 < var4.size(); ++var7) {
            if (((PlanComptable)var4.get(var7)).getPlcCompte() != null && !((PlanComptable)var4.get(var7)).getPlcCompte().isEmpty() && var3.getEcrCompte().startsWith(((PlanComptable)var4.get(var7)).getPlcCompte())) {
               var3.setEcrCompte(((PlanComptable)var4.get(var7)).getPlcCompte());
               var3.setEcrLibCompte(((PlanComptable)var4.get(var7)).getPlcLibelleCpteFR());
               break;
            }
         }
      }

      var5.modif(var3, var6);
      if (var2 == 200) {
         var6.flush();
         boolean var8 = false;
      }

   }

   public void recalculColonneEuro(OptionComptabilite var1, List var2, EcrituresDao var3, Session var4) throws HibernateException, NamingException, groovyjarjarcommonscli.ParseException {
      UtilNombre var5 = new UtilNombre();
      if (var2.size() != 0) {
         new Ecritures();

         for(int var7 = 0; var7 < var2.size(); ++var7) {
            Ecritures var6 = (Ecritures)var2.get(var7);
            if (var6.getEcrDebitSaisie() != 0.0D) {
               var6.setEcrDebitEuro(var5.myRound(var6.getEcrDebitSaisie() / 655.957D, 2));
            }

            if (var6.getEcrCreditSaisie() != 0.0D) {
               var6.setEcrCreditEuro(var5.myRound(var6.getEcrCreditSaisie() / 655.957D, 2));
            }

            var3.modif(var6, var4);
         }
      }

   }

   public void recalculDateEcheance(UtilDate var1, Tiers var2, TiersDao var3, OptionComptabilite var4, List var5, EcrituresDao var6, Session var7) throws HibernateException, NamingException, groovyjarjarcommonscli.ParseException, ParseException {
      if (var5.size() != 0) {
         new Ecritures();

         for(int var9 = 0; var9 < var5.size(); ++var9) {
            Ecritures var8 = (Ecritures)var5.get(var9);
            if (!var8.getEcrCompte().startsWith("40") && !var8.getEcrCompte().startsWith("41")) {
               var8.setEcrDateEcheance((Date)null);
               var6.modif(var8, var7);
            } else {
               var2 = var3.selectTierCompte(var8.getEcrCompte(), var7);
               if (var2 != null) {
                  var8.setEcrDateEcheance(var1.CalculDateEcheance(var8.getEcrDateSaisie(), var2.getTietypereg(), var2.getTienbecheance(), var2.getTienbarrondi()));
                  var6.modif(var8, var7);
               } else {
                  var8.setEcrDateEcheance(var8.getEcrDateSaisie());
                  var6.modif(var8, var7);
               }
            }
         }
      }

   }
}
