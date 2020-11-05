package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CampagneMessageVentes implements Serializable {
   private long cammesId;
   private Date cammesDateCreat;
   private long cammesIdCreateur;
   private String cammesNomCreateur;
   private Date cammesDateModif;
   private long cammesIdModif;
   private String cammesNomModif;
   private Date cammesDate;
   private String cammesObjet;
   private String cammesDescriptif;
   private String cammesMessage;
   private int cammesType;
   private int cammesEtat;
   private CampagneEnteteVentes campagneEnteteVentes;
   private String libelleEtat;

   public String getLibelleEtat() {
      if (this.cammesEtat == 0) {
         this.libelleEtat = "E.C.";
      } else if (this.cammesEtat == 1) {
         this.libelleEtat = "Envoyé";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public CampagneEnteteVentes getCampagneEnteteVentes() {
      return this.campagneEnteteVentes;
   }

   public void setCampagneEnteteVentes(CampagneEnteteVentes var1) {
      this.campagneEnteteVentes = var1;
   }

   public Date getCammesDate() {
      return this.cammesDate;
   }

   public void setCammesDate(Date var1) {
      this.cammesDate = var1;
   }

   public Date getCammesDateCreat() {
      return this.cammesDateCreat;
   }

   public void setCammesDateCreat(Date var1) {
      this.cammesDateCreat = var1;
   }

   public Date getCammesDateModif() {
      return this.cammesDateModif;
   }

   public void setCammesDateModif(Date var1) {
      this.cammesDateModif = var1;
   }

   public int getCammesEtat() {
      return this.cammesEtat;
   }

   public void setCammesEtat(int var1) {
      this.cammesEtat = var1;
   }

   public long getCammesId() {
      return this.cammesId;
   }

   public void setCammesId(long var1) {
      this.cammesId = var1;
   }

   public long getCammesIdCreateur() {
      return this.cammesIdCreateur;
   }

   public void setCammesIdCreateur(long var1) {
      this.cammesIdCreateur = var1;
   }

   public long getCammesIdModif() {
      return this.cammesIdModif;
   }

   public void setCammesIdModif(long var1) {
      this.cammesIdModif = var1;
   }

   public String getCammesMessage() {
      return this.cammesMessage;
   }

   public void setCammesMessage(String var1) {
      this.cammesMessage = var1;
   }

   public String getCammesNomCreateur() {
      return this.cammesNomCreateur;
   }

   public void setCammesNomCreateur(String var1) {
      this.cammesNomCreateur = var1;
   }

   public String getCammesNomModif() {
      return this.cammesNomModif;
   }

   public void setCammesNomModif(String var1) {
      this.cammesNomModif = var1;
   }

   public int getCammesType() {
      return this.cammesType;
   }

   public void setCammesType(int var1) {
      this.cammesType = var1;
   }

   public String getCammesObjet() {
      return this.cammesObjet;
   }

   public void setCammesObjet(String var1) {
      this.cammesObjet = var1;
   }

   public String getCammesDescriptif() {
      return this.cammesDescriptif;
   }

   public void setCammesDescriptif(String var1) {
      this.cammesDescriptif = var1;
   }
}
