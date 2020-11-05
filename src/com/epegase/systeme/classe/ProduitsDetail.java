package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProduitsDetail implements Serializable {
   private long prodetId;
   private String prodetCode;
   private int prodetOrdre;
   private String prodetLibelle;
   private int prodetType;
   private String prodetUnite;
   private float prodetCoef;
   private String prodetUniteConv;
   private String prodetNorme;
   private String prodetInterpretation;
   private String prodetInterpretationTexte;
   private String prodetCategorie;
   private String prodetFourchette;
   private double prodetFourchetteMin;
   private double prodetFourchetteMax;
   private ProduitsLaboratoire produitsLaboratoire;
   private String var_lib_type;

   public long getProdetId() {
      return this.prodetId;
   }

   public void setProdetId(long var1) {
      this.prodetId = var1;
   }

   public int getProdetOrdre() {
      return this.prodetOrdre;
   }

   public void setProdetOrdre(int var1) {
      this.prodetOrdre = var1;
   }

   public ProduitsLaboratoire getProduitsLaboratoire() {
      return this.produitsLaboratoire;
   }

   public void setProduitsLaboratoire(ProduitsLaboratoire var1) {
      this.produitsLaboratoire = var1;
   }

   public float getProdetCoef() {
      return this.prodetCoef;
   }

   public void setProdetCoef(float var1) {
      this.prodetCoef = var1;
   }

   public String getProdetLibelle() {
      return this.prodetLibelle;
   }

   public void setProdetLibelle(String var1) {
      this.prodetLibelle = var1;
   }

   public String getProdetNorme() {
      return this.prodetNorme;
   }

   public void setProdetNorme(String var1) {
      this.prodetNorme = var1;
   }

   public int getProdetType() {
      return this.prodetType;
   }

   public void setProdetType(int var1) {
      this.prodetType = var1;
   }

   public String getProdetUnite() {
      return this.prodetUnite;
   }

   public void setProdetUnite(String var1) {
      this.prodetUnite = var1;
   }

   public String getProdetUniteConv() {
      return this.prodetUniteConv;
   }

   public void setProdetUniteConv(String var1) {
      this.prodetUniteConv = var1;
   }

   public String getVar_lib_type() {
      if (this.prodetType == 0) {
         this.var_lib_type = "Titre";
      } else if (this.prodetType == 1) {
         this.var_lib_type = "Numérique";
      } else if (this.prodetType == 2) {
         this.var_lib_type = "Date";
      } else if (this.prodetType == 3) {
         this.var_lib_type = "Image";
      } else if (this.prodetType == 4) {
         this.var_lib_type = "Texte long";
      } else if (this.prodetType == 5) {
         this.var_lib_type = "Réponse unique";
      } else if (this.prodetType == 6) {
         this.var_lib_type = "Réponse unique + action";
      } else if (this.prodetType == 7) {
         this.var_lib_type = "Réponse multiple";
      } else if (this.prodetType == 9) {
         this.var_lib_type = "Texte court";
      } else if (this.prodetType == 10) {
         this.var_lib_type = "Texte + Négatif/Positif";
      }

      return this.var_lib_type;
   }

   public void setVar_lib_type(String var1) {
      this.var_lib_type = var1;
   }

   public String getProdetCode() {
      return this.prodetCode;
   }

   public void setProdetCode(String var1) {
      this.prodetCode = var1;
   }

   public String getProdetCategorie() {
      return this.prodetCategorie;
   }

   public void setProdetCategorie(String var1) {
      this.prodetCategorie = var1;
   }

   public String getProdetFourchette() {
      return this.prodetFourchette;
   }

   public void setProdetFourchette(String var1) {
      this.prodetFourchette = var1;
   }

   public double getProdetFourchetteMax() {
      return this.prodetFourchetteMax;
   }

   public void setProdetFourchetteMax(double var1) {
      this.prodetFourchetteMax = var1;
   }

   public double getProdetFourchetteMin() {
      return this.prodetFourchetteMin;
   }

   public void setProdetFourchetteMin(double var1) {
      this.prodetFourchetteMin = var1;
   }

   public String getProdetInterpretation() {
      return this.prodetInterpretation;
   }

   public void setProdetInterpretation(String var1) {
      this.prodetInterpretation = var1;
   }

   public String getProdetInterpretationTexte() {
      return this.prodetInterpretationTexte;
   }

   public void setProdetInterpretationTexte(String var1) {
      this.prodetInterpretationTexte = var1;
   }
}
