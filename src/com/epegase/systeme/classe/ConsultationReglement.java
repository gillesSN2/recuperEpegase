package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ConsultationReglement implements Serializable {
   private long csgregId;
   private String csgregService;
   private String csgregProduit;
   private String csgregLibelle;
   private double csgregPatient;
   private double csgregSociete;
   private double csgregAssurance;
   private double csgregComplementaire;
   private int csgregEtat;
   private Date csgregDate;
   private String csgregCaisse;
   private long csgregIdRecu;
   private String csgregNumRecu;
   private long csgregIdBonEncaissement;
   private String csgregNumPieceTiers;
   private ConsultationEnteteGene consultationEnteteGene;

   public ConsultationEnteteGene getConsultationEnteteGene() {
      return this.consultationEnteteGene;
   }

   public void setConsultationEnteteGene(ConsultationEnteteGene var1) {
      this.consultationEnteteGene = var1;
   }

   public double getCsgregAssurance() {
      return this.csgregAssurance;
   }

   public void setCsgregAssurance(double var1) {
      this.csgregAssurance = var1;
   }

   public String getCsgregCaisse() {
      return this.csgregCaisse;
   }

   public void setCsgregCaisse(String var1) {
      this.csgregCaisse = var1;
   }

   public double getCsgregComplementaire() {
      return this.csgregComplementaire;
   }

   public void setCsgregComplementaire(double var1) {
      this.csgregComplementaire = var1;
   }

   public Date getCsgregDate() {
      return this.csgregDate;
   }

   public void setCsgregDate(Date var1) {
      this.csgregDate = var1;
   }

   public int getCsgregEtat() {
      return this.csgregEtat;
   }

   public void setCsgregEtat(int var1) {
      this.csgregEtat = var1;
   }

   public long getCsgregId() {
      return this.csgregId;
   }

   public void setCsgregId(long var1) {
      this.csgregId = var1;
   }

   public long getCsgregIdBonEncaissement() {
      return this.csgregIdBonEncaissement;
   }

   public void setCsgregIdBonEncaissement(long var1) {
      this.csgregIdBonEncaissement = var1;
   }

   public long getCsgregIdRecu() {
      return this.csgregIdRecu;
   }

   public void setCsgregIdRecu(long var1) {
      this.csgregIdRecu = var1;
   }

   public String getCsgregLibelle() {
      return this.csgregLibelle;
   }

   public void setCsgregLibelle(String var1) {
      this.csgregLibelle = var1;
   }

   public String getCsgregNumRecu() {
      return this.csgregNumRecu;
   }

   public void setCsgregNumRecu(String var1) {
      this.csgregNumRecu = var1;
   }

   public double getCsgregPatient() {
      return this.csgregPatient;
   }

   public void setCsgregPatient(double var1) {
      this.csgregPatient = var1;
   }

   public String getCsgregProduit() {
      return this.csgregProduit;
   }

   public void setCsgregProduit(String var1) {
      this.csgregProduit = var1;
   }

   public String getCsgregService() {
      return this.csgregService;
   }

   public void setCsgregService(String var1) {
      this.csgregService = var1;
   }

   public double getCsgregSociete() {
      return this.csgregSociete;
   }

   public void setCsgregSociete(double var1) {
      this.csgregSociete = var1;
   }

   public String getCsgregNumPieceTiers() {
      return this.csgregNumPieceTiers;
   }

   public void setCsgregNumPieceTiers(String var1) {
      this.csgregNumPieceTiers = var1;
   }
}
