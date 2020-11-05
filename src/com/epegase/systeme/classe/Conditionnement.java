package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Conditionnement implements Serializable {
   private long cdtId;
   private Date cdtDateCreation;
   private Date cdtDateModif;
   private long cdtUserCreation;
   private long cdtUserModif;
   private String cdtLibelle;
   private String cdtDescription;
   private float cdtCoef1;
   private String cdtUnite1;
   private String cdtCodeUnite1;
   private float cdtCoef2;
   private String cdtUnite2;
   private String cdtCodeUnite2;
   private float cdtLong2;
   private float cdtLarg2;
   private float cdtHaut2;
   private float cdtDiam2;
   private float cdtNb2;
   private String cdtSuite;
   private int cdtInactif;
   private String etat;
   private boolean inactif;

   public String getCdtCodeUnite1() {
      return this.cdtCodeUnite1;
   }

   public void setCdtCodeUnite1(String var1) {
      this.cdtCodeUnite1 = var1;
   }

   public String getCdtCodeUnite2() {
      return this.cdtCodeUnite2;
   }

   public void setCdtCodeUnite2(String var1) {
      this.cdtCodeUnite2 = var1;
   }

   public float getCdtCoef1() {
      return this.cdtCoef1;
   }

   public void setCdtCoef1(float var1) {
      this.cdtCoef1 = var1;
   }

   public float getCdtCoef2() {
      return this.cdtCoef2;
   }

   public void setCdtCoef2(float var1) {
      this.cdtCoef2 = var1;
   }

   public Date getCdtDateCreation() {
      return this.cdtDateCreation;
   }

   public void setCdtDateCreation(Date var1) {
      this.cdtDateCreation = var1;
   }

   public Date getCdtDateModif() {
      return this.cdtDateModif;
   }

   public void setCdtDateModif(Date var1) {
      this.cdtDateModif = var1;
   }

   public long getCdtId() {
      return this.cdtId;
   }

   public void setCdtId(long var1) {
      this.cdtId = var1;
   }

   public int getCdtInactif() {
      return this.cdtInactif;
   }

   public void setCdtInactif(int var1) {
      this.cdtInactif = var1;
   }

   public String getCdtUnite1() {
      return this.cdtUnite1;
   }

   public void setCdtUnite1(String var1) {
      this.cdtUnite1 = var1;
   }

   public String getCdtUnite2() {
      return this.cdtUnite2;
   }

   public void setCdtUnite2(String var1) {
      this.cdtUnite2 = var1;
   }

   public long getCdtUserCreation() {
      return this.cdtUserCreation;
   }

   public void setCdtUserCreation(long var1) {
      this.cdtUserCreation = var1;
   }

   public long getCdtUserModif() {
      return this.cdtUserModif;
   }

   public void setCdtUserModif(long var1) {
      this.cdtUserModif = var1;
   }

   public String getEtat() {
      if (this.cdtInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.cdtInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.cdtInactif != 1 && this.cdtInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getCdtLibelle() {
      if (this.cdtLibelle != null && !this.cdtLibelle.isEmpty()) {
         this.cdtLibelle = this.cdtLibelle.toUpperCase();
      }

      return this.cdtLibelle;
   }

   public void setCdtLibelle(String var1) {
      this.cdtLibelle = var1;
   }

   public float getCdtDiam2() {
      return this.cdtDiam2;
   }

   public void setCdtDiam2(float var1) {
      this.cdtDiam2 = var1;
   }

   public float getCdtHaut2() {
      return this.cdtHaut2;
   }

   public void setCdtHaut2(float var1) {
      this.cdtHaut2 = var1;
   }

   public float getCdtLarg2() {
      return this.cdtLarg2;
   }

   public void setCdtLarg2(float var1) {
      this.cdtLarg2 = var1;
   }

   public float getCdtLong2() {
      return this.cdtLong2;
   }

   public void setCdtLong2(float var1) {
      this.cdtLong2 = var1;
   }

   public float getCdtNb2() {
      return this.cdtNb2;
   }

   public void setCdtNb2(float var1) {
      this.cdtNb2 = var1;
   }

   public String getCdtSuite() {
      return this.cdtSuite;
   }

   public void setCdtSuite(String var1) {
      this.cdtSuite = var1;
   }

   public String getCdtDescription() {
      if (this.cdtDescription != null && !this.cdtDescription.isEmpty()) {
         this.cdtDescription = this.cdtDescription.toUpperCase();
      }

      return this.cdtDescription;
   }

   public void setCdtDescription(String var1) {
      this.cdtDescription = var1;
   }
}
