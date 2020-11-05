package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PharmacieReglement implements Serializable {
   private long pharegId;
   private String pharegService;
   private String pharegProduit;
   private String pharegLibelle;
   private double pharegPatient;
   private double pharegSociete;
   private double pharegAssurance;
   private double pharegComplementaire;
   private int pharegEtat;
   private Date pharegDate;
   private String pharegCaisse;
   private long pharegIdRecu;
   private String pharegNumRecu;
   private long pharegIdBonEncaissement;
   private String pharegNumPieceTiers;
   private PharmacieEntete pharmacieEntete;

   public double getPharegAssurance() {
      return this.pharegAssurance;
   }

   public void setPharegAssurance(double var1) {
      this.pharegAssurance = var1;
   }

   public String getPharegCaisse() {
      return this.pharegCaisse;
   }

   public void setPharegCaisse(String var1) {
      this.pharegCaisse = var1;
   }

   public double getPharegComplementaire() {
      return this.pharegComplementaire;
   }

   public void setPharegComplementaire(double var1) {
      this.pharegComplementaire = var1;
   }

   public Date getPharegDate() {
      return this.pharegDate;
   }

   public void setPharegDate(Date var1) {
      this.pharegDate = var1;
   }

   public int getPharegEtat() {
      return this.pharegEtat;
   }

   public void setPharegEtat(int var1) {
      this.pharegEtat = var1;
   }

   public long getPharegId() {
      return this.pharegId;
   }

   public void setPharegId(long var1) {
      this.pharegId = var1;
   }

   public long getPharegIdBonEncaissement() {
      return this.pharegIdBonEncaissement;
   }

   public void setPharegIdBonEncaissement(long var1) {
      this.pharegIdBonEncaissement = var1;
   }

   public long getPharegIdRecu() {
      return this.pharegIdRecu;
   }

   public void setPharegIdRecu(long var1) {
      this.pharegIdRecu = var1;
   }

   public String getPharegLibelle() {
      return this.pharegLibelle;
   }

   public void setPharegLibelle(String var1) {
      this.pharegLibelle = var1;
   }

   public String getPharegNumRecu() {
      return this.pharegNumRecu;
   }

   public void setPharegNumRecu(String var1) {
      this.pharegNumRecu = var1;
   }

   public double getPharegPatient() {
      return this.pharegPatient;
   }

   public void setPharegPatient(double var1) {
      this.pharegPatient = var1;
   }

   public String getPharegProduit() {
      return this.pharegProduit;
   }

   public void setPharegProduit(String var1) {
      this.pharegProduit = var1;
   }

   public String getPharegService() {
      return this.pharegService;
   }

   public void setPharegService(String var1) {
      this.pharegService = var1;
   }

   public double getPharegSociete() {
      return this.pharegSociete;
   }

   public void setPharegSociete(double var1) {
      this.pharegSociete = var1;
   }

   public PharmacieEntete getPharmacieEntete() {
      return this.pharmacieEntete;
   }

   public void setPharmacieEntete(PharmacieEntete var1) {
      this.pharmacieEntete = var1;
   }

   public String getPharegNumPieceTiers() {
      return this.pharegNumPieceTiers;
   }

   public void setPharegNumPieceTiers(String var1) {
      this.pharegNumPieceTiers = var1;
   }
}
