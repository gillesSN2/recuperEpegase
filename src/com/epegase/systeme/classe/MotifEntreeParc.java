package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class MotifEntreeParc implements Serializable {
   private long mtpId;
   private long mtpUserCreation;
   private long mtpUserModif;
   private Date mtpDateCreation;
   private Date mtpDateModif;
   private String mtpCode;
   private String mtpLibelle;
   private int mtpInactif;
   private String mtpFamille;
   private String mtpType;
   private int mtpCodeType;
   private String etat;
   private boolean inactif;

   public String getEtat() {
      if (this.mtpInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.mtpInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.mtpInactif != 1 && this.mtpInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getMtpCode() {
      return this.mtpCode;
   }

   public void setMtpCode(String var1) {
      this.mtpCode = var1;
   }

   public Date getMtpDateCreation() {
      return this.mtpDateCreation;
   }

   public void setMtpDateCreation(Date var1) {
      this.mtpDateCreation = var1;
   }

   public Date getMtpDateModif() {
      return this.mtpDateModif;
   }

   public void setMtpDateModif(Date var1) {
      this.mtpDateModif = var1;
   }

   public String getMtpFamille() {
      return this.mtpFamille;
   }

   public void setMtpFamille(String var1) {
      this.mtpFamille = var1;
   }

   public long getMtpId() {
      return this.mtpId;
   }

   public void setMtpId(long var1) {
      this.mtpId = var1;
   }

   public int getMtpInactif() {
      return this.mtpInactif;
   }

   public void setMtpInactif(int var1) {
      this.mtpInactif = var1;
   }

   public String getMtpLibelle() {
      return this.mtpLibelle;
   }

   public void setMtpLibelle(String var1) {
      this.mtpLibelle = var1;
   }

   public String getMtpType() {
      return this.mtpType;
   }

   public void setMtpType(String var1) {
      this.mtpType = var1;
   }

   public long getMtpUserCreation() {
      return this.mtpUserCreation;
   }

   public void setMtpUserCreation(long var1) {
      this.mtpUserCreation = var1;
   }

   public long getMtpUserModif() {
      return this.mtpUserModif;
   }

   public void setMtpUserModif(long var1) {
      this.mtpUserModif = var1;
   }

   public int getMtpCodeType() {
      return this.mtpCodeType;
   }

   public void setMtpCodeType(int var1) {
      this.mtpCodeType = var1;
   }
}
