package com.epegase.systeme.classe;

import java.io.Serializable;

public class PegTabFormule implements Serializable {
   private long tabfor_id;
   private int tabforCol;
   private String tabforZone;
   private String tabforFormule;
   private int tabforSolde;
   private boolean tabforInactif;
   private int tabforPeriode;
   private PegTabElement pegTabElement;
   private String var_sens;
   private String lib_periode;

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
      if (this.tabforPeriode == 0) {
         this.lib_periode = "N";
      } else if (this.tabforPeriode == 20) {
         this.lib_periode = "N-1";
      } else if (this.tabforPeriode == 40) {
         this.lib_periode = "N-2";
      } else if (this.tabforPeriode == 60) {
         this.lib_periode = "N-3";
      } else if (this.tabforPeriode == 80) {
         this.lib_periode = "N-4";
      }

      return this.lib_periode;
   }

   public void setLib_periode(String var1) {
      this.lib_periode = var1;
   }

   public PegTabElement getPegTabElement() {
      return this.pegTabElement;
   }

   public void setPegTabElement(PegTabElement var1) {
      this.pegTabElement = var1;
   }

   public int getTabforCol() {
      return this.tabforCol;
   }

   public void setTabforCol(int var1) {
      this.tabforCol = var1;
   }

   public String getTabforFormule() {
      if (this.tabforFormule != null && !this.tabforFormule.isEmpty()) {
         this.tabforFormule = this.tabforFormule.toUpperCase();
      }

      return this.tabforFormule;
   }

   public void setTabforFormule(String var1) {
      this.tabforFormule = var1;
   }

   public boolean isTabforInactif() {
      return this.tabforInactif;
   }

   public void setTabforInactif(boolean var1) {
      this.tabforInactif = var1;
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

   public int getTabforPeriode() {
      return this.tabforPeriode;
   }

   public void setTabforPeriode(int var1) {
      this.tabforPeriode = var1;
   }
}
