package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ConventionMedical implements Serializable {
   private long cvnId;
   private Date cvnDateCreat;
   private Date cvnDateModif;
   private long cvnUserCreat;
   private long cvnUserModif;
   private String cvnLettre;
   private String cvnProduit;
   private String cvnLibelle;
   private double cvnValeur;
   private double cvnValeurOrigine;
   private Tiers tiers;

   public Date getCvnDateCreat() {
      return this.cvnDateCreat;
   }

   public void setCvnDateCreat(Date var1) {
      this.cvnDateCreat = var1;
   }

   public Date getCvnDateModif() {
      return this.cvnDateModif;
   }

   public void setCvnDateModif(Date var1) {
      this.cvnDateModif = var1;
   }

   public long getCvnId() {
      return this.cvnId;
   }

   public void setCvnId(long var1) {
      this.cvnId = var1;
   }

   public String getCvnLettre() {
      return this.cvnLettre;
   }

   public void setCvnLettre(String var1) {
      this.cvnLettre = var1;
   }

   public String getCvnLibelle() {
      return this.cvnLibelle;
   }

   public void setCvnLibelle(String var1) {
      this.cvnLibelle = var1;
   }

   public long getCvnUserCreat() {
      return this.cvnUserCreat;
   }

   public void setCvnUserCreat(long var1) {
      this.cvnUserCreat = var1;
   }

   public long getCvnUserModif() {
      return this.cvnUserModif;
   }

   public void setCvnUserModif(long var1) {
      this.cvnUserModif = var1;
   }

   public double getCvnValeur() {
      return this.cvnValeur;
   }

   public void setCvnValeur(double var1) {
      this.cvnValeur = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public String getCvnProduit() {
      return this.cvnProduit;
   }

   public void setCvnProduit(String var1) {
      this.cvnProduit = var1;
   }

   public double getCvnValeurOrigine() {
      return this.cvnValeurOrigine;
   }

   public void setCvnValeurOrigine(double var1) {
      this.cvnValeurOrigine = var1;
   }
}
