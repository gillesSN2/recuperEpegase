package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ReceptionAvicultureAchats implements Serializable {
   private long recaviId;
   private String recaviFeuille;
   private String recaviCode;
   private Date recaviDate;
   private int recaviJour;
   private int recaviOrdre;
   private int recaviNbJour;
   private int recaviNbMortalite;
   private int recaviNbMortaliteReel;
   private float recaviPoids;
   private float recaviPoidsReel;
   private String recaviTemperature;
   private float recaviTemperatureReel;
   private String recaviHumidite;
   private float recaviQteEau;
   private float recaviQteEauReel;
   private float recaviQteAliment;
   private float recaviQteAlimentReel;
   private String recaviAction1;
   private int recaviRepAction1;
   private String recaviAction2;
   private int recaviRepAction2;
   private String recaviAction3;
   private int recaviRepAction3;
   private String recaviTraitement1;
   private int recaviRepTraitement1;
   private float recaviQteTraitement1;
   private String recaviTraitement2;
   private int recaviRepTraitement2;
   private float recaviQteTraitement2;
   private String recaviTraitement3;
   private int recaviRepTraitement3;
   private float recaviQteTraitement3;
   private String recaviVaccin1;
   private int recaviRepVaccin1;
   private float recaviQteVaccin1;
   private String recaviVaccin2;
   private int recaviRepVaccin2;
   private float recaviQteVaccin2;
   private String recaviVaccin3;
   private int recaviRepVaccin3;
   private float recaviQteVaccin3;
   private String recaviObservation;
   private ReceptionEnteteAchats receptionEnteteAchats;

   public String getRecaviAction1() {
      return this.recaviAction1;
   }

   public void setRecaviAction1(String var1) {
      this.recaviAction1 = var1;
   }

   public String getRecaviAction2() {
      return this.recaviAction2;
   }

   public void setRecaviAction2(String var1) {
      this.recaviAction2 = var1;
   }

   public String getRecaviAction3() {
      return this.recaviAction3;
   }

   public void setRecaviAction3(String var1) {
      this.recaviAction3 = var1;
   }

   public String getRecaviCode() {
      return this.recaviCode;
   }

   public void setRecaviCode(String var1) {
      this.recaviCode = var1;
   }

   public String getRecaviFeuille() {
      return this.recaviFeuille;
   }

   public void setRecaviFeuille(String var1) {
      this.recaviFeuille = var1;
   }

   public String getRecaviHumidite() {
      return this.recaviHumidite;
   }

   public void setRecaviHumidite(String var1) {
      this.recaviHumidite = var1;
   }

   public long getRecaviId() {
      return this.recaviId;
   }

   public void setRecaviId(long var1) {
      this.recaviId = var1;
   }

   public int getRecaviJour() {
      return this.recaviJour;
   }

   public void setRecaviJour(int var1) {
      this.recaviJour = var1;
   }

   public int getRecaviNbJour() {
      return this.recaviNbJour;
   }

   public void setRecaviNbJour(int var1) {
      this.recaviNbJour = var1;
   }

   public int getRecaviNbMortalite() {
      return this.recaviNbMortalite;
   }

   public void setRecaviNbMortalite(int var1) {
      this.recaviNbMortalite = var1;
   }

   public int getRecaviNbMortaliteReel() {
      return this.recaviNbMortaliteReel;
   }

   public void setRecaviNbMortaliteReel(int var1) {
      this.recaviNbMortaliteReel = var1;
   }

   public String getRecaviObservation() {
      return this.recaviObservation;
   }

   public void setRecaviObservation(String var1) {
      this.recaviObservation = var1;
   }

   public int getRecaviOrdre() {
      return this.recaviOrdre;
   }

   public void setRecaviOrdre(int var1) {
      this.recaviOrdre = var1;
   }

   public float getRecaviPoids() {
      return this.recaviPoids;
   }

   public void setRecaviPoids(float var1) {
      this.recaviPoids = var1;
   }

   public float getRecaviPoidsReel() {
      return this.recaviPoidsReel;
   }

   public void setRecaviPoidsReel(float var1) {
      this.recaviPoidsReel = var1;
   }

   public float getRecaviQteAliment() {
      return this.recaviQteAliment;
   }

   public void setRecaviQteAliment(float var1) {
      this.recaviQteAliment = var1;
   }

   public float getRecaviQteAlimentReel() {
      return this.recaviQteAlimentReel;
   }

   public void setRecaviQteAlimentReel(float var1) {
      this.recaviQteAlimentReel = var1;
   }

   public float getRecaviQteEau() {
      return this.recaviQteEau;
   }

   public void setRecaviQteEau(float var1) {
      this.recaviQteEau = var1;
   }

   public float getRecaviQteEauReel() {
      return this.recaviQteEauReel;
   }

   public void setRecaviQteEauReel(float var1) {
      this.recaviQteEauReel = var1;
   }

   public float getRecaviQteTraitement1() {
      return this.recaviQteTraitement1;
   }

   public void setRecaviQteTraitement1(float var1) {
      this.recaviQteTraitement1 = var1;
   }

   public float getRecaviQteTraitement2() {
      return this.recaviQteTraitement2;
   }

   public void setRecaviQteTraitement2(float var1) {
      this.recaviQteTraitement2 = var1;
   }

   public float getRecaviQteTraitement3() {
      return this.recaviQteTraitement3;
   }

   public void setRecaviQteTraitement3(float var1) {
      this.recaviQteTraitement3 = var1;
   }

   public float getRecaviQteVaccin1() {
      return this.recaviQteVaccin1;
   }

   public void setRecaviQteVaccin1(float var1) {
      this.recaviQteVaccin1 = var1;
   }

   public float getRecaviQteVaccin2() {
      return this.recaviQteVaccin2;
   }

   public void setRecaviQteVaccin2(float var1) {
      this.recaviQteVaccin2 = var1;
   }

   public float getRecaviQteVaccin3() {
      return this.recaviQteVaccin3;
   }

   public void setRecaviQteVaccin3(float var1) {
      this.recaviQteVaccin3 = var1;
   }

   public String getRecaviTemperature() {
      return this.recaviTemperature;
   }

   public void setRecaviTemperature(String var1) {
      this.recaviTemperature = var1;
   }

   public float getRecaviTemperatureReel() {
      return this.recaviTemperatureReel;
   }

   public void setRecaviTemperatureReel(float var1) {
      this.recaviTemperatureReel = var1;
   }

   public String getRecaviTraitement1() {
      return this.recaviTraitement1;
   }

   public void setRecaviTraitement1(String var1) {
      this.recaviTraitement1 = var1;
   }

   public String getRecaviTraitement2() {
      return this.recaviTraitement2;
   }

   public void setRecaviTraitement2(String var1) {
      this.recaviTraitement2 = var1;
   }

   public String getRecaviTraitement3() {
      return this.recaviTraitement3;
   }

   public void setRecaviTraitement3(String var1) {
      this.recaviTraitement3 = var1;
   }

   public String getRecaviVaccin1() {
      return this.recaviVaccin1;
   }

   public void setRecaviVaccin1(String var1) {
      this.recaviVaccin1 = var1;
   }

   public String getRecaviVaccin2() {
      return this.recaviVaccin2;
   }

   public void setRecaviVaccin2(String var1) {
      this.recaviVaccin2 = var1;
   }

   public String getRecaviVaccin3() {
      return this.recaviVaccin3;
   }

   public void setRecaviVaccin3(String var1) {
      this.recaviVaccin3 = var1;
   }

   public ReceptionEnteteAchats getReceptionEnteteAchats() {
      return this.receptionEnteteAchats;
   }

   public void setReceptionEnteteAchats(ReceptionEnteteAchats var1) {
      this.receptionEnteteAchats = var1;
   }

   public Date getRecaviDate() {
      return this.recaviDate;
   }

   public void setRecaviDate(Date var1) {
      this.recaviDate = var1;
   }

   public int getRecaviRepAction1() {
      return this.recaviRepAction1;
   }

   public void setRecaviRepAction1(int var1) {
      this.recaviRepAction1 = var1;
   }

   public int getRecaviRepAction2() {
      return this.recaviRepAction2;
   }

   public void setRecaviRepAction2(int var1) {
      this.recaviRepAction2 = var1;
   }

   public int getRecaviRepAction3() {
      return this.recaviRepAction3;
   }

   public void setRecaviRepAction3(int var1) {
      this.recaviRepAction3 = var1;
   }

   public int getRecaviRepTraitement1() {
      return this.recaviRepTraitement1;
   }

   public void setRecaviRepTraitement1(int var1) {
      this.recaviRepTraitement1 = var1;
   }

   public int getRecaviRepTraitement2() {
      return this.recaviRepTraitement2;
   }

   public void setRecaviRepTraitement2(int var1) {
      this.recaviRepTraitement2 = var1;
   }

   public int getRecaviRepTraitement3() {
      return this.recaviRepTraitement3;
   }

   public void setRecaviRepTraitement3(int var1) {
      this.recaviRepTraitement3 = var1;
   }

   public int getRecaviRepVaccin1() {
      return this.recaviRepVaccin1;
   }

   public void setRecaviRepVaccin1(int var1) {
      this.recaviRepVaccin1 = var1;
   }

   public int getRecaviRepVaccin2() {
      return this.recaviRepVaccin2;
   }

   public void setRecaviRepVaccin2(int var1) {
      this.recaviRepVaccin2 = var1;
   }

   public int getRecaviRepVaccin3() {
      return this.recaviRepVaccin3;
   }

   public void setRecaviRepVaccin3(int var1) {
      this.recaviRepVaccin3 = var1;
   }
}
