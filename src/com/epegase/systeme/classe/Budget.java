package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Budget implements Serializable {
   private long bud_id;
   private Date budDateModif;
   private Date budDateCreat;
   private long budUserCreat;
   private long budUserModif;
   private String budNature;
   private String budAnnee;
   private String budCode;
   private String budEntite;
   private String budLibelleFr;
   private String budLibelleUk;
   private String budLibelleSp;
   private String budProjet;
   private int budSens;
   private int budUtil;
   private boolean budAxe01;
   private boolean budAxe02;
   private boolean budAxe03;
   private boolean budAxe04;
   private boolean budAxe05;
   private boolean budAxe06;
   private boolean budAxe07;
   private boolean budAxe08;
   private boolean budAxe09;
   private boolean budAxe10;
   private boolean budAxe11;
   private boolean budAxe12;
   private boolean budAxe13;
   private int budType;
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
   private float bud01TotQte;
   private float bud02TotQte;
   private float bud03TotQte;
   private float bud04TotQte;
   private float bud01R1Qte;
   private float bud02R1Qte;
   private float bud03R1Qte;
   private float bud04R1Qte;
   private float bud05R1Qte;
   private float bud06R1Qte;
   private float bud07R1Qte;
   private float bud08R1Qte;
   private float bud09R1Qte;
   private float bud10R1Qte;
   private float bud11R1Qte;
   private float bud12R1Qte;
   private float bud01R2Qte;
   private float bud02R2Qte;
   private float bud03R2Qte;
   private float bud04R2Qte;
   private float bud05R2Qte;
   private float bud06R2Qte;
   private float bud07R2Qte;
   private float bud08R2Qte;
   private float bud09R2Qte;
   private float bud10R2Qte;
   private float bud11R2Qte;
   private float bud12R2Qte;
   private float bud01R3Qte;
   private float bud02R3Qte;
   private float bud03R3Qte;
   private float bud04R3Qte;
   private float bud05R3Qte;
   private float bud06R3Qte;
   private float bud07R3Qte;
   private float bud08R3Qte;
   private float bud09R3Qte;
   private float bud10R3Qte;
   private float bud11R3Qte;
   private float bud12R3Qte;
   private float bud01R4Qte;
   private float bud02R4Qte;
   private float bud03R4Qte;
   private float bud04R4Qte;
   private float bud05R4Qte;
   private float bud06R4Qte;
   private float bud07R4Qte;
   private float bud08R4Qte;
   private float bud09R4Qte;
   private float bud10R4Qte;
   private float bud11R4Qte;
   private float bud12R4Qte;
   private long budIdOld;
   private ExercicesComptable exercicescomptable;
   private double montant;
   private float qte;
   private String lib_reamenagement;
   private int choixReam;
   private String espaceFamille;
   private String espaceFamilleLight;
   private double varBudget;
   private double varRealise;
   private double varEcart;
   private float varPourcentage;

   public ExercicesComptable getExercicescomptable() {
      return this.exercicescomptable;
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

   public float getVarPourcentage() {
      if (this.varBudget != 0.0D) {
         this.varPourcentage = (float)(this.varRealise / this.varBudget * 100.0D);
      } else {
         this.varPourcentage = 0.0F;
      }

      return this.varPourcentage;
   }

   public void setVarPourcentage(float var1) {
      this.varPourcentage = var1;
   }

   public double getVarRealise() {
      return this.varRealise;
   }

   public void setVarRealise(double var1) {
      this.varRealise = var1;
   }

   public String getEspaceFamille() {
      if (this.budType == 2) {
         this.espaceFamille = "font-weight:bold;";
      } else if (this.budType == 15) {
         this.espaceFamille = "font-weight:bold;color:red;font-size:15px;";
      } else if (this.budType == 20) {
         this.espaceFamille = "font-weight:bold;";
      } else if (this.budType == 21) {
         this.espaceFamille = "font-weight:bold;font-style: italic;";
      } else if (this.budType == 22) {
         this.espaceFamille = "font-weight:bold;font-style: italic;text-decoration:underline;";
      } else if (this.budType != 3 && this.budType != 4) {
         this.espaceFamille = "width:100%;";
      } else {
         this.espaceFamille = "font-style: italic;";
      }

      if (this.budNature != null && this.budNature.length() >= 2) {
         if (this.budType != 0 && this.budType != 1 && this.budType != 3 && this.budType != 4) {
            if (this.budType != 15 && this.budType != 20) {
               if (this.budType == 21) {
                  this.espaceFamille = this.espaceFamille + "margin-left:20px;";
               } else if (this.budType == 22) {
                  this.espaceFamille = this.espaceFamille + "margin-left:40px;";
               }
            }
         } else {
            this.espaceFamille = this.espaceFamille + "margin-left:60px;";
         }
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public String getEspaceFamilleLight() {
      if (this.budType == 2) {
         this.espaceFamilleLight = "font-weight:bold;";
      } else if (this.budType == 15) {
         this.espaceFamilleLight = "font-weight:bold;color:red;font-size:15px;";
      } else if (this.budType == 20) {
         this.espaceFamilleLight = "font-weight:bold;";
      } else if (this.budType == 21) {
         this.espaceFamilleLight = "font-weight:bold;font-style: italic;";
      } else if (this.budType == 22) {
         this.espaceFamilleLight = "font-weight:bold;font-style: italic;text-decoration:underline;";
      } else if (this.budType != 3 && this.budType != 4) {
         this.espaceFamilleLight = "width:100%;";
      } else {
         this.espaceFamilleLight = "font-style: italic;";
      }

      return this.espaceFamilleLight;
   }

   public void setEspaceFamilleLight(String var1) {
      this.espaceFamilleLight = var1;
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

   public float getQte() {
      if (this.choixReam == 0) {
         this.qte = this.bud01TotQte;
      } else if (this.choixReam == 1) {
         this.qte = this.bud02TotQte;
      } else if (this.choixReam == 2) {
         this.qte = this.bud03TotQte;
      } else if (this.choixReam == 3) {
         this.qte = this.bud04TotQte;
      }

      return this.qte;
   }

   public void setQte(float var1) {
      this.qte = var1;
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

   public String getBudNature() {
      return this.budNature;
   }

   public void setBudNature(String var1) {
      this.budNature = var1;
   }

   public String getBudAnnee() {
      return this.budAnnee;
   }

   public void setBudAnnee(String var1) {
      this.budAnnee = var1;
   }

   public Date getBudDateModif() {
      return this.budDateModif;
   }

   public void setBudDateModif(Date var1) {
      this.budDateModif = var1;
   }

   public long getBud_id() {
      return this.bud_id;
   }

   public void setBud_id(long var1) {
      this.bud_id = var1;
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

   public Date getBudDateCreat() {
      return this.budDateCreat;
   }

   public void setBudDateCreat(Date var1) {
      this.budDateCreat = var1;
   }

   public String getBudCode() {
      return this.budCode;
   }

   public void setBudCode(String var1) {
      this.budCode = var1;
   }

   public int getBudUtil() {
      return this.budUtil;
   }

   public void setBudUtil(int var1) {
      this.budUtil = var1;
   }

   public float getBud01R1Qte() {
      return this.bud01R1Qte;
   }

   public void setBud01R1Qte(float var1) {
      this.bud01R1Qte = var1;
   }

   public double getBud01R1Val() {
      return this.bud01R1Val;
   }

   public void setBud01R1Val(double var1) {
      this.bud01R1Val = var1;
   }

   public float getBud01R2Qte() {
      return this.bud01R2Qte;
   }

   public void setBud01R2Qte(float var1) {
      this.bud01R2Qte = var1;
   }

   public double getBud01R2Val() {
      return this.bud01R2Val;
   }

   public void setBud01R2Val(double var1) {
      this.bud01R2Val = var1;
   }

   public float getBud01R3Qte() {
      return this.bud01R3Qte;
   }

   public void setBud01R3Qte(float var1) {
      this.bud01R3Qte = var1;
   }

   public double getBud01R3Val() {
      return this.bud01R3Val;
   }

   public void setBud01R3Val(double var1) {
      this.bud01R3Val = var1;
   }

   public float getBud01R4Qte() {
      return this.bud01R4Qte;
   }

   public void setBud01R4Qte(float var1) {
      this.bud01R4Qte = var1;
   }

   public double getBud01R4Val() {
      return this.bud01R4Val;
   }

   public void setBud01R4Val(double var1) {
      this.bud01R4Val = var1;
   }

   public float getBud01TotQte() {
      return this.bud01TotQte;
   }

   public void setBud01TotQte(float var1) {
      this.bud01TotQte = var1;
   }

   public double getBud01TotVal() {
      return this.bud01TotVal;
   }

   public void setBud01TotVal(double var1) {
      this.bud01TotVal = var1;
   }

   public float getBud02R1Qte() {
      return this.bud02R1Qte;
   }

   public void setBud02R1Qte(float var1) {
      this.bud02R1Qte = var1;
   }

   public double getBud02R1Val() {
      return this.bud02R1Val;
   }

   public void setBud02R1Val(double var1) {
      this.bud02R1Val = var1;
   }

   public float getBud02R2Qte() {
      return this.bud02R2Qte;
   }

   public void setBud02R2Qte(float var1) {
      this.bud02R2Qte = var1;
   }

   public double getBud02R2Val() {
      return this.bud02R2Val;
   }

   public void setBud02R2Val(double var1) {
      this.bud02R2Val = var1;
   }

   public float getBud02R3Qte() {
      return this.bud02R3Qte;
   }

   public void setBud02R3Qte(float var1) {
      this.bud02R3Qte = var1;
   }

   public double getBud02R3Val() {
      return this.bud02R3Val;
   }

   public void setBud02R3Val(double var1) {
      this.bud02R3Val = var1;
   }

   public float getBud02R4Qte() {
      return this.bud02R4Qte;
   }

   public void setBud02R4Qte(float var1) {
      this.bud02R4Qte = var1;
   }

   public double getBud02R4Val() {
      return this.bud02R4Val;
   }

   public void setBud02R4Val(double var1) {
      this.bud02R4Val = var1;
   }

   public float getBud02TotQte() {
      return this.bud02TotQte;
   }

   public void setBud02TotQte(float var1) {
      this.bud02TotQte = var1;
   }

   public double getBud02TotVal() {
      return this.bud02TotVal;
   }

   public void setBud02TotVal(double var1) {
      this.bud02TotVal = var1;
   }

   public float getBud03R1Qte() {
      return this.bud03R1Qte;
   }

   public void setBud03R1Qte(float var1) {
      this.bud03R1Qte = var1;
   }

   public double getBud03R1Val() {
      return this.bud03R1Val;
   }

   public void setBud03R1Val(double var1) {
      this.bud03R1Val = var1;
   }

   public float getBud03R2Qte() {
      return this.bud03R2Qte;
   }

   public void setBud03R2Qte(float var1) {
      this.bud03R2Qte = var1;
   }

   public double getBud03R2Val() {
      return this.bud03R2Val;
   }

   public void setBud03R2Val(double var1) {
      this.bud03R2Val = var1;
   }

   public float getBud03R3Qte() {
      return this.bud03R3Qte;
   }

   public void setBud03R3Qte(float var1) {
      this.bud03R3Qte = var1;
   }

   public double getBud03R3Val() {
      return this.bud03R3Val;
   }

   public void setBud03R3Val(double var1) {
      this.bud03R3Val = var1;
   }

   public float getBud03R4Qte() {
      return this.bud03R4Qte;
   }

   public void setBud03R4Qte(float var1) {
      this.bud03R4Qte = var1;
   }

   public float getBud03TotQte() {
      return this.bud03TotQte;
   }

   public void setBud03TotQte(float var1) {
      this.bud03TotQte = var1;
   }

   public double getBud03TotVal() {
      return this.bud03TotVal;
   }

   public void setBud03TotVal(double var1) {
      this.bud03TotVal = var1;
   }

   public float getBud04R1Qte() {
      return this.bud04R1Qte;
   }

   public void setBud04R1Qte(float var1) {
      this.bud04R1Qte = var1;
   }

   public double getBud04R1Val() {
      return this.bud04R1Val;
   }

   public void setBud04R1Val(double var1) {
      this.bud04R1Val = var1;
   }

   public float getBud04R2Qte() {
      return this.bud04R2Qte;
   }

   public void setBud04R2Qte(float var1) {
      this.bud04R2Qte = var1;
   }

   public double getBud04R2Val() {
      return this.bud04R2Val;
   }

   public void setBud04R2Val(double var1) {
      this.bud04R2Val = var1;
   }

   public float getBud04R3Qte() {
      return this.bud04R3Qte;
   }

   public void setBud04R3Qte(float var1) {
      this.bud04R3Qte = var1;
   }

   public double getBud04R3Val() {
      return this.bud04R3Val;
   }

   public void setBud04R3Val(double var1) {
      this.bud04R3Val = var1;
   }

   public float getBud04R4Qte() {
      return this.bud04R4Qte;
   }

   public void setBud04R4Qte(float var1) {
      this.bud04R4Qte = var1;
   }

   public double getBud04R4Val() {
      return this.bud04R4Val;
   }

   public void setBud04R4Val(double var1) {
      this.bud04R4Val = var1;
   }

   public float getBud04TotQte() {
      return this.bud04TotQte;
   }

   public void setBud04TotQte(float var1) {
      this.bud04TotQte = var1;
   }

   public double getBud04TotVal() {
      return this.bud04TotVal;
   }

   public void setBud04TotVal(double var1) {
      this.bud04TotVal = var1;
   }

   public float getBud05R1Qte() {
      return this.bud05R1Qte;
   }

   public void setBud05R1Qte(float var1) {
      this.bud05R1Qte = var1;
   }

   public double getBud05R1Val() {
      return this.bud05R1Val;
   }

   public void setBud05R1Val(double var1) {
      this.bud05R1Val = var1;
   }

   public float getBud05R2Qte() {
      return this.bud05R2Qte;
   }

   public void setBud05R2Qte(float var1) {
      this.bud05R2Qte = var1;
   }

   public double getBud05R2Val() {
      return this.bud05R2Val;
   }

   public void setBud05R2Val(double var1) {
      this.bud05R2Val = var1;
   }

   public float getBud05R3Qte() {
      return this.bud05R3Qte;
   }

   public void setBud05R3Qte(float var1) {
      this.bud05R3Qte = var1;
   }

   public double getBud05R3Val() {
      return this.bud05R3Val;
   }

   public void setBud05R3Val(double var1) {
      this.bud05R3Val = var1;
   }

   public float getBud05R4Qte() {
      return this.bud05R4Qte;
   }

   public void setBud05R4Qte(float var1) {
      this.bud05R4Qte = var1;
   }

   public double getBud05R4Val() {
      return this.bud05R4Val;
   }

   public void setBud05R4Val(double var1) {
      this.bud05R4Val = var1;
   }

   public float getBud06R1Qte() {
      return this.bud06R1Qte;
   }

   public void setBud06R1Qte(float var1) {
      this.bud06R1Qte = var1;
   }

   public double getBud06R1Val() {
      return this.bud06R1Val;
   }

   public void setBud06R1Val(double var1) {
      this.bud06R1Val = var1;
   }

   public float getBud06R2Qte() {
      return this.bud06R2Qte;
   }

   public void setBud06R2Qte(float var1) {
      this.bud06R2Qte = var1;
   }

   public double getBud06R2Val() {
      return this.bud06R2Val;
   }

   public void setBud06R2Val(double var1) {
      this.bud06R2Val = var1;
   }

   public float getBud06R3Qte() {
      return this.bud06R3Qte;
   }

   public void setBud06R3Qte(float var1) {
      this.bud06R3Qte = var1;
   }

   public double getBud06R3Val() {
      return this.bud06R3Val;
   }

   public void setBud06R3Val(double var1) {
      this.bud06R3Val = var1;
   }

   public float getBud06R4Qte() {
      return this.bud06R4Qte;
   }

   public void setBud06R4Qte(float var1) {
      this.bud06R4Qte = var1;
   }

   public double getBud06R4Val() {
      return this.bud06R4Val;
   }

   public void setBud06R4Val(double var1) {
      this.bud06R4Val = var1;
   }

   public float getBud07R1Qte() {
      return this.bud07R1Qte;
   }

   public void setBud07R1Qte(float var1) {
      this.bud07R1Qte = var1;
   }

   public double getBud07R1Val() {
      return this.bud07R1Val;
   }

   public void setBud07R1Val(double var1) {
      this.bud07R1Val = var1;
   }

   public float getBud07R2Qte() {
      return this.bud07R2Qte;
   }

   public void setBud07R2Qte(float var1) {
      this.bud07R2Qte = var1;
   }

   public double getBud07R2Val() {
      return this.bud07R2Val;
   }

   public void setBud07R2Val(double var1) {
      this.bud07R2Val = var1;
   }

   public float getBud07R3Qte() {
      return this.bud07R3Qte;
   }

   public void setBud07R3Qte(float var1) {
      this.bud07R3Qte = var1;
   }

   public double getBud07R3Val() {
      return this.bud07R3Val;
   }

   public void setBud07R3Val(double var1) {
      this.bud07R3Val = var1;
   }

   public float getBud07R4Qte() {
      return this.bud07R4Qte;
   }

   public void setBud07R4Qte(float var1) {
      this.bud07R4Qte = var1;
   }

   public double getBud07R4Val() {
      return this.bud07R4Val;
   }

   public void setBud07R4Val(double var1) {
      this.bud07R4Val = var1;
   }

   public float getBud08R1Qte() {
      return this.bud08R1Qte;
   }

   public void setBud08R1Qte(float var1) {
      this.bud08R1Qte = var1;
   }

   public double getBud08R1Val() {
      return this.bud08R1Val;
   }

   public void setBud08R1Val(double var1) {
      this.bud08R1Val = var1;
   }

   public float getBud08R2Qte() {
      return this.bud08R2Qte;
   }

   public void setBud08R2Qte(float var1) {
      this.bud08R2Qte = var1;
   }

   public double getBud08R2Val() {
      return this.bud08R2Val;
   }

   public void setBud08R2Val(double var1) {
      this.bud08R2Val = var1;
   }

   public float getBud08R3Qte() {
      return this.bud08R3Qte;
   }

   public void setBud08R3Qte(float var1) {
      this.bud08R3Qte = var1;
   }

   public double getBud08R3Val() {
      return this.bud08R3Val;
   }

   public void setBud08R3Val(double var1) {
      this.bud08R3Val = var1;
   }

   public float getBud08R4Qte() {
      return this.bud08R4Qte;
   }

   public void setBud08R4Qte(float var1) {
      this.bud08R4Qte = var1;
   }

   public double getBud08R4Val() {
      return this.bud08R4Val;
   }

   public void setBud08R4Val(double var1) {
      this.bud08R4Val = var1;
   }

   public float getBud09R1Qte() {
      return this.bud09R1Qte;
   }

   public void setBud09R1Qte(float var1) {
      this.bud09R1Qte = var1;
   }

   public double getBud09R1Val() {
      return this.bud09R1Val;
   }

   public void setBud09R1Val(double var1) {
      this.bud09R1Val = var1;
   }

   public float getBud09R2Qte() {
      return this.bud09R2Qte;
   }

   public void setBud09R2Qte(float var1) {
      this.bud09R2Qte = var1;
   }

   public double getBud09R2Val() {
      return this.bud09R2Val;
   }

   public void setBud09R2Val(double var1) {
      this.bud09R2Val = var1;
   }

   public float getBud09R3Qte() {
      return this.bud09R3Qte;
   }

   public void setBud09R3Qte(float var1) {
      this.bud09R3Qte = var1;
   }

   public double getBud09R3Val() {
      return this.bud09R3Val;
   }

   public void setBud09R3Val(double var1) {
      this.bud09R3Val = var1;
   }

   public float getBud09R4Qte() {
      return this.bud09R4Qte;
   }

   public void setBud09R4Qte(float var1) {
      this.bud09R4Qte = var1;
   }

   public double getBud09R4Val() {
      return this.bud09R4Val;
   }

   public void setBud09R4Val(double var1) {
      this.bud09R4Val = var1;
   }

   public float getBud10R1Qte() {
      return this.bud10R1Qte;
   }

   public void setBud10R1Qte(float var1) {
      this.bud10R1Qte = var1;
   }

   public double getBud10R1Val() {
      return this.bud10R1Val;
   }

   public void setBud10R1Val(double var1) {
      this.bud10R1Val = var1;
   }

   public float getBud10R2Qte() {
      return this.bud10R2Qte;
   }

   public void setBud10R2Qte(float var1) {
      this.bud10R2Qte = var1;
   }

   public double getBud10R2Val() {
      return this.bud10R2Val;
   }

   public void setBud10R2Val(double var1) {
      this.bud10R2Val = var1;
   }

   public float getBud10R3Qte() {
      return this.bud10R3Qte;
   }

   public void setBud10R3Qte(float var1) {
      this.bud10R3Qte = var1;
   }

   public double getBud10R3Val() {
      return this.bud10R3Val;
   }

   public void setBud10R3Val(double var1) {
      this.bud10R3Val = var1;
   }

   public float getBud10R4Qte() {
      return this.bud10R4Qte;
   }

   public void setBud10R4Qte(float var1) {
      this.bud10R4Qte = var1;
   }

   public double getBud10R4Val() {
      return this.bud10R4Val;
   }

   public void setBud10R4Val(double var1) {
      this.bud10R4Val = var1;
   }

   public float getBud11R1Qte() {
      return this.bud11R1Qte;
   }

   public void setBud11R1Qte(float var1) {
      this.bud11R1Qte = var1;
   }

   public double getBud11R1Val() {
      return this.bud11R1Val;
   }

   public void setBud11R1Val(double var1) {
      this.bud11R1Val = var1;
   }

   public float getBud11R2Qte() {
      return this.bud11R2Qte;
   }

   public void setBud11R2Qte(float var1) {
      this.bud11R2Qte = var1;
   }

   public double getBud11R2Val() {
      return this.bud11R2Val;
   }

   public void setBud11R2Val(double var1) {
      this.bud11R2Val = var1;
   }

   public float getBud11R3Qte() {
      return this.bud11R3Qte;
   }

   public void setBud11R3Qte(float var1) {
      this.bud11R3Qte = var1;
   }

   public double getBud11R3Val() {
      return this.bud11R3Val;
   }

   public void setBud11R3Val(double var1) {
      this.bud11R3Val = var1;
   }

   public float getBud11R4Qte() {
      return this.bud11R4Qte;
   }

   public void setBud11R4Qte(float var1) {
      this.bud11R4Qte = var1;
   }

   public double getBud11R4Val() {
      return this.bud11R4Val;
   }

   public void setBud11R4Val(double var1) {
      this.bud11R4Val = var1;
   }

   public float getBud12R1Qte() {
      return this.bud12R1Qte;
   }

   public void setBud12R1Qte(float var1) {
      this.bud12R1Qte = var1;
   }

   public double getBud12R1Val() {
      return this.bud12R1Val;
   }

   public void setBud12R1Val(double var1) {
      this.bud12R1Val = var1;
   }

   public float getBud12R2Qte() {
      return this.bud12R2Qte;
   }

   public void setBud12R2Qte(float var1) {
      this.bud12R2Qte = var1;
   }

   public double getBud12R2Val() {
      return this.bud12R2Val;
   }

   public void setBud12R2Val(double var1) {
      this.bud12R2Val = var1;
   }

   public float getBud12R3Qte() {
      return this.bud12R3Qte;
   }

   public void setBud12R3Qte(float var1) {
      this.bud12R3Qte = var1;
   }

   public double getBud12R3Val() {
      return this.bud12R3Val;
   }

   public void setBud12R3Val(double var1) {
      this.bud12R3Val = var1;
   }

   public float getBud12R4Qte() {
      return this.bud12R4Qte;
   }

   public void setBud12R4Qte(float var1) {
      this.bud12R4Qte = var1;
   }

   public double getBud12R4Val() {
      return this.bud12R4Val;
   }

   public void setBud12R4Val(double var1) {
      this.bud12R4Val = var1;
   }

   public double getBud03R4Val() {
      return this.bud03R4Val;
   }

   public void setBud03R4Val(double var1) {
      this.bud03R4Val = var1;
   }

   public int getChoixReam() {
      return this.choixReam;
   }

   public void setChoixReam(int var1) {
      this.choixReam = var1;
   }

   public long getBudIdOld() {
      return this.budIdOld;
   }

   public void setBudIdOld(long var1) {
      this.budIdOld = var1;
   }

   public int getBudType() {
      return this.budType;
   }

   public void setBudType(int var1) {
      this.budType = var1;
   }

   public String getBudProjet() {
      return this.budProjet;
   }

   public void setBudProjet(String var1) {
      this.budProjet = var1;
   }

   public boolean isBudAxe01() {
      return this.budAxe01;
   }

   public void setBudAxe01(boolean var1) {
      this.budAxe01 = var1;
   }

   public boolean isBudAxe02() {
      return this.budAxe02;
   }

   public void setBudAxe02(boolean var1) {
      this.budAxe02 = var1;
   }

   public boolean isBudAxe03() {
      return this.budAxe03;
   }

   public void setBudAxe03(boolean var1) {
      this.budAxe03 = var1;
   }

   public boolean isBudAxe04() {
      return this.budAxe04;
   }

   public void setBudAxe04(boolean var1) {
      this.budAxe04 = var1;
   }

   public boolean isBudAxe05() {
      return this.budAxe05;
   }

   public void setBudAxe05(boolean var1) {
      this.budAxe05 = var1;
   }

   public boolean isBudAxe06() {
      return this.budAxe06;
   }

   public void setBudAxe06(boolean var1) {
      this.budAxe06 = var1;
   }

   public boolean isBudAxe07() {
      return this.budAxe07;
   }

   public void setBudAxe07(boolean var1) {
      this.budAxe07 = var1;
   }

   public boolean isBudAxe08() {
      return this.budAxe08;
   }

   public void setBudAxe08(boolean var1) {
      this.budAxe08 = var1;
   }

   public boolean isBudAxe09() {
      return this.budAxe09;
   }

   public void setBudAxe09(boolean var1) {
      this.budAxe09 = var1;
   }

   public boolean isBudAxe10() {
      return this.budAxe10;
   }

   public void setBudAxe10(boolean var1) {
      this.budAxe10 = var1;
   }

   public boolean isBudAxe11() {
      return this.budAxe11;
   }

   public void setBudAxe11(boolean var1) {
      this.budAxe11 = var1;
   }

   public boolean isBudAxe12() {
      return this.budAxe12;
   }

   public void setBudAxe12(boolean var1) {
      this.budAxe12 = var1;
   }

   public boolean isBudAxe13() {
      return this.budAxe13;
   }

   public void setBudAxe13(boolean var1) {
      this.budAxe13 = var1;
   }

   public String getBudEntite() {
      return this.budEntite;
   }

   public void setBudEntite(String var1) {
      this.budEntite = var1;
   }
}
