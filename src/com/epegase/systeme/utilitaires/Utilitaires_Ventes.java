package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.AppelCharge;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.BienFacture;
import com.epegase.systeme.classe.BienTravauxEntete;
import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.ChargementEntete;
import com.epegase.systeme.classe.Chrono;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.DocumentTraceVentes;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TicketEnteteVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.dao.AppelChargeDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BienFactureDao;
import com.epegase.systeme.dao.BienTravauxEnteteDao;
import com.epegase.systeme.dao.BienTravauxLigneDao;
import com.epegase.systeme.dao.BrouillardDao;
import com.epegase.systeme.dao.ChargementEnteteDao;
import com.epegase.systeme.dao.ChargementFraisDao;
import com.epegase.systeme.dao.ChargementLigneDao;
import com.epegase.systeme.dao.ChronoDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.DocumentTraceVentesDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneLigneVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.TicketEnteteVentesDao;
import com.epegase.systeme.dao.TicketLigneVentesDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Utilitaires_Ventes implements Serializable {
   public List rechercherAnnulTrfVentes(Date var1, Date var2, List var3, String var4, UtilInitHibernate var5) throws HibernateException, NamingException {
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = false;
      boolean var11 = false;
      new ArrayList();
      ChronoDao var13 = new ChronoDao(var4, var5);
      List var12 = var13.selectListVente(1, (Session)null);
      if (var12.size() != 0) {
         for(int var14 = 0; var14 < var12.size(); ++var14) {
            if (((Chrono)var12.get(var14)).getChrNature() == 22 && ((Chrono)var12.get(var14)).getChrJournal() != null && !((Chrono)var12.get(var14)).getChrJournal().isEmpty()) {
               var6 = true;
            } else if (((Chrono)var12.get(var14)).getChrNature() == 23 && ((Chrono)var12.get(var14)).getChrJournal() != null && !((Chrono)var12.get(var14)).getChrJournal().isEmpty()) {
               var7 = true;
            } else if (((Chrono)var12.get(var14)).getChrNature() == 25 && ((Chrono)var12.get(var14)).getChrJournal() != null && !((Chrono)var12.get(var14)).getChrJournal().isEmpty()) {
               var8 = true;
            } else if (((Chrono)var12.get(var14)).getChrNature() == 26 && ((Chrono)var12.get(var14)).getChrJournal() != null && !((Chrono)var12.get(var14)).getChrJournal().isEmpty()) {
               var9 = true;
            } else if (((Chrono)var12.get(var14)).getChrNature() == 27 && ((Chrono)var12.get(var14)).getChrJournal() != null && !((Chrono)var12.get(var14)).getChrJournal().isEmpty()) {
               var10 = true;
            } else if (((Chrono)var12.get(var14)).getChrNature() == 142 && ((Chrono)var12.get(var14)).getChrJournal() != null && !((Chrono)var12.get(var14)).getChrJournal().isEmpty()) {
               var11 = true;
            }
         }
      }

      new DocumentEntete();
      UtilDate var15 = new UtilDate();
      String var16 = var15.dateToStringSQLLight(var1) + " 00:00:00";
      String var17 = var15.dateToStringSQLLight(var2) + " 23:59:59";
      Session var18 = var5.getOpenSession(var4, "EcrituresVentes");
      List var20;
      int var22;
      DocumentEntete var23;
      if (var6) {
         CommandeEnteteVentesDao var19 = new CommandeEnteteVentesDao(var4, var5);
         new ArrayList();
         var20 = var19.rechercheCommandeDejaTransfererCompta(var16, var17, var18);
         if (var20.size() != 0) {
            new CommandeEnteteVentes();

            for(var22 = 0; var22 < var20.size(); ++var22) {
               CommandeEnteteVentes var21 = (CommandeEnteteVentes)var20.get(var22);
               if (var21.getBcmDateTransfert() != null) {
                  var23 = new DocumentEntete();
                  var23.setDocId(var21.getBcmId());
                  var23.setDocDate(var21.getBcmDate());
                  var23.setDocNum(var21.getBcmNum());
                  var23.setDocSerie(var21.getBcmSerie());
                  var23.setDocNature(22);
                  var23.setDocNomTiers(var21.getBcmNomTiers());
                  var23.setDocNomContact(var21.getBcmNomContact());
                  var23.setDocTotHt(var21.getBcmTotHt());
                  var23.setDocTotTva(var21.getBcmTotTva());
                  var23.setDocTotTtc(var21.getBcmTotTtc());
                  var23.setDocAnal4(var21.getBcmAnal4());
                  var23.setDocObject(var21.getBcmObject());
                  var3.add(var23);
               }
            }
         }
      }

      if (var7) {
         LivraisonEnteteVentesDao var24 = new LivraisonEnteteVentesDao(var4, var5);
         new ArrayList();
         var20 = var24.rechercheLivraisonDejaTransfererCompta(var16, var17, var18);
         if (var20.size() != 0) {
            new LivraisonEnteteVentes();

            for(var22 = 0; var22 < var20.size(); ++var22) {
               LivraisonEnteteVentes var29 = (LivraisonEnteteVentes)var20.get(var22);
               if (var29.getBlvDateTransfert() != null) {
                  var23 = new DocumentEntete();
                  var23.setDocId(var29.getBlvId());
                  var23.setDocDate(var29.getBlvDate());
                  var23.setDocNum(var29.getBlvNum());
                  var23.setDocSerie(var29.getBlvSerie());
                  var23.setDocNature(23);
                  var23.setDocNomTiers(var29.getBlvNomTiers());
                  var23.setDocNomContact(var29.getBlvNomContact());
                  var23.setDocTotHt(var29.getBlvTotHt());
                  var23.setDocTotTva(var29.getBlvTotTva());
                  var23.setDocTotTtc(var29.getBlvTotTtc());
                  var23.setDocAnal4(var29.getBlvAnal4());
                  var23.setDocObject(var29.getBlvObject());
                  var3.add(var23);
               }
            }
         }
      }

      if (var8) {
         FactureEnteteVentesDao var25 = new FactureEnteteVentesDao(var4, var5);
         new ArrayList();
         var20 = var25.rechercheFactureDejaTransfererCompta(var16, var17, var18);
         if (var20.size() != 0) {
            new FactureEnteteVentes();

            for(var22 = 0; var22 < var20.size(); ++var22) {
               FactureEnteteVentes var30 = (FactureEnteteVentes)var20.get(var22);
               if (var30.getFacDateTransfert() != null) {
                  var23 = new DocumentEntete();
                  var23.setDocId(var30.getFacId());
                  var23.setDocDate(var30.getFacDate());
                  var23.setDocNum(var30.getFacNum());
                  var23.setDocSerie(var30.getFacSerie());
                  var23.setDocNature(25);
                  var23.setDocNomTiers(var30.getFacNomTiers());
                  var23.setDocNomContact(var30.getFacNomContact());
                  var23.setDocTotHt(var30.getFacTotHt());
                  var23.setDocTotTva(var30.getFacTotTva());
                  var23.setDocTotTtc(var30.getFacTotTtc());
                  var23.setDocAnal4(var30.getFacAnal4());
                  var23.setDocObject(var30.getFacObject());
                  var3.add(var23);
               }
            }
         }
      }

      if (var11) {
         FactureInterneEnteteVentesDao var26 = new FactureInterneEnteteVentesDao(var4, var5);
         new ArrayList();
         var20 = var26.rechercheFactureInterneDejaTransfererCompta(var16, var17, var18);
         if (var20.size() != 0) {
            new FactureInterneEnteteVentes();

            for(var22 = 0; var22 < var20.size(); ++var22) {
               FactureInterneEnteteVentes var31 = (FactureInterneEnteteVentes)var20.get(var22);
               if (var31.getFitDateTransfert() != null) {
                  var23 = new DocumentEntete();
                  var23.setDocId(var31.getFitId());
                  var23.setDocDate(var31.getFitDate());
                  var23.setDocNum(var31.getFitNum());
                  var23.setDocSerie(var31.getFitSerie());
                  var23.setDocNature(142);
                  var23.setDocNomTiers(var31.getFitNomTiers());
                  var23.setDocNomContact(var31.getFitNomContact());
                  var23.setDocTotHt(var31.getFitTotHt());
                  var23.setDocTotTva(var31.getFitTotTva());
                  var23.setDocTotTtc(var31.getFitTotTtc());
                  var23.setDocAnal4(var31.getFitAnal4());
                  var23.setDocObject(var31.getFitObject());
                  var3.add(var23);
               }
            }
         }
      }

      if (var10) {
         NoteDebitEnteteVentesDao var27 = new NoteDebitEnteteVentesDao(var4, var5);
         new ArrayList();
         var20 = var27.rechercheNoteDebitDejaTransfererCompta(var16, var17, var18);
         if (var20.size() != 0) {
            new NoteDebitEnteteVentes();

            for(var22 = 0; var22 < var20.size(); ++var22) {
               NoteDebitEnteteVentes var32 = (NoteDebitEnteteVentes)var20.get(var22);
               if (var32.getNdbDateTransfert() != null) {
                  var23 = new DocumentEntete();
                  var23.setDocId(var32.getNdbId());
                  var23.setDocDate(var32.getNdbDate());
                  var23.setDocNum(var32.getNdbNum());
                  var23.setDocSerie(var32.getNdbSerie());
                  var23.setDocNature(27);
                  var23.setDocNomTiers(var32.getNdbNomTiers());
                  var23.setDocNomContact(var32.getNdbNomContact());
                  var23.setDocTotHt(var32.getNdbTotHt());
                  var23.setDocTotTva(var32.getNdbTotTva());
                  var23.setDocTotTtc(var32.getNdbTotTtc());
                  var23.setDocAnal4(var32.getNdbAnal4());
                  var23.setDocObject(var32.getNdbObject());
                  var3.add(var23);
               }
            }
         }
      }

      if (var9) {
         AvoirEnteteVentesDao var28 = new AvoirEnteteVentesDao(var4, var5);
         new ArrayList();
         var20 = var28.rechercheAvoirDejaTransfererCompta(var16, var17, var18);
         if (var20.size() != 0) {
            new AvoirEnteteVentes();

            for(var22 = 0; var22 < var20.size(); ++var22) {
               AvoirEnteteVentes var33 = (AvoirEnteteVentes)var20.get(var22);
               if (var33.getAvrDateTransfert() != null) {
                  var23 = new DocumentEntete();
                  var23.setDocId(var33.getAvrId());
                  var23.setDocDate(var33.getAvrDate());
                  var23.setDocNum(var33.getAvrNum());
                  var23.setDocSerie(var33.getAvrSerie());
                  var23.setDocNature(26);
                  var23.setDocNomTiers(var33.getAvrNomTiers());
                  var23.setDocNomContact(var33.getAvrNomContact());
                  var23.setDocTotHt(var33.getAvrTotHt());
                  var23.setDocTotTva(var33.getAvrTotTva());
                  var23.setDocTotTtc(var33.getAvrTotTtc());
                  var23.setDocAnal4(var33.getAvrAnal4());
                  var23.setDocObject(var33.getAvrObject());
                  var3.add(var23);
               }
            }
         }
      }

      return var3;
   }

   public void annulTrfVentes(Date var1, Date var2, List var3, String var4, UtilInitHibernate var5) throws HibernateException, NamingException {
      Session var6 = var5.getOpenSession(var4, "EcrituresVentes");
      EcrituresAnalytiquesDao var7 = new EcrituresAnalytiquesDao(var4, var5);
      EcrituresDao var8 = new EcrituresDao(var4, var5);
      BrouillardDao var9 = new BrouillardDao(var4, var5);
      CommandeEnteteVentesDao var10 = new CommandeEnteteVentesDao(var4, var5);
      LivraisonEnteteVentesDao var11 = new LivraisonEnteteVentesDao(var4, var5);
      FactureInterneEnteteVentesDao var12 = new FactureInterneEnteteVentesDao(var4, var5);
      FactureEnteteVentesDao var13 = new FactureEnteteVentesDao(var4, var5);
      NoteDebitEnteteVentesDao var14 = new NoteDebitEnteteVentesDao(var4, var5);
      AvoirEnteteVentesDao var15 = new AvoirEnteteVentesDao(var4, var5);
      boolean var16 = true;
      Transaction var17 = null;

      List var18;
      EcrituresAnalytique var19;
      String var24;
      try {
         var17 = var6.beginTransaction();
         new ArrayList();
         new EcrituresAnalytique();
         int var20 = 0;

         while(true) {
            if (var20 >= var3.size()) {
               var17.commit();
               break;
            }

            if (((DocumentEntete)var3.get(var20)).isDocSelect()) {
               long var21 = ((DocumentEntete)var3.get(var20)).getDocId();
               String var23 = "" + ((DocumentEntete)var3.get(var20)).getDocNature();
               var24 = "ecritures.ecrTypeOrigine='" + var23 + "' and ecritures.ecrIdOrigine=" + var21;
               var18 = var7.ChargerLesEcrituresanalytiquesRecherche(var24, var6);
               if (var18.size() != 0) {
                  for(int var25 = 0; var25 < var18.size(); ++var25) {
                     var19 = (EcrituresAnalytique)var18.get(var25);
                     var7.nettoyageAnalytique(var19, var6);
                  }
               }
            }

            ++var20;
         }
      } catch (HibernateException var68) {
         if (var17 != null) {
            var16 = false;
            var17.rollback();
         }

         throw var68;
      } finally {
         var5.closeSession();
      }

      if (var16) {
         var6 = var5.getOpenSession(var4, "EcrituresVentes");
         var18 = null;

         Ecritures var73;
         String var84;
         try {
            Transaction var70 = var6.beginTransaction();
            new ArrayList();
            new Ecritures();
            int var75 = 0;

            while(true) {
               if (var75 >= var3.size()) {
                  var70.commit();
                  break;
               }

               if (((DocumentEntete)var3.get(var75)).isDocSelect()) {
                  long var22 = ((DocumentEntete)var3.get(var75)).getDocId();
                  var24 = "" + ((DocumentEntete)var3.get(var75)).getDocNature();
                  var84 = "ecrTypeOrigine='" + var24 + "' and ecrIdOrigine=" + var22;
                  List var71 = var8.ChargerLesEcrituresRecherche(var84, var6);
                  if (var71.size() != 0) {
                     for(int var26 = 0; var26 < var71.size(); ++var26) {
                        var73 = (Ecritures)var71.get(var26);
                        var8.removeSelectedEC0(var73, 0, var6);
                     }
                  }
               }

               ++var75;
            }
         } catch (HibernateException var66) {
            if (var18 != null) {
               var16 = false;
               var18.rollback();
            }

            throw var66;
         } finally {
            var5.closeSession();
         }

         if (var16) {
            var6 = var5.getOpenSession(var4, "EcrituresVentes");
            var19 = null;

            try {
               Transaction var72 = var6.beginTransaction();
               new ArrayList();
               new Brouillard();
               int var78 = 0;

               while(true) {
                  if (var78 >= var3.size()) {
                     var72.commit();
                     break;
                  }

                  if (((DocumentEntete)var3.get(var78)).isDocSelect()) {
                     long var81 = ((DocumentEntete)var3.get(var78)).getDocId();
                     var84 = "" + ((DocumentEntete)var3.get(var78)).getDocNature();
                     String var86 = "broTypeOrigine='" + var84 + "' and broIdOrigine=" + var81;
                     List var74 = var9.ChargerLesBrouillardsRecherche(var86, var6);
                     if (var74.size() != 0) {
                        for(int var27 = 0; var27 < var74.size(); ++var27) {
                           Brouillard var77 = (Brouillard)var74.get(var27);
                           var9.removeSelected(var77, var6);
                        }
                     }
                  }

                  ++var78;
               }
            } catch (HibernateException var64) {
               if (var19 != null) {
                  var16 = false;
                  var19.rollback();
               }

               throw var64;
            } finally {
               var5.closeSession();
            }

            if (var16) {
               var6 = var5.getOpenSession(var4, "EcrituresVentes");
               var73 = null;

               try {
                  Transaction var76 = var6.beginTransaction();
                  if (var3.size() != 0) {
                     new DocumentEntete();
                     new CommandeEnteteVentes();
                     new LivraisonEnteteVentes();
                     new FactureEnteteVentes();
                     new FactureInterneEnteteVentes();
                     new AvoirEnteteVentes();
                     new NoteDebitEnteteVentes();

                     for(int var28 = 0; var28 < var3.size(); ++var28) {
                        DocumentEntete var79 = (DocumentEntete)var3.get(var28);
                        if (var79.isDocSelect()) {
                           if (var79.getDocNature() == 22) {
                              CommandeEnteteVentes var80 = var10.pourParapheur(var79.getDocId(), var6);
                              if (var80 != null) {
                                 var80.setBcmEtat(1);
                                 var80.setBcmDateTransfert((Date)null);
                                 var10.modif(var80, var6);
                              }
                           } else if (var79.getDocNature() == 23) {
                              LivraisonEnteteVentes var82 = var11.pourParapheur(var79.getDocId(), var6);
                              if (var82 != null) {
                                 var82.setBlvEtat(1);
                                 var82.setBlvDateTransfert((Date)null);
                                 var11.modif(var82, var6);
                              }
                           } else if (var79.getDocNature() == 25) {
                              FactureEnteteVentes var83 = var13.pourParapheur(var79.getDocId(), var6);
                              if (var83 != null) {
                                 var83.setFacEtat(1);
                                 var83.setFacDateTransfert((Date)null);
                                 var13.modif(var83, var6);
                              }
                           } else if (var79.getDocNature() == 26) {
                              AvoirEnteteVentes var87 = var15.pourParapheur(var79.getDocId(), var6);
                              if (var87 != null) {
                                 var87.setAvrEtat(1);
                                 var87.setAvrDateTransfert((Date)null);
                                 var15.modif(var87, var6);
                              }
                           } else if (var79.getDocNature() == 27) {
                              NoteDebitEnteteVentes var88 = var14.pourParapheur(var79.getDocId(), var6);
                              if (var88 != null) {
                                 var88.setNdbEtat(1);
                                 var88.setNdbDateTransfert((Date)null);
                                 var14.modif(var88, var6);
                              }
                           } else if (var79.getDocNature() == 142) {
                              FactureInterneEnteteVentes var85 = var12.pourParapheur(var79.getDocId(), var6);
                              if (var85 != null) {
                                 var85.setFitEtat(1);
                                 var85.setFitDateTransfert((Date)null);
                                 var12.modif(var85, var6);
                              }
                           }
                        }
                     }
                  }

                  var76.commit();
               } catch (HibernateException var62) {
                  if (var73 != null) {
                     var73.rollback();
                  }

                  throw var62;
               } finally {
                  var5.closeSession();
               }
            }
         }
      }

   }

   public void forceTrfVentes(Date var1, Date var2, String var3, UtilInitHibernate var4) throws HibernateException, NamingException {
      boolean var5 = false;
      boolean var6 = false;
      boolean var7 = false;
      boolean var8 = false;
      boolean var9 = false;
      boolean var10 = false;
      new ArrayList();
      ChronoDao var12 = new ChronoDao(var3, var4);
      List var11 = var12.selectListVente(1, (Session)null);
      if (var11.size() != 0) {
         for(int var13 = 0; var13 < var11.size(); ++var13) {
            if (((Chrono)var11.get(var13)).getChrNature() == 22 && ((Chrono)var11.get(var13)).getChrJournal() != null && !((Chrono)var11.get(var13)).getChrJournal().isEmpty()) {
               var5 = true;
            } else if (((Chrono)var11.get(var13)).getChrNature() == 23 && ((Chrono)var11.get(var13)).getChrJournal() != null && !((Chrono)var11.get(var13)).getChrJournal().isEmpty()) {
               var6 = true;
            } else if (((Chrono)var11.get(var13)).getChrNature() == 25 && ((Chrono)var11.get(var13)).getChrJournal() != null && !((Chrono)var11.get(var13)).getChrJournal().isEmpty()) {
               var7 = true;
            } else if (((Chrono)var11.get(var13)).getChrNature() == 26 && ((Chrono)var11.get(var13)).getChrJournal() != null && !((Chrono)var11.get(var13)).getChrJournal().isEmpty()) {
               var8 = true;
            } else if (((Chrono)var11.get(var13)).getChrNature() == 27 && ((Chrono)var11.get(var13)).getChrJournal() != null && !((Chrono)var11.get(var13)).getChrJournal().isEmpty()) {
               var9 = true;
            } else if (((Chrono)var11.get(var13)).getChrNature() == 142 && ((Chrono)var11.get(var13)).getChrJournal() != null && !((Chrono)var11.get(var13)).getChrJournal().isEmpty()) {
               var10 = true;
            }
         }
      }

      Session var32 = var4.getOpenSession(var3, "EcrituresVentes");
      CommandeEnteteVentesDao var14 = new CommandeEnteteVentesDao(var3, var4);
      LivraisonEnteteVentesDao var15 = new LivraisonEnteteVentesDao(var3, var4);
      FactureEnteteVentesDao var16 = new FactureEnteteVentesDao(var3, var4);
      FactureInterneEnteteVentesDao var17 = new FactureInterneEnteteVentesDao(var3, var4);
      NoteDebitEnteteVentesDao var18 = new NoteDebitEnteteVentesDao(var3, var4);
      AvoirEnteteVentesDao var19 = new AvoirEnteteVentesDao(var3, var4);
      Transaction var20 = null;

      try {
         var20 = var32.beginTransaction();
         UtilDate var21 = new UtilDate();
         String var22 = var21.dateToStringSQLLight(var1) + " 00:00:00";
         String var23 = var21.dateToStringSQLLight(var2) + " 23:59:59";
         List var24;
         int var26;
         if (var5) {
            new ArrayList();
            var24 = var14.rechercheCommandeATransfererCompta("1", "", "", var22, var23, false, var32);
            if (var24.size() != 0) {
               new CommandeEnteteVentes();

               for(var26 = 0; var26 < var24.size(); ++var26) {
                  CommandeEnteteVentes var25 = (CommandeEnteteVentes)var24.get(var26);
                  var25.setBcmEtat(1);
                  var25.setBcmDateTransfert(var25.getBcmDate());
                  var14.modif(var25, var32);
               }
            }
         }

         if (var6) {
            new ArrayList();
            var24 = var15.rechercheLivraisonATransfererCompta("1", "", "", var22, var23, false, var32);
            if (var24.size() != 0) {
               new LivraisonEnteteVentes();

               for(var26 = 0; var26 < var24.size(); ++var26) {
                  LivraisonEnteteVentes var33 = (LivraisonEnteteVentes)var24.get(var26);
                  var33.setBlvEtat(1);
                  var33.setBlvDateTransfert(var33.getBlvDate());
                  var15.modif(var33, var32);
               }
            }
         }

         if (var7) {
            new ArrayList();
            var24 = var16.rechercheFactureATransfererCompta("1", "", "", var22, var23, false, var32);
            if (var24.size() != 0) {
               new FactureEnteteVentes();

               for(var26 = 0; var26 < var24.size(); ++var26) {
                  FactureEnteteVentes var34 = (FactureEnteteVentes)var24.get(var26);
                  var34.setFacEtat(1);
                  var34.setFacDateTransfert(var34.getFacDate());
                  var16.modif(var34, var32);
               }
            }
         }

         if (var10) {
            new ArrayList();
            var24 = var17.rechercheFactureInterneATransfererCompta("1", "", "", var22, var23, false, var32);
            if (var24.size() != 0) {
               new FactureInterneEnteteVentes();

               for(var26 = 0; var26 < var24.size(); ++var26) {
                  FactureInterneEnteteVentes var35 = (FactureInterneEnteteVentes)var24.get(var26);
                  var35.setFitEtat(1);
                  var35.setFitDateTransfert(var35.getFitDate());
                  var17.modif(var35, var32);
               }
            }
         }

         if (var9) {
            new ArrayList();
            var24 = var18.rechercheNoteDebitATransfererCompta("1", "", "", var22, var23, false, var32);
            if (var24.size() != 0) {
               new NoteDebitEnteteVentes();

               for(var26 = 0; var26 < var24.size(); ++var26) {
                  NoteDebitEnteteVentes var36 = (NoteDebitEnteteVentes)var24.get(var26);
                  var36.setNdbEtat(1);
                  var36.setNdbDateTransfert(var36.getNdbDate());
                  var18.modif(var36, var32);
               }
            }
         }

         if (var8) {
            new ArrayList();
            var24 = var19.rechercheAvoirATransfererCompta("1", "", "", var22, var23, false, var32);
            if (var24.size() != 0) {
               new AvoirEnteteVentes();

               for(var26 = 0; var26 < var24.size(); ++var26) {
                  AvoirEnteteVentes var37 = (AvoirEnteteVentes)var24.get(var26);
                  var37.setAvrEtat(1);
                  var37.setAvrDateTransfert(var37.getAvrDate());
                  var19.modif(var37, var32);
               }
            }
         }

         var20.commit();
      } catch (HibernateException var30) {
         if (var20 != null) {
            var20.rollback();
         }

         throw var30;
      } finally {
         var4.closeSession();
      }

   }

   public void suppressionDevis(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new DevisEnteteVentes();
      DevisEnteteVentesDao var9 = new DevisEnteteVentesDao(var5, var6);
      new ArrayList();
      DevisLigneVentesDao var11 = new DevisLigneVentesDao(var5, var6);
      List var10 = var9.rechercheDevisByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            DevisEnteteVentes var8 = (DevisEnteteVentes)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getDvsId(), var7);
         }
      }

      this.suppressionTracabiliteVentes(var1, var2, 21, var5, var6, var7);
   }

   public void suppressionBc(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new CommandeEnteteVentes();
      CommandeEnteteVentesDao var9 = new CommandeEnteteVentesDao(var5, var6);
      new ArrayList();
      CommandeLigneVentesDao var11 = new CommandeLigneVentesDao(var5, var6);
      List var10 = var9.rechercheCommandeByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            CommandeEnteteVentes var8 = (CommandeEnteteVentes)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getBcmId(), var7);
         }
      }

      this.suppressionTracabiliteVentes(var1, var2, 22, var5, var6, var7);
   }

   public void suppressionBl(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new LivraisonEnteteVentes();
      LivraisonEnteteVentesDao var9 = new LivraisonEnteteVentesDao(var5, var6);
      new ArrayList();
      LivraisonLigneVentesDao var11 = new LivraisonLigneVentesDao(var5, var6);
      List var10 = var9.rechercheLivraisonByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            LivraisonEnteteVentes var8 = (LivraisonEnteteVentes)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getBlvId(), var7);
         }
      }

      this.suppressionTracabiliteVentes(var1, var2, 23, var5, var6, var7);
   }

   public void suppressionRetour(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new RetourEnteteVentes();
      RetourEnteteVentesDao var9 = new RetourEnteteVentesDao(var5, var6);
      new ArrayList();
      RetourLigneVentesDao var11 = new RetourLigneVentesDao(var5, var6);
      List var10 = var9.rechercheRetourByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            RetourEnteteVentes var8 = (RetourEnteteVentes)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getBrtId(), var7);
         }
      }

      this.suppressionTracabiliteVentes(var1, var2, 24, var5, var6, var7);
   }

   public void suppressionFacture(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      UtilDate var8 = new UtilDate();
      String var9 = var8.dateToStringSQLLight(var1) + " 00:00:00";
      String var10 = var8.dateToStringSQLLight(var2) + " 23:59:59";
      new FactureEnteteVentes();
      FactureEnteteVentesDao var12 = new FactureEnteteVentesDao(var5, var6);
      new ArrayList();
      FactureLigneVentesDao var14 = new FactureLigneVentesDao(var5, var6);
      List var13 = var12.rechercheFactureByDate(var9, var10, var7);
      if (var13.size() != 0) {
         for(int var15 = 0; var15 < var13.size(); ++var15) {
            FactureEnteteVentes var11 = (FactureEnteteVentes)var13.get(var15);
            var14.deleteAllLigne(var11, var7);
            var12.delete(var11, var7);
         }
      }

      this.suppressionTracabiliteVentes(var1, var2, 25, var5, var6, var7);
   }

   public void suppressionFactureInterne(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new FactureInterneEnteteVentes();
      FactureInterneEnteteVentesDao var9 = new FactureInterneEnteteVentesDao(var5, var6);
      new ArrayList();
      FactureInterneLigneVentesDao var11 = new FactureInterneLigneVentesDao(var5, var6);
      List var10 = var9.rechercheFactureInterneByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            FactureInterneEnteteVentes var8 = (FactureInterneEnteteVentes)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getFitId(), var7);
         }
      }

      this.suppressionTracabiliteVentes(var1, var2, 142, var5, var6, var7);
   }

   public void suppressionAvoir(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new AvoirEnteteVentes();
      AvoirEnteteVentesDao var9 = new AvoirEnteteVentesDao(var5, var6);
      new ArrayList();
      AvoirLigneVentesDao var11 = new AvoirLigneVentesDao(var5, var6);
      List var10 = var9.rechercheAvoirByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            AvoirEnteteVentes var8 = (AvoirEnteteVentes)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getAvrId(), var7);
         }
      }

      this.suppressionTracabiliteVentes(var1, var2, 26, var5, var6, var7);
   }

   public void suppressionNoteDebit(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new NoteDebitEnteteVentes();
      NoteDebitEnteteVentesDao var9 = new NoteDebitEnteteVentesDao(var5, var6);
      new ArrayList();
      NoteDebitLigneVentesDao var11 = new NoteDebitLigneVentesDao(var5, var6);
      List var10 = var9.rechercheNoteDebitByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            NoteDebitEnteteVentes var8 = (NoteDebitEnteteVentes)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getNdbId(), var7);
         }
      }

      this.suppressionTracabiliteVentes(var1, var2, 27, var5, var6, var7);
   }

   public void suppressionChargement(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ChargementEntete();
      ChargementEnteteDao var9 = new ChargementEnteteDao(var5, var6);
      new ArrayList();
      ChargementLigneDao var11 = new ChargementLigneDao(var5, var6);
      ChargementFraisDao var12 = new ChargementFraisDao(var5, var6);
      List var10 = var9.rechercheChargementByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var13 = 0; var13 < var10.size(); ++var13) {
            ChargementEntete var8 = (ChargementEntete)var10.get(var13);
            var11.deleteAllLigne(var8, var7);
            var12.deleteAllLigne(var8, var7);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionTicket(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new TicketEnteteVentes();
      TicketEnteteVentesDao var9 = new TicketEnteteVentesDao(var5, var6);
      new ArrayList();
      TicketLigneVentesDao var11 = new TicketLigneVentesDao(var5, var6);
      List var10 = var9.rechercheTicketByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            TicketEnteteVentes var8 = (TicketEnteteVentes)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.deleteOneLigne(var8, var7);
         }
      }

   }

   public void suppressionAppelCharge(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new AppelCharge();
      AppelChargeDao var9 = new AppelChargeDao(var5, var6);
      new ArrayList();
      List var10 = var9.rechercheFactureByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var11 = 0; var11 < var10.size(); ++var11) {
            AppelCharge var8 = (AppelCharge)var10.get(var11);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionFactureCharge(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new BienTravauxEntete();
      BienTravauxEnteteDao var9 = new BienTravauxEnteteDao(var5, var6);
      new ArrayList();
      BienTravauxLigneDao var11 = new BienTravauxLigneDao(var5, var6);
      List var10 = var9.chargerTravauxByBien(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            BienTravauxEntete var8 = (BienTravauxEntete)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionFactureLocation(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new BienFacture();
      BienFactureDao var9 = new BienFactureDao(var5, var6);
      new ArrayList();
      List var10 = var9.rechercheFactureByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var11 = 0; var11 < var10.size(); ++var11) {
            BienFacture var8 = (BienFacture)var10.get(var11);
            var9.delete(var8, var7);
         }
      }

   }

   public void suppressionTracabiliteVentes(Date var1, Date var2, int var3, String var4, UtilInitHibernate var5, Session var6) throws HibernateException, NamingException {
      new DocumentTraceVentes();
      DocumentTraceVentesDao var8 = new DocumentTraceVentesDao(var4, var5);
      new ArrayList();
      List var9 = var8.nettoyageTrace(var1, var2, var3, var6);
      if (var9.size() != 0) {
         for(int var10 = 0; var10 < var9.size(); ++var10) {
            DocumentTraceVentes var7 = (DocumentTraceVentes)var9.get(var10);
            var8.delete(var7, var6);
         }
      }

   }

   public boolean testVentesVde(String var1, String var2, UtilInitHibernate var3, Session var4) {
      boolean var5 = true;
      DevisLigneVentesDao var6 = new DevisLigneVentesDao(var2, var3);
      new ArrayList();
      List var7 = var6.chargerLesMvts(var1, var4);
      if (var7.size() == 0) {
         CommandeLigneVentesDao var8 = new CommandeLigneVentesDao(var2, var3);
         new ArrayList();
         List var9 = var8.chargerLesMvts(var1, var4);
         if (var9.size() == 0) {
            LivraisonLigneVentesDao var10 = new LivraisonLigneVentesDao(var2, var3);
            new ArrayList();
            List var11 = var10.chargerLesMvts(var1, var4);
            if (var11.size() == 0) {
               FactureLigneVentesDao var12 = new FactureLigneVentesDao(var2, var3);
               new ArrayList();
               List var13 = var12.chargerLesMvts(var1, var4);
               if (var13.size() == 0) {
                  FactureInterneLigneVentesDao var14 = new FactureInterneLigneVentesDao(var2, var3);
                  new ArrayList();
                  List var15 = var14.chargerLesMvts(var1, var4);
                  if (var15.size() == 0) {
                     RetourLigneVentesDao var16 = new RetourLigneVentesDao(var2, var3);
                     new ArrayList();
                     List var17 = var16.chargerLesMvts(var1, var4);
                     if (var17.size() == 0) {
                        NoteDebitLigneVentesDao var18 = new NoteDebitLigneVentesDao(var2, var3);
                        new ArrayList();
                        List var19 = var18.chargerLesMvts(var1, var4);
                        if (var19.size() == 0) {
                           AvoirLigneVentesDao var20 = new AvoirLigneVentesDao(var2, var3);
                           new ArrayList();
                           List var21 = var20.chargerLesMvts(var1, var4);
                           if (var21.size() == 0) {
                              ChargementLigneDao var22 = new ChargementLigneDao(var2, var3);
                              new ArrayList();
                              List var23 = var22.chargerLesMvts(var1, var4);
                              if (var23.size() == 0) {
                                 TicketLigneVentesDao var24 = new TicketLigneVentesDao(var2, var3);
                                 new ArrayList();
                                 List var25 = var24.chargerLesMvts(var1, var4);
                                 if (var25.size() != 0) {
                                    var5 = false;
                                 }
                              } else {
                                 var5 = false;
                              }
                           } else {
                              var5 = false;
                           }
                        } else {
                           var5 = false;
                        }
                     } else {
                        var5 = false;
                     }
                  } else {
                     var5 = false;
                  }
               } else {
                  var5 = false;
               }
            } else {
               var5 = false;
            }
         } else {
            var5 = false;
         }
      } else {
         var5 = false;
      }

      return var5;
   }

   public void fatureZeroLigneBl(FactureEnteteVentes var1, FactureEnteteVentesDao var2, LivraisonLigneVentesDao var3, FactureLigneVentesDao var4, EcrituresDao var5, Ecritures var6, EcrituresAnalytiquesDao var7, Session var8) throws HibernateException, NamingException {
      Object var9 = new ArrayList();
      new ArrayList();
      List var10 = var3.chargerLesLignesLivraisons("'" + var1.getFacNumBl() + "'", var8);
      if (var10.size() != 0) {
         double var11 = 0.0D;
         double var13 = 0.0D;
         double var15 = 0.0D;
         double var17 = 0.0D;
         double var19 = 0.0D;
         double var21 = 0.0D;
         double var23 = 0.0D;
         new LivraisonLigneVentes();

         LivraisonLigneVentes var25;
         for(int var26 = 0; var26 < var10.size(); ++var26) {
            var25 = (LivraisonLigneVentes)var10.get(var26);
            var19 = var25.getLivraisonEnteteVentes().getBlvTotTtc();
         }

         boolean var33 = false;
         double var27 = var1.getFacTotTtc();
         int var30;
         if (var19 != var27) {
            ((List)var9).clear();
            String var29 = "ecrTypeOrigine='25' and ecrIdOrigine=" + var1.getFacId();
            var9 = var5.ChargerLesEcrituresRecherche(var29, var8);
            if (((List)var9).size() == 0) {
               var33 = true;
            } else {
               for(var30 = 0; var30 < ((List)var9).size(); ++var30) {
                  if (((Ecritures)((List)var9).get(var30)).getEcrCompte().startsWith("4") && (((Ecritures)((List)var9).get(var30)).getEcrLettrage() == null || ((Ecritures)((List)var9).get(var30)).getEcrLettrage().isEmpty())) {
                     var33 = true;
                     break;
                  }
               }
            }
         }

         if (var33) {
            new ArrayList();
            if (((List)var9).size() != 0) {
               for(var30 = 0; var30 < ((List)var9).size(); ++var30) {
                  var6 = (Ecritures)((List)var9).get(var30);
                  List var34 = var7.chargerLesEcrituresAnalytiques(var6, var8);
                  if (var34.size() != 0) {
                     var7.nettoyageAnalytiqueByEcriture(var34, var8);
                  }

                  var5.removeSelectedEC0(var6, 0, var8);
               }

               var8.flush();
            }

            new ArrayList();
            List var35 = var4.chargerLesLignes(var1, var8);
            if (var35.size() != 0) {
               new FactureLigneVentes();

               for(int var32 = 0; var32 < var35.size(); ++var32) {
                  FactureLigneVentes var31 = (FactureLigneVentes)var35.get(var32);
                  var4.deleteOneLigne(var31, var8);
               }

               var8.flush();
            }

            for(int var36 = 0; var36 < var10.size(); ++var36) {
               var25 = (LivraisonLigneVentes)var10.get(var36);
               var11 = var25.getLivraisonEnteteVentes().getBlvTotHt();
               var13 = var25.getLivraisonEnteteVentes().getBlvTotRabais();
               var15 = var25.getLivraisonEnteteVentes().getBlvTotRemise();
               var17 = var25.getLivraisonEnteteVentes().getBlvTotTc();
               var19 = var25.getLivraisonEnteteVentes().getBlvTotTtc();
               var21 = var25.getLivraisonEnteteVentes().getBlvTotTimbre();
               var23 = var25.getLivraisonEnteteVentes().getBlvTotTva();
               FactureLigneVentes var37 = new FactureLigneVentes();
               var37.setFacligCode(var25.getBlvligCode());
               var37.setFacligComplement(var25.getBlvligComplement());
               var37.setFacligCondition(var25.getBlvligCondition());
               var37.setFacligDepot(var25.getBlvligDepot());
               var37.setFacligDescription(var25.getBlvligDescription());
               var37.setFacligDevise(var25.getBlvligDevise());
               var37.setFacligDiam(var25.getBlvligDiam());
               var37.setFacligEchelle(var25.getBlvligEchelle());
               var37.setFacligEntStock(var1.getFacStock());
               var37.setFacligFamille(var25.getBlvligFamille());
               var37.setFacligGroupe(var25.getBlvligGroupe());
               var37.setFacligHaut(var25.getBlvligHaut());
               var37.setFacligIdBcm(var25.getBlvligIdBcm());
               var37.setFacligIdBlv(var25.getBlvligId());
               var37.setFacligIdDvs(var25.getBlvligIdDvs());
               var37.setFacligLarg(var25.getBlvligLarg());
               var37.setFacligLibelle(var25.getBlvligLibelle());
               var37.setFacligLong(var25.getBlvligLong());
               var37.setFacligLot(var25.getBlvligLot());
               var37.setFacligModeGroupe(var25.getBlvligModeGroupe());
               var37.setFacligNb(var25.getBlvligNb());
               var37.setFacligNumSerie(var25.getBlvligNumSerie());
               var37.setFacligOrdre(var25.getBlvligOrdre());
               var37.setFacligPoidsBrut(var25.getBlvligPoidsBrut());
               var37.setFacligPoidsNet(var25.getBlvligPoidsNet());
               var37.setFacligPt(var25.getBlvligPt());
               var37.setFacligPu(var25.getBlvligPu());
               var37.setFacligPuRem(var25.getBlvligPuRem());
               var37.setFacligPuRemTtc(var25.getBlvligPuRemTtc());
               var37.setFacligPuTtc(var25.getBlvligPuTtc());
               var37.setFacligPump(var25.getBlvligPump());
               var37.setFacligQte(var25.getBlvligQte());
               var37.setFacligQteStock(var25.getBlvligQteStock());
               var37.setFacligQteUtil(var25.getBlvligQteUtil());
               var37.setFacligRabais(var25.getBlvligRabais());
               var37.setFacligReference(var25.getBlvligReference());
               var37.setFacligStock(var25.getBlvligStock());
               var37.setFacligTauxRemise(var25.getBlvligTauxRemise());
               var37.setFacligTauxTaxe(var25.getBlvligTauxTaxe());
               var37.setFacligTaxe(var25.getBlvligTaxe());
               var37.setFacligTc(var25.getBlvligTc());
               var37.setFacligTtc(var25.getBlvligTtc());
               var37.setFacligTva(var25.getBlvligTva());
               var37.setFacligUnite(var25.getBlvligUnite());
               var37.setFacligVolume(var25.getBlvligVolume());
               var37.setFactureEnteteVentes(var1);
               var37.setUnite(var25.getUnite());
               var4.insertLigne(var37, var8);
            }

            var8.flush();
            var1.setFacTotHt(var11);
            var1.setFacTotRabais(var13);
            var1.setFacTotRemise(var15);
            var1.setFacTotTc(var17);
            var1.setFacTotTtc(var19);
            var1.setFacTotTimbre(var21);
            var1.setFacTotTva(var23);
            var1.setFacDateTransfert((Date)null);
            var2.modif(var1, var8);
            var8.flush();
         }
      }

   }
}
