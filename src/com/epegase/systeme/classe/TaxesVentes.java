package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TaxesVentes implements Serializable {
   private long taxvteId;
   private Date taxvteDateCreation;
   private Date taxvteDateModif;
   private long taxvteUserCreation;
   private long taxvteUserModif;
   private String taxvteCode;
   private String taxvteLibelleFr;
   private String taxvteLibelleUk;
   private String taxvteLibelleSp;
   private float taxvteTaux;
   private String taxvteCompte;
   private int taxvteType;
   private int taxvteTimbre;
   private int taxvteTc;
   private ExercicesVentes exerciceventes;
   private int taxvteInactif;
   private String etat;
   private boolean afficheImag;

   public String getEtat() {
      if (this.taxvteInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.taxvteInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.taxvteInactif != 1 && this.taxvteInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public int getTaxvteInactif() {
      return this.taxvteInactif;
   }

   public void setTaxvteInactif(int var1) {
      this.taxvteInactif = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public String getTaxvteCode() {
      if (this.taxvteCode != null && !this.taxvteCode.isEmpty()) {
         this.taxvteCode = this.taxvteCode.toUpperCase();
      }

      return this.taxvteCode;
   }

   public void setTaxvteCode(String var1) {
      this.taxvteCode = var1;
   }

   public String getTaxvteCompte() {
      return this.taxvteCompte;
   }

   public void setTaxvteCompte(String var1) {
      this.taxvteCompte = var1;
   }

   public Date getTaxvteDateCreation() {
      return this.taxvteDateCreation;
   }

   public void setTaxvteDateCreation(Date var1) {
      this.taxvteDateCreation = var1;
   }

   public Date getTaxvteDateModif() {
      return this.taxvteDateModif;
   }

   public void setTaxvteDateModif(Date var1) {
      this.taxvteDateModif = var1;
   }

   public long getTaxvteId() {
      return this.taxvteId;
   }

   public void setTaxvteId(long var1) {
      this.taxvteId = var1;
   }

   public String getTaxvteLibelleFr() {
      if (this.taxvteLibelleFr != null && !this.taxvteLibelleFr.isEmpty()) {
         this.taxvteLibelleFr = this.taxvteLibelleFr.toUpperCase();
      }

      return this.taxvteLibelleFr;
   }

   public void setTaxvteLibelleFr(String var1) {
      this.taxvteLibelleFr = var1;
   }

   public String getTaxvteLibelleSp() {
      return this.taxvteLibelleSp;
   }

   public void setTaxvteLibelleSp(String var1) {
      this.taxvteLibelleSp = var1;
   }

   public String getTaxvteLibelleUk() {
      return this.taxvteLibelleUk;
   }

   public void setTaxvteLibelleUk(String var1) {
      this.taxvteLibelleUk = var1;
   }

   public float getTaxvteTaux() {
      return this.taxvteTaux;
   }

   public void setTaxvteTaux(float var1) {
      this.taxvteTaux = var1;
   }

   public int getTaxvteTimbre() {
      return this.taxvteTimbre;
   }

   public void setTaxvteTimbre(int var1) {
      this.taxvteTimbre = var1;
   }

   public int getTaxvteType() {
      return this.taxvteType;
   }

   public void setTaxvteType(int var1) {
      this.taxvteType = var1;
   }

   public long getTaxvteUserCreation() {
      return this.taxvteUserCreation;
   }

   public void setTaxvteUserCreation(long var1) {
      this.taxvteUserCreation = var1;
   }

   public long getTaxvteUserModif() {
      return this.taxvteUserModif;
   }

   public void setTaxvteUserModif(long var1) {
      this.taxvteUserModif = var1;
   }

   public int getTaxvteTc() {
      return this.taxvteTc;
   }

   public void setTaxvteTc(int var1) {
      this.taxvteTc = var1;
   }
}
