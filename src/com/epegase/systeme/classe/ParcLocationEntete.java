package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ParcLocationEntete implements Serializable {
   private long prclocId;
   private Date prclocDateCreat;
   private Date prclocDateModif;
   private long prclocIdCreateur;
   private String prclocNomCreateur;
   private long prclocIdModif;
   private String prclocNomModif;
   private Date prclocDate;
   private Date prclocDateDepart;
   private Date prclocDateRetour;
   private double prclocDuree;
   private String prclocLieuDepart;
   private String prclocLieuRetour;
   private String prclocNum;
   private int prclocType;
   private String prclocNomCommercial;
   private long prclocIdCommercial;
   private String prclocNomChauffeur;
   private long prclocIdChauffeur;
   private String prclocNomClient;
   private String prclocCivilTiers;
   private float prclocTauxRemise;
   private double prclocTotRemise;
   private double prclocTotRabais;
   private int prclocExoTva;
   private int prclocExoDouane;
   private String prclocCat;
   private String prclocDevise;
   private int prclocTypeReg;
   private String prclocModeReg;
   private String prclocSerie;
   private String prclocActivite;
   private String prclocSite;
   private String prclocDepartement;
   private String prclocService;
   private String prclocRegion;
   private String prclocSecteur;
   private String prclocPdv;
   private String prclocAnal2;
   private String prclocAnal4;
   private Date prclocDateImp;
   private String prclocModeleImp;
   private int prclocEtatVal;
   private int prclocGele;
   private int prclocEtat;
   private Date prclocDateValide;
   private Date prclocDateAnnule;
   private String prclocMotifAnnule;
   private long prclocCompteur;
   private int prclocTypeCompteur;
   private String prclocAvantGauche;
   private String prclocAvantDroit;
   private String prclocArriereGauche;
   private String prclocArriereDroit;
   private String prclocLateralGauche;
   private String prclocLateralDroit;
   private String prclocInterieur;
   private int prclocNiveauCarburant;
   private boolean prclocRoueSecours;
   private boolean prclocCrick;
   private boolean prclocExtincteur;
   private boolean prclocTrousseSecours;
   private boolean prclocGilet;
   private boolean prclocTriangle;
   private boolean prclocBoiteOutils;
   private boolean prclocPapier1;
   private boolean prclocPapier2;
   private boolean prclocPapier3;
   private boolean prclocPapier4;
   private boolean prclocPapier5;
   private boolean prclocPapier6;
   private String prclocNumChassis;
   private String prclocNumMoteur;
   private String prclocNomFin;
   private long prclocIdFin;
   private double prclocPu;
   private double prclocPv;
   private double prclocTotHt;
   private double prclocTotTva;
   private double prclocTotTtc;
   private float prclocTauxTc;
   private double prclocTotTc;
   private long prclocCompteurFin;
   private long prclocCompteurDistance;
   private String prclocAvantGaucheFin;
   private String prclocAvantDroitFin;
   private String prclocArriereGaucheFin;
   private String prclocArriereDroitFin;
   private String prclocLateralGaucheFin;
   private String prclocLateralDroitFin;
   private String prclocInterieurFin;
   private int prclocNiveauCarburantFin;
   private boolean prclocRoueSecoursFin;
   private boolean prclocCrickFin;
   private boolean prclocExtincteurFin;
   private boolean prclocTrousseSecoursFin;
   private boolean prclocGiletFin;
   private boolean prclocTriangleFin;
   private boolean prclocBoiteOutilsFin;
   private boolean prclocPapier1Fin;
   private boolean prclocPapier2Fin;
   private boolean prclocPapier3Fin;
   private boolean prclocPapier4Fin;
   private boolean prclocPapier5Fin;
   private boolean prclocPapier6Fin;
   private int prclocDiversTiers;
   private String prclocDiversNom;
   private String prclocDiversAdresse;
   private String prclocDiversVille;
   private String prclocDiversTel;
   private String prclocDiversMail;
   private String prclocSource;
   private ExercicesParc exercicesParc;
   private Parc parc;
   private Tiers tiers;
   private String libelleEta;

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public String getLibelleEta() {
      if (this.prclocEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.prclocEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.prclocEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.prclocEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.prclocEtat == 4) {
         this.libelleEta = "Terminé";
      }

      return this.libelleEta;
   }

   public void setLibelleEta(String var1) {
      this.libelleEta = var1;
   }

   public ExercicesParc getExercicesParc() {
      return this.exercicesParc;
   }

   public void setExercicesParc(ExercicesParc var1) {
      this.exercicesParc = var1;
   }

   public Parc getParc() {
      return this.parc;
   }

   public void setParc(Parc var1) {
      this.parc = var1;
   }

   public String getPrclocActivite() {
      return this.prclocActivite;
   }

   public void setPrclocActivite(String var1) {
      this.prclocActivite = var1;
   }

   public String getPrclocAnal2() {
      return this.prclocAnal2;
   }

   public void setPrclocAnal2(String var1) {
      this.prclocAnal2 = var1;
   }

   public String getPrclocAnal4() {
      return this.prclocAnal4;
   }

   public void setPrclocAnal4(String var1) {
      this.prclocAnal4 = var1;
   }

   public String getPrclocArriereDroit() {
      return this.prclocArriereDroit;
   }

   public void setPrclocArriereDroit(String var1) {
      this.prclocArriereDroit = var1;
   }

   public String getPrclocArriereGauche() {
      return this.prclocArriereGauche;
   }

   public void setPrclocArriereGauche(String var1) {
      this.prclocArriereGauche = var1;
   }

   public String getPrclocAvantDroit() {
      return this.prclocAvantDroit;
   }

   public void setPrclocAvantDroit(String var1) {
      this.prclocAvantDroit = var1;
   }

   public String getPrclocAvantGauche() {
      return this.prclocAvantGauche;
   }

   public void setPrclocAvantGauche(String var1) {
      this.prclocAvantGauche = var1;
   }

   public String getPrclocCat() {
      return this.prclocCat;
   }

   public void setPrclocCat(String var1) {
      this.prclocCat = var1;
   }

   public long getPrclocCompteur() {
      return this.prclocCompteur;
   }

   public void setPrclocCompteur(long var1) {
      this.prclocCompteur = var1;
   }

   public Date getPrclocDate() {
      return this.prclocDate;
   }

   public void setPrclocDate(Date var1) {
      this.prclocDate = var1;
   }

   public Date getPrclocDateAnnule() {
      return this.prclocDateAnnule;
   }

   public void setPrclocDateAnnule(Date var1) {
      this.prclocDateAnnule = var1;
   }

   public Date getPrclocDateCreat() {
      return this.prclocDateCreat;
   }

   public void setPrclocDateCreat(Date var1) {
      this.prclocDateCreat = var1;
   }

   public Date getPrclocDateImp() {
      return this.prclocDateImp;
   }

   public void setPrclocDateImp(Date var1) {
      this.prclocDateImp = var1;
   }

   public Date getPrclocDateModif() {
      return this.prclocDateModif;
   }

   public void setPrclocDateModif(Date var1) {
      this.prclocDateModif = var1;
   }

   public Date getPrclocDateValide() {
      return this.prclocDateValide;
   }

   public void setPrclocDateValide(Date var1) {
      this.prclocDateValide = var1;
   }

   public String getPrclocDepartement() {
      return this.prclocDepartement;
   }

   public void setPrclocDepartement(String var1) {
      this.prclocDepartement = var1;
   }

   public int getPrclocEtat() {
      return this.prclocEtat;
   }

   public void setPrclocEtat(int var1) {
      this.prclocEtat = var1;
   }

   public int getPrclocEtatVal() {
      return this.prclocEtatVal;
   }

   public void setPrclocEtatVal(int var1) {
      this.prclocEtatVal = var1;
   }

   public int getPrclocExoDouane() {
      return this.prclocExoDouane;
   }

   public void setPrclocExoDouane(int var1) {
      this.prclocExoDouane = var1;
   }

   public int getPrclocExoTva() {
      return this.prclocExoTva;
   }

   public void setPrclocExoTva(int var1) {
      this.prclocExoTva = var1;
   }

   public int getPrclocGele() {
      return this.prclocGele;
   }

   public void setPrclocGele(int var1) {
      this.prclocGele = var1;
   }

   public long getPrclocId() {
      return this.prclocId;
   }

   public void setPrclocId(long var1) {
      this.prclocId = var1;
   }

   public long getPrclocIdChauffeur() {
      return this.prclocIdChauffeur;
   }

   public void setPrclocIdChauffeur(long var1) {
      this.prclocIdChauffeur = var1;
   }

   public long getPrclocIdCommercial() {
      return this.prclocIdCommercial;
   }

   public void setPrclocIdCommercial(long var1) {
      this.prclocIdCommercial = var1;
   }

   public long getPrclocIdCreateur() {
      return this.prclocIdCreateur;
   }

   public void setPrclocIdCreateur(long var1) {
      this.prclocIdCreateur = var1;
   }

   public long getPrclocIdFin() {
      return this.prclocIdFin;
   }

   public void setPrclocIdFin(long var1) {
      this.prclocIdFin = var1;
   }

   public long getPrclocIdModif() {
      return this.prclocIdModif;
   }

   public void setPrclocIdModif(long var1) {
      this.prclocIdModif = var1;
   }

   public String getPrclocLateralDroit() {
      return this.prclocLateralDroit;
   }

   public void setPrclocLateralDroit(String var1) {
      this.prclocLateralDroit = var1;
   }

   public String getPrclocLateralGauche() {
      return this.prclocLateralGauche;
   }

   public void setPrclocLateralGauche(String var1) {
      this.prclocLateralGauche = var1;
   }

   public String getPrclocModeleImp() {
      return this.prclocModeleImp;
   }

   public void setPrclocModeleImp(String var1) {
      this.prclocModeleImp = var1;
   }

   public String getPrclocMotifAnnule() {
      return this.prclocMotifAnnule;
   }

   public void setPrclocMotifAnnule(String var1) {
      this.prclocMotifAnnule = var1;
   }

   public int getPrclocNiveauCarburant() {
      return this.prclocNiveauCarburant;
   }

   public void setPrclocNiveauCarburant(int var1) {
      this.prclocNiveauCarburant = var1;
   }

   public String getPrclocNomChauffeur() {
      return this.prclocNomChauffeur;
   }

   public void setPrclocNomChauffeur(String var1) {
      this.prclocNomChauffeur = var1;
   }

   public String getPrclocNomClient() {
      return this.prclocNomClient;
   }

   public void setPrclocNomClient(String var1) {
      this.prclocNomClient = var1;
   }

   public String getPrclocNomCommercial() {
      return this.prclocNomCommercial;
   }

   public void setPrclocNomCommercial(String var1) {
      this.prclocNomCommercial = var1;
   }

   public String getPrclocNomCreateur() {
      return this.prclocNomCreateur;
   }

   public void setPrclocNomCreateur(String var1) {
      this.prclocNomCreateur = var1;
   }

   public String getPrclocNomFin() {
      return this.prclocNomFin;
   }

   public void setPrclocNomFin(String var1) {
      this.prclocNomFin = var1;
   }

   public String getPrclocNomModif() {
      return this.prclocNomModif;
   }

   public void setPrclocNomModif(String var1) {
      this.prclocNomModif = var1;
   }

   public String getPrclocNum() {
      return this.prclocNum;
   }

   public void setPrclocNum(String var1) {
      this.prclocNum = var1;
   }

   public String getPrclocNumChassis() {
      return this.prclocNumChassis;
   }

   public void setPrclocNumChassis(String var1) {
      this.prclocNumChassis = var1;
   }

   public String getPrclocNumMoteur() {
      return this.prclocNumMoteur;
   }

   public void setPrclocNumMoteur(String var1) {
      this.prclocNumMoteur = var1;
   }

   public String getPrclocPdv() {
      return this.prclocPdv;
   }

   public void setPrclocPdv(String var1) {
      this.prclocPdv = var1;
   }

   public double getPrclocPv() {
      return this.prclocPv;
   }

   public void setPrclocPv(double var1) {
      this.prclocPv = var1;
   }

   public String getPrclocRegion() {
      return this.prclocRegion;
   }

   public void setPrclocRegion(String var1) {
      this.prclocRegion = var1;
   }

   public String getPrclocSecteur() {
      return this.prclocSecteur;
   }

   public void setPrclocSecteur(String var1) {
      this.prclocSecteur = var1;
   }

   public String getPrclocSerie() {
      return this.prclocSerie;
   }

   public void setPrclocSerie(String var1) {
      this.prclocSerie = var1;
   }

   public String getPrclocService() {
      return this.prclocService;
   }

   public void setPrclocService(String var1) {
      this.prclocService = var1;
   }

   public String getPrclocSite() {
      return this.prclocSite;
   }

   public void setPrclocSite(String var1) {
      this.prclocSite = var1;
   }

   public float getPrclocTauxTc() {
      return this.prclocTauxTc;
   }

   public void setPrclocTauxTc(float var1) {
      this.prclocTauxTc = var1;
   }

   public double getPrclocTotTc() {
      return this.prclocTotTc;
   }

   public void setPrclocTotTc(double var1) {
      this.prclocTotTc = var1;
   }

   public int getPrclocType() {
      return this.prclocType;
   }

   public void setPrclocType(int var1) {
      this.prclocType = var1;
   }

   public int getPrclocTypeCompteur() {
      return this.prclocTypeCompteur;
   }

   public void setPrclocTypeCompteur(int var1) {
      this.prclocTypeCompteur = var1;
   }

   public String getPrclocArriereDroitFin() {
      return this.prclocArriereDroitFin;
   }

   public void setPrclocArriereDroitFin(String var1) {
      this.prclocArriereDroitFin = var1;
   }

   public String getPrclocArriereGaucheFin() {
      return this.prclocArriereGaucheFin;
   }

   public void setPrclocArriereGaucheFin(String var1) {
      this.prclocArriereGaucheFin = var1;
   }

   public String getPrclocAvantDroitFin() {
      return this.prclocAvantDroitFin;
   }

   public void setPrclocAvantDroitFin(String var1) {
      this.prclocAvantDroitFin = var1;
   }

   public String getPrclocAvantGaucheFin() {
      return this.prclocAvantGaucheFin;
   }

   public void setPrclocAvantGaucheFin(String var1) {
      this.prclocAvantGaucheFin = var1;
   }

   public String getPrclocLateralDroitFin() {
      return this.prclocLateralDroitFin;
   }

   public void setPrclocLateralDroitFin(String var1) {
      this.prclocLateralDroitFin = var1;
   }

   public String getPrclocLateralGaucheFin() {
      return this.prclocLateralGaucheFin;
   }

   public void setPrclocLateralGaucheFin(String var1) {
      this.prclocLateralGaucheFin = var1;
   }

   public int getPrclocNiveauCarburantFin() {
      return this.prclocNiveauCarburantFin;
   }

   public void setPrclocNiveauCarburantFin(int var1) {
      this.prclocNiveauCarburantFin = var1;
   }

   public boolean isPrclocBoiteOutils() {
      return this.prclocBoiteOutils;
   }

   public void setPrclocBoiteOutils(boolean var1) {
      this.prclocBoiteOutils = var1;
   }

   public boolean isPrclocBoiteOutilsFin() {
      return this.prclocBoiteOutilsFin;
   }

   public void setPrclocBoiteOutilsFin(boolean var1) {
      this.prclocBoiteOutilsFin = var1;
   }

   public boolean isPrclocCrick() {
      return this.prclocCrick;
   }

   public void setPrclocCrick(boolean var1) {
      this.prclocCrick = var1;
   }

   public boolean isPrclocCrickFin() {
      return this.prclocCrickFin;
   }

   public void setPrclocCrickFin(boolean var1) {
      this.prclocCrickFin = var1;
   }

   public boolean isPrclocExtincteur() {
      return this.prclocExtincteur;
   }

   public void setPrclocExtincteur(boolean var1) {
      this.prclocExtincteur = var1;
   }

   public boolean isPrclocExtincteurFin() {
      return this.prclocExtincteurFin;
   }

   public void setPrclocExtincteurFin(boolean var1) {
      this.prclocExtincteurFin = var1;
   }

   public boolean isPrclocGilet() {
      return this.prclocGilet;
   }

   public void setPrclocGilet(boolean var1) {
      this.prclocGilet = var1;
   }

   public boolean isPrclocGiletFin() {
      return this.prclocGiletFin;
   }

   public void setPrclocGiletFin(boolean var1) {
      this.prclocGiletFin = var1;
   }

   public boolean isPrclocPapier1() {
      return this.prclocPapier1;
   }

   public void setPrclocPapier1(boolean var1) {
      this.prclocPapier1 = var1;
   }

   public boolean isPrclocPapier1Fin() {
      return this.prclocPapier1Fin;
   }

   public void setPrclocPapier1Fin(boolean var1) {
      this.prclocPapier1Fin = var1;
   }

   public boolean isPrclocPapier2() {
      return this.prclocPapier2;
   }

   public void setPrclocPapier2(boolean var1) {
      this.prclocPapier2 = var1;
   }

   public boolean isPrclocPapier2Fin() {
      return this.prclocPapier2Fin;
   }

   public void setPrclocPapier2Fin(boolean var1) {
      this.prclocPapier2Fin = var1;
   }

   public boolean isPrclocPapier3() {
      return this.prclocPapier3;
   }

   public void setPrclocPapier3(boolean var1) {
      this.prclocPapier3 = var1;
   }

   public boolean isPrclocPapier3Fin() {
      return this.prclocPapier3Fin;
   }

   public void setPrclocPapier3Fin(boolean var1) {
      this.prclocPapier3Fin = var1;
   }

   public boolean isPrclocPapier4() {
      return this.prclocPapier4;
   }

   public void setPrclocPapier4(boolean var1) {
      this.prclocPapier4 = var1;
   }

   public boolean isPrclocPapier4Fin() {
      return this.prclocPapier4Fin;
   }

   public void setPrclocPapier4Fin(boolean var1) {
      this.prclocPapier4Fin = var1;
   }

   public boolean isPrclocPapier5() {
      return this.prclocPapier5;
   }

   public void setPrclocPapier5(boolean var1) {
      this.prclocPapier5 = var1;
   }

   public boolean isPrclocPapier5Fin() {
      return this.prclocPapier5Fin;
   }

   public void setPrclocPapier5Fin(boolean var1) {
      this.prclocPapier5Fin = var1;
   }

   public boolean isPrclocPapier6() {
      return this.prclocPapier6;
   }

   public void setPrclocPapier6(boolean var1) {
      this.prclocPapier6 = var1;
   }

   public boolean isPrclocPapier6Fin() {
      return this.prclocPapier6Fin;
   }

   public void setPrclocPapier6Fin(boolean var1) {
      this.prclocPapier6Fin = var1;
   }

   public boolean isPrclocRoueSecours() {
      return this.prclocRoueSecours;
   }

   public void setPrclocRoueSecours(boolean var1) {
      this.prclocRoueSecours = var1;
   }

   public boolean isPrclocRoueSecoursFin() {
      return this.prclocRoueSecoursFin;
   }

   public void setPrclocRoueSecoursFin(boolean var1) {
      this.prclocRoueSecoursFin = var1;
   }

   public boolean isPrclocTriangle() {
      return this.prclocTriangle;
   }

   public void setPrclocTriangle(boolean var1) {
      this.prclocTriangle = var1;
   }

   public boolean isPrclocTriangleFin() {
      return this.prclocTriangleFin;
   }

   public void setPrclocTriangleFin(boolean var1) {
      this.prclocTriangleFin = var1;
   }

   public boolean isPrclocTrousseSecours() {
      return this.prclocTrousseSecours;
   }

   public void setPrclocTrousseSecours(boolean var1) {
      this.prclocTrousseSecours = var1;
   }

   public boolean isPrclocTrousseSecoursFin() {
      return this.prclocTrousseSecoursFin;
   }

   public void setPrclocTrousseSecoursFin(boolean var1) {
      this.prclocTrousseSecoursFin = var1;
   }

   public Date getPrclocDateDepart() {
      return this.prclocDateDepart;
   }

   public void setPrclocDateDepart(Date var1) {
      this.prclocDateDepart = var1;
   }

   public Date getPrclocDateRetour() {
      return this.prclocDateRetour;
   }

   public void setPrclocDateRetour(Date var1) {
      this.prclocDateRetour = var1;
   }

   public double getPrclocDuree() {
      return this.prclocDuree;
   }

   public void setPrclocDuree(double var1) {
      this.prclocDuree = var1;
   }

   public String getPrclocLieuDepart() {
      return this.prclocLieuDepart;
   }

   public void setPrclocLieuDepart(String var1) {
      this.prclocLieuDepart = var1;
   }

   public String getPrclocLieuRetour() {
      return this.prclocLieuRetour;
   }

   public void setPrclocLieuRetour(String var1) {
      this.prclocLieuRetour = var1;
   }

   public String getPrclocCivilTiers() {
      return this.prclocCivilTiers;
   }

   public void setPrclocCivilTiers(String var1) {
      this.prclocCivilTiers = var1;
   }

   public String getPrclocDevise() {
      return this.prclocDevise;
   }

   public void setPrclocDevise(String var1) {
      this.prclocDevise = var1;
   }

   public String getPrclocDiversAdresse() {
      return this.prclocDiversAdresse;
   }

   public void setPrclocDiversAdresse(String var1) {
      this.prclocDiversAdresse = var1;
   }

   public String getPrclocDiversMail() {
      return this.prclocDiversMail;
   }

   public void setPrclocDiversMail(String var1) {
      this.prclocDiversMail = var1;
   }

   public String getPrclocDiversNom() {
      return this.prclocDiversNom;
   }

   public void setPrclocDiversNom(String var1) {
      this.prclocDiversNom = var1;
   }

   public String getPrclocDiversTel() {
      return this.prclocDiversTel;
   }

   public void setPrclocDiversTel(String var1) {
      this.prclocDiversTel = var1;
   }

   public int getPrclocDiversTiers() {
      return this.prclocDiversTiers;
   }

   public void setPrclocDiversTiers(int var1) {
      this.prclocDiversTiers = var1;
   }

   public String getPrclocDiversVille() {
      return this.prclocDiversVille;
   }

   public void setPrclocDiversVille(String var1) {
      this.prclocDiversVille = var1;
   }

   public String getPrclocSource() {
      return this.prclocSource;
   }

   public void setPrclocSource(String var1) {
      this.prclocSource = var1;
   }

   public String getPrclocModeReg() {
      return this.prclocModeReg;
   }

   public void setPrclocModeReg(String var1) {
      this.prclocModeReg = var1;
   }

   public int getPrclocTypeReg() {
      return this.prclocTypeReg;
   }

   public void setPrclocTypeReg(int var1) {
      this.prclocTypeReg = var1;
   }

   public String getPrclocInterieur() {
      return this.prclocInterieur;
   }

   public void setPrclocInterieur(String var1) {
      this.prclocInterieur = var1;
   }

   public String getPrclocInterieurFin() {
      return this.prclocInterieurFin;
   }

   public void setPrclocInterieurFin(String var1) {
      this.prclocInterieurFin = var1;
   }

   public double getPrclocPu() {
      return this.prclocPu;
   }

   public void setPrclocPu(double var1) {
      this.prclocPu = var1;
   }

   public double getPrclocTotHt() {
      return this.prclocTotHt;
   }

   public void setPrclocTotHt(double var1) {
      this.prclocTotHt = var1;
   }

   public double getPrclocTotTtc() {
      return this.prclocTotTtc;
   }

   public void setPrclocTotTtc(double var1) {
      this.prclocTotTtc = var1;
   }

   public double getPrclocTotTva() {
      return this.prclocTotTva;
   }

   public void setPrclocTotTva(double var1) {
      this.prclocTotTva = var1;
   }

   public float getPrclocTauxRemise() {
      return this.prclocTauxRemise;
   }

   public void setPrclocTauxRemise(float var1) {
      this.prclocTauxRemise = var1;
   }

   public double getPrclocTotRabais() {
      return this.prclocTotRabais;
   }

   public void setPrclocTotRabais(double var1) {
      this.prclocTotRabais = var1;
   }

   public double getPrclocTotRemise() {
      return this.prclocTotRemise;
   }

   public void setPrclocTotRemise(double var1) {
      this.prclocTotRemise = var1;
   }

   public long getPrclocCompteurFin() {
      return this.prclocCompteurFin;
   }

   public void setPrclocCompteurFin(long var1) {
      this.prclocCompteurFin = var1;
   }

   public long getPrclocCompteurDistance() {
      return this.prclocCompteurDistance;
   }

   public void setPrclocCompteurDistance(long var1) {
      this.prclocCompteurDistance = var1;
   }
}
