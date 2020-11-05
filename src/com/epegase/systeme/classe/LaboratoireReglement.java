package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class LaboratoireReglement implements Serializable {
   private long labregId;
   private String labregService;
   private String labregLaboratoire;
   private long labregIdLaboratoire;
   private String labregProduit;
   private String labregLibelle;
   private double labregPatient;
   private double labregSociete;
   private double labregAssurance;
   private double labregComplementaire;
   private int labregEtat;
   private Date labregDate;
   private String labregCaisse;
   private long labregIdRecu;
   private String labregNumRecu;
   private long labregIdBonEncaissement;
   private String labregNumPieceTiers;
   private LaboratoireEntete laboratoireEntete;

   public LaboratoireEntete getLaboratoireEntete() {
      return this.laboratoireEntete;
   }

   public void setLaboratoireEntete(LaboratoireEntete var1) {
      this.laboratoireEntete = var1;
   }

   public double getLabregAssurance() {
      return this.labregAssurance;
   }

   public void setLabregAssurance(double var1) {
      this.labregAssurance = var1;
   }

   public String getLabregCaisse() {
      return this.labregCaisse;
   }

   public void setLabregCaisse(String var1) {
      this.labregCaisse = var1;
   }

   public double getLabregComplementaire() {
      return this.labregComplementaire;
   }

   public void setLabregComplementaire(double var1) {
      this.labregComplementaire = var1;
   }

   public Date getLabregDate() {
      return this.labregDate;
   }

   public void setLabregDate(Date var1) {
      this.labregDate = var1;
   }

   public int getLabregEtat() {
      return this.labregEtat;
   }

   public void setLabregEtat(int var1) {
      this.labregEtat = var1;
   }

   public long getLabregId() {
      return this.labregId;
   }

   public void setLabregId(long var1) {
      this.labregId = var1;
   }

   public long getLabregIdBonEncaissement() {
      return this.labregIdBonEncaissement;
   }

   public void setLabregIdBonEncaissement(long var1) {
      this.labregIdBonEncaissement = var1;
   }

   public long getLabregIdLaboratoire() {
      return this.labregIdLaboratoire;
   }

   public void setLabregIdLaboratoire(long var1) {
      this.labregIdLaboratoire = var1;
   }

   public long getLabregIdRecu() {
      return this.labregIdRecu;
   }

   public void setLabregIdRecu(long var1) {
      this.labregIdRecu = var1;
   }

   public String getLabregLaboratoire() {
      return this.labregLaboratoire;
   }

   public void setLabregLaboratoire(String var1) {
      this.labregLaboratoire = var1;
   }

   public String getLabregLibelle() {
      return this.labregLibelle;
   }

   public void setLabregLibelle(String var1) {
      this.labregLibelle = var1;
   }

   public String getLabregNumRecu() {
      return this.labregNumRecu;
   }

   public void setLabregNumRecu(String var1) {
      this.labregNumRecu = var1;
   }

   public double getLabregPatient() {
      return this.labregPatient;
   }

   public void setLabregPatient(double var1) {
      this.labregPatient = var1;
   }

   public String getLabregProduit() {
      return this.labregProduit;
   }

   public void setLabregProduit(String var1) {
      this.labregProduit = var1;
   }

   public String getLabregService() {
      return this.labregService;
   }

   public void setLabregService(String var1) {
      this.labregService = var1;
   }

   public double getLabregSociete() {
      return this.labregSociete;
   }

   public void setLabregSociete(double var1) {
      this.labregSociete = var1;
   }

   public String getLabregNumPieceTiers() {
      return this.labregNumPieceTiers;
   }

   public void setLabregNumPieceTiers(String var1) {
      this.labregNumPieceTiers = var1;
   }
}
