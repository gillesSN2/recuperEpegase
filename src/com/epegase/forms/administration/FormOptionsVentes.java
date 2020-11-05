package com.epegase.forms.administration;

import com.epegase.systeme.classe.CaissesCommerciales;
import com.epegase.systeme.classe.ExercicesCaisse;
import com.epegase.systeme.classe.ExercicesVentes;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesVentes;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.CaissesCommercialesDao;
import com.epegase.systeme.dao.DepotAchatsDao;
import com.epegase.systeme.dao.ExercicesCaisseDao;
import com.epegase.systeme.dao.FamillesProduitsVentesDao;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.TaxesVentesDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.SAXException;

public class FormOptionsVentes {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionVentes optionVentes = new OptionVentes();
   private Element racine = new Element("options_ventes");
   private Document document;
   private ObjetCompte objetCompte;
   private boolean griseAnalytique = false;
   private String obsAnalytique;
   private boolean griseProduit = false;
   private String obsProduit;
   private boolean var_affiche_comptoir = false;
   private List meslisteFamilleItems;
   private ExercicesVentes exercicesVentes;
   private List mesDepotsItem;
   private List mesCaissesItem;
   private List mesTvaItem;
   private boolean lib1 = false;
   private boolean lib2 = false;
   private boolean lib3 = false;
   private boolean lib4 = false;
   private boolean lib5 = false;
   private boolean lib6 = false;
   private boolean lib7 = false;
   private boolean lib8 = false;
   private boolean lib9 = false;
   private boolean lib10 = false;
   private boolean moduleTransit = false;
   private boolean moduleParc = false;
   private boolean modulePaye = false;
   private boolean moduleUsine = false;
   private boolean moduleProjet = false;
   private boolean moduleStructure = false;

   public FormOptionsVentes(Structure var1) throws SAXException {
      this.document = new Document(this.racine);
      this.structureLog = var1;
      this.var_affiche_comptoir = this.rechercheModule(80200);
      this.meslisteFamilleItems = new ArrayList();
      this.mesDepotsItem = new ArrayList();
      this.mesCaissesItem = new ArrayList();
      this.mesTvaItem = new ArrayList();
   }

   public void chargerFamilleVente(Session var1) throws HibernateException, NamingException {
      FamillesProduitsVentesDao var2 = new FamillesProduitsVentesDao(this.baseLog, this.utilInitHibernate);
      this.meslisteFamilleItems = var2.chargerFamilleProduitVentesItems(this.exercicesVentes.getExevteId(), var1);
   }

   public void calculeDepotItems(Session var1) throws HibernateException, NamingException {
      this.mesDepotsItem.clear();
      DepotAchatsDao var2 = new DepotAchatsDao(this.baseLog, this.utilInitHibernate);
      this.mesDepotsItem = var2.selectActifDepotItems(0, var1);
   }

   public void calculeCaisseItems(Session var1) throws HibernateException, NamingException, ParseException {
      this.mesCaissesItem.clear();
      new ExercicesCaisse();
      ExercicesCaisseDao var3 = new ExercicesCaisseDao(this.baseLog, this.utilInitHibernate);
      ExercicesCaisse var2 = var3.recupererLastExo(var1);
      if (var2 != null) {
         CaissesCommercialesDao var4 = new CaissesCommercialesDao(this.baseLog, this.utilInitHibernate);
         new ArrayList();
         List var5 = var4.selectActifCaisse(var2.getExecaiId(), var1);
         if (var5.size() != 0) {
            for(int var6 = 0; var6 < var5.size(); ++var6) {
               String var7 = ((CaissesCommerciales)var5.get(var6)).getCaiCode() + ":" + ((CaissesCommerciales)var5.get(var6)).getCaiNom();
               this.mesCaissesItem.add(new SelectItem(var7));
            }
         }
      }

   }

   public void calculeTvaItems(Session var1) throws HibernateException, NamingException {
      this.mesTvaItem.clear();
      TaxesVentesDao var2 = new TaxesVentesDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectActifTaxes(this.exercicesVentes.getExevteId(), var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.mesTvaItem.add(new SelectItem(((TaxesVentes)var3.get(var4)).getTaxvteCode(), ((TaxesVentes)var3.get(var4)).getTaxvteCode() + ":" + ((TaxesVentes)var3.get(var4)).getTaxvteLibelleFr()));
         }
      }

   }

   public boolean rechercheModule(int var1) {
      boolean var2 = false;
      ArrayList var3 = new ArrayList();
      if (this.structureLog.getStrmod1() != null && !this.structureLog.getStrmod1().isEmpty()) {
         var3.add(this.structureLog.getStrmod1());
      }

      if (this.structureLog.getStrmod2() != null && !this.structureLog.getStrmod2().isEmpty()) {
         var3.add(this.structureLog.getStrmod2());
      }

      if (this.structureLog.getStrmod3() != null && !this.structureLog.getStrmod3().isEmpty()) {
         var3.add(this.structureLog.getStrmod3());
      }

      if (this.structureLog.getStrmod4() != null && !this.structureLog.getStrmod4().isEmpty()) {
         var3.add(this.structureLog.getStrmod4());
      }

      if (this.structureLog.getStrmod5() != null && !this.structureLog.getStrmod5().isEmpty()) {
         var3.add(this.structureLog.getStrmod5());
      }

      if (this.structureLog.getStrmod6() != null && !this.structureLog.getStrmod6().isEmpty()) {
         var3.add(this.structureLog.getStrmod6());
      }

      if (this.structureLog.getStrmod7() != null && !this.structureLog.getStrmod7().isEmpty()) {
         var3.add(this.structureLog.getStrmod7());
      }

      if (this.structureLog.getStrmod8() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod8());
      }

      if (this.structureLog.getStrmod9() != null && !this.structureLog.getStrmod8().isEmpty()) {
         var3.add(this.structureLog.getStrmod9());
      }

      if (this.structureLog.getStrmod10() != null && !this.structureLog.getStrmod10().isEmpty()) {
         var3.add(this.structureLog.getStrmod10());
      }

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         String var5 = "" + var1;
         if (var5.contentEquals((CharSequence)var3.get(var4))) {
            var2 = true;
         }
      }

      return var2;
   }

   public void calculeLibEntete() {
      if (this.optionVentes.getLib1ENTETE() != null && !this.optionVentes.getLib1ENTETE().isEmpty()) {
         this.lib1 = true;
      } else {
         this.lib1 = false;
      }

      if (this.optionVentes.getLib2ENTETE() != null && !this.optionVentes.getLib2ENTETE().isEmpty()) {
         this.lib2 = true;
      } else {
         this.lib2 = false;
      }

      if (this.optionVentes.getLib3ENTETE() != null && !this.optionVentes.getLib3ENTETE().isEmpty()) {
         this.lib3 = true;
      } else {
         this.lib3 = false;
      }

      if (this.optionVentes.getLib4ENTETE() != null && !this.optionVentes.getLib4ENTETE().isEmpty()) {
         this.lib4 = true;
      } else {
         this.lib4 = false;
      }

      if (this.optionVentes.getLib5ENTETE() != null && !this.optionVentes.getLib5ENTETE().isEmpty()) {
         this.lib5 = true;
      } else {
         this.lib5 = false;
      }

      if (this.optionVentes.getLib6ENTETE() != null && !this.optionVentes.getLib6ENTETE().isEmpty()) {
         this.lib6 = true;
      } else {
         this.lib6 = false;
      }

      if (this.optionVentes.getLib7ENTETE() != null && !this.optionVentes.getLib7ENTETE().isEmpty()) {
         this.lib7 = true;
      } else {
         this.lib7 = false;
      }

      if (this.optionVentes.getLib8ENTETE() != null && !this.optionVentes.getLib8ENTETE().isEmpty()) {
         this.lib8 = true;
      } else {
         this.lib8 = false;
      }

      if (this.optionVentes.getLib9ENTETE() != null && !this.optionVentes.getLib9ENTETE().isEmpty()) {
         this.lib9 = true;
      } else {
         this.lib9 = false;
      }

      if (this.optionVentes.getLib10ENTETE() != null && !this.optionVentes.getLib10ENTETE().isEmpty()) {
         this.lib10 = true;
      } else {
         this.lib10 = false;
      }

      if (this.structureLog.getStrtypeentreprise() != null && !this.structureLog.getStrtypeentreprise().isEmpty() && this.structureLog.getStrtypeentreprise().equals("2")) {
         this.moduleUsine = true;
      }

      if (this.rechercheModule(80600)) {
         this.moduleTransit = true;
         this.optionVentes.setAxeDossier("3");
      }

      if (this.rechercheModule(70000)) {
         this.moduleParc = true;
      }

      if (this.rechercheModule(50000)) {
         this.modulePaye = true;
      }

      if (this.rechercheModule(40300)) {
         this.moduleProjet = true;
      }

      if (this.structureLog.getStrmaitrecabinet() == 12) {
         this.moduleStructure = true;
      }

   }

   public void creerOptionsVentes() throws IOException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("activiteEnteteLigne");
      this.racine.addContent(var1);
      var1.setText(this.optionVentes.getActiviteEnteteLigne());
      Element var2 = new Element("affichInGlobViewCAMPAGNE");
      this.racine.addContent(var2);
      var2.setText(this.optionVentes.getAffichInGlobViewCAMPAGNE());
      Element var3 = new Element("nbrJrRelanceBESOIN");
      this.racine.addContent(var3);
      var3.setText(this.optionVentes.getNbrJrRelanceBESOIN());
      Element var4 = new Element("nbrJrValidBESOIN");
      this.racine.addContent(var4);
      var4.setText(this.optionVentes.getNbrJrValidBESOIN());
      Element var5 = new Element("affichInTierFilBESOIN");
      this.racine.addContent(var5);
      var5.setText(this.optionVentes.getAffichInTierFilBESOIN());
      Element var6 = new Element("affichInGlobViewBESOIN");
      this.racine.addContent(var6);
      var6.setText(this.optionVentes.getAffichInGlobViewBESOIN());
      Element var7 = new Element("nbrJrRelanceSIMUL");
      this.racine.addContent(var7);
      var7.setText(this.optionVentes.getNbrJrRelanceSIMUL());
      Element var8 = new Element("nbrJrValidSIMUL");
      this.racine.addContent(var8);
      var8.setText(this.optionVentes.getNbrJrValidSIMUL());
      Element var9 = new Element("affichInTierFilSIMUL");
      this.racine.addContent(var9);
      var9.setText(this.optionVentes.getAffichInTierFilSIMUL());
      Element var10 = new Element("affichInGlobViewSIMUL");
      this.racine.addContent(var10);
      var10.setText(this.optionVentes.getAffichInGlobViewSIMUL());
      Element var11 = new Element("familleProduitSIMUL");
      this.racine.addContent(var11);
      var11.setText(this.optionVentes.getFamilleProduitSIMUL());
      Element var12 = new Element("affichInGlobViewAffaire");
      this.racine.addContent(var12);
      var12.setText(this.optionVentes.getAffichInGlobViewAffaire());
      Element var13 = new Element("affichInTierAffaire");
      this.racine.addContent(var13);
      var13.setText(this.optionVentes.getAffichInTierAffaire());
      if (this.optionVentes.getGestionStockBc().equals("1")) {
         this.optionVentes.setValidationDevisBcCOM("0");
      }

      Element var14 = new Element("nbrJrRelanceDEVIS");
      this.racine.addContent(var14);
      var14.setText(this.optionVentes.getNbrJrRelanceDEVIS());
      Element var15 = new Element("nbrJrValidDEVIS");
      this.racine.addContent(var15);
      var15.setText(this.optionVentes.getNbrJrValidDEVIS());
      Element var16 = new Element("affichInTierFilDEVIS");
      this.racine.addContent(var16);
      var16.setText(this.optionVentes.getAffichInTierFilDEVIS());
      Element var17 = new Element("affichInGlobViewDEVIS");
      this.racine.addContent(var17);
      var17.setText(this.optionVentes.getAffichInGlobViewDEVIS());
      Element var18 = new Element("validationDevisBcCOM");
      this.racine.addContent(var18);
      var18.setText(this.optionVentes.getValidationDevisBcCOM());
      Element var19 = new Element("modeCalculDevis");
      this.racine.addContent(var19);
      var19.setText(this.optionVentes.getModeCalculDevis());
      Element var20 = new Element("nbrJrRelanceCOM");
      this.racine.addContent(var20);
      var20.setText(this.optionVentes.getNbrJrRelanceCOM());
      Element var21 = new Element("nbrJrValidCOM");
      this.racine.addContent(var21);
      var21.setText(this.optionVentes.getNbrJrValidCOM());
      Element var22 = new Element("affichInTierFilCOM");
      this.racine.addContent(var22);
      var22.setText(this.optionVentes.getAffichInTierFilCOM());
      Element var23 = new Element("affichInGlobViewCOM");
      this.racine.addContent(var23);
      var23.setText(this.optionVentes.getAffichInGlobViewCOM());
      Element var24 = new Element("impressionBcBlCOM");
      this.racine.addContent(var24);
      var24.setText(this.optionVentes.getImpressionBcBlCOM());
      Element var25 = new Element("validationBcBlCOM");
      this.racine.addContent(var25);
      var25.setText(this.optionVentes.getValidationBcBlCOM());
      Element var26 = new Element("generationBcFab");
      this.racine.addContent(var26);
      var26.setText(this.optionVentes.getGenerationBcFab());
      Element var27 = new Element("gestionStockBc");
      this.racine.addContent(var27);
      var27.setText(this.optionVentes.getGestionStockBc());
      Element var28 = new Element("gestionPlafondBc");
      this.racine.addContent(var28);
      var28.setText(this.optionVentes.getGestionPlafondBc());
      Element var29 = new Element("nbrJrRelanceLIV");
      this.racine.addContent(var29);
      var29.setText(this.optionVentes.getNbrJrRelanceLIV());
      Element var30 = new Element("nbrJrValidLIV");
      this.racine.addContent(var30);
      var30.setText(this.optionVentes.getNbrJrValidLIV());
      Element var31 = new Element("affichInTierFilLIV");
      this.racine.addContent(var31);
      var31.setText(this.optionVentes.getAffichInTierFilLIV());
      Element var32 = new Element("affichInGlobViewLIV");
      this.racine.addContent(var32);
      var32.setText(this.optionVentes.getAffichInGlobViewLIV());
      Element var33 = new Element("gestionLivreur");
      this.racine.addContent(var33);
      var33.setText(this.optionVentes.getGestionLivreur());
      Element var34 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var34);
      var34.setText(this.optionVentes.getNbrJrRelanceFAC());
      Element var35 = new Element("nbrJrValidFAC");
      this.racine.addContent(var35);
      var35.setText(this.optionVentes.getNbrJrValidFAC());
      Element var36 = new Element("affichInTierFilFAC");
      this.racine.addContent(var36);
      var36.setText(this.optionVentes.getAffichInTierFilFAC());
      Element var37 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var37);
      var37.setText(this.optionVentes.getAffichInGlobViewFAC());
      Element var38 = new Element("numBlFac");
      this.racine.addContent(var38);
      var38.setText("" + this.optionVentes.getNumBlFac());
      Element var39 = new Element("gestionPlafondFac");
      this.racine.addContent(var39);
      var39.setText(this.optionVentes.getGestionPlafondFac());
      Element var40 = new Element("gestionImpressionFac");
      this.racine.addContent(var40);
      var40.setText(this.optionVentes.getGestionImpressionFac());
      Element var41 = new Element("gestionNumeroFac");
      this.racine.addContent(var41);
      var41.setText(this.optionVentes.getGestionNumeroFac());
      Element var42 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var42);
      var42.setText(this.optionVentes.getNbrJrRelanceNOTDEB());
      Element var43 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var43);
      var43.setText(this.optionVentes.getNbrJrValidNOTDEB());
      Element var44 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var44);
      var44.setText(this.optionVentes.getAffichInTierFilNOTDEB());
      Element var45 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var45);
      var45.setText(this.optionVentes.getAffichInGlobViewNOTDEB());
      Element var46 = new Element("gestionPlafondNdb");
      this.racine.addContent(var46);
      var46.setText(this.optionVentes.getGestionPlafondNdb());
      Element var47 = new Element("nbrJrRelanceRETOUR");
      this.racine.addContent(var47);
      var47.setText(this.optionVentes.getNbrJrRelanceRETOUR());
      Element var48 = new Element("nbrJrValidRETOUR");
      this.racine.addContent(var48);
      var48.setText(this.optionVentes.getNbrJrValidRETOUR());
      Element var49 = new Element("affichInTierFilRETOUR");
      this.racine.addContent(var49);
      var49.setText(this.optionVentes.getAffichInTierFilRETOUR());
      Element var50 = new Element("affichInGlobViewRETOUR");
      this.racine.addContent(var50);
      var50.setText(this.optionVentes.getAffichInGlobViewRETOUR());
      Element var51 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var51);
      var51.setText(this.optionVentes.getNbrJrRelanceAVOIR());
      Element var52 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var52);
      var52.setText(this.optionVentes.getNbrJrValidAVOIR());
      Element var53 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var53);
      var53.setText(this.optionVentes.getAffichInTierFilAVOIR());
      Element var54 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var54);
      var54.setText(this.optionVentes.getAffichInGlobViewAVOIR());
      Element var55 = new Element("paiementAVOIR");
      this.racine.addContent(var55);
      var55.setText(this.optionVentes.getPaiementAVOIR());
      Element var56 = new Element("modeAvoir");
      this.racine.addContent(var56);
      var56.setText(this.optionVentes.getModeAvoir());
      Element var57 = new Element("affichInGlobViewCh");
      this.racine.addContent(var57);
      var57.setText(this.optionVentes.getAffichInGlobViewCh());
      Element var58 = new Element("depotChargementDefaut");
      this.racine.addContent(var58);
      var58.setText(this.optionVentes.getDepotChargementDefaut());
      Element var59 = new Element("affichInGlobViewCOMMISSION");
      this.racine.addContent(var59);
      var59.setText(this.optionVentes.getAffichInGlobViewCOMMISSION());
      Element var60 = new Element("facture");
      this.racine.addContent(var60);
      var60.setText(this.optionVentes.getFacture());
      Element var61 = new Element("avoir");
      this.racine.addContent(var61);
      var61.setText(this.optionVentes.getAvoir());
      Element var62 = new Element("noteDebit");
      this.racine.addContent(var62);
      var62.setText(this.optionVentes.getNoteDebit());
      Element var63 = new Element("modeCommission");
      this.racine.addContent(var63);
      var63.setText(this.optionVentes.getModeCommission());
      Element var64 = new Element("compteDebit");
      this.racine.addContent(var64);
      var64.setText(this.optionVentes.getCompteDebit());
      Element var65 = new Element("gestRegSectPdvBLC");
      this.racine.addContent(var65);
      var65.setText(this.optionVentes.getGestRegSectPdvBLC());
      Element var66 = new Element("gestActBLC");
      this.racine.addContent(var66);
      var66.setText(this.optionVentes.getGestActBLC());
      Element var67 = new Element("affichInTierFilBLC");
      this.racine.addContent(var67);
      var67.setText(this.optionVentes.getAffichInTierFilBLC());
      Element var68 = new Element("affichInGlobViewBLC");
      this.racine.addContent(var68);
      var68.setText(this.optionVentes.getAffichInGlobViewBLC());
      Element var69 = new Element("gestRegSectPdvFACTC");
      this.racine.addContent(var69);
      var69.setText(this.optionVentes.getGestRegSectPdvFACTC());
      Element var70 = new Element("gestActFACTC");
      this.racine.addContent(var70);
      var70.setText(this.optionVentes.getGestActFACTC());
      Element var71 = new Element("affichInTierFilFACTC");
      this.racine.addContent(var71);
      var71.setText(this.optionVentes.getAffichInTierFilFACTC());
      Element var72 = new Element("affichInGlobViewFACTC");
      this.racine.addContent(var72);
      var72.setText(this.optionVentes.getAffichInGlobViewFACTC());
      Element var73 = new Element("gestRegSectPdvTICKC");
      this.racine.addContent(var73);
      var73.setText(this.optionVentes.getGestRegSectPdvTICKC());
      Element var74 = new Element("gestActTICKC");
      this.racine.addContent(var74);
      var74.setText(this.optionVentes.getGestActTICKC());
      Element var75 = new Element("affichInTierFilTICKC");
      this.racine.addContent(var75);
      var75.setText(this.optionVentes.getAffichInTierFilTICKC());
      Element var76 = new Element("affichInGlobViewTICKC");
      this.racine.addContent(var76);
      var76.setText(this.optionVentes.getAffichInGlobViewTICKC());
      Element var77 = new Element("caisseDefaut");
      this.racine.addContent(var77);
      var77.setText(this.optionVentes.getCaisseDefaut());
      Element var78 = new Element("caisseLivreur");
      this.racine.addContent(var78);
      var78.setText(this.optionVentes.getCaisseLivreur());
      Element var79 = new Element("caisseTable");
      this.racine.addContent(var79);
      var79.setText(this.optionVentes.getCaisseTable());
      Element var80 = new Element("caisseChambre");
      this.racine.addContent(var80);
      var80.setText(this.optionVentes.getCaisseChambre());
      Element var81 = new Element("caisseStock");
      this.racine.addContent(var81);
      var81.setText(this.optionVentes.getCaisseStock());
      Element var82 = new Element("nbrCaracteresFamPRO");
      this.racine.addContent(var82);
      var82.setText(this.optionVentes.getNbrCaracteresFamPRO());
      Element var83 = new Element("nbrCaracteresProPRO");
      this.racine.addContent(var83);
      var83.setText(this.optionVentes.getNbrCaracteresProPRO());
      Element var84 = new Element("modCalcProPRO");
      this.racine.addContent(var84);
      var84.setText(this.optionVentes.getModCalcProPRO());
      Element var85 = new Element("decrmtPrsChrStock");
      this.racine.addContent(var85);
      var85.setText(this.optionVentes.getDecrmtPrsChrStock());
      Element var86 = new Element("nbDecQte");
      this.racine.addContent(var86);
      var86.setText(this.optionVentes.getNbDecQte());
      Element var87 = new Element("nbDecPu");
      this.racine.addContent(var87);
      var87.setText(this.optionVentes.getNbDecPu());
      Element var88 = new Element("decrmtPriVteStock");
      this.racine.addContent(var88);
      var88.setText(this.optionVentes.getDecrmtPriVteStock());
      Element var89 = new Element("decrmtRabais");
      this.racine.addContent(var89);
      var89.setText(this.optionVentes.getDecrmtRabais());
      Element var90 = new Element("analAuto");
      this.racine.addContent(var90);
      var90.setText(this.optionVentes.getAnalAuto());
      Element var91 = new Element("nbLigneMax");
      this.racine.addContent(var91);
      var91.setText(this.optionVentes.getNbLigneMax());
      Element var92 = new Element("libProduit");
      this.racine.addContent(var92);
      var92.setText(this.optionVentes.getLibProduit());
      Element var93 = new Element("responsable");
      this.racine.addContent(var93);
      var93.setText(this.optionVentes.getResponsable());
      Element var94 = new Element("produitGenerique");
      this.racine.addContent(var94);
      var94.setText(this.optionVentes.getProduitGenerique());
      Element var95 = new Element("photosProduit");
      this.racine.addContent(var95);
      var95.setText(this.optionVentes.getPhotosProduit());
      Element var96 = new Element("chargementListe");
      this.racine.addContent(var96);
      var96.setText(this.optionVentes.getChargementListe());
      Element var97 = new Element("descriptifComplementaire");
      this.racine.addContent(var97);
      var97.setText(this.optionVentes.getDescriptifComplementaire());
      Element var98 = new Element("dateTransformation");
      this.racine.addContent(var98);
      var98.setText(this.optionVentes.getDateTransformation());
      Element var99 = new Element("libelleProduit");
      this.racine.addContent(var99);
      var99.setText(this.optionVentes.getLibelleProduit());
      Element var100 = new Element("tvaDefaut");
      this.racine.addContent(var100);
      var100.setText(this.optionVentes.getTvaDefaut());
      Element var101 = new Element("tlvDefaut");
      this.racine.addContent(var101);
      var101.setText(this.optionVentes.getTlvDefaut());
      Element var102 = new Element("tomDefaut");
      this.racine.addContent(var102);
      var102.setText(this.optionVentes.getTomDefaut());
      Element var103 = new Element("irppDefaut");
      this.racine.addContent(var103);
      var103.setText(this.optionVentes.getIrppDefaut());
      Element var104 = new Element("produitAchat");
      this.racine.addContent(var104);
      var104.setText(this.optionVentes.getProduitAchat());
      Element var105 = new Element("choixStock");
      this.racine.addContent(var105);
      var105.setText(this.optionVentes.getChoixStock());
      Element var106 = new Element("tracabilite");
      this.racine.addContent(var106);
      var106.setText(this.optionVentes.getTracabilite());
      Element var107 = new Element("transformation");
      this.racine.addContent(var107);
      var107.setText(this.optionVentes.getTransformation());
      Element var108 = new Element("impPoids");
      this.racine.addContent(var108);
      var108.setText(this.optionVentes.getImpPoids());
      Element var109 = new Element("lib1ENTETE");
      this.racine.addContent(var109);
      var109.setText(this.optionVentes.getLib1ENTETE());
      Element var110 = new Element("lib2ENTETE");
      this.racine.addContent(var110);
      var110.setText(this.optionVentes.getLib2ENTETE());
      Element var111 = new Element("lib3ENTETE");
      this.racine.addContent(var111);
      var111.setText(this.optionVentes.getLib3ENTETE());
      Element var112 = new Element("lib4ENTETE");
      this.racine.addContent(var112);
      var112.setText(this.optionVentes.getLib4ENTETE());
      Element var113 = new Element("lib5ENTETE");
      this.racine.addContent(var113);
      var113.setText(this.optionVentes.getLib5ENTETE());
      Element var114 = new Element("lib6ENTETE");
      this.racine.addContent(var114);
      var114.setText(this.optionVentes.getLib6ENTETE());
      Element var115 = new Element("lib7ENTETE");
      this.racine.addContent(var115);
      var115.setText(this.optionVentes.getLib7ENTETE());
      Element var116 = new Element("lib8ENTETE");
      this.racine.addContent(var116);
      var116.setText(this.optionVentes.getLib8ENTETE());
      Element var117 = new Element("lib9ENTETE");
      this.racine.addContent(var117);
      var117.setText(this.optionVentes.getLib9ENTETE());
      Element var118 = new Element("lib10ENTETE");
      this.racine.addContent(var118);
      var118.setText(this.optionVentes.getLib10ENTETE());
      Element var119 = new Element("transfertDocument");
      this.racine.addContent(var119);
      var119.setText(this.optionVentes.getTransfertDocument());
      Element var120 = new Element("zoneRef1");
      this.racine.addContent(var120);
      var120.setText(this.optionVentes.getZoneRef1());
      Element var121 = new Element("zoneRef2");
      this.racine.addContent(var121);
      var121.setText(this.optionVentes.getZoneRef2());
      Element var122 = new Element("zoneLibelle");
      this.racine.addContent(var122);
      var122.setText(this.optionVentes.getZoneLibelle());
      Element var123 = new Element("zoneLibelleSuite");
      this.racine.addContent(var123);
      var123.setText(this.optionVentes.getZoneLibelleSuite());
      Element var124 = new Element("zoneRef1Serie");
      this.racine.addContent(var124);
      var124.setText(this.optionVentes.getZoneRef1Serie());
      Element var125 = new Element("zoneRef2Serie");
      this.racine.addContent(var125);
      var125.setText(this.optionVentes.getZoneRef2Serie());
      Element var126 = new Element("axeStructure");
      this.racine.addContent(var126);
      var126.setText(this.optionVentes.getAxeStructure());
      Element var127 = new Element("axeSite");
      this.racine.addContent(var127);
      var127.setText(this.optionVentes.getAxeSite());
      Element var128 = new Element("axeRegion");
      this.racine.addContent(var128);
      var128.setText(this.optionVentes.getAxeRegion());
      Element var129 = new Element("axeUsine");
      this.racine.addContent(var129);
      var129.setText(this.optionVentes.getAxeUsine());
      Element var130 = new Element("axeActivite");
      this.racine.addContent(var130);
      var130.setText(this.optionVentes.getAxeActivite());
      Element var131 = new Element("axeAgent");
      this.racine.addContent(var131);
      var131.setText(this.optionVentes.getAxeAgent());
      Element var132 = new Element("axeChantier");
      this.racine.addContent(var132);
      var132.setText(this.optionVentes.getAxeChantier());
      Element var133 = new Element("axeParc");
      this.racine.addContent(var133);
      var133.setText(this.optionVentes.getAxeParc());
      Element var134 = new Element("axeMission");
      this.racine.addContent(var134);
      var134.setText(this.optionVentes.getAxeMission());
      Element var135 = new Element("axeCles");
      this.racine.addContent(var135);
      var135.setText(this.optionVentes.getAxeCles());
      Element var136 = new Element("axeProjet");
      this.racine.addContent(var136);
      var136.setText(this.optionVentes.getAxeProjet());
      Element var137 = new Element("axeDossier");
      this.racine.addContent(var137);
      var137.setText(this.optionVentes.getAxeDossier());
      Element var138 = new Element("chronoMatricule");
      this.racine.addContent(var138);
      var138.setText(this.optionVentes.getChronoMatricule());
      Element var139 = new Element("affichInGlobViewINVENTAIRE");
      this.racine.addContent(var139);
      var139.setText(this.optionVentes.getAffichInGlobViewINVENTAIRE());
      Element var140 = new Element("affichInGlobViewCARNET");
      this.racine.addContent(var140);
      var140.setText(this.optionVentes.getAffichInGlobViewCARNET());
      Element var141 = new Element("saisieCarnet");
      this.racine.addContent(var141);
      var141.setText(this.optionVentes.getSaisieCarnet());
      Element var142 = new Element("affichInGlobViewROULAGE");
      this.racine.addContent(var142);
      var142.setText(this.optionVentes.getAffichInGlobViewROULAGE());
      Element var143 = new Element("saisieRoulage");
      this.racine.addContent(var143);
      var143.setText(this.optionVentes.getSaisieRoulage());
      Element var144 = new Element("affichInGlobViewROUTE");
      this.racine.addContent(var144);
      var144.setText(this.optionVentes.getAffichInGlobViewROUTE());
      Element var145 = new Element("saisieRoute");
      this.racine.addContent(var145);
      var145.setText(this.optionVentes.getSaisieRoute());
      Element var146 = new Element("affichInGlobViewEXPEDITION");
      this.racine.addContent(var146);
      var146.setText(this.optionVentes.getAffichInGlobViewEXPEDITION());
      Element var147 = new Element("saisieExpedition");
      this.racine.addContent(var147);
      var147.setText(this.optionVentes.getSaisieExpedition());
      this.enregistrer();
      StructureDao var148 = new StructureDao(this.baseLog, this.utilInitHibernate);
      new Structure();
      Structure var149;
      if (this.structureLog.getStrid() == 0L) {
         var149 = var148.logStructure((Session)null);
      } else {
         var149 = var148.logStructureId(this.structureLog.getStrid(), (Session)null);
      }

      var149.setStrtypeContact(Integer.parseInt(this.optionVentes.getDecrmtPrsChrStock()));
      var148.modStructure(var149);
   }

   public void updateOptionsVentes() throws IOException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("activiteEnteteLigne");
      this.racine.addContent(var1);
      var1.setText(this.optionVentes.getActiviteEnteteLigne());
      Element var2 = new Element("affichInGlobViewCAMPAGNE");
      this.racine.addContent(var2);
      var2.setText(this.optionVentes.getAffichInGlobViewCAMPAGNE());
      Element var3 = new Element("nbrJrRelanceBESOIN");
      this.racine.addContent(var3);
      var3.setText(this.optionVentes.getNbrJrRelanceBESOIN());
      Element var4 = new Element("nbrJrValidBESOIN");
      this.racine.addContent(var4);
      var4.setText(this.optionVentes.getNbrJrValidBESOIN());
      Element var5 = new Element("affichInTierFilBESOIN");
      this.racine.addContent(var5);
      var5.setText(this.optionVentes.getAffichInTierFilBESOIN());
      Element var6 = new Element("affichInGlobViewBESOIN");
      this.racine.addContent(var6);
      var6.setText(this.optionVentes.getAffichInGlobViewBESOIN());
      Element var7 = new Element("nbrJrRelanceSIMUL");
      this.racine.addContent(var7);
      var7.setText(this.optionVentes.getNbrJrRelanceSIMUL());
      Element var8 = new Element("nbrJrValidSIMUL");
      this.racine.addContent(var8);
      var8.setText(this.optionVentes.getNbrJrValidSIMUL());
      Element var9 = new Element("affichInTierFilSIMUL");
      this.racine.addContent(var9);
      var9.setText(this.optionVentes.getAffichInTierFilSIMUL());
      Element var10 = new Element("affichInGlobViewSIMUL");
      this.racine.addContent(var10);
      var10.setText(this.optionVentes.getAffichInGlobViewSIMUL());
      Element var11 = new Element("familleProduitSIMUL");
      this.racine.addContent(var11);
      var11.setText(this.optionVentes.getFamilleProduitSIMUL());
      Element var12 = new Element("affichInGlobViewAffaire");
      this.racine.addContent(var12);
      var12.setText(this.optionVentes.getAffichInGlobViewAffaire());
      Element var13 = new Element("affichInTierAffaire");
      this.racine.addContent(var13);
      var13.setText(this.optionVentes.getAffichInTierAffaire());
      if (this.optionVentes.getGestionStockBc().equals("1")) {
         this.optionVentes.setValidationDevisBcCOM("0");
      }

      Element var14 = new Element("nbrJrRelanceDEVIS");
      this.racine.addContent(var14);
      var14.setText(this.optionVentes.getNbrJrRelanceDEVIS());
      Element var15 = new Element("nbrJrValidDEVIS");
      this.racine.addContent(var15);
      var15.setText(this.optionVentes.getNbrJrValidDEVIS());
      Element var16 = new Element("affichInTierFilDEVIS");
      this.racine.addContent(var16);
      var16.setText(this.optionVentes.getAffichInTierFilDEVIS());
      Element var17 = new Element("affichInGlobViewDEVIS");
      this.racine.addContent(var17);
      var17.setText(this.optionVentes.getAffichInGlobViewDEVIS());
      Element var18 = new Element("modeCalculDevis");
      this.racine.addContent(var18);
      var18.setText(this.optionVentes.getModeCalculDevis());
      Element var19 = new Element("nbrJrRelanceCOM");
      this.racine.addContent(var19);
      var19.setText(this.optionVentes.getNbrJrRelanceCOM());
      Element var20 = new Element("nbrJrValidCOM");
      this.racine.addContent(var20);
      var20.setText(this.optionVentes.getNbrJrValidCOM());
      Element var21 = new Element("affichInTierFilCOM");
      this.racine.addContent(var21);
      var21.setText(this.optionVentes.getAffichInTierFilCOM());
      Element var22 = new Element("affichInGlobViewCOM");
      this.racine.addContent(var22);
      var22.setText(this.optionVentes.getAffichInGlobViewCOM());
      Element var23 = new Element("impressionBcBlCOM");
      this.racine.addContent(var23);
      var23.setText(this.optionVentes.getImpressionBcBlCOM());
      Element var24 = new Element("validationBcBlCOM");
      this.racine.addContent(var24);
      var24.setText(this.optionVentes.getValidationBcBlCOM());
      Element var25 = new Element("generationBcFab");
      this.racine.addContent(var25);
      var25.setText(this.optionVentes.getGenerationBcFab());
      Element var26 = new Element("gestionStockBc");
      this.racine.addContent(var26);
      var26.setText(this.optionVentes.getGestionStockBc());
      Element var27 = new Element("gestionPlafondBc");
      this.racine.addContent(var27);
      var27.setText(this.optionVentes.getGestionPlafondBc());
      Element var28 = new Element("nbrJrRelanceLIV");
      this.racine.addContent(var28);
      var28.setText(this.optionVentes.getNbrJrRelanceLIV());
      Element var29 = new Element("nbrJrValidLIV");
      this.racine.addContent(var29);
      var29.setText(this.optionVentes.getNbrJrValidLIV());
      Element var30 = new Element("affichInTierFilLIV");
      this.racine.addContent(var30);
      var30.setText(this.optionVentes.getAffichInTierFilLIV());
      Element var31 = new Element("affichInGlobViewLIV");
      this.racine.addContent(var31);
      var31.setText(this.optionVentes.getAffichInGlobViewLIV());
      Element var32 = new Element("gestionLivreur");
      this.racine.addContent(var32);
      var32.setText(this.optionVentes.getGestionLivreur());
      Element var33 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var33);
      var33.setText(this.optionVentes.getNbrJrRelanceFAC());
      Element var34 = new Element("nbrJrValidFAC");
      this.racine.addContent(var34);
      var34.setText(this.optionVentes.getNbrJrValidFAC());
      Element var35 = new Element("affichInTierFilFAC");
      this.racine.addContent(var35);
      var35.setText(this.optionVentes.getAffichInTierFilFAC());
      Element var36 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var36);
      var36.setText(this.optionVentes.getAffichInGlobViewFAC());
      Element var37 = new Element("numBlFac");
      this.racine.addContent(var37);
      var37.setText("" + this.optionVentes.getNumBlFac());
      Element var38 = new Element("gestionPlafondFac");
      this.racine.addContent(var38);
      var38.setText(this.optionVentes.getGestionPlafondFac());
      Element var39 = new Element("gestionImpressionFac");
      this.racine.addContent(var39);
      var39.setText(this.optionVentes.getGestionImpressionFac());
      Element var40 = new Element("gestionNumeroFac");
      this.racine.addContent(var40);
      var40.setText(this.optionVentes.getGestionNumeroFac());
      Element var41 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var41);
      var41.setText(this.optionVentes.getNbrJrRelanceNOTDEB());
      Element var42 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var42);
      var42.setText(this.optionVentes.getNbrJrValidNOTDEB());
      Element var43 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var43);
      var43.setText(this.optionVentes.getAffichInTierFilNOTDEB());
      Element var44 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var44);
      var44.setText(this.optionVentes.getAffichInGlobViewNOTDEB());
      Element var45 = new Element("gestionPlafondNdb");
      this.racine.addContent(var45);
      var45.setText(this.optionVentes.getGestionPlafondNdb());
      Element var46 = new Element("nbrJrRelanceRETOUR");
      this.racine.addContent(var46);
      var46.setText(this.optionVentes.getNbrJrRelanceRETOUR());
      Element var47 = new Element("nbrJrValidRETOUR");
      this.racine.addContent(var47);
      var47.setText(this.optionVentes.getNbrJrValidRETOUR());
      Element var48 = new Element("affichInTierFilRETOUR");
      this.racine.addContent(var48);
      var48.setText(this.optionVentes.getAffichInTierFilRETOUR());
      Element var49 = new Element("affichInGlobViewRETOUR");
      this.racine.addContent(var49);
      var49.setText(this.optionVentes.getAffichInGlobViewRETOUR());
      Element var50 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var50);
      var50.setText(this.optionVentes.getNbrJrRelanceAVOIR());
      Element var51 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var51);
      var51.setText(this.optionVentes.getNbrJrValidAVOIR());
      Element var52 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var52);
      var52.setText(this.optionVentes.getAffichInTierFilAVOIR());
      Element var53 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var53);
      var53.setText(this.optionVentes.getAffichInGlobViewAVOIR());
      Element var54 = new Element("paiementAVOIR");
      this.racine.addContent(var54);
      var54.setText(this.optionVentes.getPaiementAVOIR());
      Element var55 = new Element("modeAvoir");
      this.racine.addContent(var55);
      var55.setText(this.optionVentes.getModeAvoir());
      Element var56 = new Element("affichInGlobViewCh");
      this.racine.addContent(var56);
      var56.setText(this.optionVentes.getAffichInGlobViewCh());
      Element var57 = new Element("depotChargementDefaut");
      this.racine.addContent(var57);
      var57.setText(this.optionVentes.getDepotChargementDefaut());
      Element var58 = new Element("affichInGlobViewCOMMISSION");
      this.racine.addContent(var58);
      var58.setText(this.optionVentes.getAffichInGlobViewCOMMISSION());
      Element var59 = new Element("facture");
      this.racine.addContent(var59);
      var59.setText(this.optionVentes.getFacture());
      Element var60 = new Element("avoir");
      this.racine.addContent(var60);
      var60.setText(this.optionVentes.getAvoir());
      Element var61 = new Element("noteDebit");
      this.racine.addContent(var61);
      var61.setText(this.optionVentes.getNoteDebit());
      Element var62 = new Element("modeCommission");
      this.racine.addContent(var62);
      var62.setText(this.optionVentes.getModeCommission());
      Element var63 = new Element("compteDebit");
      this.racine.addContent(var63);
      var63.setText(this.optionVentes.getCompteDebit());
      Element var64 = new Element("gestRegSectPdvBLC");
      this.racine.addContent(var64);
      var64.setText(this.optionVentes.getGestRegSectPdvBLC());
      Element var65 = new Element("gestActBLC");
      this.racine.addContent(var65);
      var65.setText(this.optionVentes.getGestActBLC());
      Element var66 = new Element("affichInTierFilBLC");
      this.racine.addContent(var66);
      var66.setText(this.optionVentes.getAffichInTierFilBLC());
      Element var67 = new Element("affichInGlobViewBLC");
      this.racine.addContent(var67);
      var67.setText(this.optionVentes.getAffichInGlobViewBLC());
      Element var68 = new Element("gestRegSectPdvFACTC");
      this.racine.addContent(var68);
      var68.setText(this.optionVentes.getGestRegSectPdvFACTC());
      Element var69 = new Element("gestActFACTC");
      this.racine.addContent(var69);
      var69.setText(this.optionVentes.getGestActFACTC());
      Element var70 = new Element("affichInTierFilFACTC");
      this.racine.addContent(var70);
      var70.setText(this.optionVentes.getAffichInTierFilFACTC());
      Element var71 = new Element("affichInGlobViewFACTC");
      this.racine.addContent(var71);
      var71.setText(this.optionVentes.getAffichInGlobViewFACTC());
      Element var72 = new Element("gestRegSectPdvTICKC");
      this.racine.addContent(var72);
      var72.setText(this.optionVentes.getGestRegSectPdvTICKC());
      Element var73 = new Element("gestActTICKC");
      this.racine.addContent(var73);
      var73.setText(this.optionVentes.getGestActTICKC());
      Element var74 = new Element("affichInTierFilTICKC");
      this.racine.addContent(var74);
      var74.setText(this.optionVentes.getAffichInTierFilTICKC());
      Element var75 = new Element("affichInGlobViewTICKC");
      this.racine.addContent(var75);
      var75.setText(this.optionVentes.getAffichInGlobViewTICKC());
      Element var76 = new Element("caisseDefaut");
      this.racine.addContent(var76);
      var76.setText(this.optionVentes.getCaisseDefaut());
      Element var77 = new Element("caisseLivreur");
      this.racine.addContent(var77);
      var77.setText(this.optionVentes.getCaisseLivreur());
      Element var78 = new Element("caisseTable");
      this.racine.addContent(var78);
      var78.setText(this.optionVentes.getCaisseTable());
      Element var79 = new Element("caisseChambre");
      this.racine.addContent(var79);
      var79.setText(this.optionVentes.getCaisseChambre());
      Element var80 = new Element("caisseStock");
      this.racine.addContent(var80);
      var80.setText(this.optionVentes.getCaisseStock());
      Element var81 = new Element("tracabilite");
      this.racine.addContent(var81);
      var81.setText(this.optionVentes.getTracabilite());
      Element var82 = new Element("transformation");
      this.racine.addContent(var82);
      var82.setText(this.optionVentes.getTransformation());
      Element var83 = new Element("impPoids");
      this.racine.addContent(var83);
      var83.setText(this.optionVentes.getImpPoids());
      Element var84 = new Element("nbrCaracteresFamPRO");
      this.racine.addContent(var84);
      var84.setText(this.optionVentes.getNbrCaracteresFamPRO());
      Element var85 = new Element("nbrCaracteresProPRO");
      this.racine.addContent(var85);
      var85.setText(this.optionVentes.getNbrCaracteresProPRO());
      Element var86 = new Element("modCalcProPRO");
      this.racine.addContent(var86);
      var86.setText(this.optionVentes.getModCalcProPRO());
      Element var87 = new Element("decrmtPrsChrStock");
      this.racine.addContent(var87);
      var87.setText(this.optionVentes.getDecrmtPrsChrStock());
      Element var88 = new Element("nbDecQte");
      this.racine.addContent(var88);
      var88.setText(this.optionVentes.getNbDecQte());
      Element var89 = new Element("nbDecPu");
      this.racine.addContent(var89);
      var89.setText(this.optionVentes.getNbDecPu());
      Element var90 = new Element("decrmtPriVteStock");
      this.racine.addContent(var90);
      var90.setText(this.optionVentes.getDecrmtPriVteStock());
      Element var91 = new Element("decrmtRabais");
      this.racine.addContent(var91);
      var91.setText(this.optionVentes.getDecrmtRabais());
      Element var92 = new Element("analAuto");
      this.racine.addContent(var92);
      var92.setText(this.optionVentes.getAnalAuto());
      Element var93 = new Element("nbLigneMax");
      this.racine.addContent(var93);
      var93.setText(this.optionVentes.getNbLigneMax());
      Element var94 = new Element("libProduit");
      this.racine.addContent(var94);
      var94.setText(this.optionVentes.getLibProduit());
      Element var95 = new Element("responsable");
      this.racine.addContent(var95);
      var95.setText(this.optionVentes.getResponsable());
      Element var96 = new Element("produitGenerique");
      this.racine.addContent(var96);
      var96.setText(this.optionVentes.getProduitGenerique());
      Element var97 = new Element("photosProduit");
      this.racine.addContent(var97);
      var97.setText(this.optionVentes.getPhotosProduit());
      Element var98 = new Element("chargementListe");
      this.racine.addContent(var98);
      var98.setText(this.optionVentes.getChargementListe());
      Element var99 = new Element("descriptifComplementaire");
      this.racine.addContent(var99);
      var99.setText(this.optionVentes.getDescriptifComplementaire());
      Element var100 = new Element("dateTransformation");
      this.racine.addContent(var100);
      var100.setText(this.optionVentes.getDateTransformation());
      Element var101 = new Element("libelleProduit");
      this.racine.addContent(var101);
      var101.setText(this.optionVentes.getLibelleProduit());
      Element var102 = new Element("tvaDefaut");
      this.racine.addContent(var102);
      var102.setText(this.optionVentes.getTvaDefaut());
      Element var103 = new Element("tlvDefaut");
      this.racine.addContent(var103);
      var103.setText(this.optionVentes.getTlvDefaut());
      Element var104 = new Element("tomDefaut");
      this.racine.addContent(var104);
      var104.setText(this.optionVentes.getTomDefaut());
      Element var105 = new Element("irppDefaut");
      this.racine.addContent(var105);
      var105.setText(this.optionVentes.getIrppDefaut());
      Element var106 = new Element("produitAchat");
      this.racine.addContent(var106);
      var106.setText(this.optionVentes.getProduitAchat());
      Element var107 = new Element("choixStock");
      this.racine.addContent(var107);
      var107.setText(this.optionVentes.getChoixStock());
      Element var108 = new Element("lib1ENTETE");
      this.racine.addContent(var108);
      var108.setText(this.optionVentes.getLib1ENTETE());
      Element var109 = new Element("lib2ENTETE");
      this.racine.addContent(var109);
      var109.setText(this.optionVentes.getLib2ENTETE());
      Element var110 = new Element("lib3ENTETE");
      this.racine.addContent(var110);
      var110.setText(this.optionVentes.getLib3ENTETE());
      Element var111 = new Element("lib4ENTETE");
      this.racine.addContent(var111);
      var111.setText(this.optionVentes.getLib4ENTETE());
      Element var112 = new Element("lib5ENTETE");
      this.racine.addContent(var112);
      var112.setText(this.optionVentes.getLib5ENTETE());
      Element var113 = new Element("lib6ENTETE");
      this.racine.addContent(var113);
      var113.setText(this.optionVentes.getLib6ENTETE());
      Element var114 = new Element("lib7ENTETE");
      this.racine.addContent(var114);
      var114.setText(this.optionVentes.getLib7ENTETE());
      Element var115 = new Element("lib8ENTETE");
      this.racine.addContent(var115);
      var115.setText(this.optionVentes.getLib8ENTETE());
      Element var116 = new Element("lib9ENTETE");
      this.racine.addContent(var116);
      var116.setText(this.optionVentes.getLib9ENTETE());
      Element var117 = new Element("lib10ENTETE");
      this.racine.addContent(var117);
      var117.setText(this.optionVentes.getLib10ENTETE());
      Element var118 = new Element("transfertDocument");
      this.racine.addContent(var118);
      var118.setText(this.optionVentes.getTransfertDocument());
      Element var119 = new Element("zoneRef1");
      this.racine.addContent(var119);
      var119.setText(this.optionVentes.getZoneRef1());
      Element var120 = new Element("zoneRef2");
      this.racine.addContent(var120);
      var120.setText(this.optionVentes.getZoneRef2());
      Element var121 = new Element("zoneLibelle");
      this.racine.addContent(var121);
      var121.setText(this.optionVentes.getZoneLibelle());
      Element var122 = new Element("zoneLibelleSuite");
      this.racine.addContent(var122);
      var122.setText(this.optionVentes.getZoneLibelleSuite());
      Element var123 = new Element("zoneRef1Serie");
      this.racine.addContent(var123);
      var123.setText(this.optionVentes.getZoneRef1Serie());
      Element var124 = new Element("zoneRef2Serie");
      this.racine.addContent(var124);
      var124.setText(this.optionVentes.getZoneRef2Serie());
      Element var125 = new Element("axeStructure");
      this.racine.addContent(var125);
      var125.setText(this.optionVentes.getAxeStructure());
      Element var126 = new Element("axeSite");
      this.racine.addContent(var126);
      var126.setText(this.optionVentes.getAxeSite());
      Element var127 = new Element("axeRegion");
      this.racine.addContent(var127);
      var127.setText(this.optionVentes.getAxeRegion());
      Element var128 = new Element("axeUsine");
      this.racine.addContent(var128);
      var128.setText(this.optionVentes.getAxeUsine());
      Element var129 = new Element("axeActivite");
      this.racine.addContent(var129);
      var129.setText(this.optionVentes.getAxeActivite());
      Element var130 = new Element("axeAgent");
      this.racine.addContent(var130);
      var130.setText(this.optionVentes.getAxeAgent());
      Element var131 = new Element("axeChantier");
      this.racine.addContent(var131);
      var131.setText(this.optionVentes.getAxeChantier());
      Element var132 = new Element("axeParc");
      this.racine.addContent(var132);
      var132.setText(this.optionVentes.getAxeParc());
      Element var133 = new Element("axeMission");
      this.racine.addContent(var133);
      var133.setText(this.optionVentes.getAxeMission());
      Element var134 = new Element("axeCles");
      this.racine.addContent(var134);
      var134.setText(this.optionVentes.getAxeCles());
      Element var135 = new Element("axeProjet");
      this.racine.addContent(var135);
      var135.setText(this.optionVentes.getAxeProjet());
      Element var136 = new Element("axeDossier");
      this.racine.addContent(var136);
      var136.setText(this.optionVentes.getAxeDossier());
      Element var137 = new Element("chronoMatricule");
      this.racine.addContent(var137);
      var137.setText(this.optionVentes.getChronoMatricule());
      Element var138 = new Element("affichInGlobViewINVENTAIRE");
      this.racine.addContent(var138);
      var138.setText(this.optionVentes.getAffichInGlobViewINVENTAIRE());
      Element var139 = new Element("affichInGlobViewCARNET");
      this.racine.addContent(var139);
      var139.setText(this.optionVentes.getAffichInGlobViewCARNET());
      Element var140 = new Element("saisieCarnet");
      this.racine.addContent(var140);
      var140.setText(this.optionVentes.getSaisieCarnet());
      Element var141 = new Element("affichInGlobViewROULAGE");
      this.racine.addContent(var141);
      var141.setText(this.optionVentes.getAffichInGlobViewROULAGE());
      Element var142 = new Element("saisieRoulage");
      this.racine.addContent(var142);
      var142.setText(this.optionVentes.getSaisieRoulage());
      Element var143 = new Element("affichInGlobViewROUTE");
      this.racine.addContent(var143);
      var143.setText(this.optionVentes.getAffichInGlobViewROUTE());
      Element var144 = new Element("saisieRoute");
      this.racine.addContent(var144);
      var144.setText(this.optionVentes.getSaisieRoute());
      Element var145 = new Element("affichInGlobViewEXPEDITION");
      this.racine.addContent(var145);
      var145.setText(this.optionVentes.getAffichInGlobViewEXPEDITION());
      Element var146 = new Element("saisieExpedition");
      this.racine.addContent(var146);
      var146.setText(this.optionVentes.getSaisieExpedition());
      this.enregistrer();
   }

   public void enregistrer() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "ventes" + File.separator + "configuration" + File.separator + "optionVentes.xml");
      var1.output(this.getDocument(), var2);
      var2.close();
   }

   public String creerOptionsVentesCompta(OptionVentes var1, OptionComptabilite var2) throws IOException {
      this.racine.removeContent();
      Element var3 = new Element("activiteEnteteLigne");
      this.racine.addContent(var3);
      var3.setText(var1.getActiviteEnteteLigne());
      Element var4 = new Element("affichInGlobViewCAMPAGNE");
      this.racine.addContent(var4);
      var4.setText(var1.getAffichInGlobViewCAMPAGNE());
      Element var5 = new Element("nbrJrRelanceBESOIN");
      this.racine.addContent(var5);
      var5.setText(var1.getNbrJrRelanceBESOIN());
      Element var6 = new Element("nbrJrValidBESOIN");
      this.racine.addContent(var6);
      var6.setText(var1.getNbrJrValidBESOIN());
      Element var7 = new Element("affichInTierFilBESOIN");
      this.racine.addContent(var7);
      var7.setText(var1.getAffichInTierFilBESOIN());
      Element var8 = new Element("affichInGlobViewBESOIN");
      this.racine.addContent(var8);
      var8.setText(var1.getAffichInGlobViewBESOIN());
      Element var9 = new Element("nbrJrRelanceSIMUL");
      this.racine.addContent(var9);
      var9.setText(var1.getNbrJrRelanceSIMUL());
      Element var10 = new Element("nbrJrValidSIMUL");
      this.racine.addContent(var10);
      var10.setText(var1.getNbrJrValidSIMUL());
      Element var11 = new Element("affichInTierFilSIMUL");
      this.racine.addContent(var11);
      var11.setText(var1.getAffichInTierFilSIMUL());
      Element var12 = new Element("affichInGlobViewSIMUL");
      this.racine.addContent(var12);
      var12.setText(var1.getAffichInGlobViewSIMUL());
      Element var13 = new Element("familleProduitSIMUL");
      this.racine.addContent(var13);
      var13.setText(var1.getFamilleProduitSIMUL());
      Element var14 = new Element("affichInGlobViewAffaire");
      this.racine.addContent(var14);
      var14.setText(var1.getAffichInGlobViewAffaire());
      Element var15 = new Element("affichInTierAffaire");
      this.racine.addContent(var15);
      var15.setText(var1.getAffichInTierAffaire());
      Element var16 = new Element("nbrJrRelanceDEVIS");
      this.racine.addContent(var16);
      var16.setText(var1.getNbrJrRelanceDEVIS());
      Element var17 = new Element("nbrJrValidDEVIS");
      this.racine.addContent(var17);
      var17.setText(var1.getNbrJrValidDEVIS());
      Element var18 = new Element("affichInTierFilDEVIS");
      this.racine.addContent(var18);
      var18.setText(var1.getAffichInTierFilDEVIS());
      Element var19 = new Element("affichInGlobViewDEVIS");
      this.racine.addContent(var19);
      var19.setText(var1.getAffichInGlobViewDEVIS());
      Element var20 = new Element("modeCalculDevis");
      this.racine.addContent(var20);
      var20.setText(var1.getModeCalculDevis());
      Element var21 = new Element("nbrJrRelanceCOM");
      this.racine.addContent(var21);
      var21.setText(var1.getNbrJrRelanceCOM());
      Element var22 = new Element("nbrJrValidCOM");
      this.racine.addContent(var22);
      var22.setText(var1.getNbrJrValidCOM());
      Element var23 = new Element("affichInTierFilCOM");
      this.racine.addContent(var23);
      var23.setText(var1.getAffichInTierFilCOM());
      Element var24 = new Element("affichInGlobViewCOM");
      this.racine.addContent(var24);
      var24.setText(var1.getAffichInGlobViewCOM());
      Element var25 = new Element("impressionBcBlCOM");
      this.racine.addContent(var25);
      var25.setText(var1.getImpressionBcBlCOM());
      Element var26 = new Element("validationBcBlCOM");
      this.racine.addContent(var26);
      var26.setText(var1.getValidationBcBlCOM());
      Element var27 = new Element("generationBcFab");
      this.racine.addContent(var27);
      var27.setText(var1.getGenerationBcFab());
      Element var28 = new Element("gestionStockBc");
      this.racine.addContent(var28);
      var28.setText(var1.getGestionStockBc());
      Element var29 = new Element("gestionPlafondBc");
      this.racine.addContent(var29);
      var29.setText(var1.getGestionPlafondBc());
      Element var30 = new Element("nbrJrRelanceLIV");
      this.racine.addContent(var30);
      var30.setText(var1.getNbrJrRelanceLIV());
      Element var31 = new Element("nbrJrValidLIV");
      this.racine.addContent(var31);
      var31.setText(var1.getNbrJrValidLIV());
      Element var32 = new Element("affichInTierFilLIV");
      this.racine.addContent(var32);
      var32.setText(var1.getAffichInTierFilLIV());
      Element var33 = new Element("affichInGlobViewLIV");
      this.racine.addContent(var33);
      var33.setText(var1.getAffichInGlobViewLIV());
      Element var34 = new Element("gestionLivreur");
      this.racine.addContent(var34);
      var34.setText(var1.getGestionLivreur());
      Element var35 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var35);
      var35.setText(var1.getNbrJrRelanceFAC());
      Element var36 = new Element("nbrJrValidFAC");
      this.racine.addContent(var36);
      var36.setText(var1.getNbrJrValidFAC());
      Element var37 = new Element("affichInTierFilFAC");
      this.racine.addContent(var37);
      var37.setText(var1.getAffichInTierFilFAC());
      Element var38 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var38);
      var38.setText(var1.getAffichInGlobViewFAC());
      Element var39 = new Element("numBlFac");
      this.racine.addContent(var39);
      var39.setText("" + var1.getNumBlFac());
      Element var40 = new Element("gestionPlafondFac");
      this.racine.addContent(var40);
      var40.setText(var1.getGestionPlafondFac());
      Element var41 = new Element("gestionImpressionFac");
      this.racine.addContent(var41);
      var41.setText(var1.getGestionImpressionFac());
      Element var42 = new Element("gestionNumeroFac");
      this.racine.addContent(var42);
      var42.setText(var1.getGestionNumeroFac());
      Element var43 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var43);
      var43.setText(var1.getNbrJrRelanceNOTDEB());
      Element var44 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var44);
      var44.setText(var1.getNbrJrValidNOTDEB());
      Element var45 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var45);
      var45.setText(var1.getAffichInTierFilNOTDEB());
      Element var46 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var46);
      var46.setText(var1.getAffichInGlobViewNOTDEB());
      Element var47 = new Element("gestionPlafondNdb");
      this.racine.addContent(var47);
      var47.setText(var1.getGestionPlafondNdb());
      Element var48 = new Element("nbrJrRelanceRETOUR");
      this.racine.addContent(var48);
      var48.setText(var1.getNbrJrRelanceRETOUR());
      Element var49 = new Element("nbrJrValidRETOUR");
      this.racine.addContent(var49);
      var49.setText(var1.getNbrJrValidRETOUR());
      Element var50 = new Element("affichInTierFilRETOUR");
      this.racine.addContent(var50);
      var50.setText(var1.getAffichInTierFilRETOUR());
      Element var51 = new Element("affichInGlobViewRETOUR");
      this.racine.addContent(var51);
      var51.setText(var1.getAffichInGlobViewRETOUR());
      Element var52 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var52);
      var52.setText(var1.getNbrJrRelanceAVOIR());
      Element var53 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var53);
      var53.setText(var1.getNbrJrValidAVOIR());
      Element var54 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var54);
      var54.setText(var1.getAffichInTierFilAVOIR());
      Element var55 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var55);
      var55.setText(var1.getAffichInGlobViewAVOIR());
      Element var56 = new Element("paiementAVOIR");
      this.racine.addContent(var56);
      var56.setText(var1.getPaiementAVOIR());
      Element var57 = new Element("modeAvoir");
      this.racine.addContent(var57);
      var57.setText(var1.getModeAvoir());
      Element var58 = new Element("affichInGlobViewCh");
      this.racine.addContent(var58);
      var58.setText(var1.getAffichInGlobViewCh());
      Element var59 = new Element("depotChargementDefaut");
      this.racine.addContent(var59);
      var59.setText(var1.getDepotChargementDefaut());
      Element var60 = new Element("affichInGlobViewCOMMISSION");
      this.racine.addContent(var60);
      var60.setText(var1.getAffichInGlobViewCOMMISSION());
      Element var61 = new Element("facture");
      this.racine.addContent(var61);
      var61.setText(var1.getFacture());
      Element var62 = new Element("avoir");
      this.racine.addContent(var62);
      var62.setText(var1.getAvoir());
      Element var63 = new Element("noteDebit");
      this.racine.addContent(var63);
      var63.setText(var1.getNoteDebit());
      Element var64 = new Element("modeCommission");
      this.racine.addContent(var64);
      var64.setText(var1.getModeCommission());
      Element var65 = new Element("compteDebit");
      this.racine.addContent(var65);
      var65.setText(var1.getCompteDebit());
      Element var66 = new Element("gestRegSectPdvBLC");
      this.racine.addContent(var66);
      var66.setText(var1.getGestRegSectPdvBLC());
      Element var67 = new Element("gestActBLC");
      this.racine.addContent(var67);
      var67.setText(var1.getGestActBLC());
      Element var68 = new Element("affichInTierFilBLC");
      this.racine.addContent(var68);
      var68.setText(var1.getAffichInTierFilBLC());
      Element var69 = new Element("affichInGlobViewBLC");
      this.racine.addContent(var69);
      var69.setText(var1.getAffichInGlobViewBLC());
      Element var70 = new Element("gestRegSectPdvFACTC");
      this.racine.addContent(var70);
      var70.setText(var1.getGestRegSectPdvFACTC());
      Element var71 = new Element("gestActFACTC");
      this.racine.addContent(var71);
      var71.setText(var1.getGestActFACTC());
      Element var72 = new Element("affichInTierFilFACTC");
      this.racine.addContent(var72);
      var72.setText(var1.getAffichInTierFilFACTC());
      Element var73 = new Element("affichInGlobViewFACTC");
      this.racine.addContent(var73);
      var73.setText(var1.getAffichInGlobViewFACTC());
      Element var74 = new Element("gestRegSectPdvTICKC");
      this.racine.addContent(var74);
      var74.setText(var1.getGestRegSectPdvTICKC());
      Element var75 = new Element("gestActTICKC");
      this.racine.addContent(var75);
      var75.setText(var1.getGestActTICKC());
      Element var76 = new Element("affichInTierFilTICKC");
      this.racine.addContent(var76);
      var76.setText(var1.getAffichInTierFilTICKC());
      Element var77 = new Element("affichInGlobViewTICKC");
      this.racine.addContent(var77);
      var77.setText(var1.getAffichInGlobViewTICKC());
      Element var78 = new Element("caisseDefaut");
      this.racine.addContent(var78);
      var78.setText(var1.getCaisseDefaut());
      Element var79 = new Element("caisseLivreur");
      this.racine.addContent(var79);
      var79.setText(var1.getCaisseLivreur());
      Element var80 = new Element("caisseTable");
      this.racine.addContent(var80);
      var80.setText(var1.getCaisseTable());
      Element var81 = new Element("caisseChambre");
      this.racine.addContent(var81);
      var81.setText(var1.getCaisseChambre());
      Element var82 = new Element("caisseStock");
      this.racine.addContent(var82);
      var82.setText(var1.getCaisseStock());
      Element var83 = new Element("tracabilite");
      this.racine.addContent(var83);
      var83.setText(var1.getTracabilite());
      Element var84 = new Element("transformation");
      this.racine.addContent(var84);
      var84.setText(var1.getTransformation());
      Element var85 = new Element("impPoids");
      this.racine.addContent(var85);
      var85.setText(var1.getImpPoids());
      Element var86 = new Element("nbrCaracteresFamPRO");
      this.racine.addContent(var86);
      var86.setText(var1.getNbrCaracteresFamPRO());
      Element var87 = new Element("nbrCaracteresProPRO");
      this.racine.addContent(var87);
      var87.setText(var1.getNbrCaracteresProPRO());
      Element var88 = new Element("modCalcProPRO");
      this.racine.addContent(var88);
      var88.setText(var1.getModCalcProPRO());
      Element var89 = new Element("nbDecQte");
      this.racine.addContent(var89);
      var89.setText(var1.getNbDecQte());
      Element var90 = new Element("nbDecPu");
      this.racine.addContent(var90);
      var90.setText(var1.getNbDecPu());
      Element var91 = new Element("decrmtPrsChrStock");
      this.racine.addContent(var91);
      var91.setText(var1.getDecrmtPrsChrStock());
      Element var92 = new Element("decrmtPriVteStock");
      this.racine.addContent(var92);
      var92.setText(var1.getDecrmtPriVteStock());
      Element var93 = new Element("decrmtRabais");
      this.racine.addContent(var93);
      var93.setText(var1.getDecrmtRabais());
      Element var94 = new Element("analAuto");
      this.racine.addContent(var94);
      var94.setText(var1.getAnalAuto());
      Element var95 = new Element("nbLigneMax");
      this.racine.addContent(var95);
      var95.setText(var1.getNbLigneMax());
      Element var96 = new Element("libProduit");
      this.racine.addContent(var96);
      var96.setText(var1.getLibProduit());
      Element var97 = new Element("responsable");
      this.racine.addContent(var97);
      var97.setText(var1.getResponsable());
      Element var98 = new Element("produitGenerique");
      this.racine.addContent(var98);
      var98.setText(var1.getProduitGenerique());
      Element var99 = new Element("photosProduit");
      this.racine.addContent(var99);
      var99.setText(var1.getPhotosProduit());
      Element var100 = new Element("chargementListe");
      this.racine.addContent(var100);
      var100.setText(var1.getChargementListe());
      Element var101 = new Element("descriptifComplementaire");
      this.racine.addContent(var101);
      var101.setText(var1.getDescriptifComplementaire());
      Element var102 = new Element("dateTransformation");
      this.racine.addContent(var102);
      var102.setText(var1.getDateTransformation());
      Element var103 = new Element("libelleProduit");
      this.racine.addContent(var103);
      var103.setText(var1.getLibelleProduit());
      Element var104 = new Element("tvaDefaut");
      this.racine.addContent(var104);
      var104.setText(var1.getTvaDefaut());
      Element var105 = new Element("tlvDefaut");
      this.racine.addContent(var105);
      var105.setText(var1.getTlvDefaut());
      Element var106 = new Element("tomDefaut");
      this.racine.addContent(var106);
      var106.setText(var1.getTomDefaut());
      Element var107 = new Element("irppDefaut");
      this.racine.addContent(var107);
      var107.setText(var1.getIrppDefaut());
      Element var108 = new Element("produitAchat");
      this.racine.addContent(var108);
      var108.setText(var1.getProduitAchat());
      Element var109 = new Element("choixStock");
      this.racine.addContent(var109);
      var109.setText(var1.getChoixStock());
      Element var110 = new Element("lib1ENTETE");
      this.racine.addContent(var110);
      var110.setText(var1.getLib1ENTETE());
      Element var111 = new Element("lib2ENTETE");
      this.racine.addContent(var111);
      var111.setText(var1.getLib2ENTETE());
      Element var112 = new Element("lib3ENTETE");
      this.racine.addContent(var112);
      var112.setText(var1.getLib3ENTETE());
      Element var113 = new Element("lib4ENTETE");
      this.racine.addContent(var113);
      var113.setText(var1.getLib4ENTETE());
      Element var114 = new Element("lib5ENTETE");
      this.racine.addContent(var114);
      var114.setText(var1.getLib5ENTETE());
      Element var115 = new Element("lib6ENTETE");
      this.racine.addContent(var115);
      var115.setText(var1.getLib6ENTETE());
      Element var116 = new Element("lib7ENTETE");
      this.racine.addContent(var116);
      var116.setText(var1.getLib7ENTETE());
      Element var117 = new Element("lib8ENTETE");
      this.racine.addContent(var117);
      var117.setText(var1.getLib8ENTETE());
      Element var118 = new Element("lib9ENTETE");
      this.racine.addContent(var118);
      var118.setText(var1.getLib9ENTETE());
      Element var119 = new Element("lib10ENTETE");
      this.racine.addContent(var119);
      var119.setText(var1.getLib10ENTETE());
      Element var120 = new Element("transfertDocument");
      this.racine.addContent(var120);
      var120.setText(var1.getTransfertDocument());
      Element var121 = new Element("zoneRef1");
      this.racine.addContent(var121);
      var121.setText(var1.getZoneRef1());
      Element var122 = new Element("zoneRef2");
      this.racine.addContent(var122);
      var122.setText(var1.getZoneRef2());
      Element var123 = new Element("zoneLibelle");
      this.racine.addContent(var123);
      var123.setText(var1.getZoneLibelle());
      Element var124 = new Element("zoneLibelleSuite");
      this.racine.addContent(var124);
      var124.setText(var1.getZoneLibelleSuite());
      Element var125 = new Element("zoneRef1Serie");
      this.racine.addContent(var125);
      var125.setText(var1.getZoneRef1Serie());
      Element var126 = new Element("zoneRef2Serie");
      this.racine.addContent(var126);
      var126.setText(var1.getZoneRef2Serie());
      Element var127 = new Element("axeStructure");
      this.racine.addContent(var127);
      var127.setText(var1.getAxeStructure());
      Element var128 = new Element("axeSite");
      this.racine.addContent(var128);
      var128.setText(var1.getAxeSite());
      Element var129 = new Element("axeRegion");
      this.racine.addContent(var129);
      var129.setText(var1.getAxeRegion());
      Element var130 = new Element("axeUsine");
      this.racine.addContent(var130);
      var130.setText(var1.getAxeUsine());
      Element var131 = new Element("axeActivite");
      this.racine.addContent(var131);
      var131.setText(var1.getAxeActivite());
      Element var132 = new Element("axeAgent");
      this.racine.addContent(var132);
      var132.setText(var1.getAxeAgent());
      Element var133 = new Element("axeChantier");
      this.racine.addContent(var133);
      var133.setText(var1.getAxeChantier());
      Element var134 = new Element("axeParc");
      this.racine.addContent(var134);
      var134.setText(var1.getAxeParc());
      Element var135 = new Element("axeMission");
      this.racine.addContent(var135);
      var135.setText(var1.getAxeMission());
      Element var136 = new Element("axeCles");
      this.racine.addContent(var136);
      var136.setText(var1.getAxeCles());
      Element var137 = new Element("axeProjet");
      this.racine.addContent(var137);
      var137.setText(var1.getAxeProjet());
      Element var138 = new Element("axeDossier");
      this.racine.addContent(var138);
      var138.setText(var1.getAxeDossier());
      Element var139 = new Element("chronoMatricule");
      this.racine.addContent(var139);
      var139.setText(var1.getChronoMatricule());
      Element var140 = new Element("affichInGlobViewINVENTAIRE");
      this.racine.addContent(var140);
      var140.setText(var1.getAffichInGlobViewINVENTAIRE());
      Element var141 = new Element("affichInGlobViewCARNET");
      this.racine.addContent(var141);
      var141.setText(var1.getAffichInGlobViewCARNET());
      Element var142 = new Element("saisieCarnet");
      this.racine.addContent(var142);
      var142.setText(var1.getSaisieCarnet());
      Element var143 = new Element("affichInGlobViewROULAGE");
      this.racine.addContent(var143);
      var143.setText(var1.getAffichInGlobViewROULAGE());
      Element var144 = new Element("saisieRoulage");
      this.racine.addContent(var144);
      var144.setText(var1.getSaisieRoulage());
      Element var145 = new Element("affichInGlobViewROUTE");
      this.racine.addContent(var145);
      var145.setText(var1.getAffichInGlobViewROUTE());
      Element var146 = new Element("saisieRoute");
      this.racine.addContent(var146);
      var146.setText(var1.getSaisieRoute());
      Element var147 = new Element("affichInGlobViewEXPEDITION");
      this.racine.addContent(var147);
      var147.setText(var1.getAffichInGlobViewEXPEDITION());
      Element var148 = new Element("saisieExpedition");
      this.racine.addContent(var148);
      var148.setText(var1.getSaisieExpedition());
      this.enregistrer();
      return "";
   }

   public String creerOptionsVentesAchats(OptionVentes var1, OptionAchats var2) throws IOException {
      this.racine.removeContent();
      Element var3 = new Element("activiteEnteteLigne");
      this.racine.addContent(var3);
      var3.setText(var1.getActiviteEnteteLigne());
      Element var4 = new Element("affichInGlobViewCAMPAGNE");
      this.racine.addContent(var4);
      var4.setText(var1.getAffichInGlobViewCAMPAGNE());
      Element var5 = new Element("nbrJrRelanceBESOIN");
      this.racine.addContent(var5);
      var5.setText(var1.getNbrJrRelanceBESOIN());
      Element var6 = new Element("nbrJrValidBESOIN");
      this.racine.addContent(var6);
      var6.setText(var1.getNbrJrValidBESOIN());
      Element var7 = new Element("affichInTierFilBESOIN");
      this.racine.addContent(var7);
      var7.setText(var1.getAffichInTierFilBESOIN());
      Element var8 = new Element("affichInGlobViewBESOIN");
      this.racine.addContent(var8);
      var8.setText(var1.getAffichInGlobViewBESOIN());
      Element var9 = new Element("nbrJrRelanceSIMUL");
      this.racine.addContent(var9);
      var9.setText(var1.getNbrJrRelanceSIMUL());
      Element var10 = new Element("nbrJrValidSIMUL");
      this.racine.addContent(var10);
      var10.setText(var1.getNbrJrValidSIMUL());
      Element var11 = new Element("affichInTierFilSIMUL");
      this.racine.addContent(var11);
      var11.setText(var1.getAffichInTierFilSIMUL());
      Element var12 = new Element("affichInGlobViewSIMUL");
      this.racine.addContent(var12);
      var12.setText(var1.getAffichInGlobViewSIMUL());
      Element var13 = new Element("familleProduitSIMUL");
      this.racine.addContent(var13);
      var13.setText(var1.getFamilleProduitSIMUL());
      Element var14 = new Element("affichInGlobViewAffaire");
      this.racine.addContent(var14);
      var14.setText(var1.getAffichInGlobViewAffaire());
      Element var15 = new Element("affichInTierAffaire");
      this.racine.addContent(var15);
      var15.setText(var1.getAffichInTierAffaire());
      Element var16 = new Element("nbrJrRelanceDEVIS");
      this.racine.addContent(var16);
      var16.setText(var1.getNbrJrRelanceDEVIS());
      Element var17 = new Element("nbrJrValidDEVIS");
      this.racine.addContent(var17);
      var17.setText(var1.getNbrJrValidDEVIS());
      Element var18 = new Element("affichInTierFilDEVIS");
      this.racine.addContent(var18);
      var18.setText(var1.getAffichInTierFilDEVIS());
      Element var19 = new Element("affichInGlobViewDEVIS");
      this.racine.addContent(var19);
      var19.setText(var1.getAffichInGlobViewDEVIS());
      Element var20 = new Element("modeCalculDevis");
      this.racine.addContent(var20);
      var20.setText(var1.getModeCalculDevis());
      Element var21 = new Element("nbrJrRelanceCOM");
      this.racine.addContent(var21);
      var21.setText(var1.getNbrJrRelanceCOM());
      Element var22 = new Element("nbrJrValidCOM");
      this.racine.addContent(var22);
      var22.setText(var1.getNbrJrValidCOM());
      Element var23 = new Element("affichInTierFilCOM");
      this.racine.addContent(var23);
      var23.setText(var1.getAffichInTierFilCOM());
      Element var24 = new Element("affichInGlobViewCOM");
      this.racine.addContent(var24);
      var24.setText(var1.getAffichInGlobViewCOM());
      Element var25 = new Element("impressionBcBlCOM");
      this.racine.addContent(var25);
      var25.setText(var1.getImpressionBcBlCOM());
      Element var26 = new Element("validationBcBlCOM");
      this.racine.addContent(var26);
      var26.setText(var1.getValidationBcBlCOM());
      Element var27 = new Element("generationBcFab");
      this.racine.addContent(var27);
      var27.setText(var1.getGenerationBcFab());
      Element var28 = new Element("gestionStockBc");
      this.racine.addContent(var28);
      var28.setText(var1.getGestionStockBc());
      Element var29 = new Element("gestionPlafondBc");
      this.racine.addContent(var29);
      var29.setText(var1.getGestionPlafondBc());
      Element var30 = new Element("nbrJrRelanceLIV");
      this.racine.addContent(var30);
      var30.setText(var1.getNbrJrRelanceLIV());
      Element var31 = new Element("nbrJrValidLIV");
      this.racine.addContent(var31);
      var31.setText(var1.getNbrJrValidLIV());
      Element var32 = new Element("affichInTierFilLIV");
      this.racine.addContent(var32);
      var32.setText(var1.getAffichInTierFilLIV());
      Element var33 = new Element("affichInGlobViewLIV");
      this.racine.addContent(var33);
      var33.setText(var1.getAffichInGlobViewLIV());
      Element var34 = new Element("gestionLivreur");
      this.racine.addContent(var34);
      var34.setText(var1.getGestionLivreur());
      Element var35 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var35);
      var35.setText(var1.getNbrJrRelanceFAC());
      Element var36 = new Element("nbrJrValidFAC");
      this.racine.addContent(var36);
      var36.setText(var1.getNbrJrValidFAC());
      Element var37 = new Element("affichInTierFilFAC");
      this.racine.addContent(var37);
      var37.setText(var1.getAffichInTierFilFAC());
      Element var38 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var38);
      var38.setText(var1.getAffichInGlobViewFAC());
      Element var39 = new Element("numBlFac");
      this.racine.addContent(var39);
      var39.setText("" + var1.getNumBlFac());
      Element var40 = new Element("gestionPlafondFac");
      this.racine.addContent(var40);
      var40.setText(var1.getGestionPlafondFac());
      Element var41 = new Element("gestionImpressionFac");
      this.racine.addContent(var41);
      var41.setText(var1.getGestionImpressionFac());
      Element var42 = new Element("gestionNumeroFac");
      this.racine.addContent(var42);
      var42.setText(var1.getGestionNumeroFac());
      Element var43 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var43);
      var43.setText(var1.getNbrJrRelanceNOTDEB());
      Element var44 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var44);
      var44.setText(var1.getNbrJrValidNOTDEB());
      Element var45 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var45);
      var45.setText(var1.getAffichInTierFilNOTDEB());
      Element var46 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var46);
      var46.setText(var1.getAffichInGlobViewNOTDEB());
      Element var47 = new Element("gestionPlafondNdb");
      this.racine.addContent(var47);
      var47.setText(var1.getGestionPlafondNdb());
      Element var48 = new Element("nbrJrRelanceRETOUR");
      this.racine.addContent(var48);
      var48.setText(var1.getNbrJrRelanceRETOUR());
      Element var49 = new Element("nbrJrValidRETOUR");
      this.racine.addContent(var49);
      var49.setText(var1.getNbrJrValidRETOUR());
      Element var50 = new Element("affichInTierFilRETOUR");
      this.racine.addContent(var50);
      var50.setText(var1.getAffichInTierFilRETOUR());
      Element var51 = new Element("affichInGlobViewRETOUR");
      this.racine.addContent(var51);
      var51.setText(var1.getAffichInGlobViewRETOUR());
      Element var52 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var52);
      var52.setText(var1.getNbrJrRelanceAVOIR());
      Element var53 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var53);
      var53.setText(var1.getNbrJrValidAVOIR());
      Element var54 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var54);
      var54.setText(var1.getAffichInTierFilAVOIR());
      Element var55 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var55);
      var55.setText(var1.getAffichInGlobViewAVOIR());
      Element var56 = new Element("paiementAVOIR");
      this.racine.addContent(var56);
      var56.setText(var1.getPaiementAVOIR());
      Element var57 = new Element("modeAvoir");
      this.racine.addContent(var57);
      var57.setText(var1.getModeAvoir());
      Element var58 = new Element("affichInGlobViewCh");
      this.racine.addContent(var58);
      var58.setText(var1.getAffichInGlobViewCh());
      Element var59 = new Element("depotChargementDefaut");
      this.racine.addContent(var59);
      var59.setText(var1.getDepotChargementDefaut());
      Element var60 = new Element("affichInGlobViewCOMMISSION");
      this.racine.addContent(var60);
      var60.setText(var1.getAffichInGlobViewCOMMISSION());
      Element var61 = new Element("facture");
      this.racine.addContent(var61);
      var61.setText(var1.getFacture());
      Element var62 = new Element("avoir");
      this.racine.addContent(var62);
      var62.setText(var1.getAvoir());
      Element var63 = new Element("noteDebit");
      this.racine.addContent(var63);
      var63.setText(var1.getNoteDebit());
      Element var64 = new Element("modeCommission");
      this.racine.addContent(var64);
      var64.setText(var1.getModeCommission());
      Element var65 = new Element("compteDebit");
      this.racine.addContent(var65);
      var65.setText(var1.getCompteDebit());
      Element var66 = new Element("gestRegSectPdvBLC");
      this.racine.addContent(var66);
      var66.setText(var1.getGestRegSectPdvBLC());
      Element var67 = new Element("gestActBLC");
      this.racine.addContent(var67);
      var67.setText(var1.getGestActBLC());
      Element var68 = new Element("affichInTierFilBLC");
      this.racine.addContent(var68);
      var68.setText(var1.getAffichInTierFilBLC());
      Element var69 = new Element("affichInGlobViewBLC");
      this.racine.addContent(var69);
      var69.setText(var1.getAffichInGlobViewBLC());
      Element var70 = new Element("gestRegSectPdvFACTC");
      this.racine.addContent(var70);
      var70.setText(var1.getGestRegSectPdvFACTC());
      Element var71 = new Element("gestActFACTC");
      this.racine.addContent(var71);
      var71.setText(var1.getGestActFACTC());
      Element var72 = new Element("affichInTierFilFACTC");
      this.racine.addContent(var72);
      var72.setText(var1.getAffichInTierFilFACTC());
      Element var73 = new Element("affichInGlobViewFACTC");
      this.racine.addContent(var73);
      var73.setText(var1.getAffichInGlobViewFACTC());
      Element var74 = new Element("gestRegSectPdvTICKC");
      this.racine.addContent(var74);
      var74.setText(var1.getGestRegSectPdvTICKC());
      Element var75 = new Element("gestActTICKC");
      this.racine.addContent(var75);
      var75.setText(var1.getGestActTICKC());
      Element var76 = new Element("affichInTierFilTICKC");
      this.racine.addContent(var76);
      var76.setText(var1.getAffichInTierFilTICKC());
      Element var77 = new Element("affichInGlobViewTICKC");
      this.racine.addContent(var77);
      var77.setText(var1.getAffichInGlobViewTICKC());
      Element var78 = new Element("caisseDefaut");
      this.racine.addContent(var78);
      var78.setText(var1.getCaisseDefaut());
      Element var79 = new Element("caisseLivreur");
      this.racine.addContent(var79);
      var79.setText(var1.getCaisseLivreur());
      Element var80 = new Element("caisseTable");
      this.racine.addContent(var80);
      var80.setText(var1.getCaisseTable());
      Element var81 = new Element("caisseChambre");
      this.racine.addContent(var81);
      var81.setText(var1.getCaisseChambre());
      Element var82 = new Element("caisseStock");
      this.racine.addContent(var82);
      var82.setText(var1.getCaisseStock());
      Element var83 = new Element("tracabilite");
      this.racine.addContent(var83);
      var83.setText(var1.getTracabilite());
      Element var84 = new Element("transformation");
      this.racine.addContent(var84);
      var84.setText(var1.getTransformation());
      Element var85 = new Element("impPoids");
      this.racine.addContent(var85);
      var85.setText(var1.getImpPoids());
      Element var86 = new Element("nbrCaracteresFamPRO");
      this.racine.addContent(var86);
      var86.setText(var2.getNbrCtrsFamProd());
      Element var87 = new Element("nbrCaracteresProPRO");
      this.racine.addContent(var87);
      var87.setText(var2.getNbrCtrsProProd());
      Element var88 = new Element("modCalcProPRO");
      this.racine.addContent(var88);
      var88.setText(var2.getModCalcProd());
      Element var89 = new Element("nbDecQte");
      this.racine.addContent(var89);
      var89.setText(var1.getNbDecQte());
      Element var90 = new Element("nbDecPu");
      this.racine.addContent(var90);
      var90.setText(var1.getNbDecPu());
      Element var91 = new Element("decrmtPrsChrStock");
      this.racine.addContent(var91);
      var91.setText(var1.getDecrmtPrsChrStock());
      Element var92 = new Element("decrmtPriVteStock");
      this.racine.addContent(var92);
      var92.setText(var1.getDecrmtPriVteStock());
      Element var93 = new Element("decrmtRabais");
      this.racine.addContent(var93);
      var93.setText(var1.getDecrmtRabais());
      Element var94 = new Element("analAuto");
      this.racine.addContent(var94);
      var94.setText(var1.getAnalAuto());
      Element var95 = new Element("nbLigneMax");
      this.racine.addContent(var95);
      var95.setText(var1.getNbLigneMax());
      Element var96 = new Element("libProduit");
      this.racine.addContent(var96);
      var96.setText(var1.getLibProduit());
      Element var97 = new Element("responsable");
      this.racine.addContent(var97);
      var97.setText(var1.getResponsable());
      Element var98 = new Element("produitGenerique");
      this.racine.addContent(var98);
      var98.setText(var1.getProduitGenerique());
      Element var99 = new Element("photosProduit");
      this.racine.addContent(var99);
      var99.setText(var1.getPhotosProduit());
      Element var100 = new Element("chargementListe");
      this.racine.addContent(var100);
      var100.setText(var1.getChargementListe());
      Element var101 = new Element("descriptifComplementaire");
      this.racine.addContent(var101);
      var101.setText(var1.getDescriptifComplementaire());
      Element var102 = new Element("dateTransformation");
      this.racine.addContent(var102);
      var102.setText(var1.getDateTransformation());
      Element var103 = new Element("libelleProduit");
      this.racine.addContent(var103);
      var103.setText(var1.getLibelleProduit());
      Element var104 = new Element("tvaDefaut");
      this.racine.addContent(var104);
      var104.setText(var1.getTvaDefaut());
      Element var105 = new Element("tlvDefaut");
      this.racine.addContent(var105);
      var105.setText(var1.getTlvDefaut());
      Element var106 = new Element("tomDefaut");
      this.racine.addContent(var106);
      var106.setText(var1.getTomDefaut());
      Element var107 = new Element("irppDefaut");
      this.racine.addContent(var107);
      var107.setText(var1.getIrppDefaut());
      Element var108 = new Element("produitAchat");
      this.racine.addContent(var108);
      var108.setText(var1.getProduitAchat());
      Element var109 = new Element("choixStock");
      this.racine.addContent(var109);
      var109.setText(var1.getChoixStock());
      Element var110 = new Element("lib1ENTETE");
      this.racine.addContent(var110);
      var110.setText(var1.getLib1ENTETE());
      Element var111 = new Element("lib2ENTETE");
      this.racine.addContent(var111);
      var111.setText(var1.getLib2ENTETE());
      Element var112 = new Element("lib3ENTETE");
      this.racine.addContent(var112);
      var112.setText(var1.getLib3ENTETE());
      Element var113 = new Element("lib4ENTETE");
      this.racine.addContent(var113);
      var113.setText(var1.getLib4ENTETE());
      Element var114 = new Element("lib5ENTETE");
      this.racine.addContent(var114);
      var114.setText(var1.getLib5ENTETE());
      Element var115 = new Element("lib6ENTETE");
      this.racine.addContent(var115);
      var115.setText(var1.getLib6ENTETE());
      Element var116 = new Element("lib7ENTETE");
      this.racine.addContent(var116);
      var116.setText(var1.getLib7ENTETE());
      Element var117 = new Element("lib8ENTETE");
      this.racine.addContent(var117);
      var117.setText(var1.getLib8ENTETE());
      Element var118 = new Element("lib9ENTETE");
      this.racine.addContent(var118);
      var118.setText(var1.getLib9ENTETE());
      Element var119 = new Element("lib10ENTETE");
      this.racine.addContent(var119);
      var119.setText(var1.getLib10ENTETE());
      Element var120 = new Element("transfertDocument");
      this.racine.addContent(var120);
      var120.setText(var1.getTransfertDocument());
      Element var121 = new Element("zoneRef1");
      this.racine.addContent(var121);
      var121.setText(var1.getZoneRef1());
      Element var122 = new Element("zoneRef2");
      this.racine.addContent(var122);
      var122.setText(var1.getZoneRef2());
      Element var123 = new Element("zoneLibelle");
      this.racine.addContent(var123);
      var123.setText(var1.getZoneLibelle());
      Element var124 = new Element("zoneLibelleSuite");
      this.racine.addContent(var124);
      var124.setText(var1.getZoneLibelleSuite());
      Element var125 = new Element("zoneRef1Serie");
      this.racine.addContent(var125);
      var125.setText(var1.getZoneRef1Serie());
      Element var126 = new Element("zoneRef2Serie");
      this.racine.addContent(var126);
      var126.setText(var1.getZoneRef2Serie());
      Element var127 = new Element("axeStructure");
      this.racine.addContent(var127);
      var127.setText(var1.getAxeStructure());
      Element var128 = new Element("axeSite");
      this.racine.addContent(var128);
      var128.setText(var1.getAxeSite());
      Element var129 = new Element("axeRegion");
      this.racine.addContent(var129);
      var129.setText(var1.getAxeRegion());
      Element var130 = new Element("axeUsine");
      this.racine.addContent(var130);
      var130.setText(var1.getAxeUsine());
      Element var131 = new Element("axeActivite");
      this.racine.addContent(var131);
      var131.setText(var1.getAxeActivite());
      Element var132 = new Element("axeAgent");
      this.racine.addContent(var132);
      var132.setText(var1.getAxeAgent());
      Element var133 = new Element("axeChantier");
      this.racine.addContent(var133);
      var133.setText(var1.getAxeChantier());
      Element var134 = new Element("axeParc");
      this.racine.addContent(var134);
      var134.setText(var1.getAxeParc());
      Element var135 = new Element("axeMission");
      this.racine.addContent(var135);
      var135.setText(var1.getAxeMission());
      Element var136 = new Element("axeCles");
      this.racine.addContent(var136);
      var136.setText(var1.getAxeCles());
      Element var137 = new Element("axeProjet");
      this.racine.addContent(var137);
      var137.setText(var1.getAxeProjet());
      Element var138 = new Element("axeDossier");
      this.racine.addContent(var138);
      var138.setText(var1.getAxeDossier());
      Element var139 = new Element("chronoMatricule");
      this.racine.addContent(var139);
      var139.setText(var1.getChronoMatricule());
      Element var140 = new Element("affichInGlobViewINVENTAIRE");
      this.racine.addContent(var140);
      var140.setText(var1.getAffichInGlobViewINVENTAIRE());
      Element var141 = new Element("affichInGlobViewCARNET");
      this.racine.addContent(var141);
      var141.setText(var1.getAffichInGlobViewCARNET());
      Element var142 = new Element("saisieCarnet");
      this.racine.addContent(var142);
      var142.setText(var1.getSaisieCarnet());
      Element var143 = new Element("affichInGlobViewROULAGE");
      this.racine.addContent(var143);
      var143.setText(var1.getAffichInGlobViewROULAGE());
      Element var144 = new Element("saisieRoulage");
      this.racine.addContent(var144);
      var144.setText(var1.getSaisieRoulage());
      Element var145 = new Element("affichInGlobViewROUTE");
      this.racine.addContent(var145);
      var145.setText(var1.getAffichInGlobViewROUTE());
      Element var146 = new Element("saisieRoute");
      this.racine.addContent(var146);
      var146.setText(var1.getSaisieRoute());
      Element var147 = new Element("affichInGlobViewEXPEDITION");
      this.racine.addContent(var147);
      var147.setText(var1.getAffichInGlobViewEXPEDITION());
      Element var148 = new Element("saisieExpedition");
      this.racine.addContent(var148);
      var148.setText(var1.getSaisieExpedition());
      this.enregistrer();
      return "";
   }

   public Element getRacine() {
      return this.racine;
   }

   public void setRacine(Element var1) {
      this.racine = var1;
   }

   public Document getDocument() {
      return this.document;
   }

   public void setDocument(Document var1) {
      this.document = var1;
   }

   public String annuler() {
      return "annuler";
   }

   public OptionVentes getOptionVentes() {
      return this.optionVentes;
   }

   public void setOptionVentes(OptionVentes var1) {
      this.optionVentes = var1;
   }

   public boolean isGriseAnalytique() {
      return this.griseAnalytique;
   }

   public void setGriseAnalytique(boolean var1) {
      this.griseAnalytique = var1;
   }

   public String getObsAnalytique() {
      return this.obsAnalytique;
   }

   public void setObsAnalytique(String var1) {
      this.obsAnalytique = var1;
   }

   public boolean isGriseProduit() {
      return this.griseProduit;
   }

   public void setGriseProduit(boolean var1) {
      this.griseProduit = var1;
   }

   public String getObsProduit() {
      return this.obsProduit;
   }

   public void setObsProduit(String var1) {
      this.obsProduit = var1;
   }

   public boolean isVar_affiche_comptoir() {
      return this.var_affiche_comptoir;
   }

   public void setVar_affiche_comptoir(boolean var1) {
      this.var_affiche_comptoir = var1;
   }

   public String getBaseLog() {
      return this.baseLog;
   }

   public void setBaseLog(String var1) {
      this.baseLog = var1;
   }

   public Structure getStructureLog() {
      return this.structureLog;
   }

   public void setStructureLog(Structure var1) {
      this.structureLog = var1;
   }

   public Users getUsersLog() {
      return this.usersLog;
   }

   public void setUsersLog(Users var1) {
      this.usersLog = var1;
   }

   public UtilInitHibernate getutilInitHibernate() {
      return this.utilInitHibernate;
   }

   public void setutilInitHibernate(UtilInitHibernate var1) {
      this.utilInitHibernate = var1;
   }

   public ExercicesVentes getExercicesVentes() {
      return this.exercicesVentes;
   }

   public void setExercicesVentes(ExercicesVentes var1) {
      this.exercicesVentes = var1;
   }

   public List getMeslisteFamilleItems() {
      return this.meslisteFamilleItems;
   }

   public void setMeslisteFamilleItems(List var1) {
      this.meslisteFamilleItems = var1;
   }

   public List getMesDepotsItem() {
      return this.mesDepotsItem;
   }

   public void setMesDepotsItem(List var1) {
      this.mesDepotsItem = var1;
   }

   public List getMesCaissesItem() {
      return this.mesCaissesItem;
   }

   public void setMesCaissesItem(List var1) {
      this.mesCaissesItem = var1;
   }

   public boolean isLib1() {
      return this.lib1;
   }

   public void setLib1(boolean var1) {
      this.lib1 = var1;
   }

   public boolean isLib10() {
      return this.lib10;
   }

   public void setLib10(boolean var1) {
      this.lib10 = var1;
   }

   public boolean isLib2() {
      return this.lib2;
   }

   public void setLib2(boolean var1) {
      this.lib2 = var1;
   }

   public boolean isLib3() {
      return this.lib3;
   }

   public void setLib3(boolean var1) {
      this.lib3 = var1;
   }

   public boolean isLib4() {
      return this.lib4;
   }

   public void setLib4(boolean var1) {
      this.lib4 = var1;
   }

   public boolean isLib5() {
      return this.lib5;
   }

   public void setLib5(boolean var1) {
      this.lib5 = var1;
   }

   public boolean isLib6() {
      return this.lib6;
   }

   public void setLib6(boolean var1) {
      this.lib6 = var1;
   }

   public boolean isLib7() {
      return this.lib7;
   }

   public void setLib7(boolean var1) {
      this.lib7 = var1;
   }

   public boolean isLib8() {
      return this.lib8;
   }

   public void setLib8(boolean var1) {
      this.lib8 = var1;
   }

   public boolean isLib9() {
      return this.lib9;
   }

   public void setLib9(boolean var1) {
      this.lib9 = var1;
   }

   public List getMesTvaItem() {
      return this.mesTvaItem;
   }

   public void setMesTvaItem(List var1) {
      this.mesTvaItem = var1;
   }

   public boolean isModuleParc() {
      return this.moduleParc;
   }

   public void setModuleParc(boolean var1) {
      this.moduleParc = var1;
   }

   public boolean isModulePaye() {
      return this.modulePaye;
   }

   public void setModulePaye(boolean var1) {
      this.modulePaye = var1;
   }

   public boolean isModuleProjet() {
      return this.moduleProjet;
   }

   public void setModuleProjet(boolean var1) {
      this.moduleProjet = var1;
   }

   public boolean isModuleStructure() {
      return this.moduleStructure;
   }

   public void setModuleStructure(boolean var1) {
      this.moduleStructure = var1;
   }

   public boolean isModuleUsine() {
      return this.moduleUsine;
   }

   public void setModuleUsine(boolean var1) {
      this.moduleUsine = var1;
   }

   public boolean isModuleTransit() {
      return this.moduleTransit;
   }

   public void setModuleTransit(boolean var1) {
      this.moduleTransit = var1;
   }
}
