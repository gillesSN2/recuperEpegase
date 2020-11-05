package com.epegase.systeme.control;

import java.io.Serializable;

public class ObjetTarif implements Serializable {
   private float qteDebut;
   private float qteFin;
   private double prix;
   private long idSejour;
   private double dejaPaye;
   private String nomService;
   private long idLaboratoire;
   private String nomLaboratoire;
   private String codeProduit;
   private float qteProduit;
   private String nomProduit;
   private String nomLibelle;
   private double totalService;
   private double solde;
   private int type;
   private boolean saisieInterdit;
   private long idCaution;
   private long idProduit;

   public long getIdCaution() {
      return this.idCaution;
   }

   public void setIdCaution(long var1) {
      this.idCaution = var1;
   }

   public double getPrix() {
      return this.prix;
   }

   public void setPrix(double var1) {
      this.prix = var1;
   }

   public float getQteDebut() {
      return this.qteDebut;
   }

   public void setQteDebut(float var1) {
      this.qteDebut = var1;
   }

   public float getQteFin() {
      return this.qteFin;
   }

   public void setQteFin(float var1) {
      this.qteFin = var1;
   }

   public String getNomService() {
      return this.nomService;
   }

   public void setNomService(String var1) {
      this.nomService = var1;
   }

   public double getTotalService() {
      return this.totalService;
   }

   public void setTotalService(double var1) {
      this.totalService = var1;
   }

   public double getSolde() {
      return this.solde;
   }

   public void setSolde(double var1) {
      this.solde = var1;
   }

   public double getDejaPaye() {
      return this.dejaPaye;
   }

   public void setDejaPaye(double var1) {
      this.dejaPaye = var1;
   }

   public long getIdSejour() {
      return this.idSejour;
   }

   public void setIdSejour(long var1) {
      this.idSejour = var1;
   }

   public String getNomLaboratoire() {
      return this.nomLaboratoire;
   }

   public void setNomLaboratoire(String var1) {
      this.nomLaboratoire = var1;
   }

   public String getNomProduit() {
      return this.nomProduit;
   }

   public void setNomProduit(String var1) {
      this.nomProduit = var1;
   }

   public String getNomLibelle() {
      return this.nomLibelle;
   }

   public void setNomLibelle(String var1) {
      this.nomLibelle = var1;
   }

   public long getIdLaboratoire() {
      return this.idLaboratoire;
   }

   public void setIdLaboratoire(long var1) {
      this.idLaboratoire = var1;
   }

   public int getType() {
      return this.type;
   }

   public void setType(int var1) {
      this.type = var1;
   }

   public boolean isSaisieInterdit() {
      return this.saisieInterdit;
   }

   public void setSaisieInterdit(boolean var1) {
      this.saisieInterdit = var1;
   }

   public String getCodeProduit() {
      return this.codeProduit;
   }

   public void setCodeProduit(String var1) {
      this.codeProduit = var1;
   }

   public float getQteProduit() {
      return this.qteProduit;
   }

   public void setQteProduit(float var1) {
      this.qteProduit = var1;
   }

   public long getIdProduit() {
      return this.idProduit;
   }

   public void setIdProduit(long var1) {
      this.idProduit = var1;
   }
}
