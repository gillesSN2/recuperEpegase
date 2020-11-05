package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Secteur implements Serializable {
   private long secId;
   private Date secDateCreat;
   private Date secDateModif;
   private long secUserCreat;
   private long secUserModif;
   private String secCode;
   private String secNomFr;
   private String secNomUk;
   private String secNomSp;
   private int secInactif;
   private float secPourcentage;
   private long secIdResponsable;
   private String secNomResponsable;
   private Region region;
   private boolean afficheImag;
   private String etat;

   public int getSecInactif() {
      return this.secInactif;
   }

   public void setSecInactif(int var1) {
      this.secInactif = var1;
   }

   public String getEtat() {
      if (this.secInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.secInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.secInactif != 1 && this.secInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public Region getRegion() {
      return this.region;
   }

   public void setRegion(Region var1) {
      this.region = var1;
   }

   public String getSecCode() {
      if (this.secCode != null && !this.secCode.isEmpty()) {
         this.secCode = this.secCode.toUpperCase();
      }

      return this.secCode;
   }

   public void setSecCode(String var1) {
      this.secCode = var1;
   }

   public Date getSecDateCreat() {
      return this.secDateCreat;
   }

   public void setSecDateCreat(Date var1) {
      this.secDateCreat = var1;
   }

   public Date getSecDateModif() {
      return this.secDateModif;
   }

   public void setSecDateModif(Date var1) {
      this.secDateModif = var1;
   }

   public long getSecId() {
      return this.secId;
   }

   public void setSecId(long var1) {
      this.secId = var1;
   }

   public String getSecNomFr() {
      if (this.secNomFr != null && !this.secNomFr.isEmpty()) {
         this.secNomFr = this.secNomFr.toUpperCase();
      }

      return this.secNomFr;
   }

   public void setSecNomFr(String var1) {
      this.secNomFr = var1;
   }

   public String getSecNomSp() {
      return this.secNomSp;
   }

   public void setSecNomSp(String var1) {
      this.secNomSp = var1;
   }

   public String getSecNomUk() {
      return this.secNomUk;
   }

   public void setSecNomUk(String var1) {
      this.secNomUk = var1;
   }

   public long getSecUserCreat() {
      return this.secUserCreat;
   }

   public void setSecUserCreat(long var1) {
      this.secUserCreat = var1;
   }

   public long getSecUserModif() {
      return this.secUserModif;
   }

   public void setSecUserModif(long var1) {
      this.secUserModif = var1;
   }

   public float getSecPourcentage() {
      return this.secPourcentage;
   }

   public void setSecPourcentage(float var1) {
      this.secPourcentage = var1;
   }

   public long getSecIdResponsable() {
      return this.secIdResponsable;
   }

   public void setSecIdResponsable(long var1) {
      this.secIdResponsable = var1;
   }

   public String getSecNomResponsable() {
      return this.secNomResponsable;
   }

   public void setSecNomResponsable(String var1) {
      this.secNomResponsable = var1;
   }
}
