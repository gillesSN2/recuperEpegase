package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class DossierTiersMF implements Serializable {
   private long dosId;
   private Date dosDateDemande;
   private Date dosDateReception;
   private Date dosDateAcceptation;
   private Date dosDateRefus;
   private String dosMotifRefus;
   private int dosType;
   private Date dosDateCloture;
   private String dosMotifCloture;
   private Tiers tiers;

   public Date getDosDateAcceptation() {
      return this.dosDateAcceptation;
   }

   public void setDosDateAcceptation(Date var1) {
      this.dosDateAcceptation = var1;
   }

   public Date getDosDateCloture() {
      return this.dosDateCloture;
   }

   public void setDosDateCloture(Date var1) {
      this.dosDateCloture = var1;
   }

   public Date getDosDateDemande() {
      return this.dosDateDemande;
   }

   public void setDosDateDemande(Date var1) {
      this.dosDateDemande = var1;
   }

   public Date getDosDateReception() {
      return this.dosDateReception;
   }

   public void setDosDateReception(Date var1) {
      this.dosDateReception = var1;
   }

   public Date getDosDateRefus() {
      return this.dosDateRefus;
   }

   public void setDosDateRefus(Date var1) {
      this.dosDateRefus = var1;
   }

   public long getDosId() {
      return this.dosId;
   }

   public void setDosId(long var1) {
      this.dosId = var1;
   }

   public String getDosMotifCloture() {
      return this.dosMotifCloture;
   }

   public void setDosMotifCloture(String var1) {
      this.dosMotifCloture = var1;
   }

   public String getDosMotifRefus() {
      return this.dosMotifRefus;
   }

   public void setDosMotifRefus(String var1) {
      this.dosMotifRefus = var1;
   }

   public int getDosType() {
      return this.dosType;
   }

   public void setDosType(int var1) {
      this.dosType = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }
}
