package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BienFacture implements Serializable {
   private long biefacId;
   private Date biefacDateCreat;
   private Date biefacDateModif;
   private long biefacIdCreateur;
   private String biefacNomCreateur;
   private long biefacIdModif;
   private String biefacNomModif;
   private Date biefacDate;
   private Date biefacDateDebut;
   private Date biefacDateFin;
   private String biefacNum;
   private String biefacBail;
   private String biefacBien;
   private String biefacZone;
   private String biefacNomResponsable;
   private long biefacIdResponsable;
   private String biefacNomCommercial;
   private long biefacIdCommercial;
   private String biefacTiers;
   private String biefacNomTiers;
   private String biefacCivilTiers;
   private long biefacIdContact;
   private String biefacNomContact;
   private String biefacCivilContact;
   private String biefacSerie;
   private int biefacExoTva;
   private int biefacExoTom;
   private String biefacCat;
   private String biefacDevise;
   private String biefacObject;
   private String biefacObservation;
   private String biefacBudget;
   private double biefacTotReglement;
   private double biefacTotTimbre;
   private int biefacSolde;
   private String biefacBanque;
   private int biefacTypeReg;
   private String biefacModeReg;
   private Date biefacEcheanceReliquat;
   private int biefacNbJourReg;
   private int biefacArrondiReg;
   private String biefacConditionReg;
   private Date biefacDateEcheReg;
   private Date biefacDateLastReg;
   private String biefacJournalReg;
   private String biefacSite;
   private String biefacDepartement;
   private String biefacService;
   private String biefacRegion;
   private String biefacSecteur;
   private String biefacPdv;
   private String biefacInfo1;
   private String biefacInfo2;
   private String biefacInfo3;
   private String biefacInfo4;
   private String biefacInfo5;
   private String biefacInfo6;
   private String biefacInfo7;
   private String biefacInfo8;
   private String biefacInfo9;
   private String biefacInfo10;
   private String biefacFormule1;
   private String biefacFormule2;
   private String biefacContrat;
   private Date biefacDateImp;
   private String biefacModeleImp;
   private int biefacEtatVal;
   private int biefacGele;
   private int biefacEtat;
   private String biefacNumTrf;
   private Date biefacDateValidite;
   private Date biefacDateRelance;
   private Date biefacDateValide;
   private Date biefacDateTransforme;
   private int biefacTypeTransforme;
   private Date biefacDateAnnule;
   private String biefacMotifAnnule;
   private String biefacMotifExo;
   private String biefacNumVisa;
   private Date biefacDateVisa;
   private String biefacRangeVisa;
   private Date biefacDateTransfert;
   private String biefacNumAvoir;
   private String biefacSource;
   private double biefacTotHt;
   private double biefacTotTva;
   private double biefacTotTtc;
   private double biefacTotTc;
   private double biefacLoyerBrut;
   private double biefacTauxRemise;
   private double biefacTotRemise;
   private double biefacTauxTom;
   private double biefacTom;
   private int biefacModeTlv;
   private double biefacTauxTlv;
   private double biefacTlv;
   private double biefacTauxTva;
   private double biefacLoyerNet;
   private double biefacLoyerProf;
   private double biefacChargesImmeuble;
   private double biefacTauxCharges;
   private double biefacEau;
   private double biefacElectricite;
   private double biefacParking;
   private double biefacGardiennage;
   private double biefacJardinnier;
   private double biefacGroupeElectro;
   private double biefacDiversFrais;
   private String biefacLibelleFrais;
   private double biefacFraisComplement;
   private double biefacNetPayer;
   private String biefacProprietaire;
   private String biefacNomProprietaire;
   private String biefacCivilProprietaire;
   private long biefacIdProprietaire;
   private int biefacTypeProprietaire;
   private double biefacTauxIrpp;
   private double biefacTotalIrpp;
   private double biefacTauxCom;
   private double biefacTotalCom;
   private double biefacForfaitGerance;
   private float biefacTauxTvaCom;
   private double biefacTvaCom;
   private int biefacMode;
   private int biefacUsage;
   private int biefacType;
   private double biefacRegTmp;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private Bien bien;
   private String libelleEta;
   private String var_solde;
   private double var_reliquat;
   private boolean var_select_ligne;
   private int var_format_devise;
   private String var_nomContact;
   private String var_nom_tiers;
   private String var_nom_proprietaire;
   private double var_fac_timbre;
   private double var_taxes;
   private String montantLettre;
   private String dupplicata;
   private String infoOrigineDoc;
   private double montantReglementManuel;
   private double baseAgence;
   private boolean avecDetail;
   private String tieadresse;
   private String tierue;
   private String tielot;
   private String tiebatiment;
   private String tieporte;
   private String tieetage;
   private String tieascensseur;
   private String tiequartier;
   private String tiecommune;
   private String tiedepart;
   private String tiezone;
   private String tiebp;
   private String tieville;
   private String bieNom;
   private String bieAdresse;
   private String bieRue;
   private String bieLot;
   private String bieIlot;
   private String bieBatiment;
   private String biePorte;
   private String bieEtage;
   private String bieEscalier;
   private String bieAscenseur;
   private String bieQuartier;
   private String bieCommune;
   private String bieDepart;
   private String bieZone;
   private String bieVille;

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public double getVar_taxes() {
      this.var_taxes = this.biefacTlv + this.biefacTom + this.biefacTotTva;
      return this.var_taxes;
   }

   public void setVar_taxes(double var1) {
      this.var_taxes = var1;
   }

   public double getBaseAgence() {
      this.baseAgence = this.biefacLoyerBrut;
      return this.baseAgence;
   }

   public void setBaseAgence(double var1) {
      this.baseAgence = var1;
   }

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
      if (this.biefacCivilTiers != null && !this.biefacCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.biefacCivilTiers + " " + this.biefacNomTiers;
      } else {
         this.var_nom_tiers = this.biefacNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nom_proprietaire() {
      if (this.biefacCivilProprietaire != null && !this.biefacCivilProprietaire.isEmpty()) {
         this.var_nom_proprietaire = this.biefacCivilProprietaire + " " + this.biefacNomProprietaire;
      } else {
         this.var_nom_proprietaire = this.biefacNomProprietaire;
      }

      return this.var_nom_proprietaire;
   }

   public void setVar_nom_proprietaire(String var1) {
      this.var_nom_proprietaire = var1;
   }

   public String getVar_nomContact() {
      if (this.biefacCivilContact != null && !this.biefacCivilContact.isEmpty()) {
         this.var_nomContact = this.biefacCivilContact + " " + this.biefacNomContact;
      } else {
         this.var_nomContact = this.biefacNomContact;
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.biefacEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.biefacEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.biefacEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.biefacEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.biefacEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.biefacEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVar_solde() {
      if (this.biefacSolde == 1) {
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

   public double getVar_reliquat() {
      this.var_reliquat = this.biefacTotTtc + this.var_fac_timbre - this.biefacTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getVar_format_devise() {
      if (!this.biefacDevise.equals("XOF") && !this.biefacDevise.equals("XAF")) {
         if (!this.biefacDevise.equals("EUR") && !this.biefacDevise.equals("XEU") && !this.biefacDevise.equals("CHF")) {
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

   public String getMontantLettre() {
      return this.montantLettre;
   }

   public void setMontantLettre(String var1) {
      this.montantLettre = var1;
   }

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

   public int getBiefacArrondiReg() {
      return this.biefacArrondiReg;
   }

   public void setBiefacArrondiReg(int var1) {
      this.biefacArrondiReg = var1;
   }

   public String getBiefacBanque() {
      return this.biefacBanque;
   }

   public void setBiefacBanque(String var1) {
      this.biefacBanque = var1;
   }

   public String getBiefacBudget() {
      return this.biefacBudget;
   }

   public void setBiefacBudget(String var1) {
      this.biefacBudget = var1;
   }

   public String getBiefacCat() {
      return this.biefacCat;
   }

   public void setBiefacCat(String var1) {
      this.biefacCat = var1;
   }

   public String getBiefacCivilContact() {
      return this.biefacCivilContact;
   }

   public void setBiefacCivilContact(String var1) {
      this.biefacCivilContact = var1;
   }

   public String getBiefacCivilTiers() {
      return this.biefacCivilTiers;
   }

   public void setBiefacCivilTiers(String var1) {
      this.biefacCivilTiers = var1;
   }

   public String getBiefacConditionReg() {
      return this.biefacConditionReg;
   }

   public void setBiefacConditionReg(String var1) {
      this.biefacConditionReg = var1;
   }

   public String getBiefacContrat() {
      return this.biefacContrat;
   }

   public void setBiefacContrat(String var1) {
      this.biefacContrat = var1;
   }

   public Date getBiefacDate() {
      return this.biefacDate;
   }

   public void setBiefacDate(Date var1) {
      this.biefacDate = var1;
   }

   public Date getBiefacDateAnnule() {
      return this.biefacDateAnnule;
   }

   public void setBiefacDateAnnule(Date var1) {
      this.biefacDateAnnule = var1;
   }

   public Date getBiefacDateCreat() {
      return this.biefacDateCreat;
   }

   public void setBiefacDateCreat(Date var1) {
      this.biefacDateCreat = var1;
   }

   public Date getBiefacDateEcheReg() {
      return this.biefacDateEcheReg;
   }

   public void setBiefacDateEcheReg(Date var1) {
      this.biefacDateEcheReg = var1;
   }

   public Date getBiefacDateImp() {
      return this.biefacDateImp;
   }

   public void setBiefacDateImp(Date var1) {
      this.biefacDateImp = var1;
   }

   public Date getBiefacDateLastReg() {
      return this.biefacDateLastReg;
   }

   public void setBiefacDateLastReg(Date var1) {
      this.biefacDateLastReg = var1;
   }

   public Date getBiefacDateModif() {
      return this.biefacDateModif;
   }

   public void setBiefacDateModif(Date var1) {
      this.biefacDateModif = var1;
   }

   public Date getBiefacDateRelance() {
      return this.biefacDateRelance;
   }

   public void setBiefacDateRelance(Date var1) {
      this.biefacDateRelance = var1;
   }

   public Date getBiefacDateTransfert() {
      return this.biefacDateTransfert;
   }

   public void setBiefacDateTransfert(Date var1) {
      this.biefacDateTransfert = var1;
   }

   public Date getBiefacDateTransforme() {
      return this.biefacDateTransforme;
   }

   public void setBiefacDateTransforme(Date var1) {
      this.biefacDateTransforme = var1;
   }

   public Date getBiefacDateValide() {
      return this.biefacDateValide;
   }

   public void setBiefacDateValide(Date var1) {
      this.biefacDateValide = var1;
   }

   public Date getBiefacDateValidite() {
      return this.biefacDateValidite;
   }

   public void setBiefacDateValidite(Date var1) {
      this.biefacDateValidite = var1;
   }

   public Date getBiefacDateVisa() {
      return this.biefacDateVisa;
   }

   public void setBiefacDateVisa(Date var1) {
      this.biefacDateVisa = var1;
   }

   public String getBiefacDepartement() {
      return this.biefacDepartement;
   }

   public void setBiefacDepartement(String var1) {
      this.biefacDepartement = var1;
   }

   public String getBiefacDevise() {
      return this.biefacDevise;
   }

   public void setBiefacDevise(String var1) {
      this.biefacDevise = var1;
   }

   public Date getBiefacEcheanceReliquat() {
      return this.biefacEcheanceReliquat;
   }

   public void setBiefacEcheanceReliquat(Date var1) {
      this.biefacEcheanceReliquat = var1;
   }

   public int getBiefacEtat() {
      return this.biefacEtat;
   }

   public void setBiefacEtat(int var1) {
      this.biefacEtat = var1;
   }

   public int getBiefacEtatVal() {
      return this.biefacEtatVal;
   }

   public void setBiefacEtatVal(int var1) {
      this.biefacEtatVal = var1;
   }

   public int getBiefacExoTom() {
      return this.biefacExoTom;
   }

   public void setBiefacExoTom(int var1) {
      this.biefacExoTom = var1;
   }

   public int getBiefacExoTva() {
      return this.biefacExoTva;
   }

   public void setBiefacExoTva(int var1) {
      this.biefacExoTva = var1;
   }

   public String getBiefacFormule1() {
      return this.biefacFormule1;
   }

   public void setBiefacFormule1(String var1) {
      this.biefacFormule1 = var1;
   }

   public String getBiefacFormule2() {
      return this.biefacFormule2;
   }

   public void setBiefacFormule2(String var1) {
      this.biefacFormule2 = var1;
   }

   public int getBiefacGele() {
      return this.biefacGele;
   }

   public void setBiefacGele(int var1) {
      this.biefacGele = var1;
   }

   public long getBiefacId() {
      return this.biefacId;
   }

   public void setBiefacId(long var1) {
      this.biefacId = var1;
   }

   public long getBiefacIdCommercial() {
      return this.biefacIdCommercial;
   }

   public void setBiefacIdCommercial(long var1) {
      this.biefacIdCommercial = var1;
   }

   public long getBiefacIdContact() {
      return this.biefacIdContact;
   }

   public void setBiefacIdContact(long var1) {
      this.biefacIdContact = var1;
   }

   public long getBiefacIdCreateur() {
      return this.biefacIdCreateur;
   }

   public void setBiefacIdCreateur(long var1) {
      this.biefacIdCreateur = var1;
   }

   public long getBiefacIdModif() {
      return this.biefacIdModif;
   }

   public void setBiefacIdModif(long var1) {
      this.biefacIdModif = var1;
   }

   public long getBiefacIdResponsable() {
      return this.biefacIdResponsable;
   }

   public void setBiefacIdResponsable(long var1) {
      this.biefacIdResponsable = var1;
   }

   public String getBiefacInfo1() {
      return this.biefacInfo1;
   }

   public void setBiefacInfo1(String var1) {
      this.biefacInfo1 = var1;
   }

   public String getBiefacInfo10() {
      return this.biefacInfo10;
   }

   public void setBiefacInfo10(String var1) {
      this.biefacInfo10 = var1;
   }

   public String getBiefacInfo2() {
      return this.biefacInfo2;
   }

   public void setBiefacInfo2(String var1) {
      this.biefacInfo2 = var1;
   }

   public String getBiefacInfo3() {
      return this.biefacInfo3;
   }

   public void setBiefacInfo3(String var1) {
      this.biefacInfo3 = var1;
   }

   public String getBiefacInfo4() {
      return this.biefacInfo4;
   }

   public void setBiefacInfo4(String var1) {
      this.biefacInfo4 = var1;
   }

   public String getBiefacInfo5() {
      return this.biefacInfo5;
   }

   public void setBiefacInfo5(String var1) {
      this.biefacInfo5 = var1;
   }

   public String getBiefacInfo6() {
      return this.biefacInfo6;
   }

   public void setBiefacInfo6(String var1) {
      this.biefacInfo6 = var1;
   }

   public String getBiefacInfo7() {
      return this.biefacInfo7;
   }

   public void setBiefacInfo7(String var1) {
      this.biefacInfo7 = var1;
   }

   public String getBiefacInfo8() {
      return this.biefacInfo8;
   }

   public void setBiefacInfo8(String var1) {
      this.biefacInfo8 = var1;
   }

   public String getBiefacInfo9() {
      return this.biefacInfo9;
   }

   public void setBiefacInfo9(String var1) {
      this.biefacInfo9 = var1;
   }

   public String getBiefacJournalReg() {
      return this.biefacJournalReg;
   }

   public void setBiefacJournalReg(String var1) {
      this.biefacJournalReg = var1;
   }

   public String getBiefacModeReg() {
      return this.biefacModeReg;
   }

   public void setBiefacModeReg(String var1) {
      this.biefacModeReg = var1;
   }

   public String getBiefacModeleImp() {
      return this.biefacModeleImp;
   }

   public void setBiefacModeleImp(String var1) {
      this.biefacModeleImp = var1;
   }

   public String getBiefacMotifAnnule() {
      return this.biefacMotifAnnule;
   }

   public void setBiefacMotifAnnule(String var1) {
      this.biefacMotifAnnule = var1;
   }

   public String getBiefacMotifExo() {
      return this.biefacMotifExo;
   }

   public void setBiefacMotifExo(String var1) {
      this.biefacMotifExo = var1;
   }

   public int getBiefacNbJourReg() {
      return this.biefacNbJourReg;
   }

   public void setBiefacNbJourReg(int var1) {
      this.biefacNbJourReg = var1;
   }

   public String getBiefacNomCommercial() {
      return this.biefacNomCommercial;
   }

   public void setBiefacNomCommercial(String var1) {
      this.biefacNomCommercial = var1;
   }

   public String getBiefacNomContact() {
      return this.biefacNomContact;
   }

   public void setBiefacNomContact(String var1) {
      this.biefacNomContact = var1;
   }

   public String getBiefacNomCreateur() {
      return this.biefacNomCreateur;
   }

   public void setBiefacNomCreateur(String var1) {
      this.biefacNomCreateur = var1;
   }

   public String getBiefacNomModif() {
      return this.biefacNomModif;
   }

   public void setBiefacNomModif(String var1) {
      this.biefacNomModif = var1;
   }

   public String getBiefacNomResponsable() {
      return this.biefacNomResponsable;
   }

   public void setBiefacNomResponsable(String var1) {
      this.biefacNomResponsable = var1;
   }

   public String getBiefacNomTiers() {
      return this.biefacNomTiers;
   }

   public void setBiefacNomTiers(String var1) {
      this.biefacNomTiers = var1;
   }

   public String getBiefacNum() {
      return this.biefacNum;
   }

   public void setBiefacNum(String var1) {
      this.biefacNum = var1;
   }

   public String getBiefacNumAvoir() {
      return this.biefacNumAvoir;
   }

   public void setBiefacNumAvoir(String var1) {
      this.biefacNumAvoir = var1;
   }

   public String getBiefacNumTrf() {
      return this.biefacNumTrf;
   }

   public void setBiefacNumTrf(String var1) {
      this.biefacNumTrf = var1;
   }

   public String getBiefacNumVisa() {
      return this.biefacNumVisa;
   }

   public void setBiefacNumVisa(String var1) {
      this.biefacNumVisa = var1;
   }

   public String getBiefacObject() {
      return this.biefacObject;
   }

   public void setBiefacObject(String var1) {
      this.biefacObject = var1;
   }

   public String getBiefacObservation() {
      return this.biefacObservation;
   }

   public void setBiefacObservation(String var1) {
      this.biefacObservation = var1;
   }

   public String getBiefacPdv() {
      return this.biefacPdv;
   }

   public void setBiefacPdv(String var1) {
      this.biefacPdv = var1;
   }

   public String getBiefacRangeVisa() {
      return this.biefacRangeVisa;
   }

   public void setBiefacRangeVisa(String var1) {
      this.biefacRangeVisa = var1;
   }

   public String getBiefacRegion() {
      return this.biefacRegion;
   }

   public void setBiefacRegion(String var1) {
      this.biefacRegion = var1;
   }

   public String getBiefacSecteur() {
      return this.biefacSecteur;
   }

   public void setBiefacSecteur(String var1) {
      this.biefacSecteur = var1;
   }

   public String getBiefacSerie() {
      return this.biefacSerie;
   }

   public void setBiefacSerie(String var1) {
      this.biefacSerie = var1;
   }

   public String getBiefacService() {
      return this.biefacService;
   }

   public void setBiefacService(String var1) {
      this.biefacService = var1;
   }

   public String getBiefacSite() {
      return this.biefacSite;
   }

   public void setBiefacSite(String var1) {
      this.biefacSite = var1;
   }

   public int getBiefacSolde() {
      return this.biefacSolde;
   }

   public void setBiefacSolde(int var1) {
      this.biefacSolde = var1;
   }

   public String getBiefacSource() {
      return this.biefacSource;
   }

   public void setBiefacSource(String var1) {
      this.biefacSource = var1;
   }

   public double getBiefacTauxRemise() {
      return this.biefacTauxRemise;
   }

   public void setBiefacTauxRemise(double var1) {
      this.biefacTauxRemise = var1;
   }

   public double getBiefacTotReglement() {
      return this.biefacTotReglement;
   }

   public void setBiefacTotReglement(double var1) {
      this.biefacTotReglement = var1;
   }

   public double getBiefacTotRemise() {
      return this.biefacTotRemise;
   }

   public void setBiefacTotRemise(double var1) {
      this.biefacTotRemise = var1;
   }

   public double getBiefacTotTimbre() {
      return this.biefacTotTimbre;
   }

   public void setBiefacTotTimbre(double var1) {
      this.biefacTotTimbre = var1;
   }

   public int getBiefacTypeReg() {
      return this.biefacTypeReg;
   }

   public void setBiefacTypeReg(int var1) {
      this.biefacTypeReg = var1;
   }

   public int getBiefacTypeTransforme() {
      return this.biefacTypeTransforme;
   }

   public void setBiefacTypeTransforme(int var1) {
      this.biefacTypeTransforme = var1;
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

   public double getBiefacChargesImmeuble() {
      return this.biefacChargesImmeuble;
   }

   public void setBiefacChargesImmeuble(double var1) {
      this.biefacChargesImmeuble = var1;
   }

   public double getBiefacDiversFrais() {
      return this.biefacDiversFrais;
   }

   public void setBiefacDiversFrais(double var1) {
      this.biefacDiversFrais = var1;
   }

   public double getBiefacEau() {
      return this.biefacEau;
   }

   public void setBiefacEau(double var1) {
      this.biefacEau = var1;
   }

   public double getBiefacElectricite() {
      return this.biefacElectricite;
   }

   public void setBiefacElectricite(double var1) {
      this.biefacElectricite = var1;
   }

   public double getBiefacFraisComplement() {
      return this.biefacFraisComplement;
   }

   public void setBiefacFraisComplement(double var1) {
      this.biefacFraisComplement = var1;
   }

   public double getBiefacGardiennage() {
      return this.biefacGardiennage;
   }

   public void setBiefacGardiennage(double var1) {
      this.biefacGardiennage = var1;
   }

   public double getBiefacGroupeElectro() {
      return this.biefacGroupeElectro;
   }

   public void setBiefacGroupeElectro(double var1) {
      this.biefacGroupeElectro = var1;
   }

   public double getBiefacJardinnier() {
      return this.biefacJardinnier;
   }

   public void setBiefacJardinnier(double var1) {
      this.biefacJardinnier = var1;
   }

   public String getBiefacLibelleFrais() {
      return this.biefacLibelleFrais;
   }

   public void setBiefacLibelleFrais(String var1) {
      this.biefacLibelleFrais = var1;
   }

   public double getBiefacLoyerBrut() {
      return this.biefacLoyerBrut;
   }

   public void setBiefacLoyerBrut(double var1) {
      this.biefacLoyerBrut = var1;
   }

   public double getBiefacLoyerNet() {
      return this.biefacLoyerNet;
   }

   public void setBiefacLoyerNet(double var1) {
      this.biefacLoyerNet = var1;
   }

   public int getBiefacModeTlv() {
      return this.biefacModeTlv;
   }

   public void setBiefacModeTlv(int var1) {
      this.biefacModeTlv = var1;
   }

   public double getBiefacNetPayer() {
      return this.biefacNetPayer;
   }

   public void setBiefacNetPayer(double var1) {
      this.biefacNetPayer = var1;
   }

   public double getBiefacParking() {
      return this.biefacParking;
   }

   public void setBiefacParking(double var1) {
      this.biefacParking = var1;
   }

   public double getBiefacTauxCharges() {
      return this.biefacTauxCharges;
   }

   public void setBiefacTauxCharges(double var1) {
      this.biefacTauxCharges = var1;
   }

   public double getBiefacTauxIrpp() {
      return this.biefacTauxIrpp;
   }

   public void setBiefacTauxIrpp(double var1) {
      this.biefacTauxIrpp = var1;
   }

   public double getBiefacTauxTlv() {
      return this.biefacTauxTlv;
   }

   public void setBiefacTauxTlv(double var1) {
      this.biefacTauxTlv = var1;
   }

   public double getBiefacTauxTom() {
      return this.biefacTauxTom;
   }

   public void setBiefacTauxTom(double var1) {
      this.biefacTauxTom = var1;
   }

   public double getBiefacTauxTva() {
      return this.biefacTauxTva;
   }

   public void setBiefacTauxTva(double var1) {
      this.biefacTauxTva = var1;
   }

   public double getBiefacTlv() {
      return this.biefacTlv;
   }

   public void setBiefacTlv(double var1) {
      this.biefacTlv = var1;
   }

   public double getBiefacTom() {
      return this.biefacTom;
   }

   public void setBiefacTom(double var1) {
      this.biefacTom = var1;
   }

   public double getBiefacTotalIrpp() {
      return this.biefacTotalIrpp;
   }

   public void setBiefacTotalIrpp(double var1) {
      this.biefacTotalIrpp = var1;
   }

   public double getBiefacTauxCom() {
      return this.biefacTauxCom;
   }

   public void setBiefacTauxCom(double var1) {
      this.biefacTauxCom = var1;
   }

   public double getBiefacTotalCom() {
      return this.biefacTotalCom;
   }

   public void setBiefacTotalCom(double var1) {
      this.biefacTotalCom = var1;
   }

   public String getBiefacBail() {
      return this.biefacBail;
   }

   public void setBiefacBail(String var1) {
      this.biefacBail = var1;
   }

   public String getBiefacBien() {
      return this.biefacBien;
   }

   public void setBiefacBien(String var1) {
      this.biefacBien = var1;
   }

   public String getBiefacCivilProprietaire() {
      return this.biefacCivilProprietaire;
   }

   public void setBiefacCivilProprietaire(String var1) {
      this.biefacCivilProprietaire = var1;
   }

   public Date getBiefacDateDebut() {
      return this.biefacDateDebut;
   }

   public void setBiefacDateDebut(Date var1) {
      this.biefacDateDebut = var1;
   }

   public Date getBiefacDateFin() {
      return this.biefacDateFin;
   }

   public void setBiefacDateFin(Date var1) {
      this.biefacDateFin = var1;
   }

   public long getBiefacIdProprietaire() {
      return this.biefacIdProprietaire;
   }

   public void setBiefacIdProprietaire(long var1) {
      this.biefacIdProprietaire = var1;
   }

   public String getBiefacNomProprietaire() {
      return this.biefacNomProprietaire;
   }

   public void setBiefacNomProprietaire(String var1) {
      this.biefacNomProprietaire = var1;
   }

   public double getBiefacTotHt() {
      return this.biefacTotHt;
   }

   public void setBiefacTotHt(double var1) {
      this.biefacTotHt = var1;
   }

   public double getBiefacTotTtc() {
      return this.biefacTotTtc;
   }

   public void setBiefacTotTtc(double var1) {
      this.biefacTotTtc = var1;
   }

   public double getBiefacTotTva() {
      return this.biefacTotTva;
   }

   public void setBiefacTotTva(double var1) {
      this.biefacTotTva = var1;
   }

   public double getBiefacTvaCom() {
      return this.biefacTvaCom;
   }

   public void setBiefacTvaCom(double var1) {
      this.biefacTvaCom = var1;
   }

   public int getBiefacTypeProprietaire() {
      return this.biefacTypeProprietaire;
   }

   public void setBiefacTypeProprietaire(int var1) {
      this.biefacTypeProprietaire = var1;
   }

   public int getBiefacMode() {
      return this.biefacMode;
   }

   public void setBiefacMode(int var1) {
      this.biefacMode = var1;
   }

   public int getBiefacUsage() {
      return this.biefacUsage;
   }

   public void setBiefacUsage(int var1) {
      this.biefacUsage = var1;
   }

   public double getBiefacTotTc() {
      return this.biefacTotTc;
   }

   public void setBiefacTotTc(double var1) {
      this.biefacTotTc = var1;
   }

   public String getBiefacZone() {
      return this.biefacZone;
   }

   public void setBiefacZone(String var1) {
      this.biefacZone = var1;
   }

   public String getBiefacProprietaire() {
      return this.biefacProprietaire;
   }

   public void setBiefacProprietaire(String var1) {
      this.biefacProprietaire = var1;
   }

   public String getBiefacTiers() {
      return this.biefacTiers;
   }

   public void setBiefacTiers(String var1) {
      this.biefacTiers = var1;
   }

   public String getBieAdresse() {
      return this.bieAdresse;
   }

   public void setBieAdresse(String var1) {
      this.bieAdresse = var1;
   }

   public String getBieAscenseur() {
      return this.bieAscenseur;
   }

   public void setBieAscenseur(String var1) {
      this.bieAscenseur = var1;
   }

   public String getBieBatiment() {
      return this.bieBatiment;
   }

   public void setBieBatiment(String var1) {
      this.bieBatiment = var1;
   }

   public String getBieCommune() {
      return this.bieCommune;
   }

   public void setBieCommune(String var1) {
      this.bieCommune = var1;
   }

   public String getBieDepart() {
      return this.bieDepart;
   }

   public void setBieDepart(String var1) {
      this.bieDepart = var1;
   }

   public String getBieEscalier() {
      return this.bieEscalier;
   }

   public void setBieEscalier(String var1) {
      this.bieEscalier = var1;
   }

   public String getBieEtage() {
      return this.bieEtage;
   }

   public void setBieEtage(String var1) {
      this.bieEtage = var1;
   }

   public String getBieIlot() {
      return this.bieIlot;
   }

   public void setBieIlot(String var1) {
      this.bieIlot = var1;
   }

   public String getBieLot() {
      return this.bieLot;
   }

   public void setBieLot(String var1) {
      this.bieLot = var1;
   }

   public String getBieNom() {
      return this.bieNom;
   }

   public void setBieNom(String var1) {
      this.bieNom = var1;
   }

   public String getBiePorte() {
      return this.biePorte;
   }

   public void setBiePorte(String var1) {
      this.biePorte = var1;
   }

   public String getBieQuartier() {
      return this.bieQuartier;
   }

   public void setBieQuartier(String var1) {
      this.bieQuartier = var1;
   }

   public String getBieRue() {
      return this.bieRue;
   }

   public void setBieRue(String var1) {
      this.bieRue = var1;
   }

   public String getBieVille() {
      return this.bieVille;
   }

   public void setBieVille(String var1) {
      this.bieVille = var1;
   }

   public String getBieZone() {
      return this.bieZone;
   }

   public void setBieZone(String var1) {
      this.bieZone = var1;
   }

   public String getTieadresse() {
      return this.tieadresse;
   }

   public void setTieadresse(String var1) {
      this.tieadresse = var1;
   }

   public String getTieascensseur() {
      return this.tieascensseur;
   }

   public void setTieascensseur(String var1) {
      this.tieascensseur = var1;
   }

   public String getTiebatiment() {
      return this.tiebatiment;
   }

   public void setTiebatiment(String var1) {
      this.tiebatiment = var1;
   }

   public String getTiebp() {
      return this.tiebp;
   }

   public void setTiebp(String var1) {
      this.tiebp = var1;
   }

   public String getTiecommune() {
      return this.tiecommune;
   }

   public void setTiecommune(String var1) {
      this.tiecommune = var1;
   }

   public String getTiedepart() {
      return this.tiedepart;
   }

   public void setTiedepart(String var1) {
      this.tiedepart = var1;
   }

   public String getTieetage() {
      return this.tieetage;
   }

   public void setTieetage(String var1) {
      this.tieetage = var1;
   }

   public String getTielot() {
      return this.tielot;
   }

   public void setTielot(String var1) {
      this.tielot = var1;
   }

   public String getTieporte() {
      return this.tieporte;
   }

   public void setTieporte(String var1) {
      this.tieporte = var1;
   }

   public String getTiequartier() {
      return this.tiequartier;
   }

   public void setTiequartier(String var1) {
      this.tiequartier = var1;
   }

   public String getTierue() {
      return this.tierue;
   }

   public void setTierue(String var1) {
      this.tierue = var1;
   }

   public String getTieville() {
      return this.tieville;
   }

   public void setTieville(String var1) {
      this.tieville = var1;
   }

   public String getTiezone() {
      return this.tiezone;
   }

   public void setTiezone(String var1) {
      this.tiezone = var1;
   }

   public int getBiefacType() {
      return this.biefacType;
   }

   public void setBiefacType(int var1) {
      this.biefacType = var1;
   }

   public double getBiefacRegTmp() {
      return this.biefacRegTmp;
   }

   public void setBiefacRegTmp(double var1) {
      this.biefacRegTmp = var1;
   }

   public float getBiefacTauxTvaCom() {
      return this.biefacTauxTvaCom;
   }

   public void setBiefacTauxTvaCom(float var1) {
      this.biefacTauxTvaCom = var1;
   }

   public double getBiefacForfaitGerance() {
      return this.biefacForfaitGerance;
   }

   public void setBiefacForfaitGerance(double var1) {
      this.biefacForfaitGerance = var1;
   }

   public double getBiefacLoyerProf() {
      return this.biefacLoyerProf;
   }

   public void setBiefacLoyerProf(double var1) {
      this.biefacLoyerProf = var1;
   }

   public boolean isAvecDetail() {
      return this.avecDetail;
   }

   public void setAvecDetail(boolean var1) {
      this.avecDetail = var1;
   }
}
