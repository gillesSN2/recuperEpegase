package com.epegase.systeme.control;

import java.io.Serializable;

public class LigneDocument implements Serializable {
   private int ligOrdre;
   private String ligCode;
   private String ligFamille;
   private String ligLibelle;
   private String ligComplement;
   private String ligReference;
   private String ligTaxe;
   private float ligTauxTaxe;
   private String ligUnite;
   private float ligQte;
   private float ligQteUtil;
   private String ligDevise;
   private double ligPu;
   private double ligPuTtc;
   private float ligTauxRemise;
   private double ligRabais;
   private double ligPuRem;
   private double ligPuRemTtc;
   private double ligPt;
   private double ligTva;
   private double ligTc;
   private double ligTtc;
   private double ligPr;
   private double ligPump;
   private String ligDepot;
   private float ligQteStock;
   private int ligEntStock;
   private String ligLot;
   private String ligNumSerie;
   private String ligGroupe;
   private int ligModeGroupe;

   public String getLigCode() {
      return this.ligCode;
   }

   public void setLigCode(String var1) {
      this.ligCode = var1;
   }

   public String getLigDevise() {
      return this.ligDevise;
   }

   public void setLigDevise(String var1) {
      this.ligDevise = var1;
   }

   public String getLigFamille() {
      return this.ligFamille;
   }

   public void setLigFamille(String var1) {
      this.ligFamille = var1;
   }

   public String getLigLibelle() {
      return this.ligLibelle;
   }

   public void setLigLibelle(String var1) {
      this.ligLibelle = var1;
   }

   public double getLigPr() {
      return this.ligPr;
   }

   public void setLigPr(double var1) {
      this.ligPr = var1;
   }

   public double getLigPt() {
      return this.ligPt;
   }

   public void setLigPt(double var1) {
      this.ligPt = var1;
   }

   public double getLigPu() {
      return this.ligPu;
   }

   public void setLigPu(double var1) {
      this.ligPu = var1;
   }

   public double getLigPuRem() {
      return this.ligPuRem;
   }

   public void setLigPuRem(double var1) {
      this.ligPuRem = var1;
   }

   public double getLigPump() {
      return this.ligPump;
   }

   public void setLigPump(double var1) {
      this.ligPump = var1;
   }

   public float getLigQte() {
      return this.ligQte;
   }

   public void setLigQte(float var1) {
      this.ligQte = var1;
   }

   public double getLigRabais() {
      return this.ligRabais;
   }

   public void setLigRabais(double var1) {
      this.ligRabais = var1;
   }

   public String getLigReference() {
      return this.ligReference;
   }

   public void setLigReference(String var1) {
      this.ligReference = var1;
   }

   public float getLigTauxRemise() {
      return this.ligTauxRemise;
   }

   public void setLigTauxRemise(float var1) {
      this.ligTauxRemise = var1;
   }

   public float getLigTauxTaxe() {
      return this.ligTauxTaxe;
   }

   public void setLigTauxTaxe(float var1) {
      this.ligTauxTaxe = var1;
   }

   public String getLigTaxe() {
      return this.ligTaxe;
   }

   public void setLigTaxe(String var1) {
      this.ligTaxe = var1;
   }

   public double getLigTc() {
      return this.ligTc;
   }

   public void setLigTc(double var1) {
      this.ligTc = var1;
   }

   public double getLigTtc() {
      return this.ligTtc;
   }

   public void setLigTtc(double var1) {
      this.ligTtc = var1;
   }

   public double getLigTva() {
      return this.ligTva;
   }

   public void setLigTva(double var1) {
      this.ligTva = var1;
   }

   public String getLigUnite() {
      return this.ligUnite;
   }

   public void setLigUnite(String var1) {
      this.ligUnite = var1;
   }

   public String getLigDepot() {
      return this.ligDepot;
   }

   public void setLigDepot(String var1) {
      this.ligDepot = var1;
   }

   public String getLigLot() {
      return this.ligLot;
   }

   public void setLigLot(String var1) {
      this.ligLot = var1;
   }

   public String getLigNumSerie() {
      return this.ligNumSerie;
   }

   public void setLigNumSerie(String var1) {
      this.ligNumSerie = var1;
   }

   public float getLigQteStock() {
      return this.ligQteStock;
   }

   public void setLigQteStock(float var1) {
      this.ligQteStock = var1;
   }

   public double getLigPuRemTtc() {
      return this.ligPuRemTtc;
   }

   public void setLigPuRemTtc(double var1) {
      this.ligPuRemTtc = var1;
   }

   public double getLigPuTtc() {
      return this.ligPuTtc;
   }

   public void setLigPuTtc(double var1) {
      this.ligPuTtc = var1;
   }

   public String getLigComplement() {
      return this.ligComplement;
   }

   public void setLigComplement(String var1) {
      this.ligComplement = var1;
   }

   public int getLigOrdre() {
      return this.ligOrdre;
   }

   public void setLigOrdre(int var1) {
      this.ligOrdre = var1;
   }

   public String getLigGroupe() {
      return this.ligGroupe;
   }

   public void setLigGroupe(String var1) {
      this.ligGroupe = var1;
   }

   public int getLigModeGroupe() {
      return this.ligModeGroupe;
   }

   public void setLigModeGroupe(int var1) {
      this.ligModeGroupe = var1;
   }

   public float getLigQteUtil() {
      return this.ligQteUtil;
   }

   public void setLigQteUtil(float var1) {
      this.ligQteUtil = var1;
   }

   public int getLigEntStock() {
      return this.ligEntStock;
   }

   public void setLigEntStock(int var1) {
      this.ligEntStock = var1;
   }
}
