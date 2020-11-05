package com.epegase.systeme.classe;

import java.io.Serializable;

public class BonSortieLigne implements Serializable {
   private long bouligId;
   private String bouligCode;
   private String bouligDepot;
   private String bouligFamille;
   private String bouligLibelle;
   private String bouligReference;
   private String bouligUnite;
   private String bouligCondition;
   private String bouligDescription;
   private float bouligQte;
   private String bouligCasier;
   private float bouligLong;
   private float bouligLarg;
   private float bouligHaut;
   private float bouligDiam;
   private float bouligNb;
   private float bouligPoidsNet;
   private float bouligPoidsBrut;
   private float bouligVolume;
   private float bouligQteUtil;
   private int bouligStock;
   private float bouligQteStock;
   private double bouligPump;
   private double bouligTotal;
   private String bouligObs;
   private BonSortieEntete bonSortieEntete;
   private boolean verouCod;
   private String var_lib_uni_condit;
   private Unite unite = new Unite();

   public String getVar_lib_uni_condit() {
      if (this.bouligCondition != null && !this.bouligCondition.isEmpty() && this.bouligCondition.contains(":")) {
         if (this.bouligDescription != null && !this.bouligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.bouligDescription;
         } else if (this.bouligCondition.contains("/")) {
            String[] var1 = this.bouligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.bouligCondition;
         }
      } else if (this.bouligCondition != null && !this.bouligCondition.isEmpty() && !this.bouligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.bouligCondition));
      } else if (this.bouligUnite != null && !this.bouligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.bouligUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public boolean isVerouCod() {
      return this.verouCod;
   }

   public void setVerouCod(boolean var1) {
      this.verouCod = var1;
   }

   public BonSortieEntete getBonSortieEntete() {
      return this.bonSortieEntete;
   }

   public void setBonSortieEntete(BonSortieEntete var1) {
      this.bonSortieEntete = var1;
   }

   public String getBouligCasier() {
      return this.bouligCasier;
   }

   public void setBouligCasier(String var1) {
      this.bouligCasier = var1;
   }

   public String getBouligCode() {
      return this.bouligCode;
   }

   public void setBouligCode(String var1) {
      this.bouligCode = var1;
   }

   public String getBouligCondition() {
      return this.bouligCondition;
   }

   public void setBouligCondition(String var1) {
      this.bouligCondition = var1;
   }

   public float getBouligDiam() {
      return this.bouligDiam;
   }

   public void setBouligDiam(float var1) {
      this.bouligDiam = var1;
   }

   public String getBouligFamille() {
      return this.bouligFamille;
   }

   public void setBouligFamille(String var1) {
      this.bouligFamille = var1;
   }

   public float getBouligHaut() {
      return this.bouligHaut;
   }

   public void setBouligHaut(float var1) {
      this.bouligHaut = var1;
   }

   public long getBouligId() {
      return this.bouligId;
   }

   public void setBouligId(long var1) {
      this.bouligId = var1;
   }

   public float getBouligLarg() {
      return this.bouligLarg;
   }

   public void setBouligLarg(float var1) {
      this.bouligLarg = var1;
   }

   public String getBouligLibelle() {
      return this.bouligLibelle;
   }

   public void setBouligLibelle(String var1) {
      this.bouligLibelle = var1;
   }

   public float getBouligLong() {
      return this.bouligLong;
   }

   public void setBouligLong(float var1) {
      this.bouligLong = var1;
   }

   public float getBouligNb() {
      return this.bouligNb;
   }

   public void setBouligNb(float var1) {
      this.bouligNb = var1;
   }

   public String getBouligObs() {
      return this.bouligObs;
   }

   public void setBouligObs(String var1) {
      this.bouligObs = var1;
   }

   public float getBouligPoidsBrut() {
      return this.bouligPoidsBrut;
   }

   public void setBouligPoidsBrut(float var1) {
      this.bouligPoidsBrut = var1;
   }

   public float getBouligPoidsNet() {
      return this.bouligPoidsNet;
   }

   public void setBouligPoidsNet(float var1) {
      this.bouligPoidsNet = var1;
   }

   public double getBouligPump() {
      return this.bouligPump;
   }

   public void setBouligPump(double var1) {
      this.bouligPump = var1;
   }

   public float getBouligQte() {
      return this.bouligQte;
   }

   public void setBouligQte(float var1) {
      this.bouligQte = var1;
   }

   public float getBouligQteStock() {
      return this.bouligQteStock;
   }

   public void setBouligQteStock(float var1) {
      this.bouligQteStock = var1;
   }

   public float getBouligQteUtil() {
      return this.bouligQteUtil;
   }

   public void setBouligQteUtil(float var1) {
      this.bouligQteUtil = var1;
   }

   public String getBouligReference() {
      return this.bouligReference;
   }

   public void setBouligReference(String var1) {
      this.bouligReference = var1;
   }

   public double getBouligTotal() {
      return this.bouligTotal;
   }

   public void setBouligTotal(double var1) {
      this.bouligTotal = var1;
   }

   public String getBouligUnite() {
      return this.bouligUnite;
   }

   public void setBouligUnite(String var1) {
      this.bouligUnite = var1;
   }

   public float getBouligVolume() {
      return this.bouligVolume;
   }

   public void setBouligVolume(float var1) {
      this.bouligVolume = var1;
   }

   public int getBouligStock() {
      return this.bouligStock;
   }

   public void setBouligStock(int var1) {
      this.bouligStock = var1;
   }

   public String getBouligDepot() {
      return this.bouligDepot;
   }

   public void setBouligDepot(String var1) {
      this.bouligDepot = var1;
   }

   public String getBouligDescription() {
      return this.bouligDescription;
   }

   public void setBouligDescription(String var1) {
      this.bouligDescription = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }
}
