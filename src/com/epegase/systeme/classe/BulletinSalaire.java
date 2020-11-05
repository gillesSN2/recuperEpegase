package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BulletinSalaire implements Serializable {
   private long bulsalId;
   private String bulsalFeuille;
   private String bulsalContrat;
   private String bulsalPeriode;
   private boolean bulsalEtatBulletin;
   private String bulsalMatricule;
   private Date bulsalDateDebut;
   private Date bulsalDateFin;
   private Date bulsalDateDebutReel;
   private Date bulsalDateFinReel;
   private String bulsalNature;
   private int bulsalEtat;
   private int bulsalEssai;
   private String bulsalCivilite;
   private String bulsalFonction;
   private long bulsalIdTiers;
   private String bulsalProjet;
   private String bulsalSite;
   private String bulsalDepartement;
   private String bulsalService;
   private String bulsalLibService;
   private String bulsalActivite;
   private String bulsalLocalisation;
   private String bulsalBudget;
   private String bulsalParc;
   private int bulsalSitFamille;
   private int bulsalGenre;
   private int bulsalNbEnfant;
   private float bulsalNbPartFiscal;
   private int bulsalNbFemme;
   private float bulsalNbPartTrimf;
   private float bulsalNbJourCp;
   private float bulsalNbJourTr;
   private String bulsalConvention;
   private String bulsalLibConvention;
   private String bulsalCentresImpots;
   private String bulsalLibCentresImpots;
   private String bulsalCentresSecurite;
   private String bulsalLibCentresSecurite;
   private String bulsalClassement;
   private String bulsalLibClassement;
   private String bulsalNivEmploi;
   private String bulsalLibNivEmploi;
   private String bulsalGrille;
   private String bulsalLibGrille;
   private Date bulsalDateentree;
   private Date bulsalDateSortie;
   private String bulsalMotifSortie;
   private double bulsalAvNat;
   private double bulsalBrut;
   private double bulsalBaseReference;
   private int bulsalTypeCP;
   private double bulsalCP;
   private float bulsalNbCpPris;
   private float bulsalNbCpAcquis;
   private float bulsalNbCpFeries;
   private float bulsalNbDispo;
   private double bulsalBaseImposableFiscale;
   private double bulsalBaseImposableSociale;
   private double bulsalNetPayer;
   private double bulsalImpot1;
   private double bulsalImpot2;
   private double bulsalImpot3;
   private double bulsalImpot4;
   private double bulsalImpot5;
   private double bulsalImpot6;
   private double bulsalImpot7;
   private double bulsalImpot8;
   private double bulsalImpot9;
   private double bulsalImpot10;
   private Date bulsalDateTransfert;
   private String bulsalCle1Anal;
   private String bulsalCle2Anal;
   private int bulsalModeReglement;
   private String bulsalNumBanque;
   private String bulsalGuichetBanque;
   private String bulsalCompteBanque;
   private String bulsalCleBanque;
   private String bulsalIban;
   private String bulsalSwift;
   private String bulsalCompteMembre;
   private int bulsalManuel;
   private Date bulsalDateImpression;
   private long bulsalUserCreat;
   private long bulsalUserModif;
   private int bulsalLot;
   private String bulsalSecu1;
   private String bulsalSecu2;
   private String bulsalPayeBnq;
   private String bulsalPayeChq;
   private long bulsalPayeIdCaissier;
   private Date bulsalPayeDate;
   private Salaries salaries;
   private ExercicesPaye exercicesPaye;
   private String libEtat;
   private String observations;
   private String patronyme;
   private String colorPaiement;

   public String getColorPaiement() {
      if (this.bulsalPayeIdCaissier < 0L) {
         this.colorPaiement = "color:red";
      } else if (this.bulsalPayeIdCaissier > 0L) {
         this.colorPaiement = "color:blue";
      } else {
         this.colorPaiement = "color:black";
      }

      return this.colorPaiement;
   }

   public void setColorPaiement(String var1) {
      this.colorPaiement = var1;
   }

   public String getPatronyme() {
      if (this.salaries.getSalPrenom() != null && !this.salaries.getSalPrenom().isEmpty()) {
         this.patronyme = this.salaries.getSalNom() + " " + this.salaries.getSalPrenom();
      } else {
         this.patronyme = this.salaries.getSalNom();
      }

      return this.patronyme;
   }

   public void setPatronyme(String var1) {
      this.patronyme = var1;
   }

   public String getLibEtat() {
      if (this.bulsalEtat == 0) {
         this.libEtat = "En Cours";
      } else if (this.bulsalEtat == 1) {
         this.libEtat = "En congés";
      } else if (this.bulsalEtat == 2) {
         this.libEtat = "Licencié(e)";
      } else if (this.bulsalEtat == 3) {
         this.libEtat = "Démissionné(e)";
      } else if (this.bulsalEtat == 4) {
         this.libEtat = "Décédé(e)";
      } else if (this.bulsalEtat == 5) {
         this.libEtat = "Retraité(e)";
      } else if (this.bulsalEtat == 6) {
         this.libEtat = "Fin contrat";
      } else if (this.bulsalEtat == 7) {
         this.libEtat = "Arrêt ou Suspension";
      } else if (this.bulsalEtat == 8) {
         this.libEtat = "Mutation";
      } else if (this.bulsalEtat == 9) {
         this.libEtat = "Gelé";
      } else if (this.bulsalEtat == 10) {
         this.libEtat = "Départ négocié";
      }

      return this.libEtat;
   }

   public void setLibEtat(String var1) {
      this.libEtat = var1;
   }

   public String getBulsalActivite() {
      return this.bulsalActivite;
   }

   public void setBulsalActivite(String var1) {
      this.bulsalActivite = var1;
   }

   public double getBulsalAvNat() {
      return this.bulsalAvNat;
   }

   public void setBulsalAvNat(double var1) {
      this.bulsalAvNat = var1;
   }

   public double getBulsalBaseImposableFiscale() {
      return this.bulsalBaseImposableFiscale;
   }

   public void setBulsalBaseImposableFiscale(double var1) {
      this.bulsalBaseImposableFiscale = var1;
   }

   public double getBulsalBaseImposableSociale() {
      return this.bulsalBaseImposableSociale;
   }

   public void setBulsalBaseImposableSociale(double var1) {
      this.bulsalBaseImposableSociale = var1;
   }

   public double getBulsalBrut() {
      return this.bulsalBrut;
   }

   public void setBulsalBrut(double var1) {
      this.bulsalBrut = var1;
   }

   public String getBulsalBudget() {
      return this.bulsalBudget;
   }

   public void setBulsalBudget(String var1) {
      this.bulsalBudget = var1;
   }

   public double getBulsalCP() {
      return this.bulsalCP;
   }

   public void setBulsalCP(double var1) {
      this.bulsalCP = var1;
   }

   public String getBulsalCentresImpots() {
      return this.bulsalCentresImpots;
   }

   public void setBulsalCentresImpots(String var1) {
      this.bulsalCentresImpots = var1;
   }

   public String getBulsalCivilite() {
      return this.bulsalCivilite;
   }

   public void setBulsalCivilite(String var1) {
      this.bulsalCivilite = var1;
   }

   public String getBulsalClassement() {
      return this.bulsalClassement;
   }

   public void setBulsalClassement(String var1) {
      this.bulsalClassement = var1;
   }

   public String getBulsalConvention() {
      return this.bulsalConvention;
   }

   public void setBulsalConvention(String var1) {
      this.bulsalConvention = var1;
   }

   public Date getBulsalDateDebut() {
      return this.bulsalDateDebut;
   }

   public void setBulsalDateDebut(Date var1) {
      this.bulsalDateDebut = var1;
   }

   public Date getBulsalDateFin() {
      return this.bulsalDateFin;
   }

   public void setBulsalDateFin(Date var1) {
      this.bulsalDateFin = var1;
   }

   public Date getBulsalDateSortie() {
      return this.bulsalDateSortie;
   }

   public void setBulsalDateSortie(Date var1) {
      this.bulsalDateSortie = var1;
   }

   public String getBulsalDepartement() {
      return this.bulsalDepartement;
   }

   public void setBulsalDepartement(String var1) {
      this.bulsalDepartement = var1;
   }

   public int getBulsalEtat() {
      return this.bulsalEtat;
   }

   public void setBulsalEtat(int var1) {
      this.bulsalEtat = var1;
   }

   public String getBulsalFeuille() {
      return this.bulsalFeuille;
   }

   public void setBulsalFeuille(String var1) {
      this.bulsalFeuille = var1;
   }

   public String getBulsalFonction() {
      return this.bulsalFonction;
   }

   public void setBulsalFonction(String var1) {
      this.bulsalFonction = var1;
   }

   public int getBulsalGenre() {
      return this.bulsalGenre;
   }

   public void setBulsalGenre(int var1) {
      this.bulsalGenre = var1;
   }

   public String getBulsalGrille() {
      return this.bulsalGrille;
   }

   public void setBulsalGrille(String var1) {
      this.bulsalGrille = var1;
   }

   public long getBulsalId() {
      return this.bulsalId;
   }

   public void setBulsalId(long var1) {
      this.bulsalId = var1;
   }

   public double getBulsalImpot1() {
      return this.bulsalImpot1;
   }

   public void setBulsalImpot1(double var1) {
      this.bulsalImpot1 = var1;
   }

   public double getBulsalImpot10() {
      return this.bulsalImpot10;
   }

   public void setBulsalImpot10(double var1) {
      this.bulsalImpot10 = var1;
   }

   public double getBulsalImpot2() {
      return this.bulsalImpot2;
   }

   public void setBulsalImpot2(double var1) {
      this.bulsalImpot2 = var1;
   }

   public double getBulsalImpot3() {
      return this.bulsalImpot3;
   }

   public void setBulsalImpot3(double var1) {
      this.bulsalImpot3 = var1;
   }

   public double getBulsalImpot4() {
      return this.bulsalImpot4;
   }

   public void setBulsalImpot4(double var1) {
      this.bulsalImpot4 = var1;
   }

   public double getBulsalImpot5() {
      return this.bulsalImpot5;
   }

   public void setBulsalImpot5(double var1) {
      this.bulsalImpot5 = var1;
   }

   public double getBulsalImpot6() {
      return this.bulsalImpot6;
   }

   public void setBulsalImpot6(double var1) {
      this.bulsalImpot6 = var1;
   }

   public double getBulsalImpot7() {
      return this.bulsalImpot7;
   }

   public void setBulsalImpot7(double var1) {
      this.bulsalImpot7 = var1;
   }

   public double getBulsalImpot8() {
      return this.bulsalImpot8;
   }

   public void setBulsalImpot8(double var1) {
      this.bulsalImpot8 = var1;
   }

   public double getBulsalImpot9() {
      return this.bulsalImpot9;
   }

   public void setBulsalImpot9(double var1) {
      this.bulsalImpot9 = var1;
   }

   public String getBulsalLibCentresImpots() {
      return this.bulsalLibCentresImpots;
   }

   public void setBulsalLibCentresImpots(String var1) {
      this.bulsalLibCentresImpots = var1;
   }

   public String getBulsalLibClassement() {
      return this.bulsalLibClassement;
   }

   public void setBulsalLibClassement(String var1) {
      this.bulsalLibClassement = var1;
   }

   public String getBulsalLibConvention() {
      return this.bulsalLibConvention;
   }

   public void setBulsalLibConvention(String var1) {
      this.bulsalLibConvention = var1;
   }

   public String getBulsalLibGrille() {
      return this.bulsalLibGrille;
   }

   public void setBulsalLibGrille(String var1) {
      this.bulsalLibGrille = var1;
   }

   public String getBulsalLibNivEmploi() {
      return this.bulsalLibNivEmploi;
   }

   public void setBulsalLibNivEmploi(String var1) {
      this.bulsalLibNivEmploi = var1;
   }

   public String getBulsalMotifSortie() {
      return this.bulsalMotifSortie;
   }

   public void setBulsalMotifSortie(String var1) {
      this.bulsalMotifSortie = var1;
   }

   public String getBulsalNature() {
      return this.bulsalNature;
   }

   public void setBulsalNature(String var1) {
      this.bulsalNature = var1;
   }

   public float getBulsalNbCpAcquis() {
      return this.bulsalNbCpAcquis;
   }

   public void setBulsalNbCpAcquis(float var1) {
      this.bulsalNbCpAcquis = var1;
   }

   public float getBulsalNbCpPris() {
      return this.bulsalNbCpPris;
   }

   public void setBulsalNbCpPris(float var1) {
      this.bulsalNbCpPris = var1;
   }

   public int getBulsalNbEnfant() {
      return this.bulsalNbEnfant;
   }

   public void setBulsalNbEnfant(int var1) {
      this.bulsalNbEnfant = var1;
   }

   public int getBulsalNbFemme() {
      return this.bulsalNbFemme;
   }

   public void setBulsalNbFemme(int var1) {
      this.bulsalNbFemme = var1;
   }

   public float getBulsalNbJourCp() {
      return this.bulsalNbJourCp;
   }

   public void setBulsalNbJourCp(float var1) {
      this.bulsalNbJourCp = var1;
   }

   public float getBulsalNbJourTr() {
      return this.bulsalNbJourTr;
   }

   public void setBulsalNbJourTr(float var1) {
      this.bulsalNbJourTr = var1;
   }

   public float getBulsalNbPartFiscal() {
      return this.bulsalNbPartFiscal;
   }

   public void setBulsalNbPartFiscal(float var1) {
      this.bulsalNbPartFiscal = var1;
   }

   public float getBulsalNbPartTrimf() {
      return this.bulsalNbPartTrimf;
   }

   public void setBulsalNbPartTrimf(float var1) {
      this.bulsalNbPartTrimf = var1;
   }

   public double getBulsalNetPayer() {
      return this.bulsalNetPayer;
   }

   public void setBulsalNetPayer(double var1) {
      this.bulsalNetPayer = var1;
   }

   public String getBulsalNivEmploi() {
      return this.bulsalNivEmploi;
   }

   public void setBulsalNivEmploi(String var1) {
      this.bulsalNivEmploi = var1;
   }

   public String getBulsalParc() {
      return this.bulsalParc;
   }

   public void setBulsalParc(String var1) {
      this.bulsalParc = var1;
   }

   public String getBulsalPeriode() {
      return this.bulsalPeriode;
   }

   public void setBulsalPeriode(String var1) {
      this.bulsalPeriode = var1;
   }

   public String getBulsalService() {
      return this.bulsalService;
   }

   public void setBulsalService(String var1) {
      this.bulsalService = var1;
   }

   public int getBulsalSitFamille() {
      return this.bulsalSitFamille;
   }

   public void setBulsalSitFamille(int var1) {
      this.bulsalSitFamille = var1;
   }

   public String getBulsalSite() {
      return this.bulsalSite;
   }

   public void setBulsalSite(String var1) {
      this.bulsalSite = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public String getBulsalMatricule() {
      return this.bulsalMatricule;
   }

   public void setBulsalMatricule(String var1) {
      this.bulsalMatricule = var1;
   }

   public String getBulsalContrat() {
      return this.bulsalContrat;
   }

   public void setBulsalContrat(String var1) {
      this.bulsalContrat = var1;
   }

   public String getObservations() {
      return this.observations;
   }

   public void setObservations(String var1) {
      this.observations = var1;
   }

   public Date getBulsalDateTransfert() {
      return this.bulsalDateTransfert;
   }

   public void setBulsalDateTransfert(Date var1) {
      this.bulsalDateTransfert = var1;
   }

   public String getBulsalCle1Anal() {
      return this.bulsalCle1Anal;
   }

   public void setBulsalCle1Anal(String var1) {
      this.bulsalCle1Anal = var1;
   }

   public String getBulsalCle2Anal() {
      return this.bulsalCle2Anal;
   }

   public void setBulsalCle2Anal(String var1) {
      this.bulsalCle2Anal = var1;
   }

   public float getBulsalNbCpFeries() {
      return this.bulsalNbCpFeries;
   }

   public void setBulsalNbCpFeries(float var1) {
      this.bulsalNbCpFeries = var1;
   }

   public String getBulsalCleBanque() {
      return this.bulsalCleBanque;
   }

   public void setBulsalCleBanque(String var1) {
      this.bulsalCleBanque = var1;
   }

   public String getBulsalCompteBanque() {
      return this.bulsalCompteBanque;
   }

   public void setBulsalCompteBanque(String var1) {
      this.bulsalCompteBanque = var1;
   }

   public String getBulsalGuichetBanque() {
      return this.bulsalGuichetBanque;
   }

   public void setBulsalGuichetBanque(String var1) {
      this.bulsalGuichetBanque = var1;
   }

   public String getBulsalIban() {
      return this.bulsalIban;
   }

   public void setBulsalIban(String var1) {
      this.bulsalIban = var1;
   }

   public int getBulsalModeReglement() {
      return this.bulsalModeReglement;
   }

   public void setBulsalModeReglement(int var1) {
      this.bulsalModeReglement = var1;
   }

   public String getBulsalNumBanque() {
      return this.bulsalNumBanque;
   }

   public void setBulsalNumBanque(String var1) {
      this.bulsalNumBanque = var1;
   }

   public String getBulsalSwift() {
      return this.bulsalSwift;
   }

   public void setBulsalSwift(String var1) {
      this.bulsalSwift = var1;
   }

   public int getBulsalManuel() {
      return this.bulsalManuel;
   }

   public void setBulsalManuel(int var1) {
      this.bulsalManuel = var1;
   }

   public String getBulsalProjet() {
      return this.bulsalProjet;
   }

   public void setBulsalProjet(String var1) {
      this.bulsalProjet = var1;
   }

   public Date getBulsalDateentree() {
      return this.bulsalDateentree;
   }

   public void setBulsalDateentree(Date var1) {
      this.bulsalDateentree = var1;
   }

   public float getBulsalNbDispo() {
      return this.bulsalNbDispo;
   }

   public void setBulsalNbDispo(float var1) {
      this.bulsalNbDispo = var1;
   }

   public int getBulsalTypeCP() {
      return this.bulsalTypeCP;
   }

   public void setBulsalTypeCP(int var1) {
      this.bulsalTypeCP = var1;
   }

   public long getBulsalIdTiers() {
      return this.bulsalIdTiers;
   }

   public void setBulsalIdTiers(long var1) {
      this.bulsalIdTiers = var1;
   }

   public String getBulsalCompteMembre() {
      return this.bulsalCompteMembre;
   }

   public void setBulsalCompteMembre(String var1) {
      this.bulsalCompteMembre = var1;
   }

   public String getBulsalLibService() {
      return this.bulsalLibService;
   }

   public void setBulsalLibService(String var1) {
      this.bulsalLibService = var1;
   }

   public double getBulsalBaseReference() {
      return this.bulsalBaseReference;
   }

   public void setBulsalBaseReference(double var1) {
      this.bulsalBaseReference = var1;
   }

   public Date getBulsalDateImpression() {
      return this.bulsalDateImpression;
   }

   public void setBulsalDateImpression(Date var1) {
      this.bulsalDateImpression = var1;
   }

   public long getBulsalUserCreat() {
      return this.bulsalUserCreat;
   }

   public void setBulsalUserCreat(long var1) {
      this.bulsalUserCreat = var1;
   }

   public long getBulsalUserModif() {
      return this.bulsalUserModif;
   }

   public void setBulsalUserModif(long var1) {
      this.bulsalUserModif = var1;
   }

   public boolean isBulsalEtatBulletin() {
      return this.bulsalEtatBulletin;
   }

   public void setBulsalEtatBulletin(boolean var1) {
      this.bulsalEtatBulletin = var1;
   }

   public String getBulsalLocalisation() {
      return this.bulsalLocalisation;
   }

   public void setBulsalLocalisation(String var1) {
      this.bulsalLocalisation = var1;
   }

   public int getBulsalLot() {
      return this.bulsalLot;
   }

   public void setBulsalLot(int var1) {
      this.bulsalLot = var1;
   }

   public String getBulsalSecu1() {
      return this.bulsalSecu1;
   }

   public void setBulsalSecu1(String var1) {
      this.bulsalSecu1 = var1;
   }

   public String getBulsalSecu2() {
      return this.bulsalSecu2;
   }

   public void setBulsalSecu2(String var1) {
      this.bulsalSecu2 = var1;
   }

   public Date getBulsalDateDebutReel() {
      return this.bulsalDateDebutReel;
   }

   public void setBulsalDateDebutReel(Date var1) {
      this.bulsalDateDebutReel = var1;
   }

   public Date getBulsalDateFinReel() {
      return this.bulsalDateFinReel;
   }

   public void setBulsalDateFinReel(Date var1) {
      this.bulsalDateFinReel = var1;
   }

   public String getBulsalCentresSecurite() {
      return this.bulsalCentresSecurite;
   }

   public void setBulsalCentresSecurite(String var1) {
      this.bulsalCentresSecurite = var1;
   }

   public String getBulsalLibCentresSecurite() {
      return this.bulsalLibCentresSecurite;
   }

   public void setBulsalLibCentresSecurite(String var1) {
      this.bulsalLibCentresSecurite = var1;
   }

   public String getBulsalPayeBnq() {
      return this.bulsalPayeBnq;
   }

   public void setBulsalPayeBnq(String var1) {
      this.bulsalPayeBnq = var1;
   }

   public String getBulsalPayeChq() {
      return this.bulsalPayeChq;
   }

   public void setBulsalPayeChq(String var1) {
      this.bulsalPayeChq = var1;
   }

   public Date getBulsalPayeDate() {
      return this.bulsalPayeDate;
   }

   public void setBulsalPayeDate(Date var1) {
      this.bulsalPayeDate = var1;
   }

   public long getBulsalPayeIdCaissier() {
      return this.bulsalPayeIdCaissier;
   }

   public void setBulsalPayeIdCaissier(long var1) {
      this.bulsalPayeIdCaissier = var1;
   }

   public int getBulsalEssai() {
      return this.bulsalEssai;
   }

   public void setBulsalEssai(int var1) {
      this.bulsalEssai = var1;
   }
}
