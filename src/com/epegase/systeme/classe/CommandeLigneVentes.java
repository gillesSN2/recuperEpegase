package com.epegase.systeme.classe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommandeLigneVentes implements Serializable {
   private long bcmligId;
   private int bcmligOrdre;
   private long bcmligIdDvs;
   private String bcmligCode;
   private int bcmligProcess;
   private String bcmligFamille;
   private String bcmligLibelle;
   private String bcmligComplement;
   private String bcmligReference;
   private String bcmligTaxe;
   private float bcmligTauxTaxe;
   private String bcmligUnite;
   private String bcmligCondition;
   private String bcmligDescription;
   private int bcmligEchelle;
   private float bcmligQte;
   private float bcmligLong;
   private float bcmligLarg;
   private float bcmligHaut;
   private float bcmligDiam;
   private float bcmligNb;
   private float bcmligPoidsNet;
   private float bcmligPoidsBrut;
   private float bcmligVolume;
   private String bcmligDepot;
   private int bcmligStock;
   private float bcmligQteUtil;
   private float bcmligQteStock;
   private String bcmligDevise;
   private double bcmligPu;
   private double bcmligPuTtc;
   private float bcmligTauxRemise;
   private double bcmligRabais;
   private double bcmligPuRem;
   private double bcmligPuRemTtc;
   private double bcmligPt;
   private double bcmligTva;
   private double bcmligTc;
   private double bcmligTtc;
   private double bcmligPump;
   private float bcmligQteLivree;
   private String bcmligGroupe;
   private int bcmligModeGroupe;
   private int bcmligEntStock;
   private CommandeEnteteVentes commandeEnteteVentes;
   private List var_listDepotItem = new ArrayList();
   private String var_depotLigne;
   private float var_qteDejaTrf;
   private float var_qteReliquat;
   private String var_lib_uni_condit;
   private String var_lib_des_condit;
   private boolean var_choix_qte;
   private Unite unite = new Unite();
   private float var_qteRestante;
   private String familleStyle;
   private String styleLigne;

   public String getVar_lib_des_condit() {
      return this.var_lib_des_condit;
   }

   public void setVar_lib_des_condit(String var1) {
      this.var_lib_des_condit = var1;
   }

   public String getStyleLigne() {
      if (this.bcmligGroupe != null && !this.bcmligGroupe.isEmpty()) {
         this.styleLigne = "font-style:italic;font-size:7px;";
      } else {
         this.styleLigne = "font-style:normal;";
      }

      return this.styleLigne;
   }

   public void setStyleLigne(String var1) {
      this.styleLigne = var1;
   }

   public String getFamilleStyle() {
      return this.familleStyle;
   }

   public void setFamilleStyle(String var1) {
      this.familleStyle = var1;
   }

   public float getVar_qteRestante() {
      if (this.bcmligId != 0L) {
         this.var_qteRestante = this.bcmligQteUtil - this.bcmligQteLivree;
      } else {
         this.var_qteRestante = 0.0F;
      }

      return this.var_qteRestante;
   }

   public void setVar_qteRestante(float var1) {
      this.var_qteRestante = var1;
   }

   public String getVar_lib_uni_condit() {
      if (this.bcmligCondition != null && !this.bcmligCondition.isEmpty() && this.bcmligCondition.contains(":")) {
         if (this.bcmligDescription != null && !this.bcmligDescription.isEmpty()) {
            this.var_lib_uni_condit = this.bcmligDescription;
         } else if (this.bcmligCondition.contains("/")) {
            String[] var1 = this.bcmligCondition.split("/");
            String var2 = var1[0];
            String[] var3 = var2.split(":");
            this.var_lib_uni_condit = var3[0] + " " + var1[1];
         } else {
            this.var_lib_uni_condit = this.bcmligCondition;
         }
      } else if (this.bcmligCondition != null && !this.bcmligCondition.isEmpty() && !this.bcmligCondition.contains(":")) {
         this.var_lib_uni_condit = this.unite.calculUnite(Integer.parseInt(this.bcmligCondition));
      } else if (this.bcmligUnite != null && !this.bcmligUnite.isEmpty()) {
         this.var_lib_uni_condit = this.bcmligUnite;
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
      if (this.bcmligCondition != null && !this.bcmligCondition.isEmpty() && !this.bcmligCondition.contains(":")) {
         this.var_choix_qte = true;
      } else {
         this.var_choix_qte = false;
      }

      return this.var_choix_qte;
   }

   public void setVar_choix_qte(boolean var1) {
      this.var_choix_qte = var1;
   }

   public String getBcmligCode() {
      return this.bcmligCode;
   }

   public void setBcmligCode(String var1) {
      this.bcmligCode = var1;
   }

   public String getBcmligDevise() {
      return this.bcmligDevise;
   }

   public void setBcmligDevise(String var1) {
      this.bcmligDevise = var1;
   }

   public String getBcmligFamille() {
      return this.bcmligFamille;
   }

   public void setBcmligFamille(String var1) {
      this.bcmligFamille = var1;
   }

   public long getBcmligId() {
      return this.bcmligId;
   }

   public void setBcmligId(long var1) {
      this.bcmligId = var1;
   }

   public String getBcmligLibelle() {
      return this.bcmligLibelle;
   }

   public void setBcmligLibelle(String var1) {
      this.bcmligLibelle = var1;
   }

   public double getBcmligPt() {
      return this.bcmligPt;
   }

   public void setBcmligPt(double var1) {
      this.bcmligPt = var1;
   }

   public double getBcmligPu() {
      return this.bcmligPu;
   }

   public void setBcmligPu(double var1) {
      this.bcmligPu = var1;
   }

   public double getBcmligPuRem() {
      return this.bcmligPuRem;
   }

   public void setBcmligPuRem(double var1) {
      this.bcmligPuRem = var1;
   }

   public float getBcmligQte() {
      return this.bcmligQte;
   }

   public void setBcmligQte(float var1) {
      this.bcmligQte = var1;
   }

   public float getBcmligQteStock() {
      return this.bcmligQteStock;
   }

   public void setBcmligQteStock(float var1) {
      this.bcmligQteStock = var1;
   }

   public double getBcmligRabais() {
      return this.bcmligRabais;
   }

   public void setBcmligRabais(double var1) {
      this.bcmligRabais = var1;
   }

   public String getBcmligReference() {
      return this.bcmligReference;
   }

   public void setBcmligReference(String var1) {
      this.bcmligReference = var1;
   }

   public float getBcmligTauxRemise() {
      return this.bcmligTauxRemise;
   }

   public void setBcmligTauxRemise(float var1) {
      this.bcmligTauxRemise = var1;
   }

   public float getBcmligTauxTaxe() {
      return this.bcmligTauxTaxe;
   }

   public void setBcmligTauxTaxe(float var1) {
      this.bcmligTauxTaxe = var1;
   }

   public String getBcmligTaxe() {
      return this.bcmligTaxe;
   }

   public void setBcmligTaxe(String var1) {
      this.bcmligTaxe = var1;
   }

   public double getBcmligTc() {
      return this.bcmligTc;
   }

   public void setBcmligTc(double var1) {
      this.bcmligTc = var1;
   }

   public double getBcmligTtc() {
      return this.bcmligTtc;
   }

   public void setBcmligTtc(double var1) {
      this.bcmligTtc = var1;
   }

   public double getBcmligTva() {
      return this.bcmligTva;
   }

   public void setBcmligTva(double var1) {
      this.bcmligTva = var1;
   }

   public String getBcmligUnite() {
      return this.bcmligUnite;
   }

   public void setBcmligUnite(String var1) {
      this.bcmligUnite = var1;
   }

   public CommandeEnteteVentes getCommandeEnteteVentes() {
      return this.commandeEnteteVentes;
   }

   public void setCommandeEnteteVentes(CommandeEnteteVentes var1) {
      this.commandeEnteteVentes = var1;
   }

   public long getBcmligIdDvs() {
      return this.bcmligIdDvs;
   }

   public void setBcmligIdDvs(long var1) {
      this.bcmligIdDvs = var1;
   }

   public double getBcmligPump() {
      return this.bcmligPump;
   }

   public void setBcmligPump(double var1) {
      this.bcmligPump = var1;
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

   public double getBcmligPuTtc() {
      return this.bcmligPuTtc;
   }

   public void setBcmligPuTtc(double var1) {
      this.bcmligPuTtc = var1;
   }

   public double getBcmligPuRemTtc() {
      return this.bcmligPuRemTtc;
   }

   public void setBcmligPuRemTtc(double var1) {
      this.bcmligPuRemTtc = var1;
   }

   public String getBcmligCondition() {
      return this.bcmligCondition;
   }

   public void setBcmligCondition(String var1) {
      this.bcmligCondition = var1;
   }

   public float getBcmligDiam() {
      return this.bcmligDiam;
   }

   public void setBcmligDiam(float var1) {
      this.bcmligDiam = var1;
   }

   public float getBcmligHaut() {
      return this.bcmligHaut;
   }

   public void setBcmligHaut(float var1) {
      this.bcmligHaut = var1;
   }

   public float getBcmligLarg() {
      return this.bcmligLarg;
   }

   public void setBcmligLarg(float var1) {
      this.bcmligLarg = var1;
   }

   public float getBcmligLong() {
      return this.bcmligLong;
   }

   public void setBcmligLong(float var1) {
      this.bcmligLong = var1;
   }

   public float getBcmligNb() {
      return this.bcmligNb;
   }

   public void setBcmligNb(float var1) {
      this.bcmligNb = var1;
   }

   public float getBcmligQteUtil() {
      return this.bcmligQteUtil;
   }

   public void setBcmligQteUtil(float var1) {
      this.bcmligQteUtil = var1;
   }

   public float getBcmligPoidsBrut() {
      return this.bcmligPoidsBrut;
   }

   public void setBcmligPoidsBrut(float var1) {
      this.bcmligPoidsBrut = var1;
   }

   public float getBcmligPoidsNet() {
      return this.bcmligPoidsNet;
   }

   public void setBcmligPoidsNet(float var1) {
      this.bcmligPoidsNet = var1;
   }

   public float getBcmligVolume() {
      return this.bcmligVolume;
   }

   public void setBcmligVolume(float var1) {
      this.bcmligVolume = var1;
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

   public String getBcmligDepot() {
      return this.bcmligDepot;
   }

   public void setBcmligDepot(String var1) {
      this.bcmligDepot = var1;
   }

   public int getBcmligStock() {
      return this.bcmligStock;
   }

   public void setBcmligStock(int var1) {
      this.bcmligStock = var1;
   }

   public int getBcmligEchelle() {
      return this.bcmligEchelle;
   }

   public void setBcmligEchelle(int var1) {
      this.bcmligEchelle = var1;
   }

   public String getBcmligDescription() {
      return this.bcmligDescription;
   }

   public void setBcmligDescription(String var1) {
      this.bcmligDescription = var1;
   }

   public int getBcmligOrdre() {
      return this.bcmligOrdre;
   }

   public void setBcmligOrdre(int var1) {
      this.bcmligOrdre = var1;
   }

   public String getBcmligComplement() {
      return this.bcmligComplement;
   }

   public void setBcmligComplement(String var1) {
      this.bcmligComplement = var1;
   }

   public float getBcmligQteLivree() {
      return this.bcmligQteLivree;
   }

   public void setBcmligQteLivree(float var1) {
      this.bcmligQteLivree = var1;
   }

   public String getBcmligGroupe() {
      return this.bcmligGroupe;
   }

   public void setBcmligGroupe(String var1) {
      this.bcmligGroupe = var1;
   }

   public int getBcmligModeGroupe() {
      return this.bcmligModeGroupe;
   }

   public void setBcmligModeGroupe(int var1) {
      this.bcmligModeGroupe = var1;
   }

   public int getBcmligProcess() {
      return this.bcmligProcess;
   }

   public void setBcmligProcess(int var1) {
      this.bcmligProcess = var1;
   }

   public int getBcmligEntStock() {
      return this.bcmligEntStock;
   }

   public void setBcmligEntStock(int var1) {
      this.bcmligEntStock = var1;
   }
}
