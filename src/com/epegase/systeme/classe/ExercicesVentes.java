package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ExercicesVentes implements Serializable {
   private long exevteId;
   private Date exevteDateCreat;
   private Date exevteDateModif;
   private Date exevteDateCloture;
   private long exevteUserCreat;
   private long exevteUserCloture;
   private long exevteUserModif;
   private Date exevteDateDebut;
   private Date exevteDateFin;
   private int exevteEtat;
   private int indice;
   private String etat;

   public String getEtat() {
      if (this.exevteEtat == 0) {
         this.etat = "Ouvert";
      } else {
         this.etat = "Cloturé";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public Date getExevteDateCloture() {
      return this.exevteDateCloture;
   }

   public void setExevteDateCloture(Date var1) {
      this.exevteDateCloture = var1;
   }

   public Date getExevteDateCreat() {
      return this.exevteDateCreat;
   }

   public void setExevteDateCreat(Date var1) {
      this.exevteDateCreat = var1;
   }

   public Date getExevteDateDebut() {
      return this.exevteDateDebut;
   }

   public void setExevteDateDebut(Date var1) {
      this.exevteDateDebut = var1;
   }

   public Date getExevteDateFin() {
      return this.exevteDateFin;
   }

   public void setExevteDateFin(Date var1) {
      this.exevteDateFin = var1;
   }

   public Date getExevteDateModif() {
      return this.exevteDateModif;
   }

   public void setExevteDateModif(Date var1) {
      this.exevteDateModif = var1;
   }

   public int getExevteEtat() {
      return this.exevteEtat;
   }

   public void setExevteEtat(int var1) {
      this.exevteEtat = var1;
   }

   public long getExevteId() {
      return this.exevteId;
   }

   public void setExevteId(long var1) {
      this.exevteId = var1;
   }

   public long getExevteUserCloture() {
      return this.exevteUserCloture;
   }

   public void setExevteUserCloture(long var1) {
      this.exevteUserCloture = var1;
   }

   public long getExevteUserCreat() {
      return this.exevteUserCreat;
   }

   public void setExevteUserCreat(long var1) {
      this.exevteUserCreat = var1;
   }

   public long getExevteUserModif() {
      return this.exevteUserModif;
   }

   public void setExevteUserModif(long var1) {
      this.exevteUserModif = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }
}
