package com.epegase.systeme.classe;

import java.io.Serializable;

public class ComplementInformations implements Serializable {
   private long cplmenid;
   private int cplmenType;
   private String cplmenNom;
   private String cplmenPrenom;
   private String cplmenNation;
   private String cplmenQualite;
   private String cplmenFiscal;
   private String cplmenDesignation;
   private String cplmenAdresse;
   private String cplmenCode;
   private String cplmenLibelle;
   private double cplmenTotal;
   private float cplmenPourcentage;
   private ExercicesComptable exercicesComptable;

   public String getCplmenAdresse() {
      return this.cplmenAdresse;
   }

   public void setCplmenAdresse(String var1) {
      this.cplmenAdresse = var1;
   }

   public String getCplmenCode() {
      return this.cplmenCode;
   }

   public void setCplmenCode(String var1) {
      this.cplmenCode = var1;
   }

   public String getCplmenDesignation() {
      return this.cplmenDesignation;
   }

   public void setCplmenDesignation(String var1) {
      this.cplmenDesignation = var1;
   }

   public String getCplmenFiscal() {
      return this.cplmenFiscal;
   }

   public void setCplmenFiscal(String var1) {
      this.cplmenFiscal = var1;
   }

   public String getCplmenLibelle() {
      return this.cplmenLibelle;
   }

   public void setCplmenLibelle(String var1) {
      this.cplmenLibelle = var1;
   }

   public String getCplmenNation() {
      return this.cplmenNation;
   }

   public void setCplmenNation(String var1) {
      this.cplmenNation = var1;
   }

   public String getCplmenNom() {
      return this.cplmenNom;
   }

   public void setCplmenNom(String var1) {
      this.cplmenNom = var1;
   }

   public float getCplmenPourcentage() {
      return this.cplmenPourcentage;
   }

   public void setCplmenPourcentage(float var1) {
      this.cplmenPourcentage = var1;
   }

   public String getCplmenPrenom() {
      return this.cplmenPrenom;
   }

   public void setCplmenPrenom(String var1) {
      this.cplmenPrenom = var1;
   }

   public String getCplmenQualite() {
      return this.cplmenQualite;
   }

   public void setCplmenQualite(String var1) {
      this.cplmenQualite = var1;
   }

   public double getCplmenTotal() {
      return this.cplmenTotal;
   }

   public void setCplmenTotal(double var1) {
      this.cplmenTotal = var1;
   }

   public int getCplmenType() {
      return this.cplmenType;
   }

   public void setCplmenType(int var1) {
      this.cplmenType = var1;
   }

   public long getCplmenid() {
      return this.cplmenid;
   }

   public void setCplmenid(long var1) {
      this.cplmenid = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }
}
