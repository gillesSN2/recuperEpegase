package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProductionAtelier implements Serializable {
   private long ateId;
   private Date ateDateCreat;
   private Date ateDateModif;
   private long ateUserCreat;
   private long ateUserModif;
   private String ateCode;
   private String ateNomFr;
   private String ateNomUk;
   private String ateNomSp;
   private int ateInactif;
   private float atePourcentage;
   private Site site;
   private ProductionLigne productionLigne;
   private boolean afficheImag;
   private String etat;

   public String getEtat() {
      if (this.ateInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.ateInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.ateInactif != 1 && this.ateInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getAteCode() {
      if (this.ateCode != null && !this.ateCode.isEmpty()) {
         this.ateCode = this.ateCode.toUpperCase();
      }

      return this.ateCode;
   }

   public void setAteCode(String var1) {
      this.ateCode = var1;
   }

   public Date getAteDateCreat() {
      return this.ateDateCreat;
   }

   public void setAteDateCreat(Date var1) {
      this.ateDateCreat = var1;
   }

   public Date getAteDateModif() {
      return this.ateDateModif;
   }

   public void setAteDateModif(Date var1) {
      this.ateDateModif = var1;
   }

   public long getAteId() {
      return this.ateId;
   }

   public void setAteId(long var1) {
      this.ateId = var1;
   }

   public int getAteInactif() {
      return this.ateInactif;
   }

   public void setAteInactif(int var1) {
      this.ateInactif = var1;
   }

   public String getAteNomFr() {
      if (this.ateNomFr != null && !this.ateNomFr.isEmpty()) {
         this.ateNomFr = this.ateNomFr.toUpperCase();
      }

      return this.ateNomFr;
   }

   public void setAteNomFr(String var1) {
      this.ateNomFr = var1;
   }

   public String getAteNomSp() {
      return this.ateNomSp;
   }

   public void setAteNomSp(String var1) {
      this.ateNomSp = var1;
   }

   public String getAteNomUk() {
      return this.ateNomUk;
   }

   public void setAteNomUk(String var1) {
      this.ateNomUk = var1;
   }

   public float getAtePourcentage() {
      return this.atePourcentage;
   }

   public void setAtePourcentage(float var1) {
      this.atePourcentage = var1;
   }

   public long getAteUserCreat() {
      return this.ateUserCreat;
   }

   public void setAteUserCreat(long var1) {
      this.ateUserCreat = var1;
   }

   public long getAteUserModif() {
      return this.ateUserModif;
   }

   public void setAteUserModif(long var1) {
      this.ateUserModif = var1;
   }

   public ProductionLigne getProductionLigne() {
      return this.productionLigne;
   }

   public void setProductionLigne(ProductionLigne var1) {
      this.productionLigne = var1;
   }

   public Site getSite() {
      return this.site;
   }

   public void setSite(Site var1) {
      this.site = var1;
   }
}
