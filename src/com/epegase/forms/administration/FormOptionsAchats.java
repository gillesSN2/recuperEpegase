package com.epegase.forms.administration;

import com.epegase.systeme.classe.ExercicesAchats;
import com.epegase.systeme.classe.Structure;
import com.epegase.systeme.classe.TaxesAchats;
import com.epegase.systeme.classe.Users;
import com.epegase.systeme.dao.StructureDao;
import com.epegase.systeme.dao.TaxesAchatsDao;
import com.epegase.systeme.util.StaticModePegase;
import com.epegase.systeme.util.UtilInitHibernate;
import com.epegase.systeme.xml.LireLesoptionsMedical;
import com.epegase.systeme.xml.LireLesoptionsVentes;
import com.epegase.systeme.xml.ObjetCompte;
import com.epegase.systeme.xml.OptionAchats;
import com.epegase.systeme.xml.OptionComptabilite;
import com.epegase.systeme.xml.OptionMedical;
import com.epegase.systeme.xml.OptionVentes;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
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

public class FormOptionsAchats implements Serializable {
   private UtilInitHibernate utilInitHibernate;
   private String baseLog;
   private Structure structureLog;
   private Users usersLog;
   private OptionAchats optionAchats = new OptionAchats();
   private Element racine = new Element("optionAchats");
   private Document document;
   private ObjetCompte objetCompte;
   private boolean griseAnalytique = false;
   private String obsAnalytique;
   private boolean majOptionVentes;
   private boolean majOptionMedical;
   private ExercicesAchats exercicesAchats;
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
   private boolean moduleParc = false;
   private boolean modulePaye = false;
   private boolean moduleUsine = false;
   private boolean moduleProjet = false;
   private boolean moduleStructure = false;

   public FormOptionsAchats() throws SAXException {
      this.document = new Document(this.racine);
      this.mesTvaItem = new ArrayList();
   }

   public void calculeLibEntete() {
      if (this.optionAchats.getLib1() != null && !this.optionAchats.getLib1().isEmpty()) {
         this.lib1 = true;
      } else {
         this.lib1 = false;
      }

      if (this.optionAchats.getLib2() != null && !this.optionAchats.getLib2().isEmpty()) {
         this.lib2 = true;
      } else {
         this.lib2 = false;
      }

      if (this.optionAchats.getLib3() != null && !this.optionAchats.getLib3().isEmpty()) {
         this.lib3 = true;
      } else {
         this.lib3 = false;
      }

      if (this.optionAchats.getLib4() != null && !this.optionAchats.getLib4().isEmpty()) {
         this.lib4 = true;
      } else {
         this.lib4 = false;
      }

      if (this.optionAchats.getLib5() != null && !this.optionAchats.getLib5().isEmpty()) {
         this.lib5 = true;
      } else {
         this.lib5 = false;
      }

      if (this.optionAchats.getLib6() != null && !this.optionAchats.getLib6().isEmpty()) {
         this.lib6 = true;
      } else {
         this.lib6 = false;
      }

      if (this.optionAchats.getLib7() != null && !this.optionAchats.getLib7().isEmpty()) {
         this.lib7 = true;
      } else {
         this.lib7 = false;
      }

      if (this.optionAchats.getLib8() != null && !this.optionAchats.getLib8().isEmpty()) {
         this.lib8 = true;
      } else {
         this.lib8 = false;
      }

      if (this.optionAchats.getLib9() != null && !this.optionAchats.getLib9().isEmpty()) {
         this.lib9 = true;
      } else {
         this.lib9 = false;
      }

      if (this.optionAchats.getLib10() != null && !this.optionAchats.getLib10().isEmpty()) {
         this.lib10 = true;
      } else {
         this.lib10 = false;
      }

      if (this.structureLog.getStrtypeentreprise().equals("2")) {
         this.moduleUsine = true;
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

   public void calculeTvaItems(Session var1) throws HibernateException, NamingException {
      this.mesTvaItem.clear();
      TaxesAchatsDao var2 = new TaxesAchatsDao(this.baseLog, this.utilInitHibernate);
      new ArrayList();
      List var3 = var2.selectActifTaxes(this.exercicesAchats.getExeachId(), var1);
      if (var3.size() != 0) {
         for(int var4 = 0; var4 < var3.size(); ++var4) {
            this.mesTvaItem.add(new SelectItem(((TaxesAchats)var3.get(var4)).getTaxachCode(), ((TaxesAchats)var3.get(var4)).getTaxachCode() + ":" + ((TaxesAchats)var3.get(var4)).getTaxachLibelleFr()));
         }
      }

   }

   public void creerOptionAchats() throws IOException, SAXException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("nbrJrRelanceDA");
      this.racine.addContent(var1);
      var1.setText("" + this.optionAchats.getNbrJrRelanceDA());
      Element var2 = new Element("nbrJrValidDA");
      this.racine.addContent(var2);
      var2.setText("" + this.optionAchats.getNbrJrValidDA());
      Element var3 = new Element("affichInTierFilDA");
      this.racine.addContent(var3);
      var3.setText(this.optionAchats.getAffichInTierFilDA());
      Element var4 = new Element("affichInGlobViewDA");
      this.racine.addContent(var4);
      var4.setText(this.optionAchats.getAffichInGlobViewDA());
      Element var5 = new Element("nbrJrRelanceCOT");
      this.racine.addContent(var5);
      var5.setText("" + this.optionAchats.getNbrJrRelanceCOT());
      Element var6 = new Element("nbrJrValidCOT");
      this.racine.addContent(var6);
      var6.setText("" + this.optionAchats.getNbrJrValidCOT());
      Element var7 = new Element("affichInTierFilCOT");
      this.racine.addContent(var7);
      var7.setText(this.optionAchats.getAffichInTierFilCOT());
      Element var8 = new Element("affichInGlobViewCOT");
      this.racine.addContent(var8);
      var8.setText(this.optionAchats.getAffichInGlobViewCOT());
      Element var9 = new Element("affichQtePoidsCOT");
      this.racine.addContent(var9);
      var9.setText(this.optionAchats.getAffichQtePoidsCOT());
      Element var10 = new Element("fraisPrp1");
      this.racine.addContent(var10);
      var10.setText(this.optionAchats.getFraisPrp1());
      Element var11 = new Element("fraisPrp2");
      this.racine.addContent(var11);
      var11.setText(this.optionAchats.getFraisPrp2());
      Element var12 = new Element("fraisPrp3");
      this.racine.addContent(var12);
      var12.setText(this.optionAchats.getFraisPrp3());
      Element var13 = new Element("tauxRusid");
      this.racine.addContent(var13);
      var13.setText("" + this.optionAchats.getTauxRusid());
      Element var14 = new Element("tauxReduit");
      this.racine.addContent(var14);
      var14.setText("" + this.optionAchats.getTauxReduit());
      Element var15 = new Element("nbrJrRelanceCOM");
      this.racine.addContent(var15);
      var15.setText("" + this.optionAchats.getNbrJrRelanceCOM());
      Element var16 = new Element("nbrJrValidCOM");
      this.racine.addContent(var16);
      var16.setText("" + this.optionAchats.getNbrJrValidCOM());
      Element var17 = new Element("affichInTierFilCOM");
      this.racine.addContent(var17);
      var17.setText(this.optionAchats.getAffichInTierFilCOM());
      Element var18 = new Element("affichInGlobViewCOM");
      this.racine.addContent(var18);
      var18.setText(this.optionAchats.getAffichInGlobViewCOM());
      Element var19 = new Element("affichQtePoidsCOM");
      this.racine.addContent(var19);
      var19.setText(this.optionAchats.getAffichQtePoidsCOM());
      Element var20 = new Element("budgetCOM");
      this.racine.addContent(var20);
      var20.setText(this.optionAchats.getBudgetCOM());
      Element var21 = new Element("qteDejaCOM");
      this.racine.addContent(var21);
      var21.setText(this.optionAchats.getQteDejaCOM());
      Element var22 = new Element("nbrJrRelanceREC");
      this.racine.addContent(var22);
      var22.setText("" + this.optionAchats.getNbrJrRelanceREC());
      Element var23 = new Element("nbrJrValidREC");
      this.racine.addContent(var23);
      var23.setText("" + this.optionAchats.getNbrJrValidREC());
      Element var24 = new Element("affichInTierFilREC");
      this.racine.addContent(var24);
      var24.setText(this.optionAchats.getAffichInTierFilREC());
      Element var25 = new Element("affichInGlobViewREC");
      this.racine.addContent(var25);
      var25.setText(this.optionAchats.getAffichInGlobViewREC());
      Element var26 = new Element("affichQtePoidsREC");
      this.racine.addContent(var26);
      var26.setText(this.optionAchats.getAffichQtePoidsREC());
      Element var27 = new Element("reacheminementREC");
      this.racine.addContent(var27);
      var27.setText(this.optionAchats.getReacheminementREC());
      Element var28 = new Element("modeCifCfrREC");
      this.racine.addContent(var28);
      var28.setText(this.optionAchats.getModeCifCfrREC());
      Element var29 = new Element("numeroReception");
      this.racine.addContent(var29);
      var29.setText(this.optionAchats.getNumeroReception());
      Element var30 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var30);
      var30.setText("" + this.optionAchats.getNbrJrRelanceFAC());
      Element var31 = new Element("nbrJrValidFAC");
      this.racine.addContent(var31);
      var31.setText("" + this.optionAchats.getNbrJrValidFAC());
      Element var32 = new Element("affichInTierFilFAC");
      this.racine.addContent(var32);
      var32.setText(this.optionAchats.getAffichInTierFilFAC());
      Element var33 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var33);
      var33.setText(this.optionAchats.getAffichInGlobViewFAC());
      Element var34 = new Element("modeCifCfrFAC");
      this.racine.addContent(var34);
      var34.setText(this.optionAchats.getModeCifCfrFAC());
      Element var35 = new Element("compteFretFAC");
      this.racine.addContent(var35);
      var35.setText(this.optionAchats.getCompteFretFAC());
      Element var36 = new Element("compteAssuranceFAC");
      this.racine.addContent(var36);
      var36.setText(this.optionAchats.getCompteAssuranceFAC());
      Element var37 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var37);
      var37.setText("" + this.optionAchats.getNbrJrRelanceNOTDEB());
      Element var38 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var38);
      var38.setText("" + this.optionAchats.getNbrJrValidNOTDEB());
      Element var39 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var39);
      var39.setText(this.optionAchats.getAffichInTierFilNOTDEB());
      Element var40 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var40);
      var40.setText(this.optionAchats.getAffichInGlobViewNOTDEB());
      Element var41 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var41);
      var41.setText("" + this.optionAchats.getNbrJrRelanceAVOIR());
      Element var42 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var42);
      var42.setText("" + this.optionAchats.getNbrJrValidAVOIR());
      Element var43 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var43);
      var43.setText(this.optionAchats.getAffichInTierFilAVOIR());
      Element var44 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var44);
      var44.setText(this.optionAchats.getAffichInGlobViewAVOIR());
      Element var45 = new Element("nbrJrRelanceRETOUR");
      this.racine.addContent(var45);
      var45.setText("" + this.optionAchats.getNbrJrRelanceRETOUR());
      Element var46 = new Element("nbrJrValidRETOUR");
      this.racine.addContent(var46);
      var46.setText("" + this.optionAchats.getNbrJrValidRETOUR());
      new Element("anal1RETOUR");
      Element var48 = new Element("affichInTierFilRETOUR");
      this.racine.addContent(var48);
      var48.setText(this.optionAchats.getAffichInTierFilRETOUR());
      Element var49 = new Element("affichInGlobViewRETOUR");
      this.racine.addContent(var49);
      var49.setText(this.optionAchats.getAffichInGlobViewRETOUR());
      Element var50 = new Element("nbrJrRelanceFRA");
      this.racine.addContent(var50);
      var50.setText("" + this.optionAchats.getNbrJrRelanceFRA());
      Element var51 = new Element("nbrJrValidFRA");
      this.racine.addContent(var51);
      var51.setText("" + this.optionAchats.getNbrJrValidFRA());
      Element var52 = new Element("affichInTierFilFRA");
      this.racine.addContent(var52);
      var52.setText(this.optionAchats.getAffichInTierFilFRA());
      Element var53 = new Element("affichInGlobViewFRA");
      this.racine.addContent(var53);
      var53.setText(this.optionAchats.getAffichInGlobViewFRA());
      Element var54 = new Element("chargerFRA");
      this.racine.addContent(var54);
      var54.setText(this.optionAchats.getChargerFRA());
      Element var55 = new Element("affichInGlobViewAffaire");
      this.racine.addContent(var55);
      var55.setText(this.optionAchats.getAffichInGlobViewAffaire());
      Element var56 = new Element("affichInTierAffaire");
      this.racine.addContent(var56);
      var56.setText(this.optionAchats.getAffichInTierAffaire());
      Element var57 = new Element("nbrCtrsProProd");
      this.racine.addContent(var57);
      var57.setText("" + this.optionAchats.getNbrCtrsProProd());
      Element var58 = new Element("nbrCtrsFamProd");
      this.racine.addContent(var58);
      var58.setText("" + this.optionAchats.getNbrCtrsFamProd());
      Element var59 = new Element("modCalcProd");
      this.racine.addContent(var59);
      var59.setText(this.optionAchats.getModCalcProd());
      Element var60 = new Element("modCoefPr");
      this.racine.addContent(var60);
      var60.setText(this.optionAchats.getModCoefPr());
      Element var61 = new Element("modCalcPr");
      this.racine.addContent(var61);
      var61.setText(this.optionAchats.getModCalcPr());
      Element var62 = new Element("modCalcPump");
      this.racine.addContent(var62);
      var62.setText(this.optionAchats.getModCalcPump());
      Element var63 = new Element("modDepPump");
      this.racine.addContent(var63);
      var63.setText(this.optionAchats.getModDepPump());
      Element var64 = new Element("modValoPvProd");
      this.racine.addContent(var64);
      var64.setText(this.optionAchats.getModValoPvProd());
      Element var65 = new Element("modValoFret");
      this.racine.addContent(var65);
      var65.setText(this.optionAchats.getModValoFret());
      Element var66 = new Element("decrmtRabais");
      this.racine.addContent(var66);
      var66.setText(this.optionAchats.getDecrmtRabais());
      Element var67 = new Element("analAuto");
      this.racine.addContent(var67);
      var67.setText(this.optionAchats.getAnalAuto());
      Element var68 = new Element("nbLigneMax");
      this.racine.addContent(var68);
      var68.setText(this.optionAchats.getNbLigneMax());
      Element var69 = new Element("nbDecQte");
      this.racine.addContent(var69);
      var69.setText(this.optionAchats.getNbDecQte());
      Element var70 = new Element("nbDecPu");
      this.racine.addContent(var70);
      var70.setText(this.optionAchats.getNbDecPu());
      Element var71 = new Element("trfCompta");
      this.racine.addContent(var71);
      var71.setText(this.optionAchats.getTrfCompta());
      Element var72 = new Element("chargementListe");
      this.racine.addContent(var72);
      var72.setText(this.optionAchats.getChargementListe());
      Element var73 = new Element("activiteEnteteLigne");
      this.racine.addContent(var73);
      var73.setText(this.optionAchats.getActiviteEnteteLigne());
      Element var74 = new Element("descriptifComplementaire");
      this.racine.addContent(var74);
      var74.setText(this.optionAchats.getDescriptifComplementaire());
      Element var75 = new Element("dateTransformation");
      this.racine.addContent(var75);
      var75.setText(this.optionAchats.getDateTransformation());
      Element var76 = new Element("photosProduit");
      this.racine.addContent(var76);
      var76.setText(this.optionAchats.getPhotosProduit());
      Element var77 = new Element("choixStock");
      this.racine.addContent(var77);
      var77.setText(this.optionAchats.getChoixStock());
      Element var78 = new Element("tvaDefaut");
      this.racine.addContent(var78);
      var78.setText(this.optionAchats.getTvaDefaut());
      Element var79 = new Element("paiementAVOIR");
      this.racine.addContent(var79);
      var79.setText(this.optionAchats.getPaiementAVOIR());
      Element var80 = new Element("transformation");
      this.racine.addContent(var80);
      var80.setText(this.optionAchats.getTransformation());
      Element var81 = new Element("depotStock");
      this.racine.addContent(var81);
      var81.setText(this.optionAchats.getDepotStock());
      Element var82 = new Element("modeCalculDevis");
      this.racine.addContent(var82);
      var82.setText(this.optionAchats.getModeCalculDevis());
      Element var83 = new Element("modLibelleProd");
      this.racine.addContent(var83);
      var83.setText(this.optionAchats.getModLibelleProd());
      Element var84 = new Element("configBudStks");
      this.racine.addContent(var84);
      var84.setText(this.optionAchats.getConfigBudStks());
      Element var85 = new Element("configSitDepSerStks");
      this.racine.addContent(var85);
      var85.setText(this.optionAchats.getConfigSitDepSerStks());
      Element var86 = new Element("configRegSecPdvStks");
      this.racine.addContent(var86);
      var86.setText(this.optionAchats.getConfigRegSecPdvStks());
      Element var87 = new Element("configanal1Stks");
      this.racine.addContent(var87);
      var87.setText(this.optionAchats.getConfiganal1Stks());
      Element var88 = new Element("configanal2Stks");
      this.racine.addContent(var88);
      var88.setText(this.optionAchats.getConfiganal2Stks());
      Element var89 = new Element("configanal2Stks");
      this.racine.addContent(var89);
      var89.setText(this.optionAchats.getConfiganal3Stks());
      Element var90 = new Element("configanal4Stks");
      this.racine.addContent(var90);
      var90.setText(this.optionAchats.getConfiganal4Stks());
      Element var91 = new Element("libelle1");
      this.racine.addContent(var91);
      var91.setText(this.optionAchats.getLib1());
      Element var92 = new Element("libelle2");
      this.racine.addContent(var92);
      var92.setText(this.optionAchats.getLib2());
      Element var93 = new Element("libelle3");
      this.racine.addContent(var93);
      var93.setText(this.optionAchats.getLib3());
      Element var94 = new Element("libelle4");
      this.racine.addContent(var94);
      var94.setText(this.optionAchats.getLib4());
      Element var95 = new Element("libelle5");
      this.racine.addContent(var95);
      var95.setText(this.optionAchats.getLib5());
      Element var96 = new Element("libelle6");
      this.racine.addContent(var96);
      var96.setText(this.optionAchats.getLib6());
      Element var97 = new Element("libelle7");
      this.racine.addContent(var97);
      var97.setText(this.optionAchats.getLib7());
      Element var98 = new Element("libelle8");
      this.racine.addContent(var98);
      var98.setText(this.optionAchats.getLib8());
      Element var99 = new Element("libelle9");
      this.racine.addContent(var99);
      var99.setText(this.optionAchats.getLib9());
      Element var100 = new Element("libelle10");
      this.racine.addContent(var100);
      var100.setText(this.optionAchats.getLib10());
      Element var101 = new Element("serie1");
      this.racine.addContent(var101);
      var101.setText(this.optionAchats.getSerie1());
      Element var102 = new Element("serie2");
      this.racine.addContent(var102);
      var102.setText(this.optionAchats.getSerie2());
      Element var103 = new Element("serie3");
      this.racine.addContent(var103);
      var103.setText(this.optionAchats.getSerie3());
      Element var104 = new Element("serie4");
      this.racine.addContent(var104);
      var104.setText(this.optionAchats.getSerie4());
      Element var105 = new Element("serie5");
      this.racine.addContent(var105);
      var105.setText(this.optionAchats.getSerie5());
      Element var106 = new Element("serie6");
      this.racine.addContent(var106);
      var106.setText(this.optionAchats.getSerie6());
      Element var107 = new Element("serie7");
      this.racine.addContent(var107);
      var107.setText(this.optionAchats.getSerie7());
      Element var108 = new Element("serie8");
      this.racine.addContent(var108);
      var108.setText(this.optionAchats.getSerie8());
      Element var109 = new Element("serie9");
      this.racine.addContent(var109);
      var109.setText(this.optionAchats.getSerie9());
      Element var110 = new Element("serie10");
      this.racine.addContent(var110);
      var110.setText(this.optionAchats.getSerie10());
      Element var111 = new Element("serie11");
      this.racine.addContent(var111);
      var111.setText(this.optionAchats.getSerie11());
      Element var112 = new Element("serie12");
      this.racine.addContent(var112);
      var112.setText(this.optionAchats.getSerie12());
      Element var113 = new Element("serie13");
      this.racine.addContent(var113);
      var113.setText(this.optionAchats.getSerie13());
      Element var114 = new Element("serie14");
      this.racine.addContent(var114);
      var114.setText(this.optionAchats.getSerie14());
      Element var115 = new Element("serie15");
      this.racine.addContent(var115);
      var115.setText(this.optionAchats.getSerie15());
      Element var116 = new Element("serie16");
      this.racine.addContent(var116);
      var116.setText(this.optionAchats.getSerie16());
      Element var117 = new Element("serie17");
      this.racine.addContent(var117);
      var117.setText(this.optionAchats.getSerie17());
      Element var118 = new Element("serie18");
      this.racine.addContent(var118);
      var118.setText(this.optionAchats.getSerie18());
      Element var119 = new Element("serie19");
      this.racine.addContent(var119);
      var119.setText(this.optionAchats.getSerie19());
      Element var120 = new Element("serie20");
      this.racine.addContent(var120);
      var120.setText(this.optionAchats.getSerie20());
      Element var121 = new Element("zoneRef1");
      this.racine.addContent(var121);
      var121.setText(this.optionAchats.getZoneRef1());
      Element var122 = new Element("zoneRef2");
      this.racine.addContent(var122);
      var122.setText(this.optionAchats.getZoneRef2());
      Element var123 = new Element("zoneLibelle");
      this.racine.addContent(var123);
      var123.setText(this.optionAchats.getZoneLibelle());
      Element var124 = new Element("zoneLibelleSuite");
      this.racine.addContent(var124);
      var124.setText(this.optionAchats.getZoneLibelleSuite());
      Element var125 = new Element("zoneRef1Serie");
      this.racine.addContent(var125);
      var125.setText(this.optionAchats.getZoneRef1Serie());
      Element var126 = new Element("zoneRef2Serie");
      this.racine.addContent(var126);
      var126.setText(this.optionAchats.getZoneRef2Serie());
      Element var127 = new Element("transfertDocument");
      this.racine.addContent(var127);
      var127.setText(this.optionAchats.getTransfertDocument());
      Element var128 = new Element("axeStructure");
      this.racine.addContent(var128);
      var128.setText(this.optionAchats.getAxeStructure());
      Element var129 = new Element("axeSite");
      this.racine.addContent(var129);
      var129.setText(this.optionAchats.getAxeSite());
      Element var130 = new Element("axeRegion");
      this.racine.addContent(var130);
      var130.setText(this.optionAchats.getAxeRegion());
      Element var131 = new Element("axeUsine");
      this.racine.addContent(var131);
      var131.setText(this.optionAchats.getAxeUsine());
      Element var132 = new Element("axeActivite");
      this.racine.addContent(var132);
      var132.setText(this.optionAchats.getAxeActivite());
      Element var133 = new Element("axeAgent");
      this.racine.addContent(var133);
      var133.setText(this.optionAchats.getAxeAgent());
      Element var134 = new Element("axeChantier");
      this.racine.addContent(var134);
      var134.setText(this.optionAchats.getAxeChantier());
      Element var135 = new Element("axeParc");
      this.racine.addContent(var135);
      var135.setText(this.optionAchats.getAxeParc());
      Element var136 = new Element("axeMission");
      this.racine.addContent(var136);
      var136.setText(this.optionAchats.getAxeMission());
      Element var137 = new Element("axeCles");
      this.racine.addContent(var137);
      var137.setText(this.optionAchats.getAxeCles());
      Element var138 = new Element("axeProjet");
      this.racine.addContent(var138);
      var138.setText(this.optionAchats.getAxeProjet());
      Element var139 = new Element("axeDossier");
      this.racine.addContent(var139);
      var139.setText(this.optionAchats.getAxeDossier());
      this.enregistre();
      StructureDao var140 = new StructureDao(this.baseLog, this.utilInitHibernate);
      new Structure();
      Structure var141;
      if (this.structureLog.getStrid() == 0L) {
         var141 = var140.logStructure((Session)null);
      } else {
         var141 = var140.logStructureId(this.structureLog.getStrid(), (Session)null);
      }

      var141.setStrDepotStock(Integer.parseInt(this.optionAchats.getDepotStock()));
      var140.modStructure(var141);
      if (this.majOptionVentes) {
         FormOptionsVentes var142 = new FormOptionsVentes(this.structureLog);
         var142.setBaseLog(this.baseLog);
         var142.setStructureLog(this.structureLog);
         LireLesoptionsVentes var143 = new LireLesoptionsVentes();
         var143.setStrId(this.structureLog.getStrid());
         new OptionVentes();
         OptionVentes var144 = var143.lancer();
         var142.creerOptionsVentesAchats(var144, this.optionAchats);
      }

      if (this.majOptionMedical) {
         FormOptionsMedical var145 = new FormOptionsMedical();
         var145.setBaseLog(this.baseLog);
         var145.setStructureLog(this.structureLog);
         LireLesoptionsMedical var146 = new LireLesoptionsMedical();
         var146.setStrId(this.structureLog.getStrid());
         new OptionMedical();
         OptionMedical var147 = var146.lancer();
         var145.creerOptionsMedicalAchats(var147, this.optionAchats);
      }

   }

   public void updateOptionAchats() throws IOException, SAXException, HibernateException, NamingException {
      this.racine.removeContent();
      Element var1 = new Element("nbrJrRelanceDA");
      this.racine.addContent(var1);
      var1.setText("" + this.optionAchats.getNbrJrRelanceDA());
      Element var2 = new Element("nbrJrValidDA");
      this.racine.addContent(var2);
      var2.setText("" + this.optionAchats.getNbrJrValidDA());
      Element var3 = new Element("affichInTierFilDA");
      this.racine.addContent(var3);
      var3.setText(this.optionAchats.getAffichInTierFilDA());
      Element var4 = new Element("affichInGlobViewDA");
      this.racine.addContent(var4);
      var4.setText(this.optionAchats.getAffichInGlobViewDA());
      Element var5 = new Element("nbrJrRelanceCOT");
      this.racine.addContent(var5);
      var5.setText("" + this.optionAchats.getNbrJrRelanceCOT());
      Element var6 = new Element("nbrJrValidCOT");
      this.racine.addContent(var6);
      var6.setText("" + this.optionAchats.getNbrJrValidCOT());
      Element var7 = new Element("affichInTierFilCOT");
      this.racine.addContent(var7);
      var7.setText(this.optionAchats.getAffichInTierFilCOT());
      Element var8 = new Element("affichInGlobViewCOT");
      this.racine.addContent(var8);
      var8.setText(this.optionAchats.getAffichInGlobViewCOT());
      Element var9 = new Element("affichQtePoidsCOT");
      this.racine.addContent(var9);
      var9.setText(this.optionAchats.getAffichQtePoidsCOT());
      Element var10 = new Element("fraisPrp1");
      this.racine.addContent(var10);
      var10.setText(this.optionAchats.getFraisPrp1());
      Element var11 = new Element("fraisPrp2");
      this.racine.addContent(var11);
      var11.setText(this.optionAchats.getFraisPrp2());
      Element var12 = new Element("fraisPrp3");
      this.racine.addContent(var12);
      var12.setText(this.optionAchats.getFraisPrp3());
      Element var13 = new Element("tauxRusid");
      this.racine.addContent(var13);
      var13.setText("" + this.optionAchats.getTauxRusid());
      Element var14 = new Element("tauxReduit");
      this.racine.addContent(var14);
      var14.setText("" + this.optionAchats.getTauxReduit());
      Element var15 = new Element("nbrJrRelanceCOM");
      this.racine.addContent(var15);
      var15.setText("" + this.optionAchats.getNbrJrRelanceCOM());
      Element var16 = new Element("nbrJrValidCOM");
      this.racine.addContent(var16);
      var16.setText("" + this.optionAchats.getNbrJrValidCOM());
      Element var17 = new Element("affichInTierFilCOM");
      this.racine.addContent(var17);
      var17.setText(this.optionAchats.getAffichInTierFilCOM());
      Element var18 = new Element("affichInGlobViewCOM");
      this.racine.addContent(var18);
      var18.setText(this.optionAchats.getAffichInGlobViewCOM());
      Element var19 = new Element("affichQtePoidsCOM");
      this.racine.addContent(var19);
      var19.setText(this.optionAchats.getAffichQtePoidsCOM());
      Element var20 = new Element("budgetCOM");
      this.racine.addContent(var20);
      var20.setText(this.optionAchats.getBudgetCOM());
      Element var21 = new Element("qteDejaCOM");
      this.racine.addContent(var21);
      var21.setText(this.optionAchats.getQteDejaCOM());
      Element var22 = new Element("nbrJrRelanceREC");
      this.racine.addContent(var22);
      var22.setText("" + this.optionAchats.getNbrJrRelanceREC());
      Element var23 = new Element("nbrJrValidREC");
      this.racine.addContent(var23);
      var23.setText("" + this.optionAchats.getNbrJrValidREC());
      Element var24 = new Element("affichInTierFilREC");
      this.racine.addContent(var24);
      var24.setText(this.optionAchats.getAffichInTierFilREC());
      Element var25 = new Element("affichInGlobViewREC");
      this.racine.addContent(var25);
      var25.setText(this.optionAchats.getAffichInGlobViewREC());
      Element var26 = new Element("affichQtePoidsREC");
      this.racine.addContent(var26);
      var26.setText(this.optionAchats.getAffichQtePoidsREC());
      Element var27 = new Element("reacheminementREC");
      this.racine.addContent(var27);
      var27.setText(this.optionAchats.getReacheminementREC());
      Element var28 = new Element("modeCifCfrREC");
      this.racine.addContent(var28);
      var28.setText(this.optionAchats.getModeCifCfrREC());
      Element var29 = new Element("numeroReception");
      this.racine.addContent(var29);
      var29.setText(this.optionAchats.getNumeroReception());
      Element var30 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var30);
      var30.setText("" + this.optionAchats.getNbrJrRelanceFAC());
      Element var31 = new Element("nbrJrValidFAC");
      this.racine.addContent(var31);
      var31.setText("" + this.optionAchats.getNbrJrValidFAC());
      Element var32 = new Element("affichInTierFilFAC");
      this.racine.addContent(var32);
      var32.setText(this.optionAchats.getAffichInTierFilFAC());
      Element var33 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var33);
      var33.setText(this.optionAchats.getAffichInGlobViewFAC());
      Element var34 = new Element("modeCifCfrFAC");
      this.racine.addContent(var34);
      var34.setText(this.optionAchats.getModeCifCfrFAC());
      Element var35 = new Element("compteFretFAC");
      this.racine.addContent(var35);
      var35.setText(this.optionAchats.getCompteFretFAC());
      Element var36 = new Element("compteAssuranceFAC");
      this.racine.addContent(var36);
      var36.setText(this.optionAchats.getCompteAssuranceFAC());
      Element var37 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var37);
      var37.setText("" + this.optionAchats.getNbrJrRelanceNOTDEB());
      Element var38 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var38);
      var38.setText("" + this.optionAchats.getNbrJrValidNOTDEB());
      Element var39 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var39);
      var39.setText(this.optionAchats.getAffichInTierFilNOTDEB());
      Element var40 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var40);
      var40.setText(this.optionAchats.getAffichInGlobViewNOTDEB());
      Element var41 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var41);
      var41.setText("" + this.optionAchats.getNbrJrRelanceAVOIR());
      Element var42 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var42);
      var42.setText("" + this.optionAchats.getNbrJrValidAVOIR());
      Element var43 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var43);
      var43.setText(this.optionAchats.getAffichInTierFilAVOIR());
      Element var44 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var44);
      var44.setText(this.optionAchats.getAffichInGlobViewAVOIR());
      Element var45 = new Element("nbrJrRelanceRETOUR");
      this.racine.addContent(var45);
      var45.setText("" + this.optionAchats.getNbrJrRelanceRETOUR());
      Element var46 = new Element("nbrJrValidRETOUR");
      this.racine.addContent(var46);
      var46.setText("" + this.optionAchats.getNbrJrValidRETOUR());
      new Element("anal1RETOUR");
      Element var48 = new Element("affichInTierFilRETOUR");
      this.racine.addContent(var48);
      var48.setText(this.optionAchats.getAffichInTierFilRETOUR());
      Element var49 = new Element("affichInGlobViewRETOUR");
      this.racine.addContent(var49);
      var49.setText(this.optionAchats.getAffichInGlobViewRETOUR());
      Element var50 = new Element("nbrJrRelanceFRA");
      this.racine.addContent(var50);
      var50.setText("" + this.optionAchats.getNbrJrRelanceFRA());
      Element var51 = new Element("nbrJrValidFRA");
      this.racine.addContent(var51);
      var51.setText("" + this.optionAchats.getNbrJrValidFRA());
      Element var52 = new Element("affichInTierFilFRA");
      this.racine.addContent(var52);
      var52.setText(this.optionAchats.getAffichInTierFilFRA());
      Element var53 = new Element("affichInGlobViewFRA");
      this.racine.addContent(var53);
      var53.setText(this.optionAchats.getAffichInGlobViewFRA());
      Element var54 = new Element("chargerFRA");
      this.racine.addContent(var54);
      var54.setText(this.optionAchats.getChargerFRA());
      Element var55 = new Element("affichInGlobViewAffaire");
      this.racine.addContent(var55);
      var55.setText(this.optionAchats.getAffichInGlobViewAffaire());
      Element var56 = new Element("affichInTierAffaire");
      this.racine.addContent(var56);
      var56.setText(this.optionAchats.getAffichInTierAffaire());
      Element var57 = new Element("nbrCtrsProProd");
      this.racine.addContent(var57);
      var57.setText("" + this.optionAchats.getNbrCtrsProProd());
      Element var58 = new Element("nbrCtrsFamProd");
      this.racine.addContent(var58);
      var58.setText("" + this.optionAchats.getNbrCtrsFamProd());
      Element var59 = new Element("modCalcProd");
      this.racine.addContent(var59);
      var59.setText(this.optionAchats.getModCalcProd());
      Element var60 = new Element("modCoefPr");
      this.racine.addContent(var60);
      var60.setText(this.optionAchats.getModCoefPr());
      Element var61 = new Element("modCalcPr");
      this.racine.addContent(var61);
      var61.setText(this.optionAchats.getModCalcPr());
      Element var62 = new Element("modCalcPump");
      this.racine.addContent(var62);
      var62.setText(this.optionAchats.getModCalcPump());
      Element var63 = new Element("modDepPump");
      this.racine.addContent(var63);
      var63.setText(this.optionAchats.getModDepPump());
      Element var64 = new Element("modValoPvProd");
      this.racine.addContent(var64);
      var64.setText(this.optionAchats.getModValoPvProd());
      Element var65 = new Element("modValoFret");
      this.racine.addContent(var65);
      var65.setText(this.optionAchats.getModValoFret());
      Element var66 = new Element("decrmtRabais");
      this.racine.addContent(var66);
      var66.setText(this.optionAchats.getDecrmtRabais());
      Element var67 = new Element("analAuto");
      this.racine.addContent(var67);
      var67.setText(this.optionAchats.getAnalAuto());
      Element var68 = new Element("nbLigneMax");
      this.racine.addContent(var68);
      var68.setText(this.optionAchats.getNbLigneMax());
      Element var69 = new Element("nbDecQte");
      this.racine.addContent(var69);
      var69.setText(this.optionAchats.getNbDecQte());
      Element var70 = new Element("nbDecPu");
      this.racine.addContent(var70);
      var70.setText(this.optionAchats.getNbDecPu());
      Element var71 = new Element("trfCompta");
      this.racine.addContent(var71);
      var71.setText(this.optionAchats.getTrfCompta());
      Element var72 = new Element("chargementListe");
      this.racine.addContent(var72);
      var72.setText(this.optionAchats.getChargementListe());
      Element var73 = new Element("activiteEnteteLigne");
      this.racine.addContent(var73);
      var73.setText(this.optionAchats.getActiviteEnteteLigne());
      Element var74 = new Element("descriptifComplementaire");
      this.racine.addContent(var74);
      var74.setText(this.optionAchats.getDescriptifComplementaire());
      Element var75 = new Element("dateTransformation");
      this.racine.addContent(var75);
      var75.setText(this.optionAchats.getDateTransformation());
      Element var76 = new Element("photosProduit");
      this.racine.addContent(var76);
      var76.setText(this.optionAchats.getPhotosProduit());
      Element var77 = new Element("choixStock");
      this.racine.addContent(var77);
      var77.setText(this.optionAchats.getChoixStock());
      Element var78 = new Element("tvaDefaut");
      this.racine.addContent(var78);
      var78.setText(this.optionAchats.getTvaDefaut());
      Element var79 = new Element("paiementAVOIR");
      this.racine.addContent(var79);
      var79.setText(this.optionAchats.getPaiementAVOIR());
      Element var80 = new Element("transformation");
      this.racine.addContent(var80);
      var80.setText(this.optionAchats.getTransformation());
      Element var81 = new Element("depotStock");
      this.racine.addContent(var81);
      var81.setText(this.optionAchats.getDepotStock());
      Element var82 = new Element("modeCalculDevis");
      this.racine.addContent(var82);
      var82.setText(this.optionAchats.getModeCalculDevis());
      Element var83 = new Element("modLibelleProd");
      this.racine.addContent(var83);
      var83.setText(this.optionAchats.getModLibelleProd());
      Element var84 = new Element("configBudStks");
      this.racine.addContent(var84);
      var84.setText(this.optionAchats.getConfigBudStks());
      Element var85 = new Element("configSitDepSerStks");
      this.racine.addContent(var85);
      var85.setText(this.optionAchats.getConfigSitDepSerStks());
      Element var86 = new Element("configRegSecPdvStks");
      this.racine.addContent(var86);
      var86.setText(this.optionAchats.getConfigRegSecPdvStks());
      Element var87 = new Element("configanal1Stks");
      this.racine.addContent(var87);
      var87.setText(this.optionAchats.getConfiganal1Stks());
      Element var88 = new Element("configanal2Stks");
      this.racine.addContent(var88);
      var88.setText(this.optionAchats.getConfiganal2Stks());
      Element var89 = new Element("configanal2Stks");
      this.racine.addContent(var89);
      var89.setText(this.optionAchats.getConfiganal3Stks());
      Element var90 = new Element("configanal4Stks");
      this.racine.addContent(var90);
      var90.setText(this.optionAchats.getConfiganal4Stks());
      Element var91 = new Element("libelle1");
      this.racine.addContent(var91);
      var91.setText(this.optionAchats.getLib1());
      Element var92 = new Element("libelle2");
      this.racine.addContent(var92);
      var92.setText(this.optionAchats.getLib2());
      Element var93 = new Element("libelle3");
      this.racine.addContent(var93);
      var93.setText(this.optionAchats.getLib3());
      Element var94 = new Element("libelle4");
      this.racine.addContent(var94);
      var94.setText(this.optionAchats.getLib4());
      Element var95 = new Element("libelle5");
      this.racine.addContent(var95);
      var95.setText(this.optionAchats.getLib5());
      Element var96 = new Element("libelle6");
      this.racine.addContent(var96);
      var96.setText(this.optionAchats.getLib6());
      Element var97 = new Element("libelle7");
      this.racine.addContent(var97);
      var97.setText(this.optionAchats.getLib7());
      Element var98 = new Element("libelle8");
      this.racine.addContent(var98);
      var98.setText(this.optionAchats.getLib8());
      Element var99 = new Element("libelle9");
      this.racine.addContent(var99);
      var99.setText(this.optionAchats.getLib9());
      Element var100 = new Element("libelle10");
      this.racine.addContent(var100);
      var100.setText(this.optionAchats.getLib10());
      Element var101 = new Element("serie1");
      this.racine.addContent(var101);
      var101.setText(this.optionAchats.getSerie1());
      Element var102 = new Element("serie2");
      this.racine.addContent(var102);
      var102.setText(this.optionAchats.getSerie2());
      Element var103 = new Element("serie3");
      this.racine.addContent(var103);
      var103.setText(this.optionAchats.getSerie3());
      Element var104 = new Element("serie4");
      this.racine.addContent(var104);
      var104.setText(this.optionAchats.getSerie4());
      Element var105 = new Element("serie5");
      this.racine.addContent(var105);
      var105.setText(this.optionAchats.getSerie5());
      Element var106 = new Element("serie6");
      this.racine.addContent(var106);
      var106.setText(this.optionAchats.getSerie6());
      Element var107 = new Element("serie7");
      this.racine.addContent(var107);
      var107.setText(this.optionAchats.getSerie7());
      Element var108 = new Element("serie8");
      this.racine.addContent(var108);
      var108.setText(this.optionAchats.getSerie8());
      Element var109 = new Element("serie9");
      this.racine.addContent(var109);
      var109.setText(this.optionAchats.getSerie9());
      Element var110 = new Element("serie10");
      this.racine.addContent(var110);
      var110.setText(this.optionAchats.getSerie10());
      Element var111 = new Element("serie11");
      this.racine.addContent(var111);
      var111.setText(this.optionAchats.getSerie11());
      Element var112 = new Element("serie12");
      this.racine.addContent(var112);
      var112.setText(this.optionAchats.getSerie12());
      Element var113 = new Element("serie13");
      this.racine.addContent(var113);
      var113.setText(this.optionAchats.getSerie13());
      Element var114 = new Element("serie14");
      this.racine.addContent(var114);
      var114.setText(this.optionAchats.getSerie14());
      Element var115 = new Element("serie15");
      this.racine.addContent(var115);
      var115.setText(this.optionAchats.getSerie15());
      Element var116 = new Element("serie16");
      this.racine.addContent(var116);
      var116.setText(this.optionAchats.getSerie16());
      Element var117 = new Element("serie17");
      this.racine.addContent(var117);
      var117.setText(this.optionAchats.getSerie17());
      Element var118 = new Element("serie18");
      this.racine.addContent(var118);
      var118.setText(this.optionAchats.getSerie18());
      Element var119 = new Element("serie19");
      this.racine.addContent(var119);
      var119.setText(this.optionAchats.getSerie19());
      Element var120 = new Element("serie20");
      this.racine.addContent(var120);
      var120.setText(this.optionAchats.getSerie20());
      Element var121 = new Element("zoneRef1");
      this.racine.addContent(var121);
      var121.setText(this.optionAchats.getZoneRef1());
      Element var122 = new Element("zoneRef2");
      this.racine.addContent(var122);
      var122.setText(this.optionAchats.getZoneRef2());
      Element var123 = new Element("zoneLibelle");
      this.racine.addContent(var123);
      var123.setText(this.optionAchats.getZoneLibelle());
      Element var124 = new Element("zoneLibelleSuite");
      this.racine.addContent(var124);
      var124.setText(this.optionAchats.getZoneLibelleSuite());
      Element var125 = new Element("zoneRef1Serie");
      this.racine.addContent(var125);
      var125.setText(this.optionAchats.getZoneRef1Serie());
      Element var126 = new Element("zoneRef2Serie");
      this.racine.addContent(var126);
      var126.setText(this.optionAchats.getZoneRef2Serie());
      Element var127 = new Element("transfertDocument");
      this.racine.addContent(var127);
      var127.setText(this.optionAchats.getTransfertDocument());
      Element var128 = new Element("axeStructure");
      this.racine.addContent(var128);
      var128.setText(this.optionAchats.getAxeStructure());
      Element var129 = new Element("axeSite");
      this.racine.addContent(var129);
      var129.setText(this.optionAchats.getAxeSite());
      Element var130 = new Element("axeRegion");
      this.racine.addContent(var130);
      var130.setText(this.optionAchats.getAxeRegion());
      Element var131 = new Element("axeUsine");
      this.racine.addContent(var131);
      var131.setText(this.optionAchats.getAxeUsine());
      Element var132 = new Element("axeActivite");
      this.racine.addContent(var132);
      var132.setText(this.optionAchats.getAxeActivite());
      Element var133 = new Element("axeAgent");
      this.racine.addContent(var133);
      var133.setText(this.optionAchats.getAxeAgent());
      Element var134 = new Element("axeChantier");
      this.racine.addContent(var134);
      var134.setText(this.optionAchats.getAxeChantier());
      Element var135 = new Element("axeParc");
      this.racine.addContent(var135);
      var135.setText(this.optionAchats.getAxeParc());
      Element var136 = new Element("axeMission");
      this.racine.addContent(var136);
      var136.setText(this.optionAchats.getAxeMission());
      Element var137 = new Element("axeCles");
      this.racine.addContent(var137);
      var137.setText(this.optionAchats.getAxeCles());
      Element var138 = new Element("axeProjet");
      this.racine.addContent(var138);
      var138.setText(this.optionAchats.getAxeProjet());
      Element var139 = new Element("axeDossier");
      this.racine.addContent(var139);
      var139.setText(this.optionAchats.getAxeDossier());
      this.enregistre();
   }

   public void creerOptionAchatsCompta(OptionAchats var1, OptionComptabilite var2) throws IOException {
      this.racine.removeContent();
      Element var3 = new Element("nbrJrRelanceDA");
      this.racine.addContent(var3);
      var3.setText("" + var1.getNbrJrRelanceDA());
      Element var4 = new Element("nbrJrValidDA");
      this.racine.addContent(var4);
      var4.setText("" + var1.getNbrJrValidDA());
      Element var5 = new Element("affichInTierFilDA");
      this.racine.addContent(var5);
      var5.setText(var1.getAffichInTierFilDA());
      Element var6 = new Element("affichInGlobViewDA");
      this.racine.addContent(var6);
      var6.setText(var1.getAffichInGlobViewDA());
      Element var7 = new Element("nbrJrRelanceCOT");
      this.racine.addContent(var7);
      var7.setText("" + var1.getNbrJrRelanceCOT());
      Element var8 = new Element("nbrJrValidCOT");
      this.racine.addContent(var8);
      var8.setText("" + var1.getNbrJrValidCOT());
      Element var9 = new Element("affichInTierFilCOT");
      this.racine.addContent(var9);
      var9.setText(var1.getAffichInTierFilCOT());
      Element var10 = new Element("affichInGlobViewCOT");
      this.racine.addContent(var10);
      var10.setText(var1.getAffichInGlobViewCOT());
      Element var11 = new Element("affichQtePoidsCOT");
      this.racine.addContent(var11);
      var11.setText(var1.getAffichQtePoidsCOT());
      Element var12 = new Element("fraisPrp1");
      this.racine.addContent(var12);
      var12.setText(var1.getFraisPrp1());
      Element var13 = new Element("fraisPrp2");
      this.racine.addContent(var13);
      var13.setText(var1.getFraisPrp2());
      Element var14 = new Element("fraisPrp3");
      this.racine.addContent(var14);
      var14.setText(var1.getFraisPrp3());
      Element var15 = new Element("tauxRusid");
      this.racine.addContent(var15);
      var15.setText("" + var1.getTauxRusid());
      Element var16 = new Element("tauxReduit");
      this.racine.addContent(var16);
      var16.setText("" + var1.getTauxReduit());
      Element var17 = new Element("nbrJrRelanceCOM");
      this.racine.addContent(var17);
      var17.setText("" + var1.getNbrJrRelanceCOM());
      Element var18 = new Element("nbrJrValidCOM");
      this.racine.addContent(var18);
      var18.setText("" + var1.getNbrJrValidCOM());
      Element var19 = new Element("affichInTierFilCOM");
      this.racine.addContent(var19);
      var19.setText(var1.getAffichInTierFilCOM());
      Element var20 = new Element("affichInGlobViewCOM");
      this.racine.addContent(var20);
      var20.setText(var1.getAffichInGlobViewCOM());
      Element var21 = new Element("affichQtePoidsCOM");
      this.racine.addContent(var21);
      var21.setText(var1.getAffichQtePoidsCOM());
      Element var22 = new Element("budgetCOM");
      this.racine.addContent(var22);
      var22.setText(var1.getBudgetCOM());
      Element var23 = new Element("qteDejaCOM");
      this.racine.addContent(var23);
      var23.setText(var1.getQteDejaCOM());
      Element var24 = new Element("nbrJrRelanceREC");
      this.racine.addContent(var24);
      var24.setText("" + var1.getNbrJrRelanceREC());
      Element var25 = new Element("nbrJrValidREC");
      this.racine.addContent(var25);
      var25.setText("" + var1.getNbrJrValidREC());
      Element var26 = new Element("affichInTierFilREC");
      this.racine.addContent(var26);
      var26.setText(var1.getAffichInTierFilREC());
      Element var27 = new Element("affichInGlobViewREC");
      this.racine.addContent(var27);
      var27.setText(var1.getAffichInGlobViewREC());
      Element var28 = new Element("affichQtePoidsREC");
      this.racine.addContent(var28);
      var28.setText(var1.getAffichQtePoidsREC());
      Element var29 = new Element("reacheminementREC");
      this.racine.addContent(var29);
      var29.setText(var1.getReacheminementREC());
      Element var30 = new Element("modeCifCfrREC");
      this.racine.addContent(var30);
      var30.setText(var1.getModeCifCfrREC());
      Element var31 = new Element("numeroReception");
      this.racine.addContent(var31);
      var31.setText(var1.getNumeroReception());
      Element var32 = new Element("nbrJrRelanceFAC");
      this.racine.addContent(var32);
      var32.setText("" + var1.getNbrJrRelanceFAC());
      Element var33 = new Element("nbrJrValidFAC");
      this.racine.addContent(var33);
      var33.setText("" + var1.getNbrJrValidFAC());
      Element var34 = new Element("affichInTierFilFAC");
      this.racine.addContent(var34);
      var34.setText(var1.getAffichInTierFilFAC());
      Element var35 = new Element("affichInGlobViewFAC");
      this.racine.addContent(var35);
      var35.setText(var1.getAffichInGlobViewFAC());
      Element var36 = new Element("modeCifCfrFAC");
      this.racine.addContent(var36);
      var36.setText(var1.getModeCifCfrFAC());
      Element var37 = new Element("compteFretFAC");
      this.racine.addContent(var37);
      var37.setText(var1.getCompteFretFAC());
      Element var38 = new Element("compteAssuranceFAC");
      this.racine.addContent(var38);
      var38.setText(var1.getCompteAssuranceFAC());
      Element var39 = new Element("nbrJrRelanceNOTDEB");
      this.racine.addContent(var39);
      var39.setText("" + var1.getNbrJrRelanceNOTDEB());
      Element var40 = new Element("nbrJrValidNOTDEB");
      this.racine.addContent(var40);
      var40.setText("" + var1.getNbrJrValidNOTDEB());
      Element var41 = new Element("affichInTierFilNOTDEB");
      this.racine.addContent(var41);
      var41.setText(var1.getAffichInTierFilNOTDEB());
      Element var42 = new Element("affichInGlobViewNOTDEB");
      this.racine.addContent(var42);
      var42.setText(var1.getAffichInGlobViewNOTDEB());
      Element var43 = new Element("nbrJrRelanceAVOIR");
      this.racine.addContent(var43);
      var43.setText("" + var1.getNbrJrRelanceAVOIR());
      Element var44 = new Element("nbrJrValidAVOIR");
      this.racine.addContent(var44);
      var44.setText("" + var1.getNbrJrValidAVOIR());
      Element var45 = new Element("affichInTierFilAVOIR");
      this.racine.addContent(var45);
      var45.setText(var1.getAffichInTierFilAVOIR());
      Element var46 = new Element("affichInGlobViewAVOIR");
      this.racine.addContent(var46);
      var46.setText(var1.getAffichInGlobViewAVOIR());
      Element var47 = new Element("nbrJrRelanceRETOUR");
      this.racine.addContent(var47);
      var47.setText("" + var1.getNbrJrRelanceRETOUR());
      Element var48 = new Element("nbrJrValidRETOUR");
      this.racine.addContent(var48);
      var48.setText("" + var1.getNbrJrValidRETOUR());
      new Element("anal1RETOUR");
      Element var50 = new Element("affichInTierFilRETOUR");
      this.racine.addContent(var50);
      var50.setText(var1.getAffichInTierFilRETOUR());
      Element var51 = new Element("affichInGlobViewRETOUR");
      this.racine.addContent(var51);
      var51.setText(var1.getAffichInGlobViewRETOUR());
      Element var52 = new Element("nbrJrRelanceFRA");
      this.racine.addContent(var52);
      var52.setText("" + var1.getNbrJrRelanceFRA());
      Element var53 = new Element("nbrJrValidFRA");
      this.racine.addContent(var53);
      var53.setText("" + var1.getNbrJrValidFRA());
      Element var54 = new Element("affichInTierFilFRA");
      this.racine.addContent(var54);
      var54.setText(var1.getAffichInTierFilFRA());
      Element var55 = new Element("affichInGlobViewFRA");
      this.racine.addContent(var55);
      var55.setText(var1.getAffichInGlobViewFRA());
      Element var56 = new Element("chargerFRA");
      this.racine.addContent(var56);
      var56.setText(var1.getChargerFRA());
      Element var57 = new Element("affichInGlobViewAffaire");
      this.racine.addContent(var57);
      var57.setText(var1.getAffichInGlobViewAffaire());
      Element var58 = new Element("affichInTierAffaire");
      this.racine.addContent(var58);
      var58.setText(var1.getAffichInTierAffaire());
      Element var59 = new Element("nbrCtrsProProd");
      this.racine.addContent(var59);
      var59.setText("" + var1.getNbrCtrsProProd());
      Element var60 = new Element("nbrCtrsFamProd");
      this.racine.addContent(var60);
      var60.setText("" + var1.getNbrCtrsFamProd());
      Element var61 = new Element("modCalcProd");
      this.racine.addContent(var61);
      var61.setText(var1.getModCalcProd());
      Element var62 = new Element("modCoefPr");
      this.racine.addContent(var62);
      var62.setText(var1.getModCoefPr());
      Element var63 = new Element("modCalcPr");
      this.racine.addContent(var63);
      var63.setText(var1.getModCalcPr());
      Element var64 = new Element("modCalcPump");
      this.racine.addContent(var64);
      var64.setText(var1.getModCalcPump());
      Element var65 = new Element("modDepPump");
      this.racine.addContent(var65);
      var65.setText(var1.getModDepPump());
      Element var66 = new Element("modValoPvProd");
      this.racine.addContent(var66);
      var66.setText(var1.getModValoPvProd());
      Element var67 = new Element("modValoFret");
      this.racine.addContent(var67);
      var67.setText(var1.getModValoFret());
      Element var68 = new Element("decrmtRabais");
      this.racine.addContent(var68);
      var68.setText(var1.getDecrmtRabais());
      Element var69 = new Element("analAuto");
      this.racine.addContent(var69);
      var69.setText(var1.getAnalAuto());
      Element var70 = new Element("nbLigneMax");
      this.racine.addContent(var70);
      var70.setText(var1.getNbLigneMax());
      Element var71 = new Element("nbDecQte");
      this.racine.addContent(var71);
      var71.setText(var1.getNbDecQte());
      Element var72 = new Element("nbDecPu");
      this.racine.addContent(var72);
      var72.setText(var1.getNbDecPu());
      Element var73 = new Element("trfCompta");
      this.racine.addContent(var73);
      var73.setText(var1.getTrfCompta());
      Element var74 = new Element("chargementListe");
      this.racine.addContent(var74);
      var74.setText(var1.getChargementListe());
      Element var75 = new Element("activiteEnteteLigne");
      this.racine.addContent(var75);
      var75.setText(var1.getActiviteEnteteLigne());
      Element var76 = new Element("descriptifComplementaire");
      this.racine.addContent(var76);
      var76.setText(var1.getDescriptifComplementaire());
      Element var77 = new Element("dateTransformation");
      this.racine.addContent(var77);
      var77.setText(var1.getDateTransformation());
      Element var78 = new Element("photosProduit");
      this.racine.addContent(var78);
      var78.setText(var1.getPhotosProduit());
      Element var79 = new Element("choixStock");
      this.racine.addContent(var79);
      var79.setText(var1.getChoixStock());
      Element var80 = new Element("tvaDefaut");
      this.racine.addContent(var80);
      var80.setText(var1.getTvaDefaut());
      Element var81 = new Element("paiementAVOIR");
      this.racine.addContent(var81);
      var81.setText(var1.getPaiementAVOIR());
      Element var82 = new Element("transformation");
      this.racine.addContent(var82);
      var82.setText(var1.getTransformation());
      Element var83 = new Element("depotStock");
      this.racine.addContent(var83);
      var83.setText(var1.getDepotStock());
      Element var84 = new Element("modeCalculDevis");
      this.racine.addContent(var84);
      var84.setText(var1.getModeCalculDevis());
      Element var85 = new Element("modLibelleProd");
      this.racine.addContent(var85);
      var85.setText(var1.getModLibelleProd());
      Element var86 = new Element("configBudStks");
      this.racine.addContent(var86);
      var86.setText(var1.getConfigBudStks());
      Element var87 = new Element("configSitDepSerStks");
      this.racine.addContent(var87);
      var87.setText(var1.getConfigSitDepSerStks());
      Element var88 = new Element("configRegSecPdvStks");
      this.racine.addContent(var88);
      var88.setText(var1.getConfigRegSecPdvStks());
      Element var89 = new Element("configanal1Stks");
      this.racine.addContent(var89);
      var89.setText(var1.getConfiganal1Stks());
      Element var90 = new Element("configanal2Stks");
      this.racine.addContent(var90);
      var90.setText(var1.getConfiganal2Stks());
      Element var91 = new Element("configanal2Stks");
      this.racine.addContent(var91);
      var91.setText(var1.getConfiganal3Stks());
      Element var92 = new Element("configanal4Stks");
      this.racine.addContent(var92);
      var92.setText(var1.getConfiganal4Stks());
      Element var93 = new Element("libelle1");
      this.racine.addContent(var93);
      var93.setText(var1.getLib1());
      Element var94 = new Element("libelle2");
      this.racine.addContent(var94);
      var94.setText(var1.getLib2());
      Element var95 = new Element("libelle3");
      this.racine.addContent(var95);
      var95.setText(var1.getLib3());
      Element var96 = new Element("libelle4");
      this.racine.addContent(var96);
      var96.setText(var1.getLib4());
      Element var97 = new Element("libelle5");
      this.racine.addContent(var97);
      var97.setText(var1.getLib5());
      Element var98 = new Element("libelle6");
      this.racine.addContent(var98);
      var98.setText(var1.getLib6());
      Element var99 = new Element("libelle7");
      this.racine.addContent(var99);
      var99.setText(var1.getLib7());
      Element var100 = new Element("libelle8");
      this.racine.addContent(var100);
      var100.setText(var1.getLib8());
      Element var101 = new Element("libelle9");
      this.racine.addContent(var101);
      var101.setText(var1.getLib9());
      Element var102 = new Element("libelle10");
      this.racine.addContent(var102);
      var102.setText(var1.getLib10());
      Element var103 = new Element("serie1");
      this.racine.addContent(var103);
      var103.setText(var1.getSerie1());
      Element var104 = new Element("serie2");
      this.racine.addContent(var104);
      var104.setText(var1.getSerie2());
      Element var105 = new Element("serie3");
      this.racine.addContent(var105);
      var105.setText(var1.getSerie3());
      Element var106 = new Element("serie4");
      this.racine.addContent(var106);
      var106.setText(var1.getSerie4());
      Element var107 = new Element("serie5");
      this.racine.addContent(var107);
      var107.setText(var1.getSerie5());
      Element var108 = new Element("serie6");
      this.racine.addContent(var108);
      var108.setText(var1.getSerie6());
      Element var109 = new Element("serie7");
      this.racine.addContent(var109);
      var109.setText(var1.getSerie7());
      Element var110 = new Element("serie8");
      this.racine.addContent(var110);
      var110.setText(var1.getSerie8());
      Element var111 = new Element("serie9");
      this.racine.addContent(var111);
      var111.setText(var1.getSerie9());
      Element var112 = new Element("serie10");
      this.racine.addContent(var112);
      var112.setText(var1.getSerie10());
      Element var113 = new Element("serie11");
      this.racine.addContent(var113);
      var113.setText(var1.getSerie11());
      Element var114 = new Element("serie12");
      this.racine.addContent(var114);
      var114.setText(var1.getSerie12());
      Element var115 = new Element("serie13");
      this.racine.addContent(var115);
      var115.setText(var1.getSerie13());
      Element var116 = new Element("serie14");
      this.racine.addContent(var116);
      var116.setText(var1.getSerie14());
      Element var117 = new Element("serie15");
      this.racine.addContent(var117);
      var117.setText(var1.getSerie15());
      Element var118 = new Element("serie16");
      this.racine.addContent(var118);
      var118.setText(var1.getSerie16());
      Element var119 = new Element("serie17");
      this.racine.addContent(var119);
      var119.setText(var1.getSerie17());
      Element var120 = new Element("serie18");
      this.racine.addContent(var120);
      var120.setText(var1.getSerie18());
      Element var121 = new Element("serie19");
      this.racine.addContent(var121);
      var121.setText(var1.getSerie19());
      Element var122 = new Element("serie20");
      this.racine.addContent(var122);
      var122.setText(var1.getSerie20());
      Element var123 = new Element("zoneRef1");
      this.racine.addContent(var123);
      var123.setText(var1.getZoneRef1());
      Element var124 = new Element("zoneRef2");
      this.racine.addContent(var124);
      var124.setText(var1.getZoneRef2());
      Element var125 = new Element("zoneLibelle");
      this.racine.addContent(var125);
      var125.setText(var1.getZoneLibelle());
      Element var126 = new Element("zoneLibelleSuite");
      this.racine.addContent(var126);
      var126.setText(var1.getZoneLibelleSuite());
      Element var127 = new Element("zoneRef1Serie");
      this.racine.addContent(var127);
      var127.setText(var1.getZoneRef1Serie());
      Element var128 = new Element("zoneRef2Serie");
      this.racine.addContent(var128);
      var128.setText(var1.getZoneRef2Serie());
      Element var129 = new Element("transfertDocument");
      this.racine.addContent(var129);
      var129.setText(var1.getTransfertDocument());
      Element var130 = new Element("axeStructure");
      this.racine.addContent(var130);
      var130.setText(var1.getAxeStructure());
      Element var131 = new Element("axeSite");
      this.racine.addContent(var131);
      var131.setText(var1.getAxeSite());
      Element var132 = new Element("axeRegion");
      this.racine.addContent(var132);
      var132.setText(var1.getAxeRegion());
      Element var133 = new Element("axeUsine");
      this.racine.addContent(var133);
      var133.setText(var1.getAxeUsine());
      Element var134 = new Element("axeActivite");
      this.racine.addContent(var134);
      var134.setText(var1.getAxeActivite());
      Element var135 = new Element("axeAgent");
      this.racine.addContent(var135);
      var135.setText(var1.getAxeAgent());
      Element var136 = new Element("axeChantier");
      this.racine.addContent(var136);
      var136.setText(var1.getAxeChantier());
      Element var137 = new Element("axeParc");
      this.racine.addContent(var137);
      var137.setText(var1.getAxeParc());
      Element var138 = new Element("axeMission");
      this.racine.addContent(var138);
      var138.setText(var1.getAxeMission());
      Element var139 = new Element("axeCles");
      this.racine.addContent(var139);
      var139.setText(var1.getAxeCles());
      Element var140 = new Element("axeProjet");
      this.racine.addContent(var140);
      var140.setText(var1.getAxeProjet());
      Element var141 = new Element("axeDossier");
      this.racine.addContent(var141);
      var141.setText(var1.getAxeDossier());
      this.enregistre();
   }

   public void enregistre() throws FileNotFoundException, IOException {
      XMLOutputter var1 = new XMLOutputter(Format.getPrettyFormat());
      FileOutputStream var2 = new FileOutputStream(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.structureLog.getStrid() + File.separator + "achats" + File.separator + "configuration" + File.separator + "optionAchats.xml");
      var1.output(this.getDocument(), var2);
      var2.close();
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

   public OptionAchats getOptionAchats() {
      return this.optionAchats;
   }

   public void setOptionAchats(OptionAchats var1) {
      this.optionAchats = var1;
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

   public boolean isMajOptionVentes() {
      return this.majOptionVentes;
   }

   public void setMajOptionVentes(boolean var1) {
      this.majOptionVentes = var1;
   }

   public boolean isMajOptionMedical() {
      return this.majOptionMedical;
   }

   public void setMajOptionMedical(boolean var1) {
      this.majOptionMedical = var1;
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

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public List getMesTvaItem() {
      return this.mesTvaItem;
   }

   public void setMesTvaItem(List var1) {
      this.mesTvaItem = var1;
   }
}
