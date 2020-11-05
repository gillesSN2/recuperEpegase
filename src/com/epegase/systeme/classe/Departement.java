package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Departement implements Serializable {
   private long depId;
   private Date depDateCreat;
   private Date depDateModif;
   private long depUserCreat;
   private long depUserModif;
   private String depCode;
   private String depNomFr;
   private String depNomUk;
   private String depNomSp;
   private int depInactif;
   private float depPourcentage;
   private long depIdResponsable;
   private String depNomResponsable;
   private Site site;
   private boolean afficheImag;
   private String etat;

   public int getDepInactif() {
      return this.depInactif;
   }

   public void setDepInactif(int var1) {
      this.depInactif = var1;
   }

   public String getEtat() {
      if (this.depInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.depInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.depInactif != 1 && this.depInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getDepCode() {
      if (this.depCode != null && !this.depCode.isEmpty()) {
         this.depCode = this.depCode.toUpperCase();
      }

      return this.depCode;
   }

   public void setDepCode(String var1) {
      this.depCode = var1;
   }

   public Date getDepDateCreat() {
      return this.depDateCreat;
   }

   public void setDepDateCreat(Date var1) {
      this.depDateCreat = var1;
   }

   public Date getDepDateModif() {
      return this.depDateModif;
   }

   public void setDepDateModif(Date var1) {
      this.depDateModif = var1;
   }

   public long getDepId() {
      return this.depId;
   }

   public void setDepId(long var1) {
      this.depId = var1;
   }

   public String getDepNomFr() {
      if (this.depNomFr != null && !this.depNomFr.isEmpty()) {
         this.depNomFr = this.depNomFr.toUpperCase();
      }

      return this.depNomFr;
   }

   public void setDepNomFr(String var1) {
      this.depNomFr = var1;
   }

   public String getDepNomSp() {
      return this.depNomSp;
   }

   public void setDepNomSp(String var1) {
      this.depNomSp = var1;
   }

   public String getDepNomUk() {
      return this.depNomUk;
   }

   public void setDepNomUk(String var1) {
      this.depNomUk = var1;
   }

   public long getDepUserCreat() {
      return this.depUserCreat;
   }

   public void setDepUserCreat(long var1) {
      this.depUserCreat = var1;
   }

   public long getDepUserModif() {
      return this.depUserModif;
   }

   public void setDepUserModif(long var1) {
      this.depUserModif = var1;
   }

   public Site getSite() {
      return this.site;
   }

   public void setSite(Site var1) {
      this.site = var1;
   }

   public float getDepPourcentage() {
      return this.depPourcentage;
   }

   public void setDepPourcentage(float var1) {
      this.depPourcentage = var1;
   }

   public long getDepIdResponsable() {
      return this.depIdResponsable;
   }

   public void setDepIdResponsable(long var1) {
      this.depIdResponsable = var1;
   }

   public String getDepNomResponsable() {
      return this.depNomResponsable;
   }

   public void setDepNomResponsable(String var1) {
      this.depNomResponsable = var1;
   }
}
