package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProduitsDepot implements Serializable {
   private long prodepId;
   private String prodepUnite;
   private int prodepEchelle;
   private float prodepQteMini;
   private float prodepQteMaxi;
   private float prodepQteConso;
   private double prodepPa;
   private double prodepPr;
   private double prodepPrKg;
   private float prodepCoefPr;
   private double prodepPump;
   private Date prodepDateInv;
   private Date prodepDateEntree;
   private Date prodepDateSortie;
   private Date prodepDateProd;
   private float prodepQteCmdAch;
   private float prodepQteCmdVte;
   private float prodepQteAttAch;
   private float prodepQteAttVte;
   private float prodepQteStk;
   private float prodepQteInv;
   private String prodepLocalisation;
   private String prodepCasier;
   private String prodepGroupe;
   private String prodepCle;
   private String prodepCle2;
   private int prodepInactif;
   private DepotAchats depot;
   private Produits produits;
   private Unite unite;
   private String etat;
   private boolean inactif;
   private float qteConditionne;

   public float getQteConditionne() {
      this.qteConditionne = 0.0F;
      if (this.produits.getProCondition5() != null && !this.produits.getProCondition5().isEmpty()) {
         String[] var1 = this.produits.getProCondition5().split("/");
         String[] var2 = var1[1].split(":");
         float var3 = Float.parseFloat(var2[0]);
         double var4 = 0.0D;
         int var6 = 0;
         int var7 = 0;
         int var8 = 0;
         if (var3 != 0.0F) {
            var4 = (double)(this.prodepQteStk / var3);
            var6 = (int)(this.prodepQteStk / var3);
            var7 = (int)((double)var6 * var4 - (double)this.prodepQteStk);
            var8 = (int)((float)((int)this.prodepQteStk) - (float)var6 * var3);
         } else if (this.produits.getProNbUnite() != 0.0F) {
            var4 = (double)(this.prodepQteStk / this.produits.getProNbUnite());
            var6 = (int)(this.prodepQteStk / this.produits.getProNbUnite());
            var7 = (int)((double)var6 * var4 - (double)this.prodepQteStk);
            var8 = (int)((float)((int)this.prodepQteStk) - (float)var6 * this.produits.getProNbUnite());
         }

         if (var7 != 0) {
            if (var8 < 0) {
               this.qteConditionne = Float.parseFloat(var6 + "." + Math.abs(var8)) * -1.0F;
            } else {
               this.qteConditionne = Float.parseFloat(var6 + "." + var8);
            }
         } else {
            this.qteConditionne = (float)var6;
         }
      }

      return this.qteConditionne;
   }

   public void setQteConditionne(float var1) {
      this.qteConditionne = var1;
   }

   public String getEtat() {
      if (this.prodepInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.prodepInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.prodepInactif != 1 && this.prodepInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public DepotAchats getDepot() {
      return this.depot;
   }

   public void setDepot(DepotAchats var1) {
      this.depot = var1;
   }

   public String getProdepCle() {
      return this.prodepCle;
   }

   public void setProdepCle(String var1) {
      this.prodepCle = var1;
   }

   public String getProdepLocalisation() {
      return this.prodepLocalisation;
   }

   public void setProdepLocalisation(String var1) {
      this.prodepLocalisation = var1;
   }

   public Date getProdepDateEntree() {
      return this.prodepDateEntree;
   }

   public void setProdepDateEntree(Date var1) {
      this.prodepDateEntree = var1;
   }

   public Date getProdepDateInv() {
      return this.prodepDateInv;
   }

   public void setProdepDateInv(Date var1) {
      this.prodepDateInv = var1;
   }

   public Date getProdepDateSortie() {
      return this.prodepDateSortie;
   }

   public void setProdepDateSortie(Date var1) {
      this.prodepDateSortie = var1;
   }

   public Date getProdepDateProd() {
      return this.prodepDateProd;
   }

   public void setProdepDateProd(Date var1) {
      this.prodepDateProd = var1;
   }

   public long getProdepId() {
      return this.prodepId;
   }

   public void setProdepId(long var1) {
      this.prodepId = var1;
   }

   public double getProdepPr() {
      return this.prodepPr;
   }

   public void setProdepPr(double var1) {
      this.prodepPr = var1;
   }

   public double getProdepPump() {
      return this.prodepPump;
   }

   public void setProdepPump(double var1) {
      this.prodepPump = var1;
   }

   public float getProdepQteCmdVte() {
      return this.prodepQteCmdVte;
   }

   public void setProdepQteCmdVte(float var1) {
      this.prodepQteCmdVte = var1;
   }

   public float getProdepQteConso() {
      return this.prodepQteConso;
   }

   public void setProdepQteConso(float var1) {
      this.prodepQteConso = var1;
   }

   public float getProdepQteMaxi() {
      return this.prodepQteMaxi;
   }

   public void setProdepQteMaxi(float var1) {
      this.prodepQteMaxi = var1;
   }

   public float getProdepQteMini() {
      return this.prodepQteMini;
   }

   public void setProdepQteMini(float var1) {
      this.prodepQteMini = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public float getProdepQteCmdAch() {
      return this.prodepQteCmdAch;
   }

   public void setProdepQteCmdAch(float var1) {
      this.prodepQteCmdAch = var1;
   }

   public float getProdepQteStk() {
      return this.prodepQteStk;
   }

   public void setProdepQteStk(float var1) {
      this.prodepQteStk = var1;
   }

   public String getProdepCasier() {
      return this.prodepCasier;
   }

   public void setProdepCasier(String var1) {
      this.prodepCasier = var1;
   }

   public int getProdepInactif() {
      return this.prodepInactif;
   }

   public void setProdepInactif(int var1) {
      this.prodepInactif = var1;
   }

   public float getProdepCoefPr() {
      return this.prodepCoefPr;
   }

   public void setProdepCoefPr(float var1) {
      this.prodepCoefPr = var1;
   }

   public float getProdepQteAttAch() {
      return this.prodepQteAttAch;
   }

   public void setProdepQteAttAch(float var1) {
      this.prodepQteAttAch = var1;
   }

   public float getProdepQteAttVte() {
      return this.prodepQteAttVte;
   }

   public void setProdepQteAttVte(float var1) {
      this.prodepQteAttVte = var1;
   }

   public String getProdepCle2() {
      return this.prodepCle2;
   }

   public void setProdepCle2(String var1) {
      this.prodepCle2 = var1;
   }

   public String getProdepGroupe() {
      return this.prodepGroupe;
   }

   public void setProdepGroupe(String var1) {
      this.prodepGroupe = var1;
   }

   public double getProdepPa() {
      return this.prodepPa;
   }

   public void setProdepPa(double var1) {
      this.prodepPa = var1;
   }

   public String getProdepUnite() {
      return this.prodepUnite;
   }

   public void setProdepUnite(String var1) {
      this.prodepUnite = var1;
   }

   public int getProdepEchelle() {
      return this.prodepEchelle;
   }

   public void setProdepEchelle(int var1) {
      this.prodepEchelle = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public float getProdepQteInv() {
      return this.prodepQteInv;
   }

   public void setProdepQteInv(float var1) {
      this.prodepQteInv = var1;
   }

   public double getProdepPrKg() {
      return this.prodepPrKg;
   }

   public void setProdepPrKg(double var1) {
      this.prodepPrKg = var1;
   }
}
