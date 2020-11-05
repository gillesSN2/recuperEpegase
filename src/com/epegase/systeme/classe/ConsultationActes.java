package com.epegase.systeme.classe;

import java.io.Serializable;

public class ConsultationActes implements Serializable {
   private long cslactId;
   private String cslactProduit;
   private String cslactLibelle;
   private String cslactDent;
   private String cslactLettre;
   private float cslactNb;
   private float cslactNbCnamgs;
   private double cslactValeur;
   private double cslactValeurCnamgs;
   private float cslactCoef;
   private double cslactPu;
   private double cslactPuCnamgs;
   private double cslactPuAssurance;
   private float cslactRemise;
   private double cslactRabais;
   private double cslactPuRem;
   private float cslactQte;
   private double cslactPatientHt;
   private double cslactPatientTaxe;
   private double cslactSocieteHt;
   private double cslactSocieteTaxe;
   private double cslactAssuranceHt;
   private double cslactAssuranceTaxe;
   private double cslactComplementaireHt;
   private double cslactComplementaireTaxe;
   private double cslactTotal;
   private double cslactTaxe;
   private float cslactTauxTva;
   private String cslactCodeTva;
   private double cslactRegPatient;
   private double cslactRegTiers;
   private ConsultationEnteteGene consultationEnteteGene;
   private double totalTiers;
   private double totlalPatient;
   private int typeLigne;
   private double nouveauPaiement;
   private String cslordProduit;
   private String cslordLibelle;
   private String cslordDci;
   private String cslordForme;
   private String cslordPoso;
   private String cslordObs;
   private int cslordQte;
   private String cslordUnite;
   private String csllabProduit;
   private String csllabLibelle;
   private String csllabObs;

   public ConsultationEnteteGene getConsultationEnteteGene() {
      return this.consultationEnteteGene;
   }

   public void setConsultationEnteteGene(ConsultationEnteteGene var1) {
      this.consultationEnteteGene = var1;
   }

   public double getNouveauPaiement() {
      return this.nouveauPaiement;
   }

   public void setNouveauPaiement(double var1) {
      this.nouveauPaiement = var1;
   }

   public double getTotlalPatient() {
      this.totlalPatient = this.cslactPatientHt + this.cslactPatientTaxe;
      return this.totlalPatient;
   }

   public void setTotlalPatient(double var1) {
      this.totlalPatient = var1;
   }

   public double getTotalTiers() {
      this.totalTiers = this.cslactSocieteHt + this.cslactSocieteTaxe + this.cslactAssuranceHt + this.cslactAssuranceTaxe + this.cslactComplementaireHt + this.cslactComplementaireTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getCslactAssuranceHt() {
      return this.cslactAssuranceHt;
   }

   public void setCslactAssuranceHt(double var1) {
      this.cslactAssuranceHt = var1;
   }

   public double getCslactAssuranceTaxe() {
      return this.cslactAssuranceTaxe;
   }

   public void setCslactAssuranceTaxe(double var1) {
      this.cslactAssuranceTaxe = var1;
   }

   public String getCslactCodeTva() {
      return this.cslactCodeTva;
   }

   public void setCslactCodeTva(String var1) {
      this.cslactCodeTva = var1;
   }

   public double getCslactComplementaireHt() {
      return this.cslactComplementaireHt;
   }

   public void setCslactComplementaireHt(double var1) {
      this.cslactComplementaireHt = var1;
   }

   public double getCslactComplementaireTaxe() {
      return this.cslactComplementaireTaxe;
   }

   public void setCslactComplementaireTaxe(double var1) {
      this.cslactComplementaireTaxe = var1;
   }

   public long getCslactId() {
      return this.cslactId;
   }

   public void setCslactId(long var1) {
      this.cslactId = var1;
   }

   public String getCslactLettre() {
      return this.cslactLettre;
   }

   public void setCslactLettre(String var1) {
      this.cslactLettre = var1;
   }

   public String getCslactLibelle() {
      return this.cslactLibelle;
   }

   public void setCslactLibelle(String var1) {
      this.cslactLibelle = var1;
   }

   public float getCslactNb() {
      return this.cslactNb;
   }

   public void setCslactNb(float var1) {
      this.cslactNb = var1;
   }

   public double getCslactPatientHt() {
      return this.cslactPatientHt;
   }

   public void setCslactPatientHt(double var1) {
      this.cslactPatientHt = var1;
   }

   public double getCslactPatientTaxe() {
      return this.cslactPatientTaxe;
   }

   public void setCslactPatientTaxe(double var1) {
      this.cslactPatientTaxe = var1;
   }

   public String getCslactProduit() {
      return this.cslactProduit;
   }

   public void setCslactProduit(String var1) {
      this.cslactProduit = var1;
   }

   public double getCslactPu() {
      return this.cslactPu;
   }

   public void setCslactPu(double var1) {
      this.cslactPu = var1;
   }

   public double getCslactPuRem() {
      return this.cslactPuRem;
   }

   public void setCslactPuRem(double var1) {
      this.cslactPuRem = var1;
   }

   public float getCslactQte() {
      return this.cslactQte;
   }

   public void setCslactQte(float var1) {
      this.cslactQte = var1;
   }

   public float getCslactRemise() {
      return this.cslactRemise;
   }

   public void setCslactRemise(float var1) {
      this.cslactRemise = var1;
   }

   public double getCslactSocieteHt() {
      return this.cslactSocieteHt;
   }

   public void setCslactSocieteHt(double var1) {
      this.cslactSocieteHt = var1;
   }

   public double getCslactSocieteTaxe() {
      return this.cslactSocieteTaxe;
   }

   public void setCslactSocieteTaxe(double var1) {
      this.cslactSocieteTaxe = var1;
   }

   public float getCslactTauxTva() {
      return this.cslactTauxTva;
   }

   public void setCslactTauxTva(float var1) {
      this.cslactTauxTva = var1;
   }

   public double getCslactTotal() {
      return this.cslactTotal;
   }

   public void setCslactTotal(double var1) {
      this.cslactTotal = var1;
   }

   public double getCslactValeur() {
      return this.cslactValeur;
   }

   public void setCslactValeur(double var1) {
      this.cslactValeur = var1;
   }

   public float getCslactCoef() {
      return this.cslactCoef;
   }

   public void setCslactCoef(float var1) {
      this.cslactCoef = var1;
   }

   public double getCslactTaxe() {
      return this.cslactTaxe;
   }

   public void setCslactTaxe(double var1) {
      this.cslactTaxe = var1;
   }

   public int getTypeLigne() {
      return this.typeLigne;
   }

   public void setTypeLigne(int var1) {
      this.typeLigne = var1;
   }

   public String getCsllabLibelle() {
      return this.csllabLibelle;
   }

   public void setCsllabLibelle(String var1) {
      this.csllabLibelle = var1;
   }

   public String getCsllabObs() {
      return this.csllabObs;
   }

   public void setCsllabObs(String var1) {
      this.csllabObs = var1;
   }

   public String getCsllabProduit() {
      return this.csllabProduit;
   }

   public void setCsllabProduit(String var1) {
      this.csllabProduit = var1;
   }

   public String getCslordDci() {
      return this.cslordDci;
   }

   public void setCslordDci(String var1) {
      this.cslordDci = var1;
   }

   public String getCslordForme() {
      return this.cslordForme;
   }

   public void setCslordForme(String var1) {
      this.cslordForme = var1;
   }

   public String getCslordLibelle() {
      return this.cslordLibelle;
   }

   public void setCslordLibelle(String var1) {
      this.cslordLibelle = var1;
   }

   public String getCslordObs() {
      return this.cslordObs;
   }

   public void setCslordObs(String var1) {
      this.cslordObs = var1;
   }

   public String getCslordPoso() {
      return this.cslordPoso;
   }

   public void setCslordPoso(String var1) {
      this.cslordPoso = var1;
   }

   public String getCslordProduit() {
      return this.cslordProduit;
   }

   public void setCslordProduit(String var1) {
      this.cslordProduit = var1;
   }

   public double getCslactPuCnamgs() {
      return this.cslactPuCnamgs;
   }

   public void setCslactPuCnamgs(double var1) {
      this.cslactPuCnamgs = var1;
   }

   public float getCslactNbCnamgs() {
      return this.cslactNbCnamgs;
   }

   public void setCslactNbCnamgs(float var1) {
      this.cslactNbCnamgs = var1;
   }

   public double getCslactValeurCnamgs() {
      return this.cslactValeurCnamgs;
   }

   public void setCslactValeurCnamgs(double var1) {
      this.cslactValeurCnamgs = var1;
   }

   public double getCslactPuAssurance() {
      return this.cslactPuAssurance;
   }

   public void setCslactPuAssurance(double var1) {
      this.cslactPuAssurance = var1;
   }

   public double getCslactRegPatient() {
      return this.cslactRegPatient;
   }

   public void setCslactRegPatient(double var1) {
      this.cslactRegPatient = var1;
   }

   public int getCslordQte() {
      return this.cslordQte;
   }

   public void setCslordQte(int var1) {
      this.cslordQte = var1;
   }

   public String getCslordUnite() {
      return this.cslordUnite;
   }

   public void setCslordUnite(String var1) {
      this.cslordUnite = var1;
   }

   public double getCslactRegTiers() {
      return this.cslactRegTiers;
   }

   public void setCslactRegTiers(double var1) {
      this.cslactRegTiers = var1;
   }

   public double getCslactRabais() {
      return this.cslactRabais;
   }

   public void setCslactRabais(double var1) {
      this.cslactRabais = var1;
   }

   public String getCslactDent() {
      return this.cslactDent;
   }

   public void setCslactDent(String var1) {
      this.cslactDent = var1;
   }
}
