package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Metiers implements Serializable {
   private long metId;
   private Date metDateCreat;
   private Date metDateModif;
   private long metUserCreat;
   private long metUserModif;
   private String metNomFr;
   private String metNomUk;
   private String metNomSp;
   private int metInactif;
   private int metType;
   private boolean afficheImag;
   private String etat;
   private boolean select_activite = false;
   private String libType;

   public String getEtat() {
      if (this.metInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.metInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.metInactif != 1 && this.metInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getLibType() {
      if (this.metType == 0) {
         this.libType = "Métier";
      } else {
         this.libType = "Activité";
      }

      return this.libType;
   }

   public void setLibType(String var1) {
      this.libType = var1;
   }

   public Date getMetDateCreat() {
      return this.metDateCreat;
   }

   public void setMetDateCreat(Date var1) {
      this.metDateCreat = var1;
   }

   public Date getMetDateModif() {
      return this.metDateModif;
   }

   public void setMetDateModif(Date var1) {
      this.metDateModif = var1;
   }

   public long getMetId() {
      return this.metId;
   }

   public void setMetId(long var1) {
      this.metId = var1;
   }

   public int getMetInactif() {
      return this.metInactif;
   }

   public void setMetInactif(int var1) {
      this.metInactif = var1;
   }

   public String getMetNomFr() {
      if (this.metNomFr != null && !this.metNomFr.isEmpty()) {
         this.metNomFr = this.metNomFr.toUpperCase();
      }

      return this.metNomFr;
   }

   public void setMetNomFr(String var1) {
      this.metNomFr = var1;
   }

   public String getMetNomSp() {
      return this.metNomSp;
   }

   public void setMetNomSp(String var1) {
      this.metNomSp = var1;
   }

   public String getMetNomUk() {
      return this.metNomUk;
   }

   public void setMetNomUk(String var1) {
      this.metNomUk = var1;
   }

   public long getMetUserCreat() {
      return this.metUserCreat;
   }

   public void setMetUserCreat(long var1) {
      this.metUserCreat = var1;
   }

   public long getMetUserModif() {
      return this.metUserModif;
   }

   public void setMetUserModif(long var1) {
      this.metUserModif = var1;
   }

   public boolean isSelect_activite() {
      return this.select_activite;
   }

   public void setSelect_activite(boolean var1) {
      this.select_activite = var1;
   }

   public int getMetType() {
      return this.metType;
   }

   public void setMetType(int var1) {
      this.metType = var1;
   }
}
