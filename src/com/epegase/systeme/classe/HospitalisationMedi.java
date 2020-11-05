package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class HospitalisationMedi implements Serializable {
   private long hosmedId;
   private Date hosmedDateCreat;
   private Date hosmedDateModif;
   private long hosmedUserCreat;
   private long hosmedUserModif;
   private long hosmedIdMedecin;
   private String hosmedMedecin;
   private String hosmedService;
   private String hosmedProduit;
   private String hosmedFamille;
   private String hosmedLibelle;
   private float hosmedCoef;
   private double hosmedPu;
   private double hosmedPuCnamgs;
   private double hosmedPuAssurance;
   private double hosmedPump;
   private float hosmedRemise;
   private double hosmedRabais;
   private double hosmedPuRem;
   private String hosmedDepot;
   private float hosmedQte;
   private float hosmedStock;
   private double hosmedPatientHt;
   private double hosmedPatientTaxe;
   private double hosmedSocieteHt;
   private double hosmedSocieteTaxe;
   private double hosmedAssuranceHt;
   private double hosmedAssuranceTaxe;
   private double hosmedComplementaireHt;
   private double hosmedComplementaireTaxe;
   private double hosmedTotal;
   private double hosmedTaxe;
   private float hosmedTauxTva;
   private String hosmedCodeTva;
   private long hosmedIdSejour;
   private double hosmedRegPatient;
   private double hosmedRegTiers;
   private HospitalisationEntete hospitalisationEntete;
   private double totalTiers;
   private double totalPatient;

   public double getTotalTiers() {
      this.totalTiers = this.hosmedSocieteHt + this.hosmedSocieteTaxe + this.hosmedAssuranceHt + this.hosmedAssuranceTaxe + this.hosmedComplementaireHt + this.hosmedComplementaireTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.hosmedPatientHt + this.hosmedPatientTaxe;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public double getHosmedAssuranceHt() {
      return this.hosmedAssuranceHt;
   }

   public void setHosmedAssuranceHt(double var1) {
      this.hosmedAssuranceHt = var1;
   }

   public double getHosmedAssuranceTaxe() {
      return this.hosmedAssuranceTaxe;
   }

   public void setHosmedAssuranceTaxe(double var1) {
      this.hosmedAssuranceTaxe = var1;
   }

   public String getHosmedCodeTva() {
      return this.hosmedCodeTva;
   }

   public void setHosmedCodeTva(String var1) {
      this.hosmedCodeTva = var1;
   }

   public double getHosmedComplementaireHt() {
      return this.hosmedComplementaireHt;
   }

   public void setHosmedComplementaireHt(double var1) {
      this.hosmedComplementaireHt = var1;
   }

   public double getHosmedComplementaireTaxe() {
      return this.hosmedComplementaireTaxe;
   }

   public void setHosmedComplementaireTaxe(double var1) {
      this.hosmedComplementaireTaxe = var1;
   }

   public String getHosmedDepot() {
      return this.hosmedDepot;
   }

   public void setHosmedDepot(String var1) {
      this.hosmedDepot = var1;
   }

   public long getHosmedId() {
      return this.hosmedId;
   }

   public void setHosmedId(long var1) {
      this.hosmedId = var1;
   }

   public long getHosmedIdMedecin() {
      return this.hosmedIdMedecin;
   }

   public void setHosmedIdMedecin(long var1) {
      this.hosmedIdMedecin = var1;
   }

   public String getHosmedLibelle() {
      return this.hosmedLibelle;
   }

   public void setHosmedLibelle(String var1) {
      this.hosmedLibelle = var1;
   }

   public String getHosmedMedecin() {
      return this.hosmedMedecin;
   }

   public void setHosmedMedecin(String var1) {
      this.hosmedMedecin = var1;
   }

   public double getHosmedPatientHt() {
      return this.hosmedPatientHt;
   }

   public void setHosmedPatientHt(double var1) {
      this.hosmedPatientHt = var1;
   }

   public double getHosmedPatientTaxe() {
      return this.hosmedPatientTaxe;
   }

   public void setHosmedPatientTaxe(double var1) {
      this.hosmedPatientTaxe = var1;
   }

   public String getHosmedProduit() {
      return this.hosmedProduit;
   }

   public void setHosmedProduit(String var1) {
      this.hosmedProduit = var1;
   }

   public double getHosmedPu() {
      return this.hosmedPu;
   }

   public void setHosmedPu(double var1) {
      this.hosmedPu = var1;
   }

   public double getHosmedPuRem() {
      return this.hosmedPuRem;
   }

   public void setHosmedPuRem(double var1) {
      this.hosmedPuRem = var1;
   }

   public float getHosmedQte() {
      return this.hosmedQte;
   }

   public void setHosmedQte(float var1) {
      this.hosmedQte = var1;
   }

   public float getHosmedRemise() {
      return this.hosmedRemise;
   }

   public void setHosmedRemise(float var1) {
      this.hosmedRemise = var1;
   }

   public String getHosmedService() {
      return this.hosmedService;
   }

   public void setHosmedService(String var1) {
      this.hosmedService = var1;
   }

   public double getHosmedSocieteHt() {
      return this.hosmedSocieteHt;
   }

   public void setHosmedSocieteHt(double var1) {
      this.hosmedSocieteHt = var1;
   }

   public double getHosmedSocieteTaxe() {
      return this.hosmedSocieteTaxe;
   }

   public void setHosmedSocieteTaxe(double var1) {
      this.hosmedSocieteTaxe = var1;
   }

   public float getHosmedTauxTva() {
      return this.hosmedTauxTva;
   }

   public void setHosmedTauxTva(float var1) {
      this.hosmedTauxTva = var1;
   }

   public double getHosmedTaxe() {
      return this.hosmedTaxe;
   }

   public void setHosmedTaxe(double var1) {
      this.hosmedTaxe = var1;
   }

   public double getHosmedTotal() {
      return this.hosmedTotal;
   }

   public void setHosmedTotal(double var1) {
      this.hosmedTotal = var1;
   }

   public long getHosmedIdSejour() {
      return this.hosmedIdSejour;
   }

   public void setHosmedIdSejour(long var1) {
      this.hosmedIdSejour = var1;
   }

   public HospitalisationEntete getHospitalisationEntete() {
      return this.hospitalisationEntete;
   }

   public void setHospitalisationEntete(HospitalisationEntete var1) {
      this.hospitalisationEntete = var1;
   }

   public String getHosmedFamille() {
      return this.hosmedFamille;
   }

   public void setHosmedFamille(String var1) {
      this.hosmedFamille = var1;
   }

   public double getHosmedPump() {
      return this.hosmedPump;
   }

   public void setHosmedPump(double var1) {
      this.hosmedPump = var1;
   }

   public float getHosmedStock() {
      return this.hosmedStock;
   }

   public void setHosmedStock(float var1) {
      this.hosmedStock = var1;
   }

   public double getHosmedPuAssurance() {
      return this.hosmedPuAssurance;
   }

   public void setHosmedPuAssurance(double var1) {
      this.hosmedPuAssurance = var1;
   }

   public double getHosmedPuCnamgs() {
      return this.hosmedPuCnamgs;
   }

   public void setHosmedPuCnamgs(double var1) {
      this.hosmedPuCnamgs = var1;
   }

   public float getHosmedCoef() {
      return this.hosmedCoef;
   }

   public void setHosmedCoef(float var1) {
      this.hosmedCoef = var1;
   }

   public double getHosmedRegPatient() {
      return this.hosmedRegPatient;
   }

   public void setHosmedRegPatient(double var1) {
      this.hosmedRegPatient = var1;
   }

   public double getHosmedRegTiers() {
      return this.hosmedRegTiers;
   }

   public void setHosmedRegTiers(double var1) {
      this.hosmedRegTiers = var1;
   }

   public Date getHosmedDateCreat() {
      return this.hosmedDateCreat;
   }

   public void setHosmedDateCreat(Date var1) {
      this.hosmedDateCreat = var1;
   }

   public Date getHosmedDateModif() {
      return this.hosmedDateModif;
   }

   public void setHosmedDateModif(Date var1) {
      this.hosmedDateModif = var1;
   }

   public long getHosmedUserCreat() {
      return this.hosmedUserCreat;
   }

   public void setHosmedUserCreat(long var1) {
      this.hosmedUserCreat = var1;
   }

   public long getHosmedUserModif() {
      return this.hosmedUserModif;
   }

   public void setHosmedUserModif(long var1) {
      this.hosmedUserModif = var1;
   }

   public double getHosmedRabais() {
      return this.hosmedRabais;
   }

   public void setHosmedRabais(double var1) {
      this.hosmedRabais = var1;
   }
}
