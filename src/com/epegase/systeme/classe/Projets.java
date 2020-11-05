package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Projets implements Serializable {
   private long proId;
   private long proUserCreat;
   private Date proDateCreat;
   private long proUserModif;
   private Date proDateModif;
   private long proIdResponsable;
   private String proNomResponsable;
   private int proChoixBudget;
   private String proCode;
   private String proNomFR;
   private String proNomUK;
   private String proNomSP;
   private String proDescription;
   private String proInitiateur;
   private String proSource;
   private Date proDateDebut;
   private Date proDateFin;
   private Date proDateDebutConvention;
   private Date proDateFinConvention;
   private String proAnnee;
   private int proDuree;
   private double proMontantDevise;
   private String proDevise;
   private float proCoefEuro;
   private double proMontantEuro;
   private float proCoefPays;
   private double proMontantPays;
   private int proNbTranche;
   private String proContexte;
   private String proObjectif;
   private int proInactif;
   private String proDateEcheanceDeb;
   private String proDateEcheanceFin;
   private String proMontantEcheance;
   private String proObsEcheance;
   private String proIdUsers;
   private String etat;
   private boolean inactif;

   public boolean isInactif() {
      if (this.proInactif != 1 && this.proInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getEtat() {
      if (this.proInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.proInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getProCode() {
      if (this.proCode != null) {
         this.proCode = this.proCode.toUpperCase();
      }

      return this.proCode;
   }

   public void setProCode(String var1) {
      this.proCode = var1;
   }

   public float getProCoefPays() {
      return this.proCoefPays;
   }

   public void setProCoefPays(float var1) {
      this.proCoefPays = var1;
   }

   public String getProContexte() {
      return this.proContexte;
   }

   public void setProContexte(String var1) {
      this.proContexte = var1;
   }

   public Date getProDateCreat() {
      return this.proDateCreat;
   }

   public void setProDateCreat(Date var1) {
      this.proDateCreat = var1;
   }

   public Date getProDateDebut() {
      return this.proDateDebut;
   }

   public void setProDateDebut(Date var1) {
      this.proDateDebut = var1;
   }

   public Date getProDateFin() {
      return this.proDateFin;
   }

   public void setProDateFin(Date var1) {
      this.proDateFin = var1;
   }

   public Date getProDateModif() {
      return this.proDateModif;
   }

   public void setProDateModif(Date var1) {
      this.proDateModif = var1;
   }

   public String getProDescription() {
      return this.proDescription;
   }

   public void setProDescription(String var1) {
      this.proDescription = var1;
   }

   public int getProInactif() {
      return this.proInactif;
   }

   public void setProInactif(int var1) {
      this.proInactif = var1;
   }

   public String getProInitiateur() {
      return this.proInitiateur;
   }

   public void setProInitiateur(String var1) {
      this.proInitiateur = var1;
   }

   public double getProMontantEuro() {
      return this.proMontantEuro;
   }

   public void setProMontantEuro(double var1) {
      this.proMontantEuro = var1;
   }

   public double getProMontantPays() {
      return this.proMontantPays;
   }

   public void setProMontantPays(double var1) {
      this.proMontantPays = var1;
   }

   public String getProNomFR() {
      if (this.proNomFR != null && !this.proNomFR.isEmpty()) {
         this.proNomFR = this.proNomFR.toUpperCase();
      }

      return this.proNomFR;
   }

   public void setProNomFR(String var1) {
      this.proNomFR = var1;
   }

   public String getProNomSP() {
      return this.proNomSP;
   }

   public void setProNomSP(String var1) {
      this.proNomSP = var1;
   }

   public String getProNomUK() {
      return this.proNomUK;
   }

   public void setProNomUK(String var1) {
      this.proNomUK = var1;
   }

   public String getProObjectif() {
      return this.proObjectif;
   }

   public void setProObjectif(String var1) {
      this.proObjectif = var1;
   }

   public long getProUserCreat() {
      return this.proUserCreat;
   }

   public void setProUserCreat(long var1) {
      this.proUserCreat = var1;
   }

   public long getProUserModif() {
      return this.proUserModif;
   }

   public void setProUserModif(long var1) {
      this.proUserModif = var1;
   }

   public long getProId() {
      return this.proId;
   }

   public void setProId(long var1) {
      this.proId = var1;
   }

   public float getProCoefEuro() {
      return this.proCoefEuro;
   }

   public void setProCoefEuro(float var1) {
      this.proCoefEuro = var1;
   }

   public String getProDevise() {
      return this.proDevise;
   }

   public void setProDevise(String var1) {
      this.proDevise = var1;
   }

   public double getProMontantDevise() {
      return this.proMontantDevise;
   }

   public void setProMontantDevise(double var1) {
      this.proMontantDevise = var1;
   }

   public long getProIdResponsable() {
      return this.proIdResponsable;
   }

   public void setProIdResponsable(long var1) {
      this.proIdResponsable = var1;
   }

   public String getProNomResponsable() {
      return this.proNomResponsable;
   }

   public void setProNomResponsable(String var1) {
      this.proNomResponsable = var1;
   }

   public int getProDuree() {
      return this.proDuree;
   }

   public void setProDuree(int var1) {
      this.proDuree = var1;
   }

   public int getProNbTranche() {
      return this.proNbTranche;
   }

   public void setProNbTranche(int var1) {
      this.proNbTranche = var1;
   }

   public String getProSource() {
      return this.proSource;
   }

   public void setProSource(String var1) {
      this.proSource = var1;
   }

   public String getProAnnee() {
      return this.proAnnee;
   }

   public void setProAnnee(String var1) {
      this.proAnnee = var1;
   }

   public String getProDateEcheanceDeb() {
      return this.proDateEcheanceDeb;
   }

   public void setProDateEcheanceDeb(String var1) {
      this.proDateEcheanceDeb = var1;
   }

   public String getProDateEcheanceFin() {
      return this.proDateEcheanceFin;
   }

   public void setProDateEcheanceFin(String var1) {
      this.proDateEcheanceFin = var1;
   }

   public String getProMontantEcheance() {
      return this.proMontantEcheance;
   }

   public void setProMontantEcheance(String var1) {
      this.proMontantEcheance = var1;
   }

   public String getProObsEcheance() {
      return this.proObsEcheance;
   }

   public void setProObsEcheance(String var1) {
      this.proObsEcheance = var1;
   }

   public String getProIdUsers() {
      return this.proIdUsers;
   }

   public void setProIdUsers(String var1) {
      this.proIdUsers = var1;
   }

   public Date getProDateDebutConvention() {
      return this.proDateDebutConvention;
   }

   public void setProDateDebutConvention(Date var1) {
      this.proDateDebutConvention = var1;
   }

   public Date getProDateFinConvention() {
      return this.proDateFinConvention;
   }

   public void setProDateFinConvention(Date var1) {
      this.proDateFinConvention = var1;
   }

   public int getProChoixBudget() {
      return this.proChoixBudget;
   }

   public void setProChoixBudget(int var1) {
      this.proChoixBudget = var1;
   }
}
