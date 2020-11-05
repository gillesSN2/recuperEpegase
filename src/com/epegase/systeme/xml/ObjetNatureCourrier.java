package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetNatureCourrier implements Serializable {
   private int indice;
   private String code;
   private String libelle;
   private String nature;
   private int codeNature;

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

   public int getCodeNature() {
      return this.codeNature;
   }

   public void setCodeNature(int var1) {
      this.codeNature = var1;
   }

   public String getNature() {
      if (this.codeNature == 0) {
         this.nature = "Mails envoyés";
      } else if (this.codeNature == 1) {
         this.nature = "Mails reçus";
      } else if (this.codeNature == 2) {
         this.nature = "Mails brouillons";
      } else if (this.codeNature == 3) {
         this.nature = "Courriers envoyés";
      } else if (this.codeNature == 4) {
         this.nature = "Courriers reçus";
      } else if (this.codeNature == 125) {
         this.nature = "Courriers internes envoyés";
      } else if (this.codeNature == 126) {
         this.nature = "Courriers internes reçus";
      } else if (this.codeNature == 5) {
         this.nature = "Corbeille";
      }

      return this.nature;
   }

   public void setNature(String var1) {
      this.nature = var1;
   }
}
