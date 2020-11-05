package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CotationLigneAchats implements Serializable {
   private long cotligId;
   private String cotligCode;
   private int cotligOrdre;
   private String cotligFamille;
   private String cotligLibelle;
   private String cotligLibelleFournisseur;
   private String cotligComplement;
   private String cotligReference;
   private String cotligPosTarifaire;
   private String cotligTaxe;
   private float cotligTauxTaxe;
   private String cotligUnite;
   private int cotligStock;
   private String cotligCondition;
   private String cotligDescription;
   private int cotligEchelle;
   private String cotligDepot;
   private float cotligQte;
   private float cotligLong;
   private float cotligLarg;
   private float cotligHaut;
   private float cotligDiam;
   private float cotligNb;
   private float cotligPoidsNet;
   private float cotligPoidsBrut;
   private float cotligVolume;
   private float cotligQteUtil;
   private String cotligDevise;
   private double cotligPu;
   private float cotligTauxRemise;
   private double cotligRabais;
   private double cotligPuRem;
   private double cotligPt;
   private double cotligTva;
   private double cotligTc;
   private double cotligTtc;
   private long cotligIdDa;
   private double cotligPr;
   private double cotligPump;
   private double cotligPv;
   private double cotligPvPropose;
   private double cotligCaf;
   private double cotligFinancier;
   private double cotligT1;
   private double cotligT3;
   private double cotligT5;
   private double cotligT10;
   private double cotligT30;
   private double cotligT31;
   private double cotligT46;
   private double cotligT53;
   private double cotligRusid;
   private double cotligFrais;
   private double cotligPrU;
   private CotationEnteteAchats cotationEnteteAchats;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private double autreTaxe;

   public double getAutreTaxe() {
      this.autreTaxe = this.cotligT46 + this.cotligT53;
      return this.autreTaxe;
   }

   public void setAutreTaxe(double var1) {
      this.autreTaxe = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.cotligCondition != null && !this.cotligCondition.isEmpty() && this.cotligCondition.contains(":")) {
         if (this.cotligDescription != null && !this.cotligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.cotligDescription;
         } else if (this.cotligCondition.contains("/")) {
            String[] var1 = this.cotligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.cotligCondition;
         }
      } else if (this.cotligCondition == null || this.cotligCondition.isEmpty() || this.cotligCondition.contains(":")) {
         if (this.cotligUnite != null && !this.cotligUnite.isEmpty()) {
            this.var_lib_uni_condit = this.cotligUnite;
         } else {
            this.var_lib_uni_condit = "";
         }
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public CotationEnteteAchats getCotationEnteteAchats() {
      return this.cotationEnteteAchats;
   }

   public void setCotationEnteteAchats(CotationEnteteAchats var1) {
      this.cotationEnteteAchats = var1;
   }

   public String getCotligCode() {
      return this.cotligCode;
   }

   public void setCotligCode(String var1) {
      this.cotligCode = var1;
   }

   public String getCotligDevise() {
      return this.cotligDevise;
   }

   public void setCotligDevise(String var1) {
      this.cotligDevise = var1;
   }

   public String getCotligFamille() {
      return this.cotligFamille;
   }

   public void setCotligFamille(String var1) {
      this.cotligFamille = var1;
   }

   public long getCotligId() {
      return this.cotligId;
   }

   public void setCotligId(long var1) {
      this.cotligId = var1;
   }

   public String getCotligLibelle() {
      return this.cotligLibelle;
   }

   public void setCotligLibelle(String var1) {
      this.cotligLibelle = var1;
   }

   public double getCotligPt() {
      return this.cotligPt;
   }

   public void setCotligPt(double var1) {
      this.cotligPt = var1;
   }

   public double getCotligPu() {
      return this.cotligPu;
   }

   public void setCotligPu(double var1) {
      this.cotligPu = var1;
   }

   public double getCotligPuRem() {
      return this.cotligPuRem;
   }

   public void setCotligPuRem(double var1) {
      this.cotligPuRem = var1;
   }

   public float getCotligQte() {
      return this.cotligQte;
   }

   public void setCotligQte(float var1) {
      this.cotligQte = var1;
   }

   public double getCotligRabais() {
      return this.cotligRabais;
   }

   public void setCotligRabais(double var1) {
      this.cotligRabais = var1;
   }

   public String getCotligReference() {
      return this.cotligReference;
   }

   public void setCotligReference(String var1) {
      this.cotligReference = var1;
   }

   public float getCotligTauxRemise() {
      return this.cotligTauxRemise;
   }

   public void setCotligTauxRemise(float var1) {
      this.cotligTauxRemise = var1;
   }

   public float getCotligTauxTaxe() {
      return this.cotligTauxTaxe;
   }

   public void setCotligTauxTaxe(float var1) {
      this.cotligTauxTaxe = var1;
   }

   public String getCotligTaxe() {
      return this.cotligTaxe;
   }

   public void setCotligTaxe(String var1) {
      this.cotligTaxe = var1;
   }

   public double getCotligTc() {
      return this.cotligTc;
   }

   public void setCotligTc(double var1) {
      this.cotligTc = var1;
   }

   public double getCotligTtc() {
      return this.cotligTtc;
   }

   public void setCotligTtc(double var1) {
      this.cotligTtc = var1;
   }

   public double getCotligTva() {
      return this.cotligTva;
   }

   public void setCotligTva(double var1) {
      this.cotligTva = var1;
   }

   public String getCotligUnite() {
      return this.cotligUnite;
   }

   public void setCotligUnite(String var1) {
      this.cotligUnite = var1;
   }

   public long getCotligIdDa() {
      return this.cotligIdDa;
   }

   public void setCotligIdDa(long var1) {
      this.cotligIdDa = var1;
   }

   public double getCotligPr() {
      return this.cotligPr;
   }

   public void setCotligPr(double var1) {
      this.cotligPr = var1;
   }

   public double getCotligPump() {
      return this.cotligPump;
   }

   public void setCotligPump(double var1) {
      this.cotligPump = var1;
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

   public String getCotligCondition() {
      return this.cotligCondition;
   }

   public void setCotligCondition(String var1) {
      this.cotligCondition = var1;
   }

   public float getCotligDiam() {
      return this.cotligDiam;
   }

   public void setCotligDiam(float var1) {
      this.cotligDiam = var1;
   }

   public float getCotligHaut() {
      return this.cotligHaut;
   }

   public void setCotligHaut(float var1) {
      this.cotligHaut = var1;
   }

   public float getCotligLarg() {
      return this.cotligLarg;
   }

   public void setCotligLarg(float var1) {
      this.cotligLarg = var1;
   }

   public float getCotligLong() {
      return this.cotligLong;
   }

   public void setCotligLong(float var1) {
      this.cotligLong = var1;
   }

   public float getCotligNb() {
      return this.cotligNb;
   }

   public void setCotligNb(float var1) {
      this.cotligNb = var1;
   }

   public float getCotligQteUtil() {
      return this.cotligQteUtil;
   }

   public void setCotligQteUtil(float var1) {
      this.cotligQteUtil = var1;
   }

   public float getCotligPoidsBrut() {
      return this.cotligPoidsBrut;
   }

   public void setCotligPoidsBrut(float var1) {
      this.cotligPoidsBrut = var1;
   }

   public float getCotligPoidsNet() {
      return this.cotligPoidsNet;
   }

   public void setCotligPoidsNet(float var1) {
      this.cotligPoidsNet = var1;
   }

   public float getCotligVolume() {
      return this.cotligVolume;
   }

   public void setCotligVolume(float var1) {
      this.cotligVolume = var1;
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

   public int getCotligStock() {
      return this.cotligStock;
   }

   public void setCotligStock(int var1) {
      this.cotligStock = var1;
   }

   public int getCotligEchelle() {
      return this.cotligEchelle;
   }

   public void setCotligEchelle(int var1) {
      this.cotligEchelle = var1;
   }

   public String getCotligDescription() {
      return this.cotligDescription;
   }

   public void setCotligDescription(String var1) {
      this.cotligDescription = var1;
   }

   public String getCotligDepot() {
      return this.cotligDepot;
   }

   public void setCotligDepot(String var1) {
      this.cotligDepot = var1;
   }

   public String getCotligComplement() {
      return this.cotligComplement;
   }

   public void setCotligComplement(String var1) {
      this.cotligComplement = var1;
   }

   public String getCotligLibelleFournisseur() {
      return this.cotligLibelleFournisseur;
   }

   public void setCotligLibelleFournisseur(String var1) {
      this.cotligLibelleFournisseur = var1;
   }

   public String getCotligPosTarifaire() {
      return this.cotligPosTarifaire;
   }

   public void setCotligPosTarifaire(String var1) {
      this.cotligPosTarifaire = var1;
   }

   public double getCotligPv() {
      return this.cotligPv;
   }

   public void setCotligPv(double var1) {
      this.cotligPv = var1;
   }

   public double getCotligFinancier() {
      return this.cotligFinancier;
   }

   public void setCotligFinancier(double var1) {
      this.cotligFinancier = var1;
   }

   public double getCotligFrais() {
      return this.cotligFrais;
   }

   public void setCotligFrais(double var1) {
      this.cotligFrais = var1;
   }

   public double getCotligPrU() {
      return this.cotligPrU;
   }

   public void setCotligPrU(double var1) {
      this.cotligPrU = var1;
   }

   public double getCotligT1() {
      return this.cotligT1;
   }

   public void setCotligT1(double var1) {
      this.cotligT1 = var1;
   }

   public double getCotligT10() {
      return this.cotligT10;
   }

   public void setCotligT10(double var1) {
      this.cotligT10 = var1;
   }

   public double getCotligT3() {
      return this.cotligT3;
   }

   public void setCotligT3(double var1) {
      this.cotligT3 = var1;
   }

   public double getCotligT30() {
      return this.cotligT30;
   }

   public void setCotligT30(double var1) {
      this.cotligT30 = var1;
   }

   public double getCotligT31() {
      return this.cotligT31;
   }

   public void setCotligT31(double var1) {
      this.cotligT31 = var1;
   }

   public double getCotligT46() {
      return this.cotligT46;
   }

   public void setCotligT46(double var1) {
      this.cotligT46 = var1;
   }

   public double getCotligT5() {
      return this.cotligT5;
   }

   public void setCotligT5(double var1) {
      this.cotligT5 = var1;
   }

   public double getCotligT53() {
      return this.cotligT53;
   }

   public void setCotligT53(double var1) {
      this.cotligT53 = var1;
   }

   public double getCotligCaf() {
      return this.cotligCaf;
   }

   public void setCotligCaf(double var1) {
      this.cotligCaf = var1;
   }

   public double getCotligRusid() {
      return this.cotligRusid;
   }

   public void setCotligRusid(double var1) {
      this.cotligRusid = var1;
   }

   public double getCotligPvPropose() {
      return this.cotligPvPropose;
   }

   public void setCotligPvPropose(double var1) {
      this.cotligPvPropose = var1;
   }

   public int getCotligOrdre() {
      return this.cotligOrdre;
   }

   public void setCotligOrdre(int var1) {
      this.cotligOrdre = var1;
   }
}
