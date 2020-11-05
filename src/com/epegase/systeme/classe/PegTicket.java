package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class PegTicket implements Serializable {
   private long pegticId;
   private int pegticMode;
   private int pegticType;
   private int pegticEtat;
   private Date pegticDate;
   private long pegticIdStructure;
   private String pegticNomStructure;
   private long pegticIdUser;
   private String pegticNomUser;
   private String pegticMailUser;
   private String pegticModule;
   private String pegticSousModule;
   private String pegticEcran;
   private String pegticModele;
   private String pegticObject;
   private String pegticProbleme;
   private String pegticSuggestion;
   private long pegticIdIntervenant;
   private String pegticNomIntervenant;
   private String pegticMailIntervenant;
   private Date pegticDateReponse;
   private String pegticReponse;
   private String libelleEtat;
   private String libelleType;
   private String libelleMode;

   public String getLibelleEtat() {
      if (this.pegticEtat == 0) {
         this.libelleEtat = "En cours";
      } else if (this.pegticEtat == 1) {
         this.libelleEtat = "Reporté";
      } else if (this.pegticEtat == 2) {
         this.libelleEtat = "Suspendu";
      } else if (this.pegticEtat == 3) {
         this.libelleEtat = "Cloturé succès";
      } else if (this.pegticEtat == 4) {
         this.libelleEtat = "Cloturé échec";
      }

      return this.libelleEtat;
   }

   public void setLibelleEtat(String var1) {
      this.libelleEtat = var1;
   }

   public String getLibelleType() {
      if (this.pegticType == 0) {
         this.libelleType = "Nouvelle fonction";
      } else if (this.pegticType == 1) {
         this.libelleType = "Modification fonction";
      } else if (this.pegticType == 2) {
         this.libelleType = "Disfonctionnement";
      } else if (this.pegticType == 3) {
         this.libelleType = "Demande Formation";
      } else if (this.pegticType == 4) {
         this.libelleType = "Facturation";
      } else if (this.pegticType == 5) {
         this.libelleType = "Questions Commerciales";
      } else if (this.pegticType == 6) {
         this.libelleType = "Questions Administratives";
      }

      return this.libelleType;
   }

   public void setLibelleType(String var1) {
      this.libelleType = var1;
   }

   public String getLibelleMode() {
      if (this.pegticMode == 0) {
         this.libelleMode = "Sur Site";
      } else if (this.pegticMode == 1) {
         this.libelleMode = "Par Web";
      }

      return this.libelleMode;
   }

   public void setLibelleMode(String var1) {
      this.libelleMode = var1;
   }

   public Date getPegticDate() {
      return this.pegticDate;
   }

   public void setPegticDate(Date var1) {
      this.pegticDate = var1;
   }

   public String getPegticEcran() {
      return this.pegticEcran;
   }

   public void setPegticEcran(String var1) {
      this.pegticEcran = var1;
   }

   public int getPegticEtat() {
      return this.pegticEtat;
   }

   public void setPegticEtat(int var1) {
      this.pegticEtat = var1;
   }

   public long getPegticId() {
      return this.pegticId;
   }

   public void setPegticId(long var1) {
      this.pegticId = var1;
   }

   public long getPegticIdIntervenant() {
      return this.pegticIdIntervenant;
   }

   public void setPegticIdIntervenant(long var1) {
      this.pegticIdIntervenant = var1;
   }

   public long getPegticIdStructure() {
      return this.pegticIdStructure;
   }

   public void setPegticIdStructure(long var1) {
      this.pegticIdStructure = var1;
   }

   public long getPegticIdUser() {
      return this.pegticIdUser;
   }

   public void setPegticIdUser(long var1) {
      this.pegticIdUser = var1;
   }

   public String getPegticMailIntervenant() {
      return this.pegticMailIntervenant;
   }

   public void setPegticMailIntervenant(String var1) {
      this.pegticMailIntervenant = var1;
   }

   public String getPegticMailUser() {
      return this.pegticMailUser;
   }

   public void setPegticMailUser(String var1) {
      this.pegticMailUser = var1;
   }

   public String getPegticModele() {
      return this.pegticModele;
   }

   public void setPegticModele(String var1) {
      this.pegticModele = var1;
   }

   public String getPegticModule() {
      return this.pegticModule;
   }

   public void setPegticModule(String var1) {
      this.pegticModule = var1;
   }

   public String getPegticNomIntervenant() {
      return this.pegticNomIntervenant;
   }

   public void setPegticNomIntervenant(String var1) {
      this.pegticNomIntervenant = var1;
   }

   public String getPegticNomStructure() {
      return this.pegticNomStructure;
   }

   public void setPegticNomStructure(String var1) {
      this.pegticNomStructure = var1;
   }

   public String getPegticNomUser() {
      return this.pegticNomUser;
   }

   public void setPegticNomUser(String var1) {
      this.pegticNomUser = var1;
   }

   public String getPegticObject() {
      return this.pegticObject;
   }

   public void setPegticObject(String var1) {
      this.pegticObject = var1;
   }

   public String getPegticProbleme() {
      return this.pegticProbleme;
   }

   public void setPegticProbleme(String var1) {
      this.pegticProbleme = var1;
   }

   public String getPegticReponse() {
      return this.pegticReponse;
   }

   public void setPegticReponse(String var1) {
      this.pegticReponse = var1;
   }

   public String getPegticSuggestion() {
      return this.pegticSuggestion;
   }

   public void setPegticSuggestion(String var1) {
      this.pegticSuggestion = var1;
   }

   public int getPegticType() {
      return this.pegticType;
   }

   public void setPegticType(int var1) {
      this.pegticType = var1;
   }

   public int getPegticMode() {
      return this.pegticMode;
   }

   public void setPegticMode(int var1) {
      this.pegticMode = var1;
   }

   public Date getPegticDateReponse() {
      return this.pegticDateReponse;
   }

   public void setPegticDateReponse(Date var1) {
      this.pegticDateReponse = var1;
   }

   public String getPegticSousModule() {
      return this.pegticSousModule;
   }

   public void setPegticSousModule(String var1) {
      this.pegticSousModule = var1;
   }
}
