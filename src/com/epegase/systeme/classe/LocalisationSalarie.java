package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class LocalisationSalarie implements Serializable {
   private long locsalId;
   private Date locsalDateCreat;
   private Date locsalDateModif;
   private long locsalUserCreat;
   private long locsalUserModif;
   private String locsalNomFr;
   private String locsalNomUk;
   private String locsalNomSp;
   private int locsalInactif;
   private long locsalLongitude;
   private long locsalLatitude;
   private boolean afficheImag;
   private String etat;

   public String getEtat() {
      if (this.locsalInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.locsalInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.locsalInactif != 1 && this.locsalInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public Date getLocsalDateCreat() {
      return this.locsalDateCreat;
   }

   public void setLocsalDateCreat(Date var1) {
      this.locsalDateCreat = var1;
   }

   public Date getLocsalDateModif() {
      return this.locsalDateModif;
   }

   public void setLocsalDateModif(Date var1) {
      this.locsalDateModif = var1;
   }

   public long getLocsalId() {
      return this.locsalId;
   }

   public void setLocsalId(long var1) {
      this.locsalId = var1;
   }

   public int getLocsalInactif() {
      return this.locsalInactif;
   }

   public void setLocsalInactif(int var1) {
      this.locsalInactif = var1;
   }

   public long getLocsalLatitude() {
      return this.locsalLatitude;
   }

   public void setLocsalLatitude(long var1) {
      this.locsalLatitude = var1;
   }

   public long getLocsalLongitude() {
      return this.locsalLongitude;
   }

   public void setLocsalLongitude(long var1) {
      this.locsalLongitude = var1;
   }

   public String getLocsalNomFr() {
      return this.locsalNomFr;
   }

   public void setLocsalNomFr(String var1) {
      this.locsalNomFr = var1;
   }

   public String getLocsalNomSp() {
      return this.locsalNomSp;
   }

   public void setLocsalNomSp(String var1) {
      this.locsalNomSp = var1;
   }

   public String getLocsalNomUk() {
      return this.locsalNomUk;
   }

   public void setLocsalNomUk(String var1) {
      this.locsalNomUk = var1;
   }

   public long getLocsalUserCreat() {
      return this.locsalUserCreat;
   }

   public void setLocsalUserCreat(long var1) {
      this.locsalUserCreat = var1;
   }

   public long getLocsalUserModif() {
      return this.locsalUserModif;
   }

   public void setLocsalUserModif(long var1) {
      this.locsalUserModif = var1;
   }
}
