package com.epegase.systeme.utilitaires;

import com.epegase.systeme.classe.Brouillard;
import com.epegase.systeme.classe.Ecritures;
import com.epegase.systeme.classe.EcrituresAnalytique;
import com.epegase.systeme.classe.FactureEnteteVentes;
import com.epegase.systeme.classe.FactureInterneEnteteVentes;
import com.epegase.systeme.classe.ManifestEntete;
import com.epegase.systeme.control.DocumentEntete;
import com.epegase.systeme.dao.BrouillardDao;
import com.epegase.systeme.dao.EcrituresAnalytiquesDao;
import com.epegase.systeme.dao.EcrituresDao;
import com.epegase.systeme.dao.FactureEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneEnteteVentesDao;
import com.epegase.systeme.dao.FactureInterneLigneVentesDao;
import com.epegase.systeme.dao.FactureLigneVentesDao;
import com.epegase.systeme.dao.ManifestEnteteDao;
import com.epegase.systeme.util.UtilInitHibernate;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Utilitaires_Parc implements Serializable {
   String listFac = "";
   String listeFacIn = "";

   public List rechercherDeverrouilleManifeste(Date var1, Date var2, List var3, String var4, UtilInitHibernate var5) throws HibernateException, NamingException, ParseException {
      ManifestEnteteDao var6 = new ManifestEnteteDao(var4, var5);
      Session var7 = var5.getOpenSession(var4, "ManifestEntete");
      new DocumentEntete();
      new ArrayList();
      List var9 = var6.rechercheFactureByDate(var1, var2, var7);
      if (var9.size() != 0) {
         new ManifestEntete();

         for(int var11 = 0; var11 < var9.size(); ++var11) {
            ManifestEntete var10 = (ManifestEntete)var9.get(var11);
            if (var10.getVtemanEtat() == 1 || var10.getVtemanEtat() == 4) {
               DocumentEntete var8 = new DocumentEntete();
               var8.setDocId(var10.getVtemanId());
               var8.setDocDate(var10.getVtemanDateDep());
               var8.setDocNum(var10.getVtemanNum());
               var8.setDocSerie(var10.getVtemanSerie());
               var8.setDocNature(47);
               var8.setDocNomTiers(var10.getVtemanLibPortDep());
               var8.setDocNomContact(var10.getVtemanNomCommercial());
               var8.setDocTotHt(var10.getVtemanTotalHt());
               var8.setDocTotTva(var10.getVtemanTotalTva());
               var8.setDocTotTtc(var10.getVtemanTotalTtc());
               var8.setDocAnal4(var10.getVtemanRefNavire());
               var8.setDocObject(var10.getVtemanObjet());
               var3.add(var8);
            }
         }
      }

      return var3;
   }

   public void deverrouilleManifeste(Date var1, Date var2, List var3, String var4, UtilInitHibernate var5) throws HibernateException, NamingException {
      Session var6 = var5.getOpenSession(var4, "DocumentTransfertVte");
      EcrituresAnalytiquesDao var7 = new EcrituresAnalytiquesDao(var4, var5);
      EcrituresDao var8 = new EcrituresDao(var4, var5);
      BrouillardDao var9 = new BrouillardDao(var4, var5);
      FactureEnteteVentesDao var10 = new FactureEnteteVentesDao(var4, var5);
      FactureLigneVentesDao var11 = new FactureLigneVentesDao(var4, var5);
      FactureInterneEnteteVentesDao var12 = new FactureInterneEnteteVentesDao(var4, var5);
      FactureInterneLigneVentesDao var13 = new FactureInterneLigneVentesDao(var4, var5);
      ManifestEnteteDao var14 = new ManifestEnteteDao(var4, var5);
      boolean var15 = true;
      Transaction var16 = null;
      new ArrayList();
      new ArrayList();
      String var19 = "";

      List var21;
      EcrituresAnalytique var22;
      try {
         var16 = var6.beginTransaction();

         for(int var20 = 0; var20 < var3.size(); ++var20) {
            if (((DocumentEntete)var3.get(var20)).isDocSelect()) {
               var19 = ((DocumentEntete)var3.get(var20)).getDocNum();
               this.calculListeFactureExterne(var19, var10, var6);
               this.calculListeFactureInterne(var19, var12, var6);
               new ArrayList();
               new EcrituresAnalytique();
               String var23 = "(ecritures.ecrDossier='" + var19 + " and ecritures.ecrIdOrigine=0)";
               if (this.listFac != null && !this.listFac.isEmpty()) {
                  var23 = var23 + " or (ecrTypeOrigine = '25' and ecrIdOrigine in (" + this.listFac + "))";
               }

               if (this.listeFacIn != null && !this.listeFacIn.isEmpty()) {
                  var23 = var23 + " or (ecrTypeOrigine = '142' and ecrIdOrigine in (" + this.listeFacIn + "))";
               }

               var21 = var7.ChargerLesEcrituresanalytiquesRecherche(var23, var6);
               if (var21.size() != 0) {
                  for(int var24 = 0; var24 < var21.size(); ++var24) {
                     var22 = (EcrituresAnalytique)var21.get(var24);
                     var7.nettoyageAnalytique(var22, var6);
                  }
               }
            }
         }

         var16.commit();
      } catch (HibernateException var68) {
         if (var16 != null) {
            var15 = false;
            var16.rollback();
         }

         throw var68;
      } finally {
         var5.closeSession();
      }

      if (var15) {
         var6 = var5.getOpenSession(var4, "DocumentTransfertVte");
         Transaction var70 = null;

         try {
            var70 = var6.beginTransaction();

            for(int var71 = 0; var71 < var3.size(); ++var71) {
               if (((DocumentEntete)var3.get(var71)).isDocSelect()) {
                  var19 = ((DocumentEntete)var3.get(var71)).getDocNum();
                  this.calculListeFactureExterne(var19, var10, var6);
                  this.calculListeFactureInterne(var19, var12, var6);
                  new ArrayList();
                  new Ecritures();
                  String var76 = "(ecrDossier='" + var19 + " and ecrIdOrigine=0)";
                  if (this.listFac != null && !this.listFac.isEmpty()) {
                     var76 = var76 + " or (ecrTypeOrigine = '25' and ecrIdOrigine in (" + this.listFac + "))";
                  }

                  if (this.listeFacIn != null && !this.listeFacIn.isEmpty()) {
                     var76 = var76 + " or (ecrTypeOrigine = '142' and ecrIdOrigine in (" + this.listeFacIn + "))";
                  }

                  List var73 = var8.ChargerLesEcrituresRecherche(var76, var6);
                  if (var73.size() != 0) {
                     for(int var25 = 0; var25 < var73.size(); ++var25) {
                        Ecritures var77 = (Ecritures)var73.get(var25);
                        var8.removeSelectedEC0(var77, 0, var6);
                     }
                  }
               }
            }

            var70.commit();
         } catch (HibernateException var66) {
            if (var70 != null) {
               var15 = false;
               var70.rollback();
            }

            throw var66;
         } finally {
            var5.closeSession();
         }

         if (var15) {
            var6 = var5.getOpenSession(var4, "DocumentTransfertVte");
            var21 = null;

            try {
               Transaction var72 = var6.beginTransaction();
               int var74 = 0;

               while(true) {
                  if (var74 >= var3.size()) {
                     var72.commit();
                     break;
                  }

                  if (((DocumentEntete)var3.get(var74)).isDocSelect()) {
                     var19 = ((DocumentEntete)var3.get(var74)).getDocNum();
                     this.calculListeFactureExterne(var19, var10, var6);
                     this.calculListeFactureInterne(var19, var12, var6);
                     new ArrayList();
                     new Brouillard();
                     String var80 = "(broDossier='" + var19 + " and broIdOrigine=0)";
                     if (this.listFac != null && !this.listFac.isEmpty()) {
                        var80 = var80 + " or (broTypeOrigine = '25' and broIdOrigine in (" + this.listFac + "))";
                     }

                     if (this.listeFacIn != null && !this.listeFacIn.isEmpty()) {
                        var80 = var80 + " or (broTypeOrigine = '142' and broIdOrigine in (" + this.listeFacIn + "))";
                     }

                     List var78 = var9.ChargerLesBrouillardsRecherche(var80, var6);
                     if (var78.size() != 0) {
                        for(int var26 = 0; var26 < var78.size(); ++var26) {
                           Brouillard var81 = (Brouillard)var78.get(var26);
                           var9.removeSelected(var81, var6);
                        }
                     }
                  }

                  ++var74;
               }
            } catch (HibernateException var64) {
               if (var21 != null) {
                  var15 = false;
                  var21.rollback();
               }

               throw var64;
            } finally {
               var5.closeSession();
            }

            if (var15) {
               var6 = var5.getOpenSession(var4, "DocumentTransfertVte");
               var22 = null;

               try {
                  Transaction var75 = var6.beginTransaction();

                  for(int var79 = 0; var79 < var3.size(); ++var79) {
                     if (((DocumentEntete)var3.get(var79)).isDocSelect()) {
                        var19 = ((DocumentEntete)var3.get(var79)).getDocNum();
                        List var17 = this.calculListeFactureExterne(var19, var10, var6);
                        List var18 = this.calculListeFactureInterne(var19, var12, var6);
                        new DocumentEntete();
                        new FactureEnteteVentes();
                        new FactureInterneEnteteVentes();
                        new ManifestEntete();
                        int var28;
                        if (var17.size() != 0) {
                           for(var28 = 0; var28 < var17.size(); ++var28) {
                              FactureEnteteVentes var83 = (FactureEnteteVentes)var17.get(var28);
                              var11.deleteAllLigne(var83, var6);
                              var10.delete(var83, var6);
                           }
                        }

                        if (var18.size() != 0) {
                           for(var28 = 0; var28 < var18.size(); ++var28) {
                              FactureInterneEnteteVentes var82 = (FactureInterneEnteteVentes)var18.get(var28);
                              var13.deleteAllLigne(var82, var6);
                              var12.delete(var82.getFitId(), var6);
                           }
                        }

                        ManifestEntete var27 = var14.pourParapheur(var19, var6);
                        if (var27 != null) {
                           var27.setVtemanEtat(0);
                           var14.modif(var27, var6);
                        }
                     }
                  }

                  var75.commit();
               } catch (HibernateException var62) {
                  if (var22 != null) {
                     var22.rollback();
                  }

                  throw var62;
               } finally {
                  var5.closeSession();
               }
            }
         }
      }

   }

   public List calculListeFactureExterne(String var1, FactureEnteteVentesDao var2, Session var3) throws HibernateException, NamingException {
      this.listFac = "";
      new ArrayList();
      String var5 = "facAnal4='" + var1 + "'";
      List var4 = var2.rechercheFactureRequete(var5, var3);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (this.listFac != null && !this.listFac.isEmpty()) {
               this.listFac = this.listFac + "," + ((FactureEnteteVentes)var4.get(var6)).getFacId();
            } else {
               this.listFac = "" + ((FactureEnteteVentes)var4.get(var6)).getFacId();
            }
         }
      }

      return var4;
   }

   public List calculListeFactureInterne(String var1, FactureInterneEnteteVentesDao var2, Session var3) throws HibernateException, NamingException {
      this.listeFacIn = "";
      new ArrayList();
      String var5 = "facAnal4='" + var1 + "'";
      List var4 = var2.rechercheFactureInterneRequete(var5, var3);
      if (var4.size() != 0) {
         for(int var6 = 0; var6 < var4.size(); ++var6) {
            if (this.listeFacIn != null && !this.listeFacIn.isEmpty()) {
               this.listeFacIn = this.listeFacIn + "," + ((FactureInterneEnteteVentes)var4.get(var6)).getFitId();
            } else {
               this.listeFacIn = "" + ((FactureInterneEnteteVentes)var4.get(var6)).getFitId();
            }
         }
      }

      return var4;
   }
}
