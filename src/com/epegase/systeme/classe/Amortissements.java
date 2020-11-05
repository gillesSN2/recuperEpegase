package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Amortissements implements Serializable {
   private long amoId;
   private long amoOldId;
   private long amoIdReception;
   private Date amoDateCreat;
   private Date amoDateModif;
   private long amoUserCreat;
   private long amoUserModif;
   private long amoNum;
   private String amoCompteAmo;
   private String amoLibelle;
   private Date amoDateAchat;
   private Date amoDateService;
   private double amoValeurAchat;
   private double amoValeurReevalue;
   private Date amoDateReevalue;
   private float amoTvaTaux;
   private double amoTvaTotal;
   private double amoTvaResiduelle;
   private int amoMode;
   private float amoTauxComptable;
   private float amoNbAnneeCpte;
   private float amoTauxFiscal;
   private float amoNbAnneeFiscal;
   private double amoAnterieur;
   private Date amoDateAnterieur;
   private String amoReference;
   private String amoPieceAchat;
   private String amoChassis;
   private int amoNature;
   private int amoNatureDetail;
   private String amoNatureDetailLib;
   private String amoInfosCpl;
   private String amoFournisseur;
   private String amoLibFournisseur;
   private String amoOrigine;
   private String amoSite;
   private String amoLibSite;
   private String amoDepartement;
   private String amoLibDepartement;
   private String amoService;
   private String amoLibService;
   private String amoRegion;
   private String amoLibRegion;
   private String amoSecteur;
   private String amoLibSecteur;
   private String amoPdv;
   private String amoLibPdv;
   private String amoDossier;
   private String amoLibDossier;
   private String amoMission;
   private String amoLibMission;
   private String amoParc;
   private String amoLibParc;
   private String amoAgent;
   private String amoLibAgent;
   private String amoCle1;
   private String amoLibCle1;
   private String amoActivite;
   private String amoLibActivite;
   private String amoProjet;
   private String amoLibProjet;
   private String amoBudget;
   private String amoLibBudget;
   private String amoLocalisation;
   private Date amoPeriodeDeb;
   private Date amoPeriodeFin;
   private double amoDotation;
   private double amoTotalAmort;
   private double amoValeurResiduelle;
   private Date amoDateSortie;
   private int amoTypeSortie;
   private String amoNomClient;
   private double amoValeurCession;
   private double amoFraisAnnexe;
   private int amoReinvestissement;
   private String amoFactureCession;
   private String amoPieceCession;
   private double amoNetAPayer;
   private double amoTotalReglement;
   private double amoSolde;
   private int amoFinancement;
   private String amoLibCompteAmo;
   private String amoLibCompteImo;
   private String amoLibCompteDot;
   private String amoCompteDotation;
   private String amoCompteImmo;
   private int amoInactif;
   private String amoFactureAchat;
   private double amoHorsExp;
   private double amoCede;
   private String amoCompteCes;
   private String amoLibCompteCes;
   private String amoPhoto;
   private String amoScan;
   private String amoModele;
   private String pj;
   private boolean afficheImag;
   private String etat;
   private String convertAmoMode;
   private String convertAmoFinancement;
   private String convertAmoNature;
   private String convertAmoOrigine;
   private String convertAmoTypeSortie;
   private boolean select;
   private String couleur;
   private String codeRacine;
   private String libelleRacine;
   private String qrCode;
   private String photoPrint;
   private double v01;
   private double v02;
   private double v03;
   private double v04;
   private double v05;
   private double v06;
   private double v07;
   private double v08;
   private double v09;
   private double v10;
   private double v11;
   private double v12;
   private double vtotal;

   public String getPhotoPrint() {
      return this.photoPrint;
   }

   public void setPhotoPrint(String var1) {
      this.photoPrint = var1;
   }

   public String getQrCode() {
      return this.qrCode;
   }

   public void setQrCode(String var1) {
      this.qrCode = var1;
   }

   public String getPj() {
      if (this.amoScan != null && !this.amoScan.isEmpty()) {
         this.pj = "/images/mail_pj.png";
      } else {
         this.pj = null;
      }

      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
   }

   public String getCouleur() {
      if (this.amoTypeSortie == 1) {
         this.couleur = "blue";
      } else if (this.amoTypeSortie == 2) {
         this.couleur = "grey";
      } else if (this.amoTypeSortie == 3) {
         this.couleur = "brown";
      } else if (this.amoTypeSortie == 4) {
         this.couleur = "red";
      } else {
         this.couleur = "black";
      }

      return this.couleur;
   }

   public void setCouleur(String var1) {
      this.couleur = var1;
   }

   public String getEtat() {
      if (this.amoInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.amoInactif == 2) {
         this.etat = "/images/supprimer.gif";
      } else {
         this.etat = "";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.amoInactif != 1 && this.amoInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getConvertAmoTypeSortie() {
      if (this.amoTypeSortie == 0) {
         this.convertAmoTypeSortie = "En cours";
      } else if (this.amoTypeSortie == 1) {
         this.convertAmoTypeSortie = "Rebut";
      } else if (this.amoTypeSortie == 2) {
         this.convertAmoTypeSortie = "Cession";
      } else if (this.amoTypeSortie == 3) {
         this.convertAmoTypeSortie = "Désactive";
      }

      return this.convertAmoTypeSortie;
   }

   public void setConvertAmoTypeSortie(String var1) {
      this.convertAmoTypeSortie = var1;
   }

   public String getConvertAmoFinancement() {
      if (this.amoFinancement == 0) {
         this.convertAmoFinancement = "Sans";
      } else if (this.amoFinancement == 1) {
         this.convertAmoFinancement = "CMT";
      } else if (this.amoFinancement == 2) {
         this.convertAmoFinancement = "Crédit";
      }

      return this.convertAmoFinancement;
   }

   public void setConvertAmoFinancement(String var1) {
      this.convertAmoFinancement = var1;
   }

   public String getConvertAmoNature() {
      if (this.amoNature == 0) {
         this.convertAmoNature = "Immobilier";
      } else if (this.amoNature == 1) {
         this.convertAmoNature = "Mobilier";
      } else if (this.amoNature == 2) {
         this.convertAmoNature = "Autre";
      } else if (this.amoNature == 3) {
         this.convertAmoNature = "Caution";
      } else if (this.amoNature == 4) {
         this.convertAmoNature = "Frais de constitution";
      }

      return this.convertAmoNature;
   }

   public void setConvertAmoNature(String var1) {
      this.convertAmoNature = var1;
   }

   public String getConvertAmoOrigine() {
      if (this.amoOrigine.equalsIgnoreCase("0")) {
         this.convertAmoOrigine = "NP";
      } else if (this.amoOrigine.equalsIgnoreCase("1")) {
         this.convertAmoOrigine = "Pays";
      } else if (this.amoOrigine.equalsIgnoreCase("2")) {
         this.convertAmoOrigine = "Zone";
      } else if (this.amoOrigine.equalsIgnoreCase("3")) {
         this.convertAmoOrigine = "Extérieur";
      }

      return this.convertAmoOrigine;
   }

   public void setConvertAmoOrigine(String var1) {
      this.convertAmoOrigine = var1;
   }

   public String getConvertAmoMode() {
      if (this.amoMode == 0) {
         this.convertAmoMode = "N";
      } else if (this.amoMode == 1) {
         this.convertAmoMode = "A";
      } else if (this.amoMode == 2) {
         this.convertAmoMode = "D";
      }

      return this.convertAmoMode;
   }

   public void setConvertAmoMode(String var1) {
      this.convertAmoMode = var1;
   }

   public double getAmoAnterieur() {
      return this.amoAnterieur;
   }

   public void setAmoAnterieur(double var1) {
      this.amoAnterieur = var1;
   }

   public String getAmoBudget() {
      return this.amoBudget;
   }

   public void setAmoBudget(String var1) {
      this.amoBudget = var1;
   }

   public String getAmoChassis() {
      return this.amoChassis;
   }

   public void setAmoChassis(String var1) {
      this.amoChassis = var1;
   }

   public String getAmoCompteAmo() {
      return this.amoCompteAmo;
   }

   public void setAmoCompteAmo(String var1) {
      this.amoCompteAmo = var1;
   }

   public String getAmoCompteDotation() {
      return this.amoCompteDotation;
   }

   public void setAmoCompteDotation(String var1) {
      this.amoCompteDotation = var1;
   }

   public Date getAmoDateCreat() {
      return this.amoDateCreat;
   }

   public void setAmoDateCreat(Date var1) {
      this.amoDateCreat = var1;
   }

   public Date getAmoDateModif() {
      return this.amoDateModif;
   }

   public void setAmoDateModif(Date var1) {
      this.amoDateModif = var1;
   }

   public Date getAmoDateAchat() {
      return this.amoDateAchat;
   }

   public void setAmoDateAchat(Date var1) {
      this.amoDateAchat = var1;
   }

   public Date getAmoDateService() {
      return this.amoDateService;
   }

   public void setAmoDateService(Date var1) {
      this.amoDateService = var1;
   }

   public Date getAmoDateSortie() {
      return this.amoDateSortie;
   }

   public void setAmoDateSortie(Date var1) {
      this.amoDateSortie = var1;
   }

   public String getAmoDepartement() {
      return this.amoDepartement;
   }

   public void setAmoDepartement(String var1) {
      this.amoDepartement = var1;
   }

   public double getAmoDotation() {
      return this.amoDotation;
   }

   public void setAmoDotation(double var1) {
      this.amoDotation = var1;
   }

   public String getAmoFactureAchat() {
      return this.amoFactureAchat;
   }

   public void setAmoFactureAchat(String var1) {
      this.amoFactureAchat = var1;
   }

   public String getAmoFactureCession() {
      return this.amoFactureCession;
   }

   public void setAmoFactureCession(String var1) {
      this.amoFactureCession = var1;
   }

   public int getAmoFinancement() {
      return this.amoFinancement;
   }

   public void setAmoFinancement(int var1) {
      this.amoFinancement = var1;
   }

   public String getAmoFournisseur() {
      return this.amoFournisseur;
   }

   public void setAmoFournisseur(String var1) {
      this.amoFournisseur = var1;
   }

   public double getAmoFraisAnnexe() {
      return this.amoFraisAnnexe;
   }

   public void setAmoFraisAnnexe(double var1) {
      this.amoFraisAnnexe = var1;
   }

   public long getAmoId() {
      return this.amoId;
   }

   public void setAmoId(long var1) {
      this.amoId = var1;
   }

   public int getAmoInactif() {
      return this.amoInactif;
   }

   public void setAmoInactif(int var1) {
      this.amoInactif = var1;
   }

   public String getAmoInfosCpl() {
      return this.amoInfosCpl;
   }

   public void setAmoInfosCpl(String var1) {
      this.amoInfosCpl = var1;
   }

   public String getAmoLibelle() {
      if (this.amoLibelle != null && !this.amoLibelle.isEmpty()) {
         this.amoLibelle = this.amoLibelle.toUpperCase();
      }

      return this.amoLibelle;
   }

   public void setAmoLibelle(String var1) {
      this.amoLibelle = var1;
   }

   public int getAmoMode() {
      return this.amoMode;
   }

   public void setAmoMode(int var1) {
      this.amoMode = var1;
   }

   public int getAmoNature() {
      return this.amoNature;
   }

   public void setAmoNature(int var1) {
      this.amoNature = var1;
   }

   public float getAmoNbAnneeCpte() {
      return this.amoNbAnneeCpte;
   }

   public void setAmoNbAnneeCpte(float var1) {
      this.amoNbAnneeCpte = var1;
   }

   public float getAmoNbAnneeFiscal() {
      return this.amoNbAnneeFiscal;
   }

   public void setAmoNbAnneeFiscal(float var1) {
      this.amoNbAnneeFiscal = var1;
   }

   public double getAmoNetAPayer() {
      return this.amoNetAPayer;
   }

   public void setAmoNetAPayer(double var1) {
      this.amoNetAPayer = var1;
   }

   public String getAmoNomClient() {
      return this.amoNomClient;
   }

   public void setAmoNomClient(String var1) {
      this.amoNomClient = var1;
   }

   public long getAmoNum() {
      return this.amoNum;
   }

   public void setAmoNum(long var1) {
      this.amoNum = var1;
   }

   public String getAmoOrigine() {
      return this.amoOrigine;
   }

   public void setAmoOrigine(String var1) {
      this.amoOrigine = var1;
   }

   public String getAmoPdv() {
      return this.amoPdv;
   }

   public void setAmoPdv(String var1) {
      this.amoPdv = var1;
   }

   public Date getAmoPeriodeDeb() {
      return this.amoPeriodeDeb;
   }

   public void setAmoPeriodeDeb(Date var1) {
      this.amoPeriodeDeb = var1;
   }

   public Date getAmoPeriodeFin() {
      return this.amoPeriodeFin;
   }

   public void setAmoPeriodeFin(Date var1) {
      this.amoPeriodeFin = var1;
   }

   public String getAmoPieceAchat() {
      return this.amoPieceAchat;
   }

   public void setAmoPieceAchat(String var1) {
      this.amoPieceAchat = var1;
   }

   public String getAmoPieceCession() {
      return this.amoPieceCession;
   }

   public void setAmoPieceCession(String var1) {
      this.amoPieceCession = var1;
   }

   public String getAmoReference() {
      return this.amoReference;
   }

   public void setAmoReference(String var1) {
      this.amoReference = var1;
   }

   public String getAmoRegion() {
      return this.amoRegion;
   }

   public void setAmoRegion(String var1) {
      this.amoRegion = var1;
   }

   public int getAmoReinvestissement() {
      return this.amoReinvestissement;
   }

   public void setAmoReinvestissement(int var1) {
      this.amoReinvestissement = var1;
   }

   public String getAmoSecteur() {
      return this.amoSecteur;
   }

   public void setAmoSecteur(String var1) {
      this.amoSecteur = var1;
   }

   public String getAmoService() {
      return this.amoService;
   }

   public void setAmoService(String var1) {
      this.amoService = var1;
   }

   public String getAmoSite() {
      return this.amoSite;
   }

   public void setAmoSite(String var1) {
      this.amoSite = var1;
   }

   public double getAmoSolde() {
      return this.amoSolde;
   }

   public void setAmoSolde(double var1) {
      this.amoSolde = var1;
   }

   public float getAmoTauxComptable() {
      return this.amoTauxComptable;
   }

   public void setAmoTauxComptable(float var1) {
      this.amoTauxComptable = var1;
   }

   public float getAmoTauxFiscal() {
      return this.amoTauxFiscal;
   }

   public void setAmoTauxFiscal(float var1) {
      this.amoTauxFiscal = var1;
   }

   public double getAmoTotalAmort() {
      return this.amoTotalAmort;
   }

   public void setAmoTotalAmort(double var1) {
      this.amoTotalAmort = var1;
   }

   public double getAmoTotalReglement() {
      return this.amoTotalReglement;
   }

   public void setAmoTotalReglement(double var1) {
      this.amoTotalReglement = var1;
   }

   public double getAmoTvaResiduelle() {
      return this.amoTvaResiduelle;
   }

   public void setAmoTvaResiduelle(double var1) {
      this.amoTvaResiduelle = var1;
   }

   public float getAmoTvaTaux() {
      return this.amoTvaTaux;
   }

   public void setAmoTvaTaux(float var1) {
      this.amoTvaTaux = var1;
   }

   public double getAmoTvaTotal() {
      return this.amoTvaTotal;
   }

   public void setAmoTvaTotal(double var1) {
      this.amoTvaTotal = var1;
   }

   public int getAmoTypeSortie() {
      return this.amoTypeSortie;
   }

   public void setAmoTypeSortie(int var1) {
      this.amoTypeSortie = var1;
   }

   public long getAmoUserCreat() {
      return this.amoUserCreat;
   }

   public void setAmoUserCreat(long var1) {
      this.amoUserCreat = var1;
   }

   public long getAmoUserModif() {
      return this.amoUserModif;
   }

   public void setAmoUserModif(long var1) {
      this.amoUserModif = var1;
   }

   public void setAmoUserModif(int var1) {
      this.amoUserModif = (long)var1;
   }

   public double getAmoValeurAchat() {
      return this.amoValeurAchat;
   }

   public void setAmoValeurAchat(double var1) {
      this.amoValeurAchat = var1;
   }

   public double getAmoValeurCession() {
      return this.amoValeurCession;
   }

   public void setAmoValeurCession(double var1) {
      this.amoValeurCession = var1;
   }

   public double getAmoValeurReevalue() {
      return this.amoValeurReevalue;
   }

   public void setAmoValeurReevalue(double var1) {
      this.amoValeurReevalue = var1;
   }

   public double getAmoValeurResiduelle() {
      return this.amoValeurResiduelle;
   }

   public void setAmoValeurResiduelle(double var1) {
      this.amoValeurResiduelle = var1;
   }

   public double getAmoCede() {
      return this.amoCede;
   }

   public void setAmoCede(double var1) {
      this.amoCede = var1;
   }

   public double getAmoHorsExp() {
      return this.amoHorsExp;
   }

   public void setAmoHorsExp(double var1) {
      this.amoHorsExp = var1;
   }

   public String getAmoActivite() {
      return this.amoActivite;
   }

   public void setAmoActivite(String var1) {
      this.amoActivite = var1;
   }

   public String getAmoProjet() {
      return this.amoProjet;
   }

   public void setAmoProjet(String var1) {
      this.amoProjet = var1;
   }

   public String getAmoCompteImmo() {
      return this.amoCompteImmo;
   }

   public void setAmoCompteImmo(String var1) {
      this.amoCompteImmo = var1;
   }

   public String getAmoPhoto() {
      return this.amoPhoto;
   }

   public void setAmoPhoto(String var1) {
      this.amoPhoto = var1;
   }

   public String getAmoLibActivite() {
      return this.amoLibActivite;
   }

   public void setAmoLibActivite(String var1) {
      this.amoLibActivite = var1;
   }

   public String getAmoLibBudget() {
      return this.amoLibBudget;
   }

   public void setAmoLibBudget(String var1) {
      this.amoLibBudget = var1;
   }

   public String getAmoLibCompteAmo() {
      return this.amoLibCompteAmo;
   }

   public void setAmoLibCompteAmo(String var1) {
      this.amoLibCompteAmo = var1;
   }

   public String getAmoLibCompteDot() {
      return this.amoLibCompteDot;
   }

   public void setAmoLibCompteDot(String var1) {
      this.amoLibCompteDot = var1;
   }

   public String getAmoLibCompteImo() {
      return this.amoLibCompteImo;
   }

   public void setAmoLibCompteImo(String var1) {
      this.amoLibCompteImo = var1;
   }

   public String getAmoLibDepartement() {
      return this.amoLibDepartement;
   }

   public void setAmoLibDepartement(String var1) {
      this.amoLibDepartement = var1;
   }

   public String getAmoLibPdv() {
      return this.amoLibPdv;
   }

   public void setAmoLibPdv(String var1) {
      this.amoLibPdv = var1;
   }

   public String getAmoLibProjet() {
      return this.amoLibProjet;
   }

   public void setAmoLibProjet(String var1) {
      this.amoLibProjet = var1;
   }

   public String getAmoLibRegion() {
      return this.amoLibRegion;
   }

   public void setAmoLibRegion(String var1) {
      this.amoLibRegion = var1;
   }

   public String getAmoLibSecteur() {
      return this.amoLibSecteur;
   }

   public void setAmoLibSecteur(String var1) {
      this.amoLibSecteur = var1;
   }

   public String getAmoLibService() {
      return this.amoLibService;
   }

   public void setAmoLibService(String var1) {
      this.amoLibService = var1;
   }

   public String getAmoLibSite() {
      return this.amoLibSite;
   }

   public void setAmoLibSite(String var1) {
      this.amoLibSite = var1;
   }

   public String getAmoCompteCes() {
      return this.amoCompteCes;
   }

   public void setAmoCompteCes(String var1) {
      this.amoCompteCes = var1;
   }

   public String getAmoLibCompteCes() {
      return this.amoLibCompteCes;
   }

   public void setAmoLibCompteCes(String var1) {
      this.amoLibCompteCes = var1;
   }

   public String getAmoCle1() {
      return this.amoCle1;
   }

   public void setAmoCle1(String var1) {
      this.amoCle1 = var1;
   }

   public String getAmoDossier() {
      return this.amoDossier;
   }

   public void setAmoDossier(String var1) {
      this.amoDossier = var1;
   }

   public String getAmoLibCle1() {
      return this.amoLibCle1;
   }

   public void setAmoLibCle1(String var1) {
      this.amoLibCle1 = var1;
   }

   public String getAmoLibDossier() {
      return this.amoLibDossier;
   }

   public void setAmoLibDossier(String var1) {
      this.amoLibDossier = var1;
   }

   public String getAmoLibMission() {
      return this.amoLibMission;
   }

   public void setAmoLibMission(String var1) {
      this.amoLibMission = var1;
   }

   public String getAmoLibParc() {
      return this.amoLibParc;
   }

   public void setAmoLibParc(String var1) {
      this.amoLibParc = var1;
   }

   public String getAmoMission() {
      return this.amoMission;
   }

   public void setAmoMission(String var1) {
      this.amoMission = var1;
   }

   public String getAmoParc() {
      return this.amoParc;
   }

   public void setAmoParc(String var1) {
      this.amoParc = var1;
   }

   public String getAmoAgent() {
      return this.amoAgent;
   }

   public void setAmoAgent(String var1) {
      this.amoAgent = var1;
   }

   public String getAmoLibAgent() {
      return this.amoLibAgent;
   }

   public void setAmoLibAgent(String var1) {
      this.amoLibAgent = var1;
   }

   public int getAmoNatureDetail() {
      return this.amoNatureDetail;
   }

   public void setAmoNatureDetail(int var1) {
      this.amoNatureDetail = var1;
   }

   public String getAmoNatureDetailLib() {
      return this.amoNatureDetailLib;
   }

   public void setAmoNatureDetailLib(String var1) {
      this.amoNatureDetailLib = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public long getAmoOldId() {
      return this.amoOldId;
   }

   public void setAmoOldId(long var1) {
      this.amoOldId = var1;
   }

   public Date getAmoDateAnterieur() {
      return this.amoDateAnterieur;
   }

   public void setAmoDateAnterieur(Date var1) {
      this.amoDateAnterieur = var1;
   }

   public Date getAmoDateReevalue() {
      return this.amoDateReevalue;
   }

   public void setAmoDateReevalue(Date var1) {
      this.amoDateReevalue = var1;
   }

   public long getAmoIdReception() {
      return this.amoIdReception;
   }

   public void setAmoIdReception(long var1) {
      this.amoIdReception = var1;
   }

   public double getV01() {
      return this.v01;
   }

   public void setV01(double var1) {
      this.v01 = var1;
   }

   public double getV02() {
      return this.v02;
   }

   public void setV02(double var1) {
      this.v02 = var1;
   }

   public double getV03() {
      return this.v03;
   }

   public void setV03(double var1) {
      this.v03 = var1;
   }

   public double getV04() {
      return this.v04;
   }

   public void setV04(double var1) {
      this.v04 = var1;
   }

   public double getV05() {
      return this.v05;
   }

   public void setV05(double var1) {
      this.v05 = var1;
   }

   public double getV06() {
      return this.v06;
   }

   public void setV06(double var1) {
      this.v06 = var1;
   }

   public double getV07() {
      return this.v07;
   }

   public void setV07(double var1) {
      this.v07 = var1;
   }

   public double getV08() {
      return this.v08;
   }

   public void setV08(double var1) {
      this.v08 = var1;
   }

   public double getV09() {
      return this.v09;
   }

   public void setV09(double var1) {
      this.v09 = var1;
   }

   public double getV10() {
      return this.v10;
   }

   public void setV10(double var1) {
      this.v10 = var1;
   }

   public double getV11() {
      return this.v11;
   }

   public void setV11(double var1) {
      this.v11 = var1;
   }

   public double getV12() {
      return this.v12;
   }

   public void setV12(double var1) {
      this.v12 = var1;
   }

   public double getVtotal() {
      this.vtotal = this.v01 + this.v02 + this.v03 + this.v04 + this.v05 + this.v06 + this.v07 + this.v08 + this.v09 + this.v10 + this.v11 + this.v12;
      return this.vtotal;
   }

   public void setVtotal(double var1) {
      this.vtotal = var1;
   }

   public String getAmoLocalisation() {
      return this.amoLocalisation;
   }

   public void setAmoLocalisation(String var1) {
      this.amoLocalisation = var1;
   }

   public String getAmoScan() {
      return this.amoScan;
   }

   public void setAmoScan(String var1) {
      this.amoScan = var1;
   }

   public String getCodeRacine() {
      return this.codeRacine;
   }

   public void setCodeRacine(String var1) {
      this.codeRacine = var1;
   }

   public String getLibelleRacine() {
      return this.libelleRacine;
   }

   public void setLibelleRacine(String var1) {
      this.libelleRacine = var1;
   }

   public String getAmoLibFournisseur() {
      return this.amoLibFournisseur;
   }

   public void setAmoLibFournisseur(String var1) {
      this.amoLibFournisseur = var1;
   }

   public String getAmoModele() {
      return this.amoModele;
   }

   public void setAmoModele(String var1) {
      this.amoModele = var1;
   }
}
