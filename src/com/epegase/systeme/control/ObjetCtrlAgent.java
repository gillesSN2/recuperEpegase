package com.epegase.systeme.control;

import java.io.Serializable;

public class ObjetCtrlAgent implements Serializable {
   private String matricule;
   private String patronyme;
   private String periode;
   private String service;
   private String activite;
   private String localisation;
   private String etat;

   public String getActivite() {
      return this.activite;
   }

   public void setActivite(String var1) {
      this.activite = var1;
   }

   public String getEtat() {
      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getLocalisation() {
      return this.localisation;
   }

   public void setLocalisation(String var1) {
      this.localisation = var1;
   }

   public String getMatricule() {
      return this.matricule;
   }

   public void setMatricule(String var1) {
      this.matricule = var1;
   }

   public String getPatronyme() {
      return this.patronyme;
   }

   public void setPatronyme(String var1) {
      this.patronyme = var1;
   }

   public String getService() {
      return this.service;
   }

   public void setService(String var1) {
      this.service = var1;
   }

   public String getPeriode() {
      return this.periode;
   }

   public void setPeriode(String var1) {
      this.periode = var1;
   }
}
