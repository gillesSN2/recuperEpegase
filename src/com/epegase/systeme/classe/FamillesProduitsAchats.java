package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class FamillesProduitsAchats implements Serializable {
   private long famachId;
   private String famachCode;
   private String famachOrigine;
   private Date famachDateCreation;
   private Date famachDateModif;
   private long famachUserCreation;
   private long famachUserModif;
   private String famachLibelleFr;
   private String famachLibelleUk;
   private String famachLibelleSp;
   private String famachTaxe;
   private String famachDouane;
   private String famachCompteLocal;
   private String famachCompteZone;
   private String famachCompteExterieur;
   private String famachCompteStock;
   private String famachCompteEncours;
   private String famachCompteCharge;
   private int famachStock;
   private String famachNature;
   private String famachLibNature;
   private int famachInactif;
   private int famachCat;
   private String famachAnal2;
   private String famachAnal4;
   private String famachBudget;
   private String famachActivite;
   private String famachDepotAch;
   private String famachDepotPrd;
   private String famachService;
   private String famachCle1;
   private String famachCle2;
   private String famachMarque;
   private String famachUnite;
   private int famachEchelle;
   private String famachCondition1;
   private String famachCondition2;
   private String famachCondition3;
   private String famachCondition4;
   private String famachCondition5;
   private float famachCoefValDefaut;
   private float famachCoefPrg;
   private float famachCoefFictif;
   private boolean famachLieeVte;
   private ExercicesAchats exercicesAchats;
   private boolean afficheImag;
   private String etat;
   private boolean inactif;
   private String libCat;
   private String libStock;
   private String espaceFamille;
   private boolean selectFamille;

   public boolean isSelectFamille() {
      return this.selectFamille;
   }

   public void setSelectFamille(boolean var1) {
      this.selectFamille = var1;
   }

   public String getEtat() {
      if (this.famachInactif == 1) {
         this.etat = "/images/desactiver.png";
      } else if (this.famachInactif == 2) {
         this.etat = "/images/supprimer.gif";
      }

      return this.etat;
   }

   public void setEtat(String var1) {
      this.etat = var1;
   }

   public boolean isInactif() {
      if (this.famachInactif != 1 && this.famachInactif != 2) {
         this.inactif = false;
      } else {
         this.inactif = true;
      }

      return this.inactif;
   }

   public void setInactif(boolean var1) {
      this.inactif = var1;
   }

   public String getLibCat() {
      if (this.famachCat == 0) {
         this.libCat = "Standard";
      } else if (this.famachCat == 1) {
         this.libCat = "Production";
      } else if (this.famachCat == 2) {
         this.libCat = "Consommables";
      } else if (this.famachCat == 3) {
         this.libCat = "Services";
      } else if (this.famachCat == 4) {
         this.libCat = "immobilisation";
      } else if (this.famachCat == 90) {
         this.libCat = "Standard/Famille";
      } else if (this.famachCat == 99) {
         this.libCat = "Famille";
      }

      return this.libCat;
   }

   public void setLibCat(String var1) {
      this.libCat = var1;
   }

   public String getLibStock() {
      if (this.famachCat == 99) {
         this.libStock = "";
      } else if (this.famachStock == 0) {
         this.libStock = "sans stock";
      } else if (this.famachStock == 1) {
         this.libStock = "stock simple";
      } else if (this.famachStock == 2) {
         this.libStock = "lifo";
      } else if (this.famachStock == 3) {
         this.libStock = "fifo";
      } else if (this.famachStock == 4) {
         this.libStock = "peremption";
      } else if (this.famachStock == 5) {
         this.libStock = "serialise ";
      } else if (this.famachStock == 6) {
         this.libStock = "consigne ";
      } else if (this.famachStock == 7) {
         this.libStock = "debours";
      }

      return this.libStock;
   }

   public void setLibStock(String var1) {
      this.libStock = var1;
   }

   public boolean isAfficheImag() {
      if (this.famachInactif != 1 && this.famachInactif != 2) {
         this.afficheImag = false;
      } else {
         this.afficheImag = true;
      }

      return this.afficheImag;
   }

   public void setAfficheImag(boolean var1) {
      this.afficheImag = var1;
   }

   public String getEspaceFamille() {
      if (this.famachCat != 90 && this.famachCat != 99) {
         this.espaceFamille = "";
      } else {
         this.espaceFamille = "font-weight:bold;text-align:center";
      }

      return this.espaceFamille;
   }

   public void setEspaceFamille(String var1) {
      this.espaceFamille = var1;
   }

   public ExercicesAchats getExercicesAchats() {
      return this.exercicesAchats;
   }

   public void setExercicesAchats(ExercicesAchats var1) {
      this.exercicesAchats = var1;
   }

   public String getFamachCompteCharge() {
      return this.famachCompteCharge;
   }

   public void setFamachCompteCharge(String var1) {
      this.famachCompteCharge = var1;
   }

   public String getFamachCompteExterieur() {
      return this.famachCompteExterieur;
   }

   public void setFamachCompteExterieur(String var1) {
      this.famachCompteExterieur = var1;
   }

   public String getFamachCompteLocal() {
      return this.famachCompteLocal;
   }

   public void setFamachCompteLocal(String var1) {
      this.famachCompteLocal = var1;
   }

   public String getFamachCompteStock() {
      return this.famachCompteStock;
   }

   public void setFamachCompteStock(String var1) {
      this.famachCompteStock = var1;
   }

   public String getFamachCompteZone() {
      return this.famachCompteZone;
   }

   public void setFamachCompteZone(String var1) {
      this.famachCompteZone = var1;
   }

   public Date getFamachDateCreation() {
      return this.famachDateCreation;
   }

   public void setFamachDateCreation(Date var1) {
      this.famachDateCreation = var1;
   }

   public Date getFamachDateModif() {
      return this.famachDateModif;
   }

   public void setFamachDateModif(Date var1) {
      this.famachDateModif = var1;
   }

   public String getFamachDouane() {
      return this.famachDouane;
   }

   public void setFamachDouane(String var1) {
      this.famachDouane = var1;
   }

   public long getFamachId() {
      return this.famachId;
   }

   public void setFamachId(long var1) {
      this.famachId = var1;
   }

   public String getFamachLibNature() {
      return this.famachLibNature;
   }

   public void setFamachLibNature(String var1) {
      this.famachLibNature = var1;
   }

   public String getFamachLibelleFr() {
      if (this.famachLibelleFr != null && !this.famachLibelleFr.isEmpty()) {
         this.famachLibelleFr = this.famachLibelleFr.toUpperCase();
      }

      return this.famachLibelleFr;
   }

   public void setFamachLibelleFr(String var1) {
      this.famachLibelleFr = var1;
   }

   public String getFamachLibelleSp() {
      return this.famachLibelleSp;
   }

   public void setFamachLibelleSp(String var1) {
      this.famachLibelleSp = var1;
   }

   public String getFamachLibelleUk() {
      return this.famachLibelleUk;
   }

   public void setFamachLibelleUk(String var1) {
      this.famachLibelleUk = var1;
   }

   public String getFamachNature() {
      return this.famachNature;
   }

   public void setFamachNature(String var1) {
      this.famachNature = var1;
   }

   public int getFamachStock() {
      return this.famachStock;
   }

   public void setFamachStock(int var1) {
      this.famachStock = var1;
   }

   public String getFamachTaxe() {
      return this.famachTaxe;
   }

   public void setFamachTaxe(String var1) {
      this.famachTaxe = var1;
   }

   public long getFamachUserCreation() {
      return this.famachUserCreation;
   }

   public void setFamachUserCreation(long var1) {
      this.famachUserCreation = var1;
   }

   public long getFamachUserModif() {
      return this.famachUserModif;
   }

   public void setFamachUserModif(long var1) {
      this.famachUserModif = var1;
   }

   public int getFamachInactif() {
      return this.famachInactif;
   }

   public void setFamachInactif(int var1) {
      this.famachInactif = var1;
   }

   public int getFamachCat() {
      return this.famachCat;
   }

   public void setFamachCat(int var1) {
      this.famachCat = var1;
   }

   public String getFamachActivite() {
      return this.famachActivite;
   }

   public void setFamachActivite(String var1) {
      this.famachActivite = var1;
   }

   public String getFamachAnal2() {
      return this.famachAnal2;
   }

   public void setFamachAnal2(String var1) {
      this.famachAnal2 = var1;
   }

   public String getFamachAnal4() {
      return this.famachAnal4;
   }

   public void setFamachAnal4(String var1) {
      this.famachAnal4 = var1;
   }

   public String getFamachBudget() {
      return this.famachBudget;
   }

   public void setFamachBudget(String var1) {
      this.famachBudget = var1;
   }

   public String getFamachCode() {
      if (this.famachCode != null && !this.famachCode.isEmpty()) {
         this.famachCode = this.famachCode.toUpperCase();
      }

      return this.famachCode;
   }

   public void setFamachCode(String var1) {
      this.famachCode = var1;
   }

   public String getFamachDepotAch() {
      return this.famachDepotAch;
   }

   public void setFamachDepotAch(String var1) {
      this.famachDepotAch = var1;
   }

   public String getFamachDepotPrd() {
      return this.famachDepotPrd;
   }

   public void setFamachDepotPrd(String var1) {
      this.famachDepotPrd = var1;
   }

   public String getFamachService() {
      return this.famachService;
   }

   public void setFamachService(String var1) {
      this.famachService = var1;
   }

   public String getFamachMarque() {
      return this.famachMarque;
   }

   public void setFamachMarque(String var1) {
      this.famachMarque = var1;
   }

   public String getFamachCondition1() {
      return this.famachCondition1;
   }

   public void setFamachCondition1(String var1) {
      this.famachCondition1 = var1;
   }

   public String getFamachCondition2() {
      return this.famachCondition2;
   }

   public void setFamachCondition2(String var1) {
      this.famachCondition2 = var1;
   }

   public String getFamachCondition3() {
      return this.famachCondition3;
   }

   public void setFamachCondition3(String var1) {
      this.famachCondition3 = var1;
   }

   public String getFamachCondition4() {
      return this.famachCondition4;
   }

   public void setFamachCondition4(String var1) {
      this.famachCondition4 = var1;
   }

   public String getFamachCondition5() {
      return this.famachCondition5;
   }

   public void setFamachCondition5(String var1) {
      this.famachCondition5 = var1;
   }

   public int getFamachEchelle() {
      return this.famachEchelle;
   }

   public void setFamachEchelle(int var1) {
      this.famachEchelle = var1;
   }

   public String getFamachUnite() {
      return this.famachUnite;
   }

   public void setFamachUnite(String var1) {
      this.famachUnite = var1;
   }

   public String getFamachCle1() {
      return this.famachCle1;
   }

   public void setFamachCle1(String var1) {
      this.famachCle1 = var1;
   }

   public String getFamachCle2() {
      return this.famachCle2;
   }

   public void setFamachCle2(String var1) {
      this.famachCle2 = var1;
   }

   public float getFamachCoefValDefaut() {
      return this.famachCoefValDefaut;
   }

   public void setFamachCoefValDefaut(float var1) {
      this.famachCoefValDefaut = var1;
   }

   public String getFamachCompteEncours() {
      return this.famachCompteEncours;
   }

   public void setFamachCompteEncours(String var1) {
      this.famachCompteEncours = var1;
   }

   public float getFamachCoefPrg() {
      return this.famachCoefPrg;
   }

   public void setFamachCoefPrg(float var1) {
      this.famachCoefPrg = var1;
   }

   public float getFamachCoefFictif() {
      return this.famachCoefFictif;
   }

   public void setFamachCoefFictif(float var1) {
      this.famachCoefFictif = var1;
   }

   public boolean isFamachLieeVte() {
      return this.famachLieeVte;
   }

   public void setFamachLieeVte(boolean var1) {
      this.famachLieeVte = var1;
   }

   public String getFamachOrigine() {
      return this.famachOrigine;
   }

   public void setFamachOrigine(String var1) {
      this.famachOrigine = var1;
   }
}
