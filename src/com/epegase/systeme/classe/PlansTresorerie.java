package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PlansTresorerie implements Serializable {
   private long treId;
   private String treAnnee;
   private Date treDateCreat;
   private Date treDateModif;
   private long treUserCreat;
   private long treUserModif;
   private String treCode;
   private String treLibelleFr;
   private String treLibelleUk;
   private String treLibelleSp;
   private String treCompte;
   private String treLibelleCompte;
   private String treProjet;
   private int treInactif;
   private int treOrdre;
   private int treType;
   private String treIdUsers;
   private ExercicesComptable exercicesComptable;
   private String etat;
   private boolean afficheImag;
   private String espaceFamille;

   public String getEspaceFamille() {
      if (this.treType != 2 && this.treType != 20) {
         if (this.treType == 21) {
            this.espaceFamille = "font-weight:bold;font-style: italic;";
         } else if (this.treType == 22) {
            this.espaceFamille = "font-weight:bold;font-style: italic;";
         } else if (this.treType != 3 && this.treType != 4) {
            this.espaceFamille = "width:100%;";
         } else {
            this.espaceFamille = "font-style: italic;";
         }
      } else {
         this.espaceFamille = "font-weight:bold;";
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public boolean isAfficheImag() {
      if (this.treInactif != 1 && this.treInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getEtat() {
      if (this.treInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.treInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public String getTreAnnee() {
      return this.treAnnee;
   }

   public void setTreAnnee(String var1) {
      this.treAnnee = var1;
   }

   public String getTreCode() {
      return this.treCode;
   }

   public void setTreCode(String var1) {
      this.treCode = var1;
   }

   public Date getTreDateCreat() {
      return this.treDateCreat;
   }

   public void setTreDateCreat(Date var1) {
      this.treDateCreat = var1;
   }

   public Date getTreDateModif() {
      return this.treDateModif;
   }

   public void setTreDateModif(Date var1) {
      this.treDateModif = var1;
   }

   public long getTreId() {
      return this.treId;
   }

   public void setTreId(long var1) {
      this.treId = var1;
   }

   public int getTreInactif() {
      return this.treInactif;
   }

   public void setTreInactif(int var1) {
      this.treInactif = var1;
   }

   public String getTreLibelleFr() {
      return this.treLibelleFr;
   }

   public void setTreLibelleFr(String var1) {
      this.treLibelleFr = var1;
   }

   public String getTreLibelleSp() {
      return this.treLibelleSp;
   }

   public void setTreLibelleSp(String var1) {
      this.treLibelleSp = var1;
   }

   public String getTreLibelleUk() {
      return this.treLibelleUk;
   }

   public void setTreLibelleUk(String var1) {
      this.treLibelleUk = var1;
   }

   public int getTreOrdre() {
      return this.treOrdre;
   }

   public void setTreOrdre(int var1) {
      this.treOrdre = var1;
   }

   public String getTreProjet() {
      return this.treProjet;
   }

   public void setTreProjet(String var1) {
      this.treProjet = var1;
   }

   public long getTreUserCreat() {
      return this.treUserCreat;
   }

   public void setTreUserCreat(long var1) {
      this.treUserCreat = var1;
   }

   public long getTreUserModif() {
      return this.treUserModif;
   }

   public void setTreUserModif(long var1) {
      this.treUserModif = var1;
   }

   public int getTreType() {
      return this.treType;
   }

   public void setTreType(int var1) {
      this.treType = var1;
   }

   public String getTreIdUsers() {
      return this.treIdUsers;
   }

   public void setTreIdUsers(String var1) {
      this.treIdUsers = var1;
   }

   public String getTreCompte() {
      return this.treCompte;
   }

   public void setTreCompte(String var1) {
      this.treCompte = var1;
   }

   public String getTreLibelleCompte() {
      return this.treLibelleCompte;
   }

   public void setTreLibelleCompte(String var1) {
      this.treLibelleCompte = var1;
   }
}
