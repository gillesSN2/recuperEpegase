package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PlansBudgetaires implements Serializable {
   private long plb_id;
   private int plbChoixBudget;
   private String plbAnnee;
   private String plbNature;
   private Date plbDateCreat;
   private Date plbDateModif;
   private long plbUserCreat;
   private long plbUserModif;
   private String plbCode;
   private String plbEntite;
   private String plbLibelleFr;
   private String plbLibelleUk;
   private String plbLibelleSp;
   private String plbActivite;
   private int plbInactif;
   private int plbOrdre;
   private int plbBloque;
   private long plbIdOld;
   private String plbProjet;
   private int plbType;
   private String plbIdUsers;
   private ExercicesComptable exercicesComptable;
   private String etat;
   private boolean afficheImag;
   private String var_lib_bloque;
   private String espaceFamille;

   public String getEspaceFamille() {
      if (this.plbType == 2) {
         this.espaceFamille = "font-weight:bold;";
      } else if (this.plbType == 15) {
         this.espaceFamille = "font-weight:bold;color:red;font-size:15px;";
      } else if (this.plbType == 20) {
         this.espaceFamille = "font-weight:bold";
      } else if (this.plbType == 21) {
         this.espaceFamille = "font-weight:bold;font-style: italic;";
      } else if (this.plbType == 22) {
         this.espaceFamille = "font-weight:bold;font-style: italic;text-decoration:underline;";
      } else if (this.plbType != 3 && this.plbType != 4) {
         this.espaceFamille = "width:100%;";
      } else {
         this.espaceFamille = "font-style: italic;";
      }

      if (this.plbNature != null && this.plbNature.length() >= 2) {
         if (this.plbType != 0 && this.plbType != 1 && this.plbType != 3 && this.plbType != 4) {
            if (this.plbType != 15 && this.plbType != 20) {
               if (this.plbType == 21) {
                  this.espaceFamille = this.espaceFamille + "margin-left:20px;";
               } else if (this.plbType == 22) {
                  this.espaceFamille = this.espaceFamille + "margin-left:40px;";
               }
            }
         } else {
            this.espaceFamille = this.espaceFamille + "margin-left:60px;";
         }
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public String getEtat() {
      if (this.plbInactif == 1) {
         this.etat = "/images/desactiver.png";
      }

      if (this.plbInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.plbInactif != 1 && this.plbInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getVar_lib_bloque() {
      if (this.plbBloque == 0) {
         this.var_lib_bloque = "Non bloquant";
      } else if (this.plbBloque == 1) {
         this.var_lib_bloque = "Bloquant sur budget";
      } else if (this.plbBloque == 2) {
         this.var_lib_bloque = "Bloquant sur tréso.";
      } else if (this.plbBloque == 3) {
         this.var_lib_bloque = "Bloquant tous critères";
      }

      return this.var_lib_bloque;
   }

   public void setVar_lib_bloque(String var1) {
      this.var_lib_bloque = var1;
   }

   public ExercicesComptable getExercicesComptable() {
      return this.exercicesComptable;
   }

   public void setExercicesComptable(ExercicesComptable var1) {
      this.exercicesComptable = var1;
   }

   public String getPlbActivite() {
      return this.plbActivite;
   }

   public void setPlbActivite(String var1) {
      this.plbActivite = var1;
   }

   public String getPlbAnnee() {
      return this.plbAnnee;
   }

   public void setPlbAnnee(String var1) {
      this.plbAnnee = var1;
   }

   public int getPlbBloque() {
      return this.plbBloque;
   }

   public void setPlbBloque(int var1) {
      this.plbBloque = var1;
   }

   public String getPlbCode() {
      if (this.plbCode != null && !this.plbCode.isEmpty()) {
         this.plbCode = this.plbCode.toUpperCase();
      }

      return this.plbCode;
   }

   public void setPlbCode(String var1) {
      this.plbCode = var1;
   }

   public Date getPlbDateCreat() {
      return this.plbDateCreat;
   }

   public void setPlbDateCreat(Date var1) {
      this.plbDateCreat = var1;
   }

   public Date getPlbDateModif() {
      return this.plbDateModif;
   }

   public void setPlbDateModif(Date var1) {
      this.plbDateModif = var1;
   }

   public int getPlbInactif() {
      return this.plbInactif;
   }

   public void setPlbInactif(int var1) {
      this.plbInactif = var1;
   }

   public String getPlbLibelleFr() {
      if (this.plbLibelleFr != null && !this.plbLibelleFr.isEmpty()) {
         this.plbLibelleFr = this.plbLibelleFr.toUpperCase();
      }

      return this.plbLibelleFr;
   }

   public void setPlbLibelleFr(String var1) {
      this.plbLibelleFr = var1;
   }

   public String getPlbLibelleSp() {
      return this.plbLibelleSp;
   }

   public void setPlbLibelleSp(String var1) {
      this.plbLibelleSp = var1;
   }

   public String getPlbLibelleUk() {
      return this.plbLibelleUk;
   }

   public void setPlbLibelleUk(String var1) {
      this.plbLibelleUk = var1;
   }

   public String getPlbNature() {
      return this.plbNature;
   }

   public void setPlbNature(String var1) {
      this.plbNature = var1;
   }

   public int getPlbOrdre() {
      return this.plbOrdre;
   }

   public void setPlbOrdre(int var1) {
      this.plbOrdre = var1;
   }

   public long getPlbUserCreat() {
      return this.plbUserCreat;
   }

   public void setPlbUserCreat(long var1) {
      this.plbUserCreat = var1;
   }

   public long getPlbUserModif() {
      return this.plbUserModif;
   }

   public void setPlbUserModif(long var1) {
      this.plbUserModif = var1;
   }

   public long getPlb_id() {
      return this.plb_id;
   }

   public void setPlb_id(long var1) {
      this.plb_id = var1;
   }

   public long getPlbIdOld() {
      return this.plbIdOld;
   }

   public void setPlbIdOld(long var1) {
      this.plbIdOld = var1;
   }

   public String getPlbIdUsers() {
      return this.plbIdUsers;
   }

   public void setPlbIdUsers(String var1) {
      this.plbIdUsers = var1;
   }

   public String getPlbProjet() {
      return this.plbProjet;
   }

   public void setPlbProjet(String var1) {
      this.plbProjet = var1;
   }

   public int getPlbType() {
      return this.plbType;
   }

   public void setPlbType(int var1) {
      this.plbType = var1;
   }

   public String getPlbEntite() {
      return this.plbEntite;
   }

   public void setPlbEntite(String var1) {
      this.plbEntite = var1;
   }

   public int getPlbChoixBudget() {
      return this.plbChoixBudget;
   }

   public void setPlbChoixBudget(int var1) {
      this.plbChoixBudget = var1;
   }
}
