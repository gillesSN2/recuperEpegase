package com.epegase.systeme.classe;

import java.io.Serializable;

public class SalariesMissions implements Serializable {
   private long salmisId;
   private String salmisDevise;
   private double salmisVisa;
   private double salmisTitreTransport;
   private int salmisTypeTransport;
   private double salmisDeplacement1;
   private double salmisDeplacement2;
   private boolean salmisResaHotel;
   private String salmisNomHotel;
   private String salmisMailHotel;
   private String salmisTelHotel;
   private String salmisChambreHotel;
   private String salmisObs;
   private double salmisPerdiemTheo;
   private double salmisPerdiemReel;
   private double salmisRestauration;
   private double salmisHebergement;
   private double salmisAutresFrais;
   private double salmisAcompte;
   private String salmisAccompagnant;
   private Missions missions;
   private Salaries salaries;
   private String libTransport;

   public String getLibTransport() {
      if (this.salmisTypeTransport == 0) {
         this.libTransport = "Route";
      } else if (this.salmisTypeTransport == 1) {
         this.libTransport = "Train";
      } else if (this.salmisTypeTransport == 2) {
         this.libTransport = "Avion";
      } else if (this.salmisTypeTransport == 3) {
         this.libTransport = "Bateau";
      }

      return this.libTransport;
   }

   public void setLibTransport(String var1) {
      this.libTransport = var1;
   }

   public Missions getMissions() {
      return this.missions;
   }

   public void setMissions(Missions var1) {
      this.missions = var1;
   }

   public Salaries getSalaries() {
      return this.salaries;
   }

   public void setSalaries(Salaries var1) {
      this.salaries = var1;
   }

   public double getSalmisAcompte() {
      return this.salmisAcompte;
   }

   public void setSalmisAcompte(double var1) {
      this.salmisAcompte = var1;
   }

   public double getSalmisAutresFrais() {
      return this.salmisAutresFrais;
   }

   public void setSalmisAutresFrais(double var1) {
      this.salmisAutresFrais = var1;
   }

   public String getSalmisChambreHotel() {
      return this.salmisChambreHotel;
   }

   public void setSalmisChambreHotel(String var1) {
      this.salmisChambreHotel = var1;
   }

   public double getSalmisDeplacement1() {
      return this.salmisDeplacement1;
   }

   public void setSalmisDeplacement1(double var1) {
      this.salmisDeplacement1 = var1;
   }

   public double getSalmisDeplacement2() {
      return this.salmisDeplacement2;
   }

   public void setSalmisDeplacement2(double var1) {
      this.salmisDeplacement2 = var1;
   }

   public String getSalmisDevise() {
      return this.salmisDevise;
   }

   public void setSalmisDevise(String var1) {
      this.salmisDevise = var1;
   }

   public double getSalmisHebergement() {
      return this.salmisHebergement;
   }

   public void setSalmisHebergement(double var1) {
      this.salmisHebergement = var1;
   }

   public long getSalmisId() {
      return this.salmisId;
   }

   public void setSalmisId(long var1) {
      this.salmisId = var1;
   }

   public String getSalmisMailHotel() {
      return this.salmisMailHotel;
   }

   public void setSalmisMailHotel(String var1) {
      this.salmisMailHotel = var1;
   }

   public String getSalmisNomHotel() {
      return this.salmisNomHotel;
   }

   public void setSalmisNomHotel(String var1) {
      this.salmisNomHotel = var1;
   }

   public String getSalmisObs() {
      return this.salmisObs;
   }

   public void setSalmisObs(String var1) {
      this.salmisObs = var1;
   }

   public double getSalmisPerdiemReel() {
      return this.salmisPerdiemReel;
   }

   public void setSalmisPerdiemReel(double var1) {
      this.salmisPerdiemReel = var1;
   }

   public double getSalmisPerdiemTheo() {
      return this.salmisPerdiemTheo;
   }

   public void setSalmisPerdiemTheo(double var1) {
      this.salmisPerdiemTheo = var1;
   }

   public boolean isSalmisResaHotel() {
      return this.salmisResaHotel;
   }

   public void setSalmisResaHotel(boolean var1) {
      this.salmisResaHotel = var1;
   }

   public double getSalmisRestauration() {
      return this.salmisRestauration;
   }

   public void setSalmisRestauration(double var1) {
      this.salmisRestauration = var1;
   }

   public String getSalmisTelHotel() {
      return this.salmisTelHotel;
   }

   public void setSalmisTelHotel(String var1) {
      this.salmisTelHotel = var1;
   }

   public double getSalmisTitreTransport() {
      return this.salmisTitreTransport;
   }

   public void setSalmisTitreTransport(double var1) {
      this.salmisTitreTransport = var1;
   }

   public int getSalmisTypeTransport() {
      return this.salmisTypeTransport;
   }

   public void setSalmisTypeTransport(int var1) {
      this.salmisTypeTransport = var1;
   }

   public double getSalmisVisa() {
      return this.salmisVisa;
   }

   public void setSalmisVisa(double var1) {
      this.salmisVisa = var1;
   }

   public String getSalmisAccompagnant() {
      return this.salmisAccompagnant;
   }

   public void setSalmisAccompagnant(String var1) {
      this.salmisAccompagnant = var1;
   }
}
