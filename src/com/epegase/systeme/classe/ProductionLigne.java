package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProductionLigne implements Serializable {
   private long ligId;
   private Date ligDateCreat;
   private Date ligDateModif;
   private long ligUserCreat;
   private long ligUserModif;
   private String ligCode;
   private String ligNomFr;
   private String ligNomUk;
   private String ligNomSp;
   private int ligInactif;
   private float ligPourcentage;
   private Site site;
   private boolean afficheImag;
   private String etat;

   public String getEtat() {
      if (this.ligInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.ligInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.ligInactif != 1 && this.ligInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getLigCode() {
      if (this.ligCode != null && !this.ligCode.isEmpty()) {
         this.ligCode = this.ligCode.toUpperCase();
      }

      return this.ligCode;
   }

   public void setLigCode(String var1) {
      this.ligCode = var1;
   }

   public Date getLigDateCreat() {
      return this.ligDateCreat;
   }

   public void setLigDateCreat(Date var1) {
      this.ligDateCreat = var1;
   }

   public Date getLigDateModif() {
      return this.ligDateModif;
   }

   public void setLigDateModif(Date var1) {
      this.ligDateModif = var1;
   }

   public long getLigId() {
      return this.ligId;
   }

   public void setLigId(long var1) {
      this.ligId = var1;
   }

   public int getLigInactif() {
      return this.ligInactif;
   }

   public void setLigInactif(int var1) {
      this.ligInactif = var1;
   }

   public String getLigNomFr() {
      if (this.ligNomFr != null && !this.ligNomFr.isEmpty()) {
         this.ligNomFr = this.ligNomFr.toUpperCase();
      }

      return this.ligNomFr;
   }

   public void setLigNomFr(String var1) {
      this.ligNomFr = var1;
   }

   public String getLigNomSp() {
      return this.ligNomSp;
   }

   public void setLigNomSp(String var1) {
      this.ligNomSp = var1;
   }

   public String getLigNomUk() {
      return this.ligNomUk;
   }

   public void setLigNomUk(String var1) {
      this.ligNomUk = var1;
   }

   public float getLigPourcentage() {
      return this.ligPourcentage;
   }

   public void setLigPourcentage(float var1) {
      this.ligPourcentage = var1;
   }

   public long getLigUserCreat() {
      return this.ligUserCreat;
   }

   public void setLigUserCreat(long var1) {
      this.ligUserCreat = var1;
   }

   public long getLigUserModif() {
      return this.ligUserModif;
   }

   public void setLigUserModif(long var1) {
      this.ligUserModif = var1;
   }

   public Site getSite() {
      return this.site;
   }

   public void setSite(Site var1) {
      this.site = var1;
   }
}
