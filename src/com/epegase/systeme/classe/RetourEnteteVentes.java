package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class RetourEnteteVentes implements Serializable {
   private long brtId;
   private Date brtDateCreat;
   private String brtNum;
   private long brtIdCreateur;
   private String brtNomCreateur;
   private Date brtDateModif;
   private long brtIdModif;
   private String brtNomModif;
   private Date brtDate;
   private String brtNomEquipe;
   private long brtIdEquipe;
   private String brtNomResponsable;
   private long brtIdResponsable;
   private String brtNomCommercial;
   private long brtIdCommercial;
   private String brtNomTiers;
   private String brtCivilTiers;
   private String brtTiersRegroupe;
   private long brtIdContact;
   private String brtNomContact;
   private String brtCivilContact;
   private String brtSerie;
   private int brtExoTva;
   private int brtExoDouane;
   private String brtJournalReg;
   private String brtCat;
   private String brtDevise;
   private String brtObject;
   private String brtObservation;
   private String brtBudget;
   private float brtTauxRemise;
   private double brtTotHt;
   private double brtTotRemise;
   private double brtTotRabais;
   private double brtTotTva;
   private float brtTauxTc;
   private double brtTotTc;
   private double brtTotTtc;
   private double brtTotReglement;
   private int brtSolde;
   private String brtBanque;
   private int brtTypeReg;
   private String brtModeReg;
   private int brtNbJourReg;
   private int brtArrondiReg;
   private String brtConditionReg;
   private Date brtDateEcheReg;
   private String brtContener;
   private String brtActivite;
   private String brtSite;
   private String brtDepartement;
   private String brtService;
   private String brtRegion;
   private String brtSecteur;
   private String brtPdv;
   private String brtAnal2;
   private String brtAnal4;
   private String brtAffaire;
   private String brtInfo1;
   private String brtInfo2;
   private String brtInfo3;
   private String brtInfo4;
   private String brtInfo5;
   private String brtInfo6;
   private String brtInfo7;
   private String brtInfo8;
   private String brtInfo9;
   private String brtInfo10;
   private String brtFormule1;
   private String brtFormule2;
   private String brtAnnexe1;
   private String brtAnnexe2;
   private String brtContrat;
   private String brtIncoterm;
   private String brtLieuLivraison;
   private Date brtDateLivraison;
   private String brtInfoLivraison;
   private Date brtDateImp;
   private String brtModeleImp;
   private String brtGarde;
   private int brtEtatVal;
   private int brtGele;
   private int brtEtat;
   private Date brtDateValidite;
   private Date brtDateRelance;
   private Date brtDateValide;
   private int brtPosSignature;
   private Date brtDateTransforme;
   private int brtTypeTransforme;
   private Date brtDateAnnule;
   private String brtMotifAnnule;
   private String brtFactorNom;
   private long brtFactorId;
   private int brtFactorEtat;
   private int brtDiversTiers;
   private String brtDiversNom;
   private String brtDiversAdresse;
   private String brtDiversVille;
   private String brtDiversTel;
   private String brtDiversMail;
   private String brtNumAvoir;
   private String brtSource;
   private String brtNumClient;
   private Date brtDateClient;
   private float brtPoids;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private String var_solde;
   private boolean var_select_ligne;
   private int var_format_devise;
   private double varTotTtcGlob;
   private String var_nomContact;
   private String var_nom_tiers;

   public String getVar_nom_tiers() {
      if (this.brtDiversNom != null && !this.brtDiversNom.isEmpty()) {
         this.var_nom_tiers = this.brtDiversNom;
      } else if (this.brtCivilTiers != null && !this.brtCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.brtCivilTiers + " " + this.brtNomTiers;
      } else {
         this.var_nom_tiers = this.brtNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.brtDiversNom != null && !this.brtDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.brtCivilContact != null && !this.brtCivilContact.isEmpty()) {
         if (this.brtNomContact != null && !this.brtNomContact.isEmpty()) {
            this.var_nomContact = this.brtCivilContact + " " + this.brtNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.brtNomContact != null && !this.brtNomContact.isEmpty()) {
         this.var_nomContact = this.brtNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.brtTotTtc + this.brtTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getBrtActivite() {
      return this.brtActivite;
   }

   public void setBrtActivite(String var1) {
      this.brtActivite = var1;
   }

   public String getBrtAnal2() {
      return this.brtAnal2;
   }

   public void setBrtAnal2(String var1) {
      this.brtAnal2 = var1;
   }

   public String getBrtAnal4() {
      return this.brtAnal4;
   }

   public void setBrtAnal4(String var1) {
      this.brtAnal4 = var1;
   }

   public String getBrtAnnexe1() {
      return this.brtAnnexe1;
   }

   public void setBrtAnnexe1(String var1) {
      this.brtAnnexe1 = var1;
   }

   public String getBrtAnnexe2() {
      return this.brtAnnexe2;
   }

   public void setBrtAnnexe2(String var1) {
      this.brtAnnexe2 = var1;
   }

   public int getBrtArrondiReg() {
      return this.brtArrondiReg;
   }

   public void setBrtArrondiReg(int var1) {
      this.brtArrondiReg = var1;
   }

   public String getBrtBanque() {
      return this.brtBanque;
   }

   public void setBrtBanque(String var1) {
      this.brtBanque = var1;
   }

   public String getBrtBudget() {
      return this.brtBudget;
   }

   public void setBrtBudget(String var1) {
      this.brtBudget = var1;
   }

   public String getBrtCat() {
      return this.brtCat;
   }

   public void setBrtCat(String var1) {
      this.brtCat = var1;
   }

   public String getBrtConditionReg() {
      return this.brtConditionReg;
   }

   public void setBrtConditionReg(String var1) {
      this.brtConditionReg = var1;
   }

   public String getBrtContrat() {
      return this.brtContrat;
   }

   public void setBrtContrat(String var1) {
      this.brtContrat = var1;
   }

   public Date getBrtDateCreat() {
      return this.brtDateCreat;
   }

   public void setBrtDateCreat(Date var1) {
      this.brtDateCreat = var1;
   }

   public Date getBrtDateAnnule() {
      return this.brtDateAnnule;
   }

   public void setBrtDateAnnule(Date var1) {
      this.brtDateAnnule = var1;
   }

   public Date getBrtDateEcheReg() {
      return this.brtDateEcheReg;
   }

   public void setBrtDateEcheReg(Date var1) {
      this.brtDateEcheReg = var1;
   }

   public Date getBrtDateImp() {
      return this.brtDateImp;
   }

   public void setBrtDateImp(Date var1) {
      this.brtDateImp = var1;
   }

   public Date getBrtDateLivraison() {
      return this.brtDateLivraison;
   }

   public void setBrtDateLivraison(Date var1) {
      this.brtDateLivraison = var1;
   }

   public Date getBrtDateRelance() {
      return this.brtDateRelance;
   }

   public void setBrtDateRelance(Date var1) {
      this.brtDateRelance = var1;
   }

   public Date getBrtDateTransforme() {
      return this.brtDateTransforme;
   }

   public void setBrtDateTransforme(Date var1) {
      this.brtDateTransforme = var1;
   }

   public Date getBrtDateValide() {
      return this.brtDateValide;
   }

   public void setBrtDateValide(Date var1) {
      this.brtDateValide = var1;
   }

   public Date getBrtDateValidite() {
      return this.brtDateValidite;
   }

   public void setBrtDateValidite(Date var1) {
      this.brtDateValidite = var1;
   }

   public String getBrtDepartement() {
      return this.brtDepartement;
   }

   public void setBrtDepartement(String var1) {
      this.brtDepartement = var1;
   }

   public String getBrtDevise() {
      return this.brtDevise;
   }

   public void setBrtDevise(String var1) {
      this.brtDevise = var1;
   }

   public int getBrtEtat() {
      return this.brtEtat;
   }

   public void setBrtEtat(int var1) {
      this.brtEtat = var1;
   }

   public int getBrtEtatVal() {
      return this.brtEtatVal;
   }

   public void setBrtEtatVal(int var1) {
      this.brtEtatVal = var1;
   }

   public String getBrtFormule1() {
      return this.brtFormule1;
   }

   public void setBrtFormule1(String var1) {
      this.brtFormule1 = var1;
   }

   public String getBrtFormule2() {
      return this.brtFormule2;
   }

   public void setBrtFormule2(String var1) {
      this.brtFormule2 = var1;
   }

   public String getBrtGarde() {
      return this.brtGarde;
   }

   public void setBrtGarde(String var1) {
      this.brtGarde = var1;
   }

   public int getBrtGele() {
      return this.brtGele;
   }

   public void setBrtGele(int var1) {
      this.brtGele = var1;
   }

   public long getBrtId() {
      return this.brtId;
   }

   public void setBrtId(long var1) {
      this.brtId = var1;
   }

   public long getBrtIdCreateur() {
      return this.brtIdCreateur;
   }

   public void setBrtIdCreateur(long var1) {
      this.brtIdCreateur = var1;
   }

   public String getBrtIncoterm() {
      return this.brtIncoterm;
   }

   public void setBrtIncoterm(String var1) {
      this.brtIncoterm = var1;
   }

   public String getBrtInfoLivraison() {
      return this.brtInfoLivraison;
   }

   public void setBrtInfoLivraison(String var1) {
      this.brtInfoLivraison = var1;
   }

   public String getBrtLieuLivraison() {
      return this.brtLieuLivraison;
   }

   public void setBrtLieuLivraison(String var1) {
      this.brtLieuLivraison = var1;
   }

   public String getBrtModeReg() {
      return this.brtModeReg;
   }

   public void setBrtModeReg(String var1) {
      this.brtModeReg = var1;
   }

   public String getBrtModeleImp() {
      return this.brtModeleImp;
   }

   public void setBrtModeleImp(String var1) {
      this.brtModeleImp = var1;
   }

   public String getBrtMotifAnnule() {
      return this.brtMotifAnnule;
   }

   public void setBrtMotifAnnule(String var1) {
      this.brtMotifAnnule = var1;
   }

   public int getBrtNbJourReg() {
      return this.brtNbJourReg;
   }

   public void setBrtNbJourReg(int var1) {
      this.brtNbJourReg = var1;
   }

   public String getBrtInfo1() {
      return this.brtInfo1;
   }

   public void setBrtInfo1(String var1) {
      this.brtInfo1 = var1;
   }

   public String getBrtInfo10() {
      return this.brtInfo10;
   }

   public void setBrtInfo10(String var1) {
      this.brtInfo10 = var1;
   }

   public String getBrtInfo2() {
      return this.brtInfo2;
   }

   public void setBrtInfo2(String var1) {
      this.brtInfo2 = var1;
   }

   public String getBrtInfo3() {
      return this.brtInfo3;
   }

   public void setBrtInfo3(String var1) {
      this.brtInfo3 = var1;
   }

   public String getBrtInfo4() {
      return this.brtInfo4;
   }

   public void setBrtInfo4(String var1) {
      this.brtInfo4 = var1;
   }

   public String getBrtInfo5() {
      return this.brtInfo5;
   }

   public void setBrtInfo5(String var1) {
      this.brtInfo5 = var1;
   }

   public String getBrtInfo6() {
      return this.brtInfo6;
   }

   public void setBrtInfo6(String var1) {
      this.brtInfo6 = var1;
   }

   public String getBrtInfo7() {
      return this.brtInfo7;
   }

   public void setBrtInfo7(String var1) {
      this.brtInfo7 = var1;
   }

   public String getBrtInfo8() {
      return this.brtInfo8;
   }

   public void setBrtInfo8(String var1) {
      this.brtInfo8 = var1;
   }

   public String getBrtInfo9() {
      return this.brtInfo9;
   }

   public void setBrtInfo9(String var1) {
      this.brtInfo9 = var1;
   }

   public String getBrtNomContact() {
      if (this.brtNomContact != null && !this.brtNomContact.isEmpty()) {
         this.brtNomContact = this.brtNomContact.toUpperCase();
      }

      return this.brtNomContact;
   }

   public void setBrtNomContact(String var1) {
      this.brtNomContact = var1;
   }

   public String getBrtNomCreateur() {
      return this.brtNomCreateur;
   }

   public void setBrtNomCreateur(String var1) {
      this.brtNomCreateur = var1;
   }

   public String getBrtNomResponsable() {
      return this.brtNomResponsable;
   }

   public void setBrtNomResponsable(String var1) {
      this.brtNomResponsable = var1;
   }

   public String getBrtNomTiers() {
      return this.brtNomTiers;
   }

   public void setBrtNomTiers(String var1) {
      this.brtNomTiers = var1;
   }

   public String getBrtNum() {
      return this.brtNum;
   }

   public void setBrtNum(String var1) {
      this.brtNum = var1;
   }

   public String getBrtObject() {
      return this.brtObject;
   }

   public void setBrtObject(String var1) {
      this.brtObject = var1;
   }

   public String getBrtObservation() {
      return this.brtObservation;
   }

   public void setBrtObservation(String var1) {
      this.brtObservation = var1;
   }

   public String getBrtPdv() {
      return this.brtPdv;
   }

   public void setBrtPdv(String var1) {
      this.brtPdv = var1;
   }

   public String getBrtRegion() {
      return this.brtRegion;
   }

   public void setBrtRegion(String var1) {
      this.brtRegion = var1;
   }

   public String getBrtSecteur() {
      return this.brtSecteur;
   }

   public void setBrtSecteur(String var1) {
      this.brtSecteur = var1;
   }

   public String getBrtSerie() {
      return this.brtSerie;
   }

   public void setBrtSerie(String var1) {
      this.brtSerie = var1;
   }

   public String getBrtService() {
      return this.brtService;
   }

   public void setBrtService(String var1) {
      this.brtService = var1;
   }

   public String getBrtSite() {
      return this.brtSite;
   }

   public void setBrtSite(String var1) {
      this.brtSite = var1;
   }

   public int getBrtSolde() {
      return this.brtSolde;
   }

   public void setBrtSolde(int var1) {
      this.brtSolde = var1;
   }

   public double getBrtTotHt() {
      return this.brtTotHt;
   }

   public void setBrtTotHt(double var1) {
      this.brtTotHt = var1;
   }

   public double getBrtTotRabais() {
      return this.brtTotRabais;
   }

   public void setBrtTotRabais(double var1) {
      this.brtTotRabais = var1;
   }

   public double getBrtTotReglement() {
      return this.brtTotReglement;
   }

   public void setBrtTotReglement(double var1) {
      this.brtTotReglement = var1;
   }

   public double getBrtTotRemise() {
      return this.brtTotRemise;
   }

   public void setBrtTotRemise(double var1) {
      this.brtTotRemise = var1;
   }

   public double getBrtTotTc() {
      return this.brtTotTc;
   }

   public void setBrtTotTc(double var1) {
      this.brtTotTc = var1;
   }

   public double getBrtTotTtc() {
      return this.brtTotTtc;
   }

   public void setBrtTotTtc(double var1) {
      this.brtTotTtc = var1;
   }

   public double getBrtTotTva() {
      return this.brtTotTva;
   }

   public void setBrtTotTva(double var1) {
      this.brtTotTva = var1;
   }

   public int getBrtTypeReg() {
      return this.brtTypeReg;
   }

   public void setBrtTypeReg(int var1) {
      this.brtTypeReg = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
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

   public Date getBrtDateModif() {
      return this.brtDateModif;
   }

   public void setBrtDateModif(Date var1) {
      this.brtDateModif = var1;
   }

   public long getBrtIdModif() {
      return this.brtIdModif;
   }

   public void setBrtIdModif(long var1) {
      this.brtIdModif = var1;
   }

   public String getBrtNomModif() {
      return this.brtNomModif;
   }

   public void setBrtNomModif(String var1) {
      this.brtNomModif = var1;
   }

   public Date getBrtDate() {
      return this.brtDate;
   }

   public void setBrtDate(Date var1) {
      this.brtDate = var1;
   }

   public String getLibelleEta() {
      if (this.brtEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.brtEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.brtEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.brtEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.brtEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.brtEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public int getBrtFactorEtat() {
      return this.brtFactorEtat;
   }

   public void setBrtFactorEtat(int var1) {
      this.brtFactorEtat = var1;
   }

   public long getBrtFactorId() {
      return this.brtFactorId;
   }

   public void setBrtFactorId(long var1) {
      this.brtFactorId = var1;
   }

   public String getBrtFactorNom() {
      return this.brtFactorNom;
   }

   public void setBrtFactorNom(String var1) {
      this.brtFactorNom = var1;
   }

   public int getBrtExoDouane() {
      return this.brtExoDouane;
   }

   public void setBrtExoDouane(int var1) {
      this.brtExoDouane = var1;
   }

   public int getBrtExoTva() {
      return this.brtExoTva;
   }

   public void setBrtExoTva(int var1) {
      this.brtExoTva = var1;
   }

   public String getBrtJournalReg() {
      return this.brtJournalReg;
   }

   public void setBrtJournalReg(String var1) {
      this.brtJournalReg = var1;
   }

   public String getBrtCivilContact() {
      return this.brtCivilContact;
   }

   public void setBrtCivilContact(String var1) {
      this.brtCivilContact = var1;
   }

   public String getBrtCivilTiers() {
      return this.brtCivilTiers;
   }

   public void setBrtCivilTiers(String var1) {
      this.brtCivilTiers = var1;
   }

   public long getBrtIdResponsable() {
      return this.brtIdResponsable;
   }

   public void setBrtIdResponsable(long var1) {
      this.brtIdResponsable = var1;
   }

   public String getVar_solde() {
      if (this.brtSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getBrtTypeTransforme() {
      return this.brtTypeTransforme;
   }

   public void setBrtTypeTransforme(int var1) {
      this.brtTypeTransforme = var1;
   }

   public int getVar_format_devise() {
      if (!this.brtDevise.equals("XOF") && !this.brtDevise.equals("XAF")) {
         if (!this.brtDevise.equals("EUR") && !this.brtDevise.equals("XEU") && !this.brtDevise.equals("CHF")) {
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

   public long getBrtIdContact() {
      return this.brtIdContact;
   }

   public void setBrtIdContact(long var1) {
      this.brtIdContact = var1;
   }

   public float getBrtTauxTc() {
      return this.brtTauxTc;
   }

   public void setBrtTauxTc(float var1) {
      this.brtTauxTc = var1;
   }

   public String getBrtDiversAdresse() {
      return this.brtDiversAdresse;
   }

   public void setBrtDiversAdresse(String var1) {
      this.brtDiversAdresse = var1;
   }

   public String getBrtDiversMail() {
      return this.brtDiversMail;
   }

   public void setBrtDiversMail(String var1) {
      this.brtDiversMail = var1;
   }

   public String getBrtDiversNom() {
      if (this.brtDiversNom != null && !this.brtDiversNom.isEmpty()) {
         this.brtDiversNom = this.brtDiversNom.toUpperCase();
      }

      return this.brtDiversNom;
   }

   public void setBrtDiversNom(String var1) {
      this.brtDiversNom = var1;
   }

   public String getBrtDiversTel() {
      return this.brtDiversTel;
   }

   public void setBrtDiversTel(String var1) {
      this.brtDiversTel = var1;
   }

   public int getBrtDiversTiers() {
      return this.brtDiversTiers;
   }

   public void setBrtDiversTiers(int var1) {
      this.brtDiversTiers = var1;
   }

   public String getBrtDiversVille() {
      return this.brtDiversVille;
   }

   public void setBrtDiversVille(String var1) {
      this.brtDiversVille = var1;
   }

   public long getBrtIdCommercial() {
      return this.brtIdCommercial;
   }

   public void setBrtIdCommercial(long var1) {
      this.brtIdCommercial = var1;
   }

   public String getBrtNomCommercial() {
      return this.brtNomCommercial;
   }

   public void setBrtNomCommercial(String var1) {
      this.brtNomCommercial = var1;
   }

   public long getBrtIdEquipe() {
      return this.brtIdEquipe;
   }

   public void setBrtIdEquipe(long var1) {
      this.brtIdEquipe = var1;
   }

   public String getBrtNomEquipe() {
      return this.brtNomEquipe;
   }

   public void setBrtNomEquipe(String var1) {
      this.brtNomEquipe = var1;
   }

   public String getBrtNumAvoir() {
      return this.brtNumAvoir;
   }

   public void setBrtNumAvoir(String var1) {
      this.brtNumAvoir = var1;
   }

   public String getBrtSource() {
      return this.brtSource;
   }

   public void setBrtSource(String var1) {
      this.brtSource = var1;
   }

   public float getBrtTauxRemise() {
      return this.brtTauxRemise;
   }

   public void setBrtTauxRemise(float var1) {
      this.brtTauxRemise = var1;
   }

   public String getBrtTiersRegroupe() {
      return this.brtTiersRegroupe;
   }

   public void setBrtTiersRegroupe(String var1) {
      this.brtTiersRegroupe = var1;
   }

   public String getBrtContener() {
      return this.brtContener;
   }

   public void setBrtContener(String var1) {
      this.brtContener = var1;
   }

   public int getBrtPosSignature() {
      return this.brtPosSignature;
   }

   public void setBrtPosSignature(int var1) {
      this.brtPosSignature = var1;
   }

   public Date getBrtDateClient() {
      return this.brtDateClient;
   }

   public void setBrtDateClient(Date var1) {
      this.brtDateClient = var1;
   }

   public String getBrtNumClient() {
      return this.brtNumClient;
   }

   public void setBrtNumClient(String var1) {
      this.brtNumClient = var1;
   }

   public String getBrtAffaire() {
      return this.brtAffaire;
   }

   public void setBrtAffaire(String var1) {
      this.brtAffaire = var1;
   }

   public float getBrtPoids() {
      return this.brtPoids;
   }

   public void setBrtPoids(float var1) {
      this.brtPoids = var1;
   }
}
