package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetAntedecentCDA implements Serializable {
   private Integer indice;
   private String code;
   private String titre;
   private String libelle;
   private String niveau;
   private String action;
   private String decale;

   public String getAction() {
      return this.action;
   }

   public void setAction(String var1) {
      this.action = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public Integer getIndice() {
      return this.indice;
   }

   public void setIndice(Integer var1) {
      this.indice = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public String getNiveau() {
      return this.niveau;
   }

   public void setNiveau(String var1) {
      this.niveau = var1;
   }

   public String getTitre() {
      return this.titre;
   }

   public void setTitre(String var1) {
      this.titre = var1;
   }

   public String getDecale() {
      if (this.niveau.equalsIgnoreCase("0")) {
         this.decale = "";
      } else if (this.niveau.equalsIgnoreCase("1")) {
         this.decale = ".....";
      }

      return this.decale;
   }

   public void setDecale(String var1) {
      this.decale = var1;
   }
}
