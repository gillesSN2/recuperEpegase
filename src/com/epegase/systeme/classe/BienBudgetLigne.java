package com.epegase.systeme.classe;

import java.io.Serializable;

public class BienBudgetLigne implements Serializable {
   private long biebudligId;
   private String biebudligCode;
   private String biebudligLibelle;
   private double biebudligResteAnterieur;
   private double biebudligMontant;
   private double biebudligDepenses;
   private double biebudligDepensesNonImpute;
   private double biebudligEcart;
   private float biebudligRealisation;
   private int biebudligType;
   private BienBudgetEntete bienBudgetEntete;
   private String libelleType;

   public BienBudgetEntete getBienBudgetEntete() {
      return this.bienBudgetEntete;
   }

   public void setBienBudgetEntete(BienBudgetEntete var1) {
      this.bienBudgetEntete = var1;
   }

   public String getLibelleType() {
      if (this.biebudligType == 0) {
         this.libelleType = "Fact.Travaux";
      } else if (this.biebudligType == 1) {
         this.libelleType = "Fact.Directe";
      } else if (this.biebudligType == 2) {
         this.libelleType = "Paye";
      } else if (this.biebudligType == 9) {
         this.libelleType = "Mixte";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getBiebudligCode() {
      return this.biebudligCode;
   }

   public void setBiebudligCode(String var1) {
      this.biebudligCode = var1;
   }

   public double getBiebudligDepenses() {
      return this.biebudligDepenses;
   }

   public void setBiebudligDepenses(double var1) {
      this.biebudligDepenses = var1;
   }

   public double getBiebudligEcart() {
      return this.biebudligEcart;
   }

   public void setBiebudligEcart(double var1) {
      this.biebudligEcart = var1;
   }

   public long getBiebudligId() {
      return this.biebudligId;
   }

   public void setBiebudligId(long var1) {
      this.biebudligId = var1;
   }

   public String getBiebudligLibelle() {
      return this.biebudligLibelle;
   }

   public void setBiebudligLibelle(String var1) {
      this.biebudligLibelle = var1;
   }

   public double getBiebudligMontant() {
      return this.biebudligMontant;
   }

   public void setBiebudligMontant(double var1) {
      this.biebudligMontant = var1;
   }

   public float getBiebudligRealisation() {
      return this.biebudligRealisation;
   }

   public void setBiebudligRealisation(float var1) {
      this.biebudligRealisation = var1;
   }

   public double getBiebudligResteAnterieur() {
      return this.biebudligResteAnterieur;
   }

   public void setBiebudligResteAnterieur(double var1) {
      this.biebudligResteAnterieur = var1;
   }

   public int getBiebudligType() {
      return this.biebudligType;
   }

   public void setBiebudligType(int var1) {
      this.biebudligType = var1;
   }

   public double getBiebudligDepensesNonImpute() {
      return this.biebudligDepensesNonImpute;
   }

   public void setBiebudligDepensesNonImpute(double var1) {
      this.biebudligDepensesNonImpute = var1;
   }
}
