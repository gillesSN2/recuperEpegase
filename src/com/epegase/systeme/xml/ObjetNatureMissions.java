package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetNatureMissions implements Serializable {
   private int indice;
   private String code;
   private String libelle;

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
}
