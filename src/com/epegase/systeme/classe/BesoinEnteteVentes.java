package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BesoinEnteteVentes implements Serializable {
   private long besId;
   private Date besDateCreat;
   private String besNum;
   private long besIdCreateur;
   private String besNomCreateur;
   private Date besDateModif;
   private long besIdModif;
   private String besNomModif;
   private String besNomEquipe;
   private long besIdEquipe;
   private long besIdResponsable;
   private String besNomResponsable;
   private String besNomCommercial;
   private long besIdCommercial;
   private String besNumCampagne;
   private long besIdCampagne;
   private String besNomTiers;
   private String besCivilTiers;
   private long besIdContact;
   private String besNomContact;
   private String besCivilContact;
   private String besSerie;
   private int besExoTva;
   private int besExoDouane;
   private String besJournalReg;
   private String besCat;
   private String besDevise;
   private String besObject;
   private String besObservation;
   private double besTotHt;
   private double besTotRemise;
   private double besTotRabais;
   private double besTotTva;
   private float besTauxTc;
   private double besTotTc;
   private double besTotTtc;
   private double besTotReglement;
   private int besSolde;
   private String besBanque;
   private int besTypeReg;
   private String besModeReg;
   private Date besEcheanceReliquat;
   private String besMotifRejetCredit;
   private int besNbJourReg;
   private int besArrondiReg;
   private String besConditionReg;
   private Date besDateEcheReg;
   private String besActivite;
   private String besSite;
   private String besDepartement;
   private String besService;
   private String besRegion;
   private String besSecteur;
   private String besPdv;
   private String besAnal2;
   private String besAnal4;
   private Date besDateImp;
   private String besModeleImp;
   private int besEtatVal;
   private int besEtat;
   private Date besDateValidite;
   private Date besDateRelance;
   private Date besDateValide;
   private int besPosSignature;
   private Date besDateTransforme;
   private int besTypeTransforme;
   private Date besDateAnnule;
   private String besMotifAnnule;
   private Date besDate;
   private int besDiversTiers;
   private String besDiversNom;
   private String besDiversAdresse;
   private String besDiversVille;
   private String besDiversTel;
   private String besDiversMail;
   private float besPoids;
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

   public String getVar_nom_tiers() {
      if (this.besDiversNom != null && !this.besDiversNom.isEmpty()) {
         this.var_nom_tiers = this.besDiversNom;
      } else if (this.besCivilTiers != null && !this.besCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.besCivilTiers + " " + this.besNomTiers;
      } else {
         this.var_nom_tiers = this.besNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.besDiversNom != null && !this.besDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.besCivilContact != null && !this.besCivilContact.isEmpty()) {
         this.var_nomContact = this.besCivilContact + " " + this.besNomContact;
      } else {
         this.var_nomContact = this.besNomContact;
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public double getVarTotTtcGlob() {
      this.varTotTtcGlob = this.besTotTtc + this.besTotTc;
      return this.varTotTtcGlob;
   }

   public void setVarTotTtcGlob(double var1) {
      this.varTotTtcGlob = var1;
   }

   public String getVar_solde() {
      if (this.besSolde == 1) {
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
      if (this.besEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.besEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.besEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.besEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.besEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.besEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public int getVar_format_devise() {
      if (!this.besDevise.equals("XOF") && !this.besDevise.equals("XAF")) {
         if (!this.besDevise.equals("EUR") && !this.besDevise.equals("XEU") && !this.besDevise.equals("CHF")) {
            this.var_format_devise = 0;
         } else {
            this.var_format_devise = 1;
         }
      } else {
         this.var_format_devise = 2;
      }

      return this.var_format_devise;
   }

   public double getVar_reliquat() {
      this.var_reliquat = this.besTotTtc - this.besTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public String getBesActivite() {
      return this.besActivite;
   }

   public void setBesActivite(String var1) {
      this.besActivite = var1;
   }

   public String getBesAnal2() {
      return this.besAnal2;
   }

   public void setBesAnal2(String var1) {
      this.besAnal2 = var1;
   }

   public String getBesAnal4() {
      return this.besAnal4;
   }

   public void setBesAnal4(String var1) {
      this.besAnal4 = var1;
   }

   public int getBesArrondiReg() {
      return this.besArrondiReg;
   }

   public void setBesArrondiReg(int var1) {
      this.besArrondiReg = var1;
   }

   public String getBesBanque() {
      return this.besBanque;
   }

   public void setBesBanque(String var1) {
      this.besBanque = var1;
   }

   public String getBesCat() {
      return this.besCat;
   }

   public void setBesCat(String var1) {
      this.besCat = var1;
   }

   public String getBesCivilContact() {
      return this.besCivilContact;
   }

   public void setBesCivilContact(String var1) {
      this.besCivilContact = var1;
   }

   public String getBesCivilTiers() {
      return this.besCivilTiers;
   }

   public void setBesCivilTiers(String var1) {
      this.besCivilTiers = var1;
   }

   public String getBesConditionReg() {
      return this.besConditionReg;
   }

   public void setBesConditionReg(String var1) {
      this.besConditionReg = var1;
   }

   public Date getBesDate() {
      return this.besDate;
   }

   public void setBesDate(Date var1) {
      this.besDate = var1;
   }

   public Date getBesDateAnnule() {
      return this.besDateAnnule;
   }

   public void setBesDateAnnule(Date var1) {
      this.besDateAnnule = var1;
   }

   public Date getBesDateCreat() {
      return this.besDateCreat;
   }

   public void setBesDateCreat(Date var1) {
      this.besDateCreat = var1;
   }

   public Date getBesDateEcheReg() {
      return this.besDateEcheReg;
   }

   public void setBesDateEcheReg(Date var1) {
      this.besDateEcheReg = var1;
   }

   public Date getBesDateImp() {
      return this.besDateImp;
   }

   public void setBesDateImp(Date var1) {
      this.besDateImp = var1;
   }

   public Date getBesDateModif() {
      return this.besDateModif;
   }

   public void setBesDateModif(Date var1) {
      this.besDateModif = var1;
   }

   public Date getBesDateRelance() {
      return this.besDateRelance;
   }

   public void setBesDateRelance(Date var1) {
      this.besDateRelance = var1;
   }

   public Date getBesDateTransforme() {
      return this.besDateTransforme;
   }

   public void setBesDateTransforme(Date var1) {
      this.besDateTransforme = var1;
   }

   public Date getBesDateValide() {
      return this.besDateValide;
   }

   public void setBesDateValide(Date var1) {
      this.besDateValide = var1;
   }

   public Date getBesDateValidite() {
      return this.besDateValidite;
   }

   public void setBesDateValidite(Date var1) {
      this.besDateValidite = var1;
   }

   public String getBesDepartement() {
      return this.besDepartement;
   }

   public void setBesDepartement(String var1) {
      this.besDepartement = var1;
   }

   public String getBesDevise() {
      return this.besDevise;
   }

   public void setBesDevise(String var1) {
      this.besDevise = var1;
   }

   public String getBesDiversAdresse() {
      return this.besDiversAdresse;
   }

   public void setBesDiversAdresse(String var1) {
      this.besDiversAdresse = var1;
   }

   public String getBesDiversMail() {
      return this.besDiversMail;
   }

   public void setBesDiversMail(String var1) {
      this.besDiversMail = var1;
   }

   public String getBesDiversNom() {
      return this.besDiversNom;
   }

   public void setBesDiversNom(String var1) {
      this.besDiversNom = var1;
   }

   public String getBesDiversTel() {
      return this.besDiversTel;
   }

   public void setBesDiversTel(String var1) {
      this.besDiversTel = var1;
   }

   public int getBesDiversTiers() {
      return this.besDiversTiers;
   }

   public void setBesDiversTiers(int var1) {
      this.besDiversTiers = var1;
   }

   public String getBesDiversVille() {
      return this.besDiversVille;
   }

   public void setBesDiversVille(String var1) {
      this.besDiversVille = var1;
   }

   public Date getBesEcheanceReliquat() {
      return this.besEcheanceReliquat;
   }

   public void setBesEcheanceReliquat(Date var1) {
      this.besEcheanceReliquat = var1;
   }

   public int getBesEtat() {
      return this.besEtat;
   }

   public void setBesEtat(int var1) {
      this.besEtat = var1;
   }

   public int getBesEtatVal() {
      return this.besEtatVal;
   }

   public void setBesEtatVal(int var1) {
      this.besEtatVal = var1;
   }

   public int getBesExoDouane() {
      return this.besExoDouane;
   }

   public void setBesExoDouane(int var1) {
      this.besExoDouane = var1;
   }

   public int getBesExoTva() {
      return this.besExoTva;
   }

   public void setBesExoTva(int var1) {
      this.besExoTva = var1;
   }

   public long getBesId() {
      return this.besId;
   }

   public void setBesId(long var1) {
      this.besId = var1;
   }

   public long getBesIdContact() {
      return this.besIdContact;
   }

   public void setBesIdContact(long var1) {
      this.besIdContact = var1;
   }

   public long getBesIdCreateur() {
      return this.besIdCreateur;
   }

   public void setBesIdCreateur(long var1) {
      this.besIdCreateur = var1;
   }

   public long getBesIdModif() {
      return this.besIdModif;
   }

   public void setBesIdModif(long var1) {
      this.besIdModif = var1;
   }

   public long getBesIdResponsable() {
      return this.besIdResponsable;
   }

   public void setBesIdResponsable(long var1) {
      this.besIdResponsable = var1;
   }

   public String getBesJournalReg() {
      return this.besJournalReg;
   }

   public void setBesJournalReg(String var1) {
      this.besJournalReg = var1;
   }

   public String getBesModeReg() {
      return this.besModeReg;
   }

   public void setBesModeReg(String var1) {
      this.besModeReg = var1;
   }

   public String getBesModeleImp() {
      return this.besModeleImp;
   }

   public void setBesModeleImp(String var1) {
      this.besModeleImp = var1;
   }

   public String getBesMotifAnnule() {
      return this.besMotifAnnule;
   }

   public void setBesMotifAnnule(String var1) {
      this.besMotifAnnule = var1;
   }

   public String getBesMotifRejetCredit() {
      return this.besMotifRejetCredit;
   }

   public void setBesMotifRejetCredit(String var1) {
      this.besMotifRejetCredit = var1;
   }

   public int getBesNbJourReg() {
      return this.besNbJourReg;
   }

   public void setBesNbJourReg(int var1) {
      this.besNbJourReg = var1;
   }

   public String getBesNomContact() {
      return this.besNomContact;
   }

   public void setBesNomContact(String var1) {
      this.besNomContact = var1;
   }

   public String getBesNomCreateur() {
      return this.besNomCreateur;
   }

   public void setBesNomCreateur(String var1) {
      this.besNomCreateur = var1;
   }

   public String getBesNomModif() {
      return this.besNomModif;
   }

   public void setBesNomModif(String var1) {
      this.besNomModif = var1;
   }

   public String getBesNomResponsable() {
      return this.besNomResponsable;
   }

   public void setBesNomResponsable(String var1) {
      this.besNomResponsable = var1;
   }

   public String getBesNomTiers() {
      return this.besNomTiers;
   }

   public void setBesNomTiers(String var1) {
      this.besNomTiers = var1;
   }

   public String getBesNum() {
      return this.besNum;
   }

   public void setBesNum(String var1) {
      this.besNum = var1;
   }

   public String getBesObject() {
      return this.besObject;
   }

   public void setBesObject(String var1) {
      this.besObject = var1;
   }

   public String getBesObservation() {
      return this.besObservation;
   }

   public void setBesObservation(String var1) {
      this.besObservation = var1;
   }

   public String getBesPdv() {
      return this.besPdv;
   }

   public void setBesPdv(String var1) {
      this.besPdv = var1;
   }

   public String getBesRegion() {
      return this.besRegion;
   }

   public void setBesRegion(String var1) {
      this.besRegion = var1;
   }

   public String getBesSecteur() {
      return this.besSecteur;
   }

   public void setBesSecteur(String var1) {
      this.besSecteur = var1;
   }

   public String getBesSerie() {
      return this.besSerie;
   }

   public void setBesSerie(String var1) {
      this.besSerie = var1;
   }

   public String getBesService() {
      return this.besService;
   }

   public void setBesService(String var1) {
      this.besService = var1;
   }

   public String getBesSite() {
      return this.besSite;
   }

   public void setBesSite(String var1) {
      this.besSite = var1;
   }

   public int getBesSolde() {
      return this.besSolde;
   }

   public void setBesSolde(int var1) {
      this.besSolde = var1;
   }

   public float getBesTauxTc() {
      return this.besTauxTc;
   }

   public void setBesTauxTc(float var1) {
      this.besTauxTc = var1;
   }

   public double getBesTotHt() {
      return this.besTotHt;
   }

   public void setBesTotHt(double var1) {
      this.besTotHt = var1;
   }

   public double getBesTotRabais() {
      return this.besTotRabais;
   }

   public void setBesTotRabais(double var1) {
      this.besTotRabais = var1;
   }

   public double getBesTotReglement() {
      return this.besTotReglement;
   }

   public void setBesTotReglement(double var1) {
      this.besTotReglement = var1;
   }

   public double getBesTotRemise() {
      return this.besTotRemise;
   }

   public void setBesTotRemise(double var1) {
      this.besTotRemise = var1;
   }

   public double getBesTotTc() {
      return this.besTotTc;
   }

   public void setBesTotTc(double var1) {
      this.besTotTc = var1;
   }

   public double getBesTotTtc() {
      return this.besTotTtc;
   }

   public void setBesTotTtc(double var1) {
      this.besTotTtc = var1;
   }

   public double getBesTotTva() {
      return this.besTotTva;
   }

   public void setBesTotTva(double var1) {
      this.besTotTva = var1;
   }

   public int getBesTypeReg() {
      return this.besTypeReg;
   }

   public void setBesTypeReg(int var1) {
      this.besTypeReg = var1;
   }

   public int getBesTypeTransforme() {
      return this.besTypeTransforme;
   }

   public void setBesTypeTransforme(int var1) {
      this.besTypeTransforme = var1;
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

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public long getBesIdCommercial() {
      return this.besIdCommercial;
   }

   public void setBesIdCommercial(long var1) {
      this.besIdCommercial = var1;
   }

   public String getBesNomCommercial() {
      return this.besNomCommercial;
   }

   public void setBesNomCommercial(String var1) {
      this.besNomCommercial = var1;
   }

   public long getBesIdCampagne() {
      return this.besIdCampagne;
   }

   public void setBesIdCampagne(long var1) {
      this.besIdCampagne = var1;
   }

   public String getBesNumCampagne() {
      return this.besNumCampagne;
   }

   public void setBesNumCampagne(String var1) {
      this.besNumCampagne = var1;
   }

   public long getBesIdEquipe() {
      return this.besIdEquipe;
   }

   public void setBesIdEquipe(long var1) {
      this.besIdEquipe = var1;
   }

   public String getBesNomEquipe() {
      return this.besNomEquipe;
   }

   public void setBesNomEquipe(String var1) {
      this.besNomEquipe = var1;
   }

   public int getBesPosSignature() {
      return this.besPosSignature;
   }

   public void setBesPosSignature(int var1) {
      this.besPosSignature = var1;
   }

   public float getBesPoids() {
      return this.besPoids;
   }

   public void setBesPoids(float var1) {
      this.besPoids = var1;
   }
}
