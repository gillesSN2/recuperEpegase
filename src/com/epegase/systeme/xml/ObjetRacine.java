package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetRacine implements Serializable {
   private String code;
   private String nom_FR;
   private String nom_UK;
   private String nom_SP;
   private String nature;
   private String util;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getNom_FR() {
      return this.nom_FR;
   }

   public void setNom_FR(String var1) {
      this.nom_FR = var1;
   }

   public String getNom_SP() {
      return this.nom_SP;
   }

   public void setNom_SP(String var1) {
      this.nom_SP = var1;
   }

   public String getNom_UK() {
      return this.nom_UK;
   }

   public void setNom_UK(String var1) {
      this.nom_UK = var1;
   }

   public String getNature() {
      return this.nature;
   }

   public void setNature(String var1) {
      this.nature = var1;
   }

   public String getUtil() {
      return this.util;
   }

   public void setUtil(String var1) {
      this.util = var1;
   }
}
