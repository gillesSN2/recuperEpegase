package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.BulletinLigne;
import com.epegase.systeme.classe.BulletinSalaire;
import com.epegase.systeme.classe.ExercicesPaye;
import com.epegase.systeme.classe.PlanPaye;
import com.epegase.systeme.classe.Salaries;
import com.epegase.systeme.classe.SalariesConges;
import com.epegase.systeme.classe.SalariesContrats;
import com.epegase.systeme.classe.SalariesElements;
import com.epegase.systeme.classe.SalariesGrh;
import com.epegase.systeme.classe.SalariesHistorique;
import com.epegase.systeme.classe.SalariesVariables;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.BulletinLigneDao;
import com.epegase.systeme.dao.BulletinSalaireDao;
import com.epegase.systeme.dao.PlanPayeDao;
import com.epegase.systeme.dao.SalariesCongesDao;
import com.epegase.systeme.dao.SalariesContratsDao;
import com.epegase.systeme.dao.SalariesDao;
import com.epegase.systeme.dao.SalariesElementsDao;
import com.epegase.systeme.dao.SalariesGrhDao;
import com.epegase.systeme.dao.SalariesHistoriqueDao;
import com.epegase.systeme.dao.SalariesVariablesDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilDownload;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.xml.LectureConventions;
import com.epegase.systeme.xml.LireLesoptionsPaye;
import com.epegase.systeme.xml.ObjetConvention;
import com.epegase.systeme.xml.OptionPaye;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Utilitaires_Paye implements Serializable {
   public void recalculBulletin(Date var1, List var2, PlanPaye var3, Salaries var4, SalariesContrats var5, BulletinSalaire var6, BulletinLigne var7, SalariesElements var8, SalariesHistoriqueDao var9, SalariesContratsDao var10, SalariesElementsDao var11, BulletinSalaireDao var12, BulletinLigneDao var13, PlanPayeDao var14, Structure var15, Session var16) throws HibernateException, NamingException {
      ArrayList var17 = new ArrayList();
      ArrayList var18 = new ArrayList();
      new ArrayList();
      var17.clear();
      List var57 = var9.chargerlesHistoriquesBySalaries(var4, var16);
      var18.clear();
      List var58 = var10.chargerlesContrats(var4, var16);
      if (var58.size() != 0) {
         for(int var20 = 0; var20 < var58.size(); ++var20) {
            var5 = (SalariesContrats)var58.get(var20);
            if (var5.getSalconNum() != null && !var5.getSalconNum().isEmpty()) {
               int var21 = 0;
               double var22 = 0.0D;
               float var24 = 0.0F;
               if (var57.size() != 0) {
                  for(int var25 = 0; var25 < var57.size(); ++var25) {
                     if (((SalariesHistorique)var57.get(var25)).getSalhisContrat() != null && !((SalariesHistorique)var57.get(var25)).getSalhisContrat().isEmpty()) {
                        if (((SalariesHistorique)var57.get(var25)).getSalhisDate().equals(var1) && ((SalariesHistorique)var57.get(var25)).getSalhisContrat().equals(var5.getSalconNum())) {
                           if (((SalariesHistorique)var57.get(var25)).getSalhisCode().equals("BRUT")) {
                              var22 = ((SalariesHistorique)var57.get(var25)).getSalhisValeurColE();
                           } else if (((SalariesHistorique)var57.get(var25)).getSalhisCode().equals("NBJS")) {
                              var24 = (float)((SalariesHistorique)var57.get(var25)).getSalhisValeurColE();
                           }
                        }
                     } else if (((SalariesHistorique)var57.get(var25)).getSalhisDate().equals(var1)) {
                        if (((SalariesHistorique)var57.get(var25)).getSalhisCode().equals("BRUT")) {
                           var22 = ((SalariesHistorique)var57.get(var25)).getSalhisValeurColE();
                        } else if (((SalariesHistorique)var57.get(var25)).getSalhisCode().equals("NBJS")) {
                           var24 = (float)((SalariesHistorique)var57.get(var25)).getSalhisValeurColE();
                        }
                     }
                  }
               }

               double var59 = 0.0D;
               double var27 = 0.0D;
               double var29 = 0.0D;
               double var31 = 0.0D;
               double var33 = 0.0D;
               double var35 = 0.0D;
               double var37 = 0.0D;
               double var39 = 0.0D;
               double var41 = 0.0D;
               double var43 = 0.0D;
               double var45 = 0.0D;
               double var47 = 0.0D;
               double var49 = 0.0D;
               double var51 = 0.0D;
               double var53 = 0.0D;

               for(int var55 = 0; var55 < var2.size(); ++var55) {
                  var6 = (BulletinSalaire)var2.get(var55);
                  if (var6.getBulsalMatricule() != null && !var6.getBulsalMatricule().isEmpty() && var6.getBulsalContrat() != null && !var6.getBulsalContrat().isEmpty() && var6.getBulsalMatricule().equals(var4.getSalMatricule()) && var6.getBulsalContrat().equals(var5.getSalconNum())) {
                     ++var21;
                     List var19 = var13.chargerleslignesBulletin(var6, var16);
                     if (var19.size() != 0) {
                        for(int var56 = 0; var56 < var19.size(); ++var56) {
                           var7 = (BulletinLigne)var19.get(var56);
                           var3 = var14.chercherCode(var7.getBulligRubrique(), 0L, var16);
                           if (var3 == null) {
                              var3 = new PlanPaye();
                           }

                           var7.setBulligNature(var3.getPlpNature());
                           var7.setBulligSens(var3.getPlpSens());
                           if (var7.getBulligRubrique() != null && !var7.getBulligRubrique().isEmpty()) {
                              if (var7.getBulligRubrique().equals("299999")) {
                                 var33 = var7.getBulligValColE();
                                 var22 += var33;
                                 var24 += var4.getSalNbJourCp();
                              } else if (var7.getBulligRubrique().equals("208000")) {
                                 var29 = var7.getBulligValColE();
                                 var31 = var7.getBulligValColD();
                              } else if (var7.getBulligRubrique().equals("699999")) {
                                 var59 = var7.getBulligValColE();
                              } else if (var7.getBulligNature() == 50) {
                                 var27 += var7.getBulligValColE();
                              } else if ((var7.getBulligNature() == 60 || var7.getBulligNature() == 61 || var7.getBulligNature() == 62 || var7.getBulligNature() == 90) && var7.getBulligValColA() != 0.0D) {
                                 var7.setBulligAffColA(true);
                                 var7.setBulligValColA(var33);
                                 var7 = var13.modif(var7, var16);
                              }

                              if (!var15.getStrcodepays().equals("0041") && !var15.getStrcodepays().equals("0056")) {
                                 if (var15.getStrcodepays().equals("0077")) {
                                    if (var7.getBulligRubrique().startsWith("300000")) {
                                       var35 += var7.getBulligValColE();
                                    } else if (var7.getBulligRubrique().startsWith("300020")) {
                                       var37 += var7.getBulligValColE();
                                    } else if (var7.getBulligRubrique().startsWith("300100")) {
                                       var39 += var7.getBulligValColE();
                                    } else if (var7.getBulligRubrique().startsWith("300200")) {
                                       var41 += var7.getBulligValColE();
                                    } else {
                                       var43 = 0.0D;
                                       var45 = 0.0D;
                                       var47 = 0.0D;
                                       var49 = 0.0D;
                                       var51 = 0.0D;
                                       var53 = 0.0D;
                                    }
                                 } else if (var15.getStrcodepays().equals("0138")) {
                                    if (var7.getBulligRubrique().startsWith("300010")) {
                                       var35 += var7.getBulligValColE();
                                    } else if (!var7.getBulligRubrique().startsWith("300020") && !var7.getBulligRubrique().startsWith("300021") && !var7.getBulligRubrique().startsWith("300022") && !var7.getBulligRubrique().startsWith("300023") && !var7.getBulligRubrique().startsWith("300024") && !var7.getBulligRubrique().startsWith("300025") && !var7.getBulligRubrique().startsWith("300026") && !var7.getBulligRubrique().startsWith("300027") && !var7.getBulligRubrique().startsWith("300028") && !var7.getBulligRubrique().startsWith("300029")) {
                                       if (var7.getBulligRubrique().startsWith("300220")) {
                                          var39 += var7.getBulligValColE();
                                       } else if (var7.getBulligRubrique().startsWith("900020")) {
                                          var41 += var7.getBulligValColE();
                                       } else if (!var7.getBulligRubrique().startsWith("900040") && !var7.getBulligRubrique().startsWith("900041") && !var7.getBulligRubrique().startsWith("900042") && !var7.getBulligRubrique().startsWith("900043") && !var7.getBulligRubrique().startsWith("900044") && !var7.getBulligRubrique().startsWith("900045") && !var7.getBulligRubrique().startsWith("900046") && !var7.getBulligRubrique().startsWith("900047") && !var7.getBulligRubrique().startsWith("900048") && !var7.getBulligRubrique().startsWith("900049")) {
                                          var45 = 0.0D;
                                          var47 = 0.0D;
                                          var49 = 0.0D;
                                          var51 = 0.0D;
                                          var53 = 0.0D;
                                       } else {
                                          var43 += var7.getBulligValColE();
                                       }
                                    } else {
                                       var37 += var7.getBulligValColE();
                                    }
                                 } else if (var15.getStrcodepays().equals("0202")) {
                                    if (!var7.getBulligRubrique().startsWith("300000") && !var7.getBulligRubrique().startsWith("300010") && !var7.getBulligRubrique().startsWith("300020")) {
                                       if (var7.getBulligRubrique().startsWith("300100")) {
                                          var37 += var7.getBulligValColE();
                                       } else if (!var7.getBulligRubrique().startsWith("300200") && !var7.getBulligRubrique().startsWith("300220")) {
                                          if (var7.getBulligRubrique().startsWith("300300")) {
                                             var41 += var7.getBulligValColE();
                                          } else {
                                             var43 = 0.0D;
                                             var45 = 0.0D;
                                             var47 = 0.0D;
                                             var49 = 0.0D;
                                             var51 = 0.0D;
                                             var53 = 0.0D;
                                          }
                                       } else {
                                          var39 += var7.getBulligValColE();
                                       }
                                    } else {
                                       var35 += var7.getBulligValColE();
                                    }
                                 } else {
                                    var35 = 0.0D;
                                    var37 = 0.0D;
                                    var39 = 0.0D;
                                    var41 = 0.0D;
                                    var43 = 0.0D;
                                    var45 = 0.0D;
                                    var47 = 0.0D;
                                    var49 = 0.0D;
                                    var51 = 0.0D;
                                    var53 = 0.0D;
                                 }
                              }
                           }
                        }

                        var6.setBulsalAvNat(var27);
                        var6.setBulsalCP(var29);
                        var6.setBulsalImpot1(var35);
                        var6.setBulsalImpot2(var37);
                        var6.setBulsalImpot3(var39);
                        var6.setBulsalImpot4(var41);
                        var6.setBulsalImpot5(var43);
                        var6.setBulsalImpot6(var45);
                        var6.setBulsalImpot7(var47);
                        var6.setBulsalImpot8(var49);
                        var6.setBulsalImpot9(var51);
                        var6.setBulsalImpot10(var53);
                     } else {
                        var6.setBulsalBrut(0.0D);
                        var6.setBulsalNetPayer(0.0D);
                        var6.setBulsalAvNat(0.0D);
                        var6.setBulsalCP(0.0D);
                        var6.setBulsalImpot1(0.0D);
                        var6.setBulsalImpot2(0.0D);
                        var6.setBulsalImpot3(0.0D);
                        var6.setBulsalImpot4(0.0D);
                        var6.setBulsalImpot5(0.0D);
                        var6.setBulsalImpot6(0.0D);
                        var6.setBulsalImpot7(0.0D);
                        var6.setBulsalImpot8(0.0D);
                        var6.setBulsalImpot9(0.0D);
                        var6.setBulsalImpot10(0.0D);
                     }

                     var8 = var11.chargerlesVariablesPeriode(var4, var6.getBulsalPeriode(), var5.getSalconNum(), var16);
                     if (var8 != null) {
                        var6.setBulsalNature(var8.getSaleleNature());
                        var6.setBulsalEtat(var8.getSaleleEtat());
                        var6.setBulsalCivilite(var8.getSaleleCivilite());
                        var6.setBulsalFonction(var8.getSaleleFonction());
                        var6.setBulsalSite(var8.getSaleleSite());
                        var6.setBulsalDepartement(var8.getSaleleDepartement());
                        var6.setBulsalService(var8.getSaleleService());
                        var6.setBulsalLibService(var8.getSaleleLibService());
                        var6.setBulsalActivite(var8.getSaleleActivite());
                        var6.setBulsalBudget(var8.getSaleleBudget());
                        var6.setBulsalParc(var8.getSaleleParc());
                        var6.setBulsalGenre(var8.getSaleleGenre());
                        var6.setBulsalSitFamille(var8.getSaleleSitFamille());
                        var6.setBulsalNbEnfant(var8.getSaleleNbEnfant());
                        var6.setBulsalNbPartFiscal(var8.getSaleleNbPartFiscal());
                        var6.setBulsalNbFemme(var8.getSaleleNbEnfant());
                        var6.setBulsalNbPartTrimf(var8.getSaleleNbPartTrimf());
                        var6.setBulsalDateSortie(var8.getSaleleDateSortie());
                        var6.setBulsalMotifSortie(var8.getSaleleMotifSortie());
                        var6.setBulsalConvention(var8.getSaleleConvention());
                        var6.setBulsalLibConvention(var8.getSaleleLibConvention());
                        var6.setBulsalCentresImpots(var8.getSaleleCentresImpots());
                        var6.setBulsalLibCentresImpots(var8.getSaleleCentresImpots());
                        var6.setBulsalCentresSecurite(var8.getSaleleCentresSecurite());
                        var6.setBulsalLibCentresSecurite(var8.getSaleleCentresSecurite());
                        var6.setBulsalClassement(var8.getSaleleClassement());
                        var6.setBulsalLibClassement(var8.getSaleleLibClassement());
                        var6.setBulsalNivEmploi(var8.getSaleleNivEmploi());
                        var6.setBulsalLibNivEmploi(var8.getSaleleLibNivEmploi());
                        var6.setBulsalGrille(var8.getSaleleGrille());
                        var6.setBulsalCle1Anal(var8.getSaleleCle1Anal());
                        var6.setBulsalCle2Anal(var8.getSaleleCle2Anal());
                        var6.setBulsalModeReglement(var8.getSaleleModeReglement());
                        var6.setBulsalNumBanque(var8.getSaleleNumBanque());
                        var6.setBulsalGuichetBanque(var8.getSaleleGuichetBanque());
                        var6.setBulsalCompteBanque(var8.getSaleleCompteBanque());
                        var6.setBulsalCompteMembre(var8.getSaleleCompteMembre());
                        var6.setBulsalCleBanque(var8.getSaleleCleBanque());
                        var6.setBulsalIban(var8.getSaleleIban());
                        var6.setBulsalSwift(var8.getSaleleSwift());
                        var6.setBulsalNbFemme(var8.getSaleleNbEnfant());
                     } else {
                        var6.setBulsalNature(var6.getSalaries().getSalNature());
                        var6.setBulsalEtat(var6.getSalaries().getSalEtat());
                        var6.setBulsalCivilite(var6.getSalaries().getSalCivilite());
                        var6.setBulsalFonction(var6.getSalaries().getSalFonction());
                        var6.setBulsalSite(var6.getSalaries().getSalSite());
                        var6.setBulsalDepartement(var6.getSalaries().getSalDepartement());
                        var6.setBulsalService(var6.getSalaries().getSalService());
                        var6.setBulsalLibService(var6.getSalaries().getSalLibService());
                        var6.setBulsalActivite(var6.getSalaries().getSalActivite());
                        var6.setBulsalBudget(var6.getSalaries().getSalBudget());
                        var6.setBulsalParc(var6.getSalaries().getSalParc());
                        var6.setBulsalGenre(var6.getSalaries().getSalGenre());
                        var6.setBulsalSitFamille(var6.getSalaries().getSalSitFamille());
                        var6.setBulsalNbEnfant(var6.getSalaries().getSalNbEnfant());
                        var6.setBulsalNbPartFiscal(var6.getSalaries().getSalNbPartFiscal());
                        var6.setBulsalNbFemme(var6.getSalaries().getSalNbEnfant());
                        var6.setBulsalNbPartTrimf(var6.getSalaries().getSalNbPartTrimf());
                        var6.setBulsalDateSortie(var6.getSalaries().getSalDateSortie());
                        var6.setBulsalMotifSortie(var6.getSalaries().getSalMotifSortie());
                        var6.setBulsalConvention(var6.getSalaries().getSalConvention());
                        var6.setBulsalLibConvention(var6.getSalaries().getSalLibConvention());
                        var6.setBulsalCentresImpots(var6.getSalaries().getSalCentresImpots());
                        var6.setBulsalLibCentresImpots(var6.getSalaries().getSalCentresImpots());
                        var6.setBulsalCentresSecurite(var6.getSalaries().getSalCentresSecurite());
                        var6.setBulsalLibCentresSecurite(var6.getSalaries().getSalCentresSecurite());
                        var6.setBulsalClassement(var6.getSalaries().getSalClassement());
                        var6.setBulsalLibClassement(var6.getSalaries().getSalLibClassement());
                        var6.setBulsalNivEmploi(var6.getSalaries().getSalNivEmploi());
                        var6.setBulsalLibNivEmploi(var6.getSalaries().getSalLibNivEmploi());
                        var6.setBulsalGrille(var6.getSalaries().getSalGrille());
                        var6.setBulsalCle1Anal(var6.getSalaries().getSalCleAnal1());
                        var6.setBulsalCle2Anal(var6.getSalaries().getSalCleAnal2());
                        var6.setBulsalModeReglement(var6.getSalaries().getSalModeReglement());
                        var6.setBulsalNumBanque(var6.getSalaries().getSalNumBanque());
                        var6.setBulsalGuichetBanque(var6.getSalaries().getSalGuichetBanque());
                        var6.setBulsalCompteBanque(var6.getSalaries().getSalCompteBanque());
                        var6.setBulsalCompteMembre(var6.getSalaries().getSalCompteMembre());
                        var6.setBulsalCleBanque(var6.getSalaries().getSalCleBanque());
                        var6.setBulsalIban(var6.getSalaries().getSalIban());
                        var6.setBulsalSwift(var6.getSalaries().getSalSwift());
                        var6.setBulsalNbFemme(var6.getSalaries().getSalNbEnfant());
                     }

                     if ((var6.getBulsalActivite() == null || var6.getBulsalActivite().isEmpty()) && var5 != null) {
                        var6.setBulsalActivite(var5.getSalconActivite());
                     }

                     var12.modif(var6, var16);
                     if (var21 == 100) {
                        var16.flush();
                        var21 = 0;
                     }
                  }
               }
            }
         }
      }

   }

   public void recalculCompteursConges(UtilNombre var1, BulletinSalaireDao var2, SalariesHistoriqueDao var3, BulletinLigneDao var4, SalariesCongesDao var5, SalariesContratsDao var6, Salaries var7, OptionPaye var8, ExercicesPaye var9, String var10, Structure var11, UtilInitHibernate var12, Session var13) throws HibernateException, NamingException {
      new ArrayList();
      new ArrayList();
      new ArrayList();
      new ArrayList();
      new ArrayList();
      SalariesContrats var19 = new SalariesContrats();
      List var14 = var2.chargerlesBulletinsbySalarieExercice(var7, var9, var13);
      if (var14.size() != 0) {
         List var15 = var4.chargerleslignesbyRubriquesSalaries("100000", "208000", var9.getExepayDateDebut(), var9.getExepayDateFin(), var7, var13);
         float var20 = 0.0F;
         List var16 = var3.chargerlesHistoriquesBySalaries(((BulletinSalaire)var14.get(0)).getSalaries(), "", var9, var13);
         if (var16.size() != 0) {
            for(int var21 = 0; var21 < var16.size(); ++var21) {
               if (((SalariesHistorique)var16.get(var21)).getSalhisCode() != null && !((SalariesHistorique)var16.get(var21)).getSalhisCode().isEmpty() && ((SalariesHistorique)var16.get(var21)).getSalhisCode().equals("NBJS")) {
                  var20 = (float)((SalariesHistorique)var16.get(var21)).getSalhisValeurColE();
               }
            }
         }

         float var36 = 0.0F;
         if (var14.size() != 0) {
            new BulletinSalaire();

            for(int var23 = 0; var23 < var14.size(); ++var23) {
               BulletinSalaire var22 = (BulletinSalaire)var14.get(var23);
               String var24 = "";
               float var25 = 0.0F;
               float var26 = 0.0F;
               if (var22.getBulsalContrat() != null && !var22.getBulsalContrat().isEmpty()) {
                  var19 = var6.chargerlesContratsActif(var7, var22.getBulsalContrat(), var13);
                  if (var19 != null) {
                     var24 = var19.getSalconConvention();
                     var25 = var19.getSalconNbJourCp();
                     var26 = var19.getSalconNbJourTr();
                  } else {
                     var24 = var7.getSalConvention();
                     var25 = var7.getSalNbJourCp();
                     var26 = var7.getSalNbJourTr();
                  }
               } else {
                  var24 = var7.getSalConvention();
                  var25 = var7.getSalNbJourCp();
                  var26 = var7.getSalNbJourTr();
               }

               List var17;
               List var18;
               if (var19 != null) {
                  var17 = var5.chargerlesCongesValide(var7, var19.getSalconNum(), var13);
                  var18 = var5.chargerlesAbsencesValide(var7, var19.getSalconNum(), var13);
               } else {
                  var17 = var5.chargerlesCongesValide(var7, "", var13);
                  var18 = var5.chargerlesAbsencesValide(var7, "", var13);
               }

               double var27 = 0.0D;
               double var29 = 0.0D;

               int var31;
               for(var31 = 0; var31 < var15.size(); ++var31) {
                  if (((BulletinLigne)var15.get(var31)).getBulletinSalaire().getBulsalId() == var22.getBulsalId()) {
                     if (((BulletinLigne)var15.get(var31)).getBulligRubrique().equals("100000")) {
                        var27 += ((BulletinLigne)var15.get(var31)).getBulligValColD();
                     } else if (((BulletinLigne)var15.get(var31)).getBulligRubrique().equals("100010")) {
                        if (((BulletinLigne)var15.get(var31)).getBulligValColA() == 0.0D) {
                           ((BulletinLigne)var15.get(var31)).setBulligValColA(this.M000158(var24, var11, var19, var7));
                        }

                        double var32 = ((BulletinLigne)var15.get(var31)).getBulligValColA() - ((BulletinLigne)var15.get(var31)).getBulligValColD();
                        double var34 = var1.myRound(var32 / 8.0D, 2);
                        var27 = (double)((float)(30.0D - var34));
                     } else if (((BulletinLigne)var15.get(var31)).getBulligRubrique().equals("100050")) {
                        var27 -= ((BulletinLigne)var15.get(var31)).getBulligValColD();
                     } else if (((BulletinLigne)var15.get(var31)).getBulligRubrique().equals("208000")) {
                        var29 += ((BulletinLigne)var15.get(var31)).getBulligValColD();
                     }
                  }
               }

               if (var18.size() != 0) {
                  for(var31 = 0; var31 < var18.size(); ++var31) {
                     if (((SalariesConges)var18.get(var31)).getSalcngType() == 0 && ((SalariesConges)var18.get(var31)).getSalcngEtat() == 1 && ((SalariesConges)var18.get(var31)).getSalcngNature() == 13 && ((SalariesConges)var18.get(var31)).getSalcngDateDebut().compareTo(var22.getBulsalDateDebut()) >= 0 && ((SalariesConges)var18.get(var31)).getSalcngDateFin().compareTo(var22.getBulsalDateFin()) <= 0) {
                        var29 += (double)((SalariesConges)var18.get(var31)).getSalcngDuree();
                     }
                  }
               }

               float var37 = 0.0F;
               if (var17.size() != 0) {
                  for(int var38 = 0; var38 < var17.size(); ++var38) {
                     if (((SalariesConges)var17.get(var38)).getSalcngType() == 1 && ((SalariesConges)var17.get(var38)).getSalcngEtat() == 1 && ((SalariesConges)var17.get(var38)).getSalcngNature() == 8 && ((SalariesConges)var17.get(var38)).getSalcngDateDebut().compareTo(var22.getBulsalDateDebut()) >= 0 && ((SalariesConges)var17.get(var38)).getSalcngDateFin().compareTo(var22.getBulsalDateFin()) <= 0) {
                        var37 += ((SalariesConges)var17.get(var38)).getSalcngDuree();
                     }
                  }
               }

               float var39 = var26 / 30.0F;
               float var33 = (float)var1.myRound((double)(var25 / (var26 / var39)) * var27, 2);
               var22.setBulsalNbCpAcquis(var33 + var37);
               var22.setBulsalNbCpPris((float)var29);
               if (var23 == 0) {
                  var22.setBulsalNbDispo(var20 + var22.getBulsalNbCpAcquis() - var22.getBulsalNbCpPris());
                  var36 = var22.getBulsalNbDispo();
                  if (var36 < 0.0F) {
                     var22.setBulsalNbDispo(0.0F);
                     var36 = var22.getBulsalNbDispo();
                  }

                  var2.modif(var22, var13);
                  var13.flush();
               } else {
                  var22.setBulsalNbDispo(var36 + var22.getBulsalNbCpAcquis() - var22.getBulsalNbCpPris());
                  var36 = var22.getBulsalNbDispo();
                  if (var36 < 0.0F) {
                     var22.setBulsalNbDispo(0.0F);
                     var36 = var22.getBulsalNbDispo();
                  }

                  var2.modif(var22, var13);
                  var13.flush();
               }
            }
         }
      }

   }

   public double M000158(String var1, Structure var2, SalariesContrats var3, Salaries var4) {
      double var5 = 0.0D;
      if (var1 != null && !var1.isEmpty()) {
         new ArrayList();
         LectureConventions var8 = new LectureConventions();
         var8.setStrId(var2.getStrid());
         var8.setStructureLog(var2);
         var8.recuperePaye();
         List var7 = var8.getMesConventionsUtils();
         if (var7.size() != 0) {
            for(int var9 = 0; var9 < var7.size(); ++var9) {
               if (var3 != null) {
                  if (((ObjetConvention)var7.get(var9)).getCode().equals(var3.getSalconConvention())) {
                     var5 = (double)((ObjetConvention)var7.get(var9)).getHeure_mois();
                     break;
                  }
               } else if (((ObjetConvention)var7.get(var9)).getCode().equals(var4.getSalConvention())) {
                  var5 = (double)((ObjetConvention)var7.get(var9)).getHeure_mois();
                  break;
               }
            }
         } else {
            var5 = 0.0D;
         }
      } else {
         var5 = 0.0D;
      }

      return var5;
   }

   public void recalculBaseConges(UtilDate var1, UtilNombre var2, List var3, List var4, List var5, PlanPayeDao var6, BulletinSalaireDao var7, SalariesHistoriqueDao var8, BulletinLigneDao var9, Salaries var10, OptionPaye var11, ExercicesPaye var12, String var13, Structure var14, UtilInitHibernate var15, Session var16) throws HibernateException, NamingException, ParseException {
      boolean var17 = false;
      double var18 = 0.0D;
      double var20 = 0.0D;
      double var22 = 0.0D;
      boolean var24 = false;
      Date var25 = null;
      new PlanPaye();
      PlanPaye var26 = var6.chercherCode("208000", var12.getExepayId(), var16);
      if (var26 != null && var26.getPlpCalculBase() != null && !var26.getPlpCalculBase().isEmpty()) {
         var17 = true;
      }

      var3.clear();
      var4.clear();
      var5.clear();
      var3 = var7.chargerlesBulletinsbySalarieExercice(var10, var12, var16);
      if (var3.size() != 0) {
         var5 = var8.chargerlesHistoriquesBySalaries(var10, "", var12, var16);
         if (var5.size() != 0) {
            for(int var27 = 0; var27 < var5.size(); ++var27) {
               if ((long)(((SalariesHistorique)var5.get(var27)).getSalhisDate().getYear() + 1900) == var12.getExepayId() && ((SalariesHistorique)var5.get(var27)).getSalhisCode() != null && !((SalariesHistorique)var5.get(var27)).getSalhisCode().isEmpty()) {
                  if (((SalariesHistorique)var5.get(var27)).getSalhisCode().equals("BRUT")) {
                     var18 += ((SalariesHistorique)var5.get(var27)).getSalhisValeurColE();
                     var25 = var1.dateMoisPrecedent(((SalariesHistorique)var5.get(var27)).getSalhisDate());
                  } else if (((SalariesHistorique)var5.get(var27)).getSalhisCode().equals("PRDCP")) {
                     var18 -= ((SalariesHistorique)var5.get(var27)).getSalhisValeurColE();
                  }
               }
            }
         }

         int var28;
         List var29;
         List var30;
         int var31;
         int var33;
         BulletinSalaire var40;
         double var47;
         float var52;
         if (var3.size() != 0 && !var17) {
            new BulletinSalaire();

            for(var28 = 0; var28 < var3.size(); ++var28) {
               var40 = (BulletinSalaire)var3.get(var28);
               new ArrayList();
               var29 = var9.chargerleslignesbyRubriquesSalaries("208000", var12.getExepayDateDebut(), var40.getBulsalDateDebut(), var10, var16);
               if (var29.size() != 0) {
                  if (var25 != null && var25.compareTo(((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalDateDebut()) < 0) {
                     var25 = ((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
                     var18 = 0.0D;
                     if (var11.getBaseconges().equals("2")) {
                        var20 = ((BulletinLigne)var29.get(var29.size() - 1)).getBulligValColE();
                        new ArrayList();
                        var30 = var9.chargerleslignesbyRubriquesSalaries("208100", var10, var16);
                        if (var30.size() != 0) {
                           for(var31 = 0; var31 < var30.size(); ++var31) {
                              if (((BulletinLigne)var30.get(var31)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalId()) {
                                 var20 += ((BulletinLigne)var30.get(var31)).getBulligValColE();
                              }
                           }
                        }
                     }
                  } else {
                     var25 = ((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
                     var18 = 0.0D;
                     if (var11.getBaseconges().equals("2")) {
                        var20 = ((BulletinLigne)var29.get(var29.size() - 1)).getBulligValColE();
                        new ArrayList();
                        var30 = var9.chargerleslignesbyRubriquesSalaries("208100", var10, var16);
                        if (var30.size() != 0) {
                           for(var31 = 0; var31 < var30.size(); ++var31) {
                              if (((BulletinLigne)var30.get(var31)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalId()) {
                                 var20 += ((BulletinLigne)var30.get(var31)).getBulligValColE();
                              }
                           }
                        }
                     }
                  }
               }

               if (var25 == null) {
                  var25 = var1.stringToDateSQLLight("2000-01-01");
               } else if (!var24) {
                  var25 = var1.dateMoisSuivant(var25);
                  var24 = true;
               }

               double var42 = 0.0D;
               new ArrayList();
               List var45 = var9.chargerleslignesbyRubriquesSalaries("299999", var25, var40.getBulsalDateDebut(), var10, var16);
               if (var45.size() != 0) {
                  for(var33 = 0; var33 < var45.size(); ++var33) {
                     var42 += ((BulletinLigne)var45.get(var33)).getBulligValColE();
                  }
               }

               var47 = 0.0D;
               double var51 = 0.0D;
               var52 = 0.0F;
               var4 = var9.chargerleslignesBulletin(var40, var16);
               new BulletinLigne();

               for(int var39 = 0; var39 < var4.size(); ++var39) {
                  BulletinLigne var38 = (BulletinLigne)var4.get(var39);
                  if (var38.getBulligRubrique().equals("208000")) {
                     var47 = var38.getBulligValColD();
                     var51 = var38.getBulligValColE();
                  }

                  if (var38.getBulligRubrique().equals("100000")) {
                     var52 = (float)(30.0D - var38.getBulligValColD());
                  } else if (var38.getBulligRubrique().equals("100050")) {
                     var52 = (float)((double)var52 + var38.getBulligValColD());
                  }
               }

               var22 = var18 + var42 + var20;
               if (var40.getBulsalCP() != 0.0D) {
                  var40.setBulsalBrut(var40.getBulsalBrut());
                  if (var40.getBulsalBrut() <= 0.0D) {
                     var22 = 0.0D;
                  } else {
                     var22 = var40.getBulsalBrut();
                  }
               }

               var40 = var7.pourParapheur(var40.getBulsalId(), var16);
               if (var40 != null) {
                  var40.setBulsalBrut(var22);
                  var40.setBulsalNbCpPris((float)var47);
                  if (var47 < 30.0D) {
                     if (var40.getSalaries().getSalNbJourTr() != 0.0F) {
                        float var53 = (var40.getSalaries().getSalNbJourTr() - var52) / 30.0F;
                        var40.setBulsalNbCpAcquis((float)((double)(var40.getSalaries().getSalNbJourCp() / (var40.getSalaries().getSalNbJourTr() / var53)) * (30.0D - var47)));
                     } else {
                        var40.setBulsalNbCpAcquis(var40.getSalaries().getSalNbJourCp());
                     }
                  } else {
                     var40.setBulsalNbCpAcquis(0.0F);
                  }

                  var40.setBulsalCP(var51);
                  var7.modif(var40, var16);
                  var16.flush();
               }
            }
         } else if (var3.size() != 0 && var17) {
            new BulletinSalaire();

            for(var28 = 0; var28 < var3.size(); ++var28) {
               var40 = (BulletinSalaire)var3.get(var28);
               new ArrayList();
               var29 = var9.chargerleslignesbyRubriquesSalaries("208000", var12.getExepayDateDebut(), var40.getBulsalDateDebut(), var10, var16);
               if (var29.size() != 0) {
                  if (var25 != null && var25.compareTo(((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalDateDebut()) < 0) {
                     var25 = ((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
                     var18 = 0.0D;
                     if (var11.getBaseconges().equals("2")) {
                        var20 = ((BulletinLigne)var29.get(var29.size() - 1)).getBulligValColE();
                        new ArrayList();
                        var30 = var9.chargerleslignesbyRubriquesSalaries("208100", var10, var16);
                        if (var30.size() != 0) {
                           for(var31 = 0; var31 < var30.size(); ++var31) {
                              if (((BulletinLigne)var30.get(var31)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalId()) {
                                 var20 += ((BulletinLigne)var30.get(var31)).getBulligValColE();
                              }
                           }
                        }
                     }
                  } else {
                     var25 = ((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalDateDebut();
                     var18 = 0.0D;
                     if (var11.getBaseconges().equals("2")) {
                        var20 = ((BulletinLigne)var29.get(var29.size() - 1)).getBulligValColE();
                        new ArrayList();
                        var30 = var9.chargerleslignesbyRubriquesSalaries("208100", var10, var16);
                        if (var30.size() != 0) {
                           for(var31 = 0; var31 < var30.size(); ++var31) {
                              if (((BulletinLigne)var30.get(var31)).getBulletinSalaire().getBulsalId() == ((BulletinLigne)var29.get(var29.size() - 1)).getBulletinSalaire().getBulsalId()) {
                                 var20 += ((BulletinLigne)var30.get(var31)).getBulligValColE();
                              }
                           }
                        }
                     }
                  }
               }

               if (var25 == null) {
                  var25 = var1.stringToDateSQLLight("2000-01-01");
               } else if (!var24) {
                  var25 = var1.dateMoisSuivant(var25);
                  var24 = true;
               }

               var22 = var20 + var18;
               String var41 = var26.getPlpCalculBase();
               int var37;
               if (var41 != null && !var41.isEmpty()) {
                  String var32;
                  String[] var43;
                  if (!var41.contains("#")) {
                     var43 = var41.split(":");
                     var32 = "'" + var43[0] + "'";
                     float var46 = Float.parseFloat(var43[2]);
                     var4 = var9.chargerleslignesLikeRubriquesSalaries(var32, var25, var40.getBulsalDateDebut(), var10, var16);
                     if (var4.size() != 0) {
                        for(int var48 = 0; var48 < var4.size(); ++var48) {
                           if (var46 == 100.0F) {
                              var22 += var2.myRoundDevise(((BulletinLigne)var4.get(var48)).getBulligValColE(), var14.getStrdevise());
                           } else if (var46 == -100.0F) {
                              var22 -= var2.myRoundDevise(((BulletinLigne)var4.get(var48)).getBulligValColE(), var14.getStrdevise());
                           } else {
                              var22 += var2.myRoundDevise(((BulletinLigne)var4.get(var48)).getBulligValColE() * (double)var46 / 100.0D, var14.getStrdevise());
                           }
                        }
                     }
                  } else {
                     var43 = var41.split("#");
                     var32 = "";
                     var33 = 0;

                     label266:
                     while(true) {
                        String[] var34;
                        String var35;
                        if (var33 >= var43.length) {
                           var4 = var9.chargerleslignesLikeRubriquesSalaries(var32, var25, var40.getBulsalDateDebut(), var10, var16);
                           if (var4.size() == 0) {
                              break;
                           }

                           var33 = 0;

                           while(true) {
                              if (var33 >= var43.length) {
                                 break label266;
                              }

                              var34 = var43[var33].split(":");
                              var35 = var34[0];
                              float var36 = Float.parseFloat(var34[2]);

                              for(var37 = 0; var37 < var4.size(); ++var37) {
                                 if (((BulletinLigne)var4.get(var37)).getBulligRubrique().equals(var35)) {
                                    if (var36 == 100.0F) {
                                       var22 += var2.myRoundDevise(((BulletinLigne)var4.get(var37)).getBulligValColE(), var14.getStrdevise());
                                    } else if (var36 == -100.0F) {
                                       var22 -= var2.myRoundDevise(((BulletinLigne)var4.get(var37)).getBulligValColE(), var14.getStrdevise());
                                    } else {
                                       var22 += var2.myRoundDevise(((BulletinLigne)var4.get(var37)).getBulligValColE() * (double)var36 / 100.0D, var14.getStrdevise());
                                    }
                                 }
                              }

                              ++var33;
                           }
                        }

                        var34 = var43[var33].split(":");
                        var35 = var34[0];
                        if (var32 != null && !var32.isEmpty()) {
                           var32 = var32 + ",'" + var35 + "'";
                        } else {
                           var32 = "'" + var35 + "'";
                        }

                        ++var33;
                     }
                  }
               }

               double var44 = 0.0D;
               var47 = 0.0D;
               float var49 = 0.0F;
               var4 = var9.chargerleslignesBulletin(var40, var16);
               new BulletinLigne();

               for(var37 = 0; var37 < var4.size(); ++var37) {
                  BulletinLigne var50 = (BulletinLigne)var4.get(var37);
                  if (var50.getBulligRubrique().equals("208000")) {
                     var44 = var50.getBulligValColD();
                     var47 = var50.getBulligValColE();
                  }

                  if (var50.getBulligRubrique().equals("100000")) {
                     var49 = (float)(30.0D - var50.getBulligValColD());
                  } else if (var50.getBulligRubrique().equals("100050")) {
                     var49 = (float)((double)var49 + var50.getBulligValColD());
                  }
               }

               if (var40.getBulsalCP() != 0.0D) {
                  var40.setBulsalBrut(var40.getBulsalBrut());
                  if (var40.getBulsalBrut() <= 0.0D) {
                     var22 = 0.0D;
                  } else {
                     var22 = var40.getBulsalBrut();
                  }
               }

               var40 = var7.pourParapheur(var40.getBulsalId(), var16);
               if (var40 != null) {
                  var40.setBulsalBrut(var22);
                  var40.setBulsalNbCpPris((float)var44);
                  if (var44 < 30.0D) {
                     if (var40.getSalaries().getSalNbJourTr() != 0.0F) {
                        var52 = (var40.getSalaries().getSalNbJourTr() - var49) / 30.0F;
                        var40.setBulsalNbCpAcquis((float)((double)(var40.getSalaries().getSalNbJourCp() / (var40.getSalaries().getSalNbJourTr() / var52)) * (30.0D - var44)));
                     } else {
                        var40.setBulsalNbCpAcquis(var40.getSalaries().getSalNbJourCp());
                     }
                  } else {
                     var40.setBulsalNbCpAcquis(0.0F);
                  }

                  var40.setBulsalCP(var47);
                  var7.modif(var40, var16);
                  var16.flush();
               }
            }
         }
      }

   }

   public void recopieVariablesM(Salaries var1, List var2, String var3, String var4, UtilDate var5, OptionPaye var6, ExercicesPaye var7, String var8, Structure var9, UtilInitHibernate var10, Session var11) throws HibernateException, NamingException, ParseException {
      new ArrayList();
      SalariesVariablesDao var13 = new SalariesVariablesDao(var8, var10);
      List var12 = var13.chargerlesVariables(var1, var3, var11);
      if (var12.size() != 0) {
         new SalariesVariables();
         new SalariesVariables();
         new SalariesVariables();

         for(int var17 = 0; var17 < var12.size(); ++var17) {
            SalariesVariables var16 = (SalariesVariables)var12.get(var17);
            SalariesVariables var14 = new SalariesVariables();
            var14.setPlanPaye((PlanPaye)null);
            if (var2.size() != 0) {
               for(int var18 = 0; var18 < var2.size(); ++var18) {
                  if (((PlanPaye)var2.get(var18)).getPlpCode().equals(var16.getSalvarCode())) {
                     var14.setPlanPaye((PlanPaye)var2.get(var18));
                     break;
                  }
               }
            }

            if (var14.getPlanPaye() != null) {
               var14.setSalaries(var16.getSalaries());
               var14.setSalvarCode(var16.getSalvarCode());
               var14.setSalvarContrat(var16.getSalvarContrat());
               var14.setSalvarFeuille(var16.getSalvarFeuille());
               var14.setSalvarJour((Date)null);
               var14.setSalvarPeriode(var4);
               var14.setSalvarValeurColA(var16.getSalvarValeurColA());
               var14.setSalvarValeurColB(var16.getSalvarValeurColB());
               var14.setSalvarValeurColC(var16.getSalvarValeurColC());
               var14.setSalvarValeurColD(var16.getSalvarValeurColD());
               var14.setSalvarValeurColE(var16.getSalvarValeurColE());
               var14.setSalvarVariableA(var16.isSalvarVariableA());
               var14.setSalvarVariableB(var16.isSalvarVariableB());
               var14.setSalvarVariableC(var16.isSalvarVariableC());
               var14.setSalvarVariableD(var16.isSalvarVariableD());
               var14.setSalvarVariableE(var16.isSalvarVariableE());
               SalariesVariables var15 = var13.chargerlesVariablesPeriodeRubrique(var16.getSalaries(), var4, var16.getSalvarContrat(), var16.getSalvarCode(), var11);
               if (var15 == null) {
                  var13.insert(var14, var11);
               }
            }
         }
      }

      new ArrayList();
      SalariesElementsDao var21 = new SalariesElementsDao(var8, var10);
      List var20 = var21.chargerlesElements(var1, var3, var11);
      if (var20.size() != 0) {
         new SalariesElements();
         new SalariesElements();
         new SalariesElements();

         for(int var19 = 0; var19 < var20.size(); ++var19) {
            SalariesElements var24 = (SalariesElements)var20.get(var19);
            SalariesElements var22 = new SalariesElements();
            var22.setEffectue(var24.isEffectue());
            var22.setSalaries(var24.getSalaries());
            var22.setSaleleActivite(var24.getSaleleActivite());
            var22.setSaleleBudget(var24.getSaleleBudget());
            var22.setSaleleCentresImpots(var24.getSaleleCentresImpots());
            var22.setSaleleCentresSecurite(var24.getSaleleCentresSecurite());
            var22.setSaleleCivilite(var24.getSaleleCivilite());
            var22.setSaleleClassement(var24.getSaleleClassement());
            var22.setSaleleCle1Anal(var24.getSaleleCle1Anal());
            var22.setSaleleCle2Anal(var24.getSaleleCle2Anal());
            var22.setSaleleCleBanque(var24.getSaleleCleBanque());
            var22.setSaleleCompteBanque(var24.getSaleleCompteBanque());
            var22.setSaleleCompteMembre(var24.getSaleleCompteMembre());
            var22.setSaleleContrat(var24.getSaleleContrat());
            var22.setSaleleConvention(var24.getSaleleConvention());
            var22.setSaleleDateConcubinage(var24.getSaleleDateConcubinage());
            var22.setSaleleDateDivorce(var24.getSaleleDateDivorce());
            var22.setSaleleDateEntree(var24.getSaleleDateEntree());
            var22.setSaleleDateMarie(var24.getSaleleDateMarie());
            var22.setSaleleDatePacs(var24.getSaleleDatePacs());
            var22.setSaleleDateSortie(var24.getSaleleDateSortie());
            var22.setSaleleDateVeuf(var24.getSaleleDateVeuf());
            var22.setSaleleDepartement(var24.getSaleleDepartement());
            var22.setSaleleDureeJour(var24.getSaleleDureeJour());
            var22.setSaleleEtat(var24.getSaleleEtat());
            var22.setSaleleFeuille(var24.getSaleleFeuille());
            var22.setSaleleFonction(var24.getSaleleFonction());
            var22.setSaleleGenre(var24.getSaleleGenre());
            var22.setSaleleGrille(var24.getSaleleGrille());
            var22.setSaleleGuichetBanque(var24.getSaleleGuichetBanque());
            var22.setSaleleIban(var24.getSaleleIban());
            var22.setSaleleJour(var24.getSaleleJour());
            var22.setSaleleLibCentresImpots(var24.getSaleleLibCentresImpots());
            var22.setSaleleLibCentresSecurite(var24.getSaleleLibCentresSecurite());
            var22.setSaleleLibClassement(var24.getSaleleLibClassement());
            var22.setSaleleLibCle1Anal(var24.getSaleleLibCle1Anal());
            var22.setSaleleLibCle2Anal(var24.getSaleleLibCle2Anal());
            var22.setSaleleLibConvention(var24.getSaleleLibConvention());
            var22.setSaleleLibGrille(var24.getSaleleLibGrille());
            var22.setSaleleLibNivEmploi(var24.getSaleleLibNivEmploi());
            var22.setSaleleLibService(var24.getSaleleLibService());
            var22.setSaleleLocalisation(var24.getSaleleLocalisation());
            var22.setSaleleMatricule(var24.getSaleleMatricule());
            var22.setSaleleModeReglement(var24.getSaleleModeReglement());
            var22.setSaleleModeSolde(var24.getSaleleModeSolde());
            var22.setSaleleMotifSortie(var24.getSaleleMotifSortie());
            var22.setSaleleNature(var24.getSaleleNature());
            var22.setSaleleNbEnfant(var24.getSaleleNbEnfant());
            var22.setSaleleNbFemme(var24.getSaleleNbFemme());
            var22.setSaleleNbJourCp(var24.getSaleleNbJourCp());
            var22.setSaleleNbJourTr(var24.getSaleleNbJourTr());
            var22.setSaleleNbPartFiscal(var24.getSaleleNbPartFiscal());
            var22.setSaleleNbPartTrimf(var24.getSaleleNbPartTrimf());
            var22.setSaleleNivEmploi(var24.getSaleleNivEmploi());
            var22.setSaleleNumBanque(var24.getSaleleNumBanque());
            var22.setSaleleParc(var24.getSaleleParc());
            var22.setSalelePeriode(var4);
            var22.setSaleleService(var24.getSaleleService());
            var22.setSaleleSitFamille(var24.getSaleleSitFamille());
            var22.setSaleleSite(var24.getSaleleSite());
            var22.setSaleleSwift(var24.getSaleleSwift());
            SalariesElements var23 = var21.chargerlesVariablesPeriode(var24.getSalaries(), var4, var24.getSaleleContrat(), var11);
            if (var23 == null) {
               var21.insert(var22, var11);
            }
         }
      }

   }

   public void geneationContratSalaries(boolean var1, Salaries var2, SalariesContrats var3, SalariesContratsDao var4, Users var5, Session var6) {
      var3.setSalaries(var2);
      var3.setSalconActivite(var2.getSalActivite());
      var3.setSalconCentresImpots(var2.getSalCentresImpots());
      var3.setSalconLibCentresImpots(var2.getSalLibCentresImpots());
      var3.setSalconCentresSecurite(var2.getSalCentresSecurite());
      var3.setSalconClassement(var2.getSalClassement());
      var3.setSalconLibClassement(var2.getSalLibClassement());
      var3.setSalconCle1Anal(var2.getSalCleAnal1());
      var3.setSalconLibCle1Anal(var2.getSalLibCleAnal1());
      var3.setSalconCle2Anal(var2.getSalCleAnal2());
      var3.setSalconLibCle2Anal(var2.getSalLibCleAnal2());
      var3.setSalconConvention(var2.getSalConvention());
      var3.setSalconLibConvention(var2.getSalLibConvention());
      var3.setSalconCodeEmploi(var2.getSalCodeEmploi());
      var3.setSalconDepartement(var2.getSalDepartement());
      var3.setSalconEtat(var2.getSalEtat());
      var3.setSalconEtatH(1);
      var3.setSalconDateDebut(var2.getSalDateEntree());
      var3.setSalconFonction(var2.getSalFonction());
      var3.setSalconFeuille(var2.getSalFeuille());
      var3.setSalconGrille(var2.getSalGrille());
      var3.setSalconLibGrille(var2.getSalLibGrille());
      var3.setSalconNivEmploi(var2.getSalNivEmploi());
      var3.setSalconLibNivEmploi(var2.getSalLibNivEmploi());
      var3.setSalconService(var2.getSalService());
      var3.setSalconSite(var2.getSalSite());
      var3.setSalconType(var2.getSalNature());
      if (!var1) {
         var3.setSalconDateCreat(new Date());
         var3.setSalconDateFin(var2.getSalDateSortie());
         var3.setSalconMotifSortie(var2.getSalMotifSortie());
         var3.setSalconNum("" + var2.getSalId());
         var3.setSalconUserCreat(var5.getUsrid());
         var4.insert(var3, var6);
      } else {
         var3.setSalconDateModif(new Date());
         var3.setSalconUserModif(var5.getUsrid());
         var4.modif(var3, var6);
      }

   }

   public void moveDossierRH(Structure var1) throws IOException {
      UtilDownload var2 = new UtilDownload();
      File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1.getStrid() + File.separator + "paye" + File.separator + "rh" + File.separator);
      File var4 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1.getStrid() + File.separator + "photos" + File.separator + "rh" + File.separator);
      File var5 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1.getStrid() + File.separator + "paye" + File.separator + "contrat" + File.separator);
      File var6 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + var1.getStrid() + File.separator + "photos" + File.separator + "rhContrat" + File.separator);
      if (!var4.exists()) {
         var4.mkdir();
      }

      if (!var6.exists()) {
         var6.mkdir();
      }

      if (var3.exists()) {
         var2.move(var3, var4);
      }

      if (var5.exists()) {
         var2.move(var5, var6);
      }

   }

   public void recalculSalarieRH(Salaries var1, SalariesGrh var2, SalariesGrhDao var3, UtilDate var4, OptionPaye var5, String var6, Structure var7, UtilInitHibernate var8, Session var9) throws HibernateException, NamingException {
      if (var1 != null) {
         new ArrayList();
         List var10 = var3.chargerlesElementRh(var1, var9);
         if (var10.size() != 0) {
            for(int var11 = 0; var11 < var10.size(); ++var11) {
               var2 = (SalariesGrh)var10.get(var11);
               if (var2.getSalgrhType() == 0 || var2.getSalgrhNature() >= 1 && var2.getSalgrhNature() <= 35) {
                  if (var2.getSalgrhNature() != 0 && var2.getSalgrhNature() != 100) {
                     if (var2.getSalgrhNature() == 1) {
                        var2.setSalgrhNature(0);
                        var2.setSalgrhType(1);
                     } else if (var2.getSalgrhNature() == 2) {
                        var2.setSalgrhNature(84);
                        var2.setSalgrhType(8400);
                     } else {
                        String var12;
                        if (var2.getSalgrhNature() == 3) {
                           var2.setSalgrhNature(83);
                           if (var2.getSalgrhObjet() != null && !var2.getSalgrhObjet().isEmpty()) {
                              var12 = var2.getSalgrhObjet().toLowerCase();
                              if (var12.contains("cong")) {
                                 var2.setSalgrhType(8300);
                              } else if (var12.contains("logement")) {
                                 var2.setSalgrhType(8301);
                              } else if (var12.contains("emploi")) {
                                 var2.setSalgrhType(8302);
                              } else if (var12.contains("endettement")) {
                                 var2.setSalgrhType(8303);
                              } else {
                                 var2.setSalgrhType(8399);
                              }
                           } else {
                              var2.setSalgrhType(8399);
                           }
                        } else if (var2.getSalgrhNature() == 4) {
                           var2.setSalgrhNature(86);
                           var2.setSalgrhType(8601);
                        } else if (var2.getSalgrhNature() == 5) {
                           var2.setSalgrhNature(85);
                           if (var2.getSalgrhObjet() != null && !var2.getSalgrhObjet().isEmpty()) {
                              var12 = var2.getSalgrhObjet().toLowerCase();
                              if (var12.contains("embauche")) {
                                 var2.setSalgrhType(8500);
                              } else if (var12.contains("travail")) {
                                 var2.setSalgrhType(8501);
                              } else if (var12.contains("cession")) {
                                 var2.setSalgrhType(8502);
                              } else if (var12.contains("aptitude")) {
                                 var2.setSalgrhType(8503);
                              } else if (var12.contains("stage")) {
                                 var2.setSalgrhType(8504);
                              } else if (var12.contains("obtention")) {
                                 var2.setSalgrhType(8505);
                              } else if (var12.contains("dical")) {
                                 var2.setSalgrhType(8506);
                              } else {
                                 var2.setSalgrhType(8599);
                              }
                           } else {
                              var2.setSalgrhType(8599);
                           }
                        } else if (var2.getSalgrhNature() == 6) {
                           var2.setSalgrhNature(84);
                           var2.setSalgrhType(8402);
                        } else if (var2.getSalgrhNature() == 7) {
                           var2.setSalgrhNature(86);
                           var2.setSalgrhType(8604);
                        } else if (var2.getSalgrhNature() == 8) {
                           var2.setSalgrhNature(86);
                           var2.setSalgrhType(8699);
                        } else if (var2.getSalgrhNature() == 9) {
                           var2.setSalgrhNature(84);
                           var2.setSalgrhType(8401);
                        } else if (var2.getSalgrhNature() == 10) {
                           var2.setSalgrhNature(86);
                           var2.setSalgrhType(8606);
                        } else if (var2.getSalgrhNature() == 11) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(11);
                        } else if (var2.getSalgrhNature() == 12) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(12);
                        } else if (var2.getSalgrhNature() == 13) {
                           var2.setSalgrhNature(86);
                           var2.setSalgrhType(8607);
                        } else if (var2.getSalgrhNature() == 14) {
                           var2.setSalgrhNature(84);
                           var2.setSalgrhType(8403);
                        } else if (var2.getSalgrhNature() == 15) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(15);
                        } else if (var2.getSalgrhNature() == 16) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(16);
                        } else if (var2.getSalgrhNature() == 17) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(17);
                        } else if (var2.getSalgrhNature() == 18) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(18);
                        } else if (var2.getSalgrhNature() == 19) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(99);
                        } else if (var2.getSalgrhNature() == 20) {
                           var2.setSalgrhNature(84);
                           var2.setSalgrhType(8404);
                        } else if (var2.getSalgrhNature() == 21) {
                           var2.setSalgrhNature(84);
                           var2.setSalgrhType(8406);
                        } else if (var2.getSalgrhNature() == 22) {
                           var2.setSalgrhNature(84);
                           var2.setSalgrhType(8405);
                        } else if (var2.getSalgrhNature() == 23) {
                           var2.setSalgrhNature(84);
                           var2.setSalgrhType(8407);
                        } else if (var2.getSalgrhNature() == 24) {
                           var2.setSalgrhNature(84);
                           var2.setSalgrhType(8409);
                        } else if (var2.getSalgrhNature() == 25) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(25);
                        } else if (var2.getSalgrhNature() == 26) {
                           var2.setSalgrhNature(86);
                           var2.setSalgrhType(8617);
                        } else if (var2.getSalgrhNature() == 27) {
                           var2.setSalgrhNature(86);
                           var2.setSalgrhType(8618);
                        } else if (var2.getSalgrhNature() == 28) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(28);
                        } else if (var2.getSalgrhNature() == 29) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(99);
                        } else if (var2.getSalgrhNature() == 30) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(30);
                        } else if (var2.getSalgrhNature() == 31) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(99);
                        } else if (var2.getSalgrhNature() == 32) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(99);
                        } else if (var2.getSalgrhNature() == 33) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(99);
                        } else if (var2.getSalgrhNature() == 34) {
                           var2.setSalgrhNature(0);
                           var2.setSalgrhType(99);
                        } else if (var2.getSalgrhNature() == 35) {
                           var2.setSalgrhNature(84);
                           var2.setSalgrhType(8410);
                        }
                     }
                  } else {
                     var2.setSalgrhNature(0);
                     var2.setSalgrhType(99);
                  }

                  var3.modif(var2, var9);
                  var9.flush();
               }
            }
         }
      }

   }

   public void effacerVariablesDoublons(String var1, Date var2, Date var3, String var4, ExercicesPaye var5, String var6, Structure var7, UtilInitHibernate var8, Session var9) throws HibernateException, NamingException {
      String var10 = "";
      byte var11 = 0;
      new OptionPaye();
      LireLesoptionsPaye var13 = new LireLesoptionsPaye();
      var13.setStrId(var7.getStrid());
      OptionPaye var12 = var13.lancer();
      if (var12.getModeTravail().equals("0")) {
         var11 = 0;
      } else if (var12.getModeTravail().equals("1")) {
         var11 = 1;
      } else if (var12.getModeTravail().equals("2")) {
         var11 = 2;
      } else if (var12.getModeTravail().equals("3")) {
         var11 = 3;
      } else if (var12.getModeTravail().equals("4")) {
         var11 = 4;
      }

      new Salaries();
      new SalariesContrats();
      SalariesContratsDao var16 = new SalariesContratsDao(var6, var8);
      new PlanPayeDao(var6, var8);
      SalariesVariablesDao var18 = new SalariesVariablesDao(var6, var8);
      new SalariesVariables();
      new ArrayList();
      List var20 = var18.chargerlesVariablesFeuille(var1, var2, var3, var4, var9);
      if (var20.size() != 0) {
         new PlanPaye();
         ArrayList var22 = new ArrayList();

         int var23;
         for(var23 = 0; var23 < var20.size(); ++var23) {
            long var24 = ((SalariesVariables)var20.get(var23)).getSalaries().getSalId();
            if (var22.size() == 0) {
               var22.add(((SalariesVariables)var20.get(var23)).getSalaries());
            } else {
               boolean var26 = false;

               for(int var27 = 0; var27 < var22.size(); ++var27) {
                  if (((Salaries)var22.get(var27)).getSalId() == var24) {
                     var26 = true;
                     break;
                  }
               }

               if (!var26) {
                  var22.add(((SalariesVariables)var20.get(var23)).getSalaries());
               }
            }
         }

         for(var23 = 0; var23 < var22.size(); ++var23) {
            Salaries var14 = (Salaries)var22.get(var23);
            ArrayList var30 = new ArrayList();

            for(int var25 = 0; var25 < var20.size(); ++var25) {
               if (((SalariesVariables)var20.get(var25)).getSalaries().getSalId() == var14.getSalId()) {
                  var30.add(var20.get(var25));
               }
            }

            String var31 = "";

            for(int var32 = 0; var32 < var30.size(); ++var32) {
               SalariesVariables var19 = (SalariesVariables)var30.get(var32);
               PlanPaye var21 = var19.getPlanPaye();
               long var33 = var19.getSalvarId();
               if (var21 != null) {
                  if (var21.getExercicesPaye().getExepayId() != var5.getExepayId()) {
                     var18.delete(var19, var9);
                  } else {
                     SalariesContrats var15 = var16.chargerlesContratsActif(var14, var19.getSalvarContrat(), var9);
                     if (var15 != null) {
                        if (var11 == 0) {
                           var10 = var15.getSalconFeuille();
                        } else if (var11 == 1) {
                           var10 = var15.getSalconActivite();
                        } else if (var11 == 2) {
                           var10 = var15.getSalconService();
                        } else if (var11 == 3) {
                           var10 = "";
                        } else if (var11 == 4) {
                           var10 = "" + var15.getSalconIdTiers();
                        }
                     } else if (var11 == 0) {
                        var10 = var14.getSalFeuille();
                     } else if (var11 == 1) {
                        var10 = var14.getSalActivite();
                     } else if (var11 == 2) {
                        var10 = var14.getSalService();
                     } else if (var11 == 3) {
                        var10 = "";
                     } else if (var11 == 4) {
                        var10 = "" + var15.getSalconIdTiers();
                     }

                     if (var19.getSalvarFeuille() == null || var19.getSalvarFeuille().isEmpty() || var19.getSalvarFeuille() != null && !var19.getSalvarFeuille().isEmpty() && !var19.getSalvarFeuille().equals(var10)) {
                        var19 = var18.pourParapheur(var33, var9);
                        if (var19 != null) {
                           var19.setSalvarFeuille(var10);
                           var19 = var18.modif(var19, var9);
                        }
                     }

                     var31 = var19.getSalvarCode();
                     if (var31 != null && !var31.isEmpty()) {
                        for(int var29 = var32 + 1; var29 < var30.size(); ++var29) {
                           var19 = (SalariesVariables)var30.get(var29);
                           if (var19.getSalvarCode() != null && !var19.getSalvarCode().isEmpty() && var19.getSalvarCode().equals(var31)) {
                              var19 = var18.pourParapheur(var33, var9);
                              if (var19 != null) {
                                 var18.delete(var19, var9);
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

   public void recopieMatriculeBulletinElement1(String var1, UtilInitHibernate var2, Session var3) throws HibernateException, NamingException, ParseException {
      BulletinSalaireDao var4 = new BulletinSalaireDao(var1, var2);
      new ArrayList();
      new BulletinSalaire();
      List var5 = var4.chargerlesBulletins(var3);
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            BulletinSalaire var6 = (BulletinSalaire)var5.get(var7);
            var6.setBulsalCivilite(var6.getSalaries().getSalCivilite());
            var6.setBulsalGenre(var6.getSalaries().getSalGenre());
            var6.setBulsalNbEnfant(var6.getSalaries().getSalNbEnfant());
            var6.setBulsalNbPartFiscal(var6.getSalaries().getSalNbPartFiscal());
            var6.setBulsalNbPartTrimf(var6.getSalaries().getSalNbPartTrimf());
            if ((var6.getBulsalMatricule() == null || var6.getBulsalMatricule().isEmpty() || var6.getBulsalNature() == null || var6.getBulsalNature().isEmpty()) && var6.getSalaries().getSalMatricule() != null && !var6.getSalaries().getSalMatricule().isEmpty() && var6.getSalaries().getSalNature() != null && !var6.getSalaries().getSalNature().isEmpty()) {
               var6.setBulsalMatricule(var6.getSalaries().getSalMatricule());
               var6.setBulsalNature(var6.getSalaries().getSalNature());
            }

            if ((var6.getBulsalConvention() == null || var6.getBulsalConvention().isEmpty()) && var6.getSalaries().getSalConvention() != null && !var6.getSalaries().getSalConvention().isEmpty()) {
               var6.setBulsalConvention(var6.getSalaries().getSalConvention());
               var6.setBulsalLibConvention(var6.getSalaries().getSalLibConvention());
            }

            if ((var6.getBulsalCentresImpots() == null || var6.getBulsalCentresImpots().isEmpty()) && var6.getSalaries().getSalCentresImpots() != null && !var6.getSalaries().getSalCentresImpots().isEmpty()) {
               var6.setBulsalCentresImpots(var6.getSalaries().getSalCentresImpots());
               var6.setBulsalLibCentresImpots(var6.getSalaries().getSalLibCentresImpots());
            }

            if ((var6.getBulsalCentresSecurite() == null || var6.getBulsalCentresSecurite().isEmpty()) && var6.getSalaries().getSalCentresSecurite() != null && !var6.getSalaries().getSalCentresSecurite().isEmpty()) {
               var6.setBulsalCentresSecurite(var6.getSalaries().getSalCentresSecurite());
               var6.setBulsalLibCentresSecurite(var6.getSalaries().getSalLibCentresSecurite());
            }

            if ((var6.getBulsalClassement() == null || var6.getBulsalClassement().isEmpty()) && var6.getSalaries().getSalClassement() != null && !var6.getSalaries().getSalClassement().isEmpty()) {
               var6.setBulsalClassement(var6.getSalaries().getSalClassement());
               var6.setBulsalLibClassement(var6.getSalaries().getSalLibClassement());
            }

            if ((var6.getBulsalNivEmploi() == null || var6.getBulsalNivEmploi().isEmpty()) && var6.getSalaries().getSalNivEmploi() != null && !var6.getSalaries().getSalNivEmploi().isEmpty()) {
               var6.setBulsalNivEmploi(var6.getSalaries().getSalNivEmploi());
               var6.setBulsalLibNivEmploi(var6.getSalaries().getSalLibNivEmploi());
            }

            if ((var6.getBulsalGrille() == null || var6.getBulsalGrille().isEmpty()) && var6.getSalaries().getSalGrille() != null && !var6.getSalaries().getSalGrille().isEmpty()) {
               var6.setBulsalGrille(var6.getSalaries().getSalGrille());
               var6.setBulsalLibGrille(var6.getSalaries().getSalLibGrille());
            }

            var4.modif(var6, var3);
         }
      }

   }

   public void recopieMatriculeBulletinElement2(String var1, UtilInitHibernate var2, Session var3) throws HibernateException, NamingException, ParseException {
      SalariesElementsDao var4 = new SalariesElementsDao(var1, var2);
      new ArrayList();
      new SalariesElements();
      List var5 = var4.chargerlesElements(var3);
      if (var5.size() != 0) {
         for(int var7 = 0; var7 < var5.size(); ++var7) {
            SalariesElements var6 = (SalariesElements)var5.get(var7);
            var6.setSaleleCivilite(var6.getSalaries().getSalCivilite());
            var6.setSaleleGenre(var6.getSalaries().getSalGenre());
            var6.setSaleleNbEnfant(var6.getSalaries().getSalNbEnfant());
            var6.setSaleleNbPartFiscal(var6.getSalaries().getSalNbPartFiscal());
            var6.setSaleleNbPartTrimf(var6.getSalaries().getSalNbPartTrimf());
            if ((var6.getSaleleMatricule() == null || var6.getSaleleMatricule().isEmpty() || var6.getSaleleNature() == null || var6.getSaleleNature().isEmpty()) && var6.getSalaries().getSalMatricule() != null && !var6.getSalaries().getSalMatricule().isEmpty() && var6.getSalaries().getSalNature() != null && !var6.getSalaries().getSalNature().isEmpty()) {
               var6.setSaleleMatricule(var6.getSalaries().getSalMatricule());
               var6.setSaleleNature(var6.getSalaries().getSalNature());
            }

            if ((var6.getSaleleConvention() == null || var6.getSaleleConvention().isEmpty()) && var6.getSalaries().getSalConvention() != null && !var6.getSalaries().getSalConvention().isEmpty()) {
               var6.setSaleleConvention(var6.getSalaries().getSalConvention());
               var6.setSaleleLibConvention(var6.getSalaries().getSalLibConvention());
            }

            if ((var6.getSaleleCentresImpots() == null || var6.getSaleleCentresImpots().isEmpty()) && var6.getSalaries().getSalCentresImpots() != null && !var6.getSalaries().getSalCentresImpots().isEmpty()) {
               var6.setSaleleCentresImpots(var6.getSalaries().getSalCentresImpots());
               var6.setSaleleLibCentresImpots(var6.getSalaries().getSalLibCentresImpots());
            }

            if ((var6.getSaleleCentresSecurite() == null || var6.getSaleleCentresSecurite().isEmpty()) && var6.getSalaries().getSalCentresSecurite() != null && !var6.getSalaries().getSalCentresSecurite().isEmpty()) {
               var6.setSaleleCentresSecurite(var6.getSalaries().getSalCentresSecurite());
               var6.setSaleleLibCentresSecurite(var6.getSalaries().getSalLibCentresSecurite());
            }

            if ((var6.getSaleleClassement() == null || var6.getSaleleClassement().isEmpty()) && var6.getSalaries().getSalClassement() != null && !var6.getSalaries().getSalClassement().isEmpty()) {
               var6.setSaleleClassement(var6.getSalaries().getSalClassement());
               var6.setSaleleLibClassement(var6.getSalaries().getSalLibClassement());
            }

            if ((var6.getSaleleNivEmploi() == null || var6.getSaleleNivEmploi().isEmpty()) && var6.getSalaries().getSalNivEmploi() != null && !var6.getSalaries().getSalNivEmploi().isEmpty()) {
               var6.setSaleleNivEmploi(var6.getSalaries().getSalNivEmploi());
               var6.setSaleleLibNivEmploi(var6.getSalaries().getSalLibNivEmploi());
            }

            if ((var6.getSaleleGrille() == null || var6.getSaleleGrille().isEmpty()) && var6.getSalaries().getSalGrille() != null && !var6.getSalaries().getSalGrille().isEmpty()) {
               var6.setSaleleGrille(var6.getSalaries().getSalGrille());
               var6.setSaleleLibGrille(var6.getSalaries().getSalLibGrille());
            }

            var4.modif(var6, var3);
         }
      }

   }

   public void recopieBulletinMatricule(String var1, UtilInitHibernate var2, Session var3) throws HibernateException, NamingException, ParseException {
      BulletinSalaireDao var4 = new BulletinSalaireDao(var1, var2);
      new ArrayList();
      new SalariesElements();
      SalariesElementsDao var7 = new SalariesElementsDao(var1, var2);
      new ArrayList();
      new Salaries();
      SalariesDao var10 = new SalariesDao(var1, var2);
      new ArrayList();
      List var11 = var10.chargerlesSalariesAll(var3);
      if (var11.size() != 0) {
         for(int var12 = 0; var12 < var11.size(); ++var12) {
            Salaries var9 = (Salaries)var11.get(var12);
            boolean var13 = false;
            if (var9.getSalMatricule() != null && !var9.getSalMatricule().isEmpty()) {
               if (var9.getSalNature() == null || var9.getSalNature().isEmpty()) {
                  var13 = true;
               }
            } else {
               var13 = true;
            }

            if (var13) {
               List var5 = var4.chargerlesBulletinsbySalarie(var9, var3);
               int var14;
               if (var5.size() != 0) {
                  var14 = var5.size() - 1;
                  if (((BulletinSalaire)var5.get(var14)).getBulsalMatricule() != null && !((BulletinSalaire)var5.get(var14)).getBulsalMatricule().isEmpty() && ((BulletinSalaire)var5.get(var14)).getBulsalNature() != null && !((BulletinSalaire)var5.get(var14)).getBulsalNature().isEmpty()) {
                     var9.setSalMatricule(((BulletinSalaire)var5.get(var14)).getBulsalMatricule());
                     var9.setSalNature(((BulletinSalaire)var5.get(var14)).getBulsalNature());
                     var9.setSalCivilite(((BulletinSalaire)var5.get(var14)).getBulsalCivilite());
                     var9 = var10.modif(var9, var3);
                  }
               }

               List var8 = var7.chargerlesElementsBySalaries(var9, var3);
               if (var8.size() != 0) {
                  for(var14 = 0; var14 < var8.size(); ++var14) {
                     if (var9.getSalMatricule() != null && !var9.getSalMatricule().isEmpty() && var9.getSalNature() != null && !var9.getSalNature().isEmpty()) {
                        SalariesElements var6 = (SalariesElements)var8.get(var14);
                        if (var6.getSaleleMatricule() == null || var6.getSaleleMatricule().isEmpty() || var6.getSaleleNature() != null || var6.getSaleleNature().isEmpty()) {
                           var6.setSaleleMatricule(var9.getSalMatricule());
                           var6.setSaleleNature(var9.getSalNature());
                           var6.setSaleleCivilite(var9.getSalCivilite());
                           var7.modif(var6, var3);
                        }
                     }
                  }
               }
            }
         }
      }

   }
}
