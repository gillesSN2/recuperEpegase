package com.epegase.systeme.xml;

import com.epegase.systeme.util.StaticModePegase;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class LireLesoptionsPaye implements Serializable {
   private long strId;
   private OptionPaye optionsPaye;

   public OptionPaye lancer() {
      if (this.optionsPaye == null) {
         this.optionsPaye = new OptionPaye();
      }

      try {
         SAXBuilder var1 = new SAXBuilder();
         File var2 = new File(StaticModePegase.getCheminContext() + File.separator + "clients" + File.separator + "structure" + this.strId + File.separator + "paye" + File.separator + "configuration" + File.separator + "optionsPaye.xml");
         FileReader var3 = new FileReader(var2);
         Document var4 = var1.build(var3);
         Element var5 = var4.getRootElement();
         if (var5.getChildText("nbLigneMax") != null && !var5.getChildText("nbLigneMax").isEmpty()) {
            this.optionsPaye.setNbLigneMax(var5.getChildText("nbLigneMax"));
         } else {
            this.optionsPaye.setNbLigneMax("100");
         }

         if (var5.getChildText("chargementListe") != null && !var5.getChildText("chargementListe").isEmpty()) {
            this.optionsPaye.setChargementListe(var5.getChildText("chargementListe"));
         } else {
            this.optionsPaye.setChargementListe("0");
         }

         if (var5.getChildText("calculRegularisation") != null && !var5.getChildText("calculRegularisation").isEmpty()) {
            this.optionsPaye.setCalculRegularisation(var5.getChildText("calculRegularisation"));
         } else {
            this.optionsPaye.setCalculRegularisation("0");
         }

         this.optionsPaye.setPlafond(var5.getChildText("plafond"));
         if (var5.getChildText("arrondiNet") != null && !var5.getChildText("arrondiNet").isEmpty()) {
            this.optionsPaye.setArrondiNet(var5.getChildText("arrondiNet"));
         } else {
            this.optionsPaye.setArrondiNet("0");
         }

         if (var5.getChildText("triAgents") != null && !var5.getChildText("triAgents").isEmpty()) {
            this.optionsPaye.setTriAgents(var5.getChildText("triAgents"));
         } else {
            this.optionsPaye.setTriAgents("0");
         }

         if (var5.getChildText("chronoMatricule") != null && !var5.getChildText("chronoMatricule").isEmpty()) {
            this.optionsPaye.setChronoMatricule(var5.getChildText("chronoMatricule"));
         } else {
            this.optionsPaye.setChronoMatricule("0");
         }

         if (var5.getChildText("modeTravail") != null && !var5.getChildText("modeTravail").isEmpty()) {
            this.optionsPaye.setModeTravail(var5.getChildText("modeTravail"));
         } else {
            this.optionsPaye.setModeTravail("0");
         }

         if (var5.getChildText("triModeTravail") != null && !var5.getChildText("triModeTravail").isEmpty()) {
            this.optionsPaye.setTriModeTravail(var5.getChildText("triModeTravail"));
         } else {
            this.optionsPaye.setTriModeTravail("0");
         }

         double var6 = 0.0D;
         if (var5.getChildText("securiteSocialeGene") != null && !var5.getChildText("securiteSocialeGene").isEmpty()) {
            var6 = Double.parseDouble(var5.getChildText("securiteSocialeGene"));
         }

         this.optionsPaye.setSecuriteSocialeGene(var6);
         double var8 = 0.0D;
         if (var5.getChildText("securiteSocialeCadre") != null && !var5.getChildText("securiteSocialeCadre").isEmpty()) {
            var8 = Double.parseDouble(var5.getChildText("securiteSocialeCadre"));
         }

         this.optionsPaye.setSecuriteSocialeCadre(var8);
         double var10 = 0.0D;
         if (var5.getChildText("cnamgs") != null && !var5.getChildText("cnamgs").isEmpty()) {
            var10 = Double.parseDouble(var5.getChildText("cnamgs"));
         }

         this.optionsPaye.setCnamgs(var10);
         float var12 = 0.0F;
         if (var5.getChildText("tauxcnamgsPS") != null && !var5.getChildText("tauxcnamgsPS").isEmpty()) {
            var12 = Float.parseFloat(var5.getChildText("tauxcnamgsPS"));
         }

         this.optionsPaye.setTauxcnamgsPS((double)var12);
         float var13 = 0.0F;
         if (var5.getChildText("tauxcnamgsPP") != null && !var5.getChildText("tauxcnamgsPP").isEmpty()) {
            var13 = Float.parseFloat(var5.getChildText("tauxcnamgsPP"));
         }

         this.optionsPaye.setTauxcnamgsPP((double)var13);
         float var14 = 0.0F;
         if (var5.getChildText("tauxcnssPS") != null && !var5.getChildText("tauxcnssPS").isEmpty()) {
            var14 = Float.parseFloat(var5.getChildText("tauxcnssPS"));
         }

         this.optionsPaye.setTauxcnssPS((double)var14);
         float var15 = 0.0F;
         if (var5.getChildText("tauxcnssPP") != null && !var5.getChildText("tauxcnssPP").isEmpty()) {
            var15 = Float.parseFloat(var5.getChildText("tauxcnssPP"));
         }

         this.optionsPaye.setTauxcnssPP((double)var15);
         float var16 = 0.0F;
         if (var5.getChildText("tauxfnhPP") != null && !var5.getChildText("tauxfnhPP").isEmpty()) {
            var16 = Float.parseFloat(var5.getChildText("tauxfnhPP"));
         }

         this.optionsPaye.setTauxfnhPP((double)var16);
         float var17 = 0.0F;
         if (var5.getChildText("tauxcfpPP") != null && !var5.getChildText("tauxcfpPP").isEmpty()) {
            var17 = Float.parseFloat(var5.getChildText("tauxcfpPP"));
         }

         this.optionsPaye.setTauxcfpPP((double)var17);
         float var18 = 0.0F;
         if (var5.getChildText("tauxipressGenePS") != null && !var5.getChildText("tauxipressGenePS").isEmpty()) {
            var18 = Float.parseFloat(var5.getChildText("tauxipressGenePS"));
         }

         this.optionsPaye.setTauxipressGenePS((double)var18);
         float var19 = 0.0F;
         if (var5.getChildText("tauxipressGenePP") != null && !var5.getChildText("tauxipressGenePP").isEmpty()) {
            var19 = Float.parseFloat(var5.getChildText("tauxipressGenePP"));
         }

         this.optionsPaye.setTauxipressGenePP((double)var19);
         float var20 = 0.0F;
         if (var5.getChildText("tauxipressCadrePS") != null && !var5.getChildText("tauxipressCadrePS").isEmpty()) {
            var20 = Float.parseFloat(var5.getChildText("tauxipressCadrePS"));
         }

         this.optionsPaye.setTauxipressCadrePS((double)var20);
         float var21 = 0.0F;
         if (var5.getChildText("tauxipressCadrePP") != null && !var5.getChildText("tauxipressCadrePP").isEmpty()) {
            var21 = Float.parseFloat(var5.getChildText("tauxipressCadrePP"));
         }

         this.optionsPaye.setTauxipressCadrePP((double)var21);
         float var22 = 0.0F;
         if (var5.getChildText("tauxcfcePP") != null && !var5.getChildText("tauxcfcePP").isEmpty()) {
            var22 = Float.parseFloat(var5.getChildText("tauxcfcePP"));
         }

         this.optionsPaye.setTauxcfcePP((double)var22);
         double var23 = 0.0D;
         if (var5.getChildText("cotisationSocialeGene") != null && !var5.getChildText("cotisationSocialeGene").isEmpty()) {
            var23 = Double.parseDouble(var5.getChildText("cotisationSocialeGene"));
         }

         this.optionsPaye.setCotisationSocialeGene(var23);
         double var25 = 0.0D;
         if (var5.getChildText("prestationMedicaleGene") != null && !var5.getChildText("prestationMedicaleGene").isEmpty()) {
            var25 = Double.parseDouble(var5.getChildText("prestationMedicaleGene"));
         }

         this.optionsPaye.setPrestationMedicaleGene(var25);
         double var27 = 0.0D;
         if (var5.getChildText("smig") != null && !var5.getChildText("smig").isEmpty()) {
            var27 = Double.parseDouble(var5.getChildText("smig"));
         }

         this.optionsPaye.setSmig(var27);
         if (var5.getChildText("trimf") != null && !var5.getChildText("trimf").isEmpty()) {
            this.optionsPaye.setTrimf(var5.getChildText("trimf"));
         } else {
            this.optionsPaye.setTrimf("0");
         }

         float var29 = 0.0F;
         if (var5.getChildText("tauxtusPP") != null && !var5.getChildText("tauxtusPP").isEmpty()) {
            var29 = Float.parseFloat(var5.getChildText("tauxtusPP"));
         }

         this.optionsPaye.setTauxtusPP((double)var29);
         double var30 = 0.0D;
         if (var5.getChildText("taxeTolCv") != null && !var5.getChildText("taxeTolCv").isEmpty()) {
            var30 = Double.parseDouble(var5.getChildText("taxeTolCv"));
         }

         this.optionsPaye.setTaxeTolCv(var30);
         double var32 = 0.0D;
         if (var5.getChildText("taxeTolPeriph") != null && !var5.getChildText("taxeTolPeriph").isEmpty()) {
            var32 = Double.parseDouble(var5.getChildText("taxeTolPeriph"));
         }

         this.optionsPaye.setTaxeTolPeriph(var32);
         double var34 = 0.0D;
         if (var5.getChildText("nbEnfantAllocation") != null && !var5.getChildText("nbEnfantAllocation").isEmpty()) {
            var34 = Double.parseDouble(var5.getChildText("nbEnfantAllocation"));
         }

         this.optionsPaye.setNbEnfantAllocation(var34);
         float var36 = 0.0F;
         if (var5.getChildText("tauxcsspfPP") != null && !var5.getChildText("tauxcsspfPP").isEmpty()) {
            var36 = Float.parseFloat(var5.getChildText("tauxcsspfPP"));
         }

         this.optionsPaye.setTauxcsspfPP((double)var36);
         float var37 = 0.0F;
         if (var5.getChildText("tauxcssatPP") != null && !var5.getChildText("tauxcssatPP").isEmpty()) {
            var37 = Float.parseFloat(var5.getChildText("tauxcssatPP"));
         }

         this.optionsPaye.setTauxcssatPP((double)var37);
         float var38 = 0.0F;
         if (var5.getChildText("tauxAt") != null && !var5.getChildText("tauxAt").isEmpty()) {
            var38 = Float.parseFloat(var5.getChildText("tauxAt"));
         }

         this.optionsPaye.setTauxAt((double)var38);
         float var39 = 0.0F;
         if (var5.getChildText("tauxPf") != null && !var5.getChildText("tauxPf").isEmpty()) {
            var39 = Float.parseFloat(var5.getChildText("tauxPf"));
         }

         this.optionsPaye.setTauxPf((double)var39);
         float var40 = 0.0F;
         if (var5.getChildText("eloignementExpat") != null && !var5.getChildText("eloignementExpat").isEmpty()) {
            var40 = Float.parseFloat(var5.getChildText("eloignementExpat"));
         }

         this.optionsPaye.setEloignementExpat((double)var40);
         double var41 = 0.0D;
         if (var5.getChildText("eloignementLocal") != null && !var5.getChildText("eloignementLocal").isEmpty()) {
            var41 = Double.parseDouble(var5.getChildText("eloignementLocal"));
         }

         this.optionsPaye.setEloignementLocal(var41);
         this.optionsPaye.setRubVersement(var5.getChildText("rubVersement"));
         this.optionsPaye.setRubSpontanee(var5.getChildText("rubSpontanee"));
         this.optionsPaye.setRubRetrait(var5.getChildText("rubRetrait"));
         double var43 = 0.0D;
         if (var5.getChildText("heurejournee") != null && !var5.getChildText("heurejournee").isEmpty()) {
            var43 = Double.parseDouble(var5.getChildText("heurejournee"));
         }

         this.optionsPaye.setHeurejournee(var43);
         double var45 = 0.0D;
         if (var5.getChildText("heuredemijournee") != null && !var5.getChildText("heuredemijournee").isEmpty()) {
            var45 = Double.parseDouble(var5.getChildText("heuredemijournee"));
         }

         this.optionsPaye.setHeuredemijournee(var45);
         this.optionsPaye.setDossierExport(var5.getChildText("dossierExport"));
         if (var5.getChildText("echeanceprets") != null && !var5.getChildText("echeanceprets").isEmpty()) {
            this.optionsPaye.setEcheanceprets(var5.getChildText("echeanceprets"));
         } else {
            this.optionsPaye.setEcheanceprets("0");
         }

         if (var5.getChildText("baseconges") != null && !var5.getChildText("baseconges").isEmpty()) {
            this.optionsPaye.setBaseconges(var5.getChildText("baseconges"));
         } else {
            this.optionsPaye.setBaseconges("0");
         }

         if (var5.getChildText("nbEnfantsFiscaux") != null && !var5.getChildText("nbEnfantsFiscaux").isEmpty()) {
            this.optionsPaye.setNbEnfantsFiscaux(var5.getChildText("nbEnfantsFiscaux"));
         } else {
            this.optionsPaye.setNbEnfantsFiscaux("0");
         }

         this.optionsPaye.setRubQuinzaine(var5.getChildText("rubQuinzaine"));
         if (var5.getChildText("societeInterim") != null && !var5.getChildText("societeInterim").isEmpty()) {
            this.optionsPaye.setSocieteInterim(var5.getChildText("societeInterim"));
         } else {
            this.optionsPaye.setSocieteInterim("0");
         }

         if (var5.getChildText("axeStructure") != null && !var5.getChildText("axeStructure").isEmpty()) {
            this.optionsPaye.setAxeStructure(var5.getChildText("axeStructure"));
         } else {
            this.optionsPaye.setAxeStructure("false");
         }

         if (var5.getChildText("axeSite") != null && !var5.getChildText("axeSite").isEmpty()) {
            this.optionsPaye.setAxeSite(var5.getChildText("axeSite"));
         } else {
            this.optionsPaye.setAxeSite("false");
         }

         if (var5.getChildText("axeRegion") != null && !var5.getChildText("axeRegion").isEmpty()) {
            this.optionsPaye.setAxeRegion(var5.getChildText("axeRegion"));
         } else {
            this.optionsPaye.setAxeRegion("false");
         }

         if (var5.getChildText("axeUsine") != null && !var5.getChildText("axeUsine").isEmpty()) {
            this.optionsPaye.setAxeUsine(var5.getChildText("axeUsine"));
         } else {
            this.optionsPaye.setAxeUsine("false");
         }

         if (var5.getChildText("axeActivite") != null && !var5.getChildText("axeActivite").isEmpty()) {
            this.optionsPaye.setAxeActivite(var5.getChildText("axeActivite"));
         } else {
            this.optionsPaye.setAxeActivite("false");
         }

         if (var5.getChildText("axeAgent") != null && !var5.getChildText("axeAgent").isEmpty()) {
            this.optionsPaye.setAxeAgent(var5.getChildText("axeAgent"));
         } else {
            this.optionsPaye.setAxeAgent("false");
         }

         if (var5.getChildText("axeChantier") != null && !var5.getChildText("axeChantier").isEmpty()) {
            this.optionsPaye.setAxeChantier(var5.getChildText("axeChantier"));
         } else {
            this.optionsPaye.setAxeChantier("false");
         }

         if (var5.getChildText("axeParc") != null && !var5.getChildText("axeParc").isEmpty()) {
            this.optionsPaye.setAxeParc(var5.getChildText("axeParc"));
         } else {
            this.optionsPaye.setAxeParc("false");
         }

         if (var5.getChildText("axeMission") != null && !var5.getChildText("axeMission").isEmpty()) {
            this.optionsPaye.setAxeMission(var5.getChildText("axeMission"));
         } else {
            this.optionsPaye.setAxeMission("false");
         }

         if (var5.getChildText("axeCles") != null && !var5.getChildText("axeCles").isEmpty()) {
            this.optionsPaye.setAxeCles(var5.getChildText("axeCles"));
         } else {
            this.optionsPaye.setAxeCles("false");
         }

         if (var5.getChildText("axeProjet") != null && !var5.getChildText("axeProjet").isEmpty()) {
            this.optionsPaye.setAxeProjet(var5.getChildText("axeProjet"));
         } else {
            this.optionsPaye.setAxeProjet("false");
         }

         if (var5.getChildText("axeDossier") != null && !var5.getChildText("axeDossier").isEmpty()) {
            this.optionsPaye.setAxeDossier(var5.getChildText("axeDossier"));
         } else {
            this.optionsPaye.setAxeDossier("0");
         }

         if (var5.getChildText("trfCptePaye") != null && !var5.getChildText("trfCptePaye").isEmpty()) {
            this.optionsPaye.setTrfCptePaye(var5.getChildText("trfCptePaye"));
         } else {
            this.optionsPaye.setTrfCptePaye("0");
         }

         if (var5.getChildText("exportOd") != null && !var5.getChildText("exportOd").isEmpty()) {
            this.optionsPaye.setExportOd(var5.getChildText("exportOd"));
         } else {
            this.optionsPaye.setExportOd("0");
         }

         if (var5.getChildText("nbcrExport") != null && !var5.getChildText("nbcrExport").isEmpty()) {
            this.optionsPaye.setNbcrExport(var5.getChildText("nbcrExport"));
         } else {
            this.optionsPaye.setNbcrExport("0");
         }

         if (var5.getChildText("nbcrTiersExport") != null && !var5.getChildText("nbcrTiersExport").isEmpty()) {
            this.optionsPaye.setNbcrTiersExport(var5.getChildText("nbcrTiersExport"));
         } else {
            this.optionsPaye.setNbcrTiersExport("0");
         }

         this.optionsPaye.setPrefixeTiersExport(var5.getChildText("prefixeTiersExport"));
         if (var5.getChildText("pointage") != null && !var5.getChildText("pointage").isEmpty()) {
            this.optionsPaye.setPointage(var5.getChildText("pointage"));
         } else {
            this.optionsPaye.setPointage("0");
         }

         if (var5.getChildText("temps") != null && !var5.getChildText("temps").isEmpty()) {
            this.optionsPaye.setTemps(var5.getChildText("temps"));
         } else {
            this.optionsPaye.setTemps("0");
         }

         var3.close();
      } catch (JDOMException var47) {
      } catch (IOException var48) {
      }

      return this.optionsPaye;
   }

   public OptionPaye lancerDefaut(String var1) {
      if (this.optionsPaye == null) {
         this.optionsPaye = new OptionPaye();
      }

      try {
         SAXBuilder var2 = new SAXBuilder();
         File var3 = new File(StaticModePegase.getCheminContext() + File.separator + "configuration" + File.separator + "paye" + File.separator + "optionsPaye" + File.separator + "optionsPaye_" + var1 + ".xml");
         FileReader var4 = new FileReader(var3);
         Document var5 = var2.build(var4);
         Element var6 = var5.getRootElement();
         if (var6.getChildText("nbLigneMax") != null && !var6.getChildText("nbLigneMax").isEmpty()) {
            this.optionsPaye.setNbLigneMax(var6.getChildText("nbLigneMax"));
         } else {
            this.optionsPaye.setNbLigneMax("100");
         }

         if (var6.getChildText("chargementListe") != null && !var6.getChildText("chargementListe").isEmpty()) {
            this.optionsPaye.setChargementListe(var6.getChildText("chargementListe"));
         } else {
            this.optionsPaye.setChargementListe("0");
         }

         if (var6.getChildText("calculRegularisation") != null && !var6.getChildText("calculRegularisation").isEmpty()) {
            this.optionsPaye.setCalculRegularisation(var6.getChildText("calculRegularisation"));
         } else {
            this.optionsPaye.setCalculRegularisation("0");
         }

         this.optionsPaye.setPlafond(var6.getChildText("plafond"));
         if (var6.getChildText("arrondiNet") != null && !var6.getChildText("arrondiNet").isEmpty()) {
            this.optionsPaye.setArrondiNet(var6.getChildText("arrondiNet"));
         } else {
            this.optionsPaye.setArrondiNet("0");
         }

         if (var6.getChildText("triAgents") != null && !var6.getChildText("triAgents").isEmpty()) {
            this.optionsPaye.setTriAgents(var6.getChildText("triAgents"));
         } else {
            this.optionsPaye.setTriAgents("0");
         }

         if (var6.getChildText("chronoMatricule") != null && !var6.getChildText("chronoMatricule").isEmpty()) {
            this.optionsPaye.setChronoMatricule(var6.getChildText("chronoMatricule"));
         } else {
            this.optionsPaye.setChronoMatricule("0");
         }

         if (var6.getChildText("modeTravail") != null && !var6.getChildText("modeTravail").isEmpty()) {
            this.optionsPaye.setModeTravail(var6.getChildText("modeTravail"));
         } else {
            this.optionsPaye.setModeTravail("0");
         }

         if (var6.getChildText("triModeTravail") != null && !var6.getChildText("triModeTravail").isEmpty()) {
            this.optionsPaye.setTriModeTravail(var6.getChildText("triModeTravail"));
         } else {
            this.optionsPaye.setTriModeTravail("0");
         }

         double var7 = 0.0D;
         if (var6.getChildText("securiteSocialeGene") != null && !var6.getChildText("securiteSocialeGene").isEmpty()) {
            var7 = Double.parseDouble(var6.getChildText("securiteSocialeGene"));
         }

         this.optionsPaye.setSecuriteSocialeGene(var7);
         double var9 = 0.0D;
         if (var6.getChildText("securiteSocialeCadre") != null && !var6.getChildText("securiteSocialeCadre").isEmpty()) {
            var9 = Double.parseDouble(var6.getChildText("securiteSocialeCadre"));
         }

         this.optionsPaye.setSecuriteSocialeCadre(var9);
         double var11 = 0.0D;
         if (var6.getChildText("cnamgs") != null && !var6.getChildText("cnamgs").isEmpty()) {
            var11 = Double.parseDouble(var6.getChildText("cnamgs"));
         }

         this.optionsPaye.setCnamgs(var11);
         float var13 = 0.0F;
         if (var6.getChildText("tauxcnamgsPS") != null && !var6.getChildText("tauxcnamgsPS").isEmpty()) {
            var13 = Float.parseFloat(var6.getChildText("tauxcnamgsPS"));
         }

         this.optionsPaye.setTauxcnamgsPS((double)var13);
         float var14 = 0.0F;
         if (var6.getChildText("tauxcnamgsPP") != null && !var6.getChildText("tauxcnamgsPP").isEmpty()) {
            var14 = Float.parseFloat(var6.getChildText("tauxcnamgsPP"));
         }

         this.optionsPaye.setTauxcnamgsPP((double)var14);
         float var15 = 0.0F;
         if (var6.getChildText("tauxcnssPS") != null && !var6.getChildText("tauxcnssPS").isEmpty()) {
            var15 = Float.parseFloat(var6.getChildText("tauxcnssPS"));
         }

         this.optionsPaye.setTauxcnssPS((double)var15);
         float var16 = 0.0F;
         if (var6.getChildText("tauxcnssPP") != null && !var6.getChildText("tauxcnssPP").isEmpty()) {
            var16 = Float.parseFloat(var6.getChildText("tauxcnssPP"));
         }

         this.optionsPaye.setTauxcnssPP((double)var16);
         float var17 = 0.0F;
         if (var6.getChildText("tauxfnhPP") != null && !var6.getChildText("tauxfnhPP").isEmpty()) {
            var17 = Float.parseFloat(var6.getChildText("tauxfnhPP"));
         }

         this.optionsPaye.setTauxfnhPP((double)var17);
         float var18 = 0.0F;
         if (var6.getChildText("tauxcfpPP") != null && !var6.getChildText("tauxcfpPP").isEmpty()) {
            var18 = Float.parseFloat(var6.getChildText("tauxcfpPP"));
         }

         this.optionsPaye.setTauxcfpPP((double)var18);
         float var19 = 0.0F;
         if (var6.getChildText("tauxipressGenePS") != null && !var6.getChildText("tauxipressGenePS").isEmpty()) {
            var19 = Float.parseFloat(var6.getChildText("tauxipressGenePS"));
         }

         this.optionsPaye.setTauxipressGenePS((double)var19);
         float var20 = 0.0F;
         if (var6.getChildText("tauxipressGenePP") != null && !var6.getChildText("tauxipressGenePP").isEmpty()) {
            var20 = Float.parseFloat(var6.getChildText("tauxipressGenePP"));
         }

         this.optionsPaye.setTauxipressGenePP((double)var20);
         float var21 = 0.0F;
         if (var6.getChildText("tauxipressCadrePS") != null && !var6.getChildText("tauxipressCadrePS").isEmpty()) {
            var21 = Float.parseFloat(var6.getChildText("tauxipressCadrePS"));
         }

         this.optionsPaye.setTauxipressCadrePS((double)var21);
         float var22 = 0.0F;
         if (var6.getChildText("tauxipressCadrePP") != null && !var6.getChildText("tauxipressCadrePP").isEmpty()) {
            var22 = Float.parseFloat(var6.getChildText("tauxipressCadrePP"));
         }

         this.optionsPaye.setTauxipressCadrePP((double)var22);
         float var23 = 0.0F;
         if (var6.getChildText("tauxcfcePP") != null && !var6.getChildText("tauxcfcePP").isEmpty()) {
            var23 = Float.parseFloat(var6.getChildText("tauxcfcePP"));
         }

         this.optionsPaye.setTauxcfcePP((double)var23);
         double var24 = 0.0D;
         if (var6.getChildText("cotisationSocialeGene") != null && !var6.getChildText("cotisationSocialeGene").isEmpty()) {
            var24 = Double.parseDouble(var6.getChildText("cotisationSocialeGene"));
         }

         this.optionsPaye.setCotisationSocialeGene(var24);
         double var26 = 0.0D;
         if (var6.getChildText("prestationMedicaleGene") != null && !var6.getChildText("prestationMedicaleGene").isEmpty()) {
            var26 = Double.parseDouble(var6.getChildText("prestationMedicaleGene"));
         }

         this.optionsPaye.setPrestationMedicaleGene(var26);
         double var28 = 0.0D;
         if (var6.getChildText("smig") != null && !var6.getChildText("smig").isEmpty()) {
            var28 = Double.parseDouble(var6.getChildText("smig"));
         }

         this.optionsPaye.setSmig(var28);
         if (var6.getChildText("trimf") != null && !var6.getChildText("trimf").isEmpty()) {
            this.optionsPaye.setTrimf(var6.getChildText("trimf"));
         } else {
            this.optionsPaye.setTrimf("0");
         }

         double var30 = 0.0D;
         if (var6.getChildText("nbEnfantAllocation") != null && !var6.getChildText("nbEnfantAllocation").isEmpty()) {
            var30 = Double.parseDouble(var6.getChildText("nbEnfantAllocation"));
         }

         this.optionsPaye.setNbEnfantAllocation(var30);
         float var32 = 0.0F;
         if (var6.getChildText("tauxcsspfPP") != null && !var6.getChildText("tauxcsspfPP").isEmpty()) {
            var32 = Float.parseFloat(var6.getChildText("tauxcsspfPP"));
         }

         this.optionsPaye.setTauxcsspfPP((double)var32);
         float var33 = 0.0F;
         if (var6.getChildText("tauxcssatPP") != null && !var6.getChildText("tauxcssatPP").isEmpty()) {
            var33 = Float.parseFloat(var6.getChildText("tauxcssatPP"));
         }

         this.optionsPaye.setTauxcssatPP((double)var33);
         this.optionsPaye.setRubVersement(var6.getChildText("rubVersement"));
         this.optionsPaye.setRubSpontanee(var6.getChildText("rubSpontanee"));
         this.optionsPaye.setRubRetrait(var6.getChildText("rubRetrait"));
         double var34 = 0.0D;
         if (var6.getChildText("heurejournee") != null && !var6.getChildText("heurejournee").isEmpty()) {
            var34 = Double.parseDouble(var6.getChildText("heurejournee"));
         }

         this.optionsPaye.setHeurejournee(var34);
         double var36 = 0.0D;
         if (var6.getChildText("heuredemijournee") != null && !var6.getChildText("heuredemijournee").isEmpty()) {
            var36 = Double.parseDouble(var6.getChildText("heuredemijournee"));
         }

         this.optionsPaye.setHeuredemijournee(var36);
         this.optionsPaye.setDossierExport(var6.getChildText("dossierExport"));
         if (var6.getChildText("echeanceprets") != null && !var6.getChildText("echeanceprets").isEmpty()) {
            this.optionsPaye.setEcheanceprets(var6.getChildText("echeanceprets"));
         } else {
            this.optionsPaye.setEcheanceprets("0");
         }

         if (var6.getChildText("baseconges") != null && !var6.getChildText("baseconges").isEmpty()) {
            this.optionsPaye.setBaseconges(var6.getChildText("baseconges"));
         } else {
            this.optionsPaye.setBaseconges("0");
         }

         if (var6.getChildText("nbEnfantsFiscaux") != null && !var6.getChildText("nbEnfantsFiscaux").isEmpty()) {
            this.optionsPaye.setNbEnfantsFiscaux(var6.getChildText("nbEnfantsFiscaux"));
         } else {
            this.optionsPaye.setNbEnfantsFiscaux("0");
         }

         this.optionsPaye.setRubQuinzaine(var6.getChildText("rubQuinzaine"));
         if (var6.getChildText("societeInterim") != null && !var6.getChildText("societeInterim").isEmpty()) {
            this.optionsPaye.setSocieteInterim(var6.getChildText("societeInterim"));
         } else {
            this.optionsPaye.setSocieteInterim("0");
         }

         if (var6.getChildText("axeStructure") != null && !var6.getChildText("axeStructure").isEmpty()) {
            this.optionsPaye.setAxeStructure(var6.getChildText("axeStructure"));
         } else {
            this.optionsPaye.setAxeStructure("false");
         }

         if (var6.getChildText("axeSite") != null && !var6.getChildText("axeSite").isEmpty()) {
            this.optionsPaye.setAxeSite(var6.getChildText("axeSite"));
         } else {
            this.optionsPaye.setAxeSite("false");
         }

         if (var6.getChildText("axeRegion") != null && !var6.getChildText("axeRegion").isEmpty()) {
            this.optionsPaye.setAxeRegion(var6.getChildText("axeRegion"));
         } else {
            this.optionsPaye.setAxeRegion("false");
         }

         if (var6.getChildText("axeUsine") != null && !var6.getChildText("axeUsine").isEmpty()) {
            this.optionsPaye.setAxeUsine(var6.getChildText("axeUsine"));
         } else {
            this.optionsPaye.setAxeUsine("false");
         }

         if (var6.getChildText("axeActivite") != null && !var6.getChildText("axeActivite").isEmpty()) {
            this.optionsPaye.setAxeActivite(var6.getChildText("axeActivite"));
         } else {
            this.optionsPaye.setAxeActivite("false");
         }

         if (var6.getChildText("axeAgent") != null && !var6.getChildText("axeAgent").isEmpty()) {
            this.optionsPaye.setAxeAgent(var6.getChildText("axeAgent"));
         } else {
            this.optionsPaye.setAxeAgent("false");
         }

         if (var6.getChildText("axeChantier") != null && !var6.getChildText("axeChantier").isEmpty()) {
            this.optionsPaye.setAxeChantier(var6.getChildText("axeChantier"));
         } else {
            this.optionsPaye.setAxeChantier("false");
         }

         if (var6.getChildText("axeParc") != null && !var6.getChildText("axeParc").isEmpty()) {
            this.optionsPaye.setAxeParc(var6.getChildText("axeParc"));
         } else {
            this.optionsPaye.setAxeParc("false");
         }

         if (var6.getChildText("axeMission") != null && !var6.getChildText("axeMission").isEmpty()) {
            this.optionsPaye.setAxeMission(var6.getChildText("axeMission"));
         } else {
            this.optionsPaye.setAxeMission("false");
         }

         if (var6.getChildText("axeCles") != null && !var6.getChildText("axeCles").isEmpty()) {
            this.optionsPaye.setAxeCles(var6.getChildText("axeCles"));
         } else {
            this.optionsPaye.setAxeCles("false");
         }

         if (var6.getChildText("axeProjet") != null && !var6.getChildText("axeProjet").isEmpty()) {
            this.optionsPaye.setAxeProjet(var6.getChildText("axeProjet"));
         } else {
            this.optionsPaye.setAxeProjet("false");
         }

         if (var6.getChildText("axeDossier") != null && !var6.getChildText("axeDossier").isEmpty()) {
            this.optionsPaye.setAxeDossier(var6.getChildText("axeDossier"));
         } else {
            this.optionsPaye.setAxeDossier("0");
         }

         if (var6.getChildText("trfCptePaye") != null && !var6.getChildText("trfCptePaye").isEmpty()) {
            this.optionsPaye.setTrfCptePaye(var6.getChildText("trfCptePaye"));
         } else {
            this.optionsPaye.setTrfCptePaye("0");
         }

         if (var6.getChildText("pointage") != null && !var6.getChildText("pointage").isEmpty()) {
            this.optionsPaye.setPointage(var6.getChildText("pointage"));
         } else {
            this.optionsPaye.setPointage("0");
         }

         if (var6.getChildText("temps") != null && !var6.getChildText("temps").isEmpty()) {
            this.optionsPaye.setTemps(var6.getChildText("temps"));
         } else {
            this.optionsPaye.setTemps("0");
         }

         var4.close();
      } catch (JDOMException var38) {
      } catch (IOException var39) {
      }

      return this.optionsPaye;
   }

   public OptionPaye getOptionsPaye() {
      return this.optionsPaye;
   }

   public void setOptionsPaye(OptionPaye var1) {
      this.optionsPaye = var1;
   }

   public long getStrId() {
      return this.strId;
   }

   public void setStrId(long var1) {
      this.strId = var1;
   }
}
