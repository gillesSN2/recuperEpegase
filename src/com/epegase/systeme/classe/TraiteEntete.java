package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TraiteEntete implements Serializable {
   private long trtId;
   private Date trtDateCreat;
   private long trtUserCreat;
   private Date trtDateModif;
   private long trtUserModif;
   private int trtNature;
   private String trtNum;
   private Date trtDateDebut;
   private Date trtDateContrat;
   private int trtDuree;
   private int trtPeriodicite;
   private String trtNomResponsable;
   private long trtIdResponsable;
   private int trtTypeTiers;
   private String trtNomTiers;
   private long trtIdTiers;
   private String trtDevise;
   private float trtCoef;
   private double trtMontant;
   private double trtMontantLocal;
   private int trtNbMoisEcheanceGene;
   private double trtMontantGene;
   private double trtMontantGeneLocal;
   private double trtMontantFinal;
   private double trtMontantFinalLocal;
   private double trtTotalReglement;
   private double trtTotalReglementLocal;
   private String trtObjet;
   private String trtFacture;
   private String trtBanque;
   private long trtIdBanque;
   private String trtActivite;
   private String trtSite;
   private String trtDepartement;
   private String trtService;
   private String trtRegion;
   private String trtSecteur;
   private String trtPdv;
   private String trtBudget;
   private String trtDossier;
   private String trtBateau;
   private int trtEtat;
   private String trtEtatVal;
   private String trtGele;
   private Date trtDateValide;
   private String trtModeleImp;
   private Date trtDateImpression;
   private ExercicesCaisse exercicesCaisse;
   private String var_lib_nat;
   private String var_etat;
   private double solde;
   private String var_compte;
   private String var_banque;
   private String var_nomBanquier;
   private String var_adresseBanque;
   private String var_villeBanque;
   private String var_adresseFournisseur;
   private String var_compteFournisseur;
   private String var_nomBanqueFournisseur;
   private String var_adresseBanqueFournisseur;
   private String var_ibanBanqueFournisseur;
   private String var_swiftBanqueFournisseur;
   private String var_fonctionResponsable;
   private String var_tvaFournisseur;

   public String getVar_ibanBanqueFournisseur() {
      return this.var_ibanBanqueFournisseur;
   }

   public void setVar_ibanBanqueFournisseur(String var1) {
      this.var_ibanBanqueFournisseur = var1;
   }

   public String getVar_swiftBanqueFournisseur() {
      return this.var_swiftBanqueFournisseur;
   }

   public void setVar_swiftBanqueFournisseur(String var1) {
      this.var_swiftBanqueFournisseur = var1;
   }

   public String getVar_tvaFournisseur() {
      return this.var_tvaFournisseur;
   }

   public void setVar_tvaFournisseur(String var1) {
      this.var_tvaFournisseur = var1;
   }

   public String getVar_fonctionResponsable() {
      return this.var_fonctionResponsable;
   }

   public void setVar_fonctionResponsable(String var1) {
      this.var_fonctionResponsable = var1;
   }

   public String getVar_adresseBanqueFournisseur() {
      return this.var_adresseBanqueFournisseur;
   }

   public void setVar_adresseBanqueFournisseur(String var1) {
      this.var_adresseBanqueFournisseur = var1;
   }

   public String getVar_nomBanqueFournisseur() {
      return this.var_nomBanqueFournisseur;
   }

   public void setVar_nomBanqueFournisseur(String var1) {
      this.var_nomBanqueFournisseur = var1;
   }

   public String getVar_compteFournisseur() {
      return this.var_compteFournisseur;
   }

   public void setVar_compteFournisseur(String var1) {
      this.var_compteFournisseur = var1;
   }

   public String getVar_adresseFournisseur() {
      return this.var_adresseFournisseur;
   }

   public void setVar_adresseFournisseur(String var1) {
      this.var_adresseFournisseur = var1;
   }

   public double getSolde() {
      this.solde = this.trtMontant - this.trtTotalReglement;
      return this.solde;
   }

   public void setSolde(double var1) {
      this.solde = var1;
   }

   public String getVar_lib_nat() {
      return this.var_lib_nat;
   }

   public void setVar_lib_nat(String var1) {
      this.var_lib_nat = var1;
   }

   public String getVar_etat() {
      if (this.trtEtat == 0) {
         this.var_etat = "En cours";
      } else if (this.trtEtat == 1) {
         this.var_etat = "Validé";
      } else if (this.trtEtat == 2) {
         this.var_etat = "Gelé";
      } else if (this.trtEtat == 3) {
         this.var_etat = "Annulé";
      } else if (this.trtEtat == 4) {
         this.var_etat = "Exécuté";
      }

      return this.var_etat;
   }

   public void setVar_etat(String var1) {
      this.var_etat = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public String getTrtActivite() {
      return this.trtActivite;
   }

   public void setTrtActivite(String var1) {
      this.trtActivite = var1;
   }

   public String getTrtBanque() {
      return this.trtBanque;
   }

   public void setTrtBanque(String var1) {
      this.trtBanque = var1;
   }

   public String getTrtBudget() {
      return this.trtBudget;
   }

   public void setTrtBudget(String var1) {
      this.trtBudget = var1;
   }

   public Date getTrtDateCreat() {
      return this.trtDateCreat;
   }

   public void setTrtDateCreat(Date var1) {
      this.trtDateCreat = var1;
   }

   public Date getTrtDateDebut() {
      return this.trtDateDebut;
   }

   public void setTrtDateDebut(Date var1) {
      this.trtDateDebut = var1;
   }

   public Date getTrtDateContrat() {
      return this.trtDateContrat;
   }

   public void setTrtDateContrat(Date var1) {
      this.trtDateContrat = var1;
   }

   public Date getTrtDateImpression() {
      return this.trtDateImpression;
   }

   public void setTrtDateImpression(Date var1) {
      this.trtDateImpression = var1;
   }

   public Date getTrtDateModif() {
      return this.trtDateModif;
   }

   public void setTrtDateModif(Date var1) {
      this.trtDateModif = var1;
   }

   public Date getTrtDateValide() {
      return this.trtDateValide;
   }

   public void setTrtDateValide(Date var1) {
      this.trtDateValide = var1;
   }

   public String getTrtDepartement() {
      return this.trtDepartement;
   }

   public void setTrtDepartement(String var1) {
      this.trtDepartement = var1;
   }

   public String getTrtDevise() {
      return this.trtDevise;
   }

   public void setTrtDevise(String var1) {
      this.trtDevise = var1;
   }

   public String getTrtDossier() {
      return this.trtDossier;
   }

   public void setTrtDossier(String var1) {
      this.trtDossier = var1;
   }

   public int getTrtEtat() {
      return this.trtEtat;
   }

   public void setTrtEtat(int var1) {
      this.trtEtat = var1;
   }

   public String getTrtEtatVal() {
      return this.trtEtatVal;
   }

   public void setTrtEtatVal(String var1) {
      this.trtEtatVal = var1;
   }

   public String getTrtFacture() {
      return this.trtFacture;
   }

   public void setTrtFacture(String var1) {
      this.trtFacture = var1;
   }

   public String getTrtGele() {
      return this.trtGele;
   }

   public void setTrtGele(String var1) {
      this.trtGele = var1;
   }

   public long getTrtId() {
      return this.trtId;
   }

   public void setTrtId(long var1) {
      this.trtId = var1;
   }

   public long getTrtIdResponsable() {
      return this.trtIdResponsable;
   }

   public void setTrtIdResponsable(long var1) {
      this.trtIdResponsable = var1;
   }

   public String getTrtModeleImp() {
      return this.trtModeleImp;
   }

   public void setTrtModeleImp(String var1) {
      this.trtModeleImp = var1;
   }

   public double getTrtMontant() {
      return this.trtMontant;
   }

   public void setTrtMontant(double var1) {
      this.trtMontant = var1;
   }

   public double getTrtMontantFinal() {
      return this.trtMontantFinal;
   }

   public void setTrtMontantFinal(double var1) {
      this.trtMontantFinal = var1;
   }

   public double getTrtMontantGene() {
      return this.trtMontantGene;
   }

   public void setTrtMontantGene(double var1) {
      this.trtMontantGene = var1;
   }

   public int getTrtNature() {
      return this.trtNature;
   }

   public void setTrtNature(int var1) {
      this.trtNature = var1;
   }

   public int getTrtNbMoisEcheanceGene() {
      return this.trtNbMoisEcheanceGene;
   }

   public void setTrtNbMoisEcheanceGene(int var1) {
      this.trtNbMoisEcheanceGene = var1;
   }

   public String getTrtNomResponsable() {
      return this.trtNomResponsable;
   }

   public void setTrtNomResponsable(String var1) {
      this.trtNomResponsable = var1;
   }

   public String getTrtNum() {
      return this.trtNum;
   }

   public void setTrtNum(String var1) {
      this.trtNum = var1;
   }

   public String getTrtObjet() {
      return this.trtObjet;
   }

   public void setTrtObjet(String var1) {
      this.trtObjet = var1;
   }

   public String getTrtPdv() {
      return this.trtPdv;
   }

   public void setTrtPdv(String var1) {
      this.trtPdv = var1;
   }

   public String getTrtRegion() {
      return this.trtRegion;
   }

   public void setTrtRegion(String var1) {
      this.trtRegion = var1;
   }

   public String getTrtSecteur() {
      return this.trtSecteur;
   }

   public void setTrtSecteur(String var1) {
      this.trtSecteur = var1;
   }

   public String getTrtService() {
      return this.trtService;
   }

   public void setTrtService(String var1) {
      this.trtService = var1;
   }

   public String getTrtSite() {
      return this.trtSite;
   }

   public void setTrtSite(String var1) {
      this.trtSite = var1;
   }

   public long getTrtUserCreat() {
      return this.trtUserCreat;
   }

   public void setTrtUserCreat(long var1) {
      this.trtUserCreat = var1;
   }

   public long getTrtUserModif() {
      return this.trtUserModif;
   }

   public void setTrtUserModif(long var1) {
      this.trtUserModif = var1;
   }

   public long getTrtIdTiers() {
      return this.trtIdTiers;
   }

   public void setTrtIdTiers(long var1) {
      this.trtIdTiers = var1;
   }

   public String getTrtNomTiers() {
      if (this.trtNomTiers != null && !this.trtNomTiers.isEmpty()) {
         this.trtNomTiers = this.trtNomTiers.toUpperCase();
      }

      return this.trtNomTiers;
   }

   public void setTrtNomTiers(String var1) {
      this.trtNomTiers = var1;
   }

   public int getTrtTypeTiers() {
      return this.trtTypeTiers;
   }

   public void setTrtTypeTiers(int var1) {
      this.trtTypeTiers = var1;
   }

   public int getTrtDuree() {
      return this.trtDuree;
   }

   public void setTrtDuree(int var1) {
      this.trtDuree = var1;
   }

   public int getTrtPeriodicite() {
      return this.trtPeriodicite;
   }

   public void setTrtPeriodicite(int var1) {
      this.trtPeriodicite = var1;
   }

   public double getTrtTotalReglement() {
      return this.trtTotalReglement;
   }

   public void setTrtTotalReglement(double var1) {
      this.trtTotalReglement = var1;
   }

   public long getTrtIdBanque() {
      return this.trtIdBanque;
   }

   public void setTrtIdBanque(long var1) {
      this.trtIdBanque = var1;
   }

   public String getVar_adresseBanque() {
      return this.var_adresseBanque;
   }

   public void setVar_adresseBanque(String var1) {
      this.var_adresseBanque = var1;
   }

   public String getVar_banque() {
      return this.var_banque;
   }

   public void setVar_banque(String var1) {
      this.var_banque = var1;
   }

   public String getVar_compte() {
      return this.var_compte;
   }

   public void setVar_compte(String var1) {
      this.var_compte = var1;
   }

   public String getVar_nomBanquier() {
      return this.var_nomBanquier;
   }

   public void setVar_nomBanquier(String var1) {
      this.var_nomBanquier = var1;
   }

   public String getVar_villeBanque() {
      return this.var_villeBanque;
   }

   public void setVar_villeBanque(String var1) {
      this.var_villeBanque = var1;
   }

   public String getTrtBateau() {
      return this.trtBateau;
   }

   public void setTrtBateau(String var1) {
      this.trtBateau = var1;
   }

   public float getTrtCoef() {
      return this.trtCoef;
   }

   public void setTrtCoef(float var1) {
      this.trtCoef = var1;
   }

   public double getTrtMontantFinalLocal() {
      return this.trtMontantFinalLocal;
   }

   public void setTrtMontantFinalLocal(double var1) {
      this.trtMontantFinalLocal = var1;
   }

   public double getTrtMontantGeneLocal() {
      return this.trtMontantGeneLocal;
   }

   public void setTrtMontantGeneLocal(double var1) {
      this.trtMontantGeneLocal = var1;
   }

   public double getTrtMontantLocal() {
      return this.trtMontantLocal;
   }

   public void setTrtMontantLocal(double var1) {
      this.trtMontantLocal = var1;
   }

   public double getTrtTotalReglementLocal() {
      return this.trtTotalReglementLocal;
   }

   public void setTrtTotalReglementLocal(double var1) {
      this.trtTotalReglementLocal = var1;
   }
}
