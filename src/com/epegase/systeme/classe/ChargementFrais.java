package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ChargementFrais implements Serializable {
   private long chafraId;
   private String chafraCode;
   private String chafraFamille;
   private String chafraLibelle;
   private String chafraPiece;
   private String chafraDescription;
   private double chafraMontant;
   private Date chafraDate;
   private ChargementEntete chargementEntete;

   public String getChafraCode() {
      return this.chafraCode;
   }

   public void setChafraCode(String var1) {
      this.chafraCode = var1;
   }

   public Date getChafraDate() {
      return this.chafraDate;
   }

   public void setChafraDate(Date var1) {
      this.chafraDate = var1;
   }

   public String getChafraDescription() {
      return this.chafraDescription;
   }

   public void setChafraDescription(String var1) {
      this.chafraDescription = var1;
   }

   public String getChafraFamille() {
      return this.chafraFamille;
   }

   public void setChafraFamille(String var1) {
      this.chafraFamille = var1;
   }

   public long getChafraId() {
      return this.chafraId;
   }

   public void setChafraId(long var1) {
      this.chafraId = var1;
   }

   public String getChafraLibelle() {
      return this.chafraLibelle;
   }

   public void setChafraLibelle(String var1) {
      this.chafraLibelle = var1;
   }

   public double getChafraMontant() {
      return this.chafraMontant;
   }

   public void setChafraMontant(double var1) {
      this.chafraMontant = var1;
   }

   public String getChafraPiece() {
      return this.chafraPiece;
   }

   public void setChafraPiece(String var1) {
      this.chafraPiece = var1;
   }

   public ChargementEntete getChargementEntete() {
      return this.chargementEntete;
   }

   public void setChargementEntete(ChargementEntete var1) {
      this.chargementEntete = var1;
   }
}
