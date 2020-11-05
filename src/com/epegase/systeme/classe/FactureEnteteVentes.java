package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FactureEnteteVentes implements Serializable {
   private long facId;
   private Date facDateCreat;
   private String facNum;
   private long facIdCreateur;
   private String facNomCreateur;
   private Date facDateModif;
   private long facIdModif;
   private String facNomModif;
   private Date facDate;
   private String facNomEquipe;
   private long facIdEquipe;
   private String facNomResponsable;
   private long facIdResponsable;
   private String facNomCommercial;
   private long facIdCommercial;
   private String facNomTiers;
   private String facCivilTiers;
   private String facTiersRegroupe;
   private long facIdContact;
   private String facNomContact;
   private String facCivilContact;
   private String facSerie;
   private int facExoTva;
   private int facExoDouane;
   private String facJournalReg;
   private String facCat;
   private String facDevise;
   private String facObject;
   private String facObservation;
   private String facBudget;
   private float facTauxRemise;
   private float facTauxAcompte;
   private int facNbAcompte;
   private String facNumAcompte;
   private double facTotHt;
   private double facTotRemise;
   private double facTotRabais;
   private double facTotTva;
   private float facTauxTc;
   private double facTotTc;
   private double facTotTtc;
   private double facTotReglement;
   private double facTotTimbre;
   private int facSolde;
   private String facBanque;
   private int facTypeReg;
   private String facModeReg;
   private Date facEcheanceReliquat;
   private String facMotifRejetCredit;
   private int facNbJourReg;
   private int facArrondiReg;
   private String facConditionReg;
   private Date facDateEcheReg;
   private Date facDateLastReg;
   private Date facDateTmpReg;
   private String facContener;
   private String facActivite;
   private String facSite;
   private String facDepartement;
   private String facService;
   private String facRegion;
   private String facSecteur;
   private String facPdv;
   private String facAnal2;
   private String facAnal4;
   private String facAffaire;
   private String facInfo1;
   private String facInfo2;
   private String facInfo3;
   private String facInfo4;
   private String facInfo5;
   private String facInfo6;
   private String facInfo7;
   private String facInfo8;
   private String facInfo9;
   private String facInfo10;
   private String facFormule1;
   private String facFormule2;
   private String facAnnexe1;
   private String facAnnexe2;
   private String facContrat;
   private String facIncoterm;
   private String facLieuLivraison;
   private Date facDateLivraison;
   private String facInfoLivraison;
   private Date facDateImp;
   private String facModeleImp;
   private String facGarde;
   private int facEtatVal;
   private int facGele;
   private int facEtat;
   private String facNumTrf;
   private Date facDateValidite;
   private Date facDateRelance;
   private Date facDateValide;
   private int facPosSignature;
   private Date facDateTransforme;
   private int facTypeTransforme;
   private Date facDateAnnule;
   private String facMotifAnnule;
   private String facMotifExo;
   private String facNumVisa;
   private Date facDateVisa;
   private String facRangeVisa;
   private Date facDateTransfert;
   private String facFactorNom;
   private long facFactorId;
   private int facFactorEtat;
   private int facDiversTiers;
   private String facDiversNom;
   private String facDiversAdresse;
   private String facDiversVille;
   private String facDiversTel;
   private String facDiversMail;
   private String facDiversNif;
   private int facStock;
   private String facNumBl;
   private String facNumAvoir;
   private String facSource;
   private boolean facRistourneBloquee;
   private String facNumClient;
   private Date facDateClient;
   private float facPoids;
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
   private String montantLettre;
   private String codeSecurity;
   private String dupplicata;
   private String infoOrigineDoc;
   private String parcImmatriculation;
   private double montantReglementManuel;
   private String numBl;
   private Date dateBl;
   private String f1;
   private String f2;
   private String f3;
   private String f4;
   private Date p1;
   private Date p2;
   private Date p3;
   private Date p4;
   private Date e1;
   private Date e2;
   private Date e3;
   private Date e4;
   private double m1;
   private double m2;
   private double m3;
   private double m4;

   public Date getE1() {
      return this.e1;
   }

   public void setE1(Date var1) {
      this.e1 = var1;
   }

   public Date getE2() {
      return this.e2;
   }

   public void setE2(Date var1) {
      this.e2 = var1;
   }

   public Date getE3() {
      return this.e3;
   }

   public void setE3(Date var1) {
      this.e3 = var1;
   }

   public Date getE4() {
      return this.e4;
   }

   public void setE4(Date var1) {
      this.e4 = var1;
   }

   public String getF1() {
      return this.f1;
   }

   public void setF1(String var1) {
      this.f1 = var1;
   }

   public String getF2() {
      return this.f2;
   }

   public void setF2(String var1) {
      this.f2 = var1;
   }

   public String getF3() {
      return this.f3;
   }

   public void setF3(String var1) {
      this.f3 = var1;
   }

   public String getF4() {
      return this.f4;
   }

   public void setF4(String var1) {
      this.f4 = var1;
   }

   public double getM1() {
      return this.m1;
   }

   public void setM1(double var1) {
      this.m1 = var1;
   }

   public double getM2() {
      return this.m2;
   }

   public void setM2(double var1) {
      this.m2 = var1;
   }

   public double getM3() {
      return this.m3;
   }

   public void setM3(double var1) {
      this.m3 = var1;
   }

   public double getM4() {
      return this.m4;
   }

   public void setM4(double var1) {
      this.m4 = var1;
   }

   public Date getP1() {
      return this.p1;
   }

   public void setP1(Date var1) {
      this.p1 = var1;
   }

   public Date getP2() {
      return this.p2;
   }

   public void setP2(Date var1) {
      this.p2 = var1;
   }

   public Date getP3() {
      return this.p3;
   }

   public void setP3(Date var1) {
      this.p3 = var1;
   }

   public Date getP4() {
      return this.p4;
   }

   public void setP4(Date var1) {
      this.p4 = var1;
   }

   public Date getDateBl() {
      return this.dateBl;
   }

   public void setDateBl(Date var1) {
      this.dateBl = var1;
   }

   public String getNumBl() {
      return this.numBl;
   }

   public void setNumBl(String var1) {
      this.numBl = var1;
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
      if (this.facDiversTiers == 99) {
         this.var_nom_tiers = this.facDiversNom;
      } else if (this.facCivilTiers != null && !this.facCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.facCivilTiers + " " + this.facNomTiers;
      } else {
         this.var_nom_tiers = this.facNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.facDiversTiers == 99) {
         this.var_nomContact = "(client divers)";
      } else if (this.facCivilContact != null && !this.facCivilContact.isEmpty()) {
         this.var_nomContact = this.facCivilContact + " " + this.facNomContact;
      } else {
         this.var_nomContact = this.facNomContact;
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.facTotTtc + this.facTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getLibelleEta() {
      if (this.facEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.facEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.facEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.facEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.facEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.facEtat == 5) {
         this.libelleEta = "Trf.T.";
      } else if (this.facEtat == 6) {
         this.libelleEta = "Cor.";
      } else if (this.facEtat == 7) {
         this.libelleEta = "Rej.";
      } else if (this.facEtat == 8) {
         this.libelleEta = "Fus.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getVar_solde() {
      if (this.facSolde == 1) {
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

   public double getVar_reliquatListe() {
      this.var_reliquatListe = this.facTotTtc + this.facTotTc + this.facTotTimbre - this.facTotReglement;
      return this.var_reliquatListe;
   }

   public void setVar_reliquatListe(double var1) {
      this.var_reliquatListe = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.facTotTtc + this.facTotTc + this.var_fac_timbre - this.facTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getVar_format_devise() {
      if (!this.facDevise.equals("XOF") && !this.facDevise.equals("XAF")) {
         if (!this.facDevise.equals("EUR") && !this.facDevise.equals("XEU") && !this.facDevise.equals("CHF")) {
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

   public String getParcImmatriculation() {
      return this.parcImmatriculation;
   }

   public void setParcImmatriculation(String var1) {
      this.parcImmatriculation = var1;
   }

   public String getFacActivite() {
      return this.facActivite;
   }

   public void setFacActivite(String var1) {
      this.facActivite = var1;
   }

   public String getFacAnal2() {
      return this.facAnal2;
   }

   public void setFacAnal2(String var1) {
      this.facAnal2 = var1;
   }

   public String getFacAnal4() {
      return this.facAnal4;
   }

   public void setFacAnal4(String var1) {
      this.facAnal4 = var1;
   }

   public String getFacAnnexe1() {
      return this.facAnnexe1;
   }

   public void setFacAnnexe1(String var1) {
      this.facAnnexe1 = var1;
   }

   public String getFacAnnexe2() {
      return this.facAnnexe2;
   }

   public void setFacAnnexe2(String var1) {
      this.facAnnexe2 = var1;
   }

   public int getFacArrondiReg() {
      return this.facArrondiReg;
   }

   public void setFacArrondiReg(int var1) {
      this.facArrondiReg = var1;
   }

   public String getFacBanque() {
      return this.facBanque;
   }

   public void setFacBanque(String var1) {
      this.facBanque = var1;
   }

   public String getFacBudget() {
      return this.facBudget;
   }

   public void setFacBudget(String var1) {
      this.facBudget = var1;
   }

   public String getFacCat() {
      return this.facCat;
   }

   public void setFacCat(String var1) {
      this.facCat = var1;
   }

   public String getFacConditionReg() {
      return this.facConditionReg;
   }

   public void setFacConditionReg(String var1) {
      this.facConditionReg = var1;
   }

   public String getFacContrat() {
      return this.facContrat;
   }

   public void setFacContrat(String var1) {
      this.facContrat = var1;
   }

   public Date getFacDateCreat() {
      return this.facDateCreat;
   }

   public void setFacDateCreat(Date var1) {
      this.facDateCreat = var1;
   }

   public Date getFacDateAnnule() {
      return this.facDateAnnule;
   }

   public void setFacDateAnnule(Date var1) {
      this.facDateAnnule = var1;
   }

   public Date getFacDateEcheReg() {
      return this.facDateEcheReg;
   }

   public void setFacDateEcheReg(Date var1) {
      this.facDateEcheReg = var1;
   }

   public Date getFacDateImp() {
      return this.facDateImp;
   }

   public void setFacDateImp(Date var1) {
      this.facDateImp = var1;
   }

   public Date getFacDateLivraison() {
      return this.facDateLivraison;
   }

   public void setFacDateLivraison(Date var1) {
      this.facDateLivraison = var1;
   }

   public Date getFacDateRelance() {
      return this.facDateRelance;
   }

   public void setFacDateRelance(Date var1) {
      this.facDateRelance = var1;
   }

   public Date getFacDateTransforme() {
      return this.facDateTransforme;
   }

   public void setFacDateTransforme(Date var1) {
      this.facDateTransforme = var1;
   }

   public Date getFacDateValide() {
      return this.facDateValide;
   }

   public void setFacDateValide(Date var1) {
      this.facDateValide = var1;
   }

   public Date getFacDateValidite() {
      return this.facDateValidite;
   }

   public void setFacDateValidite(Date var1) {
      this.facDateValidite = var1;
   }

   public String getFacDepartement() {
      return this.facDepartement;
   }

   public void setFacDepartement(String var1) {
      this.facDepartement = var1;
   }

   public String getFacDevise() {
      return this.facDevise;
   }

   public void setFacDevise(String var1) {
      this.facDevise = var1;
   }

   public int getFacEtat() {
      return this.facEtat;
   }

   public void setFacEtat(int var1) {
      this.facEtat = var1;
   }

   public int getFacEtatVal() {
      return this.facEtatVal;
   }

   public void setFacEtatVal(int var1) {
      this.facEtatVal = var1;
   }

   public String getFacFormule1() {
      return this.facFormule1;
   }

   public void setFacFormule1(String var1) {
      this.facFormule1 = var1;
   }

   public String getFacFormule2() {
      return this.facFormule2;
   }

   public void setFacFormule2(String var1) {
      this.facFormule2 = var1;
   }

   public String getFacGarde() {
      return this.facGarde;
   }

   public void setFacGarde(String var1) {
      this.facGarde = var1;
   }

   public int getFacGele() {
      return this.facGele;
   }

   public void setFacGele(int var1) {
      this.facGele = var1;
   }

   public long getFacId() {
      return this.facId;
   }

   public void setFacId(long var1) {
      this.facId = var1;
   }

   public long getFacIdCreateur() {
      return this.facIdCreateur;
   }

   public void setFacIdCreateur(long var1) {
      this.facIdCreateur = var1;
   }

   public String getFacIncoterm() {
      return this.facIncoterm;
   }

   public void setFacIncoterm(String var1) {
      this.facIncoterm = var1;
   }

   public String getFacInfoLivraison() {
      return this.facInfoLivraison;
   }

   public void setFacInfoLivraison(String var1) {
      this.facInfoLivraison = var1;
   }

   public String getFacLieuLivraison() {
      return this.facLieuLivraison;
   }

   public void setFacLieuLivraison(String var1) {
      this.facLieuLivraison = var1;
   }

   public String getFacModeReg() {
      return this.facModeReg;
   }

   public void setFacModeReg(String var1) {
      this.facModeReg = var1;
   }

   public String getFacModeleImp() {
      return this.facModeleImp;
   }

   public void setFacModeleImp(String var1) {
      this.facModeleImp = var1;
   }

   public String getFacMotifAnnule() {
      return this.facMotifAnnule;
   }

   public void setFacMotifAnnule(String var1) {
      this.facMotifAnnule = var1;
   }

   public int getFacNbJourReg() {
      return this.facNbJourReg;
   }

   public void setFacNbJourReg(int var1) {
      this.facNbJourReg = var1;
   }

   public String getFacInfo1() {
      return this.facInfo1;
   }

   public void setFacInfo1(String var1) {
      this.facInfo1 = var1;
   }

   public String getFacInfo10() {
      return this.facInfo10;
   }

   public void setFacInfo10(String var1) {
      this.facInfo10 = var1;
   }

   public String getFacInfo2() {
      return this.facInfo2;
   }

   public void setFacInfo2(String var1) {
      this.facInfo2 = var1;
   }

   public String getFacInfo3() {
      return this.facInfo3;
   }

   public void setFacInfo3(String var1) {
      this.facInfo3 = var1;
   }

   public String getFacInfo4() {
      return this.facInfo4;
   }

   public void setFacInfo4(String var1) {
      this.facInfo4 = var1;
   }

   public String getFacInfo5() {
      return this.facInfo5;
   }

   public void setFacInfo5(String var1) {
      this.facInfo5 = var1;
   }

   public String getFacInfo6() {
      return this.facInfo6;
   }

   public void setFacInfo6(String var1) {
      this.facInfo6 = var1;
   }

   public String getFacInfo7() {
      return this.facInfo7;
   }

   public void setFacInfo7(String var1) {
      this.facInfo7 = var1;
   }

   public String getFacInfo8() {
      return this.facInfo8;
   }

   public void setFacInfo8(String var1) {
      this.facInfo8 = var1;
   }

   public String getFacInfo9() {
      return this.facInfo9;
   }

   public void setFacInfo9(String var1) {
      this.facInfo9 = var1;
   }

   public String getFacNomContact() {
      if (this.facNomContact != null && !this.facNomContact.isEmpty()) {
         this.facNomContact = this.facNomContact.toUpperCase();
      }

      return this.facNomContact;
   }

   public void setFacNomContact(String var1) {
      this.facNomContact = var1;
   }

   public String getFacNomCreateur() {
      return this.facNomCreateur;
   }

   public void setFacNomCreateur(String var1) {
      this.facNomCreateur = var1;
   }

   public String getFacNomResponsable() {
      return this.facNomResponsable;
   }

   public void setFacNomResponsable(String var1) {
      this.facNomResponsable = var1;
   }

   public String getFacNomTiers() {
      return this.facNomTiers;
   }

   public void setFacNomTiers(String var1) {
      this.facNomTiers = var1;
   }

   public String getFacNum() {
      return this.facNum;
   }

   public void setFacNum(String var1) {
      this.facNum = var1;
   }

   public String getFacObject() {
      return this.facObject;
   }

   public void setFacObject(String var1) {
      this.facObject = var1;
   }

   public String getFacObservation() {
      return this.facObservation;
   }

   public void setFacObservation(String var1) {
      this.facObservation = var1;
   }

   public String getFacPdv() {
      return this.facPdv;
   }

   public void setFacPdv(String var1) {
      this.facPdv = var1;
   }

   public String getFacRegion() {
      return this.facRegion;
   }

   public void setFacRegion(String var1) {
      this.facRegion = var1;
   }

   public String getFacSecteur() {
      return this.facSecteur;
   }

   public void setFacSecteur(String var1) {
      this.facSecteur = var1;
   }

   public String getFacSerie() {
      return this.facSerie;
   }

   public void setFacSerie(String var1) {
      this.facSerie = var1;
   }

   public String getFacService() {
      return this.facService;
   }

   public void setFacService(String var1) {
      this.facService = var1;
   }

   public String getFacSite() {
      return this.facSite;
   }

   public void setFacSite(String var1) {
      this.facSite = var1;
   }

   public int getFacSolde() {
      return this.facSolde;
   }

   public void setFacSolde(int var1) {
      this.facSolde = var1;
   }

   public double getFacTotHt() {
      return this.facTotHt;
   }

   public void setFacTotHt(double var1) {
      this.facTotHt = var1;
   }

   public double getFacTotRabais() {
      return this.facTotRabais;
   }

   public void setFacTotRabais(double var1) {
      this.facTotRabais = var1;
   }

   public double getFacTotReglement() {
      return this.facTotReglement;
   }

   public void setFacTotReglement(double var1) {
      this.facTotReglement = var1;
   }

   public double getFacTotRemise() {
      return this.facTotRemise;
   }

   public void setFacTotRemise(double var1) {
      this.facTotRemise = var1;
   }

   public double getFacTotTc() {
      return this.facTotTc;
   }

   public void setFacTotTc(double var1) {
      this.facTotTc = var1;
   }

   public double getFacTotTtc() {
      return this.facTotTtc;
   }

   public void setFacTotTtc(double var1) {
      this.facTotTtc = var1;
   }

   public double getFacTotTva() {
      return this.facTotTva;
   }

   public void setFacTotTva(double var1) {
      this.facTotTva = var1;
   }

   public int getFacTypeReg() {
      return this.facTypeReg;
   }

   public void setFacTypeReg(int var1) {
      this.facTypeReg = var1;
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

   public Date getFacDateModif() {
      return this.facDateModif;
   }

   public void setFacDateModif(Date var1) {
      this.facDateModif = var1;
   }

   public long getFacIdModif() {
      return this.facIdModif;
   }

   public void setFacIdModif(long var1) {
      this.facIdModif = var1;
   }

   public String getFacNomModif() {
      return this.facNomModif;
   }

   public void setFacNomModif(String var1) {
      this.facNomModif = var1;
   }

   public Date getFacDate() {
      return this.facDate;
   }

   public void setFacDate(Date var1) {
      this.facDate = var1;
   }

   public int getFacFactorEtat() {
      return this.facFactorEtat;
   }

   public void setFacFactorEtat(int var1) {
      this.facFactorEtat = var1;
   }

   public long getFacFactorId() {
      return this.facFactorId;
   }

   public void setFacFactorId(long var1) {
      this.facFactorId = var1;
   }

   public String getFacFactorNom() {
      return this.facFactorNom;
   }

   public void setFacFactorNom(String var1) {
      this.facFactorNom = var1;
   }

   public int getFacExoDouane() {
      return this.facExoDouane;
   }

   public void setFacExoDouane(int var1) {
      this.facExoDouane = var1;
   }

   public int getFacExoTva() {
      return this.facExoTva;
   }

   public void setFacExoTva(int var1) {
      this.facExoTva = var1;
   }

   public String getFacJournalReg() {
      return this.facJournalReg;
   }

   public void setFacJournalReg(String var1) {
      this.facJournalReg = var1;
   }

   public Date getFacDateVisa() {
      return this.facDateVisa;
   }

   public void setFacDateVisa(Date var1) {
      this.facDateVisa = var1;
   }

   public String getFacMotifExo() {
      return this.facMotifExo;
   }

   public void setFacMotifExo(String var1) {
      this.facMotifExo = var1;
   }

   public String getFacNumVisa() {
      return this.facNumVisa;
   }

   public void setFacNumVisa(String var1) {
      this.facNumVisa = var1;
   }

   public String getFacRangeVisa() {
      return this.facRangeVisa;
   }

   public void setFacRangeVisa(String var1) {
      this.facRangeVisa = var1;
   }

   public String getFacCivilTiers() {
      return this.facCivilTiers;
   }

   public void setFacCivilTiers(String var1) {
      this.facCivilTiers = var1;
   }

   public String getFacCivilContact() {
      return this.facCivilContact;
   }

   public void setFacCivilContact(String var1) {
      this.facCivilContact = var1;
   }

   public long getFacIdResponsable() {
      return this.facIdResponsable;
   }

   public void setFacIdResponsable(long var1) {
      this.facIdResponsable = var1;
   }

   public int getFacTypeTransforme() {
      return this.facTypeTransforme;
   }

   public void setFacTypeTransforme(int var1) {
      this.facTypeTransforme = var1;
   }

   public long getFacIdContact() {
      return this.facIdContact;
   }

   public void setFacIdContact(long var1) {
      this.facIdContact = var1;
   }

   public Date getFacEcheanceReliquat() {
      return this.facEcheanceReliquat;
   }

   public void setFacEcheanceReliquat(Date var1) {
      this.facEcheanceReliquat = var1;
   }

   public String getFacMotifRejetCredit() {
      return this.facMotifRejetCredit;
   }

   public void setFacMotifRejetCredit(String var1) {
      this.facMotifRejetCredit = var1;
   }

   public Date getFacDateTransfert() {
      return this.facDateTransfert;
   }

   public void setFacDateTransfert(Date var1) {
      this.facDateTransfert = var1;
   }

   public Date getFacDateLastReg() {
      return this.facDateLastReg;
   }

   public void setFacDateLastReg(Date var1) {
      this.facDateLastReg = var1;
   }

   public float getFacTauxTc() {
      return this.facTauxTc;
   }

   public void setFacTauxTc(float var1) {
      this.facTauxTc = var1;
   }

   public int getFacDiversTiers() {
      return this.facDiversTiers;
   }

   public void setFacDiversTiers(int var1) {
      this.facDiversTiers = var1;
   }

   public String getFacDiversAdresse() {
      return this.facDiversAdresse;
   }

   public void setFacDiversAdresse(String var1) {
      this.facDiversAdresse = var1;
   }

   public String getFacDiversMail() {
      return this.facDiversMail;
   }

   public void setFacDiversMail(String var1) {
      this.facDiversMail = var1;
   }

   public String getFacDiversNom() {
      if (this.facDiversNom != null && !this.facDiversNom.isEmpty()) {
         this.facDiversNom = this.facDiversNom.toUpperCase();
      }

      return this.facDiversNom;
   }

   public void setFacDiversNom(String var1) {
      this.facDiversNom = var1;
   }

   public String getFacDiversTel() {
      return this.facDiversTel;
   }

   public void setFacDiversTel(String var1) {
      this.facDiversTel = var1;
   }

   public String getFacDiversVille() {
      return this.facDiversVille;
   }

   public void setFacDiversVille(String var1) {
      this.facDiversVille = var1;
   }

   public long getFacIdCommercial() {
      return this.facIdCommercial;
   }

   public void setFacIdCommercial(long var1) {
      this.facIdCommercial = var1;
   }

   public String getFacNomCommercial() {
      return this.facNomCommercial;
   }

   public void setFacNomCommercial(String var1) {
      this.facNomCommercial = var1;
   }

   public int getFacStock() {
      return this.facStock;
   }

   public void setFacStock(int var1) {
      this.facStock = var1;
   }

   public long getFacIdEquipe() {
      return this.facIdEquipe;
   }

   public void setFacIdEquipe(long var1) {
      this.facIdEquipe = var1;
   }

   public String getFacNomEquipe() {
      return this.facNomEquipe;
   }

   public void setFacNomEquipe(String var1) {
      this.facNomEquipe = var1;
   }

   public String getFacNumTrf() {
      return this.facNumTrf;
   }

   public void setFacNumTrf(String var1) {
      this.facNumTrf = var1;
   }

   public String getFacNumBl() {
      return this.facNumBl;
   }

   public void setFacNumBl(String var1) {
      this.facNumBl = var1;
   }

   public String getFacNumAvoir() {
      return this.facNumAvoir;
   }

   public void setFacNumAvoir(String var1) {
      this.facNumAvoir = var1;
   }

   public double getFacTotTimbre() {
      return this.facTotTimbre;
   }

   public void setFacTotTimbre(double var1) {
      this.facTotTimbre = var1;
   }

   public String getFacSource() {
      return this.facSource;
   }

   public void setFacSource(String var1) {
      this.facSource = var1;
   }

   public float getFacTauxRemise() {
      return this.facTauxRemise;
   }

   public void setFacTauxRemise(float var1) {
      this.facTauxRemise = var1;
   }

   public String getFacTiersRegroupe() {
      return this.facTiersRegroupe;
   }

   public void setFacTiersRegroupe(String var1) {
      this.facTiersRegroupe = var1;
   }

   public float getFacTauxAcompte() {
      return this.facTauxAcompte;
   }

   public void setFacTauxAcompte(float var1) {
      this.facTauxAcompte = var1;
   }

   public String getFacContener() {
      return this.facContener;
   }

   public void setFacContener(String var1) {
      this.facContener = var1;
   }

   public int getFacNbAcompte() {
      return this.facNbAcompte;
   }

   public void setFacNbAcompte(int var1) {
      this.facNbAcompte = var1;
   }

   public Date getFacDateTmpReg() {
      return this.facDateTmpReg;
   }

   public void setFacDateTmpReg(Date var1) {
      this.facDateTmpReg = var1;
   }

   public int getFacPosSignature() {
      return this.facPosSignature;
   }

   public void setFacPosSignature(int var1) {
      this.facPosSignature = var1;
   }

   public String getFacNumAcompte() {
      return this.facNumAcompte;
   }

   public void setFacNumAcompte(String var1) {
      this.facNumAcompte = var1;
   }

   public boolean isFacRistourneBloquee() {
      return this.facRistourneBloquee;
   }

   public void setFacRistourneBloquee(boolean var1) {
      this.facRistourneBloquee = var1;
   }

   public Date getFacDateClient() {
      return this.facDateClient;
   }

   public void setFacDateClient(Date var1) {
      this.facDateClient = var1;
   }

   public String getFacNumClient() {
      return this.facNumClient;
   }

   public void setFacNumClient(String var1) {
      this.facNumClient = var1;
   }

   public String getFacAffaire() {
      return this.facAffaire;
   }

   public void setFacAffaire(String var1) {
      this.facAffaire = var1;
   }

   public float getFacPoids() {
      return this.facPoids;
   }

   public void setFacPoids(float var1) {
      this.facPoids = var1;
   }

   public String getCodeSecurity() {
      return this.codeSecurity;
   }

   public void setCodeSecurity(String var1) {
      this.codeSecurity = var1;
   }

   public String getFacDiversNif() {
      return this.facDiversNif;
   }

   public void setFacDiversNif(String var1) {
      this.facDiversNif = var1;
   }
}
