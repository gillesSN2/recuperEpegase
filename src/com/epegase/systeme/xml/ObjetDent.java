package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetDent implements Serializable {
   private Integer indice;
   private String code;
   private String nom_FR;
   private String type;

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

   public String getNom_FR() {
      return this.nom_FR;
   }

   public void setNom_FR(String var1) {
      this.nom_FR = var1;
   }

   public String getType() {
      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }
}
