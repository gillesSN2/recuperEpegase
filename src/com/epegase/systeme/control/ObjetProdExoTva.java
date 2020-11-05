package com.epegase.systeme.control;

import java.io.Serializable;

public class ObjetProdExoTva implements Serializable {
   private String code;
   private String libelle;
   private boolean exoTva;

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

   public boolean isExoTva() {
      return this.exoTva;
   }

   public void setExoTva(boolean var1) {
      this.exoTva = var1;
   }
}
