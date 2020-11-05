package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TaxesAchats implements Serializable {
   private long taxachId;
   private Date taxachDateCreation;
   private Date taxachDateModif;
   private long taxachUserCreation;
   private long taxachUserModif;
   private String taxachCode;
   private String taxachLibelleFr;
   private String taxachLibelleUk;
   private String taxachLibelleSp;
   private float taxachTaux;
   private String taxachCompte;
   private int taxachType;
   private int taxachTimbre;
   private int taxachTc;
   private int taxachInactif;
   private ExercicesAchats exercicesachats;
   private String etat;
   private boolean afficheImag;

   public ExercicesAchats getExercicesachats() {
      return this.exercicesachats;
   }

   public void setExercicesachats(ExercicesAchats var1) {
      this.exercicesachats = var1;
   }

   public String getTaxachCode() {
      if (this.taxachCode != null && !this.taxachCode.isEmpty()) {
         this.taxachCode = this.taxachCode.toUpperCase();
      }

      return this.taxachCode;
   }

   public void setTaxachCode(String var1) {
      this.taxachCode = var1;
   }

   public String getTaxachCompte() {
      return this.taxachCompte;
   }

   public void setTaxachCompte(String var1) {
      this.taxachCompte = var1;
   }

   public Date getTaxachDateCreation() {
      return this.taxachDateCreation;
   }

   public void setTaxachDateCreation(Date var1) {
      this.taxachDateCreation = var1;
   }

   public Date getTaxachDateModif() {
      return this.taxachDateModif;
   }

   public void setTaxachDateModif(Date var1) {
      this.taxachDateModif = var1;
   }

   public long getTaxachId() {
      return this.taxachId;
   }

   public void setTaxachId(long var1) {
      this.taxachId = var1;
   }

   public String getTaxachLibelleFr() {
      if (this.taxachLibelleFr != null && !this.taxachLibelleFr.isEmpty()) {
         this.taxachLibelleFr = this.taxachLibelleFr.toUpperCase();
      }

      return this.taxachLibelleFr;
   }

   public void setTaxachLibelleFr(String var1) {
      this.taxachLibelleFr = var1;
   }

   public String getTaxachLibelleSp() {
      return this.taxachLibelleSp;
   }

   public void setTaxachLibelleSp(String var1) {
      this.taxachLibelleSp = var1;
   }

   public String getTaxachLibelleUk() {
      return this.taxachLibelleUk;
   }

   public void setTaxachLibelleUk(String var1) {
      this.taxachLibelleUk = var1;
   }

   public float getTaxachTaux() {
      return this.taxachTaux;
   }

   public void setTaxachTaux(float var1) {
      this.taxachTaux = var1;
   }

   public int getTaxachTc() {
      return this.taxachTc;
   }

   public void setTaxachTc(int var1) {
      this.taxachTc = var1;
   }

   public int getTaxachTimbre() {
      return this.taxachTimbre;
   }

   public void setTaxachTimbre(int var1) {
      this.taxachTimbre = var1;
   }

   public int getTaxachType() {
      return this.taxachType;
   }

   public void setTaxachType(int var1) {
      this.taxachType = var1;
   }

   public long getTaxachUserCreation() {
      return this.taxachUserCreation;
   }

   public void setTaxachUserCreation(long var1) {
      this.taxachUserCreation = var1;
   }

   public long getTaxachUserModif() {
      return this.taxachUserModif;
   }

   public void setTaxachUserModif(long var1) {
      this.taxachUserModif = var1;
   }

   public int getTaxachInactif() {
      return this.taxachInactif;
   }

   public void setTaxachInactif(int var1) {
      this.taxachInactif = var1;
   }

   public String getEtat() {
      if (this.taxachInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.taxachInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.taxachInactif != 1 && this.taxachInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }
}
