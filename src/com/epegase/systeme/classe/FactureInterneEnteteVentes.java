package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FactureInterneEnteteVentes implements Serializable {
   private long fitId;
   private Date fitDateCreat;
   private String fitNum;
   private String fitNumBl;
   private long fitIdCreateur;
   private String fitNomCreateur;
   private Date fitDateModif;
   private long fitIdModif;
   private String fitNomModif;
   private Date fitDate;
   private String fitNomEquipe;
   private long fitIdEquipe;
   private String fitNomResponsable;
   private long fitIdResponsable;
   private String fitNomCommercial;
   private long fitIdCommercial;
   private String fitNomTiers;
   private String fitCivilTiers;
   private String fitTiersRegroupe;
   private long fitIdContact;
   private String fitNomContact;
   private String fitCivilContact;
   private String fitSerie;
   private int fitExoTva;
   private int fitExoDouane;
   private Date fitDateLastReg;
   private String fitJournalReg;
   private String fitCat;
   private String fitDevise;
   private String fitObject;
   private String fitObservation;
   private String fitBudget;
   private float fitTauxRemise;
   private double fitTotHt;
   private double fitTotRemise;
   private double fitTotRabais;
   private double fitTotTva;
   private float fitTauxTc;
   private double fitTotTc;
   private double fitTotTtc;
   private double fitTotReglement;
   private double fitTotTimbre;
   private int fitSolde;
   private String fitBanque;
   private int fitTypeReg;
   private String fitModeReg;
   private Date fitEcheanceReliquat;
   private String fitMotifRejetCredit;
   private int fitNbJourReg;
   private int fitArrondiReg;
   private String fitConditionReg;
   private Date fitDateEcheReg;
   private String fitContener;
   private String fitActivite;
   private String fitSite;
   private String fitDepartement;
   private String fitService;
   private String fitRegion;
   private String fitSecteur;
   private String fitPdv;
   private String fitAnal2;
   private String fitAnal4;
   private String fitInfo1;
   private String fitInfo2;
   private String fitInfo3;
   private String fitInfo4;
   private String fitInfo5;
   private String fitInfo6;
   private String fitInfo7;
   private String fitInfo8;
   private String fitInfo9;
   private String fitInfo10;
   private String fitFormule1;
   private String fitFormule2;
   private String fitAnnexe1;
   private String fitAnnexe2;
   private String fitContrat;
   private String fitIncoterm;
   private String fitLieuLivraison;
   private Date fitDateLivraison;
   private String fitInfoLivraison;
   private Date fitDateImp;
   private String fitModeleImp;
   private String fitGarde;
   private int fitEtatVal;
   private int fitGele;
   private int fitEtat;
   private String fitNumTrf;
   private Date fitDateValidite;
   private Date fitDateRelance;
   private Date fitDateValide;
   private Date fitDateTransforme;
   private int fitTypeTransforme;
   private Date fitDateAnnule;
   private String fitMotifAnnule;
   private int fitExo;
   private String fitMotifExo;
   private String fitNumVisa;
   private Date fitDateVisa;
   private String fitRangeVisa;
   private Date fitDateTransfert;
   private String fitFactorNom;
   private long fitFactorId;
   private int fitFactorEtat;
   private int fitDiversTiers;
   private String fitDiversNom;
   private String fitDiversAdresse;
   private String fitDiversVille;
   private String fitDiversTel;
   private String fitDiversMail;
   private String fitDiversNif;
   private String fitSource;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private String var_solde;
   private double var_reliquat;
   private double var_reliquatListe;
   private boolean var_select_ligne;
   private int var_format_devise;
   private double varTotTtcGlob;
   private String var_nomContact;
   private String var_nom_tiers;
   private double montantReglementManuel;
   private double var_fac_timbre;

   public double getVar_fac_timbre() {
      return this.var_fac_timbre;
   }

   public void setVar_fac_timbre(double var1) {
      this.var_fac_timbre = var1;
   }

   public double getMontantReglementManuel() {
      return this.montantReglementManuel;
   }

   public void setMontantReglementManuel(double var1) {
      this.montantReglementManuel = var1;
   }

   public String getLibelleEta() {
      if (this.fitEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.fitEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.fitEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.fitEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.fitEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.fitEtat == 5) {
         this.libelleEta = "Trf.T.";
      } else if (this.fitEtat == 6) {
         this.libelleEta = "Cor.";
      } else if (this.fitEtat == 7) {
         this.libelleEta = "Rej.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.fitTotTtc + this.fitTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public int getVar_format_devise() {
      if (!this.fitDevise.equals("XOF") && !this.fitDevise.equals("XAF")) {
         if (!this.fitDevise.equals("EUR") && !this.fitDevise.equals("XEU") && !this.fitDevise.equals("CHF")) {
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

   public String getVar_nomContact() {
      if (this.fitDiversNom != null && !this.fitDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.fitCivilContact != null && !this.fitCivilContact.isEmpty()) {
         if (this.fitNomContact != null && !this.fitNomContact.isEmpty()) {
            this.var_nomContact = this.fitCivilContact + " " + this.fitNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.fitNomContact != null && !this.fitNomContact.isEmpty()) {
         this.var_nomContact = this.fitNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getVar_nom_tiers() {
      if (this.fitDiversNom != null && !this.fitDiversNom.isEmpty()) {
         this.var_nom_tiers = this.fitDiversNom;
      } else if (this.fitCivilTiers != null && !this.fitCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.fitCivilTiers + " " + this.fitNomTiers;
      } else {
         this.var_nom_tiers = this.fitNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public double getVar_reliquatListe() {
      this.var_reliquatListe = this.fitTotTtc + this.fitTotTc + this.fitTotTimbre - this.fitTotReglement;
      return this.var_reliquatListe;
   }

   public void setVar_reliquatListe(double var1) {
      this.var_reliquatListe = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.fitTotTtc + this.fitTotTc + this.var_fac_timbre - this.fitTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public String getVar_solde() {
      if (this.fitSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
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

   public String getFitActivite() {
      return this.fitActivite;
   }

   public void setFitActivite(String var1) {
      this.fitActivite = var1;
   }

   public String getFitAnal2() {
      return this.fitAnal2;
   }

   public void setFitAnal2(String var1) {
      this.fitAnal2 = var1;
   }

   public String getFitAnal4() {
      return this.fitAnal4;
   }

   public void setFitAnal4(String var1) {
      this.fitAnal4 = var1;
   }

   public String getFitAnnexe1() {
      return this.fitAnnexe1;
   }

   public void setFitAnnexe1(String var1) {
      this.fitAnnexe1 = var1;
   }

   public String getFitAnnexe2() {
      return this.fitAnnexe2;
   }

   public void setFitAnnexe2(String var1) {
      this.fitAnnexe2 = var1;
   }

   public int getFitArrondiReg() {
      return this.fitArrondiReg;
   }

   public void setFitArrondiReg(int var1) {
      this.fitArrondiReg = var1;
   }

   public String getFitBanque() {
      return this.fitBanque;
   }

   public void setFitBanque(String var1) {
      this.fitBanque = var1;
   }

   public String getFitBudget() {
      return this.fitBudget;
   }

   public void setFitBudget(String var1) {
      this.fitBudget = var1;
   }

   public String getFitCat() {
      return this.fitCat;
   }

   public void setFitCat(String var1) {
      this.fitCat = var1;
   }

   public String getFitCivilContact() {
      return this.fitCivilContact;
   }

   public void setFitCivilContact(String var1) {
      this.fitCivilContact = var1;
   }

   public String getFitCivilTiers() {
      return this.fitCivilTiers;
   }

   public void setFitCivilTiers(String var1) {
      this.fitCivilTiers = var1;
   }

   public String getFitConditionReg() {
      return this.fitConditionReg;
   }

   public void setFitConditionReg(String var1) {
      this.fitConditionReg = var1;
   }

   public String getFitContener() {
      return this.fitContener;
   }

   public void setFitContener(String var1) {
      this.fitContener = var1;
   }

   public String getFitContrat() {
      return this.fitContrat;
   }

   public void setFitContrat(String var1) {
      this.fitContrat = var1;
   }

   public Date getFitDate() {
      return this.fitDate;
   }

   public void setFitDate(Date var1) {
      this.fitDate = var1;
   }

   public Date getFitDateAnnule() {
      return this.fitDateAnnule;
   }

   public void setFitDateAnnule(Date var1) {
      this.fitDateAnnule = var1;
   }

   public Date getFitDateCreat() {
      return this.fitDateCreat;
   }

   public void setFitDateCreat(Date var1) {
      this.fitDateCreat = var1;
   }

   public Date getFitDateEcheReg() {
      return this.fitDateEcheReg;
   }

   public void setFitDateEcheReg(Date var1) {
      this.fitDateEcheReg = var1;
   }

   public Date getFitDateImp() {
      return this.fitDateImp;
   }

   public void setFitDateImp(Date var1) {
      this.fitDateImp = var1;
   }

   public Date getFitDateLastReg() {
      return this.fitDateLastReg;
   }

   public void setFitDateLastReg(Date var1) {
      this.fitDateLastReg = var1;
   }

   public Date getFitDateLivraison() {
      return this.fitDateLivraison;
   }

   public void setFitDateLivraison(Date var1) {
      this.fitDateLivraison = var1;
   }

   public Date getFitDateModif() {
      return this.fitDateModif;
   }

   public void setFitDateModif(Date var1) {
      this.fitDateModif = var1;
   }

   public Date getFitDateRelance() {
      return this.fitDateRelance;
   }

   public void setFitDateRelance(Date var1) {
      this.fitDateRelance = var1;
   }

   public Date getFitDateTransfert() {
      return this.fitDateTransfert;
   }

   public void setFitDateTransfert(Date var1) {
      this.fitDateTransfert = var1;
   }

   public Date getFitDateTransforme() {
      return this.fitDateTransforme;
   }

   public void setFitDateTransforme(Date var1) {
      this.fitDateTransforme = var1;
   }

   public Date getFitDateValide() {
      return this.fitDateValide;
   }

   public void setFitDateValide(Date var1) {
      this.fitDateValide = var1;
   }

   public Date getFitDateValidite() {
      return this.fitDateValidite;
   }

   public void setFitDateValidite(Date var1) {
      this.fitDateValidite = var1;
   }

   public Date getFitDateVisa() {
      return this.fitDateVisa;
   }

   public void setFitDateVisa(Date var1) {
      this.fitDateVisa = var1;
   }

   public String getFitDepartement() {
      return this.fitDepartement;
   }

   public void setFitDepartement(String var1) {
      this.fitDepartement = var1;
   }

   public String getFitDevise() {
      return this.fitDevise;
   }

   public void setFitDevise(String var1) {
      this.fitDevise = var1;
   }

   public String getFitDiversAdresse() {
      return this.fitDiversAdresse;
   }

   public void setFitDiversAdresse(String var1) {
      this.fitDiversAdresse = var1;
   }

   public String getFitDiversMail() {
      return this.fitDiversMail;
   }

   public void setFitDiversMail(String var1) {
      this.fitDiversMail = var1;
   }

   public String getFitDiversNom() {
      return this.fitDiversNom;
   }

   public void setFitDiversNom(String var1) {
      this.fitDiversNom = var1;
   }

   public String getFitDiversTel() {
      return this.fitDiversTel;
   }

   public void setFitDiversTel(String var1) {
      this.fitDiversTel = var1;
   }

   public int getFitDiversTiers() {
      return this.fitDiversTiers;
   }

   public void setFitDiversTiers(int var1) {
      this.fitDiversTiers = var1;
   }

   public String getFitDiversVille() {
      return this.fitDiversVille;
   }

   public void setFitDiversVille(String var1) {
      this.fitDiversVille = var1;
   }

   public Date getFitEcheanceReliquat() {
      return this.fitEcheanceReliquat;
   }

   public void setFitEcheanceReliquat(Date var1) {
      this.fitEcheanceReliquat = var1;
   }

   public int getFitEtat() {
      return this.fitEtat;
   }

   public void setFitEtat(int var1) {
      this.fitEtat = var1;
   }

   public int getFitEtatVal() {
      return this.fitEtatVal;
   }

   public void setFitEtatVal(int var1) {
      this.fitEtatVal = var1;
   }

   public int getFitExo() {
      return this.fitExo;
   }

   public void setFitExo(int var1) {
      this.fitExo = var1;
   }

   public int getFitExoDouane() {
      return this.fitExoDouane;
   }

   public void setFitExoDouane(int var1) {
      this.fitExoDouane = var1;
   }

   public int getFitExoTva() {
      return this.fitExoTva;
   }

   public void setFitExoTva(int var1) {
      this.fitExoTva = var1;
   }

   public int getFitFactorEtat() {
      return this.fitFactorEtat;
   }

   public void setFitFactorEtat(int var1) {
      this.fitFactorEtat = var1;
   }

   public long getFitFactorId() {
      return this.fitFactorId;
   }

   public void setFitFactorId(long var1) {
      this.fitFactorId = var1;
   }

   public String getFitFactorNom() {
      return this.fitFactorNom;
   }

   public void setFitFactorNom(String var1) {
      this.fitFactorNom = var1;
   }

   public String getFitFormule1() {
      return this.fitFormule1;
   }

   public void setFitFormule1(String var1) {
      this.fitFormule1 = var1;
   }

   public String getFitFormule2() {
      return this.fitFormule2;
   }

   public void setFitFormule2(String var1) {
      this.fitFormule2 = var1;
   }

   public String getFitGarde() {
      return this.fitGarde;
   }

   public void setFitGarde(String var1) {
      this.fitGarde = var1;
   }

   public int getFitGele() {
      return this.fitGele;
   }

   public void setFitGele(int var1) {
      this.fitGele = var1;
   }

   public long getFitId() {
      return this.fitId;
   }

   public void setFitId(long var1) {
      this.fitId = var1;
   }

   public long getFitIdCommercial() {
      return this.fitIdCommercial;
   }

   public void setFitIdCommercial(long var1) {
      this.fitIdCommercial = var1;
   }

   public long getFitIdContact() {
      return this.fitIdContact;
   }

   public void setFitIdContact(long var1) {
      this.fitIdContact = var1;
   }

   public long getFitIdCreateur() {
      return this.fitIdCreateur;
   }

   public void setFitIdCreateur(long var1) {
      this.fitIdCreateur = var1;
   }

   public long getFitIdEquipe() {
      return this.fitIdEquipe;
   }

   public void setFitIdEquipe(long var1) {
      this.fitIdEquipe = var1;
   }

   public long getFitIdModif() {
      return this.fitIdModif;
   }

   public void setFitIdModif(long var1) {
      this.fitIdModif = var1;
   }

   public long getFitIdResponsable() {
      return this.fitIdResponsable;
   }

   public void setFitIdResponsable(long var1) {
      this.fitIdResponsable = var1;
   }

   public String getFitIncoterm() {
      return this.fitIncoterm;
   }

   public void setFitIncoterm(String var1) {
      this.fitIncoterm = var1;
   }

   public String getFitInfo1() {
      return this.fitInfo1;
   }

   public void setFitInfo1(String var1) {
      this.fitInfo1 = var1;
   }

   public String getFitInfo10() {
      return this.fitInfo10;
   }

   public void setFitInfo10(String var1) {
      this.fitInfo10 = var1;
   }

   public String getFitInfo2() {
      return this.fitInfo2;
   }

   public void setFitInfo2(String var1) {
      this.fitInfo2 = var1;
   }

   public String getFitInfo3() {
      return this.fitInfo3;
   }

   public void setFitInfo3(String var1) {
      this.fitInfo3 = var1;
   }

   public String getFitInfo4() {
      return this.fitInfo4;
   }

   public void setFitInfo4(String var1) {
      this.fitInfo4 = var1;
   }

   public String getFitInfo5() {
      return this.fitInfo5;
   }

   public void setFitInfo5(String var1) {
      this.fitInfo5 = var1;
   }

   public String getFitInfo6() {
      return this.fitInfo6;
   }

   public void setFitInfo6(String var1) {
      this.fitInfo6 = var1;
   }

   public String getFitInfo7() {
      return this.fitInfo7;
   }

   public void setFitInfo7(String var1) {
      this.fitInfo7 = var1;
   }

   public String getFitInfo8() {
      return this.fitInfo8;
   }

   public void setFitInfo8(String var1) {
      this.fitInfo8 = var1;
   }

   public String getFitInfo9() {
      return this.fitInfo9;
   }

   public void setFitInfo9(String var1) {
      this.fitInfo9 = var1;
   }

   public String getFitInfoLivraison() {
      return this.fitInfoLivraison;
   }

   public void setFitInfoLivraison(String var1) {
      this.fitInfoLivraison = var1;
   }

   public String getFitJournalReg() {
      return this.fitJournalReg;
   }

   public void setFitJournalReg(String var1) {
      this.fitJournalReg = var1;
   }

   public String getFitLieuLivraison() {
      return this.fitLieuLivraison;
   }

   public void setFitLieuLivraison(String var1) {
      this.fitLieuLivraison = var1;
   }

   public String getFitModeReg() {
      return this.fitModeReg;
   }

   public void setFitModeReg(String var1) {
      this.fitModeReg = var1;
   }

   public String getFitModeleImp() {
      return this.fitModeleImp;
   }

   public void setFitModeleImp(String var1) {
      this.fitModeleImp = var1;
   }

   public String getFitMotifAnnule() {
      return this.fitMotifAnnule;
   }

   public void setFitMotifAnnule(String var1) {
      this.fitMotifAnnule = var1;
   }

   public String getFitMotifExo() {
      return this.fitMotifExo;
   }

   public void setFitMotifExo(String var1) {
      this.fitMotifExo = var1;
   }

   public String getFitMotifRejetCredit() {
      return this.fitMotifRejetCredit;
   }

   public void setFitMotifRejetCredit(String var1) {
      this.fitMotifRejetCredit = var1;
   }

   public int getFitNbJourReg() {
      return this.fitNbJourReg;
   }

   public void setFitNbJourReg(int var1) {
      this.fitNbJourReg = var1;
   }

   public String getFitNomCommercial() {
      return this.fitNomCommercial;
   }

   public void setFitNomCommercial(String var1) {
      this.fitNomCommercial = var1;
   }

   public String getFitNomContact() {
      return this.fitNomContact;
   }

   public void setFitNomContact(String var1) {
      this.fitNomContact = var1;
   }

   public String getFitNomCreateur() {
      return this.fitNomCreateur;
   }

   public void setFitNomCreateur(String var1) {
      this.fitNomCreateur = var1;
   }

   public String getFitNomEquipe() {
      return this.fitNomEquipe;
   }

   public void setFitNomEquipe(String var1) {
      this.fitNomEquipe = var1;
   }

   public String getFitNomModif() {
      return this.fitNomModif;
   }

   public void setFitNomModif(String var1) {
      this.fitNomModif = var1;
   }

   public String getFitNomResponsable() {
      return this.fitNomResponsable;
   }

   public void setFitNomResponsable(String var1) {
      this.fitNomResponsable = var1;
   }

   public String getFitNomTiers() {
      return this.fitNomTiers;
   }

   public void setFitNomTiers(String var1) {
      this.fitNomTiers = var1;
   }

   public String getFitNum() {
      return this.fitNum;
   }

   public void setFitNum(String var1) {
      this.fitNum = var1;
   }

   public String getFitNumTrf() {
      return this.fitNumTrf;
   }

   public void setFitNumTrf(String var1) {
      this.fitNumTrf = var1;
   }

   public String getFitNumVisa() {
      return this.fitNumVisa;
   }

   public void setFitNumVisa(String var1) {
      this.fitNumVisa = var1;
   }

   public String getFitObject() {
      return this.fitObject;
   }

   public void setFitObject(String var1) {
      this.fitObject = var1;
   }

   public String getFitObservation() {
      return this.fitObservation;
   }

   public void setFitObservation(String var1) {
      this.fitObservation = var1;
   }

   public String getFitPdv() {
      return this.fitPdv;
   }

   public void setFitPdv(String var1) {
      this.fitPdv = var1;
   }

   public String getFitRangeVisa() {
      return this.fitRangeVisa;
   }

   public void setFitRangeVisa(String var1) {
      this.fitRangeVisa = var1;
   }

   public String getFitRegion() {
      return this.fitRegion;
   }

   public void setFitRegion(String var1) {
      this.fitRegion = var1;
   }

   public String getFitSecteur() {
      return this.fitSecteur;
   }

   public void setFitSecteur(String var1) {
      this.fitSecteur = var1;
   }

   public String getFitSerie() {
      return this.fitSerie;
   }

   public void setFitSerie(String var1) {
      this.fitSerie = var1;
   }

   public String getFitService() {
      return this.fitService;
   }

   public void setFitService(String var1) {
      this.fitService = var1;
   }

   public String getFitSite() {
      return this.fitSite;
   }

   public void setFitSite(String var1) {
      this.fitSite = var1;
   }

   public int getFitSolde() {
      return this.fitSolde;
   }

   public void setFitSolde(int var1) {
      this.fitSolde = var1;
   }

   public String getFitSource() {
      return this.fitSource;
   }

   public void setFitSource(String var1) {
      this.fitSource = var1;
   }

   public float getFitTauxRemise() {
      return this.fitTauxRemise;
   }

   public void setFitTauxRemise(float var1) {
      this.fitTauxRemise = var1;
   }

   public float getFitTauxTc() {
      return this.fitTauxTc;
   }

   public void setFitTauxTc(float var1) {
      this.fitTauxTc = var1;
   }

   public String getFitTiersRegroupe() {
      return this.fitTiersRegroupe;
   }

   public void setFitTiersRegroupe(String var1) {
      this.fitTiersRegroupe = var1;
   }

   public double getFitTotHt() {
      return this.fitTotHt;
   }

   public void setFitTotHt(double var1) {
      this.fitTotHt = var1;
   }

   public double getFitTotRabais() {
      return this.fitTotRabais;
   }

   public void setFitTotRabais(double var1) {
      this.fitTotRabais = var1;
   }

   public double getFitTotReglement() {
      return this.fitTotReglement;
   }

   public void setFitTotReglement(double var1) {
      this.fitTotReglement = var1;
   }

   public double getFitTotRemise() {
      return this.fitTotRemise;
   }

   public void setFitTotRemise(double var1) {
      this.fitTotRemise = var1;
   }

   public double getFitTotTc() {
      return this.fitTotTc;
   }

   public void setFitTotTc(double var1) {
      this.fitTotTc = var1;
   }

   public double getFitTotTtc() {
      return this.fitTotTtc;
   }

   public void setFitTotTtc(double var1) {
      this.fitTotTtc = var1;
   }

   public double getFitTotTva() {
      return this.fitTotTva;
   }

   public void setFitTotTva(double var1) {
      this.fitTotTva = var1;
   }

   public int getFitTypeReg() {
      return this.fitTypeReg;
   }

   public void setFitTypeReg(int var1) {
      this.fitTypeReg = var1;
   }

   public int getFitTypeTransforme() {
      return this.fitTypeTransforme;
   }

   public void setFitTypeTransforme(int var1) {
      this.fitTypeTransforme = var1;
   }

   public double getFitTotTimbre() {
      return this.fitTotTimbre;
   }

   public void setFitTotTimbre(double var1) {
      this.fitTotTimbre = var1;
   }

   public String getFitNumBl() {
      return this.fitNumBl;
   }

   public void setFitNumBl(String var1) {
      this.fitNumBl = var1;
   }

   public String getFitDiversNif() {
      return this.fitDiversNif;
   }

   public void setFitDiversNif(String var1) {
      this.fitDiversNif = var1;
   }
}
