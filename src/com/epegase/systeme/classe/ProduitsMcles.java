package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProduitsMcles implements Serializable {
   private long promclId;
   private String promclMot;
   private Produits produits;

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public long getPromclId() {
      return this.promclId;
   }

   public void setPromclId(long var1) {
      this.promclId = var1;
   }

   public String getPromclMot() {
      if (this.promclMot != null && !this.promclMot.isEmpty()) {
         this.promclMot = this.promclMot.toUpperCase();
      }

      return this.promclMot;
   }

   public void setPromclMot(String var1) {
      this.promclMot = var1;
   }
}
