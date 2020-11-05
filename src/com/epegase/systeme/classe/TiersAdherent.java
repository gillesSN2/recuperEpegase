package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TiersAdherent implements Serializable {
   private long tieadhId;
   private Date tieadhDateCreat;
   private Date tieadhDateModif;
   private long tieadhUserCreat;
   private long tieadhUserModif;
   private String tieadhRaisonSociale;
   private Tiers tiers;

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public Date getTieadhDateCreat() {
      return this.tieadhDateCreat;
   }

   public void setTieadhDateCreat(Date var1) {
      this.tieadhDateCreat = var1;
   }

   public Date getTieadhDateModif() {
      return this.tieadhDateModif;
   }

   public void setTieadhDateModif(Date var1) {
      this.tieadhDateModif = var1;
   }

   public long getTieadhId() {
      return this.tieadhId;
   }

   public void setTieadhId(long var1) {
      this.tieadhId = var1;
   }

   public String getTieadhRaisonSociale() {
      return this.tieadhRaisonSociale;
   }

   public void setTieadhRaisonSociale(String var1) {
      this.tieadhRaisonSociale = var1;
   }

   public long getTieadhUserCreat() {
      return this.tieadhUserCreat;
   }

   public void setTieadhUserCreat(long var1) {
      this.tieadhUserCreat = var1;
   }

   public long getTieadhUserModif() {
      return this.tieadhUserModif;
   }

   public void setTieadhUserModif(long var1) {
      this.tieadhUserModif = var1;
   }
}
