package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PathologieMedical implements Serializable {
   private long phlId;
   private long phlUserCreation;
   private long phlUserModif;
   private Date phlDateCreation;
   private Date phlDateModif;
   private String phlCode;
   private String phlLibelle;
   private int phlInactif;
   private ExercicesVentes exerciceventes;
   private String etat;
   private boolean inactif;

   public String getEtat() {
      if (this.phlInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.phlInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.phlInactif != 1 && this.phlInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public String getPhlCode() {
      if (this.phlCode != null && !this.phlCode.isEmpty()) {
         this.phlCode = this.phlCode.toUpperCase();
      }

      return this.phlCode;
   }

   public void setPhlCode(String var1) {
      this.phlCode = var1;
   }

   public Date getPhlDateCreation() {
      return this.phlDateCreation;
   }

   public void setPhlDateCreation(Date var1) {
      this.phlDateCreation = var1;
   }

   public Date getPhlDateModif() {
      return this.phlDateModif;
   }

   public void setPhlDateModif(Date var1) {
      this.phlDateModif = var1;
   }

   public long getPhlId() {
      return this.phlId;
   }

   public void setPhlId(long var1) {
      this.phlId = var1;
   }

   public int getPhlInactif() {
      return this.phlInactif;
   }

   public void setPhlInactif(int var1) {
      this.phlInactif = var1;
   }

   public String getPhlLibelle() {
      if (this.phlLibelle != null && !this.phlLibelle.isEmpty()) {
         this.phlLibelle = this.phlLibelle.toUpperCase();
      }

      return this.phlLibelle;
   }

   public void setPhlLibelle(String var1) {
      this.phlLibelle = var1;
   }

   public long getPhlUserCreation() {
      return this.phlUserCreation;
   }

   public void setPhlUserCreation(long var1) {
      this.phlUserCreation = var1;
   }

   public long getPhlUserModif() {
      return this.phlUserModif;
   }

   public void setPhlUserModif(long var1) {
      this.phlUserModif = var1;
   }
}
