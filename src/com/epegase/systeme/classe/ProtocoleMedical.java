package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProtocoleMedical implements Serializable {
   private long prtId;
   private long prtUserCreation;
   private long prtUserModif;
   private Date prtDateCreation;
   private Date prtDateModif;
   private String prtCode;
   private String prtLibelle;
   private int prtInactif;
   private String prtOrdonance;
   private ExercicesVentes exerciceventes;
   private String etat;
   private boolean inactif;

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public String getEtat() {
      if (this.prtInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.prtInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.prtInactif != 1 && this.prtInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getPrtCode() {
      if (this.prtCode != null && !this.prtCode.isEmpty()) {
         this.prtCode = this.prtCode.toUpperCase();
      }

      return this.prtCode;
   }

   public void setPrtCode(String var1) {
      this.prtCode = var1;
   }

   public Date getPrtDateCreation() {
      return this.prtDateCreation;
   }

   public void setPrtDateCreation(Date var1) {
      this.prtDateCreation = var1;
   }

   public Date getPrtDateModif() {
      return this.prtDateModif;
   }

   public void setPrtDateModif(Date var1) {
      this.prtDateModif = var1;
   }

   public long getPrtId() {
      return this.prtId;
   }

   public void setPrtId(long var1) {
      this.prtId = var1;
   }

   public int getPrtInactif() {
      return this.prtInactif;
   }

   public void setPrtInactif(int var1) {
      this.prtInactif = var1;
   }

   public String getPrtLibelle() {
      if (this.prtLibelle != null && !this.prtLibelle.isEmpty()) {
         this.prtLibelle = this.prtLibelle.toUpperCase();
      }

      return this.prtLibelle;
   }

   public void setPrtLibelle(String var1) {
      this.prtLibelle = var1;
   }

   public long getPrtUserCreation() {
      return this.prtUserCreation;
   }

   public void setPrtUserCreation(long var1) {
      this.prtUserCreation = var1;
   }

   public long getPrtUserModif() {
      return this.prtUserModif;
   }

   public void setPrtUserModif(long var1) {
      this.prtUserModif = var1;
   }

   public String getPrtOrdonance() {
      return this.prtOrdonance;
   }

   public void setPrtOrdonance(String var1) {
      this.prtOrdonance = var1;
   }
}
