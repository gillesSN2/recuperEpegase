package com.epegase.systeme.classe;

import java.io.Serializable;

public class BsoTabFormule implements Serializable {
   private long tabfor_id;
   private long tabforOldId;
   private int tabforCol;
   private String tabforZone;
   private String tabforFormule;
   private String tabforAnalytique;
   private String tabforSite;
   private String tabforDepartement;
   private String tabforService;
   private String tabforRegion;
   private String tabforSecteur;
   private String tabforPdv;
   private String tabforActivite;
   private String tabforDossier;
   private String tabforParc;
   private String tabforBudget;
   private int tabforSolde;
   private int tabforPeriode;
   private int tabforInactif;
   private BsoTabElement bsoTabElement;
   private String var_sens;
   private String lib_periode;
   private boolean var_for_inactif;

   public String getVar_sens() {
      if (this.tabforSolde == 0) {
         if (this.tabforFormule.contains("COMPTE")) {
            this.var_sens = "Tout sld. (Debit-Crédit)";
         } else {
            this.var_sens = "";
         }
      } else if (this.tabforSolde == 1) {
         if (this.tabforFormule.contains("COMPTE")) {
            this.var_sens = "Tout sld. (Crédit-Débit)";
         } else {
            this.var_sens = "";
         }
      } else if (this.tabforSolde == 2) {
         this.var_sens = "Sld.Déb.";
      } else if (this.tabforSolde == 3) {
         this.var_sens = "Sld.Créd.";
      } else if (this.tabforSolde == 4) {
         this.var_sens = "Mvt.Déb.";
      } else if (this.tabforSolde == 5) {
         this.var_sens = "Mvt.Créd.";
      } else if (this.tabforSolde == 6) {
         this.var_sens = "Saisie Num.";
      } else if (this.tabforSolde == 7) {
         this.var_sens = "Saisie Texte court";
      } else if (this.tabforSolde == 8) {
         this.var_sens = "Saisie Texte long";
      } else if (this.tabforSolde == 9) {
         this.var_sens = "Saisie Liste";
      } else if (this.tabforSolde == 10) {
         if (this.tabforFormule.contains("COMPTE")) {
            this.var_sens = "Tout sld.AN (Debit-Crédit)";
         } else {
            this.var_sens = "";
         }
      } else if (this.tabforSolde == 11) {
         if (this.tabforFormule.contains("COMPTE")) {
            this.var_sens = "Tout sld.AN (Crédit-Débit)";
         } else {
            this.var_sens = "";
         }
      } else if (this.tabforSolde == 12) {
         this.var_sens = "Sld.Déb.AN";
      } else if (this.tabforSolde == 13) {
         this.var_sens = "Sld.Créd.AN";
      } else if (this.tabforSolde == 14) {
         this.var_sens = "Mvt.Déb.AN";
      } else if (this.tabforSolde == 15) {
         this.var_sens = "Mvt.Créd.AN";
      } else if (this.tabforSolde == 16) {
         this.var_sens = "Mvt.Déb. sauf AN & V.P/P";
      } else if (this.tabforSolde == 17) {
         this.var_sens = "Mvt.Créd. sauf AN & V.P/P";
      } else if (this.tabforSolde == 18) {
         this.var_sens = "Mvt.Déb. sauf V.P/P";
      } else if (this.tabforSolde == 19) {
         this.var_sens = "Mvt.Créd. sauf V.P/P";
      } else if (this.tabforSolde == 20) {
         this.var_sens = "Mvt.Déb. V.P/P";
      } else if (this.tabforSolde == 21) {
         this.var_sens = "Mvt.Créd. V.P/P";
      } else if (this.tabforSolde == 22) {
         this.var_sens = "Tout Solde V.P/P";
      } else if (this.tabforSolde == 23) {
         this.var_sens = "Mvt.Déb. AB";
      } else if (this.tabforSolde == 24) {
         this.var_sens = "Mvt.Créd AB";
      } else if (this.tabforSolde == 25) {
         this.var_sens = "Sld.Déb. AB";
      } else if (this.tabforSolde == 26) {
         this.var_sens = "Sld.Créd. AB";
      } else if (this.tabforSolde == 27) {
         if (this.tabforFormule.contains("COMPTE")) {
            this.var_sens = "Tout Sld.AB (Débit-Crédit)";
         } else {
            this.var_sens = "";
         }
      } else if (this.tabforSolde == 28) {
         if (this.tabforFormule.contains("COMPTE")) {
            this.var_sens = "Tout Sld.AB (Crédit-Débit)";
         } else {
            this.var_sens = "";
         }
      }

      return this.var_sens;
   }

   public void setVar_sens(String var1) {
      this.var_sens = var1;
   }

   public String getLib_periode() {
      if ((this.tabforFormule == null || this.tabforFormule.isEmpty() || !this.tabforFormule.contains("COMPTE")) && (this.tabforBudget == null || this.tabforBudget.isEmpty()) && (this.tabforAnalytique == null || this.tabforAnalytique.isEmpty())) {
         this.lib_periode = "";
      } else if (this.tabforPeriode == 0) {
         this.lib_periode = "N";
      } else if (this.tabforPeriode == 1) {
         this.lib_periode = "N Janvier";
      } else if (this.tabforPeriode == 2) {
         this.lib_periode = "N Février";
      } else if (this.tabforPeriode == 3) {
         this.lib_periode = "N Mars";
      } else if (this.tabforPeriode == 4) {
         this.lib_periode = "N Avril";
      } else if (this.tabforPeriode == 5) {
         this.lib_periode = "N Mai";
      } else if (this.tabforPeriode == 6) {
         this.lib_periode = "N Juin";
      } else if (this.tabforPeriode == 7) {
         this.lib_periode = "N Juillet";
      } else if (this.tabforPeriode == 8) {
         this.lib_periode = "N Aout";
      } else if (this.tabforPeriode == 9) {
         this.lib_periode = "N Septembre";
      } else if (this.tabforPeriode == 10) {
         this.lib_periode = "N Octobre";
      } else if (this.tabforPeriode == 11) {
         this.lib_periode = "N Novembre";
      } else if (this.tabforPeriode == 12) {
         this.lib_periode = "N Décembre";
      } else if (this.tabforPeriode == 13) {
         this.lib_periode = "N 1er Trimestre";
      } else if (this.tabforPeriode == 14) {
         this.lib_periode = "N 2eme Trimestre";
      } else if (this.tabforPeriode == 15) {
         this.lib_periode = "N 3eme Trimestre";
      } else if (this.tabforPeriode == 16) {
         this.lib_periode = "N 4eme Trimestre";
      } else if (this.tabforPeriode == 17) {
         this.lib_periode = "N 1er Semestre";
      } else if (this.tabforPeriode == 18) {
         this.lib_periode = "N 2eme Semestre";
      } else if (this.tabforPeriode == 19) {
         this.lib_periode = "N (Année complète)";
      } else if (this.tabforPeriode == 20) {
         this.lib_periode = "N-1";
      } else if (this.tabforPeriode == 21) {
         this.lib_periode = "N-1 Janvier";
      } else if (this.tabforPeriode == 22) {
         this.lib_periode = "N-1 Février";
      } else if (this.tabforPeriode == 23) {
         this.lib_periode = "N-1 Mars";
      } else if (this.tabforPeriode == 24) {
         this.lib_periode = "N-1 Avril";
      } else if (this.tabforPeriode == 25) {
         this.lib_periode = "N-1 Mai";
      } else if (this.tabforPeriode == 26) {
         this.lib_periode = "N-1 Juin";
      } else if (this.tabforPeriode == 27) {
         this.lib_periode = "N-1 Juillet";
      } else if (this.tabforPeriode == 28) {
         this.lib_periode = "N-1 Aout";
      } else if (this.tabforPeriode == 29) {
         this.lib_periode = "N-1 Septembre";
      } else if (this.tabforPeriode == 30) {
         this.lib_periode = "N-1 Octobre";
      } else if (this.tabforPeriode == 31) {
         this.lib_periode = "N-1 Novembre";
      } else if (this.tabforPeriode == 32) {
         this.lib_periode = "N-1 Décembre";
      } else if (this.tabforPeriode == 33) {
         this.lib_periode = "N-1 1er Trimestre";
      } else if (this.tabforPeriode == 34) {
         this.lib_periode = "N-1 2eme Trimestre";
      } else if (this.tabforPeriode == 35) {
         this.lib_periode = "N-1 3eme Trimestre";
      } else if (this.tabforPeriode == 36) {
         this.lib_periode = "N-1 4eme Trimestre";
      } else if (this.tabforPeriode == 37) {
         this.lib_periode = "N-1 1er Semestre";
      } else if (this.tabforPeriode == 38) {
         this.lib_periode = "N-1 2eme Semestre";
      } else if (this.tabforPeriode == 39) {
         this.lib_periode = "N-1 (Année complète)";
      } else if (this.tabforPeriode == 40) {
         this.lib_periode = "N-2";
      } else if (this.tabforPeriode == 41) {
         this.lib_periode = "N-2 Janvier";
      } else if (this.tabforPeriode == 42) {
         this.lib_periode = "N-2 Février";
      } else if (this.tabforPeriode == 43) {
         this.lib_periode = "N-2 Mars";
      } else if (this.tabforPeriode == 44) {
         this.lib_periode = "N-2 Avril";
      } else if (this.tabforPeriode == 45) {
         this.lib_periode = "N-2 Mai";
      } else if (this.tabforPeriode == 46) {
         this.lib_periode = "N-2 Juin";
      } else if (this.tabforPeriode == 47) {
         this.lib_periode = "N-2 Juillet";
      } else if (this.tabforPeriode == 48) {
         this.lib_periode = "N-2 Aout";
      } else if (this.tabforPeriode == 49) {
         this.lib_periode = "N-2 Septembre";
      } else if (this.tabforPeriode == 50) {
         this.lib_periode = "N-2 Octobre";
      } else if (this.tabforPeriode == 51) {
         this.lib_periode = "N-2 Novembre";
      } else if (this.tabforPeriode == 52) {
         this.lib_periode = "N-2 Décembre";
      } else if (this.tabforPeriode == 53) {
         this.lib_periode = "N-2 1er Trimestre";
      } else if (this.tabforPeriode == 54) {
         this.lib_periode = "N-2 2eme Trimestre";
      } else if (this.tabforPeriode == 55) {
         this.lib_periode = "N-2 3eme Trimestre";
      } else if (this.tabforPeriode == 56) {
         this.lib_periode = "N-2 4eme Trimestre";
      } else if (this.tabforPeriode == 57) {
         this.lib_periode = "N-2 1er Semestre";
      } else if (this.tabforPeriode == 58) {
         this.lib_periode = "N-2 2eme Semestre";
      } else if (this.tabforPeriode == 59) {
         this.lib_periode = "N-2 (Année complète)";
      }

      return this.lib_periode;
   }

   public void setLib_periode(String var1) {
      this.lib_periode = var1;
   }

   public boolean isVar_for_inactif() {
      return this.var_for_inactif;
   }

   public void setVar_for_inactif(boolean var1) {
      this.var_for_inactif = var1;
   }

   public BsoTabElement getBsoTabElement() {
      return this.bsoTabElement;
   }

   public void setBsoTabElement(BsoTabElement var1) {
      this.bsoTabElement = var1;
   }

   public int getTabforCol() {
      return this.tabforCol;
   }

   public void setTabforCol(int var1) {
      this.tabforCol = var1;
   }

   public String getTabforFormule() {
      return this.tabforFormule;
   }

   public void setTabforFormule(String var1) {
      this.tabforFormule = var1;
   }

   public int getTabforSolde() {
      return this.tabforSolde;
   }

   public void setTabforSolde(int var1) {
      this.tabforSolde = var1;
   }

   public String getTabforZone() {
      return this.tabforZone;
   }

   public void setTabforZone(String var1) {
      this.tabforZone = var1;
   }

   public long getTabfor_id() {
      return this.tabfor_id;
   }

   public void setTabfor_id(long var1) {
      this.tabfor_id = var1;
   }

   public String getTabforAnalytique() {
      return this.tabforAnalytique;
   }

   public void setTabforAnalytique(String var1) {
      this.tabforAnalytique = var1;
   }

   public long getTabforOldId() {
      return this.tabforOldId;
   }

   public void setTabforOldId(long var1) {
      this.tabforOldId = var1;
   }

   public int getTabforPeriode() {
      return this.tabforPeriode;
   }

   public void setTabforPeriode(int var1) {
      this.tabforPeriode = var1;
   }

   public String getTabforBudget() {
      return this.tabforBudget;
   }

   public void setTabforBudget(String var1) {
      this.tabforBudget = var1;
   }

   public int getTabforInactif() {
      return this.tabforInactif;
   }

   public void setTabforInactif(int var1) {
      this.tabforInactif = var1;
   }

   public String getTabforActivite() {
      return this.tabforActivite;
   }

   public void setTabforActivite(String var1) {
      this.tabforActivite = var1;
   }

   public String getTabforDepartement() {
      return this.tabforDepartement;
   }

   public void setTabforDepartement(String var1) {
      this.tabforDepartement = var1;
   }

   public String getTabforDossier() {
      return this.tabforDossier;
   }

   public void setTabforDossier(String var1) {
      this.tabforDossier = var1;
   }

   public String getTabforParc() {
      return this.tabforParc;
   }

   public void setTabforParc(String var1) {
      this.tabforParc = var1;
   }

   public String getTabforPdv() {
      return this.tabforPdv;
   }

   public void setTabforPdv(String var1) {
      this.tabforPdv = var1;
   }

   public String getTabforRegion() {
      return this.tabforRegion;
   }

   public void setTabforRegion(String var1) {
      this.tabforRegion = var1;
   }

   public String getTabforSecteur() {
      return this.tabforSecteur;
   }

   public void setTabforSecteur(String var1) {
      this.tabforSecteur = var1;
   }

   public String getTabforService() {
      return this.tabforService;
   }

   public void setTabforService(String var1) {
      this.tabforService = var1;
   }

   public String getTabforSite() {
      return this.tabforSite;
   }

   public void setTabforSite(String var1) {
      this.tabforSite = var1;
   }
}
