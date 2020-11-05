package com.epegase.systeme.classe;

import java.io.Serializable;

public class PegTabElement implements Serializable {
   private long tabele_id;
   private String tabeleZone;
   private String tabeleReference;
   private String tabeleLibFR;
   private String tabeleLibUK;
   private String tabeleLibSP;
   private int tabeleNum;
   private int tabeleType;
   private int tabeleMode;
   private boolean tabeleInactif;
   private int tabeleTypeCol01;
   private int tabeleTypeCol02;
   private int tabeleTypeCol03;
   private int tabeleTypeCol04;
   private int tabeleTypeCol05;
   private int tabeleTypeCol06;
   private int tabeleTypeCol07;
   private int tabeleTypeCol08;
   private int tabeleTypeCol09;
   private int tabeleTypeCol10;
   private int tabeleTypeCol11;
   private int tabeleTypeCol12;
   private int tabeleTypeCol13;
   private int tabeleTypeCol14;
   private int tabeleTypeCol15;
   private int tabeleTypeCol16;
   private int tabeleTypeCol17;
   private int tabeleTypeCol18;
   private int tabeleTypeCol19;
   private int tabeleTypeCol20;
   private PegTabNom pegTabNom;
   private String var_type;
   private String var_resultat;

   public String getVar_type() {
      if (this.tabeleType == 0) {
         this.var_type = "Ti.1";
      } else if (this.tabeleType == 1) {
         this.var_type = "Ti.2";
      } else if (this.tabeleType == 2) {
         this.var_type = "Ti.3";
      } else if (this.tabeleType == 3) {
         this.var_type = "Calcul/Saisie";
      } else if (this.tabeleType == 4) {
         this.var_type = "Tot.3";
      } else if (this.tabeleType == 5) {
         this.var_type = "Tot.2";
      } else if (this.tabeleType == 6) {
         this.var_type = "Tot.1";
      } else if (this.tabeleType == 7) {
         this.var_type = "Tit. Cal.";
      }

      return this.var_type;
   }

   public void setVar_type(String var1) {
      this.var_type = var1;
   }

   public String getVar_resultat() {
      if (this.tabeleMode == 0) {
         this.var_resultat = "";
      }

      if (this.tabeleMode == 1) {
         this.var_resultat = "INT.";
      }

      return this.var_resultat;
   }

   public void setVar_resultat(String var1) {
      this.var_resultat = var1;
   }

   public PegTabNom getPegTabNom() {
      return this.pegTabNom;
   }

   public void setPegTabNom(PegTabNom var1) {
      this.pegTabNom = var1;
   }

   public long getTabele_id() {
      return this.tabele_id;
   }

   public void setTabele_id(long var1) {
      this.tabele_id = var1;
   }

   public boolean isTabeleInactif() {
      return this.tabeleInactif;
   }

   public void setTabeleInactif(boolean var1) {
      this.tabeleInactif = var1;
   }

   public String getTabeleLibFR() {
      return this.tabeleLibFR;
   }

   public void setTabeleLibFR(String var1) {
      this.tabeleLibFR = var1;
   }

   public String getTabeleLibSP() {
      return this.tabeleLibSP;
   }

   public void setTabeleLibSP(String var1) {
      this.tabeleLibSP = var1;
   }

   public String getTabeleLibUK() {
      return this.tabeleLibUK;
   }

   public void setTabeleLibUK(String var1) {
      this.tabeleLibUK = var1;
   }

   public int getTabeleMode() {
      return this.tabeleMode;
   }

   public void setTabeleMode(int var1) {
      this.tabeleMode = var1;
   }

   public int getTabeleNum() {
      return this.tabeleNum;
   }

   public void setTabeleNum(int var1) {
      this.tabeleNum = var1;
   }

   public String getTabeleReference() {
      return this.tabeleReference;
   }

   public void setTabeleReference(String var1) {
      this.tabeleReference = var1;
   }

   public int getTabeleType() {
      return this.tabeleType;
   }

   public void setTabeleType(int var1) {
      this.tabeleType = var1;
   }

   public String getTabeleZone() {
      return this.tabeleZone;
   }

   public void setTabeleZone(String var1) {
      this.tabeleZone = var1;
   }

   public int getTabeleTypeCol01() {
      return this.tabeleTypeCol01;
   }

   public void setTabeleTypeCol01(int var1) {
      this.tabeleTypeCol01 = var1;
   }

   public int getTabeleTypeCol02() {
      return this.tabeleTypeCol02;
   }

   public void setTabeleTypeCol02(int var1) {
      this.tabeleTypeCol02 = var1;
   }

   public int getTabeleTypeCol03() {
      return this.tabeleTypeCol03;
   }

   public void setTabeleTypeCol03(int var1) {
      this.tabeleTypeCol03 = var1;
   }

   public int getTabeleTypeCol04() {
      return this.tabeleTypeCol04;
   }

   public void setTabeleTypeCol04(int var1) {
      this.tabeleTypeCol04 = var1;
   }

   public int getTabeleTypeCol05() {
      return this.tabeleTypeCol05;
   }

   public void setTabeleTypeCol05(int var1) {
      this.tabeleTypeCol05 = var1;
   }

   public int getTabeleTypeCol06() {
      return this.tabeleTypeCol06;
   }

   public void setTabeleTypeCol06(int var1) {
      this.tabeleTypeCol06 = var1;
   }

   public int getTabeleTypeCol07() {
      return this.tabeleTypeCol07;
   }

   public void setTabeleTypeCol07(int var1) {
      this.tabeleTypeCol07 = var1;
   }

   public int getTabeleTypeCol08() {
      return this.tabeleTypeCol08;
   }

   public void setTabeleTypeCol08(int var1) {
      this.tabeleTypeCol08 = var1;
   }

   public int getTabeleTypeCol09() {
      return this.tabeleTypeCol09;
   }

   public void setTabeleTypeCol09(int var1) {
      this.tabeleTypeCol09 = var1;
   }

   public int getTabeleTypeCol10() {
      return this.tabeleTypeCol10;
   }

   public void setTabeleTypeCol10(int var1) {
      this.tabeleTypeCol10 = var1;
   }

   public int getTabeleTypeCol11() {
      return this.tabeleTypeCol11;
   }

   public void setTabeleTypeCol11(int var1) {
      this.tabeleTypeCol11 = var1;
   }

   public int getTabeleTypeCol12() {
      return this.tabeleTypeCol12;
   }

   public void setTabeleTypeCol12(int var1) {
      this.tabeleTypeCol12 = var1;
   }

   public int getTabeleTypeCol13() {
      return this.tabeleTypeCol13;
   }

   public void setTabeleTypeCol13(int var1) {
      this.tabeleTypeCol13 = var1;
   }

   public int getTabeleTypeCol14() {
      return this.tabeleTypeCol14;
   }

   public void setTabeleTypeCol14(int var1) {
      this.tabeleTypeCol14 = var1;
   }

   public int getTabeleTypeCol15() {
      return this.tabeleTypeCol15;
   }

   public void setTabeleTypeCol15(int var1) {
      this.tabeleTypeCol15 = var1;
   }

   public int getTabeleTypeCol16() {
      return this.tabeleTypeCol16;
   }

   public void setTabeleTypeCol16(int var1) {
      this.tabeleTypeCol16 = var1;
   }

   public int getTabeleTypeCol17() {
      return this.tabeleTypeCol17;
   }

   public void setTabeleTypeCol17(int var1) {
      this.tabeleTypeCol17 = var1;
   }

   public int getTabeleTypeCol18() {
      return this.tabeleTypeCol18;
   }

   public void setTabeleTypeCol18(int var1) {
      this.tabeleTypeCol18 = var1;
   }

   public int getTabeleTypeCol19() {
      return this.tabeleTypeCol19;
   }

   public void setTabeleTypeCol19(int var1) {
      this.tabeleTypeCol19 = var1;
   }

   public int getTabeleTypeCol20() {
      return this.tabeleTypeCol20;
   }

   public void setTabeleTypeCol20(int var1) {
      this.tabeleTypeCol20 = var1;
   }
}
