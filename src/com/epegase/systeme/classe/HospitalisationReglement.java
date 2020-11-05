package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class HospitalisationReglement implements Serializable {
   private long hosregId;
   private String hosregService;
   private String hosregLaboratoire;
   private long hosregIdSejour;
   private long hosregIdLaboratoire;
   private double hosregPatient;
   private double hosregSociete;
   private double hosregAssurance;
   private double hosregComplementaire;
   private int hosregEtat;
   private Date hosregDate;
   private String hosregCaisse;
   private long hosregIdCaution;
   private long hosregIdRecu;
   private String hosregNumRecu;
   private long hosregIdBonEncaissement;
   private String hosregNumPieceTiers;
   private String hosregProduit;
   private HospitalisationEntete hospitalisationEntete;

   public HospitalisationEntete getHospitalisationEntete() {
      return this.hospitalisationEntete;
   }

   public void setHospitalisationEntete(HospitalisationEntete var1) {
      this.hospitalisationEntete = var1;
   }

   public double getHosregAssurance() {
      return this.hosregAssurance;
   }

   public void setHosregAssurance(double var1) {
      this.hosregAssurance = var1;
   }

   public String getHosregCaisse() {
      return this.hosregCaisse;
   }

   public void setHosregCaisse(String var1) {
      this.hosregCaisse = var1;
   }

   public double getHosregComplementaire() {
      return this.hosregComplementaire;
   }

   public void setHosregComplementaire(double var1) {
      this.hosregComplementaire = var1;
   }

   public Date getHosregDate() {
      return this.hosregDate;
   }

   public void setHosregDate(Date var1) {
      this.hosregDate = var1;
   }

   public long getHosregId() {
      return this.hosregId;
   }

   public void setHosregId(long var1) {
      this.hosregId = var1;
   }

   public long getHosregIdLaboratoire() {
      return this.hosregIdLaboratoire;
   }

   public void setHosregIdLaboratoire(long var1) {
      this.hosregIdLaboratoire = var1;
   }

   public long getHosregIdRecu() {
      return this.hosregIdRecu;
   }

   public void setHosregIdRecu(long var1) {
      this.hosregIdRecu = var1;
   }

   public String getHosregLaboratoire() {
      return this.hosregLaboratoire;
   }

   public void setHosregLaboratoire(String var1) {
      this.hosregLaboratoire = var1;
   }

   public double getHosregPatient() {
      return this.hosregPatient;
   }

   public void setHosregPatient(double var1) {
      this.hosregPatient = var1;
   }

   public String getHosregService() {
      return this.hosregService;
   }

   public void setHosregService(String var1) {
      this.hosregService = var1;
   }

   public double getHosregSociete() {
      return this.hosregSociete;
   }

   public void setHosregSociete(double var1) {
      this.hosregSociete = var1;
   }

   public int getHosregEtat() {
      return this.hosregEtat;
   }

   public void setHosregEtat(int var1) {
      this.hosregEtat = var1;
   }

   public long getHosregIdBonEncaissement() {
      return this.hosregIdBonEncaissement;
   }

   public void setHosregIdBonEncaissement(long var1) {
      this.hosregIdBonEncaissement = var1;
   }

   public String getHosregNumRecu() {
      return this.hosregNumRecu;
   }

   public void setHosregNumRecu(String var1) {
      this.hosregNumRecu = var1;
   }

   public String getHosregNumPieceTiers() {
      return this.hosregNumPieceTiers;
   }

   public void setHosregNumPieceTiers(String var1) {
      this.hosregNumPieceTiers = var1;
   }

   public long getHosregIdSejour() {
      return this.hosregIdSejour;
   }

   public void setHosregIdSejour(long var1) {
      this.hosregIdSejour = var1;
   }

   public long getHosregIdCaution() {
      return this.hosregIdCaution;
   }

   public void setHosregIdCaution(long var1) {
      this.hosregIdCaution = var1;
   }

   public String getHosregProduit() {
      return this.hosregProduit;
   }

   public void setHosregProduit(String var1) {
      this.hosregProduit = var1;
   }
}
