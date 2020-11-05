package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PlanningAvicultureAchats implements Serializable {
   private long ppaId;
   private Date ppaDateCreat;
   private Date ppaDateModif;
   private long ppaUserCreat;
   private long ppaUserModif;
   private String ppaFeuille;
   private String ppaCode;
   private int ppaJour;
   private int ppaInactif;
   private int ppaOrdre;
   private int ppaNbJour;
   private int ppaNbMortalite;
   private float ppaPoids;
   private String ppaTemperature;
   private String ppaHumidite;
   private float ppaQteEau;
   private float ppaQteAliment;
   private String ppaAction1;
   private String ppaAction2;
   private String ppaAction3;
   private String ppaTraitement1;
   private String ppaTraitement2;
   private String ppaTraitement3;
   private String ppaVaccin1;
   private String ppaVaccin2;
   private String ppaVaccin3;
   private String ppaObservation;

   public String getPpaCode() {
      return this.ppaCode;
   }

   public void setPpaCode(String var1) {
      this.ppaCode = var1;
   }

   public Date getPpaDateCreat() {
      return this.ppaDateCreat;
   }

   public void setPpaDateCreat(Date var1) {
      this.ppaDateCreat = var1;
   }

   public Date getPpaDateModif() {
      return this.ppaDateModif;
   }

   public void setPpaDateModif(Date var1) {
      this.ppaDateModif = var1;
   }

   public String getPpaFeuille() {
      return this.ppaFeuille;
   }

   public void setPpaFeuille(String var1) {
      this.ppaFeuille = var1;
   }

   public long getPpaId() {
      return this.ppaId;
   }

   public void setPpaId(long var1) {
      this.ppaId = var1;
   }

   public int getPpaInactif() {
      return this.ppaInactif;
   }

   public void setPpaInactif(int var1) {
      this.ppaInactif = var1;
   }

   public int getPpaNbMortalite() {
      return this.ppaNbMortalite;
   }

   public void setPpaNbMortalite(int var1) {
      this.ppaNbMortalite = var1;
   }

   public int getPpaNbJour() {
      return this.ppaNbJour;
   }

   public void setPpaNbJour(int var1) {
      this.ppaNbJour = var1;
   }

   public String getPpaObservation() {
      return this.ppaObservation;
   }

   public void setPpaObservation(String var1) {
      this.ppaObservation = var1;
   }

   public int getPpaOrdre() {
      return this.ppaOrdre;
   }

   public void setPpaOrdre(int var1) {
      this.ppaOrdre = var1;
   }

   public float getPpaQteAliment() {
      return this.ppaQteAliment;
   }

   public void setPpaQteAliment(float var1) {
      this.ppaQteAliment = var1;
   }

   public float getPpaQteEau() {
      return this.ppaQteEau;
   }

   public void setPpaQteEau(float var1) {
      this.ppaQteEau = var1;
   }

   public String getPpaTraitement1() {
      return this.ppaTraitement1;
   }

   public void setPpaTraitement1(String var1) {
      this.ppaTraitement1 = var1;
   }

   public String getPpaTraitement2() {
      return this.ppaTraitement2;
   }

   public void setPpaTraitement2(String var1) {
      this.ppaTraitement2 = var1;
   }

   public String getPpaTraitement3() {
      return this.ppaTraitement3;
   }

   public void setPpaTraitement3(String var1) {
      this.ppaTraitement3 = var1;
   }

   public long getPpaUserCreat() {
      return this.ppaUserCreat;
   }

   public void setPpaUserCreat(long var1) {
      this.ppaUserCreat = var1;
   }

   public long getPpaUserModif() {
      return this.ppaUserModif;
   }

   public void setPpaUserModif(long var1) {
      this.ppaUserModif = var1;
   }

   public String getPpaVaccin1() {
      return this.ppaVaccin1;
   }

   public void setPpaVaccin1(String var1) {
      this.ppaVaccin1 = var1;
   }

   public String getPpaVaccin2() {
      return this.ppaVaccin2;
   }

   public void setPpaVaccin2(String var1) {
      this.ppaVaccin2 = var1;
   }

   public String getPpaVaccin3() {
      return this.ppaVaccin3;
   }

   public void setPpaVaccin3(String var1) {
      this.ppaVaccin3 = var1;
   }

   public int getPpaJour() {
      return this.ppaJour;
   }

   public void setPpaJour(int var1) {
      this.ppaJour = var1;
   }

   public String getPpaAction1() {
      return this.ppaAction1;
   }

   public void setPpaAction1(String var1) {
      this.ppaAction1 = var1;
   }

   public String getPpaAction2() {
      return this.ppaAction2;
   }

   public void setPpaAction2(String var1) {
      this.ppaAction2 = var1;
   }

   public String getPpaAction3() {
      return this.ppaAction3;
   }

   public void setPpaAction3(String var1) {
      this.ppaAction3 = var1;
   }

   public float getPpaPoids() {
      return this.ppaPoids;
   }

   public void setPpaPoids(float var1) {
      this.ppaPoids = var1;
   }

   public String getPpaHumidite() {
      return this.ppaHumidite;
   }

   public void setPpaHumidite(String var1) {
      this.ppaHumidite = var1;
   }

   public String getPpaTemperature() {
      return this.ppaTemperature;
   }

   public void setPpaTemperature(String var1) {
      this.ppaTemperature = var1;
   }
}
