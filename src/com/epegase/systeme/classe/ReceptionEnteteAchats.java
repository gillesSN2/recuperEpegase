package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ReceptionEnteteAchats implements Serializable {
   private long recId;
   private Date recDateCreat;
   private Date recDateModif;
   private long recIdCreateur;
   private String recNomCreateur;
   private long recIdModif;
   private String recNomModif;
   private int recMaj;
   private Date recDate;
   private String recNum;
   private String recValo;
   private String recNomResponsable;
   private long recIdResponsable;
   private String recNomTiers;
   private String recCivilTiers;
   private long recIdContact;
   private String recNomContact;
   private String recCivilContact;
   private String recSerie;
   private int recExoTva;
   private int recExoDouane;
   private String recJournalReg;
   private String recCat;
   private String recDevise;
   private float recCoefDevise;
   private String recObject;
   private String recObservation;
   private String recBudget;
   private double recBudgetDispo;
   private double recBudgetTreso;
   private double recBudgetTresoMois;
   private double recBudgetDispoMois;
   private double recTotCertificat;
   private double recTotCertificatConformite;
   private double recTotCertificatLocal;
   private double recTotCertificatConformiteLocal;
   private double recTotHt;
   private double recTotRemise;
   private double recTotRabais;
   private double recTotTva;
   private double recTotTc;
   private double recTotTtc;
   private float recTotPoidsBrut;
   private float recTotQte;
   private double recTotReglement;
   private double recTotHtLocal;
   private double recTotTvaLocal;
   private double recTotTtcLocal;
   private double recTotRemiseLocal;
   private double recTotRabaisLocal;
   private double recTotFret;
   private double recTotFretLocal;
   private double recTotFret2;
   private double recTotFret2Local;
   private double recTotAssurance;
   private double recTotAssuranceLocal;
   private double recTotFraisAdm;
   private double recTotFraisAdmLocal;
   private int recSolde;
   private String recModeReg;
   private String recBanque;
   private int recTypeReg;
   private int recNbJourReg;
   private int recArrondiReg;
   private String recConditionReg;
   private String recActivite;
   private Date recDateEcheReg;
   private String recSite;
   private String recDepartement;
   private String recService;
   private String recRegion;
   private String recSecteur;
   private String recPdv;
   private String recAnal1;
   private String recAnal2;
   private String recAnal4;
   private String recAffaire;
   private String recInfo1;
   private String recInfo2;
   private String recInfo3;
   private String recInfo4;
   private String recInfo5;
   private String recInfo6;
   private String recInfo7;
   private String recInfo8;
   private String recInfo9;
   private String recInfo10;
   private String recFormule1;
   private String recFormule2;
   private String recAnnexe1;
   private String recAnnexe2;
   private String recContrat;
   private String recIncoterm;
   private String recNomTransitaire;
   private String recLieuLivraison;
   private Date recDateLivraison;
   private String recInfoLivraison;
   private Date recDateImp;
   private String recModeleImp;
   private int recEtatVal;
   private int recValorisation;
   private float recCoefValo;
   private int recGele;
   private int recEtat;
   private Date recDateValidite;
   private Date recDateRelance;
   private Date recDateValide;
   private int recPosSignature;
   private Date recDateFacture;
   private String recNumFature;
   private Date recDateTransforme;
   private int recTypeTransforme;
   private Date recDateAnnule;
   private String recMotifAnnule;
   private String recFactorNom;
   private long recFactorId;
   private int recFactorEtat;
   private String recLivreurNom;
   private String recCommentaire;
   private String recProduction;
   private int recDiversTiers;
   private String recDiversNom;
   private String recDiversAdresse;
   private String recDiversVille;
   private String recDiversTel;
   private String recDiversMail;
   private boolean recExcluValo;
   private boolean recPj;
   private String recSource;
   private ExercicesAchats exercicesAchats;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private String var_solde;
   private boolean var_select_ligne;
   private int var_format_devise;
   private String mode_valorisation;
   private double totRabaisRemise;
   private String var_nomContact;
   private String var_nom_tiers;
   private String excluValo;
   private String pj;

   public String getPj() {
      if (!this.recPj) {
         this.pj = null;
      } else if (this.recPj) {
         this.pj = "/images/mail_pj.png";
      }

      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
   }

   public String getExcluValo() {
      if (this.recExcluValo) {
         this.excluValo = "Exclu";
      } else {
         this.excluValo = "";
      }

      return this.excluValo;
   }

   public void setExcluValo(String var1) {
      this.excluValo = var1;
   }

   public String getVar_nom_tiers() {
      if (this.recDiversNom != null && !this.recDiversNom.isEmpty()) {
         this.var_nom_tiers = this.recDiversNom;
      } else if (this.recCivilTiers != null && !this.recCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.recCivilTiers + " " + this.recNomTiers;
      } else {
         this.var_nom_tiers = this.recNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.recDiversNom != null && !this.recDiversNom.isEmpty()) {
         this.var_nomContact = "(fournisseur divers)";
      } else if (this.recCivilContact != null && !this.recCivilContact.isEmpty()) {
         if (this.recNomContact != null && !this.recNomContact.isEmpty()) {
            this.var_nomContact = this.recCivilContact + " " + this.recNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.recNomContact != null && !this.recNomContact.isEmpty()) {
         this.var_nomContact = this.recNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.recEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.recEtat == 1) {
         this.libelleEta = "Validée";
      } else if (this.recEtat == 2) {
         this.libelleEta = "Gelée";
      } else if (this.recEtat == 3) {
         this.libelleEta = "Annulée";
      } else if (this.recEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.recEtat == 5) {
         this.libelleEta = "Trf.T.";
      } else if (this.recEtat == 6) {
         this.libelleEta = "Valorisée";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getMode_valorisation() {
      if (this.recValorisation == 0) {
         this.mode_valorisation = "Coef.Rec.";
      } else if (this.recValorisation == 1) {
         this.mode_valorisation = "Frais";
      } else if (this.recValorisation == 2) {
         this.mode_valorisation = "Coef.Fam.";
      }

      return this.mode_valorisation;
   }

   public void setMode_valorisation(String var1) {
      this.mode_valorisation = var1;
   }

   public double getTotRabaisRemise() {
      this.totRabaisRemise = this.recTotRabais + this.recTotRemise;
      return this.totRabaisRemise;
   }

   public void setTotRabaisRemise(double var1) {
      this.totRabaisRemise = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public String getRecActivite() {
      return this.recActivite;
   }

   public void setRecActivite(String var1) {
      this.recActivite = var1;
   }

   public String getRecAnal2() {
      return this.recAnal2;
   }

   public void setRecAnal2(String var1) {
      this.recAnal2 = var1;
   }

   public String getRecAnal4() {
      return this.recAnal4;
   }

   public void setRecAnal4(String var1) {
      this.recAnal4 = var1;
   }

   public String getRecAnnexe1() {
      return this.recAnnexe1;
   }

   public void setRecAnnexe1(String var1) {
      this.recAnnexe1 = var1;
   }

   public String getRecAnnexe2() {
      return this.recAnnexe2;
   }

   public void setRecAnnexe2(String var1) {
      this.recAnnexe2 = var1;
   }

   public int getRecArrondiReg() {
      return this.recArrondiReg;
   }

   public void setRecArrondiReg(int var1) {
      this.recArrondiReg = var1;
   }

   public String getRecBanque() {
      return this.recBanque;
   }

   public void setRecBanque(String var1) {
      this.recBanque = var1;
   }

   public String getRecBudget() {
      return this.recBudget;
   }

   public void setRecBudget(String var1) {
      this.recBudget = var1;
   }

   public double getRecBudgetDispo() {
      return this.recBudgetDispo;
   }

   public void setRecBudgetDispo(double var1) {
      this.recBudgetDispo = var1;
   }

   public double getRecBudgetTreso() {
      return this.recBudgetTreso;
   }

   public void setRecBudgetTreso(double var1) {
      this.recBudgetTreso = var1;
   }

   public String getRecCat() {
      return this.recCat;
   }

   public void setRecCat(String var1) {
      this.recCat = var1;
   }

   public String getRecConditionReg() {
      return this.recConditionReg;
   }

   public void setRecConditionReg(String var1) {
      this.recConditionReg = var1;
   }

   public String getRecContrat() {
      return this.recContrat;
   }

   public void setRecContrat(String var1) {
      this.recContrat = var1;
   }

   public Date getRecDate() {
      return this.recDate;
   }

   public void setRecDate(Date var1) {
      this.recDate = var1;
   }

   public Date getRecDateAnnule() {
      return this.recDateAnnule;
   }

   public void setRecDateAnnule(Date var1) {
      this.recDateAnnule = var1;
   }

   public Date getRecDateCreat() {
      return this.recDateCreat;
   }

   public void setRecDateCreat(Date var1) {
      this.recDateCreat = var1;
   }

   public Date getRecDateEcheReg() {
      return this.recDateEcheReg;
   }

   public void setRecDateEcheReg(Date var1) {
      this.recDateEcheReg = var1;
   }

   public Date getRecDateImp() {
      return this.recDateImp;
   }

   public void setRecDateImp(Date var1) {
      this.recDateImp = var1;
   }

   public Date getRecDateLivraison() {
      return this.recDateLivraison;
   }

   public void setRecDateLivraison(Date var1) {
      this.recDateLivraison = var1;
   }

   public Date getRecDateModif() {
      return this.recDateModif;
   }

   public void setRecDateModif(Date var1) {
      this.recDateModif = var1;
   }

   public Date getRecDateRelance() {
      return this.recDateRelance;
   }

   public void setRecDateRelance(Date var1) {
      this.recDateRelance = var1;
   }

   public Date getRecDateTransforme() {
      return this.recDateTransforme;
   }

   public void setRecDateTransforme(Date var1) {
      this.recDateTransforme = var1;
   }

   public Date getRecDateValide() {
      return this.recDateValide;
   }

   public void setRecDateValide(Date var1) {
      this.recDateValide = var1;
   }

   public Date getRecDateValidite() {
      return this.recDateValidite;
   }

   public void setRecDateValidite(Date var1) {
      this.recDateValidite = var1;
   }

   public String getRecDepartement() {
      return this.recDepartement;
   }

   public void setRecDepartement(String var1) {
      this.recDepartement = var1;
   }

   public String getRecDevise() {
      return this.recDevise;
   }

   public void setRecDevise(String var1) {
      this.recDevise = var1;
   }

   public int getRecEtat() {
      return this.recEtat;
   }

   public void setRecEtat(int var1) {
      this.recEtat = var1;
   }

   public int getRecEtatVal() {
      return this.recEtatVal;
   }

   public void setRecEtatVal(int var1) {
      this.recEtatVal = var1;
   }

   public String getRecFormule1() {
      return this.recFormule1;
   }

   public void setRecFormule1(String var1) {
      this.recFormule1 = var1;
   }

   public String getRecFormule2() {
      return this.recFormule2;
   }

   public void setRecFormule2(String var1) {
      this.recFormule2 = var1;
   }

   public int getRecGele() {
      return this.recGele;
   }

   public void setRecGele(int var1) {
      this.recGele = var1;
   }

   public long getRecId() {
      return this.recId;
   }

   public void setRecId(long var1) {
      this.recId = var1;
   }

   public long getRecIdCreateur() {
      return this.recIdCreateur;
   }

   public void setRecIdCreateur(long var1) {
      this.recIdCreateur = var1;
   }

   public long getRecIdModif() {
      return this.recIdModif;
   }

   public void setRecIdModif(long var1) {
      this.recIdModif = var1;
   }

   public String getRecIncoterm() {
      return this.recIncoterm;
   }

   public void setRecIncoterm(String var1) {
      this.recIncoterm = var1;
   }

   public String getRecInfo1() {
      return this.recInfo1;
   }

   public void setRecInfo1(String var1) {
      this.recInfo1 = var1;
   }

   public String getRecInfo10() {
      return this.recInfo10;
   }

   public void setRecInfo10(String var1) {
      this.recInfo10 = var1;
   }

   public String getRecInfo2() {
      return this.recInfo2;
   }

   public void setRecInfo2(String var1) {
      this.recInfo2 = var1;
   }

   public String getRecInfo3() {
      return this.recInfo3;
   }

   public void setRecInfo3(String var1) {
      this.recInfo3 = var1;
   }

   public String getRecInfo4() {
      return this.recInfo4;
   }

   public void setRecInfo4(String var1) {
      this.recInfo4 = var1;
   }

   public String getRecInfo5() {
      return this.recInfo5;
   }

   public void setRecInfo5(String var1) {
      this.recInfo5 = var1;
   }

   public String getRecInfo6() {
      return this.recInfo6;
   }

   public void setRecInfo6(String var1) {
      this.recInfo6 = var1;
   }

   public String getRecInfo7() {
      return this.recInfo7;
   }

   public void setRecInfo7(String var1) {
      this.recInfo7 = var1;
   }

   public String getRecInfo8() {
      return this.recInfo8;
   }

   public void setRecInfo8(String var1) {
      this.recInfo8 = var1;
   }

   public String getRecInfo9() {
      return this.recInfo9;
   }

   public void setRecInfo9(String var1) {
      this.recInfo9 = var1;
   }

   public String getRecLieuLivraison() {
      return this.recLieuLivraison;
   }

   public void setRecLieuLivraison(String var1) {
      this.recLieuLivraison = var1;
   }

   public String getRecModeReg() {
      return this.recModeReg;
   }

   public void setRecModeReg(String var1) {
      this.recModeReg = var1;
   }

   public String getRecModeleImp() {
      return this.recModeleImp;
   }

   public void setRecModeleImp(String var1) {
      this.recModeleImp = var1;
   }

   public String getRecMotifAnnule() {
      return this.recMotifAnnule;
   }

   public void setRecMotifAnnule(String var1) {
      this.recMotifAnnule = var1;
   }

   public int getRecNbJourReg() {
      return this.recNbJourReg;
   }

   public void setRecNbJourReg(int var1) {
      this.recNbJourReg = var1;
   }

   public String getRecNomContact() {
      return this.recNomContact;
   }

   public void setRecNomContact(String var1) {
      this.recNomContact = var1;
   }

   public String getRecNomCreateur() {
      return this.recNomCreateur;
   }

   public void setRecNomCreateur(String var1) {
      this.recNomCreateur = var1;
   }

   public String getRecNomModif() {
      return this.recNomModif;
   }

   public void setRecNomModif(String var1) {
      this.recNomModif = var1;
   }

   public String getRecNomResponsable() {
      return this.recNomResponsable;
   }

   public void setRecNomResponsable(String var1) {
      this.recNomResponsable = var1;
   }

   public String getRecNomTiers() {
      return this.recNomTiers;
   }

   public void setRecNomTiers(String var1) {
      this.recNomTiers = var1;
   }

   public String getRecNum() {
      return this.recNum;
   }

   public void setRecNum(String var1) {
      this.recNum = var1;
   }

   public String getRecObject() {
      return this.recObject;
   }

   public void setRecObject(String var1) {
      this.recObject = var1;
   }

   public String getRecObservation() {
      return this.recObservation;
   }

   public void setRecObservation(String var1) {
      this.recObservation = var1;
   }

   public String getRecPdv() {
      return this.recPdv;
   }

   public void setRecPdv(String var1) {
      this.recPdv = var1;
   }

   public String getRecRegion() {
      return this.recRegion;
   }

   public void setRecRegion(String var1) {
      this.recRegion = var1;
   }

   public String getRecSecteur() {
      return this.recSecteur;
   }

   public void setRecSecteur(String var1) {
      this.recSecteur = var1;
   }

   public String getRecSerie() {
      return this.recSerie;
   }

   public void setRecSerie(String var1) {
      this.recSerie = var1;
   }

   public String getRecService() {
      return this.recService;
   }

   public void setRecService(String var1) {
      this.recService = var1;
   }

   public String getRecSite() {
      return this.recSite;
   }

   public void setRecSite(String var1) {
      this.recSite = var1;
   }

   public int getRecSolde() {
      return this.recSolde;
   }

   public void setRecSolde(int var1) {
      this.recSolde = var1;
   }

   public double getRecTotHt() {
      return this.recTotHt;
   }

   public void setRecTotHt(double var1) {
      this.recTotHt = var1;
   }

   public double getRecTotRabais() {
      return this.recTotRabais;
   }

   public void setRecTotRabais(double var1) {
      this.recTotRabais = var1;
   }

   public double getRecTotReglement() {
      return this.recTotReglement;
   }

   public void setRecTotReglement(double var1) {
      this.recTotReglement = var1;
   }

   public double getRecTotRemise() {
      return this.recTotRemise;
   }

   public void setRecTotRemise(double var1) {
      this.recTotRemise = var1;
   }

   public double getRecTotTc() {
      return this.recTotTc;
   }

   public void setRecTotTc(double var1) {
      this.recTotTc = var1;
   }

   public double getRecTotTtc() {
      return this.recTotTtc;
   }

   public void setRecTotTtc(double var1) {
      this.recTotTtc = var1;
   }

   public double getRecTotTva() {
      return this.recTotTva;
   }

   public void setRecTotTva(double var1) {
      this.recTotTva = var1;
   }

   public int getRecTypeReg() {
      return this.recTypeReg;
   }

   public void setRecTypeReg(int var1) {
      this.recTypeReg = var1;
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

   public String getRecInfoLivraison() {
      return this.recInfoLivraison;
   }

   public void setRecInfoLivraison(String var1) {
      this.recInfoLivraison = var1;
   }

   public int getRecExoDouane() {
      return this.recExoDouane;
   }

   public void setRecExoDouane(int var1) {
      this.recExoDouane = var1;
   }

   public int getRecExoTva() {
      return this.recExoTva;
   }

   public void setRecExoTva(int var1) {
      this.recExoTva = var1;
   }

   public String getRecJournalReg() {
      return this.recJournalReg;
   }

   public void setRecJournalReg(String var1) {
      this.recJournalReg = var1;
   }

   public String getRecCivilContact() {
      return this.recCivilContact;
   }

   public void setRecCivilContact(String var1) {
      this.recCivilContact = var1;
   }

   public String getRecCivilTiers() {
      return this.recCivilTiers;
   }

   public void setRecCivilTiers(String var1) {
      this.recCivilTiers = var1;
   }

   public int getRecFactorEtat() {
      return this.recFactorEtat;
   }

   public void setRecFactorEtat(int var1) {
      this.recFactorEtat = var1;
   }

   public long getRecFactorId() {
      return this.recFactorId;
   }

   public void setRecFactorId(long var1) {
      this.recFactorId = var1;
   }

   public String getRecFactorNom() {
      return this.recFactorNom;
   }

   public void setRecFactorNom(String var1) {
      this.recFactorNom = var1;
   }

   public long getRecIdResponsable() {
      return this.recIdResponsable;
   }

   public void setRecIdResponsable(long var1) {
      this.recIdResponsable = var1;
   }

   public String getVar_solde() {
      if (this.recSolde == 1) {
         this.var_solde = "Soldé";
      } else {
         this.var_solde = "";
      }

      return this.var_solde;
   }

   public void setVar_solde(String var1) {
      this.var_solde = var1;
   }

   public String getRecCommentaire() {
      return this.recCommentaire;
   }

   public void setRecCommentaire(String var1) {
      this.recCommentaire = var1;
   }

   public String getRecLivreurNom() {
      return this.recLivreurNom;
   }

   public void setRecLivreurNom(String var1) {
      this.recLivreurNom = var1;
   }

   public String getRecProduction() {
      return this.recProduction;
   }

   public void setRecProduction(String var1) {
      this.recProduction = var1;
   }

   public int getRecTypeTransforme() {
      return this.recTypeTransforme;
   }

   public void setRecTypeTransforme(int var1) {
      this.recTypeTransforme = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getVar_format_devise() {
      if (this.recDevise != null && !this.recDevise.isEmpty()) {
         if (!this.recDevise.equals("XOF") && !this.recDevise.equals("XAF")) {
            if (!this.recDevise.equals("EUR") && !this.recDevise.equals("XEU") && !this.recDevise.equals("CHF")) {
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

   public double getRecBudgetDispoMois() {
      return this.recBudgetDispoMois;
   }

   public void setRecBudgetDispoMois(double var1) {
      this.recBudgetDispoMois = var1;
   }

   public double getRecBudgetTresoMois() {
      return this.recBudgetTresoMois;
   }

   public void setRecBudgetTresoMois(double var1) {
      this.recBudgetTresoMois = var1;
   }

   public String getRecValo() {
      return this.recValo;
   }

   public void setRecValo(String var1) {
      this.recValo = var1;
   }

   public float getRecCoefValo() {
      return this.recCoefValo;
   }

   public void setRecCoefValo(float var1) {
      this.recCoefValo = var1;
   }

   public int getRecValorisation() {
      return this.recValorisation;
   }

   public void setRecValorisation(int var1) {
      this.recValorisation = var1;
   }

   public int getRecMaj() {
      return this.recMaj;
   }

   public void setRecMaj(int var1) {
      this.recMaj = var1;
   }

   public float getRecCoefDevise() {
      return this.recCoefDevise;
   }

   public void setRecCoefDevise(float var1) {
      this.recCoefDevise = var1;
   }

   public float getRecTotPoidsBrut() {
      return this.recTotPoidsBrut;
   }

   public void setRecTotPoidsBrut(float var1) {
      this.recTotPoidsBrut = var1;
   }

   public long getRecIdContact() {
      return this.recIdContact;
   }

   public void setRecIdContact(long var1) {
      this.recIdContact = var1;
   }

   public Date getRecDateFacture() {
      return this.recDateFacture;
   }

   public void setRecDateFacture(Date var1) {
      this.recDateFacture = var1;
   }

   public double getRecTotHtLocal() {
      return this.recTotHtLocal;
   }

   public void setRecTotHtLocal(double var1) {
      this.recTotHtLocal = var1;
   }

   public double getRecTotRabaisLocal() {
      return this.recTotRabaisLocal;
   }

   public void setRecTotRabaisLocal(double var1) {
      this.recTotRabaisLocal = var1;
   }

   public double getRecTotRemiseLocal() {
      return this.recTotRemiseLocal;
   }

   public void setRecTotRemiseLocal(double var1) {
      this.recTotRemiseLocal = var1;
   }

   public double getRecTotTtcLocal() {
      return this.recTotTtcLocal;
   }

   public void setRecTotTtcLocal(double var1) {
      this.recTotTtcLocal = var1;
   }

   public double getRecTotTvaLocal() {
      return this.recTotTvaLocal;
   }

   public void setRecTotTvaLocal(double var1) {
      this.recTotTvaLocal = var1;
   }

   public double getRecTotFret() {
      return this.recTotFret;
   }

   public void setRecTotFret(double var1) {
      this.recTotFret = var1;
   }

   public double getRecTotFretLocal() {
      return this.recTotFretLocal;
   }

   public void setRecTotFretLocal(double var1) {
      this.recTotFretLocal = var1;
   }

   public double getRecTotAssurance() {
      return this.recTotAssurance;
   }

   public void setRecTotAssurance(double var1) {
      this.recTotAssurance = var1;
   }

   public double getRecTotAssuranceLocal() {
      return this.recTotAssuranceLocal;
   }

   public void setRecTotAssuranceLocal(double var1) {
      this.recTotAssuranceLocal = var1;
   }

   public String getRecNumFature() {
      return this.recNumFature;
   }

   public void setRecNumFature(String var1) {
      this.recNumFature = var1;
   }

   public float getRecTotQte() {
      return this.recTotQte;
   }

   public void setRecTotQte(float var1) {
      this.recTotQte = var1;
   }

   public String getRecDiversAdresse() {
      return this.recDiversAdresse;
   }

   public void setRecDiversAdresse(String var1) {
      this.recDiversAdresse = var1;
   }

   public String getRecDiversMail() {
      return this.recDiversMail;
   }

   public void setRecDiversMail(String var1) {
      this.recDiversMail = var1;
   }

   public String getRecDiversNom() {
      return this.recDiversNom;
   }

   public void setRecDiversNom(String var1) {
      this.recDiversNom = var1;
   }

   public String getRecDiversTel() {
      return this.recDiversTel;
   }

   public void setRecDiversTel(String var1) {
      this.recDiversTel = var1;
   }

   public int getRecDiversTiers() {
      return this.recDiversTiers;
   }

   public void setRecDiversTiers(int var1) {
      this.recDiversTiers = var1;
   }

   public String getRecDiversVille() {
      return this.recDiversVille;
   }

   public void setRecDiversVille(String var1) {
      this.recDiversVille = var1;
   }

   public String getRecNomTransitaire() {
      return this.recNomTransitaire;
   }

   public void setRecNomTransitaire(String var1) {
      this.recNomTransitaire = var1;
   }

   public double getRecTotFret2() {
      return this.recTotFret2;
   }

   public void setRecTotFret2(double var1) {
      this.recTotFret2 = var1;
   }

   public double getRecTotFret2Local() {
      return this.recTotFret2Local;
   }

   public void setRecTotFret2Local(double var1) {
      this.recTotFret2Local = var1;
   }

   public int getRecPosSignature() {
      return this.recPosSignature;
   }

   public void setRecPosSignature(int var1) {
      this.recPosSignature = var1;
   }

   public boolean isRecExcluValo() {
      return this.recExcluValo;
   }

   public void setRecExcluValo(boolean var1) {
      this.recExcluValo = var1;
   }

   public double getRecTotCertificat() {
      return this.recTotCertificat;
   }

   public void setRecTotCertificat(double var1) {
      this.recTotCertificat = var1;
   }

   public double getRecTotCertificatConformite() {
      return this.recTotCertificatConformite;
   }

   public void setRecTotCertificatConformite(double var1) {
      this.recTotCertificatConformite = var1;
   }

   public double getRecTotCertificatConformiteLocal() {
      return this.recTotCertificatConformiteLocal;
   }

   public void setRecTotCertificatConformiteLocal(double var1) {
      this.recTotCertificatConformiteLocal = var1;
   }

   public double getRecTotCertificatLocal() {
      return this.recTotCertificatLocal;
   }

   public void setRecTotCertificatLocal(double var1) {
      this.recTotCertificatLocal = var1;
   }

   public double getRecTotFraisAdm() {
      return this.recTotFraisAdm;
   }

   public void setRecTotFraisAdm(double var1) {
      this.recTotFraisAdm = var1;
   }

   public double getRecTotFraisAdmLocal() {
      return this.recTotFraisAdmLocal;
   }

   public void setRecTotFraisAdmLocal(double var1) {
      this.recTotFraisAdmLocal = var1;
   }

   public String getRecAffaire() {
      return this.recAffaire;
   }

   public void setRecAffaire(String var1) {
      this.recAffaire = var1;
   }

   public boolean isRecPj() {
      return this.recPj;
   }

   public void setRecPj(boolean var1) {
      this.recPj = var1;
   }

   public String getRecSource() {
      return this.recSource;
   }

   public void setRecSource(String var1) {
      this.recSource = var1;
   }

   public String getRecAnal1() {
      return this.recAnal1;
   }

   public void setRecAnal1(String var1) {
      this.recAnal1 = var1;
   }
}
