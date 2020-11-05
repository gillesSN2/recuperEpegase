package com.epegase.systeme.control;

import java.io.Serializable;

public class ObjetNaturePret implements Serializable {
   private String code;
   private String libelle;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }
}
