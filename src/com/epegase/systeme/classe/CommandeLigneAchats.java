package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommandeLigneAchats implements Serializable {
   private long cmdligId;
   private int cmdligOrdre;
   private long cmdligIdDa;
   private long cmdligIdCot;
   private String cmdligCode;
   private String cmdligBudgetPoste;
   private String cmdligFamille;
   private String cmdligLibelle;
   private String cmdligLibelleFournisseur;
   private String cmdligComplement;
   private String cmdligReference;
   private String cmdligTaxe;
   private float cmdligTauxTaxe;
   private String cmdligUnite;
   private int cmdligStock;
   private String cmdligCondition;
   private String cmdligDescription;
   private int cmdligEchelle;
   private float cmdligQte;
   private float cmdligLong;
   private float cmdligLarg;
   private float cmdligHaut;
   private float cmdligDiam;
   private float cmdligNb;
   private float cmdligPoidsNet;
   private float cmdligPoidsBrut;
   private float cmdligVolume;
   private float cmdligQteUtil;
   private String cmdligDepot;
   private float cmdligQteStock;
   private float cmdligQteCmd;
   private float cmdligQteLivree;
   private String cmdligDevise;
   private double cmdligPu;
   private float cmdligTauxRemise;
   private double cmdligRabais;
   private double cmdligPuRem;
   private double cmdligPtDev;
   private double cmdligPt;
   private double cmdligTva;
   private double cmdligTc;
   private double cmdligTtc;
   private double cmdligPr;
   private double cmdligPump;
   private String cmdligDouane;
   private float cmdligTauxDouane;
   private int cmdligMode;
   private float cmdligGr;
   private String cmdligCouleur;
   private double cmdligFob;
   private double cmdligFret;
   private double cmdligAssurance;
   private double cmdligFinancier;
   private double cmdligT1;
   private double cmdligT3;
   private double cmdligT5;
   private double cmdligT10;
   private double cmdligT30;
   private double cmdligT31;
   private double cmdligT46;
   private double cmdligT53;
   private double cmdligFrais;
   private double cmdligPrKg;
   private double cmdligPrU;
   private double cmdligPrUTtc;
   private CommandeEnteteAchats commandeEnteteAchats;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private boolean taxable;
   private boolean remisabe;
   private boolean rabeable;
   private boolean verouCod;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private double autreTaxe;
   private String format;
   private float var_qteRestante;
   private String familleStyle;
   private String codeProduit;
   private String libelleProsduit;

   public String getCodeProduit() {
      if (this.cmdligReference != null && !this.cmdligReference.isEmpty()) {
         this.codeProduit = this.cmdligReference;
      } else {
         this.codeProduit = this.cmdligCode;
      }

      return this.codeProduit;
   }

   public void setCodeProduit(String var1) {
      this.codeProduit = var1;
   }

   public String getLibelleProsduit() {
      if (this.cmdligLibelleFournisseur != null && !this.cmdligLibelleFournisseur.isEmpty()) {
         this.libelleProsduit = this.cmdligLibelleFournisseur;
      } else {
         this.libelleProsduit = this.cmdligLibelle;
      }

      return this.libelleProsduit;
   }

   public void setLibelleProsduit(String var1) {
      this.libelleProsduit = var1;
   }

   public String getFamilleStyle() {
      return this.familleStyle;
   }

   public void setFamilleStyle(String var1) {
      this.familleStyle = var1;
   }

   public float getVar_qteRestante() {
      if (this.cmdligId != 0L) {
         this.var_qteRestante = this.cmdligQteUtil - this.cmdligQteLivree;
      } else {
         this.var_qteRestante = 0.0F;
      }

      return this.var_qteRestante;
   }

   public void setVar_qteRestante(float var1) {
      this.var_qteRestante = var1;
   }

   public String getFormat() {
      if (this.cmdligMode == 0) {
         this.format = this.cmdligHaut + "x" + this.cmdligLong;
      } else {
         this.format = "" + this.cmdligLarg;
      }

      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public double getAutreTaxe() {
      this.autreTaxe = this.cmdligT46 + this.cmdligT53;
      return this.autreTaxe;
   }

   public void setAutreTaxe(double var1) {
      this.autreTaxe = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.cmdligCondition != null && !this.cmdligCondition.isEmpty() && this.cmdligCondition.contains(":")) {
         if (this.cmdligDescription != null && !this.cmdligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.cmdligDescription;
         } else if (this.cmdligCondition.contains("/")) {
            String[] var1 = this.cmdligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.cmdligCondition;
         }
      } else if (this.cmdligCondition == null || this.cmdligCondition.isEmpty() || this.cmdligCondition.contains(":")) {
         if (this.cmdligUnite != null && !this.cmdligUnite.isEmpty()) {
            this.var_lib_uni_condit = this.cmdligUnite;
         } else {
            this.var_lib_uni_condit = "";
         }
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public String getCmdligCode() {
      return this.cmdligCode;
   }

   public void setCmdligCode(String var1) {
      this.cmdligCode = var1;
   }

   public String getCmdligDevise() {
      return this.cmdligDevise;
   }

   public void setCmdligDevise(String var1) {
      this.cmdligDevise = var1;
   }

   public String getCmdligFamille() {
      return this.cmdligFamille;
   }

   public void setCmdligFamille(String var1) {
      this.cmdligFamille = var1;
   }

   public long getCmdligId() {
      return this.cmdligId;
   }

   public void setCmdligId(long var1) {
      this.cmdligId = var1;
   }

   public String getCmdligLibelle() {
      return this.cmdligLibelle;
   }

   public void setCmdligLibelle(String var1) {
      this.cmdligLibelle = var1;
   }

   public double getCmdligPt() {
      return this.cmdligPt;
   }

   public void setCmdligPt(double var1) {
      this.cmdligPt = var1;
   }

   public double getCmdligPu() {
      return this.cmdligPu;
   }

   public void setCmdligPu(double var1) {
      this.cmdligPu = var1;
   }

   public double getCmdligPuRem() {
      return this.cmdligPuRem;
   }

   public void setCmdligPuRem(double var1) {
      this.cmdligPuRem = var1;
   }

   public float getCmdligQte() {
      return this.cmdligQte;
   }

   public void setCmdligQte(float var1) {
      this.cmdligQte = var1;
   }

   public float getCmdligQteStock() {
      return this.cmdligQteStock;
   }

   public void setCmdligQteStock(float var1) {
      this.cmdligQteStock = var1;
   }

   public double getCmdligRabais() {
      return this.cmdligRabais;
   }

   public void setCmdligRabais(double var1) {
      this.cmdligRabais = var1;
   }

   public String getCmdligReference() {
      return this.cmdligReference;
   }

   public void setCmdligReference(String var1) {
      this.cmdligReference = var1;
   }

   public float getCmdligTauxRemise() {
      return this.cmdligTauxRemise;
   }

   public void setCmdligTauxRemise(float var1) {
      this.cmdligTauxRemise = var1;
   }

   public float getCmdligTauxTaxe() {
      return this.cmdligTauxTaxe;
   }

   public void setCmdligTauxTaxe(float var1) {
      this.cmdligTauxTaxe = var1;
   }

   public String getCmdligTaxe() {
      return this.cmdligTaxe;
   }

   public void setCmdligTaxe(String var1) {
      this.cmdligTaxe = var1;
   }

   public double getCmdligTc() {
      return this.cmdligTc;
   }

   public void setCmdligTc(double var1) {
      this.cmdligTc = var1;
   }

   public double getCmdligTtc() {
      return this.cmdligTtc;
   }

   public void setCmdligTtc(double var1) {
      this.cmdligTtc = var1;
   }

   public double getCmdligTva() {
      return this.cmdligTva;
   }

   public void setCmdligTva(double var1) {
      this.cmdligTva = var1;
   }

   public String getCmdligUnite() {
      return this.cmdligUnite;
   }

   public void setCmdligUnite(String var1) {
      this.cmdligUnite = var1;
   }

   public CommandeEnteteAchats getCommandeEnteteAchats() {
      return this.commandeEnteteAchats;
   }

   public void setCommandeEnteteAchats(CommandeEnteteAchats var1) {
      this.commandeEnteteAchats = var1;
   }

   public long getCmdligIdCot() {
      return this.cmdligIdCot;
   }

   public void setCmdligIdCot(long var1) {
      this.cmdligIdCot = var1;
   }

   public long getCmdligIdDa() {
      return this.cmdligIdDa;
   }

   public void setCmdligIdDa(long var1) {
      this.cmdligIdDa = var1;
   }

   public double getCmdligPr() {
      return this.cmdligPr;
   }

   public void setCmdligPr(double var1) {
      this.cmdligPr = var1;
   }

   public double getCmdligPump() {
      return this.cmdligPump;
   }

   public void setCmdligPump(double var1) {
      this.cmdligPump = var1;
   }

   public boolean isTaxable() {
      if (!"".equalsIgnoreCase(this.cmdligCode) && this.cmdligCode != null) {
         this.taxable = true;
      } else {
         this.taxable = false;
      }

      return this.taxable;
   }

   public void setTaxable(boolean var1) {
      this.taxable = var1;
   }

   public boolean isRabeable() {
      if ((double)this.cmdligTauxRemise != 0.0D) {
         this.rabeable = true;
      } else {
         this.rabeable = false;
      }

      return this.rabeable;
   }

   public void setRabeable(boolean var1) {
      this.rabeable = var1;
   }

   public boolean isRemisabe() {
      if (this.cmdligRabais != 0.0D) {
         this.remisabe = true;
      } else {
         this.remisabe = false;
      }

      return this.remisabe;
   }

   public void setRemisabe(boolean var1) {
      this.remisabe = var1;
   }

   public boolean isVerouCod() {
      if (this.cmdligId != 0L) {
         this.verouCod = true;
      } else {
         this.verouCod = false;
      }

      return this.verouCod;
   }

   public void setVerouCod(boolean var1) {
      this.verouCod = var1;
   }

   public float getVar_qteDejaTrf() {
      return this.var_qteDejaTrf;
   }

   public void setVar_qteDejaTrf(float var1) {
      this.var_qteDejaTrf = var1;
   }

   public float getVar_qteReliquat() {
      return this.var_qteReliquat;
   }

   public void setVar_qteReliquat(float var1) {
      this.var_qteReliquat = var1;
   }

   public String getCmdligCondition() {
      return this.cmdligCondition;
   }

   public void setCmdligCondition(String var1) {
      this.cmdligCondition = var1;
   }

   public float getCmdligDiam() {
      return this.cmdligDiam;
   }

   public void setCmdligDiam(float var1) {
      this.cmdligDiam = var1;
   }

   public float getCmdligHaut() {
      return this.cmdligHaut;
   }

   public void setCmdligHaut(float var1) {
      this.cmdligHaut = var1;
   }

   public float getCmdligLarg() {
      return this.cmdligLarg;
   }

   public void setCmdligLarg(float var1) {
      this.cmdligLarg = var1;
   }

   public float getCmdligLong() {
      return this.cmdligLong;
   }

   public void setCmdligLong(float var1) {
      this.cmdligLong = var1;
   }

   public float getCmdligNb() {
      return this.cmdligNb;
   }

   public void setCmdligNb(float var1) {
      this.cmdligNb = var1;
   }

   public float getCmdligQteUtil() {
      return this.cmdligQteUtil;
   }

   public void setCmdligQteUtil(float var1) {
      this.cmdligQteUtil = var1;
   }

   public float getCmdligPoidsBrut() {
      return this.cmdligPoidsBrut;
   }

   public void setCmdligPoidsBrut(float var1) {
      this.cmdligPoidsBrut = var1;
   }

   public float getCmdligPoidsNet() {
      return this.cmdligPoidsNet;
   }

   public void setCmdligPoidsNet(float var1) {
      this.cmdligPoidsNet = var1;
   }

   public float getCmdligVolume() {
      return this.cmdligVolume;
   }

   public void setCmdligVolume(float var1) {
      this.cmdligVolume = var1;
   }

   public String getVar_depotLigne() {
      return this.var_depotLigne;
   }

   public void setVar_depotLigne(String var1) {
      this.var_depotLigne = var1;
   }

   public List getVar_listDepotItem() {
      return this.var_listDepotItem;
   }

   public void setVar_listDepotItem(List var1) {
      this.var_listDepotItem = var1;
   }

   public String getCmdligDepot() {
      return this.cmdligDepot;
   }

   public void setCmdligDepot(String var1) {
      this.cmdligDepot = var1;
   }

   public int getCmdligStock() {
      return this.cmdligStock;
   }

   public void setCmdligStock(int var1) {
      this.cmdligStock = var1;
   }

   public int getCmdligEchelle() {
      return this.cmdligEchelle;
   }

   public void setCmdligEchelle(int var1) {
      this.cmdligEchelle = var1;
   }

   public String getCmdligDescription() {
      return this.cmdligDescription;
   }

   public void setCmdligDescription(String var1) {
      this.cmdligDescription = var1;
   }

   public double getCmdligAssurance() {
      return this.cmdligAssurance;
   }

   public void setCmdligAssurance(double var1) {
      this.cmdligAssurance = var1;
   }

   public String getCmdligCouleur() {
      return this.cmdligCouleur;
   }

   public void setCmdligCouleur(String var1) {
      this.cmdligCouleur = var1;
   }

   public String getCmdligDouane() {
      return this.cmdligDouane;
   }

   public void setCmdligDouane(String var1) {
      this.cmdligDouane = var1;
   }

   public double getCmdligFob() {
      return this.cmdligFob;
   }

   public void setCmdligFob(double var1) {
      this.cmdligFob = var1;
   }

   public double getCmdligFret() {
      return this.cmdligFret;
   }

   public void setCmdligFret(double var1) {
      this.cmdligFret = var1;
   }

   public float getCmdligGr() {
      return this.cmdligGr;
   }

   public void setCmdligGr(float var1) {
      this.cmdligGr = var1;
   }

   public int getCmdligMode() {
      return this.cmdligMode;
   }

   public void setCmdligMode(int var1) {
      this.cmdligMode = var1;
   }

   public double getCmdligPtDev() {
      return this.cmdligPtDev;
   }

   public void setCmdligPtDev(double var1) {
      this.cmdligPtDev = var1;
   }

   public double getCmdligT1() {
      return this.cmdligT1;
   }

   public void setCmdligT1(double var1) {
      this.cmdligT1 = var1;
   }

   public double getCmdligT10() {
      return this.cmdligT10;
   }

   public void setCmdligT10(double var1) {
      this.cmdligT10 = var1;
   }

   public double getCmdligT3() {
      return this.cmdligT3;
   }

   public void setCmdligT3(double var1) {
      this.cmdligT3 = var1;
   }

   public double getCmdligT30() {
      return this.cmdligT30;
   }

   public void setCmdligT30(double var1) {
      this.cmdligT30 = var1;
   }

   public double getCmdligT31() {
      return this.cmdligT31;
   }

   public void setCmdligT31(double var1) {
      this.cmdligT31 = var1;
   }

   public double getCmdligT5() {
      return this.cmdligT5;
   }

   public void setCmdligT5(double var1) {
      this.cmdligT5 = var1;
   }

   public float getCmdligTauxDouane() {
      return this.cmdligTauxDouane;
   }

   public void setCmdligTauxDouane(float var1) {
      this.cmdligTauxDouane = var1;
   }

   public double getCmdligPrKg() {
      return this.cmdligPrKg;
   }

   public void setCmdligPrKg(double var1) {
      this.cmdligPrKg = var1;
   }

   public double getCmdligPrU() {
      return this.cmdligPrU;
   }

   public void setCmdligPrU(double var1) {
      this.cmdligPrU = var1;
   }

   public double getCmdligFrais() {
      return this.cmdligFrais;
   }

   public void setCmdligFrais(double var1) {
      this.cmdligFrais = var1;
   }

   public double getCmdligFinancier() {
      return this.cmdligFinancier;
   }

   public void setCmdligFinancier(double var1) {
      this.cmdligFinancier = var1;
   }

   public double getCmdligPrUTtc() {
      return this.cmdligPrUTtc;
   }

   public void setCmdligPrUTtc(double var1) {
      this.cmdligPrUTtc = var1;
   }

   public String getCmdligComplement() {
      return this.cmdligComplement;
   }

   public void setCmdligComplement(String var1) {
      this.cmdligComplement = var1;
   }

   public String getCmdligLibelleFournisseur() {
      return this.cmdligLibelleFournisseur;
   }

   public void setCmdligLibelleFournisseur(String var1) {
      this.cmdligLibelleFournisseur = var1;
   }

   public int getCmdligOrdre() {
      return this.cmdligOrdre;
   }

   public void setCmdligOrdre(int var1) {
      this.cmdligOrdre = var1;
   }

   public double getCmdligT46() {
      return this.cmdligT46;
   }

   public void setCmdligT46(double var1) {
      this.cmdligT46 = var1;
   }

   public double getCmdligT53() {
      return this.cmdligT53;
   }

   public void setCmdligT53(double var1) {
      this.cmdligT53 = var1;
   }

   public String getCmdligBudgetPoste() {
      return this.cmdligBudgetPoste;
   }

   public void setCmdligBudgetPoste(String var1) {
      this.cmdligBudgetPoste = var1;
   }

   public float getCmdligQteCmd() {
      return this.cmdligQteCmd;
   }

   public void setCmdligQteCmd(float var1) {
      this.cmdligQteCmd = var1;
   }

   public float getCmdligQteLivree() {
      return this.cmdligQteLivree;
   }

   public void setCmdligQteLivree(float var1) {
      this.cmdligQteLivree = var1;
   }
}
