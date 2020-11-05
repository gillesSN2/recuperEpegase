package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.AvoirLigneAchats;
import com.epegase.systeme.classe.AvoirLigneVentes;
import com.epegase.systeme.classe.BonEntreeLigne;
import com.epegase.systeme.classe.BonSortieLigne;
import com.epegase.systeme.classe.CessionLigne;
import com.epegase.systeme.classe.ChargementLigne;
import com.epegase.systeme.classe.CommandeLigneAchats;
import com.epegase.systeme.classe.CommandeLigneVentes;
import com.epegase.systeme.classe.CotationLigneAchats;
import com.epegase.systeme.classe.DevisLigneVentes;
import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.FabricationLigneAchats;
import com.epegase.systeme.classe.FactureLigneAchats;
import com.epegase.systeme.classe.FactureLigneVentes;
import com.epegase.systeme.classe.InventaireLigne;
import com.epegase.systeme.classe.LivraisonLigneVentes;
import com.epegase.systeme.classe.NoteDebitLigneVentes;
import com.epegase.systeme.classe.Produits;
import com.epegase.systeme.classe.PumpAchats;
import com.epegase.systeme.classe.ReceptionLigneAchats;
import com.epegase.systeme.classe.RetourLigneAchats;
import com.epegase.systeme.classe.RetourLigneVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TicketLigneVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.AvoirLigneAchatsDao;
import com.epegase.systeme.dao.AvoirLigneVentesDao;
import com.epegase.systeme.dao.BonEntreeLigneDao;
import com.epegase.systeme.dao.BonSortieLigneDao;
import com.epegase.systeme.dao.CessionLigneDao;
import com.epegase.systeme.dao.ChargementLigneDao;
import com.epegase.systeme.dao.CommandeLigneAchatsDao;
import com.epegase.systeme.dao.CommandeLigneVentesDao;
import com.epegase.systeme.dao.CotationLigneAchatsDao;
import com.epegase.systeme.dao.DevisLigneVentesDao;
import com.epegase.systeme.dao.FabricationLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneAchatsDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.FamillesProduitsAchatsDao;
import com.epegase.systeme.dao.InventaireLigneDao;
import com.epegase.systeme.dao.LivraisonLigneVentesDao;
import com.epegase.systeme.dao.NoteDebitLigneVentesDao;
import com.epegase.systeme.dao.ProduitsAchsDao;
import com.epegase.systeme.dao.ProduitsDepotDao;
import com.epegase.systeme.dao.ProduitsFournisseurDao;
import com.epegase.systeme.dao.PumpAchatsDao;
import com.epegase.systeme.dao.RetourLigneAchatsDao;
import com.epegase.systeme.dao.RetourLigneVentesDao;
import com.epegase.systeme.dao.TicketLigneVentesDao;
import com.epegase.systeme.dao.UserDao;
import com.epegase.systeme.util.CalculStock;
import com.epegase.systeme.util.UtilDate;
import com.epegase.systeme.util.UtilInitHibernate;
import groovyjarjarcommonscli.ParseException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Utilitaires_RecalculPUMP implements Serializable {
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

   public Utilitaires_RecalculPUMP(UtilInitHibernate var1, String var2, Structure var3, Users var4) {
      this.utilInitHibernate = var1;
      this.baseLog = var2;
      this.structureLog = var3;
      this.usersLog = var4;
   }

   public void recalculPUMP(UtilDate var1, Produits var2, String var3, CalculStock var4, String var5, Structure var6, Date var7, Date var8, Session var9, ExercicesAchats var10, ProduitsFournisseurDao var11, FamillesProduitsAchatsDao var12, ProduitsAchsDao var13, ProduitsDepotDao var14, InventaireLigneDao var15, BonEntreeLigneDao var16, BonSortieLigneDao var17, CessionLigneDao var18, FabricationLigneAchatsDao var19, CotationLigneAchatsDao var20, CommandeLigneAchatsDao var21, RetourLigneAchatsDao var22, FactureLigneAchatsDao var23, AvoirLigneAchatsDao var24, DevisLigneVentesDao var25, CommandeLigneVentesDao var26, LivraisonLigneVentesDao var27, FactureLigneVentesDao var28, RetourLigneVentesDao var29, AvoirLigneVentesDao var30, ChargementLigneDao var31, PumpAchatsDao var32, NoteDebitLigneVentesDao var33) throws HibernateException, NamingException, ParseException, java.text.ParseException {
      if (var2 != null) {
         Date var34 = null;
         String var35 = "";
         double var36 = 0.0D;
         String var38 = "2015-10-31 00:00:00";
         new PumpAchats();
         new ArrayList();
         List var40 = var32.chargerLesMvtsReception(var2.getProCode(), var3, var9);
         if (var40.size() != 0) {
            new InventaireLigne();
            InventaireLigne var41 = var4.chercheDernierInventaire(var2.getProCode(), var3, this.baseLog, var9);
            if (var41 != null) {
               var36 = var41.getInvligPump();
               var38 = var1.dateToStringSQL(var41.getInventaireEntete().getInvDate());
            }

            if (var41 == null || var36 == 0.0D) {
               var36 = 0.0D;
               new ReceptionLigneAchats();
               ReceptionLigneAchats var42 = var4.chercheDernierReception(var2.getProCode(), var3, 0L, this.baseLog, var9);
               if (var42 != null) {
                  var36 = var42.getRecligPrU();
               }

               if (var41 == null) {
                  var38 = "2015-10-31 00:00:00";
               }
            }

            new ArrayList();
            var35 = "dvsligCode='" + var2.getProCode() + "' and devisEnteteVentes.dvsDate >= '" + var38 + "'";
            List var64 = var25.rechercheDevisRequete(var35, var9);
            PumpAchats var39;
            int var45;
            if (var64.size() != 0) {
               new DevisLigneVentes();

               for(int var44 = 0; var44 < var64.size(); ++var44) {
                  DevisLigneVentes var43 = (DevisLigneVentes)var64.get(var44);
                  var34 = var1.dateToSQLLight(var43.getDevisEnteteVentes().getDvsDate());
                  var39 = null;

                  for(var45 = 0; var45 < var40.size(); ++var45) {
                     if (var34.compareTo(((PumpAchats)var40.get(var45)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var45);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var43.setDvsligPump(var39.getPumPump());
                     } else {
                        var43.setDvsligPump(var39.getPumPr());
                     }
                  } else {
                     var43.setDvsligPump(var36);
                  }

                  var25.modifLigne(var43, var9);
               }
            }

            new ArrayList();
            var35 = "bcmligCode='" + var2.getProCode() + "' and commandeEnteteVentes.bcmDate >= '" + var38 + "' and (bcmligDepot is null or bcmligDepot = '' or bcmligDepot = '" + var3 + "')";
            List var65 = var26.rechercheCommandeRequete(var35, var9);
            int var46;
            if (var65.size() != 0) {
               new CommandeLigneVentes();

               for(var45 = 0; var45 < var65.size(); ++var45) {
                  CommandeLigneVentes var66 = (CommandeLigneVentes)var65.get(var45);
                  var34 = var1.dateToSQLLight(var66.getCommandeEnteteVentes().getBcmDate());
                  var39 = null;

                  for(var46 = 0; var46 < var40.size(); ++var46) {
                     if (var34.compareTo(((PumpAchats)var40.get(var46)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var46);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var66.setBcmligPump(var39.getPumPump());
                     } else {
                        var66.setBcmligPump(var39.getPumPr());
                     }
                  } else {
                     var66.setBcmligPump(var36);
                  }

                  var26.modifLigne(var66, var9);
               }
            }

            new ArrayList();
            var35 = "blvligCode='" + var2.getProCode() + "' and livraisonEnteteVentes.blvDate >= '" + var38 + "' and (blvligDepot is null or blvligDepot = '' or blvligDepot = '" + var3 + "')";
            List var67 = var27.rechercheLivraisonRequete(var35, var9);
            int var47;
            if (var67.size() != 0) {
               new LivraisonLigneVentes();

               for(var46 = 0; var46 < var67.size(); ++var46) {
                  LivraisonLigneVentes var68 = (LivraisonLigneVentes)var67.get(var46);
                  var34 = var1.dateToSQLLight(var68.getLivraisonEnteteVentes().getBlvDate());
                  var39 = null;

                  for(var47 = 0; var47 < var40.size(); ++var47) {
                     if (var34.compareTo(((PumpAchats)var40.get(var47)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var47);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var68.setBlvligPump(var39.getPumPump());
                     } else {
                        var68.setBlvligPump(var39.getPumPr());
                     }
                  } else {
                     var68.setBlvligPump(var36);
                  }

                  var27.modif(var68, var9);
               }
            }

            new ArrayList();
            var35 = "brtligCode='" + var2.getProCode() + "' and retourEnteteVentes.brtDate >= '" + var38 + "' and (brtligDepot is null or brtligDepot = '' or brtligDepot = '" + var3 + "')";
            List var69 = var29.rechercheRetourRequete(var35, var9);
            int var48;
            if (var69.size() != 0) {
               new RetourLigneVentes();

               for(var47 = 0; var47 < var69.size(); ++var47) {
                  RetourLigneVentes var70 = (RetourLigneVentes)var69.get(var47);
                  var34 = var1.dateToSQLLight(var70.getRetourEnteteVentes().getBrtDate());
                  var39 = null;

                  for(var48 = 0; var48 < var40.size(); ++var48) {
                     if (var34.compareTo(((PumpAchats)var40.get(var48)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var48);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var70.setBrtligPump(var39.getPumPump());
                     } else {
                        var70.setBrtligPump(var39.getPumPr());
                     }
                  } else {
                     var70.setBrtligPump(var36);
                  }

                  var29.modifLigne(var70, var9);
               }
            }

            new ArrayList();
            var35 = "facligCode='" + var2.getProCode() + "' and factureEnteteVentes.facDate >= '" + var38 + "' and (facligDepot is null or facligDepot = '' or facligDepot = '" + var3 + "')";
            List var71 = var28.rechercheFactureRequete(var35, var9);
            int var49;
            if (var71.size() != 0) {
               new FactureLigneVentes();

               for(var48 = 0; var48 < var71.size(); ++var48) {
                  FactureLigneVentes var72 = (FactureLigneVentes)var71.get(var48);
                  var34 = var1.dateToSQLLight(var72.getFactureEnteteVentes().getFacDate());
                  var39 = null;

                  for(var49 = 0; var49 < var40.size(); ++var49) {
                     if (var34.compareTo(((PumpAchats)var40.get(var49)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var49);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var72.setFacligPump(var39.getPumPump());
                     } else {
                        var72.setFacligPump(var39.getPumPr());
                     }
                  } else {
                     var72.setFacligPump(var36);
                  }

                  var28.modifLigne(var72, var9);
               }
            }

            new ArrayList();
            var35 = "ndbligCode='" + var2.getProCode() + "' and noteDebitEnteteVentes.ndbDate >= '" + var38 + "' and (ndbligDepot is null or ndbligDepot = '' or ndbligDepot = '" + var3 + "')";
            List var73 = var33.rechercheNoteDebitRequete(var35, var9);
            int var50;
            if (var73.size() != 0) {
               new NoteDebitLigneVentes();

               for(var49 = 0; var49 < var73.size(); ++var49) {
                  NoteDebitLigneVentes var74 = (NoteDebitLigneVentes)var73.get(var49);
                  var34 = var1.dateToSQLLight(var74.getNoteDebitEnteteVentes().getNdbDate());
                  var39 = null;

                  for(var50 = 0; var50 < var40.size(); ++var50) {
                     if (var34.compareTo(((PumpAchats)var40.get(var50)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var50);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var74.setNdbligPump(var39.getPumPump());
                     } else {
                        var74.setNdbligPump(var39.getPumPr());
                     }
                  } else {
                     var74.setNdbligPump(var36);
                  }

                  var33.modifLigne(var74, var9);
               }
            }

            new ArrayList();
            var35 = "avrligCode='" + var2.getProCode() + "' and avoirEnteteVentes.avrDate >= '" + var38 + "' and (avrligDepot is null or avrligDepot = '' or avrligDepot = '" + var3 + "')";
            List var75 = var30.rechercheAvoirRequete(var35, var9);
            if (var75.size() != 0) {
               new AvoirLigneVentes();

               for(var50 = 0; var50 < var75.size(); ++var50) {
                  AvoirLigneVentes var76 = (AvoirLigneVentes)var75.get(var50);
                  var34 = var1.dateToSQLLight(var76.getAvoirEnteteVentes().getAvrDate());
                  var39 = null;

                  for(int var51 = 0; var51 < var40.size(); ++var51) {
                     if (var34.compareTo(((PumpAchats)var40.get(var51)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var51);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var76.setAvrligPump(var39.getPumPump());
                     } else {
                        var76.setAvrligPump(var39.getPumPr());
                     }
                  } else {
                     var76.setAvrligPump(var36);
                  }

                  var30.modifLigne(var76, var9);
               }
            }

            new ArrayList();
            var35 = "ticligCode='" + var2.getProCode() + "' and ticketEnteteVentes.ticDate >= '" + var38 + "' and (ticligDepot is null or ticligDepot = '' or ticligDepot = '" + var3 + "')";
            TicketLigneVentesDao var78 = new TicketLigneVentesDao(var5, this.utilInitHibernate);
            List var77 = var78.rechercheFactureRequete(var35, var9);
            int var53;
            if (var77.size() != 0) {
               new TicketLigneVentes();

               for(int var52 = 0; var52 < var77.size(); ++var52) {
                  TicketLigneVentes var79 = (TicketLigneVentes)var77.get(var52);
                  var34 = var1.dateToSQLLight(var79.getTicketEnteteVentes().getTicDate());
                  var39 = null;

                  for(var53 = 0; var53 < var40.size(); ++var53) {
                     if (var34.compareTo(((PumpAchats)var40.get(var53)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var53);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var79.setTicligPump(var39.getPumPump());
                     } else {
                        var79.setTicligPump(var39.getPumPr());
                     }
                  } else {
                     var79.setTicligPump(var36);
                  }

                  var78.modif(var79, var9);
               }
            }

            new ArrayList();
            var35 = "chaligCode='" + var2.getProCode() + "' and ChargementEntete.chamobDate >= '" + var38 + "' and (chaligDepotCharg is null or chaligDepotCharg = '' or chaligDepotCharg = '" + var3 + "')";
            List var80 = var31.rechercheLivraisonRequete(var35, var9);
            int var54;
            if (var80.size() != 0) {
               new ChargementLigne();

               for(var53 = 0; var53 < var80.size(); ++var53) {
                  ChargementLigne var81 = (ChargementLigne)var80.get(var53);
                  var34 = var1.dateToSQLLight(var81.getChargementEntete().getChamobDate());
                  var39 = null;

                  for(var54 = 0; var54 < var40.size(); ++var54) {
                     if (var34.compareTo(((PumpAchats)var40.get(var54)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var54);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var81.setChaligPump(var39.getPumPump());
                     } else {
                        var81.setChaligPump(var39.getPumPr());
                     }
                  } else {
                     var81.setChaligPump(var36);
                  }

                  var31.modif(var81, var9);
               }
            }

            new ArrayList();
            var35 = "binligCode='" + var2.getProCode() + "' and bonEntreeEntete.binDate >= '" + var38 + "' and (binligDepot is null or binligDepot = '' or binligDepot = '" + var3 + "')";
            List var82 = var16.rechercheBEntreeRequete(var35, var9);
            int var55;
            if (var82.size() != 0) {
               new BonEntreeLigne();

               for(var54 = 0; var54 < var82.size(); ++var54) {
                  BonEntreeLigne var83 = (BonEntreeLigne)var82.get(var54);
                  var34 = var1.dateToSQLLight(var83.getBonEntreeEntete().getBinDate());
                  var39 = null;

                  for(var55 = 0; var55 < var40.size(); ++var55) {
                     if (var34.compareTo(((PumpAchats)var40.get(var55)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var55);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var83.setBinligPump(var39.getPumPump());
                     } else {
                        var83.setBinligPump(var39.getPumPr());
                     }
                  } else {
                     var83.setBinligPump(var36);
                  }

                  var16.modifLigne(var83, var9);
               }
            }

            new ArrayList();
            var35 = "bouligCode='" + var2.getProCode() + "' and bonSortieEntete.bouDate >= '" + var38 + "' and (bouligDepot is null or bouligDepot = '' or bouligDepot = '" + var3 + "')";
            List var84 = var17.rechercheBSortieRequete(var35, var9);
            int var56;
            if (var84.size() != 0) {
               new BonSortieLigne();

               for(var55 = 0; var55 < var84.size(); ++var55) {
                  BonSortieLigne var85 = (BonSortieLigne)var84.get(var55);
                  var34 = var1.dateToSQLLight(var85.getBonSortieEntete().getBouDate());
                  var39 = null;

                  for(var56 = 0; var56 < var40.size(); ++var56) {
                     if (var34.compareTo(((PumpAchats)var40.get(var56)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var56);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var85.setBouligPump(var39.getPumPump());
                     } else {
                        var85.setBouligPump(var39.getPumPr());
                     }
                  } else {
                     var85.setBouligPump(var36);
                  }

                  var17.modifLigne(var85, var9);
               }
            }

            new ArrayList();
            var35 = "cesligCode='" + var2.getProCode() + "' and cessionEntete.cesDate >= '" + var38 + "' and (cesligDepotDestination is null or cesligDepotDestination = '' or cesligDepotDestination = '" + var3 + "')";
            List var86 = var18.rechercheCessionRequete(var35, var9);
            int var57;
            if (var86.size() != 0) {
               new CessionLigne();

               for(var56 = 0; var56 < var86.size(); ++var56) {
                  CessionLigne var87 = (CessionLigne)var86.get(var56);
                  var34 = var1.dateToSQLLight(var87.getCessionEntete().getCesDate());
                  var39 = null;

                  for(var57 = 0; var57 < var40.size(); ++var57) {
                     if (var34.compareTo(((PumpAchats)var40.get(var57)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var57);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var87.setCesligPump(var39.getPumPump());
                     } else {
                        var87.setCesligPump(var39.getPumPr());
                     }
                  } else {
                     var87.setCesligPump(var36);
                  }

                  var18.modifLigne(var87, var9);
               }
            }

            new ArrayList();
            var35 = "fabligCode='" + var2.getProCode() + "' and fabricationEnteteAchats.fabDate >= '" + var38 + "' and (fabligDepot is null or fabligDepot = '' or fabligDepot = '" + var3 + "')";
            List var88 = var19.rechercheFabricationRequete(var35, var9);
            int var58;
            if (var88.size() != 0) {
               new FabricationLigneAchats();

               for(var57 = 0; var57 < var88.size(); ++var57) {
                  FabricationLigneAchats var89 = (FabricationLigneAchats)var88.get(var57);
                  var34 = var1.dateToSQLLight(var89.getFabricationEnteteAchats().getFabDate());
                  var39 = null;

                  for(var58 = 0; var58 < var40.size(); ++var58) {
                     if (var34.compareTo(((PumpAchats)var40.get(var58)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var58);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var89.setFabligPump(var39.getPumPump());
                     } else {
                        var89.setFabligPump(var39.getPumPr());
                     }
                  } else {
                     var89.setFabligPump(var36);
                  }

                  var19.modifLigne(var89, var9);
               }
            }

            new ArrayList();
            var35 = "cotligCode='" + var2.getProCode() + "' and cotationEnteteAchats.cotDate >= '" + var38 + "'";
            List var90 = var20.rechercheCotationRequete(var35, var9);
            int var59;
            if (var90.size() != 0) {
               new CotationLigneAchats();

               for(var58 = 0; var58 < var90.size(); ++var58) {
                  CotationLigneAchats var91 = (CotationLigneAchats)var90.get(var58);
                  var34 = var1.dateToSQLLight(var91.getCotationEnteteAchats().getCotDate());
                  var39 = null;

                  for(var59 = 0; var59 < var40.size(); ++var59) {
                     if (var34.compareTo(((PumpAchats)var40.get(var59)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var59);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var91.setCotligPump(var39.getPumPump());
                     } else {
                        var91.setCotligPump(var39.getPumPr());
                     }
                  } else {
                     var91.setCotligPump(var36);
                  }

                  var20.modifLigne(var91, var9);
               }
            }

            new ArrayList();
            var35 = "cmdligCode='" + var2.getProCode() + "' and commandeEnteteAchats.cmdDate >= '" + var38 + "' and (cmdligDepot is null or cmdligDepot = '' or cmdligDepot = '" + var3 + "')";
            List var92 = var21.rechercheCommandeRequete(var35, var9);
            int var60;
            if (var92.size() != 0) {
               new CommandeLigneAchats();

               for(var59 = 0; var59 < var92.size(); ++var59) {
                  CommandeLigneAchats var93 = (CommandeLigneAchats)var92.get(var59);
                  var34 = var1.dateToSQLLight(var93.getCommandeEnteteAchats().getCmdDate());
                  var39 = null;

                  for(var60 = 0; var60 < var40.size(); ++var60) {
                     if (var34.compareTo(((PumpAchats)var40.get(var60)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var60);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var93.setCmdligPump(var39.getPumPump());
                     } else {
                        var93.setCmdligPump(var39.getPumPr());
                     }
                  } else {
                     var93.setCmdligPump(var36);
                  }

                  var21.modifLigne(var93, var9);
               }
            }

            new ArrayList();
            var35 = "brfligCode='" + var2.getProCode() + "' and retourEnteteAchats.brfDate >= '" + var38 + "' and (brfligDepot is null or brfligDepot = '' or brfligDepot = '" + var3 + "')";
            List var94 = var22.rechercheRetourRequete(var35, var9);
            int var61;
            if (var94.size() != 0) {
               new RetourLigneAchats();

               for(var60 = 0; var60 < var94.size(); ++var60) {
                  RetourLigneAchats var95 = (RetourLigneAchats)var94.get(var60);
                  var34 = var1.dateToSQLLight(var95.getRetourEnteteAchats().getBrfDate());
                  var39 = null;

                  for(var61 = 0; var61 < var40.size(); ++var61) {
                     if (var34.compareTo(((PumpAchats)var40.get(var61)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var61);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var95.setBrfligPump(var39.getPumPump());
                     } else {
                        var95.setBrfligPump(var39.getPumPr());
                     }
                  } else {
                     var95.setBrfligPump(var36);
                  }

                  var22.modifLigne(var95, var9);
               }
            }

            new ArrayList();
            var35 = "fcfligCode='" + var2.getProCode() + "' and factureEnteteAchats.fcfDate >= '" + var38 + "' and (fcfligDepot is null or fcfligDepot = '' or fcfligDepot = '" + var3 + "')";
            List var96 = var23.rechercheFactureRequete(var35, var9);
            int var62;
            if (var96.size() != 0) {
               new FactureLigneAchats();

               for(var61 = 0; var61 < var96.size(); ++var61) {
                  FactureLigneAchats var97 = (FactureLigneAchats)var96.get(var61);
                  var34 = var1.dateToSQLLight(var97.getFactureEnteteAchats().getFcfDate());
                  var39 = null;

                  for(var62 = 0; var62 < var40.size(); ++var62) {
                     if (var34.compareTo(((PumpAchats)var40.get(var62)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var62);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var97.setFcfligPump(var39.getPumPump());
                     } else {
                        var97.setFcfligPump(var39.getPumPr());
                     }
                  } else {
                     var97.setFcfligPump(var36);
                  }

                  var23.modifLigne(var97, var9);
               }
            }

            new ArrayList();
            var35 = "avfligCode='" + var2.getProCode() + "' and avoirEnteteAchats.avfDate >= '" + var38 + "'";
            List var98 = var24.rechercheAvoirRequete(var35, var9);
            if (var98.size() != 0) {
               new AvoirLigneAchats();

               for(var62 = 0; var62 < var98.size(); ++var62) {
                  AvoirLigneAchats var99 = (AvoirLigneAchats)var98.get(var62);
                  var34 = var1.dateToSQLLight(var99.getAvoirEnteteAchats().getAvfDate());
                  var39 = null;

                  for(int var63 = 0; var63 < var40.size(); ++var63) {
                     if (var34.compareTo(((PumpAchats)var40.get(var63)).getPumDate()) >= 0) {
                        var39 = (PumpAchats)var40.get(var63);
                     }
                  }

                  if (var39 != null) {
                     if (var39.getPumPump() != 0.0D) {
                        var99.setAvfligPump(var39.getPumPump());
                     } else {
                        var99.setAvfligPump(var39.getPumPr());
                     }
                  } else {
                     var99.setAvfligPump(var36);
                  }

                  var24.modifLigne(var99, var9);
               }
            }

            var9.flush();
         }
      }

   }

   public FormUtilitaires getFormUtilitaires() {
      return this.formUtilitaires;
   }

   public void setFormUtilitaires(FormUtilitaires var1) {
      this.formUtilitaires = var1;
   }
}
