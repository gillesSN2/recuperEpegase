package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class LocalisationImmobilisation implements Serializable {
   private long locimmId;
   private Date locimmDateCreat;
   private Date locimmDateModif;
   private long locimmUserCreat;
   private long locimmUserModif;
   private String locimmNomFr;
   private String locimmNomUk;
   private String locimmNomSp;
   private int locimmInactif;
   private long locimmLongitude;
   private long locimmLatitude;
   private boolean afficheImag;
   private String etat;

   public String getEtat() {
      if (this.locimmInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.locimmInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.locimmInactif != 1 && this.locimmInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public Date getLocimmDateCreat() {
      return this.locimmDateCreat;
   }

   public void setLocimmDateCreat(Date var1) {
      this.locimmDateCreat = var1;
   }

   public Date getLocimmDateModif() {
      return this.locimmDateModif;
   }

   public void setLocimmDateModif(Date var1) {
      this.locimmDateModif = var1;
   }

   public long getLocimmId() {
      return this.locimmId;
   }

   public void setLocimmId(long var1) {
      this.locimmId = var1;
   }

   public int getLocimmInactif() {
      return this.locimmInactif;
   }

   public void setLocimmInactif(int var1) {
      this.locimmInactif = var1;
   }

   public long getLocimmLatitude() {
      return this.locimmLatitude;
   }

   public void setLocimmLatitude(long var1) {
      this.locimmLatitude = var1;
   }

   public long getLocimmLongitude() {
      return this.locimmLongitude;
   }

   public void setLocimmLongitude(long var1) {
      this.locimmLongitude = var1;
   }

   public String getLocimmNomFr() {
      return this.locimmNomFr;
   }

   public void setLocimmNomFr(String var1) {
      this.locimmNomFr = var1;
   }

   public String getLocimmNomSp() {
      return this.locimmNomSp;
   }

   public void setLocimmNomSp(String var1) {
      this.locimmNomSp = var1;
   }

   public String getLocimmNomUk() {
      return this.locimmNomUk;
   }

   public void setLocimmNomUk(String var1) {
      this.locimmNomUk = var1;
   }

   public long getLocimmUserCreat() {
      return this.locimmUserCreat;
   }

   public void setLocimmUserCreat(long var1) {
      this.locimmUserCreat = var1;
   }

   public long getLocimmUserModif() {
      return this.locimmUserModif;
   }

   public void setLocimmUserModif(long var1) {
      this.locimmUserModif = var1;
   }
}
