package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CommandeEnteteAchats implements Serializable {
   private long cmdId;
   private Date cmdDateCreat;
   private Date cmdDateModif;
   private long cmdIdCreateur;
   private String cmdNomCreateur;
   private long cmdIdModif;
   private String cmdNomModif;
   private int cmdMaj;
   private Date cmdDate;
   private String cmdNum;
   private String cmdValo;
   private String cmdNomResponsable;
   private long cmdIdResponsable;
   private String cmdNomCommercial;
   private long cmdIdCommercial;
   private String cmdNomTiers;
   private String cmdCivilTiers;
   private long cmdIdContact;
   private String cmdNomContact;
   private String cmdCivilContact;
   private String cmdSerie;
   private int cmdExoTva;
   private int cmdExoDouane;
   private String cmdJournalReg;
   private String cmdCat;
   private String cmdDevise;
   private float cmdCoefDevise;
   private String cmdObject;
   private String cmdObservation;
   private String cmdBudgetProjet;
   private String cmdBudgetEntite;
   private String cmdBudgetPoste;
   private double cmdTotCertificat;
   private double cmdTotCertificatConformite;
   private double cmdTotFraisAdm;
   private double cmdTotHt;
   private double cmdTotRemise;
   private double cmdTotRabais;
   private double cmdTotTva;
   private double cmdTotTc;
   private double cmdTotTtc;
   private double cmdTotReglement;
   private double cmdTotHtLocal;
   private double cmdTotTvaLocal;
   private double cmdTotTtcLocal;
   private double cmdTotRemiseLocal;
   private double cmdTotRabaisLocal;
   private double cmdTotFret;
   private double cmdTotFretLocal;
   private double cmdTotFret2;
   private double cmdTotFret2Local;
   private double cmdTotAssurance;
   private double cmdTotAssuranceLocal;
   private float cmdTotPoidsBrut;
   private float cmdTotQte;
   private double cmdBudgetDispo;
   private double cmdBudgetDispoMois;
   private double cmdBudgetTreso;
   private double cmdBudgetTresoMois;
   private double cmdTotTimbre;
   private int cmdSolde;
   private String cmdBanque;
   private int cmdTypeReg;
   private String cmdModeReg;
   private Date cmdDateLastReg;
   private int cmdNbJourReg;
   private int cmdArrondiReg;
   private String cmdConditionReg;
   private Date cmdDateEcheReg;
   private String cmdActivite;
   private String cmdSite;
   private String cmdDepartement;
   private String cmdService;
   private String cmdRegion;
   private String cmdSecteur;
   private String cmdPdv;
   private String cmdAnal1;
   private String cmdAnal2;
   private String cmdAnal4;
   private String cmdAffaire;
   private String cmdInfo1;
   private String cmdInfo2;
   private String cmdInfo3;
   private String cmdInfo4;
   private String cmdInfo5;
   private String cmdInfo6;
   private String cmdInfo7;
   private String cmdInfo8;
   private String cmdInfo9;
   private String cmdInfo10;
   private String cmdFormule1;
   private String cmdFormule2;
   private String cmdAnnexe1;
   private String cmdAnnexe2;
   private String cmdContrat;
   private String cmdIncoterm;
   private String cmdLieuLivraison;
   private Date cmdDateLivraison;
   private String cmdInfoLivraison;
   private Date cmdDateImp;
   private String cmdModeleImp;
   private int cmdEtatVal;
   private int cmdGele;
   private int cmdEtat;
   private Date cmdDateValidite;
   private Date cmdDateRelance;
   private Date cmdDateValide;
   private int cmdPosSignature;
   private Date cmdDateFacture;
   private String cmdNumProforma;
   private Date cmdDateTransforme;
   private int cmdTypeTransforme;
   private Date cmdDateAnnule;
   private String cmdMotifAnnule;
   private String cmdFactorNom;
   private long cmdFactorId;
   private int cmdFactorEtat;
   private int cmdPriorite;
   private int cmdIntOut;
   private String cmdCommentaire;
   private String cmdProduction;
   private String cmdPreparateur;
   private int cmdDiversTiers;
   private String cmdDiversNom;
   private String cmdDiversAdresse;
   private String cmdDiversVille;
   private String cmdDiversTel;
   private String cmdDiversMail;
   private String cmdTracking;
   private Date cmdDateDepartUsine;
   private Date cmdDateArriveeTransit;
   private Date cmdDateEmbarquementTheo;
   private Date cmdDateEmbarquementReel;
   private Date cmdDateArriveePortTheo;
   private Date cmdDateArriveePortReel;
   private Date cmdDateLivreDepot;
   private String cmdMoyenPaiement;
   private String cmdObsPaiement;
   private Date cmdDatePaiement;
   private int cmdMode;
   private String cmdProchaineAction;
   private int cmdValorisation;
   private String cmdReferencefournisseur;
   private String cmdTypeContener;
   private int cmdNbContener;
   private Date cmdDateFdi;
   private String cmdNomTiersFdi;
   private String cmdNumFacture;
   private Date cmdEnvoiFdi;
   private Date cmdDateDocOriginaux;
   private Date cmdDateAssurance;
   private Date cmdDateRfcv;
   private Date cmdDateDocTransit;
   private Date cmdDateStock;
   private Date cmdDateDocCaution;
   private String cmdModelePr;
   private String cmdSource;
   private ExercicesAchats exercicesAchats;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private String var_solde;
   private double var_reliquat;
   private boolean var_select_ligne;
   private int var_format_devise;
   private String var_nomContact;
   private String var_nom_tiers;
   private String libelleMode;
   private double budgetInitial;
   private double var_fac_timbre;
   private double montantReglementManuel;
   private double varTotTtcGlob;

   public double getMontantReglementManuel() {
      return this.montantReglementManuel;
   }

   public void setMontantReglementManuel(double var1) {
      this.montantReglementManuel = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.cmdTotTtc + this.cmdTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public double getVar_fac_timbre() {
      return this.var_fac_timbre;
   }

   public void setVar_fac_timbre(double var1) {
      this.var_fac_timbre = var1;
   }

   public double getBudgetInitial() {
      return this.budgetInitial;
   }

   public void setBudgetInitial(double var1) {
      this.budgetInitial = var1;
   }

   public String getLibelleMode() {
      if (this.cmdMode == 0) {
         this.libelleMode = "Maritime";
      } else if (this.cmdMode == 1) {
         this.libelleMode = "Aérien";
      } else if (this.cmdMode == 2) {
         this.libelleMode = "Express";
      } else if (this.cmdMode == 3) {
         this.libelleMode = "Route";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getVar_nom_tiers() {
      if (this.cmdDiversNom != null && !this.cmdDiversNom.isEmpty()) {
         this.var_nom_tiers = this.cmdDiversNom;
      } else if (this.cmdCivilTiers != null && !this.cmdCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.cmdCivilTiers + " " + this.cmdNomTiers;
      } else {
         this.var_nom_tiers = this.cmdNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.cmdDiversNom != null && !this.cmdDiversNom.isEmpty()) {
         this.var_nomContact = "(fournisseur divers)";
      } else if (this.cmdCivilContact != null && !this.cmdCivilContact.isEmpty()) {
         if (this.cmdNomContact != null && !this.cmdNomContact.isEmpty()) {
            this.var_nomContact = this.cmdCivilContact + " " + this.cmdNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.cmdNomContact != null && !this.cmdNomContact.isEmpty()) {
         this.var_nomContact = this.cmdNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.cmdEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.cmdEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.cmdEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.cmdEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.cmdEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.cmdEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVar_solde() {
      if (this.cmdSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.cmdTotTtc - this.cmdTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public int getVar_format_devise() {
      if (!this.cmdDevise.equals("XOF") && !this.cmdDevise.equals("XAF")) {
         if (!this.cmdDevise.equals("EUR") && !this.cmdDevise.equals("XEU") && !this.cmdDevise.equals("CHF")) {
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

   public String getCmdActivite() {
      return this.cmdActivite;
   }

   public void setCmdActivite(String var1) {
      this.cmdActivite = var1;
   }

   public String getCmdAnal2() {
      return this.cmdAnal2;
   }

   public void setCmdAnal2(String var1) {
      this.cmdAnal2 = var1;
   }

   public String getCmdAnal4() {
      return this.cmdAnal4;
   }

   public void setCmdAnal4(String var1) {
      this.cmdAnal4 = var1;
   }

   public String getCmdAnnexe1() {
      return this.cmdAnnexe1;
   }

   public void setCmdAnnexe1(String var1) {
      this.cmdAnnexe1 = var1;
   }

   public String getCmdAnnexe2() {
      return this.cmdAnnexe2;
   }

   public void setCmdAnnexe2(String var1) {
      this.cmdAnnexe2 = var1;
   }

   public int getCmdArrondiReg() {
      return this.cmdArrondiReg;
   }

   public void setCmdArrondiReg(int var1) {
      this.cmdArrondiReg = var1;
   }

   public String getCmdBanque() {
      return this.cmdBanque;
   }

   public void setCmdBanque(String var1) {
      this.cmdBanque = var1;
   }

   public String getCmdBudgetEntite() {
      return this.cmdBudgetEntite;
   }

   public void setCmdBudgetEntite(String var1) {
      this.cmdBudgetEntite = var1;
   }

   public String getCmdBudgetPoste() {
      return this.cmdBudgetPoste;
   }

   public void setCmdBudgetPoste(String var1) {
      this.cmdBudgetPoste = var1;
   }

   public String getCmdBudgetProjet() {
      return this.cmdBudgetProjet;
   }

   public void setCmdBudgetProjet(String var1) {
      this.cmdBudgetProjet = var1;
   }

   public String getCmdObservation() {
      return this.cmdObservation;
   }

   public void setCmdObservation(String var1) {
      this.cmdObservation = var1;
   }

   public String getCmdCat() {
      return this.cmdCat;
   }

   public void setCmdCat(String var1) {
      this.cmdCat = var1;
   }

   public String getCmdConditionReg() {
      return this.cmdConditionReg;
   }

   public void setCmdConditionReg(String var1) {
      this.cmdConditionReg = var1;
   }

   public String getCmdContrat() {
      return this.cmdContrat;
   }

   public void setCmdContrat(String var1) {
      this.cmdContrat = var1;
   }

   public Date getCmdDate() {
      return this.cmdDate;
   }

   public void setCmdDate(Date var1) {
      this.cmdDate = var1;
   }

   public Date getCmdDateAnnule() {
      return this.cmdDateAnnule;
   }

   public void setCmdDateAnnule(Date var1) {
      this.cmdDateAnnule = var1;
   }

   public Date getCmdDateCreat() {
      return this.cmdDateCreat;
   }

   public void setCmdDateCreat(Date var1) {
      this.cmdDateCreat = var1;
   }

   public Date getCmdDateEcheReg() {
      return this.cmdDateEcheReg;
   }

   public void setCmdDateEcheReg(Date var1) {
      this.cmdDateEcheReg = var1;
   }

   public Date getCmdDateImp() {
      return this.cmdDateImp;
   }

   public void setCmdDateImp(Date var1) {
      this.cmdDateImp = var1;
   }

   public Date getCmdDateLivraison() {
      return this.cmdDateLivraison;
   }

   public void setCmdDateLivraison(Date var1) {
      this.cmdDateLivraison = var1;
   }

   public Date getCmdDateModif() {
      return this.cmdDateModif;
   }

   public void setCmdDateModif(Date var1) {
      this.cmdDateModif = var1;
   }

   public Date getCmdDateRelance() {
      return this.cmdDateRelance;
   }

   public void setCmdDateRelance(Date var1) {
      this.cmdDateRelance = var1;
   }

   public Date getCmdDateTransforme() {
      return this.cmdDateTransforme;
   }

   public void setCmdDateTransforme(Date var1) {
      this.cmdDateTransforme = var1;
   }

   public Date getCmdDateValide() {
      return this.cmdDateValide;
   }

   public void setCmdDateValide(Date var1) {
      this.cmdDateValide = var1;
   }

   public Date getCmdDateValidite() {
      return this.cmdDateValidite;
   }

   public void setCmdDateValidite(Date var1) {
      this.cmdDateValidite = var1;
   }

   public String getCmdDepartement() {
      return this.cmdDepartement;
   }

   public void setCmdDepartement(String var1) {
      this.cmdDepartement = var1;
   }

   public String getCmdDevise() {
      return this.cmdDevise;
   }

   public void setCmdDevise(String var1) {
      this.cmdDevise = var1;
   }

   public int getCmdEtat() {
      return this.cmdEtat;
   }

   public void setCmdEtat(int var1) {
      this.cmdEtat = var1;
   }

   public int getCmdEtatVal() {
      return this.cmdEtatVal;
   }

   public void setCmdEtatVal(int var1) {
      this.cmdEtatVal = var1;
   }

   public String getCmdFormule1() {
      return this.cmdFormule1;
   }

   public void setCmdFormule1(String var1) {
      this.cmdFormule1 = var1;
   }

   public String getCmdFormule2() {
      return this.cmdFormule2;
   }

   public void setCmdFormule2(String var1) {
      this.cmdFormule2 = var1;
   }

   public int getCmdGele() {
      return this.cmdGele;
   }

   public void setCmdGele(int var1) {
      this.cmdGele = var1;
   }

   public long getCmdId() {
      return this.cmdId;
   }

   public void setCmdId(long var1) {
      this.cmdId = var1;
   }

   public long getCmdIdCreateur() {
      return this.cmdIdCreateur;
   }

   public void setCmdIdCreateur(long var1) {
      this.cmdIdCreateur = var1;
   }

   public long getCmdIdModif() {
      return this.cmdIdModif;
   }

   public void setCmdIdModif(long var1) {
      this.cmdIdModif = var1;
   }

   public String getCmdIncoterm() {
      return this.cmdIncoterm;
   }

   public void setCmdIncoterm(String var1) {
      this.cmdIncoterm = var1;
   }

   public String getCmdInfo1() {
      return this.cmdInfo1;
   }

   public void setCmdInfo1(String var1) {
      this.cmdInfo1 = var1;
   }

   public String getCmdInfo10() {
      return this.cmdInfo10;
   }

   public void setCmdInfo10(String var1) {
      this.cmdInfo10 = var1;
   }

   public String getCmdInfo2() {
      return this.cmdInfo2;
   }

   public void setCmdInfo2(String var1) {
      this.cmdInfo2 = var1;
   }

   public String getCmdInfo3() {
      return this.cmdInfo3;
   }

   public void setCmdInfo3(String var1) {
      this.cmdInfo3 = var1;
   }

   public String getCmdInfo4() {
      return this.cmdInfo4;
   }

   public void setCmdInfo4(String var1) {
      this.cmdInfo4 = var1;
   }

   public String getCmdInfo5() {
      return this.cmdInfo5;
   }

   public void setCmdInfo5(String var1) {
      this.cmdInfo5 = var1;
   }

   public String getCmdInfo6() {
      return this.cmdInfo6;
   }

   public void setCmdInfo6(String var1) {
      this.cmdInfo6 = var1;
   }

   public String getCmdInfo7() {
      return this.cmdInfo7;
   }

   public void setCmdInfo7(String var1) {
      this.cmdInfo7 = var1;
   }

   public String getCmdInfo8() {
      return this.cmdInfo8;
   }

   public void setCmdInfo8(String var1) {
      this.cmdInfo8 = var1;
   }

   public String getCmdInfo9() {
      return this.cmdInfo9;
   }

   public void setCmdInfo9(String var1) {
      this.cmdInfo9 = var1;
   }

   public String getCmdInfoLivraison() {
      return this.cmdInfoLivraison;
   }

   public void setCmdInfoLivraison(String var1) {
      this.cmdInfoLivraison = var1;
   }

   public String getCmdLieuLivraison() {
      return this.cmdLieuLivraison;
   }

   public void setCmdLieuLivraison(String var1) {
      this.cmdLieuLivraison = var1;
   }

   public String getCmdModeReg() {
      return this.cmdModeReg;
   }

   public void setCmdModeReg(String var1) {
      this.cmdModeReg = var1;
   }

   public String getCmdModeleImp() {
      return this.cmdModeleImp;
   }

   public void setCmdModeleImp(String var1) {
      this.cmdModeleImp = var1;
   }

   public String getCmdMotifAnnule() {
      return this.cmdMotifAnnule;
   }

   public void setCmdMotifAnnule(String var1) {
      this.cmdMotifAnnule = var1;
   }

   public int getCmdNbJourReg() {
      return this.cmdNbJourReg;
   }

   public void setCmdNbJourReg(int var1) {
      this.cmdNbJourReg = var1;
   }

   public String getCmdNomContact() {
      return this.cmdNomContact;
   }

   public void setCmdNomContact(String var1) {
      this.cmdNomContact = var1;
   }

   public String getCmdNomCreateur() {
      return this.cmdNomCreateur;
   }

   public void setCmdNomCreateur(String var1) {
      this.cmdNomCreateur = var1;
   }

   public String getCmdNomModif() {
      return this.cmdNomModif;
   }

   public void setCmdNomModif(String var1) {
      this.cmdNomModif = var1;
   }

   public String getCmdNomResponsable() {
      return this.cmdNomResponsable;
   }

   public void setCmdNomResponsable(String var1) {
      this.cmdNomResponsable = var1;
   }

   public String getCmdNomTiers() {
      return this.cmdNomTiers;
   }

   public void setCmdNomTiers(String var1) {
      this.cmdNomTiers = var1;
   }

   public String getCmdNum() {
      return this.cmdNum;
   }

   public void setCmdNum(String var1) {
      this.cmdNum = var1;
   }

   public String getCmdObject() {
      return this.cmdObject;
   }

   public void setCmdObject(String var1) {
      this.cmdObject = var1;
   }

   public String getCmdPdv() {
      return this.cmdPdv;
   }

   public void setCmdPdv(String var1) {
      this.cmdPdv = var1;
   }

   public String getCmdRegion() {
      return this.cmdRegion;
   }

   public void setCmdRegion(String var1) {
      this.cmdRegion = var1;
   }

   public String getCmdSecteur() {
      return this.cmdSecteur;
   }

   public void setCmdSecteur(String var1) {
      this.cmdSecteur = var1;
   }

   public String getCmdSerie() {
      return this.cmdSerie;
   }

   public void setCmdSerie(String var1) {
      this.cmdSerie = var1;
   }

   public String getCmdService() {
      return this.cmdService;
   }

   public void setCmdService(String var1) {
      this.cmdService = var1;
   }

   public String getCmdSite() {
      return this.cmdSite;
   }

   public void setCmdSite(String var1) {
      this.cmdSite = var1;
   }

   public int getCmdSolde() {
      return this.cmdSolde;
   }

   public void setCmdSolde(int var1) {
      this.cmdSolde = var1;
   }

   public double getCmdTotHt() {
      return this.cmdTotHt;
   }

   public void setCmdTotHt(double var1) {
      this.cmdTotHt = var1;
   }

   public double getCmdTotRabais() {
      return this.cmdTotRabais;
   }

   public void setCmdTotRabais(double var1) {
      this.cmdTotRabais = var1;
   }

   public double getCmdTotReglement() {
      return this.cmdTotReglement;
   }

   public void setCmdTotReglement(double var1) {
      this.cmdTotReglement = var1;
   }

   public double getCmdTotRemise() {
      return this.cmdTotRemise;
   }

   public void setCmdTotRemise(double var1) {
      this.cmdTotRemise = var1;
   }

   public double getCmdTotTc() {
      return this.cmdTotTc;
   }

   public void setCmdTotTc(double var1) {
      this.cmdTotTc = var1;
   }

   public double getCmdTotTtc() {
      return this.cmdTotTtc;
   }

   public void setCmdTotTtc(double var1) {
      this.cmdTotTtc = var1;
   }

   public double getCmdTotTva() {
      return this.cmdTotTva;
   }

   public void setCmdTotTva(double var1) {
      this.cmdTotTva = var1;
   }

   public int getCmdTypeReg() {
      return this.cmdTypeReg;
   }

   public void setCmdTypeReg(int var1) {
      this.cmdTypeReg = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
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

   public double getCmdBudgetDispo() {
      return this.cmdBudgetDispo;
   }

   public void setCmdBudgetDispo(double var1) {
      this.cmdBudgetDispo = var1;
   }

   public double getCmdBudgetTreso() {
      return this.cmdBudgetTreso;
   }

   public void setCmdBudgetTreso(double var1) {
      this.cmdBudgetTreso = var1;
   }

   public int getCmdExoDouane() {
      return this.cmdExoDouane;
   }

   public void setCmdExoDouane(int var1) {
      this.cmdExoDouane = var1;
   }

   public int getCmdExoTva() {
      return this.cmdExoTva;
   }

   public void setCmdExoTva(int var1) {
      this.cmdExoTva = var1;
   }

   public String getCmdJournalReg() {
      return this.cmdJournalReg;
   }

   public void setCmdJournalReg(String var1) {
      this.cmdJournalReg = var1;
   }

   public String getCmdCivilContact() {
      return this.cmdCivilContact;
   }

   public void setCmdCivilContact(String var1) {
      this.cmdCivilContact = var1;
   }

   public String getCmdCivilTiers() {
      return this.cmdCivilTiers;
   }

   public void setCmdCivilTiers(String var1) {
      this.cmdCivilTiers = var1;
   }

   public int getCmdFactorEtat() {
      return this.cmdFactorEtat;
   }

   public void setCmdFactorEtat(int var1) {
      this.cmdFactorEtat = var1;
   }

   public String getCmdFactorNom() {
      return this.cmdFactorNom;
   }

   public void setCmdFactorNom(String var1) {
      this.cmdFactorNom = var1;
   }

   public long getCmdIdResponsable() {
      return this.cmdIdResponsable;
   }

   public void setCmdIdResponsable(long var1) {
      this.cmdIdResponsable = var1;
   }

   public long getCmdFactorId() {
      return this.cmdFactorId;
   }

   public void setCmdFactorId(long var1) {
      this.cmdFactorId = var1;
   }

   public int getCmdPriorite() {
      return this.cmdPriorite;
   }

   public void setCmdPriorite(int var1) {
      this.cmdPriorite = var1;
   }

   public String getCmdProduction() {
      return this.cmdProduction;
   }

   public void setCmdProduction(String var1) {
      this.cmdProduction = var1;
   }

   public int getCmdIntOut() {
      return this.cmdIntOut;
   }

   public void setCmdIntOut(int var1) {
      this.cmdIntOut = var1;
   }

   public String getCmdCommentaire() {
      return this.cmdCommentaire;
   }

   public void setCmdCommentaire(String var1) {
      this.cmdCommentaire = var1;
   }

   public String getCmdPreparateur() {
      return this.cmdPreparateur;
   }

   public void setCmdPreparateur(String var1) {
      this.cmdPreparateur = var1;
   }

   public int getCmdTypeTransforme() {
      return this.cmdTypeTransforme;
   }

   public void setCmdTypeTransforme(int var1) {
      this.cmdTypeTransforme = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public double getCmdBudgetDispoMois() {
      return this.cmdBudgetDispoMois;
   }

   public void setCmdBudgetDispoMois(double var1) {
      this.cmdBudgetDispoMois = var1;
   }

   public double getCmdBudgetTresoMois() {
      return this.cmdBudgetTresoMois;
   }

   public void setCmdBudgetTresoMois(double var1) {
      this.cmdBudgetTresoMois = var1;
   }

   public String getCmdValo() {
      return this.cmdValo;
   }

   public void setCmdValo(String var1) {
      this.cmdValo = var1;
   }

   public int getCmdMaj() {
      return this.cmdMaj;
   }

   public void setCmdMaj(int var1) {
      this.cmdMaj = var1;
   }

   public long getCmdIdContact() {
      return this.cmdIdContact;
   }

   public void setCmdIdContact(long var1) {
      this.cmdIdContact = var1;
   }

   public Date getCmdDateFacture() {
      return this.cmdDateFacture;
   }

   public void setCmdDateFacture(Date var1) {
      this.cmdDateFacture = var1;
   }

   public double getCmdTotFret() {
      return this.cmdTotFret;
   }

   public void setCmdTotFret(double var1) {
      this.cmdTotFret = var1;
   }

   public double getCmdTotFretLocal() {
      return this.cmdTotFretLocal;
   }

   public void setCmdTotFretLocal(double var1) {
      this.cmdTotFretLocal = var1;
   }

   public double getCmdTotHtLocal() {
      return this.cmdTotHtLocal;
   }

   public void setCmdTotHtLocal(double var1) {
      this.cmdTotHtLocal = var1;
   }

   public double getCmdTotRabaisLocal() {
      return this.cmdTotRabaisLocal;
   }

   public void setCmdTotRabaisLocal(double var1) {
      this.cmdTotRabaisLocal = var1;
   }

   public double getCmdTotRemiseLocal() {
      return this.cmdTotRemiseLocal;
   }

   public void setCmdTotRemiseLocal(double var1) {
      this.cmdTotRemiseLocal = var1;
   }

   public double getCmdTotTtcLocal() {
      return this.cmdTotTtcLocal;
   }

   public void setCmdTotTtcLocal(double var1) {
      this.cmdTotTtcLocal = var1;
   }

   public double getCmdTotTvaLocal() {
      return this.cmdTotTvaLocal;
   }

   public void setCmdTotTvaLocal(double var1) {
      this.cmdTotTvaLocal = var1;
   }

   public float getCmdTotPoidsBrut() {
      return this.cmdTotPoidsBrut;
   }

   public void setCmdTotPoidsBrut(float var1) {
      this.cmdTotPoidsBrut = var1;
   }

   public float getCmdTotQte() {
      return this.cmdTotQte;
   }

   public void setCmdTotQte(float var1) {
      this.cmdTotQte = var1;
   }

   public String getCmdDiversAdresse() {
      return this.cmdDiversAdresse;
   }

   public void setCmdDiversAdresse(String var1) {
      this.cmdDiversAdresse = var1;
   }

   public String getCmdDiversMail() {
      return this.cmdDiversMail;
   }

   public void setCmdDiversMail(String var1) {
      this.cmdDiversMail = var1;
   }

   public String getCmdDiversNom() {
      return this.cmdDiversNom;
   }

   public void setCmdDiversNom(String var1) {
      this.cmdDiversNom = var1;
   }

   public String getCmdDiversTel() {
      return this.cmdDiversTel;
   }

   public void setCmdDiversTel(String var1) {
      this.cmdDiversTel = var1;
   }

   public int getCmdDiversTiers() {
      return this.cmdDiversTiers;
   }

   public void setCmdDiversTiers(int var1) {
      this.cmdDiversTiers = var1;
   }

   public String getCmdDiversVille() {
      return this.cmdDiversVille;
   }

   public void setCmdDiversVille(String var1) {
      this.cmdDiversVille = var1;
   }

   public String getCmdNumProforma() {
      return this.cmdNumProforma;
   }

   public void setCmdNumProforma(String var1) {
      this.cmdNumProforma = var1;
   }

   public Date getCmdDateArriveePortReel() {
      return this.cmdDateArriveePortReel;
   }

   public void setCmdDateArriveePortReel(Date var1) {
      this.cmdDateArriveePortReel = var1;
   }

   public Date getCmdDateArriveePortTheo() {
      return this.cmdDateArriveePortTheo;
   }

   public void setCmdDateArriveePortTheo(Date var1) {
      this.cmdDateArriveePortTheo = var1;
   }

   public Date getCmdDateArriveeTransit() {
      return this.cmdDateArriveeTransit;
   }

   public void setCmdDateArriveeTransit(Date var1) {
      this.cmdDateArriveeTransit = var1;
   }

   public Date getCmdDateDepartUsine() {
      return this.cmdDateDepartUsine;
   }

   public void setCmdDateDepartUsine(Date var1) {
      this.cmdDateDepartUsine = var1;
   }

   public Date getCmdDateEmbarquementReel() {
      return this.cmdDateEmbarquementReel;
   }

   public void setCmdDateEmbarquementReel(Date var1) {
      this.cmdDateEmbarquementReel = var1;
   }

   public Date getCmdDateEmbarquementTheo() {
      return this.cmdDateEmbarquementTheo;
   }

   public void setCmdDateEmbarquementTheo(Date var1) {
      this.cmdDateEmbarquementTheo = var1;
   }

   public Date getCmdDateLivreDepot() {
      return this.cmdDateLivreDepot;
   }

   public void setCmdDateLivreDepot(Date var1) {
      this.cmdDateLivreDepot = var1;
   }

   public String getCmdMoyenPaiement() {
      return this.cmdMoyenPaiement;
   }

   public void setCmdMoyenPaiement(String var1) {
      this.cmdMoyenPaiement = var1;
   }

   public Date getCmdDatePaiement() {
      return this.cmdDatePaiement;
   }

   public void setCmdDatePaiement(Date var1) {
      this.cmdDatePaiement = var1;
   }

   public int getCmdMode() {
      return this.cmdMode;
   }

   public void setCmdMode(int var1) {
      this.cmdMode = var1;
   }

   public String getCmdObsPaiement() {
      return this.cmdObsPaiement;
   }

   public void setCmdObsPaiement(String var1) {
      this.cmdObsPaiement = var1;
   }

   public String getCmdTracking() {
      return this.cmdTracking;
   }

   public void setCmdTracking(String var1) {
      this.cmdTracking = var1;
   }

   public String getCmdProchaineAction() {
      return this.cmdProchaineAction;
   }

   public void setCmdProchaineAction(String var1) {
      this.cmdProchaineAction = var1;
   }

   public float getCmdCoefDevise() {
      return this.cmdCoefDevise;
   }

   public void setCmdCoefDevise(float var1) {
      this.cmdCoefDevise = var1;
   }

   public int getCmdValorisation() {
      return this.cmdValorisation;
   }

   public void setCmdValorisation(int var1) {
      this.cmdValorisation = var1;
   }

   public Date getCmdDateAssurance() {
      return this.cmdDateAssurance;
   }

   public void setCmdDateAssurance(Date var1) {
      this.cmdDateAssurance = var1;
   }

   public Date getCmdDateDocCaution() {
      return this.cmdDateDocCaution;
   }

   public void setCmdDateDocCaution(Date var1) {
      this.cmdDateDocCaution = var1;
   }

   public Date getCmdDateDocOriginaux() {
      return this.cmdDateDocOriginaux;
   }

   public void setCmdDateDocOriginaux(Date var1) {
      this.cmdDateDocOriginaux = var1;
   }

   public Date getCmdDateDocTransit() {
      return this.cmdDateDocTransit;
   }

   public void setCmdDateDocTransit(Date var1) {
      this.cmdDateDocTransit = var1;
   }

   public Date getCmdDateFdi() {
      return this.cmdDateFdi;
   }

   public void setCmdDateFdi(Date var1) {
      this.cmdDateFdi = var1;
   }

   public Date getCmdDateRfcv() {
      return this.cmdDateRfcv;
   }

   public void setCmdDateRfcv(Date var1) {
      this.cmdDateRfcv = var1;
   }

   public Date getCmdDateStock() {
      return this.cmdDateStock;
   }

   public void setCmdDateStock(Date var1) {
      this.cmdDateStock = var1;
   }

   public Date getCmdEnvoiFdi() {
      return this.cmdEnvoiFdi;
   }

   public void setCmdEnvoiFdi(Date var1) {
      this.cmdEnvoiFdi = var1;
   }

   public int getCmdNbContener() {
      return this.cmdNbContener;
   }

   public void setCmdNbContener(int var1) {
      this.cmdNbContener = var1;
   }

   public String getCmdReferencefournisseur() {
      return this.cmdReferencefournisseur;
   }

   public void setCmdReferencefournisseur(String var1) {
      this.cmdReferencefournisseur = var1;
   }

   public String getCmdNomTiersFdi() {
      return this.cmdNomTiersFdi;
   }

   public void setCmdNomTiersFdi(String var1) {
      this.cmdNomTiersFdi = var1;
   }

   public String getCmdTypeContener() {
      return this.cmdTypeContener;
   }

   public void setCmdTypeContener(String var1) {
      this.cmdTypeContener = var1;
   }

   public String getCmdNumFacture() {
      return this.cmdNumFacture;
   }

   public void setCmdNumFacture(String var1) {
      this.cmdNumFacture = var1;
   }

   public double getCmdTotAssurance() {
      return this.cmdTotAssurance;
   }

   public void setCmdTotAssurance(double var1) {
      this.cmdTotAssurance = var1;
   }

   public double getCmdTotAssuranceLocal() {
      return this.cmdTotAssuranceLocal;
   }

   public void setCmdTotAssuranceLocal(double var1) {
      this.cmdTotAssuranceLocal = var1;
   }

   public String getCmdModelePr() {
      return this.cmdModelePr;
   }

   public void setCmdModelePr(String var1) {
      this.cmdModelePr = var1;
   }

   public double getCmdTotFret2() {
      return this.cmdTotFret2;
   }

   public void setCmdTotFret2(double var1) {
      this.cmdTotFret2 = var1;
   }

   public double getCmdTotFret2Local() {
      return this.cmdTotFret2Local;
   }

   public void setCmdTotFret2Local(double var1) {
      this.cmdTotFret2Local = var1;
   }

   public Date getCmdDateLastReg() {
      return this.cmdDateLastReg;
   }

   public void setCmdDateLastReg(Date var1) {
      this.cmdDateLastReg = var1;
   }

   public double getCmdTotTimbre() {
      return this.cmdTotTimbre;
   }

   public void setCmdTotTimbre(double var1) {
      this.cmdTotTimbre = var1;
   }

   public int getCmdPosSignature() {
      return this.cmdPosSignature;
   }

   public void setCmdPosSignature(int var1) {
      this.cmdPosSignature = var1;
   }

   public double getCmdTotCertificat() {
      return this.cmdTotCertificat;
   }

   public void setCmdTotCertificat(double var1) {
      this.cmdTotCertificat = var1;
   }

   public double getCmdTotCertificatConformite() {
      return this.cmdTotCertificatConformite;
   }

   public void setCmdTotCertificatConformite(double var1) {
      this.cmdTotCertificatConformite = var1;
   }

   public long getCmdIdCommercial() {
      return this.cmdIdCommercial;
   }

   public void setCmdIdCommercial(long var1) {
      this.cmdIdCommercial = var1;
   }

   public String getCmdNomCommercial() {
      return this.cmdNomCommercial;
   }

   public void setCmdNomCommercial(String var1) {
      this.cmdNomCommercial = var1;
   }

   public double getCmdTotFraisAdm() {
      return this.cmdTotFraisAdm;
   }

   public void setCmdTotFraisAdm(double var1) {
      this.cmdTotFraisAdm = var1;
   }

   public String getCmdAffaire() {
      return this.cmdAffaire;
   }

   public void setCmdAffaire(String var1) {
      this.cmdAffaire = var1;
   }

   public String getCmdSource() {
      return this.cmdSource;
   }

   public void setCmdSource(String var1) {
      this.cmdSource = var1;
   }

   public String getCmdAnal1() {
      return this.cmdAnal1;
   }

   public void setCmdAnal1(String var1) {
      this.cmdAnal1 = var1;
   }
}
