package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SimulationEnteteVentes implements Serializable {
   private long simcrtId;
   private Date simcrtDateCreat;
   private String simcrtNum;
   private long simcrtIdCreateur;
   private String simcrtNomCreateur;
   private Date simcrtDateModif;
   private long simcrtIdModif;
   private String simcrtNomModif;
   private String simcrtNomEquipe;
   private long simcrtIdEquipe;
   private long simcrtIdResponsable;
   private String simcrtNomResponsable;
   private String simcrtNomCommercial;
   private long simcrtIdCommercial;
   private String simcrtNomTiers;
   private String simcrtCivilTiers;
   private long simcrtIdContact;
   private String simcrtNomContact;
   private String simcrtCivilContact;
   private String simcrtSerie;
   private int simcrtExoTva;
   private int simcrtExoDouane;
   private String simcrtCat;
   private String simcrtDevise;
   private String simcrtObject;
   private String simcrtObservation;
   private double simcrtTotHt;
   private double simcrtTotTva;
   private double simcrtTotTc;
   private double simcrtTotTtc;
   private String simcrtActivite;
   private String simcrtSite;
   private String simcrtDepartement;
   private String simcrtService;
   private String simcrtRegion;
   private String simcrtSecteur;
   private String simcrtPdv;
   private String simcrtAnal2;
   private String simcrtAnal4;
   private String simcrtInfo1;
   private String simcrtInfo2;
   private String simcrtInfo3;
   private String simcrtInfo4;
   private String simcrtInfo5;
   private String simcrtInfo6;
   private String simcrtInfo7;
   private String simcrtInfo8;
   private String simcrtInfo9;
   private String simcrtInfo10;
   private String simcrtFormule1;
   private String simcrtFormule2;
   private String simcrtAnnexe1;
   private String simcrtAnnexe2;
   private String simcrtContrat;
   private String simcrtIncoterm;
   private String simcrtLieuLivraison;
   private Date simcrtDateLivraison;
   private String simcrtInfoLivraison;
   private Date simcrtDateImp;
   private String simcrtModeleImp;
   private String simcrtGarde;
   private int simcrtEtatVal;
   private int simcrtGele;
   private int simcrtEtat;
   private Date simcrtDateValidite;
   private Date simcrtDateRelance;
   private Date simcrtDateValide;
   private int simcrtPosSignature;
   private Date simcrtDateTransforme;
   private int simcrtTypeTransforme;
   private Date simcrtDateAnnule;
   private String simcrtMotifAnnule;
   private Date simcrtDate;
   private String simcrtTypeContrat;
   private String simcrtCode;
   private String simcrtMarque;
   private String simcrtGamme;
   private String simcrtModele;
   private String simcrtTaxe;
   private float simcrtTauxTaxe;
   private double simcrtPrc;
   private double simcrtRemise;
   private double simcrtPrg;
   private double simcrtAccessoire;
   private double simcrtAcompte;
   private double simcrtBase;
   private double simcrtAmortissement;
   private double simcrtFraisFinancier;
   private double simcrtEntretien;
   private double simcrtAssurance;
   private double simcrtFranchise;
   private double simcrtFraisStructure;
   private double simcrtRemplacement;
   private double simcrtRemplissage;
   private double simcrtValeurRachat;
   private double simcrtPr;
   private double simcrtValeurResiduelleTheo;
   private double simcrtValeurResiduelleReelle;
   private int simcrtDureeMin;
   private int simcrtDureeMax;
   private int simcrtNbMois;
   private double simcrtThMois;
   private double simcrtTxMois;
   private double simcrtTtMois;
   private double simcrtCumulEcheance;
   private float simcrtTauxValeurResiduelle;
   private float simcrtTauxAmortissement;
   private float simcrtTauxFraisFinancier;
   private float simcrtTauxEntretien;
   private float simcrtTauxAssurance;
   private float simcrtTauxFranchise;
   private float simcrtTauxFraisStructure;
   private float simcrtTauxRemplacement;
   private float simcrtTauxRemplissage;
   private float simcrtTauxMarge;
   private float simcrtTauxRemise;
   private int simcrtDiversTiers;
   private String simcrtDiversNom;
   private String simcrtDiversAdresse;
   private String simcrtDiversVille;
   private String simcrtDiversTel;
   private String simcrtDiversMail;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private boolean var_select_ligne;
   private int var_format_devise;
   private String var_photo;
   private String var_descriptif;
   private String var_suite;
   private String var_condition;
   private String var_nomContact;
   private String var_nom_tiers;

   public String getVar_nom_tiers() {
      if (this.simcrtDiversNom != null && !this.simcrtDiversNom.isEmpty()) {
         this.var_nom_tiers = this.simcrtDiversNom;
      } else if (this.simcrtCivilTiers != null && !this.simcrtCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.simcrtCivilTiers + " " + this.simcrtNomTiers;
      } else {
         this.var_nom_tiers = this.simcrtNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.simcrtDiversNom != null && !this.simcrtDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.simcrtCivilContact != null && !this.simcrtCivilContact.isEmpty()) {
         this.var_nomContact = this.simcrtCivilContact + " " + this.simcrtNomContact;
      } else {
         this.var_nomContact = this.simcrtNomContact;
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.simcrtEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.simcrtEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.simcrtEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.simcrtEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.simcrtEtat == 4) {
         this.libelleEta = "Trf.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public int getVar_format_devise() {
      if (!this.simcrtDevise.equals("XOF") && !this.simcrtDevise.equals("XAF")) {
         if (!this.simcrtDevise.equals("EUR") && !this.simcrtDevise.equals("XEU") && !this.simcrtDevise.equals("CHF")) {
            this.var_format_devise = 0;
         } else {
            this.var_format_devise = 1;
         }
      } else {
         this.var_format_devise = 2;
      }

      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public String getVar_photo() {
      return this.var_photo;
   }

   public void setVar_photo(String var1) {
      this.var_photo = var1;
   }

   public String getVar_descriptif() {
      return this.var_descriptif;
   }

   public void setVar_descriptif(String var1) {
      this.var_descriptif = var1;
   }

   public String getVar_condition() {
      return this.var_condition;
   }

   public void setVar_condition(String var1) {
      this.var_condition = var1;
   }

   public String getVar_suite() {
      return this.var_suite;
   }

   public void setVar_suite(String var1) {
      this.var_suite = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public double getSimcrtAccessoire() {
      return this.simcrtAccessoire;
   }

   public void setSimcrtAccessoire(double var1) {
      this.simcrtAccessoire = var1;
   }

   public double getSimcrtAcompte() {
      return this.simcrtAcompte;
   }

   public void setSimcrtAcompte(double var1) {
      this.simcrtAcompte = var1;
   }

   public String getSimcrtActivite() {
      return this.simcrtActivite;
   }

   public void setSimcrtActivite(String var1) {
      this.simcrtActivite = var1;
   }

   public String getSimcrtAnal2() {
      return this.simcrtAnal2;
   }

   public void setSimcrtAnal2(String var1) {
      this.simcrtAnal2 = var1;
   }

   public String getSimcrtAnal4() {
      return this.simcrtAnal4;
   }

   public void setSimcrtAnal4(String var1) {
      this.simcrtAnal4 = var1;
   }

   public String getSimcrtAnnexe1() {
      return this.simcrtAnnexe1;
   }

   public void setSimcrtAnnexe1(String var1) {
      this.simcrtAnnexe1 = var1;
   }

   public String getSimcrtAnnexe2() {
      return this.simcrtAnnexe2;
   }

   public void setSimcrtAnnexe2(String var1) {
      this.simcrtAnnexe2 = var1;
   }

   public String getSimcrtCat() {
      return this.simcrtCat;
   }

   public void setSimcrtCat(String var1) {
      this.simcrtCat = var1;
   }

   public String getSimcrtCivilContact() {
      return this.simcrtCivilContact;
   }

   public void setSimcrtCivilContact(String var1) {
      this.simcrtCivilContact = var1;
   }

   public String getSimcrtCivilTiers() {
      return this.simcrtCivilTiers;
   }

   public void setSimcrtCivilTiers(String var1) {
      this.simcrtCivilTiers = var1;
   }

   public String getSimcrtCode() {
      return this.simcrtCode;
   }

   public void setSimcrtCode(String var1) {
      this.simcrtCode = var1;
   }

   public String getSimcrtContrat() {
      return this.simcrtContrat;
   }

   public void setSimcrtContrat(String var1) {
      this.simcrtContrat = var1;
   }

   public double getSimcrtCumulEcheance() {
      return this.simcrtCumulEcheance;
   }

   public void setSimcrtCumulEcheance(double var1) {
      this.simcrtCumulEcheance = var1;
   }

   public Date getSimcrtDate() {
      return this.simcrtDate;
   }

   public void setSimcrtDate(Date var1) {
      this.simcrtDate = var1;
   }

   public Date getSimcrtDateAnnule() {
      return this.simcrtDateAnnule;
   }

   public void setSimcrtDateAnnule(Date var1) {
      this.simcrtDateAnnule = var1;
   }

   public Date getSimcrtDateCreat() {
      return this.simcrtDateCreat;
   }

   public void setSimcrtDateCreat(Date var1) {
      this.simcrtDateCreat = var1;
   }

   public Date getSimcrtDateImp() {
      return this.simcrtDateImp;
   }

   public void setSimcrtDateImp(Date var1) {
      this.simcrtDateImp = var1;
   }

   public Date getSimcrtDateLivraison() {
      return this.simcrtDateLivraison;
   }

   public void setSimcrtDateLivraison(Date var1) {
      this.simcrtDateLivraison = var1;
   }

   public Date getSimcrtDateModif() {
      return this.simcrtDateModif;
   }

   public void setSimcrtDateModif(Date var1) {
      this.simcrtDateModif = var1;
   }

   public Date getSimcrtDateRelance() {
      return this.simcrtDateRelance;
   }

   public void setSimcrtDateRelance(Date var1) {
      this.simcrtDateRelance = var1;
   }

   public Date getSimcrtDateTransforme() {
      return this.simcrtDateTransforme;
   }

   public void setSimcrtDateTransforme(Date var1) {
      this.simcrtDateTransforme = var1;
   }

   public Date getSimcrtDateValide() {
      return this.simcrtDateValide;
   }

   public void setSimcrtDateValide(Date var1) {
      this.simcrtDateValide = var1;
   }

   public Date getSimcrtDateValidite() {
      return this.simcrtDateValidite;
   }

   public void setSimcrtDateValidite(Date var1) {
      this.simcrtDateValidite = var1;
   }

   public String getSimcrtDepartement() {
      return this.simcrtDepartement;
   }

   public void setSimcrtDepartement(String var1) {
      this.simcrtDepartement = var1;
   }

   public String getSimcrtDevise() {
      return this.simcrtDevise;
   }

   public void setSimcrtDevise(String var1) {
      this.simcrtDevise = var1;
   }

   public int getSimcrtEtat() {
      return this.simcrtEtat;
   }

   public void setSimcrtEtat(int var1) {
      this.simcrtEtat = var1;
   }

   public int getSimcrtEtatVal() {
      return this.simcrtEtatVal;
   }

   public void setSimcrtEtatVal(int var1) {
      this.simcrtEtatVal = var1;
   }

   public int getSimcrtExoDouane() {
      return this.simcrtExoDouane;
   }

   public void setSimcrtExoDouane(int var1) {
      this.simcrtExoDouane = var1;
   }

   public int getSimcrtExoTva() {
      return this.simcrtExoTva;
   }

   public void setSimcrtExoTva(int var1) {
      this.simcrtExoTva = var1;
   }

   public String getSimcrtFormule1() {
      return this.simcrtFormule1;
   }

   public void setSimcrtFormule1(String var1) {
      this.simcrtFormule1 = var1;
   }

   public String getSimcrtFormule2() {
      return this.simcrtFormule2;
   }

   public void setSimcrtFormule2(String var1) {
      this.simcrtFormule2 = var1;
   }

   public String getSimcrtGamme() {
      return this.simcrtGamme;
   }

   public void setSimcrtGamme(String var1) {
      this.simcrtGamme = var1;
   }

   public String getSimcrtGarde() {
      return this.simcrtGarde;
   }

   public void setSimcrtGarde(String var1) {
      this.simcrtGarde = var1;
   }

   public int getSimcrtGele() {
      return this.simcrtGele;
   }

   public void setSimcrtGele(int var1) {
      this.simcrtGele = var1;
   }

   public long getSimcrtId() {
      return this.simcrtId;
   }

   public void setSimcrtId(long var1) {
      this.simcrtId = var1;
   }

   public long getSimcrtIdContact() {
      return this.simcrtIdContact;
   }

   public void setSimcrtIdContact(long var1) {
      this.simcrtIdContact = var1;
   }

   public long getSimcrtIdCreateur() {
      return this.simcrtIdCreateur;
   }

   public void setSimcrtIdCreateur(long var1) {
      this.simcrtIdCreateur = var1;
   }

   public long getSimcrtIdModif() {
      return this.simcrtIdModif;
   }

   public void setSimcrtIdModif(long var1) {
      this.simcrtIdModif = var1;
   }

   public long getSimcrtIdResponsable() {
      return this.simcrtIdResponsable;
   }

   public void setSimcrtIdResponsable(long var1) {
      this.simcrtIdResponsable = var1;
   }

   public String getSimcrtIncoterm() {
      return this.simcrtIncoterm;
   }

   public void setSimcrtIncoterm(String var1) {
      this.simcrtIncoterm = var1;
   }

   public String getSimcrtInfo1() {
      return this.simcrtInfo1;
   }

   public void setSimcrtInfo1(String var1) {
      this.simcrtInfo1 = var1;
   }

   public String getSimcrtInfo10() {
      return this.simcrtInfo10;
   }

   public void setSimcrtInfo10(String var1) {
      this.simcrtInfo10 = var1;
   }

   public String getSimcrtInfo2() {
      return this.simcrtInfo2;
   }

   public void setSimcrtInfo2(String var1) {
      this.simcrtInfo2 = var1;
   }

   public String getSimcrtInfo3() {
      return this.simcrtInfo3;
   }

   public void setSimcrtInfo3(String var1) {
      this.simcrtInfo3 = var1;
   }

   public String getSimcrtInfo4() {
      return this.simcrtInfo4;
   }

   public void setSimcrtInfo4(String var1) {
      this.simcrtInfo4 = var1;
   }

   public String getSimcrtInfo5() {
      return this.simcrtInfo5;
   }

   public void setSimcrtInfo5(String var1) {
      this.simcrtInfo5 = var1;
   }

   public String getSimcrtInfo6() {
      return this.simcrtInfo6;
   }

   public void setSimcrtInfo6(String var1) {
      this.simcrtInfo6 = var1;
   }

   public String getSimcrtInfo7() {
      return this.simcrtInfo7;
   }

   public void setSimcrtInfo7(String var1) {
      this.simcrtInfo7 = var1;
   }

   public String getSimcrtInfo8() {
      return this.simcrtInfo8;
   }

   public void setSimcrtInfo8(String var1) {
      this.simcrtInfo8 = var1;
   }

   public String getSimcrtInfo9() {
      return this.simcrtInfo9;
   }

   public void setSimcrtInfo9(String var1) {
      this.simcrtInfo9 = var1;
   }

   public String getSimcrtInfoLivraison() {
      return this.simcrtInfoLivraison;
   }

   public void setSimcrtInfoLivraison(String var1) {
      this.simcrtInfoLivraison = var1;
   }

   public String getSimcrtLieuLivraison() {
      return this.simcrtLieuLivraison;
   }

   public void setSimcrtLieuLivraison(String var1) {
      this.simcrtLieuLivraison = var1;
   }

   public String getSimcrtMarque() {
      return this.simcrtMarque;
   }

   public void setSimcrtMarque(String var1) {
      this.simcrtMarque = var1;
   }

   public String getSimcrtModele() {
      return this.simcrtModele;
   }

   public void setSimcrtModele(String var1) {
      this.simcrtModele = var1;
   }

   public String getSimcrtModeleImp() {
      return this.simcrtModeleImp;
   }

   public void setSimcrtModeleImp(String var1) {
      this.simcrtModeleImp = var1;
   }

   public String getSimcrtMotifAnnule() {
      return this.simcrtMotifAnnule;
   }

   public void setSimcrtMotifAnnule(String var1) {
      this.simcrtMotifAnnule = var1;
   }

   public int getSimcrtNbMois() {
      return this.simcrtNbMois;
   }

   public void setSimcrtNbMois(int var1) {
      this.simcrtNbMois = var1;
   }

   public String getSimcrtNomContact() {
      if (this.simcrtNomContact != null && !this.simcrtNomContact.isEmpty()) {
         this.simcrtNomContact = this.simcrtNomContact.toUpperCase();
      }

      return this.simcrtNomContact;
   }

   public void setSimcrtNomContact(String var1) {
      this.simcrtNomContact = var1;
   }

   public String getSimcrtNomCreateur() {
      return this.simcrtNomCreateur;
   }

   public void setSimcrtNomCreateur(String var1) {
      this.simcrtNomCreateur = var1;
   }

   public String getSimcrtNomModif() {
      return this.simcrtNomModif;
   }

   public void setSimcrtNomModif(String var1) {
      this.simcrtNomModif = var1;
   }

   public String getSimcrtNomResponsable() {
      return this.simcrtNomResponsable;
   }

   public void setSimcrtNomResponsable(String var1) {
      this.simcrtNomResponsable = var1;
   }

   public String getSimcrtNomTiers() {
      return this.simcrtNomTiers;
   }

   public void setSimcrtNomTiers(String var1) {
      this.simcrtNomTiers = var1;
   }

   public String getSimcrtNum() {
      return this.simcrtNum;
   }

   public void setSimcrtNum(String var1) {
      this.simcrtNum = var1;
   }

   public String getSimcrtObject() {
      return this.simcrtObject;
   }

   public void setSimcrtObject(String var1) {
      this.simcrtObject = var1;
   }

   public String getSimcrtObservation() {
      return this.simcrtObservation;
   }

   public void setSimcrtObservation(String var1) {
      this.simcrtObservation = var1;
   }

   public String getSimcrtPdv() {
      return this.simcrtPdv;
   }

   public void setSimcrtPdv(String var1) {
      this.simcrtPdv = var1;
   }

   public double getSimcrtPrc() {
      return this.simcrtPrc;
   }

   public void setSimcrtPrc(double var1) {
      this.simcrtPrc = var1;
   }

   public double getSimcrtPrg() {
      return this.simcrtPrg;
   }

   public void setSimcrtPrg(double var1) {
      this.simcrtPrg = var1;
   }

   public String getSimcrtRegion() {
      return this.simcrtRegion;
   }

   public void setSimcrtRegion(String var1) {
      this.simcrtRegion = var1;
   }

   public double getSimcrtRemise() {
      return this.simcrtRemise;
   }

   public void setSimcrtRemise(double var1) {
      this.simcrtRemise = var1;
   }

   public String getSimcrtSecteur() {
      return this.simcrtSecteur;
   }

   public void setSimcrtSecteur(String var1) {
      this.simcrtSecteur = var1;
   }

   public String getSimcrtSerie() {
      return this.simcrtSerie;
   }

   public void setSimcrtSerie(String var1) {
      this.simcrtSerie = var1;
   }

   public String getSimcrtService() {
      return this.simcrtService;
   }

   public void setSimcrtService(String var1) {
      this.simcrtService = var1;
   }

   public String getSimcrtSite() {
      return this.simcrtSite;
   }

   public void setSimcrtSite(String var1) {
      this.simcrtSite = var1;
   }

   public float getSimcrtTauxAmortissement() {
      return this.simcrtTauxAmortissement;
   }

   public void setSimcrtTauxAmortissement(float var1) {
      this.simcrtTauxAmortissement = var1;
   }

   public float getSimcrtTauxAssurance() {
      return this.simcrtTauxAssurance;
   }

   public void setSimcrtTauxAssurance(float var1) {
      this.simcrtTauxAssurance = var1;
   }

   public float getSimcrtTauxEntretien() {
      return this.simcrtTauxEntretien;
   }

   public void setSimcrtTauxEntretien(float var1) {
      this.simcrtTauxEntretien = var1;
   }

   public float getSimcrtTauxFraisFinancier() {
      return this.simcrtTauxFraisFinancier;
   }

   public void setSimcrtTauxFraisFinancier(float var1) {
      this.simcrtTauxFraisFinancier = var1;
   }

   public float getSimcrtTauxFraisStructure() {
      return this.simcrtTauxFraisStructure;
   }

   public void setSimcrtTauxFraisStructure(float var1) {
      this.simcrtTauxFraisStructure = var1;
   }

   public float getSimcrtTauxFranchise() {
      return this.simcrtTauxFranchise;
   }

   public void setSimcrtTauxFranchise(float var1) {
      this.simcrtTauxFranchise = var1;
   }

   public float getSimcrtTauxMarge() {
      return this.simcrtTauxMarge;
   }

   public void setSimcrtTauxMarge(float var1) {
      this.simcrtTauxMarge = var1;
   }

   public float getSimcrtTauxRemplacement() {
      return this.simcrtTauxRemplacement;
   }

   public void setSimcrtTauxRemplacement(float var1) {
      this.simcrtTauxRemplacement = var1;
   }

   public float getSimcrtTauxRemplissage() {
      return this.simcrtTauxRemplissage;
   }

   public void setSimcrtTauxRemplissage(float var1) {
      this.simcrtTauxRemplissage = var1;
   }

   public float getSimcrtTauxTaxe() {
      return this.simcrtTauxTaxe;
   }

   public void setSimcrtTauxTaxe(float var1) {
      this.simcrtTauxTaxe = var1;
   }

   public float getSimcrtTauxValeurResiduelle() {
      return this.simcrtTauxValeurResiduelle;
   }

   public void setSimcrtTauxValeurResiduelle(float var1) {
      this.simcrtTauxValeurResiduelle = var1;
   }

   public String getSimcrtTaxe() {
      return this.simcrtTaxe;
   }

   public void setSimcrtTaxe(String var1) {
      this.simcrtTaxe = var1;
   }

   public double getSimcrtThMois() {
      return this.simcrtThMois;
   }

   public void setSimcrtThMois(double var1) {
      this.simcrtThMois = var1;
   }

   public double getSimcrtTotHt() {
      return this.simcrtTotHt;
   }

   public void setSimcrtTotHt(double var1) {
      this.simcrtTotHt = var1;
   }

   public double getSimcrtTotTc() {
      return this.simcrtTotTc;
   }

   public void setSimcrtTotTc(double var1) {
      this.simcrtTotTc = var1;
   }

   public double getSimcrtTotTtc() {
      return this.simcrtTotTtc;
   }

   public void setSimcrtTotTtc(double var1) {
      this.simcrtTotTtc = var1;
   }

   public double getSimcrtTotTva() {
      return this.simcrtTotTva;
   }

   public void setSimcrtTotTva(double var1) {
      this.simcrtTotTva = var1;
   }

   public double getSimcrtTtMois() {
      return this.simcrtTtMois;
   }

   public void setSimcrtTtMois(double var1) {
      this.simcrtTtMois = var1;
   }

   public double getSimcrtTxMois() {
      return this.simcrtTxMois;
   }

   public void setSimcrtTxMois(double var1) {
      this.simcrtTxMois = var1;
   }

   public String getSimcrtTypeContrat() {
      return this.simcrtTypeContrat;
   }

   public void setSimcrtTypeContrat(String var1) {
      this.simcrtTypeContrat = var1;
   }

   public int getSimcrtTypeTransforme() {
      return this.simcrtTypeTransforme;
   }

   public void setSimcrtTypeTransforme(int var1) {
      this.simcrtTypeTransforme = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getSimcrtDureeMax() {
      return this.simcrtDureeMax;
   }

   public void setSimcrtDureeMax(int var1) {
      this.simcrtDureeMax = var1;
   }

   public int getSimcrtDureeMin() {
      return this.simcrtDureeMin;
   }

   public void setSimcrtDureeMin(int var1) {
      this.simcrtDureeMin = var1;
   }

   public float getSimcrtTauxRemise() {
      return this.simcrtTauxRemise;
   }

   public void setSimcrtTauxRemise(float var1) {
      this.simcrtTauxRemise = var1;
   }

   public double getSimcrtAmortissement() {
      return this.simcrtAmortissement;
   }

   public void setSimcrtAmortissement(double var1) {
      this.simcrtAmortissement = var1;
   }

   public double getSimcrtAssurance() {
      return this.simcrtAssurance;
   }

   public void setSimcrtAssurance(double var1) {
      this.simcrtAssurance = var1;
   }

   public double getSimcrtBase() {
      return this.simcrtBase;
   }

   public void setSimcrtBase(double var1) {
      this.simcrtBase = var1;
   }

   public double getSimcrtEntretien() {
      return this.simcrtEntretien;
   }

   public void setSimcrtEntretien(double var1) {
      this.simcrtEntretien = var1;
   }

   public double getSimcrtFraisFinancier() {
      return this.simcrtFraisFinancier;
   }

   public void setSimcrtFraisFinancier(double var1) {
      this.simcrtFraisFinancier = var1;
   }

   public double getSimcrtFraisStructure() {
      return this.simcrtFraisStructure;
   }

   public void setSimcrtFraisStructure(double var1) {
      this.simcrtFraisStructure = var1;
   }

   public double getSimcrtFranchise() {
      return this.simcrtFranchise;
   }

   public void setSimcrtFranchise(double var1) {
      this.simcrtFranchise = var1;
   }

   public double getSimcrtPr() {
      return this.simcrtPr;
   }

   public void setSimcrtPr(double var1) {
      this.simcrtPr = var1;
   }

   public double getSimcrtRemplacement() {
      return this.simcrtRemplacement;
   }

   public void setSimcrtRemplacement(double var1) {
      this.simcrtRemplacement = var1;
   }

   public double getSimcrtRemplissage() {
      return this.simcrtRemplissage;
   }

   public void setSimcrtRemplissage(double var1) {
      this.simcrtRemplissage = var1;
   }

   public double getSimcrtValeurRachat() {
      return this.simcrtValeurRachat;
   }

   public void setSimcrtValeurRachat(double var1) {
      this.simcrtValeurRachat = var1;
   }

   public double getSimcrtValeurResiduelleReelle() {
      return this.simcrtValeurResiduelleReelle;
   }

   public void setSimcrtValeurResiduelleReelle(double var1) {
      this.simcrtValeurResiduelleReelle = var1;
   }

   public double getSimcrtValeurResiduelleTheo() {
      return this.simcrtValeurResiduelleTheo;
   }

   public void setSimcrtValeurResiduelleTheo(double var1) {
      this.simcrtValeurResiduelleTheo = var1;
   }

   public String getSimcrtDiversAdresse() {
      return this.simcrtDiversAdresse;
   }

   public void setSimcrtDiversAdresse(String var1) {
      this.simcrtDiversAdresse = var1;
   }

   public String getSimcrtDiversMail() {
      return this.simcrtDiversMail;
   }

   public void setSimcrtDiversMail(String var1) {
      this.simcrtDiversMail = var1;
   }

   public String getSimcrtDiversNom() {
      if (this.simcrtDiversNom != null && !this.simcrtDiversNom.isEmpty()) {
         this.simcrtDiversNom = this.simcrtDiversNom.toUpperCase();
      }

      return this.simcrtDiversNom;
   }

   public void setSimcrtDiversNom(String var1) {
      this.simcrtDiversNom = var1;
   }

   public String getSimcrtDiversTel() {
      return this.simcrtDiversTel;
   }

   public void setSimcrtDiversTel(String var1) {
      this.simcrtDiversTel = var1;
   }

   public int getSimcrtDiversTiers() {
      return this.simcrtDiversTiers;
   }

   public void setSimcrtDiversTiers(int var1) {
      this.simcrtDiversTiers = var1;
   }

   public String getSimcrtDiversVille() {
      return this.simcrtDiversVille;
   }

   public void setSimcrtDiversVille(String var1) {
      this.simcrtDiversVille = var1;
   }

   public long getSimcrtIdCommercial() {
      return this.simcrtIdCommercial;
   }

   public void setSimcrtIdCommercial(long var1) {
      this.simcrtIdCommercial = var1;
   }

   public String getSimcrtNomCommercial() {
      return this.simcrtNomCommercial;
   }

   public void setSimcrtNomCommercial(String var1) {
      this.simcrtNomCommercial = var1;
   }

   public long getSimcrtIdEquipe() {
      return this.simcrtIdEquipe;
   }

   public void setSimcrtIdEquipe(long var1) {
      this.simcrtIdEquipe = var1;
   }

   public String getSimcrtNomEquipe() {
      return this.simcrtNomEquipe;
   }

   public void setSimcrtNomEquipe(String var1) {
      this.simcrtNomEquipe = var1;
   }

   public int getSimcrtPosSignature() {
      return this.simcrtPosSignature;
   }

   public void setSimcrtPosSignature(int var1) {
      this.simcrtPosSignature = var1;
   }
}
