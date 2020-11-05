package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProduitsGrp implements Serializable {
   private long progrpId;
   private String progrpCode;
   private String progrpRef;
   private String progrpLibelle;
   private String progrpDepot;
   private float progrpQte;
   private String progrpUnite;
   private double progrpPump;
   private double progrpPv;
   private Produits produits;
   private int progrpInactif;
   private String etat;
   private boolean inactif;

   public ProduitsGrp() {
   }

   public ProduitsGrp(String var1, String var2, String var3, float var4, String var5, double var6, Produits var8) {
      this.progrpCode = var1;
      this.progrpLibelle = var2;
      this.progrpDepot = var3;
      this.progrpQte = var4;
      this.progrpUnite = var5;
      this.progrpPump = var6;
      this.produits = var8;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public String getProgrpCode() {
      return this.progrpCode;
   }

   public void setProgrpCode(String var1) {
      this.progrpCode = var1;
   }

   public String getProgrpDepot() {
      return this.progrpDepot;
   }

   public void setProgrpDepot(String var1) {
      this.progrpDepot = var1;
   }

   public long getProgrpId() {
      return this.progrpId;
   }

   public void setProgrpId(long var1) {
      this.progrpId = var1;
   }

   public String getProgrpLibelle() {
      return this.progrpLibelle;
   }

   public void setProgrpLibelle(String var1) {
      this.progrpLibelle = var1;
   }

   public double getProgrpPump() {
      return this.progrpPump;
   }

   public void setProgrpPump(double var1) {
      this.progrpPump = var1;
   }

   public float getProgrpQte() {
      return this.progrpQte;
   }

   public void setProgrpQte(float var1) {
      this.progrpQte = var1;
   }

   public String getProgrpUnite() {
      return this.progrpUnite;
   }

   public void setProgrpUnite(String var1) {
      this.progrpUnite = var1;
   }

   public String getEtat() {
      if (this.progrpInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.progrpInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.progrpInactif != 1 && this.progrpInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public int getProgrpInactif() {
      return this.progrpInactif;
   }

   public void setProgrpInactif(int var1) {
      this.progrpInactif = var1;
   }

   public double getProgrpPv() {
      return this.progrpPv;
   }

   public void setProgrpPv(double var1) {
      this.progrpPv = var1;
   }

   public String getProgrpRef() {
      return this.progrpRef;
   }

   public void setProgrpRef(String var1) {
      this.progrpRef = var1;
   }
}
