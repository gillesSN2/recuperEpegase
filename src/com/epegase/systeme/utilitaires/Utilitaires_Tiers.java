package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.AvoirEnteteAchats;
import com.epegase.systeme.classe.AvoirEnteteVentes;
import com.epegase.systeme.classe.BonEncaissementVente;
import com.epegase.systeme.classe.CommandeEnteteAchats;
import com.epegase.systeme.classe.CommandeEnteteVentes;
import com.epegase.systeme.classe.Contacts;
import com.epegase.systeme.classe.ContratEnteteVentes;
import com.epegase.systeme.classe.CotationEnteteAchats;
import com.epegase.systeme.classe.DevisEnteteVentes;
import com.epegase.systeme.classe.FactureEnteteAchats;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.FraisEnteteAchats;
import com.epegase.systeme.classe.LivraisonEnteteVentes;
import com.epegase.systeme.classe.NoteDebitEnteteAchats;
import com.epegase.systeme.classe.NoteDebitEnteteVentes;
import com.epegase.systeme.classe.PlansAnalytiques;
import com.epegase.systeme.classe.ReceptionEnteteAchats;
import com.epegase.systeme.classe.Reglements;
import com.epegase.systeme.classe.Responsable;
import com.epegase.systeme.classe.RetourEnteteAchats;
import com.epegase.systeme.classe.RetourEnteteVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TicketEnteteVentes;
import com.epegase.systeme.classe.Tiers;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.AvoirEnteteAchatsDao;
import com.epegase.systeme.dao.AvoirEnteteVentesDao;
import com.epegase.systeme.dao.BonEncaissementVenteDao;
import com.epegase.systeme.dao.CommandeEnteteAchatsDao;
import com.epegase.systeme.dao.CommandeEnteteVentesDao;
import com.epegase.systeme.dao.ContactDao;
import com.epegase.systeme.dao.ContratEnteteVentesDao;
import com.epegase.systeme.dao.CotationEnteteAchatsDao;
import com.epegase.systeme.dao.DevisEnteteVentesDao;
import com.epegase.systeme.dao.FactureEnteteAchatsDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FraisEnteteAchatsDao;
import com.epegase.systeme.dao.LivraisonEnteteVentesDao;
import com.epegase.systeme.dao.NoteDebitEnteteAchatsDao;
import com.epegase.systeme.dao.NoteDebitEnteteVentesDao;
import com.epegase.systeme.dao.PlansAnalytiquesDao;
import com.epegase.systeme.dao.ReceptionEnteteAchatsDao;
import com.epegase.systeme.dao.ReglementsDao;
import com.epegase.systeme.dao.ResponsableDao;
import com.epegase.systeme.dao.RetourEnteteAchatsDao;
import com.epegase.systeme.dao.RetourEnteteVentesDao;
import com.epegase.systeme.dao.TicketEnteteVentesDao;
import com.epegase.systeme.dao.TiersDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Utilitaires_Tiers implements Serializable {
   public void fusionTiers(long var1, Tiers var3, Tiers var4, TiersDao var5, Structure var6, Users var7, String var8, UtilInitHibernate var9) throws HibernateException, NamingException {
      Session var10 = var9.getOpenSession(var8, "CalculMouvementStock");
      Transaction var11 = null;

      try {
         var11 = var10.beginTransaction();
         List var12;
         int var15;
         int var17;
         int var19;
         int var21;
         int var23;
         int var25;
         int var27;
         int var29;
         int var31;
         int var33;
         List var48;
         List var52;
         List var59;
         List var63;
         List var67;
         List var71;
         List var75;
         List var79;
         List var83;
         if (!var3.getTietype().equals("1") && !var3.getTietype().equals("2") && !var3.getTietype().equals("3")) {
            if (var3.getTietype().equals("0")) {
               new ArrayList();
               CotationEnteteAchatsDao var46 = new CotationEnteteAchatsDao(var8, var9);
               var12 = var46.rechercheByTiers(var3, var10);
               if (var12.size() != 0) {
                  new CotationEnteteAchats();

                  for(var15 = 0; var15 < var12.size(); ++var15) {
                     CotationEnteteAchats var49 = (CotationEnteteAchats)var12.get(var15);
                     var49.setTiers(var4);
                     var49.setCotNomTiers(var4.getTieraisonsocialenom());
                     var46.modif(var49, var10);
                  }

                  var10.flush();
               }

               new ArrayList();
               CommandeEnteteAchatsDao var53 = new CommandeEnteteAchatsDao(var8, var9);
               var48 = var53.rechercheByTiers(var3, var10);
               if (var48.size() != 0) {
                  new CommandeEnteteAchats();

                  for(var17 = 0; var17 < var48.size(); ++var17) {
                     CommandeEnteteAchats var54 = (CommandeEnteteAchats)var48.get(var17);
                     var54.setTiers(var4);
                     var54.setCmdNomTiers(var4.getTieraisonsocialenom());
                     var53.modif(var54, var10);
                  }

                  var10.flush();
               }

               new ArrayList();
               ReceptionEnteteAchatsDao var60 = new ReceptionEnteteAchatsDao(var8, var9);
               var52 = var60.rechercheByTiers(var3, var10);
               if (var52.size() != 0) {
                  new ReceptionEnteteAchats();

                  for(var19 = 0; var19 < var52.size(); ++var19) {
                     ReceptionEnteteAchats var61 = (ReceptionEnteteAchats)var52.get(var19);
                     var61.setTiers(var4);
                     var61.setRecNomTiers(var4.getTieraisonsocialenom());
                     var60.modif(var61, var10);
                  }

                  var10.flush();
               }

               new ArrayList();
               RetourEnteteAchatsDao var64 = new RetourEnteteAchatsDao(var8, var9);
               var59 = var64.rechercheByTiers(var3, var10);
               if (var59.size() != 0) {
                  new RetourEnteteAchats();

                  for(var21 = 0; var21 < var59.size(); ++var21) {
                     RetourEnteteAchats var65 = (RetourEnteteAchats)var59.get(var21);
                     var65.setTiers(var4);
                     var65.setBrfNomTiers(var4.getTieraisonsocialenom());
                     var64.modif(var65, var10);
                  }

                  var10.flush();
               }

               new ArrayList();
               FactureEnteteAchatsDao var68 = new FactureEnteteAchatsDao(var8, var9);
               var63 = var68.rechercheByTiers(var3, var10);
               if (var63.size() != 0) {
                  new FactureEnteteAchats();

                  for(var23 = 0; var23 < var63.size(); ++var23) {
                     FactureEnteteAchats var69 = (FactureEnteteAchats)var63.get(var23);
                     var69.setTiers(var4);
                     var69.setFcfNomTiers(var4.getTieraisonsocialenom());
                     var68.modif(var69, var10);
                  }

                  var10.flush();
               }

               new ArrayList();
               NoteDebitEnteteAchatsDao var72 = new NoteDebitEnteteAchatsDao(var8, var9);
               var67 = var72.rechercheByTiers(var3, var10);
               if (var67.size() != 0) {
                  new NoteDebitEnteteAchats();

                  for(var25 = 0; var25 < var67.size(); ++var25) {
                     NoteDebitEnteteAchats var73 = (NoteDebitEnteteAchats)var67.get(var25);
                     var73.setTiers(var4);
                     var73.setNdfNomTiers(var4.getTieraisonsocialenom());
                     var72.modif(var73, var10);
                  }

                  var10.flush();
               }

               new ArrayList();
               AvoirEnteteAchatsDao var76 = new AvoirEnteteAchatsDao(var8, var9);
               var71 = var76.rechercheByTiers(var3, var10);
               if (var71.size() != 0) {
                  new AvoirEnteteAchats();

                  for(var27 = 0; var27 < var71.size(); ++var27) {
                     AvoirEnteteAchats var77 = (AvoirEnteteAchats)var71.get(var27);
                     var77.setTiers(var4);
                     var77.setAvfNomTiers(var4.getTieraisonsocialenom());
                     var76.modif(var77, var10);
                  }

                  var10.flush();
               }

               new ArrayList();
               FraisEnteteAchatsDao var80 = new FraisEnteteAchatsDao(var8, var9);
               var75 = var80.rechercheByTiers(var3, var10);
               if (var75.size() != 0) {
                  new FraisEnteteAchats();

                  for(var29 = 0; var29 < var75.size(); ++var29) {
                     FraisEnteteAchats var81 = (FraisEnteteAchats)var75.get(var29);
                     var81.setTiers(var4);
                     var81.setFsfNomTiers(var4.getTieraisonsocialenom());
                     var80.modif(var81, var10);
                  }

                  var10.flush();
               }

               new ArrayList();
               BonEncaissementVenteDao var84 = new BonEncaissementVenteDao(var8, var9);
               var79 = var84.rechercheByTiersFournisseur(var3, var10);
               if (var79.size() != 0) {
                  new BonEncaissementVente();

                  for(var31 = 0; var31 < var79.size(); ++var31) {
                     BonEncaissementVente var85 = (BonEncaissementVente)var79.get(var31);
                     var85.setBonIdTiers(var4.getTieid());
                     var85.setBonNomTiers(var4.getTieraisonsocialenom());
                     var84.ModifBon(var85, var10);
                  }

                  var10.flush();
               }

               new ArrayList();
               ReglementsDao var88 = new ReglementsDao(var8, var9);
               var83 = var88.rechercheByTiersFournisseur(var3, var10);
               if (var83.size() != 0) {
                  new Reglements();

                  for(var33 = 0; var33 < var83.size(); ++var33) {
                     Reglements var89 = (Reglements)var83.get(var33);
                     var89.setRglIdTiers(var4.getTieid());
                     var89.setRglNomTiers(var4.getTieraisonsocialenom());
                     var88.modifierReg(var89, var10);
                  }

                  var10.flush();
               }
            }
         } else {
            new ArrayList();
            DevisEnteteVentesDao var13 = new DevisEnteteVentesDao(var8, var9);
            var12 = var13.rechercheByTiers(var3, var10);
            if (var12.size() != 0) {
               new DevisEnteteVentes();

               for(var15 = 0; var15 < var12.size(); ++var15) {
                  DevisEnteteVentes var14 = (DevisEnteteVentes)var12.get(var15);
                  var14.setTiers(var4);
                  var14.setDvsNomTiers(var4.getTieraisonsocialenom());
                  var13.modif(var14, var10);
               }

               var10.flush();
            }

            new ArrayList();
            CommandeEnteteVentesDao var51 = new CommandeEnteteVentesDao(var8, var9);
            var48 = var51.rechercheByTiers(var3, var10);
            if (var48.size() != 0) {
               new CommandeEnteteVentes();

               for(var17 = 0; var17 < var48.size(); ++var17) {
                  CommandeEnteteVentes var16 = (CommandeEnteteVentes)var48.get(var17);
                  var16.setTiers(var4);
                  var16.setBcmNomTiers(var4.getTieraisonsocialenom());
                  var51.modif(var16, var10);
               }

               var10.flush();
            }

            new ArrayList();
            LivraisonEnteteVentesDao var57 = new LivraisonEnteteVentesDao(var8, var9);
            var52 = var57.rechercheByTiers(var3, var10);
            if (var52.size() != 0) {
               new LivraisonEnteteVentes();

               for(var19 = 0; var19 < var52.size(); ++var19) {
                  LivraisonEnteteVentes var18 = (LivraisonEnteteVentes)var52.get(var19);
                  var18.setTiers(var4);
                  var18.setBlvNomTiers(var4.getTieraisonsocialenom());
                  var57.modif(var18, var10);
               }

               var10.flush();
            }

            new ArrayList();
            RetourEnteteVentesDao var62 = new RetourEnteteVentesDao(var8, var9);
            var59 = var62.rechercheByTiers(var3, var10);
            if (var59.size() != 0) {
               new RetourEnteteVentes();

               for(var21 = 0; var21 < var59.size(); ++var21) {
                  RetourEnteteVentes var20 = (RetourEnteteVentes)var59.get(var21);
                  var20.setTiers(var4);
                  var20.setBrtNomTiers(var4.getTieraisonsocialenom());
                  var62.modif(var20, var10);
               }

               var10.flush();
            }

            new ArrayList();
            FactureEnteteVentesDao var66 = new FactureEnteteVentesDao(var8, var9);
            var63 = var66.rechercheByTiers(var3, var10);
            if (var63.size() != 0) {
               new FactureEnteteVentes();

               for(var23 = 0; var23 < var63.size(); ++var23) {
                  FactureEnteteVentes var22 = (FactureEnteteVentes)var63.get(var23);
                  var22.setTiers(var4);
                  var22.setFacNomTiers(var4.getTieraisonsocialenom());
                  var66.modif(var22, var10);
               }

               var10.flush();
            }

            new ArrayList();
            FactureInterneEnteteVentesDao var70 = new FactureInterneEnteteVentesDao(var8, var9);
            var67 = var70.rechercheByTiers(var3, var10);
            if (var67.size() != 0) {
               new FactureInterneEnteteVentes();

               for(var25 = 0; var25 < var67.size(); ++var25) {
                  FactureInterneEnteteVentes var24 = (FactureInterneEnteteVentes)var67.get(var25);
                  var24.setTiers(var4);
                  var24.setFitNomTiers(var4.getTieraisonsocialenom());
                  var70.modif(var24, var10);
               }

               var10.flush();
            }

            new ArrayList();
            TicketEnteteVentesDao var74 = new TicketEnteteVentesDao(var8, var9);
            var71 = var74.rechercheByTiers(var3, var10);
            if (var71.size() != 0) {
               new TicketEnteteVentes();

               for(var27 = 0; var27 < var71.size(); ++var27) {
                  TicketEnteteVentes var26 = (TicketEnteteVentes)var71.get(var27);
                  var26.setTiers(var4);
                  var26.setTicNomTiers(var4.getTieraisonsocialenom());
                  var74.modif(var26, var10);
               }

               var10.flush();
            }

            new ArrayList();
            ContratEnteteVentesDao var78 = new ContratEnteteVentesDao(var8, var9);
            var75 = var78.rechercheByTiers(var3, var10);
            if (var75.size() != 0) {
               new ContratEnteteVentes();

               for(var29 = 0; var29 < var75.size(); ++var29) {
                  ContratEnteteVentes var28 = (ContratEnteteVentes)var75.get(var29);
                  var28.setTiers(var4);
                  var28.setCrtNomTiers(var4.getTieraisonsocialenom());
                  var78.modif(var28, var10);
               }

               var10.flush();
            }

            new ArrayList();
            NoteDebitEnteteVentesDao var82 = new NoteDebitEnteteVentesDao(var8, var9);
            var79 = var82.rechercheByTiers(var3, var10);
            if (var79.size() != 0) {
               new NoteDebitEnteteVentes();

               for(var31 = 0; var31 < var79.size(); ++var31) {
                  NoteDebitEnteteVentes var30 = (NoteDebitEnteteVentes)var79.get(var31);
                  var30.setTiers(var4);
                  var30.setNdbNomTiers(var4.getTieraisonsocialenom());
                  var82.modif(var30, var10);
               }

               var10.flush();
            }

            new ArrayList();
            AvoirEnteteVentesDao var86 = new AvoirEnteteVentesDao(var8, var9);
            var83 = var86.rechercheByTiers(var3, var10);
            if (var83.size() != 0) {
               new AvoirEnteteVentes();

               for(var33 = 0; var33 < var83.size(); ++var33) {
                  AvoirEnteteVentes var32 = (AvoirEnteteVentes)var83.get(var33);
                  var32.setTiers(var4);
                  var32.setAvrNomTiers(var4.getTieraisonsocialenom());
                  var86.modif(var32, var10);
               }

               var10.flush();
            }

            new ArrayList();
            BonEncaissementVenteDao var90 = new BonEncaissementVenteDao(var8, var9);
            List var87 = var90.rechercheByTiersClient(var3, var10);
            if (var87.size() != 0) {
               new BonEncaissementVente();

               for(int var35 = 0; var35 < var87.size(); ++var35) {
                  BonEncaissementVente var34 = (BonEncaissementVente)var87.get(var35);
                  var34.setBonIdTiers(var4.getTieid());
                  var34.setBonNomTiers(var4.getTieraisonsocialenom());
                  var90.ModifBon(var34, var10);
               }

               var10.flush();
            }

            new ArrayList();
            ReglementsDao var92 = new ReglementsDao(var8, var9);
            List var91 = var92.rechercheByTiersClient(var3, 0, var10);
            if (var91.size() != 0) {
               new Reglements();

               for(int var37 = 0; var37 < var91.size(); ++var37) {
                  Reglements var36 = (Reglements)var91.get(var37);
                  var36.setRglIdTiers(var4.getTieid());
                  var36.setRglNomTiers(var4.getTieraisonsocialenom());
                  var92.modifierReg(var36, var10);
               }

               var10.flush();
            }

            new ArrayList();
            PlansAnalytiquesDao var94 = new PlansAnalytiquesDao(var8, var9);
            String var38 = "anaAffaireIdClient=" + var3;
            List var93 = var94.rechercheAnalytiqueRequete(var38, var10);
            if (var93.size() != 0) {
               new PlansAnalytiques();

               for(int var40 = 0; var40 < var93.size(); ++var40) {
                  PlansAnalytiques var39 = (PlansAnalytiques)var93.get(var40);
                  var39.setAnaAffaireIdClient(var4.getTieid());
                  var39.setAnaAffaireNomClient(var4.getTieraisonsocialenom());
                  var94.modif(var39, var10);
               }

               var10.flush();
            }
         }

         new ArrayList();
         ContactDao var47 = new ContactDao(var8, var9);
         var12 = var47.listContactByTiers(var3, var10);
         if (var12.size() != 0) {
            new Contacts();

            for(var15 = 0; var15 < var12.size(); ++var15) {
               Contacts var50 = (Contacts)var12.get(var15);
               var50.setTiers(var4);
               var47.modif(var50, var10);
            }

            var10.flush();
         }

         new ArrayList();
         ResponsableDao var56 = new ResponsableDao(var8, var9);
         var48 = var56.chargerLesResponsables(var3, var10);
         if (var48.size() != 0) {
            new Responsable();

            for(var17 = 0; var17 < var48.size(); ++var17) {
               Responsable var55 = (Responsable)var48.get(var17);
               var55.setTiers(var4);
               var56.modif(var55, var10);
            }

            var10.flush();
         }

         new Tiers();
         Tiers var58 = var5.selectTierD(var1, var10);
         if (var58 != null) {
            var5.delete(var58, var10);
         }

         var11.commit();
      } catch (HibernateException var44) {
         if (var11 != null) {
            var11.rollback();
         }

         throw var44;
      } finally {
         var9.closeSession();
      }

   }
}
