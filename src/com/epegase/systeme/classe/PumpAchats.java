package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PumpAchats implements Serializable {
   private long pumId;
   private Date pumDateCreat;
   private long pumIdCreateur;
   private long pumIdDocOrigine;
   private String pumNumDocOrigine;
   private int pumNatureOrigine;
   private long pumIdLigneOrigine;
   private Date pumDate;
   private String pumDepot;
   private String pumProduit;
   private double pumPa;
   private double pumPr;
   private double pumPrKg;
   private double pumPump;
   private float pumQteOperation;
   private float pumQteStock;
   private String pumDossier;
   private ExercicesAchats exercicesAchats;

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public Date getPumDate() {
      return this.pumDate;
   }

   public void setPumDate(Date var1) {
      this.pumDate = var1;
   }

   public Date getPumDateCreat() {
      return this.pumDateCreat;
   }

   public void setPumDateCreat(Date var1) {
      this.pumDateCreat = var1;
   }

   public String getPumDepot() {
      return this.pumDepot;
   }

   public void setPumDepot(String var1) {
      this.pumDepot = var1;
   }

   public long getPumId() {
      return this.pumId;
   }

   public void setPumId(long var1) {
      this.pumId = var1;
   }

   public long getPumIdCreateur() {
      return this.pumIdCreateur;
   }

   public void setPumIdCreateur(long var1) {
      this.pumIdCreateur = var1;
   }

   public long getPumIdDocOrigine() {
      return this.pumIdDocOrigine;
   }

   public void setPumIdDocOrigine(long var1) {
      this.pumIdDocOrigine = var1;
   }

   public int getPumNatureOrigine() {
      return this.pumNatureOrigine;
   }

   public void setPumNatureOrigine(int var1) {
      this.pumNatureOrigine = var1;
   }

   public double getPumPa() {
      return this.pumPa;
   }

   public void setPumPa(double var1) {
      this.pumPa = var1;
   }

   public double getPumPr() {
      return this.pumPr;
   }

   public void setPumPr(double var1) {
      this.pumPr = var1;
   }

   public String getPumProduit() {
      return this.pumProduit;
   }

   public void setPumProduit(String var1) {
      this.pumProduit = var1;
   }

   public double getPumPump() {
      return this.pumPump;
   }

   public void setPumPump(double var1) {
      this.pumPump = var1;
   }

   public float getPumQteOperation() {
      return this.pumQteOperation;
   }

   public void setPumQteOperation(float var1) {
      this.pumQteOperation = var1;
   }

   public float getPumQteStock() {
      return this.pumQteStock;
   }

   public void setPumQteStock(float var1) {
      this.pumQteStock = var1;
   }

   public String getPumNumDocOrigine() {
      return this.pumNumDocOrigine;
   }

   public void setPumNumDocOrigine(String var1) {
      this.pumNumDocOrigine = var1;
   }

   public long getPumIdLigneOrigine() {
      return this.pumIdLigneOrigine;
   }

   public void setPumIdLigneOrigine(long var1) {
      this.pumIdLigneOrigine = var1;
   }

   public double getPumPrKg() {
      return this.pumPrKg;
   }

   public void setPumPrKg(double var1) {
      this.pumPrKg = var1;
   }

   public String getPumDossier() {
      return this.pumDossier;
   }

   public void setPumDossier(String var1) {
      this.pumDossier = var1;
   }
}
