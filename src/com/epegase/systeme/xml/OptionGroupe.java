package com.epegase.systeme.xml;

import java.io.Serializable;

public class OptionGroupe implements Serializable {
   private String typeGroupe;
   private String idGroupe;
   private String nomGroupe;
   private String synchroTiers = "0";
   private String synchroOffice = "0";
   private String synchroProduits = "0";
   private String centralisationCompta = "0";

   public String getTypeGroupe() {
      return this.typeGroupe;
   }

   public void setTypeGroupe(String var1) {
      this.typeGroupe = var1;
   }

   public String getSynchroProduits() {
      return this.synchroProduits;
   }

   public void setSynchroProduits(String var1) {
      this.synchroProduits = var1;
   }

   public String getSynchroTiers() {
      return this.synchroTiers;
   }

   public void setSynchroTiers(String var1) {
      this.synchroTiers = var1;
   }

   public String getIdGroupe() {
      return this.idGroupe;
   }

   public void setIdGroupe(String var1) {
      this.idGroupe = var1;
   }

   public String getSynchroOffice() {
      return this.synchroOffice;
   }

   public void setSynchroOffice(String var1) {
      this.synchroOffice = var1;
   }

   public String getCentralisationCompta() {
      return this.centralisationCompta;
   }

   public void setCentralisationCompta(String var1) {
      this.centralisationCompta = var1;
   }

   public String getNomGroupe() {
      return this.nomGroupe;
   }

   public void setNomGroupe(String var1) {
      this.nomGroupe = var1;
   }
}
