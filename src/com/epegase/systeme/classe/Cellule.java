package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Cellule implements Serializable {
   private long celId;
   private Date celDateCreat;
   private Date celDateModif;
   private long celUserCreat;
   private long celUserModif;
   private String celCode;
   private String celNomFr;
   private String celNomUk;
   private String celNomSp;
   private int celInactif;
   private float celPourcentage;
   private long celIdResponsable;
   private String celNomResponsable;
   private Region region;
   private Secteur secteur;
   private PointDeVente pointDeVente;
   private Ville ville;
   private Quartier quartier;
   private boolean afficheImag;
   private String etat;

   public boolean isAfficheImag() {
      if (this.celInactif != 1 && this.celInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getEtat() {
      if (this.celInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.celInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public PointDeVente getPointDeVente() {
      return this.pointDeVente;
   }

   public void setPointDeVente(PointDeVente var1) {
      this.pointDeVente = var1;
   }

   public Quartier getQuartier() {
      return this.quartier;
   }

   public void setQuartier(Quartier var1) {
      this.quartier = var1;
   }

   public Region getRegion() {
      return this.region;
   }

   public void setRegion(Region var1) {
      this.region = var1;
   }

   public Secteur getSecteur() {
      return this.secteur;
   }

   public void setSecteur(Secteur var1) {
      this.secteur = var1;
   }

   public Ville getVille() {
      return this.ville;
   }

   public void setVille(Ville var1) {
      this.ville = var1;
   }

   public String getCelCode() {
      return this.celCode;
   }

   public void setCelCode(String var1) {
      this.celCode = var1;
   }

   public Date getCelDateCreat() {
      return this.celDateCreat;
   }

   public void setCelDateCreat(Date var1) {
      this.celDateCreat = var1;
   }

   public Date getCelDateModif() {
      return this.celDateModif;
   }

   public void setCelDateModif(Date var1) {
      this.celDateModif = var1;
   }

   public long getCelId() {
      return this.celId;
   }

   public void setCelId(long var1) {
      this.celId = var1;
   }

   public long getCelIdResponsable() {
      return this.celIdResponsable;
   }

   public void setCelIdResponsable(long var1) {
      this.celIdResponsable = var1;
   }

   public int getCelInactif() {
      return this.celInactif;
   }

   public void setCelInactif(int var1) {
      this.celInactif = var1;
   }

   public String getCelNomFr() {
      return this.celNomFr;
   }

   public void setCelNomFr(String var1) {
      this.celNomFr = var1;
   }

   public String getCelNomResponsable() {
      return this.celNomResponsable;
   }

   public void setCelNomResponsable(String var1) {
      this.celNomResponsable = var1;
   }

   public String getCelNomSp() {
      return this.celNomSp;
   }

   public void setCelNomSp(String var1) {
      this.celNomSp = var1;
   }

   public String getCelNomUk() {
      return this.celNomUk;
   }

   public void setCelNomUk(String var1) {
      this.celNomUk = var1;
   }

   public float getCelPourcentage() {
      return this.celPourcentage;
   }

   public void setCelPourcentage(float var1) {
      this.celPourcentage = var1;
   }

   public long getCelUserCreat() {
      return this.celUserCreat;
   }

   public void setCelUserCreat(long var1) {
      this.celUserCreat = var1;
   }

   public long getCelUserModif() {
      return this.celUserModif;
   }

   public void setCelUserModif(long var1) {
      this.celUserModif = var1;
   }
}
