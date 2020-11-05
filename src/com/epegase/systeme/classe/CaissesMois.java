package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CaissesMois implements Serializable {
   private long caimenId;
   private Date caimenDateCloture;
   private long caimenUserIdCloture;
   private Date caimenDateTransfert;
   private long caimenUserIdTransfert;
   private String caimenCode;
   private String caimenPeriode;
   private long caimenUserIdCaisse;
   private int caimenOpenJournal;
   private String caimenOpenUserJournal;
   private String caimenCle1;
   private int caimenEtat;
   private double caimenSoldeEspece;
   private double caimenSoldeCheque;
   private double caimenSoldeVirement;
   private double caimenSoldeTraite;
   private double caimenSoldeTpe;
   private double caimenSoldeePaiement;
   private double caimenSoldeTransfert;
   private double caimenSoldeCredoc;
   private double caimenSoldeFactor;
   private double caimenSoldeCompense;
   private double caimenSoldeTerme;
   private double caimenSoldeLettreGarantie;
   private double caimenSoldePrelevement;
   private double caimenSoldeAlcoin;
   private double caimenSoldeBonCaisse;
   private int caimenB1;
   private int caimenB2;
   private int caimenB3;
   private int caimenB4;
   private int caimenB5;
   private int caimenB6;
   private int caimenB7;
   private int caimenB8;
   private int caimenB9;
   private int caimenB10;
   private int caimenP1;
   private int caimenP2;
   private int caimenP3;
   private int caimenP4;
   private int caimenP5;
   private int caimenP6;
   private int caimenP7;
   private int caimenP8;
   private int caimenP9;
   private int caimenP10;
   private double caimenBon;
   private double caimenEspeceTheorique;
   private double caimenEspeceReel;
   private double caimenTimbre;
   private double caimenAutre;
   private double caimenDevise1;
   private double caimenDevise2;
   private double caimenDevise3;
   private double caimenDevise4;
   private double caimenDevise5;
   private double caimenEcart;
   private String caimenObservation;
   private Date caimenControle;
   private ExercicesCaisse exercicesCaisse;
   private double soldeFinal;
   private boolean select;

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public double getSoldeFinal() {
      this.soldeFinal = this.caimenSoldeEspece + this.caimenSoldeCheque + this.caimenSoldeVirement + this.caimenSoldeTraite + this.caimenSoldeTpe + this.caimenSoldeePaiement + this.caimenSoldeTransfert + this.caimenSoldeCredoc + this.caimenSoldeFactor + this.caimenSoldeCompense + this.caimenSoldeTerme;
      return this.soldeFinal;
   }

   public void setSoldeFinal(double var1) {
      this.soldeFinal = var1;
   }

   public String getCaimenCle1() {
      return this.caimenCle1;
   }

   public void setCaimenCle1(String var1) {
      this.caimenCle1 = var1;
   }

   public String getCaimenCode() {
      return this.caimenCode;
   }

   public void setCaimenCode(String var1) {
      this.caimenCode = var1;
   }

   public int getCaimenEtat() {
      return this.caimenEtat;
   }

   public void setCaimenEtat(int var1) {
      this.caimenEtat = var1;
   }

   public long getCaimenId() {
      return this.caimenId;
   }

   public void setCaimenId(long var1) {
      this.caimenId = var1;
   }

   public String getCaimenPeriode() {
      return this.caimenPeriode;
   }

   public void setCaimenPeriode(String var1) {
      this.caimenPeriode = var1;
   }

   public long getCaimenUserIdCaisse() {
      return this.caimenUserIdCaisse;
   }

   public void setCaimenUserIdCaisse(long var1) {
      this.caimenUserIdCaisse = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public long getCaimenUserIdCloture() {
      return this.caimenUserIdCloture;
   }

   public void setCaimenUserIdCloture(long var1) {
      this.caimenUserIdCloture = var1;
   }

   public long getCaimenUserIdTransfert() {
      return this.caimenUserIdTransfert;
   }

   public void setCaimenUserIdTransfert(long var1) {
      this.caimenUserIdTransfert = var1;
   }

   public int getCaimenOpenJournal() {
      return this.caimenOpenJournal;
   }

   public void setCaimenOpenJournal(int var1) {
      this.caimenOpenJournal = var1;
   }

   public String getCaimenOpenUserJournal() {
      return this.caimenOpenUserJournal;
   }

   public void setCaimenOpenUserJournal(String var1) {
      this.caimenOpenUserJournal = var1;
   }

   public double getCaimenSoldeCheque() {
      return this.caimenSoldeCheque;
   }

   public void setCaimenSoldeCheque(double var1) {
      this.caimenSoldeCheque = var1;
   }

   public double getCaimenSoldeCompense() {
      return this.caimenSoldeCompense;
   }

   public void setCaimenSoldeCompense(double var1) {
      this.caimenSoldeCompense = var1;
   }

   public double getCaimenSoldeCredoc() {
      return this.caimenSoldeCredoc;
   }

   public void setCaimenSoldeCredoc(double var1) {
      this.caimenSoldeCredoc = var1;
   }

   public double getCaimenSoldeEspece() {
      return this.caimenSoldeEspece;
   }

   public void setCaimenSoldeEspece(double var1) {
      this.caimenSoldeEspece = var1;
   }

   public double getCaimenSoldeFactor() {
      return this.caimenSoldeFactor;
   }

   public void setCaimenSoldeFactor(double var1) {
      this.caimenSoldeFactor = var1;
   }

   public double getCaimenSoldeTerme() {
      return this.caimenSoldeTerme;
   }

   public void setCaimenSoldeTerme(double var1) {
      this.caimenSoldeTerme = var1;
   }

   public double getCaimenSoldeTpe() {
      return this.caimenSoldeTpe;
   }

   public void setCaimenSoldeTpe(double var1) {
      this.caimenSoldeTpe = var1;
   }

   public double getCaimenSoldeTraite() {
      return this.caimenSoldeTraite;
   }

   public void setCaimenSoldeTraite(double var1) {
      this.caimenSoldeTraite = var1;
   }

   public double getCaimenSoldeVirement() {
      return this.caimenSoldeVirement;
   }

   public void setCaimenSoldeVirement(double var1) {
      this.caimenSoldeVirement = var1;
   }

   public double getCaimenSoldeePaiement() {
      return this.caimenSoldeePaiement;
   }

   public void setCaimenSoldeePaiement(double var1) {
      this.caimenSoldeePaiement = var1;
   }

   public double getCaimenSoldeTransfert() {
      return this.caimenSoldeTransfert;
   }

   public void setCaimenSoldeTransfert(double var1) {
      this.caimenSoldeTransfert = var1;
   }

   public Date getCaimenDateCloture() {
      return this.caimenDateCloture;
   }

   public void setCaimenDateCloture(Date var1) {
      this.caimenDateCloture = var1;
   }

   public Date getCaimenDateTransfert() {
      return this.caimenDateTransfert;
   }

   public void setCaimenDateTransfert(Date var1) {
      this.caimenDateTransfert = var1;
   }

   public int getCaimenB1() {
      return this.caimenB1;
   }

   public void setCaimenB1(int var1) {
      this.caimenB1 = var1;
   }

   public int getCaimenB10() {
      return this.caimenB10;
   }

   public void setCaimenB10(int var1) {
      this.caimenB10 = var1;
   }

   public int getCaimenB2() {
      return this.caimenB2;
   }

   public void setCaimenB2(int var1) {
      this.caimenB2 = var1;
   }

   public int getCaimenB3() {
      return this.caimenB3;
   }

   public void setCaimenB3(int var1) {
      this.caimenB3 = var1;
   }

   public int getCaimenB4() {
      return this.caimenB4;
   }

   public void setCaimenB4(int var1) {
      this.caimenB4 = var1;
   }

   public int getCaimenB5() {
      return this.caimenB5;
   }

   public void setCaimenB5(int var1) {
      this.caimenB5 = var1;
   }

   public int getCaimenB6() {
      return this.caimenB6;
   }

   public void setCaimenB6(int var1) {
      this.caimenB6 = var1;
   }

   public int getCaimenB7() {
      return this.caimenB7;
   }

   public void setCaimenB7(int var1) {
      this.caimenB7 = var1;
   }

   public int getCaimenB8() {
      return this.caimenB8;
   }

   public void setCaimenB8(int var1) {
      this.caimenB8 = var1;
   }

   public int getCaimenB9() {
      return this.caimenB9;
   }

   public void setCaimenB9(int var1) {
      this.caimenB9 = var1;
   }

   public double getCaimenBon() {
      return this.caimenBon;
   }

   public void setCaimenBon(double var1) {
      this.caimenBon = var1;
   }

   public double getCaimenDevise1() {
      return this.caimenDevise1;
   }

   public void setCaimenDevise1(double var1) {
      this.caimenDevise1 = var1;
   }

   public double getCaimenDevise2() {
      return this.caimenDevise2;
   }

   public void setCaimenDevise2(double var1) {
      this.caimenDevise2 = var1;
   }

   public double getCaimenDevise3() {
      return this.caimenDevise3;
   }

   public void setCaimenDevise3(double var1) {
      this.caimenDevise3 = var1;
   }

   public double getCaimenDevise4() {
      return this.caimenDevise4;
   }

   public void setCaimenDevise4(double var1) {
      this.caimenDevise4 = var1;
   }

   public double getCaimenDevise5() {
      return this.caimenDevise5;
   }

   public void setCaimenDevise5(double var1) {
      this.caimenDevise5 = var1;
   }

   public int getCaimenP1() {
      return this.caimenP1;
   }

   public void setCaimenP1(int var1) {
      this.caimenP1 = var1;
   }

   public int getCaimenP10() {
      return this.caimenP10;
   }

   public void setCaimenP10(int var1) {
      this.caimenP10 = var1;
   }

   public int getCaimenP2() {
      return this.caimenP2;
   }

   public void setCaimenP2(int var1) {
      this.caimenP2 = var1;
   }

   public int getCaimenP3() {
      return this.caimenP3;
   }

   public void setCaimenP3(int var1) {
      this.caimenP3 = var1;
   }

   public int getCaimenP4() {
      return this.caimenP4;
   }

   public void setCaimenP4(int var1) {
      this.caimenP4 = var1;
   }

   public int getCaimenP5() {
      return this.caimenP5;
   }

   public void setCaimenP5(int var1) {
      this.caimenP5 = var1;
   }

   public int getCaimenP6() {
      return this.caimenP6;
   }

   public void setCaimenP6(int var1) {
      this.caimenP6 = var1;
   }

   public int getCaimenP7() {
      return this.caimenP7;
   }

   public void setCaimenP7(int var1) {
      this.caimenP7 = var1;
   }

   public int getCaimenP8() {
      return this.caimenP8;
   }

   public void setCaimenP8(int var1) {
      this.caimenP8 = var1;
   }

   public int getCaimenP9() {
      return this.caimenP9;
   }

   public void setCaimenP9(int var1) {
      this.caimenP9 = var1;
   }

   public double getCaimenTimbre() {
      return this.caimenTimbre;
   }

   public void setCaimenTimbre(double var1) {
      this.caimenTimbre = var1;
   }

   public double getCaimenAutre() {
      return this.caimenAutre;
   }

   public void setCaimenAutre(double var1) {
      this.caimenAutre = var1;
   }

   public double getCaimenEcart() {
      return this.caimenEcart;
   }

   public void setCaimenEcart(double var1) {
      this.caimenEcart = var1;
   }

   public Date getCaimenControle() {
      return this.caimenControle;
   }

   public void setCaimenControle(Date var1) {
      this.caimenControle = var1;
   }

   public double getCaimenEspeceReel() {
      return this.caimenEspeceReel;
   }

   public void setCaimenEspeceReel(double var1) {
      this.caimenEspeceReel = var1;
   }

   public double getCaimenEspeceTheorique() {
      return this.caimenEspeceTheorique;
   }

   public void setCaimenEspeceTheorique(double var1) {
      this.caimenEspeceTheorique = var1;
   }

   public String getCaimenObservation() {
      return this.caimenObservation;
   }

   public void setCaimenObservation(String var1) {
      this.caimenObservation = var1;
   }

   public double getCaimenSoldeBonCaisse() {
      return this.caimenSoldeBonCaisse;
   }

   public void setCaimenSoldeBonCaisse(double var1) {
      this.caimenSoldeBonCaisse = var1;
   }

   public double getCaimenSoldeLettreGarantie() {
      return this.caimenSoldeLettreGarantie;
   }

   public void setCaimenSoldeLettreGarantie(double var1) {
      this.caimenSoldeLettreGarantie = var1;
   }

   public double getCaimenSoldeAlcoin() {
      return this.caimenSoldeAlcoin;
   }

   public void setCaimenSoldeAlcoin(double var1) {
      this.caimenSoldeAlcoin = var1;
   }

   public double getCaimenSoldePrelevement() {
      return this.caimenSoldePrelevement;
   }

   public void setCaimenSoldePrelevement(double var1) {
      this.caimenSoldePrelevement = var1;
   }
}
