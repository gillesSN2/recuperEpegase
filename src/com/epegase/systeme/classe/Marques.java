package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Marques implements Serializable {
   private long marId;
   private Date marDateCreation;
   private Date marDateModif;
   private long marUserCreation;
   private long marUserModif;
   private String marLibelleFr;
   private String marLibelleUk;
   private String marLibelleSp;
   private int marInactif;
   private String marPhoto;
   private String marPdf;
   private String etat;
   private boolean afficheImag;

   public String getEtat() {
      if (this.marInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.marInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      this.afficheImag = false;
      if (this.marInactif == 1) {
         this.afficheImag = true;
         this.etat = "/images/desactiver.png";
      } else if (this.marInactif == 2) {
         this.afficheImag = true;
         this.etat = "/images/supprimer.gif";
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public Date getMarDateCreation() {
      return this.marDateCreation;
   }

   public void setMarDateCreation(Date var1) {
      this.marDateCreation = var1;
   }

   public Date getMarDateModif() {
      return this.marDateModif;
   }

   public void setMarDateModif(Date var1) {
      this.marDateModif = var1;
   }

   public long getMarId() {
      return this.marId;
   }

   public void setMarId(long var1) {
      this.marId = var1;
   }

   public int getMarInactif() {
      return this.marInactif;
   }

   public void setMarInactif(int var1) {
      this.marInactif = var1;
   }

   public String getMarLibelleFr() {
      return this.marLibelleFr;
   }

   public void setMarLibelleFr(String var1) {
      this.marLibelleFr = var1;
   }

   public String getMarLibelleSp() {
      return this.marLibelleSp;
   }

   public void setMarLibelleSp(String var1) {
      this.marLibelleSp = var1;
   }

   public String getMarLibelleUk() {
      return this.marLibelleUk;
   }

   public void setMarLibelleUk(String var1) {
      this.marLibelleUk = var1;
   }

   public long getMarUserCreation() {
      return this.marUserCreation;
   }

   public void setMarUserCreation(long var1) {
      this.marUserCreation = var1;
   }

   public long getMarUserModif() {
      return this.marUserModif;
   }

   public void setMarUserModif(long var1) {
      this.marUserModif = var1;
   }

   public String getMarPdf() {
      return this.marPdf;
   }

   public void setMarPdf(String var1) {
      this.marPdf = var1;
   }

   public String getMarPhoto() {
      return this.marPhoto;
   }

   public void setMarPhoto(String var1) {
      this.marPhoto = var1;
   }
}
