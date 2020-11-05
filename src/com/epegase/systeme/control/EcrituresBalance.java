package com.epegase.systeme.control;

import java.io.Serializable;

public class EcrituresBalance implements Serializable {
   private String ecrBalCompte;
   private String ecrBalLibelle;
   private double ecrColNonEchue;
   private double ecrCol0;
   private double ecrCol30;
   private double ecrCol60;
   private double ecrCol90;
   private double ecrCol120;
   private double ecrColSolde;
   private double ecrDebitAN;
   private double ecrCreditAN;
   private double ecartAN;
   private double ecrDebitMVTS;
   private double ecrCreditMVTS;
   private double ecartMVTS;
   private double ecrDebitSOLDE;
   private double ecrCreditSOLDE;
   private long ecrNbJour;
   private String revueCompte;
   private String gras;
   private String poste;
   private String libPoste;

   public String getGras() {
      if (this.ecrBalCompte != null && !this.ecrBalCompte.isEmpty()) {
         this.gras = "";
      } else {
         this.gras = "font-weight:bold;text-align:center";
      }

      return this.gras;
   }

   public void setGras(String var1) {
      this.gras = var1;
   }

   public String getEcrBalCompte() {
      return this.ecrBalCompte;
   }

   public void setEcrBalCompte(String var1) {
      this.ecrBalCompte = var1;
   }

   public String getEcrBalLibelle() {
      return this.ecrBalLibelle;
   }

   public void setEcrBalLibelle(String var1) {
      this.ecrBalLibelle = var1;
   }

   public double getEcrCol120() {
      return this.ecrCol120;
   }

   public void setEcrCol120(double var1) {
      this.ecrCol120 = var1;
   }

   public double getEcrCol30() {
      return this.ecrCol30;
   }

   public void setEcrCol30(double var1) {
      this.ecrCol30 = var1;
   }

   public double getEcrCol60() {
      return this.ecrCol60;
   }

   public void setEcrCol60(double var1) {
      this.ecrCol60 = var1;
   }

   public double getEcrCol90() {
      return this.ecrCol90;
   }

   public void setEcrCol90(double var1) {
      this.ecrCol90 = var1;
   }

   public double getEcrColSolde() {
      return this.ecrColSolde;
   }

   public void setEcrColSolde(double var1) {
      this.ecrColSolde = var1;
   }

   public double getEcrColNonEchue() {
      return this.ecrColNonEchue;
   }

   public void setEcrColNonEchue(double var1) {
      this.ecrColNonEchue = var1;
   }

   public long getEcrNbJour() {
      return this.ecrNbJour;
   }

   public void setEcrNbJour(long var1) {
      this.ecrNbJour = var1;
   }

   public double getEcrCol0() {
      return this.ecrCol0;
   }

   public void setEcrCol0(double var1) {
      this.ecrCol0 = var1;
   }

   public double getEcrCreditAN() {
      return this.ecrCreditAN;
   }

   public void setEcrCreditAN(double var1) {
      this.ecrCreditAN = var1;
   }

   public double getEcrCreditMVTS() {
      return this.ecrCreditMVTS;
   }

   public void setEcrCreditMVTS(double var1) {
      this.ecrCreditMVTS = var1;
   }

   public double getEcrCreditSOLDE() {
      return this.ecrCreditSOLDE;
   }

   public void setEcrCreditSOLDE(double var1) {
      this.ecrCreditSOLDE = var1;
   }

   public double getEcrDebitAN() {
      return this.ecrDebitAN;
   }

   public void setEcrDebitAN(double var1) {
      this.ecrDebitAN = var1;
   }

   public double getEcrDebitMVTS() {
      return this.ecrDebitMVTS;
   }

   public void setEcrDebitMVTS(double var1) {
      this.ecrDebitMVTS = var1;
   }

   public double getEcrDebitSOLDE() {
      return this.ecrDebitSOLDE;
   }

   public void setEcrDebitSOLDE(double var1) {
      this.ecrDebitSOLDE = var1;
   }

   public String getLibPoste() {
      return this.libPoste;
   }

   public void setLibPoste(String var1) {
      this.libPoste = var1;
   }

   public String getPoste() {
      return this.poste;
   }

   public void setPoste(String var1) {
      this.poste = var1;
   }

   public double getEcartAN() {
      return this.ecartAN;
   }

   public void setEcartAN(double var1) {
      this.ecartAN = var1;
   }

   public double getEcartMVTS() {
      return this.ecartMVTS;
   }

   public void setEcartMVTS(double var1) {
      this.ecartMVTS = var1;
   }

   public String getRevueCompte() {
      return this.revueCompte;
   }

   public void setRevueCompte(String var1) {
      this.revueCompte = var1;
   }
}
