package com.epegase.systeme.classe;

import java.io.Serializable;

public class EcrituresModelesLignes implements Serializable {
   private long modligId;
   private String modligCompte;
   private String modligLibelle;
   private int modligSens;
   private int modligNature;
   private float modligTaux;
   private float modligTc;
   private int modligCalcul;
   private EcrituresModeles ecrituresModeles;
   private String libelleCalcul;
   private String libelleSens;

   public EcrituresModeles getEcrituresModeles() {
      return this.ecrituresModeles;
   }

   public void setEcrituresModeles(EcrituresModeles var1) {
      this.ecrituresModeles = var1;
   }

   public String getLibelleCalcul() {
      if (this.modligCalcul == 0) {
         this.libelleCalcul = "= montant saisie";
      } else if (this.modligCalcul == 1) {
         this.libelleCalcul = "= calcule TVA";
      } else if (this.modligCalcul == 2) {
         this.libelleCalcul = "= extraction TVA";
      } else if (this.modligCalcul == 3) {
         this.libelleCalcul = "= calcule TPS";
      } else if (this.modligCalcul == 4) {
         this.libelleCalcul = "= extraction TPS";
      } else if (this.modligCalcul == 5) {
         this.libelleCalcul = "= calcule CSS";
      } else if (this.modligCalcul == 6) {
         this.libelleCalcul = "= extraction CSS";
      } else if (this.modligCalcul == 7) {
         this.libelleCalcul = "= calcul H.T.";
      } else if (this.modligCalcul == 8) {
         this.libelleCalcul = "= calcul T.T.C.";
      }

      return this.libelleCalcul;
   }

   public void setLibelleCalcul(String var1) {
      this.libelleCalcul = var1;
   }

   public String getLibelleSens() {
      if (this.modligSens == 0) {
         this.libelleSens = "Débit";
      } else {
         this.libelleSens = "Crédit";
      }

      return this.libelleSens;
   }

   public void setLibelleSens(String var1) {
      this.libelleSens = var1;
   }

   public String getModligCompte() {
      return this.modligCompte;
   }

   public void setModligCompte(String var1) {
      this.modligCompte = var1;
   }

   public long getModligId() {
      return this.modligId;
   }

   public void setModligId(long var1) {
      this.modligId = var1;
   }

   public String getModligLibelle() {
      return this.modligLibelle;
   }

   public void setModligLibelle(String var1) {
      this.modligLibelle = var1;
   }

   public int getModligSens() {
      return this.modligSens;
   }

   public void setModligSens(int var1) {
      this.modligSens = var1;
   }

   public int getModligNature() {
      return this.modligNature;
   }

   public void setModligNature(int var1) {
      this.modligNature = var1;
   }

   public int getModligCalcul() {
      return this.modligCalcul;
   }

   public void setModligCalcul(int var1) {
      this.modligCalcul = var1;
   }

   public float getModligTaux() {
      return this.modligTaux;
   }

   public void setModligTaux(float var1) {
      this.modligTaux = var1;
   }

   public float getModligTc() {
      return this.modligTc;
   }

   public void setModligTc(float var1) {
      this.modligTc = var1;
   }
}
