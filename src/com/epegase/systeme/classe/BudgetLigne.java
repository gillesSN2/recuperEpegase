package com.epegase.systeme.classe;

import java.io.Serializable;

public class BudgetLigne implements Serializable {
   private long budlig_id;
   private String budligCode;
   private int budligUtil;
   private int budligAxe;
   private double budligMontantSaisie;
   private float budligQteSaisie;
   private float budligPourcentSaisie;
   private String budligActivite;
   private String budligLibActivite;
   private String budligAnal1;
   private String budligLibAnal1;
   private String budligAnal2;
   private String budligLibAnal2;
   private String budligAnal3;
   private String budligLibAnal3;
   private String budligAnal4;
   private String budligLibAnal4;
   private String budligSite;
   private String budligSiteLib;
   private String budligDepartement;
   private String budligDepartementLib;
   private String budligService;
   private String budligServiceLib;
   private String budligRegion;
   private String budligRegionLib;
   private String budligSecteur;
   private String budligSecteurLib;
   private String budligPdv;
   private String budligPdvLib;
   private String budligLigne;
   private String budligLigneLib;
   private String budligAtelier;
   private String budligAtelierLib;
   private String budligAgent;
   private String budligAgentLib;
   private String budligStr;
   private String budligStrLib;
   private String budligStrCle;
   private String budligRepCle;
   private int budligTypeCle;
   private String budligProjet;
   private String budligProjetLib;
   private String budligEntite;
   private String budligEntiteLib;
   private String budligPoste;
   private String budligPosteLib;
   private double budlig01TotVal;
   private double budlig02TotVal;
   private double budlig03TotVal;
   private double budlig04TotVal;
   private double budlig01R1Val;
   private double budlig02R1Val;
   private double budlig03R1Val;
   private double budlig04R1Val;
   private double budlig05R1Val;
   private double budlig06R1Val;
   private double budlig07R1Val;
   private double budlig08R1Val;
   private double budlig09R1Val;
   private double budlig10R1Val;
   private double budlig11R1Val;
   private double budlig12R1Val;
   private double budlig01R2Val;
   private double budlig02R2Val;
   private double budlig03R2Val;
   private double budlig04R2Val;
   private double budlig05R2Val;
   private double budlig06R2Val;
   private double budlig07R2Val;
   private double budlig08R2Val;
   private double budlig09R2Val;
   private double budlig10R2Val;
   private double budlig11R2Val;
   private double budlig12R2Val;
   private double budlig01R3Val;
   private double budlig02R3Val;
   private double budlig03R3Val;
   private double budlig04R3Val;
   private double budlig05R3Val;
   private double budlig06R3Val;
   private double budlig07R3Val;
   private double budlig08R3Val;
   private double budlig09R3Val;
   private double budlig10R3Val;
   private double budlig11R3Val;
   private double budlig12R3Val;
   private double budlig01R4Val;
   private double budlig02R4Val;
   private double budlig03R4Val;
   private double budlig04R4Val;
   private double budlig05R4Val;
   private double budlig06R4Val;
   private double budlig07R4Val;
   private double budlig08R4Val;
   private double budlig09R4Val;
   private double budlig10R4Val;
   private double budlig11R4Val;
   private double budlig12R4Val;
   private float budlig01TotQte;
   private float budlig02TotQte;
   private float budlig03TotQte;
   private float budlig04TotQte;
   private float budlig01R1Qte;
   private float budlig02R1Qte;
   private float budlig03R1Qte;
   private float budlig04R1Qte;
   private float budlig05R1Qte;
   private float budlig06R1Qte;
   private float budlig07R1Qte;
   private float budlig08R1Qte;
   private float budlig09R1Qte;
   private float budlig10R1Qte;
   private float budlig11R1Qte;
   private float budlig12R1Qte;
   private float budlig01R2Qte;
   private float budlig02R2Qte;
   private float budlig03R2Qte;
   private float budlig04R2Qte;
   private float budlig05R2Qte;
   private float budlig06R2Qte;
   private float budlig07R2Qte;
   private float budlig08R2Qte;
   private float budlig09R2Qte;
   private float budlig10R2Qte;
   private float budlig11R2Qte;
   private float budlig12R2Qte;
   private float budlig01R3Qte;
   private float budlig02R3Qte;
   private float budlig03R3Qte;
   private float budlig04R3Qte;
   private float budlig05R3Qte;
   private float budlig06R3Qte;
   private float budlig07R3Qte;
   private float budlig08R3Qte;
   private float budlig09R3Qte;
   private float budlig10R3Qte;
   private float budlig11R3Qte;
   private float budlig12R3Qte;
   private float budlig01R4Qte;
   private float budlig02R4Qte;
   private float budlig03R4Qte;
   private float budlig04R4Qte;
   private float budlig05R4Qte;
   private float budlig06R4Qte;
   private float budlig07R4Qte;
   private float budlig08R4Qte;
   private float budlig09R4Qte;
   private float budlig10R4Qte;
   private float budlig11R4Qte;
   private float budlig12R4Qte;
   private Budget budget;
   private double montant;
   private float qte;
   private String lib_reamenagement;
   private int choixReam;
   private double ligvalTotal = 0.0D;
   private double ligval01 = 0.0D;
   private double ligval02 = 0.0D;
   private double ligval03 = 0.0D;
   private double ligval04 = 0.0D;
   private double ligval05 = 0.0D;
   private double ligval06 = 0.0D;
   private double ligval07 = 0.0D;
   private double ligval08 = 0.0D;
   private double ligval09 = 0.0D;
   private double ligval10 = 0.0D;
   private double ligval11 = 0.0D;
   private double ligval12 = 0.0D;
   private float ligqteTotal = 0.0F;
   private float ligqte01 = 0.0F;
   private float ligqte02 = 0.0F;
   private float ligqte03 = 0.0F;
   private float ligqte04 = 0.0F;
   private float ligqte05 = 0.0F;
   private float ligqte06 = 0.0F;
   private float ligqte07 = 0.0F;
   private float ligqte08 = 0.0F;
   private float ligqte09 = 0.0F;
   private float ligqte10 = 0.0F;
   private float ligqte11 = 0.0F;
   private float ligqte12 = 0.0F;
   private String zoneActivite;
   private String zoneAnal1;
   private String zoneAnal3;
   private double valDebit;
   private double valCredit;

   public int getChoixReam() {
      return this.choixReam;
   }

   public void setChoixReam(int var1) {
      this.choixReam = var1;
   }

   public Budget getBudget() {
      return this.budget;
   }

   public void setBudget(Budget var1) {
      this.budget = var1;
   }

   public float getBudlig01R1Qte() {
      return this.budlig01R1Qte;
   }

   public void setBudlig01R1Qte(float var1) {
      this.budlig01R1Qte = var1;
   }

   public double getBudlig01R1Val() {
      return this.budlig01R1Val;
   }

   public void setBudlig01R1Val(double var1) {
      this.budlig01R1Val = var1;
   }

   public float getBudlig01R2Qte() {
      return this.budlig01R2Qte;
   }

   public void setBudlig01R2Qte(float var1) {
      this.budlig01R2Qte = var1;
   }

   public double getBudlig01R2Val() {
      return this.budlig01R2Val;
   }

   public void setBudlig01R2Val(double var1) {
      this.budlig01R2Val = var1;
   }

   public float getBudlig01R3Qte() {
      return this.budlig01R3Qte;
   }

   public void setBudlig01R3Qte(float var1) {
      this.budlig01R3Qte = var1;
   }

   public double getBudlig01R3Val() {
      return this.budlig01R3Val;
   }

   public void setBudlig01R3Val(double var1) {
      this.budlig01R3Val = var1;
   }

   public float getBudlig01R4Qte() {
      return this.budlig01R4Qte;
   }

   public void setBudlig01R4Qte(float var1) {
      this.budlig01R4Qte = var1;
   }

   public double getBudlig01R4Val() {
      return this.budlig01R4Val;
   }

   public void setBudlig01R4Val(double var1) {
      this.budlig01R4Val = var1;
   }

   public float getBudlig01TotQte() {
      return this.budlig01TotQte;
   }

   public void setBudlig01TotQte(float var1) {
      this.budlig01TotQte = var1;
   }

   public double getBudlig01TotVal() {
      return this.budlig01TotVal;
   }

   public void setBudlig01TotVal(double var1) {
      this.budlig01TotVal = var1;
   }

   public float getBudlig02R1Qte() {
      return this.budlig02R1Qte;
   }

   public void setBudlig02R1Qte(float var1) {
      this.budlig02R1Qte = var1;
   }

   public double getBudlig02R1Val() {
      return this.budlig02R1Val;
   }

   public void setBudlig02R1Val(double var1) {
      this.budlig02R1Val = var1;
   }

   public float getBudlig02R2Qte() {
      return this.budlig02R2Qte;
   }

   public void setBudlig02R2Qte(float var1) {
      this.budlig02R2Qte = var1;
   }

   public double getBudlig02R2Val() {
      return this.budlig02R2Val;
   }

   public void setBudlig02R2Val(double var1) {
      this.budlig02R2Val = var1;
   }

   public float getBudlig02R3Qte() {
      return this.budlig02R3Qte;
   }

   public void setBudlig02R3Qte(float var1) {
      this.budlig02R3Qte = var1;
   }

   public double getBudlig02R3Val() {
      return this.budlig02R3Val;
   }

   public void setBudlig02R3Val(double var1) {
      this.budlig02R3Val = var1;
   }

   public float getBudlig02R4Qte() {
      return this.budlig02R4Qte;
   }

   public void setBudlig02R4Qte(float var1) {
      this.budlig02R4Qte = var1;
   }

   public double getBudlig02R4Val() {
      return this.budlig02R4Val;
   }

   public void setBudlig02R4Val(double var1) {
      this.budlig02R4Val = var1;
   }

   public float getBudlig02TotQte() {
      return this.budlig02TotQte;
   }

   public void setBudlig02TotQte(float var1) {
      this.budlig02TotQte = var1;
   }

   public double getBudlig02TotVal() {
      return this.budlig02TotVal;
   }

   public void setBudlig02TotVal(double var1) {
      this.budlig02TotVal = var1;
   }

   public float getBudlig03R1Qte() {
      return this.budlig03R1Qte;
   }

   public void setBudlig03R1Qte(float var1) {
      this.budlig03R1Qte = var1;
   }

   public double getBudlig03R1Val() {
      return this.budlig03R1Val;
   }

   public void setBudlig03R1Val(double var1) {
      this.budlig03R1Val = var1;
   }

   public float getBudlig03R2Qte() {
      return this.budlig03R2Qte;
   }

   public void setBudlig03R2Qte(float var1) {
      this.budlig03R2Qte = var1;
   }

   public double getBudlig03R2Val() {
      return this.budlig03R2Val;
   }

   public void setBudlig03R2Val(double var1) {
      this.budlig03R2Val = var1;
   }

   public float getBudlig03R3Qte() {
      return this.budlig03R3Qte;
   }

   public void setBudlig03R3Qte(float var1) {
      this.budlig03R3Qte = var1;
   }

   public double getBudlig03R3Val() {
      return this.budlig03R3Val;
   }

   public void setBudlig03R3Val(double var1) {
      this.budlig03R3Val = var1;
   }

   public float getBudlig03R4Qte() {
      return this.budlig03R4Qte;
   }

   public void setBudlig03R4Qte(float var1) {
      this.budlig03R4Qte = var1;
   }

   public double getBudlig03R4Val() {
      return this.budlig03R4Val;
   }

   public void setBudlig03R4Val(double var1) {
      this.budlig03R4Val = var1;
   }

   public float getBudlig03TotQte() {
      return this.budlig03TotQte;
   }

   public void setBudlig03TotQte(float var1) {
      this.budlig03TotQte = var1;
   }

   public double getBudlig03TotVal() {
      return this.budlig03TotVal;
   }

   public void setBudlig03TotVal(double var1) {
      this.budlig03TotVal = var1;
   }

   public float getBudlig04R1Qte() {
      return this.budlig04R1Qte;
   }

   public void setBudlig04R1Qte(float var1) {
      this.budlig04R1Qte = var1;
   }

   public double getBudlig04R1Val() {
      return this.budlig04R1Val;
   }

   public void setBudlig04R1Val(double var1) {
      this.budlig04R1Val = var1;
   }

   public float getBudlig04R2Qte() {
      return this.budlig04R2Qte;
   }

   public void setBudlig04R2Qte(float var1) {
      this.budlig04R2Qte = var1;
   }

   public double getBudlig04R2Val() {
      return this.budlig04R2Val;
   }

   public void setBudlig04R2Val(double var1) {
      this.budlig04R2Val = var1;
   }

   public float getBudlig04R3Qte() {
      return this.budlig04R3Qte;
   }

   public void setBudlig04R3Qte(float var1) {
      this.budlig04R3Qte = var1;
   }

   public double getBudlig04R3Val() {
      return this.budlig04R3Val;
   }

   public void setBudlig04R3Val(double var1) {
      this.budlig04R3Val = var1;
   }

   public float getBudlig04R4Qte() {
      return this.budlig04R4Qte;
   }

   public void setBudlig04R4Qte(float var1) {
      this.budlig04R4Qte = var1;
   }

   public double getBudlig04R4Val() {
      return this.budlig04R4Val;
   }

   public void setBudlig04R4Val(double var1) {
      this.budlig04R4Val = var1;
   }

   public float getBudlig04TotQte() {
      return this.budlig04TotQte;
   }

   public void setBudlig04TotQte(float var1) {
      this.budlig04TotQte = var1;
   }

   public double getBudlig04TotVal() {
      return this.budlig04TotVal;
   }

   public void setBudlig04TotVal(double var1) {
      this.budlig04TotVal = var1;
   }

   public float getBudlig05R1Qte() {
      return this.budlig05R1Qte;
   }

   public void setBudlig05R1Qte(float var1) {
      this.budlig05R1Qte = var1;
   }

   public double getBudlig05R1Val() {
      return this.budlig05R1Val;
   }

   public void setBudlig05R1Val(double var1) {
      this.budlig05R1Val = var1;
   }

   public float getBudlig05R2Qte() {
      return this.budlig05R2Qte;
   }

   public void setBudlig05R2Qte(float var1) {
      this.budlig05R2Qte = var1;
   }

   public double getBudlig05R2Val() {
      return this.budlig05R2Val;
   }

   public void setBudlig05R2Val(double var1) {
      this.budlig05R2Val = var1;
   }

   public float getBudlig05R3Qte() {
      return this.budlig05R3Qte;
   }

   public void setBudlig05R3Qte(float var1) {
      this.budlig05R3Qte = var1;
   }

   public double getBudlig05R3Val() {
      return this.budlig05R3Val;
   }

   public void setBudlig05R3Val(double var1) {
      this.budlig05R3Val = var1;
   }

   public float getBudlig05R4Qte() {
      return this.budlig05R4Qte;
   }

   public void setBudlig05R4Qte(float var1) {
      this.budlig05R4Qte = var1;
   }

   public double getBudlig05R4Val() {
      return this.budlig05R4Val;
   }

   public void setBudlig05R4Val(double var1) {
      this.budlig05R4Val = var1;
   }

   public float getBudlig06R1Qte() {
      return this.budlig06R1Qte;
   }

   public void setBudlig06R1Qte(float var1) {
      this.budlig06R1Qte = var1;
   }

   public double getBudlig06R1Val() {
      return this.budlig06R1Val;
   }

   public void setBudlig06R1Val(double var1) {
      this.budlig06R1Val = var1;
   }

   public float getBudlig06R2Qte() {
      return this.budlig06R2Qte;
   }

   public void setBudlig06R2Qte(float var1) {
      this.budlig06R2Qte = var1;
   }

   public double getBudlig06R2Val() {
      return this.budlig06R2Val;
   }

   public void setBudlig06R2Val(double var1) {
      this.budlig06R2Val = var1;
   }

   public float getBudlig06R3Qte() {
      return this.budlig06R3Qte;
   }

   public void setBudlig06R3Qte(float var1) {
      this.budlig06R3Qte = var1;
   }

   public double getBudlig06R3Val() {
      return this.budlig06R3Val;
   }

   public void setBudlig06R3Val(double var1) {
      this.budlig06R3Val = var1;
   }

   public float getBudlig06R4Qte() {
      return this.budlig06R4Qte;
   }

   public void setBudlig06R4Qte(float var1) {
      this.budlig06R4Qte = var1;
   }

   public double getBudlig06R4Val() {
      return this.budlig06R4Val;
   }

   public void setBudlig06R4Val(double var1) {
      this.budlig06R4Val = var1;
   }

   public float getBudlig07R1Qte() {
      return this.budlig07R1Qte;
   }

   public void setBudlig07R1Qte(float var1) {
      this.budlig07R1Qte = var1;
   }

   public double getBudlig07R1Val() {
      return this.budlig07R1Val;
   }

   public void setBudlig07R1Val(double var1) {
      this.budlig07R1Val = var1;
   }

   public float getBudlig07R2Qte() {
      return this.budlig07R2Qte;
   }

   public void setBudlig07R2Qte(float var1) {
      this.budlig07R2Qte = var1;
   }

   public double getBudlig07R2Val() {
      return this.budlig07R2Val;
   }

   public void setBudlig07R2Val(double var1) {
      this.budlig07R2Val = var1;
   }

   public float getBudlig07R3Qte() {
      return this.budlig07R3Qte;
   }

   public void setBudlig07R3Qte(float var1) {
      this.budlig07R3Qte = var1;
   }

   public double getBudlig07R3Val() {
      return this.budlig07R3Val;
   }

   public void setBudlig07R3Val(double var1) {
      this.budlig07R3Val = var1;
   }

   public float getBudlig07R4Qte() {
      return this.budlig07R4Qte;
   }

   public void setBudlig07R4Qte(float var1) {
      this.budlig07R4Qte = var1;
   }

   public double getBudlig07R4Val() {
      return this.budlig07R4Val;
   }

   public void setBudlig07R4Val(double var1) {
      this.budlig07R4Val = var1;
   }

   public float getBudlig08R1Qte() {
      return this.budlig08R1Qte;
   }

   public void setBudlig08R1Qte(float var1) {
      this.budlig08R1Qte = var1;
   }

   public double getBudlig08R1Val() {
      return this.budlig08R1Val;
   }

   public void setBudlig08R1Val(double var1) {
      this.budlig08R1Val = var1;
   }

   public float getBudlig08R2Qte() {
      return this.budlig08R2Qte;
   }

   public void setBudlig08R2Qte(float var1) {
      this.budlig08R2Qte = var1;
   }

   public double getBudlig08R2Val() {
      return this.budlig08R2Val;
   }

   public void setBudlig08R2Val(double var1) {
      this.budlig08R2Val = var1;
   }

   public float getBudlig08R3Qte() {
      return this.budlig08R3Qte;
   }

   public void setBudlig08R3Qte(float var1) {
      this.budlig08R3Qte = var1;
   }

   public double getBudlig08R3Val() {
      return this.budlig08R3Val;
   }

   public void setBudlig08R3Val(double var1) {
      this.budlig08R3Val = var1;
   }

   public float getBudlig08R4Qte() {
      return this.budlig08R4Qte;
   }

   public void setBudlig08R4Qte(float var1) {
      this.budlig08R4Qte = var1;
   }

   public double getBudlig08R4Val() {
      return this.budlig08R4Val;
   }

   public void setBudlig08R4Val(double var1) {
      this.budlig08R4Val = var1;
   }

   public float getBudlig09R1Qte() {
      return this.budlig09R1Qte;
   }

   public void setBudlig09R1Qte(float var1) {
      this.budlig09R1Qte = var1;
   }

   public double getBudlig09R1Val() {
      return this.budlig09R1Val;
   }

   public void setBudlig09R1Val(double var1) {
      this.budlig09R1Val = var1;
   }

   public float getBudlig09R2Qte() {
      return this.budlig09R2Qte;
   }

   public void setBudlig09R2Qte(float var1) {
      this.budlig09R2Qte = var1;
   }

   public double getBudlig09R2Val() {
      return this.budlig09R2Val;
   }

   public void setBudlig09R2Val(double var1) {
      this.budlig09R2Val = var1;
   }

   public float getBudlig09R3Qte() {
      return this.budlig09R3Qte;
   }

   public void setBudlig09R3Qte(float var1) {
      this.budlig09R3Qte = var1;
   }

   public double getBudlig09R3Val() {
      return this.budlig09R3Val;
   }

   public void setBudlig09R3Val(double var1) {
      this.budlig09R3Val = var1;
   }

   public float getBudlig09R4Qte() {
      return this.budlig09R4Qte;
   }

   public void setBudlig09R4Qte(float var1) {
      this.budlig09R4Qte = var1;
   }

   public double getBudlig09R4Val() {
      return this.budlig09R4Val;
   }

   public void setBudlig09R4Val(double var1) {
      this.budlig09R4Val = var1;
   }

   public float getBudlig10R1Qte() {
      return this.budlig10R1Qte;
   }

   public void setBudlig10R1Qte(float var1) {
      this.budlig10R1Qte = var1;
   }

   public double getBudlig10R1Val() {
      return this.budlig10R1Val;
   }

   public void setBudlig10R1Val(double var1) {
      this.budlig10R1Val = var1;
   }

   public float getBudlig10R2Qte() {
      return this.budlig10R2Qte;
   }

   public void setBudlig10R2Qte(float var1) {
      this.budlig10R2Qte = var1;
   }

   public double getBudlig10R2Val() {
      return this.budlig10R2Val;
   }

   public void setBudlig10R2Val(double var1) {
      this.budlig10R2Val = var1;
   }

   public float getBudlig10R3Qte() {
      return this.budlig10R3Qte;
   }

   public void setBudlig10R3Qte(float var1) {
      this.budlig10R3Qte = var1;
   }

   public double getBudlig10R3Val() {
      return this.budlig10R3Val;
   }

   public void setBudlig10R3Val(double var1) {
      this.budlig10R3Val = var1;
   }

   public float getBudlig10R4Qte() {
      return this.budlig10R4Qte;
   }

   public void setBudlig10R4Qte(float var1) {
      this.budlig10R4Qte = var1;
   }

   public double getBudlig10R4Val() {
      return this.budlig10R4Val;
   }

   public void setBudlig10R4Val(double var1) {
      this.budlig10R4Val = var1;
   }

   public float getBudlig11R1Qte() {
      return this.budlig11R1Qte;
   }

   public void setBudlig11R1Qte(float var1) {
      this.budlig11R1Qte = var1;
   }

   public double getBudlig11R1Val() {
      return this.budlig11R1Val;
   }

   public void setBudlig11R1Val(double var1) {
      this.budlig11R1Val = var1;
   }

   public float getBudlig11R2Qte() {
      return this.budlig11R2Qte;
   }

   public void setBudlig11R2Qte(float var1) {
      this.budlig11R2Qte = var1;
   }

   public double getBudlig11R2Val() {
      return this.budlig11R2Val;
   }

   public void setBudlig11R2Val(double var1) {
      this.budlig11R2Val = var1;
   }

   public float getBudlig11R3Qte() {
      return this.budlig11R3Qte;
   }

   public void setBudlig11R3Qte(float var1) {
      this.budlig11R3Qte = var1;
   }

   public double getBudlig11R3Val() {
      return this.budlig11R3Val;
   }

   public void setBudlig11R3Val(double var1) {
      this.budlig11R3Val = var1;
   }

   public float getBudlig11R4Qte() {
      return this.budlig11R4Qte;
   }

   public void setBudlig11R4Qte(float var1) {
      this.budlig11R4Qte = var1;
   }

   public double getBudlig11R4Val() {
      return this.budlig11R4Val;
   }

   public void setBudlig11R4Val(double var1) {
      this.budlig11R4Val = var1;
   }

   public float getBudlig12R1Qte() {
      return this.budlig12R1Qte;
   }

   public void setBudlig12R1Qte(float var1) {
      this.budlig12R1Qte = var1;
   }

   public double getBudlig12R1Val() {
      return this.budlig12R1Val;
   }

   public void setBudlig12R1Val(double var1) {
      this.budlig12R1Val = var1;
   }

   public float getBudlig12R2Qte() {
      return this.budlig12R2Qte;
   }

   public void setBudlig12R2Qte(float var1) {
      this.budlig12R2Qte = var1;
   }

   public double getBudlig12R2Val() {
      return this.budlig12R2Val;
   }

   public void setBudlig12R2Val(double var1) {
      this.budlig12R2Val = var1;
   }

   public float getBudlig12R3Qte() {
      return this.budlig12R3Qte;
   }

   public void setBudlig12R3Qte(float var1) {
      this.budlig12R3Qte = var1;
   }

   public double getBudlig12R3Val() {
      return this.budlig12R3Val;
   }

   public void setBudlig12R3Val(double var1) {
      this.budlig12R3Val = var1;
   }

   public float getBudlig12R4Qte() {
      return this.budlig12R4Qte;
   }

   public void setBudlig12R4Qte(float var1) {
      this.budlig12R4Qte = var1;
   }

   public double getBudlig12R4Val() {
      return this.budlig12R4Val;
   }

   public void setBudlig12R4Val(double var1) {
      this.budlig12R4Val = var1;
   }

   public String getBudligActivite() {
      return this.budligActivite;
   }

   public void setBudligActivite(String var1) {
      this.budligActivite = var1;
   }

   public String getBudligCode() {
      return this.budligCode;
   }

   public void setBudligCode(String var1) {
      this.budligCode = var1;
   }

   public int getBudligUtil() {
      return this.budligUtil;
   }

   public void setBudligUtil(int var1) {
      this.budligUtil = var1;
   }

   public long getBudlig_id() {
      return this.budlig_id;
   }

   public void setBudlig_id(long var1) {
      this.budlig_id = var1;
   }

   public String getLib_reamenagement() {
      return this.lib_reamenagement;
   }

   public void setLib_reamenagement(String var1) {
      if (this.budget.getBudUtil() == 0) {
         var1 = "Budget initial";
      } else if (this.budget.getBudUtil() == 1) {
         var1 = "Réaménagement N° 1";
      } else if (this.budget.getBudUtil() == 2) {
         var1 = "Réaménagement N° 2";
      } else if (this.budget.getBudUtil() == 3) {
         var1 = "Réaménagement N° 3";
      }

      this.lib_reamenagement = var1;
   }

   public double getMontant() {
      return this.montant;
   }

   public void setMontant(double var1) {
      this.montant = var1;
   }

   public float getQte() {
      return this.qte;
   }

   public void setQte(float var1) {
      this.qte = var1;
   }

   public float getLigqte01() {
      if (this.budligUtil == 0) {
         this.ligqte01 = this.budlig01R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte01 = this.budlig01R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte01 = this.budlig01R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte01 = this.budlig01R4Qte;
      }

      return this.ligqte01;
   }

   public void setLigqte01(float var1) {
      this.ligqte01 = var1;
   }

   public float getLigqte02() {
      if (this.budligUtil == 0) {
         this.ligqte02 = this.budlig02R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte02 = this.budlig02R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte02 = this.budlig02R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte02 = this.budlig02R4Qte;
      }

      return this.ligqte02;
   }

   public void setLigqte02(float var1) {
      this.ligqte02 = var1;
   }

   public float getLigqte03() {
      if (this.budligUtil == 0) {
         this.ligqte03 = this.budlig03R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte03 = this.budlig03R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte03 = this.budlig03R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte03 = this.budlig03R4Qte;
      }

      return this.ligqte03;
   }

   public void setLigqte03(float var1) {
      this.ligqte03 = var1;
   }

   public float getLigqte04() {
      if (this.budligUtil == 0) {
         this.ligqte04 = this.budlig04R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte04 = this.budlig04R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte04 = this.budlig04R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte04 = this.budlig04R4Qte;
      }

      return this.ligqte04;
   }

   public void setLigqte04(float var1) {
      this.ligqte04 = var1;
   }

   public float getLigqte05() {
      if (this.budligUtil == 0) {
         this.ligqte05 = this.budlig05R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte05 = this.budlig05R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte05 = this.budlig05R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte05 = this.budlig05R4Qte;
      }

      return this.ligqte05;
   }

   public void setLigqte05(float var1) {
      this.ligqte05 = var1;
   }

   public float getLigqte06() {
      if (this.budligUtil == 0) {
         this.ligqte06 = this.budlig06R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte06 = this.budlig06R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte06 = this.budlig06R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte06 = this.budlig06R4Qte;
      }

      return this.ligqte06;
   }

   public void setLigqte06(float var1) {
      this.ligqte06 = var1;
   }

   public float getLigqte07() {
      if (this.budligUtil == 0) {
         this.ligqte07 = this.budlig07R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte07 = this.budlig07R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte07 = this.budlig07R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte07 = this.budlig07R4Qte;
      }

      return this.ligqte07;
   }

   public void setLigqte07(float var1) {
      this.ligqte07 = var1;
   }

   public float getLigqte08() {
      if (this.budligUtil == 0) {
         this.ligqte08 = this.budlig08R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte08 = this.budlig08R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte08 = this.budlig08R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte08 = this.budlig08R4Qte;
      }

      return this.ligqte08;
   }

   public void setLigqte08(float var1) {
      this.ligqte08 = var1;
   }

   public float getLigqte09() {
      if (this.budligUtil == 0) {
         this.ligqte09 = this.budlig09R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte09 = this.budlig09R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte09 = this.budlig09R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte09 = this.budlig09R4Qte;
      }

      return this.ligqte09;
   }

   public void setLigqte09(float var1) {
      this.ligqte09 = var1;
   }

   public float getLigqte10() {
      if (this.budligUtil == 0) {
         this.ligqte10 = this.budlig10R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte10 = this.budlig10R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte10 = this.budlig10R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte10 = this.budlig10R4Qte;
      }

      return this.ligqte10;
   }

   public void setLigqte10(float var1) {
      this.ligqte10 = var1;
   }

   public float getLigqte11() {
      if (this.budligUtil == 0) {
         this.ligqte11 = this.budlig11R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte11 = this.budlig11R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte11 = this.budlig11R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte11 = this.budlig11R4Qte;
      }

      return this.ligqte11;
   }

   public void setLigqte11(float var1) {
      this.ligqte11 = var1;
   }

   public float getLigqte12() {
      if (this.budligUtil == 0) {
         this.ligqte12 = this.budlig12R1Qte;
      } else if (this.budligUtil == 1) {
         this.ligqte12 = this.budlig12R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqte12 = this.budlig12R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqte12 = this.budlig12R4Qte;
      }

      return this.ligqte12;
   }

   public void setLigqte12(float var1) {
      this.ligqte12 = var1;
   }

   public float getLigqteTotal() {
      if (this.budligUtil == 0) {
         this.ligqteTotal = this.budlig01TotQte;
      } else if (this.budligUtil == 1) {
         this.ligqteTotal = this.budlig02R2Qte;
      } else if (this.budligUtil == 2) {
         this.ligqteTotal = this.budlig03R3Qte;
      } else if (this.budligUtil == 3) {
         this.ligqteTotal = this.budlig04R4Qte;
      }

      return this.ligqteTotal;
   }

   public void setLigqteTotal(float var1) {
      this.ligqteTotal = var1;
   }

   public double getLigval01() {
      if (this.budligUtil == 0) {
         this.ligval01 = this.budlig01R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval01 = this.budlig01R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval01 = this.budlig01R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval01 = this.budlig01R4Val;
      }

      return this.ligval01;
   }

   public void setLigval01(double var1) {
      this.ligval01 = var1;
   }

   public double getLigval02() {
      if (this.budligUtil == 0) {
         this.ligval02 = this.budlig02R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval02 = this.budlig02R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval02 = this.budlig02R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval02 = this.budlig02R4Val;
      }

      return this.ligval02;
   }

   public void setLigval02(double var1) {
      this.ligval02 = var1;
   }

   public double getLigval03() {
      if (this.budligUtil == 0) {
         this.ligval03 = this.budlig03R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval03 = this.budlig03R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval03 = this.budlig03R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval03 = this.budlig03R4Val;
      }

      return this.ligval03;
   }

   public void setLigval03(double var1) {
      this.ligval03 = var1;
   }

   public double getLigval04() {
      if (this.budligUtil == 0) {
         this.ligval04 = this.budlig04R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval04 = this.budlig04R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval04 = this.budlig04R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval04 = this.budlig04R4Val;
      }

      return this.ligval04;
   }

   public void setLigval04(double var1) {
      this.ligval04 = var1;
   }

   public double getLigval05() {
      if (this.budligUtil == 0) {
         this.ligval05 = this.budlig05R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval05 = this.budlig05R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval05 = this.budlig05R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval05 = this.budlig05R4Val;
      }

      return this.ligval05;
   }

   public void setLigval05(double var1) {
      this.ligval05 = var1;
   }

   public double getLigval06() {
      if (this.budligUtil == 0) {
         this.ligval06 = this.budlig06R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval06 = this.budlig06R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval06 = this.budlig06R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval06 = this.budlig06R4Val;
      }

      return this.ligval06;
   }

   public void setLigval06(double var1) {
      this.ligval06 = var1;
   }

   public double getLigval07() {
      if (this.budligUtil == 0) {
         this.ligval07 = this.budlig07R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval07 = this.budlig07R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval07 = this.budlig07R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval07 = this.budlig07R4Val;
      }

      return this.ligval07;
   }

   public void setLigval07(double var1) {
      this.ligval07 = var1;
   }

   public double getLigval08() {
      if (this.budligUtil == 0) {
         this.ligval08 = this.budlig08R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval08 = this.budlig08R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval08 = this.budlig08R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval08 = this.budlig08R4Val;
      }

      return this.ligval08;
   }

   public void setLigval08(double var1) {
      this.ligval08 = var1;
   }

   public double getLigval09() {
      if (this.budligUtil == 0) {
         this.ligval09 = this.budlig09R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval09 = this.budlig09R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval09 = this.budlig09R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval09 = this.budlig09R4Val;
      }

      return this.ligval09;
   }

   public void setLigval09(double var1) {
      this.ligval09 = var1;
   }

   public double getLigval10() {
      if (this.budligUtil == 0) {
         this.ligval10 = this.budlig10R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval10 = this.budlig10R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval10 = this.budlig10R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval10 = this.budlig10R4Val;
      }

      return this.ligval10;
   }

   public void setLigval10(double var1) {
      this.ligval10 = var1;
   }

   public double getLigval11() {
      if (this.budligUtil == 0) {
         this.ligval11 = this.budlig11R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval11 = this.budlig11R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval11 = this.budlig11R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval11 = this.budlig11R4Val;
      }

      return this.ligval11;
   }

   public void setLigval11(double var1) {
      this.ligval11 = var1;
   }

   public double getLigval12() {
      if (this.budligUtil == 0) {
         this.ligval12 = this.budlig12R1Val;
      } else if (this.budligUtil == 1) {
         this.ligval12 = this.budlig12R2Val;
      } else if (this.budligUtil == 2) {
         this.ligval12 = this.budlig12R3Val;
      } else if (this.budligUtil == 3) {
         this.ligval12 = this.budlig12R4Val;
      }

      return this.ligval12;
   }

   public void setLigval12(double var1) {
      this.ligval12 = var1;
   }

   public double getLigvalTotal() {
      if (this.budligUtil == 0) {
         this.ligvalTotal = this.budlig01TotVal;
      } else if (this.budligUtil == 1) {
         this.ligvalTotal = this.budlig02TotVal;
      } else if (this.budligUtil == 2) {
         this.ligvalTotal = this.budlig03TotVal;
      } else if (this.budligUtil == 3) {
         this.ligvalTotal = this.budlig04TotVal;
      }

      return this.ligvalTotal;
   }

   public void setLigvalTotal(double var1) {
      this.ligvalTotal = var1;
   }

   public String getBudligDepartement() {
      return this.budligDepartement;
   }

   public void setBudligDepartement(String var1) {
      this.budligDepartement = var1;
   }

   public String getBudligPdv() {
      return this.budligPdv;
   }

   public void setBudligPdv(String var1) {
      this.budligPdv = var1;
   }

   public String getBudligRegion() {
      return this.budligRegion;
   }

   public void setBudligRegion(String var1) {
      this.budligRegion = var1;
   }

   public String getBudligSecteur() {
      return this.budligSecteur;
   }

   public void setBudligSecteur(String var1) {
      this.budligSecteur = var1;
   }

   public String getBudligService() {
      return this.budligService;
   }

   public void setBudligService(String var1) {
      this.budligService = var1;
   }

   public String getBudligSite() {
      return this.budligSite;
   }

   public void setBudligSite(String var1) {
      this.budligSite = var1;
   }

   public String getBudligAnal1() {
      return this.budligAnal1;
   }

   public void setBudligAnal1(String var1) {
      this.budligAnal1 = var1;
   }

   public String getBudligAnal3() {
      return this.budligAnal3;
   }

   public void setBudligAnal3(String var1) {
      this.budligAnal3 = var1;
   }

   public double getValCredit() {
      return this.valCredit;
   }

   public void setValCredit(double var1) {
      this.valCredit = var1;
   }

   public double getValDebit() {
      return this.valDebit;
   }

   public void setValDebit(double var1) {
      this.valDebit = var1;
   }

   public String getZoneActivite() {
      return this.zoneActivite;
   }

   public void setZoneActivite(String var1) {
      this.zoneActivite = var1;
   }

   public String getZoneAnal1() {
      return this.zoneAnal1;
   }

   public void setZoneAnal1(String var1) {
      this.zoneAnal1 = var1;
   }

   public String getZoneAnal3() {
      return this.zoneAnal3;
   }

   public void setZoneAnal3(String var1) {
      this.zoneAnal3 = var1;
   }

   public String getBudligLibActivite() {
      return this.budligLibActivite;
   }

   public void setBudligLibActivite(String var1) {
      this.budligLibActivite = var1;
   }

   public String getBudligLibAnal1() {
      return this.budligLibAnal1;
   }

   public void setBudligLibAnal1(String var1) {
      this.budligLibAnal1 = var1;
   }

   public String getBudligLibAnal3() {
      return this.budligLibAnal3;
   }

   public void setBudligLibAnal3(String var1) {
      this.budligLibAnal3 = var1;
   }

   public String getBudligAnal2() {
      return this.budligAnal2;
   }

   public void setBudligAnal2(String var1) {
      this.budligAnal2 = var1;
   }

   public String getBudligAnal4() {
      return this.budligAnal4;
   }

   public void setBudligAnal4(String var1) {
      this.budligAnal4 = var1;
   }

   public String getBudligDepartementLib() {
      return this.budligDepartementLib;
   }

   public void setBudligDepartementLib(String var1) {
      this.budligDepartementLib = var1;
   }

   public String getBudligLibAnal2() {
      return this.budligLibAnal2;
   }

   public void setBudligLibAnal2(String var1) {
      this.budligLibAnal2 = var1;
   }

   public String getBudligLibAnal4() {
      return this.budligLibAnal4;
   }

   public void setBudligLibAnal4(String var1) {
      this.budligLibAnal4 = var1;
   }

   public String getBudligPdvLib() {
      return this.budligPdvLib;
   }

   public void setBudligPdvLib(String var1) {
      this.budligPdvLib = var1;
   }

   public String getBudligRegionLib() {
      return this.budligRegionLib;
   }

   public void setBudligRegionLib(String var1) {
      this.budligRegionLib = var1;
   }

   public String getBudligSecteurLib() {
      return this.budligSecteurLib;
   }

   public void setBudligSecteurLib(String var1) {
      this.budligSecteurLib = var1;
   }

   public String getBudligServiceLib() {
      return this.budligServiceLib;
   }

   public void setBudligServiceLib(String var1) {
      this.budligServiceLib = var1;
   }

   public String getBudligSiteLib() {
      return this.budligSiteLib;
   }

   public void setBudligSiteLib(String var1) {
      this.budligSiteLib = var1;
   }

   public String getBudligAgent() {
      return this.budligAgent;
   }

   public void setBudligAgent(String var1) {
      this.budligAgent = var1;
   }

   public String getBudligAgentLib() {
      return this.budligAgentLib;
   }

   public void setBudligAgentLib(String var1) {
      this.budligAgentLib = var1;
   }

   public String getBudligAtelier() {
      return this.budligAtelier;
   }

   public void setBudligAtelier(String var1) {
      this.budligAtelier = var1;
   }

   public String getBudligAtelierLib() {
      return this.budligAtelierLib;
   }

   public void setBudligAtelierLib(String var1) {
      this.budligAtelierLib = var1;
   }

   public String getBudligEntite() {
      return this.budligEntite;
   }

   public void setBudligEntite(String var1) {
      this.budligEntite = var1;
   }

   public String getBudligEntiteLib() {
      return this.budligEntiteLib;
   }

   public void setBudligEntiteLib(String var1) {
      this.budligEntiteLib = var1;
   }

   public String getBudligLigne() {
      return this.budligLigne;
   }

   public void setBudligLigne(String var1) {
      this.budligLigne = var1;
   }

   public String getBudligLigneLib() {
      return this.budligLigneLib;
   }

   public void setBudligLigneLib(String var1) {
      this.budligLigneLib = var1;
   }

   public String getBudligPoste() {
      return this.budligPoste;
   }

   public void setBudligPoste(String var1) {
      this.budligPoste = var1;
   }

   public String getBudligPosteLib() {
      return this.budligPosteLib;
   }

   public void setBudligPosteLib(String var1) {
      this.budligPosteLib = var1;
   }

   public String getBudligProjet() {
      return this.budligProjet;
   }

   public void setBudligProjet(String var1) {
      this.budligProjet = var1;
   }

   public String getBudligProjetLib() {
      return this.budligProjetLib;
   }

   public void setBudligProjetLib(String var1) {
      this.budligProjetLib = var1;
   }

   public String getBudligRepCle() {
      return this.budligRepCle;
   }

   public void setBudligRepCle(String var1) {
      this.budligRepCle = var1;
   }

   public String getBudligStr() {
      return this.budligStr;
   }

   public void setBudligStr(String var1) {
      this.budligStr = var1;
   }

   public String getBudligStrCle() {
      return this.budligStrCle;
   }

   public void setBudligStrCle(String var1) {
      this.budligStrCle = var1;
   }

   public String getBudligStrLib() {
      return this.budligStrLib;
   }

   public void setBudligStrLib(String var1) {
      this.budligStrLib = var1;
   }

   public int getBudligTypeCle() {
      return this.budligTypeCle;
   }

   public void setBudligTypeCle(int var1) {
      this.budligTypeCle = var1;
   }

   public int getBudligAxe() {
      return this.budligAxe;
   }

   public void setBudligAxe(int var1) {
      this.budligAxe = var1;
   }

   public double getBudligMontantSaisie() {
      return this.budligMontantSaisie;
   }

   public void setBudligMontantSaisie(double var1) {
      this.budligMontantSaisie = var1;
   }

   public float getBudligQteSaisie() {
      return this.budligQteSaisie;
   }

   public void setBudligQteSaisie(float var1) {
      this.budligQteSaisie = var1;
   }

   public float getBudligPourcentSaisie() {
      return this.budligPourcentSaisie;
   }

   public void setBudligPourcentSaisie(float var1) {
      this.budligPourcentSaisie = var1;
   }
}
