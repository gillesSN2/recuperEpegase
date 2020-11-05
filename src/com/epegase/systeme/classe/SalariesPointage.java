package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class SalariesPointage implements Serializable {
   private long salpoiId;
   private Date salpoiDateCreat;
   private Date salpoiDateModif;
   private long salpoiUserCreat;
   private long salpoiUserModif;
   private String salpoiNum;
   private String salpoiContrat;
   private int salpoiEtat;
   private int salpoiNature;
   private Date salpoiDate;
   private String salpoiPeriode;
   private int salpoiHeureDebut;
   private int salpoiMinuteDebut;
   private int salpoiHeureFin;
   private int salpoiMinuteFin;
   private float salpoiDuree;
   private String salpoiObjet;
   private String salpoiMission;
   private String salpoiService;
   private String salpoiActivite;
   private String salpoiTache;
   private String salpoiNomTiers;
   private long salpoiIdTiers;
   private double salpoiPr;
   private double salpoiPv;
   private int salpoiType;
   private Salaries salaries;
   private ExercicesPaye exercicesPaye;
   private int var_jour;
   private String libelleMission;
   private String libelleTache;
   private String libelleType;

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public String getLibelleType() {
      if (this.salpoiType == 1) {
         this.libelleType = "FERIE";
      } else {
         this.libelleType = "";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getLibelleMission() {
      return this.libelleMission;
   }

   public void setLibelleMission(String var1) {
      this.libelleMission = var1;
   }

   public String getLibelleTache() {
      return this.libelleTache;
   }

   public void setLibelleTache(String var1) {
      this.libelleTache = var1;
   }

   public int getVar_jour() {
      if (this.salpoiDate != null) {
         this.var_jour = this.salpoiDate.getDate();
      } else {
         this.var_jour = 0;
      }

      return this.var_jour;
   }

   public void setVar_jour(int var1) {
      this.var_jour = var1;
   }

   public String getSalpoiActivite() {
      return this.salpoiActivite;
   }

   public void setSalpoiActivite(String var1) {
      this.salpoiActivite = var1;
   }

   public Date getSalpoiDate() {
      return this.salpoiDate;
   }

   public void setSalpoiDate(Date var1) {
      this.salpoiDate = var1;
   }

   public Date getSalpoiDateCreat() {
      return this.salpoiDateCreat;
   }

   public void setSalpoiDateCreat(Date var1) {
      this.salpoiDateCreat = var1;
   }

   public Date getSalpoiDateModif() {
      return this.salpoiDateModif;
   }

   public void setSalpoiDateModif(Date var1) {
      this.salpoiDateModif = var1;
   }

   public float getSalpoiDuree() {
      return this.salpoiDuree;
   }

   public void setSalpoiDuree(float var1) {
      this.salpoiDuree = var1;
   }

   public int getSalpoiHeureDebut() {
      return this.salpoiHeureDebut;
   }

   public void setSalpoiHeureDebut(int var1) {
      this.salpoiHeureDebut = var1;
   }

   public int getSalpoiHeureFin() {
      return this.salpoiHeureFin;
   }

   public void setSalpoiHeureFin(int var1) {
      this.salpoiHeureFin = var1;
   }

   public long getSalpoiId() {
      return this.salpoiId;
   }

   public void setSalpoiId(long var1) {
      this.salpoiId = var1;
   }

   public int getSalpoiMinuteDebut() {
      return this.salpoiMinuteDebut;
   }

   public void setSalpoiMinuteDebut(int var1) {
      this.salpoiMinuteDebut = var1;
   }

   public int getSalpoiMinuteFin() {
      return this.salpoiMinuteFin;
   }

   public void setSalpoiMinuteFin(int var1) {
      this.salpoiMinuteFin = var1;
   }

   public int getSalpoiNature() {
      return this.salpoiNature;
   }

   public void setSalpoiNature(int var1) {
      this.salpoiNature = var1;
   }

   public String getSalpoiNum() {
      return this.salpoiNum;
   }

   public void setSalpoiNum(String var1) {
      this.salpoiNum = var1;
   }

   public String getSalpoiObjet() {
      return this.salpoiObjet;
   }

   public void setSalpoiObjet(String var1) {
      this.salpoiObjet = var1;
   }

   public String getSalpoiService() {
      return this.salpoiService;
   }

   public void setSalpoiService(String var1) {
      this.salpoiService = var1;
   }

   public long getSalpoiUserCreat() {
      return this.salpoiUserCreat;
   }

   public void setSalpoiUserCreat(long var1) {
      this.salpoiUserCreat = var1;
   }

   public long getSalpoiUserModif() {
      return this.salpoiUserModif;
   }

   public void setSalpoiUserModif(long var1) {
      this.salpoiUserModif = var1;
   }

   public String getSalpoiPeriode() {
      return this.salpoiPeriode;
   }

   public void setSalpoiPeriode(String var1) {
      this.salpoiPeriode = var1;
   }

   public int getSalpoiEtat() {
      return this.salpoiEtat;
   }

   public void setSalpoiEtat(int var1) {
      this.salpoiEtat = var1;
   }

   public String getSalpoiMission() {
      return this.salpoiMission;
   }

   public void setSalpoiMission(String var1) {
      this.salpoiMission = var1;
   }

   public String getSalpoiTache() {
      return this.salpoiTache;
   }

   public void setSalpoiTache(String var1) {
      this.salpoiTache = var1;
   }

   public long getSalpoiIdTiers() {
      return this.salpoiIdTiers;
   }

   public void setSalpoiIdTiers(long var1) {
      this.salpoiIdTiers = var1;
   }

   public String getSalpoiNomTiers() {
      return this.salpoiNomTiers;
   }

   public void setSalpoiNomTiers(String var1) {
      this.salpoiNomTiers = var1;
   }

   public double getSalpoiPr() {
      return this.salpoiPr;
   }

   public void setSalpoiPr(double var1) {
      this.salpoiPr = var1;
   }

   public double getSalpoiPv() {
      return this.salpoiPv;
   }

   public void setSalpoiPv(double var1) {
      this.salpoiPv = var1;
   }

   public int getSalpoiType() {
      return this.salpoiType;
   }

   public void setSalpoiType(int var1) {
      this.salpoiType = var1;
   }

   public String getSalpoiContrat() {
      return this.salpoiContrat;
   }

   public void setSalpoiContrat(String var1) {
      this.salpoiContrat = var1;
   }
}
