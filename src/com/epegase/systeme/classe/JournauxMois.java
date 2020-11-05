package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class JournauxMois implements Serializable {
   private long joumenId;
   private String joumenCode;
   private String joumenPeriode;
   private long joumenUserIdJournal;
   private int joumenOpenJournal;
   private String joumenOpenUserJournal;
   private String joumenCle1;
   private int joumenEtat;
   private int joumenSaisie;
   private double joumenReleve;
   private double joumenReleveAnte;
   private double joumenCorrectif;
   private double joumenCorrectifEcran;
   private ExercicesComptable exercicesComptable;
   private String imageCadnas;
   private boolean tt;
   private boolean tta;
   private String imageSaisi;
   private boolean cadenaVisible;
   private Date datejournaux;
   private boolean select;
   private String trie;

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public String getTrie() {
      if (this.joumenPeriode != null && !this.joumenPeriode.isEmpty() && this.joumenPeriode.contains(":")) {
         String[] var1 = this.joumenPeriode.split(":");
         this.trie = var1[1] + ":" + var1[0];
      }

      return this.trie;
   }

   public void setTrie(String var1) {
      this.trie = var1;
   }

   public double getJoumenReleve() {
      return this.joumenReleve;
   }

   public void setJoumenReleve(double var1) {
      this.joumenReleve = var1;
   }

   public String getJoumenCle1() {
      this.joumenCle1 = this.recupererCles();
      return this.joumenCle1;
   }

   public void setJoumenCle1(String var1) {
      this.joumenCle1 = var1;
   }

   public int getJoumenEtat() {
      if (this.joumenEtat != 1 && this.joumenEtat != 2) {
         this.setCadenaVisible(false);
      } else {
         this.tta = true;
         this.setCadenaVisible(true);
      }

      return this.joumenEtat;
   }

   public void setJoumenEtat(int var1) {
      this.joumenEtat = var1;
   }

   public int getJoumenOpenJournal() {
      return this.joumenOpenJournal;
   }

   public void setJoumenOpenJournal(int var1) {
      this.joumenOpenJournal = var1;
   }

   public String getJoumenOpenUserJournal() {
      return this.joumenOpenUserJournal;
   }

   public void setJoumenOpenUserJournal(String var1) {
      this.joumenOpenUserJournal = var1;
   }

   public int getJoumenSaisie() {
      if (this.joumenSaisie == 1) {
         this.tta = true;
      } else {
         this.tta = false;
      }

      return this.joumenSaisie;
   }

   public void setJoumenSaisie(int var1) {
      this.joumenSaisie = var1;
   }

   public String getJoumenCode() {
      return this.joumenCode;
   }

   public void setJoumenCode(String var1) {
      this.joumenCode = var1;
   }

   public long getJoumenId() {
      return this.joumenId;
   }

   public void setJoumenId(long var1) {
      this.joumenId = var1;
   }

   public String getJoumenPeriode() {
      return this.joumenPeriode;
   }

   public void setJoumenPeriode(String var1) {
      this.joumenPeriode = var1;
   }

   public String recupererCles() {
      String var1 = this.joumenCode + ":" + this.joumenPeriode;
      return var1;
   }

   public String getImageCadnas() {
      if (this.joumenEtat != 1 && this.joumenEtat != 2) {
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
      if (this.joumenSaisie == 1) {
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

   public long getJoumenUserIdJournal() {
      return this.joumenUserIdJournal;
   }

   public void setJoumenUserIdJournal(long var1) {
      this.joumenUserIdJournal = var1;
   }

   public Date getDatejournaux() {
      return this.datejournaux;
   }

   public void setDatejournaux(Date var1) {
      this.datejournaux = var1;
   }

   public double getJoumenReleveAnte() {
      return this.joumenReleveAnte;
   }

   public void setJoumenReleveAnte(double var1) {
      this.joumenReleveAnte = var1;
   }

   public double getJoumenCorrectif() {
      return this.joumenCorrectif;
   }

   public void setJoumenCorrectif(double var1) {
      this.joumenCorrectif = var1;
   }

   public double getJoumenCorrectifEcran() {
      return this.joumenCorrectifEcran;
   }

   public void setJoumenCorrectifEcran(double var1) {
      this.joumenCorrectifEcran = var1;
   }

   public boolean isSelect() {
      return this.select;
   }

   public void setSelect(boolean var1) {
      this.select = var1;
   }
}
