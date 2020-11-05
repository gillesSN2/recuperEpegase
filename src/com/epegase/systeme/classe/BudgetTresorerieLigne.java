package com.epegase.systeme.classe;

import java.io.Serializable;

public class BudgetTresorerieLigne implements Serializable {
   private long budlig_id;
   private String budligCode;
   private int budligUtil;
   private String budligActivite;
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
   private BudgetTresorerie budgetTresorerie;
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
   private String espaceFamille;

   public String getEspaceFamille() {
      if (this.budgetTresorerie.getBudSens() == 2) {
         this.espaceFamille = "font-weight:bold;";
      } else {
         this.espaceFamille = "width:100%;";
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public int getChoixReam() {
      return this.choixReam;
   }

   public void setChoixReam(int var1) {
      this.choixReam = var1;
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

   public BudgetTresorerie getBudgetTresorerie() {
      return this.budgetTresorerie;
   }

   public void setBudgetTresorerie(BudgetTresorerie var1) {
      this.budgetTresorerie = var1;
   }

   public double getBudlig01R1Val() {
      return this.budlig01R1Val;
   }

   public void setBudlig01R1Val(double var1) {
      this.budlig01R1Val = var1;
   }

   public double getBudlig01R2Val() {
      return this.budlig01R2Val;
   }

   public void setBudlig01R2Val(double var1) {
      this.budlig01R2Val = var1;
   }

   public double getBudlig01R3Val() {
      return this.budlig01R3Val;
   }

   public void setBudlig01R3Val(double var1) {
      this.budlig01R3Val = var1;
   }

   public double getBudlig01R4Val() {
      return this.budlig01R4Val;
   }

   public void setBudlig01R4Val(double var1) {
      this.budlig01R4Val = var1;
   }

   public double getBudlig01TotVal() {
      return this.budlig01TotVal;
   }

   public void setBudlig01TotVal(double var1) {
      this.budlig01TotVal = var1;
   }

   public double getBudlig02R1Val() {
      return this.budlig02R1Val;
   }

   public void setBudlig02R1Val(double var1) {
      this.budlig02R1Val = var1;
   }

   public double getBudlig02R2Val() {
      return this.budlig02R2Val;
   }

   public void setBudlig02R2Val(double var1) {
      this.budlig02R2Val = var1;
   }

   public double getBudlig02R3Val() {
      return this.budlig02R3Val;
   }

   public void setBudlig02R3Val(double var1) {
      this.budlig02R3Val = var1;
   }

   public double getBudlig02R4Val() {
      return this.budlig02R4Val;
   }

   public void setBudlig02R4Val(double var1) {
      this.budlig02R4Val = var1;
   }

   public double getBudlig02TotVal() {
      return this.budlig02TotVal;
   }

   public void setBudlig02TotVal(double var1) {
      this.budlig02TotVal = var1;
   }

   public double getBudlig03R1Val() {
      return this.budlig03R1Val;
   }

   public void setBudlig03R1Val(double var1) {
      this.budlig03R1Val = var1;
   }

   public double getBudlig03R2Val() {
      return this.budlig03R2Val;
   }

   public void setBudlig03R2Val(double var1) {
      this.budlig03R2Val = var1;
   }

   public double getBudlig03R3Val() {
      return this.budlig03R3Val;
   }

   public void setBudlig03R3Val(double var1) {
      this.budlig03R3Val = var1;
   }

   public double getBudlig03R4Val() {
      return this.budlig03R4Val;
   }

   public void setBudlig03R4Val(double var1) {
      this.budlig03R4Val = var1;
   }

   public double getBudlig03TotVal() {
      return this.budlig03TotVal;
   }

   public void setBudlig03TotVal(double var1) {
      this.budlig03TotVal = var1;
   }

   public double getBudlig04R1Val() {
      return this.budlig04R1Val;
   }

   public void setBudlig04R1Val(double var1) {
      this.budlig04R1Val = var1;
   }

   public double getBudlig04R2Val() {
      return this.budlig04R2Val;
   }

   public void setBudlig04R2Val(double var1) {
      this.budlig04R2Val = var1;
   }

   public double getBudlig04R3Val() {
      return this.budlig04R3Val;
   }

   public void setBudlig04R3Val(double var1) {
      this.budlig04R3Val = var1;
   }

   public double getBudlig04R4Val() {
      return this.budlig04R4Val;
   }

   public void setBudlig04R4Val(double var1) {
      this.budlig04R4Val = var1;
   }

   public double getBudlig04TotVal() {
      return this.budlig04TotVal;
   }

   public void setBudlig04TotVal(double var1) {
      this.budlig04TotVal = var1;
   }

   public double getBudlig05R1Val() {
      return this.budlig05R1Val;
   }

   public void setBudlig05R1Val(double var1) {
      this.budlig05R1Val = var1;
   }

   public double getBudlig05R2Val() {
      return this.budlig05R2Val;
   }

   public void setBudlig05R2Val(double var1) {
      this.budlig05R2Val = var1;
   }

   public double getBudlig05R3Val() {
      return this.budlig05R3Val;
   }

   public void setBudlig05R3Val(double var1) {
      this.budlig05R3Val = var1;
   }

   public double getBudlig05R4Val() {
      return this.budlig05R4Val;
   }

   public void setBudlig05R4Val(double var1) {
      this.budlig05R4Val = var1;
   }

   public double getBudlig06R1Val() {
      return this.budlig06R1Val;
   }

   public void setBudlig06R1Val(double var1) {
      this.budlig06R1Val = var1;
   }

   public double getBudlig06R2Val() {
      return this.budlig06R2Val;
   }

   public void setBudlig06R2Val(double var1) {
      this.budlig06R2Val = var1;
   }

   public double getBudlig06R3Val() {
      return this.budlig06R3Val;
   }

   public void setBudlig06R3Val(double var1) {
      this.budlig06R3Val = var1;
   }

   public double getBudlig06R4Val() {
      return this.budlig06R4Val;
   }

   public void setBudlig06R4Val(double var1) {
      this.budlig06R4Val = var1;
   }

   public double getBudlig07R1Val() {
      return this.budlig07R1Val;
   }

   public void setBudlig07R1Val(double var1) {
      this.budlig07R1Val = var1;
   }

   public double getBudlig07R2Val() {
      return this.budlig07R2Val;
   }

   public void setBudlig07R2Val(double var1) {
      this.budlig07R2Val = var1;
   }

   public double getBudlig07R3Val() {
      return this.budlig07R3Val;
   }

   public void setBudlig07R3Val(double var1) {
      this.budlig07R3Val = var1;
   }

   public double getBudlig07R4Val() {
      return this.budlig07R4Val;
   }

   public void setBudlig07R4Val(double var1) {
      this.budlig07R4Val = var1;
   }

   public double getBudlig08R1Val() {
      return this.budlig08R1Val;
   }

   public void setBudlig08R1Val(double var1) {
      this.budlig08R1Val = var1;
   }

   public double getBudlig08R2Val() {
      return this.budlig08R2Val;
   }

   public void setBudlig08R2Val(double var1) {
      this.budlig08R2Val = var1;
   }

   public double getBudlig08R3Val() {
      return this.budlig08R3Val;
   }

   public void setBudlig08R3Val(double var1) {
      this.budlig08R3Val = var1;
   }

   public double getBudlig08R4Val() {
      return this.budlig08R4Val;
   }

   public void setBudlig08R4Val(double var1) {
      this.budlig08R4Val = var1;
   }

   public double getBudlig09R1Val() {
      return this.budlig09R1Val;
   }

   public void setBudlig09R1Val(double var1) {
      this.budlig09R1Val = var1;
   }

   public double getBudlig09R2Val() {
      return this.budlig09R2Val;
   }

   public void setBudlig09R2Val(double var1) {
      this.budlig09R2Val = var1;
   }

   public double getBudlig09R3Val() {
      return this.budlig09R3Val;
   }

   public void setBudlig09R3Val(double var1) {
      this.budlig09R3Val = var1;
   }

   public double getBudlig09R4Val() {
      return this.budlig09R4Val;
   }

   public void setBudlig09R4Val(double var1) {
      this.budlig09R4Val = var1;
   }

   public double getBudlig10R1Val() {
      return this.budlig10R1Val;
   }

   public void setBudlig10R1Val(double var1) {
      this.budlig10R1Val = var1;
   }

   public double getBudlig10R2Val() {
      return this.budlig10R2Val;
   }

   public void setBudlig10R2Val(double var1) {
      this.budlig10R2Val = var1;
   }

   public double getBudlig10R3Val() {
      return this.budlig10R3Val;
   }

   public void setBudlig10R3Val(double var1) {
      this.budlig10R3Val = var1;
   }

   public double getBudlig10R4Val() {
      return this.budlig10R4Val;
   }

   public void setBudlig10R4Val(double var1) {
      this.budlig10R4Val = var1;
   }

   public double getBudlig11R1Val() {
      return this.budlig11R1Val;
   }

   public void setBudlig11R1Val(double var1) {
      this.budlig11R1Val = var1;
   }

   public double getBudlig11R2Val() {
      return this.budlig11R2Val;
   }

   public void setBudlig11R2Val(double var1) {
      this.budlig11R2Val = var1;
   }

   public double getBudlig11R3Val() {
      return this.budlig11R3Val;
   }

   public void setBudlig11R3Val(double var1) {
      this.budlig11R3Val = var1;
   }

   public double getBudlig11R4Val() {
      return this.budlig11R4Val;
   }

   public void setBudlig11R4Val(double var1) {
      this.budlig11R4Val = var1;
   }

   public double getBudlig12R1Val() {
      return this.budlig12R1Val;
   }

   public void setBudlig12R1Val(double var1) {
      this.budlig12R1Val = var1;
   }

   public double getBudlig12R2Val() {
      return this.budlig12R2Val;
   }

   public void setBudlig12R2Val(double var1) {
      this.budlig12R2Val = var1;
   }

   public double getBudlig12R3Val() {
      return this.budlig12R3Val;
   }

   public void setBudlig12R3Val(double var1) {
      this.budlig12R3Val = var1;
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
      this.lib_reamenagement = var1;
   }

   public float getLigqteTotal() {
      return this.ligqteTotal;
   }

   public void setLigqteTotal(float var1) {
      this.ligqteTotal = var1;
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
}
