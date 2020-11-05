package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class NoteDebitEnteteAchats implements Serializable {
   private long ndfId;
   private Date ndfDateCreat;
   private Date ndfDateModif;
   private long ndfIdCreateur;
   private String ndfNomCreateur;
   private long ndfIdModif;
   private String ndfNomModif;
   private Date ndfDate;
   private String ndfNum;
   private String ndfValo;
   private String ndfNomResponsable;
   private long ndfIdResponsable;
   private String ndfNomTiers;
   private String ndfCivilTiers;
   private long ndfIdContact;
   private String ndfNomContact;
   private String ndfCivilContact;
   private String ndfSerie;
   private int ndfExoTva;
   private int ndfExoDouane;
   private Date ndfDateLastReg;
   private String ndfJournalReg;
   private String ndfCat;
   private String ndfDevise;
   private String ndfObject;
   private String ndfObservation;
   private String ndfBudget;
   private double ndfBudgetDispo;
   private double ndfBudgetTreso;
   private double ndfBudgetDispoMois;
   private double ndfBudgetTresoMois;
   private double ndfTotHt;
   private double ndfTotRemise;
   private double ndfTotRabais;
   private double ndfTotTva;
   private double ndfTotTc;
   private double ndfTotTtc;
   private double ndfTotReglement;
   private double ndfTotTimbre;
   private int ndfSolde;
   private String ndfBanque;
   private int ndfTypeReg;
   private String ndfModeReg;
   private int ndfNbJourReg;
   private int ndfArrondiReg;
   private String ndfConditionReg;
   private Date ndfDateEcheReg;
   private String ndfActivite;
   private String ndfSite;
   private String ndfDepartement;
   private String ndfService;
   private String ndfRegion;
   private String ndfSecteur;
   private String ndfPdv;
   private String ndfAnal1;
   private String ndfAnal2;
   private String ndfAnal4;
   private String ndfAffaire;
   private String ndfInfo1;
   private String ndfInfo2;
   private String ndfInfo3;
   private String ndfInfo4;
   private String ndfInfo5;
   private String ndfInfo6;
   private String ndfInfo7;
   private String ndfInfo8;
   private String ndfInfo9;
   private String ndfInfo10;
   private String ndfFormule1;
   private String ndfFormule2;
   private String ndfAnnexe1;
   private String ndfAnnexe2;
   private String ndfContrat;
   private Date ndfDateImp;
   private String ndfModeleImp;
   private int ndfEtatVal;
   private int ndfGele;
   private int ndfEtat;
   private String ndfNumTrf;
   private Date ndfDateValidite;
   private Date ndfDateRelance;
   private Date ndfDateValide;
   private int ndfPosSignature;
   private Date ndfDateTransforme;
   private int ndfTypeTransforme;
   private Date ndfDateAnnule;
   private String ndfMotifAnnule;
   private Date ndfDateTransfert;
   private int ndfDiversTiers;
   private String ndfDiversNom;
   private String ndfDiversAdresse;
   private String ndfDiversVille;
   private String ndfDiversTel;
   private String ndfDiversMail;
   private String ndfSource;
   private ExercicesAchats exercicesAchats;
   private Tiers tiers;
   private Users users;
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
      this.varTotTtcGlob = this.ndfTotTtc + this.ndfTotTc;
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
      if (this.ndfDiversNom != null && !this.ndfDiversNom.isEmpty()) {
         this.var_nom_tiers = this.ndfDiversNom;
      } else if (this.ndfCivilTiers != null && !this.ndfCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.ndfCivilTiers + " " + this.ndfNomTiers;
      } else {
         this.var_nom_tiers = this.ndfNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.ndfDiversNom != null && !this.ndfDiversNom.isEmpty()) {
         this.var_nomContact = "(fournisseur divers)";
      } else if (this.ndfCivilContact != null && !this.ndfCivilContact.isEmpty()) {
         if (this.ndfNomContact != null && !this.ndfNomContact.isEmpty()) {
            this.var_nomContact = this.ndfCivilContact + " " + this.ndfNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.ndfNomContact != null && !this.ndfNomContact.isEmpty()) {
         this.var_nomContact = this.ndfNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.ndfEtat == 0) {
         this.libelleEta = "En cours";
      } else if (this.ndfEtat == 1) {
         this.libelleEta = "Validée";
      } else if (this.ndfEtat == 2) {
         this.libelleEta = "Gelée";
      } else if (this.ndfEtat == 3) {
         this.libelleEta = "Annulée";
      } else if (this.ndfEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.ndfEtat == 5) {
         this.libelleEta = "Trf.T.";
      } else if (this.ndfEtat == 6) {
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
      if (this.ndfSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public int getVar_format_devise() {
      if (!this.ndfDevise.equals("XOF") && !this.ndfDevise.equals("XAF")) {
         if (!this.ndfDevise.equals("EUR") && !this.ndfDevise.equals("XEU") && !this.ndfDevise.equals("CHF")) {
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

   public double getVar_reliquat() {
      this.var_reliquat = this.ndfTotTtc - this.ndfTotReglement;
      return this.var_reliquat;
   }

   public void setVar_reliquat(double var1) {
      this.var_reliquat = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public String getNdfActivite() {
      return this.ndfActivite;
   }

   public void setNdfActivite(String var1) {
      this.ndfActivite = var1;
   }

   public String getNdfAnal2() {
      return this.ndfAnal2;
   }

   public void setNdfAnal2(String var1) {
      this.ndfAnal2 = var1;
   }

   public String getNdfAnal4() {
      return this.ndfAnal4;
   }

   public void setNdfAnal4(String var1) {
      this.ndfAnal4 = var1;
   }

   public String getNdfAnnexe1() {
      return this.ndfAnnexe1;
   }

   public void setNdfAnnexe1(String var1) {
      this.ndfAnnexe1 = var1;
   }

   public String getNdfAnnexe2() {
      return this.ndfAnnexe2;
   }

   public void setNdfAnnexe2(String var1) {
      this.ndfAnnexe2 = var1;
   }

   public int getNdfArrondiReg() {
      return this.ndfArrondiReg;
   }

   public void setNdfArrondiReg(int var1) {
      this.ndfArrondiReg = var1;
   }

   public String getNdfBanque() {
      return this.ndfBanque;
   }

   public void setNdfBanque(String var1) {
      this.ndfBanque = var1;
   }

   public String getNdfBudget() {
      return this.ndfBudget;
   }

   public void setNdfBudget(String var1) {
      this.ndfBudget = var1;
   }

   public double getNdfBudgetDispo() {
      return this.ndfBudgetDispo;
   }

   public void setNdfBudgetDispo(double var1) {
      this.ndfBudgetDispo = var1;
   }

   public String getNdfCat() {
      return this.ndfCat;
   }

   public void setNdfCat(String var1) {
      this.ndfCat = var1;
   }

   public String getNdfConditionReg() {
      return this.ndfConditionReg;
   }

   public void setNdfConditionReg(String var1) {
      this.ndfConditionReg = var1;
   }

   public String getNdfContrat() {
      return this.ndfContrat;
   }

   public void setNdfContrat(String var1) {
      this.ndfContrat = var1;
   }

   public Date getNdfDate() {
      return this.ndfDate;
   }

   public void setNdfDate(Date var1) {
      this.ndfDate = var1;
   }

   public Date getNdfDateAnnule() {
      return this.ndfDateAnnule;
   }

   public void setNdfDateAnnule(Date var1) {
      this.ndfDateAnnule = var1;
   }

   public Date getNdfDateCreat() {
      return this.ndfDateCreat;
   }

   public void setNdfDateCreat(Date var1) {
      this.ndfDateCreat = var1;
   }

   public Date getNdfDateEcheReg() {
      return this.ndfDateEcheReg;
   }

   public void setNdfDateEcheReg(Date var1) {
      this.ndfDateEcheReg = var1;
   }

   public Date getNdfDateImp() {
      return this.ndfDateImp;
   }

   public void setNdfDateImp(Date var1) {
      this.ndfDateImp = var1;
   }

   public Date getNdfDateModif() {
      return this.ndfDateModif;
   }

   public void setNdfDateModif(Date var1) {
      this.ndfDateModif = var1;
   }

   public Date getNdfDateRelance() {
      return this.ndfDateRelance;
   }

   public void setNdfDateRelance(Date var1) {
      this.ndfDateRelance = var1;
   }

   public Date getNdfDateTransforme() {
      return this.ndfDateTransforme;
   }

   public void setNdfDateTransforme(Date var1) {
      this.ndfDateTransforme = var1;
   }

   public Date getNdfDateValide() {
      return this.ndfDateValide;
   }

   public void setNdfDateValide(Date var1) {
      this.ndfDateValide = var1;
   }

   public Date getNdfDateValidite() {
      return this.ndfDateValidite;
   }

   public void setNdfDateValidite(Date var1) {
      this.ndfDateValidite = var1;
   }

   public String getNdfDepartement() {
      return this.ndfDepartement;
   }

   public void setNdfDepartement(String var1) {
      this.ndfDepartement = var1;
   }

   public String getNdfDevise() {
      return this.ndfDevise;
   }

   public void setNdfDevise(String var1) {
      this.ndfDevise = var1;
   }

   public int getNdfEtat() {
      return this.ndfEtat;
   }

   public void setNdfEtat(int var1) {
      this.ndfEtat = var1;
   }

   public int getNdfEtatVal() {
      return this.ndfEtatVal;
   }

   public void setNdfEtatVal(int var1) {
      this.ndfEtatVal = var1;
   }

   public String getNdfFormule1() {
      return this.ndfFormule1;
   }

   public void setNdfFormule1(String var1) {
      this.ndfFormule1 = var1;
   }

   public String getNdfFormule2() {
      return this.ndfFormule2;
   }

   public void setNdfFormule2(String var1) {
      this.ndfFormule2 = var1;
   }

   public int getNdfGele() {
      return this.ndfGele;
   }

   public void setNdfGele(int var1) {
      this.ndfGele = var1;
   }

   public long getNdfId() {
      return this.ndfId;
   }

   public void setNdfId(long var1) {
      this.ndfId = var1;
   }

   public long getNdfIdCreateur() {
      return this.ndfIdCreateur;
   }

   public void setNdfIdCreateur(long var1) {
      this.ndfIdCreateur = var1;
   }

   public long getNdfIdModif() {
      return this.ndfIdModif;
   }

   public void setNdfIdModif(long var1) {
      this.ndfIdModif = var1;
   }

   public String getNdfInfo1() {
      return this.ndfInfo1;
   }

   public void setNdfInfo1(String var1) {
      this.ndfInfo1 = var1;
   }

   public String getNdfInfo10() {
      return this.ndfInfo10;
   }

   public void setNdfInfo10(String var1) {
      this.ndfInfo10 = var1;
   }

   public String getNdfInfo2() {
      return this.ndfInfo2;
   }

   public void setNdfInfo2(String var1) {
      this.ndfInfo2 = var1;
   }

   public String getNdfInfo3() {
      return this.ndfInfo3;
   }

   public void setNdfInfo3(String var1) {
      this.ndfInfo3 = var1;
   }

   public String getNdfInfo4() {
      return this.ndfInfo4;
   }

   public void setNdfInfo4(String var1) {
      this.ndfInfo4 = var1;
   }

   public String getNdfInfo5() {
      return this.ndfInfo5;
   }

   public void setNdfInfo5(String var1) {
      this.ndfInfo5 = var1;
   }

   public String getNdfInfo6() {
      return this.ndfInfo6;
   }

   public void setNdfInfo6(String var1) {
      this.ndfInfo6 = var1;
   }

   public String getNdfInfo7() {
      return this.ndfInfo7;
   }

   public void setNdfInfo7(String var1) {
      this.ndfInfo7 = var1;
   }

   public String getNdfInfo8() {
      return this.ndfInfo8;
   }

   public void setNdfInfo8(String var1) {
      this.ndfInfo8 = var1;
   }

   public String getNdfInfo9() {
      return this.ndfInfo9;
   }

   public void setNdfInfo9(String var1) {
      this.ndfInfo9 = var1;
   }

   public String getNdfModeReg() {
      return this.ndfModeReg;
   }

   public void setNdfModeReg(String var1) {
      this.ndfModeReg = var1;
   }

   public String getNdfModeleImp() {
      return this.ndfModeleImp;
   }

   public void setNdfModeleImp(String var1) {
      this.ndfModeleImp = var1;
   }

   public String getNdfMotifAnnule() {
      return this.ndfMotifAnnule;
   }

   public void setNdfMotifAnnule(String var1) {
      this.ndfMotifAnnule = var1;
   }

   public int getNdfNbJourReg() {
      return this.ndfNbJourReg;
   }

   public void setNdfNbJourReg(int var1) {
      this.ndfNbJourReg = var1;
   }

   public String getNdfNomContact() {
      return this.ndfNomContact;
   }

   public void setNdfNomContact(String var1) {
      this.ndfNomContact = var1;
   }

   public String getNdfNomCreateur() {
      return this.ndfNomCreateur;
   }

   public void setNdfNomCreateur(String var1) {
      this.ndfNomCreateur = var1;
   }

   public String getNdfNomModif() {
      return this.ndfNomModif;
   }

   public void setNdfNomModif(String var1) {
      this.ndfNomModif = var1;
   }

   public String getNdfNomResponsable() {
      return this.ndfNomResponsable;
   }

   public void setNdfNomResponsable(String var1) {
      this.ndfNomResponsable = var1;
   }

   public String getNdfNomTiers() {
      return this.ndfNomTiers;
   }

   public void setNdfNomTiers(String var1) {
      this.ndfNomTiers = var1;
   }

   public String getNdfNum() {
      return this.ndfNum;
   }

   public void setNdfNum(String var1) {
      this.ndfNum = var1;
   }

   public String getNdfObject() {
      return this.ndfObject;
   }

   public void setNdfObject(String var1) {
      this.ndfObject = var1;
   }

   public String getNdfObservation() {
      return this.ndfObservation;
   }

   public void setNdfObservation(String var1) {
      this.ndfObservation = var1;
   }

   public String getNdfPdv() {
      return this.ndfPdv;
   }

   public void setNdfPdv(String var1) {
      this.ndfPdv = var1;
   }

   public String getNdfRegion() {
      return this.ndfRegion;
   }

   public void setNdfRegion(String var1) {
      this.ndfRegion = var1;
   }

   public String getNdfSecteur() {
      return this.ndfSecteur;
   }

   public void setNdfSecteur(String var1) {
      this.ndfSecteur = var1;
   }

   public String getNdfSerie() {
      return this.ndfSerie;
   }

   public void setNdfSerie(String var1) {
      this.ndfSerie = var1;
   }

   public String getNdfService() {
      return this.ndfService;
   }

   public void setNdfService(String var1) {
      this.ndfService = var1;
   }

   public String getNdfSite() {
      return this.ndfSite;
   }

   public void setNdfSite(String var1) {
      this.ndfSite = var1;
   }

   public int getNdfSolde() {
      return this.ndfSolde;
   }

   public void setNdfSolde(int var1) {
      this.ndfSolde = var1;
   }

   public double getNdfTotHt() {
      return this.ndfTotHt;
   }

   public void setNdfTotHt(double var1) {
      this.ndfTotHt = var1;
   }

   public double getNdfTotRabais() {
      return this.ndfTotRabais;
   }

   public void setNdfTotRabais(double var1) {
      this.ndfTotRabais = var1;
   }

   public double getNdfTotReglement() {
      return this.ndfTotReglement;
   }

   public void setNdfTotReglement(double var1) {
      this.ndfTotReglement = var1;
   }

   public double getNdfTotRemise() {
      return this.ndfTotRemise;
   }

   public void setNdfTotRemise(double var1) {
      this.ndfTotRemise = var1;
   }

   public double getNdfTotTc() {
      return this.ndfTotTc;
   }

   public void setNdfTotTc(double var1) {
      this.ndfTotTc = var1;
   }

   public double getNdfTotTtc() {
      return this.ndfTotTtc;
   }

   public void setNdfTotTtc(double var1) {
      this.ndfTotTtc = var1;
   }

   public double getNdfTotTva() {
      return this.ndfTotTva;
   }

   public void setNdfTotTva(double var1) {
      this.ndfTotTva = var1;
   }

   public int getNdfTypeReg() {
      return this.ndfTypeReg;
   }

   public void setNdfTypeReg(int var1) {
      this.ndfTypeReg = var1;
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

   public double getNdfBudgetTreso() {
      return this.ndfBudgetTreso;
   }

   public void setNdfBudgetTreso(double var1) {
      this.ndfBudgetTreso = var1;
   }

   public int getNdfExoDouane() {
      return this.ndfExoDouane;
   }

   public void setNdfExoDouane(int var1) {
      this.ndfExoDouane = var1;
   }

   public int getNdfExoTva() {
      return this.ndfExoTva;
   }

   public void setNdfExoTva(int var1) {
      this.ndfExoTva = var1;
   }

   public String getNdfJournalReg() {
      return this.ndfJournalReg;
   }

   public void setNdfJournalReg(String var1) {
      this.ndfJournalReg = var1;
   }

   public String getNdfCivilContact() {
      return this.ndfCivilContact;
   }

   public void setNdfCivilContact(String var1) {
      this.ndfCivilContact = var1;
   }

   public String getNdfCivilTiers() {
      return this.ndfCivilTiers;
   }

   public void setNdfCivilTiers(String var1) {
      this.ndfCivilTiers = var1;
   }

   public long getNdfIdResponsable() {
      return this.ndfIdResponsable;
   }

   public void setNdfIdResponsable(long var1) {
      this.ndfIdResponsable = var1;
   }

   public double getNdfBudgetDispoMois() {
      return this.ndfBudgetDispoMois;
   }

   public void setNdfBudgetDispoMois(double var1) {
      this.ndfBudgetDispoMois = var1;
   }

   public double getNdfBudgetTresoMois() {
      return this.ndfBudgetTresoMois;
   }

   public void setNdfBudgetTresoMois(double var1) {
      this.ndfBudgetTresoMois = var1;
   }

   public int getNdfTypeTransforme() {
      return this.ndfTypeTransforme;
   }

   public void setNdfTypeTransforme(int var1) {
      this.ndfTypeTransforme = var1;
   }

   public String getNdfValo() {
      return this.ndfValo;
   }

   public void setNdfValo(String var1) {
      this.ndfValo = var1;
   }

   public long getNdfIdContact() {
      return this.ndfIdContact;
   }

   public void setNdfIdContact(long var1) {
      this.ndfIdContact = var1;
   }

   public Date getNdfDateTransfert() {
      return this.ndfDateTransfert;
   }

   public void setNdfDateTransfert(Date var1) {
      this.ndfDateTransfert = var1;
   }

   public String getNdfDiversAdresse() {
      return this.ndfDiversAdresse;
   }

   public void setNdfDiversAdresse(String var1) {
      this.ndfDiversAdresse = var1;
   }

   public String getNdfDiversMail() {
      return this.ndfDiversMail;
   }

   public void setNdfDiversMail(String var1) {
      this.ndfDiversMail = var1;
   }

   public String getNdfDiversNom() {
      return this.ndfDiversNom;
   }

   public void setNdfDiversNom(String var1) {
      this.ndfDiversNom = var1;
   }

   public String getNdfDiversTel() {
      return this.ndfDiversTel;
   }

   public void setNdfDiversTel(String var1) {
      this.ndfDiversTel = var1;
   }

   public int getNdfDiversTiers() {
      return this.ndfDiversTiers;
   }

   public void setNdfDiversTiers(int var1) {
      this.ndfDiversTiers = var1;
   }

   public String getNdfDiversVille() {
      return this.ndfDiversVille;
   }

   public void setNdfDiversVille(String var1) {
      this.ndfDiversVille = var1;
   }

   public String getNdfNumTrf() {
      return this.ndfNumTrf;
   }

   public void setNdfNumTrf(String var1) {
      this.ndfNumTrf = var1;
   }

   public Date getNdfDateLastReg() {
      return this.ndfDateLastReg;
   }

   public void setNdfDateLastReg(Date var1) {
      this.ndfDateLastReg = var1;
   }

   public double getNdfTotTimbre() {
      return this.ndfTotTimbre;
   }

   public void setNdfTotTimbre(double var1) {
      this.ndfTotTimbre = var1;
   }

   public int getNdfPosSignature() {
      return this.ndfPosSignature;
   }

   public void setNdfPosSignature(int var1) {
      this.ndfPosSignature = var1;
   }

   public String getNdfAffaire() {
      return this.ndfAffaire;
   }

   public void setNdfAffaire(String var1) {
      this.ndfAffaire = var1;
   }

   public String getNdfSource() {
      return this.ndfSource;
   }

   public void setNdfSource(String var1) {
      this.ndfSource = var1;
   }

   public String getNdfAnal1() {
      return this.ndfAnal1;
   }

   public void setNdfAnal1(String var1) {
      this.ndfAnal1 = var1;
   }
}
