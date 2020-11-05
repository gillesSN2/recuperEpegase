package com.epegase.systeme.classe;

import java.io.Serializable;

public class AvoirLigneAchats implements Serializable {
   private long avfligId;
   private long avfligIdFcf;
   private long avfligIdNdf;
   private String avfligCode;
   private String avfligFamille;
   private String avfligLibelle;
   private String avfligLibelleFournisseur;
   private String avfligComplement;
   private String avfligReference;
   private String avfligTaxe;
   private float avfligTauxTaxe;
   private String avfligUnite;
   private String avfligCondition;
   private String avfligDescription;
   private int avfligOrdre;
   private int avfligEchelle;
   private float avfligQte;
   private float avfligLong;
   private float avfligLarg;
   private float avfligHaut;
   private float avfligDiam;
   private float avfligNb;
   private float avfligPoidsNet;
   private float avfligPoidsBrut;
   private float avfligVolume;
   private float avfligQteUtil;
   private String avfligDevise;
   private double avfligPu;
   private float avfligTauxRemise;
   private double avfligRabais;
   private double avfligPuRem;
   private double avfligPt;
   private double avfligTva;
   private double avfligTc;
   private double avfligTtc;
   private double avfligPr;
   private double avfligPump;
   private AvoirEnteteAchats avoirEnteteAchats;
   private String var_lib_uni_condit;

   public String getVar_lib_uni_condit() {
      if (this.avfligCondition != null && !this.avfligCondition.isEmpty() && this.avfligCondition.contains(":")) {
         if (this.avfligDescription != null && !this.avfligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.avfligDescription;
         } else if (this.avfligCondition.contains("/")) {
            String[] var1 = this.avfligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.avfligCondition;
         }
      } else if (this.avfligCondition == null || this.avfligCondition.isEmpty() || this.avfligCondition.contains(":")) {
         if (this.avfligUnite != null && !this.avfligUnite.isEmpty()) {
            this.var_lib_uni_condit = this.avfligUnite;
         } else {
            this.var_lib_uni_condit = "";
         }
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public String getAvfligCode() {
      return this.avfligCode;
   }

   public void setAvfligCode(String var1) {
      this.avfligCode = var1;
   }

   public String getAvfligDevise() {
      return this.avfligDevise;
   }

   public void setAvfligDevise(String var1) {
      this.avfligDevise = var1;
   }

   public String getAvfligFamille() {
      return this.avfligFamille;
   }

   public void setAvfligFamille(String var1) {
      this.avfligFamille = var1;
   }

   public long getAvfligId() {
      return this.avfligId;
   }

   public void setAvfligId(long var1) {
      this.avfligId = var1;
   }

   public long getAvfligIdFcf() {
      return this.avfligIdFcf;
   }

   public void setAvfligIdFcf(long var1) {
      this.avfligIdFcf = var1;
   }

   public String getAvfligLibelle() {
      return this.avfligLibelle;
   }

   public void setAvfligLibelle(String var1) {
      this.avfligLibelle = var1;
   }

   public double getAvfligPt() {
      return this.avfligPt;
   }

   public void setAvfligPt(double var1) {
      this.avfligPt = var1;
   }

   public double getAvfligPu() {
      return this.avfligPu;
   }

   public void setAvfligPu(double var1) {
      this.avfligPu = var1;
   }

   public double getAvfligPuRem() {
      return this.avfligPuRem;
   }

   public void setAvfligPuRem(double var1) {
      this.avfligPuRem = var1;
   }

   public float getAvfligQte() {
      return this.avfligQte;
   }

   public void setAvfligQte(float var1) {
      this.avfligQte = var1;
   }

   public double getAvfligRabais() {
      return this.avfligRabais;
   }

   public void setAvfligRabais(double var1) {
      this.avfligRabais = var1;
   }

   public String getAvfligReference() {
      return this.avfligReference;
   }

   public void setAvfligReference(String var1) {
      this.avfligReference = var1;
   }

   public float getAvfligTauxRemise() {
      return this.avfligTauxRemise;
   }

   public void setAvfligTauxRemise(float var1) {
      this.avfligTauxRemise = var1;
   }

   public float getAvfligTauxTaxe() {
      return this.avfligTauxTaxe;
   }

   public void setAvfligTauxTaxe(float var1) {
      this.avfligTauxTaxe = var1;
   }

   public String getAvfligTaxe() {
      return this.avfligTaxe;
   }

   public void setAvfligTaxe(String var1) {
      this.avfligTaxe = var1;
   }

   public double getAvfligTc() {
      return this.avfligTc;
   }

   public void setAvfligTc(double var1) {
      this.avfligTc = var1;
   }

   public double getAvfligTtc() {
      return this.avfligTtc;
   }

   public void setAvfligTtc(double var1) {
      this.avfligTtc = var1;
   }

   public double getAvfligTva() {
      return this.avfligTva;
   }

   public void setAvfligTva(double var1) {
      this.avfligTva = var1;
   }

   public String getAvfligUnite() {
      return this.avfligUnite;
   }

   public void setAvfligUnite(String var1) {
      this.avfligUnite = var1;
   }

   public AvoirEnteteAchats getAvoirEnteteAchats() {
      return this.avoirEnteteAchats;
   }

   public void setAvoirEnteteAchats(AvoirEnteteAchats var1) {
      this.avoirEnteteAchats = var1;
   }

   public double getAvfligPr() {
      return this.avfligPr;
   }

   public void setAvfligPr(double var1) {
      this.avfligPr = var1;
   }

   public double getAvfligPump() {
      return this.avfligPump;
   }

   public void setAvfligPump(double var1) {
      this.avfligPump = var1;
   }

   public long getAvfligIdNdf() {
      return this.avfligIdNdf;
   }

   public void setAvfligIdNdf(long var1) {
      this.avfligIdNdf = var1;
   }

   public String getAvfligCondition() {
      return this.avfligCondition;
   }

   public void setAvfligCondition(String var1) {
      this.avfligCondition = var1;
   }

   public float getAvfligDiam() {
      return this.avfligDiam;
   }

   public void setAvfligDiam(float var1) {
      this.avfligDiam = var1;
   }

   public float getAvfligHaut() {
      return this.avfligHaut;
   }

   public void setAvfligHaut(float var1) {
      this.avfligHaut = var1;
   }

   public float getAvfligLarg() {
      return this.avfligLarg;
   }

   public void setAvfligLarg(float var1) {
      this.avfligLarg = var1;
   }

   public float getAvfligLong() {
      return this.avfligLong;
   }

   public void setAvfligLong(float var1) {
      this.avfligLong = var1;
   }

   public float getAvfligNb() {
      return this.avfligNb;
   }

   public void setAvfligNb(float var1) {
      this.avfligNb = var1;
   }

   public float getAvfligQteUtil() {
      return this.avfligQteUtil;
   }

   public void setAvfligQteUtil(float var1) {
      this.avfligQteUtil = var1;
   }

   public float getAvfligPoidsBrut() {
      return this.avfligPoidsBrut;
   }

   public void setAvfligPoidsBrut(float var1) {
      this.avfligPoidsBrut = var1;
   }

   public float getAvfligPoidsNet() {
      return this.avfligPoidsNet;
   }

   public void setAvfligPoidsNet(float var1) {
      this.avfligPoidsNet = var1;
   }

   public float getAvfligVolume() {
      return this.avfligVolume;
   }

   public void setAvfligVolume(float var1) {
      this.avfligVolume = var1;
   }

   public int getAvfligEchelle() {
      return this.avfligEchelle;
   }

   public void setAvfligEchelle(int var1) {
      this.avfligEchelle = var1;
   }

   public String getAvfligDescription() {
      return this.avfligDescription;
   }

   public void setAvfligDescription(String var1) {
      this.avfligDescription = var1;
   }

   public String getAvfligComplement() {
      return this.avfligComplement;
   }

   public void setAvfligComplement(String var1) {
      this.avfligComplement = var1;
   }

   public String getAvfligLibelleFournisseur() {
      return this.avfligLibelleFournisseur;
   }

   public void setAvfligLibelleFournisseur(String var1) {
      this.avfligLibelleFournisseur = var1;
   }

   public int getAvfligOrdre() {
      return this.avfligOrdre;
   }

   public void setAvfligOrdre(int var1) {
      this.avfligOrdre = var1;
   }
}
