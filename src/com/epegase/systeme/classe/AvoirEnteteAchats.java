package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class AvoirEnteteAchats implements Serializable {
   private long avfId;
   private Date avfDateCreat;
   private Date avfDateModif;
   private long avfIdCreateur;
   private String avfNomCreateur;
   private long avfIdModif;
   private String avfNomModif;
   private Date avfDate;
   private String avfNum;
   private String avfNomResponsable;
   private long avfIdResponsable;
   private String avfNomTiers;
   private String avfCivilTiers;
   private long avfIdContact;
   private String avfNomContact;
   private String avfCivilContact;
   private String avfSerie;
   private int avfExoTva;
   private int avfExoDouane;
   private String avfJournalReg;
   private String avfCat;
   private String avfDevise;
   private String avfObject;
   private String avfObservation;
   private String avfBudget;
   private double avfBudgetDispo;
   private double avfBudgetTreso;
   private double avfBudgetDispoMois;
   private double avfBudgetTresoMois;
   private double avfTotHt;
   private double avfTotRemise;
   private double avfTotRabais;
   private double avfTotTva;
   private double avfTotTc;
   private double avfTotTtc;
   private double avfTotReglement;
   private int avfSolde;
   private String avfBanque;
   private int avfTypeReg;
   private String avfModeReg;
   private int avfNbJourReg;
   private int avfArrondiReg;
   private String avfConditionReg;
   private Date avfDateEcheReg;
   private String avfActivite;
   private String avfSite;
   private String avfDepartement;
   private String avfService;
   private String avfRegion;
   private String avfSecteur;
   private String avfPdv;
   private String avfAnal1;
   private String avfAnal2;
   private String avfAnal4;
   private String avfAffaire;
   private String avfInfo1;
   private String avfInfo2;
   private String avfInfo3;
   private String avfInfo4;
   private String avfInfo5;
   private String avfInfo6;
   private String avfInfo7;
   private String avfInfo8;
   private String avfInfo9;
   private String avfInfo10;
   private String avfFormule1;
   private String avfFormule2;
   private String avfAnnexe1;
   private String avfAnnexe2;
   private String avfContrat;
   private String avfNumFour;
   private Date avfDateImp;
   private String avfModeleImp;
   private int avfEtatVal;
   private int avfGele;
   private int avfEtat;
   private String avfNumTrf;
   private Date avfDateValidite;
   private Date avfDateRelance;
   private Date avfDateValide;
   private int avfPosSignature;
   private Date avfDateTransforme;
   private int avfTypeTransforme;
   private Date avfDateAnnule;
   private String avfMotifAnnule;
   private Date avfDateTransfert;
   private int avfDiversTiers;
   private String avfDiversNom;
   private String avfDiversAdresse;
   private String avfDiversVille;
   private String avfDiversTel;
   private String avfDiversMail;
   private String avfSource;
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
      if (this.avfDiversNom != null && !this.avfDiversNom.isEmpty()) {
         this.var_nom_tiers = this.avfDiversNom;
      } else if (this.avfCivilTiers != null && !this.avfCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.avfCivilTiers + " " + this.avfNomTiers;
      } else {
         this.var_nom_tiers = this.avfNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.avfDiversNom != null && !this.avfDiversNom.isEmpty()) {
         this.var_nomContact = "(fournisseur divers)";
      } else if (this.avfCivilContact != null && !this.avfCivilContact.isEmpty()) {
         if (this.avfNomContact != null && !this.avfNomContact.isEmpty()) {
            this.var_nomContact = this.avfCivilContact + " " + this.avfNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.avfNomContact != null && !this.avfNomContact.isEmpty()) {
         this.var_nomContact = this.avfNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.avfEtat == 0) {
         this.libelleEta = "En cours";
      } else if (this.avfEtat == 1) {
         this.libelleEta = "Validée";
      } else if (this.avfEtat == 2) {
         this.libelleEta = "Gelée";
      } else if (this.avfEtat == 3) {
         this.libelleEta = "Annulée";
      } else if (this.avfEtat == 6) {
         this.libelleEta = "Compta.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getAvfActivite() {
      return this.avfActivite;
   }

   public void setAvfActivite(String var1) {
      this.avfActivite = var1;
   }

   public String getAvfAnal2() {
      return this.avfAnal2;
   }

   public void setAvfAnal2(String var1) {
      this.avfAnal2 = var1;
   }

   public String getAvfAnal4() {
      return this.avfAnal4;
   }

   public void setAvfAnal4(String var1) {
      this.avfAnal4 = var1;
   }

   public String getAvfAnnexe1() {
      return this.avfAnnexe1;
   }

   public void setAvfAnnexe1(String var1) {
      this.avfAnnexe1 = var1;
   }

   public String getAvfAnnexe2() {
      return this.avfAnnexe2;
   }

   public void setAvfAnnexe2(String var1) {
      this.avfAnnexe2 = var1;
   }

   public int getAvfArrondiReg() {
      return this.avfArrondiReg;
   }

   public void setAvfArrondiReg(int var1) {
      this.avfArrondiReg = var1;
   }

   public String getAvfBanque() {
      return this.avfBanque;
   }

   public void setAvfBanque(String var1) {
      this.avfBanque = var1;
   }

   public String getAvfBudget() {
      return this.avfBudget;
   }

   public void setAvfBudget(String var1) {
      this.avfBudget = var1;
   }

   public double getAvfBudgetDispo() {
      return this.avfBudgetDispo;
   }

   public void setAvfBudgetDispo(double var1) {
      this.avfBudgetDispo = var1;
   }

   public double getAvfBudgetTreso() {
      return this.avfBudgetTreso;
   }

   public void setAvfBudgetTreso(double var1) {
      this.avfBudgetTreso = var1;
   }

   public String getAvfCat() {
      return this.avfCat;
   }

   public void setAvfCat(String var1) {
      this.avfCat = var1;
   }

   public String getAvfConditionReg() {
      return this.avfConditionReg;
   }

   public void setAvfConditionReg(String var1) {
      this.avfConditionReg = var1;
   }

   public String getAvfContrat() {
      return this.avfContrat;
   }

   public void setAvfContrat(String var1) {
      this.avfContrat = var1;
   }

   public Date getAvfDate() {
      return this.avfDate;
   }

   public void setAvfDate(Date var1) {
      this.avfDate = var1;
   }

   public Date getAvfDateAnnule() {
      return this.avfDateAnnule;
   }

   public void setAvfDateAnnule(Date var1) {
      this.avfDateAnnule = var1;
   }

   public Date getAvfDateCreat() {
      return this.avfDateCreat;
   }

   public void setAvfDateCreat(Date var1) {
      this.avfDateCreat = var1;
   }

   public Date getAvfDateEcheReg() {
      return this.avfDateEcheReg;
   }

   public void setAvfDateEcheReg(Date var1) {
      this.avfDateEcheReg = var1;
   }

   public Date getAvfDateImp() {
      return this.avfDateImp;
   }

   public void setAvfDateImp(Date var1) {
      this.avfDateImp = var1;
   }

   public Date getAvfDateModif() {
      return this.avfDateModif;
   }

   public void setAvfDateModif(Date var1) {
      this.avfDateModif = var1;
   }

   public Date getAvfDateRelance() {
      return this.avfDateRelance;
   }

   public void setAvfDateRelance(Date var1) {
      this.avfDateRelance = var1;
   }

   public Date getAvfDateTransforme() {
      return this.avfDateTransforme;
   }

   public void setAvfDateTransforme(Date var1) {
      this.avfDateTransforme = var1;
   }

   public Date getAvfDateValide() {
      return this.avfDateValide;
   }

   public void setAvfDateValide(Date var1) {
      this.avfDateValide = var1;
   }

   public Date getAvfDateValidite() {
      return this.avfDateValidite;
   }

   public void setAvfDateValidite(Date var1) {
      this.avfDateValidite = var1;
   }

   public String getAvfDepartement() {
      return this.avfDepartement;
   }

   public void setAvfDepartement(String var1) {
      this.avfDepartement = var1;
   }

   public String getAvfDevise() {
      return this.avfDevise;
   }

   public void setAvfDevise(String var1) {
      this.avfDevise = var1;
   }

   public int getAvfEtat() {
      return this.avfEtat;
   }

   public void setAvfEtat(int var1) {
      this.avfEtat = var1;
   }

   public int getAvfEtatVal() {
      return this.avfEtatVal;
   }

   public void setAvfEtatVal(int var1) {
      this.avfEtatVal = var1;
   }

   public String getAvfFormule1() {
      return this.avfFormule1;
   }

   public void setAvfFormule1(String var1) {
      this.avfFormule1 = var1;
   }

   public String getAvfFormule2() {
      return this.avfFormule2;
   }

   public void setAvfFormule2(String var1) {
      this.avfFormule2 = var1;
   }

   public int getAvfGele() {
      return this.avfGele;
   }

   public void setAvfGele(int var1) {
      this.avfGele = var1;
   }

   public long getAvfId() {
      return this.avfId;
   }

   public void setAvfId(long var1) {
      this.avfId = var1;
   }

   public long getAvfIdCreateur() {
      return this.avfIdCreateur;
   }

   public void setAvfIdCreateur(long var1) {
      this.avfIdCreateur = var1;
   }

   public long getAvfIdModif() {
      return this.avfIdModif;
   }

   public void setAvfIdModif(long var1) {
      this.avfIdModif = var1;
   }

   public String getAvfInfo2() {
      return this.avfInfo2;
   }

   public void setAvfInfo2(String var1) {
      this.avfInfo2 = var1;
   }

   public String getAvfInfo1() {
      return this.avfInfo1;
   }

   public void setAvfInfo1(String var1) {
      this.avfInfo1 = var1;
   }

   public String getAvfInfo10() {
      return this.avfInfo10;
   }

   public void setAvfInfo10(String var1) {
      this.avfInfo10 = var1;
   }

   public String getAvfInfo3() {
      return this.avfInfo3;
   }

   public void setAvfInfo3(String var1) {
      this.avfInfo3 = var1;
   }

   public String getAvfInfo4() {
      return this.avfInfo4;
   }

   public void setAvfInfo4(String var1) {
      this.avfInfo4 = var1;
   }

   public String getAvfInfo5() {
      return this.avfInfo5;
   }

   public void setAvfInfo5(String var1) {
      this.avfInfo5 = var1;
   }

   public String getAvfInfo6() {
      return this.avfInfo6;
   }

   public void setAvfInfo6(String var1) {
      this.avfInfo6 = var1;
   }

   public String getAvfInfo7() {
      return this.avfInfo7;
   }

   public void setAvfInfo7(String var1) {
      this.avfInfo7 = var1;
   }

   public String getAvfInfo8() {
      return this.avfInfo8;
   }

   public void setAvfInfo8(String var1) {
      this.avfInfo8 = var1;
   }

   public String getAvfInfo9() {
      return this.avfInfo9;
   }

   public void setAvfInfo9(String var1) {
      this.avfInfo9 = var1;
   }

   public String getAvfModeReg() {
      return this.avfModeReg;
   }

   public void setAvfModeReg(String var1) {
      this.avfModeReg = var1;
   }

   public String getAvfModeleImp() {
      return this.avfModeleImp;
   }

   public void setAvfModeleImp(String var1) {
      this.avfModeleImp = var1;
   }

   public String getAvfMotifAnnule() {
      return this.avfMotifAnnule;
   }

   public void setAvfMotifAnnule(String var1) {
      this.avfMotifAnnule = var1;
   }

   public int getAvfNbJourReg() {
      return this.avfNbJourReg;
   }

   public void setAvfNbJourReg(int var1) {
      this.avfNbJourReg = var1;
   }

   public String getAvfNomContact() {
      return this.avfNomContact;
   }

   public void setAvfNomContact(String var1) {
      this.avfNomContact = var1;
   }

   public String getAvfNomCreateur() {
      return this.avfNomCreateur;
   }

   public void setAvfNomCreateur(String var1) {
      this.avfNomCreateur = var1;
   }

   public String getAvfNomModif() {
      return this.avfNomModif;
   }

   public void setAvfNomModif(String var1) {
      this.avfNomModif = var1;
   }

   public String getAvfNomResponsable() {
      return this.avfNomResponsable;
   }

   public void setAvfNomResponsable(String var1) {
      this.avfNomResponsable = var1;
   }

   public String getAvfNomTiers() {
      return this.avfNomTiers;
   }

   public void setAvfNomTiers(String var1) {
      this.avfNomTiers = var1;
   }

   public String getAvfNum() {
      return this.avfNum;
   }

   public void setAvfNum(String var1) {
      this.avfNum = var1;
   }

   public String getAvfNumFour() {
      return this.avfNumFour;
   }

   public void setAvfNumFour(String var1) {
      this.avfNumFour = var1;
   }

   public String getAvfObject() {
      return this.avfObject;
   }

   public void setAvfObject(String var1) {
      this.avfObject = var1;
   }

   public String getAvfObservation() {
      return this.avfObservation;
   }

   public void setAvfObservation(String var1) {
      this.avfObservation = var1;
   }

   public String getAvfPdv() {
      return this.avfPdv;
   }

   public void setAvfPdv(String var1) {
      this.avfPdv = var1;
   }

   public String getAvfRegion() {
      return this.avfRegion;
   }

   public void setAvfRegion(String var1) {
      this.avfRegion = var1;
   }

   public String getAvfSecteur() {
      return this.avfSecteur;
   }

   public void setAvfSecteur(String var1) {
      this.avfSecteur = var1;
   }

   public String getAvfSerie() {
      return this.avfSerie;
   }

   public void setAvfSerie(String var1) {
      this.avfSerie = var1;
   }

   public String getAvfService() {
      return this.avfService;
   }

   public void setAvfService(String var1) {
      this.avfService = var1;
   }

   public String getAvfSite() {
      return this.avfSite;
   }

   public void setAvfSite(String var1) {
      this.avfSite = var1;
   }

   public int getAvfSolde() {
      return this.avfSolde;
   }

   public void setAvfSolde(int var1) {
      this.avfSolde = var1;
   }

   public double getAvfTotHt() {
      return this.avfTotHt;
   }

   public void setAvfTotHt(double var1) {
      this.avfTotHt = var1;
   }

   public double getAvfTotRabais() {
      return this.avfTotRabais;
   }

   public void setAvfTotRabais(double var1) {
      this.avfTotRabais = var1;
   }

   public double getAvfTotReglement() {
      return this.avfTotReglement;
   }

   public void setAvfTotReglement(double var1) {
      this.avfTotReglement = var1;
   }

   public double getAvfTotRemise() {
      return this.avfTotRemise;
   }

   public void setAvfTotRemise(double var1) {
      this.avfTotRemise = var1;
   }

   public double getAvfTotTc() {
      return this.avfTotTc;
   }

   public void setAvfTotTc(double var1) {
      this.avfTotTc = var1;
   }

   public double getAvfTotTtc() {
      return this.avfTotTtc;
   }

   public void setAvfTotTtc(double var1) {
      this.avfTotTtc = var1;
   }

   public double getAvfTotTva() {
      return this.avfTotTva;
   }

   public void setAvfTotTva(double var1) {
      this.avfTotTva = var1;
   }

   public int getAvfTypeReg() {
      return this.avfTypeReg;
   }

   public void setAvfTypeReg(int var1) {
      this.avfTypeReg = var1;
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

   public int getAvfExoDouane() {
      return this.avfExoDouane;
   }

   public void setAvfExoDouane(int var1) {
      this.avfExoDouane = var1;
   }

   public int getAvfExoTva() {
      return this.avfExoTva;
   }

   public void setAvfExoTva(int var1) {
      this.avfExoTva = var1;
   }

   public String getAvfJournalReg() {
      return this.avfJournalReg;
   }

   public void setAvfJournalReg(String var1) {
      this.avfJournalReg = var1;
   }

   public String getAvfCivilContact() {
      return this.avfCivilContact;
   }

   public void setAvfCivilContact(String var1) {
      this.avfCivilContact = var1;
   }

   public String getAvfCivilTiers() {
      return this.avfCivilTiers;
   }

   public void setAvfCivilTiers(String var1) {
      this.avfCivilTiers = var1;
   }

   public long getAvfIdResponsable() {
      return this.avfIdResponsable;
   }

   public void setAvfIdResponsable(long var1) {
      this.avfIdResponsable = var1;
   }

   public String getVar_solde() {
      if (this.avfSolde == 1) {
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
      if (!this.avfDevise.equals("XOF") && !this.avfDevise.equals("XAF")) {
         if (!this.avfDevise.equals("EUR") && !this.avfDevise.equals("XEU") && !this.avfDevise.equals("CHF")) {
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

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public double getAvfBudgetDispoMois() {
      return this.avfBudgetDispoMois;
   }

   public void setAvfBudgetDispoMois(double var1) {
      this.avfBudgetDispoMois = var1;
   }

   public double getAvfBudgetTresoMois() {
      return this.avfBudgetTresoMois;
   }

   public void setAvfBudgetTresoMois(double var1) {
      this.avfBudgetTresoMois = var1;
   }

   public int getAvfTypeTransforme() {
      return this.avfTypeTransforme;
   }

   public void setAvfTypeTransforme(int var1) {
      this.avfTypeTransforme = var1;
   }

   public long getAvfIdContact() {
      return this.avfIdContact;
   }

   public void setAvfIdContact(long var1) {
      this.avfIdContact = var1;
   }

   public Date getAvfDateTransfert() {
      return this.avfDateTransfert;
   }

   public void setAvfDateTransfert(Date var1) {
      this.avfDateTransfert = var1;
   }

   public String getAvfDiversAdresse() {
      return this.avfDiversAdresse;
   }

   public void setAvfDiversAdresse(String var1) {
      this.avfDiversAdresse = var1;
   }

   public String getAvfDiversMail() {
      return this.avfDiversMail;
   }

   public void setAvfDiversMail(String var1) {
      this.avfDiversMail = var1;
   }

   public String getAvfDiversNom() {
      if (this.avfDiversNom != null && !this.avfDiversNom.isEmpty()) {
         this.avfDiversNom = this.avfDiversNom.toUpperCase();
      }

      return this.avfDiversNom;
   }

   public void setAvfDiversNom(String var1) {
      this.avfDiversNom = var1;
   }

   public String getAvfDiversTel() {
      return this.avfDiversTel;
   }

   public void setAvfDiversTel(String var1) {
      this.avfDiversTel = var1;
   }

   public int getAvfDiversTiers() {
      return this.avfDiversTiers;
   }

   public void setAvfDiversTiers(int var1) {
      this.avfDiversTiers = var1;
   }

   public String getAvfDiversVille() {
      return this.avfDiversVille;
   }

   public void setAvfDiversVille(String var1) {
      this.avfDiversVille = var1;
   }

   public String getAvfNumTrf() {
      return this.avfNumTrf;
   }

   public void setAvfNumTrf(String var1) {
      this.avfNumTrf = var1;
   }

   public int getAvfPosSignature() {
      return this.avfPosSignature;
   }

   public void setAvfPosSignature(int var1) {
      this.avfPosSignature = var1;
   }

   public String getAvfAffaire() {
      return this.avfAffaire;
   }

   public void setAvfAffaire(String var1) {
      this.avfAffaire = var1;
   }

   public String getAvfSource() {
      return this.avfSource;
   }

   public void setAvfSource(String var1) {
      this.avfSource = var1;
   }

   public String getAvfAnal1() {
      return this.avfAnal1;
   }

   public void setAvfAnal1(String var1) {
      this.avfAnal1 = var1;
   }
}
