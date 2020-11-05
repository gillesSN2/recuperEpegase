package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Couleur implements Serializable {
   private long couId;
   private Date couDateCreation;
   private Date couDateModif;
   private long couUserCreation;
   private long couUserModif;
   private String couLibelleFr;
   private String couLibelleUk;
   private String couLibelleSp;
   private int couInactif;
   private String etat;
   private boolean afficheImag;

   public String getEtat() {
      if (this.couInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.couInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.couInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.couInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public Date getCouDateCreation() {
      return this.couDateCreation;
   }

   public void setCouDateCreation(Date var1) {
      this.couDateCreation = var1;
   }

   public Date getCouDateModif() {
      return this.couDateModif;
   }

   public void setCouDateModif(Date var1) {
      this.couDateModif = var1;
   }

   public long getCouId() {
      return this.couId;
   }

   public void setCouId(long var1) {
      this.couId = var1;
   }

   public int getCouInactif() {
      return this.couInactif;
   }

   public void setCouInactif(int var1) {
      this.couInactif = var1;
   }

   public String getCouLibelleFr() {
      return this.couLibelleFr;
   }

   public void setCouLibelleFr(String var1) {
      this.couLibelleFr = var1;
   }

   public String getCouLibelleSp() {
      return this.couLibelleSp;
   }

   public void setCouLibelleSp(String var1) {
      this.couLibelleSp = var1;
   }

   public String getCouLibelleUk() {
      return this.couLibelleUk;
   }

   public void setCouLibelleUk(String var1) {
      this.couLibelleUk = var1;
   }

   public long getCouUserCreation() {
      return this.couUserCreation;
   }

   public void setCouUserCreation(long var1) {
      this.couUserCreation = var1;
   }

   public long getCouUserModif() {
      return this.couUserModif;
   }

   public void setCouUserModif(long var1) {
      this.couUserModif = var1;
   }
}
