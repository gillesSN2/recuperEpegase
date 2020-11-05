package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class LettreMedical implements Serializable {
   private long letId;
   private Date letDateCreat;
   private Date letDateModif;
   private long letUserCreat;
   private long letUserModif;
   private String letLettre;
   private String letLibelleFr;
   private String letLibelleUk;
   private String letLibelleSp;
   private double letValeur;
   private double letValeurCnamgs;
   private int letInactif;
   private ExercicesVentes exerciceventes;
   private String etat;
   private boolean inactif;

   public String getEtat() {
      if (this.letInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.letInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.letInactif != 1 && this.letInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public int getLetInactif() {
      return this.letInactif;
   }

   public void setLetInactif(int var1) {
      this.letInactif = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public Date getLetDateCreat() {
      return this.letDateCreat;
   }

   public void setLetDateCreat(Date var1) {
      this.letDateCreat = var1;
   }

   public Date getLetDateModif() {
      return this.letDateModif;
   }

   public void setLetDateModif(Date var1) {
      this.letDateModif = var1;
   }

   public long getLetId() {
      return this.letId;
   }

   public void setLetId(long var1) {
      this.letId = var1;
   }

   public String getLetLettre() {
      if (this.letLettre != null && !this.letLettre.isEmpty()) {
         this.letLettre = this.letLettre.toUpperCase();
      }

      return this.letLettre;
   }

   public void setLetLettre(String var1) {
      this.letLettre = var1;
   }

   public String getLetLibelleFr() {
      if (this.letLibelleFr != null && !this.letLibelleFr.isEmpty()) {
         this.letLibelleFr = this.letLibelleFr.toUpperCase();
      }

      return this.letLibelleFr;
   }

   public void setLetLibelleFr(String var1) {
      this.letLibelleFr = var1;
   }

   public String getLetLibelleSp() {
      return this.letLibelleSp;
   }

   public void setLetLibelleSp(String var1) {
      this.letLibelleSp = var1;
   }

   public String getLetLibelleUk() {
      return this.letLibelleUk;
   }

   public void setLetLibelleUk(String var1) {
      this.letLibelleUk = var1;
   }

   public long getLetUserCreat() {
      return this.letUserCreat;
   }

   public void setLetUserCreat(long var1) {
      this.letUserCreat = var1;
   }

   public long getLetUserModif() {
      return this.letUserModif;
   }

   public void setLetUserModif(long var1) {
      this.letUserModif = var1;
   }

   public double getLetValeur() {
      return this.letValeur;
   }

   public void setLetValeur(double var1) {
      this.letValeur = var1;
   }

   public double getLetValeurCnamgs() {
      return this.letValeurCnamgs;
   }

   public void setLetValeurCnamgs(double var1) {
      this.letValeurCnamgs = var1;
   }
}
