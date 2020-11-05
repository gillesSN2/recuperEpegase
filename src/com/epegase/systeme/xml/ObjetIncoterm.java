package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetIncoterm implements Serializable {
   String groupe;
   String code;
   String libelle;
   String nom;
   String etat;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getGroupe() {
      return this.groupe;
   }

   public void setGroupe(String var1) {
      this.groupe = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public String getNom() {
      return this.nom;
   }

   public void setNom(String var1) {
      this.nom = var1;
   }
}
