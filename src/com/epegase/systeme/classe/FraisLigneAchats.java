package com.epegase.systeme.classe;

import java.io.Serializable;

public class FraisLigneAchats implements Serializable {
   private long fsfligId;
   private String fsfligCode;
   private String fsfligFamille;
   private String fsfligLibelle;
   private int fsfligMode;
   private String fsfligDescription;
   private String fsfligTaxe;
   private float fsfligTauxTaxe;
   private String fsfligUnite;
   private float fsfligQte;
   private float fsfligQteUtil;
   private float fsfligPoidsBrut;
   private String fsfligDevise;
   private float fsfligCoefDevise;
   private double fsfligPu;
   private float fsfligTauxRemise;
   private double fsfligRabais;
   private double fsfligPuRem;
   private double fsfligPt;
   private double fsfligPtLocal;
   private double fsfligTva;
   private double fsfligTc;
   private double fsfligTtc;
   private double fsfligPr;
   private double fsfligPump;
   private long fsfligIdFournisseur2;
   private String fsfligNomFournisseur2;
   private String fsfligNunFactureFour2;
   private long fsfligIdRec;
   private FraisEnteteAchats fraisEnteteAchats;
   private String libelle_nature;

   public String getLibelle_nature() {
      if (this.fsfligMode == 0) {
         this.libelle_nature = "Divers";
      } else if (this.fsfligMode == 1) {
         this.libelle_nature = "Fret";
      } else if (this.fsfligMode == 2) {
         this.libelle_nature = "Assurance";
      } else if (this.fsfligMode == 3) {
         this.libelle_nature = "Douane";
      } else if (this.fsfligMode == 4) {
         this.libelle_nature = "TVA/Douane";
      } else if (this.fsfligMode == 5) {
         this.libelle_nature = "Transport";
      } else if (this.fsfligMode == 6) {
         this.libelle_nature = "Débours";
      } else if (this.fsfligMode == 7) {
         this.libelle_nature = "Caution";
      } else if (this.fsfligMode == 8) {
         this.libelle_nature = "Frais Financier";
      }

      return this.libelle_nature;
   }

   public void setLibelle_nature(String var1) {
      this.libelle_nature = var1;
   }

   public FraisEnteteAchats getFraisEnteteAchats() {
      return this.fraisEnteteAchats;
   }

   public void setFraisEnteteAchats(FraisEnteteAchats var1) {
      this.fraisEnteteAchats = var1;
   }

   public String getFsfligCode() {
      return this.fsfligCode;
   }

   public void setFsfligCode(String var1) {
      this.fsfligCode = var1;
   }

   public String getFsfligDevise() {
      return this.fsfligDevise;
   }

   public void setFsfligDevise(String var1) {
      this.fsfligDevise = var1;
   }

   public String getFsfligFamille() {
      return this.fsfligFamille;
   }

   public void setFsfligFamille(String var1) {
      this.fsfligFamille = var1;
   }

   public long getFsfligId() {
      return this.fsfligId;
   }

   public void setFsfligId(long var1) {
      this.fsfligId = var1;
   }

   public String getFsfligLibelle() {
      return this.fsfligLibelle;
   }

   public void setFsfligLibelle(String var1) {
      this.fsfligLibelle = var1;
   }

   public double getFsfligPr() {
      return this.fsfligPr;
   }

   public void setFsfligPr(double var1) {
      this.fsfligPr = var1;
   }

   public double getFsfligPt() {
      return this.fsfligPt;
   }

   public void setFsfligPt(double var1) {
      this.fsfligPt = var1;
   }

   public double getFsfligPu() {
      return this.fsfligPu;
   }

   public void setFsfligPu(double var1) {
      this.fsfligPu = var1;
   }

   public double getFsfligPuRem() {
      return this.fsfligPuRem;
   }

   public void setFsfligPuRem(double var1) {
      this.fsfligPuRem = var1;
   }

   public double getFsfligPump() {
      return this.fsfligPump;
   }

   public void setFsfligPump(double var1) {
      this.fsfligPump = var1;
   }

   public float getFsfligQte() {
      return this.fsfligQte;
   }

   public void setFsfligQte(float var1) {
      this.fsfligQte = var1;
   }

   public double getFsfligRabais() {
      return this.fsfligRabais;
   }

   public void setFsfligRabais(double var1) {
      this.fsfligRabais = var1;
   }

   public float getFsfligTauxRemise() {
      return this.fsfligTauxRemise;
   }

   public void setFsfligTauxRemise(float var1) {
      this.fsfligTauxRemise = var1;
   }

   public float getFsfligTauxTaxe() {
      return this.fsfligTauxTaxe;
   }

   public void setFsfligTauxTaxe(float var1) {
      this.fsfligTauxTaxe = var1;
   }

   public String getFsfligTaxe() {
      return this.fsfligTaxe;
   }

   public void setFsfligTaxe(String var1) {
      this.fsfligTaxe = var1;
   }

   public double getFsfligTc() {
      return this.fsfligTc;
   }

   public void setFsfligTc(double var1) {
      this.fsfligTc = var1;
   }

   public double getFsfligTtc() {
      return this.fsfligTtc;
   }

   public void setFsfligTtc(double var1) {
      this.fsfligTtc = var1;
   }

   public double getFsfligTva() {
      return this.fsfligTva;
   }

   public void setFsfligTva(double var1) {
      this.fsfligTva = var1;
   }

   public String getFsfligUnite() {
      return this.fsfligUnite;
   }

   public void setFsfligUnite(String var1) {
      this.fsfligUnite = var1;
   }

   public long getFsfligIdFournisseur2() {
      return this.fsfligIdFournisseur2;
   }

   public void setFsfligIdFournisseur2(long var1) {
      this.fsfligIdFournisseur2 = var1;
   }

   public String getFsfligNomFournisseur2() {
      return this.fsfligNomFournisseur2;
   }

   public void setFsfligNomFournisseur2(String var1) {
      this.fsfligNomFournisseur2 = var1;
   }

   public String getFsfligNunFactureFour2() {
      return this.fsfligNunFactureFour2;
   }

   public void setFsfligNunFactureFour2(String var1) {
      this.fsfligNunFactureFour2 = var1;
   }

   public int getFsfligMode() {
      return this.fsfligMode;
   }

   public void setFsfligMode(int var1) {
      this.fsfligMode = var1;
   }

   public double getFsfligPtLocal() {
      return this.fsfligPtLocal;
   }

   public void setFsfligPtLocal(double var1) {
      this.fsfligPtLocal = var1;
   }

   public String getFsfligDescription() {
      return this.fsfligDescription;
   }

   public void setFsfligDescription(String var1) {
      this.fsfligDescription = var1;
   }

   public float getFsfligQteUtil() {
      return this.fsfligQteUtil;
   }

   public void setFsfligQteUtil(float var1) {
      this.fsfligQteUtil = var1;
   }

   public float getFsfligPoidsBrut() {
      return this.fsfligPoidsBrut;
   }

   public void setFsfligPoidsBrut(float var1) {
      this.fsfligPoidsBrut = var1;
   }

   public float getFsfligCoefDevise() {
      return this.fsfligCoefDevise;
   }

   public void setFsfligCoefDevise(float var1) {
      this.fsfligCoefDevise = var1;
   }

   public long getFsfligIdRec() {
      return this.fsfligIdRec;
   }

   public void setFsfligIdRec(long var1) {
      this.fsfligIdRec = var1;
   }
}
