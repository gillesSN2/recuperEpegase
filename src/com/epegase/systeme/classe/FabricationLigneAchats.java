package com.epegase.systeme.classe;

import java.io.Serializable;

public class FabricationLigneAchats implements Serializable {
   private long fabligId;
   private int fabligType;
   private int fabligOrdre;
   private String fabligCode;
   private String fabligDepot;
   private String fabligFamille;
   private String fabligLibelle;
   private String fabligReference;
   private String fabligUnite;
   private String fabligCondition;
   private int fabligEchelle;
   private String fabligDescription;
   private float fabligQteRestant;
   private float fabligQte;
   private double fabligQteReference;
   private String fabligCasier;
   private float fabligLong;
   private float fabligLarg;
   private float fabligHaut;
   private float fabligDiam;
   private float fabligNb;
   private float fabligPoidsNet;
   private float fabligPoidsBrut;
   private float fabligVolume;
   private float fabligQteUtil;
   private int fabligStock;
   private float fabligQteStock;
   private String fabligLot;
   private String fabligNumSerie;
   private double fabligPump;
   private double fabligTotal;
   private String fabligObs;
   private int fabligJj;
   private int fabligHh;
   private int fabligMm;
   private int fabligSs;
   private String fabligMetier;
   private String fabligMateriel;
   private boolean fabligInterChange;
   private String fabligProduitInterchangeable;
   private String fabligDouane;
   private float fabligTauxDouane;
   private int fabligModePapier;
   private float fabligGr;
   private String fabligCouleur;
   private FabricationEnteteAchats fabricationEnteteAchats;
   private boolean verouCod;
   private String var_lib_uni_condit;
   private Unite unite = new Unite();
   private String codeFamille;
   private String format;

   public String getCodeFamille() {
      if (this.fabligFamille != null && !this.fabligFamille.isEmpty() && this.fabligFamille.contains(":")) {
         String[] var1 = this.fabligFamille.split(":");
         this.codeFamille = var1[0];
      } else {
         this.codeFamille = this.fabligFamille;
      }

      return this.codeFamille;
   }

   public void setCodeFamille(String var1) {
      this.codeFamille = var1;
   }

   public String getFormat() {
      if (this.fabligModePapier == 0) {
         this.format = this.fabligHaut + "x" + this.fabligLong;
      } else {
         this.format = "" + this.fabligLarg;
      }

      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.fabligCondition != null && !this.fabligCondition.isEmpty() && this.fabligCondition.contains(":")) {
         if (this.fabligDescription != null && !this.fabligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.fabligDescription;
         } else if (this.fabligCondition.contains("/")) {
            String[] var1 = this.fabligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.fabligCondition;
         }
      } else if (this.fabligCondition != null && !this.fabligCondition.isEmpty() && !this.fabligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.fabligCondition));
      } else if (this.fabligUnite != null && !this.fabligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.fabligUnite;
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

   public FabricationEnteteAchats getFabricationEnteteAchats() {
      return this.fabricationEnteteAchats;
   }

   public void setFabricationEnteteAchats(FabricationEnteteAchats var1) {
      this.fabricationEnteteAchats = var1;
   }

   public String getFabligCasier() {
      return this.fabligCasier;
   }

   public void setFabligCasier(String var1) {
      this.fabligCasier = var1;
   }

   public String getFabligCode() {
      return this.fabligCode;
   }

   public void setFabligCode(String var1) {
      this.fabligCode = var1;
   }

   public String getFabligCondition() {
      return this.fabligCondition;
   }

   public void setFabligCondition(String var1) {
      this.fabligCondition = var1;
   }

   public String getFabligDepot() {
      return this.fabligDepot;
   }

   public void setFabligDepot(String var1) {
      this.fabligDepot = var1;
   }

   public String getFabligDescription() {
      return this.fabligDescription;
   }

   public void setFabligDescription(String var1) {
      this.fabligDescription = var1;
   }

   public float getFabligDiam() {
      return this.fabligDiam;
   }

   public void setFabligDiam(float var1) {
      this.fabligDiam = var1;
   }

   public String getFabligFamille() {
      return this.fabligFamille;
   }

   public void setFabligFamille(String var1) {
      this.fabligFamille = var1;
   }

   public float getFabligHaut() {
      return this.fabligHaut;
   }

   public void setFabligHaut(float var1) {
      this.fabligHaut = var1;
   }

   public long getFabligId() {
      return this.fabligId;
   }

   public void setFabligId(long var1) {
      this.fabligId = var1;
   }

   public float getFabligLarg() {
      return this.fabligLarg;
   }

   public void setFabligLarg(float var1) {
      this.fabligLarg = var1;
   }

   public String getFabligLibelle() {
      return this.fabligLibelle;
   }

   public void setFabligLibelle(String var1) {
      this.fabligLibelle = var1;
   }

   public float getFabligLong() {
      return this.fabligLong;
   }

   public void setFabligLong(float var1) {
      this.fabligLong = var1;
   }

   public float getFabligNb() {
      return this.fabligNb;
   }

   public void setFabligNb(float var1) {
      this.fabligNb = var1;
   }

   public String getFabligObs() {
      return this.fabligObs;
   }

   public void setFabligObs(String var1) {
      this.fabligObs = var1;
   }

   public float getFabligPoidsBrut() {
      return this.fabligPoidsBrut;
   }

   public void setFabligPoidsBrut(float var1) {
      this.fabligPoidsBrut = var1;
   }

   public float getFabligPoidsNet() {
      return this.fabligPoidsNet;
   }

   public void setFabligPoidsNet(float var1) {
      this.fabligPoidsNet = var1;
   }

   public double getFabligPump() {
      return this.fabligPump;
   }

   public void setFabligPump(double var1) {
      this.fabligPump = var1;
   }

   public float getFabligQteStock() {
      return this.fabligQteStock;
   }

   public void setFabligQteStock(float var1) {
      this.fabligQteStock = var1;
   }

   public float getFabligQteUtil() {
      return this.fabligQteUtil;
   }

   public void setFabligQteUtil(float var1) {
      this.fabligQteUtil = var1;
   }

   public String getFabligReference() {
      return this.fabligReference;
   }

   public void setFabligReference(String var1) {
      this.fabligReference = var1;
   }

   public int getFabligStock() {
      return this.fabligStock;
   }

   public void setFabligStock(int var1) {
      this.fabligStock = var1;
   }

   public double getFabligTotal() {
      return this.fabligTotal;
   }

   public void setFabligTotal(double var1) {
      this.fabligTotal = var1;
   }

   public String getFabligUnite() {
      return this.fabligUnite;
   }

   public void setFabligUnite(String var1) {
      this.fabligUnite = var1;
   }

   public float getFabligVolume() {
      return this.fabligVolume;
   }

   public void setFabligVolume(float var1) {
      this.fabligVolume = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public int getFabligType() {
      return this.fabligType;
   }

   public void setFabligType(int var1) {
      this.fabligType = var1;
   }

   public float getFabligQte() {
      return this.fabligQte;
   }

   public void setFabligQte(float var1) {
      this.fabligQte = var1;
   }

   public double getFabligQteReference() {
      return this.fabligQteReference;
   }

   public void setFabligQteReference(double var1) {
      this.fabligQteReference = var1;
   }

   public int getFabligHh() {
      return this.fabligHh;
   }

   public void setFabligHh(int var1) {
      this.fabligHh = var1;
   }

   public int getFabligJj() {
      return this.fabligJj;
   }

   public void setFabligJj(int var1) {
      this.fabligJj = var1;
   }

   public String getFabligMateriel() {
      return this.fabligMateriel;
   }

   public void setFabligMateriel(String var1) {
      this.fabligMateriel = var1;
   }

   public String getFabligMetier() {
      return this.fabligMetier;
   }

   public void setFabligMetier(String var1) {
      this.fabligMetier = var1;
   }

   public int getFabligMm() {
      return this.fabligMm;
   }

   public void setFabligMm(int var1) {
      this.fabligMm = var1;
   }

   public int getFabligSs() {
      return this.fabligSs;
   }

   public void setFabligSs(int var1) {
      this.fabligSs = var1;
   }

   public boolean isFabligInterChange() {
      return this.fabligInterChange;
   }

   public void setFabligInterChange(boolean var1) {
      this.fabligInterChange = var1;
   }

   public String getFabligProduitInterchangeable() {
      return this.fabligProduitInterchangeable;
   }

   public void setFabligProduitInterchangeable(String var1) {
      this.fabligProduitInterchangeable = var1;
   }

   public int getFabligOrdre() {
      return this.fabligOrdre;
   }

   public void setFabligOrdre(int var1) {
      this.fabligOrdre = var1;
   }

   public float getFabligQteRestant() {
      return this.fabligQteRestant;
   }

   public void setFabligQteRestant(float var1) {
      this.fabligQteRestant = var1;
   }

   public String getFabligLot() {
      return this.fabligLot;
   }

   public void setFabligLot(String var1) {
      this.fabligLot = var1;
   }

   public String getFabligNumSerie() {
      return this.fabligNumSerie;
   }

   public void setFabligNumSerie(String var1) {
      this.fabligNumSerie = var1;
   }

   public int getFabligEchelle() {
      return this.fabligEchelle;
   }

   public void setFabligEchelle(int var1) {
      this.fabligEchelle = var1;
   }

   public String getFabligCouleur() {
      return this.fabligCouleur;
   }

   public void setFabligCouleur(String var1) {
      this.fabligCouleur = var1;
   }

   public String getFabligDouane() {
      return this.fabligDouane;
   }

   public void setFabligDouane(String var1) {
      this.fabligDouane = var1;
   }

   public float getFabligGr() {
      return this.fabligGr;
   }

   public void setFabligGr(float var1) {
      this.fabligGr = var1;
   }

   public int getFabligModePapier() {
      return this.fabligModePapier;
   }

   public void setFabligModePapier(int var1) {
      this.fabligModePapier = var1;
   }

   public float getFabligTauxDouane() {
      return this.fabligTauxDouane;
   }

   public void setFabligTauxDouane(float var1) {
      this.fabligTauxDouane = var1;
   }
}
