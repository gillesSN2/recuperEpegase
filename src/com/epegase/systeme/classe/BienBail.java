package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BienBail implements Serializable {
   private long biebaiId;
   private Date biebaiDateCreat;
   private Date biebaiDateModif;
   private long biebaiUserCreat;
   private long biebaiUserModif;
   private Date biebaiDate;
   private int biebaiAnnee;
   private Date biebaiDateSignature;
   private Date biebaiDateEtatIn;
   private Date biebaiDateEtatOut;
   private Date biebaiDateDepot;
   private Date biebaiDateADeposer;
   private String biebaiNomDepot;
   private Date biebaiDateEnregistrement;
   private Date biebaiDateDebut;
   private Date biebaiDateFin;
   private Date biebaiDateFinFacture;
   private String biebaiNum;
   private String biebaiLocal;
   private int biebaiDuree;
   private int biebaiEtat;
   private Date biebaiDateAnnule;
   private String biebaiMotifAnnule;
   private int biebaiType;
   private int biebaiMode;
   private int biebaiUsage;
   private double biebaiLoyerBrut;
   private double biebaiLoyerProf;
   private int biebaiExoTom;
   private float biebaiTauxTom;
   private double biebaiTom;
   private int biebaiModeTlv;
   private float biebaiTauxTlv;
   private double biebaiTlv;
   private int biebaiExoTva;
   private float biebaiTauxTva;
   private double biebaiTva;
   private double biebaiLoyerNet;
   private float biebaiTauxIrpp;
   private double biebaiIrpp;
   private double biebaiCharges;
   private float biebaiTauxCharges;
   private double biebaiEau;
   private double biebaiElectricite;
   private double biebaiParking;
   private double biebaiGardiennage;
   private double biebaiJardinier;
   private double biebaiGroupeElectro;
   private double biebaiDiversFrais;
   private String biebaiLibelleFrais;
   private double biebaiFraisComplement;
   private String biebaiLocataire;
   private String biebaiNomTiers;
   private String biebaiCivilTiers;
   private long biebaiIdProprietaire;
   private String biebaiProprietaire;
   private String biebaiNomProprietaire;
   private String biebaiCivilProprietaire;
   private int biebaiTypeProprietaire;
   private String biebaiSerie;
   private String biebaiNomResponsable;
   private long biebaiIdResponsable;
   private String biebaiContrat;
   private String biebaiEtatIn;
   private String biebaiEtatOut;
   private Date biebaiDerniereRevision;
   private Date biebaiProchaineRevision;
   private Date biebaiDerniereFacture;
   private double biebaiMontantCaution;
   private Date biebaiDateCaution;
   private double biebaiRmbCaution;
   private Date biebaiDateRmbCaution;
   private long biebaiIndexElectriciteIn;
   private long biebaiIndexElectriciteOut;
   private long biebaiIndexEauIn;
   private long biebaiIndexEauOut;
   private long biebaiIndexGazIn;
   private long biebaiIndexGazOut;
   private String biebaiPoliceElectricite;
   private String biebaiPoliceEau;
   private String biebaiPoliceGaz;
   private String biebaiNomAssureur;
   private String biebaiContratAssurance;
   private String biebaiNumFacInit;
   private Date biebaiDateFacInit;
   private Date biebaiDateImp;
   private String biebaiModeleImp;
   private int biebaiEtatVal;
   private Date biebaiDateValidite;
   private Date biebaiDateValide;
   private double biebaiBaseGerance;
   private double biebaiForfaitGerance;
   private float biebaiTauxGerance;
   private double biebaiComGerance;
   private double biebaiTvaGerance;
   private Bien bien;
   private Tiers tiers;
   private String libelleMode;
   private String libelleUsage;
   private double baseAgence;
   private String libelleEtat;
   private String libelleTom;
   private String libelleTlv;
   private String libelleTva;
   private String libelleIrpp;

   public String getLibelleIrpp() {
      this.libelleIrpp = "";
      if (this.biebaiTypeProprietaire == 0) {
         this.libelleIrpp = "";
      } else if (this.biebaiTypeProprietaire == 1) {
         this.libelleIrpp = "IRPP";
      } else if (this.biebaiTypeProprietaire == 2) {
         this.libelleIrpp = "IS";
      }

      return this.libelleIrpp;
   }

   public void setLibelleIrpp(String var1) {
      this.libelleIrpp = var1;
   }

   public String getLibelleTlv() {
      this.libelleTlv = "";
      if (this.biebaiModeTlv == 0) {
         this.libelleTlv = "";
      } else if (this.biebaiModeTlv == 1) {
         this.libelleTlv = "Enregistrement";
      } else if (this.biebaiModeTlv == 2) {
         this.libelleTlv = "TLV";
      }

      return this.libelleTlv;
   }

   public void setLibelleTlv(String var1) {
      this.libelleTlv = var1;
   }

   public String getLibelleTom() {
      this.libelleTom = "";
      if (this.biebaiExoTom == 0) {
         this.libelleTom = "TOM";
      } else if (this.biebaiExoTom == 1) {
         this.libelleTom = "Exonéré";
      }

      return this.libelleTom;
   }

   public void setLibelleTom(String var1) {
      this.libelleTom = var1;
   }

   public String getLibelleTva() {
      this.libelleTva = "";
      if (this.biebaiUsage == 0) {
         this.libelleTva = "Sans";
      } else if (this.biebaiExoTva == 0) {
         this.libelleTva = "TVA";
      } else if (this.biebaiExoTva == 1) {
         this.libelleTva = "Exonéré";
      }

      return this.libelleTva;
   }

   public void setLibelleTva(String var1) {
      this.libelleTva = var1;
   }

   public String getLibelleEtat() {
      if (this.biebaiEtat == 0) {
         this.libelleEtat = "En cours";
      } else if (this.biebaiEtat == 1) {
         this.libelleEtat = "Validé";
      } else if (this.biebaiEtat == 2) {
         this.libelleEtat = "Gelé";
      } else if (this.biebaiEtat == 3) {
         this.libelleEtat = "Annulé";
      } else if (this.biebaiEtat == 4) {
         this.libelleEtat = "Terminé";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public double getBaseAgence() {
      this.baseAgence = this.biebaiLoyerBrut;
      return this.baseAgence;
   }

   public void setBaseAgence(double var1) {
      this.baseAgence = var1;
   }

   public String getLibelleMode() {
      if (this.biebaiMode == 0) {
         this.libelleMode = "Jour";
      } else if (this.biebaiMode == 1) {
         this.libelleMode = "Semaine";
      } else if (this.biebaiMode == 2) {
         this.libelleMode = "Mois";
      } else if (this.biebaiMode == 3) {
         this.libelleMode = "Trimestre";
      } else if (this.biebaiMode == 4) {
         this.libelleMode = "Semestre";
      } else if (this.biebaiMode == 5) {
         this.libelleMode = "Année";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public String getLibelleUsage() {
      if (this.biebaiUsage == 0) {
         this.libelleUsage = "Habitation";
      } else if (this.biebaiUsage == 1) {
         this.libelleUsage = "Professionnel";
      } else if (this.biebaiUsage == 2) {
         this.libelleUsage = "Industriel";
      } else if (this.biebaiUsage == 3) {
         this.libelleUsage = "Mixte";
      }

      return this.libelleUsage;
   }

   public void setLibelleUsage(String var1) {
      this.libelleUsage = var1;
   }

   public Bien getBien() {
      return this.bien;
   }

   public void setBien(Bien var1) {
      this.bien = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public Date getBiebaiDateCreat() {
      return this.biebaiDateCreat;
   }

   public void setBiebaiDateCreat(Date var1) {
      this.biebaiDateCreat = var1;
   }

   public Date getBiebaiDateDebut() {
      return this.biebaiDateDebut;
   }

   public void setBiebaiDateDebut(Date var1) {
      this.biebaiDateDebut = var1;
   }

   public Date getBiebaiDateFin() {
      return this.biebaiDateFin;
   }

   public void setBiebaiDateFin(Date var1) {
      this.biebaiDateFin = var1;
   }

   public Date getBiebaiDateModif() {
      return this.biebaiDateModif;
   }

   public void setBiebaiDateModif(Date var1) {
      this.biebaiDateModif = var1;
   }

   public Date getBiebaiDateSignature() {
      return this.biebaiDateSignature;
   }

   public void setBiebaiDateSignature(Date var1) {
      this.biebaiDateSignature = var1;
   }

   public int getBiebaiDuree() {
      return this.biebaiDuree;
   }

   public void setBiebaiDuree(int var1) {
      this.biebaiDuree = var1;
   }

   public long getBiebaiId() {
      return this.biebaiId;
   }

   public void setBiebaiId(long var1) {
      this.biebaiId = var1;
   }

   public double getBiebaiLoyerBrut() {
      return this.biebaiLoyerBrut;
   }

   public void setBiebaiLoyerBrut(double var1) {
      this.biebaiLoyerBrut = var1;
   }

   public double getBiebaiLoyerNet() {
      return this.biebaiLoyerNet;
   }

   public void setBiebaiLoyerNet(double var1) {
      this.biebaiLoyerNet = var1;
   }

   public int getBiebaiMode() {
      return this.biebaiMode;
   }

   public void setBiebaiMode(int var1) {
      this.biebaiMode = var1;
   }

   public float getBiebaiTauxTlv() {
      return this.biebaiTauxTlv;
   }

   public void setBiebaiTauxTlv(float var1) {
      this.biebaiTauxTlv = var1;
   }

   public float getBiebaiTauxTom() {
      return this.biebaiTauxTom;
   }

   public void setBiebaiTauxTom(float var1) {
      this.biebaiTauxTom = var1;
   }

   public float getBiebaiTauxTva() {
      return this.biebaiTauxTva;
   }

   public void setBiebaiTauxTva(float var1) {
      this.biebaiTauxTva = var1;
   }

   public double getBiebaiTlv() {
      return this.biebaiTlv;
   }

   public void setBiebaiTlv(double var1) {
      this.biebaiTlv = var1;
   }

   public double getBiebaiTom() {
      return this.biebaiTom;
   }

   public void setBiebaiTom(double var1) {
      this.biebaiTom = var1;
   }

   public double getBiebaiTva() {
      return this.biebaiTva;
   }

   public void setBiebaiTva(double var1) {
      this.biebaiTva = var1;
   }

   public int getBiebaiUsage() {
      return this.biebaiUsage;
   }

   public void setBiebaiUsage(int var1) {
      this.biebaiUsage = var1;
   }

   public long getBiebaiUserCreat() {
      return this.biebaiUserCreat;
   }

   public void setBiebaiUserCreat(long var1) {
      this.biebaiUserCreat = var1;
   }

   public long getBiebaiUserModif() {
      return this.biebaiUserModif;
   }

   public void setBiebaiUserModif(long var1) {
      this.biebaiUserModif = var1;
   }

   public int getBiebaiEtat() {
      return this.biebaiEtat;
   }

   public void setBiebaiEtat(int var1) {
      this.biebaiEtat = var1;
   }

   public String getBiebaiNum() {
      return this.biebaiNum;
   }

   public void setBiebaiNum(String var1) {
      this.biebaiNum = var1;
   }

   public String getBiebaiNomTiers() {
      return this.biebaiNomTiers;
   }

   public void setBiebaiNomTiers(String var1) {
      this.biebaiNomTiers = var1;
   }

   public String getBiebaiCivilTiers() {
      return this.biebaiCivilTiers;
   }

   public void setBiebaiCivilTiers(String var1) {
      this.biebaiCivilTiers = var1;
   }

   public long getBiebaiIdResponsable() {
      return this.biebaiIdResponsable;
   }

   public void setBiebaiIdResponsable(long var1) {
      this.biebaiIdResponsable = var1;
   }

   public String getBiebaiNomResponsable() {
      return this.biebaiNomResponsable;
   }

   public void setBiebaiNomResponsable(String var1) {
      this.biebaiNomResponsable = var1;
   }

   public String getBiebaiSerie() {
      return this.biebaiSerie;
   }

   public void setBiebaiSerie(String var1) {
      this.biebaiSerie = var1;
   }

   public double getBiebaiCharges() {
      return this.biebaiCharges;
   }

   public void setBiebaiCharges(double var1) {
      this.biebaiCharges = var1;
   }

   public String getBiebaiContrat() {
      return this.biebaiContrat;
   }

   public void setBiebaiContrat(String var1) {
      this.biebaiContrat = var1;
   }

   public int getBiebaiType() {
      return this.biebaiType;
   }

   public void setBiebaiType(int var1) {
      this.biebaiType = var1;
   }

   public double getBiebaiLoyerProf() {
      return this.biebaiLoyerProf;
   }

   public void setBiebaiLoyerProf(double var1) {
      this.biebaiLoyerProf = var1;
   }

   public double getBiebaiDiversFrais() {
      return this.biebaiDiversFrais;
   }

   public void setBiebaiDiversFrais(double var1) {
      this.biebaiDiversFrais = var1;
   }

   public double getBiebaiEau() {
      return this.biebaiEau;
   }

   public void setBiebaiEau(double var1) {
      this.biebaiEau = var1;
   }

   public double getBiebaiElectricite() {
      return this.biebaiElectricite;
   }

   public void setBiebaiElectricite(double var1) {
      this.biebaiElectricite = var1;
   }

   public double getBiebaiGardiennage() {
      return this.biebaiGardiennage;
   }

   public void setBiebaiGardiennage(double var1) {
      this.biebaiGardiennage = var1;
   }

   public double getBiebaiParking() {
      return this.biebaiParking;
   }

   public void setBiebaiParking(double var1) {
      this.biebaiParking = var1;
   }

   public double getBiebaiIrpp() {
      return this.biebaiIrpp;
   }

   public void setBiebaiIrpp(double var1) {
      this.biebaiIrpp = var1;
   }

   public Date getBiebaiDerniereRevision() {
      return this.biebaiDerniereRevision;
   }

   public void setBiebaiDerniereRevision(Date var1) {
      this.biebaiDerniereRevision = var1;
   }

   public Date getBiebaiProchaineRevision() {
      return this.biebaiProchaineRevision;
   }

   public void setBiebaiProchaineRevision(Date var1) {
      this.biebaiProchaineRevision = var1;
   }

   public Date getBiebaiDate() {
      return this.biebaiDate;
   }

   public void setBiebaiDate(Date var1) {
      this.biebaiDate = var1;
   }

   public Date getBiebaiDerniereFacture() {
      return this.biebaiDerniereFacture;
   }

   public void setBiebaiDerniereFacture(Date var1) {
      this.biebaiDerniereFacture = var1;
   }

   public int getBiebaiModeTlv() {
      return this.biebaiModeTlv;
   }

   public void setBiebaiModeTlv(int var1) {
      this.biebaiModeTlv = var1;
   }

   public int getBiebaiExoTom() {
      return this.biebaiExoTom;
   }

   public void setBiebaiExoTom(int var1) {
      this.biebaiExoTom = var1;
   }

   public int getBiebaiExoTva() {
      return this.biebaiExoTva;
   }

   public void setBiebaiExoTva(int var1) {
      this.biebaiExoTva = var1;
   }

   public String getBiebaiLocataire() {
      return this.biebaiLocataire;
   }

   public void setBiebaiLocataire(String var1) {
      this.biebaiLocataire = var1;
   }

   public String getBiebaiCivilProprietaire() {
      return this.biebaiCivilProprietaire;
   }

   public void setBiebaiCivilProprietaire(String var1) {
      this.biebaiCivilProprietaire = var1;
   }

   public String getBiebaiNomProprietaire() {
      return this.biebaiNomProprietaire;
   }

   public void setBiebaiNomProprietaire(String var1) {
      this.biebaiNomProprietaire = var1;
   }

   public String getBiebaiProprietaire() {
      return this.biebaiProprietaire;
   }

   public void setBiebaiProprietaire(String var1) {
      this.biebaiProprietaire = var1;
   }

   public String getBiebaiLocal() {
      return this.biebaiLocal;
   }

   public void setBiebaiLocal(String var1) {
      this.biebaiLocal = var1;
   }

   public long getBiebaiIdProprietaire() {
      return this.biebaiIdProprietaire;
   }

   public void setBiebaiIdProprietaire(long var1) {
      this.biebaiIdProprietaire = var1;
   }

   public Date getBiebaiDateCaution() {
      return this.biebaiDateCaution;
   }

   public void setBiebaiDateCaution(Date var1) {
      this.biebaiDateCaution = var1;
   }

   public Date getBiebaiDateRmbCaution() {
      return this.biebaiDateRmbCaution;
   }

   public void setBiebaiDateRmbCaution(Date var1) {
      this.biebaiDateRmbCaution = var1;
   }

   public double getBiebaiMontantCaution() {
      return this.biebaiMontantCaution;
   }

   public void setBiebaiMontantCaution(double var1) {
      this.biebaiMontantCaution = var1;
   }

   public double getBiebaiRmbCaution() {
      return this.biebaiRmbCaution;
   }

   public void setBiebaiRmbCaution(double var1) {
      this.biebaiRmbCaution = var1;
   }

   public float getBiebaiTauxIrpp() {
      return this.biebaiTauxIrpp;
   }

   public void setBiebaiTauxIrpp(float var1) {
      this.biebaiTauxIrpp = var1;
   }

   public int getBiebaiTypeProprietaire() {
      return this.biebaiTypeProprietaire;
   }

   public void setBiebaiTypeProprietaire(int var1) {
      this.biebaiTypeProprietaire = var1;
   }

   public Date getBiebaiDateEnregistrement() {
      return this.biebaiDateEnregistrement;
   }

   public void setBiebaiDateEnregistrement(Date var1) {
      this.biebaiDateEnregistrement = var1;
   }

   public Date getBiebaiDateEtatIn() {
      return this.biebaiDateEtatIn;
   }

   public void setBiebaiDateEtatIn(Date var1) {
      this.biebaiDateEtatIn = var1;
   }

   public Date getBiebaiDateEtatOut() {
      return this.biebaiDateEtatOut;
   }

   public void setBiebaiDateEtatOut(Date var1) {
      this.biebaiDateEtatOut = var1;
   }

   public Date getBiebaiDateDepot() {
      return this.biebaiDateDepot;
   }

   public void setBiebaiDateDepot(Date var1) {
      this.biebaiDateDepot = var1;
   }

   public String getBiebaiEtatIn() {
      return this.biebaiEtatIn;
   }

   public void setBiebaiEtatIn(String var1) {
      this.biebaiEtatIn = var1;
   }

   public String getBiebaiEtatOut() {
      return this.biebaiEtatOut;
   }

   public void setBiebaiEtatOut(String var1) {
      this.biebaiEtatOut = var1;
   }

   public double getBiebaiFraisComplement() {
      return this.biebaiFraisComplement;
   }

   public void setBiebaiFraisComplement(double var1) {
      this.biebaiFraisComplement = var1;
   }

   public double getBiebaiGroupeElectro() {
      return this.biebaiGroupeElectro;
   }

   public void setBiebaiGroupeElectro(double var1) {
      this.biebaiGroupeElectro = var1;
   }

   public double getBiebaiJardinier() {
      return this.biebaiJardinier;
   }

   public void setBiebaiJardinier(double var1) {
      this.biebaiJardinier = var1;
   }

   public String getBiebaiLibelleFrais() {
      return this.biebaiLibelleFrais;
   }

   public void setBiebaiLibelleFrais(String var1) {
      this.biebaiLibelleFrais = var1;
   }

   public float getBiebaiTauxCharges() {
      return this.biebaiTauxCharges;
   }

   public void setBiebaiTauxCharges(float var1) {
      this.biebaiTauxCharges = var1;
   }

   public String getBiebaiContratAssurance() {
      return this.biebaiContratAssurance;
   }

   public void setBiebaiContratAssurance(String var1) {
      this.biebaiContratAssurance = var1;
   }

   public long getBiebaiIndexEauIn() {
      return this.biebaiIndexEauIn;
   }

   public void setBiebaiIndexEauIn(long var1) {
      this.biebaiIndexEauIn = var1;
   }

   public long getBiebaiIndexEauOut() {
      return this.biebaiIndexEauOut;
   }

   public void setBiebaiIndexEauOut(long var1) {
      this.biebaiIndexEauOut = var1;
   }

   public long getBiebaiIndexElectriciteIn() {
      return this.biebaiIndexElectriciteIn;
   }

   public void setBiebaiIndexElectriciteIn(long var1) {
      this.biebaiIndexElectriciteIn = var1;
   }

   public long getBiebaiIndexElectriciteOut() {
      return this.biebaiIndexElectriciteOut;
   }

   public void setBiebaiIndexElectriciteOut(long var1) {
      this.biebaiIndexElectriciteOut = var1;
   }

   public long getBiebaiIndexGazIn() {
      return this.biebaiIndexGazIn;
   }

   public void setBiebaiIndexGazIn(long var1) {
      this.biebaiIndexGazIn = var1;
   }

   public long getBiebaiIndexGazOut() {
      return this.biebaiIndexGazOut;
   }

   public void setBiebaiIndexGazOut(long var1) {
      this.biebaiIndexGazOut = var1;
   }

   public String getBiebaiNomAssureur() {
      return this.biebaiNomAssureur;
   }

   public void setBiebaiNomAssureur(String var1) {
      this.biebaiNomAssureur = var1;
   }

   public String getBiebaiPoliceEau() {
      return this.biebaiPoliceEau;
   }

   public void setBiebaiPoliceEau(String var1) {
      this.biebaiPoliceEau = var1;
   }

   public String getBiebaiPoliceElectricite() {
      return this.biebaiPoliceElectricite;
   }

   public void setBiebaiPoliceElectricite(String var1) {
      this.biebaiPoliceElectricite = var1;
   }

   public String getBiebaiPoliceGaz() {
      return this.biebaiPoliceGaz;
   }

   public void setBiebaiPoliceGaz(String var1) {
      this.biebaiPoliceGaz = var1;
   }

   public Date getBiebaiDateADeposer() {
      return this.biebaiDateADeposer;
   }

   public void setBiebaiDateADeposer(Date var1) {
      this.biebaiDateADeposer = var1;
   }

   public String getBiebaiNomDepot() {
      return this.biebaiNomDepot;
   }

   public void setBiebaiNomDepot(String var1) {
      this.biebaiNomDepot = var1;
   }

   public Date getBiebaiDateFacInit() {
      return this.biebaiDateFacInit;
   }

   public void setBiebaiDateFacInit(Date var1) {
      this.biebaiDateFacInit = var1;
   }

   public String getBiebaiNumFacInit() {
      return this.biebaiNumFacInit;
   }

   public void setBiebaiNumFacInit(String var1) {
      this.biebaiNumFacInit = var1;
   }

   public Date getBiebaiDateImp() {
      return this.biebaiDateImp;
   }

   public void setBiebaiDateImp(Date var1) {
      this.biebaiDateImp = var1;
   }

   public String getBiebaiModeleImp() {
      return this.biebaiModeleImp;
   }

   public void setBiebaiModeleImp(String var1) {
      this.biebaiModeleImp = var1;
   }

   public Date getBiebaiDateValide() {
      return this.biebaiDateValide;
   }

   public void setBiebaiDateValide(Date var1) {
      this.biebaiDateValide = var1;
   }

   public Date getBiebaiDateValidite() {
      return this.biebaiDateValidite;
   }

   public void setBiebaiDateValidite(Date var1) {
      this.biebaiDateValidite = var1;
   }

   public int getBiebaiEtatVal() {
      return this.biebaiEtatVal;
   }

   public void setBiebaiEtatVal(int var1) {
      this.biebaiEtatVal = var1;
   }

   public double getBiebaiBaseGerance() {
      return this.biebaiBaseGerance;
   }

   public void setBiebaiBaseGerance(double var1) {
      this.biebaiBaseGerance = var1;
   }

   public double getBiebaiComGerance() {
      return this.biebaiComGerance;
   }

   public void setBiebaiComGerance(double var1) {
      this.biebaiComGerance = var1;
   }

   public float getBiebaiTauxGerance() {
      return this.biebaiTauxGerance;
   }

   public void setBiebaiTauxGerance(float var1) {
      this.biebaiTauxGerance = var1;
   }

   public double getBiebaiTvaGerance() {
      return this.biebaiTvaGerance;
   }

   public void setBiebaiTvaGerance(double var1) {
      this.biebaiTvaGerance = var1;
   }

   public int getBiebaiAnnee() {
      return this.biebaiAnnee;
   }

   public void setBiebaiAnnee(int var1) {
      this.biebaiAnnee = var1;
   }

   public Date getBiebaiDateAnnule() {
      return this.biebaiDateAnnule;
   }

   public void setBiebaiDateAnnule(Date var1) {
      this.biebaiDateAnnule = var1;
   }

   public String getBiebaiMotifAnnule() {
      return this.biebaiMotifAnnule;
   }

   public void setBiebaiMotifAnnule(String var1) {
      this.biebaiMotifAnnule = var1;
   }

   public Date getBiebaiDateFinFacture() {
      return this.biebaiDateFinFacture;
   }

   public void setBiebaiDateFinFacture(Date var1) {
      this.biebaiDateFinFacture = var1;
   }

   public double getBiebaiForfaitGerance() {
      return this.biebaiForfaitGerance;
   }

   public void setBiebaiForfaitGerance(double var1) {
      this.biebaiForfaitGerance = var1;
   }
}
