package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FamillesProduitsVentes implements Serializable {
   private long famvteId;
   private Date famvteDateCreation;
   private Date famvteDateModif;
   private long famvteUserCreation;
   private long famvteUserModif;
   private String famvteLibelleFr;
   private String famvteLibelleUk;
   private String famvteLibelleSp;
   private String famvteCode;
   private String famvteOrigine;
   private String famvteTaxe;
   private String famvteDouane;
   private String famvteCompteLocal;
   private String famvteCompteNonTaxable;
   private String famvteCompteZone;
   private String famvteCompteExterieur;
   private String famvteCompteStock;
   private String famvteCompteProduit;
   private String famvteCompteCaisse;
   private int famvteCat;
   private String famvteNature;
   private String famvteLibNature;
   private int famvteInactif;
   private String famvteAnal2;
   private String famvteAnal4;
   private String famvteBudget;
   private String famvteActivite;
   private int famvteStock;
   private String famvteDepotVte;
   private String famvteService;
   private String famvteCle1;
   private String famvteCle2;
   private String famvteMarque;
   private float famvteCoefPv;
   private ExercicesVentes exerciceventes;
   private boolean afficheImag;
   private String etat;
   private String libCat;
   private String espaceFamille;
   private boolean selectFamille;

   public boolean isSelectFamille() {
      return this.selectFamille;
   }

   public void setSelectFamille(boolean var1) {
      this.selectFamille = var1;
   }

   public String getEtat() {
      if (this.famvteInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.famvteInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isAfficheImag() {
      if (this.famvteInactif != 1 && this.famvteInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getLibCat() {
      if (this.famvteCat == 0) {
         this.libCat = "Standard";
      } else if (this.famvteCat == 2) {
         this.libCat = "Consommables";
      } else if (this.famvteCat == 3) {
         this.libCat = "Services";
      } else if (this.famvteCat == 90) {
         this.libCat = "Standard/Famille";
      } else if (this.famvteCat == 99) {
         this.libCat = "Famille";
      }

      return this.libCat;
   }

   public void setLibCat(String var1) {
      this.libCat = var1;
   }

   public String getEspaceFamille() {
      if (this.famvteCat != 90 && this.famvteCat != 99) {
         this.espaceFamille = "";
      } else {
         this.espaceFamille = "font-weight:bold;text-align:center";
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public int getFamvteInactif() {
      return this.famvteInactif;
   }

   public void setFamvteInactif(int var1) {
      this.famvteInactif = var1;
   }

   public ExercicesVentes getExerciceventes() {
      return this.exerciceventes;
   }

   public void setExerciceventes(ExercicesVentes var1) {
      this.exerciceventes = var1;
   }

   public int getFamvteCat() {
      return this.famvteCat;
   }

   public void setFamvteCat(int var1) {
      this.famvteCat = var1;
   }

   public String getFamvteCompteProduit() {
      return this.famvteCompteProduit;
   }

   public void setFamvteCompteProduit(String var1) {
      this.famvteCompteProduit = var1;
   }

   public String getFamvteCompteExterieur() {
      return this.famvteCompteExterieur;
   }

   public void setFamvteCompteExterieur(String var1) {
      this.famvteCompteExterieur = var1;
   }

   public String getFamvteCompteLocal() {
      return this.famvteCompteLocal;
   }

   public void setFamvteCompteLocal(String var1) {
      this.famvteCompteLocal = var1;
   }

   public String getFamvteCompteStock() {
      return this.famvteCompteStock;
   }

   public void setFamvteCompteStock(String var1) {
      this.famvteCompteStock = var1;
   }

   public String getFamvteCompteZone() {
      return this.famvteCompteZone;
   }

   public void setFamvteCompteZone(String var1) {
      this.famvteCompteZone = var1;
   }

   public Date getFamvteDateCreation() {
      return this.famvteDateCreation;
   }

   public void setFamvteDateCreation(Date var1) {
      this.famvteDateCreation = var1;
   }

   public Date getFamvteDateModif() {
      return this.famvteDateModif;
   }

   public void setFamvteDateModif(Date var1) {
      this.famvteDateModif = var1;
   }

   public String getFamvteDouane() {
      return this.famvteDouane;
   }

   public void setFamvteDouane(String var1) {
      this.famvteDouane = var1;
   }

   public long getFamvteId() {
      return this.famvteId;
   }

   public void setFamvteId(long var1) {
      this.famvteId = var1;
   }

   public String getFamvteLibNature() {
      return this.famvteLibNature;
   }

   public void setFamvteLibNature(String var1) {
      this.famvteLibNature = var1;
   }

   public String getFamvteLibelleFr() {
      if (this.famvteLibelleFr != null && !this.famvteLibelleFr.isEmpty()) {
         this.famvteLibelleFr = this.famvteLibelleFr.toUpperCase();
      }

      return this.famvteLibelleFr;
   }

   public void setFamvteLibelleFr(String var1) {
      this.famvteLibelleFr = var1;
   }

   public String getFamvteLibelleSp() {
      return this.famvteLibelleSp;
   }

   public void setFamvteLibelleSp(String var1) {
      this.famvteLibelleSp = var1;
   }

   public String getFamvteLibelleUk() {
      return this.famvteLibelleUk;
   }

   public void setFamvteLibelleUk(String var1) {
      this.famvteLibelleUk = var1;
   }

   public String getFamvteNature() {
      return this.famvteNature;
   }

   public void setFamvteNature(String var1) {
      this.famvteNature = var1;
   }

   public String getFamvteTaxe() {
      return this.famvteTaxe;
   }

   public void setFamvteTaxe(String var1) {
      this.famvteTaxe = var1;
   }

   public long getFamvteUserCreation() {
      return this.famvteUserCreation;
   }

   public void setFamvteUserCreation(long var1) {
      this.famvteUserCreation = var1;
   }

   public long getFamvteUserModif() {
      return this.famvteUserModif;
   }

   public void setFamvteUserModif(long var1) {
      this.famvteUserModif = var1;
   }

   public String getFamvteCode() {
      if (this.famvteCode != null && !this.famvteCode.isEmpty()) {
         this.famvteCode = this.famvteCode.toUpperCase();
      }

      return this.famvteCode;
   }

   public void setFamvteCode(String var1) {
      this.famvteCode = var1;
   }

   public String getFamvteActivite() {
      return this.famvteActivite;
   }

   public void setFamvteActivite(String var1) {
      this.famvteActivite = var1;
   }

   public String getFamvteAnal2() {
      return this.famvteAnal2;
   }

   public void setFamvteAnal2(String var1) {
      this.famvteAnal2 = var1;
   }

   public String getFamvteAnal4() {
      return this.famvteAnal4;
   }

   public void setFamvteAnal4(String var1) {
      this.famvteAnal4 = var1;
   }

   public String getFamvteBudget() {
      return this.famvteBudget;
   }

   public void setFamvteBudget(String var1) {
      this.famvteBudget = var1;
   }

   public int getFamvteStock() {
      return this.famvteStock;
   }

   public void setFamvteStock(int var1) {
      this.famvteStock = var1;
   }

   public String getFamvteDepotVte() {
      return this.famvteDepotVte;
   }

   public void setFamvteDepotVte(String var1) {
      this.famvteDepotVte = var1;
   }

   public String getFamvteService() {
      return this.famvteService;
   }

   public void setFamvteService(String var1) {
      this.famvteService = var1;
   }

   public String getFamvteMarque() {
      return this.famvteMarque;
   }

   public void setFamvteMarque(String var1) {
      this.famvteMarque = var1;
   }

   public float getFamvteCoefPv() {
      return this.famvteCoefPv;
   }

   public void setFamvteCoefPv(float var1) {
      this.famvteCoefPv = var1;
   }

   public String getFamvteCle1() {
      return this.famvteCle1;
   }

   public void setFamvteCle1(String var1) {
      this.famvteCle1 = var1;
   }

   public String getFamvteCle2() {
      return this.famvteCle2;
   }

   public void setFamvteCle2(String var1) {
      this.famvteCle2 = var1;
   }

   public String getFamvteCompteNonTaxable() {
      return this.famvteCompteNonTaxable;
   }

   public void setFamvteCompteNonTaxable(String var1) {
      this.famvteCompteNonTaxable = var1;
   }

   public String getFamvteCompteCaisse() {
      return this.famvteCompteCaisse;
   }

   public void setFamvteCompteCaisse(String var1) {
      this.famvteCompteCaisse = var1;
   }

   public String getFamvteOrigine() {
      return this.famvteOrigine;
   }

   public void setFamvteOrigine(String var1) {
      this.famvteOrigine = var1;
   }
}
