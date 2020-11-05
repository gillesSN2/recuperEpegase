package com.epegase.systeme.classe;

import java.io.Serializable;

public class BulletinLigne implements Serializable {
   private long bulligId;
   private String bulligRubrique;
   private String bulligLibelle;
   private boolean bulligAffColA;
   private boolean bulligAffColB;
   private boolean bulligAffColC;
   private boolean bulligAffColD;
   private boolean bulligAffColE;
   private double bulligValColA;
   private double bulligValColB;
   private double bulligValColC;
   private double bulligValColD;
   private double bulligValColE;
   private int bulligNature;
   private boolean bulligBaseFiscale;
   private boolean bulligBaseSociale;
   private boolean bulligBaseAutre;
   private boolean bulligBasePatronale;
   private boolean bulligBaseConges;
   private int bulligSens;
   private int bulligProrataTemporis;
   private long bulligIdPretligne;
   private String bulligNumPret;
   private int bulligNaturePret;
   private String bulligObservation;
   private boolean bulligNonPrint;
   private Salaries salaries;
   private BulletinSalaire bulletinSalaire;
   private ExercicesPaye exercicesPaye;
   private String libNature;
   private String espaceFamille;
   private double v01;
   private double v02;
   private double v03;
   private double v04;
   private double v05;
   private double v06;
   private double v07;
   private double v08;
   private double v09;
   private double v10;
   private double v11;
   private double v12;
   private double vTotal;
   private int vsitFam01;
   private String vlibSitFam01;
   private float vnbParts01;
   private int vnbEnfants01;
   private float vnbTrimf01;
   private int vsitFam02;
   private String vlibSitFam02;
   private float vnbParts02;
   private int vnbEnfants02;
   private float vnbTrimf02;
   private int vsitFam03;
   private String vlibSitFam03;
   private float vnbParts03;
   private int vnbEnfants03;
   private float vnbTrimf03;
   private int vsitFam04;
   private String vlibSitFam04;
   private float vnbParts04;
   private int vnbEnfants04;
   private float vnbTrimf04;
   private int vsitFam05;
   private String vlibSitFam05;
   private float vnbParts05;
   private int vnbEnfants05;
   private float vnbTrimf05;
   private int vsitFam06;
   private String vlibSitFam06;
   private float vnbParts06;
   private int vnbEnfants06;
   private float vnbTrimf06;
   private int vsitFam07;
   private String vlibSitFam07;
   private float vnbParts07;
   private int vnbEnfants07;
   private float vnbTrimf07;
   private int vsitFam08;
   private String vlibSitFam08;
   private float vnbParts08;
   private int vnbEnfants08;
   private float vnbTrimf08;
   private int vsitFam09;
   private String vlibSitFam09;
   private float vnbParts09;
   private int vnbEnfants09;
   private float vnbTrimf09;
   private int vsitFam10;
   private String vlibSitFam10;
   private float vnbParts10;
   private int vnbEnfants10;
   private float vnbTrimf10;
   private int vsitFam11;
   private String vlibSitFam11;
   private float vnbParts11;
   private int vnbEnfants11;
   private float vnbTrimf11;
   private int vsitFam12;
   private String vlibSitFam12;
   private float vnbParts12;
   private int vnbEnfants12;
   private float vnbTrimf12;
   private double depense;
   private double recette;

   public String getLibNature() {
      if (this.bulligNature == 10) {
         this.libNature = "Eléments de base";
      } else if (this.bulligNature == 11) {
         this.libNature = "Heures supplémentaires";
      } else if (this.bulligNature == 20) {
         this.libNature = "Primes imposables";
      } else if (this.bulligNature == 21) {
         this.libNature = "Indemnités imposables";
      } else if (this.bulligNature == 25) {
         this.libNature = "Indemnités compensatrices";
      } else if (this.bulligNature == 30) {
         this.libNature = "Retenues imposables";
      } else if (this.bulligNature == 40) {
         this.libNature = "Congés";
      } else if (this.bulligNature == 41) {
         this.libNature = "Licenciement";
      } else if (this.bulligNature == 42) {
         this.libNature = "Primes fin d`année";
      } else if (this.bulligNature == 50) {
         this.libNature = "Avantages en nature";
      } else if (this.bulligNature == 59) {
         this.libNature = "Total brut";
      } else if (this.bulligNature == 60) {
         this.libNature = "Impôts : charges fiscales";
      } else if (this.bulligNature == 61) {
         this.libNature = "Impôts : charges sociales";
      } else if (this.bulligNature == 62) {
         this.libNature = "Impôts : autres charges";
      } else if (this.bulligNature == 69) {
         this.libNature = "Total net";
      } else if (this.bulligNature == 70) {
         this.libNature = "Indemnités non imposables";
      } else if (this.bulligNature == 80) {
         this.libNature = "Retenues non imposables";
      } else if (this.bulligNature == 88) {
         this.libNature = "Appoints mensuels";
      } else if (this.bulligNature == 89) {
         this.libNature = "Total net à payer";
      } else if (this.bulligNature == 90) {
         this.libNature = "Charges patronales";
      } else if (this.bulligNature == 99) {
         this.libNature = "Salaire à atteindre";
      }

      return this.libNature;
   }

   public void setLibNature(String var1) {
      this.libNature = var1;
   }

   public String getEspaceFamille() {
      if (this.bulligNature != 59 && this.bulligNature != 69 && this.bulligNature != 89) {
         if (this.bulligNature != 50 && this.bulligSens != 2) {
            this.espaceFamille = "width:100%;";
         } else {
            this.espaceFamille = "font-style: italic;";
         }
      } else {
         this.espaceFamille = "font-weight:bold;";
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public double getDepense() {
      if (this.bulligSens == 1) {
         this.depense = this.bulligValColE * -1.0D;
      }

      return this.depense;
   }

   public void setDepense(double var1) {
      this.depense = var1;
   }

   public double getRecette() {
      if (this.bulligSens == 0) {
         this.recette = this.bulligValColE;
      }

      return this.recette;
   }

   public void setRecette(double var1) {
      this.recette = var1;
   }

   public BulletinSalaire getBulletinSalaire() {
      return this.bulletinSalaire;
   }

   public void setBulletinSalaire(BulletinSalaire var1) {
      this.bulletinSalaire = var1;
   }

   public long getBulligId() {
      return this.bulligId;
   }

   public void setBulligId(long var1) {
      this.bulligId = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public boolean isBulligAffColA() {
      return this.bulligAffColA;
   }

   public void setBulligAffColA(boolean var1) {
      this.bulligAffColA = var1;
   }

   public boolean isBulligAffColB() {
      return this.bulligAffColB;
   }

   public void setBulligAffColB(boolean var1) {
      this.bulligAffColB = var1;
   }

   public boolean isBulligAffColC() {
      return this.bulligAffColC;
   }

   public void setBulligAffColC(boolean var1) {
      this.bulligAffColC = var1;
   }

   public boolean isBulligAffColD() {
      return this.bulligAffColD;
   }

   public void setBulligAffColD(boolean var1) {
      this.bulligAffColD = var1;
   }

   public boolean isBulligAffColE() {
      return this.bulligAffColE;
   }

   public void setBulligAffColE(boolean var1) {
      this.bulligAffColE = var1;
   }

   public String getBulligLibelle() {
      return this.bulligLibelle;
   }

   public void setBulligLibelle(String var1) {
      this.bulligLibelle = var1;
   }

   public String getBulligRubrique() {
      return this.bulligRubrique;
   }

   public void setBulligRubrique(String var1) {
      this.bulligRubrique = var1;
   }

   public double getBulligValColA() {
      return this.bulligValColA;
   }

   public void setBulligValColA(double var1) {
      this.bulligValColA = var1;
   }

   public double getBulligValColB() {
      return this.bulligValColB;
   }

   public void setBulligValColB(double var1) {
      this.bulligValColB = var1;
   }

   public double getBulligValColC() {
      return this.bulligValColC;
   }

   public void setBulligValColC(double var1) {
      this.bulligValColC = var1;
   }

   public double getBulligValColD() {
      return this.bulligValColD;
   }

   public void setBulligValColD(double var1) {
      this.bulligValColD = var1;
   }

   public double getBulligValColE() {
      return this.bulligValColE;
   }

   public void setBulligValColE(double var1) {
      this.bulligValColE = var1;
   }

   public int getBulligNature() {
      return this.bulligNature;
   }

   public void setBulligNature(int var1) {
      this.bulligNature = var1;
   }

   public int getBulligSens() {
      return this.bulligSens;
   }

   public void setBulligSens(int var1) {
      this.bulligSens = var1;
   }

   public long getBulligIdPretligne() {
      return this.bulligIdPretligne;
   }

   public void setBulligIdPretligne(long var1) {
      this.bulligIdPretligne = var1;
   }

   public String getBulligNumPret() {
      return this.bulligNumPret;
   }

   public void setBulligNumPret(String var1) {
      this.bulligNumPret = var1;
   }

   public String getBulligObservation() {
      return this.bulligObservation;
   }

   public void setBulligObservation(String var1) {
      this.bulligObservation = var1;
   }

   public double getV01() {
      return this.v01;
   }

   public void setV01(double var1) {
      this.v01 = var1;
   }

   public double getV02() {
      return this.v02;
   }

   public void setV02(double var1) {
      this.v02 = var1;
   }

   public double getV03() {
      return this.v03;
   }

   public void setV03(double var1) {
      this.v03 = var1;
   }

   public double getV04() {
      return this.v04;
   }

   public void setV04(double var1) {
      this.v04 = var1;
   }

   public double getV05() {
      return this.v05;
   }

   public void setV05(double var1) {
      this.v05 = var1;
   }

   public double getV06() {
      return this.v06;
   }

   public void setV06(double var1) {
      this.v06 = var1;
   }

   public double getV07() {
      return this.v07;
   }

   public void setV07(double var1) {
      this.v07 = var1;
   }

   public double getV08() {
      return this.v08;
   }

   public void setV08(double var1) {
      this.v08 = var1;
   }

   public double getV09() {
      return this.v09;
   }

   public void setV09(double var1) {
      this.v09 = var1;
   }

   public double getV10() {
      return this.v10;
   }

   public void setV10(double var1) {
      this.v10 = var1;
   }

   public double getV11() {
      return this.v11;
   }

   public void setV11(double var1) {
      this.v11 = var1;
   }

   public double getV12() {
      return this.v12;
   }

   public void setV12(double var1) {
      this.v12 = var1;
   }

   public double getvTotal() {
      this.vTotal = this.v01 + this.v02 + this.v03 + this.v04 + this.v05 + this.v06 + this.v07 + this.v08 + this.v09 + this.v10 + this.v11 + this.v12;
      return this.vTotal;
   }

   public void setvTotal(double var1) {
      this.vTotal = var1;
   }

   public int getVnbEnfants01() {
      return this.vnbEnfants01;
   }

   public void setVnbEnfants01(int var1) {
      this.vnbEnfants01 = var1;
   }

   public int getVnbEnfants02() {
      return this.vnbEnfants02;
   }

   public void setVnbEnfants02(int var1) {
      this.vnbEnfants02 = var1;
   }

   public int getVnbEnfants03() {
      return this.vnbEnfants03;
   }

   public void setVnbEnfants03(int var1) {
      this.vnbEnfants03 = var1;
   }

   public int getVnbEnfants04() {
      return this.vnbEnfants04;
   }

   public void setVnbEnfants04(int var1) {
      this.vnbEnfants04 = var1;
   }

   public int getVnbEnfants05() {
      return this.vnbEnfants05;
   }

   public void setVnbEnfants05(int var1) {
      this.vnbEnfants05 = var1;
   }

   public int getVnbEnfants06() {
      return this.vnbEnfants06;
   }

   public void setVnbEnfants06(int var1) {
      this.vnbEnfants06 = var1;
   }

   public int getVnbEnfants07() {
      return this.vnbEnfants07;
   }

   public void setVnbEnfants07(int var1) {
      this.vnbEnfants07 = var1;
   }

   public int getVnbEnfants08() {
      return this.vnbEnfants08;
   }

   public void setVnbEnfants08(int var1) {
      this.vnbEnfants08 = var1;
   }

   public int getVnbEnfants09() {
      return this.vnbEnfants09;
   }

   public void setVnbEnfants09(int var1) {
      this.vnbEnfants09 = var1;
   }

   public int getVnbEnfants10() {
      return this.vnbEnfants10;
   }

   public void setVnbEnfants10(int var1) {
      this.vnbEnfants10 = var1;
   }

   public int getVnbEnfants11() {
      return this.vnbEnfants11;
   }

   public void setVnbEnfants11(int var1) {
      this.vnbEnfants11 = var1;
   }

   public int getVnbEnfants12() {
      return this.vnbEnfants12;
   }

   public void setVnbEnfants12(int var1) {
      this.vnbEnfants12 = var1;
   }

   public float getVnbParts01() {
      return this.vnbParts01;
   }

   public void setVnbParts01(float var1) {
      this.vnbParts01 = var1;
   }

   public float getVnbParts02() {
      return this.vnbParts02;
   }

   public void setVnbParts02(float var1) {
      this.vnbParts02 = var1;
   }

   public float getVnbParts03() {
      return this.vnbParts03;
   }

   public void setVnbParts03(float var1) {
      this.vnbParts03 = var1;
   }

   public float getVnbParts04() {
      return this.vnbParts04;
   }

   public void setVnbParts04(float var1) {
      this.vnbParts04 = var1;
   }

   public float getVnbParts05() {
      return this.vnbParts05;
   }

   public void setVnbParts05(float var1) {
      this.vnbParts05 = var1;
   }

   public float getVnbParts06() {
      return this.vnbParts06;
   }

   public void setVnbParts06(float var1) {
      this.vnbParts06 = var1;
   }

   public float getVnbParts07() {
      return this.vnbParts07;
   }

   public void setVnbParts07(float var1) {
      this.vnbParts07 = var1;
   }

   public float getVnbParts08() {
      return this.vnbParts08;
   }

   public void setVnbParts08(float var1) {
      this.vnbParts08 = var1;
   }

   public float getVnbParts09() {
      return this.vnbParts09;
   }

   public void setVnbParts09(float var1) {
      this.vnbParts09 = var1;
   }

   public float getVnbParts10() {
      return this.vnbParts10;
   }

   public void setVnbParts10(float var1) {
      this.vnbParts10 = var1;
   }

   public float getVnbParts11() {
      return this.vnbParts11;
   }

   public void setVnbParts11(float var1) {
      this.vnbParts11 = var1;
   }

   public float getVnbParts12() {
      return this.vnbParts12;
   }

   public void setVnbParts12(float var1) {
      this.vnbParts12 = var1;
   }

   public int getVsitFam01() {
      return this.vsitFam01;
   }

   public void setVsitFam01(int var1) {
      this.vsitFam01 = var1;
   }

   public int getVsitFam02() {
      return this.vsitFam02;
   }

   public void setVsitFam02(int var1) {
      this.vsitFam02 = var1;
   }

   public int getVsitFam03() {
      return this.vsitFam03;
   }

   public void setVsitFam03(int var1) {
      this.vsitFam03 = var1;
   }

   public int getVsitFam04() {
      return this.vsitFam04;
   }

   public void setVsitFam04(int var1) {
      this.vsitFam04 = var1;
   }

   public int getVsitFam05() {
      return this.vsitFam05;
   }

   public void setVsitFam05(int var1) {
      this.vsitFam05 = var1;
   }

   public int getVsitFam06() {
      return this.vsitFam06;
   }

   public void setVsitFam06(int var1) {
      this.vsitFam06 = var1;
   }

   public int getVsitFam07() {
      return this.vsitFam07;
   }

   public void setVsitFam07(int var1) {
      this.vsitFam07 = var1;
   }

   public int getVsitFam08() {
      return this.vsitFam08;
   }

   public void setVsitFam08(int var1) {
      this.vsitFam08 = var1;
   }

   public int getVsitFam09() {
      return this.vsitFam09;
   }

   public void setVsitFam09(int var1) {
      this.vsitFam09 = var1;
   }

   public int getVsitFam10() {
      return this.vsitFam10;
   }

   public void setVsitFam10(int var1) {
      this.vsitFam10 = var1;
   }

   public int getVsitFam11() {
      return this.vsitFam11;
   }

   public void setVsitFam11(int var1) {
      this.vsitFam11 = var1;
   }

   public int getVsitFam12() {
      return this.vsitFam12;
   }

   public void setVsitFam12(int var1) {
      this.vsitFam12 = var1;
   }

   public String getVlibSitFam01() {
      if (this.vsitFam01 == 1) {
         this.vlibSitFam01 = "Célibataire";
      } else if (this.vsitFam01 == 2) {
         this.vlibSitFam01 = "Marié(e)";
      } else if (this.vsitFam01 == 3) {
         this.vlibSitFam01 = "Concubin(e)";
      } else if (this.vsitFam01 == 4) {
         this.vlibSitFam01 = "Pacsé(e)";
      } else if (this.vsitFam01 == 5) {
         this.vlibSitFam01 = "Divorcé(e)";
      } else if (this.vsitFam01 == 6) {
         this.vlibSitFam01 = "Veuf(ve)";
      } else {
         this.vlibSitFam01 = "";
      }

      return this.vlibSitFam01;
   }

   public void setVlibSitFam01(String var1) {
      this.vlibSitFam01 = var1;
   }

   public String getVlibSitFam02() {
      if (this.vsitFam02 == 1) {
         this.vlibSitFam02 = "Célibataire";
      } else if (this.vsitFam02 == 2) {
         this.vlibSitFam02 = "Marié(e)";
      } else if (this.vsitFam02 == 3) {
         this.vlibSitFam02 = "Concubin(e)";
      } else if (this.vsitFam02 == 4) {
         this.vlibSitFam02 = "Pacsé(e)";
      } else if (this.vsitFam02 == 5) {
         this.vlibSitFam02 = "Divorcé(e)";
      } else if (this.vsitFam02 == 6) {
         this.vlibSitFam02 = "Veuf(ve)";
      } else {
         this.vlibSitFam02 = "";
      }

      return this.vlibSitFam02;
   }

   public void setVlibSitFam02(String var1) {
      this.vlibSitFam02 = var1;
   }

   public String getVlibSitFam03() {
      if (this.vsitFam03 == 1) {
         this.vlibSitFam03 = "Célibataire";
      } else if (this.vsitFam03 == 2) {
         this.vlibSitFam03 = "Marié(e)";
      } else if (this.vsitFam03 == 3) {
         this.vlibSitFam03 = "Concubin(e)";
      } else if (this.vsitFam03 == 4) {
         this.vlibSitFam03 = "Pacsé(e)";
      } else if (this.vsitFam03 == 5) {
         this.vlibSitFam03 = "Divorcé(e)";
      } else if (this.vsitFam03 == 6) {
         this.vlibSitFam03 = "Veuf(ve)";
      } else {
         this.vlibSitFam03 = "";
      }

      return this.vlibSitFam03;
   }

   public void setVlibSitFam03(String var1) {
      this.vlibSitFam03 = var1;
   }

   public String getVlibSitFam04() {
      if (this.vsitFam04 == 1) {
         this.vlibSitFam04 = "Célibataire";
      } else if (this.vsitFam04 == 2) {
         this.vlibSitFam04 = "Marié(e)";
      } else if (this.vsitFam04 == 3) {
         this.vlibSitFam04 = "Concubin(e)";
      } else if (this.vsitFam04 == 4) {
         this.vlibSitFam04 = "Pacsé(e)";
      } else if (this.vsitFam04 == 5) {
         this.vlibSitFam04 = "Divorcé(e)";
      } else if (this.vsitFam04 == 6) {
         this.vlibSitFam04 = "Veuf(ve)";
      } else {
         this.vlibSitFam04 = "";
      }

      return this.vlibSitFam04;
   }

   public void setVlibSitFam04(String var1) {
      this.vlibSitFam04 = var1;
   }

   public String getVlibSitFam05() {
      if (this.vsitFam05 == 1) {
         this.vlibSitFam05 = "Célibataire";
      } else if (this.vsitFam05 == 2) {
         this.vlibSitFam05 = "Marié(e)";
      } else if (this.vsitFam05 == 3) {
         this.vlibSitFam05 = "Concubin(e)";
      } else if (this.vsitFam05 == 4) {
         this.vlibSitFam05 = "Pacsé(e)";
      } else if (this.vsitFam05 == 5) {
         this.vlibSitFam05 = "Divorcé(e)";
      } else if (this.vsitFam05 == 6) {
         this.vlibSitFam05 = "Veuf(ve)";
      } else {
         this.vlibSitFam05 = "";
      }

      return this.vlibSitFam05;
   }

   public void setVlibSitFam05(String var1) {
      this.vlibSitFam05 = var1;
   }

   public String getVlibSitFam06() {
      if (this.vsitFam06 == 1) {
         this.vlibSitFam06 = "Célibataire";
      } else if (this.vsitFam06 == 2) {
         this.vlibSitFam06 = "Marié(e)";
      } else if (this.vsitFam06 == 3) {
         this.vlibSitFam06 = "Concubin(e)";
      } else if (this.vsitFam06 == 4) {
         this.vlibSitFam06 = "Pacsé(e)";
      } else if (this.vsitFam06 == 5) {
         this.vlibSitFam06 = "Divorcé(e)";
      } else if (this.vsitFam06 == 6) {
         this.vlibSitFam06 = "Veuf(ve)";
      } else {
         this.vlibSitFam06 = "";
      }

      return this.vlibSitFam06;
   }

   public void setVlibSitFam06(String var1) {
      this.vlibSitFam06 = var1;
   }

   public String getVlibSitFam07() {
      if (this.vsitFam07 == 1) {
         this.vlibSitFam07 = "Célibataire";
      } else if (this.vsitFam07 == 2) {
         this.vlibSitFam07 = "Marié(e)";
      } else if (this.vsitFam07 == 3) {
         this.vlibSitFam07 = "Concubin(e)";
      } else if (this.vsitFam07 == 4) {
         this.vlibSitFam07 = "Pacsé(e)";
      } else if (this.vsitFam07 == 5) {
         this.vlibSitFam07 = "Divorcé(e)";
      } else if (this.vsitFam07 == 6) {
         this.vlibSitFam07 = "Veuf(ve)";
      } else {
         this.vlibSitFam07 = "";
      }

      return this.vlibSitFam07;
   }

   public void setVlibSitFam07(String var1) {
      this.vlibSitFam07 = var1;
   }

   public String getVlibSitFam08() {
      if (this.vsitFam08 == 1) {
         this.vlibSitFam08 = "Célibataire";
      } else if (this.vsitFam08 == 2) {
         this.vlibSitFam08 = "Marié(e)";
      } else if (this.vsitFam08 == 3) {
         this.vlibSitFam08 = "Concubin(e)";
      } else if (this.vsitFam08 == 4) {
         this.vlibSitFam08 = "Pacsé(e)";
      } else if (this.vsitFam08 == 5) {
         this.vlibSitFam08 = "Divorcé(e)";
      } else if (this.vsitFam08 == 6) {
         this.vlibSitFam08 = "Veuf(ve)";
      } else {
         this.vlibSitFam08 = "";
      }

      return this.vlibSitFam08;
   }

   public void setVlibSitFam08(String var1) {
      this.vlibSitFam08 = var1;
   }

   public String getVlibSitFam09() {
      if (this.vsitFam09 == 1) {
         this.vlibSitFam09 = "Célibataire";
      } else if (this.vsitFam09 == 2) {
         this.vlibSitFam09 = "Marié(e)";
      } else if (this.vsitFam09 == 3) {
         this.vlibSitFam09 = "Concubin(e)";
      } else if (this.vsitFam09 == 4) {
         this.vlibSitFam09 = "Pacsé(e)";
      } else if (this.vsitFam09 == 5) {
         this.vlibSitFam09 = "Divorcé(e)";
      } else if (this.vsitFam09 == 6) {
         this.vlibSitFam09 = "Veuf(ve)";
      } else {
         this.vlibSitFam09 = "";
      }

      return this.vlibSitFam09;
   }

   public void setVlibSitFam09(String var1) {
      this.vlibSitFam09 = var1;
   }

   public String getVlibSitFam10() {
      if (this.vsitFam10 == 1) {
         this.vlibSitFam10 = "Célibataire";
      } else if (this.vsitFam10 == 2) {
         this.vlibSitFam10 = "Marié(e)";
      } else if (this.vsitFam10 == 3) {
         this.vlibSitFam10 = "Concubin(e)";
      } else if (this.vsitFam10 == 4) {
         this.vlibSitFam10 = "Pacsé(e)";
      } else if (this.vsitFam10 == 5) {
         this.vlibSitFam10 = "Divorcé(e)";
      } else if (this.vsitFam10 == 6) {
         this.vlibSitFam10 = "Veuf(ve)";
      } else {
         this.vlibSitFam10 = "";
      }

      return this.vlibSitFam10;
   }

   public void setVlibSitFam10(String var1) {
      this.vlibSitFam10 = var1;
   }

   public String getVlibSitFam11() {
      if (this.vsitFam11 == 1) {
         this.vlibSitFam11 = "Célibataire";
      } else if (this.vsitFam11 == 2) {
         this.vlibSitFam11 = "Marié(e)";
      } else if (this.vsitFam11 == 3) {
         this.vlibSitFam11 = "Concubin(e)";
      } else if (this.vsitFam11 == 4) {
         this.vlibSitFam11 = "Pacsé(e)";
      } else if (this.vsitFam11 == 5) {
         this.vlibSitFam11 = "Divorcé(e)";
      } else if (this.vsitFam11 == 6) {
         this.vlibSitFam11 = "Veuf(ve)";
      } else {
         this.vlibSitFam11 = "";
      }

      return this.vlibSitFam11;
   }

   public void setVlibSitFam11(String var1) {
      this.vlibSitFam11 = var1;
   }

   public String getVlibSitFam12() {
      if (this.vsitFam12 == 1) {
         this.vlibSitFam12 = "Célibataire";
      } else if (this.vsitFam12 == 2) {
         this.vlibSitFam12 = "Marié(e)";
      } else if (this.vsitFam12 == 3) {
         this.vlibSitFam12 = "Concubin(e)";
      } else if (this.vsitFam12 == 4) {
         this.vlibSitFam12 = "Pacsé(e)";
      } else if (this.vsitFam12 == 5) {
         this.vlibSitFam12 = "Divorcé(e)";
      } else if (this.vsitFam12 == 6) {
         this.vlibSitFam12 = "Veuf(ve)";
      } else {
         this.vlibSitFam12 = "";
      }

      return this.vlibSitFam12;
   }

   public void setVlibSitFam12(String var1) {
      this.vlibSitFam12 = var1;
   }

   public float getVnbTrimf01() {
      return this.vnbTrimf01;
   }

   public void setVnbTrimf01(float var1) {
      this.vnbTrimf01 = var1;
   }

   public float getVnbTrimf02() {
      return this.vnbTrimf02;
   }

   public void setVnbTrimf02(float var1) {
      this.vnbTrimf02 = var1;
   }

   public float getVnbTrimf03() {
      return this.vnbTrimf03;
   }

   public void setVnbTrimf03(float var1) {
      this.vnbTrimf03 = var1;
   }

   public float getVnbTrimf04() {
      return this.vnbTrimf04;
   }

   public void setVnbTrimf04(float var1) {
      this.vnbTrimf04 = var1;
   }

   public float getVnbTrimf05() {
      return this.vnbTrimf05;
   }

   public void setVnbTrimf05(float var1) {
      this.vnbTrimf05 = var1;
   }

   public float getVnbTrimf06() {
      return this.vnbTrimf06;
   }

   public void setVnbTrimf06(float var1) {
      this.vnbTrimf06 = var1;
   }

   public float getVnbTrimf07() {
      return this.vnbTrimf07;
   }

   public void setVnbTrimf07(float var1) {
      this.vnbTrimf07 = var1;
   }

   public float getVnbTrimf08() {
      return this.vnbTrimf08;
   }

   public void setVnbTrimf08(float var1) {
      this.vnbTrimf08 = var1;
   }

   public float getVnbTrimf09() {
      return this.vnbTrimf09;
   }

   public void setVnbTrimf09(float var1) {
      this.vnbTrimf09 = var1;
   }

   public float getVnbTrimf10() {
      return this.vnbTrimf10;
   }

   public void setVnbTrimf10(float var1) {
      this.vnbTrimf10 = var1;
   }

   public float getVnbTrimf11() {
      return this.vnbTrimf11;
   }

   public void setVnbTrimf11(float var1) {
      this.vnbTrimf11 = var1;
   }

   public float getVnbTrimf12() {
      return this.vnbTrimf12;
   }

   public void setVnbTrimf12(float var1) {
      this.vnbTrimf12 = var1;
   }

   public int getBulligNaturePret() {
      return this.bulligNaturePret;
   }

   public void setBulligNaturePret(int var1) {
      this.bulligNaturePret = var1;
   }

   public int getBulligProrataTemporis() {
      return this.bulligProrataTemporis;
   }

   public void setBulligProrataTemporis(int var1) {
      this.bulligProrataTemporis = var1;
   }

   public boolean isBulligNonPrint() {
      return this.bulligNonPrint;
   }

   public void setBulligNonPrint(boolean var1) {
      this.bulligNonPrint = var1;
   }

   public boolean isBulligBaseAutre() {
      return this.bulligBaseAutre;
   }

   public void setBulligBaseAutre(boolean var1) {
      this.bulligBaseAutre = var1;
   }

   public boolean isBulligBaseConges() {
      return this.bulligBaseConges;
   }

   public void setBulligBaseConges(boolean var1) {
      this.bulligBaseConges = var1;
   }

   public boolean isBulligBaseFiscale() {
      return this.bulligBaseFiscale;
   }

   public void setBulligBaseFiscale(boolean var1) {
      this.bulligBaseFiscale = var1;
   }

   public boolean isBulligBasePatronale() {
      return this.bulligBasePatronale;
   }

   public void setBulligBasePatronale(boolean var1) {
      this.bulligBasePatronale = var1;
   }

   public boolean isBulligBaseSociale() {
      return this.bulligBaseSociale;
   }

   public void setBulligBaseSociale(boolean var1) {
      this.bulligBaseSociale = var1;
   }
}
