package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProduitsServices implements Serializable {
   private long proserId;
   private String proserCode;
   private String proserNomFr;
   private float proserQte;
   private Produits produits;
   private Service services;

   public ProduitsServices() {
   }

   public ProduitsServices(String var1, String var2, Produits var3, Service var4) {
      this.proserCode = var1;
      this.proserNomFr = var2;
      this.produits = var3;
      this.services = var4;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public String getProserCode() {
      return this.proserCode;
   }

   public void setProserCode(String var1) {
      this.proserCode = var1;
   }

   public long getProserId() {
      return this.proserId;
   }

   public void setProserId(long var1) {
      this.proserId = var1;
   }

   public String getProserNomFr() {
      return this.proserNomFr;
   }

   public void setProserNomFr(String var1) {
      this.proserNomFr = var1;
   }

   public Service getServices() {
      return this.services;
   }

   public void setServices(Service var1) {
      this.services = var1;
   }

   public float getProserQte() {
      return this.proserQte;
   }

   public void setProserQte(float var1) {
      this.proserQte = var1;
   }
}
