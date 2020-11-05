package com.epegase.systeme.classe;

import java.io.Serializable;

public class ManifestProduit implements Serializable {
   private long vteprdId;
   private String vteprdNum;
   private int vteprdOrdre;
   private String vteprdNumManifest;
   private int vteprdModeFactureDetail;
   private String vteprdImmaTc1;
   private int vteprdModelTc1;
   private String vteprdPlombTc1;
   private String vteprdImmaTc2;
   private int vteprdModelTc2;
   private String vteprdPlombTc2;
   private String vteprdRefTypeColis;
   private String vteprdLibTypeColis;
   private String vteprdNatureColis;
   private int vteprdNbreColis;
   private float vteprdPoids;
   private float vteprdVolume;
   private String vteprdDescription;
   private double vteprdPu;
   private float vteprdRemise;
   private double vteprdPuRem;
   private double vteprdTotalHt;
   private String vteprdCodeTva;
   private float vteprdTauxTva;
   private double vteprdTotalTva;
   private double vteprdTotalTtc;
   private float vteprdTauxTc;
   private double vteprdTc;
   private String styleLigne;

   public String getStyleLigne() {
      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public String getVteprdCodeTva() {
      return this.vteprdCodeTva;
   }

   public void setVteprdCodeTva(String var1) {
      this.vteprdCodeTva = var1;
   }

   public String getVteprdDescription() {
      return this.vteprdDescription;
   }

   public void setVteprdDescription(String var1) {
      this.vteprdDescription = var1;
   }

   public long getVteprdId() {
      return this.vteprdId;
   }

   public void setVteprdId(long var1) {
      this.vteprdId = var1;
   }

   public String getVteprdLibTypeColis() {
      return this.vteprdLibTypeColis;
   }

   public void setVteprdLibTypeColis(String var1) {
      this.vteprdLibTypeColis = var1;
   }

   public String getVteprdNatureColis() {
      return this.vteprdNatureColis;
   }

   public void setVteprdNatureColis(String var1) {
      this.vteprdNatureColis = var1;
   }

   public int getVteprdNbreColis() {
      return this.vteprdNbreColis;
   }

   public void setVteprdNbreColis(int var1) {
      this.vteprdNbreColis = var1;
   }

   public String getVteprdNum() {
      return this.vteprdNum;
   }

   public void setVteprdNum(String var1) {
      this.vteprdNum = var1;
   }

   public String getVteprdNumManifest() {
      return this.vteprdNumManifest;
   }

   public void setVteprdNumManifest(String var1) {
      this.vteprdNumManifest = var1;
   }

   public int getVteprdOrdre() {
      return this.vteprdOrdre;
   }

   public void setVteprdOrdre(int var1) {
      this.vteprdOrdre = var1;
   }

   public float getVteprdPoids() {
      return this.vteprdPoids;
   }

   public void setVteprdPoids(float var1) {
      this.vteprdPoids = var1;
   }

   public double getVteprdPu() {
      return this.vteprdPu;
   }

   public void setVteprdPu(double var1) {
      this.vteprdPu = var1;
   }

   public double getVteprdPuRem() {
      return this.vteprdPuRem;
   }

   public void setVteprdPuRem(double var1) {
      this.vteprdPuRem = var1;
   }

   public String getVteprdRefTypeColis() {
      return this.vteprdRefTypeColis;
   }

   public void setVteprdRefTypeColis(String var1) {
      this.vteprdRefTypeColis = var1;
   }

   public float getVteprdRemise() {
      return this.vteprdRemise;
   }

   public void setVteprdRemise(float var1) {
      this.vteprdRemise = var1;
   }

   public float getVteprdTauxTc() {
      return this.vteprdTauxTc;
   }

   public void setVteprdTauxTc(float var1) {
      this.vteprdTauxTc = var1;
   }

   public float getVteprdTauxTva() {
      return this.vteprdTauxTva;
   }

   public void setVteprdTauxTva(float var1) {
      this.vteprdTauxTva = var1;
   }

   public double getVteprdTc() {
      return this.vteprdTc;
   }

   public void setVteprdTc(double var1) {
      this.vteprdTc = var1;
   }

   public double getVteprdTotalHt() {
      return this.vteprdTotalHt;
   }

   public void setVteprdTotalHt(double var1) {
      this.vteprdTotalHt = var1;
   }

   public double getVteprdTotalTtc() {
      return this.vteprdTotalTtc;
   }

   public void setVteprdTotalTtc(double var1) {
      this.vteprdTotalTtc = var1;
   }

   public double getVteprdTotalTva() {
      return this.vteprdTotalTva;
   }

   public void setVteprdTotalTva(double var1) {
      this.vteprdTotalTva = var1;
   }

   public float getVteprdVolume() {
      return this.vteprdVolume;
   }

   public void setVteprdVolume(float var1) {
      this.vteprdVolume = var1;
   }

   public String getVteprdImmaTc1() {
      return this.vteprdImmaTc1;
   }

   public void setVteprdImmaTc1(String var1) {
      this.vteprdImmaTc1 = var1;
   }

   public String getVteprdImmaTc2() {
      return this.vteprdImmaTc2;
   }

   public void setVteprdImmaTc2(String var1) {
      this.vteprdImmaTc2 = var1;
   }

   public int getVteprdModeFactureDetail() {
      return this.vteprdModeFactureDetail;
   }

   public void setVteprdModeFactureDetail(int var1) {
      this.vteprdModeFactureDetail = var1;
   }

   public int getVteprdModelTc1() {
      return this.vteprdModelTc1;
   }

   public void setVteprdModelTc1(int var1) {
      this.vteprdModelTc1 = var1;
   }

   public int getVteprdModelTc2() {
      return this.vteprdModelTc2;
   }

   public void setVteprdModelTc2(int var1) {
      this.vteprdModelTc2 = var1;
   }

   public String getVteprdPlombTc1() {
      return this.vteprdPlombTc1;
   }

   public void setVteprdPlombTc1(String var1) {
      this.vteprdPlombTc1 = var1;
   }

   public String getVteprdPlombTc2() {
      return this.vteprdPlombTc2;
   }

   public void setVteprdPlombTc2(String var1) {
      this.vteprdPlombTc2 = var1;
   }
}
