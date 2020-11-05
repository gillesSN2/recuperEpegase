package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FormulesAchats implements Serializable {
   private long forachId;
   private Date forachDateCreation;
   private Date forachDateModif;
   private long forachUserCreation;
   private long forachUserModif;
   private String forachLibelleFr;
   private String forachLibelleUk;
   private String forachLibelleSp;
   private String forachDetailFr;
   private String forachDetailUk;
   private String forachDetailSp;
   private int forachInactif;
   private ExercicesAchats exercicesAchats;
   private String etat;
   private boolean afficheImag;

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public Date getForachDateCreation() {
      return this.forachDateCreation;
   }

   public void setForachDateCreation(Date var1) {
      this.forachDateCreation = var1;
   }

   public Date getForachDateModif() {
      return this.forachDateModif;
   }

   public void setForachDateModif(Date var1) {
      this.forachDateModif = var1;
   }

   public String getForachLibelleFr() {
      return this.forachLibelleFr;
   }

   public void setForachLibelleFr(String var1) {
      this.forachLibelleFr = var1;
   }

   public String getForachLibelleSp() {
      return this.forachLibelleSp;
   }

   public void setForachLibelleSp(String var1) {
      this.forachLibelleSp = var1;
   }

   public String getForachLibelleUk() {
      return this.forachLibelleUk;
   }

   public void setForachLibelleUk(String var1) {
      this.forachLibelleUk = var1;
   }

   public long getForachUserCreation() {
      return this.forachUserCreation;
   }

   public void setForachUserCreation(long var1) {
      this.forachUserCreation = var1;
   }

   public long getForachUserModif() {
      return this.forachUserModif;
   }

   public void setForachUserModif(long var1) {
      this.forachUserModif = var1;
   }

   public long getForachId() {
      return this.forachId;
   }

   public void setForachId(long var1) {
      this.forachId = var1;
   }

   public int getForachInactif() {
      return this.forachInactif;
   }

   public void setForachInactif(int var1) {
      this.forachInactif = var1;
   }

   public String getEtat() {
      if (this.forachInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.forachInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.forachInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.forachInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getForachDetailFr() {
      return this.forachDetailFr;
   }

   public void setForachDetailFr(String var1) {
      this.forachDetailFr = var1;
   }

   public String getForachDetailSp() {
      return this.forachDetailSp;
   }

   public void setForachDetailSp(String var1) {
      this.forachDetailSp = var1;
   }

   public String getForachDetailUk() {
      return this.forachDetailUk;
   }

   public void setForachDetailUk(String var1) {
      this.forachDetailUk = var1;
   }
}
