package com.epegase.systeme.classe;

import java.io.Serializable;

public class CessionLigne implements Serializable {
   private long cesligId;
   private String cesligCode;
   private String cesligDepotOrigine;
   private String cesligDepotDestination;
   private String cesligSommier;
   private String cesligFamille;
   private String cesligLibelle;
   private String cesligReference;
   private String cesligUnite;
   private String cesligCondition;
   private String cesligDescription;
   private float cesligQte;
   private String cesligCasierOrigine;
   private String cesligCasierDestination;
   private float cesligLong;
   private float cesligLarg;
   private float cesligHaut;
   private float cesligDiam;
   private float cesligNb;
   private float cesligPoidsNet;
   private float cesligPoidsBrut;
   private float cesligVolume;
   private float cesligQteUtil;
   private int cesligStock;
   private float cesligQteStock;
   private String cesligLot;
   private String cesligNumSerie;
   private double cesligPump;
   private double cesligTotal;
   private String cesligObs;
   private CessionEntete cessionEntete;
   private boolean verouCod;
   private String var_lib_uni_condit;
   private Unite unite = new Unite();

   public String getVar_lib_uni_condit() {
      if (this.cesligCondition != null && !this.cesligCondition.isEmpty() && this.cesligCondition.contains(":")) {
         if (this.cesligDescription != null && !this.cesligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.cesligDescription;
         } else if (this.cesligCondition.contains("/")) {
            String[] var1 = this.cesligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.cesligCondition;
         }
      } else if (this.cesligCondition != null && !this.cesligCondition.isEmpty() && !this.cesligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.cesligCondition));
      } else if (this.cesligUnite != null && !this.cesligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.cesligUnite;
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

   public String getCesligCasierDestination() {
      return this.cesligCasierDestination;
   }

   public void setCesligCasierDestination(String var1) {
      this.cesligCasierDestination = var1;
   }

   public String getCesligCasierOrigine() {
      return this.cesligCasierOrigine;
   }

   public void setCesligCasierOrigine(String var1) {
      this.cesligCasierOrigine = var1;
   }

   public String getCesligCode() {
      return this.cesligCode;
   }

   public void setCesligCode(String var1) {
      this.cesligCode = var1;
   }

   public String getCesligCondition() {
      return this.cesligCondition;
   }

   public void setCesligCondition(String var1) {
      this.cesligCondition = var1;
   }

   public float getCesligDiam() {
      return this.cesligDiam;
   }

   public void setCesligDiam(float var1) {
      this.cesligDiam = var1;
   }

   public String getCesligFamille() {
      return this.cesligFamille;
   }

   public void setCesligFamille(String var1) {
      this.cesligFamille = var1;
   }

   public float getCesligHaut() {
      return this.cesligHaut;
   }

   public void setCesligHaut(float var1) {
      this.cesligHaut = var1;
   }

   public long getCesligId() {
      return this.cesligId;
   }

   public void setCesligId(long var1) {
      this.cesligId = var1;
   }

   public float getCesligLarg() {
      return this.cesligLarg;
   }

   public void setCesligLarg(float var1) {
      this.cesligLarg = var1;
   }

   public String getCesligLibelle() {
      return this.cesligLibelle;
   }

   public void setCesligLibelle(String var1) {
      this.cesligLibelle = var1;
   }

   public float getCesligLong() {
      return this.cesligLong;
   }

   public void setCesligLong(float var1) {
      this.cesligLong = var1;
   }

   public float getCesligNb() {
      return this.cesligNb;
   }

   public void setCesligNb(float var1) {
      this.cesligNb = var1;
   }

   public String getCesligObs() {
      return this.cesligObs;
   }

   public void setCesligObs(String var1) {
      this.cesligObs = var1;
   }

   public float getCesligPoidsBrut() {
      return this.cesligPoidsBrut;
   }

   public void setCesligPoidsBrut(float var1) {
      this.cesligPoidsBrut = var1;
   }

   public float getCesligPoidsNet() {
      return this.cesligPoidsNet;
   }

   public void setCesligPoidsNet(float var1) {
      this.cesligPoidsNet = var1;
   }

   public double getCesligPump() {
      return this.cesligPump;
   }

   public void setCesligPump(double var1) {
      this.cesligPump = var1;
   }

   public float getCesligQteStock() {
      return this.cesligQteStock;
   }

   public void setCesligQteStock(float var1) {
      this.cesligQteStock = var1;
   }

   public String getCesligReference() {
      return this.cesligReference;
   }

   public void setCesligReference(String var1) {
      this.cesligReference = var1;
   }

   public double getCesligTotal() {
      return this.cesligTotal;
   }

   public void setCesligTotal(double var1) {
      this.cesligTotal = var1;
   }

   public String getCesligUnite() {
      return this.cesligUnite;
   }

   public void setCesligUnite(String var1) {
      this.cesligUnite = var1;
   }

   public float getCesligVolume() {
      return this.cesligVolume;
   }

   public void setCesligVolume(float var1) {
      this.cesligVolume = var1;
   }

   public CessionEntete getCessionEntete() {
      return this.cessionEntete;
   }

   public void setCessionEntete(CessionEntete var1) {
      this.cessionEntete = var1;
   }

   public float getCesligQte() {
      return this.cesligQte;
   }

   public void setCesligQte(float var1) {
      this.cesligQte = var1;
   }

   public float getCesligQteUtil() {
      return this.cesligQteUtil;
   }

   public void setCesligQteUtil(float var1) {
      this.cesligQteUtil = var1;
   }

   public int getCesligStock() {
      return this.cesligStock;
   }

   public void setCesligStock(int var1) {
      this.cesligStock = var1;
   }

   public String getCesligDepotDestination() {
      return this.cesligDepotDestination;
   }

   public void setCesligDepotDestination(String var1) {
      this.cesligDepotDestination = var1;
   }

   public String getCesligDepotOrigine() {
      return this.cesligDepotOrigine;
   }

   public void setCesligDepotOrigine(String var1) {
      this.cesligDepotOrigine = var1;
   }

   public String getCesligSommier() {
      return this.cesligSommier;
   }

   public void setCesligSommier(String var1) {
      this.cesligSommier = var1;
   }

   public String getCesligDescription() {
      return this.cesligDescription;
   }

   public void setCesligDescription(String var1) {
      this.cesligDescription = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public String getCesligLot() {
      return this.cesligLot;
   }

   public void setCesligLot(String var1) {
      this.cesligLot = var1;
   }

   public String getCesligNumSerie() {
      return this.cesligNumSerie;
   }

   public void setCesligNumSerie(String var1) {
      this.cesligNumSerie = var1;
   }
}
