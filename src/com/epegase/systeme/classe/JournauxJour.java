package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class JournauxJour implements Serializable {
   private long joujrId;
   private Date joujrDate;
   private String joujrCode;
   private String joujrPeriode;
   private long joujrUserIdJournal;
   private int joujrOpenJournal;
   private String joujrOpenUserJournal;
   private String joujrCle1;
   private int joujrEtat;
   private int joujrSaisie;
   private double joujrReleve;
   private double joujrReleveAnte;
   private double joujrCorrectif;
   private double joujrCorrectifEcran;
   private ExercicesComptable exercicesComptable;
   private String imageCadnas;
   private boolean tt;
   private boolean tta;
   private String imageSaisi;
   private boolean cadenaVisible;
   private boolean select;

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public String recupererCles() {
      String var1 = this.joujrCode + ":" + this.joujrPeriode;
      return var1;
   }

   public String getImageCadnas() {
      if (this.joujrEtat != 1 && this.joujrEtat != 2) {
         this.setCadenaVisible(true);
      } else {
         this.tt = true;
         this.imageCadnas = "/images/cadenas_cl.gif";
         this.setCadenaVisible(true);
      }

      return this.imageCadnas;
   }

   public void setImageCadnas(String var1) {
      this.imageCadnas = var1;
   }

   public String getImageSaisi() {
      if (this.joujrSaisie == 1) {
         this.tta = true;
         this.imageSaisi = "/images/journal_saisie.gif";
      }

      return this.imageSaisi;
   }

   public void setImageSaisi(String var1) {
      this.imageSaisi = var1;
   }

   public boolean isTt() {
      return this.tt;
   }

   public void setTt(boolean var1) {
      this.tt = var1;
   }

   public boolean isTta() {
      return this.tta;
   }

   public void setTta(boolean var1) {
      this.tta = var1;
   }

   public boolean isCadenaVisible() {
      return this.cadenaVisible;
   }

   public void setCadenaVisible(boolean var1) {
      this.cadenaVisible = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }

   public String getJoujrCle1() {
      return this.joujrCle1;
   }

   public void setJoujrCle1(String var1) {
      this.joujrCle1 = var1;
   }

   public String getJoujrCode() {
      return this.joujrCode;
   }

   public void setJoujrCode(String var1) {
      this.joujrCode = var1;
   }

   public double getJoujrCorrectif() {
      return this.joujrCorrectif;
   }

   public void setJoujrCorrectif(double var1) {
      this.joujrCorrectif = var1;
   }

   public double getJoujrCorrectifEcran() {
      return this.joujrCorrectifEcran;
   }

   public void setJoujrCorrectifEcran(double var1) {
      this.joujrCorrectifEcran = var1;
   }

   public Date getJoujrDate() {
      return this.joujrDate;
   }

   public void setJoujrDate(Date var1) {
      this.joujrDate = var1;
   }

   public int getJoujrEtat() {
      return this.joujrEtat;
   }

   public void setJoujrEtat(int var1) {
      this.joujrEtat = var1;
   }

   public long getJoujrId() {
      return this.joujrId;
   }

   public void setJoujrId(long var1) {
      this.joujrId = var1;
   }

   public int getJoujrOpenJournal() {
      return this.joujrOpenJournal;
   }

   public void setJoujrOpenJournal(int var1) {
      this.joujrOpenJournal = var1;
   }

   public String getJoujrOpenUserJournal() {
      return this.joujrOpenUserJournal;
   }

   public void setJoujrOpenUserJournal(String var1) {
      this.joujrOpenUserJournal = var1;
   }

   public String getJoujrPeriode() {
      return this.joujrPeriode;
   }

   public void setJoujrPeriode(String var1) {
      this.joujrPeriode = var1;
   }

   public double getJoujrReleve() {
      return this.joujrReleve;
   }

   public void setJoujrReleve(double var1) {
      this.joujrReleve = var1;
   }

   public double getJoujrReleveAnte() {
      return this.joujrReleveAnte;
   }

   public void setJoujrReleveAnte(double var1) {
      this.joujrReleveAnte = var1;
   }

   public int getJoujrSaisie() {
      return this.joujrSaisie;
   }

   public void setJoujrSaisie(int var1) {
      this.joujrSaisie = var1;
   }

   public long getJoujrUserIdJournal() {
      return this.joujrUserIdJournal;
   }

   public void setJoujrUserIdJournal(long var1) {
      this.joujrUserIdJournal = var1;
   }
}
