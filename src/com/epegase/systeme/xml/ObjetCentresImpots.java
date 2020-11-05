package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetCentresImpots implements Serializable {
   private Integer indice;
   private String code;
   private String lib_FR;
   private String lib_UK;
   private String lib_SP;
   private String inactif;
   private boolean valide;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getInactif() {
      return this.inactif;
   }

   public void setInactif(String var1) {
      this.inactif = var1;
   }

   public Integer getIndice() {
      return this.indice;
   }

   public void setIndice(Integer var1) {
      this.indice = var1;
   }

   public String getLib_FR() {
      return this.lib_FR;
   }

   public void setLib_FR(String var1) {
      this.lib_FR = var1;
   }

   public String getLib_SP() {
      return this.lib_SP;
   }

   public void setLib_SP(String var1) {
      this.lib_SP = var1;
   }

   public String getLib_UK() {
      return this.lib_UK;
   }

   public void setLib_UK(String var1) {
      this.lib_UK = var1;
   }

   public boolean isValide() {
      return this.valide;
   }

   public void setValide(boolean var1) {
      this.valide = var1;
   }
}
