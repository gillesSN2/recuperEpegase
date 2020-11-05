package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetModeleFacture implements Serializable {
   private Integer indice;
   private String code;
   private String libelle;
   private String tva;
   private float qte;
   private double pu;
   private String famille;
   private double abn;
   private boolean select;
   private int mode;
   private String module;
   private String color;

   public String getColor() {
      if (this.mode == 1) {
         this.color = "font-weight: bold";
      } else {
         this.color = "font-weight: normal";
      }

      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public Integer getIndice() {
      return this.indice;
   }

   public void setIndice(Integer var1) {
      this.indice = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public double getPu() {
      return this.pu;
   }

   public void setPu(double var1) {
      this.pu = var1;
   }

   public float getQte() {
      return this.qte;
   }

   public void setQte(float var1) {
      this.qte = var1;
   }

   public String getTva() {
      return this.tva;
   }

   public void setTva(String var1) {
      this.tva = var1;
   }

   public double getAbn() {
      return this.abn;
   }

   public void setAbn(double var1) {
      this.abn = var1;
   }

   public String getFamille() {
      return this.famille;
   }

   public void setFamille(String var1) {
      this.famille = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public int getMode() {
      return this.mode;
   }

   public void setMode(int var1) {
      this.mode = var1;
   }

   public String getModule() {
      return this.module;
   }

   public void setModule(String var1) {
      this.module = var1;
   }
}
