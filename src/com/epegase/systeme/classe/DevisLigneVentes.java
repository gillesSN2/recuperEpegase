package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DevisLigneVentes implements Serializable {
   private long dvsligId;
   private int dvsligOrdre;
   private String dvsligCode;
   private int dvsligProcess;
   private int dvsligPrintTexte;
   private String dvsligFamille;
   private String dvsligLibelle;
   private String dvsligComplement;
   private String dvsligReference;
   private String dvsligTaxe;
   private float dvsligTauxTaxe;
   private String dvsligUnite;
   private String dvsligCondition;
   private String dvsligDescription;
   private int dvsligEchelle;
   private float dvsligQte;
   private float dvsligLong;
   private float dvsligLarg;
   private float dvsligHaut;
   private float dvsligDiam;
   private float dvsligNb;
   private double dvsligPrixKg;
   private float dvsligPoidsNet;
   private float dvsligPoidsBrut;
   private float dvsligVolume;
   private float dvsligQteUtil;
   private int dvsligStock;
   private String dvsligDepot;
   private String dvsligDevise;
   private double dvsligPu;
   private float dvsligTauxRemise;
   private double dvsligRabais;
   private double dvsligPuRem;
   private double dvsligPuTtc;
   private double dvsligPuRemTtc;
   private double dvsligPt;
   private double dvsligTva;
   private double dvsligTc;
   private double dvsligTtc;
   private double dvsligPump;
   private String dvsligGroupe;
   private int dvsligModeGroupe;
   private int dvsligExcluCalcul;
   private String dvsligPromotion;
   private DevisEnteteVentes devisEnteteVentes;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private String var_lib_des_condit;
   private boolean var_choix_qte;
   private Unite unite = new Unite();
   private String var_tarif;
   private String var_desciptif;
   private String var_photo;
   private int var_photo_taille;
   private String styleLigne;

   public String getVar_tarif() {
      return this.var_tarif;
   }

   public void setVar_tarif(String var1) {
      this.var_tarif = var1;
   }

   public String getVar_lib_des_condit() {
      return this.var_lib_des_condit;
   }

   public void setVar_lib_des_condit(String var1) {
      this.var_lib_des_condit = var1;
   }

   public String getStyleLigne() {
      if (this.dvsligGroupe != null && !this.dvsligGroupe.isEmpty()) {
         this.styleLigne = "font-style:italic;font-size:7px;";
      } else {
         this.styleLigne = "font-style:normal;";
      }

      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public String getVar_desciptif() {
      return this.var_desciptif;
   }

   public void setVar_desciptif(String var1) {
      this.var_desciptif = var1;
   }

   public String getVar_photo() {
      return this.var_photo;
   }

   public void setVar_photo(String var1) {
      this.var_photo = var1;
   }

   public int getVar_photo_taille() {
      return this.var_photo_taille;
   }

   public void setVar_photo_taille(int var1) {
      this.var_photo_taille = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.dvsligCondition != null && !this.dvsligCondition.isEmpty() && this.dvsligCondition.contains(":")) {
         if (this.dvsligDescription != null && !this.dvsligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.dvsligDescription;
         } else if (this.dvsligCondition.contains("/")) {
            String[] var1 = this.dvsligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.dvsligCondition;
         }
      } else if (this.dvsligCondition != null && !this.dvsligCondition.isEmpty() && !this.dvsligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.dvsligCondition));
      } else if (this.dvsligUnite != null && !this.dvsligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.dvsligUnite;
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
      if (this.dvsligCondition != null && !this.dvsligCondition.isEmpty() && !this.dvsligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public DevisEnteteVentes getDevisEnteteVentes() {
      return this.devisEnteteVentes;
   }

   public void setDevisEnteteVentes(DevisEnteteVentes var1) {
      this.devisEnteteVentes = var1;
   }

   public String getDvsligCode() {
      return this.dvsligCode;
   }

   public void setDvsligCode(String var1) {
      this.dvsligCode = var1;
   }

   public String getDvsligDevise() {
      return this.dvsligDevise;
   }

   public void setDvsligDevise(String var1) {
      this.dvsligDevise = var1;
   }

   public String getDvsligFamille() {
      return this.dvsligFamille;
   }

   public void setDvsligFamille(String var1) {
      this.dvsligFamille = var1;
   }

   public long getDvsligId() {
      return this.dvsligId;
   }

   public void setDvsligId(long var1) {
      this.dvsligId = var1;
   }

   public String getDvsligLibelle() {
      return this.dvsligLibelle;
   }

   public void setDvsligLibelle(String var1) {
      this.dvsligLibelle = var1;
   }

   public double getDvsligPt() {
      return this.dvsligPt;
   }

   public void setDvsligPt(double var1) {
      this.dvsligPt = var1;
   }

   public double getDvsligPu() {
      return this.dvsligPu;
   }

   public void setDvsligPu(double var1) {
      this.dvsligPu = var1;
   }

   public double getDvsligPuRem() {
      return this.dvsligPuRem;
   }

   public void setDvsligPuRem(double var1) {
      this.dvsligPuRem = var1;
   }

   public float getDvsligQte() {
      return this.dvsligQte;
   }

   public void setDvsligQte(float var1) {
      this.dvsligQte = var1;
   }

   public double getDvsligRabais() {
      return this.dvsligRabais;
   }

   public void setDvsligRabais(double var1) {
      this.dvsligRabais = var1;
   }

   public String getDvsligReference() {
      return this.dvsligReference;
   }

   public void setDvsligReference(String var1) {
      this.dvsligReference = var1;
   }

   public float getDvsligTauxRemise() {
      return this.dvsligTauxRemise;
   }

   public void setDvsligTauxRemise(float var1) {
      this.dvsligTauxRemise = var1;
   }

   public float getDvsligTauxTaxe() {
      return this.dvsligTauxTaxe;
   }

   public void setDvsligTauxTaxe(float var1) {
      this.dvsligTauxTaxe = var1;
   }

   public String getDvsligTaxe() {
      return this.dvsligTaxe;
   }

   public void setDvsligTaxe(String var1) {
      this.dvsligTaxe = var1;
   }

   public double getDvsligTc() {
      return this.dvsligTc;
   }

   public void setDvsligTc(double var1) {
      this.dvsligTc = var1;
   }

   public double getDvsligTtc() {
      return this.dvsligTtc;
   }

   public void setDvsligTtc(double var1) {
      this.dvsligTtc = var1;
   }

   public double getDvsligTva() {
      return this.dvsligTva;
   }

   public void setDvsligTva(double var1) {
      this.dvsligTva = var1;
   }

   public String getDvsligUnite() {
      return this.dvsligUnite;
   }

   public void setDvsligUnite(String var1) {
      this.dvsligUnite = var1;
   }

   public double getDvsligPump() {
      return this.dvsligPump;
   }

   public void setDvsligPump(double var1) {
      this.dvsligPump = var1;
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

   public double getDvsligPuRemTtc() {
      return this.dvsligPuRemTtc;
   }

   public void setDvsligPuRemTtc(double var1) {
      this.dvsligPuRemTtc = var1;
   }

   public double getDvsligPuTtc() {
      return this.dvsligPuTtc;
   }

   public void setDvsligPuTtc(double var1) {
      this.dvsligPuTtc = var1;
   }

   public String getDvsligCondition() {
      return this.dvsligCondition;
   }

   public void setDvsligCondition(String var1) {
      this.dvsligCondition = var1;
   }

   public float getDvsligDiam() {
      return this.dvsligDiam;
   }

   public void setDvsligDiam(float var1) {
      this.dvsligDiam = var1;
   }

   public float getDvsligHaut() {
      return this.dvsligHaut;
   }

   public void setDvsligHaut(float var1) {
      this.dvsligHaut = var1;
   }

   public float getDvsligLarg() {
      return this.dvsligLarg;
   }

   public void setDvsligLarg(float var1) {
      this.dvsligLarg = var1;
   }

   public float getDvsligLong() {
      return this.dvsligLong;
   }

   public void setDvsligLong(float var1) {
      this.dvsligLong = var1;
   }

   public float getDvsligNb() {
      return this.dvsligNb;
   }

   public void setDvsligNb(float var1) {
      this.dvsligNb = var1;
   }

   public float getDvsligQteUtil() {
      return this.dvsligQteUtil;
   }

   public void setDvsligQteUtil(float var1) {
      this.dvsligQteUtil = var1;
   }

   public float getDvsligPoidsBrut() {
      return this.dvsligPoidsBrut;
   }

   public void setDvsligPoidsBrut(float var1) {
      this.dvsligPoidsBrut = var1;
   }

   public float getDvsligPoidsNet() {
      return this.dvsligPoidsNet;
   }

   public void setDvsligPoidsNet(float var1) {
      this.dvsligPoidsNet = var1;
   }

   public float getDvsligVolume() {
      return this.dvsligVolume;
   }

   public void setDvsligVolume(float var1) {
      this.dvsligVolume = var1;
   }

   public List getVar_listDepotItem() {
      return this.var_listDepotItem;
   }

   public void setVar_listDepotItem(List var1) {
      this.var_listDepotItem = var1;
   }

   public String getVar_depotLigne() {
      return this.var_depotLigne;
   }

   public void setVar_depotLigne(String var1) {
      this.var_depotLigne = var1;
   }

   public String getDvsligDepot() {
      return this.dvsligDepot;
   }

   public void setDvsligDepot(String var1) {
      this.dvsligDepot = var1;
   }

   public int getDvsligStock() {
      return this.dvsligStock;
   }

   public void setDvsligStock(int var1) {
      this.dvsligStock = var1;
   }

   public int getDvsligEchelle() {
      return this.dvsligEchelle;
   }

   public void setDvsligEchelle(int var1) {
      this.dvsligEchelle = var1;
   }

   public String getDvsligDescription() {
      return this.dvsligDescription;
   }

   public void setDvsligDescription(String var1) {
      this.dvsligDescription = var1;
   }

   public String getDvsligComplement() {
      return this.dvsligComplement;
   }

   public void setDvsligComplement(String var1) {
      this.dvsligComplement = var1;
   }

   public int getDvsligOrdre() {
      return this.dvsligOrdre;
   }

   public void setDvsligOrdre(int var1) {
      this.dvsligOrdre = var1;
   }

   public String getDvsligGroupe() {
      return this.dvsligGroupe;
   }

   public void setDvsligGroupe(String var1) {
      this.dvsligGroupe = var1;
   }

   public int getDvsligModeGroupe() {
      return this.dvsligModeGroupe;
   }

   public void setDvsligModeGroupe(int var1) {
      this.dvsligModeGroupe = var1;
   }

   public int getDvsligProcess() {
      return this.dvsligProcess;
   }

   public void setDvsligProcess(int var1) {
      this.dvsligProcess = var1;
   }

   public double getDvsligPrixKg() {
      return this.dvsligPrixKg;
   }

   public void setDvsligPrixKg(double var1) {
      this.dvsligPrixKg = var1;
   }

   public int getDvsligPrintTexte() {
      return this.dvsligPrintTexte;
   }

   public void setDvsligPrintTexte(int var1) {
      this.dvsligPrintTexte = var1;
   }

   public int getDvsligExcluCalcul() {
      return this.dvsligExcluCalcul;
   }

   public void setDvsligExcluCalcul(int var1) {
      this.dvsligExcluCalcul = var1;
   }

   public String getDvsligPromotion() {
      return this.dvsligPromotion;
   }

   public void setDvsligPromotion(String var1) {
      this.dvsligPromotion = var1;
   }
}
