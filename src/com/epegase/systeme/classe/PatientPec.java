package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PatientPec implements Serializable {
   private long patpecId;
   private String patpecType;
   private String patpecNumContrat;
   private String patpecMatricule;
   private Date patpecDateDebut;
   private Date patpecDateFin;
   private double patpecHebergementPlaf;
   private float patpecHebergementRep;
   private float patpecSoins;
   private float patpecExamenss;
   private float patpecExamenssHospit;
   private float patpecSoinsHospit;
   private float patpecPrestations;
   private float patpecDentaire;
   private float patpecOcculaire;
   private float patpecMedicament;
   private float patpecMedicamentHospit;
   private float patpacHotelerie;
   private float patpecForfait;
   private int patpecInactif;
   private String patpecNumCnss;
   private String patpecNumCnamgs;
   private long patpecIdCouvert;
   private String patpecNomCouvert;
   private String patpecMatriculeCouvert;
   private String patpecAgentRefact;
   private long patpecIdEmployeur;
   private String patpecNomEmployeur;
   private String patpecScan;
   private Patients patient;
   private Tiers tiers;

   public float getPatpecMedicament() {
      return this.patpecMedicament;
   }

   public void setPatpecMedicament(float var1) {
      this.patpecMedicament = var1;
   }

   public String getPatpecAgentRefact() {
      return this.patpecAgentRefact;
   }

   public void setPatpecAgentRefact(String var1) {
      this.patpecAgentRefact = var1;
   }

   public String getPatpecNumCnss() {
      return this.patpecNumCnss;
   }

   public void setPatpecNumCnss(String var1) {
      this.patpecNumCnss = var1;
   }

   public long getPatpecIdCouvert() {
      return this.patpecIdCouvert;
   }

   public void setPatpecIdCouvert(long var1) {
      this.patpecIdCouvert = var1;
   }

   public String getPatpecNomCouvert() {
      return this.patpecNomCouvert;
   }

   public void setPatpecNomCouvert(String var1) {
      this.patpecNomCouvert = var1;
   }

   public Patients getPatient() {
      return this.patient;
   }

   public void setPatient(Patients var1) {
      this.patient = var1;
   }

   public Date getPatpecDateDebut() {
      return this.patpecDateDebut;
   }

   public void setPatpecDateDebut(Date var1) {
      this.patpecDateDebut = var1;
   }

   public Date getPatpecDateFin() {
      return this.patpecDateFin;
   }

   public void setPatpecDateFin(Date var1) {
      this.patpecDateFin = var1;
   }

   public long getPatpecId() {
      return this.patpecId;
   }

   public void setPatpecId(long var1) {
      this.patpecId = var1;
   }

   public String getPatpecNumContrat() {
      return this.patpecNumContrat;
   }

   public void setPatpecNumContrat(String var1) {
      this.patpecNumContrat = var1;
   }

   public float getPatpacHotelerie() {
      return this.patpacHotelerie;
   }

   public void setPatpacHotelerie(float var1) {
      this.patpacHotelerie = var1;
   }

   public float getPatpecExamenss() {
      return this.patpecExamenss;
   }

   public void setPatpecExamenss(float var1) {
      this.patpecExamenss = var1;
   }

   public float getPatpecForfait() {
      return this.patpecForfait;
   }

   public void setPatpecForfait(float var1) {
      this.patpecForfait = var1;
   }

   public double getPatpecHebergementPlaf() {
      return this.patpecHebergementPlaf;
   }

   public void setPatpecHebergementPlaf(double var1) {
      this.patpecHebergementPlaf = var1;
   }

   public String getPatpecType() {
      return this.patpecType;
   }

   public void setPatpecType(String var1) {
      this.patpecType = var1;
   }

   public float getPatpecHebergementRep() {
      return this.patpecHebergementRep;
   }

   public void setPatpecHebergementRep(float var1) {
      this.patpecHebergementRep = var1;
   }

   public int getPatpecInactif() {
      return this.patpecInactif;
   }

   public void setPatpecInactif(int var1) {
      this.patpecInactif = var1;
   }

   public float getPatpecPrestations() {
      return this.patpecPrestations;
   }

   public void setPatpecPrestations(float var1) {
      this.patpecPrestations = var1;
   }

   public float getPatpecSoins() {
      return this.patpecSoins;
   }

   public void setPatpecSoins(float var1) {
      this.patpecSoins = var1;
   }

   public float getPatpecDentaire() {
      return this.patpecDentaire;
   }

   public void setPatpecDentaire(float var1) {
      this.patpecDentaire = var1;
   }

   public float getPatpecOcculaire() {
      return this.patpecOcculaire;
   }

   public void setPatpecOcculaire(float var1) {
      this.patpecOcculaire = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public String getPatpecNumCnamgs() {
      return this.patpecNumCnamgs;
   }

   public void setPatpecNumCnamgs(String var1) {
      this.patpecNumCnamgs = var1;
   }

   public long getPatpecIdEmployeur() {
      return this.patpecIdEmployeur;
   }

   public void setPatpecIdEmployeur(long var1) {
      this.patpecIdEmployeur = var1;
   }

   public String getPatpecNomEmployeur() {
      return this.patpecNomEmployeur;
   }

   public void setPatpecNomEmployeur(String var1) {
      this.patpecNomEmployeur = var1;
   }

   public String getPatpecMatricule() {
      return this.patpecMatricule;
   }

   public void setPatpecMatricule(String var1) {
      this.patpecMatricule = var1;
   }

   public String getPatpecMatriculeCouvert() {
      return this.patpecMatriculeCouvert;
   }

   public void setPatpecMatriculeCouvert(String var1) {
      this.patpecMatriculeCouvert = var1;
   }

   public String getPatpecScan() {
      return this.patpecScan;
   }

   public void setPatpecScan(String var1) {
      this.patpecScan = var1;
   }

   public float getPatpecSoinsHospit() {
      return this.patpecSoinsHospit;
   }

   public void setPatpecSoinsHospit(float var1) {
      this.patpecSoinsHospit = var1;
   }

   public float getPatpecExamenssHospit() {
      return this.patpecExamenssHospit;
   }

   public void setPatpecExamenssHospit(float var1) {
      this.patpecExamenssHospit = var1;
   }

   public float getPatpecMedicamentHospit() {
      return this.patpecMedicamentHospit;
   }

   public void setPatpecMedicamentHospit(float var1) {
      this.patpecMedicamentHospit = var1;
   }
}
