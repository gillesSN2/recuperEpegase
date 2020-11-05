package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetSuffixeProduction implements Serializable {
   private String nom;
   private String code;

   public String getNom() {
      return this.nom;
   }

   public void setNom(String var1) {
      this.nom = var1;
   }

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }
}
