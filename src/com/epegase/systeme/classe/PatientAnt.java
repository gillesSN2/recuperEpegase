package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PatientAnt implements Serializable {
   private long patantId;
   private Date patantDateCreat;
   private Date patantDateModif;
   private long patantUserCreat;
   private long patantUserModif;
   private String patantMedecin;
   private Date patantDate;
   private String patantCode;
   private String patantFamille;
   private String patantEtat;
   private String patantNumConsultGene;
   private String patantNumConsultSpe;
   private String patantObservation;
   private Patients patient;

   public String getPatantEtat() {
      return this.patantEtat;
   }

   public void setPatantEtat(String var1) {
      this.patantEtat = var1;
   }

   public String getPatantFamille() {
      return this.patantFamille;
   }

   public void setPatantFamille(String var1) {
      this.patantFamille = var1;
   }

   public long getPatantId() {
      return this.patantId;
   }

   public void setPatantId(long var1) {
      this.patantId = var1;
   }

   public String getPatantObservation() {
      return this.patantObservation;
   }

   public void setPatantObservation(String var1) {
      this.patantObservation = var1;
   }

   public Patients getPatient() {
      return this.patient;
   }

   public void setPatient(Patients var1) {
      this.patient = var1;
   }

   public String getPatantCode() {
      return this.patantCode;
   }

   public void setPatantCode(String var1) {
      this.patantCode = var1;
   }

   public Date getPatantDate() {
      return this.patantDate;
   }

   public void setPatantDate(Date var1) {
      this.patantDate = var1;
   }

   public Date getPatantDateCreat() {
      return this.patantDateCreat;
   }

   public void setPatantDateCreat(Date var1) {
      this.patantDateCreat = var1;
   }

   public Date getPatantDateModif() {
      return this.patantDateModif;
   }

   public void setPatantDateModif(Date var1) {
      this.patantDateModif = var1;
   }

   public String getPatantMedecin() {
      return this.patantMedecin;
   }

   public void setPatantMedecin(String var1) {
      this.patantMedecin = var1;
   }

   public long getPatantUserCreat() {
      return this.patantUserCreat;
   }

   public void setPatantUserCreat(long var1) {
      this.patantUserCreat = var1;
   }

   public long getPatantUserModif() {
      return this.patantUserModif;
   }

   public void setPatantUserModif(long var1) {
      this.patantUserModif = var1;
   }

   public String getPatantNumConsultGene() {
      return this.patantNumConsultGene;
   }

   public void setPatantNumConsultGene(String var1) {
      this.patantNumConsultGene = var1;
   }

   public String getPatantNumConsultSpe() {
      return this.patantNumConsultSpe;
   }

   public void setPatantNumConsultSpe(String var1) {
      this.patantNumConsultSpe = var1;
   }
}
