package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FondationDemande implements Serializable {
   private long fondemId;
   private Date fondemDateCreat;
   private String fondemNum;
   private long fondemIdCreateur;
   private String fondemNomCreateur;
   private Date fondemDateModif;
   private long fondemIdModif;
   private String fondemNomModif;
   private String fondemNomEquipe;
   private long fondemIdEquipe;
   private long fondemIdResponsable;
   private String fondemNomResponsable;
   private String fondemNomCommercial;
   private long fondemIdCommercial;
   private String fondemNomTiers;
   private String fondemCivilTiers;
   private String fondemTiersRegroupe;
   private long fondemIdContact;
   private String fondemNomContact;
   private String fondemCivilContact;
   private String fondemSerie;
   private int fondemExoTva;
   private int fondemType;
   private int fondemSuivi;
   private int fondemExoDouane;
   private String fondemJournalReg;
   private String fondemCat;
   private String fondemDevise;
   private String fondemObject;
   private String fondemDescription;
   private String fondemObservation;
   private String fondemValidation;
   private float fondemTauxRemise;
   private double fondemTotDemande;
   private double fondemTotRemise;
   private double fondemTotRabais;
   private double fondemTotAccorde;
   private float fondemTauxTc;
   private double fondemTotTc;
   private double fondemTotDebloque;
   private double fondemTotReglement;
   private int fondemSolde;
   private String fondemBanque;
   private int fondemTypeReg;
   private String fondemModeReg;
   private Date fondemEcheanceReliquat;
   private String fondemMotifRejetCredit;
   private int fondemNbJourReg;
   private int fondemArrondiReg;
   private String fondemConditionReg;
   private Date fondemDateEcheReg;
   private String fondemActivite;
   private String fondemSite;
   private String fondemDepartement;
   private String fondemService;
   private String fondemRegion;
   private String fondemSecteur;
   private String fondemPdv;
   private String fondemAnal2;
   private String fondemAnal4;
   private String fondemInfo1;
   private String fondemInfo2;
   private String fondemInfo3;
   private String fondemInfo4;
   private String fondemInfo5;
   private String fondemInfo6;
   private String fondemInfo7;
   private String fondemInfo8;
   private String fondemInfo9;
   private String fondemInfo10;
   private String fondemFormule1;
   private String fondemFormule2;
   private String fondemAnnexe1;
   private String fondemAnnexe2;
   private String fondemContrat;
   private Date fondemDateImp;
   private String fondemModeleImp;
   private String fondemGarde;
   private int fondemEtatVal;
   private int fondemGele;
   private int fondemEtat;
   private Date fondemDateValidite;
   private Date fondemDateRelance;
   private Date fondemDateValide;
   private int fondemPosSignature;
   private Date fondemDateTransforme;
   private int fondemTypeTransforme;
   private Date fondemDateAnnule;
   private String fondemMotifAnnule;
   private Date fondemDate;
   private String fondemFactorNom;
   private long fondemFactorId;
   private int fondemFactorEtat;
   private int fondemDiversTiers;
   private String fondemDiversNom;
   private String fondemDiversAdresse;
   private String fondemDiversVille;
   private String fondemDiversTel;
   private String fondemDiversMail;
   private String fondemSource;
   private int fondemModeConclusion;
   private String fondemConclusion;
   private Date fondemDateRelance1;
   private String fondemConclusion1;
   private Date fondemDateARelance1;
   private long fondemUserRelance1;
   private Date fondemDateRelance2;
   private String fondemConclusion2;
   private Date fondemDateARelance2;
   private long fondemUserRelance2;
   private Date fondemDateRelance3;
   private String fondemConclusion3;
   private Date fondemDateARelance3;
   private long fondemUserRelance3;
   private ExercicesVentes exerciceventes;
   private Tiers tiers;
   private Users users;
   private String montantLettre;
   private String libelleEta;
   private String var_solde;
   private double var_reliquat;
   private boolean var_select_ligne;
   private int var_format_devise;
   private String var_nomContact;
   private String var_nom_tiers;
   private String devisVip;
   private String libelleType;

   public String getLibelleType() {
      if (this.fondemType == 0) {
         this.libelleType = "Parrainage";
      } else if (this.fondemType == 1) {
         this.libelleType = "Administratif";
      } else if (this.fondemType == 2) {
         this.libelleType = "Juridique";
      } else if (this.fondemType == 3) {
         this.libelleType = "Soins médicaux";
      } else if (this.fondemType == 4) {
         this.libelleType = "Scolarité";
      } else if (this.fondemType == 5) {
         this.libelleType = "Formation";
      } else if (this.fondemType == 6) {
         this.libelleType = "Logement";
      } else if (this.fondemType == 7) {
         this.libelleType = "Alimentation";
      } else if (this.fondemType == 9) {
         this.libelleType = "Autre";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getDevisVip() {
      if (this.fondemSuivi == 1) {
         this.devisVip = "color:blue";
      } else {
         this.devisVip = "color:black";
      }

      return this.devisVip;
   }

   public void setDevisVip(String var1) {
      this.devisVip = var1;
   }

   public String getMontantLettre() {
      return this.montantLettre;
   }

   public void setMontantLettre(String var1) {
      this.montantLettre = var1;
   }

   public String getVar_nom_tiers() {
      if (this.fondemDiversNom != null && !this.fondemDiversNom.isEmpty()) {
         this.var_nom_tiers = this.fondemDiversNom;
      } else if (this.fondemCivilTiers != null && !this.fondemCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.fondemCivilTiers + " " + this.fondemNomTiers;
      } else {
         this.var_nom_tiers = this.fondemNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.fondemDiversNom != null && !this.fondemDiversNom.isEmpty()) {
         this.var_nomContact = "(client divers)";
      } else if (this.fondemCivilContact != null && !this.fondemCivilContact.isEmpty()) {
         if (this.fondemNomContact != null && !this.fondemNomContact.isEmpty()) {
            this.var_nomContact = this.fondemCivilContact + " " + this.fondemNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.fondemNomContact != null && !this.fondemNomContact.isEmpty()) {
         this.var_nomContact = this.fondemNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getVar_solde() {
      if (this.fondemSolde == 1) {
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
      if (this.fondemEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.fondemEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.fondemEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.fondemEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.fondemEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.fondemEtat == 5) {
         this.libelleEta = "Trf.T.";
      } else if (this.fondemEtat == 6) {
         this.libelleEta = "ATT";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public int getVar_format_devise() {
      if (!this.fondemDevise.equals("XOF") && !this.fondemDevise.equals("XAF")) {
         if (!this.fondemDevise.equals("EUR") && !this.fondemDevise.equals("XEU") && !this.fondemDevise.equals("CHF")) {
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
      this.var_reliquat = this.fondemTotAccorde - this.fondemTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public void setVar_format_devise(int var1) {
      this.var_format_devise = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
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

   public String getFondemActivite() {
      return this.fondemActivite;
   }

   public void setFondemActivite(String var1) {
      this.fondemActivite = var1;
   }

   public String getFondemAnal2() {
      return this.fondemAnal2;
   }

   public void setFondemAnal2(String var1) {
      this.fondemAnal2 = var1;
   }

   public String getFondemAnal4() {
      return this.fondemAnal4;
   }

   public void setFondemAnal4(String var1) {
      this.fondemAnal4 = var1;
   }

   public String getFondemAnnexe1() {
      return this.fondemAnnexe1;
   }

   public void setFondemAnnexe1(String var1) {
      this.fondemAnnexe1 = var1;
   }

   public String getFondemAnnexe2() {
      return this.fondemAnnexe2;
   }

   public void setFondemAnnexe2(String var1) {
      this.fondemAnnexe2 = var1;
   }

   public int getFondemArrondiReg() {
      return this.fondemArrondiReg;
   }

   public void setFondemArrondiReg(int var1) {
      this.fondemArrondiReg = var1;
   }

   public String getFondemBanque() {
      return this.fondemBanque;
   }

   public void setFondemBanque(String var1) {
      this.fondemBanque = var1;
   }

   public String getFondemCat() {
      return this.fondemCat;
   }

   public void setFondemCat(String var1) {
      this.fondemCat = var1;
   }

   public String getFondemCivilContact() {
      return this.fondemCivilContact;
   }

   public void setFondemCivilContact(String var1) {
      this.fondemCivilContact = var1;
   }

   public String getFondemCivilTiers() {
      return this.fondemCivilTiers;
   }

   public void setFondemCivilTiers(String var1) {
      this.fondemCivilTiers = var1;
   }

   public String getFondemConclusion() {
      return this.fondemConclusion;
   }

   public void setFondemConclusion(String var1) {
      this.fondemConclusion = var1;
   }

   public String getFondemConclusion1() {
      return this.fondemConclusion1;
   }

   public void setFondemConclusion1(String var1) {
      this.fondemConclusion1 = var1;
   }

   public String getFondemConclusion2() {
      return this.fondemConclusion2;
   }

   public void setFondemConclusion2(String var1) {
      this.fondemConclusion2 = var1;
   }

   public String getFondemConclusion3() {
      return this.fondemConclusion3;
   }

   public void setFondemConclusion3(String var1) {
      this.fondemConclusion3 = var1;
   }

   public String getFondemConditionReg() {
      return this.fondemConditionReg;
   }

   public void setFondemConditionReg(String var1) {
      this.fondemConditionReg = var1;
   }

   public String getFondemContrat() {
      return this.fondemContrat;
   }

   public void setFondemContrat(String var1) {
      this.fondemContrat = var1;
   }

   public Date getFondemDate() {
      return this.fondemDate;
   }

   public void setFondemDate(Date var1) {
      this.fondemDate = var1;
   }

   public Date getFondemDateARelance1() {
      return this.fondemDateARelance1;
   }

   public void setFondemDateARelance1(Date var1) {
      this.fondemDateARelance1 = var1;
   }

   public Date getFondemDateARelance2() {
      return this.fondemDateARelance2;
   }

   public void setFondemDateARelance2(Date var1) {
      this.fondemDateARelance2 = var1;
   }

   public Date getFondemDateARelance3() {
      return this.fondemDateARelance3;
   }

   public void setFondemDateARelance3(Date var1) {
      this.fondemDateARelance3 = var1;
   }

   public Date getFondemDateAnnule() {
      return this.fondemDateAnnule;
   }

   public void setFondemDateAnnule(Date var1) {
      this.fondemDateAnnule = var1;
   }

   public Date getFondemDateCreat() {
      return this.fondemDateCreat;
   }

   public void setFondemDateCreat(Date var1) {
      this.fondemDateCreat = var1;
   }

   public Date getFondemDateEcheReg() {
      return this.fondemDateEcheReg;
   }

   public void setFondemDateEcheReg(Date var1) {
      this.fondemDateEcheReg = var1;
   }

   public Date getFondemDateImp() {
      return this.fondemDateImp;
   }

   public void setFondemDateImp(Date var1) {
      this.fondemDateImp = var1;
   }

   public Date getFondemDateModif() {
      return this.fondemDateModif;
   }

   public void setFondemDateModif(Date var1) {
      this.fondemDateModif = var1;
   }

   public Date getFondemDateRelance() {
      return this.fondemDateRelance;
   }

   public void setFondemDateRelance(Date var1) {
      this.fondemDateRelance = var1;
   }

   public Date getFondemDateRelance1() {
      return this.fondemDateRelance1;
   }

   public void setFondemDateRelance1(Date var1) {
      this.fondemDateRelance1 = var1;
   }

   public Date getFondemDateRelance2() {
      return this.fondemDateRelance2;
   }

   public void setFondemDateRelance2(Date var1) {
      this.fondemDateRelance2 = var1;
   }

   public Date getFondemDateRelance3() {
      return this.fondemDateRelance3;
   }

   public void setFondemDateRelance3(Date var1) {
      this.fondemDateRelance3 = var1;
   }

   public Date getFondemDateTransforme() {
      return this.fondemDateTransforme;
   }

   public void setFondemDateTransforme(Date var1) {
      this.fondemDateTransforme = var1;
   }

   public Date getFondemDateValide() {
      return this.fondemDateValide;
   }

   public void setFondemDateValide(Date var1) {
      this.fondemDateValide = var1;
   }

   public Date getFondemDateValidite() {
      return this.fondemDateValidite;
   }

   public void setFondemDateValidite(Date var1) {
      this.fondemDateValidite = var1;
   }

   public String getFondemDepartement() {
      return this.fondemDepartement;
   }

   public void setFondemDepartement(String var1) {
      this.fondemDepartement = var1;
   }

   public String getFondemDevise() {
      return this.fondemDevise;
   }

   public void setFondemDevise(String var1) {
      this.fondemDevise = var1;
   }

   public String getFondemDiversAdresse() {
      return this.fondemDiversAdresse;
   }

   public void setFondemDiversAdresse(String var1) {
      this.fondemDiversAdresse = var1;
   }

   public String getFondemDiversMail() {
      return this.fondemDiversMail;
   }

   public void setFondemDiversMail(String var1) {
      this.fondemDiversMail = var1;
   }

   public String getFondemDiversNom() {
      return this.fondemDiversNom;
   }

   public void setFondemDiversNom(String var1) {
      this.fondemDiversNom = var1;
   }

   public String getFondemDiversTel() {
      return this.fondemDiversTel;
   }

   public void setFondemDiversTel(String var1) {
      this.fondemDiversTel = var1;
   }

   public int getFondemDiversTiers() {
      return this.fondemDiversTiers;
   }

   public void setFondemDiversTiers(int var1) {
      this.fondemDiversTiers = var1;
   }

   public String getFondemDiversVille() {
      return this.fondemDiversVille;
   }

   public void setFondemDiversVille(String var1) {
      this.fondemDiversVille = var1;
   }

   public Date getFondemEcheanceReliquat() {
      return this.fondemEcheanceReliquat;
   }

   public void setFondemEcheanceReliquat(Date var1) {
      this.fondemEcheanceReliquat = var1;
   }

   public int getFondemEtat() {
      return this.fondemEtat;
   }

   public void setFondemEtat(int var1) {
      this.fondemEtat = var1;
   }

   public int getFondemEtatVal() {
      return this.fondemEtatVal;
   }

   public void setFondemEtatVal(int var1) {
      this.fondemEtatVal = var1;
   }

   public int getFondemExoDouane() {
      return this.fondemExoDouane;
   }

   public void setFondemExoDouane(int var1) {
      this.fondemExoDouane = var1;
   }

   public int getFondemExoTva() {
      return this.fondemExoTva;
   }

   public void setFondemExoTva(int var1) {
      this.fondemExoTva = var1;
   }

   public int getFondemFactorEtat() {
      return this.fondemFactorEtat;
   }

   public void setFondemFactorEtat(int var1) {
      this.fondemFactorEtat = var1;
   }

   public long getFondemFactorId() {
      return this.fondemFactorId;
   }

   public void setFondemFactorId(long var1) {
      this.fondemFactorId = var1;
   }

   public String getFondemFactorNom() {
      return this.fondemFactorNom;
   }

   public void setFondemFactorNom(String var1) {
      this.fondemFactorNom = var1;
   }

   public String getFondemFormule1() {
      return this.fondemFormule1;
   }

   public void setFondemFormule1(String var1) {
      this.fondemFormule1 = var1;
   }

   public String getFondemFormule2() {
      return this.fondemFormule2;
   }

   public void setFondemFormule2(String var1) {
      this.fondemFormule2 = var1;
   }

   public String getFondemGarde() {
      return this.fondemGarde;
   }

   public void setFondemGarde(String var1) {
      this.fondemGarde = var1;
   }

   public int getFondemGele() {
      return this.fondemGele;
   }

   public void setFondemGele(int var1) {
      this.fondemGele = var1;
   }

   public long getFondemId() {
      return this.fondemId;
   }

   public void setFondemId(long var1) {
      this.fondemId = var1;
   }

   public long getFondemIdCommercial() {
      return this.fondemIdCommercial;
   }

   public void setFondemIdCommercial(long var1) {
      this.fondemIdCommercial = var1;
   }

   public long getFondemIdContact() {
      return this.fondemIdContact;
   }

   public void setFondemIdContact(long var1) {
      this.fondemIdContact = var1;
   }

   public long getFondemIdCreateur() {
      return this.fondemIdCreateur;
   }

   public void setFondemIdCreateur(long var1) {
      this.fondemIdCreateur = var1;
   }

   public long getFondemIdEquipe() {
      return this.fondemIdEquipe;
   }

   public void setFondemIdEquipe(long var1) {
      this.fondemIdEquipe = var1;
   }

   public long getFondemIdModif() {
      return this.fondemIdModif;
   }

   public void setFondemIdModif(long var1) {
      this.fondemIdModif = var1;
   }

   public long getFondemIdResponsable() {
      return this.fondemIdResponsable;
   }

   public void setFondemIdResponsable(long var1) {
      this.fondemIdResponsable = var1;
   }

   public String getFondemInfo1() {
      return this.fondemInfo1;
   }

   public void setFondemInfo1(String var1) {
      this.fondemInfo1 = var1;
   }

   public String getFondemInfo10() {
      return this.fondemInfo10;
   }

   public void setFondemInfo10(String var1) {
      this.fondemInfo10 = var1;
   }

   public String getFondemInfo2() {
      return this.fondemInfo2;
   }

   public void setFondemInfo2(String var1) {
      this.fondemInfo2 = var1;
   }

   public String getFondemInfo3() {
      return this.fondemInfo3;
   }

   public void setFondemInfo3(String var1) {
      this.fondemInfo3 = var1;
   }

   public String getFondemInfo4() {
      return this.fondemInfo4;
   }

   public void setFondemInfo4(String var1) {
      this.fondemInfo4 = var1;
   }

   public String getFondemInfo5() {
      return this.fondemInfo5;
   }

   public void setFondemInfo5(String var1) {
      this.fondemInfo5 = var1;
   }

   public String getFondemInfo6() {
      return this.fondemInfo6;
   }

   public void setFondemInfo6(String var1) {
      this.fondemInfo6 = var1;
   }

   public String getFondemInfo7() {
      return this.fondemInfo7;
   }

   public void setFondemInfo7(String var1) {
      this.fondemInfo7 = var1;
   }

   public String getFondemInfo8() {
      return this.fondemInfo8;
   }

   public void setFondemInfo8(String var1) {
      this.fondemInfo8 = var1;
   }

   public String getFondemInfo9() {
      return this.fondemInfo9;
   }

   public void setFondemInfo9(String var1) {
      this.fondemInfo9 = var1;
   }

   public String getFondemJournalReg() {
      return this.fondemJournalReg;
   }

   public void setFondemJournalReg(String var1) {
      this.fondemJournalReg = var1;
   }

   public int getFondemModeConclusion() {
      return this.fondemModeConclusion;
   }

   public void setFondemModeConclusion(int var1) {
      this.fondemModeConclusion = var1;
   }

   public String getFondemModeReg() {
      return this.fondemModeReg;
   }

   public void setFondemModeReg(String var1) {
      this.fondemModeReg = var1;
   }

   public String getFondemModeleImp() {
      return this.fondemModeleImp;
   }

   public void setFondemModeleImp(String var1) {
      this.fondemModeleImp = var1;
   }

   public String getFondemMotifAnnule() {
      return this.fondemMotifAnnule;
   }

   public void setFondemMotifAnnule(String var1) {
      this.fondemMotifAnnule = var1;
   }

   public String getFondemMotifRejetCredit() {
      return this.fondemMotifRejetCredit;
   }

   public void setFondemMotifRejetCredit(String var1) {
      this.fondemMotifRejetCredit = var1;
   }

   public int getFondemNbJourReg() {
      return this.fondemNbJourReg;
   }

   public void setFondemNbJourReg(int var1) {
      this.fondemNbJourReg = var1;
   }

   public String getFondemNomCommercial() {
      return this.fondemNomCommercial;
   }

   public void setFondemNomCommercial(String var1) {
      this.fondemNomCommercial = var1;
   }

   public String getFondemNomContact() {
      return this.fondemNomContact;
   }

   public void setFondemNomContact(String var1) {
      this.fondemNomContact = var1;
   }

   public String getFondemNomCreateur() {
      return this.fondemNomCreateur;
   }

   public void setFondemNomCreateur(String var1) {
      this.fondemNomCreateur = var1;
   }

   public String getFondemNomEquipe() {
      return this.fondemNomEquipe;
   }

   public void setFondemNomEquipe(String var1) {
      this.fondemNomEquipe = var1;
   }

   public String getFondemNomModif() {
      return this.fondemNomModif;
   }

   public void setFondemNomModif(String var1) {
      this.fondemNomModif = var1;
   }

   public String getFondemNomResponsable() {
      return this.fondemNomResponsable;
   }

   public void setFondemNomResponsable(String var1) {
      this.fondemNomResponsable = var1;
   }

   public String getFondemNomTiers() {
      return this.fondemNomTiers;
   }

   public void setFondemNomTiers(String var1) {
      this.fondemNomTiers = var1;
   }

   public String getFondemNum() {
      return this.fondemNum;
   }

   public void setFondemNum(String var1) {
      this.fondemNum = var1;
   }

   public String getFondemObject() {
      return this.fondemObject;
   }

   public void setFondemObject(String var1) {
      this.fondemObject = var1;
   }

   public String getFondemObservation() {
      return this.fondemObservation;
   }

   public void setFondemObservation(String var1) {
      this.fondemObservation = var1;
   }

   public String getFondemPdv() {
      return this.fondemPdv;
   }

   public void setFondemPdv(String var1) {
      this.fondemPdv = var1;
   }

   public int getFondemPosSignature() {
      return this.fondemPosSignature;
   }

   public void setFondemPosSignature(int var1) {
      this.fondemPosSignature = var1;
   }

   public String getFondemRegion() {
      return this.fondemRegion;
   }

   public void setFondemRegion(String var1) {
      this.fondemRegion = var1;
   }

   public String getFondemSecteur() {
      return this.fondemSecteur;
   }

   public void setFondemSecteur(String var1) {
      this.fondemSecteur = var1;
   }

   public String getFondemSerie() {
      return this.fondemSerie;
   }

   public void setFondemSerie(String var1) {
      this.fondemSerie = var1;
   }

   public String getFondemService() {
      return this.fondemService;
   }

   public void setFondemService(String var1) {
      this.fondemService = var1;
   }

   public String getFondemSite() {
      return this.fondemSite;
   }

   public void setFondemSite(String var1) {
      this.fondemSite = var1;
   }

   public int getFondemSolde() {
      return this.fondemSolde;
   }

   public void setFondemSolde(int var1) {
      this.fondemSolde = var1;
   }

   public String getFondemSource() {
      return this.fondemSource;
   }

   public void setFondemSource(String var1) {
      this.fondemSource = var1;
   }

   public int getFondemSuivi() {
      return this.fondemSuivi;
   }

   public void setFondemSuivi(int var1) {
      this.fondemSuivi = var1;
   }

   public float getFondemTauxRemise() {
      return this.fondemTauxRemise;
   }

   public void setFondemTauxRemise(float var1) {
      this.fondemTauxRemise = var1;
   }

   public float getFondemTauxTc() {
      return this.fondemTauxTc;
   }

   public void setFondemTauxTc(float var1) {
      this.fondemTauxTc = var1;
   }

   public String getFondemTiersRegroupe() {
      return this.fondemTiersRegroupe;
   }

   public void setFondemTiersRegroupe(String var1) {
      this.fondemTiersRegroupe = var1;
   }

   public double getFondemTotRabais() {
      return this.fondemTotRabais;
   }

   public void setFondemTotRabais(double var1) {
      this.fondemTotRabais = var1;
   }

   public double getFondemTotReglement() {
      return this.fondemTotReglement;
   }

   public void setFondemTotReglement(double var1) {
      this.fondemTotReglement = var1;
   }

   public double getFondemTotRemise() {
      return this.fondemTotRemise;
   }

   public void setFondemTotRemise(double var1) {
      this.fondemTotRemise = var1;
   }

   public double getFondemTotTc() {
      return this.fondemTotTc;
   }

   public void setFondemTotTc(double var1) {
      this.fondemTotTc = var1;
   }

   public int getFondemTypeReg() {
      return this.fondemTypeReg;
   }

   public void setFondemTypeReg(int var1) {
      this.fondemTypeReg = var1;
   }

   public int getFondemTypeTransforme() {
      return this.fondemTypeTransforme;
   }

   public void setFondemTypeTransforme(int var1) {
      this.fondemTypeTransforme = var1;
   }

   public long getFondemUserRelance1() {
      return this.fondemUserRelance1;
   }

   public void setFondemUserRelance1(long var1) {
      this.fondemUserRelance1 = var1;
   }

   public long getFondemUserRelance2() {
      return this.fondemUserRelance2;
   }

   public void setFondemUserRelance2(long var1) {
      this.fondemUserRelance2 = var1;
   }

   public long getFondemUserRelance3() {
      return this.fondemUserRelance3;
   }

   public void setFondemUserRelance3(long var1) {
      this.fondemUserRelance3 = var1;
   }

   public int getFondemType() {
      return this.fondemType;
   }

   public void setFondemType(int var1) {
      this.fondemType = var1;
   }

   public String getFondemDescription() {
      return this.fondemDescription;
   }

   public void setFondemDescription(String var1) {
      this.fondemDescription = var1;
   }

   public String getFondemValidation() {
      return this.fondemValidation;
   }

   public void setFondemValidation(String var1) {
      this.fondemValidation = var1;
   }

   public double getFondemTotAccorde() {
      return this.fondemTotAccorde;
   }

   public void setFondemTotAccorde(double var1) {
      this.fondemTotAccorde = var1;
   }

   public double getFondemTotDebloque() {
      return this.fondemTotDebloque;
   }

   public void setFondemTotDebloque(double var1) {
      this.fondemTotDebloque = var1;
   }

   public double getFondemTotDemande() {
      return this.fondemTotDemande;
   }

   public void setFondemTotDemande(double var1) {
      this.fondemTotDemande = var1;
   }
}
