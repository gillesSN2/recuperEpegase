package com.epegase.systeme.classe;

import java.io.Serializable;

public class ParcOrPiece implements Serializable {
   private long prcorpId;
   private String prcorpCode;
   private String prcorpDepot;
   private String prcorpFamille;
   private String prcorpLibelle;
   private String prcorpReference;
   private String prcorpUnite;
   private String prcorpCondition;
   private String prcorpDescription;
   private String prcorpTaxe;
   private float prcorpTauxTaxe;
   private int prcorpEchelle;
   private float prcorpQte;
   private String prcorpCasier;
   private float prcorpLong;
   private float prcorpLarg;
   private float prcorpHaut;
   private float prcorpDiam;
   private float prcorpNb;
   private float prcorpPoidsNet;
   private float prcorpPoidsBrut;
   private float prcorpVolume;
   private float prcorpQteUtil;
   private int prcorpStock;
   private float prcorpQteStock;
   private double prcorpPu;
   private float prcorpTauxRemise;
   private double prcorpRabais;
   private double prcorpPuRem;
   private double prcorpPuTtc;
   private double prcorpPuRemTtc;
   private double prcorpPt;
   private double prcorpTva;
   private double prcorpTc;
   private double prcorpTtc;
   private double prcorpPump;
   private double prcorpTotal;
   private String prcorpObs;
   private int prcorpMode;
   private int prcorpType;
   private ParcOrEntete parcOrEntete;
   private boolean verouCod;
   private String var_lib_uni_condit;
   private Unite unite = new Unite();

   public String getVar_lib_uni_condit() {
      if (this.prcorpCondition != null && !this.prcorpCondition.isEmpty() && this.prcorpCondition.contains(":")) {
         if (this.prcorpDescription != null && !this.prcorpDescription.isEmpty()) {
            this.var_lib_uni_condit = this.prcorpDescription;
         } else if (this.prcorpCondition.contains("/")) {
            String[] var1 = this.prcorpCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.prcorpCondition;
         }
      } else if (this.prcorpCondition != null && !this.prcorpCondition.isEmpty() && !this.prcorpCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.prcorpCondition));
      } else if (this.prcorpUnite != null && !this.prcorpUnite.isEmpty()) {
         this.var_lib_uni_condit = this.prcorpUnite;
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

   public ParcOrEntete getParcOrEntete() {
      return this.parcOrEntete;
   }

   public void setParcOrEntete(ParcOrEntete var1) {
      this.parcOrEntete = var1;
   }

   public String getPrcorpCasier() {
      return this.prcorpCasier;
   }

   public void setPrcorpCasier(String var1) {
      this.prcorpCasier = var1;
   }

   public String getPrcorpCode() {
      return this.prcorpCode;
   }

   public void setPrcorpCode(String var1) {
      this.prcorpCode = var1;
   }

   public String getPrcorpCondition() {
      return this.prcorpCondition;
   }

   public void setPrcorpCondition(String var1) {
      this.prcorpCondition = var1;
   }

   public String getPrcorpDepot() {
      return this.prcorpDepot;
   }

   public void setPrcorpDepot(String var1) {
      this.prcorpDepot = var1;
   }

   public String getPrcorpDescription() {
      return this.prcorpDescription;
   }

   public void setPrcorpDescription(String var1) {
      this.prcorpDescription = var1;
   }

   public float getPrcorpDiam() {
      return this.prcorpDiam;
   }

   public void setPrcorpDiam(float var1) {
      this.prcorpDiam = var1;
   }

   public String getPrcorpFamille() {
      return this.prcorpFamille;
   }

   public void setPrcorpFamille(String var1) {
      this.prcorpFamille = var1;
   }

   public float getPrcorpHaut() {
      return this.prcorpHaut;
   }

   public void setPrcorpHaut(float var1) {
      this.prcorpHaut = var1;
   }

   public long getPrcorpId() {
      return this.prcorpId;
   }

   public void setPrcorpId(long var1) {
      this.prcorpId = var1;
   }

   public float getPrcorpLarg() {
      return this.prcorpLarg;
   }

   public void setPrcorpLarg(float var1) {
      this.prcorpLarg = var1;
   }

   public String getPrcorpLibelle() {
      return this.prcorpLibelle;
   }

   public void setPrcorpLibelle(String var1) {
      this.prcorpLibelle = var1;
   }

   public float getPrcorpLong() {
      return this.prcorpLong;
   }

   public void setPrcorpLong(float var1) {
      this.prcorpLong = var1;
   }

   public float getPrcorpNb() {
      return this.prcorpNb;
   }

   public void setPrcorpNb(float var1) {
      this.prcorpNb = var1;
   }

   public String getPrcorpObs() {
      return this.prcorpObs;
   }

   public void setPrcorpObs(String var1) {
      this.prcorpObs = var1;
   }

   public float getPrcorpPoidsBrut() {
      return this.prcorpPoidsBrut;
   }

   public void setPrcorpPoidsBrut(float var1) {
      this.prcorpPoidsBrut = var1;
   }

   public float getPrcorpPoidsNet() {
      return this.prcorpPoidsNet;
   }

   public void setPrcorpPoidsNet(float var1) {
      this.prcorpPoidsNet = var1;
   }

   public double getPrcorpPump() {
      return this.prcorpPump;
   }

   public void setPrcorpPump(double var1) {
      this.prcorpPump = var1;
   }

   public float getPrcorpQte() {
      return this.prcorpQte;
   }

   public void setPrcorpQte(float var1) {
      this.prcorpQte = var1;
   }

   public float getPrcorpQteStock() {
      return this.prcorpQteStock;
   }

   public void setPrcorpQteStock(float var1) {
      this.prcorpQteStock = var1;
   }

   public float getPrcorpQteUtil() {
      return this.prcorpQteUtil;
   }

   public void setPrcorpQteUtil(float var1) {
      this.prcorpQteUtil = var1;
   }

   public String getPrcorpReference() {
      return this.prcorpReference;
   }

   public void setPrcorpReference(String var1) {
      this.prcorpReference = var1;
   }

   public int getPrcorpStock() {
      return this.prcorpStock;
   }

   public void setPrcorpStock(int var1) {
      this.prcorpStock = var1;
   }

   public double getPrcorpTotal() {
      return this.prcorpTotal;
   }

   public void setPrcorpTotal(double var1) {
      this.prcorpTotal = var1;
   }

   public String getPrcorpUnite() {
      return this.prcorpUnite;
   }

   public void setPrcorpUnite(String var1) {
      this.prcorpUnite = var1;
   }

   public float getPrcorpVolume() {
      return this.prcorpVolume;
   }

   public void setPrcorpVolume(float var1) {
      this.prcorpVolume = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public float getPrcorpTauxTaxe() {
      return this.prcorpTauxTaxe;
   }

   public void setPrcorpTauxTaxe(float var1) {
      this.prcorpTauxTaxe = var1;
   }

   public String getPrcorpTaxe() {
      return this.prcorpTaxe;
   }

   public void setPrcorpTaxe(String var1) {
      this.prcorpTaxe = var1;
   }

   public double getPrcorpPt() {
      return this.prcorpPt;
   }

   public void setPrcorpPt(double var1) {
      this.prcorpPt = var1;
   }

   public double getPrcorpPu() {
      return this.prcorpPu;
   }

   public void setPrcorpPu(double var1) {
      this.prcorpPu = var1;
   }

   public double getPrcorpPuRem() {
      return this.prcorpPuRem;
   }

   public void setPrcorpPuRem(double var1) {
      this.prcorpPuRem = var1;
   }

   public double getPrcorpPuRemTtc() {
      return this.prcorpPuRemTtc;
   }

   public void setPrcorpPuRemTtc(double var1) {
      this.prcorpPuRemTtc = var1;
   }

   public double getPrcorpPuTtc() {
      return this.prcorpPuTtc;
   }

   public void setPrcorpPuTtc(double var1) {
      this.prcorpPuTtc = var1;
   }

   public double getPrcorpRabais() {
      return this.prcorpRabais;
   }

   public void setPrcorpRabais(double var1) {
      this.prcorpRabais = var1;
   }

   public float getPrcorpTauxRemise() {
      return this.prcorpTauxRemise;
   }

   public void setPrcorpTauxRemise(float var1) {
      this.prcorpTauxRemise = var1;
   }

   public double getPrcorpTc() {
      return this.prcorpTc;
   }

   public void setPrcorpTc(double var1) {
      this.prcorpTc = var1;
   }

   public double getPrcorpTtc() {
      return this.prcorpTtc;
   }

   public void setPrcorpTtc(double var1) {
      this.prcorpTtc = var1;
   }

   public double getPrcorpTva() {
      return this.prcorpTva;
   }

   public void setPrcorpTva(double var1) {
      this.prcorpTva = var1;
   }

   public int getPrcorpEchelle() {
      return this.prcorpEchelle;
   }

   public void setPrcorpEchelle(int var1) {
      this.prcorpEchelle = var1;
   }

   public int getPrcorpMode() {
      return this.prcorpMode;
   }

   public void setPrcorpMode(int var1) {
      this.prcorpMode = var1;
   }

   public int getPrcorpType() {
      return this.prcorpType;
   }

   public void setPrcorpType(int var1) {
      this.prcorpType = var1;
   }
}
