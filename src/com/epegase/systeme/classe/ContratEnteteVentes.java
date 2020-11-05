package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ContratEnteteVentes implements Serializable {
   private long crtId;
   private Date crtDateCreat;
   private String crtNum;
   private long crtIdCreateur;
   private String crtNomCreateur;
   private Date crtDateModif;
   private long crtIdModif;
   private String crtNomModif;
   private Date crtDate;
   private String crtNomEquipe;
   private long crtIdEquipe;
   private String crtNomResponsable;
   private long crtIdResponsable;
   private String crtNomCommercial;
   private long crtIdCommercial;
   private String crtDiversNom;
   private String crtNomTiers;
   private String crtCivilTiers;
   private String crtTiersRegroupe;
   private long crtIdContact;
   private String crtNomContact;
   private String crtCivilContact;
   private String crtSerie;
   private int crtExoTva;
   private int crtExoDouane;
   private String crtJournalReg;
   private String crtCat;
   private String crtDevise;
   private String crtObject;
   private String crtObservation;
   private String crtBudget;
   private float crtTauxRemise;
   private double crtTotHt;
   private double crtTotRemise;
   private double crtTotRabais;
   private double crtTotTva;
   private float crtTauxTc;
   private double crtTotTc;
   private double crtTotTtc;
   private double crtTotTimbre;
   private int crtMode;
   private double crtTotApport;
   private double crtTotReste;
   private String crtBanque;
   private int crtTypeReg;
   private String crtModeReg;
   private int crtNbJourReg;
   private int crtArrondiReg;
   private String crtConditionReg;
   private String crtActivite;
   private String crtSite;
   private String crtDepartement;
   private String crtService;
   private String crtRegion;
   private String crtSecteur;
   private String crtPdv;
   private String crtAnal2;
   private String crtAnal4;
   private String crtAffaire;
   private String crtInfo1;
   private String crtInfo2;
   private String crtInfo3;
   private String crtInfo4;
   private String crtInfo5;
   private String crtInfo6;
   private String crtInfo7;
   private String crtInfo8;
   private String crtInfo9;
   private String crtInfo10;
   private String crtFormule1;
   private String crtFormule2;
   private Date crtDateImp;
   private String crtModeleImp;
   private Date crtDateEnvoie;
   private Date crtDateSigne;
   private Date crtDateLivraisonTheo;
   private Date crtDateLivraisonReel;
   private int crtEtatVal;
   private int crtGele;
   private int crtEtat;
   private String crtNumTrf;
   private Date crtDateValidite;
   private Date crtDateValide;
   private String crtMotifExo;
   private String crtNumVisa;
   private Date crtDateVisa;
   private String crtRangeVisa;
   private Date crtDateTransfert;
   private int crtStock;
   private String crtSource;
   private Date crtDateDebut;
   private Date crtDateFin;
   private Date crtDateButoire;
   private int crtType;
   private int crtPeriodicite;
   private int crtJour;
   private String crtText;
   private String crtNumCompteur;
   private long crtIndexInitial;
   private String crtNature;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private boolean var_select_ligne;
   private int var_format_devise;
   private double varTotTtcGlob;
   private String var_nomContact;
   private String var_nom_tiers;
   private double var_crt_timbre;
   private String montantLettre;
   private String dupplicata;
   private String infoOrigineDoc;
   private String parcImmatriculation;
   private String lib_periodicite;
   private String lib_type;

   public String getLib_type() {
      if (this.crtType == 0) {
         this.lib_type = "Vente";
      } else if (this.crtType == 1) {
         this.lib_type = "leasing";
      } else if (this.crtType == 2) {
         this.lib_type = "garantie";
      } else if (this.crtType == 3) {
         this.lib_type = "formation";
      } else if (this.crtType == 4) {
         this.lib_type = "location";
      } else if (this.crtType == 20) {
         this.lib_type = "Maintenance";
      } else if (this.crtType == 21) {
         this.lib_type = "Assistance";
      } else if (this.crtType == 22) {
         this.lib_type = "Abonnement";
      } else if (this.crtType == 23) {
         this.lib_type = "Sauvegarde";
      } else if (this.crtType == 24) {
         this.lib_type = "Entretien";
      } else if (this.crtType == 25) {
         this.lib_type = "Crt. Abn.";
      } else if (this.crtType == 26) {
         this.lib_type = "Abn. Cabinet";
      } else if (this.crtType == 99) {
         this.lib_type = "Autre";
      } else if (this.crtType == 100) {
         this.lib_type = "Forfait";
      } else if (this.crtType == 101) {
         this.lib_type = "Temps";
      }

      return this.lib_type;
   }

   public void setLib_type(String var1) {
      this.lib_type = var1;
   }

   public String getLib_periodicite() {
      if (this.crtPeriodicite == 0) {
         this.lib_periodicite = "Journalier";
      } else if (this.crtPeriodicite == 1) {
         this.lib_periodicite = "Hebdomadaire";
      } else if (this.crtPeriodicite == 2) {
         this.lib_periodicite = "Mensuel";
      } else if (this.crtPeriodicite == 3) {
         this.lib_periodicite = "Trimestriel";
      } else if (this.crtPeriodicite == 4) {
         this.lib_periodicite = "Semestriel";
      } else if (this.crtPeriodicite == 5) {
         this.lib_periodicite = "Annuel";
      }

      return this.lib_periodicite;
   }

   public void setLib_periodicite(String var1) {
      this.lib_periodicite = var1;
   }

   public double getVar_crt_timbre() {
      return this.var_crt_timbre;
   }

   public void setVar_crt_timbre(double var1) {
      this.var_crt_timbre = var1;
   }

   public String getVar_nom_tiers() {
      if (this.crtCivilTiers != null && !this.crtCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.crtCivilTiers + " " + this.crtNomTiers;
      } else {
         this.var_nom_tiers = this.crtNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.crtCivilContact != null && !this.crtCivilContact.isEmpty()) {
         this.var_nomContact = this.crtCivilContact + " " + this.crtNomContact;
      } else {
         this.var_nomContact = this.crtNomContact;
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.crtTotTtc + this.crtTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getLibelleEta() {
      if (this.crtEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.crtEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.crtEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.crtEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.crtEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.crtEtat == 5) {
         this.libelleEta = "Trf.T.";
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

   public int getVar_format_devise() {
      if (!this.crtDevise.equals("XOF") && !this.crtDevise.equals("XAF")) {
         if (!this.crtDevise.equals("EUR") && !this.crtDevise.equals("XEU") && !this.crtDevise.equals("CHF")) {
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

   public String getCrtActivite() {
      return this.crtActivite;
   }

   public void setCrtActivite(String var1) {
      this.crtActivite = var1;
   }

   public String getCrtAnal2() {
      return this.crtAnal2;
   }

   public void setCrtAnal2(String var1) {
      this.crtAnal2 = var1;
   }

   public String getCrtAnal4() {
      return this.crtAnal4;
   }

   public void setCrtAnal4(String var1) {
      this.crtAnal4 = var1;
   }

   public int getCrtArrondiReg() {
      return this.crtArrondiReg;
   }

   public void setCrtArrondiReg(int var1) {
      this.crtArrondiReg = var1;
   }

   public String getCrtBanque() {
      return this.crtBanque;
   }

   public void setCrtBanque(String var1) {
      this.crtBanque = var1;
   }

   public String getCrtBudget() {
      return this.crtBudget;
   }

   public void setCrtBudget(String var1) {
      this.crtBudget = var1;
   }

   public String getCrtCat() {
      return this.crtCat;
   }

   public void setCrtCat(String var1) {
      this.crtCat = var1;
   }

   public String getCrtCivilContact() {
      return this.crtCivilContact;
   }

   public void setCrtCivilContact(String var1) {
      this.crtCivilContact = var1;
   }

   public String getCrtCivilTiers() {
      return this.crtCivilTiers;
   }

   public void setCrtCivilTiers(String var1) {
      this.crtCivilTiers = var1;
   }

   public String getCrtConditionReg() {
      return this.crtConditionReg;
   }

   public void setCrtConditionReg(String var1) {
      this.crtConditionReg = var1;
   }

   public Date getCrtDate() {
      return this.crtDate;
   }

   public void setCrtDate(Date var1) {
      this.crtDate = var1;
   }

   public Date getCrtDateCreat() {
      return this.crtDateCreat;
   }

   public void setCrtDateCreat(Date var1) {
      this.crtDateCreat = var1;
   }

   public Date getCrtDateDebut() {
      return this.crtDateDebut;
   }

   public void setCrtDateDebut(Date var1) {
      this.crtDateDebut = var1;
   }

   public Date getCrtDateFin() {
      return this.crtDateFin;
   }

   public void setCrtDateFin(Date var1) {
      this.crtDateFin = var1;
   }

   public Date getCrtDateImp() {
      return this.crtDateImp;
   }

   public void setCrtDateImp(Date var1) {
      this.crtDateImp = var1;
   }

   public Date getCrtDateModif() {
      return this.crtDateModif;
   }

   public void setCrtDateModif(Date var1) {
      this.crtDateModif = var1;
   }

   public Date getCrtDateTransfert() {
      return this.crtDateTransfert;
   }

   public void setCrtDateTransfert(Date var1) {
      this.crtDateTransfert = var1;
   }

   public Date getCrtDateValide() {
      return this.crtDateValide;
   }

   public void setCrtDateValide(Date var1) {
      this.crtDateValide = var1;
   }

   public Date getCrtDateValidite() {
      return this.crtDateValidite;
   }

   public void setCrtDateValidite(Date var1) {
      this.crtDateValidite = var1;
   }

   public Date getCrtDateVisa() {
      return this.crtDateVisa;
   }

   public void setCrtDateVisa(Date var1) {
      this.crtDateVisa = var1;
   }

   public String getCrtDepartement() {
      return this.crtDepartement;
   }

   public void setCrtDepartement(String var1) {
      this.crtDepartement = var1;
   }

   public String getCrtDevise() {
      return this.crtDevise;
   }

   public void setCrtDevise(String var1) {
      this.crtDevise = var1;
   }

   public int getCrtEtat() {
      return this.crtEtat;
   }

   public void setCrtEtat(int var1) {
      this.crtEtat = var1;
   }

   public int getCrtEtatVal() {
      return this.crtEtatVal;
   }

   public void setCrtEtatVal(int var1) {
      this.crtEtatVal = var1;
   }

   public int getCrtExoDouane() {
      return this.crtExoDouane;
   }

   public void setCrtExoDouane(int var1) {
      this.crtExoDouane = var1;
   }

   public int getCrtExoTva() {
      return this.crtExoTva;
   }

   public void setCrtExoTva(int var1) {
      this.crtExoTva = var1;
   }

   public String getCrtFormule1() {
      return this.crtFormule1;
   }

   public void setCrtFormule1(String var1) {
      this.crtFormule1 = var1;
   }

   public String getCrtFormule2() {
      return this.crtFormule2;
   }

   public void setCrtFormule2(String var1) {
      this.crtFormule2 = var1;
   }

   public int getCrtGele() {
      return this.crtGele;
   }

   public void setCrtGele(int var1) {
      this.crtGele = var1;
   }

   public long getCrtId() {
      return this.crtId;
   }

   public void setCrtId(long var1) {
      this.crtId = var1;
   }

   public long getCrtIdCommercial() {
      return this.crtIdCommercial;
   }

   public void setCrtIdCommercial(long var1) {
      this.crtIdCommercial = var1;
   }

   public long getCrtIdContact() {
      return this.crtIdContact;
   }

   public void setCrtIdContact(long var1) {
      this.crtIdContact = var1;
   }

   public long getCrtIdCreateur() {
      return this.crtIdCreateur;
   }

   public void setCrtIdCreateur(long var1) {
      this.crtIdCreateur = var1;
   }

   public long getCrtIdEquipe() {
      return this.crtIdEquipe;
   }

   public void setCrtIdEquipe(long var1) {
      this.crtIdEquipe = var1;
   }

   public long getCrtIdModif() {
      return this.crtIdModif;
   }

   public void setCrtIdModif(long var1) {
      this.crtIdModif = var1;
   }

   public long getCrtIdResponsable() {
      return this.crtIdResponsable;
   }

   public void setCrtIdResponsable(long var1) {
      this.crtIdResponsable = var1;
   }

   public String getCrtInfo1() {
      return this.crtInfo1;
   }

   public void setCrtInfo1(String var1) {
      this.crtInfo1 = var1;
   }

   public String getCrtInfo10() {
      return this.crtInfo10;
   }

   public void setCrtInfo10(String var1) {
      this.crtInfo10 = var1;
   }

   public String getCrtInfo2() {
      return this.crtInfo2;
   }

   public void setCrtInfo2(String var1) {
      this.crtInfo2 = var1;
   }

   public String getCrtInfo3() {
      return this.crtInfo3;
   }

   public void setCrtInfo3(String var1) {
      this.crtInfo3 = var1;
   }

   public String getCrtInfo4() {
      return this.crtInfo4;
   }

   public void setCrtInfo4(String var1) {
      this.crtInfo4 = var1;
   }

   public String getCrtInfo5() {
      return this.crtInfo5;
   }

   public void setCrtInfo5(String var1) {
      this.crtInfo5 = var1;
   }

   public String getCrtInfo6() {
      return this.crtInfo6;
   }

   public void setCrtInfo6(String var1) {
      this.crtInfo6 = var1;
   }

   public String getCrtInfo7() {
      return this.crtInfo7;
   }

   public void setCrtInfo7(String var1) {
      this.crtInfo7 = var1;
   }

   public String getCrtInfo8() {
      return this.crtInfo8;
   }

   public void setCrtInfo8(String var1) {
      this.crtInfo8 = var1;
   }

   public String getCrtInfo9() {
      return this.crtInfo9;
   }

   public void setCrtInfo9(String var1) {
      this.crtInfo9 = var1;
   }

   public int getCrtJour() {
      return this.crtJour;
   }

   public void setCrtJour(int var1) {
      this.crtJour = var1;
   }

   public String getCrtJournalReg() {
      return this.crtJournalReg;
   }

   public void setCrtJournalReg(String var1) {
      this.crtJournalReg = var1;
   }

   public String getCrtModeReg() {
      return this.crtModeReg;
   }

   public void setCrtModeReg(String var1) {
      this.crtModeReg = var1;
   }

   public String getCrtModeleImp() {
      return this.crtModeleImp;
   }

   public void setCrtModeleImp(String var1) {
      this.crtModeleImp = var1;
   }

   public String getCrtMotifExo() {
      return this.crtMotifExo;
   }

   public void setCrtMotifExo(String var1) {
      this.crtMotifExo = var1;
   }

   public int getCrtNbJourReg() {
      return this.crtNbJourReg;
   }

   public void setCrtNbJourReg(int var1) {
      this.crtNbJourReg = var1;
   }

   public String getCrtNomCommercial() {
      return this.crtNomCommercial;
   }

   public void setCrtNomCommercial(String var1) {
      this.crtNomCommercial = var1;
   }

   public String getCrtNomContact() {
      if (this.crtNomContact != null && !this.crtNomContact.isEmpty()) {
         this.crtNomContact = this.crtNomContact.toUpperCase();
      }

      return this.crtNomContact;
   }

   public void setCrtNomContact(String var1) {
      this.crtNomContact = var1;
   }

   public String getCrtNomCreateur() {
      return this.crtNomCreateur;
   }

   public void setCrtNomCreateur(String var1) {
      this.crtNomCreateur = var1;
   }

   public String getCrtNomEquipe() {
      return this.crtNomEquipe;
   }

   public void setCrtNomEquipe(String var1) {
      this.crtNomEquipe = var1;
   }

   public String getCrtNomModif() {
      return this.crtNomModif;
   }

   public void setCrtNomModif(String var1) {
      this.crtNomModif = var1;
   }

   public String getCrtNomResponsable() {
      return this.crtNomResponsable;
   }

   public void setCrtNomResponsable(String var1) {
      this.crtNomResponsable = var1;
   }

   public String getCrtNomTiers() {
      return this.crtNomTiers;
   }

   public void setCrtNomTiers(String var1) {
      this.crtNomTiers = var1;
   }

   public String getCrtNum() {
      return this.crtNum;
   }

   public void setCrtNum(String var1) {
      this.crtNum = var1;
   }

   public String getCrtNumTrf() {
      return this.crtNumTrf;
   }

   public void setCrtNumTrf(String var1) {
      this.crtNumTrf = var1;
   }

   public String getCrtNumVisa() {
      return this.crtNumVisa;
   }

   public void setCrtNumVisa(String var1) {
      this.crtNumVisa = var1;
   }

   public String getCrtObject() {
      return this.crtObject;
   }

   public void setCrtObject(String var1) {
      this.crtObject = var1;
   }

   public String getCrtObservation() {
      return this.crtObservation;
   }

   public void setCrtObservation(String var1) {
      this.crtObservation = var1;
   }

   public String getCrtPdv() {
      return this.crtPdv;
   }

   public void setCrtPdv(String var1) {
      this.crtPdv = var1;
   }

   public int getCrtPeriodicite() {
      return this.crtPeriodicite;
   }

   public void setCrtPeriodicite(int var1) {
      this.crtPeriodicite = var1;
   }

   public String getCrtRangeVisa() {
      return this.crtRangeVisa;
   }

   public void setCrtRangeVisa(String var1) {
      this.crtRangeVisa = var1;
   }

   public String getCrtRegion() {
      return this.crtRegion;
   }

   public void setCrtRegion(String var1) {
      this.crtRegion = var1;
   }

   public String getCrtSecteur() {
      return this.crtSecteur;
   }

   public void setCrtSecteur(String var1) {
      this.crtSecteur = var1;
   }

   public String getCrtSerie() {
      return this.crtSerie;
   }

   public void setCrtSerie(String var1) {
      this.crtSerie = var1;
   }

   public String getCrtService() {
      return this.crtService;
   }

   public void setCrtService(String var1) {
      this.crtService = var1;
   }

   public String getCrtSite() {
      return this.crtSite;
   }

   public void setCrtSite(String var1) {
      this.crtSite = var1;
   }

   public String getCrtSource() {
      return this.crtSource;
   }

   public void setCrtSource(String var1) {
      this.crtSource = var1;
   }

   public int getCrtStock() {
      return this.crtStock;
   }

   public void setCrtStock(int var1) {
      this.crtStock = var1;
   }

   public float getCrtTauxTc() {
      return this.crtTauxTc;
   }

   public void setCrtTauxTc(float var1) {
      this.crtTauxTc = var1;
   }

   public String getCrtText() {
      return this.crtText;
   }

   public void setCrtText(String var1) {
      this.crtText = var1;
   }

   public double getCrtTotHt() {
      return this.crtTotHt;
   }

   public void setCrtTotHt(double var1) {
      this.crtTotHt = var1;
   }

   public double getCrtTotRabais() {
      return this.crtTotRabais;
   }

   public void setCrtTotRabais(double var1) {
      this.crtTotRabais = var1;
   }

   public double getCrtTotRemise() {
      return this.crtTotRemise;
   }

   public void setCrtTotRemise(double var1) {
      this.crtTotRemise = var1;
   }

   public double getCrtTotTc() {
      return this.crtTotTc;
   }

   public void setCrtTotTc(double var1) {
      this.crtTotTc = var1;
   }

   public double getCrtTotTimbre() {
      return this.crtTotTimbre;
   }

   public void setCrtTotTimbre(double var1) {
      this.crtTotTimbre = var1;
   }

   public double getCrtTotTtc() {
      return this.crtTotTtc;
   }

   public void setCrtTotTtc(double var1) {
      this.crtTotTtc = var1;
   }

   public double getCrtTotTva() {
      return this.crtTotTva;
   }

   public void setCrtTotTva(double var1) {
      this.crtTotTva = var1;
   }

   public int getCrtType() {
      return this.crtType;
   }

   public void setCrtType(int var1) {
      this.crtType = var1;
   }

   public int getCrtTypeReg() {
      return this.crtTypeReg;
   }

   public void setCrtTypeReg(int var1) {
      this.crtTypeReg = var1;
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

   public String getCrtDiversNom() {
      return this.crtDiversNom;
   }

   public void setCrtDiversNom(String var1) {
      this.crtDiversNom = var1;
   }

   public float getCrtTauxRemise() {
      return this.crtTauxRemise;
   }

   public void setCrtTauxRemise(float var1) {
      this.crtTauxRemise = var1;
   }

   public String getCrtTiersRegroupe() {
      return this.crtTiersRegroupe;
   }

   public void setCrtTiersRegroupe(String var1) {
      this.crtTiersRegroupe = var1;
   }

   public String getCrtNumCompteur() {
      return this.crtNumCompteur;
   }

   public void setCrtNumCompteur(String var1) {
      this.crtNumCompteur = var1;
   }

   public long getCrtIndexInitial() {
      return this.crtIndexInitial;
   }

   public void setCrtIndexInitial(long var1) {
      this.crtIndexInitial = var1;
   }

   public String getCrtNature() {
      return this.crtNature;
   }

   public void setCrtNature(String var1) {
      this.crtNature = var1;
   }

   public String getCrtAffaire() {
      return this.crtAffaire;
   }

   public void setCrtAffaire(String var1) {
      this.crtAffaire = var1;
   }

   public Date getCrtDateButoire() {
      return this.crtDateButoire;
   }

   public void setCrtDateButoire(Date var1) {
      this.crtDateButoire = var1;
   }

   public Date getCrtDateEnvoie() {
      return this.crtDateEnvoie;
   }

   public void setCrtDateEnvoie(Date var1) {
      this.crtDateEnvoie = var1;
   }

   public Date getCrtDateSigne() {
      return this.crtDateSigne;
   }

   public void setCrtDateSigne(Date var1) {
      this.crtDateSigne = var1;
   }

   public Date getCrtDateLivraisonReel() {
      return this.crtDateLivraisonReel;
   }

   public void setCrtDateLivraisonReel(Date var1) {
      this.crtDateLivraisonReel = var1;
   }

   public Date getCrtDateLivraisonTheo() {
      return this.crtDateLivraisonTheo;
   }

   public void setCrtDateLivraisonTheo(Date var1) {
      this.crtDateLivraisonTheo = var1;
   }

   public int getCrtMode() {
      return this.crtMode;
   }

   public void setCrtMode(int var1) {
      this.crtMode = var1;
   }

   public double getCrtTotApport() {
      return this.crtTotApport;
   }

   public void setCrtTotApport(double var1) {
      this.crtTotApport = var1;
   }

   public double getCrtTotReste() {
      return this.crtTotReste;
   }

   public void setCrtTotReste(double var1) {
      this.crtTotReste = var1;
   }
}
