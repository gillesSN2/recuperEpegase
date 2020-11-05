package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RetourLigneVentes implements Serializable {
   private long brtligId;
   private int brtligOrdre;
   private long brtligIdBlv;
   private String brtligCode;
   private String brtligFamille;
   private String brtligLibelle;
   private String brtligComplement;
   private String brtligReference;
   private String brtligTaxe;
   private float brtligTauxTaxe;
   private String brtligUnite;
   private String brtligCondition;
   private String brtligDescription;
   private String brtligDepot;
   private int brtligEchelle;
   private float brtligQte;
   private float brtligLong;
   private float brtligLarg;
   private float brtligHaut;
   private float brtligDiam;
   private float brtligNb;
   private float brtligPoidsNet;
   private float brtligPoidsBrut;
   private float brtligVolume;
   private float brtligQteUtil;
   private int brtligStock;
   private float brtligQteStock;
   private String brtligLot;
   private String brtligNumSerie;
   private String brtligDevise;
   private double brtligPu;
   private double brtligPuTtc;
   private float brtligTauxRemise;
   private double brtligRabais;
   private double brtligPuRem;
   private double brtligPuRemTtc;
   private double brtligPt;
   private double brtligTva;
   private double brtligTc;
   private double brtligTtc;
   private double brtligPump;
   private String brtligGroupe;
   private int brtligModeGroupe;
   private RetourEnteteVentes retourEnteteVentes;
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

   public String getVar_lib_des_condit() {
      return this.var_lib_des_condit;
   }

   public void setVar_lib_des_condit(String var1) {
      this.var_lib_des_condit = var1;
   }

   public String getStyleLigne() {
      if (this.brtligGroupe != null && !this.brtligGroupe.isEmpty()) {
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
      if (this.brtligCondition != null && !this.brtligCondition.isEmpty() && this.brtligCondition.contains(":")) {
         if (this.brtligDescription != null && !this.brtligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.brtligDescription;
         } else if (this.brtligCondition.contains("/")) {
            String[] var1 = this.brtligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.brtligCondition;
         }
      } else if (this.brtligCondition != null && !this.brtligCondition.isEmpty() && !this.brtligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.brtligCondition));
      } else if (this.brtligUnite != null && !this.brtligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.brtligUnite;
      } else {
         this.var_lib_uni_condit = "";
      }

      return this.var_lib_uni_condit;
   }

   public void setVar_lib_uni_condit(String var1) {
      this.var_lib_uni_condit = var1;
   }

   public Unite getUnite() {
      return this.unite;
   }

   public void setUnite(Unite var1) {
      this.unite = var1;
   }

   public boolean isVar_choix_qte() {
      if (this.brtligCondition != null && !this.brtligCondition.isEmpty() && !this.brtligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public RetourEnteteVentes getRetourEnteteVentes() {
      return this.retourEnteteVentes;
   }

   public void setRetourEnteteVentes(RetourEnteteVentes var1) {
      this.retourEnteteVentes = var1;
   }

   public String getBrtligCode() {
      return this.brtligCode;
   }

   public void setBrtligCode(String var1) {
      this.brtligCode = var1;
   }

   public String getBrtligDepot() {
      return this.brtligDepot;
   }

   public void setBrtligDepot(String var1) {
      this.brtligDepot = var1;
   }

   public String getBrtligDevise() {
      return this.brtligDevise;
   }

   public void setBrtligDevise(String var1) {
      this.brtligDevise = var1;
   }

   public String getBrtligFamille() {
      return this.brtligFamille;
   }

   public void setBrtligFamille(String var1) {
      this.brtligFamille = var1;
   }

   public long getBrtligId() {
      return this.brtligId;
   }

   public void setBrtligId(long var1) {
      this.brtligId = var1;
   }

   public String getBrtligLibelle() {
      return this.brtligLibelle;
   }

   public void setBrtligLibelle(String var1) {
      this.brtligLibelle = var1;
   }

   public String getBrtligLot() {
      return this.brtligLot;
   }

   public void setBrtligLot(String var1) {
      this.brtligLot = var1;
   }

   public String getBrtligNumSerie() {
      return this.brtligNumSerie;
   }

   public void setBrtligNumSerie(String var1) {
      this.brtligNumSerie = var1;
   }

   public double getBrtligPt() {
      return this.brtligPt;
   }

   public void setBrtligPt(double var1) {
      this.brtligPt = var1;
   }

   public double getBrtligPu() {
      return this.brtligPu;
   }

   public void setBrtligPu(double var1) {
      this.brtligPu = var1;
   }

   public double getBrtligPuRem() {
      return this.brtligPuRem;
   }

   public void setBrtligPuRem(double var1) {
      this.brtligPuRem = var1;
   }

   public float getBrtligQte() {
      return this.brtligQte;
   }

   public void setBrtligQte(float var1) {
      this.brtligQte = var1;
   }

   public float getBrtligQteStock() {
      return this.brtligQteStock;
   }

   public void setBrtligQteStock(float var1) {
      this.brtligQteStock = var1;
   }

   public double getBrtligRabais() {
      return this.brtligRabais;
   }

   public void setBrtligRabais(double var1) {
      this.brtligRabais = var1;
   }

   public String getBrtligReference() {
      return this.brtligReference;
   }

   public void setBrtligReference(String var1) {
      this.brtligReference = var1;
   }

   public float getBrtligTauxRemise() {
      return this.brtligTauxRemise;
   }

   public void setBrtligTauxRemise(float var1) {
      this.brtligTauxRemise = var1;
   }

   public float getBrtligTauxTaxe() {
      return this.brtligTauxTaxe;
   }

   public void setBrtligTauxTaxe(float var1) {
      this.brtligTauxTaxe = var1;
   }

   public String getBrtligTaxe() {
      return this.brtligTaxe;
   }

   public void setBrtligTaxe(String var1) {
      this.brtligTaxe = var1;
   }

   public double getBrtligTc() {
      return this.brtligTc;
   }

   public void setBrtligTc(double var1) {
      this.brtligTc = var1;
   }

   public double getBrtligTtc() {
      return this.brtligTtc;
   }

   public void setBrtligTtc(double var1) {
      this.brtligTtc = var1;
   }

   public double getBrtligTva() {
      return this.brtligTva;
   }

   public void setBrtligTva(double var1) {
      this.brtligTva = var1;
   }

   public String getBrtligUnite() {
      return this.brtligUnite;
   }

   public void setBrtligUnite(String var1) {
      this.brtligUnite = var1;
   }

   public double getBrtligPump() {
      return this.brtligPump;
   }

   public void setBrtligPump(double var1) {
      this.brtligPump = var1;
   }

   public long getBrtligIdBlv() {
      return this.brtligIdBlv;
   }

   public void setBrtligIdBlv(long var1) {
      this.brtligIdBlv = var1;
   }

   public double getBrtligPuRemTtc() {
      return this.brtligPuRemTtc;
   }

   public void setBrtligPuRemTtc(double var1) {
      this.brtligPuRemTtc = var1;
   }

   public double getBrtligPuTtc() {
      return this.brtligPuTtc;
   }

   public void setBrtligPuTtc(double var1) {
      this.brtligPuTtc = var1;
   }

   public String getBrtligCondition() {
      return this.brtligCondition;
   }

   public void setBrtligCondition(String var1) {
      this.brtligCondition = var1;
   }

   public float getBrtligDiam() {
      return this.brtligDiam;
   }

   public void setBrtligDiam(float var1) {
      this.brtligDiam = var1;
   }

   public float getBrtligHaut() {
      return this.brtligHaut;
   }

   public void setBrtligHaut(float var1) {
      this.brtligHaut = var1;
   }

   public float getBrtligLarg() {
      return this.brtligLarg;
   }

   public void setBrtligLarg(float var1) {
      this.brtligLarg = var1;
   }

   public float getBrtligLong() {
      return this.brtligLong;
   }

   public void setBrtligLong(float var1) {
      this.brtligLong = var1;
   }

   public float getBrtligNb() {
      return this.brtligNb;
   }

   public void setBrtligNb(float var1) {
      this.brtligNb = var1;
   }

   public float getBrtligQteUtil() {
      return this.brtligQteUtil;
   }

   public void setBrtligQteUtil(float var1) {
      this.brtligQteUtil = var1;
   }

   public float getBrtligPoidsBrut() {
      return this.brtligPoidsBrut;
   }

   public void setBrtligPoidsBrut(float var1) {
      this.brtligPoidsBrut = var1;
   }

   public float getBrtligPoidsNet() {
      return this.brtligPoidsNet;
   }

   public void setBrtligPoidsNet(float var1) {
      this.brtligPoidsNet = var1;
   }

   public float getBrtligVolume() {
      return this.brtligVolume;
   }

   public void setBrtligVolume(float var1) {
      this.brtligVolume = var1;
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

   public int getBrtligStock() {
      return this.brtligStock;
   }

   public void setBrtligStock(int var1) {
      this.brtligStock = var1;
   }

   public int getBrtligEchelle() {
      return this.brtligEchelle;
   }

   public void setBrtligEchelle(int var1) {
      this.brtligEchelle = var1;
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

   public float getVar_qteDejaLiv() {
      return this.var_qteDejaLiv;
   }

   public void setVar_qteDejaLiv(float var1) {
      this.var_qteDejaLiv = var1;
   }

   public String getBrtligDescription() {
      return this.brtligDescription;
   }

   public void setBrtligDescription(String var1) {
      this.brtligDescription = var1;
   }

   public String getNumSerie() {
      return this.numSerie;
   }

   public void setNumSerie(String var1) {
      this.numSerie = var1;
   }

   public int getBrtligOrdre() {
      return this.brtligOrdre;
   }

   public void setBrtligOrdre(int var1) {
      this.brtligOrdre = var1;
   }

   public String getBrtligComplement() {
      return this.brtligComplement;
   }

   public void setBrtligComplement(String var1) {
      this.brtligComplement = var1;
   }

   public String getBrtligGroupe() {
      return this.brtligGroupe;
   }

   public void setBrtligGroupe(String var1) {
      this.brtligGroupe = var1;
   }

   public int getBrtligModeGroupe() {
      return this.brtligModeGroupe;
   }

   public void setBrtligModeGroupe(int var1) {
      this.brtligModeGroupe = var1;
   }
}
