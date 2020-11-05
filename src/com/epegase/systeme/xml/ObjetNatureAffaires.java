package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetNatureAffaires implements Serializable {
   private int indice;
   private String code;
   private String libelle;
   private String analytique;
   private String lib_analytique;

   public String getLib_analytique() {
      if (this.analytique != null && !this.analytique.isEmpty()) {
         if (this.analytique.equals("6")) {
            this.lib_analytique = "Dossier";
         } else if (this.analytique.equals("7")) {
            this.lib_analytique = "Chantier";
         } else if (this.analytique.equals("8")) {
            this.lib_analytique = "Mission/Frais";
         } else if (this.analytique.equals("99")) {
            this.lib_analytique = "Activité";
         }
      } else {
         this.lib_analytique = "";
      }

      return this.lib_analytique;
   }

   public void setLib_analytique(String var1) {
      this.lib_analytique = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public String getAnalytique() {
      return this.analytique;
   }

   public void setAnalytique(String var1) {
      this.analytique = var1;
   }
}
