package com.epegase.systeme.xml;

import java.io.Serializable;

public class ObjetConvention implements Serializable {
   private Integer indice;
   private String code;
   private String lib_FR;
   private String lib_UK;
   private String lib_SP;
   private float heure_mois;
   private float heure_semaine;
   private String date_maj;
   private float at;
   private float tranche1;
   private float tranche2;
   private float tranche3;
   private float tranche4;
   private float tranche5;
   private String inactif;
   private boolean valide = false;

   public String getCode() {
      return this.code;
   }

   public void setCode(String var1) {
      this.code = var1;
   }

   public Integer getIndice() {
      return this.indice;
   }

   public void setIndice(Integer var1) {
      this.indice = var1;
   }

   public String getDate_maj() {
      return this.date_maj;
   }

   public void setDate_maj(String var1) {
      this.date_maj = var1;
   }

   public String getInactif() {
      return this.inactif;
   }

   public void setInactif(String var1) {
      this.inactif = var1;
   }

   public String getLib_FR() {
      return this.lib_FR;
   }

   public void setLib_FR(String var1) {
      this.lib_FR = var1;
   }

   public String getLib_SP() {
      return this.lib_SP;
   }

   public void setLib_SP(String var1) {
      this.lib_SP = var1;
   }

   public String getLib_UK() {
      return this.lib_UK;
   }

   public void setLib_UK(String var1) {
      this.lib_UK = var1;
   }

   public float getHeure_mois() {
      return this.heure_mois;
   }

   public void setHeure_mois(float var1) {
      this.heure_mois = var1;
   }

   public float getHeure_semaine() {
      return this.heure_semaine;
   }

   public void setHeure_semaine(float var1) {
      this.heure_semaine = var1;
   }

   public float getTranche1() {
      return this.tranche1;
   }

   public void setTranche1(float var1) {
      this.tranche1 = var1;
   }

   public float getTranche2() {
      return this.tranche2;
   }

   public void setTranche2(float var1) {
      this.tranche2 = var1;
   }

   public float getTranche3() {
      return this.tranche3;
   }

   public void setTranche3(float var1) {
      this.tranche3 = var1;
   }

   public float getTranche4() {
      return this.tranche4;
   }

   public void setTranche4(float var1) {
      this.tranche4 = var1;
   }

   public float getTranche5() {
      return this.tranche5;
   }

   public void setTranche5(float var1) {
      this.tranche5 = var1;
   }

   public boolean isValide() {
      return this.valide;
   }

   public void setValide(boolean var1) {
      this.valide = var1;
   }

   public float getAt() {
      return this.at;
   }

   public void setAt(float var1) {
      this.at = var1;
   }
}
