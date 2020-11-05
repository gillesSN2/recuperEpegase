package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetPays implements Serializable {
   private String identification;
   private String langue;
   private String gestion;
   private String iso;
   private String drapeau;
   private String nom_FR;
   private String nom_UK;
   private String nom_SP;
   private String nationnalite_FR;
   private String nationnalite_UK;
   private String nationnalite_SP;
   private String zone;
   private String fiscalite;
   private String indicatif;
   private String refGabon;
   private String devise;

   public String getDevise() {
      return this.devise;
   }

   public void setDevise(String var1) {
      this.devise = var1;
   }

   public String getDrapeau() {
      return this.drapeau;
   }

   public void setDrapeau(String var1) {
      this.drapeau = var1;
   }

   public String getFiscalite() {
      return this.fiscalite;
   }

   public void setFiscalite(String var1) {
      this.fiscalite = var1;
   }

   public String getGestion() {
      return this.gestion;
   }

   public void setGestion(String var1) {
      this.gestion = var1;
   }

   public String getIdentification() {
      return this.identification;
   }

   public void setIdentification(String var1) {
      this.identification = var1;
   }

   public String getIndicatif() {
      return this.indicatif;
   }

   public void setIndicatif(String var1) {
      this.indicatif = var1;
   }

   public String getIso() {
      return this.iso;
   }

   public void setIso(String var1) {
      this.iso = var1;
   }

   public String getLangue() {
      return this.langue;
   }

   public void setLangue(String var1) {
      this.langue = var1;
   }

   public String getNationnalite_FR() {
      return this.nationnalite_FR;
   }

   public void setNationnalite_FR(String var1) {
      this.nationnalite_FR = var1;
   }

   public String getNationnalite_SP() {
      return this.nationnalite_SP;
   }

   public void setNationnalite_SP(String var1) {
      this.nationnalite_SP = var1;
   }

   public String getNationnalite_UK() {
      return this.nationnalite_UK;
   }

   public void setNationnalite_UK(String var1) {
      this.nationnalite_UK = var1;
   }

   public String getNom_FR() {
      return this.nom_FR;
   }

   public void setNom_FR(String var1) {
      this.nom_FR = var1;
   }

   public String getNom_SP() {
      return this.nom_SP;
   }

   public void setNom_SP(String var1) {
      this.nom_SP = var1;
   }

   public String getNom_UK() {
      return this.nom_UK;
   }

   public void setNom_UK(String var1) {
      this.nom_UK = var1;
   }

   public String getZone() {
      return this.zone;
   }

   public void setZone(String var1) {
      this.zone = var1;
   }

   public String getRefGabon() {
      return this.refGabon;
   }

   public void setRefGabon(String var1) {
      this.refGabon = var1;
   }
}
