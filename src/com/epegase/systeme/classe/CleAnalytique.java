package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CleAnalytique implements Serializable {
   private long cleanaId;
   private Date cleanaDate;
   private String cleanaCode;
   private String cleanaLibelle;
   private float cleanaTaux;
   private double cleanaValeur;
   private int cleanaNature;
   private long cleanaIdDocument;
   private String cleanaNumDocument;

   public String getCleanaCode() {
      return this.cleanaCode;
   }

   public void setCleanaCode(String var1) {
      this.cleanaCode = var1;
   }

   public long getCleanaId() {
      return this.cleanaId;
   }

   public void setCleanaId(long var1) {
      this.cleanaId = var1;
   }

   public long getCleanaIdDocument() {
      return this.cleanaIdDocument;
   }

   public void setCleanaIdDocument(long var1) {
      this.cleanaIdDocument = var1;
   }

   public String getCleanaLibelle() {
      return this.cleanaLibelle;
   }

   public void setCleanaLibelle(String var1) {
      this.cleanaLibelle = var1;
   }

   public int getCleanaNature() {
      return this.cleanaNature;
   }

   public void setCleanaNature(int var1) {
      this.cleanaNature = var1;
   }

   public float getCleanaTaux() {
      return this.cleanaTaux;
   }

   public void setCleanaTaux(float var1) {
      this.cleanaTaux = var1;
   }

   public String getCleanaNumDocument() {
      return this.cleanaNumDocument;
   }

   public void setCleanaNumDocument(String var1) {
      this.cleanaNumDocument = var1;
   }

   public Date getCleanaDate() {
      return this.cleanaDate;
   }

   public void setCleanaDate(Date var1) {
      this.cleanaDate = var1;
   }

   public double getCleanaValeur() {
      return this.cleanaValeur;
   }

   public void setCleanaValeur(double var1) {
      this.cleanaValeur = var1;
   }
}
