package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetFamilleTiers implements Serializable {
   private int indice = 0;
   private String libelle = "";
   private String exoTva = "";
   private String exoDouane = "";
   private String serie = "";
   private boolean selectFamille;
   private String libTva;
   private String libDou;

   public String getLibDou() {
      if (!this.exoDouane.equals("false") && !this.exoDouane.equals("0")) {
         if (!this.exoDouane.equals("true") && !this.exoDouane.equals("1")) {
            this.libDou = "TAUX REDUIT";
         } else {
            this.libDou = "EXO DOUANES";
         }
      } else {
         this.libDou = "AVEC DOUANES";
      }

      return this.libDou;
   }

   public void setLibDou(String var1) {
      this.libDou = var1;
   }

   public String getLibTva() {
      if (!this.exoTva.equals("false") && !this.exoTva.equals("0")) {
         if (!this.exoTva.equals("true") && !this.exoTva.equals("1")) {
            this.libTva = "PRECOMPTE";
         } else {
            this.libTva = "EXO TVA";
         }
      } else {
         this.libTva = "AVEC TVA";
      }

      return this.libTva;
   }

   public void setLibTva(String var1) {
      this.libTva = var1;
   }

   public boolean isSelectFamille() {
      return this.selectFamille;
   }

   public void setSelectFamille(boolean var1) {
      this.selectFamille = var1;
   }

   public String getExoDouane() {
      return this.exoDouane;
   }

   public void setExoDouane(String var1) {
      this.exoDouane = var1;
   }

   public String getExoTva() {
      return this.exoTva;
   }

   public void setExoTva(String var1) {
      this.exoTva = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public String getSerie() {
      return this.serie;
   }

   public void setSerie(String var1) {
      this.serie = var1;
   }
}
