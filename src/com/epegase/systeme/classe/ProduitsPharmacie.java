package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProduitsPharmacie implements Serializable {
   private long prophaId;
   private String prophaTherapeutique;
   private String prophaGalenique;
   private String prophaFormuleDci;
   private String prophaPosition;
   private String prophaTableau;
   private String prophaShp;
   private String prophaSpecialite;
   private String prophaDosage;
   private String prophaUnite;
   private String prophaPrise;
   private String prophaMarche;
   private String prophaOrigine;
   private String prophaPosologie;
   private String prophaObservations;
   private String prophaLaboratoire;
   private Produits produits;

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public String getProphaDosage() {
      return this.prophaDosage;
   }

   public void setProphaDosage(String var1) {
      this.prophaDosage = var1;
   }

   public String getProphaFormuleDci() {
      return this.prophaFormuleDci;
   }

   public void setProphaFormuleDci(String var1) {
      this.prophaFormuleDci = var1;
   }

   public String getProphaGalenique() {
      return this.prophaGalenique;
   }

   public void setProphaGalenique(String var1) {
      this.prophaGalenique = var1;
   }

   public long getProphaId() {
      return this.prophaId;
   }

   public void setProphaId(long var1) {
      this.prophaId = var1;
   }

   public String getProphaLaboratoire() {
      return this.prophaLaboratoire;
   }

   public void setProphaLaboratoire(String var1) {
      this.prophaLaboratoire = var1;
   }

   public String getProphaMarche() {
      return this.prophaMarche;
   }

   public void setProphaMarche(String var1) {
      this.prophaMarche = var1;
   }

   public String getProphaObservations() {
      return this.prophaObservations;
   }

   public void setProphaObservations(String var1) {
      this.prophaObservations = var1;
   }

   public String getProphaOrigine() {
      return this.prophaOrigine;
   }

   public void setProphaOrigine(String var1) {
      this.prophaOrigine = var1;
   }

   public String getProphaPosition() {
      return this.prophaPosition;
   }

   public void setProphaPosition(String var1) {
      this.prophaPosition = var1;
   }

   public String getProphaPosologie() {
      return this.prophaPosologie;
   }

   public void setProphaPosologie(String var1) {
      this.prophaPosologie = var1;
   }

   public String getProphaPrise() {
      return this.prophaPrise;
   }

   public void setProphaPrise(String var1) {
      this.prophaPrise = var1;
   }

   public String getProphaShp() {
      return this.prophaShp;
   }

   public void setProphaShp(String var1) {
      this.prophaShp = var1;
   }

   public String getProphaSpecialite() {
      return this.prophaSpecialite;
   }

   public void setProphaSpecialite(String var1) {
      this.prophaSpecialite = var1;
   }

   public String getProphaTableau() {
      return this.prophaTableau;
   }

   public void setProphaTableau(String var1) {
      this.prophaTableau = var1;
   }

   public String getProphaTherapeutique() {
      return this.prophaTherapeutique;
   }

   public void setProphaTherapeutique(String var1) {
      this.prophaTherapeutique = var1;
   }

   public String getProphaUnite() {
      return this.prophaUnite;
   }

   public void setProphaUnite(String var1) {
      this.prophaUnite = var1;
   }
}
