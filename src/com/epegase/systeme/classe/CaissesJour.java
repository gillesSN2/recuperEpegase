package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CaissesJour implements Serializable {
   private long caijouId;
   private Date caijouDateCloture;
   private long caijouUserIdCloture;
   private Date caijouDateTransfert;
   private long caijouUserIdTransfert;
   private String caijouCode;
   private String caijouPeriode;
   private Date caijouDate;
   private long caijouUserIdCaisse;
   private int caijouOpenJournal;
   private String caijouOpenUserJournal;
   private String caijouCle1;
   private int caijouEtat;
   private double caijouSoldeEspece;
   private double caijouSoldeCheque;
   private double caijouSoldeVirement;
   private double caijouSoldeTraite;
   private double caijouSoldeTpe;
   private double caijouSoldeePaiement;
   private double caijouSoldeTransfert;
   private double caijouSoldeCredoc;
   private double caijouSoldeFactor;
   private double caijouSoldeCompense;
   private double caijouSoldeTerme;
   private double caijouSoldeLettreGarantie;
   private double caijouSoldePrelevement;
   private double caijouSoldeAlcoin;
   private double caijouSoldeBonCaisse;
   private int caijouB1;
   private int caijouB2;
   private int caijouB3;
   private int caijouB4;
   private int caijouB5;
   private int caijouB6;
   private int caijouB7;
   private int caijouB8;
   private int caijouB9;
   private int caijouB10;
   private int caijouP1;
   private int caijouP2;
   private int caijouP3;
   private int caijouP4;
   private int caijouP5;
   private int caijouP6;
   private int caijouP7;
   private int caijouP8;
   private int caijouP9;
   private int caijouP10;
   private double caijouBon;
   private double caijouEspeceTheorique;
   private double caijouEspeceReel;
   private double caijouTimbre;
   private double caijouAutre;
   private double caijouDevise1;
   private double caijouDevise2;
   private double caijouDevise3;
   private double caijouDevise4;
   private double caijouDevise5;
   private double caijouEcart;
   private String caijouObservation;
   private Date caijouControle;
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
      this.soldeFinal = this.caijouSoldeEspece + this.caijouSoldeCheque + this.caijouSoldeVirement + this.caijouSoldeTraite + this.caijouSoldeTpe + this.caijouSoldeePaiement + this.caijouSoldeTransfert + this.caijouSoldeCredoc + this.caijouSoldeFactor + this.caijouSoldeCompense + this.caijouSoldeTerme;
      return this.soldeFinal;
   }

   public void setSoldeFinal(double var1) {
      this.soldeFinal = var1;
   }

   public String getCaijouCle1() {
      return this.caijouCle1;
   }

   public void setCaijouCle1(String var1) {
      this.caijouCle1 = var1;
   }

   public String getCaijouCode() {
      return this.caijouCode;
   }

   public void setCaijouCode(String var1) {
      this.caijouCode = var1;
   }

   public Date getCaijouDate() {
      return this.caijouDate;
   }

   public void setCaijouDate(Date var1) {
      this.caijouDate = var1;
   }

   public Date getCaijouDateCloture() {
      return this.caijouDateCloture;
   }

   public void setCaijouDateCloture(Date var1) {
      this.caijouDateCloture = var1;
   }

   public Date getCaijouDateTransfert() {
      return this.caijouDateTransfert;
   }

   public void setCaijouDateTransfert(Date var1) {
      this.caijouDateTransfert = var1;
   }

   public int getCaijouEtat() {
      return this.caijouEtat;
   }

   public void setCaijouEtat(int var1) {
      this.caijouEtat = var1;
   }

   public long getCaijouId() {
      return this.caijouId;
   }

   public void setCaijouId(long var1) {
      this.caijouId = var1;
   }

   public int getCaijouOpenJournal() {
      return this.caijouOpenJournal;
   }

   public void setCaijouOpenJournal(int var1) {
      this.caijouOpenJournal = var1;
   }

   public String getCaijouOpenUserJournal() {
      return this.caijouOpenUserJournal;
   }

   public void setCaijouOpenUserJournal(String var1) {
      this.caijouOpenUserJournal = var1;
   }

   public String getCaijouPeriode() {
      return this.caijouPeriode;
   }

   public void setCaijouPeriode(String var1) {
      this.caijouPeriode = var1;
   }

   public double getCaijouSoldeCheque() {
      return this.caijouSoldeCheque;
   }

   public void setCaijouSoldeCheque(double var1) {
      this.caijouSoldeCheque = var1;
   }

   public double getCaijouSoldeCompense() {
      return this.caijouSoldeCompense;
   }

   public void setCaijouSoldeCompense(double var1) {
      this.caijouSoldeCompense = var1;
   }

   public double getCaijouSoldeCredoc() {
      return this.caijouSoldeCredoc;
   }

   public void setCaijouSoldeCredoc(double var1) {
      this.caijouSoldeCredoc = var1;
   }

   public double getCaijouSoldeEspece() {
      return this.caijouSoldeEspece;
   }

   public void setCaijouSoldeEspece(double var1) {
      this.caijouSoldeEspece = var1;
   }

   public double getCaijouSoldeFactor() {
      return this.caijouSoldeFactor;
   }

   public void setCaijouSoldeFactor(double var1) {
      this.caijouSoldeFactor = var1;
   }

   public double getCaijouSoldeTerme() {
      return this.caijouSoldeTerme;
   }

   public void setCaijouSoldeTerme(double var1) {
      this.caijouSoldeTerme = var1;
   }

   public double getCaijouSoldeTpe() {
      return this.caijouSoldeTpe;
   }

   public void setCaijouSoldeTpe(double var1) {
      this.caijouSoldeTpe = var1;
   }

   public double getCaijouSoldeTraite() {
      return this.caijouSoldeTraite;
   }

   public void setCaijouSoldeTraite(double var1) {
      this.caijouSoldeTraite = var1;
   }

   public double getCaijouSoldeTransfert() {
      return this.caijouSoldeTransfert;
   }

   public void setCaijouSoldeTransfert(double var1) {
      this.caijouSoldeTransfert = var1;
   }

   public double getCaijouSoldeVirement() {
      return this.caijouSoldeVirement;
   }

   public void setCaijouSoldeVirement(double var1) {
      this.caijouSoldeVirement = var1;
   }

   public double getCaijouSoldeePaiement() {
      return this.caijouSoldeePaiement;
   }

   public void setCaijouSoldeePaiement(double var1) {
      this.caijouSoldeePaiement = var1;
   }

   public long getCaijouUserIdCaisse() {
      return this.caijouUserIdCaisse;
   }

   public void setCaijouUserIdCaisse(long var1) {
      this.caijouUserIdCaisse = var1;
   }

   public long getCaijouUserIdCloture() {
      return this.caijouUserIdCloture;
   }

   public void setCaijouUserIdCloture(long var1) {
      this.caijouUserIdCloture = var1;
   }

   public long getCaijouUserIdTransfert() {
      return this.caijouUserIdTransfert;
   }

   public void setCaijouUserIdTransfert(long var1) {
      this.caijouUserIdTransfert = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public int getCaijouB1() {
      return this.caijouB1;
   }

   public void setCaijouB1(int var1) {
      this.caijouB1 = var1;
   }

   public int getCaijouB10() {
      return this.caijouB10;
   }

   public void setCaijouB10(int var1) {
      this.caijouB10 = var1;
   }

   public int getCaijouB2() {
      return this.caijouB2;
   }

   public void setCaijouB2(int var1) {
      this.caijouB2 = var1;
   }

   public int getCaijouB3() {
      return this.caijouB3;
   }

   public void setCaijouB3(int var1) {
      this.caijouB3 = var1;
   }

   public int getCaijouB4() {
      return this.caijouB4;
   }

   public void setCaijouB4(int var1) {
      this.caijouB4 = var1;
   }

   public int getCaijouB5() {
      return this.caijouB5;
   }

   public void setCaijouB5(int var1) {
      this.caijouB5 = var1;
   }

   public int getCaijouB6() {
      return this.caijouB6;
   }

   public void setCaijouB6(int var1) {
      this.caijouB6 = var1;
   }

   public int getCaijouB7() {
      return this.caijouB7;
   }

   public void setCaijouB7(int var1) {
      this.caijouB7 = var1;
   }

   public int getCaijouB8() {
      return this.caijouB8;
   }

   public void setCaijouB8(int var1) {
      this.caijouB8 = var1;
   }

   public int getCaijouB9() {
      return this.caijouB9;
   }

   public void setCaijouB9(int var1) {
      this.caijouB9 = var1;
   }

   public double getCaijouBon() {
      return this.caijouBon;
   }

   public void setCaijouBon(double var1) {
      this.caijouBon = var1;
   }

   public double getCaijouDevise1() {
      return this.caijouDevise1;
   }

   public void setCaijouDevise1(double var1) {
      this.caijouDevise1 = var1;
   }

   public double getCaijouDevise2() {
      return this.caijouDevise2;
   }

   public void setCaijouDevise2(double var1) {
      this.caijouDevise2 = var1;
   }

   public double getCaijouDevise3() {
      return this.caijouDevise3;
   }

   public void setCaijouDevise3(double var1) {
      this.caijouDevise3 = var1;
   }

   public double getCaijouDevise4() {
      return this.caijouDevise4;
   }

   public void setCaijouDevise4(double var1) {
      this.caijouDevise4 = var1;
   }

   public double getCaijouDevise5() {
      return this.caijouDevise5;
   }

   public void setCaijouDevise5(double var1) {
      this.caijouDevise5 = var1;
   }

   public int getCaijouP1() {
      return this.caijouP1;
   }

   public void setCaijouP1(int var1) {
      this.caijouP1 = var1;
   }

   public int getCaijouP10() {
      return this.caijouP10;
   }

   public void setCaijouP10(int var1) {
      this.caijouP10 = var1;
   }

   public int getCaijouP2() {
      return this.caijouP2;
   }

   public void setCaijouP2(int var1) {
      this.caijouP2 = var1;
   }

   public int getCaijouP3() {
      return this.caijouP3;
   }

   public void setCaijouP3(int var1) {
      this.caijouP3 = var1;
   }

   public int getCaijouP4() {
      return this.caijouP4;
   }

   public void setCaijouP4(int var1) {
      this.caijouP4 = var1;
   }

   public int getCaijouP5() {
      return this.caijouP5;
   }

   public void setCaijouP5(int var1) {
      this.caijouP5 = var1;
   }

   public int getCaijouP6() {
      return this.caijouP6;
   }

   public void setCaijouP6(int var1) {
      this.caijouP6 = var1;
   }

   public int getCaijouP7() {
      return this.caijouP7;
   }

   public void setCaijouP7(int var1) {
      this.caijouP7 = var1;
   }

   public int getCaijouP8() {
      return this.caijouP8;
   }

   public void setCaijouP8(int var1) {
      this.caijouP8 = var1;
   }

   public int getCaijouP9() {
      return this.caijouP9;
   }

   public void setCaijouP9(int var1) {
      this.caijouP9 = var1;
   }

   public double getCaijouTimbre() {
      return this.caijouTimbre;
   }

   public void setCaijouTimbre(double var1) {
      this.caijouTimbre = var1;
   }

   public double getCaijouAutre() {
      return this.caijouAutre;
   }

   public void setCaijouAutre(double var1) {
      this.caijouAutre = var1;
   }

   public String getCaijouObservation() {
      return this.caijouObservation;
   }

   public void setCaijouObservation(String var1) {
      this.caijouObservation = var1;
   }

   public double getCaijouEspeceReel() {
      return this.caijouEspeceReel;
   }

   public void setCaijouEspeceReel(double var1) {
      this.caijouEspeceReel = var1;
   }

   public double getCaijouEspeceTheorique() {
      return this.caijouEspeceTheorique;
   }

   public void setCaijouEspeceTheorique(double var1) {
      this.caijouEspeceTheorique = var1;
   }

   public double getCaijouEcart() {
      return this.caijouEcart;
   }

   public void setCaijouEcart(double var1) {
      this.caijouEcart = var1;
   }

   public double getCaijouSoldeBonCaisse() {
      return this.caijouSoldeBonCaisse;
   }

   public void setCaijouSoldeBonCaisse(double var1) {
      this.caijouSoldeBonCaisse = var1;
   }

   public Date getCaijouControle() {
      return this.caijouControle;
   }

   public void setCaijouControle(Date var1) {
      this.caijouControle = var1;
   }

   public double getCaijouSoldeLettreGarantie() {
      return this.caijouSoldeLettreGarantie;
   }

   public void setCaijouSoldeLettreGarantie(double var1) {
      this.caijouSoldeLettreGarantie = var1;
   }

   public double getCaijouSoldeAlcoin() {
      return this.caijouSoldeAlcoin;
   }

   public void setCaijouSoldeAlcoin(double var1) {
      this.caijouSoldeAlcoin = var1;
   }

   public double getCaijouSoldePrelevement() {
      return this.caijouSoldePrelevement;
   }

   public void setCaijouSoldePrelevement(double var1) {
      this.caijouSoldePrelevement = var1;
   }
}
