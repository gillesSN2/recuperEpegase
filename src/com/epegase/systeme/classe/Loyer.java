package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class Loyer implements Serializable {
   private long loyId;
   private Date loyDateCreat;
   private Date loyDateModif;
   private long loyUserCreat;
   private long loyUserModif;
   private String loyNumBail;
   private String loyCompteTiers;
   private String loyLibCompteTiers;
   private String loyNumContribuable;
   private int loyCategorie;
   private int loyType = 0;
   private String loyCompteLoyer;
   private String loyLibCompteLoyer;
   private String loyCompteTaxe;
   private String loyLibCompteTaxe;
   private String loyCompteImpot;
   private String loyLibCompteImpot;
   private Date loyDateDebut;
   private Date loyDateFin;
   private String loyDescription;
   private String loyAdresse;
   private String loyUsage;
   private int loyMode;
   private double loyMontantNet;
   private int loyTypeTaxe;
   private float loyTauxTaxe;
   private int loyTypeImpot;
   private float loyTauxImpot;
   private double loyMontantBrut;
   private double loyMontantTaxe;
   private double loyMontantImpot;
   private int loyInactif;
   private String loyActiviteCode;
   private String loyActiviteLib;
   private String loySiteCode;
   private String loySiteLib;
   private String loyDepartementCode;
   private String loyDepartementLib;
   private String loyServiceCode;
   private String loyServiceLib;
   private String loyRegionCode;
   private String loyRegionLib;
   private String loySecteurCode;
   private String loySecteurLib;
   private String loyPdvCode;
   private String loyPdvLib;
   private String loyDossierCode;
   private String loyDossierLib;
   private String loyMissionCode;
   private String loyMissionLib;
   private String loyParcCode;
   private String loyParcLib;
   private String loyCle1Code;
   private String loyCle1Lib;
   private String loyAgentCode;
   private String loyAgentLib;
   private String loyBudgetCode;
   private String loyBudgetLib;
   private ExercicesComptable exercicescomptable;
   private String etat;
   private boolean inactif;
   private String type;
   private String mode;

   public String getEtat() {
      if (this.loyInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.loyInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.loyInactif != 1 && this.loyInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public String getMode() {
      if (this.loyMode == 0) {
         this.mode = "mensuel";
      } else if (this.loyMode == 1) {
         this.mode = "trimestiel";
      } else if (this.loyMode == 2) {
         this.mode = "semestriel";
      } else if (this.loyMode == 3) {
         this.mode = "annuel";
      }

      return this.mode;
   }

   public void setMode(String var1) {
      this.mode = var1;
   }

   public String getType() {
      if (this.loyType == 0) {
         this.type = "versé";
      } else if (this.loyType == 1) {
         this.type = "encaissé";
      }

      return this.type;
   }

   public void setType(String var1) {
      this.type = var1;
   }

   public ExercicesComptable getExercicescomptable() {
      return this.exercicescomptable;
   }

   public void setExercicescomptable(ExercicesComptable var1) {
      this.exercicescomptable = var1;
   }

   public String getLoyBudgetCode() {
      return this.loyBudgetCode;
   }

   public void setLoyBudgetCode(String var1) {
      this.loyBudgetCode = var1;
   }

   public String getLoyBudgetLib() {
      return this.loyBudgetLib;
   }

   public void setLoyBudgetLib(String var1) {
      this.loyBudgetLib = var1;
   }

   public int getLoyCategorie() {
      return this.loyCategorie;
   }

   public void setLoyCategorie(int var1) {
      this.loyCategorie = var1;
   }

   public String getLoyCompteImpot() {
      return this.loyCompteImpot;
   }

   public void setLoyCompteImpot(String var1) {
      this.loyCompteImpot = var1;
   }

   public String getLoyCompteLoyer() {
      return this.loyCompteLoyer;
   }

   public void setLoyCompteLoyer(String var1) {
      this.loyCompteLoyer = var1;
   }

   public String getLoyCompteTaxe() {
      return this.loyCompteTaxe;
   }

   public void setLoyCompteTaxe(String var1) {
      this.loyCompteTaxe = var1;
   }

   public String getLoyCompteTiers() {
      return this.loyCompteTiers;
   }

   public void setLoyCompteTiers(String var1) {
      this.loyCompteTiers = var1;
   }

   public Date getLoyDateCreat() {
      return this.loyDateCreat;
   }

   public void setLoyDateCreat(Date var1) {
      this.loyDateCreat = var1;
   }

   public Date getLoyDateDebut() {
      return this.loyDateDebut;
   }

   public void setLoyDateDebut(Date var1) {
      this.loyDateDebut = var1;
   }

   public Date getLoyDateFin() {
      return this.loyDateFin;
   }

   public void setLoyDateFin(Date var1) {
      this.loyDateFin = var1;
   }

   public Date getLoyDateModif() {
      return this.loyDateModif;
   }

   public void setLoyDateModif(Date var1) {
      this.loyDateModif = var1;
   }

   public String getLoyDepartementCode() {
      return this.loyDepartementCode;
   }

   public void setLoyDepartementCode(String var1) {
      this.loyDepartementCode = var1;
   }

   public String getLoyDepartementLib() {
      return this.loyDepartementLib;
   }

   public void setLoyDepartementLib(String var1) {
      this.loyDepartementLib = var1;
   }

   public String getLoyDescription() {
      return this.loyDescription;
   }

   public void setLoyDescription(String var1) {
      this.loyDescription = var1;
   }

   public long getLoyId() {
      return this.loyId;
   }

   public void setLoyId(long var1) {
      this.loyId = var1;
   }

   public int getLoyInactif() {
      return this.loyInactif;
   }

   public void setLoyInactif(int var1) {
      this.loyInactif = var1;
   }

   public String getLoyLibCompteImpot() {
      return this.loyLibCompteImpot;
   }

   public void setLoyLibCompteImpot(String var1) {
      this.loyLibCompteImpot = var1;
   }

   public String getLoyLibCompteLoyer() {
      return this.loyLibCompteLoyer;
   }

   public void setLoyLibCompteLoyer(String var1) {
      this.loyLibCompteLoyer = var1;
   }

   public String getLoyLibCompteTaxe() {
      return this.loyLibCompteTaxe;
   }

   public void setLoyLibCompteTaxe(String var1) {
      this.loyLibCompteTaxe = var1;
   }

   public String getLoyLibCompteTiers() {
      return this.loyLibCompteTiers;
   }

   public void setLoyLibCompteTiers(String var1) {
      this.loyLibCompteTiers = var1;
   }

   public int getLoyMode() {
      return this.loyMode;
   }

   public void setLoyMode(int var1) {
      this.loyMode = var1;
   }

   public double getLoyMontantBrut() {
      return this.loyMontantBrut;
   }

   public void setLoyMontantBrut(double var1) {
      this.loyMontantBrut = var1;
   }

   public double getLoyMontantImpot() {
      return this.loyMontantImpot;
   }

   public void setLoyMontantImpot(double var1) {
      this.loyMontantImpot = var1;
   }

   public double getLoyMontantNet() {
      return this.loyMontantNet;
   }

   public void setLoyMontantNet(double var1) {
      this.loyMontantNet = var1;
   }

   public double getLoyMontantTaxe() {
      return this.loyMontantTaxe;
   }

   public void setLoyMontantTaxe(double var1) {
      this.loyMontantTaxe = var1;
   }

   public String getLoyNumBail() {
      return this.loyNumBail;
   }

   public void setLoyNumBail(String var1) {
      this.loyNumBail = var1;
   }

   public String getLoyNumContribuable() {
      return this.loyNumContribuable;
   }

   public void setLoyNumContribuable(String var1) {
      this.loyNumContribuable = var1;
   }

   public String getLoyPdvCode() {
      return this.loyPdvCode;
   }

   public void setLoyPdvCode(String var1) {
      this.loyPdvCode = var1;
   }

   public String getLoyPdvLib() {
      return this.loyPdvLib;
   }

   public void setLoyPdvLib(String var1) {
      this.loyPdvLib = var1;
   }

   public String getLoyRegionCode() {
      return this.loyRegionCode;
   }

   public void setLoyRegionCode(String var1) {
      this.loyRegionCode = var1;
   }

   public String getLoyRegionLib() {
      return this.loyRegionLib;
   }

   public void setLoyRegionLib(String var1) {
      this.loyRegionLib = var1;
   }

   public String getLoySecteurCode() {
      return this.loySecteurCode;
   }

   public void setLoySecteurCode(String var1) {
      this.loySecteurCode = var1;
   }

   public String getLoySecteurLib() {
      return this.loySecteurLib;
   }

   public void setLoySecteurLib(String var1) {
      this.loySecteurLib = var1;
   }

   public String getLoyServiceCode() {
      return this.loyServiceCode;
   }

   public void setLoyServiceCode(String var1) {
      this.loyServiceCode = var1;
   }

   public String getLoyServiceLib() {
      return this.loyServiceLib;
   }

   public void setLoyServiceLib(String var1) {
      this.loyServiceLib = var1;
   }

   public String getLoySiteCode() {
      return this.loySiteCode;
   }

   public void setLoySiteCode(String var1) {
      this.loySiteCode = var1;
   }

   public String getLoySiteLib() {
      return this.loySiteLib;
   }

   public void setLoySiteLib(String var1) {
      this.loySiteLib = var1;
   }

   public float getLoyTauxImpot() {
      return this.loyTauxImpot;
   }

   public void setLoyTauxImpot(float var1) {
      this.loyTauxImpot = var1;
   }

   public float getLoyTauxTaxe() {
      return this.loyTauxTaxe;
   }

   public void setLoyTauxTaxe(float var1) {
      this.loyTauxTaxe = var1;
   }

   public int getLoyType() {
      return this.loyType;
   }

   public void setLoyType(int var1) {
      this.loyType = var1;
   }

   public int getLoyTypeImpot() {
      return this.loyTypeImpot;
   }

   public void setLoyTypeImpot(int var1) {
      this.loyTypeImpot = var1;
   }

   public int getLoyTypeTaxe() {
      return this.loyTypeTaxe;
   }

   public void setLoyTypeTaxe(int var1) {
      this.loyTypeTaxe = var1;
   }

   public String getLoyUsage() {
      return this.loyUsage;
   }

   public void setLoyUsage(String var1) {
      this.loyUsage = var1;
   }

   public long getLoyUserCreat() {
      return this.loyUserCreat;
   }

   public void setLoyUserCreat(long var1) {
      this.loyUserCreat = var1;
   }

   public long getLoyUserModif() {
      return this.loyUserModif;
   }

   public void setLoyUserModif(long var1) {
      this.loyUserModif = var1;
   }

   public String getLoyCle1Code() {
      return this.loyCle1Code;
   }

   public void setLoyCle1Code(String var1) {
      this.loyCle1Code = var1;
   }

   public String getLoyCle1Lib() {
      return this.loyCle1Lib;
   }

   public void setLoyCle1Lib(String var1) {
      this.loyCle1Lib = var1;
   }

   public String getLoyDossierCode() {
      return this.loyDossierCode;
   }

   public void setLoyDossierCode(String var1) {
      this.loyDossierCode = var1;
   }

   public String getLoyDossierLib() {
      return this.loyDossierLib;
   }

   public void setLoyDossierLib(String var1) {
      this.loyDossierLib = var1;
   }

   public String getLoyMissionCode() {
      return this.loyMissionCode;
   }

   public void setLoyMissionCode(String var1) {
      this.loyMissionCode = var1;
   }

   public String getLoyMissionLib() {
      return this.loyMissionLib;
   }

   public void setLoyMissionLib(String var1) {
      this.loyMissionLib = var1;
   }

   public String getLoyParcCode() {
      return this.loyParcCode;
   }

   public void setLoyParcCode(String var1) {
      this.loyParcCode = var1;
   }

   public String getLoyParcLib() {
      return this.loyParcLib;
   }

   public void setLoyParcLib(String var1) {
      this.loyParcLib = var1;
   }

   public String getLoyActiviteCode() {
      return this.loyActiviteCode;
   }

   public void setLoyActiviteCode(String var1) {
      this.loyActiviteCode = var1;
   }

   public String getLoyActiviteLib() {
      return this.loyActiviteLib;
   }

   public void setLoyActiviteLib(String var1) {
      this.loyActiviteLib = var1;
   }

   public String getLoyAgentCode() {
      return this.loyAgentCode;
   }

   public void setLoyAgentCode(String var1) {
      this.loyAgentCode = var1;
   }

   public String getLoyAgentLib() {
      return this.loyAgentLib;
   }

   public void setLoyAgentLib(String var1) {
      this.loyAgentLib = var1;
   }

   public String getLoyAdresse() {
      return this.loyAdresse;
   }

   public void setLoyAdresse(String var1) {
      this.loyAdresse = var1;
   }
}
