package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class NoteDebitEnteteVentes implements Serializable {
   private long ndbId;
   private Date ndbDateCreat;
   private String ndbNum;
   private long ndbIdCreateur;
   private String ndbNomCreateur;
   private Date ndbDateModif;
   private long ndbIdModif;
   private String ndbNomModif;
   private Date ndbDate;
   private String ndbNomEquipe;
   private long ndbIdEquipe;
   private String ndbNomResponsable;
   private long ndbIdResponsable;
   private String ndbNomCommercial;
   private long ndbIdCommercial;
   private String ndbNomTiers;
   private String ndbCivilTiers;
   private String ndbTiersRegroupe;
   private long ndbIdContact;
   private String ndbNomContact;
   private String ndbCivilContact;
   private String ndbSerie;
   private int ndbExoTva;
   private int ndbExoDouane;
   private Date ndbDateLastReg;
   private String ndbJournalReg;
   private String ndbCat;
   private String ndbDevise;
   private String ndbObject;
   private String ndbObservation;
   private String ndbBudget;
   private float ndbTauxRemise;
   private double ndbTotHt;
   private double ndbTotRemise;
   private double ndbTotRabais;
   private double ndbTotTva;
   private float ndbTauxTc;
   private double ndbTotTc;
   private double ndbTotTtc;
   private double ndbTotReglement;
   private double ndbTotTimbre;
   private int ndbSolde;
   private String ndbBanque;
   private int ndbTypeReg;
   private String ndbModeReg;
   private Date ndbEcheanceReliquat;
   private String ndbMotifRejetCredit;
   private int ndbNbJourReg;
   private int ndbArrondiReg;
   private String ndbConditionReg;
   private Date ndbDateEcheReg;
   private String ndbContener;
   private String ndbActivite;
   private String ndbSite;
   private String ndbDepartement;
   private String ndbService;
   private String ndbRegion;
   private String ndbSecteur;
   private String ndbPdv;
   private String ndbAnal2;
   private String ndbAnal4;
   private String ndbAffaire;
   private String ndbInfo1;
   private String ndbInfo2;
   private String ndbInfo3;
   private String ndbInfo4;
   private String ndbInfo5;
   private String ndbInfo6;
   private String ndbInfo7;
   private String ndbInfo8;
   private String ndbInfo9;
   private String ndbInfo10;
   private String ndbFormule1;
   private String ndbFormule2;
   private String ndbAnnexe1;
   private String ndbAnnexe2;
   private String ndbContrat;
   private String ndbIncoterm;
   private String ndbLieuLivraison;
   private Date ndbDateLivraison;
   private String ndbInfoLivraison;
   private Date ndbDateImp;
   private String ndbModeleImp;
   private String ndbGarde;
   private int ndbEtatVal;
   private int ndbGele;
   private int ndbEtat;
   private String ndbNumTrf;
   private Date ndbDateValidite;
   private Date ndbDateRelance;
   private Date ndbDateValide;
   private int ndbPosSignature;
   private Date ndbDateTransforme;
   private int ndbTypeTransforme;
   private Date ndbDateAnnule;
   private String ndbMotifAnnule;
   private int ndbExo;
   private String ndbMotifExo;
   private String ndbNumVisa;
   private Date ndbDateVisa;
   private String ndbRangeVisa;
   private Date ndbDateTransfert;
   private String ndbFactorNom;
   private long ndbFactorId;
   private int ndbFactorEtat;
   private int ndbDiversTiers;
   private String ndbDiversNom;
   private String ndbDiversAdresse;
   private String ndbDiversVille;
   private String ndbDiversTel;
   private String ndbDiversMail;
   private String ndbDiversNif;
   private String ndbSource;
   private String ndbNumClient;
   private Date ndbDateClient;
   private float ndbPoids;
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
   private double var_fac_timbre;
   private double montantReglementManuel;

   public double getMontantReglementManuel() {
      return this.montantReglementManuel;
   }

   public void setMontantReglementManuel(double var1) {
      this.montantReglementManuel = var1;
   }

   public double getVar_fac_timbre() {
      return this.var_fac_timbre;
   }

   public void setVar_fac_timbre(double var1) {
      this.var_fac_timbre = var1;
   }

   public String getVar_nom_tiers() {
      if (this.ndbDiversNom != null && !this.ndbDiversNom.isEmpty()) {
         this.var_nom_tiers = this.ndbDiversNom;
      } else if (this.ndbCivilTiers != null && !this.ndbCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.ndbCivilTiers + " " + this.ndbNomTiers;
      } else {
         this.var_nom_tiers = this.ndbNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.ndbDiversNom != null && !this.ndbDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.ndbCivilContact != null && !this.ndbCivilContact.isEmpty()) {
         if (this.ndbNomContact != null && !this.ndbNomContact.isEmpty()) {
            this.var_nomContact = this.ndbCivilContact + " " + this.ndbNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.ndbNomContact != null && !this.ndbNomContact.isEmpty()) {
         this.var_nomContact = this.ndbNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.ndbTotTtc + this.ndbTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getLibelleEta() {
      if (this.ndbEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.ndbEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.ndbEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.ndbEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.ndbEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.ndbEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVar_solde() {
      if (this.ndbSolde == 1) {
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

   public int getVar_format_devise() {
      if (!this.ndbDevise.equals("XOF") && !this.ndbDevise.equals("XAF")) {
         if (!this.ndbDevise.equals("EUR") && !this.ndbDevise.equals("XEU") && !this.ndbDevise.equals("CHF")) {
            this.var_format_devise = 0;
         } else {
            this.var_format_devise = 1;
         }
      } else {
         this.var_format_devise = 2;
      }

      return this.var_format_devise;
   }

   public double getVar_reliquatListe() {
      this.var_reliquatListe = this.ndbTotTtc + this.ndbTotTc + this.ndbTotTimbre - this.ndbTotReglement;
      return this.var_reliquatListe;
   }

   public void setVar_reliquatListe(double var1) {
      this.var_reliquatListe = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.ndbTotTtc + this.ndbTotTc + this.var_fac_timbre - this.ndbTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public String getNdbActivite() {
      return this.ndbActivite;
   }

   public void setNdbActivite(String var1) {
      this.ndbActivite = var1;
   }

   public String getNdbAnal2() {
      return this.ndbAnal2;
   }

   public void setNdbAnal2(String var1) {
      this.ndbAnal2 = var1;
   }

   public String getNdbAnal4() {
      return this.ndbAnal4;
   }

   public void setNdbAnal4(String var1) {
      this.ndbAnal4 = var1;
   }

   public String getNdbAnnexe1() {
      return this.ndbAnnexe1;
   }

   public void setNdbAnnexe1(String var1) {
      this.ndbAnnexe1 = var1;
   }

   public String getNdbAnnexe2() {
      return this.ndbAnnexe2;
   }

   public void setNdbAnnexe2(String var1) {
      this.ndbAnnexe2 = var1;
   }

   public int getNdbArrondiReg() {
      return this.ndbArrondiReg;
   }

   public void setNdbArrondiReg(int var1) {
      this.ndbArrondiReg = var1;
   }

   public String getNdbBanque() {
      return this.ndbBanque;
   }

   public void setNdbBanque(String var1) {
      this.ndbBanque = var1;
   }

   public String getNdbBudget() {
      return this.ndbBudget;
   }

   public void setNdbBudget(String var1) {
      this.ndbBudget = var1;
   }

   public String getNdbCat() {
      return this.ndbCat;
   }

   public void setNdbCat(String var1) {
      this.ndbCat = var1;
   }

   public String getNdbConditionReg() {
      return this.ndbConditionReg;
   }

   public void setNdbConditionReg(String var1) {
      this.ndbConditionReg = var1;
   }

   public String getNdbContrat() {
      return this.ndbContrat;
   }

   public void setNdbContrat(String var1) {
      this.ndbContrat = var1;
   }

   public Date getNdbDateCreat() {
      return this.ndbDateCreat;
   }

   public void setNdbDateCreat(Date var1) {
      this.ndbDateCreat = var1;
   }

   public Date getNdbDateAnnule() {
      return this.ndbDateAnnule;
   }

   public void setNdbDateAnnule(Date var1) {
      this.ndbDateAnnule = var1;
   }

   public Date getNdbDateEcheReg() {
      return this.ndbDateEcheReg;
   }

   public void setNdbDateEcheReg(Date var1) {
      this.ndbDateEcheReg = var1;
   }

   public Date getNdbDateImp() {
      return this.ndbDateImp;
   }

   public void setNdbDateImp(Date var1) {
      this.ndbDateImp = var1;
   }

   public Date getNdbDateLivraison() {
      return this.ndbDateLivraison;
   }

   public void setNdbDateLivraison(Date var1) {
      this.ndbDateLivraison = var1;
   }

   public Date getNdbDateRelance() {
      return this.ndbDateRelance;
   }

   public void setNdbDateRelance(Date var1) {
      this.ndbDateRelance = var1;
   }

   public Date getNdbDateTransforme() {
      return this.ndbDateTransforme;
   }

   public void setNdbDateTransforme(Date var1) {
      this.ndbDateTransforme = var1;
   }

   public Date getNdbDateValide() {
      return this.ndbDateValide;
   }

   public void setNdbDateValide(Date var1) {
      this.ndbDateValide = var1;
   }

   public Date getNdbDateValidite() {
      return this.ndbDateValidite;
   }

   public void setNdbDateValidite(Date var1) {
      this.ndbDateValidite = var1;
   }

   public String getNdbDepartement() {
      return this.ndbDepartement;
   }

   public void setNdbDepartement(String var1) {
      this.ndbDepartement = var1;
   }

   public String getNdbDevise() {
      return this.ndbDevise;
   }

   public void setNdbDevise(String var1) {
      this.ndbDevise = var1;
   }

   public int getNdbEtat() {
      return this.ndbEtat;
   }

   public void setNdbEtat(int var1) {
      this.ndbEtat = var1;
   }

   public int getNdbEtatVal() {
      return this.ndbEtatVal;
   }

   public void setNdbEtatVal(int var1) {
      this.ndbEtatVal = var1;
   }

   public String getNdbFormule1() {
      return this.ndbFormule1;
   }

   public void setNdbFormule1(String var1) {
      this.ndbFormule1 = var1;
   }

   public String getNdbFormule2() {
      return this.ndbFormule2;
   }

   public void setNdbFormule2(String var1) {
      this.ndbFormule2 = var1;
   }

   public String getNdbGarde() {
      return this.ndbGarde;
   }

   public void setNdbGarde(String var1) {
      this.ndbGarde = var1;
   }

   public int getNdbGele() {
      return this.ndbGele;
   }

   public void setNdbGele(int var1) {
      this.ndbGele = var1;
   }

   public long getNdbId() {
      return this.ndbId;
   }

   public void setNdbId(long var1) {
      this.ndbId = var1;
   }

   public long getNdbIdCreateur() {
      return this.ndbIdCreateur;
   }

   public void setNdbIdCreateur(long var1) {
      this.ndbIdCreateur = var1;
   }

   public String getNdbIncoterm() {
      return this.ndbIncoterm;
   }

   public void setNdbIncoterm(String var1) {
      this.ndbIncoterm = var1;
   }

   public String getNdbInfoLivraison() {
      return this.ndbInfoLivraison;
   }

   public void setNdbInfoLivraison(String var1) {
      this.ndbInfoLivraison = var1;
   }

   public String getNdbLieuLivraison() {
      return this.ndbLieuLivraison;
   }

   public void setNdbLieuLivraison(String var1) {
      this.ndbLieuLivraison = var1;
   }

   public String getNdbModeReg() {
      return this.ndbModeReg;
   }

   public void setNdbModeReg(String var1) {
      this.ndbModeReg = var1;
   }

   public String getNdbModeleImp() {
      return this.ndbModeleImp;
   }

   public void setNdbModeleImp(String var1) {
      this.ndbModeleImp = var1;
   }

   public String getNdbMotifAnnule() {
      return this.ndbMotifAnnule;
   }

   public void setNdbMotifAnnule(String var1) {
      this.ndbMotifAnnule = var1;
   }

   public int getNdbNbJourReg() {
      return this.ndbNbJourReg;
   }

   public void setNdbNbJourReg(int var1) {
      this.ndbNbJourReg = var1;
   }

   public String getNdbInfo1() {
      return this.ndbInfo1;
   }

   public void setNdbInfo1(String var1) {
      this.ndbInfo1 = var1;
   }

   public String getNdbInfo10() {
      return this.ndbInfo10;
   }

   public void setNdbInfo10(String var1) {
      this.ndbInfo10 = var1;
   }

   public String getNdbInfo2() {
      return this.ndbInfo2;
   }

   public void setNdbInfo2(String var1) {
      this.ndbInfo2 = var1;
   }

   public String getNdbInfo3() {
      return this.ndbInfo3;
   }

   public void setNdbInfo3(String var1) {
      this.ndbInfo3 = var1;
   }

   public String getNdbInfo4() {
      return this.ndbInfo4;
   }

   public void setNdbInfo4(String var1) {
      this.ndbInfo4 = var1;
   }

   public String getNdbInfo5() {
      return this.ndbInfo5;
   }

   public void setNdbInfo5(String var1) {
      this.ndbInfo5 = var1;
   }

   public String getNdbInfo6() {
      return this.ndbInfo6;
   }

   public void setNdbInfo6(String var1) {
      this.ndbInfo6 = var1;
   }

   public String getNdbInfo7() {
      return this.ndbInfo7;
   }

   public void setNdbInfo7(String var1) {
      this.ndbInfo7 = var1;
   }

   public String getNdbInfo8() {
      return this.ndbInfo8;
   }

   public void setNdbInfo8(String var1) {
      this.ndbInfo8 = var1;
   }

   public String getNdbInfo9() {
      return this.ndbInfo9;
   }

   public void setNdbInfo9(String var1) {
      this.ndbInfo9 = var1;
   }

   public String getNdbNomContact() {
      if (this.ndbNomContact != null && !this.ndbNomContact.isEmpty()) {
         this.ndbNomContact = this.ndbNomContact.toUpperCase();
      }

      return this.ndbNomContact;
   }

   public void setNdbNomContact(String var1) {
      this.ndbNomContact = var1;
   }

   public String getNdbNomCreateur() {
      return this.ndbNomCreateur;
   }

   public void setNdbNomCreateur(String var1) {
      this.ndbNomCreateur = var1;
   }

   public String getNdbNomResponsable() {
      return this.ndbNomResponsable;
   }

   public void setNdbNomResponsable(String var1) {
      this.ndbNomResponsable = var1;
   }

   public String getNdbNomTiers() {
      return this.ndbNomTiers;
   }

   public void setNdbNomTiers(String var1) {
      this.ndbNomTiers = var1;
   }

   public String getNdbNum() {
      return this.ndbNum;
   }

   public void setNdbNum(String var1) {
      this.ndbNum = var1;
   }

   public String getNdbObject() {
      return this.ndbObject;
   }

   public void setNdbObject(String var1) {
      this.ndbObject = var1;
   }

   public String getNdbObservation() {
      return this.ndbObservation;
   }

   public void setNdbObservation(String var1) {
      this.ndbObservation = var1;
   }

   public String getNdbPdv() {
      return this.ndbPdv;
   }

   public void setNdbPdv(String var1) {
      this.ndbPdv = var1;
   }

   public String getNdbRegion() {
      return this.ndbRegion;
   }

   public void setNdbRegion(String var1) {
      this.ndbRegion = var1;
   }

   public String getNdbSecteur() {
      return this.ndbSecteur;
   }

   public void setNdbSecteur(String var1) {
      this.ndbSecteur = var1;
   }

   public String getNdbSerie() {
      return this.ndbSerie;
   }

   public void setNdbSerie(String var1) {
      this.ndbSerie = var1;
   }

   public String getNdbService() {
      return this.ndbService;
   }

   public void setNdbService(String var1) {
      this.ndbService = var1;
   }

   public String getNdbSite() {
      return this.ndbSite;
   }

   public void setNdbSite(String var1) {
      this.ndbSite = var1;
   }

   public int getNdbSolde() {
      return this.ndbSolde;
   }

   public void setNdbSolde(int var1) {
      this.ndbSolde = var1;
   }

   public double getNdbTotHt() {
      return this.ndbTotHt;
   }

   public void setNdbTotHt(double var1) {
      this.ndbTotHt = var1;
   }

   public double getNdbTotRabais() {
      return this.ndbTotRabais;
   }

   public void setNdbTotRabais(double var1) {
      this.ndbTotRabais = var1;
   }

   public double getNdbTotReglement() {
      return this.ndbTotReglement;
   }

   public void setNdbTotReglement(double var1) {
      this.ndbTotReglement = var1;
   }

   public double getNdbTotRemise() {
      return this.ndbTotRemise;
   }

   public void setNdbTotRemise(double var1) {
      this.ndbTotRemise = var1;
   }

   public double getNdbTotTc() {
      return this.ndbTotTc;
   }

   public void setNdbTotTc(double var1) {
      this.ndbTotTc = var1;
   }

   public double getNdbTotTtc() {
      return this.ndbTotTtc;
   }

   public void setNdbTotTtc(double var1) {
      this.ndbTotTtc = var1;
   }

   public double getNdbTotTva() {
      return this.ndbTotTva;
   }

   public void setNdbTotTva(double var1) {
      this.ndbTotTva = var1;
   }

   public int getNdbTypeReg() {
      return this.ndbTypeReg;
   }

   public void setNdbTypeReg(int var1) {
      this.ndbTypeReg = var1;
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

   public Date getNdbDateModif() {
      return this.ndbDateModif;
   }

   public void setNdbDateModif(Date var1) {
      this.ndbDateModif = var1;
   }

   public long getNdbIdModif() {
      return this.ndbIdModif;
   }

   public void setNdbIdModif(long var1) {
      this.ndbIdModif = var1;
   }

   public String getNdbNomModif() {
      return this.ndbNomModif;
   }

   public void setNdbNomModif(String var1) {
      this.ndbNomModif = var1;
   }

   public Date getNdbDate() {
      return this.ndbDate;
   }

   public void setNdbDate(Date var1) {
      this.ndbDate = var1;
   }

   public int getNdbFactorEtat() {
      return this.ndbFactorEtat;
   }

   public void setNdbFactorEtat(int var1) {
      this.ndbFactorEtat = var1;
   }

   public long getNdbFactorId() {
      return this.ndbFactorId;
   }

   public void setNdbFactorId(long var1) {
      this.ndbFactorId = var1;
   }

   public String getNdbFactorNom() {
      return this.ndbFactorNom;
   }

   public void setNdbFactorNom(String var1) {
      this.ndbFactorNom = var1;
   }

   public int getNdbExoDouane() {
      return this.ndbExoDouane;
   }

   public void setNdbExoDouane(int var1) {
      this.ndbExoDouane = var1;
   }

   public int getNdbExoTva() {
      return this.ndbExoTva;
   }

   public void setNdbExoTva(int var1) {
      this.ndbExoTva = var1;
   }

   public String getNdbJournalReg() {
      return this.ndbJournalReg;
   }

   public void setNdbJournalReg(String var1) {
      this.ndbJournalReg = var1;
   }

   public Date getNdbDateVisa() {
      return this.ndbDateVisa;
   }

   public void setNdbDateVisa(Date var1) {
      this.ndbDateVisa = var1;
   }

   public int getNdbExo() {
      return this.ndbExo;
   }

   public void setNdbExo(int var1) {
      this.ndbExo = var1;
   }

   public String getNdbMotifExo() {
      return this.ndbMotifExo;
   }

   public void setNdbMotifExo(String var1) {
      this.ndbMotifExo = var1;
   }

   public String getNdbNumVisa() {
      return this.ndbNumVisa;
   }

   public void setNdbNumVisa(String var1) {
      this.ndbNumVisa = var1;
   }

   public String getNdbRangeVisa() {
      return this.ndbRangeVisa;
   }

   public void setNdbRangeVisa(String var1) {
      this.ndbRangeVisa = var1;
   }

   public String getNdbCivilContact() {
      return this.ndbCivilContact;
   }

   public void setNdbCivilContact(String var1) {
      this.ndbCivilContact = var1;
   }

   public String getNdbCivilTiers() {
      return this.ndbCivilTiers;
   }

   public void setNdbCivilTiers(String var1) {
      this.ndbCivilTiers = var1;
   }

   public long getNdbIdResponsable() {
      return this.ndbIdResponsable;
   }

   public void setNdbIdResponsable(long var1) {
      this.ndbIdResponsable = var1;
   }

   public int getNdbTypeTransforme() {
      return this.ndbTypeTransforme;
   }

   public void setNdbTypeTransforme(int var1) {
      this.ndbTypeTransforme = var1;
   }

   public long getNdbIdContact() {
      return this.ndbIdContact;
   }

   public void setNdbIdContact(long var1) {
      this.ndbIdContact = var1;
   }

   public Date getNdbEcheanceReliquat() {
      return this.ndbEcheanceReliquat;
   }

   public void setNdbEcheanceReliquat(Date var1) {
      this.ndbEcheanceReliquat = var1;
   }

   public String getNdbMotifRejetCredit() {
      return this.ndbMotifRejetCredit;
   }

   public void setNdbMotifRejetCredit(String var1) {
      this.ndbMotifRejetCredit = var1;
   }

   public Date getNdbDateTransfert() {
      return this.ndbDateTransfert;
   }

   public void setNdbDateTransfert(Date var1) {
      this.ndbDateTransfert = var1;
   }

   public float getNdbTauxTc() {
      return this.ndbTauxTc;
   }

   public void setNdbTauxTc(float var1) {
      this.ndbTauxTc = var1;
   }

   public String getNdbDiversAdresse() {
      return this.ndbDiversAdresse;
   }

   public void setNdbDiversAdresse(String var1) {
      this.ndbDiversAdresse = var1;
   }

   public String getNdbDiversMail() {
      return this.ndbDiversMail;
   }

   public void setNdbDiversMail(String var1) {
      this.ndbDiversMail = var1;
   }

   public String getNdbDiversNom() {
      if (this.ndbDiversNom != null && !this.ndbDiversNom.isEmpty()) {
         this.ndbDiversNom = this.ndbDiversNom.toUpperCase();
      }

      return this.ndbDiversNom;
   }

   public void setNdbDiversNom(String var1) {
      this.ndbDiversNom = var1;
   }

   public String getNdbDiversTel() {
      return this.ndbDiversTel;
   }

   public void setNdbDiversTel(String var1) {
      this.ndbDiversTel = var1;
   }

   public int getNdbDiversTiers() {
      return this.ndbDiversTiers;
   }

   public void setNdbDiversTiers(int var1) {
      this.ndbDiversTiers = var1;
   }

   public String getNdbDiversVille() {
      return this.ndbDiversVille;
   }

   public void setNdbDiversVille(String var1) {
      this.ndbDiversVille = var1;
   }

   public long getNdbIdCommercial() {
      return this.ndbIdCommercial;
   }

   public void setNdbIdCommercial(long var1) {
      this.ndbIdCommercial = var1;
   }

   public String getNdbNomCommercial() {
      return this.ndbNomCommercial;
   }

   public void setNdbNomCommercial(String var1) {
      this.ndbNomCommercial = var1;
   }

   public Date getNdbDateLastReg() {
      return this.ndbDateLastReg;
   }

   public void setNdbDateLastReg(Date var1) {
      this.ndbDateLastReg = var1;
   }

   public long getNdbIdEquipe() {
      return this.ndbIdEquipe;
   }

   public void setNdbIdEquipe(long var1) {
      this.ndbIdEquipe = var1;
   }

   public String getNdbNomEquipe() {
      return this.ndbNomEquipe;
   }

   public void setNdbNomEquipe(String var1) {
      this.ndbNomEquipe = var1;
   }

   public String getNdbNumTrf() {
      return this.ndbNumTrf;
   }

   public void setNdbNumTrf(String var1) {
      this.ndbNumTrf = var1;
   }

   public String getNdbSource() {
      return this.ndbSource;
   }

   public void setNdbSource(String var1) {
      this.ndbSource = var1;
   }

   public float getNdbTauxRemise() {
      return this.ndbTauxRemise;
   }

   public void setNdbTauxRemise(float var1) {
      this.ndbTauxRemise = var1;
   }

   public String getNdbTiersRegroupe() {
      return this.ndbTiersRegroupe;
   }

   public void setNdbTiersRegroupe(String var1) {
      this.ndbTiersRegroupe = var1;
   }

   public String getNdbContener() {
      return this.ndbContener;
   }

   public void setNdbContener(String var1) {
      this.ndbContener = var1;
   }

   public double getNdbTotTimbre() {
      return this.ndbTotTimbre;
   }

   public void setNdbTotTimbre(double var1) {
      this.ndbTotTimbre = var1;
   }

   public int getNdbPosSignature() {
      return this.ndbPosSignature;
   }

   public void setNdbPosSignature(int var1) {
      this.ndbPosSignature = var1;
   }

   public Date getNdbDateClient() {
      return this.ndbDateClient;
   }

   public void setNdbDateClient(Date var1) {
      this.ndbDateClient = var1;
   }

   public String getNdbNumClient() {
      return this.ndbNumClient;
   }

   public void setNdbNumClient(String var1) {
      this.ndbNumClient = var1;
   }

   public String getNdbAffaire() {
      return this.ndbAffaire;
   }

   public void setNdbAffaire(String var1) {
      this.ndbAffaire = var1;
   }

   public float getNdbPoids() {
      return this.ndbPoids;
   }

   public void setNdbPoids(float var1) {
      this.ndbPoids = var1;
   }

   public String getNdbDiversNif() {
      return this.ndbDiversNif;
   }

   public void setNdbDiversNif(String var1) {
      this.ndbDiversNif = var1;
   }
}
