package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BienGeranceEntete implements Serializable {
   private long biegerentId;
   private Date biegerentDateCreat;
   private Date biegerentDateModif;
   private long biegerentUserCreat;
   private long biegerentUserModif;
   private Date biegerentDateSignature;
   private Date biegerentDateDebut;
   private Date biegerentDateFin;
   private int biegerentModule;
   private String biegerentNum;
   private int biegerentDuree;
   private int biegerentEtat;
   private int biegerentMode;
   private String biegerentNomTiers;
   private String biegerentCivilTiers;
   private int biegerentTypeTiers;
   private String biegerentSerie;
   private int biegerentExoTva;
   private String biegerentNomResponsable;
   private long biegerentIdResponsable;
   private String biegerentContrat;
   private Date biegerentDateImp;
   private String biegerentModeleImp;
   private int biegerentEtatVal;
   private Date biegerentDateValidite;
   private Date biegerentDateValide;
   private String biegerentLocal;
   private double biegerentHonoraireHt;
   private String biegerentCodeTva;
   private float biegerentTauxTva;
   private double biegerentHonoraireTaxe;
   private double biegerentHonoraireTtc;
   private Tiers tiers;
   private Bien bien;
   private String libelleMode;
   private String libelleEtat;

   public String getLibelleEtat() {
      if (this.biegerentEtat == 0) {
         this.libelleEtat = "En cours";
      } else if (this.biegerentEtat == 1) {
         this.libelleEtat = "Validé";
      } else if (this.biegerentEtat == 2) {
         this.libelleEtat = "Annulé";
      } else if (this.biegerentEtat == 3) {
         this.libelleEtat = "Gélé";
      } else if (this.biegerentEtat == 4) {
         this.libelleEtat = "Terminé";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getLibelleMode() {
      if (this.biegerentMode == 0) {
         this.libelleMode = "Mensuel";
      } else if (this.biegerentMode == 1) {
         this.libelleMode = "Trimestriel";
      } else if (this.biegerentMode == 2) {
         this.libelleMode = "Semestriel";
      } else if (this.biegerentMode == 3) {
         this.libelleMode = "Annuel";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public String getBiegerentCivilTiers() {
      return this.biegerentCivilTiers;
   }

   public void setBiegerentCivilTiers(String var1) {
      this.biegerentCivilTiers = var1;
   }

   public Date getBiegerentDateCreat() {
      return this.biegerentDateCreat;
   }

   public void setBiegerentDateCreat(Date var1) {
      this.biegerentDateCreat = var1;
   }

   public Date getBiegerentDateDebut() {
      return this.biegerentDateDebut;
   }

   public void setBiegerentDateDebut(Date var1) {
      this.biegerentDateDebut = var1;
   }

   public Date getBiegerentDateFin() {
      return this.biegerentDateFin;
   }

   public void setBiegerentDateFin(Date var1) {
      this.biegerentDateFin = var1;
   }

   public Date getBiegerentDateModif() {
      return this.biegerentDateModif;
   }

   public void setBiegerentDateModif(Date var1) {
      this.biegerentDateModif = var1;
   }

   public Date getBiegerentDateSignature() {
      return this.biegerentDateSignature;
   }

   public void setBiegerentDateSignature(Date var1) {
      this.biegerentDateSignature = var1;
   }

   public int getBiegerentDuree() {
      return this.biegerentDuree;
   }

   public void setBiegerentDuree(int var1) {
      this.biegerentDuree = var1;
   }

   public int getBiegerentEtat() {
      return this.biegerentEtat;
   }

   public void setBiegerentEtat(int var1) {
      this.biegerentEtat = var1;
   }

   public int getBiegerentExoTva() {
      return this.biegerentExoTva;
   }

   public void setBiegerentExoTva(int var1) {
      this.biegerentExoTva = var1;
   }

   public long getBiegerentId() {
      return this.biegerentId;
   }

   public void setBiegerentId(long var1) {
      this.biegerentId = var1;
   }

   public long getBiegerentIdResponsable() {
      return this.biegerentIdResponsable;
   }

   public void setBiegerentIdResponsable(long var1) {
      this.biegerentIdResponsable = var1;
   }

   public int getBiegerentMode() {
      return this.biegerentMode;
   }

   public void setBiegerentMode(int var1) {
      this.biegerentMode = var1;
   }

   public String getBiegerentNomResponsable() {
      return this.biegerentNomResponsable;
   }

   public void setBiegerentNomResponsable(String var1) {
      this.biegerentNomResponsable = var1;
   }

   public String getBiegerentNomTiers() {
      return this.biegerentNomTiers;
   }

   public void setBiegerentNomTiers(String var1) {
      this.biegerentNomTiers = var1;
   }

   public String getBiegerentNum() {
      return this.biegerentNum;
   }

   public void setBiegerentNum(String var1) {
      this.biegerentNum = var1;
   }

   public String getBiegerentSerie() {
      return this.biegerentSerie;
   }

   public void setBiegerentSerie(String var1) {
      this.biegerentSerie = var1;
   }

   public long getBiegerentUserCreat() {
      return this.biegerentUserCreat;
   }

   public void setBiegerentUserCreat(long var1) {
      this.biegerentUserCreat = var1;
   }

   public long getBiegerentUserModif() {
      return this.biegerentUserModif;
   }

   public void setBiegerentUserModif(long var1) {
      this.biegerentUserModif = var1;
   }

   public String getBiegerentContrat() {
      return this.biegerentContrat;
   }

   public void setBiegerentContrat(String var1) {
      this.biegerentContrat = var1;
   }

   public int getBiegerentTypeTiers() {
      return this.biegerentTypeTiers;
   }

   public void setBiegerentTypeTiers(int var1) {
      this.biegerentTypeTiers = var1;
   }

   public Date getBiegerentDateImp() {
      return this.biegerentDateImp;
   }

   public void setBiegerentDateImp(Date var1) {
      this.biegerentDateImp = var1;
   }

   public Date getBiegerentDateValide() {
      return this.biegerentDateValide;
   }

   public void setBiegerentDateValide(Date var1) {
      this.biegerentDateValide = var1;
   }

   public Date getBiegerentDateValidite() {
      return this.biegerentDateValidite;
   }

   public void setBiegerentDateValidite(Date var1) {
      this.biegerentDateValidite = var1;
   }

   public int getBiegerentEtatVal() {
      return this.biegerentEtatVal;
   }

   public void setBiegerentEtatVal(int var1) {
      this.biegerentEtatVal = var1;
   }

   public String getBiegerentModeleImp() {
      return this.biegerentModeleImp;
   }

   public void setBiegerentModeleImp(String var1) {
      this.biegerentModeleImp = var1;
   }

   public int getBiegerentModule() {
      return this.biegerentModule;
   }

   public void setBiegerentModule(int var1) {
      this.biegerentModule = var1;
   }

   public String getBiegerentCodeTva() {
      return this.biegerentCodeTva;
   }

   public void setBiegerentCodeTva(String var1) {
      this.biegerentCodeTva = var1;
   }

   public double getBiegerentHonoraireHt() {
      return this.biegerentHonoraireHt;
   }

   public void setBiegerentHonoraireHt(double var1) {
      this.biegerentHonoraireHt = var1;
   }

   public double getBiegerentHonoraireTaxe() {
      return this.biegerentHonoraireTaxe;
   }

   public void setBiegerentHonoraireTaxe(double var1) {
      this.biegerentHonoraireTaxe = var1;
   }

   public double getBiegerentHonoraireTtc() {
      return this.biegerentHonoraireTtc;
   }

   public void setBiegerentHonoraireTtc(double var1) {
      this.biegerentHonoraireTtc = var1;
   }

   public float getBiegerentTauxTva() {
      return this.biegerentTauxTva;
   }

   public void setBiegerentTauxTva(float var1) {
      this.biegerentTauxTva = var1;
   }

   public String getBiegerentLocal() {
      return this.biegerentLocal;
   }

   public void setBiegerentLocal(String var1) {
      this.biegerentLocal = var1;
   }
}
