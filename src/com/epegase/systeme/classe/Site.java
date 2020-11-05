package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Site implements Serializable {
   private long sitId;
   private Date sitDateCreat;
   private Date sitDateModif;
   private long sitUserCreat;
   private long sitUserModif;
   private String sitCode;
   private String sitNomFr;
   private String sitNomUk;
   private String sitNomSp;
   private int sitInactif;
   private long sitIdResponsable;
   private String sitNomResponsable;
   private long sitIdClient;
   private boolean afficheImag;
   private String etat;

   public String getEtat() {
      if (this.sitInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.sitInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.sitInactif != 1 && this.sitInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getSitCode() {
      if (this.sitCode != null) {
         this.sitCode = this.sitCode.toUpperCase();
      }

      return this.sitCode;
   }

   public void setSitCode(String var1) {
      this.sitCode = var1;
   }

   public Date getSitDateCreat() {
      return this.sitDateCreat;
   }

   public void setSitDateCreat(Date var1) {
      this.sitDateCreat = var1;
   }

   public Date getSitDateModif() {
      return this.sitDateModif;
   }

   public void setSitDateModif(Date var1) {
      this.sitDateModif = var1;
   }

   public long getSitId() {
      return this.sitId;
   }

   public void setSitId(long var1) {
      this.sitId = var1;
   }

   public int getSitInactif() {
      return this.sitInactif;
   }

   public void setSitInactif(int var1) {
      this.sitInactif = var1;
   }

   public String getSitNomFr() {
      if (this.sitNomFr != null && !this.sitNomFr.isEmpty()) {
         this.sitNomFr = this.sitNomFr.toUpperCase();
      }

      return this.sitNomFr;
   }

   public void setSitNomFr(String var1) {
      this.sitNomFr = var1;
   }

   public String getSitNomSp() {
      return this.sitNomSp;
   }

   public void setSitNomSp(String var1) {
      this.sitNomSp = var1;
   }

   public String getSitNomUk() {
      return this.sitNomUk;
   }

   public void setSitNomUk(String var1) {
      this.sitNomUk = var1;
   }

   public long getSitUserCreat() {
      return this.sitUserCreat;
   }

   public void setSitUserCreat(long var1) {
      this.sitUserCreat = var1;
   }

   public long getSitUserModif() {
      return this.sitUserModif;
   }

   public void setSitUserModif(long var1) {
      this.sitUserModif = var1;
   }

   public long getSitIdResponsable() {
      return this.sitIdResponsable;
   }

   public void setSitIdResponsable(long var1) {
      this.sitIdResponsable = var1;
   }

   public String getSitNomResponsable() {
      return this.sitNomResponsable;
   }

   public void setSitNomResponsable(String var1) {
      this.sitNomResponsable = var1;
   }

   public long getSitIdClient() {
      return this.sitIdClient;
   }

   public void setSitIdClient(long var1) {
      this.sitIdClient = var1;
   }
}
