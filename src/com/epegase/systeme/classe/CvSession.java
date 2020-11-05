package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class CvSession implements Serializable {
   private long cvsId;
   private Date cvsDateCreat;
   private Date cvsDateModif;
   private long cvsUserCreat;
   private long cvsUserModif;
   private String cvsCode;
   private Date cvsDateDebut;
   private Date cvsDateFin;
   private String cvsOrganisme;
   private String cvsReference;
   private String cvsLangue;
   private int cvsInactif;
   private long cvsIdResponsable;
   private String cvsNomResponsable;
   private String cvsObjet;
   private ExercicesPaye exercicesPaye;
   private String etat;

   public ExercicesPaye getExercicesPaye() {
      return this.exercicesPaye;
   }

   public void setExercicesPaye(ExercicesPaye var1) {
      this.exercicesPaye = var1;
   }

   public String getEtat() {
      if (this.cvsInactif == 1) {
         this.etat = "/images/descvsiver.png";
      } else if (this.cvsInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public String getCvsCode() {
      return this.cvsCode;
   }

   public void setCvsCode(String var1) {
      this.cvsCode = var1;
   }

   public Date getCvsDateCreat() {
      return this.cvsDateCreat;
   }

   public void setCvsDateCreat(Date var1) {
      this.cvsDateCreat = var1;
   }

   public Date getCvsDateDebut() {
      return this.cvsDateDebut;
   }

   public void setCvsDateDebut(Date var1) {
      this.cvsDateDebut = var1;
   }

   public Date getCvsDateFin() {
      return this.cvsDateFin;
   }

   public void setCvsDateFin(Date var1) {
      this.cvsDateFin = var1;
   }

   public Date getCvsDateModif() {
      return this.cvsDateModif;
   }

   public void setCvsDateModif(Date var1) {
      this.cvsDateModif = var1;
   }

   public long getCvsId() {
      return this.cvsId;
   }

   public void setCvsId(long var1) {
      this.cvsId = var1;
   }

   public long getCvsIdResponsable() {
      return this.cvsIdResponsable;
   }

   public void setCvsIdResponsable(long var1) {
      this.cvsIdResponsable = var1;
   }

   public int getCvsInactif() {
      return this.cvsInactif;
   }

   public void setCvsInactif(int var1) {
      this.cvsInactif = var1;
   }

   public String getCvsLangue() {
      return this.cvsLangue;
   }

   public void setCvsLangue(String var1) {
      this.cvsLangue = var1;
   }

   public String getCvsNomResponsable() {
      return this.cvsNomResponsable;
   }

   public void setCvsNomResponsable(String var1) {
      this.cvsNomResponsable = var1;
   }

   public String getCvsOrganisme() {
      return this.cvsOrganisme;
   }

   public void setCvsOrganisme(String var1) {
      this.cvsOrganisme = var1;
   }

   public long getCvsUserCreat() {
      return this.cvsUserCreat;
   }

   public void setCvsUserCreat(long var1) {
      this.cvsUserCreat = var1;
   }

   public long getCvsUserModif() {
      return this.cvsUserModif;
   }

   public void setCvsUserModif(long var1) {
      this.cvsUserModif = var1;
   }

   public String getCvsReference() {
      return this.cvsReference;
   }

   public void setCvsReference(String var1) {
      this.cvsReference = var1;
   }

   public String getCvsObjet() {
      return this.cvsObjet;
   }

   public void setCvsObjet(String var1) {
      this.cvsObjet = var1;
   }
}
