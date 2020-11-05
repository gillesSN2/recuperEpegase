package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Ville implements Serializable {
   private long vilId;
   private Date vilDateCreat;
   private Date vilDateModif;
   private long vilUserCreat;
   private long vilUserModif;
   private String vilCode;
   private String vilNomFr;
   private String vilNomUk;
   private String vilNomSp;
   private int vilInactif;
   private float vilPourcentage;
   private long vilIdResponsable;
   private String vilNomResponsable;
   private Region region;
   private Secteur secteur;
   private PointDeVente pointDeVente;
   private boolean afficheImag;
   private String etat;

   public boolean isAfficheImag() {
      if (this.vilInactif != 1 && this.vilInactif != 2) {
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
      if (this.vilInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.vilInactif == 2) {
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

   public String getVilCode() {
      if (this.vilCode != null && !this.vilCode.isEmpty()) {
         this.vilCode = this.vilCode.toUpperCase();
      }

      return this.vilCode;
   }

   public void setVilCode(String var1) {
      this.vilCode = var1;
   }

   public Date getVilDateCreat() {
      return this.vilDateCreat;
   }

   public void setVilDateCreat(Date var1) {
      this.vilDateCreat = var1;
   }

   public Date getVilDateModif() {
      return this.vilDateModif;
   }

   public void setVilDateModif(Date var1) {
      this.vilDateModif = var1;
   }

   public long getVilId() {
      return this.vilId;
   }

   public void setVilId(long var1) {
      this.vilId = var1;
   }

   public long getVilIdResponsable() {
      return this.vilIdResponsable;
   }

   public void setVilIdResponsable(long var1) {
      this.vilIdResponsable = var1;
   }

   public int getVilInactif() {
      return this.vilInactif;
   }

   public void setVilInactif(int var1) {
      this.vilInactif = var1;
   }

   public String getVilNomFr() {
      return this.vilNomFr;
   }

   public void setVilNomFr(String var1) {
      this.vilNomFr = var1;
   }

   public String getVilNomResponsable() {
      return this.vilNomResponsable;
   }

   public void setVilNomResponsable(String var1) {
      this.vilNomResponsable = var1;
   }

   public String getVilNomSp() {
      return this.vilNomSp;
   }

   public void setVilNomSp(String var1) {
      this.vilNomSp = var1;
   }

   public String getVilNomUk() {
      return this.vilNomUk;
   }

   public void setVilNomUk(String var1) {
      this.vilNomUk = var1;
   }

   public float getVilPourcentage() {
      return this.vilPourcentage;
   }

   public void setVilPourcentage(float var1) {
      this.vilPourcentage = var1;
   }

   public long getVilUserCreat() {
      return this.vilUserCreat;
   }

   public void setVilUserCreat(long var1) {
      this.vilUserCreat = var1;
   }

   public long getVilUserModif() {
      return this.vilUserModif;
   }

   public void setVilUserModif(long var1) {
      this.vilUserModif = var1;
   }
}
