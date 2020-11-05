package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class TabResultats implements Serializable {
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
   private boolean tabresMod01;
   private boolean tabresMod02;
   private boolean tabresMod03;
   private boolean tabresMod04;
   private boolean tabresMod05;
   private boolean tabresMod06;
   private boolean tabresMod07;
   private boolean tabresMod08;
   private boolean tabresMod09;
   private boolean tabresMod10;
   private boolean tabresMod11;
   private boolean tabresMod12;
   private boolean tabresMod13;
   private boolean tabresMod14;
   private boolean tabresMod15;
   private boolean tabresMod16;
   private boolean tabresMod17;
   private boolean tabresMod18;
   private boolean tabresMod19;
   private boolean tabresMod20;
   private String tabresNotes;
   private ExercicesComptable exercicescomptable;
   private String espaceFamille;
   private String color01;
   private String color02;
   private String color03;
   private String color04;
   private String color05;
   private String color06;
   private String color07;
   private String color08;
   private String color09;
   private String color10;
   private String color11;
   private String color12;
   private String color13;
   private String color14;
   private String color15;
   private String color16;
   private String color17;
   private String color18;
   private String color19;
   private String color20;

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

   public String getColor01() {
      if (this.tabresType == 3 && this.tabresMod01) {
         this.color01 = "color:red";
      } else {
         this.color01 = "color:black";
      }

      return this.color01;
   }

   public void setColor01(String var1) {
      this.color01 = var1;
   }

   public String getColor02() {
      if (this.tabresType == 3 && this.tabresMod02) {
         this.color02 = "color:red";
      } else {
         this.color02 = "color:black";
      }

      return this.color02;
   }

   public void setColor02(String var1) {
      this.color02 = var1;
   }

   public String getColor03() {
      if (this.tabresType == 3 && this.tabresMod03) {
         this.color03 = "color:red";
      } else {
         this.color03 = "color:black";
      }

      return this.color03;
   }

   public void setColor03(String var1) {
      this.color03 = var1;
   }

   public String getColor04() {
      if (this.tabresType == 3 && this.tabresMod04) {
         this.color04 = "color:red";
      } else {
         this.color04 = "color:black";
      }

      return this.color04;
   }

   public void setColor04(String var1) {
      this.color04 = var1;
   }

   public String getColor05() {
      if (this.tabresType == 3 && this.tabresMod05) {
         this.color05 = "color:red";
      } else {
         this.color05 = "color:black";
      }

      return this.color05;
   }

   public void setColor05(String var1) {
      this.color05 = var1;
   }

   public String getColor06() {
      if (this.tabresType == 3 && this.tabresMod06) {
         this.color06 = "color:red";
      } else {
         this.color06 = "color:black";
      }

      return this.color06;
   }

   public void setColor06(String var1) {
      this.color06 = var1;
   }

   public String getColor07() {
      if (this.tabresType == 3 && this.tabresMod07) {
         this.color07 = "color:red";
      } else {
         this.color07 = "color:black";
      }

      return this.color07;
   }

   public void setColor07(String var1) {
      this.color07 = var1;
   }

   public String getColor08() {
      if (this.tabresType == 3 && this.tabresMod08) {
         this.color08 = "color:red";
      } else {
         this.color08 = "color:black";
      }

      return this.color08;
   }

   public void setColor08(String var1) {
      this.color08 = var1;
   }

   public String getColor09() {
      if (this.tabresType == 3 && this.tabresMod09) {
         this.color09 = "color:red";
      } else {
         this.color09 = "color:black";
      }

      return this.color09;
   }

   public void setColor09(String var1) {
      this.color09 = var1;
   }

   public String getColor10() {
      if (this.tabresType == 3 && this.tabresMod10) {
         this.color10 = "color:red";
      } else {
         this.color10 = "color:black";
      }

      return this.color10;
   }

   public void setColor10(String var1) {
      this.color10 = var1;
   }

   public String getColor11() {
      if (this.tabresType == 3 && this.tabresMod11) {
         this.color11 = "color:red";
      } else {
         this.color11 = "color:black";
      }

      return this.color11;
   }

   public void setColor11(String var1) {
      this.color11 = var1;
   }

   public String getColor12() {
      if (this.tabresType == 3 && this.tabresMod12) {
         this.color12 = "color:red";
      } else {
         this.color12 = "color:black";
      }

      return this.color12;
   }

   public void setColor12(String var1) {
      this.color12 = var1;
   }

   public String getColor13() {
      if (this.tabresType == 3 && this.tabresMod13) {
         this.color13 = "color:red";
      } else {
         this.color13 = "color:black";
      }

      return this.color13;
   }

   public void setColor13(String var1) {
      this.color13 = var1;
   }

   public String getColor14() {
      if (this.tabresType == 3 && this.tabresMod14) {
         this.color14 = "color:red";
      } else {
         this.color14 = "color:black";
      }

      return this.color14;
   }

   public void setColor14(String var1) {
      this.color14 = var1;
   }

   public String getColor15() {
      if (this.tabresType == 3 && this.tabresMod15) {
         this.color15 = "color:red";
      } else {
         this.color15 = "color:black";
      }

      return this.color15;
   }

   public void setColor15(String var1) {
      this.color15 = var1;
   }

   public String getColor16() {
      if (this.tabresType == 3 && this.tabresMod16) {
         this.color16 = "color:red";
      } else {
         this.color16 = "color:black";
      }

      return this.color16;
   }

   public void setColor16(String var1) {
      this.color16 = var1;
   }

   public String getColor17() {
      if (this.tabresType == 3 && this.tabresMod17) {
         this.color17 = "color:red";
      } else {
         this.color17 = "color:black";
      }

      return this.color17;
   }

   public void setColor17(String var1) {
      this.color17 = var1;
   }

   public String getColor18() {
      if (this.tabresType == 3 && this.tabresMod18) {
         this.color18 = "color:red";
      } else {
         this.color18 = "color:black";
      }

      return this.color18;
   }

   public void setColor18(String var1) {
      this.color18 = var1;
   }

   public String getColor19() {
      if (this.tabresType == 3 && this.tabresMod19) {
         this.color19 = "color:red";
      } else {
         this.color19 = "color:black";
      }

      return this.color19;
   }

   public void setColor19(String var1) {
      this.color19 = var1;
   }

   public String getColor20() {
      if (this.tabresType == 3 && this.tabresMod20) {
         this.color20 = "color:red";
      } else {
         this.color20 = "color:black";
      }

      return this.color20;
   }

   public void setColor20(String var1) {
      this.color20 = var1;
   }

   public ExercicesComptable getExercicescomptable() {
      return this.exercicescomptable;
   }

   public void setExercicescomptable(ExercicesComptable var1) {
      this.exercicescomptable = var1;
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

   public String getTabresNotes() {
      return this.tabresNotes;
   }

   public void setTabresNotes(String var1) {
      this.tabresNotes = var1;
   }

   public boolean isTabresMod01() {
      return this.tabresMod01;
   }

   public void setTabresMod01(boolean var1) {
      this.tabresMod01 = var1;
   }

   public boolean isTabresMod02() {
      return this.tabresMod02;
   }

   public void setTabresMod02(boolean var1) {
      this.tabresMod02 = var1;
   }

   public boolean isTabresMod03() {
      return this.tabresMod03;
   }

   public void setTabresMod03(boolean var1) {
      this.tabresMod03 = var1;
   }

   public boolean isTabresMod04() {
      return this.tabresMod04;
   }

   public void setTabresMod04(boolean var1) {
      this.tabresMod04 = var1;
   }

   public boolean isTabresMod05() {
      return this.tabresMod05;
   }

   public void setTabresMod05(boolean var1) {
      this.tabresMod05 = var1;
   }

   public boolean isTabresMod06() {
      return this.tabresMod06;
   }

   public void setTabresMod06(boolean var1) {
      this.tabresMod06 = var1;
   }

   public boolean isTabresMod07() {
      return this.tabresMod07;
   }

   public void setTabresMod07(boolean var1) {
      this.tabresMod07 = var1;
   }

   public boolean isTabresMod08() {
      return this.tabresMod08;
   }

   public void setTabresMod08(boolean var1) {
      this.tabresMod08 = var1;
   }

   public boolean isTabresMod09() {
      return this.tabresMod09;
   }

   public void setTabresMod09(boolean var1) {
      this.tabresMod09 = var1;
   }

   public boolean isTabresMod10() {
      return this.tabresMod10;
   }

   public void setTabresMod10(boolean var1) {
      this.tabresMod10 = var1;
   }

   public boolean isTabresMod11() {
      return this.tabresMod11;
   }

   public void setTabresMod11(boolean var1) {
      this.tabresMod11 = var1;
   }

   public boolean isTabresMod12() {
      return this.tabresMod12;
   }

   public void setTabresMod12(boolean var1) {
      this.tabresMod12 = var1;
   }

   public boolean isTabresMod13() {
      return this.tabresMod13;
   }

   public void setTabresMod13(boolean var1) {
      this.tabresMod13 = var1;
   }

   public boolean isTabresMod14() {
      return this.tabresMod14;
   }

   public void setTabresMod14(boolean var1) {
      this.tabresMod14 = var1;
   }

   public boolean isTabresMod15() {
      return this.tabresMod15;
   }

   public void setTabresMod15(boolean var1) {
      this.tabresMod15 = var1;
   }

   public boolean isTabresMod16() {
      return this.tabresMod16;
   }

   public void setTabresMod16(boolean var1) {
      this.tabresMod16 = var1;
   }

   public boolean isTabresMod17() {
      return this.tabresMod17;
   }

   public void setTabresMod17(boolean var1) {
      this.tabresMod17 = var1;
   }

   public boolean isTabresMod18() {
      return this.tabresMod18;
   }

   public void setTabresMod18(boolean var1) {
      this.tabresMod18 = var1;
   }

   public boolean isTabresMod19() {
      return this.tabresMod19;
   }

   public void setTabresMod19(boolean var1) {
      this.tabresMod19 = var1;
   }

   public boolean isTabresMod20() {
      return this.tabresMod20;
   }

   public void setTabresMod20(boolean var1) {
      this.tabresMod20 = var1;
   }
}
