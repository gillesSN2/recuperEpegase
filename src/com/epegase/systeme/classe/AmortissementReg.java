package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class AmortissementReg implements Serializable {
   private Long amoregId;
   private Date amoregDateCreat;
   private Date amoregDateModif;
   private long amoregUserCreat;
   private long amoregUserModif;
   private Date amoregDateReg;
   private double amoregMontant;
   private Amortissements amortissements;

   public Date getAmoregDateCreat() {
      return this.amoregDateCreat;
   }

   public void setAmoregDateCreat(Date var1) {
      this.amoregDateCreat = var1;
   }

   public Date getAmoregDateModif() {
      return this.amoregDateModif;
   }

   public void setAmoregDateModif(Date var1) {
      this.amoregDateModif = var1;
   }

   public Date getAmoregDateReg() {
      return this.amoregDateReg;
   }

   public void setAmoregDateReg(Date var1) {
      this.amoregDateReg = var1;
   }

   public Long getAmoregId() {
      return this.amoregId;
   }

   public void setAmoregId(Long var1) {
      this.amoregId = var1;
   }

   public double getAmoregMontant() {
      return this.amoregMontant;
   }

   public void setAmoregMontant(double var1) {
      this.amoregMontant = var1;
   }

   public long getAmoregUserCreat() {
      return this.amoregUserCreat;
   }

   public void setAmoregUserCreat(long var1) {
      this.amoregUserCreat = var1;
   }

   public long getAmoregUserModif() {
      return this.amoregUserModif;
   }

   public void setAmoregUserModif(long var1) {
      this.amoregUserModif = var1;
   }

   public void setAmoregUserModif(int var1) {
      this.amoregUserModif = (long)var1;
   }

   public Amortissements getAmortissements() {
      return this.amortissements;
   }

   public void setAmortissements(Amortissements var1) {
      this.amortissements = var1;
   }
}
