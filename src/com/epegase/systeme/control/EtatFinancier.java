package com.epegase.systeme.control;

import java.io.Serializable;

public class EtatFinancier implements Serializable {
   private String NumCol = "";
   private String nomCol = "";
   private String libPeriodeCol = "";
   private int periodeCol;
   private int TypeCol = 0;
   private String libTypeCol;
   private int formatResultat = 0;

   public String calculLibPeriode(int var1) {
      this.getLibPeriodeCol();
      return this.libPeriodeCol;
   }

   public String getLibPeriodeCol() {
      if (this.periodeCol == 0) {
         this.libPeriodeCol = "N";
      } else if (this.periodeCol == 1) {
         this.libPeriodeCol = "N Janvier";
      } else if (this.periodeCol == 2) {
         this.libPeriodeCol = "N Février";
      } else if (this.periodeCol == 3) {
         this.libPeriodeCol = "N Mars";
      } else if (this.periodeCol == 4) {
         this.libPeriodeCol = "N Avril";
      } else if (this.periodeCol == 5) {
         this.libPeriodeCol = "N Mai";
      } else if (this.periodeCol == 6) {
         this.libPeriodeCol = "N Juin";
      } else if (this.periodeCol == 7) {
         this.libPeriodeCol = "N Juillet";
      } else if (this.periodeCol == 8) {
         this.libPeriodeCol = "N Aout";
      } else if (this.periodeCol == 9) {
         this.libPeriodeCol = "N Septembre";
      } else if (this.periodeCol == 10) {
         this.libPeriodeCol = "N Octobre";
      } else if (this.periodeCol == 11) {
         this.libPeriodeCol = "N Novembre";
      } else if (this.periodeCol == 12) {
         this.libPeriodeCol = "N Décembre";
      } else if (this.periodeCol == 13) {
         this.libPeriodeCol = "N 1er trimestre";
      } else if (this.periodeCol == 14) {
         this.libPeriodeCol = "N 2eme trimestre";
      } else if (this.periodeCol == 15) {
         this.libPeriodeCol = "N 3eme trimestre";
      } else if (this.periodeCol == 16) {
         this.libPeriodeCol = "N 4eme trimestre";
      } else if (this.periodeCol == 17) {
         this.libPeriodeCol = "N 1er semestre";
      } else if (this.periodeCol == 18) {
         this.libPeriodeCol = "N 2eme semestre";
      } else if (this.periodeCol == 19) {
         this.libPeriodeCol = "N (Année Complète)";
      } else if (this.periodeCol == 20) {
         this.libPeriodeCol = "N-1";
      } else if (this.periodeCol == 21) {
         this.libPeriodeCol = "N-1 Janvier";
      } else if (this.periodeCol == 22) {
         this.libPeriodeCol = "N-1 Février";
      } else if (this.periodeCol == 23) {
         this.libPeriodeCol = "N-1 Mars";
      } else if (this.periodeCol == 24) {
         this.libPeriodeCol = "N-1 Avril";
      } else if (this.periodeCol == 25) {
         this.libPeriodeCol = "N-1 Mai";
      } else if (this.periodeCol == 26) {
         this.libPeriodeCol = "N-1 Juin";
      } else if (this.periodeCol == 27) {
         this.libPeriodeCol = "N-1 Juillet";
      } else if (this.periodeCol == 28) {
         this.libPeriodeCol = "N-1 Aout";
      } else if (this.periodeCol == 29) {
         this.libPeriodeCol = "N-1 Septembre";
      } else if (this.periodeCol == 30) {
         this.libPeriodeCol = "N-1 Octobre";
      } else if (this.periodeCol == 31) {
         this.libPeriodeCol = "N-1 Novembre";
      } else if (this.periodeCol == 32) {
         this.libPeriodeCol = "N-1 Décembre";
      } else if (this.periodeCol == 33) {
         this.libPeriodeCol = "N-1 1er trimestre";
      } else if (this.periodeCol == 34) {
         this.libPeriodeCol = "N-1 2eme trimestre";
      } else if (this.periodeCol == 35) {
         this.libPeriodeCol = "N-1 3eme trimestre";
      } else if (this.periodeCol == 36) {
         this.libPeriodeCol = "N-1 4eme trimestre";
      } else if (this.periodeCol == 37) {
         this.libPeriodeCol = "N-1 1er semestre";
      } else if (this.periodeCol == 38) {
         this.libPeriodeCol = "N-1 2eme semestre";
      } else if (this.periodeCol == 39) {
         this.libPeriodeCol = "N-1 (Année Complète)";
      } else if (this.periodeCol == 40) {
         this.libPeriodeCol = "N-2";
      } else if (this.periodeCol == 41) {
         this.libPeriodeCol = "N-2 Janvier";
      } else if (this.periodeCol == 42) {
         this.libPeriodeCol = "N-2 Février";
      } else if (this.periodeCol == 43) {
         this.libPeriodeCol = "N-2 Mars";
      } else if (this.periodeCol == 44) {
         this.libPeriodeCol = "N-2 Avril";
      } else if (this.periodeCol == 45) {
         this.libPeriodeCol = "N-2 Mai";
      } else if (this.periodeCol == 46) {
         this.libPeriodeCol = "N-2 Juin";
      } else if (this.periodeCol == 47) {
         this.libPeriodeCol = "N-2 Juillet";
      } else if (this.periodeCol == 48) {
         this.libPeriodeCol = "N-2 Aout";
      } else if (this.periodeCol == 49) {
         this.libPeriodeCol = "N-2 Septembre";
      } else if (this.periodeCol == 50) {
         this.libPeriodeCol = "N-2 Octobre";
      } else if (this.periodeCol == 51) {
         this.libPeriodeCol = "N-2 Novembre";
      } else if (this.periodeCol == 52) {
         this.libPeriodeCol = "N-2 Décembre";
      } else if (this.periodeCol == 53) {
         this.libPeriodeCol = "N-2 1er trimestre";
      } else if (this.periodeCol == 54) {
         this.libPeriodeCol = "N-2 2eme trimestre";
      } else if (this.periodeCol == 55) {
         this.libPeriodeCol = "N-2 3eme trimestre";
      } else if (this.periodeCol == 56) {
         this.libPeriodeCol = "N-2 4eme trimestre";
      } else if (this.periodeCol == 57) {
         this.libPeriodeCol = "N-2 1er semestre";
      } else if (this.periodeCol == 58) {
         this.libPeriodeCol = "N-2 2eme semestre";
      } else if (this.periodeCol == 59) {
         this.libPeriodeCol = "N-2 (Année Complète)";
      } else if (this.periodeCol == 60) {
         this.libPeriodeCol = "N-3";
      } else if (this.periodeCol == 61) {
         this.libPeriodeCol = "N-3 Janvier";
      } else if (this.periodeCol == 62) {
         this.libPeriodeCol = "N-3 Février";
      } else if (this.periodeCol == 63) {
         this.libPeriodeCol = "N-3 Mars";
      } else if (this.periodeCol == 64) {
         this.libPeriodeCol = "N-3 Avril";
      } else if (this.periodeCol == 65) {
         this.libPeriodeCol = "N-3 Mai";
      } else if (this.periodeCol == 66) {
         this.libPeriodeCol = "N-3 Juin";
      } else if (this.periodeCol == 67) {
         this.libPeriodeCol = "N-3 Juillet";
      } else if (this.periodeCol == 68) {
         this.libPeriodeCol = "N-3 Aout";
      } else if (this.periodeCol == 69) {
         this.libPeriodeCol = "N-3 Septembre";
      } else if (this.periodeCol == 70) {
         this.libPeriodeCol = "N-3 Octobre";
      } else if (this.periodeCol == 71) {
         this.libPeriodeCol = "N-3 Novembre";
      } else if (this.periodeCol == 72) {
         this.libPeriodeCol = "N-3 Décembre";
      } else if (this.periodeCol == 73) {
         this.libPeriodeCol = "N-3 1er trimestre";
      } else if (this.periodeCol == 74) {
         this.libPeriodeCol = "N-3 2eme trimestre";
      } else if (this.periodeCol == 75) {
         this.libPeriodeCol = "N-3 3eme trimestre";
      } else if (this.periodeCol == 76) {
         this.libPeriodeCol = "N-3 4eme trimestre";
      } else if (this.periodeCol == 77) {
         this.libPeriodeCol = "N-3 1er semestre";
      } else if (this.periodeCol == 78) {
         this.libPeriodeCol = "N-3 2eme semestre";
      } else if (this.periodeCol == 79) {
         this.libPeriodeCol = "N-3 (Année Complète)";
      } else if (this.periodeCol == 80) {
         this.libPeriodeCol = "N-4";
      } else if (this.periodeCol == 81) {
         this.libPeriodeCol = "N-4 Janvier";
      } else if (this.periodeCol == 82) {
         this.libPeriodeCol = "N-4 Février";
      } else if (this.periodeCol == 83) {
         this.libPeriodeCol = "N-4 Mars";
      } else if (this.periodeCol == 84) {
         this.libPeriodeCol = "N-4 Avril";
      } else if (this.periodeCol == 85) {
         this.libPeriodeCol = "N-4 Mai";
      } else if (this.periodeCol == 86) {
         this.libPeriodeCol = "N-4 Juin";
      } else if (this.periodeCol == 87) {
         this.libPeriodeCol = "N-4 Juillet";
      } else if (this.periodeCol == 88) {
         this.libPeriodeCol = "N-4 Aout";
      } else if (this.periodeCol == 89) {
         this.libPeriodeCol = "N-4 Septembre";
      } else if (this.periodeCol == 80) {
         this.libPeriodeCol = "N-4 Octobre";
      } else if (this.periodeCol == 81) {
         this.libPeriodeCol = "N-4 Novembre";
      } else if (this.periodeCol == 82) {
         this.libPeriodeCol = "N-4 Décembre";
      } else if (this.periodeCol == 83) {
         this.libPeriodeCol = "N-4 1er trimestre";
      } else if (this.periodeCol == 84) {
         this.libPeriodeCol = "N-4 2eme trimestre";
      } else if (this.periodeCol == 85) {
         this.libPeriodeCol = "N-4 3eme trimestre";
      } else if (this.periodeCol == 86) {
         this.libPeriodeCol = "N-4 4eme trimestre";
      } else if (this.periodeCol == 87) {
         this.libPeriodeCol = "N-4 1er semestre";
      } else if (this.periodeCol == 88) {
         this.libPeriodeCol = "N-4 2eme semestre";
      } else if (this.periodeCol == 89) {
         this.libPeriodeCol = "N-4 (Année Complète)";
      }

      return this.libPeriodeCol;
   }

   public void setLibPeriodeCol(String var1) {
      this.libPeriodeCol = var1;
   }

   public String getLibTypeCol() {
      if (this.TypeCol == 0) {
         this.libTypeCol = "P";
      } else if (this.TypeCol == 7) {
         this.libTypeCol = "M";
      } else if (this.TypeCol == 8) {
         this.libTypeCol = "G";
      }

      return this.libTypeCol;
   }

   public void setLibTypeCol(String var1) {
      this.libTypeCol = var1;
   }

   public String getNomCol() {
      return this.nomCol;
   }

   public void setNomCol(String var1) {
      this.nomCol = var1;
   }

   public String getNumCol() {
      return this.NumCol;
   }

   public void setNumCol(String var1) {
      this.NumCol = var1;
   }

   public int getPeriodeCol() {
      return this.periodeCol;
   }

   public void setPeriodeCol(int var1) {
      this.periodeCol = var1;
   }

   public int getTypeCol() {
      return this.TypeCol;
   }

   public void setTypeCol(int var1) {
      this.TypeCol = var1;
   }

   public int getFormatResultat() {
      return this.formatResultat;
   }

   public void setFormatResultat(int var1) {
      this.formatResultat = var1;
   }
}
