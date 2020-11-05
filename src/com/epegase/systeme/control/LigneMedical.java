package com.epegase.systeme.control;

import java.io.Serializable;

public class LigneMedical implements Serializable {
   private long ligId;
   private String ligProduit;
   private String ligLibelle;
   private String ligLettre;
   private float ligNb;
   private float ligNbCnamgs;
   private double ligValeur;
   private double ligValeurCnamgs;
   private float ligCoef;
   private double ligPu;
   private double ligPuCnamgs;
   private double ligPuAssurance;
   private float ligRemise;
   private double ligRabais;
   private double ligPuRem;
   private float ligQte;
   private double ligPatientHt;
   private double ligPatientTaxe;
   private double ligSocieteHt;
   private double ligSocieteTaxe;
   private double ligAssuranceHt;
   private double ligAssuranceTaxe;
   private double ligComplementaireHt;
   private double ligComplementaireTaxe;
   private double ligTotal;
   private double ligTaxe;
   private float ligTauxTva;
   private String ligCodeTva;
   private double ligRegPatient;
   private double ligRegTiers;
   private double totalTiers;

   public double getTotalTiers() {
      this.totalTiers = this.ligAssuranceHt + this.ligAssuranceTaxe + this.ligComplementaireHt + this.ligComplementaireTaxe + this.ligSocieteHt + this.ligSocieteTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getLigAssuranceHt() {
      return this.ligAssuranceHt;
   }

   public void setLigAssuranceHt(double var1) {
      this.ligAssuranceHt = var1;
   }

   public double getLigAssuranceTaxe() {
      return this.ligAssuranceTaxe;
   }

   public void setLigAssuranceTaxe(double var1) {
      this.ligAssuranceTaxe = var1;
   }

   public String getLigCodeTva() {
      return this.ligCodeTva;
   }

   public void setLigCodeTva(String var1) {
      this.ligCodeTva = var1;
   }

   public float getLigCoef() {
      return this.ligCoef;
   }

   public void setLigCoef(float var1) {
      this.ligCoef = var1;
   }

   public double getLigComplementaireHt() {
      return this.ligComplementaireHt;
   }

   public void setLigComplementaireHt(double var1) {
      this.ligComplementaireHt = var1;
   }

   public double getLigComplementaireTaxe() {
      return this.ligComplementaireTaxe;
   }

   public void setLigComplementaireTaxe(double var1) {
      this.ligComplementaireTaxe = var1;
   }

   public long getLigId() {
      return this.ligId;
   }

   public void setLigId(long var1) {
      this.ligId = var1;
   }

   public String getLigLettre() {
      return this.ligLettre;
   }

   public void setLigLettre(String var1) {
      this.ligLettre = var1;
   }

   public String getLigLibelle() {
      return this.ligLibelle;
   }

   public void setLigLibelle(String var1) {
      this.ligLibelle = var1;
   }

   public float getLigNb() {
      return this.ligNb;
   }

   public void setLigNb(float var1) {
      this.ligNb = var1;
   }

   public float getLigNbCnamgs() {
      return this.ligNbCnamgs;
   }

   public void setLigNbCnamgs(float var1) {
      this.ligNbCnamgs = var1;
   }

   public double getLigPatientHt() {
      return this.ligPatientHt;
   }

   public void setLigPatientHt(double var1) {
      this.ligPatientHt = var1;
   }

   public double getLigPatientTaxe() {
      return this.ligPatientTaxe;
   }

   public void setLigPatientTaxe(double var1) {
      this.ligPatientTaxe = var1;
   }

   public String getLigProduit() {
      return this.ligProduit;
   }

   public void setLigProduit(String var1) {
      this.ligProduit = var1;
   }

   public double getLigPu() {
      return this.ligPu;
   }

   public void setLigPu(double var1) {
      this.ligPu = var1;
   }

   public double getLigPuAssurance() {
      return this.ligPuAssurance;
   }

   public void setLigPuAssurance(double var1) {
      this.ligPuAssurance = var1;
   }

   public double getLigPuCnamgs() {
      return this.ligPuCnamgs;
   }

   public void setLigPuCnamgs(double var1) {
      this.ligPuCnamgs = var1;
   }

   public double getLigPuRem() {
      return this.ligPuRem;
   }

   public void setLigPuRem(double var1) {
      this.ligPuRem = var1;
   }

   public float getLigQte() {
      return this.ligQte;
   }

   public void setLigQte(float var1) {
      this.ligQte = var1;
   }

   public double getLigRabais() {
      return this.ligRabais;
   }

   public void setLigRabais(double var1) {
      this.ligRabais = var1;
   }

   public double getLigRegPatient() {
      return this.ligRegPatient;
   }

   public void setLigRegPatient(double var1) {
      this.ligRegPatient = var1;
   }

   public double getLigRegTiers() {
      return this.ligRegTiers;
   }

   public void setLigRegTiers(double var1) {
      this.ligRegTiers = var1;
   }

   public float getLigRemise() {
      return this.ligRemise;
   }

   public void setLigRemise(float var1) {
      this.ligRemise = var1;
   }

   public double getLigSocieteHt() {
      return this.ligSocieteHt;
   }

   public void setLigSocieteHt(double var1) {
      this.ligSocieteHt = var1;
   }

   public double getLigSocieteTaxe() {
      return this.ligSocieteTaxe;
   }

   public void setLigSocieteTaxe(double var1) {
      this.ligSocieteTaxe = var1;
   }

   public float getLigTauxTva() {
      return this.ligTauxTva;
   }

   public void setLigTauxTva(float var1) {
      this.ligTauxTva = var1;
   }

   public double getLigTaxe() {
      return this.ligTaxe;
   }

   public void setLigTaxe(double var1) {
      this.ligTaxe = var1;
   }

   public double getLigTotal() {
      return this.ligTotal;
   }

   public void setLigTotal(double var1) {
      this.ligTotal = var1;
   }

   public double getLigValeur() {
      return this.ligValeur;
   }

   public void setLigValeur(double var1) {
      this.ligValeur = var1;
   }

   public double getLigValeurCnamgs() {
      return this.ligValeurCnamgs;
   }

   public void setLigValeurCnamgs(double var1) {
      this.ligValeurCnamgs = var1;
   }
}
