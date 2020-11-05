package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TraiteLigne implements Serializable {
   private long trtligId;
   private int trtligOrdre;
   private Date trtligDateTheorique;
   private double trtligMontant;
   private float trtligCoef;
   private double trtligMontantLocal;
   private Date trtligDateDepot;
   private Date trtligDateReport;
   private int trtligTypet;
   private String trtligBordereau;
   private int trtligEtat;
   private String trtligMotif;
   private Date trtligDateRetour;
   private String trtligNumAvoir;
   private double trtligMontantAvoir;
   private double trtligMontantAvoirLocal;
   private TraiteEntete traiteEntete;
   private boolean select;

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public TraiteEntete getTraiteEntete() {
      return this.traiteEntete;
   }

   public void setTraiteEntete(TraiteEntete var1) {
      this.traiteEntete = var1;
   }

   public String getTrtligBordereau() {
      return this.trtligBordereau;
   }

   public void setTrtligBordereau(String var1) {
      this.trtligBordereau = var1;
   }

   public Date getTrtligDateDepot() {
      return this.trtligDateDepot;
   }

   public void setTrtligDateDepot(Date var1) {
      this.trtligDateDepot = var1;
   }

   public Date getTrtligDateReport() {
      return this.trtligDateReport;
   }

   public void setTrtligDateReport(Date var1) {
      this.trtligDateReport = var1;
   }

   public Date getTrtligDateRetour() {
      return this.trtligDateRetour;
   }

   public void setTrtligDateRetour(Date var1) {
      this.trtligDateRetour = var1;
   }

   public Date getTrtligDateTheorique() {
      return this.trtligDateTheorique;
   }

   public void setTrtligDateTheorique(Date var1) {
      this.trtligDateTheorique = var1;
   }

   public int getTrtligEtat() {
      return this.trtligEtat;
   }

   public void setTrtligEtat(int var1) {
      this.trtligEtat = var1;
   }

   public long getTrtligId() {
      return this.trtligId;
   }

   public void setTrtligId(long var1) {
      this.trtligId = var1;
   }

   public double getTrtligMontant() {
      return this.trtligMontant;
   }

   public void setTrtligMontant(double var1) {
      this.trtligMontant = var1;
   }

   public String getTrtligMotif() {
      return this.trtligMotif;
   }

   public void setTrtligMotif(String var1) {
      this.trtligMotif = var1;
   }

   public int getTrtligTypet() {
      return this.trtligTypet;
   }

   public void setTrtligTypet(int var1) {
      this.trtligTypet = var1;
   }

   public int getTrtligOrdre() {
      return this.trtligOrdre;
   }

   public void setTrtligOrdre(int var1) {
      this.trtligOrdre = var1;
   }

   public float getTrtligCoef() {
      return this.trtligCoef;
   }

   public void setTrtligCoef(float var1) {
      this.trtligCoef = var1;
   }

   public double getTrtligMontantAvoir() {
      return this.trtligMontantAvoir;
   }

   public void setTrtligMontantAvoir(double var1) {
      this.trtligMontantAvoir = var1;
   }

   public double getTrtligMontantAvoirLocal() {
      return this.trtligMontantAvoirLocal;
   }

   public void setTrtligMontantAvoirLocal(double var1) {
      this.trtligMontantAvoirLocal = var1;
   }

   public double getTrtligMontantLocal() {
      return this.trtligMontantLocal;
   }

   public void setTrtligMontantLocal(double var1) {
      this.trtligMontantLocal = var1;
   }

   public String getTrtligNumAvoir() {
      return this.trtligNumAvoir;
   }

   public void setTrtligNumAvoir(String var1) {
      this.trtligNumAvoir = var1;
   }
}
