package com.epegase.systeme.classe;

import java.io.Serializable;

public class InventaireLigne implements Serializable {
   private long invligId;
   private String invligCode;
   private String invligDepot;
   private String invligFamille;
   private String invligLibelle;
   private String invligReference;
   private String invligUnite;
   private String invligCondition;
   private String invligDescription;
   private float invligQte;
   private String invligCasier;
   private float invligLong;
   private float invligLarg;
   private float invligHaut;
   private float invligDiam;
   private float invligNb;
   private float invligPoidsNet;
   private float invligPoidsBrut;
   private float invligVolume;
   private float invligQteUtil;
   private int invligStock;
   private float invligQteStock;
   private String invligLot;
   private String invligNumSerie;
   private double invligPump;
   private double invligTotal;
   private String invligObs;
   private boolean invligValide;
   private InventaireEntete inventaireEntete;
   private boolean verouCod;
   private String var_lib_uni_condit;
   private float var_ecart;
   private Unite unite = new Unite();

   public float getVar_ecart() {
      this.var_ecart = this.invligQteStock - this.invligQte;
      return this.var_ecart;
   }

   public void setVar_ecart(float var1) {
      this.var_ecart = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.invligCondition != null && !this.invligCondition.isEmpty() && this.invligCondition.contains(":")) {
         if (this.invligDescription != null && !this.invligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.invligDescription;
         } else if (this.invligCondition.contains("/")) {
            String[] var1 = this.invligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.invligCondition;
         }
      } else if (this.invligCondition != null && !this.invligCondition.isEmpty() && !this.invligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.invligCondition));
      } else if (this.invligUnite != null && !this.invligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.invligUnite;
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

   public InventaireEntete getInventaireEntete() {
      return this.inventaireEntete;
   }

   public void setInventaireEntete(InventaireEntete var1) {
      this.inventaireEntete = var1;
   }

   public float getInvligPoidsBrut() {
      return this.invligPoidsBrut;
   }

   public void setInvligPoidsBrut(float var1) {
      this.invligPoidsBrut = var1;
   }

   public String getInvligCode() {
      return this.invligCode;
   }

   public void setInvligCode(String var1) {
      this.invligCode = var1;
   }

   public String getInvligCondition() {
      return this.invligCondition;
   }

   public void setInvligCondition(String var1) {
      this.invligCondition = var1;
   }

   public float getInvligDiam() {
      return this.invligDiam;
   }

   public void setInvligDiam(float var1) {
      this.invligDiam = var1;
   }

   public String getInvligFamille() {
      return this.invligFamille;
   }

   public void setInvligFamille(String var1) {
      this.invligFamille = var1;
   }

   public float getInvligHaut() {
      return this.invligHaut;
   }

   public void setInvligHaut(float var1) {
      this.invligHaut = var1;
   }

   public long getInvligId() {
      return this.invligId;
   }

   public void setInvligId(long var1) {
      this.invligId = var1;
   }

   public float getInvligLarg() {
      return this.invligLarg;
   }

   public void setInvligLarg(float var1) {
      this.invligLarg = var1;
   }

   public String getInvligLibelle() {
      return this.invligLibelle;
   }

   public void setInvligLibelle(String var1) {
      this.invligLibelle = var1;
   }

   public float getInvligLong() {
      return this.invligLong;
   }

   public void setInvligLong(float var1) {
      this.invligLong = var1;
   }

   public float getInvligNb() {
      return this.invligNb;
   }

   public void setInvligNb(float var1) {
      this.invligNb = var1;
   }

   public float getInvligPoidsNet() {
      return this.invligPoidsNet;
   }

   public void setInvligPoidsNet(float var1) {
      this.invligPoidsNet = var1;
   }

   public double getInvligPump() {
      return this.invligPump;
   }

   public void setInvligPump(double var1) {
      this.invligPump = var1;
   }

   public float getInvligQte() {
      return this.invligQte;
   }

   public void setInvligQte(float var1) {
      this.invligQte = var1;
   }

   public float getInvligQteStock() {
      return this.invligQteStock;
   }

   public void setInvligQteStock(float var1) {
      this.invligQteStock = var1;
   }

   public float getInvligQteUtil() {
      return this.invligQteUtil;
   }

   public void setInvligQteUtil(float var1) {
      this.invligQteUtil = var1;
   }

   public String getInvligReference() {
      return this.invligReference;
   }

   public void setInvligReference(String var1) {
      this.invligReference = var1;
   }

   public double getInvligTotal() {
      return this.invligTotal;
   }

   public void setInvligTotal(double var1) {
      this.invligTotal = var1;
   }

   public String getInvligUnite() {
      return this.invligUnite;
   }

   public void setInvligUnite(String var1) {
      this.invligUnite = var1;
   }

   public float getInvligVolume() {
      return this.invligVolume;
   }

   public void setInvligVolume(float var1) {
      this.invligVolume = var1;
   }

   public String getInvligCasier() {
      return this.invligCasier;
   }

   public void setInvligCasier(String var1) {
      this.invligCasier = var1;
   }

   public String getInvligObs() {
      return this.invligObs;
   }

   public void setInvligObs(String var1) {
      this.invligObs = var1;
   }

   public boolean isInvligValide() {
      return this.invligValide;
   }

   public void setInvligValide(boolean var1) {
      this.invligValide = var1;
   }

   public int getInvligStock() {
      return this.invligStock;
   }

   public void setInvligStock(int var1) {
      this.invligStock = var1;
   }

   public String getInvligDepot() {
      return this.invligDepot;
   }

   public void setInvligDepot(String var1) {
      this.invligDepot = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public String getInvligDescription() {
      return this.invligDescription;
   }

   public void setInvligDescription(String var1) {
      this.invligDescription = var1;
   }

   public String getInvligLot() {
      return this.invligLot;
   }

   public void setInvligLot(String var1) {
      this.invligLot = var1;
   }

   public String getInvligNumSerie() {
      return this.invligNumSerie;
   }

   public void setInvligNumSerie(String var1) {
      this.invligNumSerie = var1;
   }
}
