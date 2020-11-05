package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetDevises implements Serializable {
   private String code;
   private String taux1;
   private String taux2;
   private String date;
   private String libelle;
   private String format;
   private String principal;
   private String secondaire;
   private String formatimp;
   private boolean showMadalPrint;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getDate() {
      return this.date;
   }

   public void setDate(String var1) {
      this.date = var1;
   }

   public String getTaux1() {
      return this.taux1;
   }

   public void setTaux1(String var1) {
      this.taux1 = var1;
   }

   public String getTaux2() {
      return this.taux2;
   }

   public void setTaux2(String var1) {
      this.taux2 = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public String getFormat() {
      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public String getPrincipal() {
      return this.principal;
   }

   public void setPrincipal(String var1) {
      this.principal = var1;
   }

   public String getSecondaire() {
      return this.secondaire;
   }

   public void setSecondaire(String var1) {
      this.secondaire = var1;
   }

   public String getFormatimp() {
      return this.formatimp;
   }

   public void setFormatimp(String var1) {
      this.formatimp = var1;
   }

   public boolean isShowMadalPrint() {
      return this.showMadalPrint;
   }

   public void setShowMadalPrint(boolean var1) {
      this.showMadalPrint = var1;
   }
}
