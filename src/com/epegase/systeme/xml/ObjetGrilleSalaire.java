package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetGrilleSalaire implements Serializable {
   private Integer indice;
   private String code;
   private String lib_FR;
   private String lib_UK;
   private String lib_SP;
   private float val_mois;
   private float val_heure;
   private String niveau;
   private double rendement;
   private double responsabilite;
   private double fonction;
   private double caisse;
   private double transport;
   private double telephone;
   private double logement;
   private double eau;
   private double electricite;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public Integer getIndice() {
      return this.indice;
   }

   public void setIndice(Integer var1) {
      this.indice = var1;
   }

   public String getLib_FR() {
      return this.lib_FR;
   }

   public void setLib_FR(String var1) {
      this.lib_FR = var1;
   }

   public String getLib_SP() {
      return this.lib_SP;
   }

   public void setLib_SP(String var1) {
      this.lib_SP = var1;
   }

   public String getLib_UK() {
      return this.lib_UK;
   }

   public void setLib_UK(String var1) {
      this.lib_UK = var1;
   }

   public String getNiveau() {
      return this.niveau;
   }

   public void setNiveau(String var1) {
      this.niveau = var1;
   }

   public double getCaisse() {
      return this.caisse;
   }

   public void setCaisse(double var1) {
      this.caisse = var1;
   }

   public double getEau() {
      return this.eau;
   }

   public void setEau(double var1) {
      this.eau = var1;
   }

   public double getElectricite() {
      return this.electricite;
   }

   public void setElectricite(double var1) {
      this.electricite = var1;
   }

   public double getFonction() {
      return this.fonction;
   }

   public void setFonction(double var1) {
      this.fonction = var1;
   }

   public double getLogement() {
      return this.logement;
   }

   public void setLogement(double var1) {
      this.logement = var1;
   }

   public double getRendement() {
      return this.rendement;
   }

   public void setRendement(double var1) {
      this.rendement = var1;
   }

   public double getResponsabilite() {
      return this.responsabilite;
   }

   public void setResponsabilite(double var1) {
      this.responsabilite = var1;
   }

   public double getTelephone() {
      return this.telephone;
   }

   public void setTelephone(double var1) {
      this.telephone = var1;
   }

   public double getTransport() {
      return this.transport;
   }

   public void setTransport(double var1) {
      this.transport = var1;
   }

   public float getVal_heure() {
      return this.val_heure;
   }

   public void setVal_heure(float var1) {
      this.val_heure = var1;
   }

   public float getVal_mois() {
      return this.val_mois;
   }

   public void setVal_mois(float var1) {
      this.val_mois = var1;
   }
}
