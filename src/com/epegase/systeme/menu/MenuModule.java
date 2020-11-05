package com.epegase.systeme.menu;

import java.io.Serializable;

public class MenuModule implements Serializable {
   private String libelle;
   private String action;
   private String alert;
   private boolean etat;
   private boolean affiche;
   private int code;

   public String getAction() {
      return this.action;
   }

   public void setAction(String var1) {
      this.action = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public boolean isEtat() {
      return this.etat;
   }

   public void setEtat(boolean var1) {
      this.etat = var1;
   }

   public String getAlert() {
      return this.alert;
   }

   public void setAlert(String var1) {
      this.alert = var1;
   }

   public int getCode() {
      return this.code;
   }

   public void setCode(int var1) {
      this.code = var1;
   }

   public boolean isAffiche() {
      return this.affiche;
   }

   public void setAffiche(boolean var1) {
      this.affiche = var1;
   }
}
