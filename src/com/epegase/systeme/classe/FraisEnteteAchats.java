package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FraisEnteteAchats implements Serializable {
   private long fsfId;
   private Date fsfDateCreat;
   private Date fsfDateModif;
   private long fsfIdCreateur;
   private String fsfNomCreateur;
   private long fsfIdModif;
   private String fsfNomModif;
   private Date fsfDate;
   private String fsfNum;
   private String fsfValo;
   private int fsfTypeValo;
   private String fsfNomResponsable;
   private long fsfIdResponsable;
   private String fsfNomTiers;
   private String fsfCivilTiers;
   private long fsfIdContact;
   private String fsfNomContact;
   private String fsfCivilContact;
   private String fsfSerie;
   private int fsfExoTva;
   private int fsfExoDouane;
   private String fsfJournalReg;
   private String fsfCat;
   private String fsfDevise;
   private float fsfCoefDevise;
   private String fsfObject;
   private Date fsfDateFacture;
   private String fsfObservation;
   private String fsfBudget;
   private double fsfBudgetDispo;
   private double fsfBudgetTreso;
   private double fsfBudgetDispoMois;
   private double fsfBudgetTresoMois;
   private double fsfTotHt;
   private double fsfTotRemise;
   private double fsfTotRabais;
   private double totRabaisRemise;
   private double fsfTotTva;
   private double fsfTotTvaDouane;
   private double fsfTotTc;
   private double fsfTotTtc;
   private double fsfTotReglement;
   private double fsfTotTimbre;
   private int fsfSolde;
   private String fsfBanque;
   private int fsfTypeReg;
   private String fsfModeReg;
   private int fsfNbJourReg;
   private int fsfArrondiReg;
   private String fsfConditionReg;
   private Date fsfDateEcheReg;
   private Date fsfDateLastReg;
   private String fsfActivite;
   private String fsfSite;
   private String fsfDepartement;
   private String fsfService;
   private String fsfRegion;
   private String fsfSecteur;
   private String fsfPdv;
   private String fsfAnal2;
   private String fsfAnal4;
   private String fsfAffaire;
   private String fsfInfo1;
   private String fsfInfo2;
   private String fsfInfo3;
   private String fsfInfo4;
   private String fsfInfo5;
   private String fsfInfo6;
   private String fsfInfo7;
   private String fsfInfo8;
   private String fsfInfo9;
   private String fsfInfo10;
   private String fsfFormule1;
   private String fsfFormule2;
   private String fsfAnnexe1;
   private String fsfAnnexe2;
   private String fsfContrat;
   private String fsfNumFour;
   private String fsfNumDoc;
   private Date fsfDateImp;
   private String fsfModeleImp;
   private int fsfEtatVal;
   private int fsfGele;
   private int fsfEtat;
   private String fsfNumTrf;
   private Date fsfDateValidite;
   private Date fsfDateRelance;
   private Date fsfDateValide;
   private int fsfPosSignature;
   private Date fsfDateTransforme;
   private int fsfTypeTransforme;
   private Date fsfDateAnnule;
   private String fsfMotifAnnule;
   private String fsfFactorNom;
   private long fsfFactorId;
   private int fsfFactorEtat;
   private Date fsfDateTransfert;
   private int fsfDiversTiers;
   private String fsfDiversNom;
   private String fsfDiversAdresse;
   private String fsfDiversVille;
   private String fsfDiversTel;
   private String fsfDiversMail;
   private String fsfSource;
   private ExercicesAchats exercicesAchats;
   private Tiers tiers;
   private Users users;
   private String libelleTypeValo;
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

   public double getMontantReglementManuel() {
      return this.montantReglementManuel;
   }

   public void setMontantReglementManuel(double var1) {
      this.montantReglementManuel = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.fsfTotTtc + this.fsfTotTc;
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

   public String getVar_nom_tiers() {
      if (this.fsfDiversNom != null && !this.fsfDiversNom.isEmpty()) {
         this.var_nom_tiers = this.fsfDiversNom;
      } else if (this.fsfCivilTiers != null && !this.fsfCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.fsfCivilTiers + " " + this.fsfNomTiers;
      } else {
         this.var_nom_tiers = this.fsfNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.fsfDiversNom != null && !this.fsfDiversNom.isEmpty()) {
         this.var_nomContact = "(fournisseur divers)";
      } else if (this.fsfCivilContact != null && !this.fsfCivilContact.isEmpty()) {
         if (this.fsfNomContact != null && !this.fsfNomContact.isEmpty()) {
            this.var_nomContact = this.fsfCivilContact + " " + this.fsfNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.fsfNomContact != null && !this.fsfNomContact.isEmpty()) {
         this.var_nomContact = this.fsfNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.fsfEtat == 0) {
         this.libelleEta = "En cours";
      } else if (this.fsfEtat == 1) {
         this.libelleEta = "Validée";
      } else if (this.fsfEtat == 2) {
         this.libelleEta = "Gelée";
      } else if (this.fsfEtat == 3) {
         this.libelleEta = "Annulée";
      } else if (this.fsfEtat == 6) {
         this.libelleEta = "Compta.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getLibelleTypeValo() {
      if (this.fsfTypeValo == 0) {
         this.libelleTypeValo = "";
      } else if (this.fsfTypeValo == 1) {
         this.libelleTypeValo = "Utilisé / achat";
      } else if (this.fsfTypeValo == 2) {
         this.libelleTypeValo = "Utilise / réexpédition";
      }

      return this.libelleTypeValo;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.fsfTotTtc - this.fsfTotReglement;
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
      if (this.fsfSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public void setLibelleTypeValo(String var1) {
      this.libelleTypeValo = var1;
   }

   public int getVar_format_devise() {
      if (this.fsfDevise != null && !this.fsfDevise.isEmpty()) {
         if (!this.fsfDevise.equals("XOF") && !this.fsfDevise.equals("XAF")) {
            if (!this.fsfDevise.equals("EUR") && !this.fsfDevise.equals("XEU") && !this.fsfDevise.equals("CHF")) {
               this.var_format_devise = 0;
            } else {
               this.var_format_devise = 1;
            }
         } else {
            this.var_format_devise = 2;
         }
      } else {
         this.var_format_devise = 0;
      }

      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public String getFsfActivite() {
      return this.fsfActivite;
   }

   public void setFsfActivite(String var1) {
      this.fsfActivite = var1;
   }

   public String getFsfAnal2() {
      return this.fsfAnal2;
   }

   public void setFsfAnal2(String var1) {
      this.fsfAnal2 = var1;
   }

   public String getFsfAnal4() {
      return this.fsfAnal4;
   }

   public void setFsfAnal4(String var1) {
      this.fsfAnal4 = var1;
   }

   public String getFsfAnnexe1() {
      return this.fsfAnnexe1;
   }

   public void setFsfAnnexe1(String var1) {
      this.fsfAnnexe1 = var1;
   }

   public String getFsfAnnexe2() {
      return this.fsfAnnexe2;
   }

   public void setFsfAnnexe2(String var1) {
      this.fsfAnnexe2 = var1;
   }

   public int getFsfArrondiReg() {
      return this.fsfArrondiReg;
   }

   public void setFsfArrondiReg(int var1) {
      this.fsfArrondiReg = var1;
   }

   public String getFsfBanque() {
      return this.fsfBanque;
   }

   public void setFsfBanque(String var1) {
      this.fsfBanque = var1;
   }

   public String getFsfBudget() {
      return this.fsfBudget;
   }

   public void setFsfBudget(String var1) {
      this.fsfBudget = var1;
   }

   public double getFsfBudgetDispo() {
      return this.fsfBudgetDispo;
   }

   public void setFsfBudgetDispo(double var1) {
      this.fsfBudgetDispo = var1;
   }

   public double getFsfBudgetTreso() {
      return this.fsfBudgetTreso;
   }

   public void setFsfBudgetTreso(double var1) {
      this.fsfBudgetTreso = var1;
   }

   public String getFsfCat() {
      return this.fsfCat;
   }

   public void setFsfCat(String var1) {
      this.fsfCat = var1;
   }

   public String getFsfCivilContact() {
      return this.fsfCivilContact;
   }

   public void setFsfCivilContact(String var1) {
      this.fsfCivilContact = var1;
   }

   public String getFsfCivilTiers() {
      return this.fsfCivilTiers;
   }

   public void setFsfCivilTiers(String var1) {
      this.fsfCivilTiers = var1;
   }

   public String getFsfConditionReg() {
      return this.fsfConditionReg;
   }

   public void setFsfConditionReg(String var1) {
      this.fsfConditionReg = var1;
   }

   public String getFsfContrat() {
      return this.fsfContrat;
   }

   public void setFsfContrat(String var1) {
      this.fsfContrat = var1;
   }

   public Date getFsfDate() {
      return this.fsfDate;
   }

   public void setFsfDate(Date var1) {
      this.fsfDate = var1;
   }

   public Date getFsfDateAnnule() {
      return this.fsfDateAnnule;
   }

   public void setFsfDateAnnule(Date var1) {
      this.fsfDateAnnule = var1;
   }

   public Date getFsfDateCreat() {
      return this.fsfDateCreat;
   }

   public void setFsfDateCreat(Date var1) {
      this.fsfDateCreat = var1;
   }

   public Date getFsfDateEcheReg() {
      return this.fsfDateEcheReg;
   }

   public void setFsfDateEcheReg(Date var1) {
      this.fsfDateEcheReg = var1;
   }

   public Date getFsfDateImp() {
      return this.fsfDateImp;
   }

   public void setFsfDateImp(Date var1) {
      this.fsfDateImp = var1;
   }

   public Date getFsfDateModif() {
      return this.fsfDateModif;
   }

   public void setFsfDateModif(Date var1) {
      this.fsfDateModif = var1;
   }

   public Date getFsfDateRelance() {
      return this.fsfDateRelance;
   }

   public void setFsfDateRelance(Date var1) {
      this.fsfDateRelance = var1;
   }

   public Date getFsfDateTransforme() {
      return this.fsfDateTransforme;
   }

   public void setFsfDateTransforme(Date var1) {
      this.fsfDateTransforme = var1;
   }

   public Date getFsfDateValide() {
      return this.fsfDateValide;
   }

   public void setFsfDateValide(Date var1) {
      this.fsfDateValide = var1;
   }

   public Date getFsfDateValidite() {
      return this.fsfDateValidite;
   }

   public void setFsfDateValidite(Date var1) {
      this.fsfDateValidite = var1;
   }

   public String getFsfDepartement() {
      return this.fsfDepartement;
   }

   public void setFsfDepartement(String var1) {
      this.fsfDepartement = var1;
   }

   public String getFsfDevise() {
      return this.fsfDevise;
   }

   public void setFsfDevise(String var1) {
      this.fsfDevise = var1;
   }

   public int getFsfEtat() {
      return this.fsfEtat;
   }

   public void setFsfEtat(int var1) {
      this.fsfEtat = var1;
   }

   public int getFsfEtatVal() {
      return this.fsfEtatVal;
   }

   public void setFsfEtatVal(int var1) {
      this.fsfEtatVal = var1;
   }

   public int getFsfExoDouane() {
      return this.fsfExoDouane;
   }

   public void setFsfExoDouane(int var1) {
      this.fsfExoDouane = var1;
   }

   public int getFsfExoTva() {
      return this.fsfExoTva;
   }

   public void setFsfExoTva(int var1) {
      this.fsfExoTva = var1;
   }

   public int getFsfFactorEtat() {
      return this.fsfFactorEtat;
   }

   public void setFsfFactorEtat(int var1) {
      this.fsfFactorEtat = var1;
   }

   public long getFsfFactorId() {
      return this.fsfFactorId;
   }

   public void setFsfFactorId(long var1) {
      this.fsfFactorId = var1;
   }

   public String getFsfFactorNom() {
      return this.fsfFactorNom;
   }

   public void setFsfFactorNom(String var1) {
      this.fsfFactorNom = var1;
   }

   public String getFsfFormule1() {
      return this.fsfFormule1;
   }

   public void setFsfFormule1(String var1) {
      this.fsfFormule1 = var1;
   }

   public String getFsfFormule2() {
      return this.fsfFormule2;
   }

   public void setFsfFormule2(String var1) {
      this.fsfFormule2 = var1;
   }

   public int getFsfGele() {
      return this.fsfGele;
   }

   public void setFsfGele(int var1) {
      this.fsfGele = var1;
   }

   public long getFsfId() {
      return this.fsfId;
   }

   public void setFsfId(long var1) {
      this.fsfId = var1;
   }

   public long getFsfIdCreateur() {
      return this.fsfIdCreateur;
   }

   public void setFsfIdCreateur(long var1) {
      this.fsfIdCreateur = var1;
   }

   public long getFsfIdModif() {
      return this.fsfIdModif;
   }

   public void setFsfIdModif(long var1) {
      this.fsfIdModif = var1;
   }

   public long getFsfIdResponsable() {
      return this.fsfIdResponsable;
   }

   public void setFsfIdResponsable(long var1) {
      this.fsfIdResponsable = var1;
   }

   public String getFsfInfo1() {
      return this.fsfInfo1;
   }

   public void setFsfInfo1(String var1) {
      this.fsfInfo1 = var1;
   }

   public String getFsfInfo10() {
      return this.fsfInfo10;
   }

   public void setFsfInfo10(String var1) {
      this.fsfInfo10 = var1;
   }

   public String getFsfInfo2() {
      return this.fsfInfo2;
   }

   public void setFsfInfo2(String var1) {
      this.fsfInfo2 = var1;
   }

   public String getFsfInfo3() {
      return this.fsfInfo3;
   }

   public void setFsfInfo3(String var1) {
      this.fsfInfo3 = var1;
   }

   public String getFsfInfo4() {
      return this.fsfInfo4;
   }

   public void setFsfInfo4(String var1) {
      this.fsfInfo4 = var1;
   }

   public String getFsfInfo5() {
      return this.fsfInfo5;
   }

   public void setFsfInfo5(String var1) {
      this.fsfInfo5 = var1;
   }

   public String getFsfInfo6() {
      return this.fsfInfo6;
   }

   public void setFsfInfo6(String var1) {
      this.fsfInfo6 = var1;
   }

   public String getFsfInfo7() {
      return this.fsfInfo7;
   }

   public void setFsfInfo7(String var1) {
      this.fsfInfo7 = var1;
   }

   public String getFsfInfo8() {
      return this.fsfInfo8;
   }

   public void setFsfInfo8(String var1) {
      this.fsfInfo8 = var1;
   }

   public String getFsfInfo9() {
      return this.fsfInfo9;
   }

   public void setFsfInfo9(String var1) {
      this.fsfInfo9 = var1;
   }

   public String getFsfJournalReg() {
      return this.fsfJournalReg;
   }

   public void setFsfJournalReg(String var1) {
      this.fsfJournalReg = var1;
   }

   public String getFsfModeReg() {
      return this.fsfModeReg;
   }

   public void setFsfModeReg(String var1) {
      this.fsfModeReg = var1;
   }

   public String getFsfModeleImp() {
      return this.fsfModeleImp;
   }

   public void setFsfModeleImp(String var1) {
      this.fsfModeleImp = var1;
   }

   public String getFsfMotifAnnule() {
      return this.fsfMotifAnnule;
   }

   public void setFsfMotifAnnule(String var1) {
      this.fsfMotifAnnule = var1;
   }

   public int getFsfNbJourReg() {
      return this.fsfNbJourReg;
   }

   public void setFsfNbJourReg(int var1) {
      this.fsfNbJourReg = var1;
   }

   public String getFsfNomContact() {
      return this.fsfNomContact;
   }

   public void setFsfNomContact(String var1) {
      this.fsfNomContact = var1;
   }

   public String getFsfNomCreateur() {
      return this.fsfNomCreateur;
   }

   public void setFsfNomCreateur(String var1) {
      this.fsfNomCreateur = var1;
   }

   public String getFsfNomModif() {
      return this.fsfNomModif;
   }

   public void setFsfNomModif(String var1) {
      this.fsfNomModif = var1;
   }

   public String getFsfNomResponsable() {
      return this.fsfNomResponsable;
   }

   public void setFsfNomResponsable(String var1) {
      this.fsfNomResponsable = var1;
   }

   public String getFsfNomTiers() {
      return this.fsfNomTiers;
   }

   public void setFsfNomTiers(String var1) {
      this.fsfNomTiers = var1;
   }

   public String getFsfNum() {
      return this.fsfNum;
   }

   public void setFsfNum(String var1) {
      this.fsfNum = var1;
   }

   public String getFsfNumFour() {
      return this.fsfNumFour;
   }

   public void setFsfNumFour(String var1) {
      this.fsfNumFour = var1;
   }

   public String getFsfObject() {
      return this.fsfObject;
   }

   public void setFsfObject(String var1) {
      this.fsfObject = var1;
   }

   public String getFsfObservation() {
      return this.fsfObservation;
   }

   public void setFsfObservation(String var1) {
      this.fsfObservation = var1;
   }

   public String getFsfPdv() {
      return this.fsfPdv;
   }

   public void setFsfPdv(String var1) {
      this.fsfPdv = var1;
   }

   public String getFsfRegion() {
      return this.fsfRegion;
   }

   public void setFsfRegion(String var1) {
      this.fsfRegion = var1;
   }

   public String getFsfSecteur() {
      return this.fsfSecteur;
   }

   public void setFsfSecteur(String var1) {
      this.fsfSecteur = var1;
   }

   public String getFsfSerie() {
      return this.fsfSerie;
   }

   public void setFsfSerie(String var1) {
      this.fsfSerie = var1;
   }

   public String getFsfService() {
      return this.fsfService;
   }

   public void setFsfService(String var1) {
      this.fsfService = var1;
   }

   public String getFsfSite() {
      return this.fsfSite;
   }

   public void setFsfSite(String var1) {
      this.fsfSite = var1;
   }

   public int getFsfSolde() {
      return this.fsfSolde;
   }

   public void setFsfSolde(int var1) {
      this.fsfSolde = var1;
   }

   public double getFsfTotHt() {
      return this.fsfTotHt;
   }

   public void setFsfTotHt(double var1) {
      this.fsfTotHt = var1;
   }

   public double getFsfTotRabais() {
      return this.fsfTotRabais;
   }

   public void setFsfTotRabais(double var1) {
      this.fsfTotRabais = var1;
   }

   public double getFsfTotReglement() {
      return this.fsfTotReglement;
   }

   public void setFsfTotReglement(double var1) {
      this.fsfTotReglement = var1;
   }

   public double getFsfTotRemise() {
      return this.fsfTotRemise;
   }

   public void setFsfTotRemise(double var1) {
      this.fsfTotRemise = var1;
   }

   public double getFsfTotTc() {
      return this.fsfTotTc;
   }

   public void setFsfTotTc(double var1) {
      this.fsfTotTc = var1;
   }

   public double getFsfTotTtc() {
      return this.fsfTotTtc;
   }

   public void setFsfTotTtc(double var1) {
      this.fsfTotTtc = var1;
   }

   public double getFsfTotTva() {
      return this.fsfTotTva;
   }

   public void setFsfTotTva(double var1) {
      this.fsfTotTva = var1;
   }

   public int getFsfTypeReg() {
      return this.fsfTypeReg;
   }

   public void setFsfTypeReg(int var1) {
      this.fsfTypeReg = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public double getTotRabaisRemise() {
      return this.totRabaisRemise;
   }

   public void setTotRabaisRemise(double var1) {
      this.totRabaisRemise = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public int getFsfTypeTransforme() {
      return this.fsfTypeTransforme;
   }

   public void setFsfTypeTransforme(int var1) {
      this.fsfTypeTransforme = var1;
   }

   public double getFsfBudgetDispoMois() {
      return this.fsfBudgetDispoMois;
   }

   public void setFsfBudgetDispoMois(double var1) {
      this.fsfBudgetDispoMois = var1;
   }

   public double getFsfBudgetTresoMois() {
      return this.fsfBudgetTresoMois;
   }

   public void setFsfBudgetTresoMois(double var1) {
      this.fsfBudgetTresoMois = var1;
   }

   public String getFsfValo() {
      return this.fsfValo;
   }

   public void setFsfValo(String var1) {
      this.fsfValo = var1;
   }

   public int getFsfTypeValo() {
      return this.fsfTypeValo;
   }

   public void setFsfTypeValo(int var1) {
      this.fsfTypeValo = var1;
   }

   public long getFsfIdContact() {
      return this.fsfIdContact;
   }

   public void setFsfIdContact(long var1) {
      this.fsfIdContact = var1;
   }

   public Date getFsfDateTransfert() {
      return this.fsfDateTransfert;
   }

   public void setFsfDateTransfert(Date var1) {
      this.fsfDateTransfert = var1;
   }

   public float getFsfCoefDevise() {
      return this.fsfCoefDevise;
   }

   public void setFsfCoefDevise(float var1) {
      this.fsfCoefDevise = var1;
   }

   public String getFsfDiversAdresse() {
      return this.fsfDiversAdresse;
   }

   public void setFsfDiversAdresse(String var1) {
      this.fsfDiversAdresse = var1;
   }

   public String getFsfDiversMail() {
      return this.fsfDiversMail;
   }

   public void setFsfDiversMail(String var1) {
      this.fsfDiversMail = var1;
   }

   public String getFsfDiversNom() {
      return this.fsfDiversNom;
   }

   public void setFsfDiversNom(String var1) {
      this.fsfDiversNom = var1;
   }

   public String getFsfDiversTel() {
      return this.fsfDiversTel;
   }

   public void setFsfDiversTel(String var1) {
      this.fsfDiversTel = var1;
   }

   public int getFsfDiversTiers() {
      return this.fsfDiversTiers;
   }

   public void setFsfDiversTiers(int var1) {
      this.fsfDiversTiers = var1;
   }

   public String getFsfDiversVille() {
      return this.fsfDiversVille;
   }

   public void setFsfDiversVille(String var1) {
      this.fsfDiversVille = var1;
   }

   public String getFsfNumDoc() {
      return this.fsfNumDoc;
   }

   public void setFsfNumDoc(String var1) {
      this.fsfNumDoc = var1;
   }

   public String getFsfNumTrf() {
      return this.fsfNumTrf;
   }

   public void setFsfNumTrf(String var1) {
      this.fsfNumTrf = var1;
   }

   public double getFsfTotTvaDouane() {
      return this.fsfTotTvaDouane;
   }

   public void setFsfTotTvaDouane(double var1) {
      this.fsfTotTvaDouane = var1;
   }

   public double getFsfTotTimbre() {
      return this.fsfTotTimbre;
   }

   public void setFsfTotTimbre(double var1) {
      this.fsfTotTimbre = var1;
   }

   public Date getFsfDateLastReg() {
      return this.fsfDateLastReg;
   }

   public void setFsfDateLastReg(Date var1) {
      this.fsfDateLastReg = var1;
   }

   public int getFsfPosSignature() {
      return this.fsfPosSignature;
   }

   public void setFsfPosSignature(int var1) {
      this.fsfPosSignature = var1;
   }

   public Date getFsfDateFacture() {
      return this.fsfDateFacture;
   }

   public void setFsfDateFacture(Date var1) {
      this.fsfDateFacture = var1;
   }

   public String getFsfAffaire() {
      return this.fsfAffaire;
   }

   public void setFsfAffaire(String var1) {
      this.fsfAffaire = var1;
   }

   public String getFsfSource() {
      return this.fsfSource;
   }

   public void setFsfSource(String var1) {
      this.fsfSource = var1;
   }
}
