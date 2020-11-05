package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetLangue implements Serializable {
   private Integer indice;
   private String libelle;
   private String code;

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
}
