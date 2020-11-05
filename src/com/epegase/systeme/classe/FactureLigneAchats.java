package com.epegase.systeme.classe;

import java.io.Serializable;

public class FactureLigneAchats implements Serializable {
   private long fcfligId;
   private long fcfligIdDa;
   private long fcfligIdCot;
   private long fcfligIdCmd;
   private long fcfligIdRec;
   private String fcfligCode;
   private String fcfligFamille;
   private String fcfligLibelle;
   private String fcfligLibelleFournisseur;
   private String fcfligComplement;
   private String fcfligReference;
   private String fcfligTaxe;
   private float fcfligTauxTaxe;
   private String fcfligUnite;
   private String fcfligCondition;
   private String fcfligDescription;
   private float fcfligQte;
   private float fcfligLong;
   private float fcfligLarg;
   private float fcfligHaut;
   private float fcfligDiam;
   private float fcfligNb;
   private float fcfligPoidsNet;
   private float fcfligPoidsBrut;
   private float fcfligVolume;
   private float fcfligQteUtil;
   private String fcfligDepot;
   private float fcfligQteStock;
   private int fcfligEchelle;
   private String fcfligDevise;
   private double fcfligPu;
   private float fcfligTauxRemise;
   private double fcfligRabais;
   private double fcfligPuRem;
   private double fcfligPt;
   private double fcfligPtDev;
   private double fcfligTva;
   private double fcfligTc;
   private double fcfligTtc;
   private double fcfligPr;
   private double fcfligPump;
   private FactureEnteteAchats factureEnteteAchats;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;

   public String getVar_lib_uni_condit() {
      if (this.fcfligCondition != null && !this.fcfligCondition.isEmpty() && this.fcfligCondition.contains(":")) {
         if (this.fcfligDescription != null && !this.fcfligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.fcfligDescription;
         } else if (this.fcfligCondition.contains("/")) {
            String[] var1 = this.fcfligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.fcfligCondition;
         }
      } else if (this.fcfligCondition == null || this.fcfligCondition.isEmpty() || this.fcfligCondition.contains(":")) {
         if (this.fcfligUnite != null && !this.fcfligUnite.isEmpty()) {
            this.var_lib_uni_condit = this.fcfligUnite;
         } else {
            this.var_lib_uni_condit = "";
         }
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public FactureEnteteAchats getFactureEnteteAchats() {
      return this.factureEnteteAchats;
   }

   public void setFactureEnteteAchats(FactureEnteteAchats var1) {
      this.factureEnteteAchats = var1;
   }

   public String getFcfligCode() {
      return this.fcfligCode;
   }

   public void setFcfligCode(String var1) {
      this.fcfligCode = var1;
   }

   public String getFcfligDepot() {
      return this.fcfligDepot;
   }

   public void setFcfligDepot(String var1) {
      this.fcfligDepot = var1;
   }

   public String getFcfligDevise() {
      return this.fcfligDevise;
   }

   public void setFcfligDevise(String var1) {
      this.fcfligDevise = var1;
   }

   public String getFcfligFamille() {
      return this.fcfligFamille;
   }

   public void setFcfligFamille(String var1) {
      this.fcfligFamille = var1;
   }

   public long getFcfligId() {
      return this.fcfligId;
   }

   public void setFcfligId(long var1) {
      this.fcfligId = var1;
   }

   public long getFcfligIdRec() {
      return this.fcfligIdRec;
   }

   public void setFcfligIdRec(long var1) {
      this.fcfligIdRec = var1;
   }

   public String getFcfligLibelle() {
      return this.fcfligLibelle;
   }

   public void setFcfligLibelle(String var1) {
      this.fcfligLibelle = var1;
   }

   public double getFcfligPr() {
      return this.fcfligPr;
   }

   public void setFcfligPr(double var1) {
      this.fcfligPr = var1;
   }

   public double getFcfligPt() {
      return this.fcfligPt;
   }

   public void setFcfligPt(double var1) {
      this.fcfligPt = var1;
   }

   public double getFcfligPu() {
      return this.fcfligPu;
   }

   public void setFcfligPu(double var1) {
      this.fcfligPu = var1;
   }

   public double getFcfligPuRem() {
      return this.fcfligPuRem;
   }

   public void setFcfligPuRem(double var1) {
      this.fcfligPuRem = var1;
   }

   public double getFcfligPump() {
      return this.fcfligPump;
   }

   public void setFcfligPump(double var1) {
      this.fcfligPump = var1;
   }

   public float getFcfligQte() {
      return this.fcfligQte;
   }

   public void setFcfligQte(float var1) {
      this.fcfligQte = var1;
   }

   public float getFcfligQteStock() {
      return this.fcfligQteStock;
   }

   public void setFcfligQteStock(float var1) {
      this.fcfligQteStock = var1;
   }

   public double getFcfligRabais() {
      return this.fcfligRabais;
   }

   public void setFcfligRabais(double var1) {
      this.fcfligRabais = var1;
   }

   public String getFcfligReference() {
      return this.fcfligReference;
   }

   public void setFcfligReference(String var1) {
      this.fcfligReference = var1;
   }

   public float getFcfligTauxRemise() {
      return this.fcfligTauxRemise;
   }

   public void setFcfligTauxRemise(float var1) {
      this.fcfligTauxRemise = var1;
   }

   public float getFcfligTauxTaxe() {
      return this.fcfligTauxTaxe;
   }

   public void setFcfligTauxTaxe(float var1) {
      this.fcfligTauxTaxe = var1;
   }

   public String getFcfligTaxe() {
      return this.fcfligTaxe;
   }

   public void setFcfligTaxe(String var1) {
      this.fcfligTaxe = var1;
   }

   public double getFcfligTc() {
      return this.fcfligTc;
   }

   public void setFcfligTc(double var1) {
      this.fcfligTc = var1;
   }

   public double getFcfligTtc() {
      return this.fcfligTtc;
   }

   public void setFcfligTtc(double var1) {
      this.fcfligTtc = var1;
   }

   public double getFcfligTva() {
      return this.fcfligTva;
   }

   public void setFcfligTva(double var1) {
      this.fcfligTva = var1;
   }

   public String getFcfligUnite() {
      return this.fcfligUnite;
   }

   public void setFcfligUnite(String var1) {
      this.fcfligUnite = var1;
   }

   public float getVar_qteDejaTrf() {
      return this.var_qteDejaTrf;
   }

   public void setVar_qteDejaTrf(float var1) {
      this.var_qteDejaTrf = var1;
   }

   public float getVar_qteReliquat() {
      return this.var_qteReliquat;
   }

   public void setVar_qteReliquat(float var1) {
      this.var_qteReliquat = var1;
   }

   public long getFcfligIdCmd() {
      return this.fcfligIdCmd;
   }

   public void setFcfligIdCmd(long var1) {
      this.fcfligIdCmd = var1;
   }

   public long getFcfligIdCot() {
      return this.fcfligIdCot;
   }

   public void setFcfligIdCot(long var1) {
      this.fcfligIdCot = var1;
   }

   public long getFcfligIdDa() {
      return this.fcfligIdDa;
   }

   public void setFcfligIdDa(long var1) {
      this.fcfligIdDa = var1;
   }

   public String getFcfligCondition() {
      return this.fcfligCondition;
   }

   public void setFcfligCondition(String var1) {
      this.fcfligCondition = var1;
   }

   public float getFcfligDiam() {
      return this.fcfligDiam;
   }

   public void setFcfligDiam(float var1) {
      this.fcfligDiam = var1;
   }

   public float getFcfligHaut() {
      return this.fcfligHaut;
   }

   public void setFcfligHaut(float var1) {
      this.fcfligHaut = var1;
   }

   public float getFcfligLarg() {
      return this.fcfligLarg;
   }

   public void setFcfligLarg(float var1) {
      this.fcfligLarg = var1;
   }

   public float getFcfligLong() {
      return this.fcfligLong;
   }

   public void setFcfligLong(float var1) {
      this.fcfligLong = var1;
   }

   public float getFcfligNb() {
      return this.fcfligNb;
   }

   public void setFcfligNb(float var1) {
      this.fcfligNb = var1;
   }

   public float getFcfligQteUtil() {
      return this.fcfligQteUtil;
   }

   public void setFcfligQteUtil(float var1) {
      this.fcfligQteUtil = var1;
   }

   public float getFcfligPoidsBrut() {
      return this.fcfligPoidsBrut;
   }

   public void setFcfligPoidsBrut(float var1) {
      this.fcfligPoidsBrut = var1;
   }

   public float getFcfligPoidsNet() {
      return this.fcfligPoidsNet;
   }

   public void setFcfligPoidsNet(float var1) {
      this.fcfligPoidsNet = var1;
   }

   public float getFcfligVolume() {
      return this.fcfligVolume;
   }

   public void setFcfligVolume(float var1) {
      this.fcfligVolume = var1;
   }

   public int getFcfligEchelle() {
      return this.fcfligEchelle;
   }

   public void setFcfligEchelle(int var1) {
      this.fcfligEchelle = var1;
   }

   public String getFcfligDescription() {
      return this.fcfligDescription;
   }

   public void setFcfligDescription(String var1) {
      this.fcfligDescription = var1;
   }

   public String getFcfligComplement() {
      return this.fcfligComplement;
   }

   public void setFcfligComplement(String var1) {
      this.fcfligComplement = var1;
   }

   public String getFcfligLibelleFournisseur() {
      return this.fcfligLibelleFournisseur;
   }

   public void setFcfligLibelleFournisseur(String var1) {
      this.fcfligLibelleFournisseur = var1;
   }

   public double getFcfligPtDev() {
      return this.fcfligPtDev;
   }

   public void setFcfligPtDev(double var1) {
      this.fcfligPtDev = var1;
   }
}
