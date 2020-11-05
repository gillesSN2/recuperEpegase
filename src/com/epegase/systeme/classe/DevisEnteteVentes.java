package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class DevisEnteteVentes implements Serializable {
   private long dvsId;
   private Date dvsDateCreat;
   private String dvsNum;
   private long dvsIdCreateur;
   private String dvsNomCreateur;
   private Date dvsDateModif;
   private long dvsIdModif;
   private String dvsNomModif;
   private String dvsNomEquipe;
   private long dvsIdEquipe;
   private long dvsIdResponsable;
   private String dvsNomResponsable;
   private String dvsNomCommercial;
   private long dvsIdCommercial;
   private String dvsNomTiers;
   private String dvsCivilTiers;
   private String dvsTiersRegroupe;
   private long dvsIdContact;
   private String dvsNomContact;
   private String dvsCivilContact;
   private String dvsSerie;
   private int dvsExoTva;
   private int dvsSuivi;
   private int dvsExoDouane;
   private String dvsJournalReg;
   private String dvsCat;
   private String dvsDevise;
   private String dvsObject;
   private String dvsObservation;
   private float dvsTauxRemise;
   private double dvsTotHt;
   private double dvsTotRemise;
   private double dvsTotRabais;
   private double dvsTotTva;
   private float dvsTauxTc;
   private double dvsTotTc;
   private double dvsTotTtc;
   private double dvsTotReglement;
   private int dvsSolde;
   private String dvsBanque;
   private int dvsTypeReg;
   private String dvsModeReg;
   private Date dvsEcheanceReliquat;
   private String dvsMotifRejetCredit;
   private int dvsNbJourReg;
   private int dvsArrondiReg;
   private String dvsConditionReg;
   private Date dvsDateEcheReg;
   private String dvsContener;
   private String dvsActivite;
   private String dvsSite;
   private String dvsDepartement;
   private String dvsService;
   private String dvsRegion;
   private String dvsSecteur;
   private String dvsPdv;
   private String dvsAnal2;
   private String dvsAnal4;
   private String dvsAffaire;
   private String dvsInfo1;
   private String dvsInfo2;
   private String dvsInfo3;
   private String dvsInfo4;
   private String dvsInfo5;
   private String dvsInfo6;
   private String dvsInfo7;
   private String dvsInfo8;
   private String dvsInfo9;
   private String dvsInfo10;
   private String dvsFormule1;
   private String dvsFormule2;
   private String dvsAnnexe1;
   private String dvsAnnexe2;
   private String dvsContrat;
   private String dvsIncoterm;
   private String dvsLieuLivraison;
   private Date dvsDateLivraison;
   private String dvsDelaisLivraison;
   private String dvsInfoLivraison;
   private Date dvsDateImp;
   private String dvsModeleImp;
   private String dvsGarde;
   private int dvsEtatVal;
   private int dvsGele;
   private int dvsEtat;
   private Date dvsDateValidite;
   private Date dvsDateRelance;
   private Date dvsDateValide;
   private int dvsPosSignature;
   private Date dvsDateTransforme;
   private int dvsTypeTransforme;
   private Date dvsDateAnnule;
   private String dvsMotifAnnule;
   private Date dvsDate;
   private String dvsFactorNom;
   private long dvsFactorId;
   private int dvsFactorEtat;
   private String dvsBeneficiaire;
   private String dvsAccord;
   private String dvsRegime;
   private String dvsBureau;
   private String dvsPays;
   private String dvsUtilisation;
   private String dvsFournisseur;
   private int dvsDiversTiers;
   private String dvsDiversNom;
   private String dvsDiversAdresse;
   private String dvsDiversVille;
   private String dvsDiversTel;
   private String dvsDiversMail;
   private String dvsSource;
   private int dvsModeConclusion;
   private String dvsConclusion;
   private Date dvsDateRelance1;
   private String dvsConclusion1;
   private Date dvsDateARelance1;
   private long dvsUserRelance1;
   private Date dvsDateRelance2;
   private String dvsConclusion2;
   private Date dvsDateARelance2;
   private long dvsUserRelance2;
   private Date dvsDateRelance3;
   private String dvsConclusion3;
   private Date dvsDateARelance3;
   private long dvsUserRelance3;
   private float dvsPoids;
   private Date dvsDateEnvoie;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private String montantLettre;
   private String libelleEta;
   private String var_solde;
   private double var_reliquat;
   private boolean var_select_ligne;
   private int var_format_devise;
   private double varTotTtcGlob;
   private String var_nomContact;
   private String var_nom_tiers;
   private String devisVip;

   public String getDevisVip() {
      if (this.dvsSuivi == 1) {
         this.devisVip = "color:blue";
      } else {
         this.devisVip = "color:black";
      }

      return this.devisVip;
   }

   public void setDevisVip(String var1) {
      this.devisVip = var1;
   }

   public String getMontantLettre() {
      return this.montantLettre;
   }

   public void setMontantLettre(String var1) {
      this.montantLettre = var1;
   }

   public String getVar_nom_tiers() {
      if (this.dvsDiversNom != null && !this.dvsDiversNom.isEmpty()) {
         this.var_nom_tiers = this.dvsDiversNom;
      } else if (this.dvsCivilTiers != null && !this.dvsCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.dvsCivilTiers + " " + this.dvsNomTiers;
      } else {
         this.var_nom_tiers = this.dvsNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.dvsDiversNom != null && !this.dvsDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.dvsCivilContact != null && !this.dvsCivilContact.isEmpty()) {
         if (this.dvsNomContact != null && !this.dvsNomContact.isEmpty()) {
            this.var_nomContact = this.dvsCivilContact + " " + this.dvsNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.dvsNomContact != null && !this.dvsNomContact.isEmpty()) {
         this.var_nomContact = this.dvsNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.dvsTotTtc + this.dvsTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getVar_solde() {
      if (this.dvsSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public String getLibelleEta() {
      if (this.dvsEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.dvsEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.dvsEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.dvsEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.dvsEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.dvsEtat == 5) {
         this.libelleEta = "Trf.T.";
      } else if (this.dvsEtat == 6) {
         this.libelleEta = "ATT";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public int getVar_format_devise() {
      if (!this.dvsDevise.equals("XOF") && !this.dvsDevise.equals("XAF")) {
         if (!this.dvsDevise.equals("EUR") && !this.dvsDevise.equals("XEU") && !this.dvsDevise.equals("CHF")) {
            this.var_format_devise = 0;
         } else {
            this.var_format_devise = 1;
         }
      } else {
         this.var_format_devise = 2;
      }

      return this.var_format_devise;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.dvsTotTtc - this.dvsTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public String getDvsActivite() {
      return this.dvsActivite;
   }

   public void setDvsActivite(String var1) {
      this.dvsActivite = var1;
   }

   public String getDvsAnal2() {
      return this.dvsAnal2;
   }

   public void setDvsAnal2(String var1) {
      this.dvsAnal2 = var1;
   }

   public String getDvsAnal4() {
      return this.dvsAnal4;
   }

   public void setDvsAnal4(String var1) {
      this.dvsAnal4 = var1;
   }

   public String getDvsAnnexe1() {
      return this.dvsAnnexe1;
   }

   public void setDvsAnnexe1(String var1) {
      this.dvsAnnexe1 = var1;
   }

   public String getDvsAnnexe2() {
      return this.dvsAnnexe2;
   }

   public void setDvsAnnexe2(String var1) {
      this.dvsAnnexe2 = var1;
   }

   public int getDvsArrondiReg() {
      return this.dvsArrondiReg;
   }

   public void setDvsArrondiReg(int var1) {
      this.dvsArrondiReg = var1;
   }

   public String getDvsBanque() {
      return this.dvsBanque;
   }

   public void setDvsBanque(String var1) {
      this.dvsBanque = var1;
   }

   public String getDvsCat() {
      return this.dvsCat;
   }

   public void setDvsCat(String var1) {
      this.dvsCat = var1;
   }

   public String getDvsConditionReg() {
      return this.dvsConditionReg;
   }

   public void setDvsConditionReg(String var1) {
      this.dvsConditionReg = var1;
   }

   public String getDvsContrat() {
      return this.dvsContrat;
   }

   public void setDvsContrat(String var1) {
      this.dvsContrat = var1;
   }

   public Date getDvsDateCreat() {
      return this.dvsDateCreat;
   }

   public void setDvsDateCreat(Date var1) {
      this.dvsDateCreat = var1;
   }

   public Date getDvsDateAnnule() {
      return this.dvsDateAnnule;
   }

   public void setDvsDateAnnule(Date var1) {
      this.dvsDateAnnule = var1;
   }

   public Date getDvsDateEcheReg() {
      return this.dvsDateEcheReg;
   }

   public void setDvsDateEcheReg(Date var1) {
      this.dvsDateEcheReg = var1;
   }

   public Date getDvsDateImp() {
      return this.dvsDateImp;
   }

   public void setDvsDateImp(Date var1) {
      this.dvsDateImp = var1;
   }

   public Date getDvsDateLivraison() {
      return this.dvsDateLivraison;
   }

   public void setDvsDateLivraison(Date var1) {
      this.dvsDateLivraison = var1;
   }

   public Date getDvsDateRelance() {
      return this.dvsDateRelance;
   }

   public void setDvsDateRelance(Date var1) {
      this.dvsDateRelance = var1;
   }

   public Date getDvsDateTransforme() {
      return this.dvsDateTransforme;
   }

   public void setDvsDateTransforme(Date var1) {
      this.dvsDateTransforme = var1;
   }

   public Date getDvsDateValide() {
      return this.dvsDateValide;
   }

   public void setDvsDateValide(Date var1) {
      this.dvsDateValide = var1;
   }

   public Date getDvsDateValidite() {
      return this.dvsDateValidite;
   }

   public void setDvsDateValidite(Date var1) {
      this.dvsDateValidite = var1;
   }

   public String getDvsDepartement() {
      return this.dvsDepartement;
   }

   public void setDvsDepartement(String var1) {
      this.dvsDepartement = var1;
   }

   public String getDvsDevise() {
      return this.dvsDevise;
   }

   public void setDvsDevise(String var1) {
      this.dvsDevise = var1;
   }

   public int getDvsEtat() {
      return this.dvsEtat;
   }

   public void setDvsEtat(int var1) {
      this.dvsEtat = var1;
   }

   public int getDvsEtatVal() {
      return this.dvsEtatVal;
   }

   public void setDvsEtatVal(int var1) {
      this.dvsEtatVal = var1;
   }

   public String getDvsFormule1() {
      return this.dvsFormule1;
   }

   public void setDvsFormule1(String var1) {
      this.dvsFormule1 = var1;
   }

   public String getDvsFormule2() {
      return this.dvsFormule2;
   }

   public void setDvsFormule2(String var1) {
      this.dvsFormule2 = var1;
   }

   public String getDvsGarde() {
      return this.dvsGarde;
   }

   public void setDvsGarde(String var1) {
      this.dvsGarde = var1;
   }

   public int getDvsGele() {
      return this.dvsGele;
   }

   public void setDvsGele(int var1) {
      this.dvsGele = var1;
   }

   public long getDvsId() {
      return this.dvsId;
   }

   public void setDvsId(long var1) {
      this.dvsId = var1;
   }

   public long getDvsIdCreateur() {
      return this.dvsIdCreateur;
   }

   public void setDvsIdCreateur(long var1) {
      this.dvsIdCreateur = var1;
   }

   public String getDvsIncoterm() {
      return this.dvsIncoterm;
   }

   public void setDvsIncoterm(String var1) {
      this.dvsIncoterm = var1;
   }

   public String getDvsInfoLivraison() {
      return this.dvsInfoLivraison;
   }

   public void setDvsInfoLivraison(String var1) {
      this.dvsInfoLivraison = var1;
   }

   public String getDvsLieuLivraison() {
      return this.dvsLieuLivraison;
   }

   public void setDvsLieuLivraison(String var1) {
      this.dvsLieuLivraison = var1;
   }

   public String getDvsModeReg() {
      return this.dvsModeReg;
   }

   public void setDvsModeReg(String var1) {
      this.dvsModeReg = var1;
   }

   public String getDvsModeleImp() {
      return this.dvsModeleImp;
   }

   public void setDvsModeleImp(String var1) {
      this.dvsModeleImp = var1;
   }

   public String getDvsMotifAnnule() {
      return this.dvsMotifAnnule;
   }

   public void setDvsMotifAnnule(String var1) {
      this.dvsMotifAnnule = var1;
   }

   public int getDvsNbJourReg() {
      return this.dvsNbJourReg;
   }

   public void setDvsNbJourReg(int var1) {
      this.dvsNbJourReg = var1;
   }

   public String getDvsInfo1() {
      return this.dvsInfo1;
   }

   public void setDvsInfo1(String var1) {
      this.dvsInfo1 = var1;
   }

   public String getDvsInfo10() {
      return this.dvsInfo10;
   }

   public void setDvsInfo10(String var1) {
      this.dvsInfo10 = var1;
   }

   public String getDvsInfo2() {
      return this.dvsInfo2;
   }

   public void setDvsInfo2(String var1) {
      this.dvsInfo2 = var1;
   }

   public String getDvsInfo3() {
      return this.dvsInfo3;
   }

   public void setDvsInfo3(String var1) {
      this.dvsInfo3 = var1;
   }

   public String getDvsInfo4() {
      return this.dvsInfo4;
   }

   public void setDvsInfo4(String var1) {
      this.dvsInfo4 = var1;
   }

   public String getDvsInfo5() {
      return this.dvsInfo5;
   }

   public void setDvsInfo5(String var1) {
      this.dvsInfo5 = var1;
   }

   public String getDvsInfo6() {
      return this.dvsInfo6;
   }

   public void setDvsInfo6(String var1) {
      this.dvsInfo6 = var1;
   }

   public String getDvsInfo7() {
      return this.dvsInfo7;
   }

   public void setDvsInfo7(String var1) {
      this.dvsInfo7 = var1;
   }

   public String getDvsInfo8() {
      return this.dvsInfo8;
   }

   public void setDvsInfo8(String var1) {
      this.dvsInfo8 = var1;
   }

   public String getDvsInfo9() {
      return this.dvsInfo9;
   }

   public void setDvsInfo9(String var1) {
      this.dvsInfo9 = var1;
   }

   public String getDvsNomContact() {
      if (this.dvsNomContact != null && !this.dvsNomContact.isEmpty()) {
         this.dvsNomContact = this.dvsNomContact.toUpperCase();
      }

      return this.dvsNomContact;
   }

   public void setDvsNomContact(String var1) {
      this.dvsNomContact = var1;
   }

   public String getDvsNomCreateur() {
      return this.dvsNomCreateur;
   }

   public void setDvsNomCreateur(String var1) {
      this.dvsNomCreateur = var1;
   }

   public String getDvsNomResponsable() {
      return this.dvsNomResponsable;
   }

   public void setDvsNomResponsable(String var1) {
      this.dvsNomResponsable = var1;
   }

   public String getDvsNomTiers() {
      return this.dvsNomTiers;
   }

   public void setDvsNomTiers(String var1) {
      this.dvsNomTiers = var1;
   }

   public String getDvsNum() {
      return this.dvsNum;
   }

   public void setDvsNum(String var1) {
      this.dvsNum = var1;
   }

   public String getDvsObject() {
      return this.dvsObject;
   }

   public void setDvsObject(String var1) {
      this.dvsObject = var1;
   }

   public String getDvsObservation() {
      return this.dvsObservation;
   }

   public void setDvsObservation(String var1) {
      this.dvsObservation = var1;
   }

   public String getDvsPdv() {
      return this.dvsPdv;
   }

   public void setDvsPdv(String var1) {
      this.dvsPdv = var1;
   }

   public String getDvsRegion() {
      return this.dvsRegion;
   }

   public void setDvsRegion(String var1) {
      this.dvsRegion = var1;
   }

   public String getDvsSecteur() {
      return this.dvsSecteur;
   }

   public void setDvsSecteur(String var1) {
      this.dvsSecteur = var1;
   }

   public String getDvsSerie() {
      return this.dvsSerie;
   }

   public void setDvsSerie(String var1) {
      this.dvsSerie = var1;
   }

   public String getDvsService() {
      return this.dvsService;
   }

   public void setDvsService(String var1) {
      this.dvsService = var1;
   }

   public String getDvsSite() {
      return this.dvsSite;
   }

   public void setDvsSite(String var1) {
      this.dvsSite = var1;
   }

   public int getDvsSolde() {
      return this.dvsSolde;
   }

   public void setDvsSolde(int var1) {
      this.dvsSolde = var1;
   }

   public double getDvsTotHt() {
      return this.dvsTotHt;
   }

   public void setDvsTotHt(double var1) {
      this.dvsTotHt = var1;
   }

   public double getDvsTotRabais() {
      return this.dvsTotRabais;
   }

   public void setDvsTotRabais(double var1) {
      this.dvsTotRabais = var1;
   }

   public double getDvsTotReglement() {
      return this.dvsTotReglement;
   }

   public void setDvsTotReglement(double var1) {
      this.dvsTotReglement = var1;
   }

   public double getDvsTotRemise() {
      return this.dvsTotRemise;
   }

   public void setDvsTotRemise(double var1) {
      this.dvsTotRemise = var1;
   }

   public double getDvsTotTc() {
      return this.dvsTotTc;
   }

   public void setDvsTotTc(double var1) {
      this.dvsTotTc = var1;
   }

   public double getDvsTotTtc() {
      return this.dvsTotTtc;
   }

   public void setDvsTotTtc(double var1) {
      this.dvsTotTtc = var1;
   }

   public double getDvsTotTva() {
      return this.dvsTotTva;
   }

   public void setDvsTotTva(double var1) {
      this.dvsTotTva = var1;
   }

   public int getDvsTypeReg() {
      return this.dvsTypeReg;
   }

   public void setDvsTypeReg(int var1) {
      this.dvsTypeReg = var1;
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

   public Date getDvsDateModif() {
      return this.dvsDateModif;
   }

   public void setDvsDateModif(Date var1) {
      this.dvsDateModif = var1;
   }

   public long getDvsIdModif() {
      return this.dvsIdModif;
   }

   public void setDvsIdModif(long var1) {
      this.dvsIdModif = var1;
   }

   public String getDvsNomModif() {
      return this.dvsNomModif;
   }

   public void setDvsNomModif(String var1) {
      this.dvsNomModif = var1;
   }

   public Date getDvsDate() {
      return this.dvsDate;
   }

   public void setDvsDate(Date var1) {
      this.dvsDate = var1;
   }

   public int getDvsFactorEtat() {
      return this.dvsFactorEtat;
   }

   public void setDvsFactorEtat(int var1) {
      this.dvsFactorEtat = var1;
   }

   public long getDvsFactorId() {
      return this.dvsFactorId;
   }

   public void setDvsFactorId(long var1) {
      this.dvsFactorId = var1;
   }

   public String getDvsFactorNom() {
      return this.dvsFactorNom;
   }

   public void setDvsFactorNom(String var1) {
      this.dvsFactorNom = var1;
   }

   public int getDvsExoDouane() {
      return this.dvsExoDouane;
   }

   public void setDvsExoDouane(int var1) {
      this.dvsExoDouane = var1;
   }

   public int getDvsExoTva() {
      return this.dvsExoTva;
   }

   public void setDvsExoTva(int var1) {
      this.dvsExoTva = var1;
   }

   public String getDvsJournalReg() {
      return this.dvsJournalReg;
   }

   public void setDvsJournalReg(String var1) {
      this.dvsJournalReg = var1;
   }

   public long getDvsIdResponsable() {
      return this.dvsIdResponsable;
   }

   public void setDvsIdResponsable(long var1) {
      this.dvsIdResponsable = var1;
   }

   public String getDvsAccord() {
      return this.dvsAccord;
   }

   public void setDvsAccord(String var1) {
      this.dvsAccord = var1;
   }

   public String getDvsBeneficiaire() {
      return this.dvsBeneficiaire;
   }

   public void setDvsBeneficiaire(String var1) {
      this.dvsBeneficiaire = var1;
   }

   public String getDvsBureau() {
      return this.dvsBureau;
   }

   public void setDvsBureau(String var1) {
      this.dvsBureau = var1;
   }

   public String getDvsFournisseur() {
      return this.dvsFournisseur;
   }

   public void setDvsFournisseur(String var1) {
      this.dvsFournisseur = var1;
   }

   public String getDvsPays() {
      return this.dvsPays;
   }

   public void setDvsPays(String var1) {
      this.dvsPays = var1;
   }

   public String getDvsRegime() {
      return this.dvsRegime;
   }

   public void setDvsRegime(String var1) {
      this.dvsRegime = var1;
   }

   public String getDvsUtilisation() {
      return this.dvsUtilisation;
   }

   public void setDvsUtilisation(String var1) {
      this.dvsUtilisation = var1;
   }

   public String getDvsCivilContact() {
      return this.dvsCivilContact;
   }

   public void setDvsCivilContact(String var1) {
      this.dvsCivilContact = var1;
   }

   public String getDvsCivilTiers() {
      return this.dvsCivilTiers;
   }

   public void setDvsCivilTiers(String var1) {
      this.dvsCivilTiers = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getDvsTypeTransforme() {
      return this.dvsTypeTransforme;
   }

   public void setDvsTypeTransforme(int var1) {
      this.dvsTypeTransforme = var1;
   }

   public long getDvsIdContact() {
      return this.dvsIdContact;
   }

   public void setDvsIdContact(long var1) {
      this.dvsIdContact = var1;
   }

   public Date getDvsEcheanceReliquat() {
      return this.dvsEcheanceReliquat;
   }

   public void setDvsEcheanceReliquat(Date var1) {
      this.dvsEcheanceReliquat = var1;
   }

   public String getDvsMotifRejetCredit() {
      return this.dvsMotifRejetCredit;
   }

   public void setDvsMotifRejetCredit(String var1) {
      this.dvsMotifRejetCredit = var1;
   }

   public float getDvsTauxTc() {
      return this.dvsTauxTc;
   }

   public void setDvsTauxTc(float var1) {
      this.dvsTauxTc = var1;
   }

   public String getDvsDiversAdresse() {
      return this.dvsDiversAdresse;
   }

   public void setDvsDiversAdresse(String var1) {
      this.dvsDiversAdresse = var1;
   }

   public String getDvsDiversMail() {
      return this.dvsDiversMail;
   }

   public void setDvsDiversMail(String var1) {
      this.dvsDiversMail = var1;
   }

   public String getDvsDiversNom() {
      if (this.dvsDiversNom != null && !this.dvsDiversNom.isEmpty()) {
         this.dvsDiversNom = this.dvsDiversNom.toUpperCase();
      }

      return this.dvsDiversNom;
   }

   public void setDvsDiversNom(String var1) {
      this.dvsDiversNom = var1;
   }

   public String getDvsDiversTel() {
      return this.dvsDiversTel;
   }

   public void setDvsDiversTel(String var1) {
      this.dvsDiversTel = var1;
   }

   public int getDvsDiversTiers() {
      return this.dvsDiversTiers;
   }

   public void setDvsDiversTiers(int var1) {
      this.dvsDiversTiers = var1;
   }

   public String getDvsDiversVille() {
      return this.dvsDiversVille;
   }

   public void setDvsDiversVille(String var1) {
      this.dvsDiversVille = var1;
   }

   public long getDvsIdCommercial() {
      return this.dvsIdCommercial;
   }

   public void setDvsIdCommercial(long var1) {
      this.dvsIdCommercial = var1;
   }

   public String getDvsNomCommercial() {
      return this.dvsNomCommercial;
   }

   public void setDvsNomCommercial(String var1) {
      this.dvsNomCommercial = var1;
   }

   public long getDvsIdEquipe() {
      return this.dvsIdEquipe;
   }

   public void setDvsIdEquipe(long var1) {
      this.dvsIdEquipe = var1;
   }

   public String getDvsNomEquipe() {
      return this.dvsNomEquipe;
   }

   public void setDvsNomEquipe(String var1) {
      this.dvsNomEquipe = var1;
   }

   public String getDvsSource() {
      return this.dvsSource;
   }

   public void setDvsSource(String var1) {
      this.dvsSource = var1;
   }

   public float getDvsTauxRemise() {
      return this.dvsTauxRemise;
   }

   public void setDvsTauxRemise(float var1) {
      this.dvsTauxRemise = var1;
   }

   public String getDvsTiersRegroupe() {
      return this.dvsTiersRegroupe;
   }

   public void setDvsTiersRegroupe(String var1) {
      this.dvsTiersRegroupe = var1;
   }

   public String getDvsContener() {
      return this.dvsContener;
   }

   public void setDvsContener(String var1) {
      this.dvsContener = var1;
   }

   public int getDvsPosSignature() {
      return this.dvsPosSignature;
   }

   public void setDvsPosSignature(int var1) {
      this.dvsPosSignature = var1;
   }

   public int getDvsSuivi() {
      return this.dvsSuivi;
   }

   public void setDvsSuivi(int var1) {
      this.dvsSuivi = var1;
   }

   public String getDvsConclusion() {
      return this.dvsConclusion;
   }

   public void setDvsConclusion(String var1) {
      this.dvsConclusion = var1;
   }

   public int getDvsModeConclusion() {
      return this.dvsModeConclusion;
   }

   public void setDvsModeConclusion(int var1) {
      this.dvsModeConclusion = var1;
   }

   public String getDvsConclusion1() {
      return this.dvsConclusion1;
   }

   public void setDvsConclusion1(String var1) {
      this.dvsConclusion1 = var1;
   }

   public String getDvsConclusion2() {
      return this.dvsConclusion2;
   }

   public void setDvsConclusion2(String var1) {
      this.dvsConclusion2 = var1;
   }

   public String getDvsConclusion3() {
      return this.dvsConclusion3;
   }

   public void setDvsConclusion3(String var1) {
      this.dvsConclusion3 = var1;
   }

   public Date getDvsDateARelance1() {
      return this.dvsDateARelance1;
   }

   public void setDvsDateARelance1(Date var1) {
      this.dvsDateARelance1 = var1;
   }

   public Date getDvsDateARelance2() {
      return this.dvsDateARelance2;
   }

   public void setDvsDateARelance2(Date var1) {
      this.dvsDateARelance2 = var1;
   }

   public Date getDvsDateARelance3() {
      return this.dvsDateARelance3;
   }

   public void setDvsDateARelance3(Date var1) {
      this.dvsDateARelance3 = var1;
   }

   public Date getDvsDateRelance1() {
      return this.dvsDateRelance1;
   }

   public void setDvsDateRelance1(Date var1) {
      this.dvsDateRelance1 = var1;
   }

   public Date getDvsDateRelance2() {
      return this.dvsDateRelance2;
   }

   public void setDvsDateRelance2(Date var1) {
      this.dvsDateRelance2 = var1;
   }

   public Date getDvsDateRelance3() {
      return this.dvsDateRelance3;
   }

   public void setDvsDateRelance3(Date var1) {
      this.dvsDateRelance3 = var1;
   }

   public long getDvsUserRelance1() {
      return this.dvsUserRelance1;
   }

   public void setDvsUserRelance1(long var1) {
      this.dvsUserRelance1 = var1;
   }

   public long getDvsUserRelance2() {
      return this.dvsUserRelance2;
   }

   public void setDvsUserRelance2(long var1) {
      this.dvsUserRelance2 = var1;
   }

   public long getDvsUserRelance3() {
      return this.dvsUserRelance3;
   }

   public void setDvsUserRelance3(long var1) {
      this.dvsUserRelance3 = var1;
   }

   public String getDvsAffaire() {
      return this.dvsAffaire;
   }

   public void setDvsAffaire(String var1) {
      this.dvsAffaire = var1;
   }

   public float getDvsPoids() {
      return this.dvsPoids;
   }

   public void setDvsPoids(float var1) {
      this.dvsPoids = var1;
   }

   public String getDvsDelaisLivraison() {
      return this.dvsDelaisLivraison;
   }

   public void setDvsDelaisLivraison(String var1) {
      this.dvsDelaisLivraison = var1;
   }

   public Date getDvsDateEnvoie() {
      return this.dvsDateEnvoie;
   }

   public void setDvsDateEnvoie(Date var1) {
      this.dvsDateEnvoie = var1;
   }
}
