package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ExercicesParc implements Serializable {
   private long exeprcId;
   private Date exeprcDateCreat;
   private Date exeprcDateModif;
   private Date exeprcDateCloture;
   private long exeprcUserCreat;
   private long exeprcUserCloture;
   private long exeprcUserModif;
   private Date exeprcDateDebut;
   private Date exeprcDateFin;
   private int exeprcEtat;
   private int indice;
   private String etat;

   public ExercicesParc() {
   }

   public ExercicesParc(long var1, Date var3, Date var4, Date var5, long var6, long var8, long var10, Date var12, Date var13, int var14, int var15) {
      this.exeprcId = var1;
      this.exeprcDateCreat = var3;
      this.exeprcDateModif = var4;
      this.exeprcDateCloture = var5;
      this.exeprcUserCreat = var6;
      this.exeprcUserCloture = var8;
      this.exeprcUserModif = var10;
      this.exeprcDateDebut = var12;
      this.exeprcDateFin = var13;
      this.exeprcEtat = var14;
      this.indice = var15;
   }

   public String getEtat() {
      if (this.exeprcEtat == 0) {
         this.etat = "Ouvert";
      } else {
         this.etat = "Cloturé";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public Date getExeprcDateCloture() {
      return this.exeprcDateCloture;
   }

   public void setExeprcDateCloture(Date var1) {
      this.exeprcDateCloture = var1;
   }

   public Date getExeprcDateCreat() {
      return this.exeprcDateCreat;
   }

   public void setExeprcDateCreat(Date var1) {
      this.exeprcDateCreat = var1;
   }

   public Date getExeprcDateDebut() {
      return this.exeprcDateDebut;
   }

   public void setExeprcDateDebut(Date var1) {
      this.exeprcDateDebut = var1;
   }

   public Date getExeprcDateFin() {
      return this.exeprcDateFin;
   }

   public void setExeprcDateFin(Date var1) {
      this.exeprcDateFin = var1;
   }

   public Date getExeprcDateModif() {
      return this.exeprcDateModif;
   }

   public void setExeprcDateModif(Date var1) {
      this.exeprcDateModif = var1;
   }

   public int getExeprcEtat() {
      return this.exeprcEtat;
   }

   public void setExeprcEtat(int var1) {
      this.exeprcEtat = var1;
   }

   public long getExeprcId() {
      return this.exeprcId;
   }

   public void setExeprcId(long var1) {
      this.exeprcId = var1;
   }

   public long getExeprcUserCloture() {
      return this.exeprcUserCloture;
   }

   public void setExeprcUserCloture(long var1) {
      this.exeprcUserCloture = var1;
   }

   public long getExeprcUserCreat() {
      return this.exeprcUserCreat;
   }

   public void setExeprcUserCreat(long var1) {
      this.exeprcUserCreat = var1;
   }

   public long getExeprcUserModif() {
      return this.exeprcUserModif;
   }

   public void setExeprcUserModif(long var1) {
      this.exeprcUserModif = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }
}
