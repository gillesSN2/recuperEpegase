package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.BonEntreeEntete;
import com.epegase.systeme.classe.BonSortieEntete;
import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.CessionEntete;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.DemandeEnteteAchats;
import com.epegase.systeme.classe.DocumentTraceAchats;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.FabricationEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.FraisLigneAchats;
import com.epegase.systeme.classe.InventaireEntete;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.ProduitsActe;
import com.epegase.systeme.classe.ProduitsDepot;
import com.epegase.systeme.classe.ProduitsDetail;
import com.epegase.systeme.classe.ProduitsFourchette;
import com.epegase.systeme.classe.ProduitsFournisseur;
import com.epegase.systeme.classe.ProduitsGrp;
import com.epegase.systeme.classe.ProduitsHistoRef;
import com.epegase.systeme.classe.ProduitsLaboratoire;
import com.epegase.systeme.classe.ProduitsMcles;
import com.epegase.systeme.classe.ProduitsPharmacie;
import com.epegase.systeme.classe.ProduitsReponse;
import com.epegase.systeme.classe.ProduitsServices;
import com.epegase.systeme.classe.ProduitsTarif;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.classe.ValorisationEnteteAchats;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.BonEntreeEnteteDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieEnteteDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.BrouillardDao;
import com.epegase.systeme.dao.CessionEnteteDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DemandeEnteteAchatsDao;
import com.epegase.systeme.dao.DemandeLigneAchatsDao;
import com.epegase.systeme.dao.DocumentTraceAchatsDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.FabricationEnteteAchatsDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.FraisLigneAchatsDao;
import com.epegase.systeme.dao.InventaireEnteteDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitLigneAchatsDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsActeDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsDetailDao;
import com.epegase.systeme.dao.ProduitsFourchetteDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.ProduitsGrpDao;
import com.epegase.systeme.dao.ProduitsHistoRefDao;
import com.epegase.systeme.dao.ProduitsLaboratoireDao;
import com.epegase.systeme.dao.ProduitsMclesDao;
import com.epegase.systeme.dao.ProduitsPharmacieDao;
import com.epegase.systeme.dao.ProduitsReponseDao;
import com.epegase.systeme.dao.ProduitsServicesDao;
import com.epegase.systeme.dao.ProduitsTarifDao;
import com.epegase.systeme.dao.ReceptionAvicultureAchatsDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReceptionLigneAchatsDao;
import com.epegase.systeme.dao.ReceptionLotAchatsDao;
import com.epegase.systeme.dao.ReceptionSerieAchatsDao;
import com.epegase.systeme.dao.RetourEnteteAchatsDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.dao.ValorisationEnteteAchatsDao;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.util.UtilNombre;
import com.epegase.systeme.xml.LectureDevises;
import com.epegase.systeme.xml.ObjetDevises;
import com.epegase.systeme.xml.OptionAchats;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Utilitaires_Achats implements Serializable {
   public List rechercherAnnulTrfAchats(Date var1, Date var2, List var3, String var4, UtilInitHibernate var5, OptionAchats var6) throws HibernateException, NamingException, ParseException {
      FactureEnteteAchatsDao var7 = new FactureEnteteAchatsDao(var4, var5);
      NoteDebitEnteteAchatsDao var8 = new NoteDebitEnteteAchatsDao(var4, var5);
      AvoirEnteteAchatsDao var9 = new AvoirEnteteAchatsDao(var4, var5);
      FraisEnteteAchatsDao var10 = new FraisEnteteAchatsDao(var4, var5);
      ValorisationEnteteAchatsDao var11 = new ValorisationEnteteAchatsDao(var4, var5);
      Session var12 = var5.getOpenSession(var4, "EcrituresAchats");
      new DocumentEntete();
      UtilDate var14 = new UtilDate();
      String var15 = var14.dateToStringSQLLight(var1) + " 00:00:00";
      String var16 = var14.dateToStringSQLLight(var2) + " 23:59:59";
      new ArrayList();
      List var17 = var7.rechercheFactureDejaTransfererCompta(var15, var16, var12);
      DocumentEntete var13;
      if (var17.size() != 0) {
         new FactureEnteteAchats();

         for(int var19 = 0; var19 < var17.size(); ++var19) {
            FactureEnteteAchats var18 = (FactureEnteteAchats)var17.get(var19);
            if (var18.getFcfDateTransfert() != null) {
               var13 = new DocumentEntete();
               var13.setDocId(var18.getFcfId());
               var13.setDocDate(var18.getFcfDate());
               var13.setDocNum(var18.getFcfNum());
               var13.setDocSerie(var18.getFcfSerie());
               var13.setDocNature(15);
               var13.setDocNomTiers(var18.getFcfNomTiers());
               var13.setDocNomContact(var18.getFcfNomContact());
               var13.setDocTotHt(var18.getFcfTotHt());
               var13.setDocTotTva(var18.getFcfTotTva());
               var13.setDocTotTtc(var18.getFcfTotTtc());
               var13.setDocAnal4(var18.getFcfAnal4());
               var13.setDocObject(var18.getFcfObject());
               var3.add(var13);
            }
         }
      }

      new ArrayList();
      List var24 = var8.rechercheNoteDebitDejaTransfererCompta(var15, var16, var12);
      if (var24.size() != 0) {
         new NoteDebitEnteteAchats();

         for(int var20 = 0; var20 < var24.size(); ++var20) {
            NoteDebitEnteteAchats var25 = (NoteDebitEnteteAchats)var24.get(var20);
            if (var25.getNdfDateTransfert() != null) {
               var13 = new DocumentEntete();
               var13.setDocId(var25.getNdfId());
               var13.setDocDate(var25.getNdfDate());
               var13.setDocNum(var25.getNdfNum());
               var13.setDocSerie(var25.getNdfSerie());
               var13.setDocNature(17);
               var13.setDocNomTiers(var25.getNdfNomTiers());
               var13.setDocNomContact(var25.getNdfNomContact());
               var13.setDocTotHt(var25.getNdfTotHt());
               var13.setDocTotTva(var25.getNdfTotTva());
               var13.setDocTotTtc(var25.getNdfTotTtc());
               var13.setDocAnal4(var25.getNdfAnal4());
               var13.setDocObject(var25.getNdfObject());
               var3.add(var13);
            }
         }
      }

      new ArrayList();
      List var26 = var9.rechercheAvoirDejaTransfererCompta(var15, var16, var12);
      if (var26.size() != 0) {
         new AvoirEnteteAchats();

         for(int var21 = 0; var21 < var26.size(); ++var21) {
            AvoirEnteteAchats var27 = (AvoirEnteteAchats)var26.get(var21);
            if (var27.getAvfDateTransfert() != null) {
               var13 = new DocumentEntete();
               var13.setDocId(var27.getAvfId());
               var13.setDocDate(var27.getAvfDate());
               var13.setDocNum(var27.getAvfNum());
               var13.setDocSerie(var27.getAvfSerie());
               var13.setDocNature(16);
               var13.setDocNomTiers(var27.getAvfNomTiers());
               var13.setDocNomContact(var27.getAvfNomContact());
               var13.setDocTotHt(var27.getAvfTotHt());
               var13.setDocTotTva(var27.getAvfTotTva());
               var13.setDocTotTtc(var27.getAvfTotTtc());
               var13.setDocAnal4(var27.getAvfAnal4());
               var13.setDocObject(var27.getAvfObject());
               var3.add(var13);
            }
         }
      }

      new ArrayList();
      List var28 = var10.rechercheFraisDejaTransfererCompta(var15, var16, var12);
      if (var28.size() != 0) {
         new FraisEnteteAchats();

         for(int var22 = 0; var22 < var28.size(); ++var22) {
            FraisEnteteAchats var29 = (FraisEnteteAchats)var28.get(var22);
            if (var29.getFsfDateTransfert() != null) {
               var13 = new DocumentEntete();
               var13.setDocId(var29.getFsfId());
               var13.setDocDate(var29.getFsfDate());
               var13.setDocNum(var29.getFsfNum());
               var13.setDocSerie(var29.getFsfSerie());
               var13.setDocNature(18);
               var13.setDocNomTiers(var29.getFsfNomTiers());
               var13.setDocNomContact(var29.getFsfNomContact());
               var13.setDocTotHt(var29.getFsfTotHt());
               var13.setDocTotTva(var29.getFsfTotTva());
               var13.setDocTotTtc(var29.getFsfTotTtc());
               var13.setDocAnal4(var29.getFsfAnal4());
               var13.setDocObject(var29.getFsfObject());
               var3.add(var13);
            }
         }
      }

      if (var6.getTrfCompta().equals("1")) {
         new ArrayList();
         List var30 = var11.rechercheValoDejaTransfererCompta(var15, var16, var12);
         if (var30.size() != 0) {
            new ValorisationEnteteAchats();

            for(int var23 = 0; var23 < var30.size(); ++var23) {
               ValorisationEnteteAchats var31 = (ValorisationEnteteAchats)var30.get(var23);
               if (var31.getValDateTransfert() != null) {
                  var13 = new DocumentEntete();
                  var13.setDocId(var31.getValId());
                  var13.setDocDate(var31.getValDate());
                  var13.setDocNum(var31.getValNum());
                  var13.setDocSerie(var31.getValSerie());
                  var13.setDocNature(35);
                  var13.setDocNomTiers(var31.getValDossierTransit());
                  var13.setDocNomContact("");
                  var13.setDocTotHt(var31.getValTotalFob());
                  var13.setDocTotTva(var31.getValTotalFret());
                  var13.setDocTotTtc(0.0D);
                  var13.setDocAnal4(var31.getValAnalytique());
                  var13.setDocObject(var31.getValObjet());
                  var3.add(var13);
               }
            }
         }
      }

      return var3;
   }

   public void annulTrfAchats(Date var1, Date var2, List var3, String var4, UtilInitHibernate var5) throws HibernateException, NamingException {
      Session var6 = var5.getOpenSession(var4, "EcrituresAchats");
      EcrituresAnalytiquesDao var7 = new EcrituresAnalytiquesDao(var4, var5);
      EcrituresDao var8 = new EcrituresDao(var4, var5);
      BrouillardDao var9 = new BrouillardDao(var4, var5);
      FactureEnteteAchatsDao var10 = new FactureEnteteAchatsDao(var4, var5);
      NoteDebitEnteteAchatsDao var11 = new NoteDebitEnteteAchatsDao(var4, var5);
      AvoirEnteteAchatsDao var12 = new AvoirEnteteAchatsDao(var4, var5);
      FraisEnteteAchatsDao var13 = new FraisEnteteAchatsDao(var4, var5);
      ValorisationEnteteAchatsDao var14 = new ValorisationEnteteAchatsDao(var4, var5);
      boolean var15 = true;
      Transaction var16 = null;

      List var17;
      EcrituresAnalytique var18;
      String var23;
      try {
         var16 = var6.beginTransaction();
         new ArrayList();
         new EcrituresAnalytique();
         int var19 = 0;

         while(true) {
            if (var19 >= var3.size()) {
               var16.commit();
               break;
            }

            if (((DocumentEntete)var3.get(var19)).isDocSelect()) {
               long var20 = ((DocumentEntete)var3.get(var19)).getDocId();
               String var22 = "" + ((DocumentEntete)var3.get(var19)).getDocNature();
               var23 = "ecritures.ecrTypeOrigine='" + var22 + "' and ecritures.ecrIdOrigine=" + var20;
               var17 = var7.ChargerLesEcrituresanalytiquesRecherche(var23, var6);
               if (var17.size() != 0) {
                  for(int var24 = 0; var24 < var17.size(); ++var24) {
                     var18 = (EcrituresAnalytique)var17.get(var24);
                     var7.nettoyageAnalytique(var18, var6);
                  }
               }
            }

            ++var19;
         }
      } catch (HibernateException var67) {
         if (var16 != null) {
            var15 = false;
            var16.rollback();
         }

         throw var67;
      } finally {
         var5.closeSession();
      }

      if (var15) {
         var6 = var5.getOpenSession(var4, "EcrituresAchats");
         var17 = null;

         Ecritures var72;
         String var83;
         try {
            Transaction var69 = var6.beginTransaction();
            new ArrayList();
            new Ecritures();
            int var74 = 0;

            while(true) {
               if (var74 >= var3.size()) {
                  var69.commit();
                  break;
               }

               if (((DocumentEntete)var3.get(var74)).isDocSelect()) {
                  long var21 = ((DocumentEntete)var3.get(var74)).getDocId();
                  var23 = "" + ((DocumentEntete)var3.get(var74)).getDocNature();
                  var83 = "ecrTypeOrigine='" + var23 + "' and ecrIdOrigine=" + var21;
                  List var70 = var8.ChargerLesEcrituresRecherche(var83, var6);
                  if (var70.size() != 0) {
                     for(int var25 = 0; var25 < var70.size(); ++var25) {
                        var72 = (Ecritures)var70.get(var25);
                        var8.removeSelectedEC0(var72, 0, var6);
                     }
                  }
               }

               ++var74;
            }
         } catch (HibernateException var65) {
            if (var17 != null) {
               var15 = false;
               var17.rollback();
            }

            throw var65;
         } finally {
            var5.closeSession();
         }

         if (var15) {
            var6 = var5.getOpenSession(var4, "EcrituresAchats");
            var18 = null;

            int var26;
            try {
               Transaction var71 = var6.beginTransaction();
               new ArrayList();
               new Brouillard();
               int var77 = 0;

               while(true) {
                  if (var77 >= var3.size()) {
                     var71.commit();
                     break;
                  }

                  if (((DocumentEntete)var3.get(var77)).isDocSelect()) {
                     long var80 = ((DocumentEntete)var3.get(var77)).getDocId();
                     var83 = "" + ((DocumentEntete)var3.get(var77)).getDocNature();
                     String var85 = "broTypeOrigine='" + var83 + "' and broIdOrigine=" + var80;
                     List var73 = var9.ChargerLesBrouillardsRecherche(var85, var6);
                     if (var73.size() != 0) {
                        for(var26 = 0; var26 < var73.size(); ++var26) {
                           Brouillard var76 = (Brouillard)var73.get(var26);
                           var9.removeSelected(var76, var6);
                        }
                     }
                  }

                  ++var77;
               }
            } catch (HibernateException var63) {
               if (var18 != null) {
                  var15 = false;
                  var18.rollback();
               }

               throw var63;
            } finally {
               var5.closeSession();
            }

            if (var15) {
               var6 = var5.getOpenSession(var4, "EcrituresAchats");
               var72 = null;

               try {
                  Transaction var75 = var6.beginTransaction();
                  if (var3.size() != 0) {
                     new DocumentEntete();
                     new FactureEnteteAchats();
                     new AvoirEnteteAchats();
                     new NoteDebitEnteteAchats();
                     new FraisEnteteAchats();
                     new ValorisationEnteteAchats();

                     for(var26 = 0; var26 < var3.size(); ++var26) {
                        DocumentEntete var78 = (DocumentEntete)var3.get(var26);
                        if (var78.isDocSelect()) {
                           if (var78.getDocNature() == 15) {
                              FactureEnteteAchats var79 = var10.pourParapheur(var78.getDocId(), var6);
                              if (var79 != null) {
                                 var79.setFcfEtat(1);
                                 var79.setFcfDateTransfert((Date)null);
                                 var10.modif(var79, var6);
                              }
                           } else if (var78.getDocNature() == 16) {
                              AvoirEnteteAchats var81 = var12.pourParapheur(var78.getDocId(), var6);
                              if (var81 != null) {
                                 var81.setAvfEtat(1);
                                 var81.setAvfDateTransfert((Date)null);
                                 var12.modif(var81, var6);
                              }
                           } else if (var78.getDocNature() == 17) {
                              NoteDebitEnteteAchats var82 = var11.pourParapheur(var78.getDocId(), var6);
                              if (var82 != null) {
                                 var82.setNdfEtat(1);
                                 var82.setNdfDateTransfert((Date)null);
                                 var11.modif(var82, var6);
                              }
                           } else if (var78.getDocNature() == 18) {
                              FraisEnteteAchats var84 = var13.pourParapheur(var78.getDocId(), var6);
                              if (var84 != null) {
                                 var84.setFsfEtat(1);
                                 var84.setFsfDateTransfert((Date)null);
                                 var13.modif(var84, var6);
                              }
                           } else if (var78.getDocNature() == 35) {
                              ValorisationEnteteAchats var86 = var14.pourParapheur(var78.getDocId(), var6);
                              if (var86 != null) {
                                 var86.setValEtat(1);
                                 var86.setValDateTransfert((Date)null);
                                 var14.modif(var86, var6);
                              }
                           }
                        }
                     }
                  }

                  var75.commit();
               } catch (HibernateException var61) {
                  if (var72 != null) {
                     var72.rollback();
                  }

                  throw var61;
               } finally {
                  var5.closeSession();
               }
            }
         }
      }

   }

   public void forceTrfAchats(Date var1, Date var2, String var3, OptionAchats var4, UtilInitHibernate var5) throws HibernateException, NamingException, ParseException {
      var5.getOpenSession(var3, "EcrituresAchats");
      FactureEnteteAchatsDao var7 = new FactureEnteteAchatsDao(var3, var5);
      NoteDebitEnteteAchatsDao var8 = new NoteDebitEnteteAchatsDao(var3, var5);
      AvoirEnteteAchatsDao var9 = new AvoirEnteteAchatsDao(var3, var5);
      FraisEnteteAchatsDao var10 = new FraisEnteteAchatsDao(var3, var5);
      ValorisationEnteteAchatsDao var11 = new ValorisationEnteteAchatsDao(var3, var5);
      Session var6 = var5.getOpenSession(var3, "EcrituresAchats");
      Transaction var12 = null;

      try {
         var12 = var6.beginTransaction();
         UtilDate var13 = new UtilDate();
         Date var14 = var13.dateToSQL(var1, "00", "00", "00");
         Date var15 = var13.dateToSQL(var2, "23", "59", "59");
         String var16 = var13.dateToStringSQL(var14);
         String var17 = var13.dateToStringSQL(var15);
         new ArrayList();
         List var18 = var7.rechercheFactureATransfererCompta(var4.getTransfertDocument(), "", "", var16, var17, false, var6);
         if (var18.size() != 0) {
            new FactureEnteteAchats();

            for(int var20 = 0; var20 < var18.size(); ++var20) {
               FactureEnteteAchats var19 = (FactureEnteteAchats)var18.get(var20);
               var19.setFcfEtat(1);
               var19.setFcfDateTransfert(var19.getFcfDate());
               var7.modif(var19, var6);
            }
         }

         new ArrayList();
         List var30 = var8.rechercheNoteDebitATransfererCompta(var4.getTransfertDocument(), "", "", var16, var17, false, var6);
         if (var30.size() != 0) {
            new NoteDebitEnteteAchats();

            for(int var21 = 0; var21 < var30.size(); ++var21) {
               NoteDebitEnteteAchats var31 = (NoteDebitEnteteAchats)var30.get(var21);
               var31.setNdfEtat(1);
               var31.setNdfDateTransfert(var31.getNdfDate());
               var8.modif(var31, var6);
            }
         }

         new ArrayList();
         List var32 = var9.rechercheAvoirATransfererCompta(var4.getTransfertDocument(), "", "", var16, var17, false, var6);
         if (var32.size() != 0) {
            new AvoirEnteteAchats();

            for(int var22 = 0; var22 < var32.size(); ++var22) {
               AvoirEnteteAchats var33 = (AvoirEnteteAchats)var32.get(var22);
               var33.setAvfEtat(1);
               var33.setAvfDateTransfert(var33.getAvfDate());
               var9.modif(var33, var6);
            }
         }

         new ArrayList();
         List var34 = var10.rechercheFraisATransfererCompta(var4.getTransfertDocument(), "", "", var16, var17, false, var6);
         if (var34.size() != 0) {
            new FraisEnteteAchats();

            for(int var23 = 0; var23 < var34.size(); ++var23) {
               FraisEnteteAchats var35 = (FraisEnteteAchats)var34.get(var23);
               var35.setFsfEtat(1);
               var35.setFsfDateTransfert(var35.getFsfDate());
               var10.modif(var35, var6);
            }
         }

         if (var4.getTrfCompta().equals("1")) {
            new ArrayList();
            List var36 = var11.rechercheValoATransfererCompta(var4.getTransfertDocument(), "", "", var16, var17, false, var6);
            if (var36.size() != 0) {
               new ValorisationEnteteAchats();

               for(int var24 = 0; var24 < var36.size(); ++var24) {
                  ValorisationEnteteAchats var37 = (ValorisationEnteteAchats)var36.get(var24);
                  var37.setValEtat(1);
                  var37.setValDateTransfert(var37.getValDate());
                  var11.modif(var37, var6);
               }
            }
         }

         var12.commit();
      } catch (HibernateException var28) {
         if (var12 != null) {
            var12.rollback();
         }

         throw var28;
      } finally {
         var5.closeSession();
      }

   }

   public void recalculConnexionCotation(TiersDao var1, UtilNombre var2, String var3, String var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ArrayList();
      CotationEnteteAchatsDao var9 = new CotationEnteteAchatsDao(var5, var6);
      String var10 = "cotDate>='" + var3 + "' and cotDate<='" + var4 + "'";
      List var8 = var9.rechercheCotationRequete(var10, var7);
      if (var8.size() != 0) {
         new CotationEnteteAchats();
         new Tiers();

         for(int var13 = 0; var13 < var8.size(); ++var13) {
            CotationEnteteAchats var11 = (CotationEnteteAchats)var8.get(var13);
            Tiers var12 = var1.chargerLesTiers("0", var11.getCotNomTiers(), var7);
            if (var12 != null) {
               var11.setTiers(var12);
               var9.modif(var11, var7);
            } else {
               var12 = var1.chargerLesTiers("0", "DIVERS", var7);
               if (var12 != null) {
                  var11.setTiers(var12);
                  var9.modif(var11, var7);
               }
            }
         }

         var7.flush();
      }

   }

   public void recalculConnexionCommande(TiersDao var1, UtilNombre var2, String var3, String var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ArrayList();
      CommandeEnteteAchatsDao var9 = new CommandeEnteteAchatsDao(var5, var6);
      String var10 = "cmdDate>='" + var3 + "' and cmdDate<='" + var4 + "'";
      List var8 = var9.rechercheCommandeRequete(var10, var7);
      if (var8.size() != 0) {
         new CommandeEnteteAchats();
         new Tiers();

         for(int var13 = 0; var13 < var8.size(); ++var13) {
            CommandeEnteteAchats var11 = (CommandeEnteteAchats)var8.get(var13);
            Tiers var12 = var1.chargerLesTiers("0", var11.getCmdNomTiers(), var7);
            if (var12 != null) {
               var11.setTiers(var12);
               var9.modif(var11, var7);
            } else {
               var12 = var1.chargerLesTiers("0", "DIVERS", var7);
               if (var12 != null) {
                  var11.setTiers(var12);
                  var9.modif(var11, var7);
               }
            }
         }

         var7.flush();
      }

   }

   public void recalculConnexionReception(TiersDao var1, UtilNombre var2, String var3, String var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ArrayList();
      ReceptionEnteteAchatsDao var9 = new ReceptionEnteteAchatsDao(var5, var6);
      String var10 = "recDate>='" + var3 + "' and recDate<='" + var4 + "'";
      List var8 = var9.rechercheReceptionRequete(var10, var7);
      if (var8.size() != 0) {
         new ReceptionEnteteAchats();
         new Tiers();

         for(int var13 = 0; var13 < var8.size(); ++var13) {
            ReceptionEnteteAchats var11 = (ReceptionEnteteAchats)var8.get(var13);
            Tiers var12 = var1.chargerLesTiers("0", var11.getRecNomTiers(), var7);
            if (var12 != null) {
               var11.setTiers(var12);
               var9.modif(var11, var7);
            } else {
               var12 = var1.chargerLesTiers("0", "DIVERS", var7);
               if (var12 != null) {
                  var11.setTiers(var12);
                  var9.modif(var11, var7);
               }
            }
         }

         var7.flush();
      }

   }

   public void recalculConnexionRetour(TiersDao var1, UtilNombre var2, String var3, String var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ArrayList();
      RetourEnteteAchatsDao var9 = new RetourEnteteAchatsDao(var5, var6);
      String var10 = "brfDate>='" + var3 + "' and brfDate<='" + var4 + "'";
      List var8 = var9.rechercheRetourRequete(var10, var7);
      if (var8.size() != 0) {
         new RetourEnteteAchats();
         new Tiers();

         for(int var13 = 0; var13 < var8.size(); ++var13) {
            RetourEnteteAchats var11 = (RetourEnteteAchats)var8.get(var13);
            Tiers var12 = var1.chargerLesTiers("0", var11.getBrfNomTiers(), var7);
            if (var12 != null) {
               var11.setTiers(var12);
               var9.modif(var11, var7);
            } else {
               var12 = var1.chargerLesTiers("0", "DIVERS", var7);
               if (var12 != null) {
                  var11.setTiers(var12);
                  var9.modif(var11, var7);
               }
            }
         }

         var7.flush();
      }

   }

   public void recalculConnexionFacture(TiersDao var1, UtilNombre var2, String var3, String var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ArrayList();
      FactureEnteteAchatsDao var9 = new FactureEnteteAchatsDao(var5, var6);
      String var10 = "fcfDate>='" + var3 + "' and fcfDate<='" + var4 + "'";
      List var8 = var9.rechercheFactureRequete(var10, var7);
      if (var8.size() != 0) {
         new FactureEnteteAchats();
         new Tiers();

         for(int var13 = 0; var13 < var8.size(); ++var13) {
            FactureEnteteAchats var11 = (FactureEnteteAchats)var8.get(var13);
            Tiers var12 = var1.chargerLesTiers("0", var11.getFcfNomTiers(), var7);
            if (var12 != null) {
               var11.setTiers(var12);
               var9.modif(var11, var7);
            } else {
               var12 = var1.chargerLesTiers("0", "DIVERS", var7);
               if (var12 != null) {
                  var11.setTiers(var12);
                  var9.modif(var11, var7);
               }
            }
         }

         var7.flush();
      }

   }

   public void recalculConnexionNoteDebit(TiersDao var1, UtilNombre var2, String var3, String var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ArrayList();
      NoteDebitEnteteAchatsDao var9 = new NoteDebitEnteteAchatsDao(var5, var6);
      String var10 = "ndfDate>='" + var3 + "' and ndfDate<='" + var4 + "'";
      List var8 = var9.rechercheNoteDebitRequete(var10, var7);
      if (var8.size() != 0) {
         new NoteDebitEnteteAchats();
         new Tiers();

         for(int var13 = 0; var13 < var8.size(); ++var13) {
            NoteDebitEnteteAchats var11 = (NoteDebitEnteteAchats)var8.get(var13);
            Tiers var12 = var1.chargerLesTiers("0", var11.getNdfNomTiers(), var7);
            if (var12 != null) {
               var11.setTiers(var12);
               var9.modif(var11, var7);
            } else {
               var12 = var1.chargerLesTiers("0", "DIVERS", var7);
               if (var12 != null) {
                  var11.setTiers(var12);
                  var9.modif(var11, var7);
               }
            }
         }

         var7.flush();
      }

   }

   public void recalculConnexionAvoir(TiersDao var1, UtilNombre var2, String var3, String var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ArrayList();
      AvoirEnteteAchatsDao var9 = new AvoirEnteteAchatsDao(var5, var6);
      String var10 = "avfDate>='" + var3 + "' and avfDate<='" + var4 + "'";
      List var8 = var9.rechercheAvoirRequete(var10, var7);
      if (var8.size() != 0) {
         new AvoirEnteteAchats();
         new Tiers();

         for(int var13 = 0; var13 < var8.size(); ++var13) {
            AvoirEnteteAchats var11 = (AvoirEnteteAchats)var8.get(var13);
            Tiers var12 = var1.chargerLesTiers("0", var11.getAvfNomTiers(), var7);
            if (var12 != null) {
               var11.setTiers(var12);
               var9.modif(var11, var7);
            }
         }

         var7.flush();
      }

   }

   public void recalculConnexionFrais(TiersDao var1, UtilNombre var2, String var3, String var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ArrayList();
      FraisEnteteAchatsDao var9 = new FraisEnteteAchatsDao(var5, var6);
      String var10 = "fsfDate>='" + var3 + "' and fsfDate<='" + var4 + "'";
      List var8 = var9.rechercheFraisRequete(var10, var7);
      if (var8.size() != 0) {
         new FraisEnteteAchats();
         new Tiers();

         for(int var13 = 0; var13 < var8.size(); ++var13) {
            FraisEnteteAchats var11 = (FraisEnteteAchats)var8.get(var13);
            Tiers var12 = var1.chargerLesTiers("0", var11.getFsfNomTiers(), var7);
            if (var12 != null) {
               var11.setTiers(var12);
               var9.modif(var11, var7);
            }
         }

         var7.flush();
      }

   }

   public void suppressionDa(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new DemandeEnteteAchats();
      DemandeEnteteAchatsDao var9 = new DemandeEnteteAchatsDao(var5, var6);
      new ArrayList();
      DemandeLigneAchatsDao var11 = new DemandeLigneAchatsDao(var5, var6);
      List var10 = var9.rechercheDemandeByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            DemandeEnteteAchats var8 = (DemandeEnteteAchats)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getDemId(), var7);
         }
      }

   }

   public void suppressionCotations(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new CotationEnteteAchats();
      CotationEnteteAchatsDao var9 = new CotationEnteteAchatsDao(var5, var6);
      new ArrayList();
      CotationLigneAchatsDao var11 = new CotationLigneAchatsDao(var5, var6);
      List var10 = var9.rechercheCotationByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            CotationEnteteAchats var8 = (CotationEnteteAchats)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getCotId(), var7);
         }
      }

      this.suppressionTracabiliteAchats(var1, var2, 11, var5, var6, var7);
   }

   public void suppressionCommandes(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new CommandeEnteteAchats();
      CommandeEnteteAchatsDao var9 = new CommandeEnteteAchatsDao(var5, var6);
      new ArrayList();
      CommandeLigneAchatsDao var11 = new CommandeLigneAchatsDao(var5, var6);
      List var10 = var9.rechercheCommandeByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            CommandeEnteteAchats var8 = (CommandeEnteteAchats)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getCmdId(), var7);
         }
      }

      this.suppressionTracabiliteAchats(var1, var2, 12, var5, var6, var7);
   }

   public void suppressionReceptions(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      UtilDate var8 = new UtilDate();
      String var9 = var8.dateToStringSQLLight(var1) + " 00:00:00";
      String var10 = var8.dateToStringSQLLight(var2) + " 23:59:59";
      new ReceptionEnteteAchats();
      ReceptionEnteteAchatsDao var12 = new ReceptionEnteteAchatsDao(var5, var6);
      new ArrayList();
      ReceptionLigneAchatsDao var14 = new ReceptionLigneAchatsDao(var5, var6);
      ReceptionAvicultureAchatsDao var15 = new ReceptionAvicultureAchatsDao(var5, var6);
      new ReceptionLotAchatsDao(var5, var6);
      new ReceptionSerieAchatsDao(var5, var6);
      List var13 = var12.rechercheReceptionByDate(var9, var10, var7);
      if (var13.size() != 0) {
         for(int var18 = 0; var18 < var13.size(); ++var18) {
            ReceptionEnteteAchats var11 = (ReceptionEnteteAchats)var13.get(var18);
            var14.deleteAllLigne(var11, var7);
            var15.deleteAllLigne(var11, var7);
            var12.delete(var11.getRecId(), var7);
         }
      }

      this.suppressionTracabiliteAchats(var1, var2, 13, var5, var6, var7);
   }

   public void suppressionRetours(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new RetourEnteteAchats();
      RetourEnteteAchatsDao var9 = new RetourEnteteAchatsDao(var5, var6);
      new ArrayList();
      RetourLigneAchatsDao var11 = new RetourLigneAchatsDao(var5, var6);
      List var10 = var9.rechercheRetourByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            RetourEnteteAchats var8 = (RetourEnteteAchats)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getBrfId(), var7);
         }
      }

      this.suppressionTracabiliteAchats(var1, var2, 14, var5, var6, var7);
   }

   public void suppressionFactures(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new FactureEnteteAchats();
      FactureEnteteAchatsDao var9 = new FactureEnteteAchatsDao(var5, var6);
      new ArrayList();
      FactureLigneAchatsDao var11 = new FactureLigneAchatsDao(var5, var6);
      List var10 = var9.rechercheFactureByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            FactureEnteteAchats var8 = (FactureEnteteAchats)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getFcfId(), var7);
         }
      }

      this.suppressionTracabiliteAchats(var1, var2, 16, var5, var6, var7);
   }

   public void suppressionFrais(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new FraisEnteteAchats();
      FraisEnteteAchatsDao var9 = new FraisEnteteAchatsDao(var5, var6);
      new ArrayList();
      FraisLigneAchatsDao var11 = new FraisLigneAchatsDao(var5, var6);
      List var10 = var9.rechercheFraisByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            FraisEnteteAchats var8 = (FraisEnteteAchats)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getFsfId(), var7);
         }
      }

   }

   public void suppressionNotesDebit(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new NoteDebitEnteteAchats();
      NoteDebitEnteteAchatsDao var9 = new NoteDebitEnteteAchatsDao(var5, var6);
      new ArrayList();
      NoteDebitLigneAchatsDao var11 = new NoteDebitLigneAchatsDao(var5, var6);
      List var10 = var9.rechercheNoteDebitByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            NoteDebitEnteteAchats var8 = (NoteDebitEnteteAchats)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getNdfId(), var7);
         }
      }

      this.suppressionTracabiliteAchats(var1, var2, 17, var5, var6, var7);
   }

   public void suppressionAvoirs(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new AvoirEnteteAchats();
      AvoirEnteteAchatsDao var9 = new AvoirEnteteAchatsDao(var5, var6);
      new ArrayList();
      AvoirLigneAchatsDao var11 = new AvoirLigneAchatsDao(var5, var6);
      List var10 = var9.rechercheAvoirByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            AvoirEnteteAchats var8 = (AvoirEnteteAchats)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getAvfId(), var7);
         }
      }

      this.suppressionTracabiliteAchats(var1, var2, 16, var5, var6, var7);
   }

   public void suppressionInventaires(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new InventaireEntete();
      InventaireEnteteDao var9 = new InventaireEnteteDao(var5, var6);
      new ArrayList();
      InventaireLigneDao var11 = new InventaireLigneDao(var5, var6);
      List var10 = var9.rechercheInventaireByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            InventaireEntete var8 = (InventaireEntete)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getInvId(), var7);
         }
      }

   }

   public void suppressionBonsEntree(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new BonEntreeEntete();
      BonEntreeEnteteDao var9 = new BonEntreeEnteteDao(var5, var6);
      new ArrayList();
      BonEntreeLigneDao var11 = new BonEntreeLigneDao(var5, var6);
      List var10 = var9.rechercheBonEntreeByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            BonEntreeEntete var8 = (BonEntreeEntete)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getBinId(), var7);
         }
      }

   }

   public void suppressionBonsSortie(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      UtilDate var8 = new UtilDate();
      String var9 = var8.dateToStringSQLLight(var1) + " 00:00:00";
      String var10 = var8.dateToStringSQLLight(var2) + " 23:59:59";
      new BonSortieEntete();
      BonSortieEnteteDao var12 = new BonSortieEnteteDao(var5, var6);
      new ArrayList();
      BonSortieLigneDao var14 = new BonSortieLigneDao(var5, var6);
      List var13 = var12.rechercheBonSortieByDate(var9, var10, var7);
      if (var13.size() != 0) {
         for(int var15 = 0; var15 < var13.size(); ++var15) {
            BonSortieEntete var11 = (BonSortieEntete)var13.get(var15);
            var14.deleteAllLigne(var11, var7);
            var12.delete(var11.getBouId(), var7);
         }
      }

   }

   public void suppressionCessions(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new CessionEntete();
      CessionEnteteDao var9 = new CessionEnteteDao(var5, var6);
      new ArrayList();
      CessionLigneDao var11 = new CessionLigneDao(var5, var6);
      List var10 = var9.rechercheCessionsByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            CessionEntete var8 = (CessionEntete)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getCesId(), var7);
         }
      }

   }

   public void suppressionProductions(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new FabricationEnteteAchats();
      FabricationEnteteAchatsDao var9 = new FabricationEnteteAchatsDao(var5, var6);
      new ArrayList();
      FabricationLigneAchatsDao var11 = new FabricationLigneAchatsDao(var5, var6);
      List var10 = var9.rechercheProductionByDate(var1, var2, var7);
      if (var10.size() != 0) {
         for(int var12 = 0; var12 < var10.size(); ++var12) {
            FabricationEnteteAchats var8 = (FabricationEnteteAchats)var10.get(var12);
            var11.deleteAllLigne(var8, var7);
            var9.delete(var8.getFabId(), var7);
         }
      }

   }

   public void suppressionTracabiliteAchats(Date var1, Date var2, int var3, String var4, UtilInitHibernate var5, Session var6) throws HibernateException, NamingException {
      new DocumentTraceAchats();
      DocumentTraceAchatsDao var8 = new DocumentTraceAchatsDao(var4, var5);
      new ArrayList();
      List var9 = var8.nettoyageTrace(var1, var2, var3, var6);
      if (var9.size() != 0) {
         for(int var10 = 0; var10 < var9.size(); ++var10) {
            DocumentTraceAchats var7 = (DocumentTraceAchats)var9.get(var10);
            var8.delete(var7, var6);
         }
      }

   }

   public boolean testAchatsVde(String var1, String var2, UtilInitHibernate var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = true;
      DemandeLigneAchatsDao var6 = new DemandeLigneAchatsDao(var2, var3);
      new ArrayList();
      List var7 = var6.chargerLesMvts(var1, var4);
      if (var7.size() == 0) {
         CotationLigneAchatsDao var8 = new CotationLigneAchatsDao(var2, var3);
         new ArrayList();
         List var9 = var8.chargerLesMvts(var1, var4);
         if (var9.size() == 0) {
            CommandeLigneAchatsDao var10 = new CommandeLigneAchatsDao(var2, var3);
            new ArrayList();
            List var11 = var10.chargerLesMvts(var1, var4);
            if (var11.size() == 0) {
               ReceptionLigneAchatsDao var12 = new ReceptionLigneAchatsDao(var2, var3);
               new ArrayList();
               List var13 = var12.chargerLesMvts(var1, var4);
               if (var13.size() == 0) {
                  FactureLigneAchatsDao var14 = new FactureLigneAchatsDao(var2, var3);
                  new ArrayList();
                  List var15 = var14.chargerLesMvts(var1, var4);
                  if (var15.size() == 0) {
                     NoteDebitLigneAchatsDao var16 = new NoteDebitLigneAchatsDao(var2, var3);
                     new ArrayList();
                     List var17 = var16.chargerLesMvts(var1, var4);
                     if (var17.size() == 0) {
                        AvoirLigneAchatsDao var18 = new AvoirLigneAchatsDao(var2, var3);
                        new ArrayList();
                        List var19 = var18.chargerLesMvts(var1, var4);
                        if (var19.size() == 0) {
                           RetourLigneAchatsDao var20 = new RetourLigneAchatsDao(var2, var3);
                           new ArrayList();
                           List var21 = var20.chargerLesMvts(var1, var4);
                           if (var21.size() == 0) {
                              FraisLigneAchatsDao var22 = new FraisLigneAchatsDao(var2, var3);
                              new ArrayList();
                              List var23 = var22.chargerLesMvts(var1, var4);
                              if (var23.size() == 0) {
                                 InventaireLigneDao var24 = new InventaireLigneDao(var2, var3);
                                 new ArrayList();
                                 List var25 = var24.chargerLesMvts(var1, var4);
                                 boolean var26 = false;
                                 if (var25.size() != 0) {
                                    for(int var27 = 0; var27 < var25.size(); ++var27) {
                                       if (((InventaireLigne)var25.get(var27)).getInvligQteStock() != 0.0F) {
                                          var26 = true;
                                          break;
                                       }
                                    }
                                 }

                                 if (!var26) {
                                    BonEntreeLigneDao var35 = new BonEntreeLigneDao(var2, var3);
                                    new ArrayList();
                                    List var28 = var35.chargerLesMvts(var1, var4);
                                    if (var28.size() == 0) {
                                       BonSortieLigneDao var29 = new BonSortieLigneDao(var2, var3);
                                       new ArrayList();
                                       List var30 = var29.chargerLesMvts(var1, var4);
                                       if (var30.size() == 0) {
                                          CessionLigneDao var31 = new CessionLigneDao(var2, var3);
                                          new ArrayList();
                                          List var32 = var31.chargerLesMvts(var1, var4);
                                          if (var32.size() == 0) {
                                             FabricationLigneAchatsDao var33 = new FabricationLigneAchatsDao(var2, var3);
                                             new ArrayList();
                                             List var34 = var33.chargerLesMvts(var1, "", 0L, var4);
                                             if (var34.size() != 0) {
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

   public void suppressionProduitsDesactive(Produits var1, ProduitsActeDao var2, ProduitsDepotDao var3, ProduitsDetailDao var4, ProduitsFourchetteDao var5, ProduitsFournisseurDao var6, ProduitsGrpDao var7, ProduitsHistoRefDao var8, ProduitsLaboratoireDao var9, ProduitsMclesDao var10, ProduitsPharmacieDao var11, ProduitsReponseDao var12, ProduitsServicesDao var13, ProduitsTarifDao var14, Session var15) throws HibernateException, NamingException {
      new ArrayList();
      List var16 = var2.listeProdActeByProd(var1.getProId(), var15);
      if (var16.size() != 0) {
         new ProduitsActe();

         for(int var18 = 0; var18 < var16.size(); ++var18) {
            ProduitsActe var17 = (ProduitsActe)var16.get(var18);
            var2.delete(var17, var15);
         }
      }

      new ArrayList();
      List var31 = var3.selectProdDepByprod(var1, var15);
      if (var31.size() != 0) {
         new ProduitsDepot();

         for(int var19 = 0; var19 < var31.size(); ++var19) {
            ProduitsDepot var32 = (ProduitsDepot)var31.get(var19);
            var3.delete(var32, var15);
         }
      }

      new ArrayList();
      List var33 = var4.chargeProdDetailByLab(var1.getProId(), var15);
      if (var33.size() != 0) {
         new ProduitsDetail();

         for(int var20 = 0; var20 < var33.size(); ++var20) {
            ProduitsDetail var34 = (ProduitsDetail)var33.get(var20);
            var4.delete(var34, var15);
         }
      }

      new ArrayList();
      List var35 = var5.chargeProdFourchetteByDet(var1.getProId(), var15);
      if (var35.size() != 0) {
         new ProduitsFourchette();

         for(int var21 = 0; var21 < var35.size(); ++var21) {
            ProduitsFourchette var36 = (ProduitsFourchette)var35.get(var21);
            var5.delete(var36, var15);
         }
      }

      new ArrayList();
      List var37 = var6.selectProdFourByprod(var1, var15);
      if (var37.size() != 0) {
         new ProduitsFournisseur();

         for(int var22 = 0; var22 < var37.size(); ++var22) {
            ProduitsFournisseur var38 = (ProduitsFournisseur)var37.get(var22);
            var6.delete(var38, var15);
         }
      }

      new ArrayList();
      List var39 = var7.selectProdGrpByprod(var1, var15);
      if (var39.size() != 0) {
         new ProduitsGrp();

         for(int var23 = 0; var23 < var39.size(); ++var23) {
            ProduitsGrp var40 = (ProduitsGrp)var39.get(var23);
            var7.delete(var40, var15);
         }
      }

      new ArrayList();
      List var41 = var8.selectProdHistoRefByprod(var1, var15);
      if (var41.size() != 0) {
         new ProduitsHistoRef();

         for(int var24 = 0; var24 < var41.size(); ++var24) {
            ProduitsHistoRef var42 = (ProduitsHistoRef)var41.get(var24);
            var8.delete(var42, var15);
         }
      }

      new ArrayList();
      List var43 = var9.listProdLaboratoireByProd(var1.getProId(), var15);
      if (var43.size() != 0) {
         new ProduitsLaboratoire();

         for(int var25 = 0; var25 < var43.size(); ++var25) {
            ProduitsLaboratoire var44 = (ProduitsLaboratoire)var43.get(var25);
            var9.delete(var44, var15);
         }
      }

      new ArrayList();
      List var45 = var10.selectProdMotClefByprod(var1, var15);
      if (var45.size() != 0) {
         new ProduitsMcles();

         for(int var26 = 0; var26 < var45.size(); ++var26) {
            ProduitsMcles var46 = (ProduitsMcles)var45.get(var26);
            var10.delete(var46, var15);
         }
      }

      new ArrayList();
      List var47 = var11.listeProdPharmacieByProd(var1.getProId(), var15);
      if (var47.size() != 0) {
         new ProduitsPharmacie();

         for(int var27 = 0; var27 < var47.size(); ++var27) {
            ProduitsPharmacie var48 = (ProduitsPharmacie)var47.get(var27);
            var11.delete(var48, var15);
         }
      }

      new ArrayList();
      List var49 = var12.chargeProdReponseByProd(var1.getProCode(), var15);
      if (var49.size() != 0) {
         new ProduitsReponse();

         for(int var28 = 0; var28 < var49.size(); ++var28) {
            ProduitsReponse var50 = (ProduitsReponse)var49.get(var28);
            var12.delete(var50, var15);
         }
      }

      new ArrayList();
      List var51 = var13.selectProdServiceByprod(var1, var15);
      if (var51.size() != 0) {
         new ProduitsServices();

         for(int var29 = 0; var29 < var51.size(); ++var29) {
            ProduitsServices var52 = (ProduitsServices)var51.get(var29);
            var13.delete(var52, var15);
         }
      }

      new ArrayList();
      List var53 = var14.selectProdTarifByprod(var1, var15);
      if (var53.size() != 0) {
         new ProduitsTarif();

         for(int var30 = 0; var30 < var53.size(); ++var30) {
            ProduitsTarif var54 = (ProduitsTarif)var53.get(var30);
            var14.delete(var54, var15);
         }
      }

   }

   public boolean testAchatsInv(String var1, String var2, UtilInitHibernate var3, Session var4) throws HibernateException, NamingException {
      boolean var5 = true;
      InventaireLigneDao var6 = new InventaireLigneDao(var2, var3);
      new ArrayList();
      List var7 = var6.chargerLesMvts(var1, var4);
      boolean var8 = false;
      if (var7.size() != 0) {
         for(int var9 = 0; var9 < var7.size(); ++var9) {
            if (((InventaireLigne)var7.get(var9)).getInvligQteStock() != 0.0F) {
               var8 = true;
               break;
            }
         }
      }

      if (!var8) {
         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }

   public void regenerationProduitsFournisseurs(Structure var1, UtilNombre var2, LectureDevises var3, Produits var4, ProduitsAchsDao var5, ProduitsFournisseur var6, ProduitsFournisseurDao var7, ReceptionLigneAchatsDao var8, ReceptionLigneAchats var9, Session var10) throws HibernateException, NamingException {
      if (var4.getProCode() != null && !var4.getProCode().isEmpty()) {
         new ReceptionEnteteAchats();
         new Tiers();
         new ArrayList();
         List var13 = var7.selectProdFourByprod(var4, var10);
         new ArrayList();
         List var14 = var8.chargerLesMvts(var4.getProCode(), var10);
         ReceptionEnteteAchats var11;
         Tiers var12;
         int var15;
         boolean var16;
         int var17;
         if (var14.size() != 0) {
            for(var15 = 0; var15 < var14.size(); ++var15) {
               var9 = (ReceptionLigneAchats)var14.get(var15);
               var11 = var9.getReceptionEnteteAchats();
               var12 = var11.getTiers();
               var16 = false;
               if (var13.size() != 0) {
                  for(var17 = 0; var17 < var13.size(); ++var17) {
                     if (var12.getTieid() == ((ProduitsFournisseur)var13.get(var17)).getTiers().getTieid()) {
                        var16 = true;
                        break;
                     }
                  }
               }

               if (!var16) {
                  var6 = new ProduitsFournisseur();
                  var6.setTiers(var12);
                  var6.setProduits(var4);
                  var6.setProfouRef(var9.getRecligReference());
                  var6.setProfouDevise(var11.getRecDevise());
                  var6.setProfouFormat(var11.getVar_format_devise());
                  if (var6.getProfouDevise() == null || var6.getProfouDevise().isEmpty()) {
                     var6.setProfouDevise(var1.getStrdevise());
                     var6.setProfouFormat(var1.getStrformatdevise());
                  }

                  var6.setProfouPa(var9.getRecligPu());
                  var6.setProfouDate(var11.getRecDate());
                  new ObjetDevises();
                  ObjetDevises var24 = var3.devisesRecherchee(var6.getProfouDevise(), var1.getStrdevise());
                  float var18 = 1.0F;
                  if (var24.getTaux1() != null && !var24.getTaux1().isEmpty()) {
                     var18 = Float.parseFloat(var24.getTaux1());
                  }

                  float var19 = 1.0F;
                  if (var24.getTaux2() != null && !var24.getTaux2().isEmpty()) {
                     var19 = Float.parseFloat(var24.getTaux2());
                  }

                  var6.setProfouTauxDevise(var11.getRecCoefDevise());
                  var6.setProfouCoefEuro(var18);
                  if (var6.getProfouDevise().equalsIgnoreCase(var1.getStrdevise())) {
                     var6.setProfouCoefLocal(1.0F);
                     var6.setProfouPaLocal(var6.getProfouPa());
                  } else {
                     var6.setProfouCoefLocal(var19);
                     double var20 = var6.getProfouPa() * (double)var18 * (double)var19;
                     double var22 = var2.myRoundFormat(var20, var6.getProfouFormat());
                     var6.setProfouPaLocal(var22);
                  }

                  var7.insert(var6, var10);
               }
            }
         }

         for(var15 = 0; var15 < var13.size(); ++var15) {
            var6 = (ProduitsFournisseur)var13.get(var15);
            var16 = false;

            for(var17 = 0; var17 < var14.size(); ++var17) {
               var9 = (ReceptionLigneAchats)var14.get(var17);
               var11 = var9.getReceptionEnteteAchats();
               var12 = var11.getTiers();
               if (var6.getTiers().getTieid() == var12.getTieid()) {
                  var16 = true;
                  break;
               }
            }

            if (!var16) {
               var7.delete(var6, var10);
            }
         }
      }

   }

   public void reconnexionFraisReception(Structure var1, UtilNombre var2, FraisLigneAchats var3, FraisLigneAchatsDao var4, ReceptionEnteteAchats var5, ReceptionEnteteAchatsDao var6, Session var7) throws HibernateException, NamingException {
      if (var3 != null && var3.getFraisEnteteAchats().getFsfAnal4() != null && !var3.getFraisEnteteAchats().getFsfAnal4().isEmpty() && var3.getFraisEnteteAchats().getFsfAffaire() != null && !var3.getFraisEnteteAchats().getFsfAffaire().isEmpty()) {
         var5 = var6.pourParapheurByDossier(var3.getFraisEnteteAchats().getFsfAnal4(), var3.getFraisEnteteAchats().getFsfAffaire(), var7);
         if (var5 != null) {
            var3.setFsfligIdRec(var5.getRecId());
         } else {
            var3.setFsfligIdRec(0L);
         }

         var4.modifLigne(var3, var7);
      }

   }

   public void reconnexionFraisReceptionEntete(Structure var1, UtilNombre var2, List var3, FraisEnteteAchatsDao var4, ReceptionEnteteAchats var5, ReceptionEnteteAchatsDao var6, Session var7) throws HibernateException, NamingException {
      ArrayList var8 = new ArrayList();
      new FraisLigneAchats();
      new FraisEnteteAchats();

      FraisEnteteAchats var10;
      for(int var11 = 0; var11 < var3.size(); ++var11) {
         FraisLigneAchats var9 = (FraisLigneAchats)var3.get(var11);
         var10 = var9.getFraisEnteteAchats();
         boolean var12 = false;

         for(int var13 = 0; var13 < var8.size(); ++var13) {
            if (var9.getFraisEnteteAchats().getFsfId() == ((FraisEnteteAchats)var8.get(var13)).getFsfId()) {
               var12 = true;
               break;
            }
         }

         if (!var12) {
            var8.add(var10);
         }
      }

      if (var8.size() != 0) {
         String var14 = "";

         for(int var15 = 0; var15 < var8.size(); ++var15) {
            var10 = (FraisEnteteAchats)var8.get(var15);
            var5 = var6.pourParapheurByDossier(var10.getFsfAnal4(), var10.getFsfAffaire(), var7);
            if (var5 != null) {
               var14 = var5.getRecNum();
            } else {
               var14 = "";
            }

            var10.setFsfNumDoc(var14);
            var4.modif(var10, var7);
         }
      }

   }

   public void recalculReference(Date var1, Date var2, Structure var3, Users var4, String var5, UtilInitHibernate var6, Session var7) throws HibernateException, NamingException {
      new ArrayList();
      ProduitsFournisseurDao var9 = new ProduitsFournisseurDao(var5, var6);
      List var8 = var9.selectAllProduitsFour("", var7);
      if (var8.size() != 0) {
         UtilDate var10 = new UtilDate();
         String var11 = "";
         String var12 = var10.dateToStringSQLLight(var1) + " 00:00:00";
         String var13 = var10.dateToStringSQLLight(var2) + " 23:59:59";
         new ArrayList();
         CotationLigneAchatsDao var15 = new CotationLigneAchatsDao(var5, var6);
         var11 = " cotationEnteteAchats.cotDate between '" + var12 + "' and '" + var13 + "' and cotligReference is null or cotligReference = ''";
         List var14 = var15.rechercheCotationRequete(var11, var7);
         if (var14.size() != 0) {
            new CotationLigneAchats();
            new CotationEnteteAchats();
            int var18 = 0;

            while(true) {
               if (var18 >= var14.size()) {
                  var7.flush();
                  break;
               }

               CotationLigneAchats var16 = (CotationLigneAchats)var14.get(var18);
               CotationEnteteAchats var17 = var16.getCotationEnteteAchats();
               if (var16.getCotligCode() != null && !var16.getCotligCode().isEmpty() && (var16.getCotligReference() == null || var16.getCotligReference().isEmpty())) {
                  for(int var19 = 0; var19 < var8.size(); ++var19) {
                     if (var16.getCotligCode().equals(((ProduitsFournisseur)var8.get(var19)).getProduits().getProCode()) && var17.getTiers().getTieid() == ((ProduitsFournisseur)var8.get(var19)).getTiers().getTieid()) {
                        var16.setCotligReference(((ProduitsFournisseur)var8.get(var19)).getProfouRef());
                        var16 = var15.modifLigne(var16, var7);
                     }
                  }
               }

               ++var18;
            }
         }

         new ArrayList();
         CommandeLigneAchatsDao var25 = new CommandeLigneAchatsDao(var5, var6);
         var11 = " commandeEnteteAchats.cmdDate between '" + var12 + "' and '" + var13 + "' and cmdligReference is null or cmdligReference = ''";
         List var24 = var25.rechercheCommandeRequete(var11, var7);
         if (var24.size() != 0) {
            new CommandeLigneAchats();
            new CommandeEnteteAchats();
            int var20 = 0;

            while(true) {
               if (var20 >= var24.size()) {
                  var7.flush();
                  break;
               }

               CommandeLigneAchats var26 = (CommandeLigneAchats)var24.get(var20);
               CommandeEnteteAchats var28 = var26.getCommandeEnteteAchats();
               if (var26.getCmdligCode() != null && !var26.getCmdligCode().isEmpty() && (var26.getCmdligReference() == null || var26.getCmdligReference().isEmpty())) {
                  for(int var21 = 0; var21 < var8.size(); ++var21) {
                     if (var26.getCmdligCode().equals(((ProduitsFournisseur)var8.get(var21)).getProduits().getProCode()) && var28.getTiers().getTieid() == ((ProduitsFournisseur)var8.get(var21)).getTiers().getTieid()) {
                        var26.setCmdligReference(((ProduitsFournisseur)var8.get(var21)).getProfouRef());
                        var26 = var25.modifLigne(var26, var7);
                     }
                  }
               }

               ++var20;
            }
         }

         new ArrayList();
         ReceptionLigneAchatsDao var29 = new ReceptionLigneAchatsDao(var5, var6);
         var11 = " receptionEnteteAchats.recDate between '" + var12 + "' and '" + var13 + "' and recligReference is null or recligReference = ''";
         List var27 = var29.rechercheReceptionRequete(var11, var7);
         if (var27.size() != 0) {
            new ReceptionLigneAchats();
            new ReceptionEnteteAchats();

            for(int var22 = 0; var22 < var27.size(); ++var22) {
               ReceptionLigneAchats var30 = (ReceptionLigneAchats)var27.get(var22);
               ReceptionEnteteAchats var31 = var30.getReceptionEnteteAchats();
               if (var30.getRecligCode() != null && !var30.getRecligCode().isEmpty() && (var30.getRecligReference() == null || var30.getRecligReference().isEmpty())) {
                  for(int var23 = 0; var23 < var8.size(); ++var23) {
                     if (var30.getRecligCode().equals(((ProduitsFournisseur)var8.get(var23)).getProduits().getProCode()) && var31.getTiers().getTieid() == ((ProduitsFournisseur)var8.get(var23)).getTiers().getTieid()) {
                        var30.setRecligReference(((ProduitsFournisseur)var8.get(var23)).getProfouRef());
                        var30 = var29.modifLigne(var30, var7);
                     }
                  }
               }
            }

            var7.flush();
         }
      }

   }
}
