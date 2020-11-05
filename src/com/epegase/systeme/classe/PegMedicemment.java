package com.epegase.systeme.classe;

import java.io.Serializable;

public class PegMedicemment implements Serializable {
   private long medId;
   private String medCip;
   private String medCophase;
   private String medDci;
   private String medDosage;
   private String medSpecialite;
   private String medForme;
   private String medClasse;
   private double medPrixLoc;
   private String medListe;
   private String medLaboratoire;
   private int medType;
   private int medMe;

   public String getMedCip() {
      return this.medCip;
   }

   public void setMedCip(String var1) {
      this.medCip = var1;
   }

   public String getMedClasse() {
      return this.medClasse;
   }

   public void setMedClasse(String var1) {
      this.medClasse = var1;
   }

   public String getMedCophase() {
      return this.medCophase;
   }

   public void setMedCophase(String var1) {
      this.medCophase = var1;
   }

   public String getMedDci() {
      return this.medDci;
   }

   public void setMedDci(String var1) {
      this.medDci = var1;
   }

   public String getMedDosage() {
      return this.medDosage;
   }

   public void setMedDosage(String var1) {
      this.medDosage = var1;
   }

   public String getMedForme() {
      return this.medForme;
   }

   public void setMedForme(String var1) {
      this.medForme = var1;
   }

   public long getMedId() {
      return this.medId;
   }

   public void setMedId(long var1) {
      this.medId = var1;
   }

   public String getMedLaboratoire() {
      return this.medLaboratoire;
   }

   public void setMedLaboratoire(String var1) {
      this.medLaboratoire = var1;
   }

   public String getMedListe() {
      return this.medListe;
   }

   public void setMedListe(String var1) {
      this.medListe = var1;
   }

   public int getMedMe() {
      return this.medMe;
   }

   public void setMedMe(int var1) {
      this.medMe = var1;
   }

   public double getMedPrixLoc() {
      return this.medPrixLoc;
   }

   public void setMedPrixLoc(double var1) {
      this.medPrixLoc = var1;
   }

   public String getMedSpecialite() {
      return this.medSpecialite;
   }

   public void setMedSpecialite(String var1) {
      this.medSpecialite = var1;
   }

   public int getMedType() {
      return this.medType;
   }

   public void setMedType(int var1) {
      this.medType = var1;
   }
}
