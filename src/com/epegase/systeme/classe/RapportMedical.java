package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class RapportMedical implements Serializable {
   private long rapmedId;
   private Date rapmedDateCreat;
   private Date rapmedDateModif;
   private long rapmedUserCreat;
   private long rapmedUserModif;
   private String rapmedNomCreateur;
   private String rapmedNomModif;
   private Date rapmedDate;
   private String rapmedNum;
   private String rapmedPeriode;
   private String rapmedService;
   private String rapmedNomMedecin;
   private long rapmedIdMedecin;
   private int rapmedEtat;
   private String rapmedRapport;
   private ExercicesVentes exerciceventes;
   private String etat;

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public String getEtat() {
      if (this.rapmedEtat == 0) {
         this.etat = "EC.";
      } else if (this.rapmedEtat == 1) {
         this.etat = "Val.";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public Date getRapmedDate() {
      return this.rapmedDate;
   }

   public void setRapmedDate(Date var1) {
      this.rapmedDate = var1;
   }

   public Date getRapmedDateCreat() {
      return this.rapmedDateCreat;
   }

   public void setRapmedDateCreat(Date var1) {
      this.rapmedDateCreat = var1;
   }

   public Date getRapmedDateModif() {
      return this.rapmedDateModif;
   }

   public void setRapmedDateModif(Date var1) {
      this.rapmedDateModif = var1;
   }

   public int getRapmedEtat() {
      return this.rapmedEtat;
   }

   public void setRapmedEtat(int var1) {
      this.rapmedEtat = var1;
   }

   public long getRapmedId() {
      return this.rapmedId;
   }

   public void setRapmedId(long var1) {
      this.rapmedId = var1;
   }

   public long getRapmedIdMedecin() {
      return this.rapmedIdMedecin;
   }

   public void setRapmedIdMedecin(long var1) {
      this.rapmedIdMedecin = var1;
   }

   public String getRapmedNomMedecin() {
      return this.rapmedNomMedecin;
   }

   public void setRapmedNomMedecin(String var1) {
      this.rapmedNomMedecin = var1;
   }

   public String getRapmedPeriode() {
      return this.rapmedPeriode;
   }

   public void setRapmedPeriode(String var1) {
      this.rapmedPeriode = var1;
   }

   public String getRapmedRapport() {
      return this.rapmedRapport;
   }

   public void setRapmedRapport(String var1) {
      this.rapmedRapport = var1;
   }

   public String getRapmedService() {
      return this.rapmedService;
   }

   public void setRapmedService(String var1) {
      this.rapmedService = var1;
   }

   public long getRapmedUserCreat() {
      return this.rapmedUserCreat;
   }

   public void setRapmedUserCreat(long var1) {
      this.rapmedUserCreat = var1;
   }

   public long getRapmedUserModif() {
      return this.rapmedUserModif;
   }

   public void setRapmedUserModif(long var1) {
      this.rapmedUserModif = var1;
   }

   public String getRapmedNum() {
      return this.rapmedNum;
   }

   public void setRapmedNum(String var1) {
      this.rapmedNum = var1;
   }

   public String getRapmedNomCreateur() {
      return this.rapmedNomCreateur;
   }

   public void setRapmedNomCreateur(String var1) {
      this.rapmedNomCreateur = var1;
   }

   public String getRapmedNomModif() {
      return this.rapmedNomModif;
   }

   public void setRapmedNomModif(String var1) {
      this.rapmedNomModif = var1;
   }
}
