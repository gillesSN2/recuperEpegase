package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PlanComptable implements Serializable {
   private long plcId;
   private Date plcDateCreat;
   private Date plcDateModif;
   private long plcUserCreat;
   private long plcUserModif;
   private String plcFiscalite;
   private String plcCompte;
   private String plcLibre;
   private String plcLibelleCpteFR;
   private String plcLibelleCpteUK;
   private String plcLibelleCpteSP;
   private String plcCodeRacine;
   private String plcLibelleRacineFR;
   private String plcLibelleRacineUK;
   private String plcLibelleRacineSP;
   private int plcNature;
   private boolean plcRanDetaille;
   private Float plcTauxTaxe;
   private int plcInactif;
   private String plcLibelleNatureFR;
   private String plcLibelleNatureUK;
   private String plcLibelleNatureSP;
   private int plcSens;
   private String plcAnalCle1;
   private String plcAnalCle2;
   private String plcSage;
   private String plcCompteSyscohada;
   private String plcCompteAutre;
   private ExercicesComptable exercicesComptable;
   private boolean afficheImag;
   private String etat;
   private boolean var_select;

   public String getEtat() {
      if (this.plcInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.plcInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.plcInactif != 1 && this.plcInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public String getPlcCodeRacine() {
      return this.plcCodeRacine;
   }

   public void setPlcCodeRacine(String var1) {
      this.plcCodeRacine = var1;
   }

   public String getPlcCompte() {
      return this.plcCompte;
   }

   public void setPlcCompte(String var1) {
      this.plcCompte = var1;
   }

   public Date getPlcDateCreat() {
      return this.plcDateCreat;
   }

   public void setPlcDateCreat(Date var1) {
      this.plcDateCreat = var1;
   }

   public Date getPlcDateModif() {
      return this.plcDateModif;
   }

   public void setPlcDateModif(Date var1) {
      this.plcDateModif = var1;
   }

   public long getPlcId() {
      return this.plcId;
   }

   public void setPlcId(long var1) {
      this.plcId = var1;
   }

   public int getPlcInactif() {
      return this.plcInactif;
   }

   public void setPlcInactif(int var1) {
      this.plcInactif = var1;
   }

   public String getPlcLibelleCpteFR() {
      return this.plcLibelleCpteFR;
   }

   public void setPlcLibelleCpteFR(String var1) {
      this.plcLibelleCpteFR = var1;
   }

   public String getPlcLibelleCpteSP() {
      return this.plcLibelleCpteSP;
   }

   public void setPlcLibelleCpteSP(String var1) {
      this.plcLibelleCpteSP = var1;
   }

   public String getPlcLibelleCpteUK() {
      return this.plcLibelleCpteUK;
   }

   public void setPlcLibelleCpteUK(String var1) {
      this.plcLibelleCpteUK = var1;
   }

   public String getPlcLibelleNatureFR() {
      return this.plcLibelleNatureFR;
   }

   public void setPlcLibelleNatureFR(String var1) {
      this.plcLibelleNatureFR = var1;
   }

   public String getPlcLibelleNatureSP() {
      return this.plcLibelleNatureSP;
   }

   public void setPlcLibelleNatureSP(String var1) {
      this.plcLibelleNatureSP = var1;
   }

   public String getPlcLibelleNatureUK() {
      return this.plcLibelleNatureUK;
   }

   public void setPlcLibelleNatureUK(String var1) {
      this.plcLibelleNatureUK = var1;
   }

   public String getPlcLibelleRacineFR() {
      return this.plcLibelleRacineFR;
   }

   public void setPlcLibelleRacineFR(String var1) {
      this.plcLibelleRacineFR = var1;
   }

   public String getPlcLibelleRacineSP() {
      return this.plcLibelleRacineSP;
   }

   public void setPlcLibelleRacineSP(String var1) {
      this.plcLibelleRacineSP = var1;
   }

   public String getPlcLibelleRacineUK() {
      return this.plcLibelleRacineUK;
   }

   public void setPlcLibelleRacineUK(String var1) {
      this.plcLibelleRacineUK = var1;
   }

   public String getPlcLibre() {
      return this.plcLibre;
   }

   public void setPlcLibre(String var1) {
      this.plcLibre = var1;
   }

   public int getPlcNature() {
      return this.plcNature;
   }

   public void setPlcNature(int var1) {
      this.plcNature = var1;
   }

   public boolean isPlcRanDetaille() {
      return this.plcRanDetaille;
   }

   public void setPlcRanDetaille(boolean var1) {
      this.plcRanDetaille = var1;
   }

   public int getPlcSens() {
      return this.plcSens;
   }

   public void setPlcSens(int var1) {
      this.plcSens = var1;
   }

   public Float getPlcTauxTaxe() {
      return this.plcTauxTaxe;
   }

   public void setPlcTauxTaxe(Float var1) {
      this.plcTauxTaxe = var1;
   }

   public long getPlcUserCreat() {
      return this.plcUserCreat;
   }

   public void setPlcUserCreat(long var1) {
      this.plcUserCreat = var1;
   }

   public long getPlcUserModif() {
      return this.plcUserModif;
   }

   public void setPlcUserModif(long var1) {
      this.plcUserModif = var1;
   }

   public boolean isVar_select() {
      return this.var_select;
   }

   public void setVar_select(boolean var1) {
      this.var_select = var1;
   }

   public String getPlcAnalCle1() {
      return this.plcAnalCle1;
   }

   public void setPlcAnalCle1(String var1) {
      this.plcAnalCle1 = var1;
   }

   public String getPlcAnalCle2() {
      return this.plcAnalCle2;
   }

   public void setPlcAnalCle2(String var1) {
      this.plcAnalCle2 = var1;
   }

   public String getPlcSage() {
      return this.plcSage;
   }

   public void setPlcSage(String var1) {
      this.plcSage = var1;
   }

   public String getPlcFiscalite() {
      return this.plcFiscalite;
   }

   public void setPlcFiscalite(String var1) {
      this.plcFiscalite = var1;
   }

   public String getPlcCompteAutre() {
      return this.plcCompteAutre;
   }

   public void setPlcCompteAutre(String var1) {
      this.plcCompteAutre = var1;
   }

   public String getPlcCompteSyscohada() {
      return this.plcCompteSyscohada;
   }

   public void setPlcCompteSyscohada(String var1) {
      this.plcCompteSyscohada = var1;
   }
}
