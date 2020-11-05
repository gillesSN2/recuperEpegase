package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BudgetTresorerie implements Serializable {
   private long bud_id;
   private Date budDateModif;
   private Date budDateCreat;
   private long budUserCreat;
   private long budUserModif;
   private String budProjet;
   private String budAnnee;
   private String budCode;
   private String budLibelleFr;
   private String budLibelleUk;
   private String budLibelleSp;
   private int budSens;
   private int budUtil;
   private double bud01TotVal;
   private double bud02TotVal;
   private double bud03TotVal;
   private double bud04TotVal;
   private double bud01R1Val;
   private double bud02R1Val;
   private double bud03R1Val;
   private double bud04R1Val;
   private double bud05R1Val;
   private double bud06R1Val;
   private double bud07R1Val;
   private double bud08R1Val;
   private double bud09R1Val;
   private double bud10R1Val;
   private double bud11R1Val;
   private double bud12R1Val;
   private double bud01R2Val;
   private double bud02R2Val;
   private double bud03R2Val;
   private double bud04R2Val;
   private double bud05R2Val;
   private double bud06R2Val;
   private double bud07R2Val;
   private double bud08R2Val;
   private double bud09R2Val;
   private double bud10R2Val;
   private double bud11R2Val;
   private double bud12R2Val;
   private double bud01R3Val;
   private double bud02R3Val;
   private double bud03R3Val;
   private double bud04R3Val;
   private double bud05R3Val;
   private double bud06R3Val;
   private double bud07R3Val;
   private double bud08R3Val;
   private double bud09R3Val;
   private double bud10R3Val;
   private double bud11R3Val;
   private double bud12R3Val;
   private double bud01R4Val;
   private double bud02R4Val;
   private double bud03R4Val;
   private double bud04R4Val;
   private double bud05R4Val;
   private double bud06R4Val;
   private double bud07R4Val;
   private double bud08R4Val;
   private double bud09R4Val;
   private double bud10R4Val;
   private double bud11R4Val;
   private double bud12R4Val;
   private ExercicesComptable exercicescomptable;
   private double montant;
   private double varBudget;
   private double varRealise;
   private double varEcart;
   private double varPourcentage;
   private String lib_reamenagement;
   private int choixReam;
   private String espaceFamille;
   private String espaceFamilleLight;
   private String ecrCode;
   private Date ecrDateSaisie;
   private String ecrPeriode;
   private String ecrCompte;
   private String ecrLibCompte;
   private int ecrNature;
   private String ecrContrePartie;
   private String ecrDeviseSaisie;
   private double ecrDebitSaisie;
   private double ecrCreditSaisie;
   private float ecrCoefEuro;
   private double ecrDebitEuro;
   private double ecrCreditEuro;
   private String ecrDevisePays;
   private float ecrCoefPays;
   private double ecrDebitPays;
   private double ecrCreditPays;
   private String ecrDeviseGrp;
   private float ecrCoefGrp;
   private double ecrDebitGrp;
   private double ecrCreditGrp;
   private String ecrLettrage;
   private String ecrPointage;
   private String ecrRapprochement;
   private int ecrCloture;
   private Date ecrDateEcheance;
   private int ecrOrigineBanque;
   private Date ecrDateValeurTheo;
   private Date ecrDateValeurReelle;
   private String ecrLibelle;
   private String ecrPiece;
   private String ecrNumTrf;
   private String ecrReference1;
   private String ecrReference2;
   private String ecrTreso;
   private Date ecrDatePaiement;
   private String ecrNumIf;
   private long ecrOrdre;
   private int ecrNatureJrx;
   private int ecrReserve;
   private int ecrAnaActif;
   private int ecrEtat;
   private String ecrBudgetTreso;
   private String ecrPosteTreso;

   public String getEspaceFamille() {
      if (this.budSens != 2 && this.budSens != 20) {
         if (this.budSens == 21) {
            this.espaceFamille = "font-weight:bold;font-style: italic;";
         } else if (this.budSens == 22) {
            this.espaceFamille = "font-weight:bold;font-style: italic;";
         } else if (this.budSens != 3 && this.budSens != 4) {
            this.espaceFamille = "width:100%;";
         } else {
            this.espaceFamille = "font-style: italic;";
         }
      } else {
         this.espaceFamille = "font-weight:bold;";
      }

      if (this.budSens != 20) {
         if (this.budSens == 21) {
            this.espaceFamille = this.espaceFamille + "margin-left:20px;";
         } else if (this.budSens == 22) {
            this.espaceFamille = this.espaceFamille + "margin-left:40px;";
         }
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public String getEspaceFamilleLight() {
      if (this.budSens != 2 && this.budSens != 20) {
         if (this.budSens == 21) {
            this.espaceFamilleLight = "font-weight:bold;font-style: italic;";
         } else if (this.budSens == 22) {
            this.espaceFamilleLight = "font-weight:bold;font-style: italic;";
         } else if (this.budSens != 3 && this.budSens != 4) {
            this.espaceFamilleLight = "width:100%;";
         } else {
            this.espaceFamilleLight = "font-style: italic;";
         }
      } else {
         this.espaceFamilleLight = "font-weight:bold;";
      }

      return this.espaceFamilleLight;
   }

   public void setEspaceFamilleLight(String var1) {
      this.espaceFamilleLight = var1;
   }

   public ExercicesComptable getExercicescomptable() {
      return this.exercicescomptable;
   }

   public double getMontant() {
      if (this.choixReam == 0) {
         this.montant = this.bud01TotVal;
      } else if (this.choixReam == 1) {
         this.montant = this.bud02TotVal;
      } else if (this.choixReam == 2) {
         this.montant = this.bud03TotVal;
      } else if (this.choixReam == 3) {
         this.montant = this.bud04TotVal;
      }

      return this.montant;
   }

   public void setMontant(double var1) {
      this.montant = var1;
   }

   public double getVarBudget() {
      return this.varBudget;
   }

   public void setVarBudget(double var1) {
      this.varBudget = var1;
   }

   public double getVarEcart() {
      this.varEcart = this.varBudget - this.varRealise;
      return this.varEcart;
   }

   public void setVarEcart(double var1) {
      this.varEcart = var1;
   }

   public double getVarPourcentage() {
      if (this.varBudget != 0.0D) {
         this.varPourcentage = this.varRealise / this.varBudget * 100.0D;
      } else {
         this.varPourcentage = 0.0D;
      }

      return this.varPourcentage;
   }

   public void setVarPourcentage(double var1) {
      this.varPourcentage = var1;
   }

   public double getVarRealise() {
      return this.varRealise;
   }

   public void setVarRealise(double var1) {
      this.varRealise = var1;
   }

   public String getLib_reamenagement() {
      if (this.budUtil == 0) {
         this.lib_reamenagement = "Budget initial";
      } else if (this.budUtil == 1) {
         this.lib_reamenagement = "Réaménagement N° 1";
      } else if (this.budUtil == 2) {
         this.lib_reamenagement = "Réaménagement N° 2";
      } else if (this.budUtil == 3) {
         this.lib_reamenagement = "Réaménagement N° 3";
      }

      return this.lib_reamenagement;
   }

   public void setLib_reamenagement(String var1) {
      this.lib_reamenagement = var1;
   }

   public void setExercicescomptable(ExercicesComptable var1) {
      this.exercicescomptable = var1;
   }

   public double getBud01R1Val() {
      return this.bud01R1Val;
   }

   public void setBud01R1Val(double var1) {
      this.bud01R1Val = var1;
   }

   public double getBud01R2Val() {
      return this.bud01R2Val;
   }

   public void setBud01R2Val(double var1) {
      this.bud01R2Val = var1;
   }

   public double getBud01R3Val() {
      return this.bud01R3Val;
   }

   public void setBud01R3Val(double var1) {
      this.bud01R3Val = var1;
   }

   public double getBud01R4Val() {
      return this.bud01R4Val;
   }

   public void setBud01R4Val(double var1) {
      this.bud01R4Val = var1;
   }

   public double getBud01TotVal() {
      return this.bud01TotVal;
   }

   public void setBud01TotVal(double var1) {
      this.bud01TotVal = var1;
   }

   public double getBud02R1Val() {
      return this.bud02R1Val;
   }

   public void setBud02R1Val(double var1) {
      this.bud02R1Val = var1;
   }

   public double getBud02R2Val() {
      return this.bud02R2Val;
   }

   public void setBud02R2Val(double var1) {
      this.bud02R2Val = var1;
   }

   public double getBud02R3Val() {
      return this.bud02R3Val;
   }

   public void setBud02R3Val(double var1) {
      this.bud02R3Val = var1;
   }

   public double getBud02R4Val() {
      return this.bud02R4Val;
   }

   public void setBud02R4Val(double var1) {
      this.bud02R4Val = var1;
   }

   public double getBud02TotVal() {
      return this.bud02TotVal;
   }

   public void setBud02TotVal(double var1) {
      this.bud02TotVal = var1;
   }

   public double getBud03R1Val() {
      return this.bud03R1Val;
   }

   public void setBud03R1Val(double var1) {
      this.bud03R1Val = var1;
   }

   public double getBud03R2Val() {
      return this.bud03R2Val;
   }

   public void setBud03R2Val(double var1) {
      this.bud03R2Val = var1;
   }

   public double getBud03R3Val() {
      return this.bud03R3Val;
   }

   public void setBud03R3Val(double var1) {
      this.bud03R3Val = var1;
   }

   public double getBud03R4Val() {
      return this.bud03R4Val;
   }

   public void setBud03R4Val(double var1) {
      this.bud03R4Val = var1;
   }

   public double getBud03TotVal() {
      return this.bud03TotVal;
   }

   public void setBud03TotVal(double var1) {
      this.bud03TotVal = var1;
   }

   public double getBud04R1Val() {
      return this.bud04R1Val;
   }

   public void setBud04R1Val(double var1) {
      this.bud04R1Val = var1;
   }

   public double getBud04R2Val() {
      return this.bud04R2Val;
   }

   public void setBud04R2Val(double var1) {
      this.bud04R2Val = var1;
   }

   public double getBud04R3Val() {
      return this.bud04R3Val;
   }

   public void setBud04R3Val(double var1) {
      this.bud04R3Val = var1;
   }

   public double getBud04R4Val() {
      return this.bud04R4Val;
   }

   public void setBud04R4Val(double var1) {
      this.bud04R4Val = var1;
   }

   public double getBud04TotVal() {
      return this.bud04TotVal;
   }

   public void setBud04TotVal(double var1) {
      this.bud04TotVal = var1;
   }

   public double getBud05R1Val() {
      return this.bud05R1Val;
   }

   public void setBud05R1Val(double var1) {
      this.bud05R1Val = var1;
   }

   public double getBud05R2Val() {
      return this.bud05R2Val;
   }

   public void setBud05R2Val(double var1) {
      this.bud05R2Val = var1;
   }

   public double getBud05R3Val() {
      return this.bud05R3Val;
   }

   public void setBud05R3Val(double var1) {
      this.bud05R3Val = var1;
   }

   public double getBud05R4Val() {
      return this.bud05R4Val;
   }

   public void setBud05R4Val(double var1) {
      this.bud05R4Val = var1;
   }

   public double getBud06R1Val() {
      return this.bud06R1Val;
   }

   public void setBud06R1Val(double var1) {
      this.bud06R1Val = var1;
   }

   public double getBud06R2Val() {
      return this.bud06R2Val;
   }

   public void setBud06R2Val(double var1) {
      this.bud06R2Val = var1;
   }

   public double getBud06R3Val() {
      return this.bud06R3Val;
   }

   public void setBud06R3Val(double var1) {
      this.bud06R3Val = var1;
   }

   public double getBud06R4Val() {
      return this.bud06R4Val;
   }

   public void setBud06R4Val(double var1) {
      this.bud06R4Val = var1;
   }

   public double getBud07R1Val() {
      return this.bud07R1Val;
   }

   public void setBud07R1Val(double var1) {
      this.bud07R1Val = var1;
   }

   public double getBud07R2Val() {
      return this.bud07R2Val;
   }

   public void setBud07R2Val(double var1) {
      this.bud07R2Val = var1;
   }

   public double getBud07R3Val() {
      return this.bud07R3Val;
   }

   public void setBud07R3Val(double var1) {
      this.bud07R3Val = var1;
   }

   public double getBud07R4Val() {
      return this.bud07R4Val;
   }

   public void setBud07R4Val(double var1) {
      this.bud07R4Val = var1;
   }

   public double getBud08R1Val() {
      return this.bud08R1Val;
   }

   public void setBud08R1Val(double var1) {
      this.bud08R1Val = var1;
   }

   public double getBud08R2Val() {
      return this.bud08R2Val;
   }

   public void setBud08R2Val(double var1) {
      this.bud08R2Val = var1;
   }

   public double getBud08R3Val() {
      return this.bud08R3Val;
   }

   public void setBud08R3Val(double var1) {
      this.bud08R3Val = var1;
   }

   public double getBud08R4Val() {
      return this.bud08R4Val;
   }

   public void setBud08R4Val(double var1) {
      this.bud08R4Val = var1;
   }

   public double getBud09R1Val() {
      return this.bud09R1Val;
   }

   public void setBud09R1Val(double var1) {
      this.bud09R1Val = var1;
   }

   public double getBud09R2Val() {
      return this.bud09R2Val;
   }

   public void setBud09R2Val(double var1) {
      this.bud09R2Val = var1;
   }

   public double getBud09R3Val() {
      return this.bud09R3Val;
   }

   public void setBud09R3Val(double var1) {
      this.bud09R3Val = var1;
   }

   public double getBud09R4Val() {
      return this.bud09R4Val;
   }

   public void setBud09R4Val(double var1) {
      this.bud09R4Val = var1;
   }

   public double getBud10R1Val() {
      return this.bud10R1Val;
   }

   public void setBud10R1Val(double var1) {
      this.bud10R1Val = var1;
   }

   public double getBud10R2Val() {
      return this.bud10R2Val;
   }

   public void setBud10R2Val(double var1) {
      this.bud10R2Val = var1;
   }

   public double getBud10R3Val() {
      return this.bud10R3Val;
   }

   public void setBud10R3Val(double var1) {
      this.bud10R3Val = var1;
   }

   public double getBud10R4Val() {
      return this.bud10R4Val;
   }

   public void setBud10R4Val(double var1) {
      this.bud10R4Val = var1;
   }

   public double getBud11R1Val() {
      return this.bud11R1Val;
   }

   public void setBud11R1Val(double var1) {
      this.bud11R1Val = var1;
   }

   public double getBud11R2Val() {
      return this.bud11R2Val;
   }

   public void setBud11R2Val(double var1) {
      this.bud11R2Val = var1;
   }

   public double getBud11R3Val() {
      return this.bud11R3Val;
   }

   public void setBud11R3Val(double var1) {
      this.bud11R3Val = var1;
   }

   public double getBud11R4Val() {
      return this.bud11R4Val;
   }

   public void setBud11R4Val(double var1) {
      this.bud11R4Val = var1;
   }

   public double getBud12R1Val() {
      return this.bud12R1Val;
   }

   public void setBud12R1Val(double var1) {
      this.bud12R1Val = var1;
   }

   public double getBud12R2Val() {
      return this.bud12R2Val;
   }

   public void setBud12R2Val(double var1) {
      this.bud12R2Val = var1;
   }

   public double getBud12R3Val() {
      return this.bud12R3Val;
   }

   public void setBud12R3Val(double var1) {
      this.bud12R3Val = var1;
   }

   public double getBud12R4Val() {
      return this.bud12R4Val;
   }

   public void setBud12R4Val(double var1) {
      this.bud12R4Val = var1;
   }

   public String getBudAnnee() {
      return this.budAnnee;
   }

   public void setBudAnnee(String var1) {
      this.budAnnee = var1;
   }

   public String getBudCode() {
      return this.budCode;
   }

   public void setBudCode(String var1) {
      this.budCode = var1;
   }

   public Date getBudDateCreat() {
      return this.budDateCreat;
   }

   public void setBudDateCreat(Date var1) {
      this.budDateCreat = var1;
   }

   public Date getBudDateModif() {
      return this.budDateModif;
   }

   public void setBudDateModif(Date var1) {
      this.budDateModif = var1;
   }

   public String getBudLibelleFr() {
      return this.budLibelleFr;
   }

   public void setBudLibelleFr(String var1) {
      this.budLibelleFr = var1;
   }

   public String getBudLibelleSp() {
      return this.budLibelleSp;
   }

   public void setBudLibelleSp(String var1) {
      this.budLibelleSp = var1;
   }

   public String getBudLibelleUk() {
      return this.budLibelleUk;
   }

   public void setBudLibelleUk(String var1) {
      this.budLibelleUk = var1;
   }

   public String getBudProjet() {
      return this.budProjet;
   }

   public void setBudProjet(String var1) {
      this.budProjet = var1;
   }

   public int getBudSens() {
      return this.budSens;
   }

   public void setBudSens(int var1) {
      this.budSens = var1;
   }

   public long getBudUserCreat() {
      return this.budUserCreat;
   }

   public void setBudUserCreat(long var1) {
      this.budUserCreat = var1;
   }

   public long getBudUserModif() {
      return this.budUserModif;
   }

   public void setBudUserModif(long var1) {
      this.budUserModif = var1;
   }

   public int getBudUtil() {
      return this.budUtil;
   }

   public void setBudUtil(int var1) {
      this.budUtil = var1;
   }

   public long getBud_id() {
      return this.bud_id;
   }

   public void setBud_id(long var1) {
      this.bud_id = var1;
   }

   public int getChoixReam() {
      return this.choixReam;
   }

   public void setChoixReam(int var1) {
      this.choixReam = var1;
   }

   public int getEcrAnaActif() {
      return this.ecrAnaActif;
   }

   public void setEcrAnaActif(int var1) {
      this.ecrAnaActif = var1;
   }

   public String getEcrBudgetTreso() {
      return this.ecrBudgetTreso;
   }

   public void setEcrBudgetTreso(String var1) {
      this.ecrBudgetTreso = var1;
   }

   public int getEcrCloture() {
      return this.ecrCloture;
   }

   public void setEcrCloture(int var1) {
      this.ecrCloture = var1;
   }

   public String getEcrCode() {
      return this.ecrCode;
   }

   public void setEcrCode(String var1) {
      this.ecrCode = var1;
   }

   public float getEcrCoefEuro() {
      return this.ecrCoefEuro;
   }

   public void setEcrCoefEuro(float var1) {
      this.ecrCoefEuro = var1;
   }

   public float getEcrCoefGrp() {
      return this.ecrCoefGrp;
   }

   public void setEcrCoefGrp(float var1) {
      this.ecrCoefGrp = var1;
   }

   public float getEcrCoefPays() {
      return this.ecrCoefPays;
   }

   public void setEcrCoefPays(float var1) {
      this.ecrCoefPays = var1;
   }

   public String getEcrCompte() {
      return this.ecrCompte;
   }

   public void setEcrCompte(String var1) {
      this.ecrCompte = var1;
   }

   public String getEcrContrePartie() {
      return this.ecrContrePartie;
   }

   public void setEcrContrePartie(String var1) {
      this.ecrContrePartie = var1;
   }

   public double getEcrCreditEuro() {
      return this.ecrCreditEuro;
   }

   public void setEcrCreditEuro(double var1) {
      this.ecrCreditEuro = var1;
   }

   public double getEcrCreditGrp() {
      return this.ecrCreditGrp;
   }

   public void setEcrCreditGrp(double var1) {
      this.ecrCreditGrp = var1;
   }

   public double getEcrCreditPays() {
      return this.ecrCreditPays;
   }

   public void setEcrCreditPays(double var1) {
      this.ecrCreditPays = var1;
   }

   public double getEcrCreditSaisie() {
      return this.ecrCreditSaisie;
   }

   public void setEcrCreditSaisie(double var1) {
      this.ecrCreditSaisie = var1;
   }

   public Date getEcrDateEcheance() {
      return this.ecrDateEcheance;
   }

   public void setEcrDateEcheance(Date var1) {
      this.ecrDateEcheance = var1;
   }

   public Date getEcrDatePaiement() {
      return this.ecrDatePaiement;
   }

   public void setEcrDatePaiement(Date var1) {
      this.ecrDatePaiement = var1;
   }

   public Date getEcrDateSaisie() {
      return this.ecrDateSaisie;
   }

   public void setEcrDateSaisie(Date var1) {
      this.ecrDateSaisie = var1;
   }

   public Date getEcrDateValeurReelle() {
      return this.ecrDateValeurReelle;
   }

   public void setEcrDateValeurReelle(Date var1) {
      this.ecrDateValeurReelle = var1;
   }

   public Date getEcrDateValeurTheo() {
      return this.ecrDateValeurTheo;
   }

   public void setEcrDateValeurTheo(Date var1) {
      this.ecrDateValeurTheo = var1;
   }

   public double getEcrDebitEuro() {
      return this.ecrDebitEuro;
   }

   public void setEcrDebitEuro(double var1) {
      this.ecrDebitEuro = var1;
   }

   public double getEcrDebitGrp() {
      return this.ecrDebitGrp;
   }

   public void setEcrDebitGrp(double var1) {
      this.ecrDebitGrp = var1;
   }

   public double getEcrDebitPays() {
      return this.ecrDebitPays;
   }

   public void setEcrDebitPays(double var1) {
      this.ecrDebitPays = var1;
   }

   public double getEcrDebitSaisie() {
      return this.ecrDebitSaisie;
   }

   public void setEcrDebitSaisie(double var1) {
      this.ecrDebitSaisie = var1;
   }

   public String getEcrDeviseGrp() {
      return this.ecrDeviseGrp;
   }

   public void setEcrDeviseGrp(String var1) {
      this.ecrDeviseGrp = var1;
   }

   public String getEcrDevisePays() {
      return this.ecrDevisePays;
   }

   public void setEcrDevisePays(String var1) {
      this.ecrDevisePays = var1;
   }

   public String getEcrDeviseSaisie() {
      return this.ecrDeviseSaisie;
   }

   public void setEcrDeviseSaisie(String var1) {
      this.ecrDeviseSaisie = var1;
   }

   public int getEcrEtat() {
      return this.ecrEtat;
   }

   public void setEcrEtat(int var1) {
      this.ecrEtat = var1;
   }

   public String getEcrLettrage() {
      return this.ecrLettrage;
   }

   public void setEcrLettrage(String var1) {
      this.ecrLettrage = var1;
   }

   public String getEcrLibCompte() {
      return this.ecrLibCompte;
   }

   public void setEcrLibCompte(String var1) {
      this.ecrLibCompte = var1;
   }

   public String getEcrLibelle() {
      return this.ecrLibelle;
   }

   public void setEcrLibelle(String var1) {
      this.ecrLibelle = var1;
   }

   public int getEcrNature() {
      return this.ecrNature;
   }

   public void setEcrNature(int var1) {
      this.ecrNature = var1;
   }

   public int getEcrNatureJrx() {
      return this.ecrNatureJrx;
   }

   public void setEcrNatureJrx(int var1) {
      this.ecrNatureJrx = var1;
   }

   public String getEcrNumIf() {
      return this.ecrNumIf;
   }

   public void setEcrNumIf(String var1) {
      this.ecrNumIf = var1;
   }

   public String getEcrNumTrf() {
      return this.ecrNumTrf;
   }

   public void setEcrNumTrf(String var1) {
      this.ecrNumTrf = var1;
   }

   public long getEcrOrdre() {
      return this.ecrOrdre;
   }

   public void setEcrOrdre(long var1) {
      this.ecrOrdre = var1;
   }

   public int getEcrOrigineBanque() {
      return this.ecrOrigineBanque;
   }

   public void setEcrOrigineBanque(int var1) {
      this.ecrOrigineBanque = var1;
   }

   public String getEcrPeriode() {
      return this.ecrPeriode;
   }

   public void setEcrPeriode(String var1) {
      this.ecrPeriode = var1;
   }

   public String getEcrPiece() {
      return this.ecrPiece;
   }

   public void setEcrPiece(String var1) {
      this.ecrPiece = var1;
   }

   public String getEcrPointage() {
      return this.ecrPointage;
   }

   public void setEcrPointage(String var1) {
      this.ecrPointage = var1;
   }

   public String getEcrPosteTreso() {
      return this.ecrPosteTreso;
   }

   public void setEcrPosteTreso(String var1) {
      this.ecrPosteTreso = var1;
   }

   public String getEcrRapprochement() {
      return this.ecrRapprochement;
   }

   public void setEcrRapprochement(String var1) {
      this.ecrRapprochement = var1;
   }

   public String getEcrReference1() {
      return this.ecrReference1;
   }

   public void setEcrReference1(String var1) {
      this.ecrReference1 = var1;
   }

   public String getEcrReference2() {
      return this.ecrReference2;
   }

   public void setEcrReference2(String var1) {
      this.ecrReference2 = var1;
   }

   public int getEcrReserve() {
      return this.ecrReserve;
   }

   public void setEcrReserve(int var1) {
      this.ecrReserve = var1;
   }

   public String getEcrTreso() {
      return this.ecrTreso;
   }

   public void setEcrTreso(String var1) {
      this.ecrTreso = var1;
   }
}
