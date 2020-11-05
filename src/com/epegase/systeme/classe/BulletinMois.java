package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class BulletinMois implements Serializable {
   private long bulmenId;
   private String bulmenFeuille;
   private String bulmenPeriode;
   private Date bulmenJour;
   private String bulmenCle1;
   private int bulmenEtat;
   private long bulmenUserIdJournal;
   private int bulmenOpenJournal;
   private String bulmenOpenUserJournal;
   private long bulmenUserIdGeneration;
   private int bulmenOpenGeneration;
   private String bulmenOpenUserGeneration;
   private int bulmenModeTravail;
   private double bulmenProductionReelle;
   private double bulmenProductionTheo;
   private double bulmenNbHeureRelle;
   private int bulmenLot;
   private ExercicesPaye exercicesPaye;
   private String libEtat;
   private boolean select;

   public String getLibEtat() {
      if (this.bulmenEtat == 0) {
         this.libEtat = "En cours";
      } else if (this.bulmenEtat == 1) {
         this.libEtat = "Saisie";
      } else if (this.bulmenEtat == 2) {
         this.libEtat = "Génération";
      } else if (this.bulmenEtat == 3) {
         this.libEtat = "Cloture";
      } else if (this.bulmenEtat == 4) {
         this.libEtat = "Transféré";
      }

      return this.libEtat;
   }

   public void setLibEtat(String var1) {
      this.libEtat = var1;
   }

   public String getBulmenCle1() {
      return this.bulmenCle1;
   }

   public void setBulmenCle1(String var1) {
      this.bulmenCle1 = var1;
   }

   public int getBulmenEtat() {
      return this.bulmenEtat;
   }

   public void setBulmenEtat(int var1) {
      this.bulmenEtat = var1;
   }

   public String getBulmenFeuille() {
      return this.bulmenFeuille;
   }

   public void setBulmenFeuille(String var1) {
      this.bulmenFeuille = var1;
   }

   public long getBulmenId() {
      return this.bulmenId;
   }

   public void setBulmenId(long var1) {
      this.bulmenId = var1;
   }

   public String getBulmenPeriode() {
      return this.bulmenPeriode;
   }

   public void setBulmenPeriode(String var1) {
      this.bulmenPeriode = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public int getBulmenOpenJournal() {
      return this.bulmenOpenJournal;
   }

   public void setBulmenOpenJournal(int var1) {
      this.bulmenOpenJournal = var1;
   }

   public String getBulmenOpenUserJournal() {
      return this.bulmenOpenUserJournal;
   }

   public void setBulmenOpenUserJournal(String var1) {
      this.bulmenOpenUserJournal = var1;
   }

   public long getBulmenUserIdJournal() {
      return this.bulmenUserIdJournal;
   }

   public void setBulmenUserIdJournal(long var1) {
      this.bulmenUserIdJournal = var1;
   }

   public int getBulmenOpenGeneration() {
      return this.bulmenOpenGeneration;
   }

   public void setBulmenOpenGeneration(int var1) {
      this.bulmenOpenGeneration = var1;
   }

   public String getBulmenOpenUserGeneration() {
      return this.bulmenOpenUserGeneration;
   }

   public void setBulmenOpenUserGeneration(String var1) {
      this.bulmenOpenUserGeneration = var1;
   }

   public long getBulmenUserIdGeneration() {
      return this.bulmenUserIdGeneration;
   }

   public void setBulmenUserIdGeneration(long var1) {
      this.bulmenUserIdGeneration = var1;
   }

   public Date getBulmenJour() {
      return this.bulmenJour;
   }

   public void setBulmenJour(Date var1) {
      this.bulmenJour = var1;
   }

   public int getBulmenModeTravail() {
      return this.bulmenModeTravail;
   }

   public void setBulmenModeTravail(int var1) {
      this.bulmenModeTravail = var1;
   }

   public double getBulmenProductionReelle() {
      return this.bulmenProductionReelle;
   }

   public void setBulmenProductionReelle(double var1) {
      this.bulmenProductionReelle = var1;
   }

   public double getBulmenProductionTheo() {
      return this.bulmenProductionTheo;
   }

   public void setBulmenProductionTheo(double var1) {
      this.bulmenProductionTheo = var1;
   }

   public int getBulmenLot() {
      return this.bulmenLot;
   }

   public void setBulmenLot(int var1) {
      this.bulmenLot = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public double getBulmenNbHeureRelle() {
      return this.bulmenNbHeureRelle;
   }

   public void setBulmenNbHeureRelle(double var1) {
      this.bulmenNbHeureRelle = var1;
   }
}
