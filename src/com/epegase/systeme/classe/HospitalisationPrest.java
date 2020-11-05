package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class HospitalisationPrest implements Serializable {
   private long hosprtId;
   private Date hosprtDateCreat;
   private Date hosprtDateModif;
   private long hosprtUserCreat;
   private long hosprtUserModif;
   private long hosprtIdMedecin;
   private String hosprtMedecin;
   private String hosprtService;
   private String hosprtProduit;
   private String hosprtLibelle;
   private String hosprtLettre;
   private float hosprtNb;
   private float hosprtNbCnamgs;
   private double hosprtValeur;
   private double hosprtValeurCnamgs;
   private float hosprtCoef;
   private double hosprtPu;
   private double hosprtPuCnamgs;
   private double hosprtPuAssurance;
   private float hosprtRemise;
   private double hosprtRabais;
   private double hosprtPuRem;
   private float hosprtQte;
   private double hosprtPatientHt;
   private double hosprtPatientTaxe;
   private double hosprtSocieteHt;
   private double hosprtSocieteTaxe;
   private double hosprtAssuranceHt;
   private double hosprtAssuranceTaxe;
   private double hosprtComplementaireHt;
   private double hosprtComplementaireTaxe;
   private double hosprtTotal;
   private double hosprtTaxe;
   private float hosprtTauxTva;
   private String hosprtCodeTva;
   private long hosprtIdSejour;
   private double hosprtRegPatient;
   private double hosprtRegTiers;
   private HospitalisationEntete hospitalisationEntete;
   private double totalTiers;
   private double totalPatient;

   public double getTotalTiers() {
      this.totalTiers = this.hosprtSocieteHt + this.hosprtSocieteTaxe + this.hosprtAssuranceHt + this.hosprtAssuranceTaxe + this.hosprtComplementaireHt + this.hosprtComplementaireTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.hosprtPatientHt + this.hosprtPatientTaxe;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public HospitalisationEntete getHospitalisationEntete() {
      return this.hospitalisationEntete;
   }

   public void setHospitalisationEntete(HospitalisationEntete var1) {
      this.hospitalisationEntete = var1;
   }

   public String getHosprtService() {
      return this.hosprtService;
   }

   public void setHosprtService(String var1) {
      this.hosprtService = var1;
   }

   public double getHosprtAssuranceHt() {
      return this.hosprtAssuranceHt;
   }

   public void setHosprtAssuranceHt(double var1) {
      this.hosprtAssuranceHt = var1;
   }

   public double getHosprtAssuranceTaxe() {
      return this.hosprtAssuranceTaxe;
   }

   public void setHosprtAssuranceTaxe(double var1) {
      this.hosprtAssuranceTaxe = var1;
   }

   public String getHosprtCodeTva() {
      return this.hosprtCodeTva;
   }

   public void setHosprtCodeTva(String var1) {
      this.hosprtCodeTva = var1;
   }

   public float getHosprtCoef() {
      return this.hosprtCoef;
   }

   public void setHosprtCoef(float var1) {
      this.hosprtCoef = var1;
   }

   public double getHosprtComplementaireHt() {
      return this.hosprtComplementaireHt;
   }

   public void setHosprtComplementaireHt(double var1) {
      this.hosprtComplementaireHt = var1;
   }

   public double getHosprtComplementaireTaxe() {
      return this.hosprtComplementaireTaxe;
   }

   public void setHosprtComplementaireTaxe(double var1) {
      this.hosprtComplementaireTaxe = var1;
   }

   public long getHosprtId() {
      return this.hosprtId;
   }

   public void setHosprtId(long var1) {
      this.hosprtId = var1;
   }

   public long getHosprtIdMedecin() {
      return this.hosprtIdMedecin;
   }

   public void setHosprtIdMedecin(long var1) {
      this.hosprtIdMedecin = var1;
   }

   public long getHosprtIdSejour() {
      return this.hosprtIdSejour;
   }

   public void setHosprtIdSejour(long var1) {
      this.hosprtIdSejour = var1;
   }

   public String getHosprtLettre() {
      return this.hosprtLettre;
   }

   public void setHosprtLettre(String var1) {
      this.hosprtLettre = var1;
   }

   public String getHosprtLibelle() {
      return this.hosprtLibelle;
   }

   public void setHosprtLibelle(String var1) {
      this.hosprtLibelle = var1;
   }

   public String getHosprtMedecin() {
      return this.hosprtMedecin;
   }

   public void setHosprtMedecin(String var1) {
      this.hosprtMedecin = var1;
   }

   public float getHosprtNb() {
      return this.hosprtNb;
   }

   public void setHosprtNb(float var1) {
      this.hosprtNb = var1;
   }

   public double getHosprtPatientHt() {
      return this.hosprtPatientHt;
   }

   public void setHosprtPatientHt(double var1) {
      this.hosprtPatientHt = var1;
   }

   public double getHosprtPatientTaxe() {
      return this.hosprtPatientTaxe;
   }

   public void setHosprtPatientTaxe(double var1) {
      this.hosprtPatientTaxe = var1;
   }

   public String getHosprtProduit() {
      return this.hosprtProduit;
   }

   public void setHosprtProduit(String var1) {
      this.hosprtProduit = var1;
   }

   public double getHosprtPu() {
      return this.hosprtPu;
   }

   public void setHosprtPu(double var1) {
      this.hosprtPu = var1;
   }

   public double getHosprtPuRem() {
      return this.hosprtPuRem;
   }

   public void setHosprtPuRem(double var1) {
      this.hosprtPuRem = var1;
   }

   public float getHosprtQte() {
      return this.hosprtQte;
   }

   public void setHosprtQte(float var1) {
      this.hosprtQte = var1;
   }

   public float getHosprtRemise() {
      return this.hosprtRemise;
   }

   public void setHosprtRemise(float var1) {
      this.hosprtRemise = var1;
   }

   public double getHosprtSocieteHt() {
      return this.hosprtSocieteHt;
   }

   public void setHosprtSocieteHt(double var1) {
      this.hosprtSocieteHt = var1;
   }

   public double getHosprtSocieteTaxe() {
      return this.hosprtSocieteTaxe;
   }

   public void setHosprtSocieteTaxe(double var1) {
      this.hosprtSocieteTaxe = var1;
   }

   public float getHosprtTauxTva() {
      return this.hosprtTauxTva;
   }

   public void setHosprtTauxTva(float var1) {
      this.hosprtTauxTva = var1;
   }

   public double getHosprtTaxe() {
      return this.hosprtTaxe;
   }

   public void setHosprtTaxe(double var1) {
      this.hosprtTaxe = var1;
   }

   public double getHosprtTotal() {
      return this.hosprtTotal;
   }

   public void setHosprtTotal(double var1) {
      this.hosprtTotal = var1;
   }

   public double getHosprtValeur() {
      return this.hosprtValeur;
   }

   public void setHosprtValeur(double var1) {
      this.hosprtValeur = var1;
   }

   public float getHosprtNbCnamgs() {
      return this.hosprtNbCnamgs;
   }

   public void setHosprtNbCnamgs(float var1) {
      this.hosprtNbCnamgs = var1;
   }

   public double getHosprtPuAssurance() {
      return this.hosprtPuAssurance;
   }

   public void setHosprtPuAssurance(double var1) {
      this.hosprtPuAssurance = var1;
   }

   public double getHosprtPuCnamgs() {
      return this.hosprtPuCnamgs;
   }

   public void setHosprtPuCnamgs(double var1) {
      this.hosprtPuCnamgs = var1;
   }

   public double getHosprtValeurCnamgs() {
      return this.hosprtValeurCnamgs;
   }

   public void setHosprtValeurCnamgs(double var1) {
      this.hosprtValeurCnamgs = var1;
   }

   public double getHosprtRegPatient() {
      return this.hosprtRegPatient;
   }

   public void setHosprtRegPatient(double var1) {
      this.hosprtRegPatient = var1;
   }

   public double getHosprtRegTiers() {
      return this.hosprtRegTiers;
   }

   public void setHosprtRegTiers(double var1) {
      this.hosprtRegTiers = var1;
   }

   public Date getHosprtDateCreat() {
      return this.hosprtDateCreat;
   }

   public void setHosprtDateCreat(Date var1) {
      this.hosprtDateCreat = var1;
   }

   public Date getHosprtDateModif() {
      return this.hosprtDateModif;
   }

   public void setHosprtDateModif(Date var1) {
      this.hosprtDateModif = var1;
   }

   public long getHosprtUserCreat() {
      return this.hosprtUserCreat;
   }

   public void setHosprtUserCreat(long var1) {
      this.hosprtUserCreat = var1;
   }

   public long getHosprtUserModif() {
      return this.hosprtUserModif;
   }

   public void setHosprtUserModif(long var1) {
      this.hosprtUserModif = var1;
   }

   public double getHosprtRabais() {
      return this.hosprtRabais;
   }

   public void setHosprtRabais(double var1) {
      this.hosprtRabais = var1;
   }
}
