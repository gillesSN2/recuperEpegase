package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetCategories implements Serializable {
   private String libelle_FR;
   private String libelle_UK;
   private String libelle_SP;
   private String cat_FR;
   private String cat_UK;
   private String cat_SP;
   private String code;
   private String type;
   private float coef;

   public String getCat_FR() {
      return this.cat_FR;
   }

   public void setCat_FR(String var1) {
      this.cat_FR = var1;
   }

   public String getCat_SP() {
      return this.cat_SP;
   }

   public void setCat_SP(String var1) {
      this.cat_SP = var1;
   }

   public String getCat_UK() {
      return this.cat_UK;
   }

   public void setCat_UK(String var1) {
      this.cat_UK = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getLibelle_FR() {
      return this.libelle_FR;
   }

   public void setLibelle_FR(String var1) {
      this.libelle_FR = var1;
   }

   public String getLibelle_SP() {
      return this.libelle_SP;
   }

   public void setLibelle_SP(String var1) {
      this.libelle_SP = var1;
   }

   public String getLibelle_UK() {
      return this.libelle_UK;
   }

   public void setLibelle_UK(String var1) {
      this.libelle_UK = var1;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public float getCoef() {
      return this.coef;
   }

   public void setCoef(float var1) {
      this.coef = var1;
   }
}
