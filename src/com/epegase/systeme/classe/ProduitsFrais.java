package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.Date;

public class ProduitsFrais implements Serializable {
   private long profrsId;
   private String profrsNum;
   private String profrsFeuille;
   private int profrsType;
   private int profrsCategorie;
   private String profrsMode;
   private int profrsNature;
   private int profrsReponse;
   private Date profrsDate;
   private int profrsOrdre;
   private String profrsRubrique;
   private String profrsCode;
   private String profrsProduit;
   private long profrsIdPro;
   private String profrsLibelle;
   private String profrsAffaire;
   private String profrsCmd;
   private long profrsIdCmd;
   private String profrsCot;
   private long profrsIdCot;
   private String profrsTranche;
   private String profrsTrancheA;
   private String profrsTrancheB;
   private String profrsTrancheC;
   private String profrsTrancheD;
   private String profrsTrancheE;
   private String profrsTrancheF;
   private String profrsFormuleA;
   private String profrsFormuleB;
   private String profrsFormuleC;
   private String profrsFormuleD;
   private String profrsFormuleE;
   private String profrsFormuleF;
   private double profrsValA;
   private double profrsValB;
   private double profrsValC;
   private double profrsValD;
   private double profrsValE;
   private double profrsValF;
   private double profrsValELocal;
   private int profrsColType;
   private double profrsPA;
   private double profrsFret;
   private double profrsFob;
   private double profrsAssurance;
   private String profrsDevise;
   private float profrsCoefDevise;
   private double profrsCaf;
   private int profrsExoDouane;
   private int profrsExoTva;
   private float profrsCoefPrp;
   private int profrsDecimalA;
   private int profrsDecimalB;
   private int profrsDecimalC;
   private int profrsDecimalD;
   private int profrsDecimalE;
   private int profrsDecimalF;
   private long profrsIdTransporteur;
   private String profrsNomTransporteur;
   private long profrsIdTransitaire;
   private String profrsNomTransitaire;
   private String libelle_type;
   private String stypeNature;
   private boolean varSaisieA;
   private boolean varSaisieB;
   private boolean varSaisieC;
   private boolean varSaisieD;
   private boolean varSaisieE;

   public boolean isVarSaisieA() {
      this.varSaisieA = false;
      if (this.profrsFormuleA != null && !this.profrsFormuleA.isEmpty() && this.profrsFormuleA.equals("VAR()")) {
         this.varSaisieA = true;
      }

      return this.varSaisieA;
   }

   public void setVarSaisieA(boolean var1) {
      this.varSaisieA = var1;
   }

   public boolean isVarSaisieB() {
      this.varSaisieB = false;
      if (this.profrsFormuleB != null && !this.profrsFormuleB.isEmpty() && this.profrsFormuleB.equals("VAR()")) {
         this.varSaisieB = true;
      }

      return this.varSaisieB;
   }

   public void setVarSaisieB(boolean var1) {
      this.varSaisieB = var1;
   }

   public boolean isVarSaisieC() {
      this.varSaisieC = false;
      if (this.profrsFormuleC != null && !this.profrsFormuleC.isEmpty() && this.profrsFormuleC.equals("VAR()")) {
         this.varSaisieC = true;
      }

      return this.varSaisieC;
   }

   public void setVarSaisieC(boolean var1) {
      this.varSaisieC = var1;
   }

   public boolean isVarSaisieD() {
      this.varSaisieD = false;
      if (this.profrsFormuleD != null && !this.profrsFormuleD.isEmpty() && this.profrsFormuleD.equals("VAR()")) {
         this.varSaisieD = true;
      }

      return this.varSaisieD;
   }

   public void setVarSaisieD(boolean var1) {
      this.varSaisieD = var1;
   }

   public boolean isVarSaisieE() {
      this.varSaisieE = false;
      if (this.profrsFormuleE != null && !this.profrsFormuleE.isEmpty() && this.profrsFormuleE.equals("VAR()")) {
         this.varSaisieE = true;
      }

      return this.varSaisieE;
   }

   public void setVarSaisieE(boolean var1) {
      this.varSaisieE = var1;
   }

   public String getLibelle_type() {
      if (this.profrsType == 0) {
         this.libelle_type = "Calcul sur Fiche Produit";
      } else if (this.profrsType == 1) {
         this.libelle_type = "Calcul sur Commande Achat";
      }

      return this.libelle_type;
   }

   public void setLibelle_type(String var1) {
      this.libelle_type = var1;
   }

   public String getStypeNature() {
      if (this.profrsColType == 0) {
         this.stypeNature = "font-style:normal;";
      } else if (this.profrsColType == 1) {
         this.stypeNature = "font-weight:bold;";
      } else if (this.profrsColType == 2) {
         this.stypeNature = "font-weight:bold;";
      } else if (this.profrsColType == 3) {
         this.stypeNature = "font-style:italic;";
      }

      return this.stypeNature;
   }

   public void setStypeNature(String var1) {
      this.stypeNature = var1;
   }

   public String getProfrsCode() {
      return this.profrsCode;
   }

   public void setProfrsCode(String var1) {
      this.profrsCode = var1;
   }

   public String getProfrsTranche() {
      return this.profrsTranche;
   }

   public void setProfrsTranche(String var1) {
      this.profrsTranche = var1;
   }

   public double getProfrsValA() {
      return this.profrsValA;
   }

   public void setProfrsValA(double var1) {
      this.profrsValA = var1;
   }

   public double getProfrsValB() {
      return this.profrsValB;
   }

   public void setProfrsValB(double var1) {
      this.profrsValB = var1;
   }

   public double getProfrsValC() {
      return this.profrsValC;
   }

   public void setProfrsValC(double var1) {
      this.profrsValC = var1;
   }

   public double getProfrsValD() {
      return this.profrsValD;
   }

   public void setProfrsValD(double var1) {
      this.profrsValD = var1;
   }

   public long getProfrsId() {
      return this.profrsId;
   }

   public void setProfrsId(long var1) {
      this.profrsId = var1;
   }

   public String getProfrsLibelle() {
      return this.profrsLibelle;
   }

   public void setProfrsLibelle(String var1) {
      this.profrsLibelle = var1;
   }

   public int getProfrsOrdre() {
      return this.profrsOrdre;
   }

   public void setProfrsOrdre(int var1) {
      this.profrsOrdre = var1;
   }

   public Date getProfrsDate() {
      return this.profrsDate;
   }

   public void setProfrsDate(Date var1) {
      this.profrsDate = var1;
   }

   public String getProfrsFeuille() {
      return this.profrsFeuille;
   }

   public void setProfrsFeuille(String var1) {
      this.profrsFeuille = var1;
   }

   public String getProfrsNum() {
      return this.profrsNum;
   }

   public void setProfrsNum(String var1) {
      this.profrsNum = var1;
   }

   public int getProfrsType() {
      return this.profrsType;
   }

   public void setProfrsType(int var1) {
      this.profrsType = var1;
   }

   public double getProfrsAssurance() {
      return this.profrsAssurance;
   }

   public void setProfrsAssurance(double var1) {
      this.profrsAssurance = var1;
   }

   public double getProfrsCaf() {
      return this.profrsCaf;
   }

   public void setProfrsCaf(double var1) {
      this.profrsCaf = var1;
   }

   public float getProfrsCoefDevise() {
      return this.profrsCoefDevise;
   }

   public void setProfrsCoefDevise(float var1) {
      this.profrsCoefDevise = var1;
   }

   public int getProfrsColType() {
      return this.profrsColType;
   }

   public void setProfrsColType(int var1) {
      this.profrsColType = var1;
   }

   public String getProfrsDevise() {
      return this.profrsDevise;
   }

   public void setProfrsDevise(String var1) {
      this.profrsDevise = var1;
   }

   public double getProfrsFret() {
      return this.profrsFret;
   }

   public void setProfrsFret(double var1) {
      this.profrsFret = var1;
   }

   public double getProfrsPA() {
      return this.profrsPA;
   }

   public void setProfrsPA(double var1) {
      this.profrsPA = var1;
   }

   public String getProfrsFormuleA() {
      return this.profrsFormuleA;
   }

   public void setProfrsFormuleA(String var1) {
      this.profrsFormuleA = var1;
   }

   public String getProfrsFormuleB() {
      return this.profrsFormuleB;
   }

   public void setProfrsFormuleB(String var1) {
      this.profrsFormuleB = var1;
   }

   public String getProfrsFormuleC() {
      return this.profrsFormuleC;
   }

   public void setProfrsFormuleC(String var1) {
      this.profrsFormuleC = var1;
   }

   public String getProfrsCmd() {
      return this.profrsCmd;
   }

   public void setProfrsCmd(String var1) {
      this.profrsCmd = var1;
   }

   public long getProfrsIdCmd() {
      return this.profrsIdCmd;
   }

   public void setProfrsIdCmd(long var1) {
      this.profrsIdCmd = var1;
   }

   public String getProfrsFormuleD() {
      return this.profrsFormuleD;
   }

   public void setProfrsFormuleD(String var1) {
      this.profrsFormuleD = var1;
   }

   public String getProfrsCot() {
      return this.profrsCot;
   }

   public void setProfrsCot(String var1) {
      this.profrsCot = var1;
   }

   public long getProfrsIdCot() {
      return this.profrsIdCot;
   }

   public void setProfrsIdCot(long var1) {
      this.profrsIdCot = var1;
   }

   public long getProfrsIdPro() {
      return this.profrsIdPro;
   }

   public void setProfrsIdPro(long var1) {
      this.profrsIdPro = var1;
   }

   public String getProfrsProduit() {
      return this.profrsProduit;
   }

   public void setProfrsProduit(String var1) {
      this.profrsProduit = var1;
   }

   public int getProfrsExoDouane() {
      return this.profrsExoDouane;
   }

   public void setProfrsExoDouane(int var1) {
      this.profrsExoDouane = var1;
   }

   public int getProfrsExoTva() {
      return this.profrsExoTva;
   }

   public void setProfrsExoTva(int var1) {
      this.profrsExoTva = var1;
   }

   public float getProfrsCoefPrp() {
      return this.profrsCoefPrp;
   }

   public void setProfrsCoefPrp(float var1) {
      this.profrsCoefPrp = var1;
   }

   public int getProfrsDecimalA() {
      return this.profrsDecimalA;
   }

   public void setProfrsDecimalA(int var1) {
      this.profrsDecimalA = var1;
   }

   public int getProfrsDecimalB() {
      return this.profrsDecimalB;
   }

   public void setProfrsDecimalB(int var1) {
      this.profrsDecimalB = var1;
   }

   public int getProfrsDecimalC() {
      return this.profrsDecimalC;
   }

   public void setProfrsDecimalC(int var1) {
      this.profrsDecimalC = var1;
   }

   public int getProfrsDecimalD() {
      return this.profrsDecimalD;
   }

   public void setProfrsDecimalD(int var1) {
      this.profrsDecimalD = var1;
   }

   public int getProfrsDecimalE() {
      return this.profrsDecimalE;
   }

   public void setProfrsDecimalE(int var1) {
      this.profrsDecimalE = var1;
   }

   public String getProfrsFormuleE() {
      return this.profrsFormuleE;
   }

   public void setProfrsFormuleE(String var1) {
      this.profrsFormuleE = var1;
   }

   public double getProfrsValE() {
      return this.profrsValE;
   }

   public void setProfrsValE(double var1) {
      this.profrsValE = var1;
   }

   public long getProfrsIdTransitaire() {
      return this.profrsIdTransitaire;
   }

   public void setProfrsIdTransitaire(long var1) {
      this.profrsIdTransitaire = var1;
   }

   public long getProfrsIdTransporteur() {
      return this.profrsIdTransporteur;
   }

   public void setProfrsIdTransporteur(long var1) {
      this.profrsIdTransporteur = var1;
   }

   public String getProfrsNomTransitaire() {
      return this.profrsNomTransitaire;
   }

   public void setProfrsNomTransitaire(String var1) {
      this.profrsNomTransitaire = var1;
   }

   public String getProfrsNomTransporteur() {
      return this.profrsNomTransporteur;
   }

   public void setProfrsNomTransporteur(String var1) {
      this.profrsNomTransporteur = var1;
   }

   public String getProfrsAffaire() {
      return this.profrsAffaire;
   }

   public void setProfrsAffaire(String var1) {
      this.profrsAffaire = var1;
   }

   public int getProfrsCategorie() {
      return this.profrsCategorie;
   }

   public void setProfrsCategorie(int var1) {
      this.profrsCategorie = var1;
   }

   public String getProfrsMode() {
      return this.profrsMode;
   }

   public void setProfrsMode(String var1) {
      this.profrsMode = var1;
   }

   public int getProfrsNature() {
      return this.profrsNature;
   }

   public void setProfrsNature(int var1) {
      this.profrsNature = var1;
   }

   public String getProfrsTrancheA() {
      return this.profrsTrancheA;
   }

   public void setProfrsTrancheA(String var1) {
      this.profrsTrancheA = var1;
   }

   public String getProfrsTrancheB() {
      return this.profrsTrancheB;
   }

   public void setProfrsTrancheB(String var1) {
      this.profrsTrancheB = var1;
   }

   public String getProfrsTrancheC() {
      return this.profrsTrancheC;
   }

   public void setProfrsTrancheC(String var1) {
      this.profrsTrancheC = var1;
   }

   public String getProfrsTrancheD() {
      return this.profrsTrancheD;
   }

   public void setProfrsTrancheD(String var1) {
      this.profrsTrancheD = var1;
   }

   public String getProfrsTrancheE() {
      return this.profrsTrancheE;
   }

   public void setProfrsTrancheE(String var1) {
      this.profrsTrancheE = var1;
   }

   public String getProfrsRubrique() {
      return this.profrsRubrique;
   }

   public void setProfrsRubrique(String var1) {
      this.profrsRubrique = var1;
   }

   public double getProfrsValELocal() {
      return this.profrsValELocal;
   }

   public void setProfrsValELocal(double var1) {
      this.profrsValELocal = var1;
   }

   public double getProfrsFob() {
      return this.profrsFob;
   }

   public void setProfrsFob(double var1) {
      this.profrsFob = var1;
   }

   public int getProfrsReponse() {
      return this.profrsReponse;
   }

   public void setProfrsReponse(int var1) {
      this.profrsReponse = var1;
   }

   public int getProfrsDecimalF() {
      return this.profrsDecimalF;
   }

   public void setProfrsDecimalF(int var1) {
      this.profrsDecimalF = var1;
   }

   public String getProfrsFormuleF() {
      return this.profrsFormuleF;
   }

   public void setProfrsFormuleF(String var1) {
      this.profrsFormuleF = var1;
   }

   public String getProfrsTrancheF() {
      return this.profrsTrancheF;
   }

   public void setProfrsTrancheF(String var1) {
      this.profrsTrancheF = var1;
   }

   public double getProfrsValF() {
      return this.profrsValF;
   }

   public void setProfrsValF(double var1) {
      this.profrsValF = var1;
   }
}
