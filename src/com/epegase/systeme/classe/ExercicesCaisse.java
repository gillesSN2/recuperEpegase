package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ExercicesCaisse implements Serializable {
   private long execaiId;
   private Date execaiDateCreat;
   private Date execaiDateModif;
   private Date execaiDateCloture;
   private long execaiUserCreat;
   private long execaiUserCloture;
   private long execaiUserModif;
   private Date execaiDateDebut;
   private Date execaiDateFin;
   private int execaiEtat;
   private int indice;
   private String etat;

   public String getEtat() {
      if (this.execaiEtat == 0) {
         this.etat = "Ouvert";
      } else {
         this.etat = "Cloturé";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public Date getExecaiDateCloture() {
      return this.execaiDateCloture;
   }

   public void setExecaiDateCloture(Date var1) {
      this.execaiDateCloture = var1;
   }

   public Date getExecaiDateCreat() {
      return this.execaiDateCreat;
   }

   public void setExecaiDateCreat(Date var1) {
      this.execaiDateCreat = var1;
   }

   public Date getExecaiDateDebut() {
      return this.execaiDateDebut;
   }

   public void setExecaiDateDebut(Date var1) {
      this.execaiDateDebut = var1;
   }

   public Date getExecaiDateFin() {
      return this.execaiDateFin;
   }

   public void setExecaiDateFin(Date var1) {
      this.execaiDateFin = var1;
   }

   public Date getExecaiDateModif() {
      return this.execaiDateModif;
   }

   public void setExecaiDateModif(Date var1) {
      this.execaiDateModif = var1;
   }

   public int getExecaiEtat() {
      return this.execaiEtat;
   }

   public void setExecaiEtat(int var1) {
      this.execaiEtat = var1;
   }

   public long getExecaiId() {
      return this.execaiId;
   }

   public void setExecaiId(long var1) {
      this.execaiId = var1;
   }

   public long getExecaiUserCloture() {
      return this.execaiUserCloture;
   }

   public void setExecaiUserCloture(long var1) {
      this.execaiUserCloture = var1;
   }

   public long getExecaiUserCreat() {
      return this.execaiUserCreat;
   }

   public void setExecaiUserCreat(long var1) {
      this.execaiUserCreat = var1;
   }

   public long getExecaiUserModif() {
      return this.execaiUserModif;
   }

   public void setExecaiUserModif(long var1) {
      this.execaiUserModif = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }
}
