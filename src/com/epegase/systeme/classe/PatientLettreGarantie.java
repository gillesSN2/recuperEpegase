package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PatientLettreGarantie implements Serializable {
   private long patlgaId;
   private Date patlgaDateCreat;
   private Date patlgaDateModif;
   private long patlgaIdCreateur;
   private String patlgaNomCreateur;
   private long patlgaIdModif;
   private String patlgaNomModif;
   private int patlgaType;
   private String patlgaNum;
   private String patlgaReference;
   private Date patlgaDate;
   private double patlgaMontant;
   private double patlgaConsomme;
   private double patlgaSolde;
   private int patlgaEtat;
   private String patlgaObjet;
   private String patlgaPhoto;
   private String patlgaCriteres;
   private String patlgaNatureActe;
   private String patlgaNomActe;
   private float patlgaTauxReduction;
   private Patients patient;
   private Tiers tiers;
   private String libelleEtat;
   private String pj;

   public String getPj() {
      if (this.patlgaPhoto != null && !this.patlgaPhoto.isEmpty()) {
         this.pj = "/images/mail_pj.png";
      } else {
         this.pj = null;
      }

      return this.pj;
   }

   public void setPj(String var1) {
      this.pj = var1;
   }

   public String getLibelleEtat() {
      if (this.patlgaEtat == 0) {
         this.libelleEtat = "EC";
      } else if (this.patlgaEtat == 1) {
         this.libelleEtat = "Val.";
      } else if (this.patlgaEtat == 2) {
         this.libelleEtat = "Ter.";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public Patients getPatient() {
      return this.patient;
   }

   public void setPatient(Patients var1) {
      this.patient = var1;
   }

   public double getPatlgaConsomme() {
      return this.patlgaConsomme;
   }

   public void setPatlgaConsomme(double var1) {
      this.patlgaConsomme = var1;
   }

   public Date getPatlgaDate() {
      return this.patlgaDate;
   }

   public void setPatlgaDate(Date var1) {
      this.patlgaDate = var1;
   }

   public int getPatlgaEtat() {
      return this.patlgaEtat;
   }

   public void setPatlgaEtat(int var1) {
      this.patlgaEtat = var1;
   }

   public long getPatlgaId() {
      return this.patlgaId;
   }

   public void setPatlgaId(long var1) {
      this.patlgaId = var1;
   }

   public double getPatlgaMontant() {
      return this.patlgaMontant;
   }

   public void setPatlgaMontant(double var1) {
      this.patlgaMontant = var1;
   }

   public String getPatlgaNum() {
      return this.patlgaNum;
   }

   public void setPatlgaNum(String var1) {
      this.patlgaNum = var1;
   }

   public String getPatlgaObjet() {
      return this.patlgaObjet;
   }

   public void setPatlgaObjet(String var1) {
      this.patlgaObjet = var1;
   }

   public String getPatlgaPhoto() {
      return this.patlgaPhoto;
   }

   public void setPatlgaPhoto(String var1) {
      this.patlgaPhoto = var1;
   }

   public double getPatlgaSolde() {
      return this.patlgaSolde;
   }

   public void setPatlgaSolde(double var1) {
      this.patlgaSolde = var1;
   }

   public Tiers getTiers() {
      return this.tiers;
   }

   public void setTiers(Tiers var1) {
      this.tiers = var1;
   }

   public Date getPatlgaDateCreat() {
      return this.patlgaDateCreat;
   }

   public void setPatlgaDateCreat(Date var1) {
      this.patlgaDateCreat = var1;
   }

   public Date getPatlgaDateModif() {
      return this.patlgaDateModif;
   }

   public void setPatlgaDateModif(Date var1) {
      this.patlgaDateModif = var1;
   }

   public long getPatlgaIdCreateur() {
      return this.patlgaIdCreateur;
   }

   public void setPatlgaIdCreateur(long var1) {
      this.patlgaIdCreateur = var1;
   }

   public long getPatlgaIdModif() {
      return this.patlgaIdModif;
   }

   public void setPatlgaIdModif(long var1) {
      this.patlgaIdModif = var1;
   }

   public String getPatlgaNomCreateur() {
      return this.patlgaNomCreateur;
   }

   public void setPatlgaNomCreateur(String var1) {
      this.patlgaNomCreateur = var1;
   }

   public String getPatlgaNomModif() {
      return this.patlgaNomModif;
   }

   public void setPatlgaNomModif(String var1) {
      this.patlgaNomModif = var1;
   }

   public String getPatlgaReference() {
      return this.patlgaReference;
   }

   public void setPatlgaReference(String var1) {
      this.patlgaReference = var1;
   }

   public int getPatlgaType() {
      return this.patlgaType;
   }

   public void setPatlgaType(int var1) {
      this.patlgaType = var1;
   }

   public String getPatlgaCriteres() {
      return this.patlgaCriteres;
   }

   public void setPatlgaCriteres(String var1) {
      this.patlgaCriteres = var1;
   }

   public String getPatlgaNomActe() {
      return this.patlgaNomActe;
   }

   public void setPatlgaNomActe(String var1) {
      this.patlgaNomActe = var1;
   }

   public float getPatlgaTauxReduction() {
      return this.patlgaTauxReduction;
   }

   public void setPatlgaTauxReduction(float var1) {
      this.patlgaTauxReduction = var1;
   }

   public String getPatlgaNatureActe() {
      return this.patlgaNatureActe;
   }

   public void setPatlgaNatureActe(String var1) {
      this.patlgaNatureActe = var1;
   }
}
