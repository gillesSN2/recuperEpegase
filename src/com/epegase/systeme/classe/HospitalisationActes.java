package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class HospitalisationActes implements Serializable {
   private long hosactId;
   private Date hosactDateCreat;
   private Date hosactDateModif;
   private long hosactUserCreat;
   private long hosactUserModif;
   private long hosactIdMedecin;
   private String hosactMedecin;
   private String hosactService;
   private String hosactProduit;
   private String hosactProduitLie;
   private String hosactLibelle;
   private String hosactLettre;
   private float hosactNb;
   private float hosactNbCnamgs;
   private double hosactValeur;
   private double hosactValeurCnamgs;
   private float hosactCoef;
   private double hosactPu;
   private double hosactPuCnamgs;
   private double hosactPuAssurance;
   private float hosactRemise;
   private double hosactRabais;
   private double hosactPuRem;
   private float hosactQte;
   private double hosactPatientHt;
   private double hosactPatientTaxe;
   private double hosactSocieteHt;
   private double hosactSocieteTaxe;
   private double hosactAssuranceHt;
   private double hosactAssuranceTaxe;
   private double hosactComplementaireHt;
   private double hosactComplementaireTaxe;
   private double hosactTotal;
   private double hosactTaxe;
   private float hosactTauxTva;
   private String hosactCodeTva;
   private long hosactIdSejour;
   private double hosactRegPatient;
   private double hosactRegTiers;
   private HospitalisationEntete hospitalisationEntete;
   private double totalTiers;
   private double totalPatient;

   public double getTotalTiers() {
      this.totalTiers = this.hosactSocieteHt + this.hosactSocieteTaxe + this.hosactAssuranceHt + this.hosactAssuranceTaxe + this.hosactComplementaireHt + this.hosactComplementaireTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.hosactPatientHt + this.hosactPatientTaxe;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public double getHosactAssuranceHt() {
      return this.hosactAssuranceHt;
   }

   public void setHosactAssuranceHt(double var1) {
      this.hosactAssuranceHt = var1;
   }

   public double getHosactAssuranceTaxe() {
      return this.hosactAssuranceTaxe;
   }

   public void setHosactAssuranceTaxe(double var1) {
      this.hosactAssuranceTaxe = var1;
   }

   public String getHosactCodeTva() {
      return this.hosactCodeTva;
   }

   public void setHosactCodeTva(String var1) {
      this.hosactCodeTva = var1;
   }

   public float getHosactCoef() {
      return this.hosactCoef;
   }

   public void setHosactCoef(float var1) {
      this.hosactCoef = var1;
   }

   public double getHosactComplementaireHt() {
      return this.hosactComplementaireHt;
   }

   public void setHosactComplementaireHt(double var1) {
      this.hosactComplementaireHt = var1;
   }

   public double getHosactComplementaireTaxe() {
      return this.hosactComplementaireTaxe;
   }

   public void setHosactComplementaireTaxe(double var1) {
      this.hosactComplementaireTaxe = var1;
   }

   public long getHosactId() {
      return this.hosactId;
   }

   public void setHosactId(long var1) {
      this.hosactId = var1;
   }

   public long getHosactIdMedecin() {
      return this.hosactIdMedecin;
   }

   public void setHosactIdMedecin(long var1) {
      this.hosactIdMedecin = var1;
   }

   public long getHosactIdSejour() {
      return this.hosactIdSejour;
   }

   public void setHosactIdSejour(long var1) {
      this.hosactIdSejour = var1;
   }

   public String getHosactLettre() {
      return this.hosactLettre;
   }

   public void setHosactLettre(String var1) {
      this.hosactLettre = var1;
   }

   public String getHosactLibelle() {
      return this.hosactLibelle;
   }

   public void setHosactLibelle(String var1) {
      this.hosactLibelle = var1;
   }

   public String getHosactMedecin() {
      return this.hosactMedecin;
   }

   public void setHosactMedecin(String var1) {
      this.hosactMedecin = var1;
   }

   public float getHosactNb() {
      return this.hosactNb;
   }

   public void setHosactNb(float var1) {
      this.hosactNb = var1;
   }

   public double getHosactPatientHt() {
      return this.hosactPatientHt;
   }

   public void setHosactPatientHt(double var1) {
      this.hosactPatientHt = var1;
   }

   public double getHosactPatientTaxe() {
      return this.hosactPatientTaxe;
   }

   public void setHosactPatientTaxe(double var1) {
      this.hosactPatientTaxe = var1;
   }

   public String getHosactProduit() {
      return this.hosactProduit;
   }

   public void setHosactProduit(String var1) {
      this.hosactProduit = var1;
   }

   public double getHosactPu() {
      return this.hosactPu;
   }

   public void setHosactPu(double var1) {
      this.hosactPu = var1;
   }

   public double getHosactPuRem() {
      return this.hosactPuRem;
   }

   public void setHosactPuRem(double var1) {
      this.hosactPuRem = var1;
   }

   public float getHosactQte() {
      return this.hosactQte;
   }

   public void setHosactQte(float var1) {
      this.hosactQte = var1;
   }

   public float getHosactRemise() {
      return this.hosactRemise;
   }

   public void setHosactRemise(float var1) {
      this.hosactRemise = var1;
   }

   public String getHosactService() {
      return this.hosactService;
   }

   public void setHosactService(String var1) {
      this.hosactService = var1;
   }

   public double getHosactSocieteHt() {
      return this.hosactSocieteHt;
   }

   public void setHosactSocieteHt(double var1) {
      this.hosactSocieteHt = var1;
   }

   public double getHosactSocieteTaxe() {
      return this.hosactSocieteTaxe;
   }

   public void setHosactSocieteTaxe(double var1) {
      this.hosactSocieteTaxe = var1;
   }

   public float getHosactTauxTva() {
      return this.hosactTauxTva;
   }

   public void setHosactTauxTva(float var1) {
      this.hosactTauxTva = var1;
   }

   public double getHosactTaxe() {
      return this.hosactTaxe;
   }

   public void setHosactTaxe(double var1) {
      this.hosactTaxe = var1;
   }

   public double getHosactTotal() {
      return this.hosactTotal;
   }

   public void setHosactTotal(double var1) {
      this.hosactTotal = var1;
   }

   public double getHosactValeur() {
      return this.hosactValeur;
   }

   public void setHosactValeur(double var1) {
      this.hosactValeur = var1;
   }

   public HospitalisationEntete getHospitalisationEntete() {
      return this.hospitalisationEntete;
   }

   public void setHospitalisationEntete(HospitalisationEntete var1) {
      this.hospitalisationEntete = var1;
   }

   public float getHosactNbCnamgs() {
      return this.hosactNbCnamgs;
   }

   public void setHosactNbCnamgs(float var1) {
      this.hosactNbCnamgs = var1;
   }

   public double getHosactPuAssurance() {
      return this.hosactPuAssurance;
   }

   public void setHosactPuAssurance(double var1) {
      this.hosactPuAssurance = var1;
   }

   public double getHosactPuCnamgs() {
      return this.hosactPuCnamgs;
   }

   public void setHosactPuCnamgs(double var1) {
      this.hosactPuCnamgs = var1;
   }

   public double getHosactValeurCnamgs() {
      return this.hosactValeurCnamgs;
   }

   public void setHosactValeurCnamgs(double var1) {
      this.hosactValeurCnamgs = var1;
   }

   public String getHosactProduitLie() {
      return this.hosactProduitLie;
   }

   public void setHosactProduitLie(String var1) {
      this.hosactProduitLie = var1;
   }

   public double getHosactRegPatient() {
      return this.hosactRegPatient;
   }

   public void setHosactRegPatient(double var1) {
      this.hosactRegPatient = var1;
   }

   public double getHosactRegTiers() {
      return this.hosactRegTiers;
   }

   public void setHosactRegTiers(double var1) {
      this.hosactRegTiers = var1;
   }

   public Date getHosactDateCreat() {
      return this.hosactDateCreat;
   }

   public void setHosactDateCreat(Date var1) {
      this.hosactDateCreat = var1;
   }

   public Date getHosactDateModif() {
      return this.hosactDateModif;
   }

   public void setHosactDateModif(Date var1) {
      this.hosactDateModif = var1;
   }

   public long getHosactUserCreat() {
      return this.hosactUserCreat;
   }

   public void setHosactUserCreat(long var1) {
      this.hosactUserCreat = var1;
   }

   public long getHosactUserModif() {
      return this.hosactUserModif;
   }

   public void setHosactUserModif(long var1) {
      this.hosactUserModif = var1;
   }

   public double getHosactRabais() {
      return this.hosactRabais;
   }

   public void setHosactRabais(double var1) {
      this.hosactRabais = var1;
   }
}
