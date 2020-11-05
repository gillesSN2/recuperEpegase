package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ExercicesAchats implements Serializable {
   private long exeachId;
   private Date exeachDateCreat;
   private Date exeachDateModif;
   private Date exeachDateCloture;
   private long exeachUserCreat;
   private long exeachUserCloture;
   private long exeachUserModif;
   private Date exeachDateDebut;
   private Date exeachDateFin;
   private int exeachEtat;
   private int indice;
   private String etat;

   public String getEtat() {
      if (this.exeachEtat == 0) {
         this.etat = "Ouvert";
      } else {
         this.etat = "Cloturé";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public Date getExeachDateCloture() {
      return this.exeachDateCloture;
   }

   public void setExeachDateCloture(Date var1) {
      this.exeachDateCloture = var1;
   }

   public Date getExeachDateCreat() {
      return this.exeachDateCreat;
   }

   public void setExeachDateCreat(Date var1) {
      this.exeachDateCreat = var1;
   }

   public Date getExeachDateDebut() {
      return this.exeachDateDebut;
   }

   public void setExeachDateDebut(Date var1) {
      this.exeachDateDebut = var1;
   }

   public Date getExeachDateFin() {
      return this.exeachDateFin;
   }

   public void setExeachDateFin(Date var1) {
      this.exeachDateFin = var1;
   }

   public Date getExeachDateModif() {
      return this.exeachDateModif;
   }

   public void setExeachDateModif(Date var1) {
      this.exeachDateModif = var1;
   }

   public int getExeachEtat() {
      return this.exeachEtat;
   }

   public void setExeachEtat(int var1) {
      this.exeachEtat = var1;
   }

   public long getExeachId() {
      return this.exeachId;
   }

   public void setExeachId(long var1) {
      this.exeachId = var1;
   }

   public long getExeachUserCloture() {
      return this.exeachUserCloture;
   }

   public void setExeachUserCloture(long var1) {
      this.exeachUserCloture = var1;
   }

   public long getExeachUserCreat() {
      return this.exeachUserCreat;
   }

   public void setExeachUserCreat(long var1) {
      this.exeachUserCreat = var1;
   }

   public long getExeachUserModif() {
      return this.exeachUserModif;
   }

   public void setExeachUserModif(long var1) {
      this.exeachUserModif = var1;
   }
}
