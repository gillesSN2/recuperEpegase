package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BsoResultats implements Serializable {
   private long tabresId;
   private String tabresCode;
   private String tabresNomFr;
   private String tabresNomUk;
   private String tabresNomSp;
   private long tabresAnnee;
   private Date tabresDateDeb;
   private Date tabresDateFin;
   private int tabresNbMois;
   private int tabresResultatAffecte;
   private int tabresJrSit;
   private int tabresJrRv;
   private String tabresReference;
   private String tabresLibFr;
   private String tabresLibUk;
   private String tabresLibSp;
   private int tabresNum;
   private int tabresType;
   private int tabresMode;
   private int tabresPrint;
   private long tabresIdElement;
   private double tabresCol01;
   private double tabresCol02;
   private double tabresCol03;
   private double tabresCol04;
   private double tabresCol05;
   private double tabresCol06;
   private double tabresCol07;
   private double tabresCol08;
   private double tabresCol09;
   private double tabresCol10;
   private double tabresCol11;
   private double tabresCol12;
   private double tabresCol13;
   private double tabresCol14;
   private double tabresCol15;
   private double tabresCol16;
   private double tabresCol17;
   private double tabresCol18;
   private double tabresCol19;
   private double tabresCol20;
   private String tabresCon01;
   private String tabresCon02;
   private String tabresCon03;
   private String tabresCon04;
   private String tabresCon05;
   private String tabresCon06;
   private String tabresCon07;
   private String tabresCon08;
   private String tabresCon09;
   private String tabresCon10;
   private String tabresCon11;
   private String tabresCon12;
   private String tabresCon13;
   private String tabresCon14;
   private String tabresCon15;
   private String tabresCon16;
   private String tabresCon17;
   private String tabresCon18;
   private String tabresCon19;
   private String tabresCon20;
   private int tabresTypeCol01;
   private int tabresTypeCol02;
   private int tabresTypeCol03;
   private int tabresTypeCol04;
   private int tabresTypeCol05;
   private int tabresTypeCol06;
   private int tabresTypeCol07;
   private int tabresTypeCol08;
   private int tabresTypeCol09;
   private int tabresTypeCol10;
   private int tabresTypeCol11;
   private int tabresTypeCol12;
   private int tabresTypeCol13;
   private int tabresTypeCol14;
   private int tabresTypeCol15;
   private int tabresTypeCol16;
   private int tabresTypeCol17;
   private int tabresTypeCol18;
   private int tabresTypeCol19;
   private int tabresTypeCol20;
   private int tabresFormatCol01;
   private int tabresFormatCol02;
   private int tabresFormatCol03;
   private int tabresFormatCol04;
   private int tabresFormatCol05;
   private int tabresFormatCol06;
   private int tabresFormatCol07;
   private int tabresFormatCol08;
   private int tabresFormatCol09;
   private int tabresFormatCol10;
   private int tabresFormatCol11;
   private int tabresFormatCol12;
   private int tabresFormatCol13;
   private int tabresFormatCol14;
   private int tabresFormatCol15;
   private int tabresFormatCol16;
   private int tabresFormatCol17;
   private int tabresFormatCol18;
   private int tabresFormatCol19;
   private int tabresFormatCol20;
   private ExercicesPaye exercicesPaye;
   private String espaceFamille;

   public String getEspaceFamille() {
      if (this.tabresType >= 0 && this.tabresType <= 2) {
         this.espaceFamille = "text-decoration:underline;";
      } else if (this.tabresType >= 4 && this.tabresType <= 7) {
         this.espaceFamille = "font-weight:bold;";
      } else {
         this.espaceFamille = "width:100%;";
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public long getTabresAnnee() {
      return this.tabresAnnee;
   }

   public void setTabresAnnee(long var1) {
      this.tabresAnnee = var1;
   }

   public String getTabresCode() {
      return this.tabresCode;
   }

   public void setTabresCode(String var1) {
      this.tabresCode = var1;
   }

   public double getTabresCol01() {
      return this.tabresCol01;
   }

   public void setTabresCol01(double var1) {
      this.tabresCol01 = var1;
   }

   public double getTabresCol02() {
      return this.tabresCol02;
   }

   public void setTabresCol02(double var1) {
      this.tabresCol02 = var1;
   }

   public double getTabresCol03() {
      return this.tabresCol03;
   }

   public void setTabresCol03(double var1) {
      this.tabresCol03 = var1;
   }

   public double getTabresCol04() {
      return this.tabresCol04;
   }

   public void setTabresCol04(double var1) {
      this.tabresCol04 = var1;
   }

   public double getTabresCol05() {
      return this.tabresCol05;
   }

   public void setTabresCol05(double var1) {
      this.tabresCol05 = var1;
   }

   public double getTabresCol06() {
      return this.tabresCol06;
   }

   public void setTabresCol06(double var1) {
      this.tabresCol06 = var1;
   }

   public double getTabresCol07() {
      return this.tabresCol07;
   }

   public void setTabresCol07(double var1) {
      this.tabresCol07 = var1;
   }

   public double getTabresCol08() {
      return this.tabresCol08;
   }

   public void setTabresCol08(double var1) {
      this.tabresCol08 = var1;
   }

   public double getTabresCol09() {
      return this.tabresCol09;
   }

   public void setTabresCol09(double var1) {
      this.tabresCol09 = var1;
   }

   public double getTabresCol10() {
      return this.tabresCol10;
   }

   public void setTabresCol10(double var1) {
      this.tabresCol10 = var1;
   }

   public double getTabresCol11() {
      return this.tabresCol11;
   }

   public void setTabresCol11(double var1) {
      this.tabresCol11 = var1;
   }

   public double getTabresCol12() {
      return this.tabresCol12;
   }

   public void setTabresCol12(double var1) {
      this.tabresCol12 = var1;
   }

   public double getTabresCol13() {
      return this.tabresCol13;
   }

   public void setTabresCol13(double var1) {
      this.tabresCol13 = var1;
   }

   public double getTabresCol14() {
      return this.tabresCol14;
   }

   public void setTabresCol14(double var1) {
      this.tabresCol14 = var1;
   }

   public double getTabresCol15() {
      return this.tabresCol15;
   }

   public void setTabresCol15(double var1) {
      this.tabresCol15 = var1;
   }

   public double getTabresCol16() {
      return this.tabresCol16;
   }

   public void setTabresCol16(double var1) {
      this.tabresCol16 = var1;
   }

   public double getTabresCol17() {
      return this.tabresCol17;
   }

   public void setTabresCol17(double var1) {
      this.tabresCol17 = var1;
   }

   public double getTabresCol18() {
      return this.tabresCol18;
   }

   public void setTabresCol18(double var1) {
      this.tabresCol18 = var1;
   }

   public double getTabresCol19() {
      return this.tabresCol19;
   }

   public void setTabresCol19(double var1) {
      this.tabresCol19 = var1;
   }

   public double getTabresCol20() {
      return this.tabresCol20;
   }

   public void setTabresCol20(double var1) {
      this.tabresCol20 = var1;
   }

   public Date getTabresDateDeb() {
      return this.tabresDateDeb;
   }

   public void setTabresDateDeb(Date var1) {
      this.tabresDateDeb = var1;
   }

   public Date getTabresDateFin() {
      return this.tabresDateFin;
   }

   public void setTabresDateFin(Date var1) {
      this.tabresDateFin = var1;
   }

   public long getTabresId() {
      return this.tabresId;
   }

   public void setTabresId(long var1) {
      this.tabresId = var1;
   }

   public int getTabresJrRv() {
      return this.tabresJrRv;
   }

   public void setTabresJrRv(int var1) {
      this.tabresJrRv = var1;
   }

   public int getTabresJrSit() {
      return this.tabresJrSit;
   }

   public void setTabresJrSit(int var1) {
      this.tabresJrSit = var1;
   }

   public String getTabresLibFr() {
      return this.tabresLibFr;
   }

   public void setTabresLibFr(String var1) {
      this.tabresLibFr = var1;
   }

   public String getTabresLibSp() {
      return this.tabresLibSp;
   }

   public void setTabresLibSp(String var1) {
      this.tabresLibSp = var1;
   }

   public String getTabresLibUk() {
      return this.tabresLibUk;
   }

   public void setTabresLibUk(String var1) {
      this.tabresLibUk = var1;
   }

   public int getTabresMode() {
      return this.tabresMode;
   }

   public void setTabresMode(int var1) {
      this.tabresMode = var1;
   }

   public int getTabresNbMois() {
      return this.tabresNbMois;
   }

   public void setTabresNbMois(int var1) {
      this.tabresNbMois = var1;
   }

   public String getTabresNomFr() {
      return this.tabresNomFr;
   }

   public void setTabresNomFr(String var1) {
      this.tabresNomFr = var1;
   }

   public String getTabresNomSp() {
      return this.tabresNomSp;
   }

   public void setTabresNomSp(String var1) {
      this.tabresNomSp = var1;
   }

   public String getTabresNomUk() {
      return this.tabresNomUk;
   }

   public void setTabresNomUk(String var1) {
      this.tabresNomUk = var1;
   }

   public int getTabresNum() {
      return this.tabresNum;
   }

   public void setTabresNum(int var1) {
      this.tabresNum = var1;
   }

   public String getTabresReference() {
      return this.tabresReference;
   }

   public void setTabresReference(String var1) {
      this.tabresReference = var1;
   }

   public int getTabresType() {
      return this.tabresType;
   }

   public void setTabresType(int var1) {
      this.tabresType = var1;
   }

   public String getTabresCon01() {
      return this.tabresCon01;
   }

   public void setTabresCon01(String var1) {
      this.tabresCon01 = var1;
   }

   public String getTabresCon02() {
      return this.tabresCon02;
   }

   public void setTabresCon02(String var1) {
      this.tabresCon02 = var1;
   }

   public String getTabresCon03() {
      return this.tabresCon03;
   }

   public void setTabresCon03(String var1) {
      this.tabresCon03 = var1;
   }

   public String getTabresCon04() {
      return this.tabresCon04;
   }

   public void setTabresCon04(String var1) {
      this.tabresCon04 = var1;
   }

   public String getTabresCon05() {
      return this.tabresCon05;
   }

   public void setTabresCon05(String var1) {
      this.tabresCon05 = var1;
   }

   public String getTabresCon06() {
      return this.tabresCon06;
   }

   public void setTabresCon06(String var1) {
      this.tabresCon06 = var1;
   }

   public String getTabresCon07() {
      return this.tabresCon07;
   }

   public void setTabresCon07(String var1) {
      this.tabresCon07 = var1;
   }

   public String getTabresCon08() {
      return this.tabresCon08;
   }

   public void setTabresCon08(String var1) {
      this.tabresCon08 = var1;
   }

   public String getTabresCon09() {
      return this.tabresCon09;
   }

   public void setTabresCon09(String var1) {
      this.tabresCon09 = var1;
   }

   public String getTabresCon10() {
      return this.tabresCon10;
   }

   public void setTabresCon10(String var1) {
      this.tabresCon10 = var1;
   }

   public String getTabresCon11() {
      return this.tabresCon11;
   }

   public void setTabresCon11(String var1) {
      this.tabresCon11 = var1;
   }

   public String getTabresCon12() {
      return this.tabresCon12;
   }

   public void setTabresCon12(String var1) {
      this.tabresCon12 = var1;
   }

   public String getTabresCon13() {
      return this.tabresCon13;
   }

   public void setTabresCon13(String var1) {
      this.tabresCon13 = var1;
   }

   public String getTabresCon14() {
      return this.tabresCon14;
   }

   public void setTabresCon14(String var1) {
      this.tabresCon14 = var1;
   }

   public String getTabresCon15() {
      return this.tabresCon15;
   }

   public void setTabresCon15(String var1) {
      this.tabresCon15 = var1;
   }

   public String getTabresCon16() {
      return this.tabresCon16;
   }

   public void setTabresCon16(String var1) {
      this.tabresCon16 = var1;
   }

   public String getTabresCon17() {
      return this.tabresCon17;
   }

   public void setTabresCon17(String var1) {
      this.tabresCon17 = var1;
   }

   public String getTabresCon18() {
      return this.tabresCon18;
   }

   public void setTabresCon18(String var1) {
      this.tabresCon18 = var1;
   }

   public String getTabresCon19() {
      return this.tabresCon19;
   }

   public void setTabresCon19(String var1) {
      this.tabresCon19 = var1;
   }

   public String getTabresCon20() {
      return this.tabresCon20;
   }

   public void setTabresCon20(String var1) {
      this.tabresCon20 = var1;
   }

   public long getTabresIdElement() {
      return this.tabresIdElement;
   }

   public void setTabresIdElement(long var1) {
      this.tabresIdElement = var1;
   }

   public int getTabresTypeCol01() {
      return this.tabresTypeCol01;
   }

   public void setTabresTypeCol01(int var1) {
      this.tabresTypeCol01 = var1;
   }

   public int getTabresTypeCol02() {
      return this.tabresTypeCol02;
   }

   public void setTabresTypeCol02(int var1) {
      this.tabresTypeCol02 = var1;
   }

   public int getTabresTypeCol03() {
      return this.tabresTypeCol03;
   }

   public void setTabresTypeCol03(int var1) {
      this.tabresTypeCol03 = var1;
   }

   public int getTabresTypeCol04() {
      return this.tabresTypeCol04;
   }

   public void setTabresTypeCol04(int var1) {
      this.tabresTypeCol04 = var1;
   }

   public int getTabresTypeCol05() {
      return this.tabresTypeCol05;
   }

   public void setTabresTypeCol05(int var1) {
      this.tabresTypeCol05 = var1;
   }

   public int getTabresTypeCol06() {
      return this.tabresTypeCol06;
   }

   public void setTabresTypeCol06(int var1) {
      this.tabresTypeCol06 = var1;
   }

   public int getTabresTypeCol07() {
      return this.tabresTypeCol07;
   }

   public void setTabresTypeCol07(int var1) {
      this.tabresTypeCol07 = var1;
   }

   public int getTabresTypeCol08() {
      return this.tabresTypeCol08;
   }

   public void setTabresTypeCol08(int var1) {
      this.tabresTypeCol08 = var1;
   }

   public int getTabresTypeCol09() {
      return this.tabresTypeCol09;
   }

   public void setTabresTypeCol09(int var1) {
      this.tabresTypeCol09 = var1;
   }

   public int getTabresTypeCol10() {
      return this.tabresTypeCol10;
   }

   public void setTabresTypeCol10(int var1) {
      this.tabresTypeCol10 = var1;
   }

   public int getTabresTypeCol11() {
      return this.tabresTypeCol11;
   }

   public void setTabresTypeCol11(int var1) {
      this.tabresTypeCol11 = var1;
   }

   public int getTabresTypeCol12() {
      return this.tabresTypeCol12;
   }

   public void setTabresTypeCol12(int var1) {
      this.tabresTypeCol12 = var1;
   }

   public int getTabresTypeCol13() {
      return this.tabresTypeCol13;
   }

   public void setTabresTypeCol13(int var1) {
      this.tabresTypeCol13 = var1;
   }

   public int getTabresTypeCol14() {
      return this.tabresTypeCol14;
   }

   public void setTabresTypeCol14(int var1) {
      this.tabresTypeCol14 = var1;
   }

   public int getTabresTypeCol15() {
      return this.tabresTypeCol15;
   }

   public void setTabresTypeCol15(int var1) {
      this.tabresTypeCol15 = var1;
   }

   public int getTabresTypeCol16() {
      return this.tabresTypeCol16;
   }

   public void setTabresTypeCol16(int var1) {
      this.tabresTypeCol16 = var1;
   }

   public int getTabresTypeCol17() {
      return this.tabresTypeCol17;
   }

   public void setTabresTypeCol17(int var1) {
      this.tabresTypeCol17 = var1;
   }

   public int getTabresTypeCol18() {
      return this.tabresTypeCol18;
   }

   public void setTabresTypeCol18(int var1) {
      this.tabresTypeCol18 = var1;
   }

   public int getTabresTypeCol19() {
      return this.tabresTypeCol19;
   }

   public void setTabresTypeCol19(int var1) {
      this.tabresTypeCol19 = var1;
   }

   public int getTabresTypeCol20() {
      return this.tabresTypeCol20;
   }

   public void setTabresTypeCol20(int var1) {
      this.tabresTypeCol20 = var1;
   }

   public int getTabresPrint() {
      return this.tabresPrint;
   }

   public void setTabresPrint(int var1) {
      this.tabresPrint = var1;
   }

   public int getTabresFormatCol01() {
      return this.tabresFormatCol01;
   }

   public void setTabresFormatCol01(int var1) {
      this.tabresFormatCol01 = var1;
   }

   public int getTabresFormatCol02() {
      return this.tabresFormatCol02;
   }

   public void setTabresFormatCol02(int var1) {
      this.tabresFormatCol02 = var1;
   }

   public int getTabresFormatCol03() {
      return this.tabresFormatCol03;
   }

   public void setTabresFormatCol03(int var1) {
      this.tabresFormatCol03 = var1;
   }

   public int getTabresFormatCol04() {
      return this.tabresFormatCol04;
   }

   public void setTabresFormatCol04(int var1) {
      this.tabresFormatCol04 = var1;
   }

   public int getTabresFormatCol05() {
      return this.tabresFormatCol05;
   }

   public void setTabresFormatCol05(int var1) {
      this.tabresFormatCol05 = var1;
   }

   public int getTabresFormatCol06() {
      return this.tabresFormatCol06;
   }

   public void setTabresFormatCol06(int var1) {
      this.tabresFormatCol06 = var1;
   }

   public int getTabresFormatCol07() {
      return this.tabresFormatCol07;
   }

   public void setTabresFormatCol07(int var1) {
      this.tabresFormatCol07 = var1;
   }

   public int getTabresFormatCol08() {
      return this.tabresFormatCol08;
   }

   public void setTabresFormatCol08(int var1) {
      this.tabresFormatCol08 = var1;
   }

   public int getTabresFormatCol09() {
      return this.tabresFormatCol09;
   }

   public void setTabresFormatCol09(int var1) {
      this.tabresFormatCol09 = var1;
   }

   public int getTabresFormatCol10() {
      return this.tabresFormatCol10;
   }

   public void setTabresFormatCol10(int var1) {
      this.tabresFormatCol10 = var1;
   }

   public int getTabresFormatCol11() {
      return this.tabresFormatCol11;
   }

   public void setTabresFormatCol11(int var1) {
      this.tabresFormatCol11 = var1;
   }

   public int getTabresFormatCol12() {
      return this.tabresFormatCol12;
   }

   public void setTabresFormatCol12(int var1) {
      this.tabresFormatCol12 = var1;
   }

   public int getTabresFormatCol13() {
      return this.tabresFormatCol13;
   }

   public void setTabresFormatCol13(int var1) {
      this.tabresFormatCol13 = var1;
   }

   public int getTabresFormatCol14() {
      return this.tabresFormatCol14;
   }

   public void setTabresFormatCol14(int var1) {
      this.tabresFormatCol14 = var1;
   }

   public int getTabresFormatCol15() {
      return this.tabresFormatCol15;
   }

   public void setTabresFormatCol15(int var1) {
      this.tabresFormatCol15 = var1;
   }

   public int getTabresFormatCol16() {
      return this.tabresFormatCol16;
   }

   public void setTabresFormatCol16(int var1) {
      this.tabresFormatCol16 = var1;
   }

   public int getTabresFormatCol17() {
      return this.tabresFormatCol17;
   }

   public void setTabresFormatCol17(int var1) {
      this.tabresFormatCol17 = var1;
   }

   public int getTabresFormatCol18() {
      return this.tabresFormatCol18;
   }

   public void setTabresFormatCol18(int var1) {
      this.tabresFormatCol18 = var1;
   }

   public int getTabresFormatCol19() {
      return this.tabresFormatCol19;
   }

   public void setTabresFormatCol19(int var1) {
      this.tabresFormatCol19 = var1;
   }

   public int getTabresFormatCol20() {
      return this.tabresFormatCol20;
   }

   public void setTabresFormatCol20(int var1) {
      this.tabresFormatCol20 = var1;
   }

   public int getTabresResultatAffecte() {
      return this.tabresResultatAffecte;
   }

   public void setTabresResultatAffecte(int var1) {
      this.tabresResultatAffecte = var1;
   }
}
