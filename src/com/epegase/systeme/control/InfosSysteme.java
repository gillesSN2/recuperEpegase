package com.epegase.systeme.control;

import java.io.Serializable;

public class InfosSysteme implements Serializable {
   private String nomTable;
   private String nomReel;
   private String nomrepertoire;
   private String module;
   private long nbRecords;
   private long nbRecordsDistant;
   private long taille;
   private String type;
   private String styleCouleur;
   private boolean select;

   public String getStyleCouleur() {
      if (this.nbRecordsDistant != 0L) {
         if (this.nbRecordsDistant != this.nbRecords) {
            this.styleCouleur = "color:red";
         } else {
            this.styleCouleur = "color:black";
         }
      } else {
         this.styleCouleur = "color:black";
      }

      return this.styleCouleur;
   }

   public void setStyleCouleur(String var1) {
      this.styleCouleur = var1;
   }

   public long getNbRecords() {
      return this.nbRecords;
   }

   public void setNbRecords(long var1) {
      this.nbRecords = var1;
   }

   public String getNomTable() {
      return this.nomTable;
   }

   public void setNomTable(String var1) {
      this.nomTable = var1;
   }

   public String getModule() {
      return this.module;
   }

   public void setModule(String var1) {
      this.module = var1;
   }

   public long getTaille() {
      return this.taille;
   }

   public void setTaille(long var1) {
      this.taille = var1;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public String getNomReel() {
      return this.nomReel;
   }

   public void setNomReel(String var1) {
      this.nomReel = var1;
   }

   public String getNomrepertoire() {
      return this.nomrepertoire;
   }

   public void setNomrepertoire(String var1) {
      this.nomrepertoire = var1;
   }

   public long getNbRecordsDistant() {
      return this.nbRecordsDistant;
   }

   public void setNbRecordsDistant(long var1) {
      this.nbRecordsDistant = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }
}
