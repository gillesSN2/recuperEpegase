package com.epegase.systeme.classe;

import java.io.Serializable;

public class BonEntreeLigne implements Serializable {
   private long binligId;
   private String binligCode;
   private String binligDepot;
   private String binligFamille;
   private String binligLibelle;
   private String binligReference;
   private String binligUnite;
   private String binligCondition;
   private String binligDescription;
   private float binligQte;
   private String binligCasier;
   private float binligLong;
   private float binligLarg;
   private float binligHaut;
   private float binligDiam;
   private float binligNb;
   private float binligPoidsNet;
   private float binligPoidsBrut;
   private float binligVolume;
   private float binligQteUtil;
   private int binligStock;
   private float binligQteStock;
   private double binligPump;
   private double binligTotal;
   private String binligObs;
   private BonEntreeEntete bonEntreeEntete;
   private boolean verouCod;
   private String var_lib_uni_condit;
   private Unite unite = new Unite();

   public String getVar_lib_uni_condit() {
      if (this.binligCondition != null && !this.binligCondition.isEmpty() && this.binligCondition.contains(":")) {
         if (this.binligDescription != null && !this.binligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.binligDescription;
         } else if (this.binligCondition.contains("/")) {
            String[] var1 = this.binligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.binligCondition;
         }
      } else if (this.binligCondition != null && !this.binligCondition.isEmpty() && !this.binligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.binligCondition));
      } else if (this.binligUnite != null && !this.binligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.binligUnite;
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

   public String getBinligCasier() {
      return this.binligCasier;
   }

   public void setBinligCasier(String var1) {
      this.binligCasier = var1;
   }

   public String getBinligCode() {
      return this.binligCode;
   }

   public void setBinligCode(String var1) {
      this.binligCode = var1;
   }

   public String getBinligCondition() {
      return this.binligCondition;
   }

   public void setBinligCondition(String var1) {
      this.binligCondition = var1;
   }

   public float getBinligDiam() {
      return this.binligDiam;
   }

   public void setBinligDiam(float var1) {
      this.binligDiam = var1;
   }

   public String getBinligFamille() {
      return this.binligFamille;
   }

   public void setBinligFamille(String var1) {
      this.binligFamille = var1;
   }

   public float getBinligHaut() {
      return this.binligHaut;
   }

   public void setBinligHaut(float var1) {
      this.binligHaut = var1;
   }

   public long getBinligId() {
      return this.binligId;
   }

   public void setBinligId(long var1) {
      this.binligId = var1;
   }

   public float getBinligLarg() {
      return this.binligLarg;
   }

   public void setBinligLarg(float var1) {
      this.binligLarg = var1;
   }

   public String getBinligLibelle() {
      return this.binligLibelle;
   }

   public void setBinligLibelle(String var1) {
      this.binligLibelle = var1;
   }

   public float getBinligLong() {
      return this.binligLong;
   }

   public void setBinligLong(float var1) {
      this.binligLong = var1;
   }

   public float getBinligNb() {
      return this.binligNb;
   }

   public void setBinligNb(float var1) {
      this.binligNb = var1;
   }

   public String getBinligObs() {
      return this.binligObs;
   }

   public void setBinligObs(String var1) {
      this.binligObs = var1;
   }

   public float getBinligPoidsBrut() {
      return this.binligPoidsBrut;
   }

   public void setBinligPoidsBrut(float var1) {
      this.binligPoidsBrut = var1;
   }

   public float getBinligPoidsNet() {
      return this.binligPoidsNet;
   }

   public void setBinligPoidsNet(float var1) {
      this.binligPoidsNet = var1;
   }

   public double getBinligPump() {
      return this.binligPump;
   }

   public void setBinligPump(double var1) {
      this.binligPump = var1;
   }

   public float getBinligQte() {
      return this.binligQte;
   }

   public void setBinligQte(float var1) {
      this.binligQte = var1;
   }

   public float getBinligQteStock() {
      return this.binligQteStock;
   }

   public void setBinligQteStock(float var1) {
      this.binligQteStock = var1;
   }

   public float getBinligQteUtil() {
      return this.binligQteUtil;
   }

   public void setBinligQteUtil(float var1) {
      this.binligQteUtil = var1;
   }

   public String getBinligReference() {
      return this.binligReference;
   }

   public void setBinligReference(String var1) {
      this.binligReference = var1;
   }

   public double getBinligTotal() {
      return this.binligTotal;
   }

   public void setBinligTotal(double var1) {
      this.binligTotal = var1;
   }

   public String getBinligUnite() {
      return this.binligUnite;
   }

   public void setBinligUnite(String var1) {
      this.binligUnite = var1;
   }

   public float getBinligVolume() {
      return this.binligVolume;
   }

   public void setBinligVolume(float var1) {
      this.binligVolume = var1;
   }

   public BonEntreeEntete getBonEntreeEntete() {
      return this.bonEntreeEntete;
   }

   public void setBonEntreeEntete(BonEntreeEntete var1) {
      this.bonEntreeEntete = var1;
   }

   public int getBinligStock() {
      return this.binligStock;
   }

   public void setBinligStock(int var1) {
      this.binligStock = var1;
   }

   public String getBinligDepot() {
      return this.binligDepot;
   }

   public void setBinligDepot(String var1) {
      this.binligDepot = var1;
   }

   public String getBinligDescription() {
      return this.binligDescription;
   }

   public void setBinligDescription(String var1) {
      this.binligDescription = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }
}
