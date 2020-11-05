package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PegEvolution implements Serializable {
   private long pegevoId;
   private int pegevoMode;
   private int pegevoType;
   private String pegevoVersion;
   private Date pegevoDate;
   private String pegevoModule;
   private String pegevoEcran;
   private String pegevoModele;
   private String pegevoObject;
   private String pegevoDetail;
   private String pegevoNomDeveloppeur;
   private String libelleType;

   public String getLibelleType() {
      if (this.pegevoType == 0) {
         this.libelleType = "Nouvelle fonction";
      } else if (this.pegevoType == 1) {
         this.libelleType = "Modification fonction";
      } else if (this.pegevoType == 2) {
         this.libelleType = "Correction fonction";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public Date getPegevoDate() {
      return this.pegevoDate;
   }

   public void setPegevoDate(Date var1) {
      this.pegevoDate = var1;
   }

   public String getPegevoDetail() {
      return this.pegevoDetail;
   }

   public void setPegevoDetail(String var1) {
      this.pegevoDetail = var1;
   }

   public String getPegevoEcran() {
      return this.pegevoEcran;
   }

   public void setPegevoEcran(String var1) {
      this.pegevoEcran = var1;
   }

   public long getPegevoId() {
      return this.pegevoId;
   }

   public void setPegevoId(long var1) {
      this.pegevoId = var1;
   }

   public int getPegevoMode() {
      return this.pegevoMode;
   }

   public void setPegevoMode(int var1) {
      this.pegevoMode = var1;
   }

   public String getPegevoModele() {
      return this.pegevoModele;
   }

   public void setPegevoModele(String var1) {
      this.pegevoModele = var1;
   }

   public String getPegevoModule() {
      return this.pegevoModule;
   }

   public void setPegevoModule(String var1) {
      this.pegevoModule = var1;
   }

   public String getPegevoNomDeveloppeur() {
      return this.pegevoNomDeveloppeur;
   }

   public void setPegevoNomDeveloppeur(String var1) {
      this.pegevoNomDeveloppeur = var1;
   }

   public String getPegevoObject() {
      return this.pegevoObject;
   }

   public void setPegevoObject(String var1) {
      this.pegevoObject = var1;
   }

   public int getPegevoType() {
      return this.pegevoType;
   }

   public void setPegevoType(int var1) {
      this.pegevoType = var1;
   }

   public String getPegevoVersion() {
      return this.pegevoVersion;
   }

   public void setPegevoVersion(String var1) {
      this.pegevoVersion = var1;
   }
}
