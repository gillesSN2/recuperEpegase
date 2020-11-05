package com.epegase.systeme.xml;

import java.io.Serializable;

public class OptionPaye implements Serializable {
   private String NbLigneMax;
   private String chargementListe;
   private String plafond;
   private String arrondiNet;
   private String triAgents;
   private String chronoMatricule;
   private String modeTravail;
   private String triModeTravail;
   private double securiteSocialeGene = 0.0D;
   private double tauxcnssPS = 0.0D;
   private double tauxcnssPP = 0.0D;
   private double tauxfnhPP = 0.0D;
   private double tauxcfpPP = 0.0D;
   private double tauxipressGenePS = 0.0D;
   private double tauxipressGenePP = 0.0D;
   private double tauxipressCadrePS = 0.0D;
   private double tauxipressCadrePP = 0.0D;
   private double tauxcsspfPP = 0.0D;
   private double tauxcssatPP = 0.0D;
   private double tauxcfcePP = 0.0D;
   private double securiteSocialeCadre = 0.0D;
   private double cnamgs = 0.0D;
   private double tauxcnamgsPS = 0.0D;
   private double tauxcnamgsPP = 0.0D;
   private double cotisationSocialeGene = 0.0D;
   private double prestationMedicaleGene = 0.0D;
   private double smig = 0.0D;
   private String trimf;
   private double nbEnfantAllocation = 0.0D;
   private String rubVersement;
   private String rubSpontanee;
   private String rubRetrait;
   private String calculRegularisation;
   private double heurejournee = 0.0D;
   private double heuredemijournee = 0.0D;
   private String dossierExport;
   private String echeanceprets = "0";
   private String baseconges = "0";
   private String nbEnfantsFiscaux = "0";
   private String rubQuinzaine;
   private String societeInterim;
   private double tauxAt = 0.0D;
   private double tauxPf = 0.0D;
   private double tauxVf = 0.0D;
   private double tauxTa = 0.0D;
   private double tauxCfpa = 0.0D;
   private double tauxtusPP = 0.0D;
   private double taxeTolCv = 0.0D;
   private double taxeTolPeriph = 0.0D;
   private double eloignementExpat = 0.0D;
   private double eloignementLocal = 0.0D;
   private String axeStructure;
   private String axeSite;
   private String axeRegion;
   private String axeUsine;
   private String axeActivite;
   private String axeAgent;
   private String axeChantier;
   private String axeParc;
   private String axeMission;
   private String axeCles;
   private String axeProjet;
   private String axeDossier;
   private String trfCptePaye;
   private String pointage;
   private String temps;
   private String exportOd;
   private String nbcrExport;
   private String nbcrTiersExport;
   private String prefixeTiersExport;

   public String getNbLigneMax() {
      return this.NbLigneMax;
   }

   public void setNbLigneMax(String var1) {
      this.NbLigneMax = var1;
   }

   public String getChargementListe() {
      return this.chargementListe;
   }

   public void setChargementListe(String var1) {
      this.chargementListe = var1;
   }

   public String getPlafond() {
      return this.plafond;
   }

   public void setPlafond(String var1) {
      this.plafond = var1;
   }

   public double getSmig() {
      return this.smig;
   }

   public void setSmig(double var1) {
      this.smig = var1;
   }

   public double getCotisationSocialeGene() {
      return this.cotisationSocialeGene;
   }

   public void setCotisationSocialeGene(double var1) {
      this.cotisationSocialeGene = var1;
   }

   public double getSecuriteSocialeCadre() {
      return this.securiteSocialeCadre;
   }

   public void setSecuriteSocialeCadre(double var1) {
      this.securiteSocialeCadre = var1;
   }

   public double getSecuriteSocialeGene() {
      return this.securiteSocialeGene;
   }

   public void setSecuriteSocialeGene(double var1) {
      this.securiteSocialeGene = var1;
   }

   public double getPrestationMedicaleGene() {
      return this.prestationMedicaleGene;
   }

   public void setPrestationMedicaleGene(double var1) {
      this.prestationMedicaleGene = var1;
   }

   public double getNbEnfantAllocation() {
      return this.nbEnfantAllocation;
   }

   public void setNbEnfantAllocation(double var1) {
      this.nbEnfantAllocation = var1;
   }

   public String getArrondiNet() {
      return this.arrondiNet;
   }

   public void setArrondiNet(String var1) {
      this.arrondiNet = var1;
   }

   public String getTriAgents() {
      return this.triAgents;
   }

   public void setTriAgents(String var1) {
      this.triAgents = var1;
   }

   public String getRubRetrait() {
      return this.rubRetrait;
   }

   public void setRubRetrait(String var1) {
      this.rubRetrait = var1;
   }

   public String getRubSpontanee() {
      return this.rubSpontanee;
   }

   public void setRubSpontanee(String var1) {
      this.rubSpontanee = var1;
   }

   public String getRubVersement() {
      return this.rubVersement;
   }

   public void setRubVersement(String var1) {
      this.rubVersement = var1;
   }

   public String getCalculRegularisation() {
      return this.calculRegularisation;
   }

   public void setCalculRegularisation(String var1) {
      this.calculRegularisation = var1;
   }

   public double getHeuredemijournee() {
      return this.heuredemijournee;
   }

   public void setHeuredemijournee(double var1) {
      this.heuredemijournee = var1;
   }

   public double getHeurejournee() {
      return this.heurejournee;
   }

   public void setHeurejournee(double var1) {
      this.heurejournee = var1;
   }

   public String getChronoMatricule() {
      return this.chronoMatricule;
   }

   public void setChronoMatricule(String var1) {
      this.chronoMatricule = var1;
   }

   public String getDossierExport() {
      return this.dossierExport;
   }

   public void setDossierExport(String var1) {
      this.dossierExport = var1;
   }

   public String getTrimf() {
      return this.trimf;
   }

   public void setTrimf(String var1) {
      this.trimf = var1;
   }

   public double getCnamgs() {
      return this.cnamgs;
   }

   public void setCnamgs(double var1) {
      this.cnamgs = var1;
   }

   public double getTauxcnamgsPS() {
      return this.tauxcnamgsPS;
   }

   public void setTauxcnamgsPS(double var1) {
      this.tauxcnamgsPS = var1;
   }

   public double getTauxcnamgsPP() {
      return this.tauxcnamgsPP;
   }

   public void setTauxcnamgsPP(double var1) {
      this.tauxcnamgsPP = var1;
   }

   public double getTauxcnssPP() {
      return this.tauxcnssPP;
   }

   public void setTauxcnssPP(double var1) {
      this.tauxcnssPP = var1;
   }

   public double getTauxcnssPS() {
      return this.tauxcnssPS;
   }

   public void setTauxcnssPS(double var1) {
      this.tauxcnssPS = var1;
   }

   public double getTauxfnhPP() {
      return this.tauxfnhPP;
   }

   public void setTauxfnhPP(double var1) {
      this.tauxfnhPP = var1;
   }

   public String getEcheanceprets() {
      return this.echeanceprets;
   }

   public void setEcheanceprets(String var1) {
      this.echeanceprets = var1;
   }

   public String getBaseconges() {
      return this.baseconges;
   }

   public void setBaseconges(String var1) {
      this.baseconges = var1;
   }

   public String getModeTravail() {
      return this.modeTravail;
   }

   public void setModeTravail(String var1) {
      this.modeTravail = var1;
   }

   public String getNbEnfantsFiscaux() {
      return this.nbEnfantsFiscaux;
   }

   public void setNbEnfantsFiscaux(String var1) {
      this.nbEnfantsFiscaux = var1;
   }

   public String getRubQuinzaine() {
      return this.rubQuinzaine;
   }

   public void setRubQuinzaine(String var1) {
      this.rubQuinzaine = var1;
   }

   public String getAxeActivite() {
      return this.axeActivite;
   }

   public void setAxeActivite(String var1) {
      this.axeActivite = var1;
   }

   public String getAxeAgent() {
      return this.axeAgent;
   }

   public void setAxeAgent(String var1) {
      this.axeAgent = var1;
   }

   public String getAxeChantier() {
      return this.axeChantier;
   }

   public void setAxeChantier(String var1) {
      this.axeChantier = var1;
   }

   public String getAxeCles() {
      return this.axeCles;
   }

   public void setAxeCles(String var1) {
      this.axeCles = var1;
   }

   public String getAxeDossier() {
      return this.axeDossier;
   }

   public void setAxeDossier(String var1) {
      this.axeDossier = var1;
   }

   public String getAxeMission() {
      return this.axeMission;
   }

   public void setAxeMission(String var1) {
      this.axeMission = var1;
   }

   public String getAxeParc() {
      return this.axeParc;
   }

   public void setAxeParc(String var1) {
      this.axeParc = var1;
   }

   public String getAxeProjet() {
      return this.axeProjet;
   }

   public void setAxeProjet(String var1) {
      this.axeProjet = var1;
   }

   public String getAxeRegion() {
      return this.axeRegion;
   }

   public void setAxeRegion(String var1) {
      this.axeRegion = var1;
   }

   public String getAxeSite() {
      return this.axeSite;
   }

   public void setAxeSite(String var1) {
      this.axeSite = var1;
   }

   public String getAxeStructure() {
      return this.axeStructure;
   }

   public void setAxeStructure(String var1) {
      this.axeStructure = var1;
   }

   public String getAxeUsine() {
      return this.axeUsine;
   }

   public void setAxeUsine(String var1) {
      this.axeUsine = var1;
   }

   public double getTauxcfpPP() {
      return this.tauxcfpPP;
   }

   public void setTauxcfpPP(double var1) {
      this.tauxcfpPP = var1;
   }

   public double getTauxcssatPP() {
      return this.tauxcssatPP;
   }

   public void setTauxcssatPP(double var1) {
      this.tauxcssatPP = var1;
   }

   public double getTauxcsspfPP() {
      return this.tauxcsspfPP;
   }

   public void setTauxcsspfPP(double var1) {
      this.tauxcsspfPP = var1;
   }

   public double getTauxipressCadrePP() {
      return this.tauxipressCadrePP;
   }

   public void setTauxipressCadrePP(double var1) {
      this.tauxipressCadrePP = var1;
   }

   public double getTauxipressCadrePS() {
      return this.tauxipressCadrePS;
   }

   public void setTauxipressCadrePS(double var1) {
      this.tauxipressCadrePS = var1;
   }

   public double getTauxipressGenePP() {
      return this.tauxipressGenePP;
   }

   public void setTauxipressGenePP(double var1) {
      this.tauxipressGenePP = var1;
   }

   public double getTauxipressGenePS() {
      return this.tauxipressGenePS;
   }

   public void setTauxipressGenePS(double var1) {
      this.tauxipressGenePS = var1;
   }

   public double getTauxcfcePP() {
      return this.tauxcfcePP;
   }

   public void setTauxcfcePP(double var1) {
      this.tauxcfcePP = var1;
   }

   public String getTrfCptePaye() {
      return this.trfCptePaye;
   }

   public void setTrfCptePaye(String var1) {
      this.trfCptePaye = var1;
   }

   public String getTriModeTravail() {
      return this.triModeTravail;
   }

   public void setTriModeTravail(String var1) {
      this.triModeTravail = var1;
   }

   public String getSocieteInterim() {
      return this.societeInterim;
   }

   public void setSocieteInterim(String var1) {
      this.societeInterim = var1;
   }

   public String getPointage() {
      return this.pointage;
   }

   public void setPointage(String var1) {
      this.pointage = var1;
   }

   public String getTemps() {
      return this.temps;
   }

   public void setTemps(String var1) {
      this.temps = var1;
   }

   public double getTauxAt() {
      return this.tauxAt;
   }

   public void setTauxAt(double var1) {
      this.tauxAt = var1;
   }

   public double getTauxCfpa() {
      return this.tauxCfpa;
   }

   public void setTauxCfpa(double var1) {
      this.tauxCfpa = var1;
   }

   public double getTauxPf() {
      return this.tauxPf;
   }

   public void setTauxPf(double var1) {
      this.tauxPf = var1;
   }

   public double getTauxTa() {
      return this.tauxTa;
   }

   public void setTauxTa(double var1) {
      this.tauxTa = var1;
   }

   public double getTauxVf() {
      return this.tauxVf;
   }

   public void setTauxVf(double var1) {
      this.tauxVf = var1;
   }

   public String getExportOd() {
      return this.exportOd;
   }

   public void setExportOd(String var1) {
      this.exportOd = var1;
   }

   public String getNbcrExport() {
      return this.nbcrExport;
   }

   public void setNbcrExport(String var1) {
      this.nbcrExport = var1;
   }

   public double getTauxtusPP() {
      return this.tauxtusPP;
   }

   public void setTauxtusPP(double var1) {
      this.tauxtusPP = var1;
   }

   public double getTaxeTolCv() {
      return this.taxeTolCv;
   }

   public void setTaxeTolCv(double var1) {
      this.taxeTolCv = var1;
   }

   public double getTaxeTolPeriph() {
      return this.taxeTolPeriph;
   }

   public void setTaxeTolPeriph(double var1) {
      this.taxeTolPeriph = var1;
   }

   public String getNbcrTiersExport() {
      return this.nbcrTiersExport;
   }

   public void setNbcrTiersExport(String var1) {
      this.nbcrTiersExport = var1;
   }

   public String getPrefixeTiersExport() {
      return this.prefixeTiersExport;
   }

   public void setPrefixeTiersExport(String var1) {
      this.prefixeTiersExport = var1;
   }

   public double getEloignementExpat() {
      return this.eloignementExpat;
   }

   public void setEloignementExpat(double var1) {
      this.eloignementExpat = var1;
   }

   public double getEloignementLocal() {
      return this.eloignementLocal;
   }

   public void setEloignementLocal(double var1) {
      this.eloignementLocal = var1;
   }
}
