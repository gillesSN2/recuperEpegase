package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CaissesInventaire implements Serializable {
   private long caiinvId;
   private Date caiinvDateCreation;
   private long caiinvUserIdCreation;
   private Date caiinvDateModif;
   private long caiinvUserIdModif;
   private String caiinvCodeCaisse;
   private String caiinvLibCaisse;
   private String caiinvSerie;
   private String caiinvPeriode;
   private Date caiinvDate;
   private String caiinvNum;
   private Date caiinvDateCtrl;
   private long caiinvCaisseIdCtrl;
   private long caiinvUserIdCaisse;
   private String caiinvUserNomCaisse;
   private int caiinvEtat;
   private double caiinvSoldeEspece;
   private double caiinvSoldeCheque;
   private double caiinvSoldeVirement;
   private double caiinvSoldeTraite;
   private double caiinvSoldeTpe;
   private double caiinvSoldeePaiement;
   private double caiinvSoldeTransfert;
   private double caiinvSoldeCredoc;
   private double caiinvSoldeFactor;
   private double caiinvSoldeCompense;
   private double caiinvSoldeTerme;
   private double caiinvSoldeBonCaisse;
   private int caiinvB1;
   private int caiinvB2;
   private int caiinvB3;
   private int caiinvB4;
   private int caiinvB5;
   private int caiinvB6;
   private int caiinvB7;
   private int caiinvB8;
   private int caiinvB9;
   private int caiinvB10;
   private int caiinvP1;
   private int caiinvP2;
   private int caiinvP3;
   private int caiinvP4;
   private int caiinvP5;
   private int caiinvP6;
   private int caiinvP7;
   private int caiinvP8;
   private int caiinvP9;
   private int caiinvP10;
   private double caiinvBon;
   private double caiinvEspece;
   private double caiinvTimbre;
   private double caiinvAutre;
   private double caiinvDevise1;
   private double caiinvDevise2;
   private double caiinvDevise3;
   private double caiinvDevise4;
   private double caiinvDevise5;
   private double caiinvEcart;
   private String caiinvObservation;
   private double caiinvSoldeEspeceReel;
   private double caiinvSoldeChequeReel;
   private double caiinvSoldeVirementReel;
   private double caiinvSoldeTraiteReel;
   private double caiinvSoldeTpeReel;
   private double caiinvSoldeePaiementReel;
   private double caiinvSoldeTransfertReel;
   private double caiinvSoldeCredocReel;
   private double caiinvSoldeFactorReel;
   private double caiinvSoldeCompenseReel;
   private double caiinvSoldeTermeReel;
   private double caiinvSoldeBonCaisseReel;
   private int caiinvB1Reel;
   private int caiinvB2Reel;
   private int caiinvB3Reel;
   private int caiinvB4Reel;
   private int caiinvB5Reel;
   private int caiinvB6Reel;
   private int caiinvB7Reel;
   private int caiinvB8Reel;
   private int caiinvB9Reel;
   private int caiinvB10Reel;
   private int caiinvP1Reel;
   private int caiinvP2Reel;
   private int caiinvP3Reel;
   private int caiinvP4Reel;
   private int caiinvP5Reel;
   private int caiinvP6Reel;
   private int caiinvP7Reel;
   private int caiinvP8Reel;
   private int caiinvP9Reel;
   private int caiinvP10Reel;
   private double caiinvBonReel;
   private double caiinvEspeceReel;
   private double caiinvTimbreReel;
   private double caiinvAutreReel;
   private double caiinvDevise1Reel;
   private double caiinvDevise2Reel;
   private double caiinvDevise3Reel;
   private double caiinvDevise4Reel;
   private double caiinvDevise5Reel;
   private double caiinvEcartReel;
   private Date caiinvDateImpression;
   private String caiinvModeleImp;
   private double caiinvSoldeEspeceEcart;
   private double caiinvSoldeChequeEcart;
   private double caiinvSoldeVirementEcart;
   private double caiinvSoldeTraiteEcart;
   private double caiinvSoldeTpeEcart;
   private double caiinvSoldeePaiementEcart;
   private double caiinvSoldeTransfertEcart;
   private double caiinvSoldeCredocEcart;
   private double caiinvSoldeFactorEcart;
   private double caiinvSoldeCompenseEcart;
   private double caiinvSoldeTermeEcart;
   private double caiinvSoldeBonCaisseEcart;
   private int caiinvB1Ecart;
   private int caiinvB2Ecart;
   private int caiinvB3Ecart;
   private int caiinvB4Ecart;
   private int caiinvB5Ecart;
   private int caiinvB6Ecart;
   private int caiinvB7Ecart;
   private int caiinvB8Ecart;
   private int caiinvB9Ecart;
   private int caiinvB10Ecart;
   private int caiinvP1Ecart;
   private int caiinvP2Ecart;
   private int caiinvP3Ecart;
   private int caiinvP4Ecart;
   private int caiinvP5Ecart;
   private int caiinvP6Ecart;
   private int caiinvP7Ecart;
   private int caiinvP8Ecart;
   private int caiinvP9Ecart;
   private int caiinvP10Ecart;
   private double caiinvBonEcart;
   private double caiinvEspeceEcart;
   private double caiinvTimbreEcart;
   private double caiinvAutreEcart;
   private double caiinvDevise1Ecart;
   private double caiinvDevise2Ecart;
   private double caiinvDevise3Ecart;
   private double caiinvDevise4Ecart;
   private double caiinvDevise5Ecart;
   private double caiinvEcartEcart;
   private ExercicesCaisse exercicesCaisse;
   private double soldeFinal;
   private String var_etat;

   public double getSoldeFinal() {
      this.soldeFinal = this.caiinvSoldeEspece + this.caiinvSoldeCheque + this.caiinvSoldeVirement + this.caiinvSoldeTraite + this.caiinvSoldeTpe + this.caiinvSoldeePaiement + this.caiinvSoldeTransfert + this.caiinvSoldeCredoc + this.caiinvSoldeFactor + this.caiinvSoldeCompense + this.caiinvSoldeTerme;
      return this.soldeFinal;
   }

   public void setSoldeFinal(double var1) {
      this.soldeFinal = var1;
   }

   public String getVar_etat() {
      if (this.caiinvEtat == 0) {
         this.var_etat = "E.C.";
      } else if (this.caiinvEtat == 1) {
         this.var_etat = "Val.";
      } else if (this.caiinvEtat == 2) {
         this.var_etat = "Gel.";
      } else if (this.caiinvEtat == 3) {
         this.var_etat = "Annul.";
      }

      return this.var_etat;
   }

   public void setVar_etat(String var1) {
      this.var_etat = var1;
   }

   public double getCaiinvAutre() {
      return this.caiinvAutre;
   }

   public void setCaiinvAutre(double var1) {
      this.caiinvAutre = var1;
   }

   public double getCaiinvAutreReel() {
      return this.caiinvAutreReel;
   }

   public void setCaiinvAutreReel(double var1) {
      this.caiinvAutreReel = var1;
   }

   public int getCaiinvB1() {
      return this.caiinvB1;
   }

   public void setCaiinvB1(int var1) {
      this.caiinvB1 = var1;
   }

   public int getCaiinvB10() {
      return this.caiinvB10;
   }

   public void setCaiinvB10(int var1) {
      this.caiinvB10 = var1;
   }

   public int getCaiinvB10Reel() {
      return this.caiinvB10Reel;
   }

   public void setCaiinvB10Reel(int var1) {
      this.caiinvB10Reel = var1;
   }

   public int getCaiinvB1Reel() {
      return this.caiinvB1Reel;
   }

   public void setCaiinvB1Reel(int var1) {
      this.caiinvB1Reel = var1;
   }

   public int getCaiinvB2() {
      return this.caiinvB2;
   }

   public void setCaiinvB2(int var1) {
      this.caiinvB2 = var1;
   }

   public int getCaiinvB2Reel() {
      return this.caiinvB2Reel;
   }

   public void setCaiinvB2Reel(int var1) {
      this.caiinvB2Reel = var1;
   }

   public int getCaiinvB3() {
      return this.caiinvB3;
   }

   public void setCaiinvB3(int var1) {
      this.caiinvB3 = var1;
   }

   public int getCaiinvB3Reel() {
      return this.caiinvB3Reel;
   }

   public void setCaiinvB3Reel(int var1) {
      this.caiinvB3Reel = var1;
   }

   public int getCaiinvB4() {
      return this.caiinvB4;
   }

   public void setCaiinvB4(int var1) {
      this.caiinvB4 = var1;
   }

   public int getCaiinvB4Reel() {
      return this.caiinvB4Reel;
   }

   public void setCaiinvB4Reel(int var1) {
      this.caiinvB4Reel = var1;
   }

   public int getCaiinvB5() {
      return this.caiinvB5;
   }

   public void setCaiinvB5(int var1) {
      this.caiinvB5 = var1;
   }

   public int getCaiinvB5Reel() {
      return this.caiinvB5Reel;
   }

   public void setCaiinvB5Reel(int var1) {
      this.caiinvB5Reel = var1;
   }

   public int getCaiinvB6() {
      return this.caiinvB6;
   }

   public void setCaiinvB6(int var1) {
      this.caiinvB6 = var1;
   }

   public int getCaiinvB6Reel() {
      return this.caiinvB6Reel;
   }

   public void setCaiinvB6Reel(int var1) {
      this.caiinvB6Reel = var1;
   }

   public int getCaiinvB7() {
      return this.caiinvB7;
   }

   public void setCaiinvB7(int var1) {
      this.caiinvB7 = var1;
   }

   public int getCaiinvB7Reel() {
      return this.caiinvB7Reel;
   }

   public void setCaiinvB7Reel(int var1) {
      this.caiinvB7Reel = var1;
   }

   public int getCaiinvB8() {
      return this.caiinvB8;
   }

   public void setCaiinvB8(int var1) {
      this.caiinvB8 = var1;
   }

   public int getCaiinvB8Reel() {
      return this.caiinvB8Reel;
   }

   public void setCaiinvB8Reel(int var1) {
      this.caiinvB8Reel = var1;
   }

   public int getCaiinvB9() {
      return this.caiinvB9;
   }

   public void setCaiinvB9(int var1) {
      this.caiinvB9 = var1;
   }

   public int getCaiinvB9Reel() {
      return this.caiinvB9Reel;
   }

   public void setCaiinvB9Reel(int var1) {
      this.caiinvB9Reel = var1;
   }

   public double getCaiinvBon() {
      return this.caiinvBon;
   }

   public void setCaiinvBon(double var1) {
      this.caiinvBon = var1;
   }

   public double getCaiinvBonReel() {
      return this.caiinvBonReel;
   }

   public void setCaiinvBonReel(double var1) {
      this.caiinvBonReel = var1;
   }

   public String getCaiinvCodeCaisse() {
      return this.caiinvCodeCaisse;
   }

   public void setCaiinvCodeCaisse(String var1) {
      this.caiinvCodeCaisse = var1;
   }

   public String getCaiinvLibCaisse() {
      return this.caiinvLibCaisse;
   }

   public void setCaiinvLibCaisse(String var1) {
      this.caiinvLibCaisse = var1;
   }

   public Date getCaiinvDate() {
      return this.caiinvDate;
   }

   public void setCaiinvDate(Date var1) {
      this.caiinvDate = var1;
   }

   public double getCaiinvDevise1() {
      return this.caiinvDevise1;
   }

   public void setCaiinvDevise1(double var1) {
      this.caiinvDevise1 = var1;
   }

   public double getCaiinvDevise1Reel() {
      return this.caiinvDevise1Reel;
   }

   public void setCaiinvDevise1Reel(double var1) {
      this.caiinvDevise1Reel = var1;
   }

   public double getCaiinvDevise2() {
      return this.caiinvDevise2;
   }

   public void setCaiinvDevise2(double var1) {
      this.caiinvDevise2 = var1;
   }

   public double getCaiinvDevise2Reel() {
      return this.caiinvDevise2Reel;
   }

   public void setCaiinvDevise2Reel(double var1) {
      this.caiinvDevise2Reel = var1;
   }

   public double getCaiinvDevise3() {
      return this.caiinvDevise3;
   }

   public void setCaiinvDevise3(double var1) {
      this.caiinvDevise3 = var1;
   }

   public double getCaiinvDevise3Reel() {
      return this.caiinvDevise3Reel;
   }

   public void setCaiinvDevise3Reel(double var1) {
      this.caiinvDevise3Reel = var1;
   }

   public double getCaiinvDevise4() {
      return this.caiinvDevise4;
   }

   public void setCaiinvDevise4(double var1) {
      this.caiinvDevise4 = var1;
   }

   public double getCaiinvDevise4Reel() {
      return this.caiinvDevise4Reel;
   }

   public void setCaiinvDevise4Reel(double var1) {
      this.caiinvDevise4Reel = var1;
   }

   public double getCaiinvDevise5() {
      return this.caiinvDevise5;
   }

   public void setCaiinvDevise5(double var1) {
      this.caiinvDevise5 = var1;
   }

   public double getCaiinvDevise5Reel() {
      return this.caiinvDevise5Reel;
   }

   public void setCaiinvDevise5Reel(double var1) {
      this.caiinvDevise5Reel = var1;
   }

   public double getCaiinvEcart() {
      return this.caiinvEcart;
   }

   public void setCaiinvEcart(double var1) {
      this.caiinvEcart = var1;
   }

   public double getCaiinvEcartReel() {
      return this.caiinvEcartReel;
   }

   public void setCaiinvEcartReel(double var1) {
      this.caiinvEcartReel = var1;
   }

   public double getCaiinvEspece() {
      return this.caiinvEspece;
   }

   public void setCaiinvEspece(double var1) {
      this.caiinvEspece = var1;
   }

   public double getCaiinvEspeceReel() {
      return this.caiinvEspeceReel;
   }

   public void setCaiinvEspeceReel(double var1) {
      this.caiinvEspeceReel = var1;
   }

   public int getCaiinvEtat() {
      return this.caiinvEtat;
   }

   public void setCaiinvEtat(int var1) {
      this.caiinvEtat = var1;
   }

   public long getCaiinvId() {
      return this.caiinvId;
   }

   public void setCaiinvId(long var1) {
      this.caiinvId = var1;
   }

   public String getCaiinvObservation() {
      return this.caiinvObservation;
   }

   public void setCaiinvObservation(String var1) {
      this.caiinvObservation = var1;
   }

   public int getCaiinvP1() {
      return this.caiinvP1;
   }

   public void setCaiinvP1(int var1) {
      this.caiinvP1 = var1;
   }

   public int getCaiinvP10() {
      return this.caiinvP10;
   }

   public void setCaiinvP10(int var1) {
      this.caiinvP10 = var1;
   }

   public int getCaiinvP10Reel() {
      return this.caiinvP10Reel;
   }

   public void setCaiinvP10Reel(int var1) {
      this.caiinvP10Reel = var1;
   }

   public int getCaiinvP1Reel() {
      return this.caiinvP1Reel;
   }

   public void setCaiinvP1Reel(int var1) {
      this.caiinvP1Reel = var1;
   }

   public int getCaiinvP2() {
      return this.caiinvP2;
   }

   public void setCaiinvP2(int var1) {
      this.caiinvP2 = var1;
   }

   public int getCaiinvP2Reel() {
      return this.caiinvP2Reel;
   }

   public void setCaiinvP2Reel(int var1) {
      this.caiinvP2Reel = var1;
   }

   public int getCaiinvP3() {
      return this.caiinvP3;
   }

   public void setCaiinvP3(int var1) {
      this.caiinvP3 = var1;
   }

   public int getCaiinvP3Reel() {
      return this.caiinvP3Reel;
   }

   public void setCaiinvP3Reel(int var1) {
      this.caiinvP3Reel = var1;
   }

   public int getCaiinvP4() {
      return this.caiinvP4;
   }

   public void setCaiinvP4(int var1) {
      this.caiinvP4 = var1;
   }

   public int getCaiinvP4Reel() {
      return this.caiinvP4Reel;
   }

   public void setCaiinvP4Reel(int var1) {
      this.caiinvP4Reel = var1;
   }

   public int getCaiinvP5() {
      return this.caiinvP5;
   }

   public void setCaiinvP5(int var1) {
      this.caiinvP5 = var1;
   }

   public int getCaiinvP5Reel() {
      return this.caiinvP5Reel;
   }

   public void setCaiinvP5Reel(int var1) {
      this.caiinvP5Reel = var1;
   }

   public int getCaiinvP6() {
      return this.caiinvP6;
   }

   public void setCaiinvP6(int var1) {
      this.caiinvP6 = var1;
   }

   public int getCaiinvP6Reel() {
      return this.caiinvP6Reel;
   }

   public void setCaiinvP6Reel(int var1) {
      this.caiinvP6Reel = var1;
   }

   public int getCaiinvP7() {
      return this.caiinvP7;
   }

   public void setCaiinvP7(int var1) {
      this.caiinvP7 = var1;
   }

   public int getCaiinvP7Reel() {
      return this.caiinvP7Reel;
   }

   public void setCaiinvP7Reel(int var1) {
      this.caiinvP7Reel = var1;
   }

   public int getCaiinvP8() {
      return this.caiinvP8;
   }

   public void setCaiinvP8(int var1) {
      this.caiinvP8 = var1;
   }

   public int getCaiinvP8Reel() {
      return this.caiinvP8Reel;
   }

   public void setCaiinvP8Reel(int var1) {
      this.caiinvP8Reel = var1;
   }

   public int getCaiinvP9() {
      return this.caiinvP9;
   }

   public void setCaiinvP9(int var1) {
      this.caiinvP9 = var1;
   }

   public int getCaiinvP9Reel() {
      return this.caiinvP9Reel;
   }

   public void setCaiinvP9Reel(int var1) {
      this.caiinvP9Reel = var1;
   }

   public String getCaiinvPeriode() {
      return this.caiinvPeriode;
   }

   public void setCaiinvPeriode(String var1) {
      this.caiinvPeriode = var1;
   }

   public double getCaiinvSoldeBonCaisse() {
      return this.caiinvSoldeBonCaisse;
   }

   public void setCaiinvSoldeBonCaisse(double var1) {
      this.caiinvSoldeBonCaisse = var1;
   }

   public double getCaiinvSoldeBonCaisseReel() {
      return this.caiinvSoldeBonCaisseReel;
   }

   public void setCaiinvSoldeBonCaisseReel(double var1) {
      this.caiinvSoldeBonCaisseReel = var1;
   }

   public double getCaiinvSoldeCheque() {
      return this.caiinvSoldeCheque;
   }

   public void setCaiinvSoldeCheque(double var1) {
      this.caiinvSoldeCheque = var1;
   }

   public double getCaiinvSoldeChequeReel() {
      return this.caiinvSoldeChequeReel;
   }

   public void setCaiinvSoldeChequeReel(double var1) {
      this.caiinvSoldeChequeReel = var1;
   }

   public double getCaiinvSoldeCompense() {
      return this.caiinvSoldeCompense;
   }

   public void setCaiinvSoldeCompense(double var1) {
      this.caiinvSoldeCompense = var1;
   }

   public double getCaiinvSoldeCompenseReel() {
      return this.caiinvSoldeCompenseReel;
   }

   public void setCaiinvSoldeCompenseReel(double var1) {
      this.caiinvSoldeCompenseReel = var1;
   }

   public double getCaiinvSoldeCredoc() {
      return this.caiinvSoldeCredoc;
   }

   public void setCaiinvSoldeCredoc(double var1) {
      this.caiinvSoldeCredoc = var1;
   }

   public double getCaiinvSoldeCredocReel() {
      return this.caiinvSoldeCredocReel;
   }

   public void setCaiinvSoldeCredocReel(double var1) {
      this.caiinvSoldeCredocReel = var1;
   }

   public double getCaiinvSoldeEspece() {
      return this.caiinvSoldeEspece;
   }

   public void setCaiinvSoldeEspece(double var1) {
      this.caiinvSoldeEspece = var1;
   }

   public double getCaiinvSoldeEspeceReel() {
      return this.caiinvSoldeEspeceReel;
   }

   public void setCaiinvSoldeEspeceReel(double var1) {
      this.caiinvSoldeEspeceReel = var1;
   }

   public double getCaiinvSoldeFactor() {
      return this.caiinvSoldeFactor;
   }

   public void setCaiinvSoldeFactor(double var1) {
      this.caiinvSoldeFactor = var1;
   }

   public double getCaiinvSoldeFactorReel() {
      return this.caiinvSoldeFactorReel;
   }

   public void setCaiinvSoldeFactorReel(double var1) {
      this.caiinvSoldeFactorReel = var1;
   }

   public double getCaiinvSoldeTerme() {
      return this.caiinvSoldeTerme;
   }

   public void setCaiinvSoldeTerme(double var1) {
      this.caiinvSoldeTerme = var1;
   }

   public double getCaiinvSoldeTermeReel() {
      return this.caiinvSoldeTermeReel;
   }

   public void setCaiinvSoldeTermeReel(double var1) {
      this.caiinvSoldeTermeReel = var1;
   }

   public double getCaiinvSoldeTpe() {
      return this.caiinvSoldeTpe;
   }

   public void setCaiinvSoldeTpe(double var1) {
      this.caiinvSoldeTpe = var1;
   }

   public double getCaiinvSoldeTpeReel() {
      return this.caiinvSoldeTpeReel;
   }

   public void setCaiinvSoldeTpeReel(double var1) {
      this.caiinvSoldeTpeReel = var1;
   }

   public double getCaiinvSoldeTraite() {
      return this.caiinvSoldeTraite;
   }

   public void setCaiinvSoldeTraite(double var1) {
      this.caiinvSoldeTraite = var1;
   }

   public double getCaiinvSoldeTraiteReel() {
      return this.caiinvSoldeTraiteReel;
   }

   public void setCaiinvSoldeTraiteReel(double var1) {
      this.caiinvSoldeTraiteReel = var1;
   }

   public double getCaiinvSoldeTransfert() {
      return this.caiinvSoldeTransfert;
   }

   public void setCaiinvSoldeTransfert(double var1) {
      this.caiinvSoldeTransfert = var1;
   }

   public double getCaiinvSoldeTransfertReel() {
      return this.caiinvSoldeTransfertReel;
   }

   public void setCaiinvSoldeTransfertReel(double var1) {
      this.caiinvSoldeTransfertReel = var1;
   }

   public double getCaiinvSoldeVirement() {
      return this.caiinvSoldeVirement;
   }

   public void setCaiinvSoldeVirement(double var1) {
      this.caiinvSoldeVirement = var1;
   }

   public double getCaiinvSoldeVirementReel() {
      return this.caiinvSoldeVirementReel;
   }

   public void setCaiinvSoldeVirementReel(double var1) {
      this.caiinvSoldeVirementReel = var1;
   }

   public double getCaiinvSoldeePaiement() {
      return this.caiinvSoldeePaiement;
   }

   public void setCaiinvSoldeePaiement(double var1) {
      this.caiinvSoldeePaiement = var1;
   }

   public double getCaiinvSoldeePaiementReel() {
      return this.caiinvSoldeePaiementReel;
   }

   public void setCaiinvSoldeePaiementReel(double var1) {
      this.caiinvSoldeePaiementReel = var1;
   }

   public double getCaiinvTimbre() {
      return this.caiinvTimbre;
   }

   public void setCaiinvTimbre(double var1) {
      this.caiinvTimbre = var1;
   }

   public double getCaiinvTimbreReel() {
      return this.caiinvTimbreReel;
   }

   public void setCaiinvTimbreReel(double var1) {
      this.caiinvTimbreReel = var1;
   }

   public long getCaiinvUserIdCaisse() {
      return this.caiinvUserIdCaisse;
   }

   public void setCaiinvUserIdCaisse(long var1) {
      this.caiinvUserIdCaisse = var1;
   }

   public ExercicesCaisse getExercicesCaisse() {
      return this.exercicesCaisse;
   }

   public void setExercicesCaisse(ExercicesCaisse var1) {
      this.exercicesCaisse = var1;
   }

   public String getCaiinvSerie() {
      return this.caiinvSerie;
   }

   public void setCaiinvSerie(String var1) {
      this.caiinvSerie = var1;
   }

   public Date getCaiinvDateCreation() {
      return this.caiinvDateCreation;
   }

   public void setCaiinvDateCreation(Date var1) {
      this.caiinvDateCreation = var1;
   }

   public Date getCaiinvDateModif() {
      return this.caiinvDateModif;
   }

   public void setCaiinvDateModif(Date var1) {
      this.caiinvDateModif = var1;
   }

   public long getCaiinvUserIdCreation() {
      return this.caiinvUserIdCreation;
   }

   public void setCaiinvUserIdCreation(long var1) {
      this.caiinvUserIdCreation = var1;
   }

   public long getCaiinvUserIdModif() {
      return this.caiinvUserIdModif;
   }

   public void setCaiinvUserIdModif(long var1) {
      this.caiinvUserIdModif = var1;
   }

   public String getCaiinvUserNomCaisse() {
      return this.caiinvUserNomCaisse;
   }

   public void setCaiinvUserNomCaisse(String var1) {
      this.caiinvUserNomCaisse = var1;
   }

   public String getCaiinvNum() {
      return this.caiinvNum;
   }

   public void setCaiinvNum(String var1) {
      this.caiinvNum = var1;
   }

   public Date getCaiinvDateImpression() {
      return this.caiinvDateImpression;
   }

   public void setCaiinvDateImpression(Date var1) {
      this.caiinvDateImpression = var1;
   }

   public String getCaiinvModeleImp() {
      return this.caiinvModeleImp;
   }

   public void setCaiinvModeleImp(String var1) {
      this.caiinvModeleImp = var1;
   }

   public Date getCaiinvDateCtrl() {
      return this.caiinvDateCtrl;
   }

   public void setCaiinvDateCtrl(Date var1) {
      this.caiinvDateCtrl = var1;
   }

   public long getCaiinvCaisseIdCtrl() {
      return this.caiinvCaisseIdCtrl;
   }

   public void setCaiinvCaisseIdCtrl(long var1) {
      this.caiinvCaisseIdCtrl = var1;
   }

   public double getCaiinvAutreEcart() {
      return this.caiinvAutreEcart;
   }

   public void setCaiinvAutreEcart(double var1) {
      this.caiinvAutreEcart = var1;
   }

   public int getCaiinvB10Ecart() {
      return this.caiinvB10Ecart;
   }

   public void setCaiinvB10Ecart(int var1) {
      this.caiinvB10Ecart = var1;
   }

   public int getCaiinvB1Ecart() {
      return this.caiinvB1Ecart;
   }

   public void setCaiinvB1Ecart(int var1) {
      this.caiinvB1Ecart = var1;
   }

   public int getCaiinvB2Ecart() {
      return this.caiinvB2Ecart;
   }

   public void setCaiinvB2Ecart(int var1) {
      this.caiinvB2Ecart = var1;
   }

   public int getCaiinvB3Ecart() {
      return this.caiinvB3Ecart;
   }

   public void setCaiinvB3Ecart(int var1) {
      this.caiinvB3Ecart = var1;
   }

   public int getCaiinvB4Ecart() {
      return this.caiinvB4Ecart;
   }

   public void setCaiinvB4Ecart(int var1) {
      this.caiinvB4Ecart = var1;
   }

   public int getCaiinvB5Ecart() {
      return this.caiinvB5Ecart;
   }

   public void setCaiinvB5Ecart(int var1) {
      this.caiinvB5Ecart = var1;
   }

   public int getCaiinvB6Ecart() {
      return this.caiinvB6Ecart;
   }

   public void setCaiinvB6Ecart(int var1) {
      this.caiinvB6Ecart = var1;
   }

   public int getCaiinvB7Ecart() {
      return this.caiinvB7Ecart;
   }

   public void setCaiinvB7Ecart(int var1) {
      this.caiinvB7Ecart = var1;
   }

   public int getCaiinvB8Ecart() {
      return this.caiinvB8Ecart;
   }

   public void setCaiinvB8Ecart(int var1) {
      this.caiinvB8Ecart = var1;
   }

   public int getCaiinvB9Ecart() {
      return this.caiinvB9Ecart;
   }

   public void setCaiinvB9Ecart(int var1) {
      this.caiinvB9Ecart = var1;
   }

   public double getCaiinvBonEcart() {
      return this.caiinvBonEcart;
   }

   public void setCaiinvBonEcart(double var1) {
      this.caiinvBonEcart = var1;
   }

   public double getCaiinvDevise1Ecart() {
      return this.caiinvDevise1Ecart;
   }

   public void setCaiinvDevise1Ecart(double var1) {
      this.caiinvDevise1Ecart = var1;
   }

   public double getCaiinvDevise2Ecart() {
      return this.caiinvDevise2Ecart;
   }

   public void setCaiinvDevise2Ecart(double var1) {
      this.caiinvDevise2Ecart = var1;
   }

   public double getCaiinvDevise3Ecart() {
      return this.caiinvDevise3Ecart;
   }

   public void setCaiinvDevise3Ecart(double var1) {
      this.caiinvDevise3Ecart = var1;
   }

   public double getCaiinvDevise4Ecart() {
      return this.caiinvDevise4Ecart;
   }

   public void setCaiinvDevise4Ecart(double var1) {
      this.caiinvDevise4Ecart = var1;
   }

   public double getCaiinvDevise5Ecart() {
      return this.caiinvDevise5Ecart;
   }

   public void setCaiinvDevise5Ecart(double var1) {
      this.caiinvDevise5Ecart = var1;
   }

   public double getCaiinvEcartEcart() {
      return this.caiinvEcartEcart;
   }

   public void setCaiinvEcartEcart(double var1) {
      this.caiinvEcartEcart = var1;
   }

   public double getCaiinvEspeceEcart() {
      return this.caiinvEspeceEcart;
   }

   public void setCaiinvEspeceEcart(double var1) {
      this.caiinvEspeceEcart = var1;
   }

   public int getCaiinvP10Ecart() {
      return this.caiinvP10Ecart;
   }

   public void setCaiinvP10Ecart(int var1) {
      this.caiinvP10Ecart = var1;
   }

   public int getCaiinvP1Ecart() {
      return this.caiinvP1Ecart;
   }

   public void setCaiinvP1Ecart(int var1) {
      this.caiinvP1Ecart = var1;
   }

   public int getCaiinvP2Ecart() {
      return this.caiinvP2Ecart;
   }

   public void setCaiinvP2Ecart(int var1) {
      this.caiinvP2Ecart = var1;
   }

   public int getCaiinvP3Ecart() {
      return this.caiinvP3Ecart;
   }

   public void setCaiinvP3Ecart(int var1) {
      this.caiinvP3Ecart = var1;
   }

   public int getCaiinvP4Ecart() {
      return this.caiinvP4Ecart;
   }

   public void setCaiinvP4Ecart(int var1) {
      this.caiinvP4Ecart = var1;
   }

   public int getCaiinvP5Ecart() {
      return this.caiinvP5Ecart;
   }

   public void setCaiinvP5Ecart(int var1) {
      this.caiinvP5Ecart = var1;
   }

   public int getCaiinvP6Ecart() {
      return this.caiinvP6Ecart;
   }

   public void setCaiinvP6Ecart(int var1) {
      this.caiinvP6Ecart = var1;
   }

   public int getCaiinvP7Ecart() {
      return this.caiinvP7Ecart;
   }

   public void setCaiinvP7Ecart(int var1) {
      this.caiinvP7Ecart = var1;
   }

   public int getCaiinvP8Ecart() {
      return this.caiinvP8Ecart;
   }

   public void setCaiinvP8Ecart(int var1) {
      this.caiinvP8Ecart = var1;
   }

   public int getCaiinvP9Ecart() {
      return this.caiinvP9Ecart;
   }

   public void setCaiinvP9Ecart(int var1) {
      this.caiinvP9Ecart = var1;
   }

   public double getCaiinvSoldeBonCaisseEcart() {
      return this.caiinvSoldeBonCaisseEcart;
   }

   public void setCaiinvSoldeBonCaisseEcart(double var1) {
      this.caiinvSoldeBonCaisseEcart = var1;
   }

   public double getCaiinvSoldeChequeEcart() {
      return this.caiinvSoldeChequeEcart;
   }

   public void setCaiinvSoldeChequeEcart(double var1) {
      this.caiinvSoldeChequeEcart = var1;
   }

   public double getCaiinvSoldeCompenseEcart() {
      return this.caiinvSoldeCompenseEcart;
   }

   public void setCaiinvSoldeCompenseEcart(double var1) {
      this.caiinvSoldeCompenseEcart = var1;
   }

   public double getCaiinvSoldeCredocEcart() {
      return this.caiinvSoldeCredocEcart;
   }

   public void setCaiinvSoldeCredocEcart(double var1) {
      this.caiinvSoldeCredocEcart = var1;
   }

   public double getCaiinvSoldeEspeceEcart() {
      return this.caiinvSoldeEspeceEcart;
   }

   public void setCaiinvSoldeEspeceEcart(double var1) {
      this.caiinvSoldeEspeceEcart = var1;
   }

   public double getCaiinvSoldeFactorEcart() {
      return this.caiinvSoldeFactorEcart;
   }

   public void setCaiinvSoldeFactorEcart(double var1) {
      this.caiinvSoldeFactorEcart = var1;
   }

   public double getCaiinvSoldeTermeEcart() {
      return this.caiinvSoldeTermeEcart;
   }

   public void setCaiinvSoldeTermeEcart(double var1) {
      this.caiinvSoldeTermeEcart = var1;
   }

   public double getCaiinvSoldeTpeEcart() {
      return this.caiinvSoldeTpeEcart;
   }

   public void setCaiinvSoldeTpeEcart(double var1) {
      this.caiinvSoldeTpeEcart = var1;
   }

   public double getCaiinvSoldeTraiteEcart() {
      return this.caiinvSoldeTraiteEcart;
   }

   public void setCaiinvSoldeTraiteEcart(double var1) {
      this.caiinvSoldeTraiteEcart = var1;
   }

   public double getCaiinvSoldeTransfertEcart() {
      return this.caiinvSoldeTransfertEcart;
   }

   public void setCaiinvSoldeTransfertEcart(double var1) {
      this.caiinvSoldeTransfertEcart = var1;
   }

   public double getCaiinvSoldeVirementEcart() {
      return this.caiinvSoldeVirementEcart;
   }

   public void setCaiinvSoldeVirementEcart(double var1) {
      this.caiinvSoldeVirementEcart = var1;
   }

   public double getCaiinvSoldeePaiementEcart() {
      return this.caiinvSoldeePaiementEcart;
   }

   public void setCaiinvSoldeePaiementEcart(double var1) {
      this.caiinvSoldeePaiementEcart = var1;
   }

   public double getCaiinvTimbreEcart() {
      return this.caiinvTimbreEcart;
   }

   public void setCaiinvTimbreEcart(double var1) {
      this.caiinvTimbreEcart = var1;
   }
}
