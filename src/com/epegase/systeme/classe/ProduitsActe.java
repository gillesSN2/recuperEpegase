package com.epegase.systeme.classe;

import java.io.Serializable;

public class ProduitsActe implements Serializable {
   private long proactId;
   private String proactHierarchie;
   private String proactRang;
   private String proactPosition;
   private String proactY;
   private String proactIcr;
   private String proactPara;
   private String proactA;
   private String proactB;
   private String proactCc;
   private String proactScore;
   private String proactObservations;
   private Produits produits;

   public String getProactA() {
      return this.proactA;
   }

   public void setProactA(String var1) {
      this.proactA = var1;
   }

   public String getProactB() {
      return this.proactB;
   }

   public void setProactB(String var1) {
      this.proactB = var1;
   }

   public String getProactPosition() {
      return this.proactPosition;
   }

   public void setProactPosition(String var1) {
      this.proactPosition = var1;
   }

   public String getProactCc() {
      return this.proactCc;
   }

   public void setProactCc(String var1) {
      this.proactCc = var1;
   }

   public String getProactHierarchie() {
      return this.proactHierarchie;
   }

   public void setProactHierarchie(String var1) {
      this.proactHierarchie = var1;
   }

   public String getProactIcr() {
      return this.proactIcr;
   }

   public void setProactIcr(String var1) {
      this.proactIcr = var1;
   }

   public long getProactId() {
      return this.proactId;
   }

   public void setProactId(long var1) {
      this.proactId = var1;
   }

   public String getProactObservations() {
      return this.proactObservations;
   }

   public void setProactObservations(String var1) {
      this.proactObservations = var1;
   }

   public String getProactPara() {
      return this.proactPara;
   }

   public void setProactPara(String var1) {
      this.proactPara = var1;
   }

   public String getProactRang() {
      return this.proactRang;
   }

   public void setProactRang(String var1) {
      this.proactRang = var1;
   }

   public String getProactScore() {
      return this.proactScore;
   }

   public void setProactScore(String var1) {
      this.proactScore = var1;
   }

   public String getProactY() {
      return this.proactY;
   }

   public void setProactY(String var1) {
      this.proactY = var1;
   }

   public Produits getProduits() {
      return this.produits;
   }

   public void setProduits(Produits var1) {
      this.produits = var1;
   }
}
