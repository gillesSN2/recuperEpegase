package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FactureEnteteAchats implements Serializable {
   private long fcfId;
   private Date fcfDateCreat;
   private Date fcfDateModif;
   private long fcfIdCreateur;
   private String fcfNomCreateur;
   private long fcfIdModif;
   private String fcfNomModif;
   private Date fcfDate;
   private Date fcfDateLivraison;
   private String fcfNum;
   private String fcfNomResponsable;
   private long fcfIdResponsable;
   private String fcfNomTiers;
   private String fcfCivilTiers;
   private long fcfIdContact;
   private String fcfIncoterm;
   private String fcfNomContact;
   private String fcfCivilContact;
   private String fcfSerie;
   private int fcfExoTva;
   private int fcfExoDouane;
   private String fcfJournalReg;
   private String fcfCat;
   private String fcfDevise;
   private float fcfCoefDevise;
   private String fcfObject;
   private String fcfObservation;
   private String fcfBudget;
   private double fcfBudgetDispo;
   private double fcfBudgetTreso;
   private double fcfBudgetDispoMois;
   private double fcfBudgetTresoMois;
   private double fcfTotHt;
   private double fcfTotRemise;
   private double fcfTotRabais;
   private double fcfTotTva;
   private double fcfTotTc;
   private double fcfTotTtc;
   private float fcfTotPoidsBrut;
   private float fcfTotQte;
   private double fcfTotHtLocal;
   private double fcfTotTvaLocal;
   private double fcfTotTtcLocal;
   private double fcfTotRemiseLocal;
   private double fcfTotRabaisLocal;
   private double fcfTotReglement;
   private double fcfTotTimbre;
   private double fcfTotFret;
   private double fcfTotFretLocal;
   private double fcfTotFret2;
   private double fcfTotFret2Local;
   private double fcfTotAssurance;
   private double fcfTotAssuranceLocal;
   private int fcfSolde;
   private String fcfBanque;
   private int fcfTypeReg;
   private String fcfModeReg;
   private int fcfNbJourReg;
   private int fcfArrondiReg;
   private String fcfConditionReg;
   private Date fcfDateEcheReg;
   private Date fcfDateLastReg;
   private String fcfActivite;
   private String fcfSite;
   private String fcfDepartement;
   private String fcfService;
   private String fcfRegion;
   private String fcfSecteur;
   private String fcfPdv;
   private String fcfAnal1;
   private String fcfAnal2;
   private String fcfAnal4;
   private String fcfAffaire;
   private String fcfInfo1;
   private String fcfInfo2;
   private String fcfInfo3;
   private String fcfInfo4;
   private String fcfInfo5;
   private String fcfInfo6;
   private String fcfInfo7;
   private String fcfInfo8;
   private String fcfInfo9;
   private String fcfInfo10;
   private String fcfFormule1;
   private String fcfFormule2;
   private String fcfAnnexe1;
   private String fcfAnnexe2;
   private String fcfContrat;
   private String fcfProformaFour;
   private String fcfNumFour;
   private Date fcfDateImp;
   private String fcfModeleImp;
   private int fcfEtatVal;
   private int fcfGele;
   private int fcfEtat;
   private String fcfNumTrf;
   private Date fcfDateValidite;
   private Date fcfDateRelance;
   private Date fcfDateValide;
   private int fcfPosSignature;
   private Date fcfDateTransforme;
   private int fcfTypeTransforme;
   private Date fcfDateAnnule;
   private String fcfMotifAnnule;
   private Date fcfDateTransfert;
   private String fcfFactorNom;
   private long fcfFactorId;
   private int fcfFactorEtat;
   private Date fcfDateValo;
   private int fcfTypeValo;
   private float fcfCoefValo;
   private String fcfFraisValo;
   private int fcfDiversTiers;
   private String fcfDiversNom;
   private String fcfDiversAdresse;
   private String fcfDiversVille;
   private String fcfDiversTel;
   private String fcfDiversMail;
   private boolean fcfPj;
   private String fcfSource;
   private ExercicesAchats exercicesAchats;
   private Tiers tiers;
   private Users users;
   private double totRabaisRemise;
   private String libelleEta;
   private String var_solde;
   private double var_reliquat;
   private boolean var_select_ligne;
   private int var_format_devise;
   private String var_nomContact;
   private String var_nom_tiers;
   private double var_fac_timbre;
   private double montantReglementManuel;
   private double varTotTtcGlob;
   private String pj;

   public String getPj() {
      if (!this.fcfPj) {
         this.pj = null;
      } else if (this.fcfPj) {
         this.pj = "/images/mail_pj.png";
      }

      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.fcfTotTtc + this.fcfTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getVar_nom_tiers() {
      if (this.fcfDiversNom != null && !this.fcfDiversNom.isEmpty()) {
         this.var_nom_tiers = this.fcfDiversNom;
      } else if (this.fcfCivilTiers != null && !this.fcfCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.fcfCivilTiers + " " + this.fcfNomTiers;
      } else {
         this.var_nom_tiers = this.fcfNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.fcfDiversNom != null && !this.fcfDiversNom.isEmpty()) {
         this.var_nomContact = "(fournisseur divers)";
      } else if (this.fcfCivilContact != null && !this.fcfCivilContact.isEmpty()) {
         if (this.fcfNomContact != null && !this.fcfNomContact.isEmpty()) {
            this.var_nomContact = this.fcfCivilContact + " " + this.fcfNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.fcfNomContact != null && !this.fcfNomContact.isEmpty()) {
         this.var_nomContact = this.fcfNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.fcfEtat == 0) {
         this.libelleEta = "En cours";
      } else if (this.fcfEtat == 1) {
         this.libelleEta = "Validée";
      } else if (this.fcfEtat == 2) {
         this.libelleEta = "Gelée";
      } else if (this.fcfEtat == 3) {
         this.libelleEta = "Annulée";
      } else if (this.fcfEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.fcfEtat == 5) {
         this.libelleEta = "Trf.T.";
      } else if (this.fcfEtat == 6) {
         this.libelleEta = "Compta.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public String getVar_solde() {
      if (this.fcfSolde == 1) {
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
      this.var_reliquat = this.fcfTotTtc - this.fcfTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public int getVar_format_devise() {
      if (!this.fcfDevise.equals("XOF") && !this.fcfDevise.equals("XAF")) {
         if (!this.fcfDevise.equals("EUR") && !this.fcfDevise.equals("XEU") && !this.fcfDevise.equals("CHF")) {
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

   public double getTotRabaisRemise() {
      this.totRabaisRemise = this.fcfTotRabais + this.fcfTotRemise;
      return this.totRabaisRemise;
   }

   public void setTotRabaisRemise(double var1) {
      this.totRabaisRemise = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public String getFcfActivite() {
      return this.fcfActivite;
   }

   public void setFcfActivite(String var1) {
      this.fcfActivite = var1;
   }

   public String getFcfAnal2() {
      return this.fcfAnal2;
   }

   public void setFcfAnal2(String var1) {
      this.fcfAnal2 = var1;
   }

   public String getFcfAnal4() {
      return this.fcfAnal4;
   }

   public void setFcfAnal4(String var1) {
      this.fcfAnal4 = var1;
   }

   public String getFcfAnnexe1() {
      return this.fcfAnnexe1;
   }

   public void setFcfAnnexe1(String var1) {
      this.fcfAnnexe1 = var1;
   }

   public String getFcfAnnexe2() {
      return this.fcfAnnexe2;
   }

   public void setFcfAnnexe2(String var1) {
      this.fcfAnnexe2 = var1;
   }

   public int getFcfArrondiReg() {
      return this.fcfArrondiReg;
   }

   public void setFcfArrondiReg(int var1) {
      this.fcfArrondiReg = var1;
   }

   public String getFcfBanque() {
      return this.fcfBanque;
   }

   public void setFcfBanque(String var1) {
      this.fcfBanque = var1;
   }

   public String getFcfBudget() {
      return this.fcfBudget;
   }

   public void setFcfBudget(String var1) {
      this.fcfBudget = var1;
   }

   public double getFcfBudgetDispo() {
      return this.fcfBudgetDispo;
   }

   public void setFcfBudgetDispo(double var1) {
      this.fcfBudgetDispo = var1;
   }

   public double getFcfBudgetTreso() {
      return this.fcfBudgetTreso;
   }

   public void setFcfBudgetTreso(double var1) {
      this.fcfBudgetTreso = var1;
   }

   public String getFcfCat() {
      return this.fcfCat;
   }

   public void setFcfCat(String var1) {
      this.fcfCat = var1;
   }

   public String getFcfConditionReg() {
      return this.fcfConditionReg;
   }

   public void setFcfConditionReg(String var1) {
      this.fcfConditionReg = var1;
   }

   public String getFcfContrat() {
      return this.fcfContrat;
   }

   public void setFcfContrat(String var1) {
      this.fcfContrat = var1;
   }

   public Date getFcfDate() {
      return this.fcfDate;
   }

   public void setFcfDate(Date var1) {
      this.fcfDate = var1;
   }

   public Date getFcfDateCreat() {
      return this.fcfDateCreat;
   }

   public void setFcfDateCreat(Date var1) {
      this.fcfDateCreat = var1;
   }

   public Date getFcfDateEcheReg() {
      return this.fcfDateEcheReg;
   }

   public void setFcfDateEcheReg(Date var1) {
      this.fcfDateEcheReg = var1;
   }

   public Date getFcfDateImp() {
      return this.fcfDateImp;
   }

   public void setFcfDateImp(Date var1) {
      this.fcfDateImp = var1;
   }

   public Date getFcfDateModif() {
      return this.fcfDateModif;
   }

   public void setFcfDateModif(Date var1) {
      this.fcfDateModif = var1;
   }

   public Date getFcfDateRelance() {
      return this.fcfDateRelance;
   }

   public void setFcfDateRelance(Date var1) {
      this.fcfDateRelance = var1;
   }

   public Date getFcfDateTransforme() {
      return this.fcfDateTransforme;
   }

   public void setFcfDateTransforme(Date var1) {
      this.fcfDateTransforme = var1;
   }

   public Date getFcfDateValide() {
      return this.fcfDateValide;
   }

   public void setFcfDateValide(Date var1) {
      this.fcfDateValide = var1;
   }

   public Date getFcfDateValidite() {
      return this.fcfDateValidite;
   }

   public void setFcfDateValidite(Date var1) {
      this.fcfDateValidite = var1;
   }

   public String getFcfDepartement() {
      return this.fcfDepartement;
   }

   public void setFcfDepartement(String var1) {
      this.fcfDepartement = var1;
   }

   public String getFcfDevise() {
      return this.fcfDevise;
   }

   public void setFcfDevise(String var1) {
      this.fcfDevise = var1;
   }

   public int getFcfEtat() {
      return this.fcfEtat;
   }

   public void setFcfEtat(int var1) {
      this.fcfEtat = var1;
   }

   public int getFcfEtatVal() {
      return this.fcfEtatVal;
   }

   public void setFcfEtatVal(int var1) {
      this.fcfEtatVal = var1;
   }

   public String getFcfFormule1() {
      return this.fcfFormule1;
   }

   public void setFcfFormule1(String var1) {
      this.fcfFormule1 = var1;
   }

   public String getFcfFormule2() {
      return this.fcfFormule2;
   }

   public void setFcfFormule2(String var1) {
      this.fcfFormule2 = var1;
   }

   public int getFcfGele() {
      return this.fcfGele;
   }

   public void setFcfGele(int var1) {
      this.fcfGele = var1;
   }

   public long getFcfId() {
      return this.fcfId;
   }

   public void setFcfId(long var1) {
      this.fcfId = var1;
   }

   public long getFcfIdCreateur() {
      return this.fcfIdCreateur;
   }

   public void setFcfIdCreateur(long var1) {
      this.fcfIdCreateur = var1;
   }

   public long getFcfIdModif() {
      return this.fcfIdModif;
   }

   public void setFcfIdModif(long var1) {
      this.fcfIdModif = var1;
   }

   public String getFcfInfo1() {
      return this.fcfInfo1;
   }

   public void setFcfInfo1(String var1) {
      this.fcfInfo1 = var1;
   }

   public String getFcfInfo10() {
      return this.fcfInfo10;
   }

   public void setFcfInfo10(String var1) {
      this.fcfInfo10 = var1;
   }

   public String getFcfInfo2() {
      return this.fcfInfo2;
   }

   public void setFcfInfo2(String var1) {
      this.fcfInfo2 = var1;
   }

   public String getFcfInfo3() {
      return this.fcfInfo3;
   }

   public void setFcfInfo3(String var1) {
      this.fcfInfo3 = var1;
   }

   public String getFcfInfo4() {
      return this.fcfInfo4;
   }

   public void setFcfInfo4(String var1) {
      this.fcfInfo4 = var1;
   }

   public String getFcfInfo5() {
      return this.fcfInfo5;
   }

   public void setFcfInfo5(String var1) {
      this.fcfInfo5 = var1;
   }

   public String getFcfInfo6() {
      return this.fcfInfo6;
   }

   public void setFcfInfo6(String var1) {
      this.fcfInfo6 = var1;
   }

   public String getFcfInfo7() {
      return this.fcfInfo7;
   }

   public void setFcfInfo7(String var1) {
      this.fcfInfo7 = var1;
   }

   public String getFcfInfo8() {
      return this.fcfInfo8;
   }

   public void setFcfInfo8(String var1) {
      this.fcfInfo8 = var1;
   }

   public String getFcfInfo9() {
      return this.fcfInfo9;
   }

   public void setFcfInfo9(String var1) {
      this.fcfInfo9 = var1;
   }

   public String getFcfModeleImp() {
      return this.fcfModeleImp;
   }

   public void setFcfModeleImp(String var1) {
      this.fcfModeleImp = var1;
   }

   public int getFcfNbJourReg() {
      return this.fcfNbJourReg;
   }

   public void setFcfNbJourReg(int var1) {
      this.fcfNbJourReg = var1;
   }

   public String getFcfNomContact() {
      return this.fcfNomContact;
   }

   public void setFcfNomContact(String var1) {
      this.fcfNomContact = var1;
   }

   public String getFcfNomCreateur() {
      return this.fcfNomCreateur;
   }

   public void setFcfNomCreateur(String var1) {
      this.fcfNomCreateur = var1;
   }

   public String getFcfNomModif() {
      return this.fcfNomModif;
   }

   public void setFcfNomModif(String var1) {
      this.fcfNomModif = var1;
   }

   public String getFcfNomResponsable() {
      return this.fcfNomResponsable;
   }

   public void setFcfNomResponsable(String var1) {
      this.fcfNomResponsable = var1;
   }

   public String getFcfNomTiers() {
      return this.fcfNomTiers;
   }

   public void setFcfNomTiers(String var1) {
      this.fcfNomTiers = var1;
   }

   public String getFcfNum() {
      return this.fcfNum;
   }

   public void setFcfNum(String var1) {
      this.fcfNum = var1;
   }

   public String getFcfNumFour() {
      return this.fcfNumFour;
   }

   public void setFcfNumFour(String var1) {
      this.fcfNumFour = var1;
   }

   public String getFcfObject() {
      return this.fcfObject;
   }

   public void setFcfObject(String var1) {
      this.fcfObject = var1;
   }

   public String getFcfObservation() {
      return this.fcfObservation;
   }

   public void setFcfObservation(String var1) {
      this.fcfObservation = var1;
   }

   public String getFcfPdv() {
      return this.fcfPdv;
   }

   public void setFcfPdv(String var1) {
      this.fcfPdv = var1;
   }

   public String getFcfRegion() {
      return this.fcfRegion;
   }

   public void setFcfRegion(String var1) {
      this.fcfRegion = var1;
   }

   public String getFcfSecteur() {
      return this.fcfSecteur;
   }

   public void setFcfSecteur(String var1) {
      this.fcfSecteur = var1;
   }

   public String getFcfSerie() {
      return this.fcfSerie;
   }

   public void setFcfSerie(String var1) {
      this.fcfSerie = var1;
   }

   public String getFcfService() {
      return this.fcfService;
   }

   public void setFcfService(String var1) {
      this.fcfService = var1;
   }

   public String getFcfSite() {
      return this.fcfSite;
   }

   public void setFcfSite(String var1) {
      this.fcfSite = var1;
   }

   public int getFcfSolde() {
      return this.fcfSolde;
   }

   public void setFcfSolde(int var1) {
      this.fcfSolde = var1;
   }

   public double getFcfTotHt() {
      return this.fcfTotHt;
   }

   public void setFcfTotHt(double var1) {
      this.fcfTotHt = var1;
   }

   public double getFcfTotRabais() {
      return this.fcfTotRabais;
   }

   public void setFcfTotRabais(double var1) {
      this.fcfTotRabais = var1;
   }

   public double getFcfTotReglement() {
      return this.fcfTotReglement;
   }

   public void setFcfTotReglement(double var1) {
      this.fcfTotReglement = var1;
   }

   public double getFcfTotRemise() {
      return this.fcfTotRemise;
   }

   public void setFcfTotRemise(double var1) {
      this.fcfTotRemise = var1;
   }

   public double getFcfTotTc() {
      return this.fcfTotTc;
   }

   public void setFcfTotTc(double var1) {
      this.fcfTotTc = var1;
   }

   public double getFcfTotTtc() {
      return this.fcfTotTtc;
   }

   public void setFcfTotTtc(double var1) {
      this.fcfTotTtc = var1;
   }

   public double getFcfTotTva() {
      return this.fcfTotTva;
   }

   public void setFcfTotTva(double var1) {
      this.fcfTotTva = var1;
   }

   public int getFcfTypeReg() {
      return this.fcfTypeReg;
   }

   public void setFcfTypeReg(int var1) {
      this.fcfTypeReg = var1;
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

   public Date getFcfDateAnnule() {
      return this.fcfDateAnnule;
   }

   public void setFcfDateAnnule(Date var1) {
      this.fcfDateAnnule = var1;
   }

   public String getFcfMotifAnnule() {
      return this.fcfMotifAnnule;
   }

   public void setFcfMotifAnnule(String var1) {
      this.fcfMotifAnnule = var1;
   }

   public int getFcfExoDouane() {
      return this.fcfExoDouane;
   }

   public void setFcfExoDouane(int var1) {
      this.fcfExoDouane = var1;
   }

   public int getFcfExoTva() {
      return this.fcfExoTva;
   }

   public void setFcfExoTva(int var1) {
      this.fcfExoTva = var1;
   }

   public String getFcfJournalReg() {
      return this.fcfJournalReg;
   }

   public void setFcfJournalReg(String var1) {
      this.fcfJournalReg = var1;
   }

   public String getFcfCivilContact() {
      return this.fcfCivilContact;
   }

   public void setFcfCivilContact(String var1) {
      this.fcfCivilContact = var1;
   }

   public String getFcfCivilTiers() {
      return this.fcfCivilTiers;
   }

   public void setFcfCivilTiers(String var1) {
      this.fcfCivilTiers = var1;
   }

   public long getFcfIdResponsable() {
      return this.fcfIdResponsable;
   }

   public void setFcfIdResponsable(long var1) {
      this.fcfIdResponsable = var1;
   }

   public String getFcfModeReg() {
      return this.fcfModeReg;
   }

   public void setFcfModeReg(String var1) {
      this.fcfModeReg = var1;
   }

   public int getFcfFactorEtat() {
      return this.fcfFactorEtat;
   }

   public void setFcfFactorEtat(int var1) {
      this.fcfFactorEtat = var1;
   }

   public long getFcfFactorId() {
      return this.fcfFactorId;
   }

   public void setFcfFactorId(long var1) {
      this.fcfFactorId = var1;
   }

   public String getFcfFactorNom() {
      return this.fcfFactorNom;
   }

   public void setFcfFactorNom(String var1) {
      this.fcfFactorNom = var1;
   }

   public int getFcfTypeTransforme() {
      return this.fcfTypeTransforme;
   }

   public void setFcfTypeTransforme(int var1) {
      this.fcfTypeTransforme = var1;
   }

   public float getFcfCoefValo() {
      return this.fcfCoefValo;
   }

   public void setFcfCoefValo(float var1) {
      this.fcfCoefValo = var1;
   }

   public Date getFcfDateValo() {
      return this.fcfDateValo;
   }

   public void setFcfDateValo(Date var1) {
      this.fcfDateValo = var1;
   }

   public String getFcfFraisValo() {
      return this.fcfFraisValo;
   }

   public void setFcfFraisValo(String var1) {
      this.fcfFraisValo = var1;
   }

   public int getFcfTypeValo() {
      return this.fcfTypeValo;
   }

   public void setFcfTypeValo(int var1) {
      this.fcfTypeValo = var1;
   }

   public double getFcfBudgetDispoMois() {
      return this.fcfBudgetDispoMois;
   }

   public void setFcfBudgetDispoMois(double var1) {
      this.fcfBudgetDispoMois = var1;
   }

   public double getFcfBudgetTresoMois() {
      return this.fcfBudgetTresoMois;
   }

   public void setFcfBudgetTresoMois(double var1) {
      this.fcfBudgetTresoMois = var1;
   }

   public Date getFcfDateTransfert() {
      return this.fcfDateTransfert;
   }

   public void setFcfDateTransfert(Date var1) {
      this.fcfDateTransfert = var1;
   }

   public long getFcfIdContact() {
      return this.fcfIdContact;
   }

   public void setFcfIdContact(long var1) {
      this.fcfIdContact = var1;
   }

   public Date getFcfDateLivraison() {
      return this.fcfDateLivraison;
   }

   public void setFcfDateLivraison(Date var1) {
      this.fcfDateLivraison = var1;
   }

   public float getFcfCoefDevise() {
      return this.fcfCoefDevise;
   }

   public void setFcfCoefDevise(float var1) {
      this.fcfCoefDevise = var1;
   }

   public double getFcfTotHtLocal() {
      return this.fcfTotHtLocal;
   }

   public void setFcfTotHtLocal(double var1) {
      this.fcfTotHtLocal = var1;
   }

   public double getFcfTotRabaisLocal() {
      return this.fcfTotRabaisLocal;
   }

   public void setFcfTotRabaisLocal(double var1) {
      this.fcfTotRabaisLocal = var1;
   }

   public double getFcfTotRemiseLocal() {
      return this.fcfTotRemiseLocal;
   }

   public void setFcfTotRemiseLocal(double var1) {
      this.fcfTotRemiseLocal = var1;
   }

   public double getFcfTotTtcLocal() {
      return this.fcfTotTtcLocal;
   }

   public void setFcfTotTtcLocal(double var1) {
      this.fcfTotTtcLocal = var1;
   }

   public double getFcfTotTvaLocal() {
      return this.fcfTotTvaLocal;
   }

   public void setFcfTotTvaLocal(double var1) {
      this.fcfTotTvaLocal = var1;
   }

   public String getFcfDiversAdresse() {
      return this.fcfDiversAdresse;
   }

   public void setFcfDiversAdresse(String var1) {
      this.fcfDiversAdresse = var1;
   }

   public String getFcfDiversMail() {
      return this.fcfDiversMail;
   }

   public void setFcfDiversMail(String var1) {
      this.fcfDiversMail = var1;
   }

   public String getFcfDiversNom() {
      return this.fcfDiversNom;
   }

   public void setFcfDiversNom(String var1) {
      this.fcfDiversNom = var1;
   }

   public String getFcfDiversTel() {
      return this.fcfDiversTel;
   }

   public void setFcfDiversTel(String var1) {
      this.fcfDiversTel = var1;
   }

   public int getFcfDiversTiers() {
      return this.fcfDiversTiers;
   }

   public void setFcfDiversTiers(int var1) {
      this.fcfDiversTiers = var1;
   }

   public String getFcfDiversVille() {
      return this.fcfDiversVille;
   }

   public void setFcfDiversVille(String var1) {
      this.fcfDiversVille = var1;
   }

   public String getFcfProformaFour() {
      return this.fcfProformaFour;
   }

   public void setFcfProformaFour(String var1) {
      this.fcfProformaFour = var1;
   }

   public String getFcfNumTrf() {
      return this.fcfNumTrf;
   }

   public void setFcfNumTrf(String var1) {
      this.fcfNumTrf = var1;
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

   public double getFcfTotTimbre() {
      return this.fcfTotTimbre;
   }

   public void setFcfTotTimbre(double var1) {
      this.fcfTotTimbre = var1;
   }

   public Date getFcfDateLastReg() {
      return this.fcfDateLastReg;
   }

   public void setFcfDateLastReg(Date var1) {
      this.fcfDateLastReg = var1;
   }

   public int getFcfPosSignature() {
      return this.fcfPosSignature;
   }

   public void setFcfPosSignature(int var1) {
      this.fcfPosSignature = var1;
   }

   public double getFcfTotAssurance() {
      return this.fcfTotAssurance;
   }

   public void setFcfTotAssurance(double var1) {
      this.fcfTotAssurance = var1;
   }

   public double getFcfTotAssuranceLocal() {
      return this.fcfTotAssuranceLocal;
   }

   public void setFcfTotAssuranceLocal(double var1) {
      this.fcfTotAssuranceLocal = var1;
   }

   public double getFcfTotFret() {
      return this.fcfTotFret;
   }

   public void setFcfTotFret(double var1) {
      this.fcfTotFret = var1;
   }

   public double getFcfTotFret2() {
      return this.fcfTotFret2;
   }

   public void setFcfTotFret2(double var1) {
      this.fcfTotFret2 = var1;
   }

   public double getFcfTotFret2Local() {
      return this.fcfTotFret2Local;
   }

   public void setFcfTotFret2Local(double var1) {
      this.fcfTotFret2Local = var1;
   }

   public double getFcfTotFretLocal() {
      return this.fcfTotFretLocal;
   }

   public void setFcfTotFretLocal(double var1) {
      this.fcfTotFretLocal = var1;
   }

   public float getFcfTotPoidsBrut() {
      return this.fcfTotPoidsBrut;
   }

   public void setFcfTotPoidsBrut(float var1) {
      this.fcfTotPoidsBrut = var1;
   }

   public float getFcfTotQte() {
      return this.fcfTotQte;
   }

   public void setFcfTotQte(float var1) {
      this.fcfTotQte = var1;
   }

   public String getFcfIncoterm() {
      return this.fcfIncoterm;
   }

   public void setFcfIncoterm(String var1) {
      this.fcfIncoterm = var1;
   }

   public String getFcfAffaire() {
      return this.fcfAffaire;
   }

   public void setFcfAffaire(String var1) {
      this.fcfAffaire = var1;
   }

   public boolean isFcfPj() {
      return this.fcfPj;
   }

   public void setFcfPj(boolean var1) {
      this.fcfPj = var1;
   }

   public String getFcfSource() {
      return this.fcfSource;
   }

   public void setFcfSource(String var1) {
      this.fcfSource = var1;
   }

   public String getFcfAnal1() {
      return this.fcfAnal1;
   }

   public void setFcfAnal1(String var1) {
      this.fcfAnal1 = var1;
   }
}
