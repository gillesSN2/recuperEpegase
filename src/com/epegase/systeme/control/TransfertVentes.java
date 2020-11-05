package com.epegase.systeme.control;

import java.io.Serializable;

public class TransfertVentes implements Serializable {
   private String trfColT00;
   private String trfColT01;
   private String trfColT02;
   private String trfColT03;
   private String trfColT04;
   private String trfColT05;
   private String trfColT06;
   private String trfColT07;
   private String trfColT08;
   private String trfColT09;
   private String trfColT10;
   private String trfColT11;
   private String trfColT12;
   private String trfColT13;
   private String trfColT14;
   private String trfColT15;
   private String trfColT16;
   private String trfColT17;
   private String trfColT18;
   private String trfColT19;
   private String trfColT20;
   private String trfColT21;
   private String trfColT22;
   private String trfColT23;
   private String trfColT24;
   private String trfColT25;
   private String trfColT26;
   private String trfColT27;
   private String trfColT28;
   private String trfColT29;
   private String trfColT30;
   private String trfColT31;
   private String trfColT32;
   private String trfColT33;
   private String trfColT34;
   private String trfColT35;
   private String trfColT36;
   private String trfColT37;
   private String trfColT38;
   private String trfColT39;
   private String trfColT40;
   private double trfColN01;
   private double trfColN02;
   private double trfColN03;
   private double trfColN04;
   private double trfColN05;
   private double trfColN06;
   private double trfColN07;
   private double trfColN08;
   private double trfColN09;
   private double trfColN10;
   private double trfColN11;
   private double trfColN12;
   private double trfColN13;
   private double trfColN14;
   private double trfColN15;
   private double trfColN16;
   private double trfColN17;
   private double trfColN18;
   private double trfColN19;
   private double trfColN20;
   private double trfColN21;
   private double trfColN22;
   private double trfColN23;
   private double trfColN24;
   private double trfColN25;
   private double trfColN26;
   private double trfColN27;
   private double trfColN28;
   private double trfColN29;
   private double trfColN30;
   private double trfColN31;
   private double trfColN32;
   private double trfColN33;
   private double trfColN34;
   private double trfColN35;
   private double trfColN36;
   private double trfColN37;
   private double trfColN38;
   private double trfColN39;
   private double trfColN40;
   private int trfTypeImport;
   private String trfNomFeuille;
   private String trfPeriode;
   private String libelleEtat;
   private String stylePolice;

   public String getStylePolice() {
      if (this.trfNomFeuille != null && !this.trfNomFeuille.isEmpty()) {
         if (this.trfNomFeuille.equals("RUBRIQUE")) {
            this.stylePolice = "font-weight:bold";
         } else {
            this.stylePolice = "width:100%";
         }
      } else {
         this.stylePolice = "width:100%";
      }

      return this.stylePolice;
   }

   public void setStylePolice(String var1) {
      this.stylePolice = var1;
   }

   public String getLibelleEtat() {
      if (this.trfColN05 == 1.0D) {
         this.libelleEtat = "Gelé(e)";
      } else {
         this.libelleEtat = "";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public double getTrfColN01() {
      return this.trfColN01;
   }

   public void setTrfColN01(double var1) {
      this.trfColN01 = var1;
   }

   public double getTrfColN02() {
      return this.trfColN02;
   }

   public void setTrfColN02(double var1) {
      this.trfColN02 = var1;
   }

   public double getTrfColN03() {
      return this.trfColN03;
   }

   public void setTrfColN03(double var1) {
      this.trfColN03 = var1;
   }

   public double getTrfColN04() {
      return this.trfColN04;
   }

   public void setTrfColN04(double var1) {
      this.trfColN04 = var1;
   }

   public double getTrfColN05() {
      return this.trfColN05;
   }

   public void setTrfColN05(double var1) {
      this.trfColN05 = var1;
   }

   public double getTrfColN06() {
      return this.trfColN06;
   }

   public void setTrfColN06(double var1) {
      this.trfColN06 = var1;
   }

   public double getTrfColN07() {
      return this.trfColN07;
   }

   public void setTrfColN07(double var1) {
      this.trfColN07 = var1;
   }

   public double getTrfColN08() {
      return this.trfColN08;
   }

   public void setTrfColN08(double var1) {
      this.trfColN08 = var1;
   }

   public double getTrfColN09() {
      return this.trfColN09;
   }

   public void setTrfColN09(double var1) {
      this.trfColN09 = var1;
   }

   public double getTrfColN10() {
      return this.trfColN10;
   }

   public void setTrfColN10(double var1) {
      this.trfColN10 = var1;
   }

   public double getTrfColN11() {
      return this.trfColN11;
   }

   public void setTrfColN11(double var1) {
      this.trfColN11 = var1;
   }

   public double getTrfColN12() {
      return this.trfColN12;
   }

   public void setTrfColN12(double var1) {
      this.trfColN12 = var1;
   }

   public double getTrfColN13() {
      return this.trfColN13;
   }

   public void setTrfColN13(double var1) {
      this.trfColN13 = var1;
   }

   public double getTrfColN14() {
      return this.trfColN14;
   }

   public void setTrfColN14(double var1) {
      this.trfColN14 = var1;
   }

   public double getTrfColN15() {
      return this.trfColN15;
   }

   public void setTrfColN15(double var1) {
      this.trfColN15 = var1;
   }

   public double getTrfColN16() {
      return this.trfColN16;
   }

   public void setTrfColN16(double var1) {
      this.trfColN16 = var1;
   }

   public double getTrfColN17() {
      return this.trfColN17;
   }

   public void setTrfColN17(double var1) {
      this.trfColN17 = var1;
   }

   public double getTrfColN18() {
      return this.trfColN18;
   }

   public void setTrfColN18(double var1) {
      this.trfColN18 = var1;
   }

   public double getTrfColN19() {
      return this.trfColN19;
   }

   public void setTrfColN19(double var1) {
      this.trfColN19 = var1;
   }

   public double getTrfColN20() {
      return this.trfColN20;
   }

   public void setTrfColN20(double var1) {
      this.trfColN20 = var1;
   }

   public double getTrfColN21() {
      return this.trfColN21;
   }

   public void setTrfColN21(double var1) {
      this.trfColN21 = var1;
   }

   public double getTrfColN22() {
      return this.trfColN22;
   }

   public void setTrfColN22(double var1) {
      this.trfColN22 = var1;
   }

   public double getTrfColN23() {
      return this.trfColN23;
   }

   public void setTrfColN23(double var1) {
      this.trfColN23 = var1;
   }

   public double getTrfColN24() {
      return this.trfColN24;
   }

   public void setTrfColN24(double var1) {
      this.trfColN24 = var1;
   }

   public double getTrfColN25() {
      return this.trfColN25;
   }

   public void setTrfColN25(double var1) {
      this.trfColN25 = var1;
   }

   public double getTrfColN26() {
      return this.trfColN26;
   }

   public void setTrfColN26(double var1) {
      this.trfColN26 = var1;
   }

   public double getTrfColN27() {
      return this.trfColN27;
   }

   public void setTrfColN27(double var1) {
      this.trfColN27 = var1;
   }

   public double getTrfColN28() {
      return this.trfColN28;
   }

   public void setTrfColN28(double var1) {
      this.trfColN28 = var1;
   }

   public double getTrfColN29() {
      return this.trfColN29;
   }

   public void setTrfColN29(double var1) {
      this.trfColN29 = var1;
   }

   public double getTrfColN30() {
      return this.trfColN30;
   }

   public void setTrfColN30(double var1) {
      this.trfColN30 = var1;
   }

   public double getTrfColN31() {
      return this.trfColN31;
   }

   public void setTrfColN31(double var1) {
      this.trfColN31 = var1;
   }

   public double getTrfColN32() {
      return this.trfColN32;
   }

   public void setTrfColN32(double var1) {
      this.trfColN32 = var1;
   }

   public double getTrfColN33() {
      return this.trfColN33;
   }

   public void setTrfColN33(double var1) {
      this.trfColN33 = var1;
   }

   public double getTrfColN34() {
      return this.trfColN34;
   }

   public void setTrfColN34(double var1) {
      this.trfColN34 = var1;
   }

   public double getTrfColN35() {
      return this.trfColN35;
   }

   public void setTrfColN35(double var1) {
      this.trfColN35 = var1;
   }

   public double getTrfColN36() {
      return this.trfColN36;
   }

   public void setTrfColN36(double var1) {
      this.trfColN36 = var1;
   }

   public double getTrfColN37() {
      return this.trfColN37;
   }

   public void setTrfColN37(double var1) {
      this.trfColN37 = var1;
   }

   public double getTrfColN38() {
      return this.trfColN38;
   }

   public void setTrfColN38(double var1) {
      this.trfColN38 = var1;
   }

   public double getTrfColN39() {
      return this.trfColN39;
   }

   public void setTrfColN39(double var1) {
      this.trfColN39 = var1;
   }

   public double getTrfColN40() {
      return this.trfColN40;
   }

   public void setTrfColN40(double var1) {
      this.trfColN40 = var1;
   }

   public String getTrfColT01() {
      return this.trfColT01;
   }

   public void setTrfColT01(String var1) {
      this.trfColT01 = var1;
   }

   public String getTrfColT02() {
      return this.trfColT02;
   }

   public void setTrfColT02(String var1) {
      this.trfColT02 = var1;
   }

   public String getTrfColT03() {
      return this.trfColT03;
   }

   public void setTrfColT03(String var1) {
      this.trfColT03 = var1;
   }

   public String getTrfColT04() {
      return this.trfColT04;
   }

   public void setTrfColT04(String var1) {
      this.trfColT04 = var1;
   }

   public String getTrfColT05() {
      return this.trfColT05;
   }

   public void setTrfColT05(String var1) {
      this.trfColT05 = var1;
   }

   public String getTrfColT06() {
      return this.trfColT06;
   }

   public void setTrfColT06(String var1) {
      this.trfColT06 = var1;
   }

   public String getTrfColT07() {
      return this.trfColT07;
   }

   public void setTrfColT07(String var1) {
      this.trfColT07 = var1;
   }

   public String getTrfColT08() {
      return this.trfColT08;
   }

   public void setTrfColT08(String var1) {
      this.trfColT08 = var1;
   }

   public String getTrfColT09() {
      return this.trfColT09;
   }

   public void setTrfColT09(String var1) {
      this.trfColT09 = var1;
   }

   public String getTrfColT10() {
      return this.trfColT10;
   }

   public void setTrfColT10(String var1) {
      this.trfColT10 = var1;
   }

   public String getTrfColT11() {
      return this.trfColT11;
   }

   public void setTrfColT11(String var1) {
      this.trfColT11 = var1;
   }

   public String getTrfColT12() {
      return this.trfColT12;
   }

   public void setTrfColT12(String var1) {
      this.trfColT12 = var1;
   }

   public String getTrfColT13() {
      return this.trfColT13;
   }

   public void setTrfColT13(String var1) {
      this.trfColT13 = var1;
   }

   public String getTrfColT14() {
      return this.trfColT14;
   }

   public void setTrfColT14(String var1) {
      this.trfColT14 = var1;
   }

   public String getTrfColT15() {
      return this.trfColT15;
   }

   public void setTrfColT15(String var1) {
      this.trfColT15 = var1;
   }

   public String getTrfColT16() {
      return this.trfColT16;
   }

   public void setTrfColT16(String var1) {
      this.trfColT16 = var1;
   }

   public String getTrfColT17() {
      return this.trfColT17;
   }

   public void setTrfColT17(String var1) {
      this.trfColT17 = var1;
   }

   public String getTrfColT18() {
      return this.trfColT18;
   }

   public void setTrfColT18(String var1) {
      this.trfColT18 = var1;
   }

   public String getTrfColT19() {
      return this.trfColT19;
   }

   public void setTrfColT19(String var1) {
      this.trfColT19 = var1;
   }

   public String getTrfColT20() {
      return this.trfColT20;
   }

   public void setTrfColT20(String var1) {
      this.trfColT20 = var1;
   }

   public String getTrfColT21() {
      return this.trfColT21;
   }

   public void setTrfColT21(String var1) {
      this.trfColT21 = var1;
   }

   public String getTrfColT22() {
      return this.trfColT22;
   }

   public void setTrfColT22(String var1) {
      this.trfColT22 = var1;
   }

   public String getTrfColT23() {
      return this.trfColT23;
   }

   public void setTrfColT23(String var1) {
      this.trfColT23 = var1;
   }

   public String getTrfColT24() {
      return this.trfColT24;
   }

   public void setTrfColT24(String var1) {
      this.trfColT24 = var1;
   }

   public String getTrfColT25() {
      return this.trfColT25;
   }

   public void setTrfColT25(String var1) {
      this.trfColT25 = var1;
   }

   public String getTrfColT26() {
      return this.trfColT26;
   }

   public void setTrfColT26(String var1) {
      this.trfColT26 = var1;
   }

   public String getTrfColT27() {
      return this.trfColT27;
   }

   public void setTrfColT27(String var1) {
      this.trfColT27 = var1;
   }

   public String getTrfColT28() {
      return this.trfColT28;
   }

   public void setTrfColT28(String var1) {
      this.trfColT28 = var1;
   }

   public String getTrfColT29() {
      return this.trfColT29;
   }

   public void setTrfColT29(String var1) {
      this.trfColT29 = var1;
   }

   public String getTrfColT30() {
      return this.trfColT30;
   }

   public void setTrfColT30(String var1) {
      this.trfColT30 = var1;
   }

   public String getTrfColT31() {
      return this.trfColT31;
   }

   public void setTrfColT31(String var1) {
      this.trfColT31 = var1;
   }

   public String getTrfColT32() {
      return this.trfColT32;
   }

   public void setTrfColT32(String var1) {
      this.trfColT32 = var1;
   }

   public String getTrfColT33() {
      return this.trfColT33;
   }

   public void setTrfColT33(String var1) {
      this.trfColT33 = var1;
   }

   public String getTrfColT34() {
      return this.trfColT34;
   }

   public void setTrfColT34(String var1) {
      this.trfColT34 = var1;
   }

   public String getTrfColT35() {
      return this.trfColT35;
   }

   public void setTrfColT35(String var1) {
      this.trfColT35 = var1;
   }

   public String getTrfColT36() {
      return this.trfColT36;
   }

   public void setTrfColT36(String var1) {
      this.trfColT36 = var1;
   }

   public String getTrfColT37() {
      return this.trfColT37;
   }

   public void setTrfColT37(String var1) {
      this.trfColT37 = var1;
   }

   public String getTrfColT38() {
      return this.trfColT38;
   }

   public void setTrfColT38(String var1) {
      this.trfColT38 = var1;
   }

   public String getTrfColT39() {
      return this.trfColT39;
   }

   public void setTrfColT39(String var1) {
      this.trfColT39 = var1;
   }

   public String getTrfColT40() {
      return this.trfColT40;
   }

   public void setTrfColT40(String var1) {
      this.trfColT40 = var1;
   }

   public int getTrfTypeImport() {
      return this.trfTypeImport;
   }

   public void setTrfTypeImport(int var1) {
      this.trfTypeImport = var1;
   }

   public String getTrfNomFeuille() {
      return this.trfNomFeuille;
   }

   public void setTrfNomFeuille(String var1) {
      this.trfNomFeuille = var1;
   }

   public String getTrfPeriode() {
      return this.trfPeriode;
   }

   public void setTrfPeriode(String var1) {
      this.trfPeriode = var1;
   }

   public String getTrfColT00() {
      return this.trfColT00;
   }

   public void setTrfColT00(String var1) {
      this.trfColT00 = var1;
   }
}
