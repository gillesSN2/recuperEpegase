package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TransitLieuVentes implements Serializable {
   private long tralieId;
   private Date tralieDateCreation;
   private Date tralieDateModif;
   private long tralieUserCreation;
   private long tralieUserModif;
   private String tralieCode;
   private String tralieLibelleFr;
   private String tralieLibelleUk;
   private String tralieLibelleSp;
   private String traliePort;
   private int tralieInactif;
   private String etat;
   private boolean afficheImag;

   public String getEtat() {
      if (this.tralieInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.tralieInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.tralieInactif != 1 && this.tralieInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public int gettralieInactif() {
      return this.tralieInactif;
   }

   public void settralieInactif(int var1) {
      this.tralieInactif = var1;
   }

   public String getTralieCode() {
      return this.tralieCode;
   }

   public void setTralieCode(String var1) {
      this.tralieCode = var1;
   }

   public Date getTralieDateCreation() {
      return this.tralieDateCreation;
   }

   public void setTralieDateCreation(Date var1) {
      this.tralieDateCreation = var1;
   }

   public Date getTralieDateModif() {
      return this.tralieDateModif;
   }

   public void setTralieDateModif(Date var1) {
      this.tralieDateModif = var1;
   }

   public long getTralieId() {
      return this.tralieId;
   }

   public void setTralieId(long var1) {
      this.tralieId = var1;
   }

   public int getTralieInactif() {
      return this.tralieInactif;
   }

   public void setTralieInactif(int var1) {
      this.tralieInactif = var1;
   }

   public String getTralieLibelleFr() {
      return this.tralieLibelleFr;
   }

   public void setTralieLibelleFr(String var1) {
      this.tralieLibelleFr = var1;
   }

   public String getTralieLibelleSp() {
      return this.tralieLibelleSp;
   }

   public void setTralieLibelleSp(String var1) {
      this.tralieLibelleSp = var1;
   }

   public String getTralieLibelleUk() {
      return this.tralieLibelleUk;
   }

   public void setTralieLibelleUk(String var1) {
      this.tralieLibelleUk = var1;
   }

   public long getTralieUserCreation() {
      return this.tralieUserCreation;
   }

   public void setTralieUserCreation(long var1) {
      this.tralieUserCreation = var1;
   }

   public long getTralieUserModif() {
      return this.tralieUserModif;
   }

   public void setTralieUserModif(long var1) {
      this.tralieUserModif = var1;
   }

   public String getTraliePort() {
      return this.traliePort;
   }

   public void setTraliePort(String var1) {
      this.traliePort = var1;
   }
}
