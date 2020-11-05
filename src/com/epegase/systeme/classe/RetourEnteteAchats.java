package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class RetourEnteteAchats implements Serializable {
   private long brfId;
   private Date brfDateCreat;
   private Date brfDateModif;
   private long brfIdCreateur;
   private String brfNomCreateur;
   private long brfIdModif;
   private String brfNomModif;
   private Date brfDate;
   private String brfNum;
   private String brfValo;
   private String brfNomResponsable;
   private long brfIdResponsable;
   private String brfNomTiers;
   private String brfCivilTiers;
   private long brfIdContact;
   private String brfNomContact;
   private String brfCivilContact;
   private String brfSerie;
   private int brfExoTva;
   private int brfExoDouane;
   private String brfJournalReg;
   private String brfCat;
   private String brfDevise;
   private String brfObject;
   private String brfObservation;
   private String brfBudget;
   private double brfBudgetDispo;
   private double brfBudgetTreso;
   private double brfBudgetDispoMois;
   private double brfBudgetTresoMois;
   private double brfTotHt;
   private double brfTotRemise;
   private double brfTotRabais;
   private double brfTotTva;
   private double brfTotTc;
   private double brfTotTtc;
   private double brfTotReglement;
   private String brfConditionReg;
   private int brfSolde;
   private String brfBanque;
   private int brfTypeReg;
   private String brfModeReg;
   private double brfTotBonEncais;
   private int brfNbJourReg;
   private int brfArrondiReg;
   private Date brfDateEcheReg;
   private String brfActivite;
   private String brfSite;
   private String brfDepartement;
   private String brfService;
   private String brfRegion;
   private String brfSecteur;
   private String brfPdv;
   private String brfAnal1;
   private String brfAnal2;
   private String brfAnal4;
   private String brfAffaire;
   private String brfInfo1;
   private String brfInfo2;
   private String brfInfo3;
   private String brfInfo4;
   private String brfInfo5;
   private String brfInfo6;
   private String brfInfo7;
   private String brfInfo8;
   private String brfInfo9;
   private String brfInfo10;
   private String brfFormule1;
   private String brfFormule2;
   private String brfAnnexe1;
   private String brfAnnexe2;
   private String brfContrat;
   private String brfIncoterm;
   private String brfLieuLivraison;
   private Date brfDateLivraison;
   private String brfInfoLivraison;
   private Date brfDateImp;
   private String brfModeleImp;
   private int brfEtatVal;
   private int brfGele;
   private int brfEtat;
   private Date brfDateValidite;
   private Date brfDateRelance;
   private Date brfDateValide;
   private int brfPosSignature;
   private Date brfDateTransforme;
   private int brfTypeTransforme;
   private Date brfDateAnnule;
   private String brfMotifAnnule;
   private String brfFactorNom;
   private long brfFactorId;
   private int brfFactorEtat;
   private String brfLivreurNom;
   private String brfCommentaire;
   private String brfProduction;
   private int brfDiversTiers;
   private String brfDiversNom;
   private String brfDiversAdresse;
   private String brfDiversVille;
   private String brfDiversTel;
   private String brfDiversMail;
   private String brfNumAvoir;
   private String brfSource;
   private ExercicesAchats exercicesAchats;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private String var_solde;
   private boolean var_select_ligne;
   private int var_format_devise;
   private String var_nomContact;
   private String var_nom_tiers;

   public String getVar_nom_tiers() {
      if (this.brfDiversNom != null && !this.brfDiversNom.isEmpty()) {
         this.var_nom_tiers = this.brfDiversNom;
      } else if (this.brfCivilTiers != null && !this.brfCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.brfCivilTiers + " " + this.brfNomTiers;
      } else {
         this.var_nom_tiers = this.brfNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.brfDiversNom != null && !this.brfDiversNom.isEmpty()) {
         this.var_nomContact = "(fournisseur divers)";
      } else if (this.brfCivilContact != null && !this.brfCivilContact.isEmpty()) {
         if (this.brfNomContact != null && !this.brfNomContact.isEmpty()) {
            this.var_nomContact = this.brfCivilContact + " " + this.brfNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.brfNomContact != null && !this.brfNomContact.isEmpty()) {
         this.var_nomContact = this.brfNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getBrfActivite() {
      return this.brfActivite;
   }

   public void setBrfActivite(String var1) {
      this.brfActivite = var1;
   }

   public String getBrfAnal2() {
      return this.brfAnal2;
   }

   public void setBrfAnal2(String var1) {
      this.brfAnal2 = var1;
   }

   public String getBrfAnal4() {
      return this.brfAnal4;
   }

   public void setBrfAnal4(String var1) {
      this.brfAnal4 = var1;
   }

   public String getBrfAnnexe1() {
      return this.brfAnnexe1;
   }

   public void setBrfAnnexe1(String var1) {
      this.brfAnnexe1 = var1;
   }

   public String getBrfAnnexe2() {
      return this.brfAnnexe2;
   }

   public void setBrfAnnexe2(String var1) {
      this.brfAnnexe2 = var1;
   }

   public int getBrfArrondiReg() {
      return this.brfArrondiReg;
   }

   public void setBrfArrondiReg(int var1) {
      this.brfArrondiReg = var1;
   }

   public String getBrfBanque() {
      return this.brfBanque;
   }

   public void setBrfBanque(String var1) {
      this.brfBanque = var1;
   }

   public String getBrfBudget() {
      return this.brfBudget;
   }

   public void setBrfBudget(String var1) {
      this.brfBudget = var1;
   }

   public double getBrfBudgetDispo() {
      return this.brfBudgetDispo;
   }

   public void setBrfBudgetDispo(double var1) {
      this.brfBudgetDispo = var1;
   }

   public double getBrfBudgetTreso() {
      return this.brfBudgetTreso;
   }

   public void setBrfBudgetTreso(double var1) {
      this.brfBudgetTreso = var1;
   }

   public String getBrfCat() {
      return this.brfCat;
   }

   public void setBrfCat(String var1) {
      this.brfCat = var1;
   }

   public String getBrfContrat() {
      return this.brfContrat;
   }

   public void setBrfContrat(String var1) {
      this.brfContrat = var1;
   }

   public Date getBrfDate() {
      return this.brfDate;
   }

   public void setBrfDate(Date var1) {
      this.brfDate = var1;
   }

   public Date getBrfDateAnnule() {
      return this.brfDateAnnule;
   }

   public void setBrfDateAnnule(Date var1) {
      this.brfDateAnnule = var1;
   }

   public Date getBrfDateCreat() {
      return this.brfDateCreat;
   }

   public void setBrfDateCreat(Date var1) {
      this.brfDateCreat = var1;
   }

   public Date getBrfDateEcheReg() {
      return this.brfDateEcheReg;
   }

   public void setBrfDateEcheReg(Date var1) {
      this.brfDateEcheReg = var1;
   }

   public Date getBrfDateImp() {
      return this.brfDateImp;
   }

   public void setBrfDateImp(Date var1) {
      this.brfDateImp = var1;
   }

   public Date getBrfDateLivraison() {
      return this.brfDateLivraison;
   }

   public void setBrfDateLivraison(Date var1) {
      this.brfDateLivraison = var1;
   }

   public Date getBrfDateModif() {
      return this.brfDateModif;
   }

   public void setBrfDateModif(Date var1) {
      this.brfDateModif = var1;
   }

   public Date getBrfDateRelance() {
      return this.brfDateRelance;
   }

   public void setBrfDateRelance(Date var1) {
      this.brfDateRelance = var1;
   }

   public Date getBrfDateTransforme() {
      return this.brfDateTransforme;
   }

   public void setBrfDateTransforme(Date var1) {
      this.brfDateTransforme = var1;
   }

   public Date getBrfDateValide() {
      return this.brfDateValide;
   }

   public void setBrfDateValide(Date var1) {
      this.brfDateValide = var1;
   }

   public Date getBrfDateValidite() {
      return this.brfDateValidite;
   }

   public void setBrfDateValidite(Date var1) {
      this.brfDateValidite = var1;
   }

   public String getBrfDepartement() {
      return this.brfDepartement;
   }

   public void setBrfDepartement(String var1) {
      this.brfDepartement = var1;
   }

   public String getBrfDevise() {
      return this.brfDevise;
   }

   public void setBrfDevise(String var1) {
      this.brfDevise = var1;
   }

   public int getBrfEtat() {
      return this.brfEtat;
   }

   public void setBrfEtat(int var1) {
      this.brfEtat = var1;
   }

   public int getBrfEtatVal() {
      return this.brfEtatVal;
   }

   public void setBrfEtatVal(int var1) {
      this.brfEtatVal = var1;
   }

   public String getBrfFormule1() {
      return this.brfFormule1;
   }

   public void setBrfFormule1(String var1) {
      this.brfFormule1 = var1;
   }

   public String getBrfFormule2() {
      return this.brfFormule2;
   }

   public void setBrfFormule2(String var1) {
      this.brfFormule2 = var1;
   }

   public int getBrfGele() {
      return this.brfGele;
   }

   public void setBrfGele(int var1) {
      this.brfGele = var1;
   }

   public long getBrfId() {
      return this.brfId;
   }

   public void setBrfId(long var1) {
      this.brfId = var1;
   }

   public long getBrfIdCreateur() {
      return this.brfIdCreateur;
   }

   public void setBrfIdCreateur(long var1) {
      this.brfIdCreateur = var1;
   }

   public long getBrfIdModif() {
      return this.brfIdModif;
   }

   public void setBrfIdModif(long var1) {
      this.brfIdModif = var1;
   }

   public String getBrfIncoterm() {
      return this.brfIncoterm;
   }

   public void setBrfIncoterm(String var1) {
      this.brfIncoterm = var1;
   }

   public String getBrfInfo1() {
      return this.brfInfo1;
   }

   public void setBrfInfo1(String var1) {
      this.brfInfo1 = var1;
   }

   public String getBrfInfo10() {
      return this.brfInfo10;
   }

   public void setBrfInfo10(String var1) {
      this.brfInfo10 = var1;
   }

   public String getBrfInfo2() {
      return this.brfInfo2;
   }

   public void setBrfInfo2(String var1) {
      this.brfInfo2 = var1;
   }

   public String getBrfInfo3() {
      return this.brfInfo3;
   }

   public void setBrfInfo3(String var1) {
      this.brfInfo3 = var1;
   }

   public String getBrfInfo4() {
      return this.brfInfo4;
   }

   public void setBrfInfo4(String var1) {
      this.brfInfo4 = var1;
   }

   public String getBrfInfo5() {
      return this.brfInfo5;
   }

   public void setBrfInfo5(String var1) {
      this.brfInfo5 = var1;
   }

   public String getBrfInfo6() {
      return this.brfInfo6;
   }

   public void setBrfInfo6(String var1) {
      this.brfInfo6 = var1;
   }

   public String getBrfInfo7() {
      return this.brfInfo7;
   }

   public void setBrfInfo7(String var1) {
      this.brfInfo7 = var1;
   }

   public String getBrfInfo8() {
      return this.brfInfo8;
   }

   public void setBrfInfo8(String var1) {
      this.brfInfo8 = var1;
   }

   public String getBrfInfo9() {
      return this.brfInfo9;
   }

   public void setBrfInfo9(String var1) {
      this.brfInfo9 = var1;
   }

   public String getBrfInfoLivraison() {
      return this.brfInfoLivraison;
   }

   public void setBrfInfoLivraison(String var1) {
      this.brfInfoLivraison = var1;
   }

   public String getBrfLieuLivraison() {
      return this.brfLieuLivraison;
   }

   public void setBrfLieuLivraison(String var1) {
      this.brfLieuLivraison = var1;
   }

   public String getBrfModeReg() {
      return this.brfModeReg;
   }

   public void setBrfModeReg(String var1) {
      this.brfModeReg = var1;
   }

   public String getBrfModeleImp() {
      return this.brfModeleImp;
   }

   public void setBrfModeleImp(String var1) {
      this.brfModeleImp = var1;
   }

   public String getBrfMotifAnnule() {
      return this.brfMotifAnnule;
   }

   public void setBrfMotifAnnule(String var1) {
      this.brfMotifAnnule = var1;
   }

   public int getBrfNbJourReg() {
      return this.brfNbJourReg;
   }

   public void setBrfNbJourReg(int var1) {
      this.brfNbJourReg = var1;
   }

   public String getBrfNomContact() {
      return this.brfNomContact;
   }

   public void setBrfNomContact(String var1) {
      this.brfNomContact = var1;
   }

   public String getBrfNomCreateur() {
      return this.brfNomCreateur;
   }

   public void setBrfNomCreateur(String var1) {
      this.brfNomCreateur = var1;
   }

   public String getBrfNomModif() {
      return this.brfNomModif;
   }

   public void setBrfNomModif(String var1) {
      this.brfNomModif = var1;
   }

   public String getBrfNomResponsable() {
      return this.brfNomResponsable;
   }

   public void setBrfNomResponsable(String var1) {
      this.brfNomResponsable = var1;
   }

   public String getBrfNomTiers() {
      return this.brfNomTiers;
   }

   public void setBrfNomTiers(String var1) {
      this.brfNomTiers = var1;
   }

   public String getBrfNum() {
      return this.brfNum;
   }

   public void setBrfNum(String var1) {
      this.brfNum = var1;
   }

   public String getBrfObject() {
      return this.brfObject;
   }

   public void setBrfObject(String var1) {
      this.brfObject = var1;
   }

   public String getBrfObservation() {
      return this.brfObservation;
   }

   public void setBrfObservation(String var1) {
      this.brfObservation = var1;
   }

   public String getBrfPdv() {
      return this.brfPdv;
   }

   public void setBrfPdv(String var1) {
      this.brfPdv = var1;
   }

   public String getBrfRegion() {
      return this.brfRegion;
   }

   public void setBrfRegion(String var1) {
      this.brfRegion = var1;
   }

   public String getBrfSecteur() {
      return this.brfSecteur;
   }

   public void setBrfSecteur(String var1) {
      this.brfSecteur = var1;
   }

   public String getBrfSerie() {
      return this.brfSerie;
   }

   public void setBrfSerie(String var1) {
      this.brfSerie = var1;
   }

   public String getBrfService() {
      return this.brfService;
   }

   public void setBrfService(String var1) {
      this.brfService = var1;
   }

   public String getBrfSite() {
      return this.brfSite;
   }

   public void setBrfSite(String var1) {
      this.brfSite = var1;
   }

   public int getBrfSolde() {
      return this.brfSolde;
   }

   public void setBrfSolde(int var1) {
      this.brfSolde = var1;
   }

   public double getBrfTotBonEncais() {
      return this.brfTotBonEncais;
   }

   public void setBrfTotBonEncais(double var1) {
      this.brfTotBonEncais = var1;
   }

   public double getBrfTotHt() {
      return this.brfTotHt;
   }

   public void setBrfTotHt(double var1) {
      this.brfTotHt = var1;
   }

   public double getBrfTotRabais() {
      return this.brfTotRabais;
   }

   public void setBrfTotRabais(double var1) {
      this.brfTotRabais = var1;
   }

   public double getBrfTotReglement() {
      return this.brfTotReglement;
   }

   public void setBrfTotReglement(double var1) {
      this.brfTotReglement = var1;
   }

   public double getBrfTotRemise() {
      return this.brfTotRemise;
   }

   public void setBrfTotRemise(double var1) {
      this.brfTotRemise = var1;
   }

   public double getBrfTotTc() {
      return this.brfTotTc;
   }

   public void setBrfTotTc(double var1) {
      this.brfTotTc = var1;
   }

   public double getBrfTotTtc() {
      return this.brfTotTtc;
   }

   public void setBrfTotTtc(double var1) {
      this.brfTotTtc = var1;
   }

   public double getBrfTotTva() {
      return this.brfTotTva;
   }

   public void setBrfTotTva(double var1) {
      this.brfTotTva = var1;
   }

   public int getBrfTypeReg() {
      return this.brfTypeReg;
   }

   public void setBrfTypeReg(int var1) {
      this.brfTypeReg = var1;
   }

   public String getLibelleEta() {
      if (this.brfEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.brfEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.brfEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.brfEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.brfEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.brfEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
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

   public int getBrfExoDouane() {
      return this.brfExoDouane;
   }

   public void setBrfExoDouane(int var1) {
      this.brfExoDouane = var1;
   }

   public int getBrfExoTva() {
      return this.brfExoTva;
   }

   public void setBrfExoTva(int var1) {
      this.brfExoTva = var1;
   }

   public String getBrfJournalReg() {
      return this.brfJournalReg;
   }

   public void setBrfJournalReg(String var1) {
      this.brfJournalReg = var1;
   }

   public String getBrfCivilContact() {
      return this.brfCivilContact;
   }

   public void setBrfCivilContact(String var1) {
      this.brfCivilContact = var1;
   }

   public String getBrfCivilTiers() {
      return this.brfCivilTiers;
   }

   public void setBrfCivilTiers(String var1) {
      this.brfCivilTiers = var1;
   }

   public int getBrfFactorEtat() {
      return this.brfFactorEtat;
   }

   public void setBrfFactorEtat(int var1) {
      this.brfFactorEtat = var1;
   }

   public long getBrfFactorId() {
      return this.brfFactorId;
   }

   public void setBrfFactorId(long var1) {
      this.brfFactorId = var1;
   }

   public String getBrfFactorNom() {
      return this.brfFactorNom;
   }

   public void setBrfFactorNom(String var1) {
      this.brfFactorNom = var1;
   }

   public long getBrfIdResponsable() {
      return this.brfIdResponsable;
   }

   public void setBrfIdResponsable(long var1) {
      this.brfIdResponsable = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public String getVar_solde() {
      if (this.brfSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public String getBrfConditionReg() {
      return this.brfConditionReg;
   }

   public void setBrfConditionReg(String var1) {
      this.brfConditionReg = var1;
   }

   public int getVar_format_devise() {
      if (!this.brfDevise.equals("XOF") && !this.brfDevise.equals("XAF")) {
         if (!this.brfDevise.equals("EUR") && !this.brfDevise.equals("XEU") && !this.brfDevise.equals("CHF")) {
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

   public double getBrfBudgetDispoMois() {
      return this.brfBudgetDispoMois;
   }

   public void setBrfBudgetDispoMois(double var1) {
      this.brfBudgetDispoMois = var1;
   }

   public double getBrfBudgetTresoMois() {
      return this.brfBudgetTresoMois;
   }

   public void setBrfBudgetTresoMois(double var1) {
      this.brfBudgetTresoMois = var1;
   }

   public int getBrfTypeTransforme() {
      return this.brfTypeTransforme;
   }

   public void setBrfTypeTransforme(int var1) {
      this.brfTypeTransforme = var1;
   }

   public String getBrfLivreurNom() {
      return this.brfLivreurNom;
   }

   public void setBrfLivreurNom(String var1) {
      this.brfLivreurNom = var1;
   }

   public String getBrfProduction() {
      return this.brfProduction;
   }

   public void setBrfProduction(String var1) {
      this.brfProduction = var1;
   }

   public String getBrfCommentaire() {
      return this.brfCommentaire;
   }

   public void setBrfCommentaire(String var1) {
      this.brfCommentaire = var1;
   }

   public String getBrfValo() {
      return this.brfValo;
   }

   public void setBrfValo(String var1) {
      this.brfValo = var1;
   }

   public long getBrfIdContact() {
      return this.brfIdContact;
   }

   public void setBrfIdContact(long var1) {
      this.brfIdContact = var1;
   }

   public String getBrfDiversAdresse() {
      return this.brfDiversAdresse;
   }

   public void setBrfDiversAdresse(String var1) {
      this.brfDiversAdresse = var1;
   }

   public String getBrfDiversMail() {
      return this.brfDiversMail;
   }

   public void setBrfDiversMail(String var1) {
      this.brfDiversMail = var1;
   }

   public String getBrfDiversNom() {
      return this.brfDiversNom;
   }

   public void setBrfDiversNom(String var1) {
      this.brfDiversNom = var1;
   }

   public String getBrfDiversTel() {
      return this.brfDiversTel;
   }

   public void setBrfDiversTel(String var1) {
      this.brfDiversTel = var1;
   }

   public int getBrfDiversTiers() {
      return this.brfDiversTiers;
   }

   public void setBrfDiversTiers(int var1) {
      this.brfDiversTiers = var1;
   }

   public String getBrfDiversVille() {
      return this.brfDiversVille;
   }

   public void setBrfDiversVille(String var1) {
      this.brfDiversVille = var1;
   }

   public int getBrfPosSignature() {
      return this.brfPosSignature;
   }

   public void setBrfPosSignature(int var1) {
      this.brfPosSignature = var1;
   }

   public String getBrfNumAvoir() {
      return this.brfNumAvoir;
   }

   public void setBrfNumAvoir(String var1) {
      this.brfNumAvoir = var1;
   }

   public String getBrfAffaire() {
      return this.brfAffaire;
   }

   public void setBrfAffaire(String var1) {
      this.brfAffaire = var1;
   }

   public String getBrfSource() {
      return this.brfSource;
   }

   public void setBrfSource(String var1) {
      this.brfSource = var1;
   }

   public String getBrfAnal1() {
      return this.brfAnal1;
   }

   public void setBrfAnal1(String var1) {
      this.brfAnal1 = var1;
   }
}
