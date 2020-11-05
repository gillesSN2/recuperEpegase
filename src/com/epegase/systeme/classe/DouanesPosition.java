package com.epegase.systeme.classe;

import java.io.Serializable;

public class DouanesPosition implements Serializable {
   private long douposId;
   private String douposZone;
   private String douposCode;
   private String douposLibFR;
   private String douposLibUK;
   private String douposLibSP;
   private String douposUnite;
   private float douposDd;
   private float douposRs;
   private float douposPcs;
   private float douposDa;
   private float douposAd;
   private float doupos46;
   private float doupos53;
   private float douposTva;
   private float douposCumul;
   private String douposChapitre;
   private String douposCodeChapitre;
   private String douposSection;
   private String douposCodeSection;
   private int douposUtil;
   private boolean libUtil;
   private boolean chapitre;

   public boolean isLibUtil() {
      if (this.douposUtil == 0) {
         this.libUtil = false;
      } else {
         this.libUtil = true;
      }

      return this.libUtil;
   }

   public void setLibUtil(boolean var1) {
      this.libUtil = var1;
   }

   public boolean isChapitre() {
      if (this.douposCode != null && this.douposCode.length() <= 4) {
         this.chapitre = false;
      } else {
         this.chapitre = true;
      }

      return this.chapitre;
   }

   public void setChapitre(boolean var1) {
      this.chapitre = var1;
   }

   public float getDouposAd() {
      return this.douposAd;
   }

   public void setDouposAd(float var1) {
      this.douposAd = var1;
   }

   public String getDouposChapitre() {
      return this.douposChapitre;
   }

   public void setDouposChapitre(String var1) {
      this.douposChapitre = var1;
   }

   public String getDouposCode() {
      return this.douposCode;
   }

   public void setDouposCode(String var1) {
      this.douposCode = var1;
   }

   public float getDouposCumul() {
      return this.douposCumul;
   }

   public void setDouposCumul(float var1) {
      this.douposCumul = var1;
   }

   public float getDouposDa() {
      return this.douposDa;
   }

   public void setDouposDa(float var1) {
      this.douposDa = var1;
   }

   public float getDouposDd() {
      return this.douposDd;
   }

   public void setDouposDd(float var1) {
      this.douposDd = var1;
   }

   public long getDouposId() {
      return this.douposId;
   }

   public void setDouposId(long var1) {
      this.douposId = var1;
   }

   public String getDouposLibFR() {
      return this.douposLibFR;
   }

   public void setDouposLibFR(String var1) {
      this.douposLibFR = var1;
   }

   public String getDouposLibSP() {
      return this.douposLibSP;
   }

   public void setDouposLibSP(String var1) {
      this.douposLibSP = var1;
   }

   public String getDouposLibUK() {
      return this.douposLibUK;
   }

   public void setDouposLibUK(String var1) {
      this.douposLibUK = var1;
   }

   public float getDouposPcs() {
      return this.douposPcs;
   }

   public void setDouposPcs(float var1) {
      this.douposPcs = var1;
   }

   public float getDouposRs() {
      return this.douposRs;
   }

   public void setDouposRs(float var1) {
      this.douposRs = var1;
   }

   public String getDouposSection() {
      return this.douposSection;
   }

   public void setDouposSection(String var1) {
      this.douposSection = var1;
   }

   public float getDouposTva() {
      return this.douposTva;
   }

   public void setDouposTva(float var1) {
      this.douposTva = var1;
   }

   public String getDouposUnite() {
      return this.douposUnite;
   }

   public void setDouposUnite(String var1) {
      this.douposUnite = var1;
   }

   public int getDouposUtil() {
      return this.douposUtil;
   }

   public void setDouposUtil(int var1) {
      this.douposUtil = var1;
   }

   public String getDouposZone() {
      return this.douposZone;
   }

   public void setDouposZone(String var1) {
      this.douposZone = var1;
   }

   public String getDouposCodeChapitre() {
      return this.douposCodeChapitre;
   }

   public void setDouposCodeChapitre(String var1) {
      this.douposCodeChapitre = var1;
   }

   public String getDouposCodeSection() {
      return this.douposCodeSection;
   }

   public void setDouposCodeSection(String var1) {
      this.douposCodeSection = var1;
   }

   public float getDoupos46() {
      return this.doupos46;
   }

   public void setDoupos46(float var1) {
      this.doupos46 = var1;
   }

   public float getDoupos53() {
      return this.doupos53;
   }

   public void setDoupos53(float var1) {
      this.doupos53 = var1;
   }
}
