package com.epegase.systeme.classe;

import java.io.Serializable;

public class CptTabFormule implements Serializable {
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
   private int tabforTypeReglement;
   private int tabforSens;
   private int tabforNature;
   private int tabforCategorie;
   private String tabforCpteDest;
   private String tabforNatureSalarie;
   private String tabforFeuilleSalarie;
   private int tabforEtatSalarie;
   private int tabforTypeSalarie;
   private String tabforClassementSalarie;
   private CptTabElement cptTabElement;
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
      if (this.tabforFormule != null && !this.tabforFormule.isEmpty() && (this.tabforFormule.contains("COMPTE") || this.tabforFormule.contains("RUBRIQUE")) || this.tabforBudget != null && !this.tabforBudget.isEmpty() || this.tabforAnalytique != null && !this.tabforAnalytique.isEmpty()) {
         if (this.tabforPeriode == 0) {
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
         } else if (this.tabforPeriode == 60) {
            this.lib_periode = "N-3";
         } else if (this.tabforPeriode == 61) {
            this.lib_periode = "N-3 Janvier";
         } else if (this.tabforPeriode == 62) {
            this.lib_periode = "N-3 Février";
         } else if (this.tabforPeriode == 63) {
            this.lib_periode = "N-3 Mars";
         } else if (this.tabforPeriode == 64) {
            this.lib_periode = "N-3 Avril";
         } else if (this.tabforPeriode == 65) {
            this.lib_periode = "N-3 Mai";
         } else if (this.tabforPeriode == 66) {
            this.lib_periode = "N-3 Juin";
         } else if (this.tabforPeriode == 67) {
            this.lib_periode = "N-3 Juillet";
         } else if (this.tabforPeriode == 68) {
            this.lib_periode = "N-3 Aout";
         } else if (this.tabforPeriode == 69) {
            this.lib_periode = "N-3 Septembre";
         } else if (this.tabforPeriode == 70) {
            this.lib_periode = "N-3 Octobre";
         } else if (this.tabforPeriode == 71) {
            this.lib_periode = "N-3 Novembre";
         } else if (this.tabforPeriode == 72) {
            this.lib_periode = "N-3 Décembre";
         } else if (this.tabforPeriode == 73) {
            this.lib_periode = "N-3 1er Trimestre";
         } else if (this.tabforPeriode == 74) {
            this.lib_periode = "N-3 2eme Trimestre";
         } else if (this.tabforPeriode == 75) {
            this.lib_periode = "N-3 3eme Trimestre";
         } else if (this.tabforPeriode == 76) {
            this.lib_periode = "N-3 4eme Trimestre";
         } else if (this.tabforPeriode == 77) {
            this.lib_periode = "N-3 1er Semestre";
         } else if (this.tabforPeriode == 78) {
            this.lib_periode = "N-3 2eme Semestre";
         } else if (this.tabforPeriode == 79) {
            this.lib_periode = "N-3 (Année complète)";
         } else if (this.tabforPeriode == 80) {
            this.lib_periode = "N-4";
         } else if (this.tabforPeriode == 81) {
            this.lib_periode = "N-4 Janvier";
         } else if (this.tabforPeriode == 82) {
            this.lib_periode = "N-4 Février";
         } else if (this.tabforPeriode == 83) {
            this.lib_periode = "N-4 Mars";
         } else if (this.tabforPeriode == 84) {
            this.lib_periode = "N-4 Avril";
         } else if (this.tabforPeriode == 85) {
            this.lib_periode = "N-4 Mai";
         } else if (this.tabforPeriode == 86) {
            this.lib_periode = "N-4 Juin";
         } else if (this.tabforPeriode == 87) {
            this.lib_periode = "N-4 Juillet";
         } else if (this.tabforPeriode == 88) {
            this.lib_periode = "N-4 Aout";
         } else if (this.tabforPeriode == 89) {
            this.lib_periode = "N-4 Septembre";
         } else if (this.tabforPeriode == 90) {
            this.lib_periode = "N-4 Octobre";
         } else if (this.tabforPeriode == 91) {
            this.lib_periode = "N-4 Novembre";
         } else if (this.tabforPeriode == 92) {
            this.lib_periode = "N-4 Décembre";
         } else if (this.tabforPeriode == 93) {
            this.lib_periode = "N-4 1er Trimestre";
         } else if (this.tabforPeriode == 94) {
            this.lib_periode = "N-4 2eme Trimestre";
         } else if (this.tabforPeriode == 95) {
            this.lib_periode = "N-4 3eme Trimestre";
         } else if (this.tabforPeriode == 96) {
            this.lib_periode = "N-4 4eme Trimestre";
         } else if (this.tabforPeriode == 97) {
            this.lib_periode = "N-4 1er Semestre";
         } else if (this.tabforPeriode == 98) {
            this.lib_periode = "N-4 2eme Semestre";
         } else if (this.tabforPeriode == 99) {
            this.lib_periode = "N-4 (Année complète)";
         }
      } else {
         this.lib_periode = "";
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

   public CptTabElement getCptTabElement() {
      return this.cptTabElement;
   }

   public void setCptTabElement(CptTabElement var1) {
      this.cptTabElement = var1;
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

   public int getTabforSens() {
      return this.tabforSens;
   }

   public void setTabforSens(int var1) {
      this.tabforSens = var1;
   }

   public int getTabforTypeReglement() {
      return this.tabforTypeReglement;
   }

   public void setTabforTypeReglement(int var1) {
      this.tabforTypeReglement = var1;
   }

   public String getTabforCpteDest() {
      return this.tabforCpteDest;
   }

   public void setTabforCpteDest(String var1) {
      this.tabforCpteDest = var1;
   }

   public int getTabforNature() {
      return this.tabforNature;
   }

   public void setTabforNature(int var1) {
      this.tabforNature = var1;
   }

   public int getTabforCategorie() {
      return this.tabforCategorie;
   }

   public void setTabforCategorie(int var1) {
      this.tabforCategorie = var1;
   }

   public String getTabforFeuilleSalarie() {
      return this.tabforFeuilleSalarie;
   }

   public void setTabforFeuilleSalarie(String var1) {
      this.tabforFeuilleSalarie = var1;
   }

   public String getTabforNatureSalarie() {
      return this.tabforNatureSalarie;
   }

   public void setTabforNatureSalarie(String var1) {
      this.tabforNatureSalarie = var1;
   }

   public String getTabforClassementSalarie() {
      return this.tabforClassementSalarie;
   }

   public void setTabforClassementSalarie(String var1) {
      this.tabforClassementSalarie = var1;
   }

   public int getTabforEtatSalarie() {
      return this.tabforEtatSalarie;
   }

   public void setTabforEtatSalarie(int var1) {
      this.tabforEtatSalarie = var1;
   }

   public int getTabforTypeSalarie() {
      return this.tabforTypeSalarie;
   }

   public void setTabforTypeSalarie(int var1) {
      this.tabforTypeSalarie = var1;
   }
}
