package com.epegase.systeme.classe;

import java.io.Serializable;

public class ParcLocationLigne implements Serializable {
   private long prcllgId;
   private String prcllgCode;
   private int prcllgOrdre;
   private String prcllgDepot;
   private String prcllgFamille;
   private int prcllgPrintTexte;
   private String prcllgLibelle;
   private String prcllgReference;
   private String prcllgComplement;
   private String prcllgUnite;
   private String prcllgCondition;
   private String prcllgDescription;
   private String prcllgTaxe;
   private float prcllgTauxTaxe;
   private int prcllgEchelle;
   private float prcllgQte;
   private String prcllgCasier;
   private float prcllgLong;
   private float prcllgLarg;
   private float prcllgHaut;
   private float prcllgDiam;
   private float prcllgNb;
   private float prcllgPoidsNet;
   private float prcllgPoidsBrut;
   private float prcllgVolume;
   private float prcllgQteUtil;
   private int prcllgStock;
   private float prcllgQteStock;
   private double prcllgPu;
   private float prcllgTauxRemise;
   private double prcllgRabais;
   private double prcllgPuRem;
   private double prcllgPuTtc;
   private double prcllgPuRemTtc;
   private double prcllgPt;
   private double prcllgTva;
   private double prcllgTc;
   private double prcllgTtc;
   private double prcllgPump;
   private String prcllgGroupe;
   private int prcllgModeGroupe;
   private double prcllgTotal;
   private String prcllgObs;
   private ParcLocationEntete parcLocationEntete;
   private boolean verouCod;
   private String var_lib_uni_condit;
   private Unite unite = new Unite();
   private String styleLigne;
   private boolean var_choix_qte;

   public boolean isVar_choix_qte() {
      if (this.prcllgCondition != null && !this.prcllgCondition.isEmpty() && !this.prcllgCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public String getStyleLigne() {
      if (this.prcllgGroupe != null && !this.prcllgGroupe.isEmpty()) {
         this.styleLigne = "font-style:italic;font-size:7px;";
      } else {
         this.styleLigne = "font-style:normal;";
      }

      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.prcllgCondition != null && !this.prcllgCondition.isEmpty() && this.prcllgCondition.contains(":")) {
         if (this.prcllgDescription != null && !this.prcllgDescription.isEmpty()) {
            this.var_lib_uni_condit = this.prcllgDescription;
         } else if (this.prcllgCondition.contains("/")) {
            String[] var1 = this.prcllgCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.prcllgCondition;
         }
      } else if (this.prcllgCondition != null && !this.prcllgCondition.isEmpty() && !this.prcllgCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.prcllgCondition));
      } else if (this.prcllgUnite != null && !this.prcllgUnite.isEmpty()) {
         this.var_lib_uni_condit = this.prcllgUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public boolean isVerouCod() {
      return this.verouCod;
   }

   public void setVerouCod(boolean var1) {
      this.verouCod = var1;
   }

   public ParcLocationEntete getParcLocationEntete() {
      return this.parcLocationEntete;
   }

   public void setParcLocationEntete(ParcLocationEntete var1) {
      this.parcLocationEntete = var1;
   }

   public String getPrcllgCasier() {
      return this.prcllgCasier;
   }

   public void setPrcllgCasier(String var1) {
      this.prcllgCasier = var1;
   }

   public String getPrcllgCode() {
      return this.prcllgCode;
   }

   public void setPrcllgCode(String var1) {
      this.prcllgCode = var1;
   }

   public String getPrcllgCondition() {
      return this.prcllgCondition;
   }

   public void setPrcllgCondition(String var1) {
      this.prcllgCondition = var1;
   }

   public String getPrcllgDepot() {
      return this.prcllgDepot;
   }

   public void setPrcllgDepot(String var1) {
      this.prcllgDepot = var1;
   }

   public String getPrcllgDescription() {
      return this.prcllgDescription;
   }

   public void setPrcllgDescription(String var1) {
      this.prcllgDescription = var1;
   }

   public float getPrcllgDiam() {
      return this.prcllgDiam;
   }

   public void setPrcllgDiam(float var1) {
      this.prcllgDiam = var1;
   }

   public int getPrcllgEchelle() {
      return this.prcllgEchelle;
   }

   public void setPrcllgEchelle(int var1) {
      this.prcllgEchelle = var1;
   }

   public String getPrcllgFamille() {
      return this.prcllgFamille;
   }

   public void setPrcllgFamille(String var1) {
      this.prcllgFamille = var1;
   }

   public float getPrcllgHaut() {
      return this.prcllgHaut;
   }

   public void setPrcllgHaut(float var1) {
      this.prcllgHaut = var1;
   }

   public long getPrcllgId() {
      return this.prcllgId;
   }

   public void setPrcllgId(long var1) {
      this.prcllgId = var1;
   }

   public float getPrcllgLarg() {
      return this.prcllgLarg;
   }

   public void setPrcllgLarg(float var1) {
      this.prcllgLarg = var1;
   }

   public String getPrcllgLibelle() {
      return this.prcllgLibelle;
   }

   public void setPrcllgLibelle(String var1) {
      this.prcllgLibelle = var1;
   }

   public float getPrcllgLong() {
      return this.prcllgLong;
   }

   public void setPrcllgLong(float var1) {
      this.prcllgLong = var1;
   }

   public float getPrcllgNb() {
      return this.prcllgNb;
   }

   public void setPrcllgNb(float var1) {
      this.prcllgNb = var1;
   }

   public String getPrcllgObs() {
      return this.prcllgObs;
   }

   public void setPrcllgObs(String var1) {
      this.prcllgObs = var1;
   }

   public float getPrcllgPoidsBrut() {
      return this.prcllgPoidsBrut;
   }

   public void setPrcllgPoidsBrut(float var1) {
      this.prcllgPoidsBrut = var1;
   }

   public float getPrcllgPoidsNet() {
      return this.prcllgPoidsNet;
   }

   public void setPrcllgPoidsNet(float var1) {
      this.prcllgPoidsNet = var1;
   }

   public double getPrcllgPt() {
      return this.prcllgPt;
   }

   public void setPrcllgPt(double var1) {
      this.prcllgPt = var1;
   }

   public double getPrcllgPu() {
      return this.prcllgPu;
   }

   public void setPrcllgPu(double var1) {
      this.prcllgPu = var1;
   }

   public double getPrcllgPuRem() {
      return this.prcllgPuRem;
   }

   public void setPrcllgPuRem(double var1) {
      this.prcllgPuRem = var1;
   }

   public double getPrcllgPuRemTtc() {
      return this.prcllgPuRemTtc;
   }

   public void setPrcllgPuRemTtc(double var1) {
      this.prcllgPuRemTtc = var1;
   }

   public double getPrcllgPuTtc() {
      return this.prcllgPuTtc;
   }

   public void setPrcllgPuTtc(double var1) {
      this.prcllgPuTtc = var1;
   }

   public double getPrcllgPump() {
      return this.prcllgPump;
   }

   public void setPrcllgPump(double var1) {
      this.prcllgPump = var1;
   }

   public float getPrcllgQte() {
      return this.prcllgQte;
   }

   public void setPrcllgQte(float var1) {
      this.prcllgQte = var1;
   }

   public float getPrcllgQteStock() {
      return this.prcllgQteStock;
   }

   public void setPrcllgQteStock(float var1) {
      this.prcllgQteStock = var1;
   }

   public float getPrcllgQteUtil() {
      return this.prcllgQteUtil;
   }

   public void setPrcllgQteUtil(float var1) {
      this.prcllgQteUtil = var1;
   }

   public double getPrcllgRabais() {
      return this.prcllgRabais;
   }

   public void setPrcllgRabais(double var1) {
      this.prcllgRabais = var1;
   }

   public String getPrcllgReference() {
      return this.prcllgReference;
   }

   public void setPrcllgReference(String var1) {
      this.prcllgReference = var1;
   }

   public int getPrcllgStock() {
      return this.prcllgStock;
   }

   public void setPrcllgStock(int var1) {
      this.prcllgStock = var1;
   }

   public float getPrcllgTauxRemise() {
      return this.prcllgTauxRemise;
   }

   public void setPrcllgTauxRemise(float var1) {
      this.prcllgTauxRemise = var1;
   }

   public float getPrcllgTauxTaxe() {
      return this.prcllgTauxTaxe;
   }

   public void setPrcllgTauxTaxe(float var1) {
      this.prcllgTauxTaxe = var1;
   }

   public String getPrcllgTaxe() {
      return this.prcllgTaxe;
   }

   public void setPrcllgTaxe(String var1) {
      this.prcllgTaxe = var1;
   }

   public double getPrcllgTc() {
      return this.prcllgTc;
   }

   public void setPrcllgTc(double var1) {
      this.prcllgTc = var1;
   }

   public double getPrcllgTotal() {
      return this.prcllgTotal;
   }

   public void setPrcllgTotal(double var1) {
      this.prcllgTotal = var1;
   }

   public double getPrcllgTtc() {
      return this.prcllgTtc;
   }

   public void setPrcllgTtc(double var1) {
      this.prcllgTtc = var1;
   }

   public double getPrcllgTva() {
      return this.prcllgTva;
   }

   public void setPrcllgTva(double var1) {
      this.prcllgTva = var1;
   }

   public String getPrcllgUnite() {
      return this.prcllgUnite;
   }

   public void setPrcllgUnite(String var1) {
      this.prcllgUnite = var1;
   }

   public float getPrcllgVolume() {
      return this.prcllgVolume;
   }

   public void setPrcllgVolume(float var1) {
      this.prcllgVolume = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public String getPrcllgGroupe() {
      return this.prcllgGroupe;
   }

   public void setPrcllgGroupe(String var1) {
      this.prcllgGroupe = var1;
   }

   public int getPrcllgModeGroupe() {
      return this.prcllgModeGroupe;
   }

   public void setPrcllgModeGroupe(int var1) {
      this.prcllgModeGroupe = var1;
   }

   public int getPrcllgPrintTexte() {
      return this.prcllgPrintTexte;
   }

   public void setPrcllgPrintTexte(int var1) {
      this.prcllgPrintTexte = var1;
   }

   public String getPrcllgComplement() {
      return this.prcllgComplement;
   }

   public void setPrcllgComplement(String var1) {
      this.prcllgComplement = var1;
   }

   public int getPrcllgOrdre() {
      return this.prcllgOrdre;
   }

   public void setPrcllgOrdre(int var1) {
      this.prcllgOrdre = var1;
   }
}
