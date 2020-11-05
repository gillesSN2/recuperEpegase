package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CommandeEnteteVentes implements Serializable {
   private long bcmId;
   private Date bcmDateCreat;
   private long bcmIdCreateur;
   private String bcmNomCreateur;
   private Date bcmDateModif;
   private long bcmIdModif;
   private String bcmNomModif;
   private Date bcmDate;
   private String bcmNum;
   private String bcmNomEquipe;
   private long bcmIdEquipe;
   private String bcmNomResponsable;
   private long bcmIdResponsable;
   private String bcmNomCommercial;
   private long bcmIdCommercial;
   private String bcmNomTiers;
   private String bcmCivilTiers;
   private String bcmTiersRegroupe;
   private long bcmIdContact;
   private String bcmNomContact;
   private String bcmCivilContact;
   private String bcmSerie;
   private int bcmExoTva;
   private int bcmExoDouane;
   private String bcmJournalReg;
   private int bcmSuivi;
   private String bcmCat;
   private String bcmDevise;
   private String bcmObject;
   private String bcmObservation;
   private String bcmBudget;
   private float bcmTauxRemise;
   private double bcmTotHt;
   private double bcmTotRemise;
   private double bcmTotRabais;
   private double bcmTotTva;
   private float bcmTauxTc;
   private double bcmTotTc;
   private double bcmTotTtc;
   private double bcmTotReglement;
   private double bcmTotLivre;
   private double bcmTotTimbre;
   private int bcmSolde;
   private String bcmBanque;
   private int bcmTypeReg;
   private String bcmModeReg;
   private Date bcmEcheanceReliquat;
   private String bcmMotifRejetCredit;
   private int bcmNbJourReg;
   private int bcmArrondiReg;
   private String bcmConditionReg;
   private Date bcmDateEcheReg;
   private Date bcmDateLastReg;
   private String bcmContener;
   private String bcmActivite;
   private String bcmSite;
   private String bcmDepartement;
   private String bcmService;
   private String bcmRegion;
   private String bcmSecteur;
   private String bcmPdv;
   private String bcmAnal2;
   private String bcmAnal4;
   private String bcmAffaire;
   private String bcmInfo1;
   private String bcmInfo2;
   private String bcmInfo3;
   private String bcmInfo4;
   private String bcmInfo5;
   private String bcmInfo6;
   private String bcmInfo7;
   private String bcmInfo8;
   private String bcmInfo9;
   private String bcmInfo10;
   private String bcmFormule1;
   private String bcmFormule2;
   private String bcmAnnexe1;
   private String bcmAnnexe2;
   private String bcmContrat;
   private String bcmIncoterm;
   private String bcmLieuLivraison;
   private Date bcmDateLivraison;
   private int bcmCompteurReport;
   private String bcmInfoLivraison;
   private int bcmModeLivraison;
   private int bcmHoraireLivraison;
   private String bcmHeureLivraison;
   private String bcmContactLivraison;
   private String bcmTelephoneLivraison;
   private int bcmEtatLivraison;
   private String bcmObservationLivraison;
   private Date bcmDateImp;
   private String bcmModeleImp;
   private String bcmGarde;
   private int bcmEtatVal;
   private int bcmGele;
   private int bcmEtat;
   private Date bcmDateValidite;
   private Date bcmDateRelance;
   private Date bcmDateValide;
   private int bcmPosSignature;
   private Date bcmDateTransforme;
   private int bcmTypeTransforme;
   private Date bcmDateAnnule;
   private String bcmMotifAnnule;
   private int bcmNiveau;
   private String bcmPreparateur;
   private String bcmConseil;
   private Date bcmDateTransfert;
   private String bcmNumTrf;
   private String bcmFactorNom;
   private long bcmFactorId;
   private int bcmFactorEtat;
   private int bcmPhase;
   private int bcmDiversTiers;
   private String bcmDiversNom;
   private String bcmDiversAdresse;
   private String bcmDiversVille;
   private String bcmDiversTel;
   private String bcmDiversMail;
   private String bcmSource;
   private int bcmStock;
   private boolean bcmPj;
   private boolean bcmRistourneBloquee;
   private String bcmNumClient;
   private Date bcmDateClient;
   private float bcmPoids;
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
   private String var_contactLivraison;
   private String var_nom_tiers;
   private String heure;
   private String minute;
   private String periode;
   private int annee;
   private String libelleMode;
   private double var_fac_timbre;
   private double montantReglementManuel;
   private String pj;
   private String color;
   private String texteAffiche;
   private String bcVip;

   public String getBcVip() {
      if (this.bcmSuivi == 1) {
         this.bcVip = "color:blue";
      } else {
         this.bcVip = "color:black";
      }

      return this.bcVip;
   }

   public void setBcVip(String var1) {
      this.bcVip = var1;
   }

   public String getPj() {
      if (!this.bcmPj) {
         this.pj = null;
      } else if (this.bcmPj) {
         this.pj = "/images/mail_pj.png";
      }

      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
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

   public int getAnnee() {
      if (this.bcmDate != null) {
         this.annee = this.bcmDate.getYear() + 1900;
      }

      return this.annee;
   }

   public void setAnnee(int var1) {
      this.annee = var1;
   }

   public String getColor() {
      if (this.bcmModeLivraison == 0) {
         this.color = "color:#000000;";
      } else if (this.bcmModeLivraison == 1) {
         this.color = "color:#0000FF;";
      } else if (this.bcmModeLivraison == 2) {
         this.color = "color:#B404AE;";
      } else if (this.bcmModeLivraison == 3) {
         this.color = "color:#610B0B;";
      }

      return this.color;
   }

   public void setColor(String var1) {
      this.color = var1;
   }

   public String getTexteAffiche() {
      return this.texteAffiche;
   }

   public void setTexteAffiche(String var1) {
      this.texteAffiche = var1;
   }

   public String getLibelleMode() {
      if (this.bcmModeLivraison == 0) {
         this.libelleMode = "N.S.";
      } else if (this.bcmModeLivraison == 1) {
         this.libelleMode = "LIV";
      } else if (this.bcmModeLivraison == 2) {
         this.libelleMode = "LIV+POS";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getPeriode() {
      if (this.bcmHoraireLivraison == 0) {
         this.periode = "ns";
      } else if (this.bcmHoraireLivraison == 1) {
         this.periode = "AM";
      } else if (this.bcmHoraireLivraison == 2) {
         this.periode = "PM";
      } else if (this.bcmHoraireLivraison == 3) {
         this.periode = this.bcmHeureLivraison + ":00";
      }

      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }

   public String getHeure() {
      return this.heure;
   }

   public void setHeure(String var1) {
      this.heure = var1;
   }

   public String getMinute() {
      return this.minute;
   }

   public void setMinute(String var1) {
      this.minute = var1;
   }

   public String getVar_nom_tiers() {
      if (this.bcmDiversNom != null && !this.bcmDiversNom.isEmpty()) {
         this.var_nom_tiers = this.bcmDiversNom;
      } else if (this.bcmCivilTiers != null && !this.bcmCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.bcmCivilTiers + " " + this.bcmNomTiers;
      } else {
         this.var_nom_tiers = this.bcmNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_contactLivraison() {
      if (this.bcmContactLivraison != null && !this.bcmContactLivraison.isEmpty()) {
         this.var_contactLivraison = this.bcmContactLivraison;
      } else {
         this.var_contactLivraison = this.bcmNomContact;
      }

      if (this.bcmTelephoneLivraison != null && !this.bcmTelephoneLivraison.isEmpty()) {
         this.var_contactLivraison = this.var_contactLivraison + " tel: " + this.bcmTelephoneLivraison;
      } else if (this.tiers != null) {
         if (this.tiers.getTieburtel1() != null && !this.tiers.getTieburtel1().isEmpty()) {
            this.var_contactLivraison = this.var_contactLivraison + " tel: " + this.tiers.getTieburtel1();
         } else if (this.tiers.getTieburtel2() != null && !this.tiers.getTieburtel2().isEmpty()) {
            this.var_contactLivraison = this.var_contactLivraison + " tel: " + this.tiers.getTieburtel2();
         } else if (this.tiers.getTieburtel3() != null && !this.tiers.getTieburtel3().isEmpty()) {
            this.var_contactLivraison = this.var_contactLivraison + " tel: " + this.tiers.getTieburtel3();
         } else if (this.tiers.getTiecel1() != null && !this.tiers.getTiecel1().isEmpty()) {
            this.var_contactLivraison = this.var_contactLivraison + " tel: " + this.tiers.getTiecel1();
         } else if (this.tiers.getTiecel2() != null && !this.tiers.getTiecel2().isEmpty()) {
            this.var_contactLivraison = this.var_contactLivraison + " tel: " + this.tiers.getTiecel2();
         } else if (this.tiers.getTiecel3() != null && !this.tiers.getTiecel3().isEmpty()) {
            this.var_contactLivraison = this.var_contactLivraison + " tel: " + this.tiers.getTiecel3();
         }
      }

      if (this.bcmLieuLivraison != null && !this.bcmLieuLivraison.isEmpty()) {
         this.var_contactLivraison = this.var_contactLivraison + " lieu: " + this.bcmLieuLivraison;
      }

      return this.var_contactLivraison;
   }

   public void setVar_contactLivraison(String var1) {
      this.var_contactLivraison = var1;
   }

   public String getVar_nomContact() {
      if (this.bcmDiversNom != null && !this.bcmDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.bcmCivilContact != null && !this.bcmCivilContact.isEmpty()) {
         if (this.bcmNomContact != null && !this.bcmNomContact.isEmpty()) {
            this.var_nomContact = this.bcmCivilContact + " " + this.bcmNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.bcmNomContact != null && !this.bcmNomContact.isEmpty()) {
         this.var_nomContact = this.bcmNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.bcmTotTtc + this.bcmTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getVar_solde() {
      if (this.bcmSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public String getLibelleEta() {
      if (this.bcmEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.bcmEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.bcmEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.bcmEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.bcmEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.bcmEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public int getVar_format_devise() {
      if (!this.bcmDevise.equals("XOF") && !this.bcmDevise.equals("XAF")) {
         if (!this.bcmDevise.equals("EUR") && !this.bcmDevise.equals("XEU") && !this.bcmDevise.equals("CHF")) {
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

   public double getVar_reliquatListe() {
      this.var_reliquatListe = this.bcmTotTtc + this.bcmTotTc + this.bcmTotTimbre - this.bcmTotReglement;
      return this.var_reliquatListe;
   }

   public void setVar_reliquatListe(double var1) {
      this.var_reliquatListe = var1;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.bcmTotTtc + this.bcmTotTc + this.var_fac_timbre - this.bcmTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public String getBcmActivite() {
      return this.bcmActivite;
   }

   public void setBcmActivite(String var1) {
      this.bcmActivite = var1;
   }

   public String getBcmAnal2() {
      return this.bcmAnal2;
   }

   public void setBcmAnal2(String var1) {
      this.bcmAnal2 = var1;
   }

   public String getBcmAnal4() {
      return this.bcmAnal4;
   }

   public void setBcmAnal4(String var1) {
      this.bcmAnal4 = var1;
   }

   public String getBcmAnnexe1() {
      return this.bcmAnnexe1;
   }

   public void setBcmAnnexe1(String var1) {
      this.bcmAnnexe1 = var1;
   }

   public String getBcmAnnexe2() {
      return this.bcmAnnexe2;
   }

   public void setBcmAnnexe2(String var1) {
      this.bcmAnnexe2 = var1;
   }

   public int getBcmArrondiReg() {
      return this.bcmArrondiReg;
   }

   public void setBcmArrondiReg(int var1) {
      this.bcmArrondiReg = var1;
   }

   public String getBcmBanque() {
      return this.bcmBanque;
   }

   public void setBcmBanque(String var1) {
      this.bcmBanque = var1;
   }

   public String getBcmBudget() {
      return this.bcmBudget;
   }

   public void setBcmBudget(String var1) {
      this.bcmBudget = var1;
   }

   public String getBcmCat() {
      return this.bcmCat;
   }

   public void setBcmCat(String var1) {
      this.bcmCat = var1;
   }

   public String getBcmConditionReg() {
      return this.bcmConditionReg;
   }

   public void setBcmConditionReg(String var1) {
      this.bcmConditionReg = var1;
   }

   public String getBcmContrat() {
      return this.bcmContrat;
   }

   public void setBcmContrat(String var1) {
      this.bcmContrat = var1;
   }

   public Date getBcmDate() {
      return this.bcmDate;
   }

   public void setBcmDate(Date var1) {
      this.bcmDate = var1;
   }

   public Date getBcmDateAnnule() {
      return this.bcmDateAnnule;
   }

   public void setBcmDateAnnule(Date var1) {
      this.bcmDateAnnule = var1;
   }

   public Date getBcmDateCreat() {
      return this.bcmDateCreat;
   }

   public void setBcmDateCreat(Date var1) {
      this.bcmDateCreat = var1;
   }

   public Date getBcmDateEcheReg() {
      return this.bcmDateEcheReg;
   }

   public void setBcmDateEcheReg(Date var1) {
      this.bcmDateEcheReg = var1;
   }

   public Date getBcmDateImp() {
      return this.bcmDateImp;
   }

   public void setBcmDateImp(Date var1) {
      this.bcmDateImp = var1;
   }

   public Date getBcmDateLivraison() {
      return this.bcmDateLivraison;
   }

   public void setBcmDateLivraison(Date var1) {
      this.bcmDateLivraison = var1;
   }

   public Date getBcmDateModif() {
      return this.bcmDateModif;
   }

   public void setBcmDateModif(Date var1) {
      this.bcmDateModif = var1;
   }

   public Date getBcmDateRelance() {
      return this.bcmDateRelance;
   }

   public void setBcmDateRelance(Date var1) {
      this.bcmDateRelance = var1;
   }

   public Date getBcmDateTransforme() {
      return this.bcmDateTransforme;
   }

   public void setBcmDateTransforme(Date var1) {
      this.bcmDateTransforme = var1;
   }

   public Date getBcmDateValide() {
      return this.bcmDateValide;
   }

   public void setBcmDateValide(Date var1) {
      this.bcmDateValide = var1;
   }

   public Date getBcmDateValidite() {
      return this.bcmDateValidite;
   }

   public void setBcmDateValidite(Date var1) {
      this.bcmDateValidite = var1;
   }

   public String getBcmDepartement() {
      return this.bcmDepartement;
   }

   public void setBcmDepartement(String var1) {
      this.bcmDepartement = var1;
   }

   public String getBcmDevise() {
      return this.bcmDevise;
   }

   public void setBcmDevise(String var1) {
      this.bcmDevise = var1;
   }

   public int getBcmEtat() {
      return this.bcmEtat;
   }

   public void setBcmEtat(int var1) {
      this.bcmEtat = var1;
   }

   public int getBcmEtatVal() {
      return this.bcmEtatVal;
   }

   public void setBcmEtatVal(int var1) {
      this.bcmEtatVal = var1;
   }

   public String getBcmFormule1() {
      return this.bcmFormule1;
   }

   public void setBcmFormule1(String var1) {
      this.bcmFormule1 = var1;
   }

   public String getBcmFormule2() {
      return this.bcmFormule2;
   }

   public void setBcmFormule2(String var1) {
      this.bcmFormule2 = var1;
   }

   public String getBcmGarde() {
      return this.bcmGarde;
   }

   public void setBcmGarde(String var1) {
      this.bcmGarde = var1;
   }

   public int getBcmGele() {
      return this.bcmGele;
   }

   public void setBcmGele(int var1) {
      this.bcmGele = var1;
   }

   public long getBcmId() {
      return this.bcmId;
   }

   public void setBcmId(long var1) {
      this.bcmId = var1;
   }

   public long getBcmIdCreateur() {
      return this.bcmIdCreateur;
   }

   public void setBcmIdCreateur(long var1) {
      this.bcmIdCreateur = var1;
   }

   public long getBcmIdModif() {
      return this.bcmIdModif;
   }

   public void setBcmIdModif(long var1) {
      this.bcmIdModif = var1;
   }

   public String getBcmIncoterm() {
      return this.bcmIncoterm;
   }

   public void setBcmIncoterm(String var1) {
      this.bcmIncoterm = var1;
   }

   public String getBcmInfo1() {
      return this.bcmInfo1;
   }

   public void setBcmInfo1(String var1) {
      this.bcmInfo1 = var1;
   }

   public String getBcmInfo10() {
      return this.bcmInfo10;
   }

   public void setBcmInfo10(String var1) {
      this.bcmInfo10 = var1;
   }

   public String getBcmInfo2() {
      return this.bcmInfo2;
   }

   public void setBcmInfo2(String var1) {
      this.bcmInfo2 = var1;
   }

   public String getBcmInfo3() {
      return this.bcmInfo3;
   }

   public void setBcmInfo3(String var1) {
      this.bcmInfo3 = var1;
   }

   public String getBcmInfo4() {
      return this.bcmInfo4;
   }

   public void setBcmInfo4(String var1) {
      this.bcmInfo4 = var1;
   }

   public String getBcmInfo5() {
      return this.bcmInfo5;
   }

   public void setBcmInfo5(String var1) {
      this.bcmInfo5 = var1;
   }

   public String getBcmInfo6() {
      return this.bcmInfo6;
   }

   public void setBcmInfo6(String var1) {
      this.bcmInfo6 = var1;
   }

   public String getBcmInfo7() {
      return this.bcmInfo7;
   }

   public void setBcmInfo7(String var1) {
      this.bcmInfo7 = var1;
   }

   public String getBcmInfo8() {
      return this.bcmInfo8;
   }

   public void setBcmInfo8(String var1) {
      this.bcmInfo8 = var1;
   }

   public String getBcmInfo9() {
      return this.bcmInfo9;
   }

   public void setBcmInfo9(String var1) {
      this.bcmInfo9 = var1;
   }

   public String getBcmInfoLivraison() {
      return this.bcmInfoLivraison;
   }

   public void setBcmInfoLivraison(String var1) {
      this.bcmInfoLivraison = var1;
   }

   public String getBcmLieuLivraison() {
      return this.bcmLieuLivraison;
   }

   public void setBcmLieuLivraison(String var1) {
      this.bcmLieuLivraison = var1;
   }

   public String getBcmModeReg() {
      return this.bcmModeReg;
   }

   public void setBcmModeReg(String var1) {
      this.bcmModeReg = var1;
   }

   public String getBcmModeleImp() {
      return this.bcmModeleImp;
   }

   public void setBcmModeleImp(String var1) {
      this.bcmModeleImp = var1;
   }

   public String getBcmMotifAnnule() {
      return this.bcmMotifAnnule;
   }

   public void setBcmMotifAnnule(String var1) {
      this.bcmMotifAnnule = var1;
   }

   public int getBcmNbJourReg() {
      return this.bcmNbJourReg;
   }

   public void setBcmNbJourReg(int var1) {
      this.bcmNbJourReg = var1;
   }

   public String getBcmNomContact() {
      if (this.bcmNomContact != null && !this.bcmNomContact.isEmpty()) {
         this.bcmNomContact = this.bcmNomContact.toUpperCase();
      }

      return this.bcmNomContact;
   }

   public void setBcmNomContact(String var1) {
      this.bcmNomContact = var1;
   }

   public String getBcmNomCreateur() {
      return this.bcmNomCreateur;
   }

   public void setBcmNomCreateur(String var1) {
      this.bcmNomCreateur = var1;
   }

   public String getBcmNomModif() {
      return this.bcmNomModif;
   }

   public void setBcmNomModif(String var1) {
      this.bcmNomModif = var1;
   }

   public String getBcmNomResponsable() {
      return this.bcmNomResponsable;
   }

   public void setBcmNomResponsable(String var1) {
      this.bcmNomResponsable = var1;
   }

   public String getBcmNomTiers() {
      return this.bcmNomTiers;
   }

   public void setBcmNomTiers(String var1) {
      this.bcmNomTiers = var1;
   }

   public String getBcmNum() {
      return this.bcmNum;
   }

   public void setBcmNum(String var1) {
      this.bcmNum = var1;
   }

   public String getBcmObject() {
      return this.bcmObject;
   }

   public void setBcmObject(String var1) {
      this.bcmObject = var1;
   }

   public String getBcmObservation() {
      return this.bcmObservation;
   }

   public void setBcmObservation(String var1) {
      this.bcmObservation = var1;
   }

   public String getBcmPdv() {
      return this.bcmPdv;
   }

   public void setBcmPdv(String var1) {
      this.bcmPdv = var1;
   }

   public String getBcmRegion() {
      return this.bcmRegion;
   }

   public void setBcmRegion(String var1) {
      this.bcmRegion = var1;
   }

   public String getBcmSecteur() {
      return this.bcmSecteur;
   }

   public void setBcmSecteur(String var1) {
      this.bcmSecteur = var1;
   }

   public String getBcmSerie() {
      return this.bcmSerie;
   }

   public void setBcmSerie(String var1) {
      this.bcmSerie = var1;
   }

   public String getBcmService() {
      return this.bcmService;
   }

   public void setBcmService(String var1) {
      this.bcmService = var1;
   }

   public String getBcmSite() {
      return this.bcmSite;
   }

   public void setBcmSite(String var1) {
      this.bcmSite = var1;
   }

   public int getBcmSolde() {
      return this.bcmSolde;
   }

   public void setBcmSolde(int var1) {
      this.bcmSolde = var1;
   }

   public double getBcmTotHt() {
      return this.bcmTotHt;
   }

   public void setBcmTotHt(double var1) {
      this.bcmTotHt = var1;
   }

   public double getBcmTotRabais() {
      return this.bcmTotRabais;
   }

   public void setBcmTotRabais(double var1) {
      this.bcmTotRabais = var1;
   }

   public double getBcmTotReglement() {
      return this.bcmTotReglement;
   }

   public void setBcmTotReglement(double var1) {
      this.bcmTotReglement = var1;
   }

   public double getBcmTotRemise() {
      return this.bcmTotRemise;
   }

   public void setBcmTotRemise(double var1) {
      this.bcmTotRemise = var1;
   }

   public double getBcmTotTc() {
      return this.bcmTotTc;
   }

   public void setBcmTotTc(double var1) {
      this.bcmTotTc = var1;
   }

   public double getBcmTotTtc() {
      return this.bcmTotTtc;
   }

   public void setBcmTotTtc(double var1) {
      this.bcmTotTtc = var1;
   }

   public double getBcmTotTva() {
      return this.bcmTotTva;
   }

   public void setBcmTotTva(double var1) {
      this.bcmTotTva = var1;
   }

   public int getBcmTypeReg() {
      return this.bcmTypeReg;
   }

   public void setBcmTypeReg(int var1) {
      this.bcmTypeReg = var1;
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

   public int getBcmNiveau() {
      return this.bcmNiveau;
   }

   public void setBcmNiveau(int var1) {
      this.bcmNiveau = var1;
   }

   public String getBcmPreparateur() {
      return this.bcmPreparateur;
   }

   public void setBcmPreparateur(String var1) {
      this.bcmPreparateur = var1;
   }

   public int getBcmExoDouane() {
      return this.bcmExoDouane;
   }

   public void setBcmExoDouane(int var1) {
      this.bcmExoDouane = var1;
   }

   public int getBcmExoTva() {
      return this.bcmExoTva;
   }

   public void setBcmExoTva(int var1) {
      this.bcmExoTva = var1;
   }

   public String getBcmJournalReg() {
      return this.bcmJournalReg;
   }

   public void setBcmJournalReg(String var1) {
      this.bcmJournalReg = var1;
   }

   public int getBcmFactorEtat() {
      return this.bcmFactorEtat;
   }

   public void setBcmFactorEtat(int var1) {
      this.bcmFactorEtat = var1;
   }

   public long getBcmFactorId() {
      return this.bcmFactorId;
   }

   public void setBcmFactorId(long var1) {
      this.bcmFactorId = var1;
   }

   public String getBcmFactorNom() {
      return this.bcmFactorNom;
   }

   public void setBcmFactorNom(String var1) {
      this.bcmFactorNom = var1;
   }

   public long getBcmIdResponsable() {
      return this.bcmIdResponsable;
   }

   public void setBcmIdResponsable(long var1) {
      this.bcmIdResponsable = var1;
   }

   public String getBcmCivilContact() {
      return this.bcmCivilContact;
   }

   public void setBcmCivilContact(String var1) {
      this.bcmCivilContact = var1;
   }

   public String getBcmCivilTiers() {
      return this.bcmCivilTiers;
   }

   public void setBcmCivilTiers(String var1) {
      this.bcmCivilTiers = var1;
   }

   public String getBcmConseil() {
      return this.bcmConseil;
   }

   public void setBcmConseil(String var1) {
      this.bcmConseil = var1;
   }

   public int getBcmPhase() {
      return this.bcmPhase;
   }

   public void setBcmPhase(int var1) {
      this.bcmPhase = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getBcmTypeTransforme() {
      return this.bcmTypeTransforme;
   }

   public void setBcmTypeTransforme(int var1) {
      this.bcmTypeTransforme = var1;
   }

   public long getBcmIdContact() {
      return this.bcmIdContact;
   }

   public void setBcmIdContact(long var1) {
      this.bcmIdContact = var1;
   }

   public Date getBcmEcheanceReliquat() {
      return this.bcmEcheanceReliquat;
   }

   public void setBcmEcheanceReliquat(Date var1) {
      this.bcmEcheanceReliquat = var1;
   }

   public String getBcmMotifRejetCredit() {
      return this.bcmMotifRejetCredit;
   }

   public void setBcmMotifRejetCredit(String var1) {
      this.bcmMotifRejetCredit = var1;
   }

   public float getBcmTauxTc() {
      return this.bcmTauxTc;
   }

   public void setBcmTauxTc(float var1) {
      this.bcmTauxTc = var1;
   }

   public String getBcmDiversAdresse() {
      return this.bcmDiversAdresse;
   }

   public void setBcmDiversAdresse(String var1) {
      this.bcmDiversAdresse = var1;
   }

   public String getBcmDiversMail() {
      return this.bcmDiversMail;
   }

   public void setBcmDiversMail(String var1) {
      this.bcmDiversMail = var1;
   }

   public String getBcmDiversNom() {
      if (this.bcmDiversNom != null && !this.bcmDiversNom.isEmpty()) {
         this.bcmDiversNom = this.bcmDiversNom.toUpperCase();
      }

      return this.bcmDiversNom;
   }

   public void setBcmDiversNom(String var1) {
      this.bcmDiversNom = var1;
   }

   public String getBcmDiversTel() {
      return this.bcmDiversTel;
   }

   public void setBcmDiversTel(String var1) {
      this.bcmDiversTel = var1;
   }

   public int getBcmDiversTiers() {
      return this.bcmDiversTiers;
   }

   public void setBcmDiversTiers(int var1) {
      this.bcmDiversTiers = var1;
   }

   public String getBcmDiversVille() {
      return this.bcmDiversVille;
   }

   public void setBcmDiversVille(String var1) {
      this.bcmDiversVille = var1;
   }

   public long getBcmIdCommercial() {
      return this.bcmIdCommercial;
   }

   public void setBcmIdCommercial(long var1) {
      this.bcmIdCommercial = var1;
   }

   public String getBcmNomCommercial() {
      return this.bcmNomCommercial;
   }

   public void setBcmNomCommercial(String var1) {
      this.bcmNomCommercial = var1;
   }

   public long getBcmIdEquipe() {
      return this.bcmIdEquipe;
   }

   public void setBcmIdEquipe(long var1) {
      this.bcmIdEquipe = var1;
   }

   public String getBcmNomEquipe() {
      return this.bcmNomEquipe;
   }

   public void setBcmNomEquipe(String var1) {
      this.bcmNomEquipe = var1;
   }

   public String getBcmSource() {
      return this.bcmSource;
   }

   public void setBcmSource(String var1) {
      this.bcmSource = var1;
   }

   public float getBcmTauxRemise() {
      return this.bcmTauxRemise;
   }

   public void setBcmTauxRemise(float var1) {
      this.bcmTauxRemise = var1;
   }

   public String getBcmTiersRegroupe() {
      return this.bcmTiersRegroupe;
   }

   public void setBcmTiersRegroupe(String var1) {
      this.bcmTiersRegroupe = var1;
   }

   public String getBcmContactLivraison() {
      return this.bcmContactLivraison;
   }

   public void setBcmContactLivraison(String var1) {
      this.bcmContactLivraison = var1;
   }

   public String getBcmHeureLivraison() {
      return this.bcmHeureLivraison;
   }

   public void setBcmHeureLivraison(String var1) {
      this.bcmHeureLivraison = var1;
   }

   public int getBcmHoraireLivraison() {
      return this.bcmHoraireLivraison;
   }

   public void setBcmHoraireLivraison(int var1) {
      this.bcmHoraireLivraison = var1;
   }

   public String getBcmTelephoneLivraison() {
      return this.bcmTelephoneLivraison;
   }

   public void setBcmTelephoneLivraison(String var1) {
      this.bcmTelephoneLivraison = var1;
   }

   public int getBcmModeLivraison() {
      return this.bcmModeLivraison;
   }

   public void setBcmModeLivraison(int var1) {
      this.bcmModeLivraison = var1;
   }

   public int getBcmStock() {
      return this.bcmStock;
   }

   public void setBcmStock(int var1) {
      this.bcmStock = var1;
   }

   public int getBcmCompteurReport() {
      return this.bcmCompteurReport;
   }

   public void setBcmCompteurReport(int var1) {
      this.bcmCompteurReport = var1;
   }

   public int getBcmEtatLivraison() {
      return this.bcmEtatLivraison;
   }

   public void setBcmEtatLivraison(int var1) {
      this.bcmEtatLivraison = var1;
   }

   public String getBcmObservationLivraison() {
      return this.bcmObservationLivraison;
   }

   public void setBcmObservationLivraison(String var1) {
      this.bcmObservationLivraison = var1;
   }

   public String getBcmContener() {
      return this.bcmContener;
   }

   public void setBcmContener(String var1) {
      this.bcmContener = var1;
   }

   public Date getBcmDateLastReg() {
      return this.bcmDateLastReg;
   }

   public void setBcmDateLastReg(Date var1) {
      this.bcmDateLastReg = var1;
   }

   public Date getBcmDateTransfert() {
      return this.bcmDateTransfert;
   }

   public void setBcmDateTransfert(Date var1) {
      this.bcmDateTransfert = var1;
   }

   public String getBcmNumTrf() {
      return this.bcmNumTrf;
   }

   public void setBcmNumTrf(String var1) {
      this.bcmNumTrf = var1;
   }

   public double getBcmTotTimbre() {
      return this.bcmTotTimbre;
   }

   public void setBcmTotTimbre(double var1) {
      this.bcmTotTimbre = var1;
   }

   public int getBcmPosSignature() {
      return this.bcmPosSignature;
   }

   public void setBcmPosSignature(int var1) {
      this.bcmPosSignature = var1;
   }

   public boolean isBcmPj() {
      return this.bcmPj;
   }

   public void setBcmPj(boolean var1) {
      this.bcmPj = var1;
   }

   public boolean isBcmRistourneBloquee() {
      return this.bcmRistourneBloquee;
   }

   public void setBcmRistourneBloquee(boolean var1) {
      this.bcmRistourneBloquee = var1;
   }

   public int getBcmSuivi() {
      return this.bcmSuivi;
   }

   public void setBcmSuivi(int var1) {
      this.bcmSuivi = var1;
   }

   public Date getBcmDateClient() {
      return this.bcmDateClient;
   }

   public void setBcmDateClient(Date var1) {
      this.bcmDateClient = var1;
   }

   public String getBcmNumClient() {
      return this.bcmNumClient;
   }

   public void setBcmNumClient(String var1) {
      this.bcmNumClient = var1;
   }

   public String getBcmAffaire() {
      return this.bcmAffaire;
   }

   public void setBcmAffaire(String var1) {
      this.bcmAffaire = var1;
   }

   public float getBcmPoids() {
      return this.bcmPoids;
   }

   public void setBcmPoids(float var1) {
      this.bcmPoids = var1;
   }

   public double getBcmTotLivre() {
      return this.bcmTotLivre;
   }

   public void setBcmTotLivre(double var1) {
      this.bcmTotLivre = var1;
   }
}
