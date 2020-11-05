package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetFonction implements Serializable {
   private int indice;
   private String code;
   private int etat;
   private String nom_FR;
   private String nom_UK;
   private String nom_SP;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public int getEtat() {
      return this.etat;
   }

   public void setEtat(int var1) {
      this.etat = var1;
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

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }
}
