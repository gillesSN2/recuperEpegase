package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class AppelCharge implements Serializable {
   private long appchaId;
   private Date appchaDateCreat;
   private Date appchaDateModif;
   private long appchaIdCreateur;
   private String appchaNomCreateur;
   private long appchaIdModif;
   private String appchaNomModif;
   private Date appchaDate;
   private Date appchaDateDebut;
   private Date appchaDateFin;
   private String appchaNum;
   private String appchaPeriode;
   private String appchaContrat;
   private String appchaImmeuble;
   private long appchaIdImmeuble;
   private int appchaMlImmeuble;
   private String appchaNomResponsable;
   private long appchaIdResponsable;
   private String appchaNomCommercial;
   private long appchaIdCommercial;
   private String appchaBien;
   private long appchaIdBien;
   private int appchaMlBien;
   private long appchaIdTiers;
   private String appchaNomTiers;
   private String appchaCivilTiers;
   private long appchaIdContact;
   private String appchaNomContact;
   private String appchaCivilContact;
   private String appchaSerie;
   private int appchaExoTva;
   private int appchaMode;
   private String appchaDevise;
   private String appchaObject;
   private String appchaObservation;
   private long appchaIdBudget;
   private String appchaBudget;
   private String appchaAnneeBudget;
   private double appchaTotAnnuel;
   private double appchaTotReliquat;
   private double appchaTotBudget;
   private double appchaTotReglement;
   private double appchaTotTimbre;
   private int appchaSolde;
   private String appchaBanque;
   private int appchaTypeReg;
   private String appchaModeReg;
   private Date appchaEcheanceReliquat;
   private String appchaMotifRejetCredit;
   private int appchaNbJourReg;
   private int appchaArrondiReg;
   private String appchaConditionReg;
   private Date appchaDateEcheReg;
   private Date appchaDateLastReg;
   private String appchaJournalReg;
   private String appchaInfo1;
   private String appchaInfo2;
   private String appchaInfo3;
   private String appchaInfo4;
   private String appchaInfo5;
   private String appchaInfo6;
   private String appchaInfo7;
   private String appchaInfo8;
   private String appchaInfo9;
   private String appchaInfo10;
   private String appchaFormule1;
   private String appchaFormule2;
   private Date appchaDateImp;
   private String appchaModeleImp;
   private int appchaEtatVal;
   private int appchaGele;
   private int appchaEtat;
   private String appchaNumTrf;
   private Date appchaDateValidite;
   private Date appchaDateRelance;
   private Date appchaDateValide;
   private Date appchaDateTransforme;
   private int appchaTypeTransforme;
   private Date appchaDateAnnule;
   private String appchaMotifAnnule;
   private String appchaMotifExo;
   private String appchaNumVisa;
   private Date appchaDateVisa;
   private String appchaRangeVisa;
   private Date appchaDateTransfert;
   private String appchaNumAvoir;
   private String appchaSource;
   private double appchaPu;
   private double appchaTotHt;
   private double appchaTotTva;
   private double appchaTotTtc;
   private double appchaTotTc;
   private double appchaPuReliquat;
   private double appchaTotHtReliquat;
   private double appchaTotTvaReliquat;
   private double appchaTotTtcReliquat;
   private double appchaTotTcReliquat;
   private double appchaTauxRemise;
   private double appchaTotRemise;
   private double appchaTauxTva;
   private String appchaCodeTva;
   private ExercicesVentes exerciceventes;
   private Bien bien;
   private Users users;
   private String libelleEta;
   private String libelleMode;
   private String var_solde;
   private double var_reliquat;
   private boolean var_select_ligne;
   private int var_format_devise;
   private double varTotTtcGlob;
   private String var_nomContact;
   private String var_nom_proprietaire;
   private double var_fac_timbre;
   private double var_taxes;
   private double var_tot_reglement;
   private double var_tot_avoir;
   private String montantLettre;
   private String dupplicata;
   private String infoOrigineDoc;
   private double montantReglementManuel;
   private double totalTtc;
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
   private Date IMPappchaDate;
   private Date IMPappchaDateDebut;
   private Date IMPappchaDateFin;
   private String IMPappchaNum;
   private String IMPappchaPeriode;
   private String IMPappchaContrat;
   private String IMPappchaImmeuble;
   private long IMPappchaIdImmeuble;
   private int IMPappchaMlImmeuble;
   private String IMPappchaNomResponsable;
   private long IMPappchaIdResponsable;
   private String IMPappchaNomCommercial;
   private long IMPappchaIdCommercial;
   private String IMPappchaBien;
   private long IMPappchaIdBien;
   private int IMPappchaMlBien;
   private long IMPappchaIdTiers;
   private String IMPappchaNomTiers;
   private String IMPappchaCivilTiers;
   private long IMPappchaIdContact;
   private String IMPappchaNomContact;
   private String IMPappchaCivilContact;
   private String IMPappchaSerie;
   private int IMPappchaExoTva;
   private int IMPappchaMode;
   private String IMPappchaDevise;
   private String IMPappchaObject;
   private String IMPappchaObservation;
   private long IMPappchaIdBudget;
   private String IMPappchaBudget;
   private String IMPappchaAnneeBudget;
   private double IMPappchaTotAnnuel;
   private double IMPappchaTotReliquat;
   private double IMPappchaTotBudget;
   private double IMPappchaTotReglement;
   private double IMPappchaTotTimbre;
   private int IMPappchaSolde;
   private String IMPappchaBanque;
   private int IMPappchaTypeReg;
   private String IMPappchaModeReg;
   private int IMPappchaNbJourReg;
   private int IMPappchaArrondiReg;
   private String IMPappchaConditionReg;
   private String IMPappchaJournalReg;
   private String IMPappchaInfo1;
   private String IMPappchaInfo2;
   private String IMPappchaInfo3;
   private String IMPappchaInfo4;
   private String IMPappchaInfo5;
   private String IMPappchaInfo6;
   private String IMPappchaInfo7;
   private String IMPappchaInfo8;
   private String IMPappchaInfo9;
   private String IMPappchaInfo10;
   private String IMPappchaFormule1;
   private String IMPappchaFormule2;
   private int IMPappchaEtat;
   private String IMPappchaNumTrf;
   private String IMPappchaNumAvoir;
   private String IMPappchaSource;
   private double IMPappchaPu;
   private double IMPappchaTotHt;
   private double IMPappchaTotTva;
   private double IMPappchaTotTtc;
   private double IMPappchaTotTc;
   private double IMPappchaPuReliquat;
   private double IMPappchaTotHtReliquat;
   private double IMPappchaTotTvaReliquat;
   private double IMPappchaTotTtcReliquat;
   private double IMPappchaTotTcReliquat;
   private double IMPappchaTauxRemise;
   private double IMPappchaTotRemise;
   private double IMPappchaTauxTva;
   private String IMPappchaCodeTva;

   public double getTotalTtc() {
      this.totalTtc = this.appchaTotTtc + this.appchaTotTtcReliquat;
      return this.totalTtc;
   }

   public void setTotalTtc(double var1) {
      this.totalTtc = var1;
   }

   public double getVar_tot_reglement() {
      this.var_tot_reglement = this.appchaTotReglement + this.appchaTotTimbre;
      return this.var_tot_reglement;
   }

   public void setVar_tot_reglement(double var1) {
      this.var_tot_reglement = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.appchaTotTtc + this.appchaTotTc + this.appchaTotTtcReliquat + this.appchaTotTcReliquat - this.var_tot_avoir;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getLibelleMode() {
      if (this.appchaMode >= 20) {
         if (this.appchaMode == 20) {
            this.libelleMode = "Espèce";
         } else if (this.appchaMode == 21) {
            this.libelleMode = "Chéque";
         } else if (this.appchaMode == 22) {
            this.libelleMode = "Virement";
         } else if (this.appchaMode == 23) {
            this.libelleMode = "Traite";
         } else if (this.appchaMode == 24) {
            this.libelleMode = "T.P.E.";
         } else if (this.appchaMode == 25) {
            this.libelleMode = "Transfert argent";
         } else if (this.appchaMode == 26) {
            this.libelleMode = "ePaiement";
         } else if (this.appchaMode == 27) {
            this.libelleMode = "Crédoc";
         } else if (this.appchaMode == 28) {
            this.libelleMode = "Factor";
         } else if (this.appchaMode == 29) {
            this.libelleMode = "Compense";
         } else if (this.appchaMode == 30) {
            this.libelleMode = "Terme";
         } else if (this.appchaMode == 31) {
            this.libelleMode = "Espèces sans timbre";
         } else if (this.appchaMode == 32) {
            this.libelleMode = "Lettre de garantie";
         } else if (this.appchaMode == 33) {
            this.libelleMode = "Prélèvement";
         } else {
            this.libelleMode = "Autre";
         }
      } else if (this.appchaMode == 0) {
         this.libelleMode = "Normal";
      } else if (this.appchaMode == 1) {
         this.libelleMode = "Exceptionnel";
      } else if (this.appchaMode == 2) {
         this.libelleMode = "F.Roul.";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getDupplicata() {
      return this.dupplicata;
   }

   public void setDupplicata(String var1) {
      this.dupplicata = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public String getInfoOrigineDoc() {
      return this.infoOrigineDoc;
   }

   public void setInfoOrigineDoc(String var1) {
      this.infoOrigineDoc = var1;
   }

   public String getLibelleEta() {
      if (this.appchaEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.appchaEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.appchaEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.appchaEtat == 3) {
         this.libelleEta = "Ann.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getMontantLettre() {
      return this.montantLettre;
   }

   public void setMontantLettre(String var1) {
      this.montantLettre = var1;
   }

   public double getMontantReglementManuel() {
      return this.montantReglementManuel;
   }

   public void setMontantReglementManuel(double var1) {
      this.montantReglementManuel = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public Users getUsers() {
      return this.users;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public double getVar_fac_timbre() {
      return this.var_fac_timbre;
   }

   public void setVar_fac_timbre(double var1) {
      this.var_fac_timbre = var1;
   }

   public int getVar_format_devise() {
      return this.var_format_devise;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public String getVar_nomContact() {
      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getVar_nom_proprietaire() {
      if (this.appchaCivilTiers != null && !this.appchaCivilTiers.isEmpty()) {
         this.var_nom_proprietaire = this.appchaCivilTiers + " " + this.appchaNomTiers;
      } else {
         this.var_nom_proprietaire = this.appchaNomTiers;
      }

      return this.var_nom_proprietaire;
   }

   public void setVar_nom_proprietaire(String var1) {
      this.var_nom_proprietaire = var1;
   }

   public double getVar_reliquat() {
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
      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public double getVar_taxes() {
      return this.var_taxes;
   }

   public void setVar_taxes(double var1) {
      this.var_taxes = var1;
   }

   public int getAppchaArrondiReg() {
      return this.appchaArrondiReg;
   }

   public void setAppchaArrondiReg(int var1) {
      this.appchaArrondiReg = var1;
   }

   public String getAppchaBanque() {
      return this.appchaBanque;
   }

   public void setAppchaBanque(String var1) {
      this.appchaBanque = var1;
   }

   public String getAppchaBien() {
      return this.appchaBien;
   }

   public void setAppchaBien(String var1) {
      this.appchaBien = var1;
   }

   public String getAppchaBudget() {
      return this.appchaBudget;
   }

   public void setAppchaBudget(String var1) {
      this.appchaBudget = var1;
   }

   public String getAppchaCivilContact() {
      return this.appchaCivilContact;
   }

   public void setAppchaCivilContact(String var1) {
      this.appchaCivilContact = var1;
   }

   public String getAppchaCivilTiers() {
      return this.appchaCivilTiers;
   }

   public void setAppchaCivilTiers(String var1) {
      this.appchaCivilTiers = var1;
   }

   public String getAppchaConditionReg() {
      return this.appchaConditionReg;
   }

   public void setAppchaConditionReg(String var1) {
      this.appchaConditionReg = var1;
   }

   public Date getAppchaDate() {
      return this.appchaDate;
   }

   public void setAppchaDate(Date var1) {
      this.appchaDate = var1;
   }

   public Date getAppchaDateAnnule() {
      return this.appchaDateAnnule;
   }

   public void setAppchaDateAnnule(Date var1) {
      this.appchaDateAnnule = var1;
   }

   public Date getAppchaDateCreat() {
      return this.appchaDateCreat;
   }

   public void setAppchaDateCreat(Date var1) {
      this.appchaDateCreat = var1;
   }

   public Date getAppchaDateDebut() {
      return this.appchaDateDebut;
   }

   public void setAppchaDateDebut(Date var1) {
      this.appchaDateDebut = var1;
   }

   public Date getAppchaDateEcheReg() {
      return this.appchaDateEcheReg;
   }

   public void setAppchaDateEcheReg(Date var1) {
      this.appchaDateEcheReg = var1;
   }

   public Date getAppchaDateFin() {
      return this.appchaDateFin;
   }

   public void setAppchaDateFin(Date var1) {
      this.appchaDateFin = var1;
   }

   public Date getAppchaDateImp() {
      return this.appchaDateImp;
   }

   public void setAppchaDateImp(Date var1) {
      this.appchaDateImp = var1;
   }

   public Date getAppchaDateLastReg() {
      return this.appchaDateLastReg;
   }

   public void setAppchaDateLastReg(Date var1) {
      this.appchaDateLastReg = var1;
   }

   public Date getAppchaDateModif() {
      return this.appchaDateModif;
   }

   public void setAppchaDateModif(Date var1) {
      this.appchaDateModif = var1;
   }

   public Date getAppchaDateRelance() {
      return this.appchaDateRelance;
   }

   public void setAppchaDateRelance(Date var1) {
      this.appchaDateRelance = var1;
   }

   public Date getAppchaDateTransfert() {
      return this.appchaDateTransfert;
   }

   public void setAppchaDateTransfert(Date var1) {
      this.appchaDateTransfert = var1;
   }

   public Date getAppchaDateTransforme() {
      return this.appchaDateTransforme;
   }

   public void setAppchaDateTransforme(Date var1) {
      this.appchaDateTransforme = var1;
   }

   public Date getAppchaDateValide() {
      return this.appchaDateValide;
   }

   public void setAppchaDateValide(Date var1) {
      this.appchaDateValide = var1;
   }

   public Date getAppchaDateValidite() {
      return this.appchaDateValidite;
   }

   public void setAppchaDateValidite(Date var1) {
      this.appchaDateValidite = var1;
   }

   public Date getAppchaDateVisa() {
      return this.appchaDateVisa;
   }

   public void setAppchaDateVisa(Date var1) {
      this.appchaDateVisa = var1;
   }

   public String getAppchaDevise() {
      return this.appchaDevise;
   }

   public void setAppchaDevise(String var1) {
      this.appchaDevise = var1;
   }

   public Date getAppchaEcheanceReliquat() {
      return this.appchaEcheanceReliquat;
   }

   public void setAppchaEcheanceReliquat(Date var1) {
      this.appchaEcheanceReliquat = var1;
   }

   public int getAppchaEtat() {
      return this.appchaEtat;
   }

   public void setAppchaEtat(int var1) {
      this.appchaEtat = var1;
   }

   public int getAppchaEtatVal() {
      return this.appchaEtatVal;
   }

   public void setAppchaEtatVal(int var1) {
      this.appchaEtatVal = var1;
   }

   public int getAppchaExoTva() {
      return this.appchaExoTva;
   }

   public void setAppchaExoTva(int var1) {
      this.appchaExoTva = var1;
   }

   public String getAppchaFormule1() {
      return this.appchaFormule1;
   }

   public void setAppchaFormule1(String var1) {
      this.appchaFormule1 = var1;
   }

   public String getAppchaFormule2() {
      return this.appchaFormule2;
   }

   public void setAppchaFormule2(String var1) {
      this.appchaFormule2 = var1;
   }

   public int getAppchaGele() {
      return this.appchaGele;
   }

   public void setAppchaGele(int var1) {
      this.appchaGele = var1;
   }

   public long getAppchaId() {
      return this.appchaId;
   }

   public void setAppchaId(long var1) {
      this.appchaId = var1;
   }

   public long getAppchaIdCommercial() {
      return this.appchaIdCommercial;
   }

   public void setAppchaIdCommercial(long var1) {
      this.appchaIdCommercial = var1;
   }

   public long getAppchaIdContact() {
      return this.appchaIdContact;
   }

   public void setAppchaIdContact(long var1) {
      this.appchaIdContact = var1;
   }

   public long getAppchaIdCreateur() {
      return this.appchaIdCreateur;
   }

   public void setAppchaIdCreateur(long var1) {
      this.appchaIdCreateur = var1;
   }

   public long getAppchaIdModif() {
      return this.appchaIdModif;
   }

   public void setAppchaIdModif(long var1) {
      this.appchaIdModif = var1;
   }

   public long getAppchaIdResponsable() {
      return this.appchaIdResponsable;
   }

   public void setAppchaIdResponsable(long var1) {
      this.appchaIdResponsable = var1;
   }

   public String getAppchaInfo1() {
      return this.appchaInfo1;
   }

   public void setAppchaInfo1(String var1) {
      this.appchaInfo1 = var1;
   }

   public String getAppchaInfo10() {
      return this.appchaInfo10;
   }

   public void setAppchaInfo10(String var1) {
      this.appchaInfo10 = var1;
   }

   public String getAppchaInfo2() {
      return this.appchaInfo2;
   }

   public void setAppchaInfo2(String var1) {
      this.appchaInfo2 = var1;
   }

   public String getAppchaInfo3() {
      return this.appchaInfo3;
   }

   public void setAppchaInfo3(String var1) {
      this.appchaInfo3 = var1;
   }

   public String getAppchaInfo4() {
      return this.appchaInfo4;
   }

   public void setAppchaInfo4(String var1) {
      this.appchaInfo4 = var1;
   }

   public String getAppchaInfo5() {
      return this.appchaInfo5;
   }

   public void setAppchaInfo5(String var1) {
      this.appchaInfo5 = var1;
   }

   public String getAppchaInfo6() {
      return this.appchaInfo6;
   }

   public void setAppchaInfo6(String var1) {
      this.appchaInfo6 = var1;
   }

   public String getAppchaInfo7() {
      return this.appchaInfo7;
   }

   public void setAppchaInfo7(String var1) {
      this.appchaInfo7 = var1;
   }

   public String getAppchaInfo8() {
      return this.appchaInfo8;
   }

   public void setAppchaInfo8(String var1) {
      this.appchaInfo8 = var1;
   }

   public String getAppchaInfo9() {
      return this.appchaInfo9;
   }

   public void setAppchaInfo9(String var1) {
      this.appchaInfo9 = var1;
   }

   public String getAppchaJournalReg() {
      return this.appchaJournalReg;
   }

   public void setAppchaJournalReg(String var1) {
      this.appchaJournalReg = var1;
   }

   public int getAppchaMode() {
      return this.appchaMode;
   }

   public void setAppchaMode(int var1) {
      this.appchaMode = var1;
   }

   public String getAppchaModeReg() {
      return this.appchaModeReg;
   }

   public void setAppchaModeReg(String var1) {
      this.appchaModeReg = var1;
   }

   public String getAppchaModeleImp() {
      return this.appchaModeleImp;
   }

   public void setAppchaModeleImp(String var1) {
      this.appchaModeleImp = var1;
   }

   public String getAppchaMotifAnnule() {
      return this.appchaMotifAnnule;
   }

   public void setAppchaMotifAnnule(String var1) {
      this.appchaMotifAnnule = var1;
   }

   public String getAppchaMotifExo() {
      return this.appchaMotifExo;
   }

   public void setAppchaMotifExo(String var1) {
      this.appchaMotifExo = var1;
   }

   public int getAppchaNbJourReg() {
      return this.appchaNbJourReg;
   }

   public void setAppchaNbJourReg(int var1) {
      this.appchaNbJourReg = var1;
   }

   public String getAppchaNomCommercial() {
      return this.appchaNomCommercial;
   }

   public void setAppchaNomCommercial(String var1) {
      this.appchaNomCommercial = var1;
   }

   public String getAppchaNomContact() {
      return this.appchaNomContact;
   }

   public void setAppchaNomContact(String var1) {
      this.appchaNomContact = var1;
   }

   public String getAppchaNomCreateur() {
      return this.appchaNomCreateur;
   }

   public void setAppchaNomCreateur(String var1) {
      this.appchaNomCreateur = var1;
   }

   public String getAppchaNomModif() {
      return this.appchaNomModif;
   }

   public void setAppchaNomModif(String var1) {
      this.appchaNomModif = var1;
   }

   public String getAppchaNomResponsable() {
      return this.appchaNomResponsable;
   }

   public void setAppchaNomResponsable(String var1) {
      this.appchaNomResponsable = var1;
   }

   public String getAppchaNomTiers() {
      return this.appchaNomTiers;
   }

   public void setAppchaNomTiers(String var1) {
      this.appchaNomTiers = var1;
   }

   public String getAppchaNum() {
      return this.appchaNum;
   }

   public void setAppchaNum(String var1) {
      this.appchaNum = var1;
   }

   public String getAppchaNumAvoir() {
      return this.appchaNumAvoir;
   }

   public void setAppchaNumAvoir(String var1) {
      this.appchaNumAvoir = var1;
   }

   public String getAppchaNumTrf() {
      return this.appchaNumTrf;
   }

   public void setAppchaNumTrf(String var1) {
      this.appchaNumTrf = var1;
   }

   public String getAppchaNumVisa() {
      return this.appchaNumVisa;
   }

   public void setAppchaNumVisa(String var1) {
      this.appchaNumVisa = var1;
   }

   public String getAppchaObject() {
      return this.appchaObject;
   }

   public void setAppchaObject(String var1) {
      this.appchaObject = var1;
   }

   public String getAppchaObservation() {
      return this.appchaObservation;
   }

   public void setAppchaObservation(String var1) {
      this.appchaObservation = var1;
   }

   public String getAppchaRangeVisa() {
      return this.appchaRangeVisa;
   }

   public void setAppchaRangeVisa(String var1) {
      this.appchaRangeVisa = var1;
   }

   public String getAppchaSerie() {
      return this.appchaSerie;
   }

   public void setAppchaSerie(String var1) {
      this.appchaSerie = var1;
   }

   public int getAppchaSolde() {
      return this.appchaSolde;
   }

   public void setAppchaSolde(int var1) {
      this.appchaSolde = var1;
   }

   public String getAppchaSource() {
      return this.appchaSource;
   }

   public void setAppchaSource(String var1) {
      this.appchaSource = var1;
   }

   public double getAppchaTauxRemise() {
      return this.appchaTauxRemise;
   }

   public void setAppchaTauxRemise(double var1) {
      this.appchaTauxRemise = var1;
   }

   public double getAppchaTauxTva() {
      return this.appchaTauxTva;
   }

   public void setAppchaTauxTva(double var1) {
      this.appchaTauxTva = var1;
   }

   public long getAppchaIdTiers() {
      return this.appchaIdTiers;
   }

   public void setAppchaIdTiers(long var1) {
      this.appchaIdTiers = var1;
   }

   public double getAppchaTotHt() {
      return this.appchaTotHt;
   }

   public void setAppchaTotHt(double var1) {
      this.appchaTotHt = var1;
   }

   public double getAppchaTotReglement() {
      return this.appchaTotReglement;
   }

   public void setAppchaTotReglement(double var1) {
      this.appchaTotReglement = var1;
   }

   public double getAppchaTotRemise() {
      return this.appchaTotRemise;
   }

   public void setAppchaTotRemise(double var1) {
      this.appchaTotRemise = var1;
   }

   public double getAppchaTotTc() {
      return this.appchaTotTc;
   }

   public void setAppchaTotTc(double var1) {
      this.appchaTotTc = var1;
   }

   public double getAppchaTotTimbre() {
      return this.appchaTotTimbre;
   }

   public void setAppchaTotTimbre(double var1) {
      this.appchaTotTimbre = var1;
   }

   public double getAppchaTotTtc() {
      return this.appchaTotTtc;
   }

   public void setAppchaTotTtc(double var1) {
      this.appchaTotTtc = var1;
   }

   public double getAppchaTotTva() {
      return this.appchaTotTva;
   }

   public void setAppchaTotTva(double var1) {
      this.appchaTotTva = var1;
   }

   public int getAppchaTypeReg() {
      return this.appchaTypeReg;
   }

   public void setAppchaTypeReg(int var1) {
      this.appchaTypeReg = var1;
   }

   public int getAppchaTypeTransforme() {
      return this.appchaTypeTransforme;
   }

   public void setAppchaTypeTransforme(int var1) {
      this.appchaTypeTransforme = var1;
   }

   public long getAppchaIdBien() {
      return this.appchaIdBien;
   }

   public void setAppchaIdBien(long var1) {
      this.appchaIdBien = var1;
   }

   public long getAppchaIdImmeuble() {
      return this.appchaIdImmeuble;
   }

   public void setAppchaIdImmeuble(long var1) {
      this.appchaIdImmeuble = var1;
   }

   public String getAppchaImmeuble() {
      return this.appchaImmeuble;
   }

   public void setAppchaImmeuble(String var1) {
      this.appchaImmeuble = var1;
   }

   public String getAppchaPeriode() {
      return this.appchaPeriode;
   }

   public void setAppchaPeriode(String var1) {
      this.appchaPeriode = var1;
   }

   public int getAppchaMlBien() {
      return this.appchaMlBien;
   }

   public void setAppchaMlBien(int var1) {
      this.appchaMlBien = var1;
   }

   public int getAppchaMlImmeuble() {
      return this.appchaMlImmeuble;
   }

   public void setAppchaMlImmeuble(int var1) {
      this.appchaMlImmeuble = var1;
   }

   public double getAppchaPu() {
      return this.appchaPu;
   }

   public void setAppchaPu(double var1) {
      this.appchaPu = var1;
   }

   public double getAppchaTotBudget() {
      return this.appchaTotBudget;
   }

   public void setAppchaTotBudget(double var1) {
      this.appchaTotBudget = var1;
   }

   public long getAppchaIdBudget() {
      return this.appchaIdBudget;
   }

   public void setAppchaIdBudget(long var1) {
      this.appchaIdBudget = var1;
   }

   public String getAppchaCodeTva() {
      return this.appchaCodeTva;
   }

   public void setAppchaCodeTva(String var1) {
      this.appchaCodeTva = var1;
   }

   public String getAppchaContrat() {
      return this.appchaContrat;
   }

   public void setAppchaContrat(String var1) {
      this.appchaContrat = var1;
   }

   public String getAppchaAnneeBudget() {
      return this.appchaAnneeBudget;
   }

   public void setAppchaAnneeBudget(String var1) {
      this.appchaAnneeBudget = var1;
   }

   public double getAppchaTotAnnuel() {
      return this.appchaTotAnnuel;
   }

   public void setAppchaTotAnnuel(double var1) {
      this.appchaTotAnnuel = var1;
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

   public String getAppchaMotifRejetCredit() {
      return this.appchaMotifRejetCredit;
   }

   public void setAppchaMotifRejetCredit(String var1) {
      this.appchaMotifRejetCredit = var1;
   }

   public double getAppchaPuReliquat() {
      return this.appchaPuReliquat;
   }

   public void setAppchaPuReliquat(double var1) {
      this.appchaPuReliquat = var1;
   }

   public double getAppchaTotHtReliquat() {
      return this.appchaTotHtReliquat;
   }

   public void setAppchaTotHtReliquat(double var1) {
      this.appchaTotHtReliquat = var1;
   }

   public double getAppchaTotReliquat() {
      return this.appchaTotReliquat;
   }

   public void setAppchaTotReliquat(double var1) {
      this.appchaTotReliquat = var1;
   }

   public double getAppchaTotTcReliquat() {
      return this.appchaTotTcReliquat;
   }

   public void setAppchaTotTcReliquat(double var1) {
      this.appchaTotTcReliquat = var1;
   }

   public double getAppchaTotTtcReliquat() {
      return this.appchaTotTtcReliquat;
   }

   public void setAppchaTotTtcReliquat(double var1) {
      this.appchaTotTtcReliquat = var1;
   }

   public double getAppchaTotTvaReliquat() {
      return this.appchaTotTvaReliquat;
   }

   public void setAppchaTotTvaReliquat(double var1) {
      this.appchaTotTvaReliquat = var1;
   }

   public String getIMPappchaAnneeBudget() {
      return this.IMPappchaAnneeBudget;
   }

   public void setIMPappchaAnneeBudget(String var1) {
      this.IMPappchaAnneeBudget = var1;
   }

   public int getIMPappchaArrondiReg() {
      return this.IMPappchaArrondiReg;
   }

   public void setIMPappchaArrondiReg(int var1) {
      this.IMPappchaArrondiReg = var1;
   }

   public String getIMPappchaBanque() {
      return this.IMPappchaBanque;
   }

   public void setIMPappchaBanque(String var1) {
      this.IMPappchaBanque = var1;
   }

   public String getIMPappchaBien() {
      return this.IMPappchaBien;
   }

   public void setIMPappchaBien(String var1) {
      this.IMPappchaBien = var1;
   }

   public String getIMPappchaBudget() {
      return this.IMPappchaBudget;
   }

   public void setIMPappchaBudget(String var1) {
      this.IMPappchaBudget = var1;
   }

   public String getIMPappchaCivilContact() {
      return this.IMPappchaCivilContact;
   }

   public void setIMPappchaCivilContact(String var1) {
      this.IMPappchaCivilContact = var1;
   }

   public String getIMPappchaCivilTiers() {
      return this.IMPappchaCivilTiers;
   }

   public void setIMPappchaCivilTiers(String var1) {
      this.IMPappchaCivilTiers = var1;
   }

   public String getIMPappchaCodeTva() {
      return this.IMPappchaCodeTva;
   }

   public void setIMPappchaCodeTva(String var1) {
      this.IMPappchaCodeTva = var1;
   }

   public String getIMPappchaConditionReg() {
      return this.IMPappchaConditionReg;
   }

   public void setIMPappchaConditionReg(String var1) {
      this.IMPappchaConditionReg = var1;
   }

   public String getIMPappchaContrat() {
      return this.IMPappchaContrat;
   }

   public void setIMPappchaContrat(String var1) {
      this.IMPappchaContrat = var1;
   }

   public Date getIMPappchaDate() {
      return this.IMPappchaDate;
   }

   public void setIMPappchaDate(Date var1) {
      this.IMPappchaDate = var1;
   }

   public Date getIMPappchaDateDebut() {
      return this.IMPappchaDateDebut;
   }

   public void setIMPappchaDateDebut(Date var1) {
      this.IMPappchaDateDebut = var1;
   }

   public Date getIMPappchaDateFin() {
      return this.IMPappchaDateFin;
   }

   public void setIMPappchaDateFin(Date var1) {
      this.IMPappchaDateFin = var1;
   }

   public String getIMPappchaDevise() {
      return this.IMPappchaDevise;
   }

   public void setIMPappchaDevise(String var1) {
      this.IMPappchaDevise = var1;
   }

   public int getIMPappchaEtat() {
      return this.IMPappchaEtat;
   }

   public void setIMPappchaEtat(int var1) {
      this.IMPappchaEtat = var1;
   }

   public int getIMPappchaExoTva() {
      return this.IMPappchaExoTva;
   }

   public void setIMPappchaExoTva(int var1) {
      this.IMPappchaExoTva = var1;
   }

   public String getIMPappchaFormule1() {
      return this.IMPappchaFormule1;
   }

   public void setIMPappchaFormule1(String var1) {
      this.IMPappchaFormule1 = var1;
   }

   public String getIMPappchaFormule2() {
      return this.IMPappchaFormule2;
   }

   public void setIMPappchaFormule2(String var1) {
      this.IMPappchaFormule2 = var1;
   }

   public long getIMPappchaIdBien() {
      return this.IMPappchaIdBien;
   }

   public void setIMPappchaIdBien(long var1) {
      this.IMPappchaIdBien = var1;
   }

   public long getIMPappchaIdBudget() {
      return this.IMPappchaIdBudget;
   }

   public void setIMPappchaIdBudget(long var1) {
      this.IMPappchaIdBudget = var1;
   }

   public long getIMPappchaIdCommercial() {
      return this.IMPappchaIdCommercial;
   }

   public void setIMPappchaIdCommercial(long var1) {
      this.IMPappchaIdCommercial = var1;
   }

   public long getIMPappchaIdContact() {
      return this.IMPappchaIdContact;
   }

   public void setIMPappchaIdContact(long var1) {
      this.IMPappchaIdContact = var1;
   }

   public long getIMPappchaIdImmeuble() {
      return this.IMPappchaIdImmeuble;
   }

   public void setIMPappchaIdImmeuble(long var1) {
      this.IMPappchaIdImmeuble = var1;
   }

   public long getIMPappchaIdResponsable() {
      return this.IMPappchaIdResponsable;
   }

   public void setIMPappchaIdResponsable(long var1) {
      this.IMPappchaIdResponsable = var1;
   }

   public long getIMPappchaIdTiers() {
      return this.IMPappchaIdTiers;
   }

   public void setIMPappchaIdTiers(long var1) {
      this.IMPappchaIdTiers = var1;
   }

   public String getIMPappchaImmeuble() {
      return this.IMPappchaImmeuble;
   }

   public void setIMPappchaImmeuble(String var1) {
      this.IMPappchaImmeuble = var1;
   }

   public String getIMPappchaInfo1() {
      return this.IMPappchaInfo1;
   }

   public void setIMPappchaInfo1(String var1) {
      this.IMPappchaInfo1 = var1;
   }

   public String getIMPappchaInfo10() {
      return this.IMPappchaInfo10;
   }

   public void setIMPappchaInfo10(String var1) {
      this.IMPappchaInfo10 = var1;
   }

   public String getIMPappchaInfo2() {
      return this.IMPappchaInfo2;
   }

   public void setIMPappchaInfo2(String var1) {
      this.IMPappchaInfo2 = var1;
   }

   public String getIMPappchaInfo3() {
      return this.IMPappchaInfo3;
   }

   public void setIMPappchaInfo3(String var1) {
      this.IMPappchaInfo3 = var1;
   }

   public String getIMPappchaInfo4() {
      return this.IMPappchaInfo4;
   }

   public void setIMPappchaInfo4(String var1) {
      this.IMPappchaInfo4 = var1;
   }

   public String getIMPappchaInfo5() {
      return this.IMPappchaInfo5;
   }

   public void setIMPappchaInfo5(String var1) {
      this.IMPappchaInfo5 = var1;
   }

   public String getIMPappchaInfo6() {
      return this.IMPappchaInfo6;
   }

   public void setIMPappchaInfo6(String var1) {
      this.IMPappchaInfo6 = var1;
   }

   public String getIMPappchaInfo7() {
      return this.IMPappchaInfo7;
   }

   public void setIMPappchaInfo7(String var1) {
      this.IMPappchaInfo7 = var1;
   }

   public String getIMPappchaInfo8() {
      return this.IMPappchaInfo8;
   }

   public void setIMPappchaInfo8(String var1) {
      this.IMPappchaInfo8 = var1;
   }

   public String getIMPappchaInfo9() {
      return this.IMPappchaInfo9;
   }

   public void setIMPappchaInfo9(String var1) {
      this.IMPappchaInfo9 = var1;
   }

   public String getIMPappchaJournalReg() {
      return this.IMPappchaJournalReg;
   }

   public void setIMPappchaJournalReg(String var1) {
      this.IMPappchaJournalReg = var1;
   }

   public int getIMPappchaMlBien() {
      return this.IMPappchaMlBien;
   }

   public void setIMPappchaMlBien(int var1) {
      this.IMPappchaMlBien = var1;
   }

   public int getIMPappchaMlImmeuble() {
      return this.IMPappchaMlImmeuble;
   }

   public void setIMPappchaMlImmeuble(int var1) {
      this.IMPappchaMlImmeuble = var1;
   }

   public int getIMPappchaMode() {
      return this.IMPappchaMode;
   }

   public void setIMPappchaMode(int var1) {
      this.IMPappchaMode = var1;
   }

   public String getIMPappchaModeReg() {
      return this.IMPappchaModeReg;
   }

   public void setIMPappchaModeReg(String var1) {
      this.IMPappchaModeReg = var1;
   }

   public int getIMPappchaNbJourReg() {
      return this.IMPappchaNbJourReg;
   }

   public void setIMPappchaNbJourReg(int var1) {
      this.IMPappchaNbJourReg = var1;
   }

   public String getIMPappchaNomCommercial() {
      return this.IMPappchaNomCommercial;
   }

   public void setIMPappchaNomCommercial(String var1) {
      this.IMPappchaNomCommercial = var1;
   }

   public String getIMPappchaNomContact() {
      return this.IMPappchaNomContact;
   }

   public void setIMPappchaNomContact(String var1) {
      this.IMPappchaNomContact = var1;
   }

   public String getIMPappchaNomResponsable() {
      return this.IMPappchaNomResponsable;
   }

   public void setIMPappchaNomResponsable(String var1) {
      this.IMPappchaNomResponsable = var1;
   }

   public String getIMPappchaNomTiers() {
      return this.IMPappchaNomTiers;
   }

   public void setIMPappchaNomTiers(String var1) {
      this.IMPappchaNomTiers = var1;
   }

   public String getIMPappchaNum() {
      return this.IMPappchaNum;
   }

   public void setIMPappchaNum(String var1) {
      this.IMPappchaNum = var1;
   }

   public String getIMPappchaNumAvoir() {
      return this.IMPappchaNumAvoir;
   }

   public void setIMPappchaNumAvoir(String var1) {
      this.IMPappchaNumAvoir = var1;
   }

   public String getIMPappchaNumTrf() {
      return this.IMPappchaNumTrf;
   }

   public void setIMPappchaNumTrf(String var1) {
      this.IMPappchaNumTrf = var1;
   }

   public String getIMPappchaObject() {
      return this.IMPappchaObject;
   }

   public void setIMPappchaObject(String var1) {
      this.IMPappchaObject = var1;
   }

   public String getIMPappchaObservation() {
      return this.IMPappchaObservation;
   }

   public void setIMPappchaObservation(String var1) {
      this.IMPappchaObservation = var1;
   }

   public String getIMPappchaPeriode() {
      return this.IMPappchaPeriode;
   }

   public void setIMPappchaPeriode(String var1) {
      this.IMPappchaPeriode = var1;
   }

   public double getIMPappchaPu() {
      return this.IMPappchaPu;
   }

   public void setIMPappchaPu(double var1) {
      this.IMPappchaPu = var1;
   }

   public double getIMPappchaPuReliquat() {
      return this.IMPappchaPuReliquat;
   }

   public void setIMPappchaPuReliquat(double var1) {
      this.IMPappchaPuReliquat = var1;
   }

   public String getIMPappchaSerie() {
      return this.IMPappchaSerie;
   }

   public void setIMPappchaSerie(String var1) {
      this.IMPappchaSerie = var1;
   }

   public int getIMPappchaSolde() {
      return this.IMPappchaSolde;
   }

   public void setIMPappchaSolde(int var1) {
      this.IMPappchaSolde = var1;
   }

   public String getIMPappchaSource() {
      return this.IMPappchaSource;
   }

   public void setIMPappchaSource(String var1) {
      this.IMPappchaSource = var1;
   }

   public double getIMPappchaTauxRemise() {
      return this.IMPappchaTauxRemise;
   }

   public void setIMPappchaTauxRemise(double var1) {
      this.IMPappchaTauxRemise = var1;
   }

   public double getIMPappchaTauxTva() {
      return this.IMPappchaTauxTva;
   }

   public void setIMPappchaTauxTva(double var1) {
      this.IMPappchaTauxTva = var1;
   }

   public double getIMPappchaTotAnnuel() {
      return this.IMPappchaTotAnnuel;
   }

   public void setIMPappchaTotAnnuel(double var1) {
      this.IMPappchaTotAnnuel = var1;
   }

   public double getIMPappchaTotBudget() {
      return this.IMPappchaTotBudget;
   }

   public void setIMPappchaTotBudget(double var1) {
      this.IMPappchaTotBudget = var1;
   }

   public double getIMPappchaTotHt() {
      return this.IMPappchaTotHt;
   }

   public void setIMPappchaTotHt(double var1) {
      this.IMPappchaTotHt = var1;
   }

   public double getIMPappchaTotHtReliquat() {
      return this.IMPappchaTotHtReliquat;
   }

   public void setIMPappchaTotHtReliquat(double var1) {
      this.IMPappchaTotHtReliquat = var1;
   }

   public double getIMPappchaTotReglement() {
      return this.IMPappchaTotReglement;
   }

   public void setIMPappchaTotReglement(double var1) {
      this.IMPappchaTotReglement = var1;
   }

   public double getIMPappchaTotReliquat() {
      return this.IMPappchaTotReliquat;
   }

   public void setIMPappchaTotReliquat(double var1) {
      this.IMPappchaTotReliquat = var1;
   }

   public double getIMPappchaTotRemise() {
      return this.IMPappchaTotRemise;
   }

   public void setIMPappchaTotRemise(double var1) {
      this.IMPappchaTotRemise = var1;
   }

   public double getIMPappchaTotTc() {
      return this.IMPappchaTotTc;
   }

   public void setIMPappchaTotTc(double var1) {
      this.IMPappchaTotTc = var1;
   }

   public double getIMPappchaTotTcReliquat() {
      return this.IMPappchaTotTcReliquat;
   }

   public void setIMPappchaTotTcReliquat(double var1) {
      this.IMPappchaTotTcReliquat = var1;
   }

   public double getIMPappchaTotTimbre() {
      return this.IMPappchaTotTimbre;
   }

   public void setIMPappchaTotTimbre(double var1) {
      this.IMPappchaTotTimbre = var1;
   }

   public double getIMPappchaTotTtc() {
      return this.IMPappchaTotTtc;
   }

   public void setIMPappchaTotTtc(double var1) {
      this.IMPappchaTotTtc = var1;
   }

   public double getIMPappchaTotTtcReliquat() {
      return this.IMPappchaTotTtcReliquat;
   }

   public void setIMPappchaTotTtcReliquat(double var1) {
      this.IMPappchaTotTtcReliquat = var1;
   }

   public double getIMPappchaTotTva() {
      return this.IMPappchaTotTva;
   }

   public void setIMPappchaTotTva(double var1) {
      this.IMPappchaTotTva = var1;
   }

   public double getIMPappchaTotTvaReliquat() {
      return this.IMPappchaTotTvaReliquat;
   }

   public void setIMPappchaTotTvaReliquat(double var1) {
      this.IMPappchaTotTvaReliquat = var1;
   }

   public int getIMPappchaTypeReg() {
      return this.IMPappchaTypeReg;
   }

   public void setIMPappchaTypeReg(int var1) {
      this.IMPappchaTypeReg = var1;
   }

   public double getVar_tot_avoir() {
      return this.var_tot_avoir;
   }

   public void setVar_tot_avoir(double var1) {
      this.var_tot_avoir = var1;
   }
}
