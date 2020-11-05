package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.Date;

public class TransfertCompta implements Serializable {
   private long trfIdOrigine;
   private String trfTypeOrigine;
   private int trfNature;
   private int trfCategorie;
   private String trfCode;
   private Date trfDateSaisie;
   private String trfPeriode;
   private String trfCompte;
   private String trfCp;
   private double trfDebitSaisie;
   private double trfCreditSaisie;
   private double trfDebitMvts;
   private double trfCreditMvts;
   private Date trfDateEcheance;
   private Date trfDateValeurTheo;
   private String trfLibelle;
   private String trfPiece;
   private String trfReference1;
   private String trfReference2;
   private String trfLettre;
   private String trfTreso;
   private String trfSite;
   private String trfDepartement;
   private String trfService;
   private String trfRegion;
   private String trfSecteur;
   private String trfPdv;
   private String trfDossier;
   private String trfParc;
   private String trfCle1;
   private String trfActivite;
   private String trfAnal1;
   private String trfAnal3;
   private String trfProjet;
   private String trfBudget;
   private String trfAgent;
   private String trfRepartitionCle1;
   private String trfRepartitionCle2;
   private String trfSitePrd;
   private String trfLigne;
   private String trfAtelier;
   private String trfMission;
   private String trfChantier;
   private String trfStructure;
   private int trfModeReglement;
   private String trfSuite;
   private String trfTypeImport;
   private long trfIdResponsable;
   private String trfNomResponsable;
   private String trfErreur;
   private int modeErreur;

   public String getTrfActivite() {
      return this.trfActivite;
   }

   public void setTrfActivite(String var1) {
      this.trfActivite = var1;
   }

   public String getTrfBudget() {
      return this.trfBudget;
   }

   public void setTrfBudget(String var1) {
      this.trfBudget = var1;
   }

   public String getTrfCode() {
      return this.trfCode;
   }

   public void setTrfCode(String var1) {
      this.trfCode = var1;
   }

   public String getTrfCompte() {
      return this.trfCompte;
   }

   public void setTrfCompte(String var1) {
      this.trfCompte = var1;
   }

   public double getTrfCreditSaisie() {
      return this.trfCreditSaisie;
   }

   public void setTrfCreditSaisie(double var1) {
      this.trfCreditSaisie = var1;
   }

   public Date getTrfDateEcheance() {
      return this.trfDateEcheance;
   }

   public void setTrfDateEcheance(Date var1) {
      this.trfDateEcheance = var1;
   }

   public Date getTrfDateSaisie() {
      return this.trfDateSaisie;
   }

   public void setTrfDateSaisie(Date var1) {
      this.trfDateSaisie = var1;
   }

   public Date getTrfDateValeurTheo() {
      return this.trfDateValeurTheo;
   }

   public void setTrfDateValeurTheo(Date var1) {
      this.trfDateValeurTheo = var1;
   }

   public double getTrfDebitSaisie() {
      return this.trfDebitSaisie;
   }

   public void setTrfDebitSaisie(double var1) {
      this.trfDebitSaisie = var1;
   }

   public String getTrfDepartement() {
      return this.trfDepartement;
   }

   public void setTrfDepartement(String var1) {
      this.trfDepartement = var1;
   }

   public String getTrfLibelle() {
      return this.trfLibelle;
   }

   public void setTrfLibelle(String var1) {
      this.trfLibelle = var1;
   }

   public String getTrfPdv() {
      return this.trfPdv;
   }

   public void setTrfPdv(String var1) {
      this.trfPdv = var1;
   }

   public String getTrfPeriode() {
      return this.trfPeriode;
   }

   public void setTrfPeriode(String var1) {
      this.trfPeriode = var1;
   }

   public String getTrfPiece() {
      return this.trfPiece;
   }

   public void setTrfPiece(String var1) {
      this.trfPiece = var1;
   }

   public String getTrfProjet() {
      return this.trfProjet;
   }

   public void setTrfProjet(String var1) {
      this.trfProjet = var1;
   }

   public String getTrfReference1() {
      return this.trfReference1;
   }

   public void setTrfReference1(String var1) {
      this.trfReference1 = var1;
   }

   public String getTrfReference2() {
      return this.trfReference2;
   }

   public void setTrfReference2(String var1) {
      this.trfReference2 = var1;
   }

   public String getTrfRegion() {
      return this.trfRegion;
   }

   public void setTrfRegion(String var1) {
      this.trfRegion = var1;
   }

   public String getTrfSecteur() {
      return this.trfSecteur;
   }

   public void setTrfSecteur(String var1) {
      this.trfSecteur = var1;
   }

   public String getTrfService() {
      return this.trfService;
   }

   public void setTrfService(String var1) {
      this.trfService = var1;
   }

   public String getTrfSite() {
      return this.trfSite;
   }

   public void setTrfSite(String var1) {
      this.trfSite = var1;
   }

   public String getTrfTreso() {
      return this.trfTreso;
   }

   public void setTrfTreso(String var1) {
      this.trfTreso = var1;
   }

   public long getTrfIdOrigine() {
      return this.trfIdOrigine;
   }

   public void setTrfIdOrigine(long var1) {
      this.trfIdOrigine = var1;
   }

   public String getTrfTypeOrigine() {
      return this.trfTypeOrigine;
   }

   public void setTrfTypeOrigine(String var1) {
      this.trfTypeOrigine = var1;
   }

   public String getTrfAgent() {
      return this.trfAgent;
   }

   public void setTrfAgent(String var1) {
      this.trfAgent = var1;
   }

   public String getTrfCle1() {
      return this.trfCle1;
   }

   public void setTrfCle1(String var1) {
      this.trfCle1 = var1;
   }

   public String getTrfDossier() {
      return this.trfDossier;
   }

   public void setTrfDossier(String var1) {
      this.trfDossier = var1;
   }

   public String getTrfParc() {
      return this.trfParc;
   }

   public void setTrfParc(String var1) {
      this.trfParc = var1;
   }

   public String getTrfRepartitionCle1() {
      return this.trfRepartitionCle1;
   }

   public void setTrfRepartitionCle1(String var1) {
      this.trfRepartitionCle1 = var1;
   }

   public String getTrfRepartitionCle2() {
      return this.trfRepartitionCle2;
   }

   public void setTrfRepartitionCle2(String var1) {
      this.trfRepartitionCle2 = var1;
   }

   public int getTrfCategorie() {
      return this.trfCategorie;
   }

   public void setTrfCategorie(int var1) {
      this.trfCategorie = var1;
   }

   public int getTrfNature() {
      return this.trfNature;
   }

   public void setTrfNature(int var1) {
      this.trfNature = var1;
   }

   public int getTrfModeReglement() {
      return this.trfModeReglement;
   }

   public void setTrfModeReglement(int var1) {
      this.trfModeReglement = var1;
   }

   public String getTrfSuite() {
      return this.trfSuite;
   }

   public void setTrfSuite(String var1) {
      this.trfSuite = var1;
   }

   public String getTrfTypeImport() {
      return this.trfTypeImport;
   }

   public void setTrfTypeImport(String var1) {
      this.trfTypeImport = var1;
   }

   public String getTrfAnal1() {
      return this.trfAnal1;
   }

   public void setTrfAnal1(String var1) {
      this.trfAnal1 = var1;
   }

   public String getTrfAnal3() {
      return this.trfAnal3;
   }

   public void setTrfAnal3(String var1) {
      this.trfAnal3 = var1;
   }

   public double getTrfCreditMvts() {
      return this.trfCreditMvts;
   }

   public void setTrfCreditMvts(double var1) {
      this.trfCreditMvts = var1;
   }

   public double getTrfDebitMvts() {
      return this.trfDebitMvts;
   }

   public void setTrfDebitMvts(double var1) {
      this.trfDebitMvts = var1;
   }

   public String getTrfCp() {
      return this.trfCp;
   }

   public void setTrfCp(String var1) {
      this.trfCp = var1;
   }

   public String getTrfLettre() {
      return this.trfLettre;
   }

   public void setTrfLettre(String var1) {
      this.trfLettre = var1;
   }

   public String getTrfAtelier() {
      return this.trfAtelier;
   }

   public void setTrfAtelier(String var1) {
      this.trfAtelier = var1;
   }

   public String getTrfLigne() {
      return this.trfLigne;
   }

   public void setTrfLigne(String var1) {
      this.trfLigne = var1;
   }

   public String getTrfSitePrd() {
      return this.trfSitePrd;
   }

   public void setTrfSitePrd(String var1) {
      this.trfSitePrd = var1;
   }

   public String getTrfChantier() {
      return this.trfChantier;
   }

   public void setTrfChantier(String var1) {
      this.trfChantier = var1;
   }

   public String getTrfMission() {
      return this.trfMission;
   }

   public void setTrfMission(String var1) {
      this.trfMission = var1;
   }

   public String getTrfStructure() {
      return this.trfStructure;
   }

   public void setTrfStructure(String var1) {
      this.trfStructure = var1;
   }

   public long getTrfIdResponsable() {
      return this.trfIdResponsable;
   }

   public void setTrfIdResponsable(long var1) {
      this.trfIdResponsable = var1;
   }

   public String getTrfNomResponsable() {
      return this.trfNomResponsable;
   }

   public void setTrfNomResponsable(String var1) {
      this.trfNomResponsable = var1;
   }

   public String getTrfErreur() {
      return this.trfErreur;
   }

   public void setTrfErreur(String var1) {
      this.trfErreur = var1;
   }

   public int getModeErreur() {
      return this.modeErreur;
   }

   public void setModeErreur(int var1) {
      this.modeErreur = var1;
   }
}
