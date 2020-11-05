package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Region implements Serializable {
   private long regId;
   private Date regDateCreat;
   private Date regDateModif;
   private long regUserCreat;
   private long regUserModif;
   private String regCode;
   private String regNomFr;
   private String regNomUk;
   private String regNomSp;
   private int regInactif;
   private long regIdResponsable;
   private String regNomResponsable;
   private boolean afficheImag;
   private String etat;

   public int getRegInactif() {
      return this.regInactif;
   }

   public void setRegInactif(int var1) {
      this.regInactif = var1;
   }

   public String getEtat() {
      if (this.regInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.regInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.regInactif != 1 && this.regInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getRegCode() {
      if (this.regCode != null && !this.regCode.isEmpty()) {
         this.regCode = this.regCode.toUpperCase();
      }

      return this.regCode;
   }

   public void setRegCode(String var1) {
      this.regCode = var1;
   }

   public Date getRegDateCreat() {
      return this.regDateCreat;
   }

   public void setRegDateCreat(Date var1) {
      this.regDateCreat = var1;
   }

   public Date getRegDateModif() {
      return this.regDateModif;
   }

   public void setRegDateModif(Date var1) {
      this.regDateModif = var1;
   }

   public long getRegId() {
      return this.regId;
   }

   public void setRegId(long var1) {
      this.regId = var1;
   }

   public String getRegNomFr() {
      if (this.regNomFr != null && !this.regNomFr.isEmpty()) {
         this.regNomFr = this.regNomFr.toUpperCase();
      }

      return this.regNomFr;
   }

   public void setRegNomFr(String var1) {
      this.regNomFr = var1;
   }

   public String getRegNomSp() {
      return this.regNomSp;
   }

   public void setRegNomSp(String var1) {
      this.regNomSp = var1;
   }

   public String getRegNomUk() {
      return this.regNomUk;
   }

   public void setRegNomUk(String var1) {
      this.regNomUk = var1;
   }

   public long getRegUserCreat() {
      return this.regUserCreat;
   }

   public void setRegUserCreat(long var1) {
      this.regUserCreat = var1;
   }

   public long getRegUserModif() {
      return this.regUserModif;
   }

   public void setRegUserModif(long var1) {
      this.regUserModif = var1;
   }

   public long getRegIdResponsable() {
      return this.regIdResponsable;
   }

   public void setRegIdResponsable(long var1) {
      this.regIdResponsable = var1;
   }

   public String getRegNomResponsable() {
      return this.regNomResponsable;
   }

   public void setRegNomResponsable(String var1) {
      this.regNomResponsable = var1;
   }
}
