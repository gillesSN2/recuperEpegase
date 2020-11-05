package com.epegase.systeme.control;

import java.io.Serializable;
import java.util.Date;

public class ObjetIsr implements Serializable {
   private String matricule = "";
   private String patronyme = "";
   private String convention = "";
   private double baseBrute = 0.0D;
   private double moyBrute = 0.0D;
   private Date dateEntree;
   private int nbAnee = 0;
   private int nbMois = 0;
   private double valIsr = 0.0D;
   private float tauxT1 = 0.0F;
   private int nbAnneeT1 = 0;
   private double valT1 = 0.0D;
   private float tauxT2 = 0.0F;
   private int nbAnneeT2 = 0;
   private double valT2 = 0.0D;
   private float tauxT3 = 0.0F;
   private int nbAnneeT3 = 0;
   private double valT3 = 0.0D;
   private float tauxT4 = 0.0F;
   private int nbAnneeT4 = 0;
   private double valT4 = 0.0D;
   private float tauxT5 = 0.0F;
   private int nbAnneeT5 = 0;
   private double valT5 = 0.0D;
   private float tauxT6 = 0.0F;
   private int nbMoisT6 = 0;
   private double valT6 = 0.0D;

   public double getBaseBrute() {
      return this.baseBrute;
   }

   public void setBaseBrute(double var1) {
      this.baseBrute = var1;
   }

   public String getConvention() {
      return this.convention;
   }

   public void setConvention(String var1) {
      this.convention = var1;
   }

   public Date getDateEntree() {
      return this.dateEntree;
   }

   public void setDateEntree(Date var1) {
      this.dateEntree = var1;
   }

   public String getMatricule() {
      return this.matricule;
   }

   public void setMatricule(String var1) {
      this.matricule = var1;
   }

   public double getMoyBrute() {
      return this.moyBrute;
   }

   public void setMoyBrute(double var1) {
      this.moyBrute = var1;
   }

   public int getNbAnee() {
      return this.nbAnee;
   }

   public void setNbAnee(int var1) {
      this.nbAnee = var1;
   }

   public int getNbAnneeT1() {
      return this.nbAnneeT1;
   }

   public void setNbAnneeT1(int var1) {
      this.nbAnneeT1 = var1;
   }

   public int getNbAnneeT2() {
      return this.nbAnneeT2;
   }

   public void setNbAnneeT2(int var1) {
      this.nbAnneeT2 = var1;
   }

   public int getNbAnneeT3() {
      return this.nbAnneeT3;
   }

   public void setNbAnneeT3(int var1) {
      this.nbAnneeT3 = var1;
   }

   public int getNbAnneeT4() {
      return this.nbAnneeT4;
   }

   public void setNbAnneeT4(int var1) {
      this.nbAnneeT4 = var1;
   }

   public int getNbAnneeT5() {
      return this.nbAnneeT5;
   }

   public void setNbAnneeT5(int var1) {
      this.nbAnneeT5 = var1;
   }

   public int getNbMoisT6() {
      return this.nbMoisT6;
   }

   public void setNbMoisT6(int var1) {
      this.nbMoisT6 = var1;
   }

   public int getNbMois() {
      return this.nbMois;
   }

   public void setNbMois(int var1) {
      this.nbMois = var1;
   }

   public String getPatronyme() {
      return this.patronyme;
   }

   public void setPatronyme(String var1) {
      this.patronyme = var1;
   }

   public float getTauxT1() {
      return this.tauxT1;
   }

   public void setTauxT1(float var1) {
      this.tauxT1 = var1;
   }

   public float getTauxT2() {
      return this.tauxT2;
   }

   public void setTauxT2(float var1) {
      this.tauxT2 = var1;
   }

   public float getTauxT3() {
      return this.tauxT3;
   }

   public void setTauxT3(float var1) {
      this.tauxT3 = var1;
   }

   public float getTauxT4() {
      return this.tauxT4;
   }

   public void setTauxT4(float var1) {
      this.tauxT4 = var1;
   }

   public float getTauxT5() {
      return this.tauxT5;
   }

   public void setTauxT5(float var1) {
      this.tauxT5 = var1;
   }

   public float getTauxT6() {
      return this.tauxT6;
   }

   public void setTauxT6(float var1) {
      this.tauxT6 = var1;
   }

   public double getValIsr() {
      return this.valIsr;
   }

   public void setValIsr(double var1) {
      this.valIsr = var1;
   }

   public double getValT1() {
      return this.valT1;
   }

   public void setValT1(double var1) {
      this.valT1 = var1;
   }

   public double getValT2() {
      return this.valT2;
   }

   public void setValT2(double var1) {
      this.valT2 = var1;
   }

   public double getValT3() {
      return this.valT3;
   }

   public void setValT3(double var1) {
      this.valT3 = var1;
   }

   public double getValT4() {
      return this.valT4;
   }

   public void setValT4(double var1) {
      this.valT4 = var1;
   }

   public double getValT5() {
      return this.valT5;
   }

   public void setValT5(double var1) {
      this.valT5 = var1;
   }

   public double getValT6() {
      return this.valT6;
   }

   public void setValT6(double var1) {
      this.valT6 = var1;
   }
}
