package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RetourLigneAchats implements Serializable {
   private long brfligId;
   private long brfligIdDa;
   private long brfligIdCot;
   private long brfligIdCmd;
   private long brfligIdRec;
   private String brfligCode;
   private String brfligFamille;
   private String brfligLibelle;
   private String brfligLibelleFournisseur;
   private String brfligComplement;
   private String brfligReference;
   private String brfligTaxe;
   private float brfligTauxTaxe;
   private String brfligUnite;
   private int brfligStock;
   private String brfligCondition;
   private String brfligDescription;
   private int brfligEchelle;
   private float brfligQte;
   private float brfligLong;
   private float brfligLarg;
   private float brfligHaut;
   private float brfligDiam;
   private float brfligNb;
   private float brfligPoidsNet;
   private float brfligPoidsBrut;
   private float brfligVolume;
   private float brfligQteUtil;
   private String brfligDepot;
   private float brfligQteStock;
   private String brfligDevise;
   private double brfligPu;
   private float brfligTauxRemise;
   private double brfligRabais;
   private double brfligPuRem;
   private double brfligPt;
   private double brfligTva;
   private double brfligTc;
   private double brfligTtc;
   private double brfligPr;
   private double brfligPump;
   private RetourEnteteAchats retourEnteteAchats;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteDejaLiv;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private String var_lib_des_condit;
   private boolean var_choix_qte;
   private Unite unite = new Unite();
   private String numSerie;
   private String styleLigne;

   public String getVar_lib_uni_condit() {
      if (this.brfligCondition != null && !this.brfligCondition.isEmpty() && this.brfligCondition.contains(":")) {
         if (this.brfligDescription != null && !this.brfligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.brfligDescription;
         } else if (this.brfligCondition.contains("/")) {
            String[] var1 = this.brfligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.brfligCondition;
         }
      } else if (this.brfligCondition == null || this.brfligCondition.isEmpty() || this.brfligCondition.contains(":")) {
         if (this.brfligUnite != null && !this.brfligUnite.isEmpty()) {
            this.var_lib_uni_condit = this.brfligUnite;
         } else {
            this.var_lib_uni_condit = "";
         }
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public String getBrfligCode() {
      return this.brfligCode;
   }

   public void setBrfligCode(String var1) {
      this.brfligCode = var1;
   }

   public String getBrfligDepot() {
      return this.brfligDepot;
   }

   public void setBrfligDepot(String var1) {
      this.brfligDepot = var1;
   }

   public String getBrfligDevise() {
      return this.brfligDevise;
   }

   public void setBrfligDevise(String var1) {
      this.brfligDevise = var1;
   }

   public String getBrfligFamille() {
      return this.brfligFamille;
   }

   public void setBrfligFamille(String var1) {
      this.brfligFamille = var1;
   }

   public long getBrfligId() {
      return this.brfligId;
   }

   public void setBrfligId(long var1) {
      this.brfligId = var1;
   }

   public long getBrfligIdCmd() {
      return this.brfligIdCmd;
   }

   public void setBrfligIdCmd(long var1) {
      this.brfligIdCmd = var1;
   }

   public long getBrfligIdCot() {
      return this.brfligIdCot;
   }

   public void setBrfligIdCot(long var1) {
      this.brfligIdCot = var1;
   }

   public long getBrfligIdDa() {
      return this.brfligIdDa;
   }

   public void setBrfligIdDa(long var1) {
      this.brfligIdDa = var1;
   }

   public long getBrfligIdRec() {
      return this.brfligIdRec;
   }

   public void setBrfligIdRec(long var1) {
      this.brfligIdRec = var1;
   }

   public String getBrfligLibelle() {
      return this.brfligLibelle;
   }

   public void setBrfligLibelle(String var1) {
      this.brfligLibelle = var1;
   }

   public double getBrfligPr() {
      return this.brfligPr;
   }

   public void setBrfligPr(double var1) {
      this.brfligPr = var1;
   }

   public double getBrfligPt() {
      return this.brfligPt;
   }

   public void setBrfligPt(double var1) {
      this.brfligPt = var1;
   }

   public double getBrfligPu() {
      return this.brfligPu;
   }

   public void setBrfligPu(double var1) {
      this.brfligPu = var1;
   }

   public double getBrfligPuRem() {
      return this.brfligPuRem;
   }

   public void setBrfligPuRem(double var1) {
      this.brfligPuRem = var1;
   }

   public double getBrfligPump() {
      return this.brfligPump;
   }

   public void setBrfligPump(double var1) {
      this.brfligPump = var1;
   }

   public float getBrfligQte() {
      return this.brfligQte;
   }

   public void setBrfligQte(float var1) {
      this.brfligQte = var1;
   }

   public float getBrfligQteStock() {
      return this.brfligQteStock;
   }

   public void setBrfligQteStock(float var1) {
      this.brfligQteStock = var1;
   }

   public double getBrfligRabais() {
      return this.brfligRabais;
   }

   public void setBrfligRabais(double var1) {
      this.brfligRabais = var1;
   }

   public String getBrfligReference() {
      return this.brfligReference;
   }

   public void setBrfligReference(String var1) {
      this.brfligReference = var1;
   }

   public float getBrfligTauxRemise() {
      return this.brfligTauxRemise;
   }

   public void setBrfligTauxRemise(float var1) {
      this.brfligTauxRemise = var1;
   }

   public float getBrfligTauxTaxe() {
      return this.brfligTauxTaxe;
   }

   public void setBrfligTauxTaxe(float var1) {
      this.brfligTauxTaxe = var1;
   }

   public String getBrfligTaxe() {
      return this.brfligTaxe;
   }

   public void setBrfligTaxe(String var1) {
      this.brfligTaxe = var1;
   }

   public double getBrfligTc() {
      return this.brfligTc;
   }

   public void setBrfligTc(double var1) {
      this.brfligTc = var1;
   }

   public double getBrfligTtc() {
      return this.brfligTtc;
   }

   public void setBrfligTtc(double var1) {
      this.brfligTtc = var1;
   }

   public double getBrfligTva() {
      return this.brfligTva;
   }

   public void setBrfligTva(double var1) {
      this.brfligTva = var1;
   }

   public String getBrfligUnite() {
      return this.brfligUnite;
   }

   public void setBrfligUnite(String var1) {
      this.brfligUnite = var1;
   }

   public RetourEnteteAchats getRetourEnteteAchats() {
      return this.retourEnteteAchats;
   }

   public void setRetourEnteteAchats(RetourEnteteAchats var1) {
      this.retourEnteteAchats = var1;
   }

   public String getBrfligCondition() {
      return this.brfligCondition;
   }

   public void setBrfligCondition(String var1) {
      this.brfligCondition = var1;
   }

   public float getBrfligDiam() {
      return this.brfligDiam;
   }

   public void setBrfligDiam(float var1) {
      this.brfligDiam = var1;
   }

   public float getBrfligHaut() {
      return this.brfligHaut;
   }

   public void setBrfligHaut(float var1) {
      this.brfligHaut = var1;
   }

   public float getBrfligLarg() {
      return this.brfligLarg;
   }

   public void setBrfligLarg(float var1) {
      this.brfligLarg = var1;
   }

   public float getBrfligLong() {
      return this.brfligLong;
   }

   public void setBrfligLong(float var1) {
      this.brfligLong = var1;
   }

   public float getBrfligNb() {
      return this.brfligNb;
   }

   public void setBrfligNb(float var1) {
      this.brfligNb = var1;
   }

   public float getBrfligQteUtil() {
      return this.brfligQteUtil;
   }

   public void setBrfligQteUtil(float var1) {
      this.brfligQteUtil = var1;
   }

   public float getBrfligPoidsBrut() {
      return this.brfligPoidsBrut;
   }

   public void setBrfligPoidsBrut(float var1) {
      this.brfligPoidsBrut = var1;
   }

   public float getBrfligPoidsNet() {
      return this.brfligPoidsNet;
   }

   public void setBrfligPoidsNet(float var1) {
      this.brfligPoidsNet = var1;
   }

   public float getBrfligVolume() {
      return this.brfligVolume;
   }

   public void setBrfligVolume(float var1) {
      this.brfligVolume = var1;
   }

   public int getBrfligStock() {
      return this.brfligStock;
   }

   public void setBrfligStock(int var1) {
      this.brfligStock = var1;
   }

   public int getBrfligEchelle() {
      return this.brfligEchelle;
   }

   public void setBrfligEchelle(int var1) {
      this.brfligEchelle = var1;
   }

   public String getBrfligDescription() {
      return this.brfligDescription;
   }

   public void setBrfligDescription(String var1) {
      this.brfligDescription = var1;
   }

   public String getBrfligComplement() {
      return this.brfligComplement;
   }

   public void setBrfligComplement(String var1) {
      this.brfligComplement = var1;
   }

   public String getBrfligLibelleFournisseur() {
      return this.brfligLibelleFournisseur;
   }

   public void setBrfligLibelleFournisseur(String var1) {
      this.brfligLibelleFournisseur = var1;
   }

   public String getNumSerie() {
      return this.numSerie;
   }

   public void setNumSerie(String var1) {
      this.numSerie = var1;
   }

   public String getStyleLigne() {
      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public boolean isVar_choix_qte() {
      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public String getVar_depotLigne() {
      return this.var_depotLigne;
   }

   public void setVar_depotLigne(String var1) {
      this.var_depotLigne = var1;
   }

   public String getVar_lib_des_condit() {
      return this.var_lib_des_condit;
   }

   public void setVar_lib_des_condit(String var1) {
      this.var_lib_des_condit = var1;
   }

   public List getVar_listDepotItem() {
      return this.var_listDepotItem;
   }

   public void setVar_listDepotItem(List var1) {
      this.var_listDepotItem = var1;
   }

   public float getVar_qteDejaLiv() {
      return this.var_qteDejaLiv;
   }

   public void setVar_qteDejaLiv(float var1) {
      this.var_qteDejaLiv = var1;
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
}
