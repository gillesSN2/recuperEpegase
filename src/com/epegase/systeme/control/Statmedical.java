package com.epegase.systeme.control;

import java.io.Serializable;

public class Statmedical implements Serializable {
   private int nbFemme;
   private int nbHomme;
   private int nbEmbauche;
   private int nbTemporaire;
   private int nbPrestataire;
   private int nbStagiaire;
   private int nbSyndicat;
   private int nbComite;
   private int nbAutre;
   private int nbEmbaucheF;
   private int nbTemporaireF;
   private int nbPrestataireF;
   private int nbStagiaireF;
   private int nbSyndicatF;
   private int nbComiteF;
   private int nbAutreF;
   private int nbEmbaucheH;
   private int nbTemporaireH;
   private int nbPrestataireH;
   private int nbStagiaireH;
   private int nbSyndicatH;
   private int nbComiteH;
   private int nbAutreH;
   private int nbMaladie;
   private int nbVme;
   private int nbVma;
   private int nbAt;
   private int nbVaccination;
   private int nbDeparasitage;
   private int nbAudiometrie;
   private int nbTubertest;
   private int nbSuiteat;
   private int nbResulVme;
   private int nbResulVma;
   private int nbActes;
   private int nbProtocoles;
   private int nbMaladieF;
   private int nbVmeF;
   private int nbVmaF;
   private int nbAtF;
   private int nbVaccinationF;
   private int nbDeparasitageF;
   private int nbAudiometrieF;
   private int nbTubertestF;
   private int nbSuiteatF;
   private int nbResulVmeF;
   private int nbResulVmaF;
   private int nbActesF;
   private int nbProtocolesF;
   private int nbMaladieH;
   private int nbVmeH;
   private int nbVmaH;
   private int nbAtH;
   private int nbVaccinationH;
   private int nbDeparasitageH;
   private int nbAudiometrieH;
   private int nbTubertestH;
   private int nbSuiteatH;
   private int nbResulVmeH;
   private int nbResulVmaH;
   private int nbActesH;
   private int nbProtocolesH;
   private int nbATEmbauche;
   private int nbATTemporaire;
   private int nbATPrestataire;
   private int nbATStagiaire;
   private int nbATSyndicat;
   private int nbATComite;
   private int nbATAutre;
   private int nbATEmbaucheF;
   private int nbATTemporaireF;
   private int nbATPrestataireF;
   private int nbATStagiaireF;
   private int nbATSyndicatF;
   private int nbATComiteF;
   private int nbATAutreF;
   private int nbATEmbaucheH;
   private int nbATTemporaireH;
   private int nbATPrestataireH;
   private int nbATStagiaireH;
   private int nbATSyndicatH;
   private int nbATComiteH;
   private int nbATAutreH;
   private int nbJoursArretEmb;
   private int nbJoursArretTmp;
   private int nbJoursArretPrestataire;
   private int nbJoursArretStagiaire;
   private int nbJoursArretSyndicat;
   private int nbJoursArretComite;
   private int nbJoursArretAutre;
   private int chapitre;
   private int type;
   private String libelle;
   private String depot;
   private String site;
   private String medecin;
   private String rapport;

   public int getNbAt() {
      return this.nbAt;
   }

   public void setNbAt(int var1) {
      this.nbAt = var1;
   }

   public int getNbAudiometrie() {
      return this.nbAudiometrie;
   }

   public void setNbAudiometrie(int var1) {
      this.nbAudiometrie = var1;
   }

   public int getNbEmbauche() {
      return this.nbEmbauche;
   }

   public void setNbEmbauche(int var1) {
      this.nbEmbauche = var1;
   }

   public int getNbMaladie() {
      return this.nbMaladie;
   }

   public void setNbMaladie(int var1) {
      this.nbMaladie = var1;
   }

   public int getNbTemporaire() {
      return this.nbTemporaire;
   }

   public void setNbTemporaire(int var1) {
      this.nbTemporaire = var1;
   }

   public int getNbTubertest() {
      return this.nbTubertest;
   }

   public void setNbTubertest(int var1) {
      this.nbTubertest = var1;
   }

   public int getNbVaccination() {
      return this.nbVaccination;
   }

   public void setNbVaccination(int var1) {
      this.nbVaccination = var1;
   }

   public int getNbVma() {
      return this.nbVma;
   }

   public void setNbVma(int var1) {
      this.nbVma = var1;
   }

   public int getNbVme() {
      return this.nbVme;
   }

   public void setNbVme(int var1) {
      this.nbVme = var1;
   }

   public int getType() {
      return this.type;
   }

   public void setType(int var1) {
      this.type = var1;
   }

   public String getLibelle() {
      return this.libelle;
   }

   public void setLibelle(String var1) {
      this.libelle = var1;
   }

   public String getDepot() {
      return this.depot;
   }

   public void setDepot(String var1) {
      this.depot = var1;
   }

   public int getNbActes() {
      return this.nbActes;
   }

   public void setNbActes(int var1) {
      this.nbActes = var1;
   }

   public int getNbJoursArretEmb() {
      return this.nbJoursArretEmb;
   }

   public void setNbJoursArretEmb(int var1) {
      this.nbJoursArretEmb = var1;
   }

   public int getNbJoursArretTmp() {
      return this.nbJoursArretTmp;
   }

   public void setNbJoursArretTmp(int var1) {
      this.nbJoursArretTmp = var1;
   }

   public int getNbAutre() {
      return this.nbAutre;
   }

   public void setNbAutre(int var1) {
      this.nbAutre = var1;
   }

   public int getNbComite() {
      return this.nbComite;
   }

   public void setNbComite(int var1) {
      this.nbComite = var1;
   }

   public int getNbJoursArretAutre() {
      return this.nbJoursArretAutre;
   }

   public void setNbJoursArretAutre(int var1) {
      this.nbJoursArretAutre = var1;
   }

   public int getNbJoursArretComite() {
      return this.nbJoursArretComite;
   }

   public void setNbJoursArretComite(int var1) {
      this.nbJoursArretComite = var1;
   }

   public int getNbJoursArretPrestataire() {
      return this.nbJoursArretPrestataire;
   }

   public void setNbJoursArretPrestataire(int var1) {
      this.nbJoursArretPrestataire = var1;
   }

   public int getNbJoursArretStagiaire() {
      return this.nbJoursArretStagiaire;
   }

   public void setNbJoursArretStagiaire(int var1) {
      this.nbJoursArretStagiaire = var1;
   }

   public int getNbJoursArretSyndicat() {
      return this.nbJoursArretSyndicat;
   }

   public void setNbJoursArretSyndicat(int var1) {
      this.nbJoursArretSyndicat = var1;
   }

   public int getNbPrestataire() {
      return this.nbPrestataire;
   }

   public void setNbPrestataire(int var1) {
      this.nbPrestataire = var1;
   }

   public int getNbStagiaire() {
      return this.nbStagiaire;
   }

   public void setNbStagiaire(int var1) {
      this.nbStagiaire = var1;
   }

   public int getNbSyndicat() {
      return this.nbSyndicat;
   }

   public void setNbSyndicat(int var1) {
      this.nbSyndicat = var1;
   }

   public int getNbResulVma() {
      return this.nbResulVma;
   }

   public void setNbResulVma(int var1) {
      this.nbResulVma = var1;
   }

   public int getNbResulVme() {
      return this.nbResulVme;
   }

   public void setNbResulVme(int var1) {
      this.nbResulVme = var1;
   }

   public int getNbSuiteat() {
      return this.nbSuiteat;
   }

   public void setNbSuiteat(int var1) {
      this.nbSuiteat = var1;
   }

   public String getRapport() {
      return this.rapport;
   }

   public void setRapport(String var1) {
      this.rapport = var1;
   }

   public String getSite() {
      return this.site;
   }

   public void setSite(String var1) {
      this.site = var1;
   }

   public int getNbAutreF() {
      return this.nbAutreF;
   }

   public void setNbAutreF(int var1) {
      this.nbAutreF = var1;
   }

   public int getNbAutreH() {
      return this.nbAutreH;
   }

   public void setNbAutreH(int var1) {
      this.nbAutreH = var1;
   }

   public int getNbComiteF() {
      return this.nbComiteF;
   }

   public void setNbComiteF(int var1) {
      this.nbComiteF = var1;
   }

   public int getNbComiteH() {
      return this.nbComiteH;
   }

   public void setNbComiteH(int var1) {
      this.nbComiteH = var1;
   }

   public int getNbEmbaucheF() {
      return this.nbEmbaucheF;
   }

   public void setNbEmbaucheF(int var1) {
      this.nbEmbaucheF = var1;
   }

   public int getNbEmbaucheH() {
      return this.nbEmbaucheH;
   }

   public void setNbEmbaucheH(int var1) {
      this.nbEmbaucheH = var1;
   }

   public int getNbPrestataireF() {
      return this.nbPrestataireF;
   }

   public void setNbPrestataireF(int var1) {
      this.nbPrestataireF = var1;
   }

   public int getNbPrestataireH() {
      return this.nbPrestataireH;
   }

   public void setNbPrestataireH(int var1) {
      this.nbPrestataireH = var1;
   }

   public int getNbStagiaireF() {
      return this.nbStagiaireF;
   }

   public void setNbStagiaireF(int var1) {
      this.nbStagiaireF = var1;
   }

   public int getNbStagiaireH() {
      return this.nbStagiaireH;
   }

   public void setNbStagiaireH(int var1) {
      this.nbStagiaireH = var1;
   }

   public int getNbSyndicatF() {
      return this.nbSyndicatF;
   }

   public void setNbSyndicatF(int var1) {
      this.nbSyndicatF = var1;
   }

   public int getNbSyndicatH() {
      return this.nbSyndicatH;
   }

   public void setNbSyndicatH(int var1) {
      this.nbSyndicatH = var1;
   }

   public int getNbTemporaireF() {
      return this.nbTemporaireF;
   }

   public void setNbTemporaireF(int var1) {
      this.nbTemporaireF = var1;
   }

   public int getNbTemporaireH() {
      return this.nbTemporaireH;
   }

   public void setNbTemporaireH(int var1) {
      this.nbTemporaireH = var1;
   }

   public int getNbProtocoles() {
      return this.nbProtocoles;
   }

   public void setNbProtocoles(int var1) {
      this.nbProtocoles = var1;
   }

   public String getMedecin() {
      return this.medecin;
   }

   public void setMedecin(String var1) {
      this.medecin = var1;
   }

   public int getChapitre() {
      return this.chapitre;
   }

   public void setChapitre(int var1) {
      this.chapitre = var1;
   }

   public int getNbActesF() {
      return this.nbActesF;
   }

   public void setNbActesF(int var1) {
      this.nbActesF = var1;
   }

   public int getNbActesH() {
      return this.nbActesH;
   }

   public void setNbActesH(int var1) {
      this.nbActesH = var1;
   }

   public int getNbAtF() {
      return this.nbAtF;
   }

   public void setNbAtF(int var1) {
      this.nbAtF = var1;
   }

   public int getNbAtH() {
      return this.nbAtH;
   }

   public void setNbAtH(int var1) {
      this.nbAtH = var1;
   }

   public int getNbAudiometrieF() {
      return this.nbAudiometrieF;
   }

   public void setNbAudiometrieF(int var1) {
      this.nbAudiometrieF = var1;
   }

   public int getNbAudiometrieH() {
      return this.nbAudiometrieH;
   }

   public void setNbAudiometrieH(int var1) {
      this.nbAudiometrieH = var1;
   }

   public int getNbMaladieF() {
      return this.nbMaladieF;
   }

   public void setNbMaladieF(int var1) {
      this.nbMaladieF = var1;
   }

   public int getNbMaladieH() {
      return this.nbMaladieH;
   }

   public void setNbMaladieH(int var1) {
      this.nbMaladieH = var1;
   }

   public int getNbProtocolesF() {
      return this.nbProtocolesF;
   }

   public void setNbProtocolesF(int var1) {
      this.nbProtocolesF = var1;
   }

   public int getNbProtocolesH() {
      return this.nbProtocolesH;
   }

   public void setNbProtocolesH(int var1) {
      this.nbProtocolesH = var1;
   }

   public int getNbResulVmaF() {
      return this.nbResulVmaF;
   }

   public void setNbResulVmaF(int var1) {
      this.nbResulVmaF = var1;
   }

   public int getNbResulVmaH() {
      return this.nbResulVmaH;
   }

   public void setNbResulVmaH(int var1) {
      this.nbResulVmaH = var1;
   }

   public int getNbResulVmeF() {
      return this.nbResulVmeF;
   }

   public void setNbResulVmeF(int var1) {
      this.nbResulVmeF = var1;
   }

   public int getNbResulVmeH() {
      return this.nbResulVmeH;
   }

   public void setNbResulVmeH(int var1) {
      this.nbResulVmeH = var1;
   }

   public int getNbSuiteatF() {
      return this.nbSuiteatF;
   }

   public void setNbSuiteatF(int var1) {
      this.nbSuiteatF = var1;
   }

   public int getNbSuiteatH() {
      return this.nbSuiteatH;
   }

   public void setNbSuiteatH(int var1) {
      this.nbSuiteatH = var1;
   }

   public int getNbTubertestF() {
      return this.nbTubertestF;
   }

   public void setNbTubertestF(int var1) {
      this.nbTubertestF = var1;
   }

   public int getNbTubertestH() {
      return this.nbTubertestH;
   }

   public void setNbTubertestH(int var1) {
      this.nbTubertestH = var1;
   }

   public int getNbVaccinationF() {
      return this.nbVaccinationF;
   }

   public void setNbVaccinationF(int var1) {
      this.nbVaccinationF = var1;
   }

   public int getNbVaccinationH() {
      return this.nbVaccinationH;
   }

   public void setNbVaccinationH(int var1) {
      this.nbVaccinationH = var1;
   }

   public int getNbVmaF() {
      return this.nbVmaF;
   }

   public void setNbVmaF(int var1) {
      this.nbVmaF = var1;
   }

   public int getNbVmaH() {
      return this.nbVmaH;
   }

   public void setNbVmaH(int var1) {
      this.nbVmaH = var1;
   }

   public int getNbVmeF() {
      return this.nbVmeF;
   }

   public void setNbVmeF(int var1) {
      this.nbVmeF = var1;
   }

   public int getNbVmeH() {
      return this.nbVmeH;
   }

   public void setNbVmeH(int var1) {
      this.nbVmeH = var1;
   }

   public int getNbATAutre() {
      return this.nbATAutre;
   }

   public void setNbATAutre(int var1) {
      this.nbATAutre = var1;
   }

   public int getNbATAutreF() {
      return this.nbATAutreF;
   }

   public void setNbATAutreF(int var1) {
      this.nbATAutreF = var1;
   }

   public int getNbATAutreH() {
      return this.nbATAutreH;
   }

   public void setNbATAutreH(int var1) {
      this.nbATAutreH = var1;
   }

   public int getNbATComite() {
      return this.nbATComite;
   }

   public void setNbATComite(int var1) {
      this.nbATComite = var1;
   }

   public int getNbATComiteF() {
      return this.nbATComiteF;
   }

   public void setNbATComiteF(int var1) {
      this.nbATComiteF = var1;
   }

   public int getNbATComiteH() {
      return this.nbATComiteH;
   }

   public void setNbATComiteH(int var1) {
      this.nbATComiteH = var1;
   }

   public int getNbATEmbauche() {
      return this.nbATEmbauche;
   }

   public void setNbATEmbauche(int var1) {
      this.nbATEmbauche = var1;
   }

   public int getNbATEmbaucheF() {
      return this.nbATEmbaucheF;
   }

   public void setNbATEmbaucheF(int var1) {
      this.nbATEmbaucheF = var1;
   }

   public int getNbATEmbaucheH() {
      return this.nbATEmbaucheH;
   }

   public void setNbATEmbaucheH(int var1) {
      this.nbATEmbaucheH = var1;
   }

   public int getNbATPrestataire() {
      return this.nbATPrestataire;
   }

   public void setNbATPrestataire(int var1) {
      this.nbATPrestataire = var1;
   }

   public int getNbATPrestataireF() {
      return this.nbATPrestataireF;
   }

   public void setNbATPrestataireF(int var1) {
      this.nbATPrestataireF = var1;
   }

   public int getNbATPrestataireH() {
      return this.nbATPrestataireH;
   }

   public void setNbATPrestataireH(int var1) {
      this.nbATPrestataireH = var1;
   }

   public int getNbATStagiaire() {
      return this.nbATStagiaire;
   }

   public void setNbATStagiaire(int var1) {
      this.nbATStagiaire = var1;
   }

   public int getNbATStagiaireF() {
      return this.nbATStagiaireF;
   }

   public void setNbATStagiaireF(int var1) {
      this.nbATStagiaireF = var1;
   }

   public int getNbATStagiaireH() {
      return this.nbATStagiaireH;
   }

   public void setNbATStagiaireH(int var1) {
      this.nbATStagiaireH = var1;
   }

   public int getNbATSyndicat() {
      return this.nbATSyndicat;
   }

   public void setNbATSyndicat(int var1) {
      this.nbATSyndicat = var1;
   }

   public int getNbATSyndicatF() {
      return this.nbATSyndicatF;
   }

   public void setNbATSyndicatF(int var1) {
      this.nbATSyndicatF = var1;
   }

   public int getNbATSyndicatH() {
      return this.nbATSyndicatH;
   }

   public void setNbATSyndicatH(int var1) {
      this.nbATSyndicatH = var1;
   }

   public int getNbATTemporaire() {
      return this.nbATTemporaire;
   }

   public void setNbATTemporaire(int var1) {
      this.nbATTemporaire = var1;
   }

   public int getNbATTemporaireF() {
      return this.nbATTemporaireF;
   }

   public void setNbATTemporaireF(int var1) {
      this.nbATTemporaireF = var1;
   }

   public int getNbATTemporaireH() {
      return this.nbATTemporaireH;
   }

   public void setNbATTemporaireH(int var1) {
      this.nbATTemporaireH = var1;
   }

   public int getNbFemme() {
      return this.nbFemme;
   }

   public void setNbFemme(int var1) {
      this.nbFemme = var1;
   }

   public int getNbHomme() {
      return this.nbHomme;
   }

   public void setNbHomme(int var1) {
      this.nbHomme = var1;
   }

   public int getNbDeparasitage() {
      return this.nbDeparasitage;
   }

   public void setNbDeparasitage(int var1) {
      this.nbDeparasitage = var1;
   }

   public int getNbDeparasitageF() {
      return this.nbDeparasitageF;
   }

   public void setNbDeparasitageF(int var1) {
      this.nbDeparasitageF = var1;
   }

   public int getNbDeparasitageH() {
      return this.nbDeparasitageH;
   }

   public void setNbDeparasitageH(int var1) {
      this.nbDeparasitageH = var1;
   }
}
