package com.epegase.systeme.classe;

import java.io.Serializable;

public class PharmacieLigne implements Serializable {
   private long phaligId;
   private String phaligProduit;
   private String phaligLibelle;
   private String phaligDci;
   private String phaligFamille;
   private float phaligCoef;
   private double phaligPu;
   private double phaligPuCnamgs;
   private double phaligPuAssurance;
   private double phaligPump;
   private float phaligRemise;
   private double phaligRabais;
   private double phaligPuRem;
   private String phaligDepot;
   private float phaligQte;
   private float phaligQteUtil;
   private String phaligUnite;
   private String phaligCondition;
   private String phaligDescription;
   private int phaligStock;
   private int phaligEchelle;
   private double phaligPatientHt;
   private double phaligPatientTaxe;
   private double phaligSocieteHt;
   private double phaligSocieteTaxe;
   private double phaligAssuranceHt;
   private double phaligAssuranceTaxe;
   private double phaligComplementaireHt;
   private double phaligComplementaireTaxe;
   private double phaligTotal;
   private double phaligTaxe;
   private float phaligTauxTva;
   private String phaligCodeTva;
   private double phaligRegPatient;
   private double phaligRegTiers;
   private PharmacieEntete pharmacieEntete;
   private ConsultationEnteteGene consultationEnteteGene;
   private double totalTiers;
   private double totlalPatient;
   private String var_lib_uni_condit;
   private Unite unite = new Unite();
   private double nouveauPaiement;

   public PharmacieEntete getPharmacieEntete() {
      return this.pharmacieEntete;
   }

   public void setPharmacieEntete(PharmacieEntete var1) {
      this.pharmacieEntete = var1;
   }

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

   public String getVar_lib_uni_condit() {
      if (this.phaligCondition != null && !this.phaligCondition.isEmpty() && this.phaligCondition.contains(":")) {
         if (this.phaligDescription != null && !this.phaligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.phaligDescription;
         } else if (this.phaligCondition.contains("/")) {
            String[] var1 = this.phaligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.phaligCondition;
         }
      } else if (this.phaligCondition != null && !this.phaligCondition.isEmpty() && !this.phaligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.phaligCondition));
      } else if (this.phaligUnite != null && !this.phaligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.phaligUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public double getTotalTiers() {
      this.totalTiers = this.phaligAssuranceHt + this.phaligAssuranceTaxe + this.phaligComplementaireHt + this.phaligComplementaireTaxe + this.phaligSocieteHt + this.phaligSocieteTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getTotlalPatient() {
      this.totlalPatient = this.phaligPatientHt + this.phaligPatientTaxe;
      return this.totlalPatient;
   }

   public void setTotlalPatient(double var1) {
      this.totlalPatient = var1;
   }

   public double getPhaligAssuranceHt() {
      return this.phaligAssuranceHt;
   }

   public void setPhaligAssuranceHt(double var1) {
      this.phaligAssuranceHt = var1;
   }

   public double getPhaligAssuranceTaxe() {
      return this.phaligAssuranceTaxe;
   }

   public void setPhaligAssuranceTaxe(double var1) {
      this.phaligAssuranceTaxe = var1;
   }

   public String getPhaligCodeTva() {
      return this.phaligCodeTva;
   }

   public void setPhaligCodeTva(String var1) {
      this.phaligCodeTva = var1;
   }

   public double getPhaligComplementaireHt() {
      return this.phaligComplementaireHt;
   }

   public void setPhaligComplementaireHt(double var1) {
      this.phaligComplementaireHt = var1;
   }

   public double getPhaligComplementaireTaxe() {
      return this.phaligComplementaireTaxe;
   }

   public void setPhaligComplementaireTaxe(double var1) {
      this.phaligComplementaireTaxe = var1;
   }

   public String getPhaligFamille() {
      return this.phaligFamille;
   }

   public void setPhaligFamille(String var1) {
      this.phaligFamille = var1;
   }

   public long getPhaligId() {
      return this.phaligId;
   }

   public void setPhaligId(long var1) {
      this.phaligId = var1;
   }

   public String getPhaligLibelle() {
      return this.phaligLibelle;
   }

   public void setPhaligLibelle(String var1) {
      this.phaligLibelle = var1;
   }

   public double getPhaligPatientHt() {
      return this.phaligPatientHt;
   }

   public void setPhaligPatientHt(double var1) {
      this.phaligPatientHt = var1;
   }

   public double getPhaligPatientTaxe() {
      return this.phaligPatientTaxe;
   }

   public void setPhaligPatientTaxe(double var1) {
      this.phaligPatientTaxe = var1;
   }

   public String getPhaligProduit() {
      return this.phaligProduit;
   }

   public void setPhaligProduit(String var1) {
      this.phaligProduit = var1;
   }

   public double getPhaligPu() {
      return this.phaligPu;
   }

   public void setPhaligPu(double var1) {
      this.phaligPu = var1;
   }

   public double getPhaligPuRem() {
      return this.phaligPuRem;
   }

   public void setPhaligPuRem(double var1) {
      this.phaligPuRem = var1;
   }

   public float getPhaligQte() {
      return this.phaligQte;
   }

   public void setPhaligQte(float var1) {
      this.phaligQte = var1;
   }

   public float getPhaligRemise() {
      return this.phaligRemise;
   }

   public void setPhaligRemise(float var1) {
      this.phaligRemise = var1;
   }

   public double getPhaligSocieteHt() {
      return this.phaligSocieteHt;
   }

   public void setPhaligSocieteHt(double var1) {
      this.phaligSocieteHt = var1;
   }

   public double getPhaligSocieteTaxe() {
      return this.phaligSocieteTaxe;
   }

   public void setPhaligSocieteTaxe(double var1) {
      this.phaligSocieteTaxe = var1;
   }

   public float getPhaligTauxTva() {
      return this.phaligTauxTva;
   }

   public void setPhaligTauxTva(float var1) {
      this.phaligTauxTva = var1;
   }

   public double getPhaligTaxe() {
      return this.phaligTaxe;
   }

   public void setPhaligTaxe(double var1) {
      this.phaligTaxe = var1;
   }

   public double getPhaligTotal() {
      return this.phaligTotal;
   }

   public void setPhaligTotal(double var1) {
      this.phaligTotal = var1;
   }

   public String getPhaligDepot() {
      return this.phaligDepot;
   }

   public void setPhaligDepot(String var1) {
      this.phaligDepot = var1;
   }

   public String getPhaligDci() {
      return this.phaligDci;
   }

   public void setPhaligDci(String var1) {
      this.phaligDci = var1;
   }

   public String getPhaligCondition() {
      return this.phaligCondition;
   }

   public void setPhaligCondition(String var1) {
      this.phaligCondition = var1;
   }

   public int getPhaligEchelle() {
      return this.phaligEchelle;
   }

   public void setPhaligEchelle(int var1) {
      this.phaligEchelle = var1;
   }

   public int getPhaligStock() {
      return this.phaligStock;
   }

   public void setPhaligStock(int var1) {
      this.phaligStock = var1;
   }

   public String getPhaligUnite() {
      return this.phaligUnite;
   }

   public void setPhaligUnite(String var1) {
      this.phaligUnite = var1;
   }

   public String getPhaligDescription() {
      return this.phaligDescription;
   }

   public void setPhaligDescription(String var1) {
      this.phaligDescription = var1;
   }

   public double getPhaligPump() {
      return this.phaligPump;
   }

   public void setPhaligPump(double var1) {
      this.phaligPump = var1;
   }

   public double getPhaligPuAssurance() {
      return this.phaligPuAssurance;
   }

   public void setPhaligPuAssurance(double var1) {
      this.phaligPuAssurance = var1;
   }

   public double getPhaligPuCnamgs() {
      return this.phaligPuCnamgs;
   }

   public void setPhaligPuCnamgs(double var1) {
      this.phaligPuCnamgs = var1;
   }

   public float getPhaligCoef() {
      return this.phaligCoef;
   }

   public void setPhaligCoef(float var1) {
      this.phaligCoef = var1;
   }

   public float getPhaligQteUtil() {
      return this.phaligQteUtil;
   }

   public void setPhaligQteUtil(float var1) {
      this.phaligQteUtil = var1;
   }

   public double getPhaligRegPatient() {
      return this.phaligRegPatient;
   }

   public void setPhaligRegPatient(double var1) {
      this.phaligRegPatient = var1;
   }

   public double getPhaligRegTiers() {
      return this.phaligRegTiers;
   }

   public void setPhaligRegTiers(double var1) {
      this.phaligRegTiers = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public double getPhaligRabais() {
      return this.phaligRabais;
   }

   public void setPhaligRabais(double var1) {
      this.phaligRabais = var1;
   }
}
