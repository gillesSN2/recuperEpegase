package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ParcOrEntete implements Serializable {
   private long prcoreId;
   private Date prcoreDateCreat;
   private Date prcoreDateModif;
   private long prcoreIdCreateur;
   private String prcoreNomCreateur;
   private long prcoreIdModif;
   private String prcoreNomModif;
   private Date prcoreDate;
   private String prcoreNum;
   private int prcoreType;
   private String prcoreNomReceptionnaire;
   private long prcoreIdReceptionnaire;
   private String prcoreNomChauffeur;
   private long prcoreIdChauffeur;
   private String prcoreNomClient;
   private int prcoreExoTva;
   private int prcoreExoDouane;
   private String prcoreCat;
   private String prcoreSerie;
   private String prcoreActivite;
   private String prcoreSite;
   private String prcoreDepartement;
   private String prcoreService;
   private String prcoreRegion;
   private String prcoreSecteur;
   private String prcorePdv;
   private String prcoreAnal2;
   private String prcoreAnal4;
   private Date prcoreDateImp;
   private String prcoreModeleImp;
   private int prcoreEtatVal;
   private int prcoreGele;
   private int prcoreEtat;
   private Date prcoreDateValide;
   private Date prcoreDateAnnule;
   private String prcoreMotifAnnule;
   private long prcoreCompteur;
   private int prcoreTypeCompteur;
   private String prcoreMotifEntree1;
   private String prcoreMotifEntree2;
   private String prcoreResumeEntree;
   private String prcoreAvantGauche;
   private String prcoreAvantDroit;
   private String prcoreArriereGauche;
   private String prcoreArriereDroit;
   private String prcoreLateralGauche;
   private String prcoreLateralDroit;
   private int prcoreNiveauCarburant;
   private String prcoreNumChassis;
   private String prcoreNumMoteur;
   private String prcoreNumSrie;
   private String prcoreNomFin;
   private long prcoreIdFin;
   private double prcoreCoutMo;
   private double prcoreCoutPiece;
   private double prcorePvMo;
   private double prcorePvPiece;
   private float prcoreTauxTc;
   private double prcoreTotTc;
   private String prcoreControle;
   private String prcoreAFaire;
   private String prcoreAPrevoir;
   private Date prcoreDateProchaine;
   private boolean prcoreRoueSecours;
   private boolean prcoreCrick;
   private boolean prcoreExtincteur;
   private boolean prcoreTrousseSecours;
   private boolean prcoreGilet;
   private boolean prcoreTriangle;
   private boolean prcoreBoiteOutils;
   private boolean prcorePapier1;
   private boolean prcorePapier2;
   private boolean prcorePapier3;
   private boolean prcorePapier4;
   private boolean prcorePapier5;
   private boolean prcorePapier6;
   private boolean prcoreRoueSecoursFin;
   private boolean prcoreCrickFin;
   private boolean prcoreExtincteurFin;
   private boolean prcoreTrousseSecoursFin;
   private boolean prcoreGiletFin;
   private boolean prcoreTriangleFin;
   private boolean prcoreBoiteOutilsFin;
   private boolean prcorePapier1Fin;
   private boolean prcorePapier2Fin;
   private boolean prcorePapier3Fin;
   private boolean prcorePapier4Fin;
   private boolean prcorePapier5Fin;
   private boolean prcorePapier6Fin;
   private int prcoreTransmisDevis;
   private int prcoreReponseClient;
   private String prcoreObservationClient;
   private int prcoreExecution;
   private String prcoreObservationChef;
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
      if (this.prcoreEtat == 0) {
         this.libelleEta = "E.C.";
      } else if (this.prcoreEtat == 1) {
         this.libelleEta = "Val.";
      } else if (this.prcoreEtat == 2) {
         this.libelleEta = "Gel.";
      } else if (this.prcoreEtat == 3) {
         this.libelleEta = "Annul.";
      } else if (this.prcoreEtat == 4) {
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

   public String getPrcoreAFaire() {
      return this.prcoreAFaire;
   }

   public void setPrcoreAFaire(String var1) {
      this.prcoreAFaire = var1;
   }

   public String getPrcoreAPrevoir() {
      return this.prcoreAPrevoir;
   }

   public void setPrcoreAPrevoir(String var1) {
      this.prcoreAPrevoir = var1;
   }

   public String getPrcoreActivite() {
      return this.prcoreActivite;
   }

   public void setPrcoreActivite(String var1) {
      this.prcoreActivite = var1;
   }

   public String getPrcoreAnal2() {
      return this.prcoreAnal2;
   }

   public void setPrcoreAnal2(String var1) {
      this.prcoreAnal2 = var1;
   }

   public String getPrcoreAnal4() {
      return this.prcoreAnal4;
   }

   public void setPrcoreAnal4(String var1) {
      this.prcoreAnal4 = var1;
   }

   public String getPrcoreArriereDroit() {
      return this.prcoreArriereDroit;
   }

   public void setPrcoreArriereDroit(String var1) {
      this.prcoreArriereDroit = var1;
   }

   public String getPrcoreArriereGauche() {
      return this.prcoreArriereGauche;
   }

   public void setPrcoreArriereGauche(String var1) {
      this.prcoreArriereGauche = var1;
   }

   public String getPrcoreAvantDroit() {
      return this.prcoreAvantDroit;
   }

   public void setPrcoreAvantDroit(String var1) {
      this.prcoreAvantDroit = var1;
   }

   public String getPrcoreAvantGauche() {
      return this.prcoreAvantGauche;
   }

   public void setPrcoreAvantGauche(String var1) {
      this.prcoreAvantGauche = var1;
   }

   public long getPrcoreCompteur() {
      return this.prcoreCompteur;
   }

   public void setPrcoreCompteur(long var1) {
      this.prcoreCompteur = var1;
   }

   public String getPrcoreControle() {
      return this.prcoreControle;
   }

   public void setPrcoreControle(String var1) {
      this.prcoreControle = var1;
   }

   public double getPrcoreCoutMo() {
      return this.prcoreCoutMo;
   }

   public void setPrcoreCoutMo(double var1) {
      this.prcoreCoutMo = var1;
   }

   public double getPrcoreCoutPiece() {
      return this.prcoreCoutPiece;
   }

   public void setPrcoreCoutPiece(double var1) {
      this.prcoreCoutPiece = var1;
   }

   public Date getPrcoreDate() {
      return this.prcoreDate;
   }

   public void setPrcoreDate(Date var1) {
      this.prcoreDate = var1;
   }

   public Date getPrcoreDateAnnule() {
      return this.prcoreDateAnnule;
   }

   public void setPrcoreDateAnnule(Date var1) {
      this.prcoreDateAnnule = var1;
   }

   public Date getPrcoreDateCreat() {
      return this.prcoreDateCreat;
   }

   public void setPrcoreDateCreat(Date var1) {
      this.prcoreDateCreat = var1;
   }

   public Date getPrcoreDateImp() {
      return this.prcoreDateImp;
   }

   public void setPrcoreDateImp(Date var1) {
      this.prcoreDateImp = var1;
   }

   public Date getPrcoreDateModif() {
      return this.prcoreDateModif;
   }

   public void setPrcoreDateModif(Date var1) {
      this.prcoreDateModif = var1;
   }

   public Date getPrcoreDateProchaine() {
      return this.prcoreDateProchaine;
   }

   public void setPrcoreDateProchaine(Date var1) {
      this.prcoreDateProchaine = var1;
   }

   public Date getPrcoreDateValide() {
      return this.prcoreDateValide;
   }

   public void setPrcoreDateValide(Date var1) {
      this.prcoreDateValide = var1;
   }

   public String getPrcoreDepartement() {
      return this.prcoreDepartement;
   }

   public void setPrcoreDepartement(String var1) {
      this.prcoreDepartement = var1;
   }

   public int getPrcoreEtat() {
      return this.prcoreEtat;
   }

   public void setPrcoreEtat(int var1) {
      this.prcoreEtat = var1;
   }

   public int getPrcoreEtatVal() {
      return this.prcoreEtatVal;
   }

   public void setPrcoreEtatVal(int var1) {
      this.prcoreEtatVal = var1;
   }

   public int getPrcoreGele() {
      return this.prcoreGele;
   }

   public void setPrcoreGele(int var1) {
      this.prcoreGele = var1;
   }

   public long getPrcoreId() {
      return this.prcoreId;
   }

   public void setPrcoreId(long var1) {
      this.prcoreId = var1;
   }

   public long getPrcoreIdChauffeur() {
      return this.prcoreIdChauffeur;
   }

   public void setPrcoreIdChauffeur(long var1) {
      this.prcoreIdChauffeur = var1;
   }

   public long getPrcoreIdCreateur() {
      return this.prcoreIdCreateur;
   }

   public void setPrcoreIdCreateur(long var1) {
      this.prcoreIdCreateur = var1;
   }

   public long getPrcoreIdFin() {
      return this.prcoreIdFin;
   }

   public void setPrcoreIdFin(long var1) {
      this.prcoreIdFin = var1;
   }

   public long getPrcoreIdModif() {
      return this.prcoreIdModif;
   }

   public void setPrcoreIdModif(long var1) {
      this.prcoreIdModif = var1;
   }

   public long getPrcoreIdReceptionnaire() {
      return this.prcoreIdReceptionnaire;
   }

   public void setPrcoreIdReceptionnaire(long var1) {
      this.prcoreIdReceptionnaire = var1;
   }

   public String getPrcoreLateralDroit() {
      return this.prcoreLateralDroit;
   }

   public void setPrcoreLateralDroit(String var1) {
      this.prcoreLateralDroit = var1;
   }

   public String getPrcoreLateralGauche() {
      return this.prcoreLateralGauche;
   }

   public void setPrcoreLateralGauche(String var1) {
      this.prcoreLateralGauche = var1;
   }

   public String getPrcoreModeleImp() {
      return this.prcoreModeleImp;
   }

   public void setPrcoreModeleImp(String var1) {
      this.prcoreModeleImp = var1;
   }

   public String getPrcoreMotifAnnule() {
      return this.prcoreMotifAnnule;
   }

   public void setPrcoreMotifAnnule(String var1) {
      this.prcoreMotifAnnule = var1;
   }

   public String getPrcoreMotifEntree1() {
      return this.prcoreMotifEntree1;
   }

   public void setPrcoreMotifEntree1(String var1) {
      this.prcoreMotifEntree1 = var1;
   }

   public String getPrcoreMotifEntree2() {
      return this.prcoreMotifEntree2;
   }

   public void setPrcoreMotifEntree2(String var1) {
      this.prcoreMotifEntree2 = var1;
   }

   public int getPrcoreNiveauCarburant() {
      return this.prcoreNiveauCarburant;
   }

   public void setPrcoreNiveauCarburant(int var1) {
      this.prcoreNiveauCarburant = var1;
   }

   public String getPrcoreNomChauffeur() {
      return this.prcoreNomChauffeur;
   }

   public void setPrcoreNomChauffeur(String var1) {
      this.prcoreNomChauffeur = var1;
   }

   public String getPrcoreNomCreateur() {
      return this.prcoreNomCreateur;
   }

   public void setPrcoreNomCreateur(String var1) {
      this.prcoreNomCreateur = var1;
   }

   public String getPrcoreNomFin() {
      return this.prcoreNomFin;
   }

   public void setPrcoreNomFin(String var1) {
      this.prcoreNomFin = var1;
   }

   public String getPrcoreNomModif() {
      return this.prcoreNomModif;
   }

   public void setPrcoreNomModif(String var1) {
      this.prcoreNomModif = var1;
   }

   public String getPrcoreNomReceptionnaire() {
      return this.prcoreNomReceptionnaire;
   }

   public void setPrcoreNomReceptionnaire(String var1) {
      this.prcoreNomReceptionnaire = var1;
   }

   public String getPrcoreNum() {
      return this.prcoreNum;
   }

   public void setPrcoreNum(String var1) {
      this.prcoreNum = var1;
   }

   public String getPrcoreNumChassis() {
      return this.prcoreNumChassis;
   }

   public void setPrcoreNumChassis(String var1) {
      this.prcoreNumChassis = var1;
   }

   public String getPrcoreNumMoteur() {
      return this.prcoreNumMoteur;
   }

   public void setPrcoreNumMoteur(String var1) {
      this.prcoreNumMoteur = var1;
   }

   public String getPrcoreNumSrie() {
      return this.prcoreNumSrie;
   }

   public void setPrcoreNumSrie(String var1) {
      this.prcoreNumSrie = var1;
   }

   public String getPrcorePdv() {
      return this.prcorePdv;
   }

   public void setPrcorePdv(String var1) {
      this.prcorePdv = var1;
   }

   public double getPrcorePvMo() {
      return this.prcorePvMo;
   }

   public void setPrcorePvMo(double var1) {
      this.prcorePvMo = var1;
   }

   public double getPrcorePvPiece() {
      return this.prcorePvPiece;
   }

   public void setPrcorePvPiece(double var1) {
      this.prcorePvPiece = var1;
   }

   public String getPrcoreRegion() {
      return this.prcoreRegion;
   }

   public void setPrcoreRegion(String var1) {
      this.prcoreRegion = var1;
   }

   public String getPrcoreResumeEntree() {
      return this.prcoreResumeEntree;
   }

   public void setPrcoreResumeEntree(String var1) {
      this.prcoreResumeEntree = var1;
   }

   public String getPrcoreSecteur() {
      return this.prcoreSecteur;
   }

   public void setPrcoreSecteur(String var1) {
      this.prcoreSecteur = var1;
   }

   public String getPrcoreSerie() {
      return this.prcoreSerie;
   }

   public void setPrcoreSerie(String var1) {
      this.prcoreSerie = var1;
   }

   public String getPrcoreService() {
      return this.prcoreService;
   }

   public void setPrcoreService(String var1) {
      this.prcoreService = var1;
   }

   public String getPrcoreSite() {
      return this.prcoreSite;
   }

   public void setPrcoreSite(String var1) {
      this.prcoreSite = var1;
   }

   public int getPrcoreType() {
      return this.prcoreType;
   }

   public void setPrcoreType(int var1) {
      this.prcoreType = var1;
   }

   public int getPrcoreTypeCompteur() {
      return this.prcoreTypeCompteur;
   }

   public void setPrcoreTypeCompteur(int var1) {
      this.prcoreTypeCompteur = var1;
   }

   public int getPrcoreExoDouane() {
      return this.prcoreExoDouane;
   }

   public void setPrcoreExoDouane(int var1) {
      this.prcoreExoDouane = var1;
   }

   public int getPrcoreExoTva() {
      return this.prcoreExoTva;
   }

   public void setPrcoreExoTva(int var1) {
      this.prcoreExoTva = var1;
   }

   public String getPrcoreCat() {
      return this.prcoreCat;
   }

   public void setPrcoreCat(String var1) {
      this.prcoreCat = var1;
   }

   public float getPrcoreTauxTc() {
      return this.prcoreTauxTc;
   }

   public void setPrcoreTauxTc(float var1) {
      this.prcoreTauxTc = var1;
   }

   public double getPrcoreTotTc() {
      return this.prcoreTotTc;
   }

   public void setPrcoreTotTc(double var1) {
      this.prcoreTotTc = var1;
   }

   public String getPrcoreNomClient() {
      return this.prcoreNomClient;
   }

   public void setPrcoreNomClient(String var1) {
      this.prcoreNomClient = var1;
   }

   public boolean isPrcoreBoiteOutils() {
      return this.prcoreBoiteOutils;
   }

   public void setPrcoreBoiteOutils(boolean var1) {
      this.prcoreBoiteOutils = var1;
   }

   public boolean isPrcoreBoiteOutilsFin() {
      return this.prcoreBoiteOutilsFin;
   }

   public void setPrcoreBoiteOutilsFin(boolean var1) {
      this.prcoreBoiteOutilsFin = var1;
   }

   public boolean isPrcoreCrick() {
      return this.prcoreCrick;
   }

   public void setPrcoreCrick(boolean var1) {
      this.prcoreCrick = var1;
   }

   public boolean isPrcoreCrickFin() {
      return this.prcoreCrickFin;
   }

   public void setPrcoreCrickFin(boolean var1) {
      this.prcoreCrickFin = var1;
   }

   public boolean isPrcoreExtincteur() {
      return this.prcoreExtincteur;
   }

   public void setPrcoreExtincteur(boolean var1) {
      this.prcoreExtincteur = var1;
   }

   public boolean isPrcoreExtincteurFin() {
      return this.prcoreExtincteurFin;
   }

   public void setPrcoreExtincteurFin(boolean var1) {
      this.prcoreExtincteurFin = var1;
   }

   public boolean isPrcoreGilet() {
      return this.prcoreGilet;
   }

   public void setPrcoreGilet(boolean var1) {
      this.prcoreGilet = var1;
   }

   public boolean isPrcoreGiletFin() {
      return this.prcoreGiletFin;
   }

   public void setPrcoreGiletFin(boolean var1) {
      this.prcoreGiletFin = var1;
   }

   public boolean isPrcorePapier1() {
      return this.prcorePapier1;
   }

   public void setPrcorePapier1(boolean var1) {
      this.prcorePapier1 = var1;
   }

   public boolean isPrcorePapier1Fin() {
      return this.prcorePapier1Fin;
   }

   public void setPrcorePapier1Fin(boolean var1) {
      this.prcorePapier1Fin = var1;
   }

   public boolean isPrcorePapier2() {
      return this.prcorePapier2;
   }

   public void setPrcorePapier2(boolean var1) {
      this.prcorePapier2 = var1;
   }

   public boolean isPrcorePapier2Fin() {
      return this.prcorePapier2Fin;
   }

   public void setPrcorePapier2Fin(boolean var1) {
      this.prcorePapier2Fin = var1;
   }

   public boolean isPrcorePapier3() {
      return this.prcorePapier3;
   }

   public void setPrcorePapier3(boolean var1) {
      this.prcorePapier3 = var1;
   }

   public boolean isPrcorePapier3Fin() {
      return this.prcorePapier3Fin;
   }

   public void setPrcorePapier3Fin(boolean var1) {
      this.prcorePapier3Fin = var1;
   }

   public boolean isPrcorePapier4() {
      return this.prcorePapier4;
   }

   public void setPrcorePapier4(boolean var1) {
      this.prcorePapier4 = var1;
   }

   public boolean isPrcorePapier4Fin() {
      return this.prcorePapier4Fin;
   }

   public void setPrcorePapier4Fin(boolean var1) {
      this.prcorePapier4Fin = var1;
   }

   public boolean isPrcorePapier5() {
      return this.prcorePapier5;
   }

   public void setPrcorePapier5(boolean var1) {
      this.prcorePapier5 = var1;
   }

   public boolean isPrcorePapier5Fin() {
      return this.prcorePapier5Fin;
   }

   public void setPrcorePapier5Fin(boolean var1) {
      this.prcorePapier5Fin = var1;
   }

   public boolean isPrcorePapier6() {
      return this.prcorePapier6;
   }

   public void setPrcorePapier6(boolean var1) {
      this.prcorePapier6 = var1;
   }

   public boolean isPrcorePapier6Fin() {
      return this.prcorePapier6Fin;
   }

   public void setPrcorePapier6Fin(boolean var1) {
      this.prcorePapier6Fin = var1;
   }

   public boolean isPrcoreRoueSecours() {
      return this.prcoreRoueSecours;
   }

   public void setPrcoreRoueSecours(boolean var1) {
      this.prcoreRoueSecours = var1;
   }

   public boolean isPrcoreRoueSecoursFin() {
      return this.prcoreRoueSecoursFin;
   }

   public void setPrcoreRoueSecoursFin(boolean var1) {
      this.prcoreRoueSecoursFin = var1;
   }

   public boolean isPrcoreTriangle() {
      return this.prcoreTriangle;
   }

   public void setPrcoreTriangle(boolean var1) {
      this.prcoreTriangle = var1;
   }

   public boolean isPrcoreTriangleFin() {
      return this.prcoreTriangleFin;
   }

   public void setPrcoreTriangleFin(boolean var1) {
      this.prcoreTriangleFin = var1;
   }

   public boolean isPrcoreTrousseSecours() {
      return this.prcoreTrousseSecours;
   }

   public void setPrcoreTrousseSecours(boolean var1) {
      this.prcoreTrousseSecours = var1;
   }

   public boolean isPrcoreTrousseSecoursFin() {
      return this.prcoreTrousseSecoursFin;
   }

   public void setPrcoreTrousseSecoursFin(boolean var1) {
      this.prcoreTrousseSecoursFin = var1;
   }

   public String getPrcoreObservationClient() {
      return this.prcoreObservationClient;
   }

   public void setPrcoreObservationClient(String var1) {
      this.prcoreObservationClient = var1;
   }

   public int getPrcoreReponseClient() {
      return this.prcoreReponseClient;
   }

   public void setPrcoreReponseClient(int var1) {
      this.prcoreReponseClient = var1;
   }

   public int getPrcoreTransmisDevis() {
      return this.prcoreTransmisDevis;
   }

   public void setPrcoreTransmisDevis(int var1) {
      this.prcoreTransmisDevis = var1;
   }

   public String getPrcoreObservationChef() {
      return this.prcoreObservationChef;
   }

   public void setPrcoreObservationChef(String var1) {
      this.prcoreObservationChef = var1;
   }

   public int getPrcoreExecution() {
      return this.prcoreExecution;
   }

   public void setPrcoreExecution(int var1) {
      this.prcoreExecution = var1;
   }
}
