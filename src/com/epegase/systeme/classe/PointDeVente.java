package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PointDeVente implements Serializable {
   private long pdvId;
   private Date pdvDateCreat;
   private Date pdvDateModif;
   private long pdvUserCreat;
   private long pdvUserModif;
   private String pdvCode;
   private String pdvNomFr;
   private String pdvNomUk;
   private String pdvNomSp;
   private int pdvInactif;
   private float pdvPourcentage;
   private long pdvIdResponsable;
   private String pdvNomResponsable;
   private Region region;
   private Secteur secteur;
   private boolean afficheImag;
   private String etat;

   public int getPdvInactif() {
      return this.pdvInactif;
   }

   public void setPdvInactif(int var1) {
      this.pdvInactif = var1;
   }

   public String getEtat() {
      if (this.pdvInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.pdvInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.pdvInactif != 1 && this.pdvInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getPdvCode() {
      if (this.pdvCode != null && !this.pdvCode.isEmpty()) {
         this.pdvCode = this.pdvCode.toUpperCase();
      }

      return this.pdvCode;
   }

   public void setPdvCode(String var1) {
      this.pdvCode = var1;
   }

   public Date getPdvDateCreat() {
      return this.pdvDateCreat;
   }

   public void setPdvDateCreat(Date var1) {
      this.pdvDateCreat = var1;
   }

   public Date getPdvDateModif() {
      return this.pdvDateModif;
   }

   public void setPdvDateModif(Date var1) {
      this.pdvDateModif = var1;
   }

   public long getPdvId() {
      return this.pdvId;
   }

   public void setPdvId(long var1) {
      this.pdvId = var1;
   }

   public String getPdvNomFr() {
      if (this.pdvNomFr != null && !this.pdvNomFr.isEmpty()) {
         this.pdvNomFr = this.pdvNomFr.toUpperCase();
      }

      return this.pdvNomFr;
   }

   public void setPdvNomFr(String var1) {
      this.pdvNomFr = var1;
   }

   public String getPdvNomSp() {
      return this.pdvNomSp;
   }

   public void setPdvNomSp(String var1) {
      this.pdvNomSp = var1;
   }

   public String getPdvNomUk() {
      return this.pdvNomUk;
   }

   public void setPdvNomUk(String var1) {
      this.pdvNomUk = var1;
   }

   public long getPdvUserCreat() {
      return this.pdvUserCreat;
   }

   public void setPdvUserCreat(long var1) {
      this.pdvUserCreat = var1;
   }

   public long getPdvUserModif() {
      return this.pdvUserModif;
   }

   public void setPdvUserModif(long var1) {
      this.pdvUserModif = var1;
   }

   public Secteur getSecteur() {
      return this.secteur;
   }

   public void setSecteur(Secteur var1) {
      this.secteur = var1;
   }

   public float getPdvPourcentage() {
      return this.pdvPourcentage;
   }

   public void setPdvPourcentage(float var1) {
      this.pdvPourcentage = var1;
   }

   public Region getRegion() {
      return this.region;
   }

   public void setRegion(Region var1) {
      this.region = var1;
   }

   public long getPdvIdResponsable() {
      return this.pdvIdResponsable;
   }

   public void setPdvIdResponsable(long var1) {
      this.pdvIdResponsable = var1;
   }

   public String getPdvNomResponsable() {
      return this.pdvNomResponsable;
   }

   public void setPdvNomResponsable(String var1) {
      this.pdvNomResponsable = var1;
   }
}
