package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetReglement implements Serializable {
   private int indice;
   private String categories;
   private String libelles;
   private String journals;
   private String echeances = "0";
   private String nbjours = "0";
   private String arrondis = "0";
   private String conditions;
   private String libEcheances;
   private String defaut;
   private boolean aff_defaut;

   public boolean isAff_defaut() {
      if (this.defaut != null && !this.defaut.isEmpty()) {
         if (this.defaut.equals("true")) {
            this.aff_defaut = true;
         } else {
            this.aff_defaut = false;
         }
      } else {
         this.aff_defaut = false;
      }

      return this.aff_defaut;
   }

   public void setAff_defaut(boolean var1) {
      this.aff_defaut = var1;
   }

   public String getLibEcheances() {
      if (this.echeances.equals("0")) {
         this.libEcheances = "paiement au comptant";
      }

      if (this.echeances.equals("1")) {
         this.libEcheances = "paiement terme date facture";
      }

      if (this.echeances.equals("2")) {
         this.libEcheances = "paiement terme fin mois";
      }

      return this.libEcheances;
   }

   public void setLibEcheances(String var1) {
      this.libEcheances = var1;
   }

   public String getArrondis() {
      return this.arrondis;
   }

   public void setArrondis(String var1) {
      this.arrondis = var1;
   }

   public String getCategories() {
      return this.categories;
   }

   public void setCategories(String var1) {
      this.categories = var1;
   }

   public String getConditions() {
      return this.conditions;
   }

   public void setConditions(String var1) {
      this.conditions = var1;
   }

   public String getEcheances() {
      return this.echeances;
   }

   public void setEcheances(String var1) {
      this.echeances = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public String getJournals() {
      return this.journals;
   }

   public void setJournals(String var1) {
      this.journals = var1;
   }

   public String getLibelles() {
      return this.libelles;
   }

   public void setLibelles(String var1) {
      this.libelles = var1;
   }

   public String getNbjours() {
      return this.nbjours;
   }

   public void setNbjours(String var1) {
      this.nbjours = var1;
   }

   public String getDefaut() {
      return this.defaut;
   }

   public void setDefaut(String var1) {
      this.defaut = var1;
   }
}
