package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceptionLigneAchats implements Serializable {
   private long recligId;
   private long recligIdDa;
   private long recligIdCot;
   private long recligIdCmd;
   private String recligNumLot;
   private String recligCode;
   private String recligFamille;
   private String recligLibelle;
   private String recligLibelleFournisseur;
   private String recligComplement;
   private String recligReference;
   private String recligTaxe;
   private float recligTauxTaxe;
   private String recligUnite;
   private String recligCondition;
   private String recligDescription;
   private int recligStock;
   private int recligEchelle;
   private float recligQte;
   private float recligLong;
   private float recligLarg;
   private float recligHaut;
   private float recligDiam;
   private float recligNb;
   private float recligPoidsNet;
   private float recligPoidsBrut;
   private float recligVolume;
   private float recligQteUtil;
   private String recligDepot;
   private String recligDepotCmd;
   private float recligQteStock;
   private String recligDevise;
   private double recligPu;
   private float recligTauxRemise;
   private double recligRabais;
   private double recligPuRem;
   private double recligPt;
   private double recligPtDev;
   private double recligTva;
   private double recligTc;
   private double recligTtc;
   private double recligPr;
   private double recligPump;
   private double recligPumpOld;
   private String recligSommier;
   private String recligDouane;
   private float recligTauxDouane;
   private int recligMode;
   private float recligGr;
   private String recligCouleur;
   private double recligFob;
   private double recligFret;
   private double recligAssurance;
   private double recligFinancier;
   private double recligT1;
   private double recligT3;
   private double recligT5;
   private double recligT10;
   private double recligT30;
   private double recligT31;
   private double recligT46;
   private double recligT53;
   private double recligFrais;
   private double recligPrKg;
   private double recligPrU;
   private double recligPrUTtc;
   private float recligCoefPr;
   private ReceptionEnteteAchats receptionEnteteAchats;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private boolean nonModif;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private Unite unite = new Unite();
   private String codeFamille;
   private String format;
   private double pv_ht;
   private double autreTaxe;
   private String numBc;
   private int typeLigne;
   private String type_doc;
   private Date date_cession;
   private String num_cession;
   private float qte_cession;
   private String unite_cession;
   private int stk_cession;
   private float qte_solde;
   private ValorisationEnteteAchats valorisationEnteteAchats;
   private String libelleProsduit;

   public String getLibelleProsduit() {
      if (this.recligLibelleFournisseur != null && !this.recligLibelleFournisseur.isEmpty()) {
         this.libelleProsduit = this.recligLibelleFournisseur;
      } else {
         this.libelleProsduit = this.recligLibelle;
      }

      return this.libelleProsduit;
   }

   public void setLibelleProsduit(String var1) {
      this.libelleProsduit = var1;
   }

   public int getTypeLigne() {
      return this.typeLigne;
   }

   public void setTypeLigne(int var1) {
      this.typeLigne = var1;
   }

   public double getAutreTaxe() {
      this.autreTaxe = this.recligT46 + this.recligT53;
      return this.autreTaxe;
   }

   public void setAutreTaxe(double var1) {
      this.autreTaxe = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.recligCondition != null && !this.recligCondition.isEmpty() && this.recligCondition.contains(":")) {
         if (this.recligDescription != null && !this.recligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.recligDescription;
         } else if (this.recligCondition.contains("/")) {
            String[] var1 = this.recligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.recligCondition;
         }
      } else if (this.recligCondition != null && !this.recligCondition.isEmpty() && !this.recligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.recligCondition));
      } else if (this.recligUnite != null && !this.recligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.recligUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public String getCodeFamille() {
      if (this.recligFamille != null && !this.recligFamille.isEmpty() && this.recligFamille.contains(":")) {
         String[] var1 = this.recligFamille.split(":");
         this.codeFamille = var1[0];
      } else {
         this.codeFamille = this.recligFamille;
      }

      return this.codeFamille;
   }

   public String getFormat() {
      if (this.recligMode == 0) {
         this.format = this.recligHaut + "x" + this.recligLong;
      } else {
         this.format = "" + this.recligLarg;
      }

      return this.format;
   }

   public void setFormat(String var1) {
      this.format = var1;
   }

   public void setCodeFamille(String var1) {
      this.codeFamille = var1;
   }

   public ReceptionEnteteAchats getReceptionEnteteAchats() {
      return this.receptionEnteteAchats;
   }

   public void setReceptionEnteteAchats(ReceptionEnteteAchats var1) {
      this.receptionEnteteAchats = var1;
   }

   public String getRecligCode() {
      return this.recligCode;
   }

   public void setRecligCode(String var1) {
      this.recligCode = var1;
   }

   public String getRecligDepot() {
      return this.recligDepot;
   }

   public void setRecligDepot(String var1) {
      this.recligDepot = var1;
   }

   public String getRecligDevise() {
      return this.recligDevise;
   }

   public void setRecligDevise(String var1) {
      this.recligDevise = var1;
   }

   public String getRecligFamille() {
      return this.recligFamille;
   }

   public void setRecligFamille(String var1) {
      this.recligFamille = var1;
   }

   public long getRecligId() {
      return this.recligId;
   }

   public void setRecligId(long var1) {
      this.recligId = var1;
   }

   public long getRecligIdCmd() {
      return this.recligIdCmd;
   }

   public void setRecligIdCmd(long var1) {
      this.recligIdCmd = var1;
   }

   public String getRecligLibelle() {
      return this.recligLibelle;
   }

   public void setRecligLibelle(String var1) {
      this.recligLibelle = var1;
   }

   public double getRecligPr() {
      return this.recligPr;
   }

   public void setRecligPr(double var1) {
      this.recligPr = var1;
   }

   public double getRecligPt() {
      return this.recligPt;
   }

   public void setRecligPt(double var1) {
      this.recligPt = var1;
   }

   public double getRecligPu() {
      return this.recligPu;
   }

   public void setRecligPu(double var1) {
      this.recligPu = var1;
   }

   public double getRecligPuRem() {
      return this.recligPuRem;
   }

   public void setRecligPuRem(double var1) {
      this.recligPuRem = var1;
   }

   public double getRecligPump() {
      return this.recligPump;
   }

   public void setRecligPump(double var1) {
      this.recligPump = var1;
   }

   public float getRecligQte() {
      return this.recligQte;
   }

   public void setRecligQte(float var1) {
      this.recligQte = var1;
   }

   public float getRecligQteStock() {
      return this.recligQteStock;
   }

   public void setRecligQteStock(float var1) {
      this.recligQteStock = var1;
   }

   public double getRecligRabais() {
      return this.recligRabais;
   }

   public void setRecligRabais(double var1) {
      this.recligRabais = var1;
   }

   public String getRecligReference() {
      return this.recligReference;
   }

   public void setRecligReference(String var1) {
      this.recligReference = var1;
   }

   public float getRecligTauxRemise() {
      return this.recligTauxRemise;
   }

   public void setRecligTauxRemise(float var1) {
      this.recligTauxRemise = var1;
   }

   public float getRecligTauxTaxe() {
      return this.recligTauxTaxe;
   }

   public void setRecligTauxTaxe(float var1) {
      this.recligTauxTaxe = var1;
   }

   public String getRecligTaxe() {
      return this.recligTaxe;
   }

   public void setRecligTaxe(String var1) {
      this.recligTaxe = var1;
   }

   public double getRecligTc() {
      return this.recligTc;
   }

   public void setRecligTc(double var1) {
      this.recligTc = var1;
   }

   public double getRecligTtc() {
      return this.recligTtc;
   }

   public void setRecligTtc(double var1) {
      this.recligTtc = var1;
   }

   public double getRecligTva() {
      return this.recligTva;
   }

   public void setRecligTva(double var1) {
      this.recligTva = var1;
   }

   public String getRecligUnite() {
      return this.recligUnite;
   }

   public void setRecligUnite(String var1) {
      this.recligUnite = var1;
   }

   public boolean isNonModif() {
      if (this.recligId == 0L) {
         this.nonModif = false;
      } else {
         this.nonModif = true;
      }

      return this.nonModif;
   }

   public void setNonModif(boolean var1) {
      this.nonModif = var1;
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

   public long getRecligIdCot() {
      return this.recligIdCot;
   }

   public void setRecligIdCot(long var1) {
      this.recligIdCot = var1;
   }

   public long getRecligIdDa() {
      return this.recligIdDa;
   }

   public void setRecligIdDa(long var1) {
      this.recligIdDa = var1;
   }

   public String getRecligCondition() {
      return this.recligCondition;
   }

   public void setRecligCondition(String var1) {
      this.recligCondition = var1;
   }

   public float getRecligDiam() {
      return this.recligDiam;
   }

   public void setRecligDiam(float var1) {
      this.recligDiam = var1;
   }

   public float getRecligHaut() {
      return this.recligHaut;
   }

   public void setRecligHaut(float var1) {
      this.recligHaut = var1;
   }

   public float getRecligLarg() {
      return this.recligLarg;
   }

   public void setRecligLarg(float var1) {
      this.recligLarg = var1;
   }

   public float getRecligLong() {
      return this.recligLong;
   }

   public void setRecligLong(float var1) {
      this.recligLong = var1;
   }

   public float getRecligNb() {
      return this.recligNb;
   }

   public void setRecligNb(float var1) {
      this.recligNb = var1;
   }

   public float getRecligQteUtil() {
      return this.recligQteUtil;
   }

   public void setRecligQteUtil(float var1) {
      this.recligQteUtil = var1;
   }

   public float getRecligPoidsBrut() {
      return this.recligPoidsBrut;
   }

   public void setRecligPoidsBrut(float var1) {
      this.recligPoidsBrut = var1;
   }

   public float getRecligPoidsNet() {
      return this.recligPoidsNet;
   }

   public void setRecligPoidsNet(float var1) {
      this.recligPoidsNet = var1;
   }

   public float getRecligVolume() {
      return this.recligVolume;
   }

   public void setRecligVolume(float var1) {
      this.recligVolume = var1;
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

   public String getRecligDepotCmd() {
      return this.recligDepotCmd;
   }

   public void setRecligDepotCmd(String var1) {
      this.recligDepotCmd = var1;
   }

   public int getRecligStock() {
      return this.recligStock;
   }

   public void setRecligStock(int var1) {
      this.recligStock = var1;
   }

   public int getRecligEchelle() {
      return this.recligEchelle;
   }

   public void setRecligEchelle(int var1) {
      this.recligEchelle = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public String getRecligDescription() {
      return this.recligDescription;
   }

   public void setRecligDescription(String var1) {
      this.recligDescription = var1;
   }

   public String getRecligDouane() {
      return this.recligDouane;
   }

   public void setRecligDouane(String var1) {
      this.recligDouane = var1;
   }

   public float getRecligTauxDouane() {
      return this.recligTauxDouane;
   }

   public void setRecligTauxDouane(float var1) {
      this.recligTauxDouane = var1;
   }

   public String getRecligCouleur() {
      return this.recligCouleur;
   }

   public void setRecligCouleur(String var1) {
      this.recligCouleur = var1;
   }

   public float getRecligGr() {
      return this.recligGr;
   }

   public void setRecligGr(float var1) {
      this.recligGr = var1;
   }

   public int getRecligMode() {
      return this.recligMode;
   }

   public void setRecligMode(int var1) {
      this.recligMode = var1;
   }

   public double getRecligPtDev() {
      return this.recligPtDev;
   }

   public void setRecligPtDev(double var1) {
      this.recligPtDev = var1;
   }

   public double getRecligAssurance() {
      return this.recligAssurance;
   }

   public void setRecligAssurance(double var1) {
      this.recligAssurance = var1;
   }

   public double getRecligFob() {
      return this.recligFob;
   }

   public void setRecligFob(double var1) {
      this.recligFob = var1;
   }

   public double getRecligFret() {
      return this.recligFret;
   }

   public void setRecligFret(double var1) {
      this.recligFret = var1;
   }

   public double getRecligT1() {
      return this.recligT1;
   }

   public void setRecligT1(double var1) {
      this.recligT1 = var1;
   }

   public double getRecligT10() {
      return this.recligT10;
   }

   public void setRecligT10(double var1) {
      this.recligT10 = var1;
   }

   public double getRecligT3() {
      return this.recligT3;
   }

   public void setRecligT3(double var1) {
      this.recligT3 = var1;
   }

   public double getRecligT30() {
      return this.recligT30;
   }

   public void setRecligT30(double var1) {
      this.recligT30 = var1;
   }

   public double getRecligT31() {
      return this.recligT31;
   }

   public void setRecligT31(double var1) {
      this.recligT31 = var1;
   }

   public double getRecligT5() {
      return this.recligT5;
   }

   public void setRecligT5(double var1) {
      this.recligT5 = var1;
   }

   public double getRecligPrKg() {
      return this.recligPrKg;
   }

   public void setRecligPrKg(double var1) {
      this.recligPrKg = var1;
   }

   public double getRecligPrU() {
      return this.recligPrU;
   }

   public void setRecligPrU(double var1) {
      this.recligPrU = var1;
   }

   public double getRecligFrais() {
      return this.recligFrais;
   }

   public void setRecligFrais(double var1) {
      this.recligFrais = var1;
   }

   public String getRecligSommier() {
      return this.recligSommier;
   }

   public void setRecligSommier(String var1) {
      this.recligSommier = var1;
   }

   public float getRecligCoefPr() {
      return this.recligCoefPr;
   }

   public void setRecligCoefPr(float var1) {
      this.recligCoefPr = var1;
   }

   public double getRecligFinancier() {
      return this.recligFinancier;
   }

   public void setRecligFinancier(double var1) {
      this.recligFinancier = var1;
   }

   public double getPv_ht() {
      return this.pv_ht;
   }

   public void setPv_ht(double var1) {
      this.pv_ht = var1;
   }

   public String getNum_cession() {
      return this.num_cession;
   }

   public void setNum_cession(String var1) {
      this.num_cession = var1;
   }

   public float getQte_cession() {
      return this.qte_cession;
   }

   public void setQte_cession(float var1) {
      this.qte_cession = var1;
   }

   public String getUnite_cession() {
      return this.unite_cession;
   }

   public void setUnite_cession(String var1) {
      this.unite_cession = var1;
   }

   public int getStk_cession() {
      return this.stk_cession;
   }

   public void setStk_cession(int var1) {
      this.stk_cession = var1;
   }

   public Date getDate_cession() {
      return this.date_cession;
   }

   public void setDate_cession(Date var1) {
      this.date_cession = var1;
   }

   public String getType_doc() {
      return this.type_doc;
   }

   public void setType_doc(String var1) {
      this.type_doc = var1;
   }

   public float getQte_solde() {
      return this.qte_solde;
   }

   public void setQte_solde(float var1) {
      this.qte_solde = var1;
   }

   public ValorisationEnteteAchats getValorisationEnteteAchats() {
      return this.valorisationEnteteAchats;
   }

   public void setValorisationEnteteAchats(ValorisationEnteteAchats var1) {
      this.valorisationEnteteAchats = var1;
   }

   public double getRecligPrUTtc() {
      return this.recligPrUTtc;
   }

   public void setRecligPrUTtc(double var1) {
      this.recligPrUTtc = var1;
   }

   public String getRecligComplement() {
      return this.recligComplement;
   }

   public void setRecligComplement(String var1) {
      this.recligComplement = var1;
   }

   public String getRecligLibelleFournisseur() {
      return this.recligLibelleFournisseur;
   }

   public void setRecligLibelleFournisseur(String var1) {
      this.recligLibelleFournisseur = var1;
   }

   public double getRecligT46() {
      return this.recligT46;
   }

   public void setRecligT46(double var1) {
      this.recligT46 = var1;
   }

   public double getRecligT53() {
      return this.recligT53;
   }

   public void setRecligT53(double var1) {
      this.recligT53 = var1;
   }

   public double getRecligPumpOld() {
      return this.recligPumpOld;
   }

   public void setRecligPumpOld(double var1) {
      this.recligPumpOld = var1;
   }

   public String getRecligNumLot() {
      return this.recligNumLot;
   }

   public void setRecligNumLot(String var1) {
      this.recligNumLot = var1;
   }

   public String getNumBc() {
      return this.numBc;
   }

   public void setNumBc(String var1) {
      this.numBc = var1;
   }
}
