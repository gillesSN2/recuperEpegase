package com.epegase.systeme.menu;

import java.io.Serializable;

public class MenuGauche implements Serializable {
   private int indice;
   private String libelle_FR;
   private String libelle_UK;
   private String libelle_SP;
   private String pagemenu;
   private String commande;

   public String getCommande() {
      return this.commande;
   }

   public void setCommande(String var1) {
      this.commande = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public String getLibelle_FR() {
      return this.libelle_FR;
   }

   public void setLibelle_FR(String var1) {
      this.libelle_FR = var1;
   }

   public String getLibelle_SP() {
      return this.libelle_SP;
   }

   public void setLibelle_SP(String var1) {
      this.libelle_SP = var1;
   }

   public String getLibelle_UK() {
      return this.libelle_UK;
   }

   public void setLibelle_UK(String var1) {
      this.libelle_UK = var1;
   }

   public String getPagemenu() {
      return this.pagemenu;
   }

   public void setPagemenu(String var1) {
      this.pagemenu = var1;
   }
}
