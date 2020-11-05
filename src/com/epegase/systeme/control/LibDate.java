package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.Date;

public class LibDate implements Serializable {
   private String libelle;
   private Date date;
   private Date dateDeb;
   private Date dateFin;
   private double montant;

   public Date getDate() {
      return this.date;
   }

   public void setDate(Date var1) {
      this.date = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public double getMontant() {
      return this.montant;
   }

   public void setMontant(double var1) {
      this.montant = var1;
   }

   public Date getDateDeb() {
      return this.dateDeb;
   }

   public void setDateDeb(Date var1) {
      this.dateDeb = var1;
   }

   public Date getDateFin() {
      return this.dateFin;
   }

   public void setDateFin(Date var1) {
      this.dateFin = var1;
   }
}
