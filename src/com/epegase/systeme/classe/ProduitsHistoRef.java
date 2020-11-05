package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProduitsHistoRef implements Serializable {
   private long prohrfId;
   private String prohrfReference;
   private Date prohrfDateDebut;
   private Date prohrfDateFin;
   private String prohrfObs;
   private Produits produits;

   public long getProhrfId() {
      return this.prohrfId;
   }

   public void setProhrfId(long var1) {
      this.prohrfId = var1;
   }

   public Date getProhrfDateFin() {
      return this.prohrfDateFin;
   }

   public void setProhrfDateFin(Date var1) {
      this.prohrfDateFin = var1;
   }

   public String getProhrfObs() {
      return this.prohrfObs;
   }

   public void setProhrfObs(String var1) {
      this.prohrfObs = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public Date getProhrfDateDebut() {
      return this.prohrfDateDebut;
   }

   public void setProhrfDateDebut(Date var1) {
      this.prohrfDateDebut = var1;
   }

   public String getProhrfReference() {
      if (this.prohrfReference != null && !this.prohrfReference.isEmpty()) {
         this.prohrfReference = this.prohrfReference.toUpperCase();
      }

      return this.prohrfReference;
   }

   public void setProhrfReference(String var1) {
      this.prohrfReference = var1;
   }
}
