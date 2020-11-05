package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class UsersChrono implements Serializable {
   private long usrchrId;
   private Date usrchrDateCreat;
   private Date usrchrDateModif;
   private long usrchrUserCreat;
   private long usrchrUserModif;
   private String usrchrSerie;
   private String usrchrLib;
   private int usrchrNature;
   private int usrchrValidation;
   private int usrchrDeValidation;
   private int usrchrDupplication;
   private int usrchrUpdate;
   private int usrchrPrive;
   private String usrchrPlafond;
   private String usrchrMode;
   private int usrchrExecution;
   private String usrchrCodeCaisse;
   private int usrchrModeCaisse;
   private int usrchrJournal;
   private Users users;
   private String lib_validation;
   private String lib_devalidation;
   private String lib_dupplication;
   private String lib_execution;
   private String lib_journal;
   private String lib_update;

   public Users getUsers() {
      return this.users;
   }

   public String getLib_journal() {
      if (this.usrchrNature == 60) {
         if (this.usrchrJournal == 0) {
            this.lib_journal = "Interdit";
         } else if (this.usrchrJournal == 1) {
            this.lib_journal = "Autorisé";
         }
      } else {
         this.lib_journal = "";
      }

      return this.lib_journal;
   }

   public void setLib_journal(String var1) {
      this.lib_journal = var1;
   }

   public String getLib_execution() {
      if (this.usrchrNature == 60) {
         if (this.usrchrExecution == 0) {
            this.lib_execution = "Interdit";
         } else if (this.usrchrExecution == 1) {
            this.lib_execution = "Autorisé";
         }
      } else {
         this.lib_execution = "";
      }

      return this.lib_execution;
   }

   public void setLib_execution(String var1) {
      this.lib_execution = var1;
   }

   public String getLib_dupplication() {
      if (this.usrchrDupplication == 0) {
         this.lib_dupplication = "Interdit";
      } else if (this.usrchrDupplication == 1) {
         this.lib_dupplication = "Autorisé";
      }

      return this.lib_dupplication;
   }

   public void setLib_dupplication(String var1) {
      this.lib_dupplication = var1;
   }

   public String getLib_devalidation() {
      if (this.usrchrDeValidation == 0) {
         this.lib_devalidation = "Interdit";
      } else if (this.usrchrDeValidation == 1) {
         this.lib_devalidation = "Autorisé";
      }

      return this.lib_devalidation;
   }

   public void setLib_devalidation(String var1) {
      this.lib_devalidation = var1;
   }

   public String getLib_validation() {
      if (this.usrchrValidation == 0) {
         this.lib_validation = "Enregistrement";
      } else if (this.usrchrValidation == 1) {
         this.lib_validation = "Impression";
      } else if (this.usrchrValidation == 2) {
         this.lib_validation = "Bouton";
      } else if (this.usrchrValidation == 3) {
         this.lib_validation = "Interdit";
      } else if (this.usrchrValidation == 4) {
         this.lib_validation = "Enreg.+Paiement";
      }

      return this.lib_validation;
   }

   public void setLib_validation(String var1) {
      this.lib_validation = var1;
   }

   public String getLib_update() {
      if (this.usrchrUpdate == 0) {
         if (this.usrchrNature != 19 && this.usrchrNature != 29 && this.usrchrNature != 79) {
            this.lib_update = "Autorisé";
         } else {
            this.lib_update = "Maj simple";
         }
      } else if (this.usrchrUpdate == 1) {
         this.lib_update = "Interdit";
      } else if (this.usrchrUpdate == 2) {
         this.lib_update = "Maj + Annulation";
      } else if (this.usrchrUpdate == 3) {
         this.lib_update = "Maj + Suppression";
      } else if (this.usrchrUpdate == 4) {
         this.lib_update = "Maj + Ann.+ Sup.";
      }

      return this.lib_update;
   }

   public void setLib_update(String var1) {
      this.lib_update = var1;
   }

   public void setUsers(Users var1) {
      this.users = var1;
   }

   public Date getUsrchrDateCreat() {
      return this.usrchrDateCreat;
   }

   public void setUsrchrDateCreat(Date var1) {
      this.usrchrDateCreat = var1;
   }

   public Date getUsrchrDateModif() {
      return this.usrchrDateModif;
   }

   public void setUsrchrDateModif(Date var1) {
      this.usrchrDateModif = var1;
   }

   public long getUsrchrId() {
      return this.usrchrId;
   }

   public void setUsrchrId(long var1) {
      this.usrchrId = var1;
   }

   public String getUsrchrLib() {
      return this.usrchrLib;
   }

   public void setUsrchrLib(String var1) {
      this.usrchrLib = var1;
   }

   public String getUsrchrSerie() {
      return this.usrchrSerie;
   }

   public void setUsrchrSerie(String var1) {
      this.usrchrSerie = var1;
   }

   public long getUsrchrUserCreat() {
      return this.usrchrUserCreat;
   }

   public void setUsrchrUserCreat(long var1) {
      this.usrchrUserCreat = var1;
   }

   public long getUsrchrUserModif() {
      return this.usrchrUserModif;
   }

   public void setUsrchrUserModif(long var1) {
      this.usrchrUserModif = var1;
   }

   public int getUsrchrNature() {
      return this.usrchrNature;
   }

   public void setUsrchrNature(int var1) {
      this.usrchrNature = var1;
   }

   public int getUsrchrDeValidation() {
      return this.usrchrDeValidation;
   }

   public void setUsrchrDeValidation(int var1) {
      this.usrchrDeValidation = var1;
   }

   public int getUsrchrDupplication() {
      return this.usrchrDupplication;
   }

   public void setUsrchrDupplication(int var1) {
      this.usrchrDupplication = var1;
   }

   public int getUsrchrValidation() {
      return this.usrchrValidation;
   }

   public void setUsrchrValidation(int var1) {
      this.usrchrValidation = var1;
   }

   public int getUsrchrUpdate() {
      return this.usrchrUpdate;
   }

   public void setUsrchrUpdate(int var1) {
      this.usrchrUpdate = var1;
   }

   public int getUsrchrPrive() {
      return this.usrchrPrive;
   }

   public void setUsrchrPrive(int var1) {
      this.usrchrPrive = var1;
   }

   public String getUsrchrMode() {
      return this.usrchrMode;
   }

   public void setUsrchrMode(String var1) {
      this.usrchrMode = var1;
   }

   public String getUsrchrPlafond() {
      return this.usrchrPlafond;
   }

   public void setUsrchrPlafond(String var1) {
      this.usrchrPlafond = var1;
   }

   public int getUsrchrExecution() {
      return this.usrchrExecution;
   }

   public void setUsrchrExecution(int var1) {
      this.usrchrExecution = var1;
   }

   public String getUsrchrCodeCaisse() {
      return this.usrchrCodeCaisse;
   }

   public void setUsrchrCodeCaisse(String var1) {
      this.usrchrCodeCaisse = var1;
   }

   public int getUsrchrModeCaisse() {
      return this.usrchrModeCaisse;
   }

   public void setUsrchrModeCaisse(int var1) {
      this.usrchrModeCaisse = var1;
   }

   public int getUsrchrJournal() {
      return this.usrchrJournal;
   }

   public void setUsrchrJournal(int var1) {
      this.usrchrJournal = var1;
   }
}
