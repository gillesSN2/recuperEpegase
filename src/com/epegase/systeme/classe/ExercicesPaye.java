package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ExercicesPaye implements Serializable {
   private long exepayId;
   private Date exepayDateCreat;
   private Date exepayDateModif;
   private Date exepayDateCloture;
   private long exepayUserCreat;
   private long exepayUserCloture;
   private long exepayUserModif;
   private Date exepayDateDebut;
   private Date exepayDateFin;
   private int exepayEtat;
   private String exepayNumBrd01;
   private String exepayNumBrd02;
   private String exepayNumBrd03;
   private String exepayNumBrd04;
   private String exepayNumBrd05;
   private String exepayNumBrd06;
   private String exepayNumBrd07;
   private String exepayNumBrd08;
   private String exepayNumBrd09;
   private String exepayNumBrd10;
   private String exepayNumBrd11;
   private String exepayNumBrd12;
   private Date exepayDteBrd01;
   private Date exepayDteBrd02;
   private Date exepayDteBrd03;
   private Date exepayDteBrd04;
   private Date exepayDteBrd05;
   private Date exepayDteBrd06;
   private Date exepayDteBrd07;
   private Date exepayDteBrd08;
   private Date exepayDteBrd09;
   private Date exepayDteBrd10;
   private Date exepayDteBrd11;
   private Date exepayDteBrd12;
   private double exepayTotBrd01;
   private double exepayTotBrd02;
   private double exepayTotBrd03;
   private double exepayTotBrd04;
   private double exepayTotBrd05;
   private double exepayTotBrd06;
   private double exepayTotBrd07;
   private double exepayTotBrd08;
   private double exepayTotBrd09;
   private double exepayTotBrd10;
   private double exepayTotBrd11;
   private double exepayTotBrd12;
   private double exepayTotAll01;
   private double exepayTotAll02;
   private double exepayTotAll03;
   private double exepayTotAll04;
   private double exepayTotAll05;
   private double exepayTotAll06;
   private double exepayTotAll07;
   private double exepayTotAll08;
   private double exepayTotAll09;
   private double exepayTotAll10;
   private double exepayTotAll11;
   private double exepayTotAll12;
   private double exepayRedevance;
   private int indice;
   private String etat;

   public String getEtat() {
      if (this.exepayEtat == 0) {
         this.etat = "Ouvert";
      } else {
         this.etat = "Cloturé";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public int getIndice() {
      return this.indice;
   }

   public void setIndice(int var1) {
      this.indice = var1;
   }

   public Date getExepayDateCloture() {
      return this.exepayDateCloture;
   }

   public void setExepayDateCloture(Date var1) {
      this.exepayDateCloture = var1;
   }

   public Date getExepayDateCreat() {
      return this.exepayDateCreat;
   }

   public void setExepayDateCreat(Date var1) {
      this.exepayDateCreat = var1;
   }

   public Date getExepayDateDebut() {
      return this.exepayDateDebut;
   }

   public void setExepayDateDebut(Date var1) {
      this.exepayDateDebut = var1;
   }

   public Date getExepayDateFin() {
      return this.exepayDateFin;
   }

   public void setExepayDateFin(Date var1) {
      this.exepayDateFin = var1;
   }

   public Date getExepayDateModif() {
      return this.exepayDateModif;
   }

   public void setExepayDateModif(Date var1) {
      this.exepayDateModif = var1;
   }

   public int getExepayEtat() {
      return this.exepayEtat;
   }

   public void setExepayEtat(int var1) {
      this.exepayEtat = var1;
   }

   public long getExepayId() {
      return this.exepayId;
   }

   public void setExepayId(long var1) {
      this.exepayId = var1;
   }

   public long getExepayUserCloture() {
      return this.exepayUserCloture;
   }

   public void setExepayUserCloture(long var1) {
      this.exepayUserCloture = var1;
   }

   public long getExepayUserCreat() {
      return this.exepayUserCreat;
   }

   public void setExepayUserCreat(long var1) {
      this.exepayUserCreat = var1;
   }

   public long getExepayUserModif() {
      return this.exepayUserModif;
   }

   public void setExepayUserModif(long var1) {
      this.exepayUserModif = var1;
   }

   public Date getExepayDteBrd01() {
      return this.exepayDteBrd01;
   }

   public void setExepayDteBrd01(Date var1) {
      this.exepayDteBrd01 = var1;
   }

   public Date getExepayDteBrd02() {
      return this.exepayDteBrd02;
   }

   public void setExepayDteBrd02(Date var1) {
      this.exepayDteBrd02 = var1;
   }

   public Date getExepayDteBrd03() {
      return this.exepayDteBrd03;
   }

   public void setExepayDteBrd03(Date var1) {
      this.exepayDteBrd03 = var1;
   }

   public Date getExepayDteBrd04() {
      return this.exepayDteBrd04;
   }

   public void setExepayDteBrd04(Date var1) {
      this.exepayDteBrd04 = var1;
   }

   public Date getExepayDteBrd05() {
      return this.exepayDteBrd05;
   }

   public void setExepayDteBrd05(Date var1) {
      this.exepayDteBrd05 = var1;
   }

   public Date getExepayDteBrd06() {
      return this.exepayDteBrd06;
   }

   public void setExepayDteBrd06(Date var1) {
      this.exepayDteBrd06 = var1;
   }

   public Date getExepayDteBrd07() {
      return this.exepayDteBrd07;
   }

   public void setExepayDteBrd07(Date var1) {
      this.exepayDteBrd07 = var1;
   }

   public Date getExepayDteBrd08() {
      return this.exepayDteBrd08;
   }

   public void setExepayDteBrd08(Date var1) {
      this.exepayDteBrd08 = var1;
   }

   public Date getExepayDteBrd09() {
      return this.exepayDteBrd09;
   }

   public void setExepayDteBrd09(Date var1) {
      this.exepayDteBrd09 = var1;
   }

   public Date getExepayDteBrd10() {
      return this.exepayDteBrd10;
   }

   public void setExepayDteBrd10(Date var1) {
      this.exepayDteBrd10 = var1;
   }

   public Date getExepayDteBrd11() {
      return this.exepayDteBrd11;
   }

   public void setExepayDteBrd11(Date var1) {
      this.exepayDteBrd11 = var1;
   }

   public Date getExepayDteBrd12() {
      return this.exepayDteBrd12;
   }

   public void setExepayDteBrd12(Date var1) {
      this.exepayDteBrd12 = var1;
   }

   public String getExepayNumBrd01() {
      return this.exepayNumBrd01;
   }

   public void setExepayNumBrd01(String var1) {
      this.exepayNumBrd01 = var1;
   }

   public String getExepayNumBrd02() {
      return this.exepayNumBrd02;
   }

   public void setExepayNumBrd02(String var1) {
      this.exepayNumBrd02 = var1;
   }

   public String getExepayNumBrd03() {
      return this.exepayNumBrd03;
   }

   public void setExepayNumBrd03(String var1) {
      this.exepayNumBrd03 = var1;
   }

   public String getExepayNumBrd04() {
      return this.exepayNumBrd04;
   }

   public void setExepayNumBrd04(String var1) {
      this.exepayNumBrd04 = var1;
   }

   public String getExepayNumBrd05() {
      return this.exepayNumBrd05;
   }

   public void setExepayNumBrd05(String var1) {
      this.exepayNumBrd05 = var1;
   }

   public String getExepayNumBrd06() {
      return this.exepayNumBrd06;
   }

   public void setExepayNumBrd06(String var1) {
      this.exepayNumBrd06 = var1;
   }

   public String getExepayNumBrd07() {
      return this.exepayNumBrd07;
   }

   public void setExepayNumBrd07(String var1) {
      this.exepayNumBrd07 = var1;
   }

   public String getExepayNumBrd08() {
      return this.exepayNumBrd08;
   }

   public void setExepayNumBrd08(String var1) {
      this.exepayNumBrd08 = var1;
   }

   public String getExepayNumBrd09() {
      return this.exepayNumBrd09;
   }

   public void setExepayNumBrd09(String var1) {
      this.exepayNumBrd09 = var1;
   }

   public String getExepayNumBrd10() {
      return this.exepayNumBrd10;
   }

   public void setExepayNumBrd10(String var1) {
      this.exepayNumBrd10 = var1;
   }

   public String getExepayNumBrd11() {
      return this.exepayNumBrd11;
   }

   public void setExepayNumBrd11(String var1) {
      this.exepayNumBrd11 = var1;
   }

   public String getExepayNumBrd12() {
      return this.exepayNumBrd12;
   }

   public void setExepayNumBrd12(String var1) {
      this.exepayNumBrd12 = var1;
   }

   public double getExepayRedevance() {
      return this.exepayRedevance;
   }

   public void setExepayRedevance(double var1) {
      this.exepayRedevance = var1;
   }

   public double getExepayTotBrd01() {
      return this.exepayTotBrd01;
   }

   public void setExepayTotBrd01(double var1) {
      this.exepayTotBrd01 = var1;
   }

   public double getExepayTotBrd02() {
      return this.exepayTotBrd02;
   }

   public void setExepayTotBrd02(double var1) {
      this.exepayTotBrd02 = var1;
   }

   public double getExepayTotBrd03() {
      return this.exepayTotBrd03;
   }

   public void setExepayTotBrd03(double var1) {
      this.exepayTotBrd03 = var1;
   }

   public double getExepayTotBrd04() {
      return this.exepayTotBrd04;
   }

   public void setExepayTotBrd04(double var1) {
      this.exepayTotBrd04 = var1;
   }

   public double getExepayTotBrd05() {
      return this.exepayTotBrd05;
   }

   public void setExepayTotBrd05(double var1) {
      this.exepayTotBrd05 = var1;
   }

   public double getExepayTotBrd06() {
      return this.exepayTotBrd06;
   }

   public void setExepayTotBrd06(double var1) {
      this.exepayTotBrd06 = var1;
   }

   public double getExepayTotBrd07() {
      return this.exepayTotBrd07;
   }

   public void setExepayTotBrd07(double var1) {
      this.exepayTotBrd07 = var1;
   }

   public double getExepayTotBrd08() {
      return this.exepayTotBrd08;
   }

   public void setExepayTotBrd08(double var1) {
      this.exepayTotBrd08 = var1;
   }

   public double getExepayTotBrd09() {
      return this.exepayTotBrd09;
   }

   public void setExepayTotBrd09(double var1) {
      this.exepayTotBrd09 = var1;
   }

   public double getExepayTotBrd10() {
      return this.exepayTotBrd10;
   }

   public void setExepayTotBrd10(double var1) {
      this.exepayTotBrd10 = var1;
   }

   public double getExepayTotBrd11() {
      return this.exepayTotBrd11;
   }

   public void setExepayTotBrd11(double var1) {
      this.exepayTotBrd11 = var1;
   }

   public double getExepayTotBrd12() {
      return this.exepayTotBrd12;
   }

   public void setExepayTotBrd12(double var1) {
      this.exepayTotBrd12 = var1;
   }

   public double getExepayTotAll01() {
      return this.exepayTotAll01;
   }

   public void setExepayTotAll01(double var1) {
      this.exepayTotAll01 = var1;
   }

   public double getExepayTotAll02() {
      return this.exepayTotAll02;
   }

   public void setExepayTotAll02(double var1) {
      this.exepayTotAll02 = var1;
   }

   public double getExepayTotAll03() {
      return this.exepayTotAll03;
   }

   public void setExepayTotAll03(double var1) {
      this.exepayTotAll03 = var1;
   }

   public double getExepayTotAll04() {
      return this.exepayTotAll04;
   }

   public void setExepayTotAll04(double var1) {
      this.exepayTotAll04 = var1;
   }

   public double getExepayTotAll05() {
      return this.exepayTotAll05;
   }

   public void setExepayTotAll05(double var1) {
      this.exepayTotAll05 = var1;
   }

   public double getExepayTotAll06() {
      return this.exepayTotAll06;
   }

   public void setExepayTotAll06(double var1) {
      this.exepayTotAll06 = var1;
   }

   public double getExepayTotAll07() {
      return this.exepayTotAll07;
   }

   public void setExepayTotAll07(double var1) {
      this.exepayTotAll07 = var1;
   }

   public double getExepayTotAll08() {
      return this.exepayTotAll08;
   }

   public void setExepayTotAll08(double var1) {
      this.exepayTotAll08 = var1;
   }

   public double getExepayTotAll09() {
      return this.exepayTotAll09;
   }

   public void setExepayTotAll09(double var1) {
      this.exepayTotAll09 = var1;
   }

   public double getExepayTotAll10() {
      return this.exepayTotAll10;
   }

   public void setExepayTotAll10(double var1) {
      this.exepayTotAll10 = var1;
   }

   public double getExepayTotAll11() {
      return this.exepayTotAll11;
   }

   public void setExepayTotAll11(double var1) {
      this.exepayTotAll11 = var1;
   }

   public double getExepayTotAll12() {
      return this.exepayTotAll12;
   }

   public void setExepayTotAll12(double var1) {
      this.exepayTotAll12 = var1;
   }
}
