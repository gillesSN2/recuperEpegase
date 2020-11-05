package com.epegase.systeme.classe;

import java.io.Serializable;

public class DevisLigneMedical implements Serializable {
   private long dvsligId;
   private String dvsligLaboratoire;
   private String dvsligProduit;
   private String dvsligLibelle;
   private String dvsligFamille;
   private String dvsligLettre;
   private float dvsligNb;
   private float dvsligNbCnamgs;
   private double dvsligValeur;
   private double dvsligValeurCnamgs;
   private float dvsligCoef;
   private double dvsligPu;
   private double dvsligPuCnamgs;
   private double dvsligPuAssurance;
   private float dvsligRemise;
   private double dvsligRabais;
   private double dvsligPuRem;
   private float dvsligQte;
   private double dvsligPatientHt;
   private double dvsligPatientTaxe;
   private double dvsligSocieteHt;
   private double dvsligSocieteTaxe;
   private double dvsligAssuranceHt;
   private double dvsligAssuranceTaxe;
   private double dvsligComplementaireHt;
   private double dvsligComplementaireTaxe;
   private double dvsligTotal;
   private double dvsligTaxe;
   private float dvsligTauxTva;
   private String dvsligCodeTva;
   private int dvsligEtat;
   private double dvsligRegPatient;
   private double dvsligRegTiers;
   private String dvsligCommentaire;
   private DevisEnteteMedical devisEnteteMedical;
   private double totalTiers;
   private double totlalPatient;
   private String libelle_etat;
   private double nouveauPaiement;

   public double getNouveauPaiement() {
      return this.nouveauPaiement;
   }

   public void setNouveauPaiement(double var1) {
      this.nouveauPaiement = var1;
   }

   public String getLibelle_etat() {
      if (this.dvsligEtat == 0) {
         this.libelle_etat = "En cours";
      } else if (this.dvsligEtat == 1) {
         this.libelle_etat = "Effectué";
      } else if (this.dvsligEtat == 2) {
         this.libelle_etat = "Gelé";
      } else if (this.dvsligEtat == 3) {
         this.libelle_etat = "Annulé";
      } else if (this.dvsligEtat == 4) {
         this.libelle_etat = "Cloturé";
      }

      return this.libelle_etat;
   }

   public void setLibelle_etat(String var1) {
      this.libelle_etat = var1;
   }

   public double getTotalTiers() {
      this.totalTiers = this.dvsligAssuranceHt + this.dvsligAssuranceTaxe + this.dvsligComplementaireHt + this.dvsligComplementaireTaxe + this.dvsligSocieteHt + this.dvsligSocieteTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getTotlalPatient() {
      this.totlalPatient = this.dvsligPatientHt + this.dvsligPatientTaxe;
      return this.totlalPatient;
   }

   public void setTotlalPatient(double var1) {
      this.totlalPatient = var1;
   }

   public double getDvsligAssuranceHt() {
      return this.dvsligAssuranceHt;
   }

   public void setDvsligAssuranceHt(double var1) {
      this.dvsligAssuranceHt = var1;
   }

   public double getDvsligAssuranceTaxe() {
      return this.dvsligAssuranceTaxe;
   }

   public void setDvsligAssuranceTaxe(double var1) {
      this.dvsligAssuranceTaxe = var1;
   }

   public String getDvsligCodeTva() {
      return this.dvsligCodeTva;
   }

   public void setDvsligCodeTva(String var1) {
      this.dvsligCodeTva = var1;
   }

   public float getDvsligCoef() {
      return this.dvsligCoef;
   }

   public void setDvsligCoef(float var1) {
      this.dvsligCoef = var1;
   }

   public String getDvsligCommentaire() {
      return this.dvsligCommentaire;
   }

   public void setDvsligCommentaire(String var1) {
      this.dvsligCommentaire = var1;
   }

   public double getDvsligComplementaireHt() {
      return this.dvsligComplementaireHt;
   }

   public void setDvsligComplementaireHt(double var1) {
      this.dvsligComplementaireHt = var1;
   }

   public double getDvsligComplementaireTaxe() {
      return this.dvsligComplementaireTaxe;
   }

   public void setDvsligComplementaireTaxe(double var1) {
      this.dvsligComplementaireTaxe = var1;
   }

   public int getDvsligEtat() {
      return this.dvsligEtat;
   }

   public void setDvsligEtat(int var1) {
      this.dvsligEtat = var1;
   }

   public String getDvsligFamille() {
      return this.dvsligFamille;
   }

   public void setDvsligFamille(String var1) {
      this.dvsligFamille = var1;
   }

   public long getDvsligId() {
      return this.dvsligId;
   }

   public void setDvsligId(long var1) {
      this.dvsligId = var1;
   }

   public String getDvsligLaboratoire() {
      return this.dvsligLaboratoire;
   }

   public void setDvsligLaboratoire(String var1) {
      this.dvsligLaboratoire = var1;
   }

   public String getDvsligLettre() {
      return this.dvsligLettre;
   }

   public void setDvsligLettre(String var1) {
      this.dvsligLettre = var1;
   }

   public String getDvsligLibelle() {
      return this.dvsligLibelle;
   }

   public void setDvsligLibelle(String var1) {
      this.dvsligLibelle = var1;
   }

   public float getDvsligNb() {
      return this.dvsligNb;
   }

   public void setDvsligNb(float var1) {
      this.dvsligNb = var1;
   }

   public float getDvsligNbCnamgs() {
      return this.dvsligNbCnamgs;
   }

   public void setDvsligNbCnamgs(float var1) {
      this.dvsligNbCnamgs = var1;
   }

   public double getDvsligPatientHt() {
      return this.dvsligPatientHt;
   }

   public void setDvsligPatientHt(double var1) {
      this.dvsligPatientHt = var1;
   }

   public double getDvsligPatientTaxe() {
      return this.dvsligPatientTaxe;
   }

   public void setDvsligPatientTaxe(double var1) {
      this.dvsligPatientTaxe = var1;
   }

   public String getDvsligProduit() {
      return this.dvsligProduit;
   }

   public void setDvsligProduit(String var1) {
      this.dvsligProduit = var1;
   }

   public double getDvsligPu() {
      return this.dvsligPu;
   }

   public void setDvsligPu(double var1) {
      this.dvsligPu = var1;
   }

   public double getDvsligPuAssurance() {
      return this.dvsligPuAssurance;
   }

   public void setDvsligPuAssurance(double var1) {
      this.dvsligPuAssurance = var1;
   }

   public double getDvsligPuCnamgs() {
      return this.dvsligPuCnamgs;
   }

   public void setDvsligPuCnamgs(double var1) {
      this.dvsligPuCnamgs = var1;
   }

   public double getDvsligPuRem() {
      return this.dvsligPuRem;
   }

   public void setDvsligPuRem(double var1) {
      this.dvsligPuRem = var1;
   }

   public float getDvsligQte() {
      return this.dvsligQte;
   }

   public void setDvsligQte(float var1) {
      this.dvsligQte = var1;
   }

   public double getDvsligRabais() {
      return this.dvsligRabais;
   }

   public void setDvsligRabais(double var1) {
      this.dvsligRabais = var1;
   }

   public double getDvsligRegPatient() {
      return this.dvsligRegPatient;
   }

   public void setDvsligRegPatient(double var1) {
      this.dvsligRegPatient = var1;
   }

   public double getDvsligRegTiers() {
      return this.dvsligRegTiers;
   }

   public void setDvsligRegTiers(double var1) {
      this.dvsligRegTiers = var1;
   }

   public float getDvsligRemise() {
      return this.dvsligRemise;
   }

   public void setDvsligRemise(float var1) {
      this.dvsligRemise = var1;
   }

   public double getDvsligSocieteHt() {
      return this.dvsligSocieteHt;
   }

   public void setDvsligSocieteHt(double var1) {
      this.dvsligSocieteHt = var1;
   }

   public double getDvsligSocieteTaxe() {
      return this.dvsligSocieteTaxe;
   }

   public void setDvsligSocieteTaxe(double var1) {
      this.dvsligSocieteTaxe = var1;
   }

   public float getDvsligTauxTva() {
      return this.dvsligTauxTva;
   }

   public void setDvsligTauxTva(float var1) {
      this.dvsligTauxTva = var1;
   }

   public double getDvsligTaxe() {
      return this.dvsligTaxe;
   }

   public void setDvsligTaxe(double var1) {
      this.dvsligTaxe = var1;
   }

   public double getDvsligTotal() {
      return this.dvsligTotal;
   }

   public void setDvsligTotal(double var1) {
      this.dvsligTotal = var1;
   }

   public double getDvsligValeur() {
      return this.dvsligValeur;
   }

   public void setDvsligValeur(double var1) {
      this.dvsligValeur = var1;
   }

   public double getDvsligValeurCnamgs() {
      return this.dvsligValeurCnamgs;
   }

   public void setDvsligValeurCnamgs(double var1) {
      this.dvsligValeurCnamgs = var1;
   }

   public DevisEnteteMedical getDevisEnteteMedical() {
      return this.devisEnteteMedical;
   }

   public void setDevisEnteteMedical(DevisEnteteMedical var1) {
      this.devisEnteteMedical = var1;
   }
}
