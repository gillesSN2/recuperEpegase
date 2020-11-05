package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TransitPortVentes implements Serializable {
   private long traprtId;
   private Date traprtDateCreation;
   private Date traprtDateModif;
   private long traprtUserCreation;
   private long traprtUserModif;
   private String traprtNature;
   private String traprtCode;
   private String traprtLibelleFr;
   private String traprtLibelleUk;
   private String traprtLibelleSp;
   private double traprtKms;
   private int traprtInactif;
   private String etat;
   private boolean afficheImag;
   private String libelleNature;

   public String getLibelleNature() {
      if (this.traprtNature != null && !this.traprtNature.isEmpty()) {
         if (this.traprtNature.equals("1")) {
            this.libelleNature = "Maritime";
         } else if (this.traprtNature.equals("2")) {
            this.libelleNature = "Fluvial";
         } else if (this.traprtNature.equals("3")) {
            this.libelleNature = "Aérien";
         } else if (this.traprtNature.equals("4")) {
            this.libelleNature = "Routier";
         } else if (this.traprtNature.equals("5")) {
            this.libelleNature = "Ferrovier";
         } else if (this.traprtNature.equals("6")) {
            this.libelleNature = "Agence";
         } else {
            this.libelleNature = "";
         }
      } else {
         this.libelleNature = "";
      }

      return this.libelleNature;
   }

   public void setLibelleNature(String var1) {
      this.libelleNature = var1;
   }

   public String getEtat() {
      if (this.traprtInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.traprtInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.traprtInactif != 1 && this.traprtInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public int gettraprtInactif() {
      return this.traprtInactif;
   }

   public void settraprtInactif(int var1) {
      this.traprtInactif = var1;
   }

   public String getTraprtCode() {
      return this.traprtCode;
   }

   public void setTraprtCode(String var1) {
      this.traprtCode = var1;
   }

   public Date getTraprtDateCreation() {
      return this.traprtDateCreation;
   }

   public void setTraprtDateCreation(Date var1) {
      this.traprtDateCreation = var1;
   }

   public Date getTraprtDateModif() {
      return this.traprtDateModif;
   }

   public void setTraprtDateModif(Date var1) {
      this.traprtDateModif = var1;
   }

   public long getTraprtId() {
      return this.traprtId;
   }

   public void setTraprtId(long var1) {
      this.traprtId = var1;
   }

   public int getTraprtInactif() {
      return this.traprtInactif;
   }

   public void setTraprtInactif(int var1) {
      this.traprtInactif = var1;
   }

   public String getTraprtLibelleFr() {
      return this.traprtLibelleFr;
   }

   public void setTraprtLibelleFr(String var1) {
      this.traprtLibelleFr = var1;
   }

   public String getTraprtLibelleSp() {
      return this.traprtLibelleSp;
   }

   public void setTraprtLibelleSp(String var1) {
      this.traprtLibelleSp = var1;
   }

   public String getTraprtLibelleUk() {
      return this.traprtLibelleUk;
   }

   public void setTraprtLibelleUk(String var1) {
      this.traprtLibelleUk = var1;
   }

   public long getTraprtUserCreation() {
      return this.traprtUserCreation;
   }

   public void setTraprtUserCreation(long var1) {
      this.traprtUserCreation = var1;
   }

   public long getTraprtUserModif() {
      return this.traprtUserModif;
   }

   public void setTraprtUserModif(long var1) {
      this.traprtUserModif = var1;
   }

   public String getTraprtNature() {
      return this.traprtNature;
   }

   public void setTraprtNature(String var1) {
      this.traprtNature = var1;
   }

   public double getTraprtKms() {
      return this.traprtKms;
   }

   public void setTraprtKms(double var1) {
      this.traprtKms = var1;
   }
}
