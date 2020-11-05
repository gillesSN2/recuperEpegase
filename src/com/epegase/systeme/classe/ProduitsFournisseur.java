package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProduitsFournisseur implements Serializable {
   private String etat;
   private boolean inactif;
   private long profouId;
   private String profouRef;
   private String profouLib;
   private double profouPa;
   private String profouDevise;
   private float profouTauxDevise;
   private int profouFormat;
   private float profouCoefEuro;
   private float profouCoefLocal;
   private double profouPaLocal;
   private double profouPaEuro;
   private Date profouDate;
   private String profouCondition1;
   private String profouCondition2;
   private String profouCondition3;
   private String profouCondition4;
   private String profouCondition5;
   private int profouInactif;
   private Produits produits;
   private Tiers tiers;
   private float qteTotaleStock;

   public String getEtat() {
      if (this.profouInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.profouInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public boolean isInactif() {
      if (this.profouInactif != 1 && this.profouInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public Date getProfouDate() {
      return this.profouDate;
   }

   public void setProfouDate(Date var1) {
      this.profouDate = var1;
   }

   public String getProfouDevise() {
      return this.profouDevise;
   }

   public void setProfouDevise(String var1) {
      this.profouDevise = var1;
   }

   public int getProfouFormat() {
      return this.profouFormat;
   }

   public void setProfouFormat(int var1) {
      this.profouFormat = var1;
   }

   public long getProfouId() {
      return this.profouId;
   }

   public void setProfouId(long var1) {
      this.profouId = var1;
   }

   public int getProfouInactif() {
      return this.profouInactif;
   }

   public void setProfouInactif(int var1) {
      this.profouInactif = var1;
   }

   public String getProfouLib() {
      return this.profouLib;
   }

   public void setProfouLib(String var1) {
      this.profouLib = var1;
   }

   public double getProfouPa() {
      return this.profouPa;
   }

   public void setProfouPa(double var1) {
      this.profouPa = var1;
   }

   public double getProfouPaLocal() {
      return this.profouPaLocal;
   }

   public void setProfouPaLocal(double var1) {
      this.profouPaLocal = var1;
   }

   public String getProfouRef() {
      return this.profouRef;
   }

   public void setProfouRef(String var1) {
      this.profouRef = var1;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getProfouCondition1() {
      return this.profouCondition1;
   }

   public void setProfouCondition1(String var1) {
      this.profouCondition1 = var1;
   }

   public String getProfouCondition2() {
      return this.profouCondition2;
   }

   public void setProfouCondition2(String var1) {
      this.profouCondition2 = var1;
   }

   public String getProfouCondition3() {
      return this.profouCondition3;
   }

   public void setProfouCondition3(String var1) {
      this.profouCondition3 = var1;
   }

   public String getProfouCondition4() {
      return this.profouCondition4;
   }

   public void setProfouCondition4(String var1) {
      this.profouCondition4 = var1;
   }

   public String getProfouCondition5() {
      return this.profouCondition5;
   }

   public void setProfouCondition5(String var1) {
      this.profouCondition5 = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public float getProfouCoefEuro() {
      return this.profouCoefEuro;
   }

   public void setProfouCoefEuro(float var1) {
      this.profouCoefEuro = var1;
   }

   public float getProfouCoefLocal() {
      return this.profouCoefLocal;
   }

   public void setProfouCoefLocal(float var1) {
      this.profouCoefLocal = var1;
   }

   public double getProfouPaEuro() {
      return this.profouPaEuro;
   }

   public void setProfouPaEuro(double var1) {
      this.profouPaEuro = var1;
   }

   public float getProfouTauxDevise() {
      return this.profouTauxDevise;
   }

   public void setProfouTauxDevise(float var1) {
      this.profouTauxDevise = var1;
   }

   public float getQteTotaleStock() {
      return this.qteTotaleStock;
   }

   public void setQteTotaleStock(float var1) {
      this.qteTotaleStock = var1;
   }
}
