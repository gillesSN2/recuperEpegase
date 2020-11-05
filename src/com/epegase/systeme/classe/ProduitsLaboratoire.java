package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProduitsLaboratoire implements Serializable {
   private long prolabId;
   private String prolabLibelleFr;
   private String prolabLibelleUk;
   private String prolabLibelleSp;
   private int prolabType;
   private String prolabUnite;
   private float prolabCoef;
   private String prolabUniteConv;
   private int prolabOrdre;
   private String prolabTechnique;
   private String prolabNorme;
   private String prolabInterpretation;
   private String prolabInterpretaionTexte;
   private int prolabAnonyme;
   private int prolabEtiquette;
   private int prolabConclusion;
   private String prolabConclusionDef;
   private String prolabCategorie;
   private String prolabFourchette;
   private double prolabFourchetteMin;
   private double prolabFourchetteMax;
   private Produits produits;

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }

   public int getProlabAnonyme() {
      return this.prolabAnonyme;
   }

   public void setProlabAnonyme(int var1) {
      this.prolabAnonyme = var1;
   }

   public float getProlabCoef() {
      return this.prolabCoef;
   }

   public void setProlabCoef(float var1) {
      this.prolabCoef = var1;
   }

   public int getProlabConclusion() {
      return this.prolabConclusion;
   }

   public void setProlabConclusion(int var1) {
      this.prolabConclusion = var1;
   }

   public int getProlabEtiquette() {
      return this.prolabEtiquette;
   }

   public void setProlabEtiquette(int var1) {
      this.prolabEtiquette = var1;
   }

   public long getProlabId() {
      return this.prolabId;
   }

   public void setProlabId(long var1) {
      this.prolabId = var1;
   }

   public String getProlabLibelleFr() {
      return this.prolabLibelleFr;
   }

   public void setProlabLibelleFr(String var1) {
      this.prolabLibelleFr = var1;
   }

   public String getProlabLibelleSp() {
      return this.prolabLibelleSp;
   }

   public void setProlabLibelleSp(String var1) {
      this.prolabLibelleSp = var1;
   }

   public String getProlabLibelleUk() {
      return this.prolabLibelleUk;
   }

   public void setProlabLibelleUk(String var1) {
      this.prolabLibelleUk = var1;
   }

   public int getProlabOrdre() {
      return this.prolabOrdre;
   }

   public void setProlabOrdre(int var1) {
      this.prolabOrdre = var1;
   }

   public String getProlabTechnique() {
      return this.prolabTechnique;
   }

   public void setProlabTechnique(String var1) {
      this.prolabTechnique = var1;
   }

   public int getProlabType() {
      return this.prolabType;
   }

   public void setProlabType(int var1) {
      this.prolabType = var1;
   }

   public String getProlabUnite() {
      return this.prolabUnite;
   }

   public void setProlabUnite(String var1) {
      this.prolabUnite = var1;
   }

   public String getProlabUniteConv() {
      return this.prolabUniteConv;
   }

   public void setProlabUniteConv(String var1) {
      this.prolabUniteConv = var1;
   }

   public String getProlabNorme() {
      return this.prolabNorme;
   }

   public void setProlabNorme(String var1) {
      this.prolabNorme = var1;
   }

   public String getProlabConclusionDef() {
      return this.prolabConclusionDef;
   }

   public void setProlabConclusionDef(String var1) {
      this.prolabConclusionDef = var1;
   }

   public String getProlabCategorie() {
      return this.prolabCategorie;
   }

   public void setProlabCategorie(String var1) {
      this.prolabCategorie = var1;
   }

   public String getProlabFourchette() {
      return this.prolabFourchette;
   }

   public void setProlabFourchette(String var1) {
      this.prolabFourchette = var1;
   }

   public double getProlabFourchetteMax() {
      return this.prolabFourchetteMax;
   }

   public void setProlabFourchetteMax(double var1) {
      this.prolabFourchetteMax = var1;
   }

   public double getProlabFourchetteMin() {
      return this.prolabFourchetteMin;
   }

   public void setProlabFourchetteMin(double var1) {
      this.prolabFourchetteMin = var1;
   }

   public String getProlabInterpretation() {
      return this.prolabInterpretation;
   }

   public void setProlabInterpretation(String var1) {
      this.prolabInterpretation = var1;
   }

   public String getProlabInterpretaionTexte() {
      return this.prolabInterpretaionTexte;
   }

   public void setProlabInterpretaionTexte(String var1) {
      this.prolabInterpretaionTexte = var1;
   }
}
