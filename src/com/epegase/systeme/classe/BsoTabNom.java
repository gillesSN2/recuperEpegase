package com.epegase.systeme.classe;

import java.io.Serializable;

public class BsoTabNom implements Serializable {
   private long tablis_id;
   private long tablisOldId;
   private String tablisZone;
   private int tablisNum;
   private String tablisCode;
   private String tablisLibFR;
   private String tablisLibUK;
   private String tablisLibSP;
   private String tablisModele;
   private String tablisAnalytique;
   private String tablisSauf;
   private int tablisNbCol;
   private int tablisType;
   private int tablisModif;
   private int tablisInactif;
   private int tablisAnn01;
   private int tablisAnn02;
   private int tablisAnn03;
   private int tablisAnn04;
   private int tablisAnn05;
   private int tablisAnn06;
   private int tablisAnn07;
   private int tablisAnn08;
   private int tablisAnn09;
   private int tablisAnn10;
   private int tablisAnn11;
   private int tablisAnn12;
   private int tablisAnn13;
   private int tablisAnn14;
   private int tablisAnn15;
   private int tablisAnn16;
   private int tablisAnn17;
   private int tablisAnn18;
   private int tablisAnn19;
   private int tablisAnn20;
   private String tablisNom01;
   private String tablisNom02;
   private String tablisNom03;
   private String tablisNom04;
   private String tablisNom05;
   private String tablisNom06;
   private String tablisNom07;
   private String tablisNom08;
   private String tablisNom09;
   private String tablisNom10;
   private String tablisNom11;
   private String tablisNom12;
   private String tablisNom13;
   private String tablisNom14;
   private String tablisNom15;
   private String tablisNom16;
   private String tablisNom17;
   private String tablisNom18;
   private String tablisNom19;
   private String tablisNom20;
   private int tablisTypeCol01;
   private int tablisTypeCol02;
   private int tablisTypeCol03;
   private int tablisTypeCol04;
   private int tablisTypeCol05;
   private int tablisTypeCol06;
   private int tablisTypeCol07;
   private int tablisTypeCol08;
   private int tablisTypeCol09;
   private int tablisTypeCol10;
   private int tablisTypeCol11;
   private int tablisTypeCol12;
   private int tablisTypeCol13;
   private int tablisTypeCol14;
   private int tablisTypeCol15;
   private int tablisTypeCol16;
   private int tablisTypeCol17;
   private int tablisTypeCol18;
   private int tablisTypeCol19;
   private int tablisTypeCol20;
   private boolean var_tab_inactif;
   private boolean var_select_tableau;

   public boolean isVar_tab_inactif() {
      if (this.tablisInactif == 1) {
         this.var_tab_inactif = true;
      } else {
         this.var_tab_inactif = false;
      }

      return this.var_tab_inactif;
   }

   public void setVar_tab_inactif(boolean var1) {
      this.var_tab_inactif = var1;
   }

   public int getTablisAnn01() {
      return this.tablisAnn01;
   }

   public void setTablisAnn01(int var1) {
      this.tablisAnn01 = var1;
   }

   public int getTablisAnn02() {
      return this.tablisAnn02;
   }

   public void setTablisAnn02(int var1) {
      this.tablisAnn02 = var1;
   }

   public int getTablisAnn03() {
      return this.tablisAnn03;
   }

   public void setTablisAnn03(int var1) {
      this.tablisAnn03 = var1;
   }

   public int getTablisAnn04() {
      return this.tablisAnn04;
   }

   public void setTablisAnn04(int var1) {
      this.tablisAnn04 = var1;
   }

   public int getTablisAnn05() {
      return this.tablisAnn05;
   }

   public void setTablisAnn05(int var1) {
      this.tablisAnn05 = var1;
   }

   public int getTablisAnn06() {
      return this.tablisAnn06;
   }

   public void setTablisAnn06(int var1) {
      this.tablisAnn06 = var1;
   }

   public int getTablisAnn07() {
      return this.tablisAnn07;
   }

   public void setTablisAnn07(int var1) {
      this.tablisAnn07 = var1;
   }

   public int getTablisAnn08() {
      return this.tablisAnn08;
   }

   public void setTablisAnn08(int var1) {
      this.tablisAnn08 = var1;
   }

   public int getTablisAnn09() {
      return this.tablisAnn09;
   }

   public void setTablisAnn09(int var1) {
      this.tablisAnn09 = var1;
   }

   public int getTablisAnn10() {
      return this.tablisAnn10;
   }

   public void setTablisAnn10(int var1) {
      this.tablisAnn10 = var1;
   }

   public int getTablisAnn11() {
      return this.tablisAnn11;
   }

   public void setTablisAnn11(int var1) {
      this.tablisAnn11 = var1;
   }

   public int getTablisAnn12() {
      return this.tablisAnn12;
   }

   public void setTablisAnn12(int var1) {
      this.tablisAnn12 = var1;
   }

   public int getTablisAnn13() {
      return this.tablisAnn13;
   }

   public void setTablisAnn13(int var1) {
      this.tablisAnn13 = var1;
   }

   public int getTablisAnn14() {
      return this.tablisAnn14;
   }

   public void setTablisAnn14(int var1) {
      this.tablisAnn14 = var1;
   }

   public int getTablisAnn15() {
      return this.tablisAnn15;
   }

   public void setTablisAnn15(int var1) {
      this.tablisAnn15 = var1;
   }

   public int getTablisAnn16() {
      return this.tablisAnn16;
   }

   public void setTablisAnn16(int var1) {
      this.tablisAnn16 = var1;
   }

   public int getTablisAnn17() {
      return this.tablisAnn17;
   }

   public void setTablisAnn17(int var1) {
      this.tablisAnn17 = var1;
   }

   public int getTablisAnn18() {
      return this.tablisAnn18;
   }

   public void setTablisAnn18(int var1) {
      this.tablisAnn18 = var1;
   }

   public int getTablisAnn19() {
      return this.tablisAnn19;
   }

   public void setTablisAnn19(int var1) {
      this.tablisAnn19 = var1;
   }

   public int getTablisAnn20() {
      return this.tablisAnn20;
   }

   public void setTablisAnn20(int var1) {
      this.tablisAnn20 = var1;
   }

   public String getTablisCode() {
      return this.tablisCode;
   }

   public void setTablisCode(String var1) {
      this.tablisCode = var1;
   }

   public long getTablis_id() {
      return this.tablis_id;
   }

   public void setTablis_id(long var1) {
      this.tablis_id = var1;
   }

   public String getTablisLibFR() {
      return this.tablisLibFR;
   }

   public void setTablisLibFR(String var1) {
      this.tablisLibFR = var1;
   }

   public String getTablisLibSP() {
      return this.tablisLibSP;
   }

   public void setTablisLibSP(String var1) {
      this.tablisLibSP = var1;
   }

   public String getTablisLibUK() {
      return this.tablisLibUK;
   }

   public void setTablisLibUK(String var1) {
      this.tablisLibUK = var1;
   }

   public int getTablisNbCol() {
      return this.tablisNbCol;
   }

   public void setTablisNbCol(int var1) {
      this.tablisNbCol = var1;
   }

   public String getTablisNom01() {
      return this.tablisNom01;
   }

   public void setTablisNom01(String var1) {
      this.tablisNom01 = var1;
   }

   public String getTablisNom02() {
      return this.tablisNom02;
   }

   public void setTablisNom02(String var1) {
      this.tablisNom02 = var1;
   }

   public String getTablisNom03() {
      return this.tablisNom03;
   }

   public void setTablisNom03(String var1) {
      this.tablisNom03 = var1;
   }

   public String getTablisNom04() {
      return this.tablisNom04;
   }

   public void setTablisNom04(String var1) {
      this.tablisNom04 = var1;
   }

   public String getTablisNom05() {
      return this.tablisNom05;
   }

   public void setTablisNom05(String var1) {
      this.tablisNom05 = var1;
   }

   public String getTablisNom06() {
      return this.tablisNom06;
   }

   public void setTablisNom06(String var1) {
      this.tablisNom06 = var1;
   }

   public String getTablisNom07() {
      return this.tablisNom07;
   }

   public void setTablisNom07(String var1) {
      this.tablisNom07 = var1;
   }

   public String getTablisNom08() {
      return this.tablisNom08;
   }

   public void setTablisNom08(String var1) {
      this.tablisNom08 = var1;
   }

   public String getTablisNom09() {
      return this.tablisNom09;
   }

   public void setTablisNom09(String var1) {
      this.tablisNom09 = var1;
   }

   public String getTablisNom10() {
      return this.tablisNom10;
   }

   public void setTablisNom10(String var1) {
      this.tablisNom10 = var1;
   }

   public String getTablisNom11() {
      return this.tablisNom11;
   }

   public void setTablisNom11(String var1) {
      this.tablisNom11 = var1;
   }

   public String getTablisNom12() {
      return this.tablisNom12;
   }

   public void setTablisNom12(String var1) {
      this.tablisNom12 = var1;
   }

   public String getTablisNom13() {
      return this.tablisNom13;
   }

   public void setTablisNom13(String var1) {
      this.tablisNom13 = var1;
   }

   public String getTablisNom14() {
      return this.tablisNom14;
   }

   public void setTablisNom14(String var1) {
      this.tablisNom14 = var1;
   }

   public String getTablisNom15() {
      return this.tablisNom15;
   }

   public void setTablisNom15(String var1) {
      this.tablisNom15 = var1;
   }

   public String getTablisNom16() {
      return this.tablisNom16;
   }

   public void setTablisNom16(String var1) {
      this.tablisNom16 = var1;
   }

   public String getTablisNom17() {
      return this.tablisNom17;
   }

   public void setTablisNom17(String var1) {
      this.tablisNom17 = var1;
   }

   public String getTablisNom18() {
      return this.tablisNom18;
   }

   public void setTablisNom18(String var1) {
      this.tablisNom18 = var1;
   }

   public String getTablisNom19() {
      return this.tablisNom19;
   }

   public void setTablisNom19(String var1) {
      this.tablisNom19 = var1;
   }

   public String getTablisNom20() {
      return this.tablisNom20;
   }

   public void setTablisNom20(String var1) {
      this.tablisNom20 = var1;
   }

   public String getTablisZone() {
      return this.tablisZone;
   }

   public void setTablisZone(String var1) {
      this.tablisZone = var1;
   }

   public int getTablisInactif() {
      return this.tablisInactif;
   }

   public void setTablisInactif(int var1) {
      this.tablisInactif = var1;
   }

   public int getTablisModif() {
      return this.tablisModif;
   }

   public void setTablisModif(int var1) {
      this.tablisModif = var1;
   }

   public int getTablisType() {
      return this.tablisType;
   }

   public void setTablisType(int var1) {
      this.tablisType = var1;
   }

   public long getTablisOldId() {
      return this.tablisOldId;
   }

   public void setTablisOldId(long var1) {
      this.tablisOldId = var1;
   }

   public String getTablisModele() {
      return this.tablisModele;
   }

   public void setTablisModele(String var1) {
      this.tablisModele = var1;
   }

   public int getTablisNum() {
      return this.tablisNum;
   }

   public void setTablisNum(int var1) {
      this.tablisNum = var1;
   }

   public int getTablisTypeCol01() {
      return this.tablisTypeCol01;
   }

   public void setTablisTypeCol01(int var1) {
      this.tablisTypeCol01 = var1;
   }

   public int getTablisTypeCol02() {
      return this.tablisTypeCol02;
   }

   public void setTablisTypeCol02(int var1) {
      this.tablisTypeCol02 = var1;
   }

   public int getTablisTypeCol03() {
      return this.tablisTypeCol03;
   }

   public void setTablisTypeCol03(int var1) {
      this.tablisTypeCol03 = var1;
   }

   public int getTablisTypeCol04() {
      return this.tablisTypeCol04;
   }

   public void setTablisTypeCol04(int var1) {
      this.tablisTypeCol04 = var1;
   }

   public int getTablisTypeCol05() {
      return this.tablisTypeCol05;
   }

   public void setTablisTypeCol05(int var1) {
      this.tablisTypeCol05 = var1;
   }

   public int getTablisTypeCol06() {
      return this.tablisTypeCol06;
   }

   public void setTablisTypeCol06(int var1) {
      this.tablisTypeCol06 = var1;
   }

   public int getTablisTypeCol07() {
      return this.tablisTypeCol07;
   }

   public void setTablisTypeCol07(int var1) {
      this.tablisTypeCol07 = var1;
   }

   public int getTablisTypeCol08() {
      return this.tablisTypeCol08;
   }

   public void setTablisTypeCol08(int var1) {
      this.tablisTypeCol08 = var1;
   }

   public int getTablisTypeCol09() {
      return this.tablisTypeCol09;
   }

   public void setTablisTypeCol09(int var1) {
      this.tablisTypeCol09 = var1;
   }

   public int getTablisTypeCol10() {
      return this.tablisTypeCol10;
   }

   public void setTablisTypeCol10(int var1) {
      this.tablisTypeCol10 = var1;
   }

   public int getTablisTypeCol11() {
      return this.tablisTypeCol11;
   }

   public void setTablisTypeCol11(int var1) {
      this.tablisTypeCol11 = var1;
   }

   public int getTablisTypeCol12() {
      return this.tablisTypeCol12;
   }

   public void setTablisTypeCol12(int var1) {
      this.tablisTypeCol12 = var1;
   }

   public int getTablisTypeCol13() {
      return this.tablisTypeCol13;
   }

   public void setTablisTypeCol13(int var1) {
      this.tablisTypeCol13 = var1;
   }

   public int getTablisTypeCol14() {
      return this.tablisTypeCol14;
   }

   public void setTablisTypeCol14(int var1) {
      this.tablisTypeCol14 = var1;
   }

   public int getTablisTypeCol15() {
      return this.tablisTypeCol15;
   }

   public void setTablisTypeCol15(int var1) {
      this.tablisTypeCol15 = var1;
   }

   public int getTablisTypeCol16() {
      return this.tablisTypeCol16;
   }

   public void setTablisTypeCol16(int var1) {
      this.tablisTypeCol16 = var1;
   }

   public int getTablisTypeCol17() {
      return this.tablisTypeCol17;
   }

   public void setTablisTypeCol17(int var1) {
      this.tablisTypeCol17 = var1;
   }

   public int getTablisTypeCol18() {
      return this.tablisTypeCol18;
   }

   public void setTablisTypeCol18(int var1) {
      this.tablisTypeCol18 = var1;
   }

   public int getTablisTypeCol19() {
      return this.tablisTypeCol19;
   }

   public void setTablisTypeCol19(int var1) {
      this.tablisTypeCol19 = var1;
   }

   public int getTablisTypeCol20() {
      return this.tablisTypeCol20;
   }

   public void setTablisTypeCol20(int var1) {
      this.tablisTypeCol20 = var1;
   }

   public String getTablisAnalytique() {
      return this.tablisAnalytique;
   }

   public void setTablisAnalytique(String var1) {
      this.tablisAnalytique = var1;
   }

   public boolean isVar_select_tableau() {
      return this.var_select_tableau;
   }

   public void setVar_select_tableau(boolean var1) {
      this.var_select_tableau = var1;
   }

   public String getTablisSauf() {
      return this.tablisSauf;
   }

   public void setTablisSauf(String var1) {
      this.tablisSauf = var1;
   }
}
