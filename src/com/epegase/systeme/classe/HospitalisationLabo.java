package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class HospitalisationLabo implements Serializable {
   private long hoslabId;
   private Date hoslabDateCreat;
   private Date hoslabDateModif;
   private long hoslabUserCreat;
   private long hoslabUserModif;
   private long hoslabIdMedecin;
   private String hoslabMedecin;
   private String hoslabService;
   private String hoslabLaboratoire;
   private long hoslabIdLaboratoire;
   private String hoslabProduit;
   private String hoslabLibelle;
   private String hoslabLettre;
   private float hoslabNb;
   private float hoslabNbCnamgs;
   private double hoslabValeur;
   private double hoslabValeurCnamgs;
   private float hoslabCoef;
   private double hoslabPu;
   private double hoslabPuCnamgs;
   private double hoslabPuAssurance;
   private float hoslabRemise;
   private double hoslabRabais;
   private double hoslabPuRem;
   private float hoslabQte;
   private double hoslabPatientHt;
   private double hoslabPatientTaxe;
   private double hoslabSocieteHt;
   private double hoslabSocieteTaxe;
   private double hoslabAssuranceHt;
   private double hoslabAssuranceTaxe;
   private double hoslabComplementaireHt;
   private double hoslabComplementaireTaxe;
   private double hoslabTotal;
   private double hoslabTaxe;
   private float hoslabTauxTva;
   private String hoslabCodeTva;
   private long hoslabIdSejour;
   private Date hoslabDateResultat;
   private Date hoslabDatePrelevement;
   private int hoslabLieuPrelevement;
   private int hoslabPartenaire;
   private Date hoslabDateRegles;
   private boolean hoslabAnonyme;
   private boolean hoslabGrossesse;
   private boolean hoslabDiabete;
   private boolean hoslabImmunodepressif;
   private boolean hoslabTraitement;
   private String hoslabLequel;
   private int hoslabUrgent;
   private double hoslabRegPatient;
   private double hoslabRegTiers;
   private HospitalisationEntete hospitalisationEntete;
   private double totalTiers;
   private double totalPatient;

   public double getTotalTiers() {
      this.totalTiers = this.hoslabSocieteHt + this.hoslabSocieteTaxe + this.hoslabAssuranceHt + this.hoslabAssuranceTaxe + this.hoslabComplementaireHt + this.hoslabComplementaireTaxe;
      return this.totalTiers;
   }

   public void setTotalTiers(double var1) {
      this.totalTiers = var1;
   }

   public double getTotalPatient() {
      this.totalPatient = this.hoslabPatientHt + this.hoslabPatientTaxe;
      return this.totalPatient;
   }

   public void setTotalPatient(double var1) {
      this.totalPatient = var1;
   }

   public double getHoslabAssuranceHt() {
      return this.hoslabAssuranceHt;
   }

   public void setHoslabAssuranceHt(double var1) {
      this.hoslabAssuranceHt = var1;
   }

   public double getHoslabAssuranceTaxe() {
      return this.hoslabAssuranceTaxe;
   }

   public void setHoslabAssuranceTaxe(double var1) {
      this.hoslabAssuranceTaxe = var1;
   }

   public String getHoslabCodeTva() {
      return this.hoslabCodeTva;
   }

   public void setHoslabCodeTva(String var1) {
      this.hoslabCodeTva = var1;
   }

   public float getHoslabCoef() {
      return this.hoslabCoef;
   }

   public void setHoslabCoef(float var1) {
      this.hoslabCoef = var1;
   }

   public double getHoslabComplementaireHt() {
      return this.hoslabComplementaireHt;
   }

   public void setHoslabComplementaireHt(double var1) {
      this.hoslabComplementaireHt = var1;
   }

   public double getHoslabComplementaireTaxe() {
      return this.hoslabComplementaireTaxe;
   }

   public void setHoslabComplementaireTaxe(double var1) {
      this.hoslabComplementaireTaxe = var1;
   }

   public long getHoslabId() {
      return this.hoslabId;
   }

   public void setHoslabId(long var1) {
      this.hoslabId = var1;
   }

   public long getHoslabIdMedecin() {
      return this.hoslabIdMedecin;
   }

   public void setHoslabIdMedecin(long var1) {
      this.hoslabIdMedecin = var1;
   }

   public String getHoslabLettre() {
      return this.hoslabLettre;
   }

   public void setHoslabLettre(String var1) {
      this.hoslabLettre = var1;
   }

   public String getHoslabLibelle() {
      return this.hoslabLibelle;
   }

   public void setHoslabLibelle(String var1) {
      this.hoslabLibelle = var1;
   }

   public String getHoslabMedecin() {
      return this.hoslabMedecin;
   }

   public void setHoslabMedecin(String var1) {
      this.hoslabMedecin = var1;
   }

   public float getHoslabNb() {
      return this.hoslabNb;
   }

   public void setHoslabNb(float var1) {
      this.hoslabNb = var1;
   }

   public double getHoslabPatientHt() {
      return this.hoslabPatientHt;
   }

   public void setHoslabPatientHt(double var1) {
      this.hoslabPatientHt = var1;
   }

   public double getHoslabPatientTaxe() {
      return this.hoslabPatientTaxe;
   }

   public void setHoslabPatientTaxe(double var1) {
      this.hoslabPatientTaxe = var1;
   }

   public String getHoslabProduit() {
      return this.hoslabProduit;
   }

   public void setHoslabProduit(String var1) {
      this.hoslabProduit = var1;
   }

   public double getHoslabPu() {
      return this.hoslabPu;
   }

   public void setHoslabPu(double var1) {
      this.hoslabPu = var1;
   }

   public double getHoslabPuRem() {
      return this.hoslabPuRem;
   }

   public void setHoslabPuRem(double var1) {
      this.hoslabPuRem = var1;
   }

   public float getHoslabQte() {
      return this.hoslabQte;
   }

   public void setHoslabQte(float var1) {
      this.hoslabQte = var1;
   }

   public float getHoslabRemise() {
      return this.hoslabRemise;
   }

   public void setHoslabRemise(float var1) {
      this.hoslabRemise = var1;
   }

   public String getHoslabService() {
      return this.hoslabService;
   }

   public void setHoslabService(String var1) {
      this.hoslabService = var1;
   }

   public double getHoslabSocieteHt() {
      return this.hoslabSocieteHt;
   }

   public void setHoslabSocieteHt(double var1) {
      this.hoslabSocieteHt = var1;
   }

   public double getHoslabSocieteTaxe() {
      return this.hoslabSocieteTaxe;
   }

   public void setHoslabSocieteTaxe(double var1) {
      this.hoslabSocieteTaxe = var1;
   }

   public float getHoslabTauxTva() {
      return this.hoslabTauxTva;
   }

   public void setHoslabTauxTva(float var1) {
      this.hoslabTauxTva = var1;
   }

   public double getHoslabTaxe() {
      return this.hoslabTaxe;
   }

   public void setHoslabTaxe(double var1) {
      this.hoslabTaxe = var1;
   }

   public double getHoslabTotal() {
      return this.hoslabTotal;
   }

   public void setHoslabTotal(double var1) {
      this.hoslabTotal = var1;
   }

   public double getHoslabValeur() {
      return this.hoslabValeur;
   }

   public void setHoslabValeur(double var1) {
      this.hoslabValeur = var1;
   }

   public long getHoslabIdSejour() {
      return this.hoslabIdSejour;
   }

   public void setHoslabIdSejour(long var1) {
      this.hoslabIdSejour = var1;
   }

   public HospitalisationEntete getHospitalisationEntete() {
      return this.hospitalisationEntete;
   }

   public void setHospitalisationEntete(HospitalisationEntete var1) {
      this.hospitalisationEntete = var1;
   }

   public float getHoslabNbCnamgs() {
      return this.hoslabNbCnamgs;
   }

   public void setHoslabNbCnamgs(float var1) {
      this.hoslabNbCnamgs = var1;
   }

   public double getHoslabPuAssurance() {
      return this.hoslabPuAssurance;
   }

   public void setHoslabPuAssurance(double var1) {
      this.hoslabPuAssurance = var1;
   }

   public double getHoslabPuCnamgs() {
      return this.hoslabPuCnamgs;
   }

   public void setHoslabPuCnamgs(double var1) {
      this.hoslabPuCnamgs = var1;
   }

   public double getHoslabValeurCnamgs() {
      return this.hoslabValeurCnamgs;
   }

   public void setHoslabValeurCnamgs(double var1) {
      this.hoslabValeurCnamgs = var1;
   }

   public String getHoslabLaboratoire() {
      return this.hoslabLaboratoire;
   }

   public void setHoslabLaboratoire(String var1) {
      this.hoslabLaboratoire = var1;
   }

   public long getHoslabIdLaboratoire() {
      return this.hoslabIdLaboratoire;
   }

   public void setHoslabIdLaboratoire(long var1) {
      this.hoslabIdLaboratoire = var1;
   }

   public boolean isHoslabAnonyme() {
      return this.hoslabAnonyme;
   }

   public void setHoslabAnonyme(boolean var1) {
      this.hoslabAnonyme = var1;
   }

   public Date getHoslabDatePrelevement() {
      return this.hoslabDatePrelevement;
   }

   public void setHoslabDatePrelevement(Date var1) {
      this.hoslabDatePrelevement = var1;
   }

   public Date getHoslabDateRegles() {
      return this.hoslabDateRegles;
   }

   public void setHoslabDateRegles(Date var1) {
      this.hoslabDateRegles = var1;
   }

   public Date getHoslabDateResultat() {
      return this.hoslabDateResultat;
   }

   public void setHoslabDateResultat(Date var1) {
      this.hoslabDateResultat = var1;
   }

   public int getHoslabLieuPrelevement() {
      return this.hoslabLieuPrelevement;
   }

   public void setHoslabLieuPrelevement(int var1) {
      this.hoslabLieuPrelevement = var1;
   }

   public int getHoslabPartenaire() {
      return this.hoslabPartenaire;
   }

   public void setHoslabPartenaire(int var1) {
      this.hoslabPartenaire = var1;
   }

   public boolean isHoslabDiabete() {
      return this.hoslabDiabete;
   }

   public void setHoslabDiabete(boolean var1) {
      this.hoslabDiabete = var1;
   }

   public boolean isHoslabGrossesse() {
      return this.hoslabGrossesse;
   }

   public void setHoslabGrossesse(boolean var1) {
      this.hoslabGrossesse = var1;
   }

   public boolean isHoslabImmunodepressif() {
      return this.hoslabImmunodepressif;
   }

   public void setHoslabImmunodepressif(boolean var1) {
      this.hoslabImmunodepressif = var1;
   }

   public String getHoslabLequel() {
      return this.hoslabLequel;
   }

   public void setHoslabLequel(String var1) {
      this.hoslabLequel = var1;
   }

   public boolean isHoslabTraitement() {
      return this.hoslabTraitement;
   }

   public void setHoslabTraitement(boolean var1) {
      this.hoslabTraitement = var1;
   }

   public int getHoslabUrgent() {
      return this.hoslabUrgent;
   }

   public void setHoslabUrgent(int var1) {
      this.hoslabUrgent = var1;
   }

   public double getHoslabRegPatient() {
      return this.hoslabRegPatient;
   }

   public void setHoslabRegPatient(double var1) {
      this.hoslabRegPatient = var1;
   }

   public double getHoslabRegTiers() {
      return this.hoslabRegTiers;
   }

   public void setHoslabRegTiers(double var1) {
      this.hoslabRegTiers = var1;
   }

   public Date getHoslabDateCreat() {
      return this.hoslabDateCreat;
   }

   public void setHoslabDateCreat(Date var1) {
      this.hoslabDateCreat = var1;
   }

   public Date getHoslabDateModif() {
      return this.hoslabDateModif;
   }

   public void setHoslabDateModif(Date var1) {
      this.hoslabDateModif = var1;
   }

   public long getHoslabUserCreat() {
      return this.hoslabUserCreat;
   }

   public void setHoslabUserCreat(long var1) {
      this.hoslabUserCreat = var1;
   }

   public long getHoslabUserModif() {
      return this.hoslabUserModif;
   }

   public void setHoslabUserModif(long var1) {
      this.hoslabUserModif = var1;
   }

   public double getHoslabRabais() {
      return this.hoslabRabais;
   }

   public void setHoslabRabais(double var1) {
      this.hoslabRabais = var1;
   }
}
