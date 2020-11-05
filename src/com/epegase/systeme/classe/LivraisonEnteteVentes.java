package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class LivraisonEnteteVentes implements Serializable {
   private long blvId;
   private Date blvDateCreat;
   private long blvIdCreateur;
   private String blvNomCreateur;
   private Date blvDateModif;
   private long blvIdModif;
   private String blvNomModif;
   private int blvMaj;
   private Date blvDate;
   private String blvNum;
   private String blvNomEquipe;
   private long blvIdEquipe;
   private String blvNomResponsable;
   private long blvIdResponsable;
   private String blvNomCommercial;
   private long blvIdCommercial;
   private String blvNomTiers;
   private String blvCivilTiers;
   private String blvTiersRegroupe;
   private long blvIdContact;
   private String blvNomContact;
   private String blvCivilContact;
   private String blvSerie;
   private int blvExoTva;
   private int blvExoDouane;
   private String blvJournalReg;
   private String blvCat;
   private String blvDevise;
   private boolean blvPj;
   private String blvObject;
   private String blvObservation;
   private String blvBudget;
   private float blvTauxRemise;
   private double blvTotHt;
   private double blvTotRemise;
   private double blvTotRabais;
   private double blvTotTva;
   private float blvTauxTc;
   private double blvTotTc;
   private double blvTotTtc;
   private double blvTotReglement;
   private double blvTotTimbre;
   private int blvSolde;
   private String blvBanque;
   private int blvTypeReg;
   private String blvModeReg;
   private Date blvEcheanceReliquat;
   private String blvMotifRejetCredit;
   private int blvNbJourReg;
   private int blvArrondiReg;
   private String blvConditionReg;
   private Date blvDateEcheReg;
   private Date blvDateLastReg;
   private String blvContener;
   private String blvActivite;
   private String blvSite;
   private String blvDepartement;
   private String blvService;
   private String blvRegion;
   private String blvSecteur;
   private String blvPdv;
   private String blvAnal2;
   private String blvAnal4;
   private String blvAffaire;
   private String blvInfo1;
   private String blvInfo2;
   private String blvInfo3;
   private String blvInfo4;
   private String blvInfo5;
   private String blvInfo6;
   private String blvInfo7;
   private String blvInfo8;
   private String blvInfo9;
   private String blvInfo10;
   private String blvFormule1;
   private String blvFormule2;
   private String blvAnnexe1;
   private String blvAnnexe2;
   private String blvContrat;
   private String blvIncoterm;
   private String blvLieuLivraison;
   private Date blvDateLivraison;
   private String blvInfoLivraison;
   private Date blvDateImp;
   private String blvModeleImp;
   private String blvGarde;
   private int blvEtatVal;
   private int blvGele;
   private int blvEtat;
   private int blvLivreeEtat;
   private int blvLivreur;
   private Date blvDateValidite;
   private Date blvDateRelance;
   private Date blvDateValide;
   private int blvPosSignature;
   private Date blvDateTransforme;
   private int blvTypeTransforme;
   private Date blvDateAnnule;
   private String blvMotifAnnule;
   private Date blvDateTransfert;
   private String blvNumTrf;
   private Date blvDateFacture;
   private String blvFactorNom;
   private long blvFactorId;
   private int blvFactorEtat;
   private int blvDiversTiers;
   private String blvDiversNom;
   private String blvDiversAdresse;
   private String blvDiversVille;
   private String blvDiversTel;
   private String blvDiversMail;
   private String blvMemoNumFacture;
   private String blvNumFacture;
   private String blvSource;
   private int blvStock;
   private boolean blvRistourneBloquee;
   private String blvNumClient;
   private Date blvDateClient;
   private float blvPoids;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private String libelleLivreeEta;
   private String var_solde;
   private boolean var_select_ligne;
   private int var_format_devise;
   private double varTotTtcGlob;
   private String var_nomContact;
   private String var_nom_tiers;
   private String var_numBc;
   private double var_reliquat;
   private double var_reliquatListe;
   private double var_blv_timbre;
   private double montantReglementManuel;
   private String pj;

   public String getPj() {
      if (!this.blvPj) {
         this.pj = null;
      } else if (this.blvPj) {
         this.pj = "/images/mail_pj.png";
      }

      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
   }

   public String getVar_nom_tiers() {
      if (this.blvDiversNom != null && !this.blvDiversNom.isEmpty()) {
         this.var_nom_tiers = this.blvDiversNom;
      } else if (this.blvCivilTiers != null && !this.blvCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.blvCivilTiers + " " + this.blvNomTiers;
      } else {
         this.var_nom_tiers = this.blvNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.blvTotTtc + this.blvTotTc + this.var_blv_timbre - this.blvTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public double getVar_reliquatListe() {
      this.var_reliquatListe = this.blvTotTtc + this.blvTotTc + this.blvTotTimbre - this.blvTotReglement;
      return this.var_reliquatListe;
   }

   public void setVar_reliquatListe(double var1) {
      this.var_reliquatListe = var1;
   }

   public String getVar_nomContact() {
      if (this.blvDiversNom != null && !this.blvDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.blvCivilContact != null && !this.blvCivilContact.isEmpty()) {
         if (this.blvNomContact != null && !this.blvNomContact.isEmpty()) {
            this.var_nomContact = this.blvCivilContact + " " + this.blvNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.blvNomContact != null && !this.blvNomContact.isEmpty()) {
         this.var_nomContact = this.blvNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.blvTotTtc + this.blvTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getLibelleLivreeEta() {
      if (this.blvLivreeEtat == 0) {
         this.libelleLivreeEta = "N.L.";
      } else if (this.blvLivreeEtat == 1) {
         this.libelleLivreeEta = "Liv.P.";
      } else if (this.blvLivreeEtat == 2) {
         this.libelleLivreeEta = "Liv.T.";
      }

      return this.libelleLivreeEta;
   }

   public void setLibelleLivreeEta(String var1) {
      this.libelleLivreeEta = var1;
   }

   public String getLibelleEta() {
      if (this.blvEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.blvEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.blvEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.blvEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.blvEtat == 4) {
         this.libelleEta = "Fac.P.";
      } else if (this.blvEtat == 5) {
         this.libelleEta = "Fac.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public int getVar_format_devise() {
      if (!this.blvDevise.equals("XOF") && !this.blvDevise.equals("XAF")) {
         if (!this.blvDevise.equals("EUR") && !this.blvDevise.equals("XEU") && !this.blvDevise.equals("CHF")) {
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

   public String getBlvActivite() {
      return this.blvActivite;
   }

   public void setBlvActivite(String var1) {
      this.blvActivite = var1;
   }

   public String getBlvAnal2() {
      return this.blvAnal2;
   }

   public void setBlvAnal2(String var1) {
      this.blvAnal2 = var1;
   }

   public String getBlvAnal4() {
      return this.blvAnal4;
   }

   public void setBlvAnal4(String var1) {
      this.blvAnal4 = var1;
   }

   public String getBlvAnnexe1() {
      return this.blvAnnexe1;
   }

   public void setBlvAnnexe1(String var1) {
      this.blvAnnexe1 = var1;
   }

   public String getBlvAnnexe2() {
      return this.blvAnnexe2;
   }

   public void setBlvAnnexe2(String var1) {
      this.blvAnnexe2 = var1;
   }

   public int getBlvArrondiReg() {
      return this.blvArrondiReg;
   }

   public void setBlvArrondiReg(int var1) {
      this.blvArrondiReg = var1;
   }

   public String getBlvBanque() {
      return this.blvBanque;
   }

   public void setBlvBanque(String var1) {
      this.blvBanque = var1;
   }

   public String getBlvBudget() {
      return this.blvBudget;
   }

   public void setBlvBudget(String var1) {
      this.blvBudget = var1;
   }

   public String getBlvCat() {
      return this.blvCat;
   }

   public void setBlvCat(String var1) {
      this.blvCat = var1;
   }

   public String getBlvConditionReg() {
      return this.blvConditionReg;
   }

   public void setBlvConditionReg(String var1) {
      this.blvConditionReg = var1;
   }

   public String getBlvContrat() {
      return this.blvContrat;
   }

   public void setBlvContrat(String var1) {
      this.blvContrat = var1;
   }

   public Date getBlvDate() {
      return this.blvDate;
   }

   public void setBlvDate(Date var1) {
      this.blvDate = var1;
   }

   public Date getBlvDateAnnule() {
      return this.blvDateAnnule;
   }

   public void setBlvDateAnnule(Date var1) {
      this.blvDateAnnule = var1;
   }

   public Date getBlvDateCreat() {
      return this.blvDateCreat;
   }

   public void setBlvDateCreat(Date var1) {
      this.blvDateCreat = var1;
   }

   public Date getBlvDateEcheReg() {
      return this.blvDateEcheReg;
   }

   public void setBlvDateEcheReg(Date var1) {
      this.blvDateEcheReg = var1;
   }

   public Date getBlvDateImp() {
      return this.blvDateImp;
   }

   public void setBlvDateImp(Date var1) {
      this.blvDateImp = var1;
   }

   public Date getBlvDateLivraison() {
      return this.blvDateLivraison;
   }

   public void setBlvDateLivraison(Date var1) {
      this.blvDateLivraison = var1;
   }

   public Date getBlvDateModif() {
      return this.blvDateModif;
   }

   public void setBlvDateModif(Date var1) {
      this.blvDateModif = var1;
   }

   public Date getBlvDateRelance() {
      return this.blvDateRelance;
   }

   public void setBlvDateRelance(Date var1) {
      this.blvDateRelance = var1;
   }

   public Date getBlvDateTransforme() {
      return this.blvDateTransforme;
   }

   public void setBlvDateTransforme(Date var1) {
      this.blvDateTransforme = var1;
   }

   public Date getBlvDateValide() {
      return this.blvDateValide;
   }

   public void setBlvDateValide(Date var1) {
      this.blvDateValide = var1;
   }

   public Date getBlvDateValidite() {
      return this.blvDateValidite;
   }

   public void setBlvDateValidite(Date var1) {
      this.blvDateValidite = var1;
   }

   public String getBlvDepartement() {
      return this.blvDepartement;
   }

   public void setBlvDepartement(String var1) {
      this.blvDepartement = var1;
   }

   public String getBlvDevise() {
      return this.blvDevise;
   }

   public void setBlvDevise(String var1) {
      this.blvDevise = var1;
   }

   public int getBlvEtat() {
      return this.blvEtat;
   }

   public void setBlvEtat(int var1) {
      this.blvEtat = var1;
   }

   public int getBlvEtatVal() {
      return this.blvEtatVal;
   }

   public void setBlvEtatVal(int var1) {
      this.blvEtatVal = var1;
   }

   public String getBlvFormule1() {
      return this.blvFormule1;
   }

   public void setBlvFormule1(String var1) {
      this.blvFormule1 = var1;
   }

   public String getBlvFormule2() {
      return this.blvFormule2;
   }

   public void setBlvFormule2(String var1) {
      this.blvFormule2 = var1;
   }

   public String getBlvGarde() {
      return this.blvGarde;
   }

   public void setBlvGarde(String var1) {
      this.blvGarde = var1;
   }

   public int getBlvGele() {
      return this.blvGele;
   }

   public void setBlvGele(int var1) {
      this.blvGele = var1;
   }

   public long getBlvId() {
      return this.blvId;
   }

   public void setBlvId(long var1) {
      this.blvId = var1;
   }

   public long getBlvIdCreateur() {
      return this.blvIdCreateur;
   }

   public void setBlvIdCreateur(long var1) {
      this.blvIdCreateur = var1;
   }

   public long getBlvIdModif() {
      return this.blvIdModif;
   }

   public void setBlvIdModif(long var1) {
      this.blvIdModif = var1;
   }

   public String getBlvIncoterm() {
      return this.blvIncoterm;
   }

   public void setBlvIncoterm(String var1) {
      this.blvIncoterm = var1;
   }

   public String getBlvInfo1() {
      return this.blvInfo1;
   }

   public void setBlvInfo1(String var1) {
      this.blvInfo1 = var1;
   }

   public String getBlvInfo10() {
      return this.blvInfo10;
   }

   public void setBlvInfo10(String var1) {
      this.blvInfo10 = var1;
   }

   public String getBlvInfo2() {
      return this.blvInfo2;
   }

   public void setBlvInfo2(String var1) {
      this.blvInfo2 = var1;
   }

   public String getBlvInfo3() {
      return this.blvInfo3;
   }

   public void setBlvInfo3(String var1) {
      this.blvInfo3 = var1;
   }

   public String getBlvInfo4() {
      return this.blvInfo4;
   }

   public void setBlvInfo4(String var1) {
      this.blvInfo4 = var1;
   }

   public String getBlvInfo5() {
      return this.blvInfo5;
   }

   public void setBlvInfo5(String var1) {
      this.blvInfo5 = var1;
   }

   public String getBlvInfo6() {
      return this.blvInfo6;
   }

   public void setBlvInfo6(String var1) {
      this.blvInfo6 = var1;
   }

   public String getBlvInfo7() {
      return this.blvInfo7;
   }

   public void setBlvInfo7(String var1) {
      this.blvInfo7 = var1;
   }

   public String getBlvInfo8() {
      return this.blvInfo8;
   }

   public void setBlvInfo8(String var1) {
      this.blvInfo8 = var1;
   }

   public String getBlvInfo9() {
      return this.blvInfo9;
   }

   public void setBlvInfo9(String var1) {
      this.blvInfo9 = var1;
   }

   public String getBlvInfoLivraison() {
      return this.blvInfoLivraison;
   }

   public void setBlvInfoLivraison(String var1) {
      this.blvInfoLivraison = var1;
   }

   public String getBlvLieuLivraison() {
      return this.blvLieuLivraison;
   }

   public void setBlvLieuLivraison(String var1) {
      this.blvLieuLivraison = var1;
   }

   public String getBlvModeReg() {
      return this.blvModeReg;
   }

   public void setBlvModeReg(String var1) {
      this.blvModeReg = var1;
   }

   public String getBlvModeleImp() {
      return this.blvModeleImp;
   }

   public void setBlvModeleImp(String var1) {
      this.blvModeleImp = var1;
   }

   public String getBlvMotifAnnule() {
      return this.blvMotifAnnule;
   }

   public void setBlvMotifAnnule(String var1) {
      this.blvMotifAnnule = var1;
   }

   public int getBlvNbJourReg() {
      return this.blvNbJourReg;
   }

   public void setBlvNbJourReg(int var1) {
      this.blvNbJourReg = var1;
   }

   public String getBlvNomContact() {
      if (this.blvNomContact != null && !this.blvNomContact.isEmpty()) {
         this.blvNomContact = this.blvNomContact.toUpperCase();
      }

      return this.blvNomContact;
   }

   public void setBlvNomContact(String var1) {
      this.blvNomContact = var1;
   }

   public String getBlvNomCreateur() {
      return this.blvNomCreateur;
   }

   public void setBlvNomCreateur(String var1) {
      this.blvNomCreateur = var1;
   }

   public String getBlvNomModif() {
      return this.blvNomModif;
   }

   public void setBlvNomModif(String var1) {
      this.blvNomModif = var1;
   }

   public String getBlvNomResponsable() {
      return this.blvNomResponsable;
   }

   public void setBlvNomResponsable(String var1) {
      this.blvNomResponsable = var1;
   }

   public String getBlvNomTiers() {
      return this.blvNomTiers;
   }

   public void setBlvNomTiers(String var1) {
      this.blvNomTiers = var1;
   }

   public String getBlvNum() {
      return this.blvNum;
   }

   public void setBlvNum(String var1) {
      this.blvNum = var1;
   }

   public String getBlvObject() {
      return this.blvObject;
   }

   public void setBlvObject(String var1) {
      this.blvObject = var1;
   }

   public String getBlvObservation() {
      return this.blvObservation;
   }

   public void setBlvObservation(String var1) {
      this.blvObservation = var1;
   }

   public String getBlvPdv() {
      return this.blvPdv;
   }

   public void setBlvPdv(String var1) {
      this.blvPdv = var1;
   }

   public String getBlvRegion() {
      return this.blvRegion;
   }

   public void setBlvRegion(String var1) {
      this.blvRegion = var1;
   }

   public String getBlvSecteur() {
      return this.blvSecteur;
   }

   public void setBlvSecteur(String var1) {
      this.blvSecteur = var1;
   }

   public String getBlvSerie() {
      return this.blvSerie;
   }

   public void setBlvSerie(String var1) {
      this.blvSerie = var1;
   }

   public String getBlvService() {
      return this.blvService;
   }

   public void setBlvService(String var1) {
      this.blvService = var1;
   }

   public String getBlvSite() {
      return this.blvSite;
   }

   public void setBlvSite(String var1) {
      this.blvSite = var1;
   }

   public int getBlvSolde() {
      return this.blvSolde;
   }

   public void setBlvSolde(int var1) {
      this.blvSolde = var1;
   }

   public double getBlvTotHt() {
      return this.blvTotHt;
   }

   public void setBlvTotHt(double var1) {
      this.blvTotHt = var1;
   }

   public double getBlvTotRabais() {
      return this.blvTotRabais;
   }

   public void setBlvTotRabais(double var1) {
      this.blvTotRabais = var1;
   }

   public double getBlvTotReglement() {
      return this.blvTotReglement;
   }

   public void setBlvTotReglement(double var1) {
      this.blvTotReglement = var1;
   }

   public double getBlvTotRemise() {
      return this.blvTotRemise;
   }

   public void setBlvTotRemise(double var1) {
      this.blvTotRemise = var1;
   }

   public double getBlvTotTc() {
      return this.blvTotTc;
   }

   public void setBlvTotTc(double var1) {
      this.blvTotTc = var1;
   }

   public double getBlvTotTtc() {
      return this.blvTotTtc;
   }

   public void setBlvTotTtc(double var1) {
      this.blvTotTtc = var1;
   }

   public double getBlvTotTva() {
      return this.blvTotTva;
   }

   public void setBlvTotTva(double var1) {
      this.blvTotTva = var1;
   }

   public int getBlvTypeReg() {
      return this.blvTypeReg;
   }

   public void setBlvTypeReg(int var1) {
      this.blvTypeReg = var1;
   }

   public long getBlvIdContact() {
      return this.blvIdContact;
   }

   public void setBlvIdContact(long var1) {
      this.blvIdContact = var1;
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

   public int getBlvExoDouane() {
      return this.blvExoDouane;
   }

   public void setBlvExoDouane(int var1) {
      this.blvExoDouane = var1;
   }

   public int getBlvExoTva() {
      return this.blvExoTva;
   }

   public void setBlvExoTva(int var1) {
      this.blvExoTva = var1;
   }

   public String getBlvJournalReg() {
      return this.blvJournalReg;
   }

   public void setBlvJournalReg(String var1) {
      this.blvJournalReg = var1;
   }

   public int getBlvFactorEtat() {
      return this.blvFactorEtat;
   }

   public void setBlvFactorEtat(int var1) {
      this.blvFactorEtat = var1;
   }

   public long getBlvFactorId() {
      return this.blvFactorId;
   }

   public void setBlvFactorId(long var1) {
      this.blvFactorId = var1;
   }

   public String getBlvFactorNom() {
      return this.blvFactorNom;
   }

   public void setBlvFactorNom(String var1) {
      this.blvFactorNom = var1;
   }

   public String getBlvCivilContact() {
      return this.blvCivilContact;
   }

   public void setBlvCivilContact(String var1) {
      this.blvCivilContact = var1;
   }

   public String getBlvCivilTiers() {
      return this.blvCivilTiers;
   }

   public void setBlvCivilTiers(String var1) {
      this.blvCivilTiers = var1;
   }

   public long getBlvIdResponsable() {
      return this.blvIdResponsable;
   }

   public void setBlvIdResponsable(long var1) {
      this.blvIdResponsable = var1;
   }

   public String getVar_solde() {
      if (this.blvSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public int getBlvTypeTransforme() {
      return this.blvTypeTransforme;
   }

   public void setBlvTypeTransforme(int var1) {
      this.blvTypeTransforme = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getBlvMaj() {
      return this.blvMaj;
   }

   public void setBlvMaj(int var1) {
      this.blvMaj = var1;
   }

   public Date getBlvDateFacture() {
      return this.blvDateFacture;
   }

   public void setBlvDateFacture(Date var1) {
      this.blvDateFacture = var1;
   }

   public float getBlvTauxTc() {
      return this.blvTauxTc;
   }

   public void setBlvTauxTc(float var1) {
      this.blvTauxTc = var1;
   }

   public String getBlvDiversAdresse() {
      return this.blvDiversAdresse;
   }

   public void setBlvDiversAdresse(String var1) {
      this.blvDiversAdresse = var1;
   }

   public String getBlvDiversMail() {
      return this.blvDiversMail;
   }

   public void setBlvDiversMail(String var1) {
      this.blvDiversMail = var1;
   }

   public String getBlvDiversNom() {
      if (this.blvDiversNom != null && !this.blvDiversNom.isEmpty()) {
         this.blvDiversNom = this.blvDiversNom.toUpperCase();
      }

      return this.blvDiversNom;
   }

   public void setBlvDiversNom(String var1) {
      this.blvDiversNom = var1;
   }

   public String getBlvDiversTel() {
      return this.blvDiversTel;
   }

   public void setBlvDiversTel(String var1) {
      this.blvDiversTel = var1;
   }

   public int getBlvDiversTiers() {
      return this.blvDiversTiers;
   }

   public void setBlvDiversTiers(int var1) {
      this.blvDiversTiers = var1;
   }

   public String getBlvDiversVille() {
      return this.blvDiversVille;
   }

   public void setBlvDiversVille(String var1) {
      this.blvDiversVille = var1;
   }

   public long getBlvIdCommercial() {
      return this.blvIdCommercial;
   }

   public void setBlvIdCommercial(long var1) {
      this.blvIdCommercial = var1;
   }

   public String getBlvNomCommercial() {
      return this.blvNomCommercial;
   }

   public void setBlvNomCommercial(String var1) {
      this.blvNomCommercial = var1;
   }

   public String getBlvMemoNumFacture() {
      return this.blvMemoNumFacture;
   }

   public void setBlvMemoNumFacture(String var1) {
      this.blvMemoNumFacture = var1;
   }

   public long getBlvIdEquipe() {
      return this.blvIdEquipe;
   }

   public void setBlvIdEquipe(long var1) {
      this.blvIdEquipe = var1;
   }

   public String getBlvNomEquipe() {
      return this.blvNomEquipe;
   }

   public void setBlvNomEquipe(String var1) {
      this.blvNomEquipe = var1;
   }

   public String getBlvNumFacture() {
      return this.blvNumFacture;
   }

   public void setBlvNumFacture(String var1) {
      this.blvNumFacture = var1;
   }

   public String getVar_numBc() {
      return this.var_numBc;
   }

   public void setVar_numBc(String var1) {
      this.var_numBc = var1;
   }

   public int getBlvLivreeEtat() {
      return this.blvLivreeEtat;
   }

   public void setBlvLivreeEtat(int var1) {
      this.blvLivreeEtat = var1;
   }

   public int getBlvLivreur() {
      return this.blvLivreur;
   }

   public void setBlvLivreur(int var1) {
      this.blvLivreur = var1;
   }

   public String getBlvSource() {
      return this.blvSource;
   }

   public void setBlvSource(String var1) {
      this.blvSource = var1;
   }

   public float getBlvTauxRemise() {
      return this.blvTauxRemise;
   }

   public void setBlvTauxRemise(float var1) {
      this.blvTauxRemise = var1;
   }

   public String getBlvTiersRegroupe() {
      return this.blvTiersRegroupe;
   }

   public void setBlvTiersRegroupe(String var1) {
      this.blvTiersRegroupe = var1;
   }

   public int getBlvStock() {
      return this.blvStock;
   }

   public void setBlvStock(int var1) {
      this.blvStock = var1;
   }

   public String getBlvContener() {
      return this.blvContener;
   }

   public void setBlvContener(String var1) {
      this.blvContener = var1;
   }

   public int getBlvPosSignature() {
      return this.blvPosSignature;
   }

   public void setBlvPosSignature(int var1) {
      this.blvPosSignature = var1;
   }

   public boolean isBlvRistourneBloquee() {
      return this.blvRistourneBloquee;
   }

   public void setBlvRistourneBloquee(boolean var1) {
      this.blvRistourneBloquee = var1;
   }

   public double getMontantReglementManuel() {
      return this.montantReglementManuel;
   }

   public void setMontantReglementManuel(double var1) {
      this.montantReglementManuel = var1;
   }

   public double getVar_blv_timbre() {
      return this.var_blv_timbre;
   }

   public void setVar_blv_timbre(double var1) {
      this.var_blv_timbre = var1;
   }

   public Date getBlvDateLastReg() {
      return this.blvDateLastReg;
   }

   public void setBlvDateLastReg(Date var1) {
      this.blvDateLastReg = var1;
   }

   public double getBlvTotTimbre() {
      return this.blvTotTimbre;
   }

   public void setBlvTotTimbre(double var1) {
      this.blvTotTimbre = var1;
   }

   public Date getBlvEcheanceReliquat() {
      return this.blvEcheanceReliquat;
   }

   public void setBlvEcheanceReliquat(Date var1) {
      this.blvEcheanceReliquat = var1;
   }

   public String getBlvMotifRejetCredit() {
      return this.blvMotifRejetCredit;
   }

   public void setBlvMotifRejetCredit(String var1) {
      this.blvMotifRejetCredit = var1;
   }

   public Date getBlvDateClient() {
      return this.blvDateClient;
   }

   public void setBlvDateClient(Date var1) {
      this.blvDateClient = var1;
   }

   public String getBlvNumClient() {
      return this.blvNumClient;
   }

   public void setBlvNumClient(String var1) {
      this.blvNumClient = var1;
   }

   public Date getBlvDateTransfert() {
      return this.blvDateTransfert;
   }

   public void setBlvDateTransfert(Date var1) {
      this.blvDateTransfert = var1;
   }

   public String getBlvNumTrf() {
      return this.blvNumTrf;
   }

   public void setBlvNumTrf(String var1) {
      this.blvNumTrf = var1;
   }

   public boolean isBlvPj() {
      return this.blvPj;
   }

   public void setBlvPj(boolean var1) {
      this.blvPj = var1;
   }

   public String getBlvAffaire() {
      return this.blvAffaire;
   }

   public void setBlvAffaire(String var1) {
      this.blvAffaire = var1;
   }

   public float getBlvPoids() {
      return this.blvPoids;
   }

   public void setBlvPoids(float var1) {
      this.blvPoids = var1;
   }
}
