package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CotationEnteteAchats implements Serializable {
   private long cotId;
   private Date cotDate;
   private Date cotDateCreat;
   private Date cotDateModif;
   private String cotNum;
   private int cotType;
   private String cotLibellePrestation;
   private String cotLibelleFrais;
   private long cotIdCreateur;
   private long cotIdModif;
   private String cotNomCreateur;
   private String cotNomModif;
   private String cotNomResponsable;
   private long cotIdResponsable;
   private String cotNomTransporteur;
   private long cotIdTransport;
   private long cotIdTransporteur;
   private String cotNomTransitaire;
   private long cotIdTansit;
   private long cotIdTansitaire;
   private String cotNomTiers;
   private String cotCivilTiers;
   private long cotIdContact;
   private String cotNomContact;
   private String cotCivilContact;
   private String cotSerie;
   private int cotExoTva;
   private int cotExoDouane;
   private int cotContener;
   private int cotNbContener;
   private int cotNbBl;
   private int cotZone;
   private int cotModeTransport;
   private int cotAvion;
   private int cotBateau;
   private int cotExpress;
   private int cotRoute;
   private int cotTrain;
   private int cotReachem1;
   private int cotReachem2;
   private int cotReachem3;
   private String cotCat;
   private String cotDevise;
   private float cotCoefDevise;
   private String cotObject;
   private String cotObservation;
   private String cotBudget;
   private double cotTotCertificat;
   private double cotTotCertificatConf;
   private double cotTotHt;
   private double cotTotEmballage;
   private double cotTotComplement;
   private float cotTotPoidsBrut;
   private float cotTotVolume;
   private float cotTotPoidsTaxable;
   private boolean cotForcePoidsVol;
   private float cotCoefMarge;
   private float cotCoefPRP;
   private float cotTotQte;
   private double cotBudgetTreso;
   private double cotBudgetDispo;
   private double cotBudgetDispoMois;
   private double cotBudgetTresoMois;
   private double cotTotRemise;
   private double cotTotRabais;
   private double cotTotTva;
   private double cotTotTc;
   private double cotTotTtc;
   private double cotTotPRP;
   private double cotTotFob;
   private double cotTotFret;
   private double cotTotAssurance;
   private double cotTotTVente;
   private double cotTotTVentePropose;
   private String cotBanque;
   private int cotTypeReg;
   private String cotModeReg;
   private int cotNbJourReg;
   private int cotArrondiReg;
   private String cotConditionReg;
   private Date cotDateEcheReg;
   private String cotActivite;
   private String cotSite;
   private String cotDepartement;
   private String cotService;
   private String cotRegion;
   private String cotSecteur;
   private String cotPdv;
   private String cotAnal1;
   private String cotAnal2;
   private String cotAnal4;
   private String cotAffaire;
   private String cotInfo1;
   private String cotInfo2;
   private String cotInfo3;
   private String cotInfo4;
   private String cotInfo5;
   private String cotInfo6;
   private String cotInfo7;
   private String cotInfo8;
   private String cotInfo9;
   private String cotInfo10;
   private String cotFormule1;
   private String cotFormule2;
   private String cotAnnexe1;
   private String cotAnnexe2;
   private String cotContrat;
   private String cotIncoterm;
   private String cotLieuLivraison;
   private Date cotDateLivraison;
   private String cotInfoLivraison;
   private Date cotDateImp;
   private int cotTypeImp;
   private String cotModeleImp;
   private int cotEtatVal;
   private int cotGele;
   private int cotEtat;
   private Date cotDateValidite;
   private Date cotDateRelance;
   private Date cotDateValide;
   private int cotPosSignature;
   private Date cotDateTransforme;
   private int cotTypeTransforme;
   private Date cotDateAnnule;
   private String cotMotifAnnule;
   private int cotDiversTiers;
   private String cotDiversNom;
   private String cotDiversAdresse;
   private String cotDiversVille;
   private String cotDiversTel;
   private String cotDiversMail;
   private String cotModelePr;
   private int cotNbDeclaration;
   private int cotNbExpedition;
   private int cotNbDossier;
   private double cotTransportUsine;
   private String cotUnitePayante;
   private String cotSource;
   private ExercicesAchats exercicesAchats;
   private Tiers tiers;
   private Users users;
   private String libelleEta;
   private boolean var_select_ligne;
   private int var_format_devise;
   private String var_nomContact;
   private String var_nom_tiers;
   private double totalPRP;
   private String nomCommercial;
   private String nomResponsable;
   private String nomClient;
   private String nomContactClient;
   private String source;
   private String position;
   private String libelleModeTrp;

   public String getLibelleModeTrp() {
      if (this.cotType == 0) {
         if (this.cotModeTransport == 0) {
            this.libelleModeTrp = "Aérien";
         } else if (this.cotModeTransport == 1) {
            this.libelleModeTrp = "Maritime";
         } else if (this.cotModeTransport == 2) {
            this.libelleModeTrp = "Express";
         } else if (this.cotModeTransport == 3) {
            this.libelleModeTrp = "Terrestre";
         } else if (this.cotModeTransport == 4) {
            this.libelleModeTrp = "Ferrovier";
         } else {
            this.libelleModeTrp = "???";
         }
      } else if (this.cotType == 1) {
         this.libelleModeTrp = "Prestations";
      } else if (this.cotType == 2) {
         this.libelleModeTrp = "Local";
      } else {
         this.libelleModeTrp = "???";
      }

      return this.libelleModeTrp;
   }

   public void setLibelleModeTrp(String var1) {
      this.libelleModeTrp = var1;
   }

   public String getPosition() {
      return this.position;
   }

   public void setPosition(String var1) {
      this.position = var1;
   }

   public String getSource() {
      return this.source;
   }

   public void setSource(String var1) {
      this.source = var1;
   }

   public String getNomContactClient() {
      return this.nomContactClient;
   }

   public void setNomContactClient(String var1) {
      this.nomContactClient = var1;
   }

   public String getNomCommercial() {
      return this.nomCommercial;
   }

   public void setNomCommercial(String var1) {
      this.nomCommercial = var1;
   }

   public String getNomClient() {
      return this.nomClient;
   }

   public void setNomClient(String var1) {
      this.nomClient = var1;
   }

   public String getNomResponsable() {
      return this.nomResponsable;
   }

   public void setNomResponsable(String var1) {
      this.nomResponsable = var1;
   }

   public double getTotalPRP() {
      this.totalPRP = (double)this.cotCoefPRP;
      return this.totalPRP;
   }

   public void setTotalPRP(double var1) {
      this.totalPRP = var1;
   }

   public String getVar_nom_tiers() {
      if (this.cotDiversNom != null && !this.cotDiversNom.isEmpty()) {
         this.var_nom_tiers = this.cotDiversNom;
      } else if (this.cotCivilTiers != null && !this.cotCivilTiers.isEmpty()) {
         this.var_nom_tiers = this.cotCivilTiers + " " + this.cotNomTiers;
      } else {
         this.var_nom_tiers = this.cotNomTiers;
      }

      return this.var_nom_tiers;
   }

   public void setVar_nom_tiers(String var1) {
      this.var_nom_tiers = var1;
   }

   public String getVar_nomContact() {
      if (this.cotDiversNom != null && !this.cotDiversNom.isEmpty()) {
         this.var_nomContact = "(fournisseur divers)";
      } else if (this.cotCivilContact != null && !this.cotCivilContact.isEmpty()) {
         if (this.cotNomContact != null && !this.cotNomContact.isEmpty()) {
            this.var_nomContact = this.cotCivilContact + " " + this.cotNomContact;
         } else {
            this.var_nomContact = "";
         }
      } else if (this.cotNomContact != null && !this.cotNomContact.isEmpty()) {
         this.var_nomContact = this.cotNomContact;
      } else {
         this.var_nomContact = "";
      }

      return this.var_nomContact;
   }

   public void setVar_nomContact(String var1) {
      this.var_nomContact = var1;
   }

   public String getLibelleEta() {
      if (this.cotEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.cotEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.cotEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.cotEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.cotEtat == 4) {
         this.libelleEta = "Trf.P.";
      } else if (this.cotEtat == 5) {
         this.libelleEta = "Trf.T.";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public String getCotActivite() {
      return this.cotActivite;
   }

   public void setCotActivite(String var1) {
      this.cotActivite = var1;
   }

   public String getCotAnal4() {
      return this.cotAnal4;
   }

   public void setCotAnal4(String var1) {
      this.cotAnal4 = var1;
   }

   public String getCotAnnexe1() {
      return this.cotAnnexe1;
   }

   public void setCotAnnexe1(String var1) {
      this.cotAnnexe1 = var1;
   }

   public String getCotAnnexe2() {
      return this.cotAnnexe2;
   }

   public void setCotAnnexe2(String var1) {
      this.cotAnnexe2 = var1;
   }

   public String getCotBudget() {
      return this.cotBudget;
   }

   public void setCotBudget(String var1) {
      this.cotBudget = var1;
   }

   public String getCotCat() {
      return this.cotCat;
   }

   public void setCotCat(String var1) {
      this.cotCat = var1;
   }

   public String getCotContrat() {
      return this.cotContrat;
   }

   public void setCotContrat(String var1) {
      this.cotContrat = var1;
   }

   public Date getCotDate() {
      return this.cotDate;
   }

   public void setCotDate(Date var1) {
      this.cotDate = var1;
   }

   public Date getCotDateAnnule() {
      return this.cotDateAnnule;
   }

   public void setCotDateAnnule(Date var1) {
      this.cotDateAnnule = var1;
   }

   public Date getCotDateImp() {
      return this.cotDateImp;
   }

   public void setCotDateImp(Date var1) {
      this.cotDateImp = var1;
   }

   public Date getCotDateLivraison() {
      return this.cotDateLivraison;
   }

   public void setCotDateLivraison(Date var1) {
      this.cotDateLivraison = var1;
   }

   public Date getCotDateRelance() {
      return this.cotDateRelance;
   }

   public void setCotDateRelance(Date var1) {
      this.cotDateRelance = var1;
   }

   public Date getCotDateTransforme() {
      return this.cotDateTransforme;
   }

   public void setCotDateTransforme(Date var1) {
      this.cotDateTransforme = var1;
   }

   public Date getCotDateValide() {
      return this.cotDateValide;
   }

   public void setCotDateValide(Date var1) {
      this.cotDateValide = var1;
   }

   public Date getCotDateValidite() {
      return this.cotDateValidite;
   }

   public void setCotDateValidite(Date var1) {
      this.cotDateValidite = var1;
   }

   public String getCotDepartement() {
      return this.cotDepartement;
   }

   public void setCotDepartement(String var1) {
      this.cotDepartement = var1;
   }

   public String getCotDevise() {
      return this.cotDevise;
   }

   public void setCotDevise(String var1) {
      this.cotDevise = var1;
   }

   public int getCotEtat() {
      return this.cotEtat;
   }

   public void setCotEtat(int var1) {
      this.cotEtat = var1;
   }

   public int getCotEtatVal() {
      return this.cotEtatVal;
   }

   public void setCotEtatVal(int var1) {
      this.cotEtatVal = var1;
   }

   public String getCotFormule1() {
      return this.cotFormule1;
   }

   public void setCotFormule1(String var1) {
      this.cotFormule1 = var1;
   }

   public String getCotFormule2() {
      return this.cotFormule2;
   }

   public void setCotFormule2(String var1) {
      this.cotFormule2 = var1;
   }

   public int getCotGele() {
      return this.cotGele;
   }

   public void setCotGele(int var1) {
      this.cotGele = var1;
   }

   public long getCotId() {
      return this.cotId;
   }

   public void setCotId(long var1) {
      this.cotId = var1;
   }

   public long getCotIdCreateur() {
      return this.cotIdCreateur;
   }

   public void setCotIdCreateur(long var1) {
      this.cotIdCreateur = var1;
   }

   public String getCotIncoterm() {
      return this.cotIncoterm;
   }

   public void setCotIncoterm(String var1) {
      this.cotIncoterm = var1;
   }

   public String getCotInfo1() {
      return this.cotInfo1;
   }

   public void setCotInfo1(String var1) {
      this.cotInfo1 = var1;
   }

   public String getCotInfo10() {
      return this.cotInfo10;
   }

   public void setCotInfo10(String var1) {
      this.cotInfo10 = var1;
   }

   public String getCotInfo2() {
      return this.cotInfo2;
   }

   public void setCotInfo2(String var1) {
      this.cotInfo2 = var1;
   }

   public String getCotInfo3() {
      return this.cotInfo3;
   }

   public void setCotInfo3(String var1) {
      this.cotInfo3 = var1;
   }

   public String getCotInfo4() {
      return this.cotInfo4;
   }

   public void setCotInfo4(String var1) {
      this.cotInfo4 = var1;
   }

   public String getCotInfo5() {
      return this.cotInfo5;
   }

   public void setCotInfo5(String var1) {
      this.cotInfo5 = var1;
   }

   public String getCotInfo6() {
      return this.cotInfo6;
   }

   public void setCotInfo6(String var1) {
      this.cotInfo6 = var1;
   }

   public String getCotInfo7() {
      return this.cotInfo7;
   }

   public void setCotInfo7(String var1) {
      this.cotInfo7 = var1;
   }

   public String getCotInfo8() {
      return this.cotInfo8;
   }

   public void setCotInfo8(String var1) {
      this.cotInfo8 = var1;
   }

   public String getCotInfo9() {
      return this.cotInfo9;
   }

   public void setCotInfo9(String var1) {
      this.cotInfo9 = var1;
   }

   public String getCotInfoLivraison() {
      return this.cotInfoLivraison;
   }

   public void setCotInfoLivraison(String var1) {
      this.cotInfoLivraison = var1;
   }

   public String getCotLieuLivraison() {
      return this.cotLieuLivraison;
   }

   public void setCotLieuLivraison(String var1) {
      this.cotLieuLivraison = var1;
   }

   public String getCotModeleImp() {
      return this.cotModeleImp;
   }

   public void setCotModeleImp(String var1) {
      this.cotModeleImp = var1;
   }

   public String getCotMotifAnnule() {
      return this.cotMotifAnnule;
   }

   public void setCotMotifAnnule(String var1) {
      this.cotMotifAnnule = var1;
   }

   public String getCotNomContact() {
      return this.cotNomContact;
   }

   public void setCotNomContact(String var1) {
      this.cotNomContact = var1;
   }

   public String getCotNomCreateur() {
      return this.cotNomCreateur;
   }

   public void setCotNomCreateur(String var1) {
      this.cotNomCreateur = var1;
   }

   public String getCotNomResponsable() {
      return this.cotNomResponsable;
   }

   public void setCotNomResponsable(String var1) {
      this.cotNomResponsable = var1;
   }

   public String getCotNomTiers() {
      return this.cotNomTiers;
   }

   public void setCotNomTiers(String var1) {
      this.cotNomTiers = var1;
   }

   public String getCotNum() {
      return this.cotNum;
   }

   public void setCotNum(String var1) {
      this.cotNum = var1;
   }

   public String getCotObject() {
      return this.cotObject;
   }

   public void setCotObject(String var1) {
      this.cotObject = var1;
   }

   public String getCotObservation() {
      return this.cotObservation;
   }

   public void setCotObservation(String var1) {
      this.cotObservation = var1;
   }

   public String getCotPdv() {
      return this.cotPdv;
   }

   public void setCotPdv(String var1) {
      this.cotPdv = var1;
   }

   public String getCotRegion() {
      return this.cotRegion;
   }

   public void setCotRegion(String var1) {
      this.cotRegion = var1;
   }

   public String getCotSecteur() {
      return this.cotSecteur;
   }

   public void setCotSecteur(String var1) {
      this.cotSecteur = var1;
   }

   public String getCotSerie() {
      return this.cotSerie;
   }

   public void setCotSerie(String var1) {
      this.cotSerie = var1;
   }

   public String getCotService() {
      return this.cotService;
   }

   public void setCotService(String var1) {
      this.cotService = var1;
   }

   public String getCotSite() {
      return this.cotSite;
   }

   public void setCotSite(String var1) {
      this.cotSite = var1;
   }

   public double getCotTotTtc() {
      return this.cotTotTtc;
   }

   public void setCotTotTtc(double var1) {
      this.cotTotTtc = var1;
   }

   public int getCotTypeImp() {
      return this.cotTypeImp;
   }

   public void setCotTypeImp(int var1) {
      this.cotTypeImp = var1;
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

   public String getCotAnal2() {
      return this.cotAnal2;
   }

   public void setCotAnal2(String var1) {
      this.cotAnal2 = var1;
   }

   public Date getCotDateModif() {
      return this.cotDateModif;
   }

   public void setCotDateModif(Date var1) {
      this.cotDateModif = var1;
   }

   public long getCotIdModif() {
      return this.cotIdModif;
   }

   public void setCotIdModif(long var1) {
      this.cotIdModif = var1;
   }

   public String getCotNomModif() {
      return this.cotNomModif;
   }

   public void setCotNomModif(String var1) {
      this.cotNomModif = var1;
   }

   public double getCotTotHt() {
      return this.cotTotHt;
   }

   public void setCotTotHt(double var1) {
      this.cotTotHt = var1;
   }

   public double getCotTotRabais() {
      return this.cotTotRabais;
   }

   public void setCotTotRabais(double var1) {
      this.cotTotRabais = var1;
   }

   public double getCotTotRemise() {
      return this.cotTotRemise;
   }

   public void setCotTotRemise(double var1) {
      this.cotTotRemise = var1;
   }

   public double getCotTotTc() {
      return this.cotTotTc;
   }

   public void setCotTotTc(double var1) {
      this.cotTotTc = var1;
   }

   public double getCotTotTva() {
      return this.cotTotTva;
   }

   public void setCotTotTva(double var1) {
      this.cotTotTva = var1;
   }

   public double getCotBudgetDispo() {
      return this.cotBudgetDispo;
   }

   public void setCotBudgetDispo(double var1) {
      this.cotBudgetDispo = var1;
   }

   public double getCotBudgetTreso() {
      return this.cotBudgetTreso;
   }

   public void setCotBudgetTreso(double var1) {
      this.cotBudgetTreso = var1;
   }

   public String getCotCivilTiers() {
      return this.cotCivilTiers;
   }

   public void setCotCivilTiers(String var1) {
      this.cotCivilTiers = var1;
   }

   public int getCotArrondiReg() {
      return this.cotArrondiReg;
   }

   public void setCotArrondiReg(int var1) {
      this.cotArrondiReg = var1;
   }

   public String getCotCivilContact() {
      return this.cotCivilContact;
   }

   public void setCotCivilContact(String var1) {
      this.cotCivilContact = var1;
   }

   public String getCotConditionReg() {
      return this.cotConditionReg;
   }

   public void setCotConditionReg(String var1) {
      this.cotConditionReg = var1;
   }

   public Date getCotDateEcheReg() {
      return this.cotDateEcheReg;
   }

   public void setCotDateEcheReg(Date var1) {
      this.cotDateEcheReg = var1;
   }

   public int getCotExoDouane() {
      return this.cotExoDouane;
   }

   public void setCotExoDouane(int var1) {
      this.cotExoDouane = var1;
   }

   public int getCotExoTva() {
      return this.cotExoTva;
   }

   public void setCotExoTva(int var1) {
      this.cotExoTva = var1;
   }

   public String getCotModeReg() {
      return this.cotModeReg;
   }

   public void setCotModeReg(String var1) {
      this.cotModeReg = var1;
   }

   public int getCotNbJourReg() {
      return this.cotNbJourReg;
   }

   public void setCotNbJourReg(int var1) {
      this.cotNbJourReg = var1;
   }

   public int getCotTypeReg() {
      return this.cotTypeReg;
   }

   public void setCotTypeReg(int var1) {
      this.cotTypeReg = var1;
   }

   public Date getCotDateCreat() {
      return this.cotDateCreat;
   }

   public void setCotDateCreat(Date var1) {
      this.cotDateCreat = var1;
   }

   public long getCotIdResponsable() {
      return this.cotIdResponsable;
   }

   public void setCotIdResponsable(long var1) {
      this.cotIdResponsable = var1;
   }

   public String getCotBanque() {
      return this.cotBanque;
   }

   public void setCotBanque(String var1) {
      this.cotBanque = var1;
   }

   public int getCotTypeTransforme() {
      return this.cotTypeTransforme;
   }

   public void setCotTypeTransforme(int var1) {
      this.cotTypeTransforme = var1;
   }

   public boolean isVar_select_ligne() {
      return this.var_select_ligne;
   }

   public void setVar_select_ligne(boolean var1) {
      this.var_select_ligne = var1;
   }

   public int getVar_format_devise() {
      if (!this.cotDevise.equals("XOF") && !this.cotDevise.equals("XAF")) {
         if (!this.cotDevise.equals("EUR") && !this.cotDevise.equals("XEU") && !this.cotDevise.equals("CHF")) {
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

   public double getCotBudgetDispoMois() {
      return this.cotBudgetDispoMois;
   }

   public void setCotBudgetDispoMois(double var1) {
      this.cotBudgetDispoMois = var1;
   }

   public double getCotBudgetTresoMois() {
      return this.cotBudgetTresoMois;
   }

   public void setCotBudgetTresoMois(double var1) {
      this.cotBudgetTresoMois = var1;
   }

   public long getCotIdContact() {
      return this.cotIdContact;
   }

   public void setCotIdContact(long var1) {
      this.cotIdContact = var1;
   }

   public String getCotDiversAdresse() {
      return this.cotDiversAdresse;
   }

   public void setCotDiversAdresse(String var1) {
      this.cotDiversAdresse = var1;
   }

   public String getCotDiversMail() {
      return this.cotDiversMail;
   }

   public void setCotDiversMail(String var1) {
      this.cotDiversMail = var1;
   }

   public String getCotDiversNom() {
      return this.cotDiversNom;
   }

   public void setCotDiversNom(String var1) {
      this.cotDiversNom = var1;
   }

   public String getCotDiversTel() {
      return this.cotDiversTel;
   }

   public void setCotDiversTel(String var1) {
      this.cotDiversTel = var1;
   }

   public int getCotDiversTiers() {
      return this.cotDiversTiers;
   }

   public void setCotDiversTiers(int var1) {
      this.cotDiversTiers = var1;
   }

   public String getCotDiversVille() {
      return this.cotDiversVille;
   }

   public void setCotDiversVille(String var1) {
      this.cotDiversVille = var1;
   }

   public String getCotModelePr() {
      return this.cotModelePr;
   }

   public void setCotModelePr(String var1) {
      this.cotModelePr = var1;
   }

   public float getCotCoefDevise() {
      return this.cotCoefDevise;
   }

   public void setCotCoefDevise(float var1) {
      this.cotCoefDevise = var1;
   }

   public float getCotTotPoidsBrut() {
      return this.cotTotPoidsBrut;
   }

   public void setCotTotPoidsBrut(float var1) {
      this.cotTotPoidsBrut = var1;
   }

   public float getCotTotQte() {
      return this.cotTotQte;
   }

   public void setCotTotQte(float var1) {
      this.cotTotQte = var1;
   }

   public int getCotPosSignature() {
      return this.cotPosSignature;
   }

   public void setCotPosSignature(int var1) {
      this.cotPosSignature = var1;
   }

   public long getCotIdTansitaire() {
      return this.cotIdTansitaire;
   }

   public void setCotIdTansitaire(long var1) {
      this.cotIdTansitaire = var1;
   }

   public long getCotIdTransporteur() {
      return this.cotIdTransporteur;
   }

   public void setCotIdTransporteur(long var1) {
      this.cotIdTransporteur = var1;
   }

   public String getCotNomTransitaire() {
      return this.cotNomTransitaire;
   }

   public void setCotNomTransitaire(String var1) {
      this.cotNomTransitaire = var1;
   }

   public String getCotNomTransporteur() {
      return this.cotNomTransporteur;
   }

   public void setCotNomTransporteur(String var1) {
      this.cotNomTransporteur = var1;
   }

   public int getCotAvion() {
      return this.cotAvion;
   }

   public void setCotAvion(int var1) {
      this.cotAvion = var1;
   }

   public int getCotBateau() {
      return this.cotBateau;
   }

   public void setCotBateau(int var1) {
      this.cotBateau = var1;
   }

   public int getCotExpress() {
      return this.cotExpress;
   }

   public void setCotExpress(int var1) {
      this.cotExpress = var1;
   }

   public int getCotReachem1() {
      return this.cotReachem1;
   }

   public void setCotReachem1(int var1) {
      this.cotReachem1 = var1;
   }

   public int getCotReachem2() {
      return this.cotReachem2;
   }

   public void setCotReachem2(int var1) {
      this.cotReachem2 = var1;
   }

   public int getCotReachem3() {
      return this.cotReachem3;
   }

   public void setCotReachem3(int var1) {
      this.cotReachem3 = var1;
   }

   public int getCotRoute() {
      return this.cotRoute;
   }

   public void setCotRoute(int var1) {
      this.cotRoute = var1;
   }

   public float getCotTotVolume() {
      return this.cotTotVolume;
   }

   public void setCotTotVolume(float var1) {
      this.cotTotVolume = var1;
   }

   public double getCotTotComplement() {
      return this.cotTotComplement;
   }

   public void setCotTotComplement(double var1) {
      this.cotTotComplement = var1;
   }

   public double getCotTotEmballage() {
      return this.cotTotEmballage;
   }

   public void setCotTotEmballage(double var1) {
      this.cotTotEmballage = var1;
   }

   public boolean isCotForcePoidsVol() {
      return this.cotForcePoidsVol;
   }

   public void setCotForcePoidsVol(boolean var1) {
      this.cotForcePoidsVol = var1;
   }

   public float getCotCoefMarge() {
      return this.cotCoefMarge;
   }

   public void setCotCoefMarge(float var1) {
      this.cotCoefMarge = var1;
   }

   public double getCotTotTVente() {
      return this.cotTotTVente;
   }

   public void setCotTotTVente(double var1) {
      this.cotTotTVente = var1;
   }

   public long getCotIdTansit() {
      return this.cotIdTansit;
   }

   public void setCotIdTansit(long var1) {
      this.cotIdTansit = var1;
   }

   public long getCotIdTransport() {
      return this.cotIdTransport;
   }

   public void setCotIdTransport(long var1) {
      this.cotIdTransport = var1;
   }

   public int getCotContener() {
      return this.cotContener;
   }

   public void setCotContener(int var1) {
      this.cotContener = var1;
   }

   public int getCotTrain() {
      return this.cotTrain;
   }

   public void setCotTrain(int var1) {
      this.cotTrain = var1;
   }

   public double getCotTotPRP() {
      return this.cotTotPRP;
   }

   public void setCotTotPRP(double var1) {
      this.cotTotPRP = var1;
   }

   public float getCotCoefPRP() {
      return this.cotCoefPRP;
   }

   public void setCotCoefPRP(float var1) {
      this.cotCoefPRP = var1;
   }

   public double getCotTotAssurance() {
      return this.cotTotAssurance;
   }

   public void setCotTotAssurance(double var1) {
      this.cotTotAssurance = var1;
   }

   public double getCotTotFob() {
      return this.cotTotFob;
   }

   public void setCotTotFob(double var1) {
      this.cotTotFob = var1;
   }

   public double getCotTotFret() {
      return this.cotTotFret;
   }

   public void setCotTotFret(double var1) {
      this.cotTotFret = var1;
   }

   public int getCotNbBl() {
      return this.cotNbBl;
   }

   public void setCotNbBl(int var1) {
      this.cotNbBl = var1;
   }

   public int getCotNbContener() {
      return this.cotNbContener;
   }

   public void setCotNbContener(int var1) {
      this.cotNbContener = var1;
   }

   public int getCotZone() {
      return this.cotZone;
   }

   public void setCotZone(int var1) {
      this.cotZone = var1;
   }

   public int getCotNbDeclaration() {
      return this.cotNbDeclaration;
   }

   public void setCotNbDeclaration(int var1) {
      this.cotNbDeclaration = var1;
   }

   public int getCotNbDossier() {
      return this.cotNbDossier;
   }

   public void setCotNbDossier(int var1) {
      this.cotNbDossier = var1;
   }

   public int getCotNbExpedition() {
      return this.cotNbExpedition;
   }

   public void setCotNbExpedition(int var1) {
      this.cotNbExpedition = var1;
   }

   public double getCotTransportUsine() {
      return this.cotTransportUsine;
   }

   public void setCotTransportUsine(double var1) {
      this.cotTransportUsine = var1;
   }

   public double getCotTotCertificat() {
      return this.cotTotCertificat;
   }

   public void setCotTotCertificat(double var1) {
      this.cotTotCertificat = var1;
   }

   public double getCotTotCertificatConf() {
      return this.cotTotCertificatConf;
   }

   public void setCotTotCertificatConf(double var1) {
      this.cotTotCertificatConf = var1;
   }

   public double getCotTotTVentePropose() {
      return this.cotTotTVentePropose;
   }

   public void setCotTotTVentePropose(double var1) {
      this.cotTotTVentePropose = var1;
   }

   public float getCotTotPoidsTaxable() {
      return this.cotTotPoidsTaxable;
   }

   public void setCotTotPoidsTaxable(float var1) {
      this.cotTotPoidsTaxable = var1;
   }

   public int getCotType() {
      return this.cotType;
   }

   public void setCotType(int var1) {
      this.cotType = var1;
   }

   public String getCotLibellePrestation() {
      return this.cotLibellePrestation;
   }

   public void setCotLibellePrestation(String var1) {
      this.cotLibellePrestation = var1;
   }

   public String getCotLibelleFrais() {
      return this.cotLibelleFrais;
   }

   public void setCotLibelleFrais(String var1) {
      this.cotLibelleFrais = var1;
   }

   public String getCotAffaire() {
      return this.cotAffaire;
   }

   public void setCotAffaire(String var1) {
      this.cotAffaire = var1;
   }

   public int getCotModeTransport() {
      return this.cotModeTransport;
   }

   public void setCotModeTransport(int var1) {
      this.cotModeTransport = var1;
   }

   public String getCotUnitePayante() {
      return this.cotUnitePayante;
   }

   public void setCotUnitePayante(String var1) {
      this.cotUnitePayante = var1;
   }

   public String getCotSource() {
      return this.cotSource;
   }

   public void setCotSource(String var1) {
      this.cotSource = var1;
   }

   public String getCotAnal1() {
      return this.cotAnal1;
   }

   public void setCotAnal1(String var1) {
      this.cotAnal1 = var1;
   }
}
