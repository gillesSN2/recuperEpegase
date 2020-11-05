package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class AvoirEnteteVentes implements Serializable {
   private long avrId;
   private Date avrDateCreat;
   private String avrNum;
   private long avrIdCreateur;
   private String avrNomCreateur;
   private Date avrDateModif;
   private long avrIdModif;
   private String avrNomModif;
   private Date avrDate;
   private String avrNomEquipe;
   private long avrIdEquipe;
   private String avrNomResponsable;
   private long avrIdResponsable;
   private String avrNomCommercial;
   private long avrIdCommercial;
   private String avrNomTiers;
   private String avrCivilTiers;
   private String avrTiersRegroupe;
   private long avrIdContact;
   private String avrNomContact;
   private String avrCivilContact;
   private String avrSerie;
   private int avrExoTva;
   private int avrExoDouane;
   private Date avrDateLastReg;
   private String avrJournalReg;
   private String avrCat;
   private String avrDevise;
   private String avrObject;
   private String avrObservation;
   private String avrBudget;
   private float avrTauxRemise;
   private double avrTotHt;
   private double avrTotRemise;
   private double avrTotRabais;
   private double avrTotTva;
   private float avrTauxTc;
   private double avrTotTc;
   private double avrTotTtc;
   private double avrTotReglement;
   private int avrSolde;
   private String avrBanque;
   private int avrTypeReg;
   private String avrModeReg;
   private int avrNbJourReg;
   private int avrArrondiReg;
   private String avrConditionReg;
   private Date avrDateEcheReg;
   private String avrContener;
   private String avrActivite;
   private String avrSite;
   private String avrDepartement;
   private String avrService;
   private String avrRegion;
   private String avrSecteur;
   private String avrPdv;
   private String avrAnal2;
   private String avrAnal4;
   private String avrAffaire;
   private String avrInfo1;
   private String avrInfo2;
   private String avrInfo3;
   private String avrInfo4;
   private String avrInfo5;
   private String avrInfo6;
   private String avrInfo7;
   private String avrInfo8;
   private String avrInfo9;
   private String avrInfo10;
   private String avrFormule1;
   private String avrFormule2;
   private String avrAnnexe1;
   private String avrAnnexe2;
   private String avrContrat;
   private String avrIncoterm;
   private String avrLieuLivraison;
   private Date avrDateLivraison;
   private String avrInfoLivraison;
   private Date avrDateImp;
   private String avrModeleImp;
   private String avrGarde;
   private int avrEtatVal;
   private int avrGele;
   private int avrEtat;
   private String avrNumTrf;
   private Date avrDateValidite;
   private Date avrDateRelance;
   private Date avrDateValide;
   private int avrPosSignature;
   private Date avrDateTransforme;
   private int avrTypeTransforme;
   private Date avrDateAnnule;
   private String avrMotifAnnule;
   private int avrExo;
   private String avrMotifExo;
   private String avrNumVisa;
   private Date avrDateVisa;
   private String avrRangeVisa;
   private Date avrDateTransfert;
   private String avrFactorNom;
   private long avrFactorId;
   private int avrFactorEtat;
   private int avrDiversTiers;
   private String avrDiversNom;
   private String avrDiversAdresse;
   private String avrDiversVille;
   private String avrDiversTel;
   private String avrDiversMail;
   private String avrDiversNif;
   private String avrNumRetour;
   private String avrNumFacture;
   private String avrNumBC;
   private String avrNumBL;
   private String avrSource;
   private String avrNumClient;
   private Date avrDateClient;
   private float avrPoids;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private String var_solde;
   private double var_reliquat;
   private boolean var_select_ligne;
   private int var_format_devise;
   private double varTotTtcGlob;
   private String var_nomContact;
   private String var_nom_tiers;
   private String montantLettre;
   private String dupplicata;
   private String infoOrigineDoc;
   private String parcImmatriculation;

   public String getDupplicata() {
      return this.dupplicata;
   }

   public void setDupplicata(String var1) {
      this.dupplicata = var1;
   }

   public String getInfoOrigineDoc() {
      return this.infoOrigineDoc;
   }

   public void setInfoOrigineDoc(String var1) {
      this.infoOrigineDoc = var1;
   }

   public String getParcImmatriculation() {
      return this.parcImmatriculation;
   }

   public void setParcImmatriculation(String var1) {
      this.parcImmatriculation = var1;
   }

   public String getMontantLettre() {
      return this.montantLettre;
   }

   public void setMontantLettre(String var1) {
      this.montantLettre = var1;
   }

   public String getVar_nom_tiers() {
      if (this.avrDiversNom != null && !this.avrDiversNom.isEmpty()) {
         this.var_nom_tiers = this.avrDiversNom;
      } else if (this.avrCivilTiers != null && !this.avrCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.avrCivilTiers + " " + this.avrNomTiers;
      } else {
         this.var_nom_tiers = this.avrNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.avrDiversNom != null && !this.avrDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.avrCivilContact != null && !this.avrCivilContact.isEmpty()) {
         if (this.avrNomContact != null && !this.avrNomContact.isEmpty()) {
            this.var_nomContact = this.avrCivilContact + " " + this.avrNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.avrNomContact != null && !this.avrNomContact.isEmpty()) {
         this.var_nomContact = this.avrNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.avrTotTtc + this.avrTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getLibelleEta() {
      if (this.avrEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.avrEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.avrEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.avrEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.avrEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.avrEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVar_solde() {
      if (this.avrSolde == 1) {
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
      this.var_reliquat = this.avrTotTtc - this.avrTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public int getVar_format_devise() {
      if (!this.avrDevise.equals("XOF") && !this.avrDevise.equals("XAF")) {
         if (!this.avrDevise.equals("EUR") && !this.avrDevise.equals("XEU") && !this.avrDevise.equals("CHF")) {
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

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public String getAvrActivite() {
      return this.avrActivite;
   }

   public void setAvrActivite(String var1) {
      this.avrActivite = var1;
   }

   public String getAvrAnal2() {
      return this.avrAnal2;
   }

   public void setAvrAnal2(String var1) {
      this.avrAnal2 = var1;
   }

   public String getAvrAnal4() {
      return this.avrAnal4;
   }

   public void setAvrAnal4(String var1) {
      this.avrAnal4 = var1;
   }

   public String getAvrAnnexe1() {
      return this.avrAnnexe1;
   }

   public void setAvrAnnexe1(String var1) {
      this.avrAnnexe1 = var1;
   }

   public String getAvrAnnexe2() {
      return this.avrAnnexe2;
   }

   public void setAvrAnnexe2(String var1) {
      this.avrAnnexe2 = var1;
   }

   public int getAvrArrondiReg() {
      return this.avrArrondiReg;
   }

   public void setAvrArrondiReg(int var1) {
      this.avrArrondiReg = var1;
   }

   public String getAvrBanque() {
      return this.avrBanque;
   }

   public void setAvrBanque(String var1) {
      this.avrBanque = var1;
   }

   public String getAvrBudget() {
      return this.avrBudget;
   }

   public void setAvrBudget(String var1) {
      this.avrBudget = var1;
   }

   public String getAvrCat() {
      return this.avrCat;
   }

   public void setAvrCat(String var1) {
      this.avrCat = var1;
   }

   public String getAvrConditionReg() {
      return this.avrConditionReg;
   }

   public void setAvrConditionReg(String var1) {
      this.avrConditionReg = var1;
   }

   public String getAvrContrat() {
      return this.avrContrat;
   }

   public void setAvrContrat(String var1) {
      this.avrContrat = var1;
   }

   public Date getAvrDateCreat() {
      return this.avrDateCreat;
   }

   public void setAvrDateCreat(Date var1) {
      this.avrDateCreat = var1;
   }

   public Date getAvrDateAnnule() {
      return this.avrDateAnnule;
   }

   public void setAvrDateAnnule(Date var1) {
      this.avrDateAnnule = var1;
   }

   public Date getAvrDateEcheReg() {
      return this.avrDateEcheReg;
   }

   public void setAvrDateEcheReg(Date var1) {
      this.avrDateEcheReg = var1;
   }

   public Date getAvrDateImp() {
      return this.avrDateImp;
   }

   public void setAvrDateImp(Date var1) {
      this.avrDateImp = var1;
   }

   public Date getAvrDateLivraison() {
      return this.avrDateLivraison;
   }

   public void setAvrDateLivraison(Date var1) {
      this.avrDateLivraison = var1;
   }

   public Date getAvrDateRelance() {
      return this.avrDateRelance;
   }

   public void setAvrDateRelance(Date var1) {
      this.avrDateRelance = var1;
   }

   public Date getAvrDateTransforme() {
      return this.avrDateTransforme;
   }

   public void setAvrDateTransforme(Date var1) {
      this.avrDateTransforme = var1;
   }

   public Date getAvrDateValide() {
      return this.avrDateValide;
   }

   public void setAvrDateValide(Date var1) {
      this.avrDateValide = var1;
   }

   public Date getAvrDateValidite() {
      return this.avrDateValidite;
   }

   public void setAvrDateValidite(Date var1) {
      this.avrDateValidite = var1;
   }

   public String getAvrDepartement() {
      return this.avrDepartement;
   }

   public void setAvrDepartement(String var1) {
      this.avrDepartement = var1;
   }

   public String getAvrDevise() {
      return this.avrDevise;
   }

   public void setAvrDevise(String var1) {
      this.avrDevise = var1;
   }

   public int getAvrEtat() {
      return this.avrEtat;
   }

   public void setAvrEtat(int var1) {
      this.avrEtat = var1;
   }

   public int getAvrEtatVal() {
      return this.avrEtatVal;
   }

   public void setAvrEtatVal(int var1) {
      this.avrEtatVal = var1;
   }

   public String getAvrFormule1() {
      return this.avrFormule1;
   }

   public void setAvrFormule1(String var1) {
      this.avrFormule1 = var1;
   }

   public String getAvrFormule2() {
      return this.avrFormule2;
   }

   public void setAvrFormule2(String var1) {
      this.avrFormule2 = var1;
   }

   public String getAvrGarde() {
      return this.avrGarde;
   }

   public void setAvrGarde(String var1) {
      this.avrGarde = var1;
   }

   public int getAvrGele() {
      return this.avrGele;
   }

   public void setAvrGele(int var1) {
      this.avrGele = var1;
   }

   public long getAvrId() {
      return this.avrId;
   }

   public void setAvrId(long var1) {
      this.avrId = var1;
   }

   public long getAvrIdCreateur() {
      return this.avrIdCreateur;
   }

   public void setAvrIdCreateur(long var1) {
      this.avrIdCreateur = var1;
   }

   public String getAvrIncoterm() {
      return this.avrIncoterm;
   }

   public void setAvrIncoterm(String var1) {
      this.avrIncoterm = var1;
   }

   public String getAvrInfoLivraison() {
      return this.avrInfoLivraison;
   }

   public void setAvrInfoLivraison(String var1) {
      this.avrInfoLivraison = var1;
   }

   public String getAvrLieuLivraison() {
      return this.avrLieuLivraison;
   }

   public void setAvrLieuLivraison(String var1) {
      this.avrLieuLivraison = var1;
   }

   public String getAvrModeReg() {
      return this.avrModeReg;
   }

   public void setAvrModeReg(String var1) {
      this.avrModeReg = var1;
   }

   public String getAvrModeleImp() {
      return this.avrModeleImp;
   }

   public void setAvrModeleImp(String var1) {
      this.avrModeleImp = var1;
   }

   public String getAvrMotifAnnule() {
      return this.avrMotifAnnule;
   }

   public void setAvrMotifAnnule(String var1) {
      this.avrMotifAnnule = var1;
   }

   public int getAvrNbJourReg() {
      return this.avrNbJourReg;
   }

   public void setAvrNbJourReg(int var1) {
      this.avrNbJourReg = var1;
   }

   public String getAvrInfo1() {
      return this.avrInfo1;
   }

   public void setAvrInfo1(String var1) {
      this.avrInfo1 = var1;
   }

   public String getAvrInfo10() {
      return this.avrInfo10;
   }

   public void setAvrInfo10(String var1) {
      this.avrInfo10 = var1;
   }

   public String getAvrInfo2() {
      return this.avrInfo2;
   }

   public void setAvrInfo2(String var1) {
      this.avrInfo2 = var1;
   }

   public String getAvrInfo3() {
      return this.avrInfo3;
   }

   public void setAvrInfo3(String var1) {
      this.avrInfo3 = var1;
   }

   public String getAvrInfo4() {
      return this.avrInfo4;
   }

   public void setAvrInfo4(String var1) {
      this.avrInfo4 = var1;
   }

   public String getAvrInfo5() {
      return this.avrInfo5;
   }

   public void setAvrInfo5(String var1) {
      this.avrInfo5 = var1;
   }

   public String getAvrInfo6() {
      return this.avrInfo6;
   }

   public void setAvrInfo6(String var1) {
      this.avrInfo6 = var1;
   }

   public String getAvrInfo7() {
      return this.avrInfo7;
   }

   public void setAvrInfo7(String var1) {
      this.avrInfo7 = var1;
   }

   public String getAvrInfo8() {
      return this.avrInfo8;
   }

   public void setAvrInfo8(String var1) {
      this.avrInfo8 = var1;
   }

   public String getAvrInfo9() {
      return this.avrInfo9;
   }

   public void setAvrInfo9(String var1) {
      this.avrInfo9 = var1;
   }

   public String getAvrNomContact() {
      if (this.avrNomContact != null && !this.avrNomContact.isEmpty()) {
         this.avrNomContact = this.avrNomContact.toUpperCase();
      }

      return this.avrNomContact;
   }

   public void setAvrNomContact(String var1) {
      this.avrNomContact = var1;
   }

   public String getAvrNomCreateur() {
      return this.avrNomCreateur;
   }

   public void setAvrNomCreateur(String var1) {
      this.avrNomCreateur = var1;
   }

   public String getAvrNomResponsable() {
      return this.avrNomResponsable;
   }

   public void setAvrNomResponsable(String var1) {
      this.avrNomResponsable = var1;
   }

   public String getAvrNomTiers() {
      return this.avrNomTiers;
   }

   public void setAvrNomTiers(String var1) {
      this.avrNomTiers = var1;
   }

   public String getAvrNum() {
      return this.avrNum;
   }

   public void setAvrNum(String var1) {
      this.avrNum = var1;
   }

   public String getAvrObject() {
      return this.avrObject;
   }

   public void setAvrObject(String var1) {
      this.avrObject = var1;
   }

   public String getAvrObservation() {
      return this.avrObservation;
   }

   public void setAvrObservation(String var1) {
      this.avrObservation = var1;
   }

   public String getAvrPdv() {
      return this.avrPdv;
   }

   public void setAvrPdv(String var1) {
      this.avrPdv = var1;
   }

   public String getAvrRegion() {
      return this.avrRegion;
   }

   public void setAvrRegion(String var1) {
      this.avrRegion = var1;
   }

   public String getAvrSecteur() {
      return this.avrSecteur;
   }

   public void setAvrSecteur(String var1) {
      this.avrSecteur = var1;
   }

   public String getAvrSerie() {
      return this.avrSerie;
   }

   public void setAvrSerie(String var1) {
      this.avrSerie = var1;
   }

   public String getAvrService() {
      return this.avrService;
   }

   public void setAvrService(String var1) {
      this.avrService = var1;
   }

   public String getAvrSite() {
      return this.avrSite;
   }

   public void setAvrSite(String var1) {
      this.avrSite = var1;
   }

   public int getAvrSolde() {
      return this.avrSolde;
   }

   public void setAvrSolde(int var1) {
      this.avrSolde = var1;
   }

   public double getAvrTotHt() {
      return this.avrTotHt;
   }

   public void setAvrTotHt(double var1) {
      this.avrTotHt = var1;
   }

   public double getAvrTotRabais() {
      return this.avrTotRabais;
   }

   public void setAvrTotRabais(double var1) {
      this.avrTotRabais = var1;
   }

   public double getAvrTotReglement() {
      return this.avrTotReglement;
   }

   public void setAvrTotReglement(double var1) {
      this.avrTotReglement = var1;
   }

   public double getAvrTotRemise() {
      return this.avrTotRemise;
   }

   public void setAvrTotRemise(double var1) {
      this.avrTotRemise = var1;
   }

   public double getAvrTotTc() {
      return this.avrTotTc;
   }

   public void setAvrTotTc(double var1) {
      this.avrTotTc = var1;
   }

   public double getAvrTotTtc() {
      return this.avrTotTtc;
   }

   public void setAvrTotTtc(double var1) {
      this.avrTotTtc = var1;
   }

   public double getAvrTotTva() {
      return this.avrTotTva;
   }

   public void setAvrTotTva(double var1) {
      this.avrTotTva = var1;
   }

   public int getAvrTypeReg() {
      return this.avrTypeReg;
   }

   public void setAvrTypeReg(int var1) {
      this.avrTypeReg = var1;
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

   public Date getAvrDateModif() {
      return this.avrDateModif;
   }

   public void setAvrDateModif(Date var1) {
      this.avrDateModif = var1;
   }

   public long getAvrIdModif() {
      return this.avrIdModif;
   }

   public void setAvrIdModif(long var1) {
      this.avrIdModif = var1;
   }

   public String getAvrNomModif() {
      return this.avrNomModif;
   }

   public void setAvrNomModif(String var1) {
      this.avrNomModif = var1;
   }

   public Date getAvrDate() {
      return this.avrDate;
   }

   public void setAvrDate(Date var1) {
      this.avrDate = var1;
   }

   public int getAvrFactorEtat() {
      return this.avrFactorEtat;
   }

   public void setAvrFactorEtat(int var1) {
      this.avrFactorEtat = var1;
   }

   public long getAvrFactorId() {
      return this.avrFactorId;
   }

   public void setAvrFactorId(long var1) {
      this.avrFactorId = var1;
   }

   public String getAvrFactorNom() {
      return this.avrFactorNom;
   }

   public void setAvrFactorNom(String var1) {
      this.avrFactorNom = var1;
   }

   public int getAvrExoDouane() {
      return this.avrExoDouane;
   }

   public void setAvrExoDouane(int var1) {
      this.avrExoDouane = var1;
   }

   public int getAvrExoTva() {
      return this.avrExoTva;
   }

   public void setAvrExoTva(int var1) {
      this.avrExoTva = var1;
   }

   public String getAvrJournalReg() {
      return this.avrJournalReg;
   }

   public void setAvrJournalReg(String var1) {
      this.avrJournalReg = var1;
   }

   public Date getAvrDateVisa() {
      return this.avrDateVisa;
   }

   public void setAvrDateVisa(Date var1) {
      this.avrDateVisa = var1;
   }

   public int getAvrExo() {
      return this.avrExo;
   }

   public void setAvrExo(int var1) {
      this.avrExo = var1;
   }

   public String getAvrMotifExo() {
      return this.avrMotifExo;
   }

   public void setAvrMotifExo(String var1) {
      this.avrMotifExo = var1;
   }

   public String getAvrNumVisa() {
      return this.avrNumVisa;
   }

   public void setAvrNumVisa(String var1) {
      this.avrNumVisa = var1;
   }

   public String getAvrRangeVisa() {
      return this.avrRangeVisa;
   }

   public void setAvrRangeVisa(String var1) {
      this.avrRangeVisa = var1;
   }

   public String getAvrCivilContact() {
      return this.avrCivilContact;
   }

   public void setAvrCivilContact(String var1) {
      this.avrCivilContact = var1;
   }

   public String getAvrCivilTiers() {
      return this.avrCivilTiers;
   }

   public void setAvrCivilTiers(String var1) {
      this.avrCivilTiers = var1;
   }

   public long getAvrIdResponsable() {
      return this.avrIdResponsable;
   }

   public void setAvrIdResponsable(long var1) {
      this.avrIdResponsable = var1;
   }

   public int getAvrTypeTransforme() {
      return this.avrTypeTransforme;
   }

   public void setAvrTypeTransforme(int var1) {
      this.avrTypeTransforme = var1;
   }

   public long getAvrIdContact() {
      return this.avrIdContact;
   }

   public void setAvrIdContact(long var1) {
      this.avrIdContact = var1;
   }

   public Date getAvrDateTransfert() {
      return this.avrDateTransfert;
   }

   public void setAvrDateTransfert(Date var1) {
      this.avrDateTransfert = var1;
   }

   public float getAvrTauxTc() {
      return this.avrTauxTc;
   }

   public void setAvrTauxTc(float var1) {
      this.avrTauxTc = var1;
   }

   public String getAvrDiversAdresse() {
      return this.avrDiversAdresse;
   }

   public void setAvrDiversAdresse(String var1) {
      this.avrDiversAdresse = var1;
   }

   public String getAvrDiversMail() {
      return this.avrDiversMail;
   }

   public void setAvrDiversMail(String var1) {
      this.avrDiversMail = var1;
   }

   public String getAvrDiversNom() {
      if (this.avrDiversNom != null && !this.avrDiversNom.isEmpty()) {
         this.avrDiversNom = this.avrDiversNom.toUpperCase();
      }

      return this.avrDiversNom;
   }

   public void setAvrDiversNom(String var1) {
      this.avrDiversNom = var1;
   }

   public String getAvrDiversTel() {
      return this.avrDiversTel;
   }

   public void setAvrDiversTel(String var1) {
      this.avrDiversTel = var1;
   }

   public int getAvrDiversTiers() {
      return this.avrDiversTiers;
   }

   public void setAvrDiversTiers(int var1) {
      this.avrDiversTiers = var1;
   }

   public String getAvrDiversVille() {
      return this.avrDiversVille;
   }

   public void setAvrDiversVille(String var1) {
      this.avrDiversVille = var1;
   }

   public long getAvrIdCommercial() {
      return this.avrIdCommercial;
   }

   public void setAvrIdCommercial(long var1) {
      this.avrIdCommercial = var1;
   }

   public String getAvrNomCommercial() {
      return this.avrNomCommercial;
   }

   public void setAvrNomCommercial(String var1) {
      this.avrNomCommercial = var1;
   }

   public Date getAvrDateLastReg() {
      return this.avrDateLastReg;
   }

   public void setAvrDateLastReg(Date var1) {
      this.avrDateLastReg = var1;
   }

   public long getAvrIdEquipe() {
      return this.avrIdEquipe;
   }

   public void setAvrIdEquipe(long var1) {
      this.avrIdEquipe = var1;
   }

   public String getAvrNomEquipe() {
      return this.avrNomEquipe;
   }

   public void setAvrNomEquipe(String var1) {
      this.avrNomEquipe = var1;
   }

   public String getAvrNumTrf() {
      return this.avrNumTrf;
   }

   public void setAvrNumTrf(String var1) {
      this.avrNumTrf = var1;
   }

   public String getAvrNumFacture() {
      return this.avrNumFacture;
   }

   public void setAvrNumFacture(String var1) {
      this.avrNumFacture = var1;
   }

   public String getAvrNumRetour() {
      return this.avrNumRetour;
   }

   public void setAvrNumRetour(String var1) {
      this.avrNumRetour = var1;
   }

   public String getAvrNumBC() {
      return this.avrNumBC;
   }

   public void setAvrNumBC(String var1) {
      this.avrNumBC = var1;
   }

   public String getAvrSource() {
      return this.avrSource;
   }

   public void setAvrSource(String var1) {
      this.avrSource = var1;
   }

   public float getAvrTauxRemise() {
      return this.avrTauxRemise;
   }

   public void setAvrTauxRemise(float var1) {
      this.avrTauxRemise = var1;
   }

   public String getAvrTiersRegroupe() {
      return this.avrTiersRegroupe;
   }

   public void setAvrTiersRegroupe(String var1) {
      this.avrTiersRegroupe = var1;
   }

   public String getAvrContener() {
      return this.avrContener;
   }

   public void setAvrContener(String var1) {
      this.avrContener = var1;
   }

   public int getAvrPosSignature() {
      return this.avrPosSignature;
   }

   public void setAvrPosSignature(int var1) {
      this.avrPosSignature = var1;
   }

   public String getAvrNumBL() {
      return this.avrNumBL;
   }

   public void setAvrNumBL(String var1) {
      this.avrNumBL = var1;
   }

   public Date getAvrDateClient() {
      return this.avrDateClient;
   }

   public void setAvrDateClient(Date var1) {
      this.avrDateClient = var1;
   }

   public String getAvrNumClient() {
      return this.avrNumClient;
   }

   public void setAvrNumClient(String var1) {
      this.avrNumClient = var1;
   }

   public String getAvrAffaire() {
      return this.avrAffaire;
   }

   public void setAvrAffaire(String var1) {
      this.avrAffaire = var1;
   }

   public float getAvrPoids() {
      return this.avrPoids;
   }

   public void setAvrPoids(float var1) {
      this.avrPoids = var1;
   }

   public String getAvrDiversNif() {
      return this.avrDiversNif;
   }

   public void setAvrDiversNif(String var1) {
      this.avrDiversNif = var1;
   }
}
