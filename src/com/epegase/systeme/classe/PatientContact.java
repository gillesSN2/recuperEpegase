package com.epegase.systeme.classe;

import java.io.Serializable;

public class PatientContact implements Serializable {
   private long patconId;
   private String patconCivilite;
   private String patconQualite;
   private String patconNom;
   private String patconPrenom;
   private String patconAdresse;
   private String patconTelBur;
   private String patconTelDom;
   private String patconCel;
   private String patconMail;
   private String patconObs;
   private Patients patient;
   private String patronyme;

   public String getPatronyme() {
      if (this.patconPrenom != null && !this.patconPrenom.isEmpty()) {
         this.patronyme = this.patconNom + " " + this.patconPrenom;
      } else {
         this.patronyme = this.patconNom;
      }

      return this.patronyme;
   }

   public void setPatronyme(String var1) {
      this.patronyme = var1;
   }

   public String getPatconAdresse() {
      return this.patconAdresse;
   }

   public void setPatconAdresse(String var1) {
      this.patconAdresse = var1;
   }

   public String getPatconCel() {
      return this.patconCel;
   }

   public void setPatconCel(String var1) {
      this.patconCel = var1;
   }

   public String getPatconCivilite() {
      return this.patconCivilite;
   }

   public void setPatconCivilite(String var1) {
      this.patconCivilite = var1;
   }

   public String getPatconMail() {
      return this.patconMail;
   }

   public void setPatconMail(String var1) {
      this.patconMail = var1;
   }

   public String getPatconNom() {
      if (this.patconNom != null && !this.patconNom.isEmpty()) {
         this.patconNom = this.patconNom.toUpperCase();
      }

      return this.patconNom;
   }

   public void setPatconNom(String var1) {
      this.patconNom = var1;
   }

   public String getPatconObs() {
      return this.patconObs;
   }

   public void setPatconObs(String var1) {
      this.patconObs = var1;
   }

   public String getPatconPrenom() {
      return this.patconPrenom;
   }

   public void setPatconPrenom(String var1) {
      this.patconPrenom = var1;
   }

   public String getPatconQualite() {
      return this.patconQualite;
   }

   public void setPatconQualite(String var1) {
      this.patconQualite = var1;
   }

   public String getPatconTelBur() {
      return this.patconTelBur;
   }

   public void setPatconTelBur(String var1) {
      this.patconTelBur = var1;
   }

   public String getPatconTelDom() {
      return this.patconTelDom;
   }

   public void setPatconTelDom(String var1) {
      this.patconTelDom = var1;
   }

   public long getPatconId() {
      return this.patconId;
   }

   public void setPatconId(long var1) {
      this.patconId = var1;
   }

   public Patients getPatient() {
      return this.patient;
   }

   public void setPatient(Patients var1) {
      this.patient = var1;
   }
}
