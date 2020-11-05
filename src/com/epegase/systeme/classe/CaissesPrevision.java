package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CaissesPrevision implements Serializable {
   private long caipreId;
   private int caipreType;
   private Date caipreDateCreation;
   private long caipreUserIdCreation;
   private Date caipreDateModif;
   private long caipreUserIdModif;
   private String caiprePeriode;
   private Date caipreDateDebut;
   private Date caipreDateFin;
   private int caipreEtat;
   private double caipreRecetteEspece;
   private double caipreRecetteCheque;
   private double caipreRecetteVirement;
   private double caipreRecetteTraite;
   private double caipreRecetteTpe;
   private double caipreRecetteePaiement;
   private double caipreRecetteTransfert;
   private double caipreRecetteCredoc;
   private double caipreRecetteFactor;
   private double caipreRecetteCompense;
   private double caipreRecetteTerme;
   private double caipreRecetteBonCaisse;
   private double caipreTotalRecette;
   private double caipreDepenseEspece;
   private double caipreDepenseCheque;
   private double caipreDepenseVirement;
   private double caipreDepenseTraite;
   private double caipreDepenseTpe;
   private double caipreDepenseePaiement;
   private double caipreDepenseTransfert;
   private double caipreDepenseCredoc;
   private double caipreDepenseFactor;
   private double caipreDepenseCompense;
   private double caipreDepenseTerme;
   private double caipreDepenseBonCaisse;
   private double caipreTotalDepense;
   private String caipreObservations;
   private int caipreNbP1;
   private int caipreNbP2;
   private int caipreNbP3;
   private int caipreNbP4;
   private int caipreNbP5;
   private int caipreNbP6;
   private int caipreNbP7;
   private int caipreNbP8;
   private int caipreNbP9;
   private int caipreNbP10;
   private int caipreNbB1;
   private int caipreNbB2;
   private int caipreNbB3;
   private int caipreNbB4;
   private int caipreNbB5;
   private int caipreNbB6;
   private int caipreNbB7;
   private int caipreNbB8;
   private int caipreNbB9;
   private int caipreNbB10;
   private double caipreTotalCheques;
   private double caipreTotalDevises;
   private String caipreCaisse;
   private String caipreDepot;
   private long caipreIdCaissier;
   private long caipreIdEquipe;
   private long caipreIdResponsable;
   private ExercicesCaisse exercicesCaisse;
   private String libelle_etat;

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public String getLibelle_etat() {
      if (this.caipreEtat == 0) {
         this.libelle_etat = "EC";
      } else if (this.caipreEtat == 1) {
         this.libelle_etat = "Val";
      }

      return this.libelle_etat;
   }

   public void setLibelle_etat(String var1) {
      this.libelle_etat = var1;
   }

   public Date getCaipreDateCreation() {
      return this.caipreDateCreation;
   }

   public void setCaipreDateCreation(Date var1) {
      this.caipreDateCreation = var1;
   }

   public Date getCaipreDateDebut() {
      return this.caipreDateDebut;
   }

   public void setCaipreDateDebut(Date var1) {
      this.caipreDateDebut = var1;
   }

   public Date getCaipreDateFin() {
      return this.caipreDateFin;
   }

   public void setCaipreDateFin(Date var1) {
      this.caipreDateFin = var1;
   }

   public Date getCaipreDateModif() {
      return this.caipreDateModif;
   }

   public void setCaipreDateModif(Date var1) {
      this.caipreDateModif = var1;
   }

   public double getCaipreDepenseBonCaisse() {
      return this.caipreDepenseBonCaisse;
   }

   public void setCaipreDepenseBonCaisse(double var1) {
      this.caipreDepenseBonCaisse = var1;
   }

   public double getCaipreDepenseCheque() {
      return this.caipreDepenseCheque;
   }

   public void setCaipreDepenseCheque(double var1) {
      this.caipreDepenseCheque = var1;
   }

   public double getCaipreDepenseCompense() {
      return this.caipreDepenseCompense;
   }

   public void setCaipreDepenseCompense(double var1) {
      this.caipreDepenseCompense = var1;
   }

   public double getCaipreDepenseCredoc() {
      return this.caipreDepenseCredoc;
   }

   public void setCaipreDepenseCredoc(double var1) {
      this.caipreDepenseCredoc = var1;
   }

   public double getCaipreDepenseEspece() {
      return this.caipreDepenseEspece;
   }

   public void setCaipreDepenseEspece(double var1) {
      this.caipreDepenseEspece = var1;
   }

   public double getCaipreDepenseFactor() {
      return this.caipreDepenseFactor;
   }

   public void setCaipreDepenseFactor(double var1) {
      this.caipreDepenseFactor = var1;
   }

   public double getCaipreDepenseTerme() {
      return this.caipreDepenseTerme;
   }

   public void setCaipreDepenseTerme(double var1) {
      this.caipreDepenseTerme = var1;
   }

   public double getCaipreDepenseTpe() {
      return this.caipreDepenseTpe;
   }

   public void setCaipreDepenseTpe(double var1) {
      this.caipreDepenseTpe = var1;
   }

   public double getCaipreDepenseTraite() {
      return this.caipreDepenseTraite;
   }

   public void setCaipreDepenseTraite(double var1) {
      this.caipreDepenseTraite = var1;
   }

   public double getCaipreDepenseTransfert() {
      return this.caipreDepenseTransfert;
   }

   public void setCaipreDepenseTransfert(double var1) {
      this.caipreDepenseTransfert = var1;
   }

   public double getCaipreDepenseVirement() {
      return this.caipreDepenseVirement;
   }

   public void setCaipreDepenseVirement(double var1) {
      this.caipreDepenseVirement = var1;
   }

   public int getCaipreEtat() {
      return this.caipreEtat;
   }

   public void setCaipreEtat(int var1) {
      this.caipreEtat = var1;
   }

   public long getCaipreId() {
      return this.caipreId;
   }

   public void setCaipreId(long var1) {
      this.caipreId = var1;
   }

   public String getCaiprePeriode() {
      return this.caiprePeriode;
   }

   public void setCaiprePeriode(String var1) {
      this.caiprePeriode = var1;
   }

   public double getCaipreRecetteBonCaisse() {
      return this.caipreRecetteBonCaisse;
   }

   public void setCaipreRecetteBonCaisse(double var1) {
      this.caipreRecetteBonCaisse = var1;
   }

   public double getCaipreRecetteCheque() {
      return this.caipreRecetteCheque;
   }

   public void setCaipreRecetteCheque(double var1) {
      this.caipreRecetteCheque = var1;
   }

   public double getCaipreRecetteCompense() {
      return this.caipreRecetteCompense;
   }

   public void setCaipreRecetteCompense(double var1) {
      this.caipreRecetteCompense = var1;
   }

   public double getCaipreRecetteCredoc() {
      return this.caipreRecetteCredoc;
   }

   public void setCaipreRecetteCredoc(double var1) {
      this.caipreRecetteCredoc = var1;
   }

   public double getCaipreRecetteEspece() {
      return this.caipreRecetteEspece;
   }

   public void setCaipreRecetteEspece(double var1) {
      this.caipreRecetteEspece = var1;
   }

   public double getCaipreRecetteFactor() {
      return this.caipreRecetteFactor;
   }

   public void setCaipreRecetteFactor(double var1) {
      this.caipreRecetteFactor = var1;
   }

   public double getCaipreRecetteTerme() {
      return this.caipreRecetteTerme;
   }

   public void setCaipreRecetteTerme(double var1) {
      this.caipreRecetteTerme = var1;
   }

   public double getCaipreRecetteTpe() {
      return this.caipreRecetteTpe;
   }

   public void setCaipreRecetteTpe(double var1) {
      this.caipreRecetteTpe = var1;
   }

   public double getCaipreRecetteTraite() {
      return this.caipreRecetteTraite;
   }

   public void setCaipreRecetteTraite(double var1) {
      this.caipreRecetteTraite = var1;
   }

   public double getCaipreRecetteTransfert() {
      return this.caipreRecetteTransfert;
   }

   public void setCaipreRecetteTransfert(double var1) {
      this.caipreRecetteTransfert = var1;
   }

   public double getCaipreRecetteVirement() {
      return this.caipreRecetteVirement;
   }

   public void setCaipreRecetteVirement(double var1) {
      this.caipreRecetteVirement = var1;
   }

   public double getCaipreTotalDepense() {
      this.caipreTotalDepense = this.caipreDepenseBonCaisse + this.caipreDepenseCheque + this.caipreDepenseCompense + this.caipreDepenseCredoc + this.caipreDepenseEspece + this.caipreDepenseFactor + this.caipreDepenseTerme + this.caipreDepenseTpe + this.caipreDepenseTraite + this.caipreDepenseTransfert + this.caipreDepenseVirement + this.caipreDepenseePaiement;
      return this.caipreTotalDepense;
   }

   public void setCaipreTotalDepense(double var1) {
      this.caipreTotalDepense = var1;
   }

   public double getCaipreTotalRecette() {
      this.caipreTotalRecette = this.caipreRecetteBonCaisse + this.caipreRecetteCheque + this.caipreRecetteCompense + this.caipreRecetteCredoc + this.caipreRecetteEspece + this.caipreRecetteFactor + this.caipreRecetteTerme + this.caipreRecetteTpe + this.caipreRecetteTraite + this.caipreRecetteTransfert + this.caipreRecetteVirement + this.caipreRecetteePaiement;
      return this.caipreTotalRecette;
   }

   public void setCaipreTotalRecette(double var1) {
      this.caipreTotalRecette = var1;
   }

   public long getCaipreUserIdCreation() {
      return this.caipreUserIdCreation;
   }

   public void setCaipreUserIdCreation(long var1) {
      this.caipreUserIdCreation = var1;
   }

   public long getCaipreUserIdModif() {
      return this.caipreUserIdModif;
   }

   public void setCaipreUserIdModif(long var1) {
      this.caipreUserIdModif = var1;
   }

   public String getCaipreObservations() {
      return this.caipreObservations;
   }

   public void setCaipreObservations(String var1) {
      this.caipreObservations = var1;
   }

   public double getCaipreDepenseePaiement() {
      return this.caipreDepenseePaiement;
   }

   public void setCaipreDepenseePaiement(double var1) {
      this.caipreDepenseePaiement = var1;
   }

   public double getCaipreRecetteePaiement() {
      return this.caipreRecetteePaiement;
   }

   public void setCaipreRecetteePaiement(double var1) {
      this.caipreRecetteePaiement = var1;
   }

   public String getCaipreCaisse() {
      return this.caipreCaisse;
   }

   public void setCaipreCaisse(String var1) {
      this.caipreCaisse = var1;
   }

   public String getCaipreDepot() {
      return this.caipreDepot;
   }

   public void setCaipreDepot(String var1) {
      this.caipreDepot = var1;
   }

   public long getCaipreIdCaissier() {
      return this.caipreIdCaissier;
   }

   public void setCaipreIdCaissier(long var1) {
      this.caipreIdCaissier = var1;
   }

   public long getCaipreIdEquipe() {
      return this.caipreIdEquipe;
   }

   public void setCaipreIdEquipe(long var1) {
      this.caipreIdEquipe = var1;
   }

   public long getCaipreIdResponsable() {
      return this.caipreIdResponsable;
   }

   public void setCaipreIdResponsable(long var1) {
      this.caipreIdResponsable = var1;
   }

   public int getCaipreNbB1() {
      return this.caipreNbB1;
   }

   public void setCaipreNbB1(int var1) {
      this.caipreNbB1 = var1;
   }

   public int getCaipreNbB10() {
      return this.caipreNbB10;
   }

   public void setCaipreNbB10(int var1) {
      this.caipreNbB10 = var1;
   }

   public int getCaipreNbB2() {
      return this.caipreNbB2;
   }

   public void setCaipreNbB2(int var1) {
      this.caipreNbB2 = var1;
   }

   public int getCaipreNbB3() {
      return this.caipreNbB3;
   }

   public void setCaipreNbB3(int var1) {
      this.caipreNbB3 = var1;
   }

   public int getCaipreNbB4() {
      return this.caipreNbB4;
   }

   public void setCaipreNbB4(int var1) {
      this.caipreNbB4 = var1;
   }

   public int getCaipreNbB5() {
      return this.caipreNbB5;
   }

   public void setCaipreNbB5(int var1) {
      this.caipreNbB5 = var1;
   }

   public int getCaipreNbB6() {
      return this.caipreNbB6;
   }

   public void setCaipreNbB6(int var1) {
      this.caipreNbB6 = var1;
   }

   public int getCaipreNbB7() {
      return this.caipreNbB7;
   }

   public void setCaipreNbB7(int var1) {
      this.caipreNbB7 = var1;
   }

   public int getCaipreNbB8() {
      return this.caipreNbB8;
   }

   public void setCaipreNbB8(int var1) {
      this.caipreNbB8 = var1;
   }

   public int getCaipreNbB9() {
      return this.caipreNbB9;
   }

   public void setCaipreNbB9(int var1) {
      this.caipreNbB9 = var1;
   }

   public int getCaipreNbP1() {
      return this.caipreNbP1;
   }

   public void setCaipreNbP1(int var1) {
      this.caipreNbP1 = var1;
   }

   public int getCaipreNbP10() {
      return this.caipreNbP10;
   }

   public void setCaipreNbP10(int var1) {
      this.caipreNbP10 = var1;
   }

   public int getCaipreNbP2() {
      return this.caipreNbP2;
   }

   public void setCaipreNbP2(int var1) {
      this.caipreNbP2 = var1;
   }

   public int getCaipreNbP3() {
      return this.caipreNbP3;
   }

   public void setCaipreNbP3(int var1) {
      this.caipreNbP3 = var1;
   }

   public int getCaipreNbP4() {
      return this.caipreNbP4;
   }

   public void setCaipreNbP4(int var1) {
      this.caipreNbP4 = var1;
   }

   public int getCaipreNbP5() {
      return this.caipreNbP5;
   }

   public void setCaipreNbP5(int var1) {
      this.caipreNbP5 = var1;
   }

   public int getCaipreNbP6() {
      return this.caipreNbP6;
   }

   public void setCaipreNbP6(int var1) {
      this.caipreNbP6 = var1;
   }

   public int getCaipreNbP7() {
      return this.caipreNbP7;
   }

   public void setCaipreNbP7(int var1) {
      this.caipreNbP7 = var1;
   }

   public int getCaipreNbP8() {
      return this.caipreNbP8;
   }

   public void setCaipreNbP8(int var1) {
      this.caipreNbP8 = var1;
   }

   public int getCaipreNbP9() {
      return this.caipreNbP9;
   }

   public void setCaipreNbP9(int var1) {
      this.caipreNbP9 = var1;
   }

   public int getCaipreType() {
      return this.caipreType;
   }

   public void setCaipreType(int var1) {
      this.caipreType = var1;
   }

   public double getCaipreTotalCheques() {
      return this.caipreTotalCheques;
   }

   public void setCaipreTotalCheques(double var1) {
      this.caipreTotalCheques = var1;
   }

   public double getCaipreTotalDevises() {
      return this.caipreTotalDevises;
   }

   public void setCaipreTotalDevises(double var1) {
      this.caipreTotalDevises = var1;
   }
}
