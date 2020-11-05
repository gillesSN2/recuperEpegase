package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesContrats implements Serializable {
   private long salconId;
   private Date salconDateCreat;
   private Date salconDateModif;
   private long salconUserCreat;
   private long salconUserModif;
   private String salconNum;
   private String salconType;
   private int salconEtat;
   private int salconEssai;
   private int salconNbMoisEssai;
   private String salconFonction;
   private String salconSite;
   private String salconDepartement;
   private String salconLocalisation;
   private String salconService;
   private String salconLibService;
   private Date salconDateDebut;
   private String salconLieuTravail;
   private String salconConvention;
   private String salconLibConvention;
   private String salconCentresImpots;
   private String salconLibCentresImpots;
   private String salconCentresSecurite;
   private String salconLibCentresSecurite;
   private String salconClassement;
   private String salconLibClassement;
   private String salconCodeEmploi;
   private String salconNivEmploi;
   private String salconLibNivEmploi;
   private String salconGrille;
   private String salconLibGrille;
   private String salconActivite;
   private String salconLibActivite;
   private String salconBudget;
   private String salconLibBudget;
   private String salconProjet;
   private String salconLibProjet;
   private int salconVehicule;
   private double salconRbmKms;
   private String salconParc;
   private String salconTexte;
   private Date salconDateEntreeInitial;
   private Date salconDateFin;
   private String salconMotifSortie;
   private String salconFeuille;
   private Date salconDateRemise;
   private Date salconDateRetour;
   private Date salconDateConfirmation;
   private long salconIdRepresetant;
   private String salconNomRepresentant;
   private String salconQualite;
   private int salconEtatVal;
   private int salconEtatH;
   private Date salconDateValide;
   private int salconPosSignature;
   private Date salconDateImp;
   private float salconNbHeureMois;
   private double salconBase;
   private double salconSursalaire;
   private double salconForfaitSup;
   private double salconPrimeRendement;
   private double salconPrimeResponsabilite;
   private double salconPrimeExceptionnelle;
   private double salconPrimeSujetion;
   private double salconPrimeFonction;
   private double salconPrimeTransport;
   private double salconPrimeLogement;
   private double salconPrimeOutillage;
   private double salconPrimeAstreinte;
   private double salconIndemniteCaisse;
   private double salconIndemniteTransport;
   private double salconIndemniteLogement;
   private double salconIndemniteDeplacement;
   private double salconIndemniteKilometrique;
   private double salconIndemniteSalissure;
   private double salconIndemniteRepresentation;
   private double salconIndemniteDiverse;
   private double salconIndemniteResponsabilite;
   private double salconIndemniteNourriture;
   private double salconAvnLogement;
   private double salconAvnDomesticite;
   private double salconAvnEau;
   private double salconAvnElectricite;
   private double salconAvnNourriture;
   private double salconAvnVehicule;
   private double salconAvnTelephone;
   private float salconNbJourCp;
   private float salconNbJourTr;
   private String salconCle1Anal;
   private String salconLibCle1Anal;
   private String salconCle2Anal;
   private String salconLibCle2Anal;
   private long salconIdTiers;
   private String salconNomTiers;
   private Date salconDateAvenantDeb1;
   private Date salconDateAvenantFin1;
   private Date salconDateAvenantFin2;
   private Date salconDateAvenantFin3;
   private Date salconDateAvenantFin4;
   private Date salconDateAvenantFin5;
   private Date salconDateAvenantFin6;
   private Date salconDateAvenantFin7;
   private Date salconDateAvenantFin8;
   private Date salconDateAvenantFin9;
   private Date salconDateAvenantFin10;
   private Date salconDateAvenantFin11;
   private Date salconDateAvenantFin12;
   private String salconDocument;
   private float salconTaux;
   private Salaries salaries;
   private String lib_etat;
   private String lib_nature;
   private String libelleEtat;
   private boolean effectue;
   private String styleEffectue;
   private double histoAdm;
   private double histoBrut;
   private double histoNbjs;
   private double histoCp;
   private String protege;

   public String getProtege() {
      if (this.salaries.getSalProtege() == 1) {
         this.protege = "color:grey";
      } else {
         this.protege = "color:black";
      }

      return this.protege;
   }

   public void setProtege(String var1) {
      this.protege = var1;
   }

   public String getStyleEffectue() {
      if (!this.effectue) {
         this.styleEffectue = "color:red";
      } else {
         this.styleEffectue = "color:black";
      }

      return this.styleEffectue;
   }

   public void setStyleEffectue(String var1) {
      this.styleEffectue = var1;
   }

   public String getLib_etat() {
      if (this.salconEtat <= 1) {
         this.lib_etat = "En Cours";
      } else if (this.salconEtat == 2) {
         this.lib_etat = "Licencié(e)";
      } else if (this.salconEtat == 3) {
         this.lib_etat = "Démissionné(e)";
      } else if (this.salconEtat == 4) {
         this.lib_etat = "Décédé(e)";
      } else if (this.salconEtat == 5) {
         this.lib_etat = "Retraité(e)";
      } else if (this.salconEtat == 5) {
         this.lib_etat = "Fin contrat";
      } else if (this.salconEtat == 6) {
         this.lib_etat = "Fin contrat";
      } else if (this.salconEtat == 7) {
         this.lib_etat = "Arrêt ou Suspension";
      } else if (this.salconEtat == 8) {
         this.lib_etat = "Mutation";
      } else if (this.salconEtat == 9) {
         this.lib_etat = "Gelé(e)";
      } else if (this.salconEtat == 10) {
         this.lib_etat = "Départ négocié";
      } else {
         this.lib_etat = "???";
      }

      return this.lib_etat;
   }

   public void setLib_etat(String var1) {
      this.lib_etat = var1;
   }

   public String getLib_nature() {
      if (this.salconType != null && !this.salconType.isEmpty()) {
         if (this.salconType.equals("01D")) {
            this.lib_nature = "Mensuel CDD";
         } else if (this.salconType.equals("01I")) {
            this.lib_nature = "Mensuel CDI";
         } else if (this.salconType.equals("02D")) {
            this.lib_nature = "Expatrié CDD";
         } else if (this.salconType.equals("02I")) {
            this.lib_nature = "Expatrié CDI";
         } else if (this.salconType.equals("03D")) {
            this.lib_nature = "Horaire CDD";
         } else if (this.salconType.equals("03I")) {
            this.lib_nature = "Horaire CDI";
         } else if (this.salconType.equals("04")) {
            this.lib_nature = "Journalier";
         } else if (this.salconType.equals("05")) {
            this.lib_nature = "Stagiaire permanent";
         } else if (this.salconType.equals("11")) {
            this.lib_nature = "Stagiaire temporaire";
         } else if (this.salconType.equals("12")) {
            this.lib_nature = "Intérimaire";
         } else if (this.salconType.equals("13")) {
            this.lib_nature = "Prestataire";
         } else if (this.salconType.equals("14")) {
            this.lib_nature = "Vacataire";
         } else if (this.salconType.equals("20")) {
            this.lib_nature = "Autre";
         } else if (this.salconType.equals("99")) {
            this.lib_nature = "Pool agents (non actifs)";
         } else {
            this.lib_nature = "";
         }
      } else {
         this.lib_nature = "";
      }

      return this.lib_nature;
   }

   public String getLibelleEtat() {
      if (this.salconEtatH == 0) {
         this.libelleEtat = "N.Val.";
      } else if (this.salconEtatH == 1) {
         this.libelleEtat = "Val.";
      } else if (this.salconEtatH == 2) {
         this.libelleEtat = "Gel.";
      } else if (this.salconEtatH == 3) {
         this.libelleEtat = "Annul.";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public void setLib_nature(String var1) {
      this.lib_nature = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public String getSalconCentresImpots() {
      return this.salconCentresImpots;
   }

   public void setSalconCentresImpots(String var1) {
      this.salconCentresImpots = var1;
   }

   public String getSalconClassement() {
      return this.salconClassement;
   }

   public void setSalconClassement(String var1) {
      this.salconClassement = var1;
   }

   public String getSalconConvention() {
      return this.salconConvention;
   }

   public void setSalconConvention(String var1) {
      this.salconConvention = var1;
   }

   public Date getSalconDateCreat() {
      return this.salconDateCreat;
   }

   public void setSalconDateCreat(Date var1) {
      this.salconDateCreat = var1;
   }

   public Date getSalconDateDebut() {
      return this.salconDateDebut;
   }

   public void setSalconDateDebut(Date var1) {
      this.salconDateDebut = var1;
   }

   public Date getSalconDateFin() {
      return this.salconDateFin;
   }

   public void setSalconDateFin(Date var1) {
      this.salconDateFin = var1;
   }

   public Date getSalconDateModif() {
      return this.salconDateModif;
   }

   public void setSalconDateModif(Date var1) {
      this.salconDateModif = var1;
   }

   public String getSalconDepartement() {
      return this.salconDepartement;
   }

   public void setSalconDepartement(String var1) {
      this.salconDepartement = var1;
   }

   public int getSalconEssai() {
      return this.salconEssai;
   }

   public void setSalconEssai(int var1) {
      this.salconEssai = var1;
   }

   public int getSalconEtat() {
      return this.salconEtat;
   }

   public void setSalconEtat(int var1) {
      this.salconEtat = var1;
   }

   public String getSalconFeuille() {
      return this.salconFeuille;
   }

   public void setSalconFeuille(String var1) {
      this.salconFeuille = var1;
   }

   public String getSalconFonction() {
      return this.salconFonction;
   }

   public void setSalconFonction(String var1) {
      this.salconFonction = var1;
   }

   public String getSalconGrille() {
      return this.salconGrille;
   }

   public void setSalconGrille(String var1) {
      this.salconGrille = var1;
   }

   public long getSalconId() {
      return this.salconId;
   }

   public void setSalconId(long var1) {
      this.salconId = var1;
   }

   public String getSalconLibCentresImpots() {
      return this.salconLibCentresImpots;
   }

   public void setSalconLibCentresImpots(String var1) {
      this.salconLibCentresImpots = var1;
   }

   public String getSalconLibClassement() {
      return this.salconLibClassement;
   }

   public void setSalconLibClassement(String var1) {
      this.salconLibClassement = var1;
   }

   public String getSalconLibConvention() {
      return this.salconLibConvention;
   }

   public void setSalconLibConvention(String var1) {
      this.salconLibConvention = var1;
   }

   public String getSalconLibGrille() {
      return this.salconLibGrille;
   }

   public void setSalconLibGrille(String var1) {
      this.salconLibGrille = var1;
   }

   public String getSalconLibNivEmploi() {
      return this.salconLibNivEmploi;
   }

   public void setSalconLibNivEmploi(String var1) {
      this.salconLibNivEmploi = var1;
   }

   public String getSalconLieuTravail() {
      return this.salconLieuTravail;
   }

   public void setSalconLieuTravail(String var1) {
      this.salconLieuTravail = var1;
   }

   public String getSalconMotifSortie() {
      return this.salconMotifSortie;
   }

   public void setSalconMotifSortie(String var1) {
      this.salconMotifSortie = var1;
   }

   public String getSalconType() {
      return this.salconType;
   }

   public void setSalconType(String var1) {
      this.salconType = var1;
   }

   public int getSalconNbMoisEssai() {
      return this.salconNbMoisEssai;
   }

   public void setSalconNbMoisEssai(int var1) {
      this.salconNbMoisEssai = var1;
   }

   public String getSalconNivEmploi() {
      return this.salconNivEmploi;
   }

   public void setSalconNivEmploi(String var1) {
      this.salconNivEmploi = var1;
   }

   public String getSalconService() {
      return this.salconService;
   }

   public void setSalconService(String var1) {
      this.salconService = var1;
   }

   public String getSalconSite() {
      return this.salconSite;
   }

   public void setSalconSite(String var1) {
      this.salconSite = var1;
   }

   public long getSalconUserCreat() {
      return this.salconUserCreat;
   }

   public void setSalconUserCreat(long var1) {
      this.salconUserCreat = var1;
   }

   public long getSalconUserModif() {
      return this.salconUserModif;
   }

   public void setSalconUserModif(long var1) {
      this.salconUserModif = var1;
   }

   public Date getSalconDateConfirmation() {
      return this.salconDateConfirmation;
   }

   public void setSalconDateConfirmation(Date var1) {
      this.salconDateConfirmation = var1;
   }

   public Date getSalconDateRetour() {
      return this.salconDateRetour;
   }

   public void setSalconDateRetour(Date var1) {
      this.salconDateRetour = var1;
   }

   public long getSalconIdRepresetant() {
      return this.salconIdRepresetant;
   }

   public void setSalconIdRepresetant(long var1) {
      this.salconIdRepresetant = var1;
   }

   public String getSalconNomRepresentant() {
      return this.salconNomRepresentant;
   }

   public void setSalconNomRepresentant(String var1) {
      this.salconNomRepresentant = var1;
   }

   public String getSalconQualite() {
      return this.salconQualite;
   }

   public void setSalconQualite(String var1) {
      this.salconQualite = var1;
   }

   public String getSalconActivite() {
      return this.salconActivite;
   }

   public void setSalconActivite(String var1) {
      this.salconActivite = var1;
   }

   public Date getSalconDateRemise() {
      return this.salconDateRemise;
   }

   public void setSalconDateRemise(Date var1) {
      this.salconDateRemise = var1;
   }

   public String getSalconLibActivite() {
      return this.salconLibActivite;
   }

   public void setSalconLibActivite(String var1) {
      this.salconLibActivite = var1;
   }

   public String getSalconParc() {
      return this.salconParc;
   }

   public void setSalconParc(String var1) {
      this.salconParc = var1;
   }

   public double getSalconRbmKms() {
      return this.salconRbmKms;
   }

   public void setSalconRbmKms(double var1) {
      this.salconRbmKms = var1;
   }

   public String getSalconTexte() {
      return this.salconTexte;
   }

   public void setSalconTexte(String var1) {
      this.salconTexte = var1;
   }

   public int getSalconVehicule() {
      return this.salconVehicule;
   }

   public void setSalconVehicule(int var1) {
      this.salconVehicule = var1;
   }

   public String getSalconBudget() {
      return this.salconBudget;
   }

   public void setSalconBudget(String var1) {
      this.salconBudget = var1;
   }

   public String getSalconLibBudget() {
      return this.salconLibBudget;
   }

   public void setSalconLibBudget(String var1) {
      this.salconLibBudget = var1;
   }

   public String getSalconNum() {
      return this.salconNum;
   }

   public void setSalconNum(String var1) {
      this.salconNum = var1;
   }

   public Date getSalconDateValide() {
      return this.salconDateValide;
   }

   public void setSalconDateValide(Date var1) {
      this.salconDateValide = var1;
   }

   public int getSalconEtatH() {
      return this.salconEtatH;
   }

   public void setSalconEtatH(int var1) {
      this.salconEtatH = var1;
   }

   public int getSalconEtatVal() {
      return this.salconEtatVal;
   }

   public void setSalconEtatVal(int var1) {
      this.salconEtatVal = var1;
   }

   public Date getSalconDateImp() {
      return this.salconDateImp;
   }

   public void setSalconDateImp(Date var1) {
      this.salconDateImp = var1;
   }

   public double getSalconAvnDomesticite() {
      return this.salconAvnDomesticite;
   }

   public void setSalconAvnDomesticite(double var1) {
      this.salconAvnDomesticite = var1;
   }

   public double getSalconAvnEau() {
      return this.salconAvnEau;
   }

   public void setSalconAvnEau(double var1) {
      this.salconAvnEau = var1;
   }

   public double getSalconAvnElectricite() {
      return this.salconAvnElectricite;
   }

   public void setSalconAvnElectricite(double var1) {
      this.salconAvnElectricite = var1;
   }

   public double getSalconAvnLogement() {
      return this.salconAvnLogement;
   }

   public void setSalconAvnLogement(double var1) {
      this.salconAvnLogement = var1;
   }

   public double getSalconAvnNourriture() {
      return this.salconAvnNourriture;
   }

   public void setSalconAvnNourriture(double var1) {
      this.salconAvnNourriture = var1;
   }

   public double getSalconAvnTelephone() {
      return this.salconAvnTelephone;
   }

   public void setSalconAvnTelephone(double var1) {
      this.salconAvnTelephone = var1;
   }

   public double getSalconAvnVehicule() {
      return this.salconAvnVehicule;
   }

   public void setSalconAvnVehicule(double var1) {
      this.salconAvnVehicule = var1;
   }

   public double getSalconIndemniteCaisse() {
      return this.salconIndemniteCaisse;
   }

   public void setSalconIndemniteCaisse(double var1) {
      this.salconIndemniteCaisse = var1;
   }

   public double getSalconIndemniteLogement() {
      return this.salconIndemniteLogement;
   }

   public void setSalconIndemniteLogement(double var1) {
      this.salconIndemniteLogement = var1;
   }

   public double getSalconIndemniteTransport() {
      return this.salconIndemniteTransport;
   }

   public void setSalconIndemniteTransport(double var1) {
      this.salconIndemniteTransport = var1;
   }

   public double getSalconPrimeFonction() {
      return this.salconPrimeFonction;
   }

   public void setSalconPrimeFonction(double var1) {
      this.salconPrimeFonction = var1;
   }

   public double getSalconPrimeRendement() {
      return this.salconPrimeRendement;
   }

   public void setSalconPrimeRendement(double var1) {
      this.salconPrimeRendement = var1;
   }

   public double getSalconPrimeResponsabilite() {
      return this.salconPrimeResponsabilite;
   }

   public void setSalconPrimeResponsabilite(double var1) {
      this.salconPrimeResponsabilite = var1;
   }

   public float getSalconNbJourCp() {
      return this.salconNbJourCp;
   }

   public void setSalconNbJourCp(float var1) {
      this.salconNbJourCp = var1;
   }

   public float getSalconNbJourTr() {
      return this.salconNbJourTr;
   }

   public void setSalconNbJourTr(float var1) {
      this.salconNbJourTr = var1;
   }

   public String getSalconCle1Anal() {
      return this.salconCle1Anal;
   }

   public void setSalconCle1Anal(String var1) {
      this.salconCle1Anal = var1;
   }

   public String getSalconCle2Anal() {
      return this.salconCle2Anal;
   }

   public void setSalconCle2Anal(String var1) {
      this.salconCle2Anal = var1;
   }

   public String getSalconLibCle1Anal() {
      return this.salconLibCle1Anal;
   }

   public void setSalconLibCle1Anal(String var1) {
      this.salconLibCle1Anal = var1;
   }

   public String getSalconLibCle2Anal() {
      return this.salconLibCle2Anal;
   }

   public void setSalconLibCle2Anal(String var1) {
      this.salconLibCle2Anal = var1;
   }

   public double getSalconSursalaire() {
      return this.salconSursalaire;
   }

   public void setSalconSursalaire(double var1) {
      this.salconSursalaire = var1;
   }

   public double getSalconIndemniteDeplacement() {
      return this.salconIndemniteDeplacement;
   }

   public void setSalconIndemniteDeplacement(double var1) {
      this.salconIndemniteDeplacement = var1;
   }

   public double getSalconIndemniteKilometrique() {
      return this.salconIndemniteKilometrique;
   }

   public void setSalconIndemniteKilometrique(double var1) {
      this.salconIndemniteKilometrique = var1;
   }

   public double getSalconIndemniteSalissure() {
      return this.salconIndemniteSalissure;
   }

   public void setSalconIndemniteSalissure(double var1) {
      this.salconIndemniteSalissure = var1;
   }

   public double getSalconPrimeSujetion() {
      return this.salconPrimeSujetion;
   }

   public void setSalconPrimeSujetion(double var1) {
      this.salconPrimeSujetion = var1;
   }

   public double getSalconIndemniteRepresentation() {
      return this.salconIndemniteRepresentation;
   }

   public void setSalconIndemniteRepresentation(double var1) {
      this.salconIndemniteRepresentation = var1;
   }

   public double getSalconBase() {
      return this.salconBase;
   }

   public void setSalconBase(double var1) {
      this.salconBase = var1;
   }

   public String getSalconLibProjet() {
      return this.salconLibProjet;
   }

   public void setSalconLibProjet(String var1) {
      this.salconLibProjet = var1;
   }

   public String getSalconProjet() {
      return this.salconProjet;
   }

   public void setSalconProjet(String var1) {
      this.salconProjet = var1;
   }

   public double getSalconForfaitSup() {
      return this.salconForfaitSup;
   }

   public void setSalconForfaitSup(double var1) {
      this.salconForfaitSup = var1;
   }

   public double getSalconPrimeOutillage() {
      return this.salconPrimeOutillage;
   }

   public void setSalconPrimeOutillage(double var1) {
      this.salconPrimeOutillage = var1;
   }

   public boolean isEffectue() {
      return this.effectue;
   }

   public void setEffectue(boolean var1) {
      this.effectue = var1;
   }

   public double getSalconPrimeAstreinte() {
      return this.salconPrimeAstreinte;
   }

   public void setSalconPrimeAstreinte(double var1) {
      this.salconPrimeAstreinte = var1;
   }

   public long getSalconIdTiers() {
      return this.salconIdTiers;
   }

   public void setSalconIdTiers(long var1) {
      this.salconIdTiers = var1;
   }

   public String getSalconNomTiers() {
      return this.salconNomTiers;
   }

   public void setSalconNomTiers(String var1) {
      this.salconNomTiers = var1;
   }

   public double getHistoAdm() {
      return this.histoAdm;
   }

   public void setHistoAdm(double var1) {
      this.histoAdm = var1;
   }

   public double getHistoBrut() {
      return this.histoBrut;
   }

   public void setHistoBrut(double var1) {
      this.histoBrut = var1;
   }

   public double getHistoCp() {
      return this.histoCp;
   }

   public void setHistoCp(double var1) {
      this.histoCp = var1;
   }

   public double getHistoNbjs() {
      return this.histoNbjs;
   }

   public void setHistoNbjs(double var1) {
      this.histoNbjs = var1;
   }

   public String getSalconLibService() {
      return this.salconLibService;
   }

   public void setSalconLibService(String var1) {
      this.salconLibService = var1;
   }

   public Date getSalconDateAvenantDeb1() {
      return this.salconDateAvenantDeb1;
   }

   public void setSalconDateAvenantDeb1(Date var1) {
      this.salconDateAvenantDeb1 = var1;
   }

   public Date getSalconDateAvenantFin1() {
      return this.salconDateAvenantFin1;
   }

   public void setSalconDateAvenantFin1(Date var1) {
      this.salconDateAvenantFin1 = var1;
   }

   public Date getSalconDateAvenantFin2() {
      return this.salconDateAvenantFin2;
   }

   public void setSalconDateAvenantFin2(Date var1) {
      this.salconDateAvenantFin2 = var1;
   }

   public Date getSalconDateAvenantFin3() {
      return this.salconDateAvenantFin3;
   }

   public void setSalconDateAvenantFin3(Date var1) {
      this.salconDateAvenantFin3 = var1;
   }

   public String getSalconDocument() {
      return this.salconDocument;
   }

   public void setSalconDocument(String var1) {
      this.salconDocument = var1;
   }

   public String getSalconLocalisation() {
      return this.salconLocalisation;
   }

   public void setSalconLocalisation(String var1) {
      this.salconLocalisation = var1;
   }

   public String getSalconCodeEmploi() {
      return this.salconCodeEmploi;
   }

   public void setSalconCodeEmploi(String var1) {
      this.salconCodeEmploi = var1;
   }

   public double getSalconPrimeExceptionnelle() {
      return this.salconPrimeExceptionnelle;
   }

   public void setSalconPrimeExceptionnelle(double var1) {
      this.salconPrimeExceptionnelle = var1;
   }

   public float getSalconTaux() {
      return this.salconTaux;
   }

   public void setSalconTaux(float var1) {
      this.salconTaux = var1;
   }

   public int getSalconPosSignature() {
      return this.salconPosSignature;
   }

   public void setSalconPosSignature(int var1) {
      this.salconPosSignature = var1;
   }

   public double getSalconIndemniteDiverse() {
      return this.salconIndemniteDiverse;
   }

   public void setSalconIndemniteDiverse(double var1) {
      this.salconIndemniteDiverse = var1;
   }

   public double getSalconIndemniteNourriture() {
      return this.salconIndemniteNourriture;
   }

   public void setSalconIndemniteNourriture(double var1) {
      this.salconIndemniteNourriture = var1;
   }

   public double getSalconIndemniteResponsabilite() {
      return this.salconIndemniteResponsabilite;
   }

   public void setSalconIndemniteResponsabilite(double var1) {
      this.salconIndemniteResponsabilite = var1;
   }

   public String getSalconCentresSecurite() {
      return this.salconCentresSecurite;
   }

   public void setSalconCentresSecurite(String var1) {
      this.salconCentresSecurite = var1;
   }

   public String getSalconLibCentresSecurite() {
      return this.salconLibCentresSecurite;
   }

   public void setSalconLibCentresSecurite(String var1) {
      this.salconLibCentresSecurite = var1;
   }

   public float getSalconNbHeureMois() {
      return this.salconNbHeureMois;
   }

   public void setSalconNbHeureMois(float var1) {
      this.salconNbHeureMois = var1;
   }

   public double getSalconPrimeLogement() {
      return this.salconPrimeLogement;
   }

   public void setSalconPrimeLogement(double var1) {
      this.salconPrimeLogement = var1;
   }

   public double getSalconPrimeTransport() {
      return this.salconPrimeTransport;
   }

   public void setSalconPrimeTransport(double var1) {
      this.salconPrimeTransport = var1;
   }

   public Date getSalconDateAvenantFin10() {
      return this.salconDateAvenantFin10;
   }

   public void setSalconDateAvenantFin10(Date var1) {
      this.salconDateAvenantFin10 = var1;
   }

   public Date getSalconDateAvenantFin11() {
      return this.salconDateAvenantFin11;
   }

   public void setSalconDateAvenantFin11(Date var1) {
      this.salconDateAvenantFin11 = var1;
   }

   public Date getSalconDateAvenantFin12() {
      return this.salconDateAvenantFin12;
   }

   public void setSalconDateAvenantFin12(Date var1) {
      this.salconDateAvenantFin12 = var1;
   }

   public Date getSalconDateAvenantFin4() {
      return this.salconDateAvenantFin4;
   }

   public void setSalconDateAvenantFin4(Date var1) {
      this.salconDateAvenantFin4 = var1;
   }

   public Date getSalconDateAvenantFin5() {
      return this.salconDateAvenantFin5;
   }

   public void setSalconDateAvenantFin5(Date var1) {
      this.salconDateAvenantFin5 = var1;
   }

   public Date getSalconDateAvenantFin6() {
      return this.salconDateAvenantFin6;
   }

   public void setSalconDateAvenantFin6(Date var1) {
      this.salconDateAvenantFin6 = var1;
   }

   public Date getSalconDateAvenantFin7() {
      return this.salconDateAvenantFin7;
   }

   public void setSalconDateAvenantFin7(Date var1) {
      this.salconDateAvenantFin7 = var1;
   }

   public Date getSalconDateAvenantFin8() {
      return this.salconDateAvenantFin8;
   }

   public void setSalconDateAvenantFin8(Date var1) {
      this.salconDateAvenantFin8 = var1;
   }

   public Date getSalconDateAvenantFin9() {
      return this.salconDateAvenantFin9;
   }

   public void setSalconDateAvenantFin9(Date var1) {
      this.salconDateAvenantFin9 = var1;
   }

   public Date getSalconDateEntreeInitial() {
      return this.salconDateEntreeInitial;
   }

   public void setSalconDateEntreeInitial(Date var1) {
      this.salconDateEntreeInitial = var1;
   }
}
