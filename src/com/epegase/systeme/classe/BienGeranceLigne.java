package com.epegase.systeme.classe;

import java.io.Serializable;

public class BienGeranceLigne implements Serializable {
   private long biegerligId;
   private int biegerligMode;
   private int biegerligUsage;
   private double biegerligLoyerBrut;
   private double biegerligMontantCaution;
   private float biegerligTauxTom;
   private double biegerligTom;
   private float biegerligTauxTlv;
   private double biegerligTlv;
   private float biegerligTauxTva;
   private double biegerligTva;
   private double biegerligLoyerNet;
   private double biegerligLoyerProfessionnel;
   private double biegerligChargesImmeuble;
   private float biegerligTauxCharges;
   private double biegerligEau;
   private double biegerligElectricite;
   private double biegerligParking;
   private double biegerligGardiennage;
   private double biegerligJardinnier;
   private double biegerligGroupeElectro;
   private String biegerligLibelleFrais;
   private double biegerligFraisComplement;
   private double biegerligDiversFrais;
   private float biegerligTauxCommission;
   private double biegerligTotalCommission;
   private double biegerligTvaCommission;
   private int biegerligModeTlv;
   private double biegerligNetPayer;
   private float biegerligTauxIrpp;
   private double biegerligTotalIrpp;
   private int biegerligDeclare;
   private double biegerligFraisDeclaration;
   private double biegerligFraisEtatCompte;
   private String biegerligNomContrat;
   private String biegerligContrat;
   private Bien bien;
   private BienGeranceEntete bienGeranceEntete;
   private String libelleMode;
   private String libelleUsage;

   public String getLibelleMode() {
      if (this.biegerligMode == 0) {
         this.libelleMode = "Jour";
      } else if (this.biegerligMode == 1) {
         this.libelleMode = "Semaine";
      } else if (this.biegerligMode == 2) {
         this.libelleMode = "Mois";
      } else if (this.biegerligMode == 3) {
         this.libelleMode = "Trimestre";
      } else if (this.biegerligMode == 4) {
         this.libelleMode = "Semestre";
      } else if (this.biegerligMode == 5) {
         this.libelleMode = "Année";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getLibelleUsage() {
      if (this.biegerligUsage == 0) {
         this.libelleUsage = "Habitation";
      } else if (this.biegerligUsage == 1) {
         this.libelleUsage = "Professionnel";
      } else if (this.biegerligUsage == 2) {
         this.libelleUsage = "Industriel";
      } else if (this.biegerligUsage == 3) {
         this.libelleUsage = "mixte";
      }

      return this.libelleUsage;
   }

   public void setLibelleUsage(String var1) {
      this.libelleUsage = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public BienGeranceEntete getBienGeranceEntete() {
      return this.bienGeranceEntete;
   }

   public void setBienGeranceEntete(BienGeranceEntete var1) {
      this.bienGeranceEntete = var1;
   }

   public double getBiegerligChargesImmeuble() {
      return this.biegerligChargesImmeuble;
   }

   public void setBiegerligChargesImmeuble(double var1) {
      this.biegerligChargesImmeuble = var1;
   }

   public double getBiegerligDiversFrais() {
      return this.biegerligDiversFrais;
   }

   public void setBiegerligDiversFrais(double var1) {
      this.biegerligDiversFrais = var1;
   }

   public double getBiegerligEau() {
      return this.biegerligEau;
   }

   public void setBiegerligEau(double var1) {
      this.biegerligEau = var1;
   }

   public double getBiegerligElectricite() {
      return this.biegerligElectricite;
   }

   public void setBiegerligElectricite(double var1) {
      this.biegerligElectricite = var1;
   }

   public double getBiegerligGardiennage() {
      return this.biegerligGardiennage;
   }

   public void setBiegerligGardiennage(double var1) {
      this.biegerligGardiennage = var1;
   }

   public long getBiegerligId() {
      return this.biegerligId;
   }

   public void setBiegerligId(long var1) {
      this.biegerligId = var1;
   }

   public double getBiegerligLoyerBrut() {
      return this.biegerligLoyerBrut;
   }

   public void setBiegerligLoyerBrut(double var1) {
      this.biegerligLoyerBrut = var1;
   }

   public double getBiegerligLoyerNet() {
      return this.biegerligLoyerNet;
   }

   public void setBiegerligLoyerNet(double var1) {
      this.biegerligLoyerNet = var1;
   }

   public int getBiegerligMode() {
      return this.biegerligMode;
   }

   public void setBiegerligMode(int var1) {
      this.biegerligMode = var1;
   }

   public double getBiegerligParking() {
      return this.biegerligParking;
   }

   public void setBiegerligParking(double var1) {
      this.biegerligParking = var1;
   }

   public float getBiegerligTauxCommission() {
      return this.biegerligTauxCommission;
   }

   public void setBiegerligTauxCommission(float var1) {
      this.biegerligTauxCommission = var1;
   }

   public float getBiegerligTauxTlv() {
      return this.biegerligTauxTlv;
   }

   public void setBiegerligTauxTlv(float var1) {
      this.biegerligTauxTlv = var1;
   }

   public float getBiegerligTauxTom() {
      return this.biegerligTauxTom;
   }

   public void setBiegerligTauxTom(float var1) {
      this.biegerligTauxTom = var1;
   }

   public float getBiegerligTauxTva() {
      return this.biegerligTauxTva;
   }

   public void setBiegerligTauxTva(float var1) {
      this.biegerligTauxTva = var1;
   }

   public double getBiegerligTlv() {
      return this.biegerligTlv;
   }

   public void setBiegerligTlv(double var1) {
      this.biegerligTlv = var1;
   }

   public double getBiegerligTom() {
      return this.biegerligTom;
   }

   public void setBiegerligTom(double var1) {
      this.biegerligTom = var1;
   }

   public double getBiegerligTotalCommission() {
      return this.biegerligTotalCommission;
   }

   public void setBiegerligTotalCommission(double var1) {
      this.biegerligTotalCommission = var1;
   }

   public double getBiegerligTva() {
      return this.biegerligTva;
   }

   public void setBiegerligTva(double var1) {
      this.biegerligTva = var1;
   }

   public double getBiegerligTvaCommission() {
      return this.biegerligTvaCommission;
   }

   public void setBiegerligTvaCommission(double var1) {
      this.biegerligTvaCommission = var1;
   }

   public int getBiegerligUsage() {
      return this.biegerligUsage;
   }

   public void setBiegerligUsage(int var1) {
      this.biegerligUsage = var1;
   }

   public double getBiegerligLoyerProfessionnel() {
      return this.biegerligLoyerProfessionnel;
   }

   public void setBiegerligLoyerProfessionnel(double var1) {
      this.biegerligLoyerProfessionnel = var1;
   }

   public double getBiegerligNetPayer() {
      return this.biegerligNetPayer;
   }

   public void setBiegerligNetPayer(double var1) {
      this.biegerligNetPayer = var1;
   }

   public double getBiegerligTotalIrpp() {
      return this.biegerligTotalIrpp;
   }

   public void setBiegerligTotalIrpp(double var1) {
      this.biegerligTotalIrpp = var1;
   }

   public float getBiegerligTauxIrpp() {
      return this.biegerligTauxIrpp;
   }

   public void setBiegerligTauxIrpp(float var1) {
      this.biegerligTauxIrpp = var1;
   }

   public int getBiegerligModeTlv() {
      return this.biegerligModeTlv;
   }

   public void setBiegerligModeTlv(int var1) {
      this.biegerligModeTlv = var1;
   }

   public double getBiegerligMontantCaution() {
      return this.biegerligMontantCaution;
   }

   public void setBiegerligMontantCaution(double var1) {
      this.biegerligMontantCaution = var1;
   }

   public int getBiegerligDeclare() {
      return this.biegerligDeclare;
   }

   public void setBiegerligDeclare(int var1) {
      this.biegerligDeclare = var1;
   }

   public double getBiegerligFraisComplement() {
      return this.biegerligFraisComplement;
   }

   public void setBiegerligFraisComplement(double var1) {
      this.biegerligFraisComplement = var1;
   }

   public double getBiegerligFraisDeclaration() {
      return this.biegerligFraisDeclaration;
   }

   public void setBiegerligFraisDeclaration(double var1) {
      this.biegerligFraisDeclaration = var1;
   }

   public double getBiegerligFraisEtatCompte() {
      return this.biegerligFraisEtatCompte;
   }

   public void setBiegerligFraisEtatCompte(double var1) {
      this.biegerligFraisEtatCompte = var1;
   }

   public double getBiegerligGroupeElectro() {
      return this.biegerligGroupeElectro;
   }

   public void setBiegerligGroupeElectro(double var1) {
      this.biegerligGroupeElectro = var1;
   }

   public double getBiegerligJardinnier() {
      return this.biegerligJardinnier;
   }

   public void setBiegerligJardinnier(double var1) {
      this.biegerligJardinnier = var1;
   }

   public String getBiegerligLibelleFrais() {
      return this.biegerligLibelleFrais;
   }

   public void setBiegerligLibelleFrais(String var1) {
      this.biegerligLibelleFrais = var1;
   }

   public float getBiegerligTauxCharges() {
      return this.biegerligTauxCharges;
   }

   public void setBiegerligTauxCharges(float var1) {
      this.biegerligTauxCharges = var1;
   }

   public String getBiegerligContrat() {
      return this.biegerligContrat;
   }

   public void setBiegerligContrat(String var1) {
      this.biegerligContrat = var1;
   }

   public String getBiegerligNomContrat() {
      return this.biegerligNomContrat;
   }

   public void setBiegerligNomContrat(String var1) {
      this.biegerligNomContrat = var1;
   }
}
